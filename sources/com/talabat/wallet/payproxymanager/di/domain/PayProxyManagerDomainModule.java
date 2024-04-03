package com.talabat.wallet.payproxymanager.di.domain;

import com.talabat.core.network.endpoint.ProxyPayEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.payproxymanager.data.impl.PayProxyManagerRepositoryImpl;
import com.talabat.wallet.payproxymanager.data.remote.api.PayProxyManagerApi;
import com.talabat.wallet.payproxymanager.data.remote.impl.PayProxyManagerRemoteDataSourceImpl;
import com.talabat.wallet.payproxymanager.domain.PayProxyManagerRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/payproxymanager/di/domain/PayProxyManagerDomainModule;", "", "()V", "providePayProxyManagerRepository", "Lcom/talabat/wallet/payproxymanager/domain/PayProxyManagerRepository;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyManagerDomainModule {
    @NotNull
    public static final PayProxyManagerDomainModule INSTANCE = new PayProxyManagerDomainModule();

    private PayProxyManagerDomainModule() {
    }

    @NotNull
    public final PayProxyManagerRepository providePayProxyManagerRepository() {
        return new PayProxyManagerRepositoryImpl(new PayProxyManagerRemoteDataSourceImpl((PayProxyManagerApi) new TalabatAPIBuilder().createApi(ProxyPayEndPointProvider.INSTANCE.getBaseUrl(), PayProxyManagerApi.class)));
    }
}
