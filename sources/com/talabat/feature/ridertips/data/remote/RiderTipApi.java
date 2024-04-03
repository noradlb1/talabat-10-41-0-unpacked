package com.talabat.feature.ridertips.data.remote;

import com.talabat.feature.ridertips.data.remote.dto.RiderTipRequest;
import com.talabat.feature.ridertips.data.remote.dto.RiderTipResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/ridertips/data/remote/RiderTipApi;", "", "getRiderTip", "Lcom/talabat/feature/ridertips/data/remote/dto/RiderTipResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRiderTip", "", "riderTipRequest", "Lcom/talabat/feature/ridertips/data/remote/dto/RiderTipRequest;", "(ILcom/talabat/feature/ridertips/data/remote/dto/RiderTipRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RiderTipApi {
    @Nullable
    @GET("v1/rider-tip/{countryId}")
    Object getRiderTip(@Path("countryId") int i11, @NotNull Continuation<? super RiderTipResponse> continuation);

    @POST("v1/rider-tip/{countryId}")
    @Nullable
    Object saveRiderTip(@Path("countryId") int i11, @NotNull @Body RiderTipRequest riderTipRequest, @NotNull Continuation<? super Unit> continuation);
}
