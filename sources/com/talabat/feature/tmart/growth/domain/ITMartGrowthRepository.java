package com.talabat.feature.tmart.growth.domain;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthLoaderData;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H&J\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "", "claimInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo;", "getClaimInfo", "()Lkotlinx/coroutines/flow/Flow;", "loaderData", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthLoaderData;", "getLoaderData", "trackingData", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "getTrackingData", "claimVoucher", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimConfirmation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshVoucher", "", "triggerGettingVoucher", "voucherId", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthVoucherId;", "triggerGettingVoucher-99KcVpk", "(Ljava/lang/String;)V", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITMartGrowthRepository {
    @Nullable
    Object claimVoucher(@NotNull Continuation<? super TMartGrowthClaimConfirmation> continuation);

    @NotNull
    Flow<TMartGrowthClaimInfo> getClaimInfo();

    @NotNull
    Flow<TMartGrowthLoaderData> getLoaderData();

    @NotNull
    Flow<TMartGrowthTrackingInfo> getTrackingData();

    void refreshVoucher();

    /* renamed from: triggerGettingVoucher-99KcVpk  reason: not valid java name */
    void m10299triggerGettingVoucher99KcVpk(@NotNull String str);
}
