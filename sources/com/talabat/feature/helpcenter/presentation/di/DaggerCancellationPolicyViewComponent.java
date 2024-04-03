package com.talabat.feature.helpcenter.presentation.di;

import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterEventTracker;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyItemDisplayMapper_Factory;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyView;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyViewModel;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyViewModelFactory;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyViewModel_Factory;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyView_MembersInjector;
import com.talabat.feature.helpcenter.presentation.ICancellationPolicyItemDisplayMapper;
import com.talabat.feature.helpcenter.presentation.di.CancellationPolicyViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerCancellationPolicyViewComponent {

    public static final class CancellationPolicyViewComponentImpl implements CancellationPolicyViewComponent {
        private final CancellationPolicyViewComponentImpl cancellationPolicyViewComponentImpl;
        private Provider<CancellationPolicyViewModel> cancellationPolicyViewModelProvider;
        private Provider<ICancellationPolicyRepository> getCancellationPolicyRepositoryProvider;
        private Provider<IHelpCenterEventTracker> getHelpCenterEventTrackerProvider;
        private Provider<ICancellationPolicyItemDisplayMapper> provideItemDisplayMapperProvider;

        public static final class GetCancellationPolicyRepositoryProvider implements Provider<ICancellationPolicyRepository> {
            private final HelpCenterFeatureApi helpCenterFeatureApi;

            public GetCancellationPolicyRepositoryProvider(HelpCenterFeatureApi helpCenterFeatureApi2) {
                this.helpCenterFeatureApi = helpCenterFeatureApi2;
            }

            public ICancellationPolicyRepository get() {
                return (ICancellationPolicyRepository) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getCancellationPolicyRepository());
            }
        }

        public static final class GetHelpCenterEventTrackerProvider implements Provider<IHelpCenterEventTracker> {
            private final HelpCenterFeatureApi helpCenterFeatureApi;

            public GetHelpCenterEventTrackerProvider(HelpCenterFeatureApi helpCenterFeatureApi2) {
                this.helpCenterFeatureApi = helpCenterFeatureApi2;
            }

            public IHelpCenterEventTracker get() {
                return (IHelpCenterEventTracker) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterEventTracker());
            }
        }

        private CancellationPolicyViewComponentImpl(HelpCenterFeatureApi helpCenterFeatureApi) {
            this.cancellationPolicyViewComponentImpl = this;
            initialize(helpCenterFeatureApi);
        }

        private CancellationPolicyViewModelFactory cancellationPolicyViewModelFactory() {
            return new CancellationPolicyViewModelFactory(this.cancellationPolicyViewModelProvider);
        }

        private void initialize(HelpCenterFeatureApi helpCenterFeatureApi) {
            this.getCancellationPolicyRepositoryProvider = new GetCancellationPolicyRepositoryProvider(helpCenterFeatureApi);
            this.provideItemDisplayMapperProvider = SingleCheck.provider(CancellationPolicyItemDisplayMapper_Factory.create());
            GetHelpCenterEventTrackerProvider getHelpCenterEventTrackerProvider2 = new GetHelpCenterEventTrackerProvider(helpCenterFeatureApi);
            this.getHelpCenterEventTrackerProvider = getHelpCenterEventTrackerProvider2;
            this.cancellationPolicyViewModelProvider = CancellationPolicyViewModel_Factory.create(this.getCancellationPolicyRepositoryProvider, this.provideItemDisplayMapperProvider, getHelpCenterEventTrackerProvider2);
        }

        private CancellationPolicyView injectCancellationPolicyView(CancellationPolicyView cancellationPolicyView) {
            CancellationPolicyView_MembersInjector.injectCancellationPolicyViewModelFactory(cancellationPolicyView, cancellationPolicyViewModelFactory());
            return cancellationPolicyView;
        }

        public void inject(CancellationPolicyView cancellationPolicyView) {
            injectCancellationPolicyView(cancellationPolicyView);
        }
    }

    public static final class Factory implements CancellationPolicyViewComponent.Factory {
        private Factory() {
        }

        public CancellationPolicyViewComponent create(HelpCenterFeatureApi helpCenterFeatureApi) {
            Preconditions.checkNotNull(helpCenterFeatureApi);
            return new CancellationPolicyViewComponentImpl(helpCenterFeatureApi);
        }
    }

    private DaggerCancellationPolicyViewComponent() {
    }

    public static CancellationPolicyViewComponent.Factory factory() {
        return new Factory();
    }
}
