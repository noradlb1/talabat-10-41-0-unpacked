package com.talabat.userandlocation.customerinfo.data.remote.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/remote/api/CustomerInfoApi;", "", "getCustomerInfo", "Lcom/talabat/userandlocation/customerinfo/data/remote/api/CustomerInfoResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CustomerInfoApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCustomerInfo$default(CustomerInfoApi customerInfoApi, int i11, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 0;
                }
                return customerInfoApi.getCustomerInfo(i11, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCustomerInfo");
        }
    }

    @Nullable
    @GET("v1/customer/{countryId}")
    Object getCustomerInfo(@Path("countryId") int i11, @NotNull Continuation<? super CustomerInfoResponse> continuation);
}
