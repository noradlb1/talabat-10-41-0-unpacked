package com.talabat.wallet.knetStatusManager.domain.business.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase", f = "GetKNetStatusUseCase.kt", i = {0}, l = {20, 21}, m = "invoke", n = {"this"}, s = {"L$0"})
public final class GetKNetStatusUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12625h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12626i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetKNetStatusUseCase f12627j;

    /* renamed from: k  reason: collision with root package name */
    public int f12628k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetKNetStatusUseCase$invoke$1(GetKNetStatusUseCase getKNetStatusUseCase, Continuation<? super GetKNetStatusUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12627j = getKNetStatusUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12626i = obj;
        this.f12628k |= Integer.MIN_VALUE;
        return this.f12627j.invoke(false, this);
    }
}
