package com.talabat.talabatcommon.feature.walletCardManagement;

import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase", f = "GetDeleteWalletCardUseCase.kt", i = {0, 1, 2}, l = {15, 19, 22}, m = "invoke", n = {"this", "deleteCardResult", "deleteCardResult"}, s = {"L$0", "L$0", "L$0"})
public final class GetDeleteWalletCardUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61707h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61708i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetDeleteWalletCardUseCase f61709j;

    /* renamed from: k  reason: collision with root package name */
    public int f61710k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetDeleteWalletCardUseCase$invoke$1(GetDeleteWalletCardUseCase getDeleteWalletCardUseCase, Continuation<? super GetDeleteWalletCardUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61709j = getDeleteWalletCardUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61708i = obj;
        this.f61710k |= Integer.MIN_VALUE;
        return this.f61709j.invoke((WalletDeleteCardRequestModel) null, this);
    }
}
