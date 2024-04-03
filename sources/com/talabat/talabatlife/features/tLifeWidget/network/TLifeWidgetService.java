package com.talabat.talabatlife.features.tLifeWidget.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusRootResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatlife/features/tLifeWidget/network/TLifeWidgetService;", "Lcom/talabat/talabatlife/features/tLifeWidget/network/TLifeWidgetApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "tLifeWidgetApi", "getTLifeWidgetApi", "()Lcom/talabat/talabatlife/features/tLifeWidget/network/TLifeWidgetApi;", "tLifeWidgetApi$delegate", "Lkotlin/Lazy;", "getUserSubscriptionStatus", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/tLifeWidget/model/TLifeSubscriptionStatusRootResponse;", "country", "", "version", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeWidgetService implements TLifeWidgetApi {
    @NotNull
    private final Lazy tLifeWidgetApi$delegate;

    public TLifeWidgetService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.tLifeWidgetApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TLifeWidgetService$tLifeWidgetApi$2(talabatAPIBuilder));
    }

    private final TLifeWidgetApi getTLifeWidgetApi() {
        return (TLifeWidgetApi) this.tLifeWidgetApi$delegate.getValue();
    }

    @NotNull
    public Call<TLifeSubscriptionStatusRootResponse> getUserSubscriptionStatus(int i11, int i12) {
        return getTLifeWidgetApi().getUserSubscriptionStatus(i11, i12);
    }
}
