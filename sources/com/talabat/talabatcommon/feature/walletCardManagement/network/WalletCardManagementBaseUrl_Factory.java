package com.talabat.talabatcommon.feature.walletCardManagement.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletCardManagementBaseUrl_Factory implements Factory<WalletCardManagementBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final WalletCardManagementBaseUrl_Factory INSTANCE = new WalletCardManagementBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static WalletCardManagementBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static WalletCardManagementBaseUrl newInstance() {
        return new WalletCardManagementBaseUrl();
    }

    public WalletCardManagementBaseUrl get() {
        return newInstance();
    }
}
