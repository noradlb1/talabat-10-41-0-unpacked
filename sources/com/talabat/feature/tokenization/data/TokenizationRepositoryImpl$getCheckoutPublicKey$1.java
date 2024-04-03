package com.talabat.feature.tokenization.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tokenization.data.TokenizationRepositoryImpl", f = "TokenizationRepositoryImpl.kt", i = {}, l = {24}, m = "getCheckoutPublicKey", n = {}, s = {})
public final class TokenizationRepositoryImpl$getCheckoutPublicKey$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59231h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59232i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TokenizationRepositoryImpl f59233j;

    /* renamed from: k  reason: collision with root package name */
    public int f59234k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenizationRepositoryImpl$getCheckoutPublicKey$1(TokenizationRepositoryImpl tokenizationRepositoryImpl, Continuation<? super TokenizationRepositoryImpl$getCheckoutPublicKey$1> continuation) {
        super(continuation);
        this.f59233j = tokenizationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59232i = obj;
        this.f59234k |= Integer.MIN_VALUE;
        return this.f59233j.getCheckoutPublicKey(0, (String) null, (Integer) null, this);
    }
}
