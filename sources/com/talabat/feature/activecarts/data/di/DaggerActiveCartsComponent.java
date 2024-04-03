package com.talabat.feature.activecarts.data.di;

import buisnessmodels.Cart;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.activecarts.data.di.ActiveCartsComponent;
import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl_Factory;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandlerImpl;
import com.talabat.feature.activecarts.domain.mapper.ActiveCartInfoMapper;
import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import com.talabat.feature.activecarts.domain.usecase.GetActiveCartInfoUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.GetCartListUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.GetFoodCartUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.GetQCommerceCartListUseCase;
import com.talabat.feature.activecarts.domain.usecase.GetQCommerceCartListUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.TrackCartLoadedEventUseCaseImpl;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;

@DaggerGenerated
public final class DaggerActiveCartsComponent {

    public static final class ActiveCartsComponentImpl implements ActiveCartsComponent {
        private Provider<ActiveCartInfoRepositoryImpl> activeCartInfoRepositoryImplProvider;
        private final ActiveCartsComponentImpl activeCartsComponentImpl;
        private Provider<DarkstoresCartListRepository> cartListRepositoryProvider;
        private final DarkstoresCartListApi darkstoresCartListApi;
        private Provider<DarkstoresRepository> darkstoresRepositoryProvider;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private Provider<ActiveCartRepository> provideActiveCartRepositoryProvider;
        private Provider<Cart> provideCartProvider;
        private final TrackingCoreLibApi trackingCoreLibApi;

        public static final class CartListRepositoryProvider implements Provider<DarkstoresCartListRepository> {
            private final DarkstoresCartListApi darkstoresCartListApi;

            public CartListRepositoryProvider(DarkstoresCartListApi darkstoresCartListApi2) {
                this.darkstoresCartListApi = darkstoresCartListApi2;
            }

            public DarkstoresCartListRepository get() {
                return (DarkstoresCartListRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartListApi.cartListRepository());
            }
        }

        public static final class DarkstoresRepositoryProvider implements Provider<DarkstoresRepository> {
            private final DarkstoresFeatureApi darkstoresFeatureApi;

            public DarkstoresRepositoryProvider(DarkstoresFeatureApi darkstoresFeatureApi2) {
                this.darkstoresFeatureApi = darkstoresFeatureApi2;
            }

            public DarkstoresRepository get() {
                return (DarkstoresRepository) Preconditions.checkNotNullFromComponent(this.darkstoresFeatureApi.darkstoresRepository());
            }
        }

        private ActiveCartsComponentImpl(ActiveCartsDataModule activeCartsDataModule, DarkstoresCartListApi darkstoresCartListApi2, DarkstoresFeatureApi darkstoresFeatureApi, DispatcherCoreLibApi dispatcherCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2) {
            this.activeCartsComponentImpl = this;
            this.darkstoresCartListApi = darkstoresCartListApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            initialize(activeCartsDataModule, darkstoresCartListApi2, darkstoresFeatureApi, dispatcherCoreLibApi2, experimentCoreLibApi, trackingCoreLibApi2);
        }

        private ActiveCartsMethodCallHandlerImpl activeCartsMethodCallHandlerImpl() {
            return new ActiveCartsMethodCallHandlerImpl(getCartListUseCaseImpl(), getQCommerceCartListUseCaseImpl(), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
        }

        private GetActiveCartInfoUseCaseImpl getActiveCartInfoUseCaseImpl() {
            return new GetActiveCartInfoUseCaseImpl(getFoodCartUseCaseImpl(), getQCommerceCartListUseCaseImpl(), trackCartLoadedEventUseCaseImpl(), this.provideActiveCartRepositoryProvider.get());
        }

        private GetCartListUseCaseImpl getCartListUseCaseImpl() {
            return new GetCartListUseCaseImpl(getFoodCartUseCaseImpl(), getQCommerceCartListUseCaseImpl(), new ActiveCartInfoMapper(), this.provideActiveCartRepositoryProvider.get());
        }

        private GetFoodCartUseCaseImpl getFoodCartUseCaseImpl() {
            return new GetFoodCartUseCaseImpl(this.provideActiveCartRepositoryProvider.get());
        }

        private GetQCommerceCartListUseCaseImpl getQCommerceCartListUseCaseImpl() {
            return new GetQCommerceCartListUseCaseImpl((IsMultiBasketEnabledUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresCartListApi.isMultiBasketEnabledUseCase()), this.provideActiveCartRepositoryProvider.get());
        }

        private void initialize(ActiveCartsDataModule activeCartsDataModule, DarkstoresCartListApi darkstoresCartListApi2, DarkstoresFeatureApi darkstoresFeatureApi, DispatcherCoreLibApi dispatcherCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2) {
            this.provideCartProvider = ActiveCartsDataModule_ProvideCartFactory.create(activeCartsDataModule);
            this.darkstoresRepositoryProvider = new DarkstoresRepositoryProvider(darkstoresFeatureApi);
            CartListRepositoryProvider cartListRepositoryProvider2 = new CartListRepositoryProvider(darkstoresCartListApi2);
            this.cartListRepositoryProvider = cartListRepositoryProvider2;
            ActiveCartInfoRepositoryImpl_Factory create = ActiveCartInfoRepositoryImpl_Factory.create(this.provideCartProvider, this.darkstoresRepositoryProvider, cartListRepositoryProvider2);
            this.activeCartInfoRepositoryImplProvider = create;
            this.provideActiveCartRepositoryProvider = SingleCheck.provider(ActiveCartsDataModule_ProvideActiveCartRepositoryFactory.create(activeCartsDataModule, create));
        }

        private TrackCartLoadedEventUseCaseImpl trackCartLoadedEventUseCaseImpl() {
            return new TrackCartLoadedEventUseCaseImpl((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
        }

        public ActiveCartsMethodCallHandler activeCartsMethodCallHandler() {
            return activeCartsMethodCallHandlerImpl();
        }

        public GetActiveCartInfoUseCase getActiveCartInfoUseCase() {
            return getActiveCartInfoUseCaseImpl();
        }

        public GetQCommerceCartListUseCase getQCommerceCartListUseCase() {
            return getQCommerceCartListUseCaseImpl();
        }
    }

    public static final class Factory implements ActiveCartsComponent.Factory {
        private Factory() {
        }

        public ActiveCartsComponent create(DarkstoresCartListApi darkstoresCartListApi, DarkstoresFeatureApi darkstoresFeatureApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(darkstoresCartListApi);
            Preconditions.checkNotNull(darkstoresFeatureApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new ActiveCartsComponentImpl(new ActiveCartsDataModule(), darkstoresCartListApi, darkstoresFeatureApi, dispatcherCoreLibApi, experimentCoreLibApi, trackingCoreLibApi);
        }
    }

    private DaggerActiveCartsComponent() {
    }

    public static ActiveCartsComponent.Factory factory() {
        return new Factory();
    }
}
