package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {0}, l = {261}, m = "getMultiPlan", n = {"this"}, s = {"L$0"})
public final class SubscriptionsRepositoryImpl$getMultiPlan$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58897h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58898i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58899j;

    /* renamed from: k  reason: collision with root package name */
    public int f58900k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$getMultiPlan$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$getMultiPlan$1> continuation) {
        super(continuation);
        this.f58899j = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58898i = obj;
        this.f58900k |= Integer.MIN_VALUE;
        return this.f58899j.getMultiPlan(0, (String) null, (Boolean) null, (String) null, (String) null, this);
    }
}
