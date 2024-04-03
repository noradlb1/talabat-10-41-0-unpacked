package com.talabat.feature.walletaddcard.data;

import com.talabat.feature.walletaddcard.domain.model.BankCard;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl", f = "WalletAddCardRepositoryImpl.kt", i = {}, l = {34}, m = "generateCardToken", n = {}, s = {})
public final class WalletAddCardRepositoryImpl$generateCardToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59427h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletAddCardRepositoryImpl f59428i;

    /* renamed from: j  reason: collision with root package name */
    public int f59429j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletAddCardRepositoryImpl$generateCardToken$1(WalletAddCardRepositoryImpl walletAddCardRepositoryImpl, Continuation<? super WalletAddCardRepositoryImpl$generateCardToken$1> continuation) {
        super(continuation);
        this.f59428i = walletAddCardRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59427h = obj;
        this.f59429j |= Integer.MIN_VALUE;
        return this.f59428i.generateCardToken((BankCard) null, this);
    }
}
