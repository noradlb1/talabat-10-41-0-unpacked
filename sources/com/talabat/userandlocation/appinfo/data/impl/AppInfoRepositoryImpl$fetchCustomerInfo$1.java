package com.talabat.userandlocation.appinfo.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl", f = "AppInfoRepositoryImpl.kt", i = {}, l = {96}, m = "fetchCustomerInfo", n = {}, s = {})
public final class AppInfoRepositoryImpl$fetchCustomerInfo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12189h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f12190i;

    /* renamed from: j  reason: collision with root package name */
    public int f12191j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$fetchCustomerInfo$1(AppInfoRepositoryImpl appInfoRepositoryImpl, Continuation<? super AppInfoRepositoryImpl$fetchCustomerInfo$1> continuation) {
        super(continuation);
        this.f12190i = appInfoRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12189h = obj;
        this.f12191j |= Integer.MIN_VALUE;
        return this.f12190i.fetchCustomerInfo(0, this);
    }
}
