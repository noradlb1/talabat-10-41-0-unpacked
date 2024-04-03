package com.talabat.wallet.bnplmanager.di.module;

import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BnplManagerDaggerModule_ProvideBnplManagerLocalDataSourceFactory implements Factory<BNPLManagerLocalDataSource> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final BnplManagerDaggerModule_ProvideBnplManagerLocalDataSourceFactory INSTANCE = new BnplManagerDaggerModule_ProvideBnplManagerLocalDataSourceFactory();

        private InstanceHolder() {
        }
    }

    public static BnplManagerDaggerModule_ProvideBnplManagerLocalDataSourceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BNPLManagerLocalDataSource provideBnplManagerLocalDataSource() {
        return (BNPLManagerLocalDataSource) Preconditions.checkNotNullFromProvides(BnplManagerDaggerModule.INSTANCE.provideBnplManagerLocalDataSource());
    }

    public BNPLManagerLocalDataSource get() {
        return provideBnplManagerLocalDataSource();
    }
}
