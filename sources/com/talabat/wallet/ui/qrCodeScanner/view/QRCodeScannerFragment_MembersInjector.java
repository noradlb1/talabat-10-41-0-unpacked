package com.talabat.wallet.ui.qrCodeScanner.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class QRCodeScannerFragment_MembersInjector implements MembersInjector<QRCodeScannerFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public QRCodeScannerFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<QRCodeScannerFragment> create(Provider<ConfigurationLocalRepository> provider) {
        return new QRCodeScannerFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(QRCodeScannerFragment qRCodeScannerFragment, ConfigurationLocalRepository configurationLocalRepository) {
        qRCodeScannerFragment.configurationLocalRepository = configurationLocalRepository;
    }

    public void injectMembers(QRCodeScannerFragment qRCodeScannerFragment) {
        injectConfigurationLocalRepository(qRCodeScannerFragment, this.configurationLocalRepositoryProvider.get());
    }
}
