package com.talabat.feature.nfvinvendorsearch.presentation.di;

import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandler;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandler;
import com.talabat.feature.darkstoresflutter.domain.usecase.NavigateToCheckoutUseCase;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.darkstoresvendor.domain.usecase.GetVendorUseCase;
import com.talabat.feature.nfvinvendorsearch.domain.di.QCommerceFlutterFeatureApi;
import com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivity;
import com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivity_MembersInjector;
import com.talabat.feature.nfvinvendorsearch.presentation.di.QCommerceFlutterPresentationComponent;
import com.talabat.feature.nfvinvendorsearch.presentation.fragment.QCommerceFlutterFragment;
import com.talabat.feature.nfvinvendorsearch.presentation.fragment.QCommerceFlutterFragment_MembersInjector;
import com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler;
import com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler_Factory;
import com.talabat.feature.nfvinvendorsearch.presentation.mapper.FlutterVendorToMapMapper_Factory;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModel;
import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModelFactory;
import com.talabat.feature.nfvinvendorsearch.presentation.viewmodel.QCommerceViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerQCommerceFlutterPresentationComponent {

    public static final class Factory implements QCommerceFlutterPresentationComponent.Factory {
        private Factory() {
        }

        public QCommerceFlutterPresentationComponent create(DarkstoresFeatureApi darkstoresFeatureApi, DarkstoresVendorApi darkstoresVendorApi, QCommerceFlutterFeatureApi qCommerceFlutterFeatureApi, DarkstoresFlutterCartApi darkstoresFlutterCartApi, FlutterConfigurationParams flutterConfigurationParams) {
            Preconditions.checkNotNull(darkstoresFeatureApi);
            Preconditions.checkNotNull(darkstoresVendorApi);
            Preconditions.checkNotNull(qCommerceFlutterFeatureApi);
            Preconditions.checkNotNull(darkstoresFlutterCartApi);
            Preconditions.checkNotNull(flutterConfigurationParams);
            return new QCommerceFlutterPresentationComponentImpl(darkstoresFeatureApi, darkstoresVendorApi, qCommerceFlutterFeatureApi, darkstoresFlutterCartApi, flutterConfigurationParams);
        }
    }

    public static final class QCommerceFlutterPresentationComponentImpl implements QCommerceFlutterPresentationComponent {
        private Provider<FlutterConfigurationParams> configurationParamsProvider;
        private Provider<DarkstoreCartEventStreamHandler> darkstoreCartEventHandlerProvider;
        private Provider<DarkstoresCartMethodCallHandler> darkstoresCartMethodCallHandlerProvider;
        private Provider<DarkstoresNavigator> darkstoresNavigatorProvider;
        private Provider<GetVendorUseCase> getVendorUseCaseProvider;
        private Provider<NavigateToCheckoutUseCase> navigateToCheckoutUseCaseProvider;
        private final QCommerceFlutterPresentationComponentImpl qCommerceFlutterPresentationComponentImpl;
        private Provider<QCommerceMethodHandler> qCommerceMethodHandlerProvider;
        private Provider<QCommerceViewModel> qCommerceViewModelProvider;

        public static final class DarkstoreCartEventHandlerProvider implements Provider<DarkstoreCartEventStreamHandler> {
            private final DarkstoresFlutterCartApi darkstoresFlutterCartApi;

            public DarkstoreCartEventHandlerProvider(DarkstoresFlutterCartApi darkstoresFlutterCartApi2) {
                this.darkstoresFlutterCartApi = darkstoresFlutterCartApi2;
            }

            public DarkstoreCartEventStreamHandler get() {
                return (DarkstoreCartEventStreamHandler) Preconditions.checkNotNullFromComponent(this.darkstoresFlutterCartApi.darkstoreCartEventHandler());
            }
        }

        public static final class DarkstoresCartMethodCallHandlerProvider implements Provider<DarkstoresCartMethodCallHandler> {
            private final DarkstoresFlutterCartApi darkstoresFlutterCartApi;

            public DarkstoresCartMethodCallHandlerProvider(DarkstoresFlutterCartApi darkstoresFlutterCartApi2) {
                this.darkstoresFlutterCartApi = darkstoresFlutterCartApi2;
            }

            public DarkstoresCartMethodCallHandler get() {
                return (DarkstoresCartMethodCallHandler) Preconditions.checkNotNullFromComponent(this.darkstoresFlutterCartApi.darkstoresCartMethodCallHandler());
            }
        }

        public static final class DarkstoresNavigatorProvider implements Provider<DarkstoresNavigator> {
            private final DarkstoresFeatureApi darkstoresFeatureApi;

            public DarkstoresNavigatorProvider(DarkstoresFeatureApi darkstoresFeatureApi2) {
                this.darkstoresFeatureApi = darkstoresFeatureApi2;
            }

            public DarkstoresNavigator get() {
                return (DarkstoresNavigator) Preconditions.checkNotNullFromComponent(this.darkstoresFeatureApi.darkstoresNavigator());
            }
        }

        public static final class GetVendorUseCaseProvider implements Provider<GetVendorUseCase> {
            private final DarkstoresVendorApi darkstoresVendorApi;

            public GetVendorUseCaseProvider(DarkstoresVendorApi darkstoresVendorApi2) {
                this.darkstoresVendorApi = darkstoresVendorApi2;
            }

            public GetVendorUseCase get() {
                return (GetVendorUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresVendorApi.getVendorUseCase());
            }
        }

        public static final class NavigateToCheckoutUseCaseProvider implements Provider<NavigateToCheckoutUseCase> {
            private final DarkstoresFlutterCartApi darkstoresFlutterCartApi;

            public NavigateToCheckoutUseCaseProvider(DarkstoresFlutterCartApi darkstoresFlutterCartApi2) {
                this.darkstoresFlutterCartApi = darkstoresFlutterCartApi2;
            }

            public NavigateToCheckoutUseCase get() {
                return (NavigateToCheckoutUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresFlutterCartApi.navigateToCheckoutUseCase());
            }
        }

        private QCommerceFlutterPresentationComponentImpl(DarkstoresFeatureApi darkstoresFeatureApi, DarkstoresVendorApi darkstoresVendorApi, QCommerceFlutterFeatureApi qCommerceFlutterFeatureApi, DarkstoresFlutterCartApi darkstoresFlutterCartApi, FlutterConfigurationParams flutterConfigurationParams) {
            this.qCommerceFlutterPresentationComponentImpl = this;
            initialize(darkstoresFeatureApi, darkstoresVendorApi, qCommerceFlutterFeatureApi, darkstoresFlutterCartApi, flutterConfigurationParams);
        }

        private void initialize(DarkstoresFeatureApi darkstoresFeatureApi, DarkstoresVendorApi darkstoresVendorApi, QCommerceFlutterFeatureApi qCommerceFlutterFeatureApi, DarkstoresFlutterCartApi darkstoresFlutterCartApi, FlutterConfigurationParams flutterConfigurationParams) {
            this.configurationParamsProvider = InstanceFactory.create(flutterConfigurationParams);
            GetVendorUseCaseProvider getVendorUseCaseProvider2 = new GetVendorUseCaseProvider(darkstoresVendorApi);
            this.getVendorUseCaseProvider = getVendorUseCaseProvider2;
            this.qCommerceMethodHandlerProvider = QCommerceMethodHandler_Factory.create(this.configurationParamsProvider, getVendorUseCaseProvider2, FlutterVendorToMapMapper_Factory.create());
            this.darkstoresNavigatorProvider = new DarkstoresNavigatorProvider(darkstoresFeatureApi);
            this.darkstoreCartEventHandlerProvider = new DarkstoreCartEventHandlerProvider(darkstoresFlutterCartApi);
            this.darkstoresCartMethodCallHandlerProvider = new DarkstoresCartMethodCallHandlerProvider(darkstoresFlutterCartApi);
            NavigateToCheckoutUseCaseProvider navigateToCheckoutUseCaseProvider2 = new NavigateToCheckoutUseCaseProvider(darkstoresFlutterCartApi);
            this.navigateToCheckoutUseCaseProvider = navigateToCheckoutUseCaseProvider2;
            this.qCommerceViewModelProvider = QCommerceViewModel_Factory.create(this.qCommerceMethodHandlerProvider, this.darkstoresNavigatorProvider, this.darkstoreCartEventHandlerProvider, this.darkstoresCartMethodCallHandlerProvider, navigateToCheckoutUseCaseProvider2);
        }

        private QCommerceFlutterActivity injectQCommerceFlutterActivity(QCommerceFlutterActivity qCommerceFlutterActivity) {
            QCommerceFlutterActivity_MembersInjector.injectViewModelFactory(qCommerceFlutterActivity, qCommerceViewModelFactory());
            return qCommerceFlutterActivity;
        }

        private QCommerceFlutterFragment injectQCommerceFlutterFragment(QCommerceFlutterFragment qCommerceFlutterFragment) {
            QCommerceFlutterFragment_MembersInjector.injectViewModelFactory(qCommerceFlutterFragment, qCommerceViewModelFactory());
            return qCommerceFlutterFragment;
        }

        private QCommerceViewModelFactory qCommerceViewModelFactory() {
            return new QCommerceViewModelFactory(this.qCommerceViewModelProvider);
        }

        public void inject(QCommerceFlutterFragment qCommerceFlutterFragment) {
            injectQCommerceFlutterFragment(qCommerceFlutterFragment);
        }

        public void inject(QCommerceFlutterActivity qCommerceFlutterActivity) {
            injectQCommerceFlutterActivity(qCommerceFlutterActivity);
        }
    }

    private DaggerQCommerceFlutterPresentationComponent() {
    }

    public static QCommerceFlutterPresentationComponent.Factory factory() {
        return new Factory();
    }
}
