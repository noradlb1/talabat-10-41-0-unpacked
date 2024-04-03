package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker;
import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimTrackingUseCase;", "", "repository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "reminderRepository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;", "tracker", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;", "(Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;)V", "trackClaimClicked", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackHomeWidgetShown", "trackOpenTMartClicked", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "(Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackReminderWidgetShown", "title", "", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimTrackingUseCase {
    @NotNull
    private final ITMartGrowthReminderRepository reminderRepository;
    @NotNull
    private final ITMartGrowthRepository repository;
    @NotNull
    private final ITMartGrowthTracker tracker;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TMartGrowthScreenType.values().length];
            iArr[TMartGrowthScreenType.HOME.ordinal()] = 1;
            iArr[TMartGrowthScreenType.ORDER_CONFIRMATION.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public TMartGrowthClaimTrackingUseCase(@NotNull ITMartGrowthRepository iTMartGrowthRepository, @NotNull ITMartGrowthReminderRepository iTMartGrowthReminderRepository, @NotNull ITMartGrowthTracker iTMartGrowthTracker) {
        Intrinsics.checkNotNullParameter(iTMartGrowthRepository, "repository");
        Intrinsics.checkNotNullParameter(iTMartGrowthReminderRepository, "reminderRepository");
        Intrinsics.checkNotNullParameter(iTMartGrowthTracker, "tracker");
        this.repository = iTMartGrowthRepository;
        this.reminderRepository = iTMartGrowthReminderRepository;
        this.tracker = iTMartGrowthTracker;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object trackClaimClicked(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackClaimClicked$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackClaimClicked$1 r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackClaimClicked$1) r0
            int r1 = r0.f59108k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59108k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackClaimClicked$1 r0 = new com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackClaimClicked$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f59106i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59108k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f59105h
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase) r0
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
            r0.f59105h = r4     // Catch:{ all -> 0x0055 }
            r0.f59108k = r3     // Catch:{ all -> 0x0055 }
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
            if (r1 == 0) goto L_0x006e
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r5 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r5
            com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker r0 = r0.tracker
            r0.claimClicked(r5)
        L_0x006e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase.trackClaimClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object trackHomeWidgetShown(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1 r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1) r0
            int r1 = r0.f59112k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59112k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1 r0 = new com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f59110i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59112k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f59109h
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase) r0
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
            r0.f59109h = r4     // Catch:{ all -> 0x0055 }
            r0.f59112k = r3     // Catch:{ all -> 0x0055 }
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
            if (r1 == 0) goto L_0x006e
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r5 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r5
            com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker r0 = r0.tracker
            r0.homeWidgetLoaded(r5)
        L_0x006e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase.trackHomeWidgetShown(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object trackOpenTMartClicked(@org.jetbrains.annotations.NotNull com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1 r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1) r0
            int r1 = r0.f59117l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59117l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1 r0 = new com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f59115j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59117l
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.f59114i
            com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType r5 = (com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType) r5
            java.lang.Object r0 = r0.f59113h
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x006f
        L_0x0031:
            r6 = move-exception
            goto L_0x0078
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            int[] r6 = com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase.WhenMappings.$EnumSwitchMapping$0
            int r2 = r5.ordinal()
            r6 = r6[r2]
            if (r6 == r3) goto L_0x0059
            r0 = 2
            if (r6 != r0) goto L_0x0053
            com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository r6 = r4.reminderRepository
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r6 = r6.getTrackingInfo()
            r0 = r4
            goto L_0x008b
        L_0x0053:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L_0x0059:
            com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository r6 = r4.repository
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.flow.Flow r6 = r6.getTrackingData()     // Catch:{ all -> 0x0076 }
            r0.f59113h = r4     // Catch:{ all -> 0x0076 }
            r0.f59114i = r5     // Catch:{ all -> 0x0076 }
            r0.f59117l = r3     // Catch:{ all -> 0x0076 }
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.first(r6, r0)     // Catch:{ all -> 0x0076 }
            if (r6 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r0 = r4
        L_0x006f:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r6     // Catch:{ all -> 0x0031 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0082
        L_0x0076:
            r6 = move-exception
            r0 = r4
        L_0x0078:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0082:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r6)
            if (r1 == 0) goto L_0x0089
            r6 = 0
        L_0x0089:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo) r6
        L_0x008b:
            if (r6 == 0) goto L_0x0092
            com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker r0 = r0.tracker
            r0.openTMartClicked(r5, r6)
        L_0x0092:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase.trackOpenTMartClicked(com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void trackReminderWidgetShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TMartGrowthTrackingInfo trackingInfo = this.reminderRepository.getTrackingInfo();
        if (trackingInfo != null) {
            this.tracker.reminderWidgetLoaded(str, trackingInfo);
        }
    }
}
