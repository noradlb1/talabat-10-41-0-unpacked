package com.instabug.terminations.diagnostics;

import com.instabug.terminations.di.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f52615a = new a();

    public a() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke() {
        return Boolean.valueOf(d.f52610a.s().isEnabled());
    }
}
