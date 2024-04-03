package com.talabat.feature.darkstoresflutter.data.di;

import com.squareup.moshi.Moshi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstoresflutter.data.di.DarkstoresFlutterCartComponent;
import com.talabat.feature.darkstoresflutter.data.mapper.CampaignProgressToFlutterCampaignProgressMapper_Factory;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterCartToMapMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterCartToMapMapper_Factory;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterMapToProductMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterMapToProductMapper_Factory;
import com.talabat.feature.darkstoresflutter.data.mapper.ProductToFlutterCartItemMapper_Factory;
import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl_Factory;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandlerImpl;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandlerImpl;
import com.talabat.feature.darkstoresflutter.domain.usecase.AddItemToCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.ClearCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.GetCartChanges;
import com.talabat.feature.darkstoresflutter.domain.usecase.NavigateToCheckoutUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.RefreshCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.RemoveItemFromCartUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDarkstoresFlutterCartComponent {

    public static final class DarkstoresFlutterCartComponentImpl implements DarkstoresFlutterCartComponent {
        private Provider<DarkstoresCartRepository> cartRepositoryProvider;
        private Provider<DarkstoresCartFlutterRepositoryImpl> darkstoresCartFlutterRepositoryImplProvider;
        private final DarkstoresFlutterCartComponentImpl darkstoresFlutterCartComponentImpl;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private Provider<FlutterCartToMapMapper> flutterCartToMapMapperProvider;
        private Provider<FlutterMapToProductMapper> flutterMapToProductMapperProvider;
        private Provider<Moshi> getMoshiProvider;

        public static final class CartRepositoryProvider implements Provider<DarkstoresCartRepository> {
            private final DarkstoresCartApi darkstoresCartApi;

            public CartRepositoryProvider(DarkstoresCartApi darkstoresCartApi2) {
                this.darkstoresCartApi = darkstoresCartApi2;
            }

            public DarkstoresCartRepository get() {
                return (DarkstoresCartRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartApi.cartRepository());
            }
        }

        public static final class GetMoshiProvider implements Provider<Moshi> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetMoshiProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Moshi get() {
                return (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi());
            }
        }

        private DarkstoresFlutterCartComponentImpl(DarkstoresCartApi darkstoresCartApi, DispatcherCoreLibApi dispatcherCoreLibApi2, ParserCoreLibApi parserCoreLibApi) {
            this.darkstoresFlutterCartComponentImpl = this;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            initialize(darkstoresCartApi, dispatcherCoreLibApi2, parserCoreLibApi);
        }

        private AddItemToCartUseCase addItemToCartUseCase() {
            return new AddItemToCartUseCase(this.darkstoresCartFlutterRepositoryImplProvider.get());
        }

        private ClearCartUseCase clearCartUseCase() {
            return new ClearCartUseCase(this.darkstoresCartFlutterRepositoryImplProvider.get());
        }

        private DarkstoreCartEventStreamHandlerImpl darkstoreCartEventStreamHandlerImpl() {
            return new DarkstoreCartEventStreamHandlerImpl(getCartChanges(), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
        }

        private DarkstoresCartMethodCallHandlerImpl darkstoresCartMethodCallHandlerImpl() {
            return new DarkstoresCartMethodCallHandlerImpl(addItemToCartUseCase(), removeItemFromCartUseCase(), clearCartUseCase(), refreshCartUseCase(), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
        }

        private GetCartChanges getCartChanges() {
            return new GetCartChanges(this.darkstoresCartFlutterRepositoryImplProvider.get());
        }

        private void initialize(DarkstoresCartApi darkstoresCartApi, DispatcherCoreLibApi dispatcherCoreLibApi2, ParserCoreLibApi parserCoreLibApi) {
            this.cartRepositoryProvider = new CartRepositoryProvider(darkstoresCartApi);
            GetMoshiProvider getMoshiProvider2 = new GetMoshiProvider(parserCoreLibApi);
            this.getMoshiProvider = getMoshiProvider2;
            this.flutterMapToProductMapperProvider = FlutterMapToProductMapper_Factory.create(getMoshiProvider2);
            this.flutterCartToMapMapperProvider = FlutterCartToMapMapper_Factory.create(this.getMoshiProvider);
            this.darkstoresCartFlutterRepositoryImplProvider = SingleCheck.provider(DarkstoresCartFlutterRepositoryImpl_Factory.create(this.cartRepositoryProvider, ProductToFlutterCartItemMapper_Factory.create(), this.flutterMapToProductMapperProvider, this.flutterCartToMapMapperProvider, CampaignProgressToFlutterCampaignProgressMapper_Factory.create()));
        }

        private RefreshCartUseCase refreshCartUseCase() {
            return new RefreshCartUseCase(this.darkstoresCartFlutterRepositoryImplProvider.get());
        }

        private RemoveItemFromCartUseCase removeItemFromCartUseCase() {
            return new RemoveItemFromCartUseCase(this.darkstoresCartFlutterRepositoryImplProvider.get());
        }

        public DarkstoreCartEventStreamHandler darkstoreCartEventHandler() {
            return darkstoreCartEventStreamHandlerImpl();
        }

        public DarkstoresCartMethodCallHandler darkstoresCartMethodCallHandler() {
            return darkstoresCartMethodCallHandlerImpl();
        }

        public NavigateToCheckoutUseCase navigateToCheckoutUseCase() {
            return new NavigateToCheckoutUseCase(this.darkstoresCartFlutterRepositoryImplProvider.get());
        }
    }

    public static final class Factory implements DarkstoresFlutterCartComponent.Factory {
        private Factory() {
        }

        public DarkstoresFlutterCartComponent create(DarkstoresCartApi darkstoresCartApi, DispatcherCoreLibApi dispatcherCoreLibApi, ParserCoreLibApi parserCoreLibApi) {
            Preconditions.checkNotNull(darkstoresCartApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            return new DarkstoresFlutterCartComponentImpl(darkstoresCartApi, dispatcherCoreLibApi, parserCoreLibApi);
        }
    }

    private DaggerDarkstoresFlutterCartComponent() {
    }

    public static DarkstoresFlutterCartComponent.Factory factory() {
        return new Factory();
    }
}
