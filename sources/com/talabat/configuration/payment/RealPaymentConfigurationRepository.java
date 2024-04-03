package com.talabat.configuration.payment;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.payment.mapper.PaymentConfigMapper;
import com.talabat.configuration.payment.mapper.WalletConfigMapper;
import com.talabat.configuration.remote.model.AppInfoEntity;
import dagger.Reusable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/configuration/payment/RealPaymentConfigurationRepository;", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "appInfoContainer", "Lcom/talabat/configuration/AppInfoContainer;", "mapper", "Lcom/talabat/configuration/payment/mapper/PaymentConfigMapper;", "walletMapper", "Lcom/talabat/configuration/payment/mapper/WalletConfigMapper;", "(Lcom/talabat/configuration/AppInfoContainer;Lcom/talabat/configuration/payment/mapper/PaymentConfigMapper;Lcom/talabat/configuration/payment/mapper/WalletConfigMapper;)V", "config", "Lcom/talabat/configuration/payment/PaymentConfig;", "walletConfig", "Lcom/talabat/configuration/payment/WalletConfig;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class RealPaymentConfigurationRepository implements PaymentConfigurationRepository {
    @NotNull
    private final AppInfoContainer appInfoContainer;
    @NotNull
    private final PaymentConfigMapper mapper;
    @NotNull
    private final WalletConfigMapper walletMapper;

    @Inject
    public RealPaymentConfigurationRepository(@NotNull AppInfoContainer appInfoContainer2, @NotNull PaymentConfigMapper paymentConfigMapper, @NotNull WalletConfigMapper walletConfigMapper) {
        Intrinsics.checkNotNullParameter(appInfoContainer2, "appInfoContainer");
        Intrinsics.checkNotNullParameter(paymentConfigMapper, "mapper");
        Intrinsics.checkNotNullParameter(walletConfigMapper, "walletMapper");
        this.appInfoContainer = appInfoContainer2;
        this.mapper = paymentConfigMapper;
        this.walletMapper = walletConfigMapper;
    }

    @NotNull
    public PaymentConfig config() {
        PaymentConfig apply;
        AppInfoEntity cachedAppInfoEntity = this.appInfoContainer.getCachedAppInfoEntity();
        if (cachedAppInfoEntity == null || (apply = this.mapper.apply(cachedAppInfoEntity)) == null) {
            return PaymentConfig.Companion.getDEFAULT();
        }
        return apply;
    }

    @NotNull
    public WalletConfig walletConfig() {
        WalletConfig apply;
        AppInfoEntity cachedAppInfoEntity = this.appInfoContainer.getCachedAppInfoEntity();
        if (cachedAppInfoEntity == null || (apply = this.walletMapper.apply(cachedAppInfoEntity)) == null) {
            return WalletConfig.Companion.getDEFAULT();
        }
        return apply;
    }
}
