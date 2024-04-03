package com.talabat.talabatcommon.feature.vouchers.monolith.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/MonolithService;", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/MonolithApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "getApi", "()Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/MonolithApi;", "api$delegate", "Lkotlin/Lazy;", "getMenuItems", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsRootResponse;", "apiVersion", "", "id", "", "branchId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MonolithService implements MonolithApi {
    @NotNull
    private final Lazy api$delegate;

    public MonolithService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new MonolithService$api$2(talabatAPIBuilder));
    }

    private final MonolithApi getApi() {
        return (MonolithApi) this.api$delegate.getValue();
    }

    @NotNull
    public Call<VoucherItemsRootResponse> getMenuItems(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        return getApi().getMenuItems(i11, str, str2);
    }
}
