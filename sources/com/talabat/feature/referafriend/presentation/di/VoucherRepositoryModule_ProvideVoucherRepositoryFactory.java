package com.talabat.feature.referafriend.presentation.di;

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
public final class VoucherRepositoryModule_ProvideVoucherRepositoryFactory implements Factory<VoucherRepositoryImpl> {
    private final Provider<Context> contextProvider;

    public VoucherRepositoryModule_ProvideVoucherRepositoryFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static VoucherRepositoryModule_ProvideVoucherRepositoryFactory create(Provider<Context> provider) {
        return new VoucherRepositoryModule_ProvideVoucherRepositoryFactory(provider);
    }

    public static VoucherRepositoryImpl provideVoucherRepository(Context context) {
        return (VoucherRepositoryImpl) Preconditions.checkNotNullFromProvides(VoucherRepositoryModule.INSTANCE.provideVoucherRepository(context));
    }

    public VoucherRepositoryImpl get() {
        return provideVoucherRepository(this.contextProvider.get());
    }
}
