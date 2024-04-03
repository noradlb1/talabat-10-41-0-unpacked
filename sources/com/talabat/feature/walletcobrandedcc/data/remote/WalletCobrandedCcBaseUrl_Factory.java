package com.talabat.feature.walletcobrandedcc.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletCobrandedCcBaseUrl_Factory implements Factory<WalletCobrandedCcBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final WalletCobrandedCcBaseUrl_Factory INSTANCE = new WalletCobrandedCcBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static WalletCobrandedCcBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static WalletCobrandedCcBaseUrl newInstance() {
        return new WalletCobrandedCcBaseUrl();
    }

    public WalletCobrandedCcBaseUrl get() {
        return newInstance();
    }
}
