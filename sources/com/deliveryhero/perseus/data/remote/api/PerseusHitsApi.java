package com.deliveryhero.perseus.data.remote.api;

import com.deliveryhero.perseus.data.remote.api.model.HitsRequest;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/PerseusHitsApi;", "", "sendEventsHits", "Lio/reactivex/Single;", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "brand", "", "request", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusHitsApi {
    @NotNull
    public static final Companion Companion = Companion.f30399a;
    @NotNull
    public static final String HITS = "/v1/insert/{brand}/hits";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/PerseusHitsApi$Companion;", "", "()V", "HITS", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String HITS = "/v1/insert/{brand}/hits";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f30399a = new Companion();

        private Companion() {
        }
    }

    @NotNull
    @POST("/v1/insert/{brand}/hits")
    @Headers({"Content-Type: application/json"})
    Single<HitsResponse> sendEventsHits(@NotNull @Path("brand") String str, @NotNull @Body HitsRequest hitsRequest);
}
