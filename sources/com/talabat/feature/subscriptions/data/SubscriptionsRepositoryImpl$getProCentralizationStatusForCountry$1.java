package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {0}, l = {181}, m = "getProCentralizationStatusForCountry", n = {"this"}, s = {"L$0"})
public final class SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58901h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58902i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58903j;

    /* renamed from: k  reason: collision with root package name */
    public int f58904k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$getProCentralizationStatusForCountry$1> continuation) {
        super(continuation);
        this.f58903j = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58902i = obj;
        this.f58904k |= Integer.MIN_VALUE;
        return this.f58903j.getProCentralizationStatusForCountry(0, this);
    }
}
