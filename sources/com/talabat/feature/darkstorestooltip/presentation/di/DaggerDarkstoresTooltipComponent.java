package com.talabat.feature.darkstorestooltip.presentation.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorestooltip.DarkstoresTooltipDataSource;
import com.talabat.feature.darkstorestooltip.DarkstoresTooltipDataSource_Factory;
import com.talabat.feature.darkstorestooltip.DarkstoresTooltipRepositoryImpl;
import com.talabat.feature.darkstorestooltip.DarkstoresTooltipRepositoryImpl_Factory;
import com.talabat.feature.darkstorestooltip.domain.di.DarkstoresTooltipRepository;
import com.talabat.feature.darkstorestooltip.domain.usecase.SetTooltipShown;
import com.talabat.feature.darkstorestooltip.domain.usecase.SetTooltipShownImpl;
import com.talabat.feature.darkstorestooltip.domain.usecase.SetTooltipShownImpl_Factory;
import com.talabat.feature.darkstorestooltip.domain.usecase.WasTooltipAlreadyShown;
import com.talabat.feature.darkstorestooltip.domain.usecase.WasTooltipAlreadyShownImpl;
import com.talabat.feature.darkstorestooltip.domain.usecase.WasTooltipAlreadyShownImpl_Factory;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;
import com.talabat.feature.darkstorestooltip.presentation.TooltipViewController;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView_MembersInjector;
import com.talabat.feature.darkstorestooltip.presentation.di.DarkstoresTooltipComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDarkstoresTooltipComponent {

    public static final class DarkstoresTooltipComponentImpl implements DarkstoresTooltipComponent {
        private Provider<WasTooltipAlreadyShown> bindIsTooltipShownProvider;
        private Provider<SetTooltipShown> bindSetTooltipShownProvider;
        private final DarkstoresTooltipComponentImpl darkstoresTooltipComponentImpl;
        private Provider<DarkstoresTooltipDataSource> darkstoresTooltipDataSourceProvider;
        private Provider<DarkstoresTooltipRepositoryImpl> darkstoresTooltipRepositoryImplProvider;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private Provider<Context> getContextProvider;
        private Provider<DarkstoresTooltipRepository> provideRepositoryProvider;
        private Provider<SharedPreferences> provideSharedPreferencesProvider;
        private Provider<SetTooltipShownImpl> setTooltipShownImplProvider;
        private Provider<WasTooltipAlreadyShownImpl> wasTooltipAlreadyShownImplProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private DarkstoresTooltipComponentImpl(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi2) {
            this.darkstoresTooltipComponentImpl = this;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            initialize(contextCoreLibApi, dispatcherCoreLibApi2);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi2) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            DarkstoresTooltipDataModule_ProvideSharedPreferencesFactory create = DarkstoresTooltipDataModule_ProvideSharedPreferencesFactory.create(getContextProvider2);
            this.provideSharedPreferencesProvider = create;
            DarkstoresTooltipDataSource_Factory create2 = DarkstoresTooltipDataSource_Factory.create(create);
            this.darkstoresTooltipDataSourceProvider = create2;
            DarkstoresTooltipRepositoryImpl_Factory create3 = DarkstoresTooltipRepositoryImpl_Factory.create(create2);
            this.darkstoresTooltipRepositoryImplProvider = create3;
            DarkstoresTooltipDataModule_ProvideRepositoryFactory create4 = DarkstoresTooltipDataModule_ProvideRepositoryFactory.create(create3);
            this.provideRepositoryProvider = create4;
            WasTooltipAlreadyShownImpl_Factory create5 = WasTooltipAlreadyShownImpl_Factory.create(create4);
            this.wasTooltipAlreadyShownImplProvider = create5;
            this.bindIsTooltipShownProvider = SingleCheck.provider(create5);
            SetTooltipShownImpl_Factory create6 = SetTooltipShownImpl_Factory.create(this.provideRepositoryProvider);
            this.setTooltipShownImplProvider = create6;
            this.bindSetTooltipShownProvider = SingleCheck.provider(create6);
        }

        private TooltipView injectTooltipView(TooltipView tooltipView) {
            TooltipView_MembersInjector.injectTooltipViewController(tooltipView, tooltipViewController());
            return tooltipView;
        }

        private TooltipViewController tooltipViewController() {
            return new TooltipViewController(this.bindIsTooltipShownProvider.get(), this.bindSetTooltipShownProvider.get(), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
        }

        public void inject(TooltipView tooltipView) {
            injectTooltipView(tooltipView);
        }
    }

    public static final class Factory implements DarkstoresTooltipComponent.Factory {
        private Factory() {
        }

        public DarkstoresTooltipComponent create(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new DarkstoresTooltipComponentImpl(contextCoreLibApi, dispatcherCoreLibApi);
        }
    }

    private DaggerDarkstoresTooltipComponent() {
    }

    public static DarkstoresTooltipComponent.Factory factory() {
        return new Factory();
    }
}
