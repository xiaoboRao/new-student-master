package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemsExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMygroupIsNull() {
            addCriterion("mygroup is null");
            return (Criteria) this;
        }

        public Criteria andMygroupIsNotNull() {
            addCriterion("mygroup is not null");
            return (Criteria) this;
        }

        public Criteria andMygroupEqualTo(String value) {
            addCriterion("mygroup =", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupNotEqualTo(String value) {
            addCriterion("mygroup <>", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupGreaterThan(String value) {
            addCriterion("mygroup >", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupGreaterThanOrEqualTo(String value) {
            addCriterion("mygroup >=", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupLessThan(String value) {
            addCriterion("mygroup <", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupLessThanOrEqualTo(String value) {
            addCriterion("mygroup <=", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupLike(String value) {
            addCriterion("mygroup like", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupNotLike(String value) {
            addCriterion("mygroup not like", value, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupIn(List<String> values) {
            addCriterion("mygroup in", values, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupNotIn(List<String> values) {
            addCriterion("mygroup not in", values, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupBetween(String value1, String value2) {
            addCriterion("mygroup between", value1, value2, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMygroupNotBetween(String value1, String value2) {
            addCriterion("mygroup not between", value1, value2, "mygroup");
            return (Criteria) this;
        }

        public Criteria andMysocialIsNull() {
            addCriterion("mysocial is null");
            return (Criteria) this;
        }

        public Criteria andMysocialIsNotNull() {
            addCriterion("mysocial is not null");
            return (Criteria) this;
        }

        public Criteria andMysocialEqualTo(String value) {
            addCriterion("mysocial =", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialNotEqualTo(String value) {
            addCriterion("mysocial <>", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialGreaterThan(String value) {
            addCriterion("mysocial >", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialGreaterThanOrEqualTo(String value) {
            addCriterion("mysocial >=", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialLessThan(String value) {
            addCriterion("mysocial <", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialLessThanOrEqualTo(String value) {
            addCriterion("mysocial <=", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialLike(String value) {
            addCriterion("mysocial like", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialNotLike(String value) {
            addCriterion("mysocial not like", value, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialIn(List<String> values) {
            addCriterion("mysocial in", values, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialNotIn(List<String> values) {
            addCriterion("mysocial not in", values, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialBetween(String value1, String value2) {
            addCriterion("mysocial between", value1, value2, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMysocialNotBetween(String value1, String value2) {
            addCriterion("mysocial not between", value1, value2, "mysocial");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerIsNull() {
            addCriterion("myvolunteer is null");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerIsNotNull() {
            addCriterion("myvolunteer is not null");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerEqualTo(String value) {
            addCriterion("myvolunteer =", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerNotEqualTo(String value) {
            addCriterion("myvolunteer <>", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerGreaterThan(String value) {
            addCriterion("myvolunteer >", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerGreaterThanOrEqualTo(String value) {
            addCriterion("myvolunteer >=", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerLessThan(String value) {
            addCriterion("myvolunteer <", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerLessThanOrEqualTo(String value) {
            addCriterion("myvolunteer <=", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerLike(String value) {
            addCriterion("myvolunteer like", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerNotLike(String value) {
            addCriterion("myvolunteer not like", value, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerIn(List<String> values) {
            addCriterion("myvolunteer in", values, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerNotIn(List<String> values) {
            addCriterion("myvolunteer not in", values, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerBetween(String value1, String value2) {
            addCriterion("myvolunteer between", value1, value2, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMyvolunteerNotBetween(String value1, String value2) {
            addCriterion("myvolunteer not between", value1, value2, "myvolunteer");
            return (Criteria) this;
        }

        public Criteria andMycreativeIsNull() {
            addCriterion("mycreative is null");
            return (Criteria) this;
        }

        public Criteria andMycreativeIsNotNull() {
            addCriterion("mycreative is not null");
            return (Criteria) this;
        }

        public Criteria andMycreativeEqualTo(String value) {
            addCriterion("mycreative =", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeNotEqualTo(String value) {
            addCriterion("mycreative <>", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeGreaterThan(String value) {
            addCriterion("mycreative >", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeGreaterThanOrEqualTo(String value) {
            addCriterion("mycreative >=", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeLessThan(String value) {
            addCriterion("mycreative <", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeLessThanOrEqualTo(String value) {
            addCriterion("mycreative <=", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeLike(String value) {
            addCriterion("mycreative like", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeNotLike(String value) {
            addCriterion("mycreative not like", value, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeIn(List<String> values) {
            addCriterion("mycreative in", values, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeNotIn(List<String> values) {
            addCriterion("mycreative not in", values, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeBetween(String value1, String value2) {
            addCriterion("mycreative between", value1, value2, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMycreativeNotBetween(String value1, String value2) {
            addCriterion("mycreative not between", value1, value2, "mycreative");
            return (Criteria) this;
        }

        public Criteria andMyimportantIsNull() {
            addCriterion("myimportant is null");
            return (Criteria) this;
        }

        public Criteria andMyimportantIsNotNull() {
            addCriterion("myimportant is not null");
            return (Criteria) this;
        }

        public Criteria andMyimportantEqualTo(String value) {
            addCriterion("myimportant =", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantNotEqualTo(String value) {
            addCriterion("myimportant <>", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantGreaterThan(String value) {
            addCriterion("myimportant >", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantGreaterThanOrEqualTo(String value) {
            addCriterion("myimportant >=", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantLessThan(String value) {
            addCriterion("myimportant <", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantLessThanOrEqualTo(String value) {
            addCriterion("myimportant <=", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantLike(String value) {
            addCriterion("myimportant like", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantNotLike(String value) {
            addCriterion("myimportant not like", value, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantIn(List<String> values) {
            addCriterion("myimportant in", values, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantNotIn(List<String> values) {
            addCriterion("myimportant not in", values, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantBetween(String value1, String value2) {
            addCriterion("myimportant between", value1, value2, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyimportantNotBetween(String value1, String value2) {
            addCriterion("myimportant not between", value1, value2, "myimportant");
            return (Criteria) this;
        }

        public Criteria andMyqualityIsNull() {
            addCriterion("myquality is null");
            return (Criteria) this;
        }

        public Criteria andMyqualityIsNotNull() {
            addCriterion("myquality is not null");
            return (Criteria) this;
        }

        public Criteria andMyqualityEqualTo(String value) {
            addCriterion("myquality =", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityNotEqualTo(String value) {
            addCriterion("myquality <>", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityGreaterThan(String value) {
            addCriterion("myquality >", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityGreaterThanOrEqualTo(String value) {
            addCriterion("myquality >=", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityLessThan(String value) {
            addCriterion("myquality <", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityLessThanOrEqualTo(String value) {
            addCriterion("myquality <=", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityLike(String value) {
            addCriterion("myquality like", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityNotLike(String value) {
            addCriterion("myquality not like", value, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityIn(List<String> values) {
            addCriterion("myquality in", values, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityNotIn(List<String> values) {
            addCriterion("myquality not in", values, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityBetween(String value1, String value2) {
            addCriterion("myquality between", value1, value2, "myquality");
            return (Criteria) this;
        }

        public Criteria andMyqualityNotBetween(String value1, String value2) {
            addCriterion("myquality not between", value1, value2, "myquality");
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