package com.rd.animation.type;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.controller.ValueController;

public abstract class BaseAnimation<T extends Animator> {
    public static final int DEFAULT_ANIMATION_TIME = 350;

    /* renamed from: a  reason: collision with root package name */
    public long f52888a = 350;

    /* renamed from: b  reason: collision with root package name */
    public ValueController.UpdateListener f52889b;

    /* renamed from: c  reason: collision with root package name */
    public T f52890c;

    public BaseAnimation(@Nullable ValueController.UpdateListener updateListener) {
        this.f52889b = updateListener;
        this.f52890c = createAnimator();
    }

    @NonNull
    public abstract T createAnimator();

    public BaseAnimation duration(long j11) {
        this.f52888a = j11;
        T t11 = this.f52890c;
        if (t11 instanceof ValueAnimator) {
            t11.setDuration(j11);
        }
        return this;
    }

    public void end() {
        T t11 = this.f52890c;
        if (t11 != null && t11.isStarted()) {
            this.f52890c.end();
        }
    }

    public abstract BaseAnimation progress(float f11);

    public void start() {
        T t11 = this.f52890c;
        if (t11 != null && !t11.isRunning()) {
            this.f52890c.start();
        }
    }
}
