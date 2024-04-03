package com.talabat.feature.tmart.growth.presentation.sheet;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$onAnimationEnd$1", f = "TMartGrowthBottomSheetViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthBottomSheetViewModel$onAnimationEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59173h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheetViewModel f59174i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheetViewModel$onAnimationEnd$1(TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel, Continuation<? super TMartGrowthBottomSheetViewModel$onAnimationEnd$1> continuation) {
        super(2, continuation);
        this.f59174i = tMartGrowthBottomSheetViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TMartGrowthBottomSheetViewModel$onAnimationEnd$1(this.f59174i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthBottomSheetViewModel$onAnimationEnd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59173h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow access$getAnimationEndFlow$p = this.f59174i.animationEndFlow;
            Unit unit = Unit.INSTANCE;
            this.f59173h = 1;
            if (access$getAnimationEndFlow$p.emit(unit, this) == coroutine_suspended) {
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
