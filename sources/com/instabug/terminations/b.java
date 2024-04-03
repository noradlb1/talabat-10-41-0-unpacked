package com.instabug.terminations;

import com.instabug.terminations.di.d;
import kotlin.jvm.internal.PropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

final /* synthetic */ class b extends PropertyReference0Impl {
    public b(Object obj) {
        super(obj, d.class, "appCtx", "getAppCtx()Landroid/content/Context;", 0);
    }

    @Nullable
    public Object get() {
        return ((d) this.receiver).a();
    }
}
