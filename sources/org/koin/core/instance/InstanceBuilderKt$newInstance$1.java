package org.koin.core.instance;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"", "T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class InstanceBuilderKt$newInstance$1 extends Lambda implements Function0<Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f62725g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Constructor<?> f62726h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstanceBuilderKt$newInstance$1(Object[] objArr, Constructor<?> constructor) {
        super(0);
        this.f62725g = objArr;
        this.f62726h = constructor;
    }

    @NotNull
    public final Object invoke() {
        return InstanceBuilderKt.createInstance(this.f62725g, this.f62726h);
    }
}
