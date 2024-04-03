package com.talabat.riderinfo.data.datasource.remote;

import com.talabat.riderinfo.data.dto.RiderInfoDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/riderinfo/data/datasource/remote/PoeRetrofitService;", "", "getRiderInfo", "Lcom/talabat/riderinfo/data/dto/RiderInfoDto;", "orderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PoeRetrofitService {
    @Nullable
    @GET("/api/v1/Chat")
    Object getRiderInfo(@NotNull @Query("orderId") String str, @NotNull Continuation<? super RiderInfoDto> continuation);
}
