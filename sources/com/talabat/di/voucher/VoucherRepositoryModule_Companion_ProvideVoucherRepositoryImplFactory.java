package com.talabat.di.voucher;

import android.content.Context;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class VoucherRepositoryModule_Companion_ProvideVoucherRepositoryImplFactory implements Factory<VoucherRepositoryImpl> {
    private final Provider<Context> contextProvider;

    public VoucherRepositoryModule_Companion_ProvideVoucherRepositoryImplFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static VoucherRepositoryModule_Companion_ProvideVoucherRepositoryImplFactory create(Provider<Context> provider) {
        return new VoucherRepositoryModule_Companion_ProvideVoucherRepositoryImplFactory(provider);
    }

    public static VoucherRepositoryImpl provideVoucherRepositoryImpl(Context context) {
        return (VoucherRepositoryImpl) Preconditions.checkNotNullFromProvides(VoucherRepositoryModule.Companion.provideVoucherRepositoryImpl(context));
    }

    public VoucherRepositoryImpl get() {
        return provideVoucherRepositoryImpl(this.contextProvider.get());
    }
}
