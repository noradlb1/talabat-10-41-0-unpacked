package com.talabat.helpers;

import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.fwf.domain.config.IFWFManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignDeeplinkUseCase;
import com.talabat.messaging.MessagingServiceType;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TalabatApplication_MembersInjector implements MembersInjector<TalabatApplication> {
    private final Provider<MutableConfigurationRemoteCoreLibApi> configurationRemoteCoreLibApiProvider;
    private final Provider<CustomerInfoRepository> customerInfoRepositoryProvider;
    private final Provider<IFWFManager> fWFManagerProvider;
    private final Provider<MessagingServiceType> messagingServiceTypeProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<SplashPreferences> splashPreferencesProvider;
    private final Provider<VoucherCampaignDeeplinkUseCase> voucherCampaignDeeplinkUseCaseProvider;

    public TalabatApplication_MembersInjector(Provider<SplashPreferences> provider, Provider<MutableConfigurationRemoteCoreLibApi> provider2, Provider<CustomerInfoRepository> provider3, Provider<IFWFManager> provider4, Provider<VoucherCampaignDeeplinkUseCase> provider5, Provider<IScreenTracker> provider6, Provider<MessagingServiceType> provider7) {
        this.splashPreferencesProvider = provider;
        this.configurationRemoteCoreLibApiProvider = provider2;
        this.customerInfoRepositoryProvider = provider3;
        this.fWFManagerProvider = provider4;
        this.voucherCampaignDeeplinkUseCaseProvider = provider5;
        this.screenTrackerProvider = provider6;
        this.messagingServiceTypeProvider = provider7;
    }

    public static MembersInjector<TalabatApplication> create(Provider<SplashPreferences> provider, Provider<MutableConfigurationRemoteCoreLibApi> provider2, Provider<CustomerInfoRepository> provider3, Provider<IFWFManager> provider4, Provider<VoucherCampaignDeeplinkUseCase> provider5, Provider<IScreenTracker> provider6, Provider<MessagingServiceType> provider7) {
        return new TalabatApplication_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.helpers.TalabatApplication.configurationRemoteCoreLibApi")
    public static void injectConfigurationRemoteCoreLibApi(TalabatApplication talabatApplication, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        talabatApplication.configurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.helpers.TalabatApplication.customerInfoRepository")
    public static void injectCustomerInfoRepository(TalabatApplication talabatApplication, CustomerInfoRepository customerInfoRepository) {
        talabatApplication.customerInfoRepository = customerInfoRepository;
    }

    @InjectedFieldSignature("com.talabat.helpers.TalabatApplication.fWFManager")
    public static void injectFWFManager(TalabatApplication talabatApplication, IFWFManager iFWFManager) {
        talabatApplication.fWFManager = iFWFManager;
    }

    @InjectedFieldSignature("com.talabat.helpers.TalabatApplication.messagingServiceType")
    public static void injectMessagingServiceType(TalabatApplication talabatApplication, MessagingServiceType messagingServiceType) {
        talabatApplication.messagingServiceType = messagingServiceType;
    }

    @InjectedFieldSignature("com.talabat.helpers.TalabatApplication.screenTracker")
    public static void injectScreenTracker(TalabatApplication talabatApplication, IScreenTracker iScreenTracker) {
        talabatApplication.screenTracker = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.helpers.TalabatApplication.splashPreferences")
    public static void injectSplashPreferences(TalabatApplication talabatApplication, SplashPreferences splashPreferences) {
        talabatApplication.splashPreferences = splashPreferences;
    }

    @InjectedFieldSignature("com.talabat.helpers.TalabatApplication.voucherCampaignDeeplinkUseCase")
    public static void injectVoucherCampaignDeeplinkUseCase(TalabatApplication talabatApplication, VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase) {
        talabatApplication.voucherCampaignDeeplinkUseCase = voucherCampaignDeeplinkUseCase;
    }

    public void injectMembers(TalabatApplication talabatApplication) {
        injectSplashPreferences(talabatApplication, this.splashPreferencesProvider.get());
        injectConfigurationRemoteCoreLibApi(talabatApplication, this.configurationRemoteCoreLibApiProvider.get());
        injectCustomerInfoRepository(talabatApplication, this.customerInfoRepositoryProvider.get());
        injectFWFManager(talabatApplication, this.fWFManagerProvider.get());
        injectVoucherCampaignDeeplinkUseCase(talabatApplication, this.voucherCampaignDeeplinkUseCaseProvider.get());
        injectScreenTracker(talabatApplication, this.screenTrackerProvider.get());
        injectMessagingServiceType(talabatApplication, this.messagingServiceTypeProvider.get());
    }
}
