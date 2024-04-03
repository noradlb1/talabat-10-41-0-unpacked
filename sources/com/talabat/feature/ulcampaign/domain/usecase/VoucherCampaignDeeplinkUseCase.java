package com.talabat.feature.ulcampaign.domain.usecase;

import com.talabat.feature.ulcampaign.domain.CampaignMigratorRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignDeeplinkUseCase;", "", "repository", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorRepository;", "(Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorRepository;)V", "invoke", "", "array", "", "", "([Ljava/lang/String;)Z", "com_talabat_feature_ul-campaign_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherCampaignDeeplinkUseCase {
    @NotNull
    private final CampaignMigratorRepository repository;

    @Inject
    public VoucherCampaignDeeplinkUseCase(@NotNull CampaignMigratorRepository campaignMigratorRepository) {
        Intrinsics.checkNotNullParameter(campaignMigratorRepository, "repository");
        this.repository = campaignMigratorRepository;
    }

    public final boolean invoke(@Nullable String[] strArr) {
        return this.repository.handleDeeplinkVoucherCampaign(strArr);
    }
}
