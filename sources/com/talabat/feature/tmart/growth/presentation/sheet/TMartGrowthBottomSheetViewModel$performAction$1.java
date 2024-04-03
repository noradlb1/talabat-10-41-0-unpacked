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
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$performAction$1", f = "TMartGrowthBottomSheetViewModel.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthBottomSheetViewModel$performAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59175h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheetViewModel f59176i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BottomSheetAction f59177j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheetViewModel$performAction$1(TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel, BottomSheetAction bottomSheetAction, Continuation<? super TMartGrowthBottomSheetViewModel$performAction$1> continuation) {
        super(2, continuation);
        this.f59176i = tMartGrowthBottomSheetViewModel;
        this.f59177j = bottomSheetAction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TMartGrowthBottomSheetViewModel$performAction$1(this.f59176i, this.f59177j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthBottomSheetViewModel$performAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59175h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow access$getActionFlow$p = this.f59176i.actionFlow;
            BottomSheetAction bottomSheetAction = this.f59177j;
            this.f59175h = 1;
            if (access$getActionFlow$p.emit(bottomSheetAction, this) == coroutine_suspended) {
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
