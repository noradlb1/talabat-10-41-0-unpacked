package com.instabug.apm.cache.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.model.common.Session;
import java.util.List;

public class f implements Session {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f45213a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f45214b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f45215c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final String f45216d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final String f45217e;

    /* renamed from: f  reason: collision with root package name */
    private final long f45218f;

    /* renamed from: g  reason: collision with root package name */
    private final long f45219g;

    /* renamed from: h  reason: collision with root package name */
    private final long f45220h;

    /* renamed from: i  reason: collision with root package name */
    private final int f45221i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private List f45222j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private List f45223k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private List f45224l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private List f45225m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private g f45226n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private List f45227o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private List f45228p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    private final String f45229q;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(@NonNull String str, @NonNull Session session) {
        this(str, session.getId(), session.getOs(), session.getAppVersion() != null ? session.getAppVersion() : "", session.getUuid(), 0, session.getStartTimestampMicros(), session.getStartNanoTime(), session.getVersion(), -1, -1);
    }

    public f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, long j11, long j12, long j13, @NonNull String str6, int i11, int i12) {
        this.f45213a = str;
        this.f45214b = str2;
        this.f45215c = str3;
        this.f45216d = str4;
        this.f45217e = str5;
        this.f45218f = j11;
        this.f45219g = j12;
        this.f45221i = i11;
        this.f45220h = j13;
        this.f45229q = str6;
    }

    @Nullable
    public List a() {
        return this.f45222j;
    }

    public void a(@Nullable g gVar) {
        this.f45226n = gVar;
    }

    public void a(@Nullable List list) {
        this.f45222j = list;
    }

    @NonNull
    public String b() {
        return this.f45214b;
    }

    public void b(@Nullable List list) {
        this.f45223k = list;
    }

    public long c() {
        return this.f45218f;
    }

    public void c(@Nullable List list) {
        this.f45227o = list;
    }

    @Nullable
    public List d() {
        return this.f45223k;
    }

    public void d(@Nullable List list) {
        this.f45228p = list;
    }

    @Nullable
    public List e() {
        return this.f45227o;
    }

    public void e(@Nullable List list) {
        this.f45225m = list;
    }

    @Nullable
    public List f() {
        return this.f45228p;
    }

    public void f(@Nullable List list) {
        this.f45224l = list;
    }

    @Nullable
    public List g() {
        return this.f45225m;
    }

    @NonNull
    public String getAppVersion() {
        return this.f45216d;
    }

    @NonNull
    public String getId() {
        return this.f45213a;
    }

    @NonNull
    public String getOs() {
        return this.f45215c;
    }

    public long getStartNanoTime() {
        return this.f45220h;
    }

    public long getStartTimestampMicros() {
        return this.f45219g;
    }

    @NonNull
    public String getUuid() {
        return this.f45217e;
    }

    public String getVersion() {
        return this.f45229q;
    }

    @Nullable
    public g h() {
        return this.f45226n;
    }

    public int i() {
        return this.f45221i;
    }

    @Nullable
    public List j() {
        return this.f45224l;
    }
}
