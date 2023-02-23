package com.evol.service.impl;

import com.ddcx.config.LogConfig;
import com.ddcx.contants.enums.AccountTypeEnum;
import com.ddcx.contants.enums.ApiResponseEnum;
import com.ddcx.contants.enums.TurnoverQueryTypeEnum;
import com.ddcx.contants.enums.order.OrderStatusEnum;
import com.ddcx.contants.enums.order.ReduceTypeEnum;
import com.ddcx.date.DateUtils;
import com.ddcx.domain.ApiResponse;
import com.ddcx.domain.PageBase;
import com.ddcx.domain.business.TenantDTO;
import com.ddcx.domain.business.TenantInfoOrderDTO;
import com.ddcx.domain.device.DeviceDTO;
import com.ddcx.domain.device.DeviceQueryDTO;
import com.ddcx.domain.device.DeviceStationDTO;
import com.ddcx.domain.dto.*;
import com.ddcx.domain.model.order.Orders;
import com.ddcx.domain.model.order.Transaction;
import com.ddcx.domain.query.ReqParameter;
import com.ddcx.mapper.clickhouse.history.OrdersHistoryClickMapper;
import com.ddcx.service.clickhouse.history.OrderHistoryClickService;
import com.ddcx.service.invoke.FeignServiceDevice;
import com.ddcx.service.invoke.FeignServiceUser;
import com.ddcx.utils.OrderCommon;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderHistoryClickServiceImpl implements OrderHistoryClickService {

    @Autowired
    DataSource clickDataSource;

    @Autowired
    private OrdersHistoryClickMapper ordersHistoryClickMapper;


    @Autowired
    private LogConfig logConfig;

    @Autowired
    private FeignServiceUser feignServiceUser;
    @Autowired
    private FeignServiceDevice feignServiceDevice;

    @Override
    public Integer insertBatchOrdersHistory(List<Orders> ordersList) throws SQLException {

        if(CollectionUtils.isEmpty(ordersList)){
            return 0;
        }

        int insertedTotal = 0;

        String sql = "INSERT INTO orders_history (id, tenant_id, site_id, device_id, order_no,user_name," +
                "user_id, pay_type, device_number, device_ways, order_type, charging_prepaid_money,charging_estimate_amount, device_billing_type, device_billing_price, charging_actual_money, refund_money, refund_time, charging_actual_amount, end_time, parent_order_id, device_type, phone_model_type, pay_source_type, device_take_out, is_order_cancel, device_refund_time, status,online_card_number, province, city, area, err_type, reduce_money, reduce_type, reduce_id,charge_code, create_time, update_time, remark) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        DataSource source1 = clickDataSource;
        Connection connection = null;
        try{
            connection = clickDataSource.getConnection();
        }catch(Exception ex){
            log.error("从数据源获取clickhouse connection异常", ex);
        }

        if(connection == null){
            return 0;
        }

        try {
            PreparedStatement perStatement = connection.prepareStatement(sql);
            for (Orders order: ordersList) {

                if(order == null){
                    continue;
                }
                perStatement.setInt(1, order.getId());         //id
                perStatement.setInt(2, order.getTenantId());         //tenant_id
                perStatement.setInt(3, order.getSiteId());         //site_id
                perStatement.setInt(4, order.getDeviceId());         //device_id
                perStatement.setString(5, order.getOrderNo());         //order_no
                if(order.getUserName() != null){
                    perStatement.setString(6, order.getUserName());         //user_name
                }else{
                    perStatement.setString(6, "");
                }

                if(order.getUserId() != null){
                    perStatement.setInt(7, order.getUserId());         //user_id
                }else{
                    perStatement.setNull(7, Types.INTEGER);
                }

                perStatement.setInt(8, order.getPayType());         //pay_type
                perStatement.setString(9, order.getDeviceNumber());         //device_number
                perStatement.setInt(10, order.getDeviceWays());         //device_ways
                perStatement.setInt(11, order.getOrderType());         //order_type

                if(order.getChargingPrepaidMoney() != null){
                    perStatement.setInt(12, order.getChargingPrepaidMoney());         //charging_prepaid_money
                }else{
                    perStatement.setNull(12, Types.INTEGER);
                }

                if(order.getChargingEstimateAmount() != null){
                    perStatement.setInt(13, order.getChargingEstimateAmount());         //charging_estimate_amount
                }else{
                    perStatement.setNull(13, Types.INTEGER);
                }

                perStatement.setInt(14, order.getDeviceBillingType());         //device_billing_type

                if(order.getDeviceBillingPrice() != null){
                    perStatement.setString(15,  order.getDeviceBillingPrice());         //device_billing_price
                }else{
                    perStatement.setNull(15, Types.VARCHAR);
                }
//例如"1元=4小时"

                if(order.getChargingActualMoney() != null){
                    perStatement.setInt(16, order.getChargingActualMoney());         //charging_actual_money
                }else{
                    perStatement.setNull(16, Types.VARCHAR);
                }

                perStatement.setInt(17, order.getRefundMoney());         //refund_money

                Time refundTime = order.getRefundTime() == null ? null : new Time(order.getRefundTime().getTime());

                if(refundTime != null){
                    perStatement.setTime(18,refundTime);         //refund_time
                }else{
                    perStatement.setNull(18, Types.DATE);
                }

                if(order.getChargingActualMoney() != null){
                    perStatement.setInt(19,order.getChargingActualAmount());         //charging_actual_amount
                }else{
                    perStatement.setNull(19, Types.INTEGER);
                }

                Time endTime = order.getEndTime() == null ? null : new Time(order.getEndTime().getTime());
                if(endTime != null){
                    perStatement.setTime(20, endTime);         //end_time
                }else{
                    perStatement.setNull(20, Types.DATE);
                }

                perStatement.setInt(21, order.getParentOrderId());         //parent_order_id
                perStatement.setInt(22, order.getDeviceType());         //device_type

                if(order.getPhoneModelType() != null){
                    perStatement.setInt(23, order.getPhoneModelType());         //phone_model_type
                }else{
                    perStatement.setNull(23, Types.INTEGER);
                }

                if(order.getPaySourceType() != null){
                    perStatement.setInt(24, order.getPaySourceType());         //pay_source_type
                }else{
                    perStatement.setNull(24, Types.INTEGER);
                }

                perStatement.setInt(25, order.getDeviceTakeOut());         //device_take_out
                perStatement.setInt(26, order.getIsOrderCancel());         //is_order_cancel
                perStatement.setInt(27, order.getDeviceRefundTime());         //device_refund_time
                perStatement.setInt(28, order.getStatus());         //status

                if(order.getOnlineCardNumber() != null){
                    perStatement.setString(29, order.getOnlineCardNumber());         //online_card_number
                }else{
                    perStatement.setNull(29, Types.VARCHAR);
                }

                if(order.getProvince() != null){
                    perStatement.setString(30, order.getProvince());         //province
                }else{
                    perStatement.setNull(30, Types.VARCHAR);
                }

                if(order.getCity() != null){
                    perStatement.setString(31, order.getCity());         //city
                }else{
                    perStatement.setNull(31, Types.VARCHAR);
                }

                if(order.getArea() != null){
                    perStatement.setString(32,order.getArea());         //area
                }else{
                    perStatement.setNull(32, Types.VARCHAR);
                }

                perStatement.setInt(33, order.getErrType());         //err_type

                if(order.getReduceMoney() != null){
                    perStatement.setInt(34,order.getReduceMoney());         //reduce_money
                }else{
                    perStatement.setNull(34, Types.INTEGER);
                }

                if(order.getReduceType() != null){
                    perStatement.setInt(35,order.getReduceType());         //reduce_type
                }else{
                    perStatement.setNull(35, Types.INTEGER);
                }

                if(order.getReduceType() != null){
                    perStatement.setInt(36, order.getReduceId());         //reduce_id
                }else{
                    perStatement.setNull(36, Types.INTEGER);
                }

                if(order.getReduceType() != null){
                    perStatement.setString(37, order.getChargeCode());         //charge_code
                }else{
                    perStatement.setNull(37, Types.VARCHAR);
                }

                Time createTime = order.getCreateTime() == null ? null : new Time(order.getCreateTime().getTime());
                if(createTime != null){
                    perStatement.setTime(38, createTime);         //create_time
                }else{
                    perStatement.setNull(38, Types.DATE);
                }


                Time updateTime = order.getUpdateTime() == null ? null : new Time(order.getUpdateTime().getTime());
                if(updateTime != null){
                    perStatement.setTime(39, updateTime);         //update_time
                }else{
                    perStatement.setNull(39, Types.DATE);
                }

                if(order.getRemark() != null){
                    perStatement.setString(40, order.getRemark());         //remark
                }else{
                    perStatement.setNull(40, Types.VARCHAR);
                }


                perStatement.addBatch();
                insertedTotal++;
            }

            perStatement.executeBatch();

        }catch (Exception ex){
            log.error("批量插入订单到clickhouse异常", ex);
        }finally {
            connection.close();
        }

        return insertedTotal;
    }

    public Integer insertBatchOrdersHistoryTest(List<Orders> ordersList) throws SQLException {
        DataSource source1 = clickDataSource;
        Connection connection = clickDataSource.getConnection();
        try {
            String sql = "INSERT INTO test (id, name) VALUES (?,?)";
            PreparedStatement perStatement = connection.prepareStatement(sql);
            for (int i =1; i < 3; i++){
                perStatement.setInt(1, i);
                perStatement.setString(2, "name" + i);
                perStatement.addBatch();
            }
            perStatement.executeBatch();

        }catch (Exception ex){
            System.out.println(ex);
        }finally {
            connection.close();
        }


        return 0;
    }

    @Override
    public ApiResponse selectOrderNums(ReqParameter reqParameter) {
        //时间参数校验
        if(StringUtils.isBlank(reqParameter.getStartTime()) ||
                StringUtils.isBlank(reqParameter.getEndTime())){
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
            reqParameter.setEndTime(DateUtils.format(DateUtils.addMonth(-1)));
        }
        if(DateUtils.timeCompare(logConfig.getHistoryDataStart(),reqParameter.getStartTime()) == 1){
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
        }
        if(DateUtils.timeCompare(logConfig.getHistoryDataStart(),reqParameter.getEndTime()) == 1){
            return new ApiResponse();
        }
        if(DateUtils.timeCompare(DateUtils.format(new Date()), reqParameter.getEndTime()) == -1){
            reqParameter.setEndTime(DateUtils.format(new Date()));
        }

        List<Integer> list = new ArrayList<>();
        if(reqParameter.getAccountType().equals(AccountTypeEnum.ACCOUNT_TENANT.getType())){
            //获取租户及设备信息
            ApiResponse<List<TenantInfoOrderDTO>> apiResponse = feignServiceUser.queryTenantListInfo(reqParameter.getTenantId(),
                    reqParameter.getTenantName(), TurnoverQueryTypeEnum.DETAIL.getCode());
            if (apiResponse.getCode() != 0) {
                return apiResponse;
            }
            List<TenantInfoOrderDTO> tenantDTOList = apiResponse.getData();
            //获取返回的所有租户ID
            list = tenantDTOList.stream().map(TenantInfoOrderDTO::getTenantId).collect(Collectors.toList());
        }

        //查询站点名称查询站点id集合
        List<Integer> stationIdList = new ArrayList<>();
        if (StringUtils.isNotEmpty(reqParameter.getStationName())) {
            ApiResponse<List<DeviceStationDTO>> listApiResponse = feignServiceDevice.listStationsBySiteName(reqParameter.getStationName());
            if (listApiResponse.getCode() == 0 && !CollectionUtils.isEmpty(listApiResponse.getData())) {
                List<DeviceStationDTO> deviceStationDTOS = listApiResponse.getData();
                for (DeviceStationDTO deviceStationDTO : deviceStationDTOS) {
                    stationIdList.add(deviceStationDTO.getId());
                }
            } else {
                OrderNumDTO dto = new OrderNumDTO();
                dto.setAllOrderNum(0);
                dto.setCancelOrderNum(0);
                dto.setFinishOrderNum(0);
                dto.setOngoingOrderNum(0);
                return new ApiResponse(dto);
            }
        }

        OrderNumDTO result = ordersHistoryClickMapper.selectOrderNums(list, reqParameter, stationIdList);
        return new ApiResponse(result);
    }

    @Override
    public ApiResponse selectOrderList(ReqParameter reqParameter) {
        if(reqParameter.getPageNo() == null || reqParameter.getPageSize() == null){
            log.info("获取订单列表接口的请求参数不合格");
            return new ApiResponse(ApiResponseEnum.BAD_REQUEST.getCode(),
                    ApiResponseEnum.BAD_REQUEST.getErrorMsg(), Lists.newArrayList());
        }
        //时间参数校验
        if(StringUtils.isBlank(reqParameter.getStartTime()) ||
                StringUtils.isBlank(reqParameter.getEndTime())){
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
            reqParameter.setEndTime(DateUtils.format(DateUtils.addMonth(-1),null)+" 23:59:59");
        }
        if(DateUtils.timeCompare(logConfig.getHistoryDataStart(),reqParameter.getStartTime()) == 1){
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
        }
        if(DateUtils.timeCompare(logConfig.getHistoryDataStart(),reqParameter.getEndTime()) == 1){
            return new ApiResponse();
        }
        if(DateUtils.timeCompare(DateUtils.format(new Date()), reqParameter.getEndTime()) == -1){
            reqParameter.setEndTime(DateUtils.format(new Date(),null)+" 23:59:59");
        }

        List<Integer> list = new ArrayList<>();
        if(reqParameter.getAccountType().equals(AccountTypeEnum.ACCOUNT_TENANT.getType())){
            //获取租户及设备信息
            ApiResponse<List<TenantInfoOrderDTO>> apiResponse = feignServiceUser.queryTenantListInfo(reqParameter.getTenantId(),
                    reqParameter.getTenantName(), TurnoverQueryTypeEnum.DETAIL.getCode());
            if(apiResponse.getCode() != 0){
                return apiResponse;
            }
            List<TenantInfoOrderDTO> tenantDTOList = apiResponse.getData();
            //获取返回的所有租户ID
            list = tenantDTOList.stream().map(TenantInfoOrderDTO::getTenantId).collect(Collectors.toList());
        }

        //处理订单的筛选条件 状态
        Integer status = null;
        if (reqParameter.getType() != null) {
            status = OrderCommon.checkOrderStatus(reqParameter.getType());
        }
        reqParameter.setStatus(status);

        //查询站点名称查询站点id集合
        List<Integer> stationIdList = new ArrayList<>();
        List<DeviceStationDTO> deviceStationDTOS = new ArrayList<>();
        if (StringUtils.isNotEmpty(reqParameter.getStationName())) {
            ApiResponse<List<DeviceStationDTO>> listApiResponse = feignServiceDevice.listStationsBySiteName(reqParameter.getStationName());
            if (listApiResponse.getCode() == 0 && !CollectionUtils.isEmpty(listApiResponse.getData())) {
                deviceStationDTOS = listApiResponse.getData();
                for (DeviceStationDTO deviceStationDTO : deviceStationDTOS) {
                    stationIdList.add(deviceStationDTO.getId());
                }
            } else {
                return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(),
                        ApiResponseEnum.QUERY_RECORD_LIST_EMPTY.getErrorMsg());
            }
        }

        int count = ordersHistoryClickMapper.selectOrderListCount(list, reqParameter, stationIdList);
        if (count == 0) {
            return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(),
                    ApiResponseEnum.QUERY_RECORD_LIST_EMPTY.getErrorMsg());
        }

        reqParameter.setPageNo((reqParameter.getPageNo() - 1) * reqParameter.getPageSize());
        List<OrderListDTO> lists = ordersHistoryClickMapper.selectOrderList(list, reqParameter, stationIdList);
        //查询主订单是否有续充订单
        List<Orders> orders = ordersHistoryClickMapper.selectSonOrderListById(lists.stream().map(OrderListDTO::getId).collect(Collectors.toList()));
        //取出所有的设备编码，做去重处理
        List<DeviceQueryDTO> deviceNumberList = new ArrayList();
        for (OrderListDTO listDTO : lists) {
            List<Orders> sonOrders = orders.stream().filter(e -> e.getParentOrderId().equals(listDTO.getId())).collect(Collectors.toList());
            List<Integer> sonId = new ArrayList<>();
            if (sonOrders.size() > 0) {
                listDTO.setChildOrder(true);
                for (Orders o : sonOrders) {
                    listDTO.setChargingActualMoney(o.getChargingActualMoney() + listDTO.getChargingActualMoney());
                    listDTO.setChargingPrepaidMoney(o.getChargingPrepaidMoney() + listDTO.getChargingPrepaidMoney());
                    listDTO.setRefundMoney(o.getRefundMoney() + listDTO.getRefundMoney());
                }
                sonId.add(listDTO.getId());
                listDTO.setSonId(sonId);
            } else {
                listDTO.setChildOrder(false);
                sonId.add(listDTO.getId());
                listDTO.setSonId(sonId);
            }

            DeviceQueryDTO deviceQueryDTO = new DeviceQueryDTO();
            deviceQueryDTO.setDeviceNumber(listDTO.getDeviceNumber());
            deviceNumberList.add(deviceQueryDTO);
        }
        HashSet h = new HashSet(deviceNumberList);
        deviceNumberList.clear();
        deviceNumberList.addAll(h);

        //调用设备接口获取设备相关数据
        ApiResponse apiResponse1 = feignServiceDevice.selectDeviceDetail(deviceNumberList);
        if (apiResponse1.getCode() != 0) {
            return apiResponse1;
        }
        //循环绑定设备相关信息
        List<DeviceDTO> invokeDeviceDTO = (List<DeviceDTO>) apiResponse1.getData();

        // 查询交易记录中所有订单（包含子订单）退款金额
        List<Integer> allSonIds = new ArrayList<>();
        lists.forEach(e -> allSonIds.addAll(e.getSonId()));
        List<Map<String, Object>> refundMap = ordersHistoryClickMapper.selectSumMoneyByOrderId(allSonIds, OrderStatusEnum.CANCELLED.getCode());

        if (invokeDeviceDTO.size() > 0) {
            for (DeviceDTO i : invokeDeviceDTO) {
                for (OrderListDTO listDTO : lists) {
                    if (i.getDeviceNumber().equals(listDTO.getDeviceNumber())) {
                        listDTO.setSiteId(i.getSiteId().toString());
                        listDTO.setSiteName(i.getName());
                        listDTO.setVersion(i.getVersion());
                        //处理金额字段
                        listDTO.setSumMoney(listDTO.getReduceType().equals(ReduceTypeEnum.PC_COUPON.getCode()) || listDTO.getReduceType().equals(ReduceTypeEnum.COUPON.getCode()) ?
                                listDTO.getChargingPrepaidMoney() + listDTO.getReduceMoney() : listDTO.getChargingPrepaidMoney());
                        //查询交易记录的退款金额
                        Integer money = 0;
                        for (Map<String, Object> e : refundMap) {
                            if (listDTO.getSonId().contains(Integer.parseInt(e.get("order_id").toString()))) {
                                money += Integer.parseInt(e.get("allTransMoney").toString());
                            }
                        }
                        listDTO.setRefundMoney(money);
                        listDTO.setSettlementMoney(listDTO.getReduceType().equals(ReduceTypeEnum.PC_COUPON.getCode()) || listDTO.getReduceType().equals(ReduceTypeEnum.COUPON.getCode())
                                ? listDTO.getSumMoney() - listDTO.getRefundMoney() : listDTO.getChargingActualMoney());
                        continue;
                    }
                }
            }
        }
        return new ApiResponse(PageBase.create(Long.valueOf(count), lists));
    }

    @Override
    public ApiResponse selectOrderDetailById(ReqParameter reqParameter) {
        //判断参数是否正确
        if(Objects.isNull(reqParameter.getOrderId())){
            log.info("获取订单详情数据请求参数不合格");
            return new ApiResponse(ApiResponseEnum.BAD_REQUEST.getCode(),
                    ApiResponseEnum.BAD_REQUEST.getErrorMsg(),Lists.newArrayList());
        }

        //查询订单详情
        reqParameter.setTableName("orders_"+DateUtils.dateToString(DateUtils.parse(reqParameter.getCreateTime()),"yyyyMM"));
        OrderDeatilDTO orders = ordersHistoryClickMapper.selectOrderDetailById(reqParameter);
        if(orders == null){
            log.info("查询订单详情返回数据为空");
            return new ApiResponse();
        }
        //调用设备接口获取设备相关数据
        List<DeviceQueryDTO> deviceNumberList = new ArrayList();
        DeviceQueryDTO deviceQueryDTO = new DeviceQueryDTO();
        deviceQueryDTO.setDeviceWay(orders.getDeviceWays());
        deviceQueryDTO.setDeviceNumber(orders.getDeviceNumber());
        deviceNumberList.add(deviceQueryDTO);

        ApiResponse apiResponse = feignServiceDevice.selectDeviceDetail(deviceNumberList);
        if(apiResponse.getCode() != 0){
            return apiResponse;
        }
        List<DeviceDTO> invokeDeviceDTO = (List<DeviceDTO>) apiResponse.getData();

        if(invokeDeviceDTO.size() > 0){
            orders.setSiteName(invokeDeviceDTO.get(0).getName());
            orders.setInstallAddress(invokeDeviceDTO.get(0).getInstallAddress());
            orders.setDiviceBilling(invokeDeviceDTO.get(0).getDiviceBilling());
            orders.setVersion(invokeDeviceDTO.get(0).getVersion());
            orders.setOwner(invokeDeviceDTO.get(0).getOwner());
        }

        if(orders.getDeviceBillingType() == 0){
            //计算该订单剩余充电时间
            Long time = DateUtils.calLastedTime(orders.getExpectEndTime(), new Date());
            time = time / 60;
            if(time.intValue() < 0){
                orders.setSyTime(0);
            }else {
                orders.setSyTime(time.intValue());
            }
        }

        if(Objects.isNull(orders)){
            return new ApiResponse();
        }
        return new ApiResponse(orders);
    }

    @Override
    public ApiResponse selectTransactionList(ReqParameter reqParameter) {
        //校验参数
        if (reqParameter.getPageNo() == null || reqParameter.getPageSize() == null) {
            return new ApiResponse(ApiResponseEnum.BAD_REQUEST.getCode(),
                    ApiResponseEnum.BAD_REQUEST.getErrorMsg());
        }
        //时间参数校验
        if (StringUtils.isBlank(reqParameter.getStartTime()) ||
                StringUtils.isBlank(reqParameter.getEndTime())) {
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
            reqParameter.setEndTime(DateUtils.format(DateUtils.addMonth(-1)));
        }
        if (DateUtils.timeCompare(logConfig.getHistoryDataStart(), reqParameter.getStartTime()) == 1) {
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
        }
        if (DateUtils.timeCompare(logConfig.getHistoryDataStart(), reqParameter.getEndTime()) == 1) {
            return new ApiResponse();
        }
        if (DateUtils.timeCompare(DateUtils.format(new Date()), reqParameter.getEndTime()) == -1) {
            reqParameter.setEndTime(DateUtils.format(new Date()));
        }

        List<Integer> list = new ArrayList<>();
        List<TenantDTO> tenantDTOList = new ArrayList<>();
        if (reqParameter.getAccountType().equals(AccountTypeEnum.ACCOUNT_STAFF.getType())) {
            if (StringUtils.isNotBlank(reqParameter.getTenantName())) {
                reqParameter.setTenantId(String.valueOf(reqParameter.getAccountType()));
                reqParameter.setAccountType("1");

                ApiResponse<List<TenantDTO>> apiResponse = feignServiceUser.queryAllChildTenants(reqParameter.getTenantId(),
                        reqParameter.getTenantName());
                if (apiResponse.getCode() != 0) {
                    return apiResponse;
                }
                tenantDTOList = apiResponse.getData();
                //获取返回的所有租户ID
                list = tenantDTOList.stream().map(TenantDTO::getTenantId).collect(Collectors.toList());
                if (list.size() == 0) {
                    return new ApiResponse();
                }
            }
        }else if(reqParameter.getAccountType().equals(AccountTypeEnum.ACCOUNT_TENANT.getType())){
            ApiResponse<List<TenantDTO>> apiResponse = feignServiceUser.queryAllChildTenants(reqParameter.getTenantId(),
                    reqParameter.getTenantName());
            if (apiResponse.getCode() != 0) {
                return apiResponse;
            }
            tenantDTOList = apiResponse.getData();
            //获取返回的所有租户ID
            list = tenantDTOList.stream().map(TenantDTO::getTenantId).collect(Collectors.toList());
            if (list.size() == 0) {
                return new ApiResponse();
            }
        }

        reqParameter.setPageNo((reqParameter.getPageNo()-1)*reqParameter.getPageSize());
        reqParameter.setPastTime(DateUtils.format(DateUtils.addMonth(DateUtils.parse(reqParameter.getStartTime()), -1)));
        int count = ordersHistoryClickMapper.selectTransactionListCount(list,reqParameter);
        if (count == 0) {
            return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(),
                    ApiResponseEnum.QUERY_RECORD_LIST_EMPTY.getErrorMsg());
        }
        List<OrderTransactionDTO> orderTransactionDTOS = ordersHistoryClickMapper.selectTransactionList(list,reqParameter);
        //判断查询的数据是否为空
        if(orderTransactionDTOS.size() == 0){
            return new ApiResponse();
        }
        //组装数据
        List<Integer> tenantIds = new ArrayList<>();
        for (OrderTransactionDTO c : orderTransactionDTOS){
            tenantIds.clear();
            tenantIds.add(c.getTenantId());
            ApiResponse<List<TenantDTO>> listApiResponse = feignServiceUser.queryTenantsByIds(tenantIds, null);

            if (listApiResponse.getCode() != 0) {
                continue;
            }
            tenantDTOList = listApiResponse.getData();
            if(tenantDTOList.size() > 0){
                c.setTenantName(tenantDTOList.get(0).getTenantName());
                //组装金额数据
                c.setSumMoney(c.getReduceType().equals(ReduceTypeEnum.PC_COUPON.getCode()) || c.getReduceType().equals(ReduceTypeEnum.COUPON.getCode()) ?
                        c.getChargingPrepaidMoney() + (c.getReduceMoney()) : c.getChargingPrepaidMoney());
            }
        }

        return new ApiResponse(PageBase.create(Long.valueOf(count), orderTransactionDTOS));

    }

    @Override
    public ApiResponse transactionListExport(ReqParameter reqParameter, HttpServletResponse response) {
        //时间参数校验
        if(StringUtils.isBlank(reqParameter.getStartTime()) ||
                StringUtils.isBlank(reqParameter.getEndTime())){
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
            reqParameter.setEndTime(DateUtils.format(DateUtils.addMonth(-1)));
        }
        if (DateUtils.timeCompare(logConfig.getHistoryDataStart(), reqParameter.getStartTime()) == 1) {
            reqParameter.setStartTime(logConfig.getHistoryDataStart());
        }
        if (DateUtils.timeCompare(logConfig.getHistoryDataStart(), reqParameter.getEndTime()) == 1) {
            return new ApiResponse();
        }
        if (DateUtils.timeCompare(DateUtils.format(new Date()), reqParameter.getEndTime()) == -1) {
            reqParameter.setEndTime(DateUtils.format(new Date()));
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("查询商户");
        List<Integer> list = new ArrayList<>();
        List<TenantDTO> tenantDTOList = new ArrayList<>();
        if (reqParameter.getAccountType().equals(AccountTypeEnum.ACCOUNT_STAFF.getType())) {
            if (StringUtils.isNotBlank(reqParameter.getTenantName())) {
                reqParameter.setTenantId(String.valueOf(reqParameter.getAccountType()));
                reqParameter.setAccountType("1");

                ApiResponse<List<TenantDTO>> apiResponse = feignServiceUser.queryAllChildTenants(reqParameter.getTenantId(),
                        reqParameter.getTenantName());
                if (apiResponse.getCode() != 0) {
                    return apiResponse;
                }
                tenantDTOList = apiResponse.getData();
                //获取返回的所有租户ID
                list = tenantDTOList.stream().map(TenantDTO::getTenantId).collect(Collectors.toList());
                if (list.size() == 0) {
                    return new ApiResponse();
                }
            }
        }else if(reqParameter.getAccountType().equals(AccountTypeEnum.ACCOUNT_TENANT.getType())){
            ApiResponse<List<TenantDTO>> apiResponse = feignServiceUser.queryAllChildTenants(reqParameter.getTenantId(),
                    reqParameter.getTenantName());
            if (apiResponse.getCode() != 0) {
                return apiResponse;
            }
            tenantDTOList = apiResponse.getData();
            //获取返回的所有租户ID
            list = tenantDTOList.stream().map(TenantDTO::getTenantId).collect(Collectors.toList());
            if (list.size() == 0) {
                return new ApiResponse();
            }
        }
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName() + "耗时" + stopWatch.getLastTaskTimeMillis() + "ms");

        reqParameter.setPastTime(DateUtils.format(DateUtils.addMonth(DateUtils.parse(reqParameter.getStartTime()), -1)));
        stopWatch.start("查询总数量");
        int count = ordersHistoryClickMapper.selectTransactionListCount(list, reqParameter);
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName() + "耗时" + stopWatch.getLastTaskTimeMillis() + "ms");
        //判断查询的数据是否为空
        if (count == 0) {
            return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(),
                    ApiResponseEnum.QUERY_RECORD_LIST_EMPTY.getErrorMsg());
        } else if (count > logConfig.getMaxExportNum()) {
            return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(),
                    "导出数据量过大，请缩小时间筛选条件！");
        }

        stopWatch.start("查询数据");
        List<OrderTransactionDTO> orderTransactionDTOS = ordersHistoryClickMapper.selectTransactionExportList(list, reqParameter);
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName() + "耗时" + stopWatch.getLastTaskTimeMillis() + "ms");

        //组装数据
        stopWatch.start("查询需要的商户数据");
        ApiResponse<List<TenantDTO>> apiResponse = feignServiceUser.queryAllChildTenants(null == reqParameter.getTenantId() ? 0 : reqParameter.getTenantId(),
                reqParameter.getTenantName());
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName() + "耗时" + stopWatch.getLastTaskTimeMillis() + "ms");
        if (!ApiResponseEnum.SUCCESS.getCode().equals(apiResponse.getCode())) {
            return apiResponse;
        }
        tenantDTOList = apiResponse.getData();
        stopWatch.start("组装数据");
        for (OrderTransactionDTO c : orderTransactionDTOS) {
            for (TenantDTO t : tenantDTOList) {
                if (c.getTenantId().equals(t.getTenantId())) {
                    c.setTenantName(t.getTenantName());
                    c.setTenantOwner(t.getTenantOwner());
                    break;
                }
            }
            c.setChargingActualExportMoney(c.getStatus().equals(2) ? new BigDecimal(c.getChargingActualMoney()).divide(new BigDecimal(100)).multiply(new BigDecimal(-1))
                    : new BigDecimal(c.getChargingActualMoney()).divide(new BigDecimal(100)));
            c.setSumExportMoney(c.getReduceType().equals(ReduceTypeEnum.PC_COUPON.getCode()) || c.getReduceType().equals(ReduceTypeEnum.COUPON.getCode()) ?
                    new BigDecimal(c.getChargingPrepaidMoney() + c.getReduceMoney()).divide(new BigDecimal(100))
                    : new BigDecimal(c.getChargingPrepaidMoney()).divide(new BigDecimal(100)));
            c.setChargingPrepaidExportMoney(new BigDecimal(c.getChargingPrepaidMoney()).divide(new BigDecimal(100)));
            c.setReduceExportMoney(new BigDecimal(c.getReduceMoney()).divide(new BigDecimal(100)));
        }
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName() + "耗时" + stopWatch.getLastTaskTimeMillis() + "ms");

        // 导出交易记录
        stopWatch.start("exportExcel");
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("交易记录（交易金额是兑付给各位商户的金额，算帐时只需要统计交易金额即可）", "交易记录导出"), OrderTransactionDTO.class, orderTransactionDTOS);
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName() + "耗时" + stopWatch.getLastTaskTimeMillis() + "ms");
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment=交易记录导出.xls");
        stopWatch.start("导出");
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("交易记录导出出错", e);
        }
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName() + "耗时" + stopWatch.getLastTaskTimeMillis() + "ms");
        return null;
    }

    @Override
    public Integer insertBatchTransactionHistory(List<Transaction> transactionList) throws SQLException {

        if(CollectionUtils.isEmpty(transactionList)){
            return 0;
        }

        int insertedTotal = 0;

        String sql = "INSERT INTO transaction_history (id, user_id, user_name, tenant_id, device_id, order_id, " +
                "order_no,  " +
                "order_type, pay_type, trans_money, trans_time, money_in_out_type, status, create_time, update_time) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        DataSource source1 = clickDataSource;
        Connection connection = null;
        try{
            connection = clickDataSource.getConnection();
        }catch(Exception ex){
            log.error("从数据源获取clickhouse connection异常", ex);
        }
        if(connection == null){
            return 0;
        }
        try {

            PreparedStatement perStatement = connection.prepareStatement(sql);
            for (Transaction transaction: transactionList) {

                if(transaction == null){
                    continue;
                }
                perStatement.setInt(1, transaction.getId());         //id
                if(transaction.getUserId() != null){
                    perStatement.setInt(2, transaction.getUserId());         //user_id
                }else{
                    perStatement.setNull(2, Types.INTEGER);         //user_id
                }

                perStatement.setString(3, transaction.getUserName());         //user_name
                if(transaction.getTenantId() != null){
                    perStatement.setInt(4, transaction.getTenantId());         //tenant_id
                }else{
                    perStatement.setNull(4, Types.INTEGER);         //tenant_id
                }
                perStatement.setInt(5, transaction.getDeviceId());         //device_id
                perStatement.setInt(6, transaction.getOrderId());         //order_id
                perStatement.setString(7, transaction.getOrderNo());         //order_no
                perStatement.setInt(8, transaction.getOrderType());         //order_type
                perStatement.setInt(9, transaction.getPayType());         //pay_type
                perStatement.setInt(10, transaction.getTransMoney());         //trans_money

                Time transTime = transaction.getTransTime() == null ? null :
                        new Time(transaction.getTransTime().getTime());
                perStatement.setTime(11, transTime);         //trans_time
                perStatement.setInt(12, transaction.getMoneyInOutType());         //money_in_out_type
                perStatement.setInt(13, transaction.getStatus());         //status

                Time createTime = transaction.getCreateTime() == null ? null :
                        new Time(transaction.getCreateTime().getTime());
                perStatement.setTime(14, createTime);         //create_time

                Time updateTime = transaction.getUpdateTime() == null ? null : new Time(transaction.getUpdateTime().getTime());
                perStatement.setTime(15,  updateTime);         //update_time
                perStatement.addBatch();
                insertedTotal++;
            }

            perStatement.executeBatch();

        }catch (Exception ex){
            log.error("批量插入交易到clickhouse异常", ex);
        }finally {
            connection.close();
        }

        return insertedTotal;

    }

    @Override
    public List<DataViewOrderFigureListDTO> dataViewOrderFigureHistoryList() {
        return ordersHistoryClickMapper.dataViewOrderFigureHistoryList();
    }

    @Override
    public Integer dataViewOrderHistoryCount() {
        return ordersHistoryClickMapper.dataViewOrderHistoryCount();
    }
}
