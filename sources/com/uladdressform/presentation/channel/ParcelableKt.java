package com.uladdressform.presentation.channel;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0002H\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u0002H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0002H\u0002¨\u0006\t"}, d2 = {"asBoolean", "", "", "asDouble", "", "asInt", "", "asString", "", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ParcelableKt {
    /* access modifiers changed from: private */
    public static final boolean asBoolean(Object obj) {
        Boolean bool;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        try {
            Result.Companion companion = Result.Companion;
            if (obj != null) {
                bool = Result.m6329constructorimpl(Boolean.valueOf(Boolean.parseBoolean((String) obj)));
                Boolean bool2 = Boolean.FALSE;
                if (Result.m6335isFailureimpl(bool)) {
                    bool = bool2;
                }
                return ((Boolean) bool).booleanValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public static final double asDouble(Object obj) {
        Double d11;
        if (obj instanceof Double) {
            return ((Number) obj).doubleValue();
        }
        try {
            Result.Companion companion = Result.Companion;
            if (obj != null) {
                d11 = Result.m6329constructorimpl(Double.valueOf(Double.parseDouble((String) obj)));
                Double valueOf = Double.valueOf(0.0d);
                if (Result.m6335isFailureimpl(d11)) {
                    d11 = valueOf;
                }
                return ((Number) d11).doubleValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            d11 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public static final int asInt(Object obj) {
        Integer num;
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        try {
            Result.Companion companion = Result.Companion;
            if (obj != null) {
                num = Result.m6329constructorimpl(Integer.valueOf(Integer.parseInt((String) obj)));
                if (Result.m6335isFailureimpl(num)) {
                    num = 0;
                }
                return ((Number) num).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public static final String asString(Object obj) {
        String obj2 = obj != null ? obj.toString() : null;
        return obj2 == null ? "" : obj2;
    }
}
