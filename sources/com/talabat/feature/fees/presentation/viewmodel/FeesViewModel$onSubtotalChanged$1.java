package com.talabat.feature.fees.presentation.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.fees.presentation.viewmodel.FeesViewModel$onSubtotalChanged$1", f = "FeesViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class FeesViewModel$onSubtotalChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58543h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FeesViewModel f58544i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f58545j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f58546k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f58547l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ double f58548m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ double f58549n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeesViewModel$onSubtotalChanged$1(FeesViewModel feesViewModel, float f11, float f12, float f13, double d11, double d12, Continuation<? super FeesViewModel$onSubtotalChanged$1> continuation) {
        super(2, continuation);
        this.f58544i = feesViewModel;
        this.f58545j = f11;
        this.f58546k = f12;
        this.f58547l = f13;
        this.f58548m = d11;
        this.f58549n = d12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeesViewModel$onSubtotalChanged$1(this.f58544i, this.f58545j, this.f58546k, this.f58547l, this.f58548m, this.f58549n, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeesViewModel$onSubtotalChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58543h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FeesViewModel feesViewModel = this.f58544i;
            float f11 = this.f58545j;
            float f12 = this.f58546k;
            float f13 = this.f58547l;
            double d11 = this.f58548m;
            double d12 = this.f58549n;
            this.f58543h = 1;
            if (feesViewModel.getCalculatedFeesAndDescriptions(f11, f12, f13, d11, d12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
