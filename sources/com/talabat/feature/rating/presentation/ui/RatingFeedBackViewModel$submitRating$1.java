package com.talabat.feature.rating.presentation.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel$submitRating$1", f = "RatingFeedBackViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class RatingFeedBackViewModel$submitRating$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f58711h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RatingFeedBackViewModel f58712i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingFeedBackViewModel$submitRating$1(RatingFeedBackViewModel ratingFeedBackViewModel, Continuation<? super RatingFeedBackViewModel$submitRating$1> continuation) {
        super(2, continuation);
        this.f58712i = ratingFeedBackViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RatingFeedBackViewModel$submitRating$1 ratingFeedBackViewModel$submitRating$1 = new RatingFeedBackViewModel$submitRating$1(this.f58712i, continuation);
        ratingFeedBackViewModel$submitRating$1.L$0 = obj;
        return ratingFeedBackViewModel$submitRating$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RatingFeedBackViewModel$submitRating$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f58711h
            r2 = 1
            if (r1 == 0) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            java.lang.Object r0 = r4.L$0
            com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel r0 = (com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0013 }
            goto L_0x0044
        L_0x0013:
            r5 = move-exception
            goto L_0x004d
        L_0x0015:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel r5 = r4.f58712i
            com.talabat.feature.rating.domain.RatingDataManager r5 = r5.ratingDataManager
            com.talabat.feature.rating.domain.model.RateOrderRequest r5 = r5.getRateOrderRequest()
            if (r5 == 0) goto L_0x0086
            com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel r1 = r4.f58712i
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x004b }
            com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository r3 = r1.submitFeedBackRepository     // Catch:{ all -> 0x004b }
            r4.L$0 = r1     // Catch:{ all -> 0x004b }
            r4.f58711h = r2     // Catch:{ all -> 0x004b }
            java.lang.Object r5 = r3.submitFeedback(r5, r4)     // Catch:{ all -> 0x004b }
            if (r5 != r0) goto L_0x0043
            return r0
        L_0x0043:
            r0 = r1
        L_0x0044:
            com.talabat.feature.rating.domain.model.RateOrderResponse r5 = (com.talabat.feature.rating.domain.model.RateOrderResponse) r5     // Catch:{ all -> 0x0013 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0013 }
            goto L_0x0057
        L_0x004b:
            r5 = move-exception
            r0 = r1
        L_0x004d:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0057:
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r5)
            if (r1 == 0) goto L_0x0072
            r1 = r5
            com.talabat.feature.rating.domain.model.RateOrderResponse r1 = (com.talabat.feature.rating.domain.model.RateOrderResponse) r1
            com.talabat.feature.rating.domain.RatingDataManager r1 = r0.ratingDataManager
            r1.clear()
            androidx.lifecycle.MutableLiveData r1 = r0._isRatingSuccess
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r1.postValue(r3)
        L_0x0072:
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r5 == 0) goto L_0x0086
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent r0 = r0._isRatingError
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r0.postValue(r1)
            com.talabat.talabatcore.logger.LogManager.logException(r5)
        L_0x0086:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel$submitRating$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
