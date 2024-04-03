package com.deliveryhero.perseus.data.remote;

import com.deliveryhero.perseus.data.remote.api.model.HitsRequest;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/PerseusHitsRemoteDataStore;", "", "sendEventsHits", "Lio/reactivex/Single;", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "hitRequest", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusHitsRemoteDataStore {
    @NotNull
    Single<HitsResponse> sendEventsHits(@NotNull HitsRequest hitsRequest);
}
