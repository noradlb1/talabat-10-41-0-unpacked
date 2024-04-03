package com.talabat.wallet.ui.qrCodeScanner.view.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment_MembersInjector;
import com.talabat.wallet.ui.qrCodeScanner.view.di.QRCodeScannerFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerQRCodeScannerFragmentComponent {

    public static final class Factory implements QRCodeScannerFragmentComponent.Factory {
        private Factory() {
        }

        public QRCodeScannerFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new QRCodeScannerFragmentComponentImpl(configurationLocalCoreLibApi);
        }
    }

    public static final class QRCodeScannerFragmentComponentImpl implements QRCodeScannerFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final QRCodeScannerFragmentComponentImpl qRCodeScannerFragmentComponentImpl;

        private QRCodeScannerFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.qRCodeScannerFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private QRCodeScannerFragment injectQRCodeScannerFragment(QRCodeScannerFragment qRCodeScannerFragment) {
            QRCodeScannerFragment_MembersInjector.injectConfigurationLocalRepository(qRCodeScannerFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return qRCodeScannerFragment;
        }

        public void inject(QRCodeScannerFragment qRCodeScannerFragment) {
            injectQRCodeScannerFragment(qRCodeScannerFragment);
        }
    }

    private DaggerQRCodeScannerFragmentComponent() {
    }

    public static QRCodeScannerFragmentComponent.Factory factory() {
        return new Factory();
    }
}
