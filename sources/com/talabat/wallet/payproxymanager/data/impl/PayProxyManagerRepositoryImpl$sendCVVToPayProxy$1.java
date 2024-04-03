package com.talabat.wallet.payproxymanager.data.impl;

import com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl", f = "PayProxyManagerRepositoryImpl.kt", i = {}, l = {16}, m = "sendCVVToPayProxy", n = {}, s = {})
public final class PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12634h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12635i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PayProxyManagerRepositoryImpl f12636j;

    /* renamed from: k  reason: collision with root package name */
    public int f12637k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1(PayProxyManagerRepositoryImpl payProxyManagerRepositoryImpl, Continuation<? super PayProxyManagerRepositoryImpl$sendCVVToPayProxy$1> continuation) {
        super(continuation);
        this.f12636j = payProxyManagerRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12635i = obj;
        this.f12637k |= Integer.MIN_VALUE;
        return this.f12636j.sendCVVToPayProxy((PayProxyCVVRequestModel) null, this);
    }
}
