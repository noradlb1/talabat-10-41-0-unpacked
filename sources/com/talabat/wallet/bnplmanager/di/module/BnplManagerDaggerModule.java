package com.talabat.wallet.bnplmanager.di.module;

import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSourceImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/bnplmanager/di/module/BnplManagerDaggerModule;", "", "()V", "provideBnplManagerLocalDataSource", "Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class BnplManagerDaggerModule {
    @NotNull
    public static final BnplManagerDaggerModule INSTANCE = new BnplManagerDaggerModule();

    private BnplManagerDaggerModule() {
    }

    @NotNull
    @Provides
    public final BNPLManagerLocalDataSource provideBnplManagerLocalDataSource() {
        return new BNPLManagerLocalDataSourceImpl();
    }
}
