package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {0}, l = {94}, m = "payForSubscriptionPlan", n = {"this"}, s = {"L$0"})
public final class SubscriptionsRepositoryImpl$payForSubscriptionPlan$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58929h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58930i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58931j;

    /* renamed from: k  reason: collision with root package name */
    public int f58932k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$payForSubscriptionPlan$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$payForSubscriptionPlan$1> continuation) {
        super(continuation);
        this.f58931j = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58930i = obj;
        this.f58932k |= Integer.MIN_VALUE;
        return this.f58931j.payForSubscriptionPlan((String) null, 0, (String) null, (String) null, (String) null, (String) null, this);
    }
}
