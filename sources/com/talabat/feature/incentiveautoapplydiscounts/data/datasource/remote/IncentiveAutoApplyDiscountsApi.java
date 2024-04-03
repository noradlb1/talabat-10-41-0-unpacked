package com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote;

import com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJM\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/remote/IncentiveAutoApplyDiscountsApi;", "", "getAutoApplyDiscounts", "Lcom/talabat/feature/incentiveautoapplydiscounts/data/model/AutoApplyDiscountResponse;", "countryId", "", "areaId", "brandId", "branchId", "subTotalAmount", "", "orderDeliveryMode", "(IIIIDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_feature_incentive-auto-apply-discounts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IncentiveAutoApplyDiscountsApi {
    @NotNull
    public static final Companion Companion = Companion.f58562a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/remote/IncentiveAutoApplyDiscountsApi$Companion;", "", "()V", "AAD_API_VERSION", "", "com_talabat_feature_incentive-auto-apply-discounts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private static final int AAD_API_VERSION = 1;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f58562a = new Companion();

        private Companion() {
        }
    }

    @Nullable
    @GET("api/v1/auto-applied-discounts/active-campaigns")
    Object getAutoApplyDiscounts(@Query("country") int i11, @Query("areaId") int i12, @Query("brandId") int i13, @Query("branchId") int i14, @Query("subTotalAmount") double d11, @Query("orderDeliveryMode") int i15, @NotNull Continuation<? super AutoApplyDiscountResponse> continuation);
}
