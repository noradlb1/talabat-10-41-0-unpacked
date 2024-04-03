package com.talabat.feature.tmart.growth.presentation.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.core.ui.di.ViewModelGenericFactory;
import com.talabat.core.ui.di.ViewModelGenericFactory_Factory;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase_Factory;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase_Factory;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthClaimVoucherUseCase;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthClaimVoucherUseCase_Factory;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationImagesUseCase;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationImagesUseCase_Factory;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase_Factory;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import com.talabat.feature.tmart.growth.presentation.di.TMartGrowthViewComponent;
import com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheet;
import com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel;
import com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel_Factory;
import com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheet_MembersInjector;
import com.talabat.feature.tmart.growth.presentation.widget.C0479TMartGrowthWidgetViewModel_Factory;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper_Factory;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetView;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel_Factory_Impl;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetView_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerTMartGrowthViewComponent {

    public static final class Factory implements TMartGrowthViewComponent.Factory {
        private Factory() {
        }

        public TMartGrowthViewComponent create(TMartGrowthFeatureApi tMartGrowthFeatureApi) {
            Preconditions.checkNotNull(tMartGrowthFeatureApi);
            return new TMartGrowthViewComponentImpl(tMartGrowthFeatureApi);
        }
    }

    public static final class TMartGrowthViewComponentImpl implements TMartGrowthViewComponent {
        private Provider<ViewModelProvider.Factory> bindViewModelFactoryProvider;
        private Provider<TMartGrowthWidgetViewModel.Factory> factoryProvider;
        private Provider<ITMartGrowthFileManager> getFileManagerProvider;
        private Provider<ITMartGrowthReminderRepository> getReminderRepositoryProvider;
        private Provider<ITMartGrowthRepository> getRepositoryProvider;
        private Provider<ITMartGrowthTracker> getTrackerProvider;
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
        private Provider<TMartGrowthBottomSheetViewModel> tMartGrowthBottomSheetViewModelProvider;
        private Provider<TMartGrowthClaimInfoUseCase> tMartGrowthClaimInfoUseCaseProvider;
        private Provider<TMartGrowthClaimTrackingUseCase> tMartGrowthClaimTrackingUseCaseProvider;
        private Provider<TMartGrowthClaimVoucherUseCase> tMartGrowthClaimVoucherUseCaseProvider;
        private Provider<TMartGrowthConfirmationImagesUseCase> tMartGrowthConfirmationImagesUseCaseProvider;
        private Provider<TMartGrowthConfirmationTrackingUseCase> tMartGrowthConfirmationTrackingUseCaseProvider;
        private Provider<TMartGrowthReminderDisplayMapper> tMartGrowthReminderDisplayMapperProvider;
        private final TMartGrowthViewComponentImpl tMartGrowthViewComponentImpl;
        private C0479TMartGrowthWidgetViewModel_Factory tMartGrowthWidgetViewModelProvider;
        private Provider<ViewModelGenericFactory> viewModelGenericFactoryProvider;

        public static final class GetFileManagerProvider implements Provider<ITMartGrowthFileManager> {
            private final TMartGrowthFeatureApi tMartGrowthFeatureApi;

            public GetFileManagerProvider(TMartGrowthFeatureApi tMartGrowthFeatureApi2) {
                this.tMartGrowthFeatureApi = tMartGrowthFeatureApi2;
            }

            public ITMartGrowthFileManager get() {
                return (ITMartGrowthFileManager) Preconditions.checkNotNullFromComponent(this.tMartGrowthFeatureApi.getFileManager());
            }
        }

        public static final class GetReminderRepositoryProvider implements Provider<ITMartGrowthReminderRepository> {
            private final TMartGrowthFeatureApi tMartGrowthFeatureApi;

            public GetReminderRepositoryProvider(TMartGrowthFeatureApi tMartGrowthFeatureApi2) {
                this.tMartGrowthFeatureApi = tMartGrowthFeatureApi2;
            }

            public ITMartGrowthReminderRepository get() {
                return (ITMartGrowthReminderRepository) Preconditions.checkNotNullFromComponent(this.tMartGrowthFeatureApi.getReminderRepository());
            }
        }

        public static final class GetRepositoryProvider implements Provider<ITMartGrowthRepository> {
            private final TMartGrowthFeatureApi tMartGrowthFeatureApi;

            public GetRepositoryProvider(TMartGrowthFeatureApi tMartGrowthFeatureApi2) {
                this.tMartGrowthFeatureApi = tMartGrowthFeatureApi2;
            }

            public ITMartGrowthRepository get() {
                return (ITMartGrowthRepository) Preconditions.checkNotNullFromComponent(this.tMartGrowthFeatureApi.getRepository());
            }
        }

        public static final class GetTrackerProvider implements Provider<ITMartGrowthTracker> {
            private final TMartGrowthFeatureApi tMartGrowthFeatureApi;

            public GetTrackerProvider(TMartGrowthFeatureApi tMartGrowthFeatureApi2) {
                this.tMartGrowthFeatureApi = tMartGrowthFeatureApi2;
            }

            public ITMartGrowthTracker get() {
                return (ITMartGrowthTracker) Preconditions.checkNotNullFromComponent(this.tMartGrowthFeatureApi.getTracker());
            }
        }

        private TMartGrowthViewComponentImpl(TMartGrowthFeatureApi tMartGrowthFeatureApi) {
            this.tMartGrowthViewComponentImpl = this;
            initialize(tMartGrowthFeatureApi);
        }

        private void initialize(TMartGrowthFeatureApi tMartGrowthFeatureApi) {
            this.getRepositoryProvider = new GetRepositoryProvider(tMartGrowthFeatureApi);
            GetFileManagerProvider getFileManagerProvider2 = new GetFileManagerProvider(tMartGrowthFeatureApi);
            this.getFileManagerProvider = getFileManagerProvider2;
            this.tMartGrowthConfirmationImagesUseCaseProvider = TMartGrowthConfirmationImagesUseCase_Factory.create(this.getRepositoryProvider, getFileManagerProvider2);
            this.tMartGrowthClaimVoucherUseCaseProvider = TMartGrowthClaimVoucherUseCase_Factory.create(this.getRepositoryProvider);
            GetTrackerProvider getTrackerProvider2 = new GetTrackerProvider(tMartGrowthFeatureApi);
            this.getTrackerProvider = getTrackerProvider2;
            TMartGrowthConfirmationTrackingUseCase_Factory create = TMartGrowthConfirmationTrackingUseCase_Factory.create(this.getRepositoryProvider, getTrackerProvider2);
            this.tMartGrowthConfirmationTrackingUseCaseProvider = create;
            this.tMartGrowthBottomSheetViewModelProvider = TMartGrowthBottomSheetViewModel_Factory.create(this.tMartGrowthConfirmationImagesUseCaseProvider, this.tMartGrowthClaimVoucherUseCaseProvider, create);
            MapProviderFactory build = MapProviderFactory.builder(1).put((Object) TMartGrowthBottomSheetViewModel.class, (Provider) this.tMartGrowthBottomSheetViewModelProvider).build();
            this.mapOfClassOfAndProviderOfViewModelProvider = build;
            ViewModelGenericFactory_Factory create2 = ViewModelGenericFactory_Factory.create(build);
            this.viewModelGenericFactoryProvider = create2;
            this.bindViewModelFactoryProvider = SingleCheck.provider(create2);
            this.tMartGrowthClaimInfoUseCaseProvider = TMartGrowthClaimInfoUseCase_Factory.create(this.getFileManagerProvider, this.getRepositoryProvider);
            this.getReminderRepositoryProvider = new GetReminderRepositoryProvider(tMartGrowthFeatureApi);
            this.tMartGrowthReminderDisplayMapperProvider = TMartGrowthReminderDisplayMapper_Factory.create(this.getFileManagerProvider);
            TMartGrowthClaimTrackingUseCase_Factory create3 = TMartGrowthClaimTrackingUseCase_Factory.create(this.getRepositoryProvider, this.getReminderRepositoryProvider, this.getTrackerProvider);
            this.tMartGrowthClaimTrackingUseCaseProvider = create3;
            C0479TMartGrowthWidgetViewModel_Factory create4 = C0479TMartGrowthWidgetViewModel_Factory.create(this.tMartGrowthClaimInfoUseCaseProvider, this.getReminderRepositoryProvider, this.tMartGrowthReminderDisplayMapperProvider, create3);
            this.tMartGrowthWidgetViewModelProvider = create4;
            this.factoryProvider = TMartGrowthWidgetViewModel_Factory_Impl.create(create4);
        }

        private TMartGrowthBottomSheet injectTMartGrowthBottomSheet(TMartGrowthBottomSheet tMartGrowthBottomSheet) {
            TMartGrowthBottomSheet_MembersInjector.injectViewModelFactory(tMartGrowthBottomSheet, this.bindViewModelFactoryProvider.get());
            return tMartGrowthBottomSheet;
        }

        private TMartGrowthWidgetView injectTMartGrowthWidgetView(TMartGrowthWidgetView tMartGrowthWidgetView) {
            TMartGrowthWidgetView_MembersInjector.injectViewModelFactory(tMartGrowthWidgetView, this.factoryProvider.get());
            return tMartGrowthWidgetView;
        }

        public void inject(TMartGrowthBottomSheet tMartGrowthBottomSheet) {
            injectTMartGrowthBottomSheet(tMartGrowthBottomSheet);
        }

        public void inject(TMartGrowthWidgetView tMartGrowthWidgetView) {
            injectTMartGrowthWidgetView(tMartGrowthWidgetView);
        }
    }

    private DaggerTMartGrowthViewComponent() {
    }

    public static TMartGrowthViewComponent.Factory factory() {
        return new Factory();
    }
}
