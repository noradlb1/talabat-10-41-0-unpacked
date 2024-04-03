package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase", f = "UpdateAutoRenewalUseCase.kt", i = {0, 1}, l = {15, 21}, m = "invoke", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class UpdateAutoRenewalUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58995h;

    /* renamed from: i  reason: collision with root package name */
    public Object f58996i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f58997j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ UpdateAutoRenewalUseCase f58998k;

    /* renamed from: l  reason: collision with root package name */
    public int f58999l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateAutoRenewalUseCase$invoke$1(UpdateAutoRenewalUseCase updateAutoRenewalUseCase, Continuation<? super UpdateAutoRenewalUseCase$invoke$1> continuation) {
        super(continuation);
        this.f58998k = updateAutoRenewalUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58997j = obj;
        this.f58999l |= Integer.MIN_VALUE;
        return this.f58998k.invoke((UpdateAutoRenewalUseCase.Params) null, this);
    }
}
