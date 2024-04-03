package com.apptimize;

import java.util.Date;

public class ApptimizeTestInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f40983a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f40984b;

    /* renamed from: c  reason: collision with root package name */
    private final ApptimizeTestType f40985c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40986d;

    /* renamed from: e  reason: collision with root package name */
    private final long f40987e;

    /* renamed from: f  reason: collision with root package name */
    private final Date f40988f;

    /* renamed from: g  reason: collision with root package name */
    private final Date f40989g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f40990h;

    /* renamed from: i  reason: collision with root package name */
    private final int f40991i;

    /* renamed from: j  reason: collision with root package name */
    private final int f40992j;

    /* renamed from: k  reason: collision with root package name */
    private final int f40993k;

    /* renamed from: l  reason: collision with root package name */
    private final String f40994l;

    /* renamed from: m  reason: collision with root package name */
    private final String f40995m;

    public ApptimizeTestInfo(String str, Long l11, ApptimizeTestType apptimizeTestType, String str2, long j11, Date date, Date date2, boolean z11, int i11, int i12, int i13, String str3, String str4) {
        this.f40983a = str;
        this.f40984b = l11;
        this.f40985c = apptimizeTestType;
        this.f40986d = str2;
        this.f40987e = j11;
        this.f40988f = date;
        this.f40989g = date2;
        this.f40990h = z11;
        this.f40991i = i11;
        this.f40992j = i12;
        this.f40993k = i13;
        this.f40994l = str3;
        this.f40995m = str4;
    }

    public String getAnonymousUserId() {
        return this.f40995m;
    }

    public ApptimizeTestType getApptimizeTestType() {
        return this.f40985c;
    }

    public int getCurrentPhase() {
        return this.f40992j;
    }

    public String getCustomerUserId() {
        return this.f40994l;
    }

    public int getCycle() {
        return this.f40991i;
    }

    public long getEnrolledVariantId() {
        return this.f40987e;
    }

    public String getEnrolledVariantName() {
        return this.f40986d;
    }

    public int getParticipationPhase() {
        return this.f40993k;
    }

    public Date getTestEnrolledDate() {
        return this.f40989g;
    }

    public Long getTestId() {
        return this.f40984b;
    }

    public String getTestName() {
        return this.f40983a;
    }

    public Date getTestStartedDate() {
        return this.f40988f;
    }

    public boolean userHasParticipated() {
        return this.f40990h;
    }
}
