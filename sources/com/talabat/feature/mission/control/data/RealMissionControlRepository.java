package com.talabat.feature.mission.control.data;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.darkstores.DarkstoresFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.mission.control.data.remote.LifeStyleMissionControlApi;
import com.talabat.feature.mission.control.data.remote.PrimaryMissionControlApi;
import com.talabat.feature.mission.control.data.remote.mapper.LifeStyleMissionControlMapper;
import com.talabat.feature.mission.control.data.remote.mapper.PrimaryMissionControlMapper;
import com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse;
import com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponseData;
import com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponseData;
import com.talabat.feature.mission.control.domain.MissionControlRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0016\u0010\"\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0016\u0010$\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020%0 H\u0002J\u0016\u0010&\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020%0 H\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001bH\u0002J\f\u0010.\u001a\u00020/*\u00020/H\u0002J\f\u0010.\u001a\u000200*\u000200H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/talabat/feature/mission/control/data/RealMissionControlRepository;", "Lcom/talabat/feature/mission/control/domain/MissionControlRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "lifeStyleMissionControlMapper", "Lcom/talabat/feature/mission/control/data/remote/mapper/LifeStyleMissionControlMapper;", "lifeStyleMissionControlApi", "Lcom/talabat/feature/mission/control/data/remote/LifeStyleMissionControlApi;", "primaryMissionControlApi", "Lcom/talabat/feature/mission/control/data/remote/PrimaryMissionControlApi;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "primaryMissionControlMapper", "Lcom/talabat/feature/mission/control/data/remote/mapper/PrimaryMissionControlMapper;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/feature/mission/control/data/remote/mapper/LifeStyleMissionControlMapper;Lcom/talabat/feature/mission/control/data/remote/LifeStyleMissionControlApi;Lcom/talabat/feature/mission/control/data/remote/PrimaryMissionControlApi;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/feature/mission/control/data/remote/mapper/PrimaryMissionControlMapper;)V", "getLifeStyleMissionControls", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "request", "Lcom/talabat/feature/mission/control/domain/model/MissionControlRequest;", "(Lcom/talabat/feature/mission/control/domain/model/MissionControlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrimaryMissionControls", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControl;", "getPrimaryMissionMaxCount", "", "isLifeStyleMissionEnabled", "", "isLifeStyleMissionMoreThanMax", "missions", "", "Lcom/talabat/feature/mission/control/data/remote/model/LifeStyleMissionControlResponseData;", "isLifeStyleMissionResponseInvalid", "isPrimaryMissionEnabled", "isPrimaryMissionMoreThanMax", "Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponseData;", "isPrimaryMissionResponseInvalid", "isPrimaryMissionTwoTiles", "tracObservabilityEvent", "", "eventName", "", "vendorId", "count", "trim", "Lcom/talabat/feature/mission/control/data/remote/model/LifeStyleMissionControlResponse;", "Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponse;", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealMissionControlRepository implements MissionControlRepository {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final LifeStyleMissionControlApi lifeStyleMissionControlApi;
    @NotNull
    private final LifeStyleMissionControlMapper lifeStyleMissionControlMapper;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PrimaryMissionControlApi primaryMissionControlApi;
    @NotNull
    private final PrimaryMissionControlMapper primaryMissionControlMapper;
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Inject
    public RealMissionControlRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull LifeStyleMissionControlMapper lifeStyleMissionControlMapper2, @NotNull LifeStyleMissionControlApi lifeStyleMissionControlApi2, @NotNull PrimaryMissionControlApi primaryMissionControlApi2, @NotNull IObservabilityManager iObservabilityManager, @NotNull PrimaryMissionControlMapper primaryMissionControlMapper2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(lifeStyleMissionControlMapper2, "lifeStyleMissionControlMapper");
        Intrinsics.checkNotNullParameter(lifeStyleMissionControlApi2, "lifeStyleMissionControlApi");
        Intrinsics.checkNotNullParameter(primaryMissionControlApi2, "primaryMissionControlApi");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(primaryMissionControlMapper2, "primaryMissionControlMapper");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.featureFlag = iTalabatFeatureFlag;
        this.talabatExperiment = iTalabatExperiment;
        this.lifeStyleMissionControlMapper = lifeStyleMissionControlMapper2;
        this.lifeStyleMissionControlApi = lifeStyleMissionControlApi2;
        this.primaryMissionControlApi = primaryMissionControlApi2;
        this.observabilityManager = iObservabilityManager;
        this.primaryMissionControlMapper = primaryMissionControlMapper2;
    }

    private final int getPrimaryMissionMaxCount() {
        return isPrimaryMissionTwoTiles() ? 2 : 3;
    }

    private final boolean isLifeStyleMissionEnabled() {
        return this.featureFlag.getFeatureFlag(DarkstoresFeatureFlagConstants.DARKSTORE_VLP_LIFESTYLE_MISSION_CONTROL, false);
    }

    private final boolean isLifeStyleMissionMoreThanMax(List<LifeStyleMissionControlResponseData> list) {
        return list.size() > 2;
    }

    private final boolean isLifeStyleMissionResponseInvalid(List<LifeStyleMissionControlResponseData> list) {
        return list.isEmpty();
    }

    private final boolean isPrimaryMissionEnabled() {
        return this.featureFlag.getFeatureFlag(DarkstoresFeatureFlagConstants.DARKSTORE_VLP_PRIMARY_MISSION_CONTROL, false);
    }

    private final boolean isPrimaryMissionMoreThanMax(List<PrimaryMissionControlResponseData> list) {
        if (list.size() > getPrimaryMissionMaxCount()) {
            return true;
        }
        return false;
    }

    private final boolean isPrimaryMissionResponseInvalid(List<PrimaryMissionControlResponseData> list) {
        return list.size() < 2;
    }

    private final boolean isPrimaryMissionTwoTiles() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_FAST_PRIMARY_MISSION_TWO_TILES, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    private final void tracObservabilityEvent(String str, String str2, int i11) {
        this.observabilityManager.track(str, "DarkstoreEvents", MapsKt__MapsKt.mapOf(TuplesKt.to("vendorID", str2), TuplesKt.to("count", String.valueOf(i11))));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = r1.getMissions();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse trim(com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse r4) {
        /*
            r3 = this;
            int r0 = r3.getPrimaryMissionMaxCount()
            com.talabat.feature.mission.control.data.remote.model.Result r1 = r4.getResult()
            r2 = 0
            if (r1 == 0) goto L_0x0018
            java.util.List r1 = r1.getMissions()
            if (r1 == 0) goto L_0x0018
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.take(r1, r0)
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            com.talabat.feature.mission.control.data.remote.model.Result r1 = r4.getResult()
            if (r1 == 0) goto L_0x0023
            com.talabat.feature.mission.control.data.remote.model.Result r2 = r1.copy(r0)
        L_0x0023:
            com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse r4 = r4.copy(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.mission.control.data.RealMissionControlRepository.trim(com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse):com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getLifeStyleMissionControls(@org.jetbrains.annotations.NotNull com.talabat.feature.mission.control.domain.model.MissionControlRequest r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.talabat.feature.mission.control.data.RealMissionControlRepository$getLifeStyleMissionControls$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.talabat.feature.mission.control.data.RealMissionControlRepository$getLifeStyleMissionControls$1 r0 = (com.talabat.feature.mission.control.data.RealMissionControlRepository$getLifeStyleMissionControls$1) r0
            int r1 = r0.f58574m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58574m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.mission.control.data.RealMissionControlRepository$getLifeStyleMissionControls$1 r0 = new com.talabat.feature.mission.control.data.RealMissionControlRepository$getLifeStyleMissionControls$1
            r0.<init>(r11, r13)
        L_0x0018:
            r8 = r0
            java.lang.Object r13 = r8.f58572k
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f58574m
            r2 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 != r2) goto L_0x003b
            java.lang.Object r12 = r8.f58571j
            com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl r12 = (com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl) r12
            java.lang.Object r0 = r8.f58570i
            com.talabat.feature.mission.control.domain.model.MissionControlRequest r0 = (com.talabat.feature.mission.control.domain.model.MissionControlRequest) r0
            java.lang.Object r1 = r8.f58569h
            com.talabat.feature.mission.control.data.RealMissionControlRepository r1 = (com.talabat.feature.mission.control.data.RealMissionControlRepository) r1
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r13
            r13 = r12
            r12 = r0
            r0 = r1
            r1 = r10
            goto L_0x008b
        L_0x003b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r13)
            com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl r13 = new com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r13.<init>(r1)
            boolean r1 = r11.isLifeStyleMissionEnabled()
            if (r1 == 0) goto L_0x00ce
            com.talabat.feature.mission.control.data.remote.LifeStyleMissionControlApi r1 = r11.lifeStyleMissionControlApi
            com.talabat.configuration.ConfigurationLocalRepository r3 = r11.configurationLocalRepository
            com.talabat.configuration.country.Country r3 = r3.selectedCountry()
            java.lang.String r3 = r3.getTwoLetterCode()
            java.lang.String r4 = r12.getVariant()
            java.lang.String r5 = r12.getScreen()
            java.lang.String r6 = r12.getVendorId()
            boolean r7 = r12.isDarkstores()
            java.lang.String r9 = r12.getTalabatBranchId()
            r8.f58569h = r11
            r8.f58570i = r12
            r8.f58571j = r13
            r8.f58574m = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r9
            java.lang.Object r1 = r1.getLifeStyleMissionControls(r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r0) goto L_0x008a
            return r0
        L_0x008a:
            r0 = r11
        L_0x008b:
            com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse r1 = (com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse) r1
            java.util.List r2 = r1.getMissions()
            if (r2 == 0) goto L_0x00ce
            boolean r3 = r0.isLifeStyleMissionResponseInvalid(r2)
            java.lang.String r4 = "LifestyleMissionControlsCountError"
            if (r3 == 0) goto L_0x00a8
            java.lang.String r12 = r12.getVendorId()
            int r1 = r2.size()
            r0.tracObservabilityEvent(r4, r12, r1)
            r12 = r13
            goto L_0x00ca
        L_0x00a8:
            boolean r3 = r0.isLifeStyleMissionMoreThanMax(r2)
            if (r3 == 0) goto L_0x00c4
            java.lang.String r12 = r12.getVendorId()
            int r2 = r2.size()
            r0.tracObservabilityEvent(r4, r12, r2)
            com.talabat.feature.mission.control.data.remote.mapper.LifeStyleMissionControlMapper r12 = r0.lifeStyleMissionControlMapper
            com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse r0 = r0.trim((com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse) r1)
            com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl r12 = r12.apply((com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse) r0)
            goto L_0x00ca
        L_0x00c4:
            com.talabat.feature.mission.control.data.remote.mapper.LifeStyleMissionControlMapper r12 = r0.lifeStyleMissionControlMapper
            com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl r12 = r12.apply((com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse) r1)
        L_0x00ca:
            if (r12 != 0) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            r13 = r12
        L_0x00ce:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.mission.control.data.RealMissionControlRepository.getLifeStyleMissionControls(com.talabat.feature.mission.control.domain.model.MissionControlRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getPrimaryMissionControls(@org.jetbrains.annotations.NotNull com.talabat.feature.mission.control.domain.model.MissionControlRequest r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.mission.control.domain.model.PrimaryMissionControl> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.talabat.feature.mission.control.data.RealMissionControlRepository$getPrimaryMissionControls$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.feature.mission.control.data.RealMissionControlRepository$getPrimaryMissionControls$1 r0 = (com.talabat.feature.mission.control.data.RealMissionControlRepository$getPrimaryMissionControls$1) r0
            int r1 = r0.f58580m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58580m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.mission.control.data.RealMissionControlRepository$getPrimaryMissionControls$1 r0 = new com.talabat.feature.mission.control.data.RealMissionControlRepository$getPrimaryMissionControls$1
            r0.<init>(r9, r11)
        L_0x0018:
            r6 = r0
            java.lang.Object r11 = r6.f58578k
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f58580m
            r2 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 != r2) goto L_0x003b
            java.lang.Object r10 = r6.f58577j
            com.talabat.feature.mission.control.domain.model.PrimaryMissionControl r10 = (com.talabat.feature.mission.control.domain.model.PrimaryMissionControl) r10
            java.lang.Object r0 = r6.f58576i
            com.talabat.feature.mission.control.domain.model.MissionControlRequest r0 = (com.talabat.feature.mission.control.domain.model.MissionControlRequest) r0
            java.lang.Object r1 = r6.f58575h
            com.talabat.feature.mission.control.data.RealMissionControlRepository r1 = (com.talabat.feature.mission.control.data.RealMissionControlRepository) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r11
            r11 = r10
            r10 = r0
            r0 = r1
            r1 = r8
            goto L_0x0081
        L_0x003b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r11)
            com.talabat.feature.mission.control.domain.model.PrimaryMissionControl r11 = new com.talabat.feature.mission.control.domain.model.PrimaryMissionControl
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r11.<init>(r1)
            boolean r1 = r9.isPrimaryMissionEnabled()
            if (r1 == 0) goto L_0x00ca
            com.talabat.feature.mission.control.data.remote.PrimaryMissionControlApi r1 = r9.primaryMissionControlApi
            com.talabat.configuration.ConfigurationLocalRepository r3 = r9.configurationLocalRepository
            com.talabat.configuration.country.Country r3 = r3.selectedCountry()
            java.lang.String r3 = r3.getTwoLetterCode()
            java.lang.String r4 = r10.getVendorId()
            java.lang.String r5 = r10.getTalabatBranchId()
            boolean r7 = r10.isDarkstores()
            r6.f58575h = r9
            r6.f58576i = r10
            r6.f58577j = r11
            r6.f58580m = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            java.lang.Object r1 = r1.getPrimaryMissionControls(r2, r3, r4, r5, r6)
            if (r1 != r0) goto L_0x0080
            return r0
        L_0x0080:
            r0 = r9
        L_0x0081:
            com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse r1 = (com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse) r1
            com.talabat.feature.mission.control.data.remote.model.Result r2 = r1.getResult()
            if (r2 == 0) goto L_0x00ca
            java.util.List r2 = r2.getMissions()
            if (r2 == 0) goto L_0x00ca
            boolean r3 = r0.isPrimaryMissionResponseInvalid(r2)
            java.lang.String r4 = "PrimaryMissionControlsCountError"
            if (r3 == 0) goto L_0x00a4
            java.lang.String r10 = r10.getVendorId()
            int r1 = r2.size()
            r0.tracObservabilityEvent(r4, r10, r1)
            r10 = r11
            goto L_0x00c6
        L_0x00a4:
            boolean r3 = r0.isPrimaryMissionMoreThanMax(r2)
            if (r3 == 0) goto L_0x00c0
            java.lang.String r10 = r10.getVendorId()
            int r2 = r2.size()
            r0.tracObservabilityEvent(r4, r10, r2)
            com.talabat.feature.mission.control.data.remote.mapper.PrimaryMissionControlMapper r10 = r0.primaryMissionControlMapper
            com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse r0 = r0.trim((com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse) r1)
            com.talabat.feature.mission.control.domain.model.PrimaryMissionControl r10 = r10.apply((com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse) r0)
            goto L_0x00c6
        L_0x00c0:
            com.talabat.feature.mission.control.data.remote.mapper.PrimaryMissionControlMapper r10 = r0.primaryMissionControlMapper
            com.talabat.feature.mission.control.domain.model.PrimaryMissionControl r10 = r10.apply((com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse) r1)
        L_0x00c6:
            if (r10 != 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r11 = r10
        L_0x00ca:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.mission.control.data.RealMissionControlRepository.getPrimaryMissionControls(com.talabat.feature.mission.control.domain.model.MissionControlRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final LifeStyleMissionControlResponse trim(LifeStyleMissionControlResponse lifeStyleMissionControlResponse) {
        List<LifeStyleMissionControlResponseData> missions = lifeStyleMissionControlResponse.getMissions();
        return lifeStyleMissionControlResponse.copy(missions != null ? CollectionsKt___CollectionsKt.take(missions, 2) : null);
    }
}
