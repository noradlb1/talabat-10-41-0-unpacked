package com.talabat.talabatcommon.feature.walletCardList;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase", f = "DebitCardDeflectionUseCase.kt", i = {}, l = {19, 23}, m = "invoke", n = {}, s = {})
public final class DebitCardDeflectionUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61702h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61703i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DebitCardDeflectionUseCase f61704j;

    /* renamed from: k  reason: collision with root package name */
    public int f61705k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebitCardDeflectionUseCase$invoke$1(DebitCardDeflectionUseCase debitCardDeflectionUseCase, Continuation<? super DebitCardDeflectionUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61704j = debitCardDeflectionUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61703i = obj;
        this.f61705k |= Integer.MIN_VALUE;
        return this.f61704j.invoke((String) null, this);
    }
}
