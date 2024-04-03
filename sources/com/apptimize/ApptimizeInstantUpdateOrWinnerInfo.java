package com.apptimize;

public class ApptimizeInstantUpdateOrWinnerInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Type f40955a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f40956b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40957c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f40958d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40959e;

    /* renamed from: f  reason: collision with root package name */
    private final Long f40960f;

    /* renamed from: g  reason: collision with root package name */
    private final String f40961g;

    /* renamed from: h  reason: collision with root package name */
    private final String f40962h;

    /* renamed from: i  reason: collision with root package name */
    private final String f40963i;

    public enum Type {
        INSTANT_UPDATE,
        WINNER
    }

    public ApptimizeInstantUpdateOrWinnerInfo(Type type, Long l11, String str, Long l12, String str2, Long l13, String str3, String str4, String str5) {
        this.f40955a = type;
        this.f40956b = l11;
        this.f40957c = str;
        this.f40958d = l12;
        this.f40959e = str2;
        this.f40960f = l13;
        this.f40961g = str3;
        this.f40962h = str4;
        this.f40963i = str5;
    }

    public String getAnonymousUserId() {
        return this.f40963i;
    }

    public String getCustomerUserId() {
        return this.f40962h;
    }

    public Long getInstantUpdateId() {
        return this.f40956b;
    }

    public String getInstantUpdateName() {
        return this.f40957c;
    }

    public Type getType() {
        return this.f40955a;
    }

    public Long getWinningTestId() {
        return this.f40958d;
    }

    public String getWinningTestName() {
        return this.f40959e;
    }

    public Long getWinningVariantId() {
        return this.f40960f;
    }

    public String getWinningVariantName() {
        return this.f40961g;
    }
}
