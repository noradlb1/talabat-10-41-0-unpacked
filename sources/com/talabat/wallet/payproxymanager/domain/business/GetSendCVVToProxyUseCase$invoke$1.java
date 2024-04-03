package com.talabat.wallet.payproxymanager.domain.business;

import com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase", f = "GetSendCVVToProxyUseCase.kt", i = {0}, l = {21}, m = "invoke", n = {"this"}, s = {"L$0"})
public final class GetSendCVVToProxyUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12638h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12639i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetSendCVVToProxyUseCase f12640j;

    /* renamed from: k  reason: collision with root package name */
    public int f12641k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetSendCVVToProxyUseCase$invoke$1(GetSendCVVToProxyUseCase getSendCVVToProxyUseCase, Continuation<? super GetSendCVVToProxyUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12640j = getSendCVVToProxyUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12639i = obj;
        this.f12641k |= Integer.MIN_VALUE;
        return this.f12640j.invoke((PayProxyCVVRequestModel) null, this);
    }
}
