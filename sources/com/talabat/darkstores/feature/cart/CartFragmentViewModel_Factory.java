package com.talabat.darkstores.feature.cart;

import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.deliveryfee.FlutterDeliveryTierMapper;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo;
import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentRepo;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTracker;
import com.talabat.darkstores.data.tracking.fees.tracker.IDarkstoresFeesTracker;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCase;
import com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCase;
import com.talabat.darkstores.feature.cart.cartabadonment.StartCartClearedEventTrackerUseCase;
import com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase;
import com.talabat.darkstores.feature.checkout.DarkstoresListener;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.feature.darkstores.domain.disclaimer.DisclaimerRepository;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartFragmentViewModel_Factory implements Factory<CartFragmentViewModel> {
    private final Provider<BuildBasketUpsellActionUseCase> buildBasketUpsellActionProvider;
    private final Provider<BuildDeliveryFeeTierNavigationUseCase> buildDeliveryFeeTierNavigationUseCaseProvider;
    private final Provider<CampaignProgressUseCase> campaignProgressUseCaseProvider;
    private final Provider<CartController> cartControllerProvider;
    private final Provider<CartSwimlaneUseCase> cartSwimlaneUseCaseProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<Customer> customerProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DarkstoresRepository> darkstoresRepositoryProvider;
    private final Provider<DeliveryDetailsRepo> deliveryDetailsRepoProvider;
    private final Provider<GroceryDeliveryFeeTierFeatureFlagUseCase> deliveryFeeTierFeatureFlagUseCaseProvider;
    private final Provider<DarkStoreBottomSheetTracker> deliveryTierBottomSheetTrackerProvider;
    private final Provider<DisclaimerRepository> disclaimerRepositoryProvider;
    private final Provider<IDarkstoresFeesTracker> feesTrackerProvider;
    private final Provider<FlutterDeliveryTierMapper> flutterDeliveryTierMapperProvider;
    private final Provider<GetCartListToastUseCase> getCartListToastProvider;
    private final Provider<InitCartUseCase> initCartUseCaseProvider;
    private final Provider<InvalidateCartListCacheUseCase> invalidateCartListCacheProvider;
    private final Provider<DarkstoresListener> listenerProvider;
    private final Provider<Cart> nonMigratedCartProvider;
    private final Provider<PartialFulfillmentRepo> partialFulfillmentRepoProvider;
    private final Provider<PostCartUseCase> postCartProvider;
    private final Provider<SaveBasketUpsellBottomSheetShownUseCase> saveBasketUpsellBottomSheetShownProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<StartCartClearedEventTrackerUseCase> startCartClearedEventTrackerProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<SwimlanesTracker> swimlanesTrackerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;

    public CartFragmentViewModel_Factory(Provider<CartController> provider, Provider<DarkstoresRepo> provider2, Provider<IScreenTracker> provider3, Provider<DarkstoresListener> provider4, Provider<CompositeDisposable> provider5, Provider<DarkstoresEventTracker> provider6, Provider<IDarkstoresFeesTracker> provider7, Provider<DeliveryDetailsRepo> provider8, Provider<PartialFulfillmentRepo> provider9, Provider<ITalabatFeatureFlag> provider10, Provider<ITalabatExperiment> provider11, Provider<Customer> provider12, Provider<ConfigurationParameters> provider13, Provider<CartSwimlaneUseCase> provider14, Provider<CampaignProgressUseCase> provider15, Provider<DarkstoresRepository> provider16, Provider<DisclaimerRepository> provider17, Provider<PostCartUseCase> provider18, Provider<FlutterDeliveryTierMapper> provider19, Provider<DarkStoreBottomSheetTracker> provider20, Provider<GroceryDeliveryFeeTierFeatureFlagUseCase> provider21, Provider<StoreInfoTrackingProvider> provider22, Provider<Cart> provider23, Provider<GetCartListToastUseCase> provider24, Provider<InvalidateCartListCacheUseCase> provider25, Provider<InitCartUseCase> provider26, Provider<StartCartClearedEventTrackerUseCase> provider27, Provider<BuildBasketUpsellActionUseCase> provider28, Provider<SaveBasketUpsellBottomSheetShownUseCase> provider29, Provider<SwimlanesTracker> provider30, Provider<BuildDeliveryFeeTierNavigationUseCase> provider31) {
        this.cartControllerProvider = provider;
        this.darkstoresRepoProvider = provider2;
        this.screenTrackerProvider = provider3;
        this.listenerProvider = provider4;
        this.compositeDisposableProvider = provider5;
        this.trackerProvider = provider6;
        this.feesTrackerProvider = provider7;
        this.deliveryDetailsRepoProvider = provider8;
        this.partialFulfillmentRepoProvider = provider9;
        this.talabatFeatureFlagProvider = provider10;
        this.talabatExperimentProvider = provider11;
        this.customerProvider = provider12;
        this.configurationParametersProvider = provider13;
        this.cartSwimlaneUseCaseProvider = provider14;
        this.campaignProgressUseCaseProvider = provider15;
        this.darkstoresRepositoryProvider = provider16;
        this.disclaimerRepositoryProvider = provider17;
        this.postCartProvider = provider18;
        this.flutterDeliveryTierMapperProvider = provider19;
        this.deliveryTierBottomSheetTrackerProvider = provider20;
        this.deliveryFeeTierFeatureFlagUseCaseProvider = provider21;
        this.storeInfoTrackingProvider = provider22;
        this.nonMigratedCartProvider = provider23;
        this.getCartListToastProvider = provider24;
        this.invalidateCartListCacheProvider = provider25;
        this.initCartUseCaseProvider = provider26;
        this.startCartClearedEventTrackerProvider = provider27;
        this.buildBasketUpsellActionProvider = provider28;
        this.saveBasketUpsellBottomSheetShownProvider = provider29;
        this.swimlanesTrackerProvider = provider30;
        this.buildDeliveryFeeTierNavigationUseCaseProvider = provider31;
    }

    public static CartFragmentViewModel_Factory create(Provider<CartController> provider, Provider<DarkstoresRepo> provider2, Provider<IScreenTracker> provider3, Provider<DarkstoresListener> provider4, Provider<CompositeDisposable> provider5, Provider<DarkstoresEventTracker> provider6, Provider<IDarkstoresFeesTracker> provider7, Provider<DeliveryDetailsRepo> provider8, Provider<PartialFulfillmentRepo> provider9, Provider<ITalabatFeatureFlag> provider10, Provider<ITalabatExperiment> provider11, Provider<Customer> provider12, Provider<ConfigurationParameters> provider13, Provider<CartSwimlaneUseCase> provider14, Provider<CampaignProgressUseCase> provider15, Provider<DarkstoresRepository> provider16, Provider<DisclaimerRepository> provider17, Provider<PostCartUseCase> provider18, Provider<FlutterDeliveryTierMapper> provider19, Provider<DarkStoreBottomSheetTracker> provider20, Provider<GroceryDeliveryFeeTierFeatureFlagUseCase> provider21, Provider<StoreInfoTrackingProvider> provider22, Provider<Cart> provider23, Provider<GetCartListToastUseCase> provider24, Provider<InvalidateCartListCacheUseCase> provider25, Provider<InitCartUseCase> provider26, Provider<StartCartClearedEventTrackerUseCase> provider27, Provider<BuildBasketUpsellActionUseCase> provider28, Provider<SaveBasketUpsellBottomSheetShownUseCase> provider29, Provider<SwimlanesTracker> provider30, Provider<BuildDeliveryFeeTierNavigationUseCase> provider31) {
        return new CartFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31);
    }

    public static CartFragmentViewModel newInstance(CartController cartController, DarkstoresRepo darkstoresRepo, IScreenTracker iScreenTracker, DarkstoresListener darkstoresListener, CompositeDisposable compositeDisposable, DarkstoresEventTracker darkstoresEventTracker, IDarkstoresFeesTracker iDarkstoresFeesTracker, DeliveryDetailsRepo deliveryDetailsRepo, PartialFulfillmentRepo partialFulfillmentRepo, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment, Customer customer, ConfigurationParameters configurationParameters, CartSwimlaneUseCase cartSwimlaneUseCase, CampaignProgressUseCase campaignProgressUseCase, DarkstoresRepository darkstoresRepository, DisclaimerRepository disclaimerRepository, PostCartUseCase postCartUseCase, FlutterDeliveryTierMapper flutterDeliveryTierMapper, DarkStoreBottomSheetTracker darkStoreBottomSheetTracker, GroceryDeliveryFeeTierFeatureFlagUseCase groceryDeliveryFeeTierFeatureFlagUseCase, StoreInfoTrackingProvider storeInfoTrackingProvider2, Cart cart, GetCartListToastUseCase getCartListToastUseCase, InvalidateCartListCacheUseCase invalidateCartListCacheUseCase, InitCartUseCase initCartUseCase, StartCartClearedEventTrackerUseCase startCartClearedEventTrackerUseCase, BuildBasketUpsellActionUseCase buildBasketUpsellActionUseCase, SaveBasketUpsellBottomSheetShownUseCase saveBasketUpsellBottomSheetShownUseCase, SwimlanesTracker swimlanesTracker, BuildDeliveryFeeTierNavigationUseCase buildDeliveryFeeTierNavigationUseCase) {
        return new CartFragmentViewModel(cartController, darkstoresRepo, iScreenTracker, darkstoresListener, compositeDisposable, darkstoresEventTracker, iDarkstoresFeesTracker, deliveryDetailsRepo, partialFulfillmentRepo, iTalabatFeatureFlag, iTalabatExperiment, customer, configurationParameters, cartSwimlaneUseCase, campaignProgressUseCase, darkstoresRepository, disclaimerRepository, postCartUseCase, flutterDeliveryTierMapper, darkStoreBottomSheetTracker, groceryDeliveryFeeTierFeatureFlagUseCase, storeInfoTrackingProvider2, cart, getCartListToastUseCase, invalidateCartListCacheUseCase, initCartUseCase, startCartClearedEventTrackerUseCase, buildBasketUpsellActionUseCase, saveBasketUpsellBottomSheetShownUseCase, swimlanesTracker, buildDeliveryFeeTierNavigationUseCase);
    }

    public CartFragmentViewModel get() {
        return newInstance(this.cartControllerProvider.get(), this.darkstoresRepoProvider.get(), this.screenTrackerProvider.get(), this.listenerProvider.get(), this.compositeDisposableProvider.get(), this.trackerProvider.get(), this.feesTrackerProvider.get(), this.deliveryDetailsRepoProvider.get(), this.partialFulfillmentRepoProvider.get(), this.talabatFeatureFlagProvider.get(), this.talabatExperimentProvider.get(), this.customerProvider.get(), this.configurationParametersProvider.get(), this.cartSwimlaneUseCaseProvider.get(), this.campaignProgressUseCaseProvider.get(), this.darkstoresRepositoryProvider.get(), this.disclaimerRepositoryProvider.get(), this.postCartProvider.get(), this.flutterDeliveryTierMapperProvider.get(), this.deliveryTierBottomSheetTrackerProvider.get(), this.deliveryFeeTierFeatureFlagUseCaseProvider.get(), this.storeInfoTrackingProvider.get(), this.nonMigratedCartProvider.get(), this.getCartListToastProvider.get(), this.invalidateCartListCacheProvider.get(), this.initCartUseCaseProvider.get(), this.startCartClearedEventTrackerProvider.get(), this.buildBasketUpsellActionProvider.get(), this.saveBasketUpsellBottomSheetShownProvider.get(), this.swimlanesTrackerProvider.get(), this.buildDeliveryFeeTierNavigationUseCaseProvider.get());
    }
}
