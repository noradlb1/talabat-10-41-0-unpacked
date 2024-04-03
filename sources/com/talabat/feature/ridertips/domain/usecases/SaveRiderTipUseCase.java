package com.talabat.feature.ridertips.domain.usecases;

import com.talabat.feature.ridertips.domain.IRiderTipObservability;
import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/ridertips/domain/usecases/SaveRiderTipUseCase;", "", "repository", "Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;", "riderTipObservability", "Lcom/talabat/feature/ridertips/domain/IRiderTipObservability;", "(Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;Lcom/talabat/feature/ridertips/domain/IRiderTipObservability;)V", "saveRiderTip", "", "amount", "", "saveTip", "", "(Ljava/lang/Double;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SaveRiderTipUseCase {
    @NotNull
    private final IRiderTipRepository repository;
    @NotNull
    private final IRiderTipObservability riderTipObservability;

    @Inject
    public SaveRiderTipUseCase(@NotNull IRiderTipRepository iRiderTipRepository, @NotNull IRiderTipObservability iRiderTipObservability) {
        Intrinsics.checkNotNullParameter(iRiderTipRepository, "repository");
        Intrinsics.checkNotNullParameter(iRiderTipObservability, "riderTipObservability");
        this.repository = iRiderTipRepository;
        this.riderTipObservability = iRiderTipObservability;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveRiderTip(@org.jetbrains.annotations.Nullable java.lang.Double r5, boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase$saveRiderTip$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase$saveRiderTip$1 r0 = (com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase$saveRiderTip$1) r0
            int r1 = r0.f58802k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58802k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase$saveRiderTip$1 r0 = new com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase$saveRiderTip$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f58800i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58802k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f58799h
            com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase r5 = (com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r6 = move-exception
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0056 }
            com.talabat.feature.ridertips.domain.IRiderTipRepository r7 = r4.repository     // Catch:{ all -> 0x0056 }
            if (r6 != 0) goto L_0x0042
            r6 = r3
            goto L_0x0043
        L_0x0042:
            r6 = 0
        L_0x0043:
            r0.f58799h = r4     // Catch:{ all -> 0x0056 }
            r0.f58802k = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r5 = r7.saveRiderTip(r5, r6, r0)     // Catch:{ all -> 0x0056 }
            if (r5 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r5 = r4
        L_0x004f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0062
        L_0x0056:
            r6 = move-exception
            r5 = r4
        L_0x0058:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0062:
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r6 == 0) goto L_0x0081
            com.talabat.feature.ridertips.domain.IRiderTipObservability r5 = r5.riderTipObservability
            java.lang.String r6 = r6.getMessage()
            if (r6 != 0) goto L_0x0072
            java.lang.String r6 = ""
        L_0x0072:
            java.lang.String r7 = "error"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r7, r6)
            java.util.Map r6 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r6)
            java.lang.String r7 = "SaveRiderTip"
            r5.observeUnexpectedScenario(r7, r6)
        L_0x0081:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase.saveRiderTip(java.lang.Double, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
