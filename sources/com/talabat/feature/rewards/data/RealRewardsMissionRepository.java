package com.talabat.feature.rewards.data;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.rewards.data.remote.RewardsMissionApi;
import com.talabat.feature.rewards.domain.RewardsMissionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ<\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rewards/data/RealRewardsMissionRepository;", "Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;", "api", "Lcom/talabat/feature/rewards/data/remote/RewardsMissionApi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/feature/rewards/data/remote/RewardsMissionApi;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "acceptMissionReward", "Lkotlin/Result;", "", "missionId", "", "screen", "", "acceptMissionReward-0E7RQCE", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "claimMissionReward", "claimMissionReward-0E7RQCE", "getMissions", "", "Lcom/talabat/feature/rewards/domain/model/Mission;", "chainId", "getMissions-0E7RQCE", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealRewardsMissionRepository implements RewardsMissionRepository {
    @NotNull
    private final RewardsMissionApi api;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;

    @Inject
    public RealRewardsMissionRepository(@NotNull RewardsMissionApi rewardsMissionApi, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(rewardsMissionApi, "api");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.api = rewardsMissionApi;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: acceptMissionReward-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m10274acceptMissionReward0E7RQCE(int r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.feature.rewards.data.RealRewardsMissionRepository$acceptMissionReward$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.rewards.data.RealRewardsMissionRepository$acceptMissionReward$1 r0 = (com.talabat.feature.rewards.data.RealRewardsMissionRepository$acceptMissionReward$1) r0
            int r1 = r0.f58742j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58742j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rewards.data.RealRewardsMissionRepository$acceptMissionReward$1 r0 = new com.talabat.feature.rewards.data.RealRewardsMissionRepository$acceptMissionReward$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f58740h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58742j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0052 }
            goto L_0x004b
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0052 }
            com.talabat.configuration.ConfigurationLocalRepository r7 = r4.configurationLocalRepository     // Catch:{ all -> 0x0052 }
            com.talabat.configuration.country.Country r7 = r7.selectedCountry()     // Catch:{ all -> 0x0052 }
            int r7 = r7.getCountryId()     // Catch:{ all -> 0x0052 }
            com.talabat.feature.rewards.data.remote.RewardsMissionApi r2 = r4.api     // Catch:{ all -> 0x0052 }
            r0.f58742j = r3     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = r2.acceptMission(r7, r5, r6, r0)     // Catch:{ all -> 0x0052 }
            if (r5 != r1) goto L_0x004b
            return r1
        L_0x004b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0052 }
            goto L_0x005d
        L_0x0052:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x005d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.RealRewardsMissionRepository.m10274acceptMissionReward0E7RQCE(int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: claimMissionReward-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m10275claimMissionReward0E7RQCE(int r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.feature.rewards.data.RealRewardsMissionRepository$claimMissionReward$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.rewards.data.RealRewardsMissionRepository$claimMissionReward$1 r0 = (com.talabat.feature.rewards.data.RealRewardsMissionRepository$claimMissionReward$1) r0
            int r1 = r0.f58745j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58745j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rewards.data.RealRewardsMissionRepository$claimMissionReward$1 r0 = new com.talabat.feature.rewards.data.RealRewardsMissionRepository$claimMissionReward$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f58743h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58745j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0052 }
            goto L_0x004b
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0052 }
            com.talabat.configuration.ConfigurationLocalRepository r7 = r4.configurationLocalRepository     // Catch:{ all -> 0x0052 }
            com.talabat.configuration.country.Country r7 = r7.selectedCountry()     // Catch:{ all -> 0x0052 }
            int r7 = r7.getCountryId()     // Catch:{ all -> 0x0052 }
            com.talabat.feature.rewards.data.remote.RewardsMissionApi r2 = r4.api     // Catch:{ all -> 0x0052 }
            r0.f58745j = r3     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = r2.claimMissionReward(r7, r5, r6, r0)     // Catch:{ all -> 0x0052 }
            if (r5 != r1) goto L_0x004b
            return r1
        L_0x004b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0052 }
            goto L_0x005d
        L_0x0052:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x005d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.RealRewardsMissionRepository.m10275claimMissionReward0E7RQCE(int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057 A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getMissions-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m10276getMissions0E7RQCE(@org.jetbrains.annotations.Nullable java.lang.Integer r8, @org.jetbrains.annotations.Nullable java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.List<com.talabat.feature.rewards.domain.model.Mission>>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.talabat.feature.rewards.data.RealRewardsMissionRepository$getMissions$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.feature.rewards.data.RealRewardsMissionRepository$getMissions$1 r0 = (com.talabat.feature.rewards.data.RealRewardsMissionRepository$getMissions$1) r0
            int r1 = r0.f58748j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58748j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rewards.data.RealRewardsMissionRepository$getMissions$1 r0 = new com.talabat.feature.rewards.data.RealRewardsMissionRepository$getMissions$1
            r0.<init>(r7, r10)
        L_0x0018:
            r6 = r0
            java.lang.Object r10 = r6.f58746h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f58748j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0068 }
            goto L_0x004f
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            com.talabat.configuration.ConfigurationLocalRepository r10 = r7.configurationLocalRepository     // Catch:{ all -> 0x0068 }
            com.talabat.configuration.country.Country r10 = r10.selectedCountry()     // Catch:{ all -> 0x0068 }
            int r3 = r10.getCountryId()     // Catch:{ all -> 0x0068 }
            com.talabat.feature.rewards.data.remote.RewardsMissionApi r1 = r7.api     // Catch:{ all -> 0x0068 }
            r6.f58748j = r2     // Catch:{ all -> 0x0068 }
            r2 = r3
            r4 = r8
            r5 = r9
            java.lang.Object r10 = r1.getMissions(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0068 }
            if (r10 != r0) goto L_0x004f
            return r0
        L_0x004f:
            com.talabat.feature.rewards.data.remote.dto.RewardsMissionsResponse r10 = (com.talabat.feature.rewards.data.remote.dto.RewardsMissionsResponse) r10     // Catch:{ all -> 0x0068 }
            com.talabat.feature.rewards.data.remote.dto.MissionsResult r8 = r10.getResult()     // Catch:{ all -> 0x0068 }
            if (r8 == 0) goto L_0x005c
            java.util.List r8 = r8.getData()     // Catch:{ all -> 0x0068 }
            goto L_0x005d
        L_0x005c:
            r8 = 0
        L_0x005d:
            if (r8 != 0) goto L_0x0063
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ all -> 0x0068 }
        L_0x0063:
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x0068 }
            goto L_0x0073
        L_0x0068:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x0073:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.RealRewardsMissionRepository.m10276getMissions0E7RQCE(java.lang.Integer, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
