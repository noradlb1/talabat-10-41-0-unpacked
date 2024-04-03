package com.instabug.commons.diagnostics;

import com.instabug.commons.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.jetbrains.annotations.Nullable;

final /* synthetic */ class b extends PropertyReference1Impl {

    /* renamed from: a  reason: collision with root package name */
    public static final b f46310a = new b();

    public b() {
        super(d.class, "internalReason", "getInternalReason()I", 0);
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        return Integer.valueOf(((d) obj).b());
    }
}
