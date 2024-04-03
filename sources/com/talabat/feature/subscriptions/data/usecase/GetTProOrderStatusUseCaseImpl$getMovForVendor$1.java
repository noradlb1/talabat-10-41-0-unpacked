package com.talabat.feature.subscriptions.data.usecase;

import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl", f = "GetTProOrderStatusUseCaseImpl.kt", i = {}, l = {126}, m = "getMovForVendor", n = {}, s = {})
public final class GetTProOrderStatusUseCaseImpl$getMovForVendor$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58961h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetTProOrderStatusUseCaseImpl f58962i;

    /* renamed from: j  reason: collision with root package name */
    public int f58963j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTProOrderStatusUseCaseImpl$getMovForVendor$1(GetTProOrderStatusUseCaseImpl getTProOrderStatusUseCaseImpl, Continuation<? super GetTProOrderStatusUseCaseImpl$getMovForVendor$1> continuation) {
        super(continuation);
        this.f58962i = getTProOrderStatusUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58961h = obj;
        this.f58963j |= Integer.MIN_VALUE;
        return this.f58962i.getMovForVendor((Restaurant) null, this);
    }
}
