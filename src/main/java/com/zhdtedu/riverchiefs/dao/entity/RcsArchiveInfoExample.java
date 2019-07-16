package com.zhdtedu.riverchiefs.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RcsArchiveInfoExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;


    public RcsArchiveInfoExample() {
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
            addCriterion("ID_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArchNumIsNull() {
            addCriterion("ARCH_NUM is null");
            return (Criteria) this;
        }

        public Criteria andArchNumIsNotNull() {
            addCriterion("ARCH_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andArchNumEqualTo(String value) {
            addCriterion("ARCH_NUM =", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumNotEqualTo(String value) {
            addCriterion("ARCH_NUM <>", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumGreaterThan(String value) {
            addCriterion("ARCH_NUM >", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumGreaterThanOrEqualTo(String value) {
            addCriterion("ARCH_NUM >=", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumLessThan(String value) {
            addCriterion("ARCH_NUM <", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumLessThanOrEqualTo(String value) {
            addCriterion("ARCH_NUM <=", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumLike(String value) {
            addCriterion("ARCH_NUM like", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumNotLike(String value) {
            addCriterion("ARCH_NUM not like", value, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumIn(List<String> values) {
            addCriterion("ARCH_NUM in", values, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumNotIn(List<String> values) {
            addCriterion("ARCH_NUM not in", values, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumBetween(String value1, String value2) {
            addCriterion("ARCH_NUM between", value1, value2, "archNum");
            return (Criteria) this;
        }

        public Criteria andArchNumNotBetween(String value1, String value2) {
            addCriterion("ARCH_NUM not between", value1, value2, "archNum");
            return (Criteria) this;
        }

        public Criteria andQuestionFromIsNull() {
            addCriterion("QUESTION_FROM is null");
            return (Criteria) this;
        }

        public Criteria andQuestionFromIsNotNull() {
            addCriterion("QUESTION_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionFromEqualTo(String value) {
            addCriterion("QUESTION_FROM =", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromNotEqualTo(String value) {
            addCriterion("QUESTION_FROM <>", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromGreaterThan(String value) {
            addCriterion("QUESTION_FROM >", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_FROM >=", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromLessThan(String value) {
            addCriterion("QUESTION_FROM <", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_FROM <=", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromLike(String value) {
            addCriterion("QUESTION_FROM like", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromNotLike(String value) {
            addCriterion("QUESTION_FROM not like", value, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromIn(List<String> values) {
            addCriterion("QUESTION_FROM in", values, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromNotIn(List<String> values) {
            addCriterion("QUESTION_FROM not in", values, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromBetween(String value1, String value2) {
            addCriterion("QUESTION_FROM between", value1, value2, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionFromNotBetween(String value1, String value2) {
            addCriterion("QUESTION_FROM not between", value1, value2, "questionFrom");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNull() {
            addCriterion("QUESTION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("QUESTION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(String value) {
            addCriterion("QUESTION_TYPE =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(String value) {
            addCriterion("QUESTION_TYPE <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(String value) {
            addCriterion("QUESTION_TYPE >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_TYPE >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(String value) {
            addCriterion("QUESTION_TYPE <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_TYPE <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLike(String value) {
            addCriterion("QUESTION_TYPE like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotLike(String value) {
            addCriterion("QUESTION_TYPE not like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<String> values) {
            addCriterion("QUESTION_TYPE in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<String> values) {
            addCriterion("QUESTION_TYPE not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(String value1, String value2) {
            addCriterion("QUESTION_TYPE between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(String value1, String value2) {
            addCriterion("QUESTION_TYPE not between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrIsNull() {
            addCriterion("QUESTION_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrIsNotNull() {
            addCriterion("QUESTION_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrEqualTo(String value) {
            addCriterion("QUESTION_ADDR =", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrNotEqualTo(String value) {
            addCriterion("QUESTION_ADDR <>", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrGreaterThan(String value) {
            addCriterion("QUESTION_ADDR >", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_ADDR >=", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrLessThan(String value) {
            addCriterion("QUESTION_ADDR <", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_ADDR <=", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrLike(String value) {
            addCriterion("QUESTION_ADDR like", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrNotLike(String value) {
            addCriterion("QUESTION_ADDR not like", value, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrIn(List<String> values) {
            addCriterion("QUESTION_ADDR in", values, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrNotIn(List<String> values) {
            addCriterion("QUESTION_ADDR not in", values, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrBetween(String value1, String value2) {
            addCriterion("QUESTION_ADDR between", value1, value2, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andQuestionAddrNotBetween(String value1, String value2) {
            addCriterion("QUESTION_ADDR not between", value1, value2, "questionAddr");
            return (Criteria) this;
        }

        public Criteria andMapLevelIsNull() {
            addCriterion("MAP_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andMapLevelIsNotNull() {
            addCriterion("MAP_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andMapLevelEqualTo(String value) {
            addCriterion("MAP_LEVEL =", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotEqualTo(String value) {
            addCriterion("MAP_LEVEL <>", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelGreaterThan(String value) {
            addCriterion("MAP_LEVEL >", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelGreaterThanOrEqualTo(String value) {
            addCriterion("MAP_LEVEL >=", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelLessThan(String value) {
            addCriterion("MAP_LEVEL <", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelLessThanOrEqualTo(String value) {
            addCriterion("MAP_LEVEL <=", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelLike(String value) {
            addCriterion("MAP_LEVEL like", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotLike(String value) {
            addCriterion("MAP_LEVEL not like", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelIn(List<String> values) {
            addCriterion("MAP_LEVEL in", values, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotIn(List<String> values) {
            addCriterion("MAP_LEVEL not in", values, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelBetween(String value1, String value2) {
            addCriterion("MAP_LEVEL between", value1, value2, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotBetween(String value1, String value2) {
            addCriterion("MAP_LEVEL not between", value1, value2, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapAddrIsNull() {
            addCriterion("MAP_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andMapAddrIsNotNull() {
            addCriterion("MAP_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andMapAddrEqualTo(String value) {
            addCriterion("MAP_ADDR =", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrNotEqualTo(String value) {
            addCriterion("MAP_ADDR <>", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrGreaterThan(String value) {
            addCriterion("MAP_ADDR >", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrGreaterThanOrEqualTo(String value) {
            addCriterion("MAP_ADDR >=", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrLessThan(String value) {
            addCriterion("MAP_ADDR <", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrLessThanOrEqualTo(String value) {
            addCriterion("MAP_ADDR <=", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrLike(String value) {
            addCriterion("MAP_ADDR like", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrNotLike(String value) {
            addCriterion("MAP_ADDR not like", value, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrIn(List<String> values) {
            addCriterion("MAP_ADDR in", values, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrNotIn(List<String> values) {
            addCriterion("MAP_ADDR not in", values, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrBetween(String value1, String value2) {
            addCriterion("MAP_ADDR between", value1, value2, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andMapAddrNotBetween(String value1, String value2) {
            addCriterion("MAP_ADDR not between", value1, value2, "mapAddr");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyIsNull() {
            addCriterion("SUOS_LIUY is null");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyIsNotNull() {
            addCriterion("SUOS_LIUY is not null");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyEqualTo(String value) {
            addCriterion("SUOS_LIUY =", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyNotEqualTo(String value) {
            addCriterion("SUOS_LIUY <>", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyGreaterThan(String value) {
            addCriterion("SUOS_LIUY >", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyGreaterThanOrEqualTo(String value) {
            addCriterion("SUOS_LIUY >=", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyLessThan(String value) {
            addCriterion("SUOS_LIUY <", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyLessThanOrEqualTo(String value) {
            addCriterion("SUOS_LIUY <=", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyLike(String value) {
            addCriterion("SUOS_LIUY like", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyNotLike(String value) {
            addCriterion("SUOS_LIUY not like", value, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyIn(List<String> values) {
            addCriterion("SUOS_LIUY in", values, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyNotIn(List<String> values) {
            addCriterion("SUOS_LIUY not in", values, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyBetween(String value1, String value2) {
            addCriterion("SUOS_LIUY between", value1, value2, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andSuosLiuyNotBetween(String value1, String value2) {
            addCriterion("SUOS_LIUY not between", value1, value2, "suosLiuy");
            return (Criteria) this;
        }

        public Criteria andCallPhoneIsNull() {
            addCriterion("CALL_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCallPhoneIsNotNull() {
            addCriterion("CALL_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCallPhoneEqualTo(String value) {
            addCriterion("CALL_PHONE =", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneNotEqualTo(String value) {
            addCriterion("CALL_PHONE <>", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneGreaterThan(String value) {
            addCriterion("CALL_PHONE >", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CALL_PHONE >=", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneLessThan(String value) {
            addCriterion("CALL_PHONE <", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneLessThanOrEqualTo(String value) {
            addCriterion("CALL_PHONE <=", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneLike(String value) {
            addCriterion("CALL_PHONE like", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneNotLike(String value) {
            addCriterion("CALL_PHONE not like", value, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneIn(List<String> values) {
            addCriterion("CALL_PHONE in", values, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneNotIn(List<String> values) {
            addCriterion("CALL_PHONE not in", values, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneBetween(String value1, String value2) {
            addCriterion("CALL_PHONE between", value1, value2, "callPhone");
            return (Criteria) this;
        }

        public Criteria andCallPhoneNotBetween(String value1, String value2) {
            addCriterion("CALL_PHONE not between", value1, value2, "callPhone");
            return (Criteria) this;
        }

        public Criteria andHdzNumIsNull() {
            addCriterion("HDZ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andHdzNumIsNotNull() {
            addCriterion("HDZ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andHdzNumEqualTo(String value) {
            addCriterion("HDZ_NUM =", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumNotEqualTo(String value) {
            addCriterion("HDZ_NUM <>", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumGreaterThan(String value) {
            addCriterion("HDZ_NUM >", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumGreaterThanOrEqualTo(String value) {
            addCriterion("HDZ_NUM >=", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumLessThan(String value) {
            addCriterion("HDZ_NUM <", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumLessThanOrEqualTo(String value) {
            addCriterion("HDZ_NUM <=", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumLike(String value) {
            addCriterion("HDZ_NUM like", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumNotLike(String value) {
            addCriterion("HDZ_NUM not like", value, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumIn(List<String> values) {
            addCriterion("HDZ_NUM in", values, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumNotIn(List<String> values) {
            addCriterion("HDZ_NUM not in", values, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumBetween(String value1, String value2) {
            addCriterion("HDZ_NUM between", value1, value2, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzNumNotBetween(String value1, String value2) {
            addCriterion("HDZ_NUM not between", value1, value2, "hdzNum");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameIsNull() {
            addCriterion("HDZ_REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameIsNotNull() {
            addCriterion("HDZ_REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameEqualTo(String value) {
            addCriterion("HDZ_REALNAME =", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameNotEqualTo(String value) {
            addCriterion("HDZ_REALNAME <>", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameGreaterThan(String value) {
            addCriterion("HDZ_REALNAME >", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("HDZ_REALNAME >=", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameLessThan(String value) {
            addCriterion("HDZ_REALNAME <", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameLessThanOrEqualTo(String value) {
            addCriterion("HDZ_REALNAME <=", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameLike(String value) {
            addCriterion("HDZ_REALNAME like", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameNotLike(String value) {
            addCriterion("HDZ_REALNAME not like", value, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameIn(List<String> values) {
            addCriterion("HDZ_REALNAME in", values, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameNotIn(List<String> values) {
            addCriterion("HDZ_REALNAME not in", values, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameBetween(String value1, String value2) {
            addCriterion("HDZ_REALNAME between", value1, value2, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzRealnameNotBetween(String value1, String value2) {
            addCriterion("HDZ_REALNAME not between", value1, value2, "hdzRealname");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneIsNull() {
            addCriterion("HDZ_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneIsNotNull() {
            addCriterion("HDZ_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneEqualTo(String value) {
            addCriterion("HDZ_PHONE =", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneNotEqualTo(String value) {
            addCriterion("HDZ_PHONE <>", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneGreaterThan(String value) {
            addCriterion("HDZ_PHONE >", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("HDZ_PHONE >=", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneLessThan(String value) {
            addCriterion("HDZ_PHONE <", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneLessThanOrEqualTo(String value) {
            addCriterion("HDZ_PHONE <=", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneLike(String value) {
            addCriterion("HDZ_PHONE like", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneNotLike(String value) {
            addCriterion("HDZ_PHONE not like", value, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneIn(List<String> values) {
            addCriterion("HDZ_PHONE in", values, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneNotIn(List<String> values) {
            addCriterion("HDZ_PHONE not in", values, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneBetween(String value1, String value2) {
            addCriterion("HDZ_PHONE between", value1, value2, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andHdzPhoneNotBetween(String value1, String value2) {
            addCriterion("HDZ_PHONE not between", value1, value2, "hdzPhone");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameIsNull() {
            addCriterion("JBR_REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameIsNotNull() {
            addCriterion("JBR_REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameEqualTo(String value) {
            addCriterion("JBR_REALNAME =", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameNotEqualTo(String value) {
            addCriterion("JBR_REALNAME <>", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameGreaterThan(String value) {
            addCriterion("JBR_REALNAME >", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("JBR_REALNAME >=", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameLessThan(String value) {
            addCriterion("JBR_REALNAME <", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameLessThanOrEqualTo(String value) {
            addCriterion("JBR_REALNAME <=", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameLike(String value) {
            addCriterion("JBR_REALNAME like", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameNotLike(String value) {
            addCriterion("JBR_REALNAME not like", value, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameIn(List<String> values) {
            addCriterion("JBR_REALNAME in", values, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameNotIn(List<String> values) {
            addCriterion("JBR_REALNAME not in", values, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameBetween(String value1, String value2) {
            addCriterion("JBR_REALNAME between", value1, value2, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andJbrRealnameNotBetween(String value1, String value2) {
            addCriterion("JBR_REALNAME not between", value1, value2, "jbrRealname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNull() {
            addCriterion("REPORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("REPORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Integer value) {
            addCriterion("REPORT_ID =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Integer value) {
            addCriterion("REPORT_ID <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Integer value) {
            addCriterion("REPORT_ID >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REPORT_ID >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Integer value) {
            addCriterion("REPORT_ID <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Integer value) {
            addCriterion("REPORT_ID <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Integer> values) {
            addCriterion("REPORT_ID in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Integer> values) {
            addCriterion("REPORT_ID not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Integer value1, Integer value2) {
            addCriterion("REPORT_ID between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REPORT_ID not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportRealnameIsNull() {
            addCriterion("REPORT_REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andReportRealnameIsNotNull() {
            addCriterion("REPORT_REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andReportRealnameEqualTo(String value) {
            addCriterion("REPORT_REALNAME =", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameNotEqualTo(String value) {
            addCriterion("REPORT_REALNAME <>", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameGreaterThan(String value) {
            addCriterion("REPORT_REALNAME >", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("REPORT_REALNAME >=", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameLessThan(String value) {
            addCriterion("REPORT_REALNAME <", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameLessThanOrEqualTo(String value) {
            addCriterion("REPORT_REALNAME <=", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameLike(String value) {
            addCriterion("REPORT_REALNAME like", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameNotLike(String value) {
            addCriterion("REPORT_REALNAME not like", value, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameIn(List<String> values) {
            addCriterion("REPORT_REALNAME in", values, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameNotIn(List<String> values) {
            addCriterion("REPORT_REALNAME not in", values, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameBetween(String value1, String value2) {
            addCriterion("REPORT_REALNAME between", value1, value2, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportRealnameNotBetween(String value1, String value2) {
            addCriterion("REPORT_REALNAME not between", value1, value2, "reportRealname");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNull() {
            addCriterion("REPORT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNotNull() {
            addCriterion("REPORT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andReportDateEqualTo(Date value) {
            addCriterion("REPORT_DATE =", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotEqualTo(Date value) {
            addCriterion("REPORT_DATE <>", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThan(Date value) {
            addCriterion("REPORT_DATE >", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThanOrEqualTo(Date value) {
            addCriterion("REPORT_DATE >=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThan(Date value) {
            addCriterion("REPORT_DATE <", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThanOrEqualTo(Date value) {
            addCriterion("REPORT_DATE <=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateIn(List<Date> values) {
            addCriterion("REPORT_DATE in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotIn(List<Date> values) {
            addCriterion("REPORT_DATE not in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateBetween(Date value1, Date value2) {
            addCriterion("REPORT_DATE between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotBetween(Date value1, Date value2) {
            addCriterion("REPORT_DATE not between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS_ like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS_ not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("EXT1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT1 not between", value1, value2, "ext1");
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