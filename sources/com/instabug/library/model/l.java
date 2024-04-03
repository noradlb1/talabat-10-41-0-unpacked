package com.instabug.library.model;

import androidx.annotation.Nullable;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final int f51549a;

    /* renamed from: b  reason: collision with root package name */
    private final String f51550b;

    /* renamed from: c  reason: collision with root package name */
    private final String f51551c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f51552d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f51553e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f51554a;

        /* renamed from: b  reason: collision with root package name */
        private final String f51555b;

        /* renamed from: c  reason: collision with root package name */
        private int f51556c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private String f51557d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f51558e;

        public a(String str, String str2) {
            this.f51554a = str;
            this.f51555b = str2;
        }

        public a a(@Nullable String str) {
            this.f51557d = str;
            return this;
        }

        public a a(int i11) {
            this.f51556c = i11;
            return this;
        }

        public a a(boolean z11) {
            this.f51558e = z11;
            return this;
        }

        public l a() {
            return new l(this.f51554a, this.f51555b, this.f51557d, this.f51558e, this.f51556c);
        }
    }

    public a a() {
        return new a(this.f51550b, this.f51551c).a(this.f51552d).a(this.f51549a).a(this.f51553e);
    }

    public String b() {
        return this.f51550b;
    }

    public int c() {
        return this.f51549a;
    }

    @Nullable
    public String d() {
        return this.f51552d;
    }

    public String e() {
        return this.f51551c;
    }

    public boolean f() {
        return this.f51553e;
    }

    private l(String str, String str2, @Nullable String str3, boolean z11, int i11) {
        this.f51550b = str;
        this.f51551c = str2;
        this.f51552d = str3;
        this.f51553e = z11;
        this.f51549a = i11;
    }
}
