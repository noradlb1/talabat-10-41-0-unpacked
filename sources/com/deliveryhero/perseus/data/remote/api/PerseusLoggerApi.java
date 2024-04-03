package com.deliveryhero.perseus.data.remote.api;

import com.deliveryhero.perseus.data.remote.api.model.BackLogInfoRequest;
import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/PerseusLoggerApi;", "", "logBackInfo", "Lio/reactivex/Completable;", "infoRequest", "Lcom/deliveryhero/perseus/data/remote/api/model/BackLogInfoRequest;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusLoggerApi {
    @NotNull
    @POST("/v1/logging/queue/status")
    @Headers({"Content-Type: application/json"})
    Completable logBackInfo(@NotNull @Body BackLogInfoRequest backLogInfoRequest);
}
