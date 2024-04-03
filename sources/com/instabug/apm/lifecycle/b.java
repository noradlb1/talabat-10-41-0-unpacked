package com.instabug.apm.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.instabug.apm.model.a;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private long f45457a;

    /* renamed from: b  reason: collision with root package name */
    private long f45458b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45459c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45460d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45461e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f45462f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45463g;

    /* renamed from: h  reason: collision with root package name */
    private int f45464h = 0;

    /* renamed from: i  reason: collision with root package name */
    private String f45465i = "cold";

    /* renamed from: j  reason: collision with root package name */
    private final Map f45466j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private com.instabug.apm.cache.model.b f45467k;

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
    public b() {
        HashMap hashMap = new HashMap();
        this.f45466j = hashMap;
        com.instabug.apm.model.b bVar = new com.instabug.apm.model.b();
        bVar.c(System.currentTimeMillis() * 1000);
        bVar.b(System.nanoTime() / 1000);
        hashMap.put(a.APP_CREATION, bVar);
    }

    public int a() {
        return this.f45464h;
    }

    @Nullable
    public String a(String str) {
        com.instabug.apm.model.b bVar = (com.instabug.apm.model.b) this.f45466j.get(a.ACTIVITY_CREATION);
        String str2 = null;
        String b11 = bVar != null ? bVar.b() : null;
        com.instabug.apm.model.b bVar2 = (com.instabug.apm.model.b) this.f45466j.get(a.ACTIVITY_START);
        if (bVar2 != null) {
            str2 = bVar2.b();
        }
        str.hashCode();
        return (str.equals("cold") && b11 != null && !b11.equals(str2)) ? b11 : str2;
    }

    public void a(int i11) {
        this.f45464h = i11;
    }

    public void a(long j11) {
        this.f45457a = j11;
    }

    public void a(@Nullable com.instabug.apm.cache.model.b bVar) {
        this.f45467k = bVar;
    }

    public void a(boolean z11) {
        this.f45459c = z11;
    }

    public long b() {
        return this.f45457a;
    }

    public void b(long j11) {
        this.f45458b = j11;
    }

    public void b(String str) {
        this.f45465i = str;
    }

    public void b(boolean z11) {
        this.f45462f = z11;
    }

    @Nullable
    public com.instabug.apm.cache.model.b c() {
        return this.f45467k;
    }

    public void c(boolean z11) {
        this.f45463g = z11;
    }

    public long d() {
        return this.f45458b;
    }

    public void d(boolean z11) {
        this.f45460d = z11;
    }

    public Map e() {
        return this.f45466j;
    }

    public void e(boolean z11) {
        this.f45461e = z11;
    }

    public String f() {
        return this.f45465i;
    }

    public boolean g() {
        return this.f45459c;
    }

    public boolean h() {
        return this.f45462f;
    }

    public boolean i() {
        return this.f45463g;
    }

    public boolean j() {
        return this.f45460d;
    }

    public boolean k() {
        return this.f45461e;
    }
}
