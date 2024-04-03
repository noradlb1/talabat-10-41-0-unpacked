package com.talabat.userandlocation.appinfo.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl", f = "AppInfoRepositoryImpl.kt", i = {}, l = {138}, m = "getAddressesFromMicroService", n = {}, s = {})
public final class AppInfoRepositoryImpl$getAddressesFromMicroService$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12192h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f12193i;

    /* renamed from: j  reason: collision with root package name */
    public int f12194j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$getAddressesFromMicroService$1(AppInfoRepositoryImpl appInfoRepositoryImpl, Continuation<? super AppInfoRepositoryImpl$getAddressesFromMicroService$1> continuation) {
        super(continuation);
        this.f12193i = appInfoRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12192h = obj;
        this.f12194j |= Integer.MIN_VALUE;
        return this.f12193i.getAddressesFromMicroService(0, this);
    }
}
