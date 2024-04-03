package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {}, l = {214}, m = "subscribeWithB2BVoucher", n = {}, s = {})
public final class SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58940h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58941i;

    /* renamed from: j  reason: collision with root package name */
    public int f58942j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$subscribeWithB2BVoucher$1> continuation) {
        super(continuation);
        this.f58941i = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58940h = obj;
        this.f58942j |= Integer.MIN_VALUE;
        return this.f58941i.subscribeWithB2BVoucher((String) null, (String) null, (String) null, this);
    }
}
