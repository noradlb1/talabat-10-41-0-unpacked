package com.talabat.feature.tmart.growth.domain.confirmation;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/confirmation/TMartGrowthConfirmationTrackingUseCase;", "", "repository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "tracker", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;", "(Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;)V", "trackOpenTMartClicked", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackPreferenceSelected", "preference", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthSelectedPreference;", "(Lcom/talabat/feature/tmart/growth/domain/TMartGrowthSelectedPreference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthConfirmationTrackingUseCase {
    @NotNull
    private final ITMartGrowthRepository repository;
    @NotNull
    private final ITMartGrowthTracker tracker;

    @Inject
    public TMartGrowthConfirmationTrackingUseCase(@NotNull ITMartGrowthRepository iTMartGrowthRepository, @NotNull ITMartGrowthTracker iTMartGrowthTracker) {
        Intrinsics.checkNotNullParameter(iTMartGrowthRepository, "repository");
        Intrinsics.checkNotNullParameter(iTMartGrowthTracker, "tracker");
        this.repository = iTMartGrowthRepository;
        this.tracker = iTMartGrowthTracker;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object trackOpenTMartClicked(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1 r0 = (com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1) r0
            int r1 = r0.f59131k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59131k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1 r0 = new com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f59129i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59131k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f59128h
            com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase r0 = (com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x004e
        L_0x002d:
            r5 = move-exception
            goto L_0x0057
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository r5 = r4.repository
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0055 }
            kotlinx.coroutines.flow.Flow r5 = r5.getTrackingData()     // Catch:{ all -> 0x0055 }
            r0.f59128h = r4     // Catch:{ all -> 0x0055 }
            r0.f59131k = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.first(r5, r0)     // Catch:{ all -> 0x0055 }
            if (r5 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r4
        L_0x004e:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r5 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r5     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0061
        L_0x0055:
            r5 = move-exception
            r0 = r4
        L_0x0057:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0061:
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r5)
            if (r1 == 0) goto L_0x0070
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r5 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r5
            com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker r0 = r0.tracker
            com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType r1 = com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType.HOME
            r0.shopNowClicked(r1, r5)
        L_0x0070:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase.trackOpenTMartClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object trackPreferenceSelected(@org.jetbrains.annotations.NotNull com.talabat.feature.tmart.growth.domain.TMartGrowthSelectedPreference r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1 r0 = (com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1) r0
            int r1 = r0.f59136l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59136l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1 r0 = new com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f59134j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59136l
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.f59133i
            com.talabat.feature.tmart.growth.domain.TMartGrowthSelectedPreference r5 = (com.talabat.feature.tmart.growth.domain.TMartGrowthSelectedPreference) r5
            java.lang.Object r0 = r0.f59132h
            com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase r0 = (com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0054
        L_0x0031:
            r6 = move-exception
            goto L_0x005d
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository r6 = r4.repository
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            kotlinx.coroutines.flow.Flow r6 = r6.getTrackingData()     // Catch:{ all -> 0x005b }
            r0.f59132h = r4     // Catch:{ all -> 0x005b }
            r0.f59133i = r5     // Catch:{ all -> 0x005b }
            r0.f59136l = r3     // Catch:{ all -> 0x005b }
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.first(r6, r0)     // Catch:{ all -> 0x005b }
            if (r6 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r4
        L_0x0054:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r6     // Catch:{ all -> 0x0031 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0067
        L_0x005b:
            r6 = move-exception
            r0 = r4
        L_0x005d:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0067:
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r6)
            if (r1 == 0) goto L_0x0074
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r6
            com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker r0 = r0.tracker
            r0.preferenceSelected(r5, r6)
        L_0x0074:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase.trackPreferenceSelected(com.talabat.feature.tmart.growth.domain.TMartGrowthSelectedPreference, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
