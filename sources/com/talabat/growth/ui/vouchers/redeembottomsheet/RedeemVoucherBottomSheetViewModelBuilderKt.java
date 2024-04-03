package com.talabat.growth.ui.vouchers.redeembottomsheet;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"getRedeemVoucherBottomSheetViewModel", "Lcom/talabat/growth/ui/vouchers/redeembottomsheet/RedeemVoucherBottomSheetViewModel;", "context", "Landroid/content/Context;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherBottomSheetViewModelBuilderKt {
    @NotNull
    public static final RedeemVoucherBottomSheetViewModel getRedeemVoucherBottomSheetViewModel(@NotNull Context context, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull IObservabilityManager iObservabilityManager, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        RedeemVoucherCodeUseCase redeemVoucherCodeUseCase = new RedeemVoucherCodeUseCase(new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())), (GrowthTracker) null, iTalabatFeatureFlag, 2, (DefaultConstructorMarker) null);
        return new RedeemVoucherBottomSheetViewModel(context, redeemVoucherCodeUseCase, new GuestVoucherDetailsUseCase(new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())), iObservabilityManager), configurationLocalRepository, RedeemVoucherBottomSheetViewModelBuilderKt$getRedeemVoucherBottomSheetViewModel$1.INSTANCE, Dispatchers.getIO());
    }
}
