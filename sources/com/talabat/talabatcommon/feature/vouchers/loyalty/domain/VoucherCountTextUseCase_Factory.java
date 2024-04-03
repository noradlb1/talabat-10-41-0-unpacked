package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VoucherCountTextUseCase_Factory implements Factory<VoucherCountTextUseCase> {
    private final Provider<Context> contextProvider;

    public VoucherCountTextUseCase_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static VoucherCountTextUseCase_Factory create(Provider<Context> provider) {
        return new VoucherCountTextUseCase_Factory(provider);
    }

    public static VoucherCountTextUseCase newInstance(Context context) {
        return new VoucherCountTextUseCase(context);
    }

    public VoucherCountTextUseCase get() {
        return newInstance(this.contextProvider.get());
    }
}
