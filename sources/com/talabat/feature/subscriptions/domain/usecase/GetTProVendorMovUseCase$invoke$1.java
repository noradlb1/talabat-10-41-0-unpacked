package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase", f = "GetTProVendorMovUseCase.kt", i = {0}, l = {16}, m = "invoke", n = {"params"}, s = {"L$0"})
public final class GetTProVendorMovUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58991h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58992i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetTProVendorMovUseCase f58993j;

    /* renamed from: k  reason: collision with root package name */
    public int f58994k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTProVendorMovUseCase$invoke$1(GetTProVendorMovUseCase getTProVendorMovUseCase, Continuation<? super GetTProVendorMovUseCase$invoke$1> continuation) {
        super(continuation);
        this.f58993j = getTProVendorMovUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58992i = obj;
        this.f58994k |= Integer.MIN_VALUE;
        return this.f58993j.invoke((GetTProVendorMovUseCase.Params) null, this);
    }
}
