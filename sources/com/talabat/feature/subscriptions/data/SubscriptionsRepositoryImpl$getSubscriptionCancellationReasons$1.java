package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {0}, l = {326}, m = "getSubscriptionCancellationReasons", n = {"this"}, s = {"L$0"})
public final class SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58913h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58914i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58915j;

    /* renamed from: k  reason: collision with root package name */
    public int f58916k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$getSubscriptionCancellationReasons$1> continuation) {
        super(continuation);
        this.f58915j = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58914i = obj;
        this.f58916k |= Integer.MIN_VALUE;
        return this.f58915j.getSubscriptionCancellationReasons(this);
    }
}
