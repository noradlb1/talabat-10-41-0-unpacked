package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {0}, l = {438}, m = "fetchTProOnBoardingBannerAndPlans", n = {"$this$fetchTProOnBoardingBannerAndPlans_u24lambda_u2d38"}, s = {"L$0"})
public final class SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58893h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58894i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58895j;

    /* renamed from: k  reason: collision with root package name */
    public int f58896k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$fetchTProOnBoardingBannerAndPlans$1> continuation) {
        super(continuation);
        this.f58895j = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58894i = obj;
        this.f58896k |= Integer.MIN_VALUE;
        return this.f58895j.fetchTProOnBoardingBannerAndPlans(0, (String) null, (Boolean) null, (String) null, (String) null, this);
    }
}
