package com.talabat.core.safety.data.datasource.api;

import com.talabat.core.safety.data.model.ShieldInfoDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/core/safety/data/datasource/api/ShieldRequestApi;", "", "postProcedure", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "procedure", "Lcom/talabat/core/safety/data/model/ShieldInfoDto;", "(Lcom/talabat/core/safety/data/model/ShieldInfoDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ShieldRequestApi {
    @POST("/tracker/android/")
    @Nullable
    Object postProcedure(@NotNull @Body ShieldInfoDto shieldInfoDto, @NotNull Continuation<? super Response<ResponseBody>> continuation);
}
