package com.talabat.di.voucher;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.RedeemTalabatVoucher;
import com.talabat.RedeemTalabatVoucher_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.voucher.RedeemTalabatVoucherComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRedeemTalabatVoucherComponent {

    public static final class Factory implements RedeemTalabatVoucherComponent.Factory {
        private Factory() {
        }

        public RedeemTalabatVoucherComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new RedeemTalabatVoucherComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class RedeemTalabatVoucherComponentImpl implements RedeemTalabatVoucherComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final RedeemTalabatVoucherComponentImpl redeemTalabatVoucherComponentImpl;

        private RedeemTalabatVoucherComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.redeemTalabatVoucherComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RedeemTalabatVoucher injectRedeemTalabatVoucher(RedeemTalabatVoucher redeemTalabatVoucher) {
            RedeemTalabatVoucher_MembersInjector.injectAppVersionProvider(redeemTalabatVoucher, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return redeemTalabatVoucher;
        }

        public void inject(RedeemTalabatVoucher redeemTalabatVoucher) {
            injectRedeemTalabatVoucher(redeemTalabatVoucher);
        }
    }

    private DaggerRedeemTalabatVoucherComponent() {
    }

    public static RedeemTalabatVoucherComponent.Factory factory() {
        return new Factory();
    }
}
