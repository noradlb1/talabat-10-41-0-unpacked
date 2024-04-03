package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {0}, l = {389}, m = "upgradeSubscriptionPlan", n = {"this"}, s = {"L$0"})
public final class SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58946h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58947i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58948j;

    /* renamed from: k  reason: collision with root package name */
    public int f58949k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$upgradeSubscriptionPlan$1> continuation) {
        super(continuation);
        this.f58948j = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58947i = obj;
        this.f58949k |= Integer.MIN_VALUE;
        return this.f58948j.upgradeSubscriptionPlan((String) null, (String) null, (String) null, this);
    }
}
