package com.talabat.feature.fees.presentation.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.fees.presentation.viewmodel.FeesViewModel", f = "FeesViewModel.kt", i = {0}, l = {81}, m = "getCalculatedFeesAndDescriptions", n = {"this"}, s = {"L$0"})
public final class FeesViewModel$getCalculatedFeesAndDescriptions$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58539h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58540i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FeesViewModel f58541j;

    /* renamed from: k  reason: collision with root package name */
    public int f58542k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeesViewModel$getCalculatedFeesAndDescriptions$1(FeesViewModel feesViewModel, Continuation<? super FeesViewModel$getCalculatedFeesAndDescriptions$1> continuation) {
        super(continuation);
        this.f58541j = feesViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58540i = obj;
        this.f58542k |= Integer.MIN_VALUE;
        return this.f58541j.getCalculatedFeesAndDescriptions(0.0f, 0.0f, 0.0f, 0.0d, 0.0d, this);
    }
}
