package com.talabat.feature.tmart.growth.data;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\f\u0010\u0013\u001a\u00020\u0003*\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthReminderRepository;", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;", "countryCode", "", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "tMartGrowthApi", "Lcom/talabat/feature/tmart/growth/data/remote/TMartGrowthApi;", "(Ljava/lang/String;Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/talabat/feature/tmart/growth/data/remote/TMartGrowthApi;)V", "trackingInfo", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "trackingInfoCached", "getVoucherReminder", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "(Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toQuery", "Companion", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthReminderRepository implements ITMartGrowthReminderRepository {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String HOME_SCREEN_TYPE = "home";
    @NotNull
    @Deprecated
    public static final String POE_SCREEN_TYPE = "poe";
    @NotNull
    private final String countryCode;
    @NotNull
    private final IntegrationGlobalDataModel.Companion globalDataModel;
    @NotNull
    private final TMartGrowthApi tMartGrowthApi;
    @Nullable
    private TMartGrowthTrackingInfo trackingInfoCached;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthReminderRepository$Companion;", "", "()V", "HOME_SCREEN_TYPE", "", "POE_SCREEN_TYPE", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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
    public TMartGrowthReminderRepository(@NotNull @Named("countryCode") String str, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull TMartGrowthApi tMartGrowthApi2) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(companion, "globalDataModel");
        Intrinsics.checkNotNullParameter(tMartGrowthApi2, "tMartGrowthApi");
        this.countryCode = str;
        this.globalDataModel = companion;
        this.tMartGrowthApi = tMartGrowthApi2;
    }

    private final String toQuery(TMartGrowthScreenType tMartGrowthScreenType) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[tMartGrowthScreenType.ordinal()];
        if (i11 == 1) {
            return "home";
        }
        if (i11 == 2) {
            return POE_SCREEN_TYPE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public TMartGrowthTrackingInfo getTrackingInfo() {
        return this.trackingInfoCached;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getVoucherReminder(@org.jetbrains.annotations.NotNull com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository$getVoucherReminder$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository$getVoucherReminder$1 r0 = (com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository$getVoucherReminder$1) r0
            int r1 = r0.f59022k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59022k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository$getVoucherReminder$1 r0 = new com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository$getVoucherReminder$1
            r0.<init>(r10, r12)
        L_0x0018:
            r9 = r0
            java.lang.Object r12 = r9.f59020i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f59022k
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r11 = r9.f59019h
            com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository r11 = (com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0060
        L_0x002e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r12)
            com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi r1 = r10.tMartGrowthApi
            java.lang.String r12 = r10.countryCode
            com.integration.IntegrationGlobalDataModel$Companion r3 = r10.globalDataModel
            int r3 = r3.getSelectedAreaId()
            com.integration.IntegrationGlobalDataModel$Companion r4 = r10.globalDataModel
            double r4 = r4.selectedLocationLatitude()
            com.integration.IntegrationGlobalDataModel$Companion r6 = r10.globalDataModel
            double r6 = r6.selectedLocationLongitude()
            java.lang.String r8 = r10.toQuery(r11)
            r9.f59019h = r10
            r9.f59022k = r2
            r2 = r12
            java.lang.Object r12 = r1.getVoucherReminder(r2, r3, r4, r6, r8, r9)
            if (r12 != r0) goto L_0x005f
            return r0
        L_0x005f:
            r11 = r10
        L_0x0060:
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminderResponse r12 = (com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminderResponse) r12
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponse r0 = r12.getTrackingInfo()
            if (r0 == 0) goto L_0x0075
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder r1 = r12.getReminder()
            java.lang.String r1 = r1.getTitle()
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo r0 = com.talabat.feature.tmart.growth.data.convert.TMartGrowthReminderMappersKt.toTrackingInfo(r0, r1)
            goto L_0x0076
        L_0x0075:
            r0 = 0
        L_0x0076:
            r11.trackingInfoCached = r0
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder r11 = r12.getReminder()
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData r11 = com.talabat.feature.tmart.growth.data.convert.TMartGrowthReminderMappersKt.toReminderData(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository.getVoucherReminder(com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
