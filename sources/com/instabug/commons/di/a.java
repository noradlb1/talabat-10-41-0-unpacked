package com.instabug.commons.di;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class a extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f46305a = new a();

    public a() {
        super(0);
    }

    @Nullable
    /* renamed from: a */
    public final Context invoke() {
        return CommonsLocator.INSTANCE.getCtx();
    }
}
