package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f47494a;

    /* renamed from: b  reason: collision with root package name */
    private final String f47495b;

    /* renamed from: c  reason: collision with root package name */
    private final String f47496c;

    /* renamed from: d  reason: collision with root package name */
    private final String f47497d;

    /* renamed from: e  reason: collision with root package name */
    private final String f47498e;

    /* renamed from: f  reason: collision with root package name */
    private final int f47499f;

    /* renamed from: g  reason: collision with root package name */
    private int f47500g = 0;

    public d(String str, String str2, String str3, String str4, String str5, int i11) {
        this.f47494a = str;
        this.f47495b = str2;
        this.f47496c = str3;
        this.f47497d = str4;
        this.f47498e = str5;
        this.f47499f = i11;
        if (str != null) {
            this.f47500g = str.length() / 2;
        }
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f47494a) && !TextUtils.isEmpty(this.f47495b) && !TextUtils.isEmpty(this.f47496c) && !TextUtils.isEmpty(this.f47497d) && this.f47494a.length() == this.f47495b.length() && this.f47495b.length() == this.f47496c.length() && this.f47496c.length() == this.f47500g * 2 && this.f47499f >= 0 && !TextUtils.isEmpty(this.f47498e);
    }

    public String b() {
        return this.f47494a;
    }

    public String c() {
        return this.f47495b;
    }

    public String d() {
        return this.f47496c;
    }

    public String e() {
        return this.f47497d;
    }

    public String f() {
        return this.f47498e;
    }

    public int g() {
        return this.f47499f;
    }

    public int h() {
        return this.f47500g;
    }
}
