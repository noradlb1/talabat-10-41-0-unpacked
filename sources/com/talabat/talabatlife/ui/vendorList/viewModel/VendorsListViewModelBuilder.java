package com.talabat.talabatlife.ui.vendorList.viewModel;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.network.endpoint.TLifeEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.data.DomainEntityMapper;
import com.talabat.talabatlife.data.FilterRepo;
import com.talabat.talabatlife.data.remote.FiltersRemoteDataSource;
import com.talabat.talabatlife.domain.usecases.GetFiltersUseCase;
import com.talabat.talabatlife.features.vendors.GetVendorsAreas;
import com.talabat.talabatlife.features.vendors.GetVendorsList;
import com.talabat.talabatlife.features.vendors.network.VendorsService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModelBuilder$Companion;", "", "()V", "getVendorListViewModel", "Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModelImpl;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VendorsListViewModelImpl getVendorListViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            return new VendorsListViewModelImpl(new GetVendorsList(new NetworkHandler(context), new VendorsService(new TalabatAPIBuilder()), coroutineScope, Dispatchers.getMain()), new GetVendorsAreas(new NetworkHandler(context), new VendorsService(new TalabatAPIBuilder()), coroutineScope, Dispatchers.getMain()), new GetFiltersUseCase(new FilterRepo(new FiltersRemoteDataSource(new TalabatAPIBuilder(), TLifeEndPointProvider.INSTANCE.getBaseUrl()), new DomainEntityMapper()), coroutineScope, Dispatchers.getMain()), configurationLocalRepository);
        }
    }
}
