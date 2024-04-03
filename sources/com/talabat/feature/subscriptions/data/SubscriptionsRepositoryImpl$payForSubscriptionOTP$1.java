package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {0}, l = {411}, m = "payForSubscriptionOTP", n = {"$this$payForSubscriptionOTP_u24lambda_u2d34"}, s = {"L$0"})
public final class SubscriptionsRepositoryImpl$payForSubscriptionOTP$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58925h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58926i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58927j;

    /* renamed from: k  reason: collision with root package name */
    public int f58928k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$payForSubscriptionOTP$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$payForSubscriptionOTP$1> continuation) {
        super(continuation);
        this.f58927j = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58926i = obj;
        this.f58928k |= Integer.MIN_VALUE;
        return this.f58927j.payForSubscriptionOTP((String) null, 0, (String) null, (String) null, (String) null, this);
    }
}
