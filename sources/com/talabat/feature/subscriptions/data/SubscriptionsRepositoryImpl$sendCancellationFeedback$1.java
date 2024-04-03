package com.talabat.feature.subscriptions.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl", f = "SubscriptionsRepositoryImpl.kt", i = {}, l = {346}, m = "sendCancellationFeedback", n = {}, s = {})
public final class SubscriptionsRepositoryImpl$sendCancellationFeedback$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58937h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscriptionsRepositoryImpl f58938i;

    /* renamed from: j  reason: collision with root package name */
    public int f58939j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionsRepositoryImpl$sendCancellationFeedback$1(SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, Continuation<? super SubscriptionsRepositoryImpl$sendCancellationFeedback$1> continuation) {
        super(continuation);
        this.f58938i = subscriptionsRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58937h = obj;
        this.f58939j |= Integer.MIN_VALUE;
        return this.f58938i.sendCancellationFeedback((String) null, (String) null, (String) null, this);
    }
}
