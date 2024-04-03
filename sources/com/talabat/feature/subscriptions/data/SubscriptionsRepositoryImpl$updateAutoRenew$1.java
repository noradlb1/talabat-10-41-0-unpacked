package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {}, l = {69}, m = "updateAutoRenew", n = {}, s = {})
public final class SubscriptionsRepositoryImpl$updateAutoRenew$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58943h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58944i;

    /* renamed from: j  reason: collision with root package name */
    public int f58945j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$updateAutoRenew$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$updateAutoRenew$1> continuation) {
        super(continuation);
        this.f58944i = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58943h = obj;
        this.f58945j |= Integer.MIN_VALUE;
        return this.f58944i.updateAutoRenew((String) null, false, false, this);
    }
}
