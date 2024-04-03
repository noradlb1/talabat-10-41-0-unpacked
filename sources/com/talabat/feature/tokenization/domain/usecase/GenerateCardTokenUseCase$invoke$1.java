package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase", f = "GenerateCardTokenUseCase.kt", i = {0, 1}, l = {29, 27}, m = "invoke", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class GenerateCardTokenUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59237h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59238i;

    /* renamed from: j  reason: collision with root package name */
    public Object f59239j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f59240k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ GenerateCardTokenUseCase f59241l;

    /* renamed from: m  reason: collision with root package name */
    public int f59242m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenerateCardTokenUseCase$invoke$1(GenerateCardTokenUseCase generateCardTokenUseCase, Continuation<? super GenerateCardTokenUseCase$invoke$1> continuation) {
        super(continuation);
        this.f59241l = generateCardTokenUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59240k = obj;
        this.f59242m |= Integer.MIN_VALUE;
        return this.f59241l.invoke((TokenizationCard) null, (GenerateCardTokenUseCase.UseCase) null, (Integer) null, this);
    }
}
