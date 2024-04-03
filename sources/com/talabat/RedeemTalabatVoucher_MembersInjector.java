package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RedeemTalabatVoucher_MembersInjector implements MembersInjector<RedeemTalabatVoucher> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public RedeemTalabatVoucher_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<RedeemTalabatVoucher> create(Provider<AppVersionProvider> provider) {
        return new RedeemTalabatVoucher_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.RedeemTalabatVoucher.appVersionProvider")
    public static void injectAppVersionProvider(RedeemTalabatVoucher redeemTalabatVoucher, AppVersionProvider appVersionProvider2) {
        redeemTalabatVoucher.f54923i = appVersionProvider2;
    }

    public void injectMembers(RedeemTalabatVoucher redeemTalabatVoucher) {
        injectAppVersionProvider(redeemTalabatVoucher, this.appVersionProvider.get());
    }
}
