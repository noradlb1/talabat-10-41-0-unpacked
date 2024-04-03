package com.newrelic.agent.android.util;

import com.newrelic.com.google.gson.JsonPrimitive;

public class SafeJsonPrimitive {
    public static final Boolean NULL_BOOL = Boolean.FALSE;
    public static final char NULL_CHAR = ' ';
    public static final Number NULL_NUMBER = Float.valueOf(Float.NaN);
    public static final String NULL_STRING = "null";

    public static Boolean checkNull(Boolean bool) {
        return bool == null ? NULL_BOOL : bool;
    }

    public static String checkNull(String str) {
        return str == null ? "null" : str;
    }

    public static JsonPrimitive factory(Boolean bool) {
        return new JsonPrimitive(checkNull(bool));
    }

    public static Number checkNull(Number number) {
        return number == null ? NULL_NUMBER : number;
    }

    public static JsonPrimitive factory(Number number) {
        return new JsonPrimitive(checkNull(number));
    }

    public static Character checkNull(Character ch2) {
        return Character.valueOf(ch2 == null ? ' ' : ch2.charValue());
    }

    public static JsonPrimitive factory(String str) {
        return new JsonPrimitive(checkNull(str));
    }

    public static JsonPrimitive factory(Character ch2) {
        return new JsonPrimitive(checkNull(ch2));
    }

    public static JsonPrimitive factory(Double d11) {
        if (d11.floatValue() <= 2.14748365E9f || ((double) d11.longValue()) != d11.doubleValue()) {
            return new JsonPrimitive(checkNull((Number) d11));
        }
        return new JsonPrimitive((Number) Long.valueOf(d11.longValue()));
    }
}
