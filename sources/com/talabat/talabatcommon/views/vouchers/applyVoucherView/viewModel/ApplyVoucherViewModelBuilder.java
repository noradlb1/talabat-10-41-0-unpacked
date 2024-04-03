package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModelBuilder;", "", "()V", "getApplyVoucherViewModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModelImpl;", "context", "Landroid/content/Context;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewModelBuilder {
    @NotNull
    public static final ApplyVoucherViewModelBuilder INSTANCE = new ApplyVoucherViewModelBuilder();

    private ApplyVoucherViewModelBuilder() {
    }

    @NotNull
    public final ApplyVoucherViewModelImpl getApplyVoucherViewModel(@NotNull Context context, @NotNull TalabatTracker talabatTracker, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Context context2 = context;
        TalabatTracker talabatTracker2 = talabatTracker;
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        return new ApplyVoucherViewModelImpl(ApplyVoucherViewModelBuilderKt.getPossibleVouchersUseCase(context2, iTalabatFeatureFlag2), ApplyVoucherViewModelBuilderKt.getApplyVoucherUseCase(context2, iTalabatFeatureFlag2), ApplyVoucherViewModelBuilderKt.getUnApplyAllVoucherUseCase(context), ApplyVoucherViewModelBuilderKt.getRedeemVoucherUseCase(context2, talabatTracker2, configurationLocalRepository2), ApplyVoucherViewModelBuilderKt.getIsBasketVouchersEnabled(context2, iTalabatFeatureFlag2), ApplyVoucherViewModelBuilderKt.getIsVouchersEnabledInTmartUseCase(context2, iTalabatFeatureFlag2), ApplyVoucherViewModelBuilderKt.getIsVoucherCodesEnabled(context2, iTalabatFeatureFlag2), ApplyVoucherViewModelBuilderKt.getAddVoucherCodeUseCase(context, talabatTracker, iTalabatFeatureFlag), ApplyVoucherViewModelBuilderKt.getPossibleBinRestrictedVoucherUseCase(context2, iTalabatFeatureFlag2), ApplyVoucherViewModelBuilder$getApplyVoucherViewModel$1.INSTANCE, ApplyVoucherViewModelBuilder$getApplyVoucherViewModel$2.INSTANCE, Dispatchers.getIO(), iTalabatFeatureFlag2);
    }
}
