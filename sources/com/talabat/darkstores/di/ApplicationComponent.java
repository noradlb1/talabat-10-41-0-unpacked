package com.talabat.darkstores.di;

import android.content.Context;
import com.google.gson.Gson;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.cart.views.CartProgressContract;
import com.talabat.darkstores.feature.categories.CategoriesFragmentViewModel;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import com.talabat.darkstores.feature.categories.subcategories.sort.SortOptionBottomSheetViewModel;
import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewFragmentViewModel;
import com.talabat.darkstores.feature.home.HomeFragmentViewModel;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewStateViewModel;
import com.talabat.darkstores.feature.mission.control.MainViewModel;
import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesFeatureApi;
import com.talabat.feature.darkstores.vendorlanding.domain.VendorLandingFeatureApi;
import com.talabat.feature.darkstorescampaignmessage.domain.CampaignMessagingApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.features.swimlanevoucherslist.domain.di.CustomerVouchersSwimLaneFeaturesApi;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, CustomerCoreLibApi.class, DarkstoresCartApi.class, DarkstoresCartListApi.class, DarkstoresFlutterCartApi.class, DarkstoresVendorApi.class, DeepLinkCoreLibApi.class, CampaignMessagingApi.class, DispatcherCoreLibApi.class, FeatureFlagCoreLibApi.class, SecretCoreLibApi.class, TrackingCoreLibApi.class, SubscriptionsFeatureApi.class, SwimlanesFeatureApi.class, VendorLandingFeatureApi.class, ObservabilityCoreLibApi.class, CustomerVouchersSwimLaneFeaturesApi.class, RemoteConfigCoreLibApi.class, NavigationCoreLibApi.class}, modules = {DarkstoresCartModule.class, DarkstoresEnvironmentModule.class, DarkstoresNetworkModule.class, DarkstoresApiModule.class, DarkstoreBasketUpsellModule.class, DarkstoresCampaignMessageModule.class, DarkstoresDatabaseModule.class, DarkstoresApplicationModule.class, DarkstoresSchedulersModule.class, DarkstoresBindingModule.class, PreSearchBindingModule.class, DarkstoresFeatureModule.class, DarkstoresUserDataModule.class, NonMigratedCartModule.class, DarkstoresDataModule.class})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001>R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u000207X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0012\u0010:\u001a\u00020;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/talabat/darkstores/di/ApplicationComponent;", "", "cartFragmentViewModel", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "getCartFragmentViewModel", "()Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "cartProgressPresenter", "Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$Presenter;", "getCartProgressPresenter", "()Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$Presenter;", "categoriesFragmentViewModel", "Lcom/talabat/darkstores/feature/categories/CategoriesFragmentViewModel;", "getCategoriesFragmentViewModel", "()Lcom/talabat/darkstores/feature/categories/CategoriesFragmentViewModel;", "categoriesOverviewFragmentViewModel", "Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewFragmentViewModel;", "getCategoriesOverviewFragmentViewModel", "()Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewFragmentViewModel;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "getConfigurationParameters", "()Lcom/talabat/darkstores/data/ConfigurationParameters;", "deliveryTierBottomSheetViewStateViewModel", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "getDeliveryTierBottomSheetViewStateViewModel", "()Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "homeFragmentViewModel", "Lcom/talabat/darkstores/feature/home/HomeFragmentViewModel;", "getHomeFragmentViewModel", "()Lcom/talabat/darkstores/feature/home/HomeFragmentViewModel;", "mainViewModel", "Lcom/talabat/darkstores/feature/mission/control/MainViewModel;", "getMainViewModel", "()Lcom/talabat/darkstores/feature/mission/control/MainViewModel;", "productFragmentViewModelFactory", "Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel$Factory;", "getProductFragmentViewModelFactory", "()Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel$Factory;", "searchFragmentViewModel", "Lcom/talabat/darkstores/feature/search/SearchFragmentViewModel;", "getSearchFragmentViewModel", "()Lcom/talabat/darkstores/feature/search/SearchFragmentViewModel;", "searchResultsFragmentViewModelFactory", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Factory;", "getSearchResultsFragmentViewModelFactory", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Factory;", "sortOptionBottomSheetViewModel", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetViewModel;", "getSortOptionBottomSheetViewModel", "()Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetViewModel;", "subcategoriesFragmentViewModelFactory", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel$Factory;", "getSubcategoriesFragmentViewModelFactory", "()Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel$Factory;", "subcategoriesFragmentViewModelNewFactory", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew$Factory;", "getSubcategoriesFragmentViewModelNewFactory", "()Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew$Factory;", "tracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "getTracker", "()Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "Factory", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public interface ApplicationComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JÐ\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H&¨\u00064"}, d2 = {"Lcom/talabat/darkstores/di/ApplicationComponent$Factory;", "", "create", "Lcom/talabat/darkstores/di/ApplicationComponent;", "applicationContext", "Landroid/content/Context;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "darkstoresCartApi", "Lcom/talabat/feature/darkstorescart/data/di/DarkstoresCartApi;", "darkstoresCartListApi", "Lcom/talabat/feature/darkstorescartlist/domain/di/DarkstoresCartListApi;", "darkstoresFlutterCartApi", "Lcom/talabat/feature/darkstoresflutter/domain/DarkstoresFlutterCartApi;", "darkstoresVendorApi", "Lcom/talabat/feature/darkstoresvendor/domain/DarkstoresVendorApi;", "vendorLandingFeatureApi", "Lcom/talabat/feature/darkstores/vendorlanding/domain/VendorLandingFeatureApi;", "campaignMessagingApi", "Lcom/talabat/feature/darkstorescampaignmessage/domain/CampaignMessagingApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "gson", "Lcom/google/gson/Gson;", "secretsCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "swimlanesFeatureApi", "Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesFeatureApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "customerVoucherSwimLaneApi", "Lcom/talabat/features/swimlanevoucherslist/domain/di/CustomerVouchersSwimLaneFeaturesApi;", "remoteConfigCoreLibApi", "Lcom/talabat/talabatremoteconfiguration/di/RemoteConfigCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ApplicationComponent create(@NotNull @BindsInstance Context context, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull @BindsInstance ConfigurationParameters configurationParameters, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull CustomerCoreLibApi customerCoreLibApi, @NotNull DarkstoresCartApi darkstoresCartApi, @NotNull DarkstoresCartListApi darkstoresCartListApi, @NotNull DarkstoresFlutterCartApi darkstoresFlutterCartApi, @NotNull DarkstoresVendorApi darkstoresVendorApi, @NotNull VendorLandingFeatureApi vendorLandingFeatureApi, @NotNull CampaignMessagingApi campaignMessagingApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull @BindsInstance Gson gson, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull SwimlanesFeatureApi swimlanesFeatureApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull SubscriptionsFeatureApi subscriptionsFeatureApi, @NotNull @BindsInstance BaseUrlFactory baseUrlFactory, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi, @NotNull RemoteConfigCoreLibApi remoteConfigCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi);
    }

    @NotNull
    CartFragmentViewModel getCartFragmentViewModel();

    @NotNull
    CartProgressContract.Presenter getCartProgressPresenter();

    @NotNull
    CategoriesFragmentViewModel getCategoriesFragmentViewModel();

    @NotNull
    CategoriesOverviewFragmentViewModel getCategoriesOverviewFragmentViewModel();

    @NotNull
    ConfigurationParameters getConfigurationParameters();

    @NotNull
    DeliveryTierBottomSheetViewStateViewModel getDeliveryTierBottomSheetViewStateViewModel();

    @NotNull
    HomeFragmentViewModel getHomeFragmentViewModel();

    @NotNull
    MainViewModel getMainViewModel();

    @NotNull
    ProductFragmentViewModel.Factory getProductFragmentViewModelFactory();

    @NotNull
    SearchFragmentViewModel getSearchFragmentViewModel();

    @NotNull
    SearchResultsFragmentViewModel.Factory getSearchResultsFragmentViewModelFactory();

    @NotNull
    SortOptionBottomSheetViewModel getSortOptionBottomSheetViewModel();

    @NotNull
    SubcategoriesFragmentViewModel.Factory getSubcategoriesFragmentViewModelFactory();

    @NotNull
    SubcategoriesFragmentViewModelNew.Factory getSubcategoriesFragmentViewModelNewFactory();

    @NotNull
    ProductImpressionTracker getTracker();
}
