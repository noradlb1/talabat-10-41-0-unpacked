package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.growth.features.loyalty.network.VendorService;
import com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel.GetRestaurantUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.MarketPlaceRedeemBurnOptionService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.MarketPlaceRedeemBurnOptionRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModelBuilder$Companion;", "", "()V", "getBurnOptionsDetailsViewModel", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModel;", "context", "Landroid/content/Context;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BurnOptionsDetailsViewModel getBurnOptionsDetailsViewModel(@NotNull Context context, @NotNull TalabatTracker talabatTracker, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull CoroutineScope coroutineScope) {
            Context context2 = context;
            TalabatTracker talabatTracker2 = talabatTracker;
            ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            CoroutineScope coroutineScope2 = coroutineScope;
            Intrinsics.checkNotNullParameter(coroutineScope2, "scope");
            return new BurnOptionsDetailsViewModelImpl(new RedeemVoucherUseCase(Dispatchers.getIO(), new MarketPlaceRedeemBurnOptionRepositoryImpl(new NetworkHandler(context), new MarketPlaceRedeemBurnOptionService(new TalabatAPIBuilder()), configurationLocalRepository), talabatTracker), new GetRestaurantUseCase(new VendorService(new TalabatAPIBuilder()), new NetworkHandler(context), coroutineScope2, (CoroutineDispatcher) null, 8, (DefaultConstructorMarker) null), Dispatchers.getIO());
        }
    }
}
