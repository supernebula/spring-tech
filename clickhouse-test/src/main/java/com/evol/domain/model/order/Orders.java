package com.evol.domain.model.order;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    @ApiModelProperty(value = "表时间后缀")
    private String tableName;

    @ApiModelProperty(value = "编号")
    private Integer id;

    @ApiModelProperty(value = "租户ID")
    private Integer tenantId;

    @ApiModelProperty(value = "站点ID")
    private Integer siteId;

    @ApiModelProperty(value = "设备ID")
    private Integer deviceId;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "支付类型：1微信，2支付宝，3余额，4投币，5刷卡，6免费特权,7在线卡")
    private Integer payType;

    @ApiModelProperty(value = "设备编码")
    private String deviceNumber;

    @ApiModelProperty(value = "充电路数")
    private Integer deviceWays;

    @ApiModelProperty(value = "充值或是消费：1充值，2消费,3预约付款")
    private Integer orderType;

    @ApiModelProperty(value = "充电预付金额")
    private Integer chargingPrepaidMoney;

    @ApiModelProperty(value = "预估充电量(分钟、度，根据计费方式保存时间或度数 电量百倍)")
    private Integer chargingEstimateAmount;

    @ApiModelProperty(value = "计费方式0：按时间计费；1按电量；2：按功率计费")
    private Integer deviceBillingType;

    @ApiModelProperty(value = "计费价格")
    private String deviceBillingPrice;

    @ApiModelProperty(value = "实际充电金额")
    private Integer chargingActualMoney;

    @ApiModelProperty(value = "退款金额")
    private Integer refundMoney;

    @ApiModelProperty(value = "退款时间")
    private Date refundTime;

    @ApiModelProperty(value = "实际充电时间（分钟）")
    private Integer chargingActualAmount;

    @ApiModelProperty(value = "充电结束时间")
    private Date endTime;

    @ApiModelProperty(value = "续充父订单ID")
    private Integer parentOrderId;

    @ApiModelProperty(value = "设备类型：1充电桩 2充电柜 3直流汽车充电桩 7交流汽车充电桩 4电吹风 5洗衣机 6手机充电站 8热水器控制器")
    private Integer deviceType;

    @ApiModelProperty(value = "来源机型：1安卓、2IOS")
    private Integer phoneModelType;

    @ApiModelProperty(value = "支付来源：1app、2小程序")
    private Integer paySourceType;

    @ApiModelProperty(value = "充电柜类型订单用于电瓶是否已取出：1未取出，2已取出")
    private Integer deviceTakeOut;

    @ApiModelProperty(value = "是否允许取消充电：0是，1否")
    private Integer isOrderCancel;

    @ApiModelProperty(value = "取消充电退款最长时间（单位分钟）")
    private Integer deviceRefundTime;

    @ApiModelProperty(value = "订单状态：0未支付、1已支付、2已退款")
    private Integer status;

    @ApiModelProperty(value = "在线卡卡号")
    private String onlineCardNumber;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "充电结束标识：1充满自停;2拔掉断电;3功率过大;4保险丝损坏;5:空载断电;6充电器/电池异常;7充电完成")
    private Integer errType;

    @ApiModelProperty(value = "减免金额")
    private Integer reduceMoney;

    @ApiModelProperty(value = "减免类型：1红包，2优惠券")
    private Integer reduceType;

    @ApiModelProperty(value = "减免券id")
    private Integer reduceId;

    @ApiModelProperty(value = "Code 代表该订单为电码充电")
    private String chargeCode;

    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber == null ? null : deviceNumber.trim();
    }

    public Integer getDeviceWays() {
        return deviceWays;
    }

    public void setDeviceWays(Integer deviceWays) {
        this.deviceWays = deviceWays;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getChargingPrepaidMoney() {
        return chargingPrepaidMoney;
    }

    public void setChargingPrepaidMoney(Integer chargingPrepaidMoney) {
        this.chargingPrepaidMoney = chargingPrepaidMoney;
    }

    public Integer getChargingEstimateAmount() {
        return chargingEstimateAmount;
    }

    public void setChargingEstimateAmount(Integer chargingEstimateAmount) {
        this.chargingEstimateAmount = chargingEstimateAmount;
    }

    public Integer getDeviceBillingType() {
        return deviceBillingType;
    }

    public void setDeviceBillingType(Integer deviceBillingType) {
        this.deviceBillingType = deviceBillingType;
    }

    public String getDeviceBillingPrice() {
        return deviceBillingPrice;
    }

    public void setDeviceBillingPrice(String deviceBillingPrice) {
        this.deviceBillingPrice = deviceBillingPrice == null ? null : deviceBillingPrice.trim();
    }

    public Integer getChargingActualMoney() {
        return chargingActualMoney;
    }

    public void setChargingActualMoney(Integer chargingActualMoney) {
        this.chargingActualMoney = chargingActualMoney;
    }

    public Integer getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Integer refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getChargingActualAmount() {
        return chargingActualAmount;
    }

    public void setChargingActualAmount(Integer chargingActualAmount) {
        this.chargingActualAmount = chargingActualAmount;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(Integer parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getPhoneModelType() {
        return phoneModelType;
    }

    public void setPhoneModelType(Integer phoneModelType) {
        this.phoneModelType = phoneModelType;
    }

    public Integer getPaySourceType() {
        return paySourceType;
    }

    public void setPaySourceType(Integer paySourceType) {
        this.paySourceType = paySourceType;
    }

    public Integer getDeviceTakeOut() {
        return deviceTakeOut;
    }

    public void setDeviceTakeOut(Integer deviceTakeOut) {
        this.deviceTakeOut = deviceTakeOut;
    }

    public Integer getIsOrderCancel() {
        return isOrderCancel;
    }

    public void setIsOrderCancel(Integer isOrderCancel) {
        this.isOrderCancel = isOrderCancel;
    }

    public Integer getDeviceRefundTime() {
        return deviceRefundTime;
    }

    public void setDeviceRefundTime(Integer deviceRefundTime) {
        this.deviceRefundTime = deviceRefundTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOnlineCardNumber() {
        return onlineCardNumber;
    }

    public void setOnlineCardNumber(String onlineCardNumber) {
        this.onlineCardNumber = onlineCardNumber == null ? null : onlineCardNumber.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getErrType() {
        return errType;
    }

    public void setErrType(Integer errType) {
        this.errType = errType;
    }

    public Integer getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(Integer reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    public Integer getReduceType() {
        return reduceType;
    }

    public void setReduceType(Integer reduceType) {
        this.reduceType = reduceType;
    }

    public Integer getReduceId() {
        return reduceId;
    }

    public void setReduceId(Integer reduceId) {
        this.reduceId = reduceId;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode == null ? null : chargeCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", siteId=").append(siteId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", userName=").append(userName);
        sb.append(", userId=").append(userId);
        sb.append(", payType=").append(payType);
        sb.append(", deviceNumber=").append(deviceNumber);
        sb.append(", deviceWays=").append(deviceWays);
        sb.append(", orderType=").append(orderType);
        sb.append(", chargingPrepaidMoney=").append(chargingPrepaidMoney);
        sb.append(", chargingEstimateAmount=").append(chargingEstimateAmount);
        sb.append(", deviceBillingType=").append(deviceBillingType);
        sb.append(", deviceBillingPrice=").append(deviceBillingPrice);
        sb.append(", chargingActualMoney=").append(chargingActualMoney);
        sb.append(", refundMoney=").append(refundMoney);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", chargingActualAmount=").append(chargingActualAmount);
        sb.append(", endTime=").append(endTime);
        sb.append(", parentOrderId=").append(parentOrderId);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", phoneModelType=").append(phoneModelType);
        sb.append(", paySourceType=").append(paySourceType);
        sb.append(", deviceTakeOut=").append(deviceTakeOut);
        sb.append(", isOrderCancel=").append(isOrderCancel);
        sb.append(", deviceRefundTime=").append(deviceRefundTime);
        sb.append(", status=").append(status);
        sb.append(", onlineCardNumber=").append(onlineCardNumber);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", errType=").append(errType);
        sb.append(", reduceMoney=").append(reduceMoney);
        sb.append(", reduceType=").append(reduceType);
        sb.append(", reduceId=").append(reduceId);
        sb.append(", chargeCode=").append(chargeCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}