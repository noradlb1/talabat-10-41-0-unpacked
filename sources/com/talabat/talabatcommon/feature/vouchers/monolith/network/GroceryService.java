package com.talabat.talabatcommon.feature.vouchers.monolith.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.GroceryItemDetailsResponse;
import com.talabat.talabatcommon.feature.vouchers.monolith.network.GroceryApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/GroceryService;", "", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/GroceryApi;", "getApi", "()Lcom/talabat/talabatcommon/feature/vouchers/monolith/network/GroceryApi;", "api$delegate", "Lkotlin/Lazy;", "getGroceryItemDetails", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/GroceryItemDetailsResponse;", "groceryVendorId", "", "sku", "countryCode", "language", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryService {
    @NotNull
    private final Lazy api$delegate;

    public GroceryService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new GroceryService$api$2(talabatAPIBuilder));
    }

    private final GroceryApi getApi() {
        return (GroceryApi) this.api$delegate.getValue();
    }

    @NotNull
    public final Call<GroceryItemDetailsResponse> getGroceryItemDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "groceryVendorId");
        Intrinsics.checkNotNullParameter(str2, "sku");
        Intrinsics.checkNotNullParameter(str3, "countryCode");
        Intrinsics.checkNotNullParameter(str4, ConstantsKt.ADJUST_LANGUAGE);
        return GroceryApi.DefaultImpls.getProductDetailsBySku$default(getApi(), str, str2, (String) null, str3, str4, 4, (Object) null);
    }
}
