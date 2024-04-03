package com.talabat.talabatcommon.views.wallet.qpaydeflection.di.module;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.network.endpoint.QPayEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.data.impl.CheckoutPaymentManagerRepositoryImpl;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.impl.QPayDeflectionRepositoryImpl;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.QPayDeflectionRemoteDataSource;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.api.QPayDeflectionApi;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.impl.QPayDeflectionRemoteDataSourceImpl;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.application.GetQPayDeflectionEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayFallbackEnabled;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.repository.QPayDeflectionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/di/module/QPayDomainModule;", "", "()V", "provideGetQPayDeflectionBinsUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionBinsUseCase;", "flag", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "provideGetQPayDeflectionSavedCardUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionSavedCardUseCase;", "provideIsQPayFallbackEnabled", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayFallbackEnabled;", "provideIsQPayServiceDownUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayServiceDownUseCase;", "provideQPayDeflectionRemoteDataSource", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/data/remote/QPayDeflectionRemoteDataSource;", "provideQPayDeflectionRepository", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/repository/QPayDeflectionRepository;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDomainModule {
    @NotNull
    public static final QPayDomainModule INSTANCE = new QPayDomainModule();

    private QPayDomainModule() {
    }

    private final QPayDeflectionRemoteDataSource provideQPayDeflectionRemoteDataSource() {
        return new QPayDeflectionRemoteDataSourceImpl((QPayDeflectionApi) new TalabatAPIBuilder().createApi(QPayEndPointProvider.INSTANCE.getBaseUrl(), QPayDeflectionApi.class));
    }

    @NotNull
    public final GetQPayDeflectionBinsUseCase provideGetQPayDeflectionBinsUseCase(@NotNull FWFKey fWFKey, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(fWFKey, "flag");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        return new GetQPayDeflectionBinsUseCase(provideQPayDeflectionRepository(), new GetQPayDeflectionEnabledUseCase(iTalabatFeatureFlag, fWFKey));
    }

    @NotNull
    public final GetQPayDeflectionSavedCardUseCase provideGetQPayDeflectionSavedCardUseCase(@NotNull FWFKey fWFKey, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(fWFKey, "flag");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        return new GetQPayDeflectionSavedCardUseCase(new CheckoutPaymentManagerRepositoryImpl(), provideGetQPayDeflectionBinsUseCase(fWFKey, iTalabatFeatureFlag));
    }

    @NotNull
    public final IsQPayFallbackEnabled provideIsQPayFallbackEnabled(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        return new IsQPayFallbackEnabled(iTalabatFeatureFlag);
    }

    @NotNull
    public final IsQPayServiceDownUseCase provideIsQPayServiceDownUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        return new IsQPayServiceDownUseCase(provideQPayDeflectionRepository(), provideIsQPayFallbackEnabled(iTalabatFeatureFlag));
    }

    @NotNull
    public final QPayDeflectionRepository provideQPayDeflectionRepository() {
        return new QPayDeflectionRepositoryImpl(provideQPayDeflectionRemoteDataSource());
    }
}
