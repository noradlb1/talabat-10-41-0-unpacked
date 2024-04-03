package com.talabat.core.hms.push.presentation;

import com.braze.Braze;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable"})
@DaggerGenerated
public final class HmsPushService_MembersInjector implements MembersInjector<HmsPushService> {
    private final Provider<Braze> brazeProvider;
    private final Provider<Boolean> isGmsAvailableProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<TalabatHuaweiWatch> talabatHuaweiWatchProvider;
    private final Provider<CoroutineScope> uiScopeProvider;

    public HmsPushService_MembersInjector(Provider<TalabatHuaweiWatch> provider, Provider<IObservabilityManager> provider2, Provider<Boolean> provider3, Provider<Braze> provider4, Provider<CoroutineScope> provider5) {
        this.talabatHuaweiWatchProvider = provider;
        this.observabilityManagerProvider = provider2;
        this.isGmsAvailableProvider = provider3;
        this.brazeProvider = provider4;
        this.uiScopeProvider = provider5;
    }

    public static MembersInjector<HmsPushService> create(Provider<TalabatHuaweiWatch> provider, Provider<IObservabilityManager> provider2, Provider<Boolean> provider3, Provider<Braze> provider4, Provider<CoroutineScope> provider5) {
        return new HmsPushService_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.core.hms.push.presentation.HmsPushService.braze")
    public static void injectBraze(HmsPushService hmsPushService, Braze braze) {
        hmsPushService.braze = braze;
    }

    @IsGmsAvailable
    @InjectedFieldSignature("com.talabat.core.hms.push.presentation.HmsPushService.isGmsAvailable")
    public static void injectIsGmsAvailable(HmsPushService hmsPushService, boolean z11) {
        hmsPushService.isGmsAvailable = z11;
    }

    @InjectedFieldSignature("com.talabat.core.hms.push.presentation.HmsPushService.observabilityManager")
    public static void injectObservabilityManager(HmsPushService hmsPushService, IObservabilityManager iObservabilityManager) {
        hmsPushService.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.core.hms.push.presentation.HmsPushService.talabatHuaweiWatch")
    public static void injectTalabatHuaweiWatch(HmsPushService hmsPushService, TalabatHuaweiWatch talabatHuaweiWatch) {
        hmsPushService.talabatHuaweiWatch = talabatHuaweiWatch;
    }

    @InjectedFieldSignature("com.talabat.core.hms.push.presentation.HmsPushService.uiScope")
    public static void injectUiScope(HmsPushService hmsPushService, CoroutineScope coroutineScope) {
        hmsPushService.uiScope = coroutineScope;
    }

    public void injectMembers(HmsPushService hmsPushService) {
        injectTalabatHuaweiWatch(hmsPushService, this.talabatHuaweiWatchProvider.get());
        injectObservabilityManager(hmsPushService, this.observabilityManagerProvider.get());
        injectIsGmsAvailable(hmsPushService, this.isGmsAvailableProvider.get().booleanValue());
        injectBraze(hmsPushService, this.brazeProvider.get());
        injectUiScope(hmsPushService, this.uiScopeProvider.get());
    }
}
