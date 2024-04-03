package com.talabat.feature.swimlanevoucherslist.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersBaseUrl;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersSwimLaneApi;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/di/CustomerVoucherSwimLaneNetworkModule;", "", "()V", "provideCustomerVouchersSwimLaneApi", "Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/VouchersSwimLaneApi;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "vouchersBaseUrl", "Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/VouchersBaseUrl;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class CustomerVoucherSwimLaneNetworkModule {
    @NotNull
    public static final CustomerVoucherSwimLaneNetworkModule INSTANCE = new CustomerVoucherSwimLaneNetworkModule();

    private CustomerVoucherSwimLaneNetworkModule() {
    }

    @NotNull
    @Provides
    public final VouchersSwimLaneApi provideCustomerVouchersSwimLaneApi(@NotNull BaseUrlFactory baseUrlFactory, @NotNull VouchersBaseUrl vouchersBaseUrl, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(vouchersBaseUrl, "vouchersBaseUrl");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.baseUrl(baseUrlFactory.baseUrl(vouchersBaseUrl)).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder\n        …rl))\n            .build()");
        return (VouchersSwimLaneApi) build.create(VouchersSwimLaneApi.class);
    }
}
