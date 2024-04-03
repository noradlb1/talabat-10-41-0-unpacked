package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase", f = "TokenizeCardUseCase.kt", i = {0, 0, 1, 1}, l = {23, 24}, m = "invoke", n = {"this", "card", "this", "publicKey"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class TokenizeCardUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59243h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59244i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59245j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TokenizeCardUseCase f59246k;

    /* renamed from: l  reason: collision with root package name */
    public int f59247l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenizeCardUseCase$invoke$1(TokenizeCardUseCase tokenizeCardUseCase, Continuation<? super TokenizeCardUseCase$invoke$1> continuation) {
        super(continuation);
        this.f59246k = tokenizeCardUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59245j = obj;
        this.f59247l |= Integer.MIN_VALUE;
        return this.f59246k.invoke((TokenizationCard) null, (TokenizeCardUseCase.UseCase) null, (Integer) null, this);
    }
}
