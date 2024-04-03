package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.dd  reason: case insensitive filesystem */
public class C0361dd {

    /* renamed from: a  reason: collision with root package name */
    private String f48460a;

    /* renamed from: b  reason: collision with root package name */
    private String f48461b;

    /* renamed from: c  reason: collision with root package name */
    private String f48462c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f48463d;

    /* renamed from: e  reason: collision with root package name */
    private List<C0366ed> f48464e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private String f48465f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f48466g;

    /* renamed from: h  reason: collision with root package name */
    private String f48467h;

    /* renamed from: i  reason: collision with root package name */
    private int f48468i = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f48469j;

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f48470k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f48471l;

    public int a() {
        return this.f48468i;
    }

    public void a(int i11) {
        this.f48468i = i11;
    }

    public void a(String str) {
        this.f48465f = str;
    }

    public void a(List<C0366ed> list) {
        if (list != null) {
            this.f48464e = list;
        }
    }

    public void a(boolean z11) {
        this.f48469j = z11;
    }

    public String b() {
        return this.f48465f;
    }

    public void b(String str) {
        this.f48460a = str;
    }

    public void b(List<Integer> list) {
        this.f48470k = list;
    }

    public void b(boolean z11) {
        this.f48471l = z11;
    }

    public String c() {
        return this.f48460a;
    }

    public void c(String str) {
        this.f48461b = str;
    }

    public void c(boolean z11) {
        this.f48466g = z11;
    }

    public String d() {
        return this.f48461b;
    }

    public void d(String str) {
        this.f48467h = str;
    }

    public void d(boolean z11) {
        this.f48463d = z11;
    }

    public List<C0366ed> e() {
        return this.f48464e;
    }

    public void e(String str) {
        this.f48462c = str;
    }

    public List<Integer> f() {
        return this.f48470k;
    }

    public String g() {
        return this.f48462c;
    }

    public boolean h() {
        return this.f48469j;
    }

    public boolean i() {
        return this.f48471l;
    }

    public boolean j() {
        return this.f48466g;
    }

    public boolean k() {
        return this.f48463d;
    }
}
