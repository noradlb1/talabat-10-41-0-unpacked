package com.instabug.apm.cache.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class j {

    /* renamed from: a  reason: collision with root package name */
    private long f45249a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45250b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f45251c;

    /* renamed from: d  reason: collision with root package name */
    private long f45252d;

    /* renamed from: e  reason: collision with root package name */
    private long f45253e;

    /* renamed from: f  reason: collision with root package name */
    private long f45254f;

    /* renamed from: g  reason: collision with root package name */
    private long f45255g;

    /* renamed from: h  reason: collision with root package name */
    private int f45256h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f45257i = null;

    /* renamed from: j  reason: collision with root package name */
    private int f45258j = -1;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Boolean f45259k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f45260l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private String f45261m = null;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private String f45262n = null;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private String f45263o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private i f45264p = null;

    /* renamed from: q  reason: collision with root package name */
    private long f45265q;

    private boolean q() {
        return (this.f45254f == -1 || this.f45253e == -1) ? false : true;
    }

    private boolean r() {
        return this.f45264p != null;
    }

    public int a() {
        return this.f45258j;
    }

    public void a(int i11) {
        this.f45258j = i11;
    }

    public void a(long j11) {
        this.f45252d = j11;
    }

    public void a(@Nullable h hVar) {
        long j11;
        if (hVar != null) {
            this.f45253e = hVar.a();
            j11 = hVar.b();
        } else {
            j11 = -1;
            this.f45253e = -1;
        }
        this.f45254f = j11;
    }

    public void a(@Nullable i iVar) {
        this.f45264p = iVar;
    }

    public void a(@Nullable Boolean bool) {
        this.f45259k = bool;
    }

    public void a(String str) {
        this.f45260l = str;
    }

    public void a(boolean z11) {
        this.f45250b = z11;
    }

    @Nullable
    public String b() {
        return this.f45260l;
    }

    public void b(int i11) {
        this.f45256h = i11;
    }

    public void b(long j11) {
        this.f45249a = j11;
    }

    public void b(@Nullable String str) {
        this.f45261m = str;
    }

    public long c() {
        return this.f45252d;
    }

    public void c(long j11) {
        this.f45253e = j11;
    }

    public void c(String str) {
        this.f45251c = str;
    }

    public long d() {
        return this.f45249a;
    }

    public void d(long j11) {
        this.f45254f = j11;
    }

    public void d(String str) {
        this.f45262n = str;
    }

    public long e() {
        return this.f45253e;
    }

    public void e(long j11) {
        this.f45255g = j11;
    }

    public void e(String str) {
        this.f45257i = str;
    }

    @Nullable
    public String f() {
        return this.f45261m;
    }

    public void f(long j11) {
        this.f45265q = j11;
    }

    public void f(@Nullable String str) {
        this.f45263o = str;
    }

    @Nullable
    public String g() {
        return this.f45251c;
    }

    @Nullable
    public String h() {
        return this.f45262n;
    }

    @Nullable
    public Boolean i() {
        return this.f45259k;
    }

    public int j() {
        return this.f45256h;
    }

    @Nullable
    public String k() {
        return this.f45257i;
    }

    @Nullable
    public String l() {
        return this.f45263o;
    }

    public long m() {
        return this.f45254f;
    }

    public long n() {
        return this.f45255g;
    }

    public long o() {
        return this.f45265q;
    }

    @Nullable
    public i p() {
        return this.f45264p;
    }

    public boolean s() {
        return r() || q();
    }

    public boolean t() {
        return this.f45250b;
    }

    @NonNull
    public String toString() {
        return "\nScrName:\t" + this.f45251c + "\nScrTitle:\t" + this.f45257i + "\nScrStTime:\t" + this.f45255g + "\nScrVisit:\t" + this.f45252d + "\nSmallDrops:\t" + this.f45254f + "\nLargeDrop:\t" + this.f45253e + "\nRefresh:\t" + this.f45256h + "\nPowerSave:\t" + this.f45259k + "\nContainer:\t" + this.f45260l + "\nModule:\t\t" + this.f45261m + "\nOrientat:\t" + this.f45262n + "\nUserDefine:\t" + this.f45262n + "\nBattery:\t" + this.f45258j + "\nSession:\t" + this.f45263o;
    }
}
