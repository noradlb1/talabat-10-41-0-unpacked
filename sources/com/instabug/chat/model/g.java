package com.instabug.chat.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f46036a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f46037b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f46038c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f46039d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private f f46040e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private e f46041f;

    /* renamed from: g  reason: collision with root package name */
    private long f46042g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f46043h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f46044i;

    public g a(long j11) {
        this.f46042g = j11;
        return this;
    }

    public g a(e eVar) {
        this.f46041f = eVar;
        return this;
    }

    public g a(f fVar) {
        this.f46040e = fVar;
        return this;
    }

    public g a(@Nullable String str) {
        this.f46036a = str;
        return this;
    }

    public g a(boolean z11) {
        this.f46043h = z11;
        return this;
    }

    @Nullable
    public String a() {
        return this.f46036a;
    }

    public void a(@Nullable ArrayList arrayList) {
        this.f46044i = arrayList;
    }

    public g b(@Nullable String str) {
        this.f46039d = str;
        return this;
    }

    @Nullable
    public ArrayList b() {
        return this.f46044i;
    }

    public long c() {
        return this.f46042g;
    }

    public g c(@Nullable String str) {
        this.f46037b = str;
        return this;
    }

    @Nullable
    public e d() {
        return this.f46041f;
    }

    public g d(@Nullable String str) {
        this.f46038c = str;
        return this;
    }

    @Nullable
    public String e() {
        return this.f46039d;
    }

    @Nullable
    public String f() {
        return this.f46037b;
    }

    @Nullable
    public f g() {
        return this.f46040e;
    }

    @Nullable
    public String h() {
        return this.f46038c;
    }

    public boolean i() {
        ArrayList arrayList = this.f46044i;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean j() {
        return this.f46043h;
    }

    @NonNull
    public String toString() {
        return "Body: " + a() + "URL: " + h() + "has actions: " + i() + "type: " + g() + "actions: " + b();
    }
}
