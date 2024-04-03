package com.talabat.growth.ui.vouchers.list.viewModel;

import android.app.Activity;
import android.app.Application;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.growth.features.vouchers.GetVouchersList;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/viewModel/VouchersListViewModelBuilder;", "", "()V", "getVouchersListViewModel", "Lcom/talabat/growth/ui/vouchers/list/viewModel/VouchersListViewModel;", "context", "Landroid/app/Activity;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListViewModelBuilder {
    @NotNull
    public static final VouchersListViewModelBuilder INSTANCE = new VouchersListViewModelBuilder();

    private VouchersListViewModelBuilder() {
    }

    @NotNull
    public final VouchersListViewModel getVouchersListViewModel(@NotNull Activity activity, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        GetVouchersList getVouchersList = new GetVouchersList(new NetworkHandler(activity), new VouchersService(new TalabatAPIBuilder()), coroutineScope, Dispatchers.getMain());
        VoucherRepositoryImpl voucherRepositoryImpl = new VoucherRepositoryImpl(new NetworkHandler(activity), new VouchersService(new TalabatAPIBuilder()));
        Application application = activity.getApplication();
        if (application != null) {
            RedeemVoucherCodeUseCase redeemVoucherCodeUseCase = new RedeemVoucherCodeUseCase(voucherRepositoryImpl, (GrowthTracker) null, ((FeatureFlagCoreLibApi) ((ApiContainer) application).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag(), 2, (DefaultConstructorMarker) null);
            Application application2 = activity.getApplication();
            if (application2 != null) {
                return new VouchersListViewModelImpl(getVouchersList, redeemVoucherCodeUseCase, ((ConfigurationLocalCoreLibApi) ((ApiContainer) application2).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository(), (CoroutineDispatcher) null, 8, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }
}
