package com.talabat.growth.ui.vouchers.details;

import android.content.Context;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.growth.features.vouchers.domain.GetVoucherDetailsUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"getVoucherDetailsViewModelBuilder", "Lcom/talabat/growth/ui/vouchers/details/VoucherDetailsViewModel;", "context", "Landroid/content/Context;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VoucherDetailsViewModelBuilderKt {
    @NotNull
    public static final VoucherDetailsViewModel getVoucherDetailsViewModelBuilder(@NotNull Context context, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        return new VoucherDetailsViewModel(Dispatchers.getIO(), new GetVoucherDetailsUseCase(new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder()))), iObservabilityManager);
    }
}
