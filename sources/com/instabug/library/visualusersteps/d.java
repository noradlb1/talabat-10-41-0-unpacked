package com.instabug.library.visualusersteps;

import androidx.annotation.Nullable;
import com.instabug.library.model.StepType;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f52144a;

    /* renamed from: b  reason: collision with root package name */
    private String f52145b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52146c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private c f52147d;

    /* renamed from: e  reason: collision with root package name */
    private Deque f52148e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f52149f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f52150g = false;

    public d(String str, @Nullable String str2, @Nullable String str3) {
        this.f52145b = str;
        this.f52146c = str2;
        this.f52148e = new LinkedBlockingDeque();
        this.f52144a = str3;
    }

    public void a(@Nullable String str) {
        this.f52146c = str;
    }

    public void b(boolean z11) {
        this.f52149f = z11;
    }

    @Nullable
    public VisualUserStep c() {
        Deque deque = this.f52148e;
        if (deque == null || deque.size() <= 0) {
            return null;
        }
        return (VisualUserStep) this.f52148e.peekLast();
    }

    @Nullable
    public c d() {
        return this.f52147d;
    }

    @Nullable
    public String e() {
        return this.f52146c;
    }

    public Deque f() {
        return this.f52148e;
    }

    @Nullable
    public String g() {
        return this.f52144a;
    }

    public int h() {
        return this.f52148e.size();
    }

    public boolean i() {
        return this.f52150g;
    }

    public boolean j() {
        return this.f52149f;
    }

    public void k() {
        if (!this.f52148e.isEmpty()) {
            this.f52148e.pollFirst();
        }
    }

    public void l() {
        if (!this.f52148e.isEmpty()) {
            this.f52148e.pollLast();
        }
    }

    public String a() {
        return this.f52145b;
    }

    public void b(VisualUserStep visualUserStep) {
        this.f52148e.add(visualUserStep);
        if (visualUserStep.getStepType() == null) {
            return;
        }
        if (visualUserStep.getStepType().equals(StepType.ACTIVITY_RESUMED) || visualUserStep.getStepType().equals(StepType.FRAGMENT_RESUMED)) {
            this.f52149f = true;
        }
    }

    public void a(@Nullable c cVar) {
        this.f52147d = cVar;
    }

    public void a(boolean z11) {
        this.f52150g = z11;
    }
}
