package com.talabat.growth.ui.loyalty.burn.list.viewModel;

import android.content.Context;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.features.matketPlace.FilterBurnItems;
import com.talabat.growth.features.matketPlace.GetBurnCategoryDetails;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceApi;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceService;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/viewModel/FeaturedListViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/viewModel/FeaturedListViewModelBuilder$Companion;", "", "()V", "getFeaturedListViewModel", "Lcom/talabat/growth/ui/loyalty/burn/list/viewModel/FeaturedListViewModel;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeaturedListViewModel getFeaturedListViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            return new FeaturedListViewModelImpl(new GetBurnCategoryDetails(new NetworkHandler(context), new MarketPlaceService((MarketPlaceApi) null, 1, (DefaultConstructorMarker) null), locationConfigurationRepository, coroutineScope, Dispatchers.getMain()), new FilterBurnItems(coroutineScope, Dispatchers.getMain(), iTalabatFeatureFlag), new BurnOptionDetailsNavigator(coroutineScope, Dispatchers.getMain(), (RemoteConfiguration) null, 4, (DefaultConstructorMarker) null));
        }
    }
}
