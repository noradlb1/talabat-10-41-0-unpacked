package com.instabug.apm.cache.model;

import androidx.annotation.Nullable;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private long f45190a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f45191b;

    /* renamed from: c  reason: collision with root package name */
    private long f45192c;

    /* renamed from: d  reason: collision with root package name */
    private long f45193d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Map f45194e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f45195f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45196g;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45197a;

        /* renamed from: b  reason: collision with root package name */
        private final long f45198b;

        /* renamed from: c  reason: collision with root package name */
        private long f45199c;

        /* renamed from: d  reason: collision with root package name */
        private long f45200d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private Map f45201e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f45202f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f45203g;

        public a(String str, long j11) {
            this.f45197a = str;
            this.f45198b = j11;
        }

        public a a(long j11) {
            this.f45200d = j11;
            return this;
        }

        public a a(Map map) {
            this.f45201e = map;
            return this;
        }

        public a a(boolean z11) {
            this.f45203g = z11;
            return this;
        }

        public c a() {
            c cVar = new c();
            cVar.b(this.f45198b);
            cVar.a(this.f45197a);
            cVar.c(this.f45199c);
            cVar.b(this.f45202f);
            cVar.a(this.f45200d);
            cVar.a(this.f45203g);
            cVar.a(this.f45201e);
            return cVar;
        }

        public a b(long j11) {
            this.f45199c = j11;
            return this;
        }

        public a b(boolean z11) {
            this.f45202f = z11;
            return this;
        }
    }

    public void a(long j11) {
        this.f45193d = j11;
    }

    public void a(@Nullable String str) {
        this.f45191b = str;
    }

    public void a(@Nullable Map map) {
        this.f45194e = map;
    }

    public void a(boolean z11) {
        this.f45196g = z11;
    }

    public boolean a() {
        return this.f45196g;
    }

    @Nullable
    public Map b() {
        return this.f45194e;
    }

    public void b(long j11) {
        this.f45190a = j11;
    }

    public void b(boolean z11) {
        this.f45195f = z11;
    }

    public long c() {
        return this.f45193d;
    }

    public void c(long j11) {
        this.f45192c = j11;
    }

    public long d() {
        return this.f45190a;
    }

    @Nullable
    public String e() {
        return this.f45191b;
    }

    public long f() {
        return this.f45192c;
    }

    public boolean g() {
        return this.f45195f;
    }
}
