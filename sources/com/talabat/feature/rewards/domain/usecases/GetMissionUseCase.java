package com.talabat.feature.rewards.domain.usecases;

import com.talabat.feature.rewards.domain.RewardsMissionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/rewards/domain/usecases/GetMissionUseCase;", "", "repository", "Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;", "(Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;)V", "getMission", "Lkotlin/Result;", "Lcom/talabat/feature/rewards/domain/model/Mission;", "chainId", "", "screen", "", "getMission-0E7RQCE", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetMissionUseCase {
    @NotNull
    private final RewardsMissionRepository repository;

    @Inject
    public GetMissionUseCase(@NotNull RewardsMissionRepository rewardsMissionRepository) {
        Intrinsics.checkNotNullParameter(rewardsMissionRepository, "repository");
        this.repository = rewardsMissionRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getMission-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m10282getMission0E7RQCE(@org.jetbrains.annotations.Nullable java.lang.Integer r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<com.talabat.feature.rewards.domain.model.Mission>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.feature.rewards.domain.usecases.GetMissionUseCase$getMission$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.rewards.domain.usecases.GetMissionUseCase$getMission$1 r0 = (com.talabat.feature.rewards.domain.usecases.GetMissionUseCase$getMission$1) r0
            int r1 = r0.f58762j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58762j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rewards.domain.usecases.GetMissionUseCase$getMission$1 r0 = new com.talabat.feature.rewards.domain.usecases.GetMissionUseCase$getMission$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f58760h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58762j
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
            r0.f58762j = r3
            java.lang.Object r5 = r7.m10279getMissions0E7RQCE(r5, r6, r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            boolean r6 = kotlin.Result.m6336isSuccessimpl(r5)
            if (r6 == 0) goto L_0x0053
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r5)
            com.talabat.feature.rewards.domain.model.Mission r5 = (com.talabat.feature.rewards.domain.model.Mission) r5
        L_0x0053:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.domain.usecases.GetMissionUseCase.m10282getMission0E7RQCE(java.lang.Integer, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
