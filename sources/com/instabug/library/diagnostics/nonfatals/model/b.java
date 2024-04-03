package com.instabug.library.diagnostics.nonfatals.model;

import androidx.annotation.Nullable;
import com.instabug.library.model.State;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private long f34315a;

    /* renamed from: b  reason: collision with root package name */
    private long f34316b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f34317c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private State f34318d;

    public b(long j11, long j12, String str) {
        this.f34315a = j11;
        this.f34316b = j12;
        this.f34317c = str;
    }

    public long a() {
        return this.f34315a;
    }

    public long b() {
        return this.f34316b;
    }

    @Nullable
    public State c() {
        return this.f34318d;
    }

    @Nullable
    public String d() {
        return this.f34317c;
    }

    public void a(State state) {
        this.f34318d = state;
    }
}
