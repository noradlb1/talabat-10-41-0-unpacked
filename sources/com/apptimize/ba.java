package com.apptimize;

public enum ba {
    Unknown("unknown"),
    CompoundOr("or"),
    CompoundAnd("and"),
    CompoundNot("not"),
    CompoundIsNull("is_null"),
    CompoundIsNotNull("is_not_null"),
    InList("in"),
    Intersection("intersection"),
    NotInList("not_in"),
    Equals("="),
    NotEquals("!="),
    Regex("regex"),
    NotRegex("not_regex"),
    GreaterThan(">"),
    GreaterThanOrEqual(">="),
    LessThan("<"),
    LessThanOrEqual("<="),
    IsPropertyNull("is_property_null"),
    IsPropertyNotNull("is_property_not_null"),
    IsRecognizedProperty("is_recognized_property"),
    IsNotRecognizedProperty("is_not_recognized_property"),
    IsRecognizedOperator("is_recognized_operator"),
    IsNotRecognizedOperator("is_not_recognized_operator"),
    ValueOf("value_of");
    

    /* renamed from: y  reason: collision with root package name */
    private String f41356y;

    private ba(String str) {
        this.f41356y = str;
    }

    public static ba a(String str) {
        if (str != null) {
            for (ba baVar : values()) {
                if (str.equalsIgnoreCase(baVar.f41356y)) {
                    return baVar;
                }
            }
        }
        return Unknown;
    }

    public String toString() {
        return this.f41356y;
    }
}
