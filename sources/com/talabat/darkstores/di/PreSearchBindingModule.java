package com.talabat.darkstores.di;

import com.integration.grocerydiscovery.GroceryDiscoveryObservabilityIntegration;
import com.integration.grocerydiscovery.GroceryDiscoveryObservabilityIntegrationImpl;
import com.talabat.darkstores.data.recentsearches.RecentSearchesRepositoryImpl;
import com.talabat.darkstores.data.recentsearches.mapper.RecentSearchDatabaseToDomainModelMapper;
import com.talabat.darkstores.data.recentsearches.mapper.RecentSearchDatabaseToDomainModelMapperImpl;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.GetFlutterConfigurationParamsUseCase;
import com.talabat.darkstores.domain.common.GetFlutterConfigurationParamsUseCaseImpl;
import com.talabat.darkstores.domain.presearch.GetPreSearchSwimlaneUseCase;
import com.talabat.darkstores.domain.presearch.GetPreSearchSwimlaneUseCaseImpl;
import com.talabat.darkstores.domain.recentsearches.RecentSearchesRepository;
import com.talabat.darkstores.domain.recentsearches.observability.RecentSearchesObservabilityManager;
import com.talabat.darkstores.domain.recentsearches.observability.RecentSearchesObservabilityManagerImpl;
import com.talabat.darkstores.feature.model.mapper.PreSearchSwimlaneToListItemsMapper;
import com.talabat.darkstores.feature.model.mapper.PreSearchSwimlaneToListItemsMapperImpl;
import com.talabat.darkstores.feature.model.mapper.RecentSearchesToListItemsMapper;
import com.talabat.darkstores.feature.model.mapper.RecentSearchesToListItemsMapperImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u001aH'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u001dH'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020 H'J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020#H'¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/di/PreSearchBindingModule;", "", "bindBuildSearchNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;", "impl", "Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCaseImpl;", "bindBuildVoucherDetailsNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildVoucherDetailsNavigationUseCase;", "Lcom/talabat/darkstores/domain/common/BuildVoucherDetailsNavigationUseCaseImpl;", "bindBuildVoucherProductListingNavDirectionUseCase", "Lcom/talabat/darkstores/domain/common/BuildVoucherProductListingNavigationUseCase;", "Lcom/talabat/darkstores/domain/common/BuildVoucherProductListingNavigationUseCaseImpl;", "bindGetFlutterConfigurationParamsUseCase", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCaseImpl;", "bindGetPreSearchSwimlaneUseCase", "Lcom/talabat/darkstores/domain/presearch/GetPreSearchSwimlaneUseCase;", "Lcom/talabat/darkstores/domain/presearch/GetPreSearchSwimlaneUseCaseImpl;", "bindGroceryDiscoveryObservabilityIntegration", "Lcom/integration/grocerydiscovery/GroceryDiscoveryObservabilityIntegration;", "Lcom/integration/grocerydiscovery/GroceryDiscoveryObservabilityIntegrationImpl;", "bindPastOrdersToListItemMapper", "Lcom/talabat/darkstores/feature/model/mapper/PreSearchSwimlaneToListItemsMapper;", "Lcom/talabat/darkstores/feature/model/mapper/PreSearchSwimlaneToListItemsMapperImpl;", "bindRecentSearchDatabaseToDomainModelMapper", "Lcom/talabat/darkstores/data/recentsearches/mapper/RecentSearchDatabaseToDomainModelMapper;", "Lcom/talabat/darkstores/data/recentsearches/mapper/RecentSearchDatabaseToDomainModelMapperImpl;", "bindRecentSearchRepository", "Lcom/talabat/darkstores/domain/recentsearches/RecentSearchesRepository;", "Lcom/talabat/darkstores/data/recentsearches/RecentSearchesRepositoryImpl;", "bindRecentSearchToListItemMapper", "Lcom/talabat/darkstores/feature/model/mapper/RecentSearchesToListItemsMapper;", "Lcom/talabat/darkstores/feature/model/mapper/RecentSearchesToListItemsMapperImpl;", "bindRecentSearchesObservabilityManager", "Lcom/talabat/darkstores/domain/recentsearches/observability/RecentSearchesObservabilityManager;", "Lcom/talabat/darkstores/domain/recentsearches/observability/RecentSearchesObservabilityManagerImpl;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface PreSearchBindingModule {
    @NotNull
    @Binds
    BuildSearchNavigationActionUseCase bindBuildSearchNavigationActionUseCase(@NotNull BuildSearchNavigationActionUseCaseImpl buildSearchNavigationActionUseCaseImpl);

    @NotNull
    @Binds
    BuildVoucherDetailsNavigationUseCase bindBuildVoucherDetailsNavigationUseCase(@NotNull BuildVoucherDetailsNavigationUseCaseImpl buildVoucherDetailsNavigationUseCaseImpl);

    @NotNull
    @Binds
    BuildVoucherProductListingNavigationUseCase bindBuildVoucherProductListingNavDirectionUseCase(@NotNull BuildVoucherProductListingNavigationUseCaseImpl buildVoucherProductListingNavigationUseCaseImpl);

    @NotNull
    @Binds
    GetFlutterConfigurationParamsUseCase bindGetFlutterConfigurationParamsUseCase(@NotNull GetFlutterConfigurationParamsUseCaseImpl getFlutterConfigurationParamsUseCaseImpl);

    @NotNull
    @Binds
    GetPreSearchSwimlaneUseCase bindGetPreSearchSwimlaneUseCase(@NotNull GetPreSearchSwimlaneUseCaseImpl getPreSearchSwimlaneUseCaseImpl);

    @NotNull
    @Binds
    GroceryDiscoveryObservabilityIntegration bindGroceryDiscoveryObservabilityIntegration(@NotNull GroceryDiscoveryObservabilityIntegrationImpl groceryDiscoveryObservabilityIntegrationImpl);

    @NotNull
    @Binds
    PreSearchSwimlaneToListItemsMapper bindPastOrdersToListItemMapper(@NotNull PreSearchSwimlaneToListItemsMapperImpl preSearchSwimlaneToListItemsMapperImpl);

    @NotNull
    @Binds
    RecentSearchDatabaseToDomainModelMapper bindRecentSearchDatabaseToDomainModelMapper(@NotNull RecentSearchDatabaseToDomainModelMapperImpl recentSearchDatabaseToDomainModelMapperImpl);

    @NotNull
    @Binds
    RecentSearchesRepository bindRecentSearchRepository(@NotNull RecentSearchesRepositoryImpl recentSearchesRepositoryImpl);

    @NotNull
    @Binds
    RecentSearchesToListItemsMapper bindRecentSearchToListItemMapper(@NotNull RecentSearchesToListItemsMapperImpl recentSearchesToListItemsMapperImpl);

    @NotNull
    @Binds
    RecentSearchesObservabilityManager bindRecentSearchesObservabilityManager(@NotNull RecentSearchesObservabilityManagerImpl recentSearchesObservabilityManagerImpl);
}
