package com.talabat.userandlocation.appinfo.data.remote.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl", f = "AppInfoRemoteDataSourceImpl.kt", i = {0}, l = {20}, m = "getAppInfo", n = {"$this$getAppInfo_u24lambda_u2d1"}, s = {"L$0"})
public final class AppInfoRemoteDataSourceImpl$getAppInfo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12198h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12199i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AppInfoRemoteDataSourceImpl f12200j;

    /* renamed from: k  reason: collision with root package name */
    public int f12201k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRemoteDataSourceImpl$getAppInfo$1(AppInfoRemoteDataSourceImpl appInfoRemoteDataSourceImpl, Continuation<? super AppInfoRemoteDataSourceImpl$getAppInfo$1> continuation) {
        super(continuation);
        this.f12200j = appInfoRemoteDataSourceImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12199i = obj;
        this.f12201k |= Integer.MIN_VALUE;
        return this.f12200j.getAppInfo(0, this);
    }
}
