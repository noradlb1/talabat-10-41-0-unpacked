package com.instabug.library.util.memory.predicate;

import android.content.Context;
import androidx.annotation.Nullable;

public abstract class Predicate {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Context f52077a;

    @Nullable
    public Context a() {
        return this.f52077a;
    }

    public abstract boolean check();

    public void setContext(@Nullable Context context) {
        this.f52077a = context;
    }
}
