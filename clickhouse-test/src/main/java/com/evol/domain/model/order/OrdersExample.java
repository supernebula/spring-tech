package com.evol.domain.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Integer value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Integer value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Integer value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Integer value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Integer value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Integer> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Integer> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNull() {
            addCriterion("site_id is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("site_id is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(Integer value) {
            addCriterion("site_id =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(Integer value) {
            addCriterion("site_id <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(Integer value) {
            addCriterion("site_id >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("site_id >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(Integer value) {
            addCriterion("site_id <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("site_id <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<Integer> values) {
            addCriterion("site_id in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<Integer> values) {
            addCriterion("site_id not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(Integer value1, Integer value2) {
            addCriterion("site_id between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("site_id not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNull() {
            addCriterion("device_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("device_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("device_number =", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("device_number <>", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("device_number >", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_number >=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("device_number <", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("device_number <=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("device_number like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("device_number not like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIn(List<String> values) {
            addCriterion("device_number in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotIn(List<String> values) {
            addCriterion("device_number not in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("device_number between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("device_number not between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysIsNull() {
            addCriterion("device_ways is null");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysIsNotNull() {
            addCriterion("device_ways is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysEqualTo(Integer value) {
            addCriterion("device_ways =", value, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysNotEqualTo(Integer value) {
            addCriterion("device_ways <>", value, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysGreaterThan(Integer value) {
            addCriterion("device_ways >", value, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_ways >=", value, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysLessThan(Integer value) {
            addCriterion("device_ways <", value, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysLessThanOrEqualTo(Integer value) {
            addCriterion("device_ways <=", value, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysIn(List<Integer> values) {
            addCriterion("device_ways in", values, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysNotIn(List<Integer> values) {
            addCriterion("device_ways not in", values, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysBetween(Integer value1, Integer value2) {
            addCriterion("device_ways between", value1, value2, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andDeviceWaysNotBetween(Integer value1, Integer value2) {
            addCriterion("device_ways not between", value1, value2, "deviceWays");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyIsNull() {
            addCriterion("charging_prepaid_money is null");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyIsNotNull() {
            addCriterion("charging_prepaid_money is not null");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyEqualTo(Integer value) {
            addCriterion("charging_prepaid_money =", value, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyNotEqualTo(Integer value) {
            addCriterion("charging_prepaid_money <>", value, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyGreaterThan(Integer value) {
            addCriterion("charging_prepaid_money >", value, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("charging_prepaid_money >=", value, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyLessThan(Integer value) {
            addCriterion("charging_prepaid_money <", value, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("charging_prepaid_money <=", value, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyIn(List<Integer> values) {
            addCriterion("charging_prepaid_money in", values, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyNotIn(List<Integer> values) {
            addCriterion("charging_prepaid_money not in", values, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyBetween(Integer value1, Integer value2) {
            addCriterion("charging_prepaid_money between", value1, value2, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingPrepaidMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("charging_prepaid_money not between", value1, value2, "chargingPrepaidMoney");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountIsNull() {
            addCriterion("charging_estimate_amount is null");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountIsNotNull() {
            addCriterion("charging_estimate_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountEqualTo(Integer value) {
            addCriterion("charging_estimate_amount =", value, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountNotEqualTo(Integer value) {
            addCriterion("charging_estimate_amount <>", value, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountGreaterThan(Integer value) {
            addCriterion("charging_estimate_amount >", value, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("charging_estimate_amount >=", value, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountLessThan(Integer value) {
            addCriterion("charging_estimate_amount <", value, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountLessThanOrEqualTo(Integer value) {
            addCriterion("charging_estimate_amount <=", value, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountIn(List<Integer> values) {
            addCriterion("charging_estimate_amount in", values, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountNotIn(List<Integer> values) {
            addCriterion("charging_estimate_amount not in", values, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountBetween(Integer value1, Integer value2) {
            addCriterion("charging_estimate_amount between", value1, value2, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andChargingEstimateAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("charging_estimate_amount not between", value1, value2, "chargingEstimateAmount");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeIsNull() {
            addCriterion("device_billing_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeIsNotNull() {
            addCriterion("device_billing_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeEqualTo(Integer value) {
            addCriterion("device_billing_type =", value, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeNotEqualTo(Integer value) {
            addCriterion("device_billing_type <>", value, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeGreaterThan(Integer value) {
            addCriterion("device_billing_type >", value, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_billing_type >=", value, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeLessThan(Integer value) {
            addCriterion("device_billing_type <", value, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeLessThanOrEqualTo(Integer value) {
            addCriterion("device_billing_type <=", value, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeIn(List<Integer> values) {
            addCriterion("device_billing_type in", values, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeNotIn(List<Integer> values) {
            addCriterion("device_billing_type not in", values, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeBetween(Integer value1, Integer value2) {
            addCriterion("device_billing_type between", value1, value2, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("device_billing_type not between", value1, value2, "deviceBillingType");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceIsNull() {
            addCriterion("device_billing_price is null");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceIsNotNull() {
            addCriterion("device_billing_price is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceEqualTo(String value) {
            addCriterion("device_billing_price =", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceNotEqualTo(String value) {
            addCriterion("device_billing_price <>", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceGreaterThan(String value) {
            addCriterion("device_billing_price >", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceGreaterThanOrEqualTo(String value) {
            addCriterion("device_billing_price >=", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceLessThan(String value) {
            addCriterion("device_billing_price <", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceLessThanOrEqualTo(String value) {
            addCriterion("device_billing_price <=", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceLike(String value) {
            addCriterion("device_billing_price like", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceNotLike(String value) {
            addCriterion("device_billing_price not like", value, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceIn(List<String> values) {
            addCriterion("device_billing_price in", values, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceNotIn(List<String> values) {
            addCriterion("device_billing_price not in", values, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceBetween(String value1, String value2) {
            addCriterion("device_billing_price between", value1, value2, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andDeviceBillingPriceNotBetween(String value1, String value2) {
            addCriterion("device_billing_price not between", value1, value2, "deviceBillingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyIsNull() {
            addCriterion("charging_actual_money is null");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyIsNotNull() {
            addCriterion("charging_actual_money is not null");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyEqualTo(Integer value) {
            addCriterion("charging_actual_money =", value, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyNotEqualTo(Integer value) {
            addCriterion("charging_actual_money <>", value, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyGreaterThan(Integer value) {
            addCriterion("charging_actual_money >", value, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("charging_actual_money >=", value, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyLessThan(Integer value) {
            addCriterion("charging_actual_money <", value, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("charging_actual_money <=", value, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyIn(List<Integer> values) {
            addCriterion("charging_actual_money in", values, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyNotIn(List<Integer> values) {
            addCriterion("charging_actual_money not in", values, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyBetween(Integer value1, Integer value2) {
            addCriterion("charging_actual_money between", value1, value2, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andChargingActualMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("charging_actual_money not between", value1, value2, "chargingActualMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyIsNull() {
            addCriterion("refund_money is null");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyIsNotNull() {
            addCriterion("refund_money is not null");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyEqualTo(Integer value) {
            addCriterion("refund_money =", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyNotEqualTo(Integer value) {
            addCriterion("refund_money <>", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyGreaterThan(Integer value) {
            addCriterion("refund_money >", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_money >=", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyLessThan(Integer value) {
            addCriterion("refund_money <", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("refund_money <=", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyIn(List<Integer> values) {
            addCriterion("refund_money in", values, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyNotIn(List<Integer> values) {
            addCriterion("refund_money not in", values, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyBetween(Integer value1, Integer value2) {
            addCriterion("refund_money between", value1, value2, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_money not between", value1, value2, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("refund_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("refund_time =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("refund_time <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("refund_time >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_time >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("refund_time <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_time <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("refund_time in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("refund_time not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("refund_time between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_time not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountIsNull() {
            addCriterion("charging_actual_amount is null");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountIsNotNull() {
            addCriterion("charging_actual_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountEqualTo(Integer value) {
            addCriterion("charging_actual_amount =", value, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountNotEqualTo(Integer value) {
            addCriterion("charging_actual_amount <>", value, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountGreaterThan(Integer value) {
            addCriterion("charging_actual_amount >", value, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("charging_actual_amount >=", value, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountLessThan(Integer value) {
            addCriterion("charging_actual_amount <", value, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountLessThanOrEqualTo(Integer value) {
            addCriterion("charging_actual_amount <=", value, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountIn(List<Integer> values) {
            addCriterion("charging_actual_amount in", values, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountNotIn(List<Integer> values) {
            addCriterion("charging_actual_amount not in", values, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountBetween(Integer value1, Integer value2) {
            addCriterion("charging_actual_amount between", value1, value2, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andChargingActualAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("charging_actual_amount not between", value1, value2, "chargingActualAmount");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNull() {
            addCriterion("parent_order_id is null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNotNull() {
            addCriterion("parent_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdEqualTo(Integer value) {
            addCriterion("parent_order_id =", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotEqualTo(Integer value) {
            addCriterion("parent_order_id <>", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThan(Integer value) {
            addCriterion("parent_order_id >", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_order_id >=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThan(Integer value) {
            addCriterion("parent_order_id <", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_order_id <=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIn(List<Integer> values) {
            addCriterion("parent_order_id in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotIn(List<Integer> values) {
            addCriterion("parent_order_id not in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_order_id between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_order_id not between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(Integer value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(Integer value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(Integer value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(Integer value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<Integer> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<Integer> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(Integer value1, Integer value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeIsNull() {
            addCriterion("phone_model_type is null");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeIsNotNull() {
            addCriterion("phone_model_type is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeEqualTo(Integer value) {
            addCriterion("phone_model_type =", value, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeNotEqualTo(Integer value) {
            addCriterion("phone_model_type <>", value, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeGreaterThan(Integer value) {
            addCriterion("phone_model_type >", value, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_model_type >=", value, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeLessThan(Integer value) {
            addCriterion("phone_model_type <", value, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("phone_model_type <=", value, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeIn(List<Integer> values) {
            addCriterion("phone_model_type in", values, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeNotIn(List<Integer> values) {
            addCriterion("phone_model_type not in", values, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeBetween(Integer value1, Integer value2) {
            addCriterion("phone_model_type between", value1, value2, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPhoneModelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_model_type not between", value1, value2, "phoneModelType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeIsNull() {
            addCriterion("pay_source_type is null");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeIsNotNull() {
            addCriterion("pay_source_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeEqualTo(Integer value) {
            addCriterion("pay_source_type =", value, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeNotEqualTo(Integer value) {
            addCriterion("pay_source_type <>", value, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeGreaterThan(Integer value) {
            addCriterion("pay_source_type >", value, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_source_type >=", value, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeLessThan(Integer value) {
            addCriterion("pay_source_type <", value, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_source_type <=", value, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeIn(List<Integer> values) {
            addCriterion("pay_source_type in", values, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeNotIn(List<Integer> values) {
            addCriterion("pay_source_type not in", values, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_source_type between", value1, value2, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andPaySourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_source_type not between", value1, value2, "paySourceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutIsNull() {
            addCriterion("device_take_out is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutIsNotNull() {
            addCriterion("device_take_out is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutEqualTo(Integer value) {
            addCriterion("device_take_out =", value, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutNotEqualTo(Integer value) {
            addCriterion("device_take_out <>", value, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutGreaterThan(Integer value) {
            addCriterion("device_take_out >", value, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_take_out >=", value, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutLessThan(Integer value) {
            addCriterion("device_take_out <", value, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutLessThanOrEqualTo(Integer value) {
            addCriterion("device_take_out <=", value, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutIn(List<Integer> values) {
            addCriterion("device_take_out in", values, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutNotIn(List<Integer> values) {
            addCriterion("device_take_out not in", values, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutBetween(Integer value1, Integer value2) {
            addCriterion("device_take_out between", value1, value2, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andDeviceTakeOutNotBetween(Integer value1, Integer value2) {
            addCriterion("device_take_out not between", value1, value2, "deviceTakeOut");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelIsNull() {
            addCriterion("is_order_cancel is null");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelIsNotNull() {
            addCriterion("is_order_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelEqualTo(Integer value) {
            addCriterion("is_order_cancel =", value, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelNotEqualTo(Integer value) {
            addCriterion("is_order_cancel <>", value, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelGreaterThan(Integer value) {
            addCriterion("is_order_cancel >", value, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_order_cancel >=", value, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelLessThan(Integer value) {
            addCriterion("is_order_cancel <", value, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelLessThanOrEqualTo(Integer value) {
            addCriterion("is_order_cancel <=", value, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelIn(List<Integer> values) {
            addCriterion("is_order_cancel in", values, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelNotIn(List<Integer> values) {
            addCriterion("is_order_cancel not in", values, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelBetween(Integer value1, Integer value2) {
            addCriterion("is_order_cancel between", value1, value2, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andIsOrderCancelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_order_cancel not between", value1, value2, "isOrderCancel");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeIsNull() {
            addCriterion("device_refund_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeIsNotNull() {
            addCriterion("device_refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeEqualTo(Integer value) {
            addCriterion("device_refund_time =", value, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeNotEqualTo(Integer value) {
            addCriterion("device_refund_time <>", value, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeGreaterThan(Integer value) {
            addCriterion("device_refund_time >", value, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_refund_time >=", value, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeLessThan(Integer value) {
            addCriterion("device_refund_time <", value, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeLessThanOrEqualTo(Integer value) {
            addCriterion("device_refund_time <=", value, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeIn(List<Integer> values) {
            addCriterion("device_refund_time in", values, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeNotIn(List<Integer> values) {
            addCriterion("device_refund_time not in", values, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeBetween(Integer value1, Integer value2) {
            addCriterion("device_refund_time between", value1, value2, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRefundTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("device_refund_time not between", value1, value2, "deviceRefundTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberIsNull() {
            addCriterion("online_card_number is null");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberIsNotNull() {
            addCriterion("online_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberEqualTo(String value) {
            addCriterion("online_card_number =", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberNotEqualTo(String value) {
            addCriterion("online_card_number <>", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberGreaterThan(String value) {
            addCriterion("online_card_number >", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("online_card_number >=", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberLessThan(String value) {
            addCriterion("online_card_number <", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberLessThanOrEqualTo(String value) {
            addCriterion("online_card_number <=", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberLike(String value) {
            addCriterion("online_card_number like", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberNotLike(String value) {
            addCriterion("online_card_number not like", value, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberIn(List<String> values) {
            addCriterion("online_card_number in", values, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberNotIn(List<String> values) {
            addCriterion("online_card_number not in", values, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberBetween(String value1, String value2) {
            addCriterion("online_card_number between", value1, value2, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andOnlineCardNumberNotBetween(String value1, String value2) {
            addCriterion("online_card_number not between", value1, value2, "onlineCardNumber");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andErrTypeIsNull() {
            addCriterion("err_type is null");
            return (Criteria) this;
        }

        public Criteria andErrTypeIsNotNull() {
            addCriterion("err_type is not null");
            return (Criteria) this;
        }

        public Criteria andErrTypeEqualTo(Integer value) {
            addCriterion("err_type =", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotEqualTo(Integer value) {
            addCriterion("err_type <>", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeGreaterThan(Integer value) {
            addCriterion("err_type >", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("err_type >=", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLessThan(Integer value) {
            addCriterion("err_type <", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLessThanOrEqualTo(Integer value) {
            addCriterion("err_type <=", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeIn(List<Integer> values) {
            addCriterion("err_type in", values, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotIn(List<Integer> values) {
            addCriterion("err_type not in", values, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeBetween(Integer value1, Integer value2) {
            addCriterion("err_type between", value1, value2, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("err_type not between", value1, value2, "errType");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyIsNull() {
            addCriterion("reduce_money is null");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyIsNotNull() {
            addCriterion("reduce_money is not null");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyEqualTo(Integer value) {
            addCriterion("reduce_money =", value, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyNotEqualTo(Integer value) {
            addCriterion("reduce_money <>", value, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyGreaterThan(Integer value) {
            addCriterion("reduce_money >", value, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_money >=", value, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyLessThan(Integer value) {
            addCriterion("reduce_money <", value, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_money <=", value, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyIn(List<Integer> values) {
            addCriterion("reduce_money in", values, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyNotIn(List<Integer> values) {
            addCriterion("reduce_money not in", values, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyBetween(Integer value1, Integer value2) {
            addCriterion("reduce_money between", value1, value2, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_money not between", value1, value2, "reduceMoney");
            return (Criteria) this;
        }

        public Criteria andReduceTypeIsNull() {
            addCriterion("reduce_type is null");
            return (Criteria) this;
        }

        public Criteria andReduceTypeIsNotNull() {
            addCriterion("reduce_type is not null");
            return (Criteria) this;
        }

        public Criteria andReduceTypeEqualTo(Integer value) {
            addCriterion("reduce_type =", value, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeNotEqualTo(Integer value) {
            addCriterion("reduce_type <>", value, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeGreaterThan(Integer value) {
            addCriterion("reduce_type >", value, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_type >=", value, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeLessThan(Integer value) {
            addCriterion("reduce_type <", value, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_type <=", value, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeIn(List<Integer> values) {
            addCriterion("reduce_type in", values, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeNotIn(List<Integer> values) {
            addCriterion("reduce_type not in", values, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeBetween(Integer value1, Integer value2) {
            addCriterion("reduce_type between", value1, value2, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_type not between", value1, value2, "reduceType");
            return (Criteria) this;
        }

        public Criteria andReduceIdIsNull() {
            addCriterion("reduce_id is null");
            return (Criteria) this;
        }

        public Criteria andReduceIdIsNotNull() {
            addCriterion("reduce_id is not null");
            return (Criteria) this;
        }

        public Criteria andReduceIdEqualTo(Integer value) {
            addCriterion("reduce_id =", value, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdNotEqualTo(Integer value) {
            addCriterion("reduce_id <>", value, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdGreaterThan(Integer value) {
            addCriterion("reduce_id >", value, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_id >=", value, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdLessThan(Integer value) {
            addCriterion("reduce_id <", value, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_id <=", value, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdIn(List<Integer> values) {
            addCriterion("reduce_id in", values, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdNotIn(List<Integer> values) {
            addCriterion("reduce_id not in", values, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdBetween(Integer value1, Integer value2) {
            addCriterion("reduce_id between", value1, value2, "reduceId");
            return (Criteria) this;
        }

        public Criteria andReduceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_id not between", value1, value2, "reduceId");
            return (Criteria) this;
        }

        public Criteria andChargeCodeIsNull() {
            addCriterion("charge_code is null");
            return (Criteria) this;
        }

        public Criteria andChargeCodeIsNotNull() {
            addCriterion("charge_code is not null");
            return (Criteria) this;
        }

        public Criteria andChargeCodeEqualTo(String value) {
            addCriterion("charge_code =", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeNotEqualTo(String value) {
            addCriterion("charge_code <>", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeGreaterThan(String value) {
            addCriterion("charge_code >", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("charge_code >=", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeLessThan(String value) {
            addCriterion("charge_code <", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeLessThanOrEqualTo(String value) {
            addCriterion("charge_code <=", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeLike(String value) {
            addCriterion("charge_code like", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeNotLike(String value) {
            addCriterion("charge_code not like", value, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeIn(List<String> values) {
            addCriterion("charge_code in", values, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeNotIn(List<String> values) {
            addCriterion("charge_code not in", values, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeBetween(String value1, String value2) {
            addCriterion("charge_code between", value1, value2, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andChargeCodeNotBetween(String value1, String value2) {
            addCriterion("charge_code not between", value1, value2, "chargeCode");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}