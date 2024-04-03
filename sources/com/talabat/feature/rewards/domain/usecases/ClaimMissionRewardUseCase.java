package com.talabat.feature.rewards.domain.usecases;

import com.talabat.feature.rewards.domain.RewardsMissionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/rewards/domain/usecases/ClaimMissionRewardUseCase;", "", "repository", "Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;", "(Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;)V", "claimMissionReward", "Lkotlin/Result;", "", "missionId", "", "screen", "", "claimMissionReward-0E7RQCE", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClaimMissionRewardUseCase {
    @NotNull
    private final RewardsMissionRepository repository;

    @Inject
    public ClaimMissionRewardUseCase(@NotNull RewardsMissionRepository rewardsMissionRepository) {
        Intrinsics.checkNotNullParameter(rewardsMissionRepository, "repository");
        this.repository = rewardsMissionRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: claimMissionReward-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m10281claimMissionReward0E7RQCE(int r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase$claimMissionReward$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase$claimMissionReward$1 r0 = (com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase$claimMissionReward$1) r0
            int r1 = r0.f58759j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58759j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase$claimMissionReward$1 r0 = new com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase$claimMissionReward$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f58757h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58759j
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.m6338unboximpl()
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.feature.rewards.domain.RewardsMissionRepository r7 = r4.repository
            r0.f58759j = r3
            java.lang.Object r5 = r7.m10278claimMissionReward0E7RQCE(r5, r6, r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase.m10281claimMissionReward0E7RQCE(int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
