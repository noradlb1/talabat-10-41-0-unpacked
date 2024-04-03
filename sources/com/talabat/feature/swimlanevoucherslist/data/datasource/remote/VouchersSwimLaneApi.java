package com.talabat.feature.swimlanevoucherslist.data.datasource.remote;

import com.talabat.feature.swimlanevoucherslist.data.model.VouchersSwimLaneResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bæ\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ9\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/VouchersSwimLaneApi;", "", "getVouchersSwimLane", "Lcom/talabat/feature/swimlanevoucherslist/data/model/VouchersSwimLaneResponse;", "countryCode", "", "vendorId", "areaId", "", "brandId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VouchersSwimLaneApi {
    @NotNull
    public static final Companion Companion = Companion.f59017a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/VouchersSwimLaneApi$Companion;", "", "()V", "API_VERSION", "", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private static final int API_VERSION = 1;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f59017a = new Companion();

        private Companion() {
        }
    }

    @Nullable
    @GET("v1/{country_code}/vouchers-swimlane")
    Object getVouchersSwimLane(@NotNull @Path("country_code") String str, @NotNull @Query("dhVendorId") String str2, @Query("areaId") int i11, @NotNull @Query("brandId") String str3, @NotNull Continuation<? super VouchersSwimLaneResponse> continuation);
}
