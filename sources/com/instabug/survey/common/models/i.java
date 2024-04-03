package com.instabug.survey.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;

public class i implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private long f52359a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52360b;

    /* renamed from: c  reason: collision with root package name */
    private g f52361c;

    /* renamed from: d  reason: collision with root package name */
    private int f52362d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52363e;

    /* renamed from: f  reason: collision with root package name */
    private long f52364f;

    /* renamed from: g  reason: collision with root package name */
    private long f52365g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f52366h;

    /* renamed from: i  reason: collision with root package name */
    private int f52367i;

    /* renamed from: j  reason: collision with root package name */
    private int f52368j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f52369k;

    /* renamed from: l  reason: collision with root package name */
    private int f52370l = 0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f52371m;

    /* renamed from: n  reason: collision with root package name */
    private f f52372n;

    public i(int i11) {
        this.f52362d = i11;
        this.f52363e = false;
        this.f52366h = false;
        this.f52372n = f.NOT_AVAILABLE;
        this.f52371m = true;
        this.f52361c = new g();
        this.f52368j = -1;
        this.f52367i = -1;
    }

    public int a() {
        return this.f52362d;
    }

    public void a(int i11) {
        this.f52367i = i11;
    }

    public void a(long j11) {
        this.f52364f = j11;
    }

    public void a(f fVar) {
        this.f52372n = fVar;
    }

    public void a(g gVar) {
        this.f52361c = gVar;
    }

    public void a(@NonNull String str) {
        this.f52360b = str;
    }

    public void a(boolean z11) {
        this.f52369k = z11;
    }

    public int b() {
        return this.f52367i;
    }

    public void b(int i11) {
        this.f52368j = i11;
    }

    public void b(long j11) {
        this.f52365g = j11;
    }

    public void b(boolean z11) {
        this.f52363e = z11;
    }

    public long c() {
        return this.f52364f;
    }

    public void c(int i11) {
        this.f52370l = i11;
    }

    public void c(long j11) {
        this.f52359a = j11;
    }

    public void c(boolean z11) {
        this.f52366h = z11;
    }

    public int d() {
        return this.f52368j;
    }

    public void d(boolean z11) {
        this.f52371m = z11;
    }

    public int e() {
        return this.f52370l;
    }

    public long f() {
        return this.f52365g;
    }

    public long g() {
        return this.f52359a;
    }

    public f h() {
        return this.f52372n;
    }

    public g i() {
        return this.f52361c;
    }

    @Nullable
    public String j() {
        return this.f52360b;
    }

    public void k() {
        this.f52367i++;
    }

    public int l() {
        int i11 = this.f52368j + 1;
        this.f52368j = i11;
        return i11;
    }

    public void m() {
        int i11 = this.f52370l + 1;
        this.f52370l = i11;
        c(i11);
    }

    public boolean n() {
        return this.f52369k;
    }

    public boolean o() {
        return this.f52363e;
    }

    public boolean p() {
        return this.f52366h;
    }

    public boolean q() {
        return this.f52371m;
    }
}
