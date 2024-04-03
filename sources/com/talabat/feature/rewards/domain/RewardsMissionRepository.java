package com.talabat.feature.rewards.domain;

import com.talabat.feature.rewards.domain.model.Mission;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\nJ<\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/rewards/domain/RewardsMissionRepository;", "", "acceptMissionReward", "Lkotlin/Result;", "", "missionId", "", "screen", "", "acceptMissionReward-0E7RQCE", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "claimMissionReward", "claimMissionReward-0E7RQCE", "getMissions", "", "Lcom/talabat/feature/rewards/domain/model/Mission;", "chainId", "getMissions-0E7RQCE", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RewardsMissionRepository {
    @Nullable
    /* renamed from: acceptMissionReward-0E7RQCE  reason: not valid java name */
    Object m10277acceptMissionReward0E7RQCE(int i11, @Nullable String str, @NotNull Continuation<? super Result<Unit>> continuation);

    @Nullable
    /* renamed from: claimMissionReward-0E7RQCE  reason: not valid java name */
    Object m10278claimMissionReward0E7RQCE(int i11, @Nullable String str, @NotNull Continuation<? super Result<Unit>> continuation);

    @Nullable
    /* renamed from: getMissions-0E7RQCE  reason: not valid java name */
    Object m10279getMissions0E7RQCE(@Nullable Integer num, @Nullable String str, @NotNull Continuation<? super Result<? extends List<Mission>>> continuation);
}
