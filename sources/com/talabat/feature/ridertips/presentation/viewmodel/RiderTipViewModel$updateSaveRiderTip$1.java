package com.talabat.feature.ridertips.presentation.viewmodel;

import com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase;
import com.talabat.feature.ridertips.presentation.displaymodel.RiderTipDisplayModel;
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
@DebugMetadata(c = "com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel$updateSaveRiderTip$1", f = "RiderTipViewModel.kt", i = {}, l = {98, 104}, m = "invokeSuspend", n = {}, s = {})
public final class RiderTipViewModel$updateSaveRiderTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58888h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RiderTipViewModel f58889i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipViewModel$updateSaveRiderTip$1(RiderTipViewModel riderTipViewModel, Continuation<? super RiderTipViewModel$updateSaveRiderTip$1> continuation) {
        super(2, continuation);
        this.f58889i = riderTipViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RiderTipViewModel$updateSaveRiderTip$1(this.f58889i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RiderTipViewModel$updateSaveRiderTip$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58888h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = this.f58889i.getViewState$com_talabat_feature_ridertips_presentation_presentation();
            if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
                RiderTipViewModel riderTipViewModel = this.f58889i;
                if (viewState$com_talabat_feature_ridertips_presentation_presentation.isDefaultTipEnabled()) {
                    SaveRiderTipUseCase access$getSaveRiderTipUseCase$p = riderTipViewModel.saveRiderTipUseCase;
                    Double tipAmount = viewState$com_talabat_feature_ridertips_presentation_presentation.getTipAmount();
                    boolean reuseTipSelected = viewState$com_talabat_feature_ridertips_presentation_presentation.getTipOptionsDetails().getReuseTipSelected();
                    this.f58888h = 2;
                    if (access$getSaveRiderTipUseCase$p.saveRiderTip(tipAmount, reuseTipSelected, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (viewState$com_talabat_feature_ridertips_presentation_presentation.getTipAmount() != null && viewState$com_talabat_feature_ridertips_presentation_presentation.getTipAmount().doubleValue() > 0.0d) {
                    SaveRiderTipUseCase access$getSaveRiderTipUseCase$p2 = riderTipViewModel.saveRiderTipUseCase;
                    Double tipAmount2 = viewState$com_talabat_feature_ridertips_presentation_presentation.getTipAmount();
                    boolean reuseTipSelected2 = viewState$com_talabat_feature_ridertips_presentation_presentation.getTipOptionsDetails().getReuseTipSelected();
                    this.f58888h = 1;
                    if (access$getSaveRiderTipUseCase$p2.saveRiderTip(tipAmount2, reuseTipSelected2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
