package com.instabug.library.diagnostics.nonfatals.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f34304a = -1;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f34305b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f34306c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f34307d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f34308e;

    /* renamed from: f  reason: collision with root package name */
    private int f34309f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private State f34310g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private List f34311h = new ArrayList();
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private String f34312i = "";
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private String f34313j;

    /* renamed from: k  reason: collision with root package name */
    private int f34314k = 0;

    public void a(long j11) {
        this.f34304a = j11;
    }

    @Nullable
    public String b() {
        return this.f34305b;
    }

    @Nullable
    public String c() {
        return this.f34308e;
    }

    public long d() {
        return this.f34304a;
    }

    public void e(@Nullable String str) {
        this.f34307d = str;
    }

    @NonNull
    public String f() {
        return this.f34312i;
    }

    @Nullable
    public String g() {
        return this.f34307d;
    }

    @NonNull
    public List h() {
        return this.f34311h;
    }

    public int i() {
        return this.f34314k;
    }

    @Nullable
    public String j() {
        return this.f34313j;
    }

    @Nullable
    public State k() {
        return this.f34310g;
    }

    @Nullable
    public String a() {
        return this.f34306c;
    }

    public void b(@Nullable String str) {
        this.f34305b = str;
    }

    public void c(@Nullable String str) {
        this.f34308e = str;
    }

    public void d(@NonNull String str) {
        this.f34312i = str;
    }

    public int e() {
        return this.f34309f;
    }

    public void f(@Nullable String str) {
        this.f34313j = str;
    }

    public void a(@Nullable String str) {
        this.f34306c = str;
    }

    public void b(int i11) {
        this.f34314k = i11;
    }

    public void a(int i11) {
        this.f34309f = i11;
    }

    public void a(@Nullable State state) {
        this.f34310g = state;
    }

    public void a(b bVar) {
        if (bVar == null) {
            this.f34311h = new ArrayList();
        }
        this.f34311h.add(bVar);
    }
}
