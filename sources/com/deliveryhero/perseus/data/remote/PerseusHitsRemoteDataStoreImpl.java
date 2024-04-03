package com.deliveryhero.perseus.data.remote;

import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.data.remote.api.PerseusHitsApi;
import com.deliveryhero.perseus.data.remote.api.model.HitsRequest;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/PerseusHitsRemoteDataStoreImpl;", "Lcom/deliveryhero/perseus/data/remote/PerseusHitsRemoteDataStore;", "perseusHitsApi", "Lcom/deliveryhero/perseus/data/remote/api/PerseusHitsApi;", "configProvider", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "(Lcom/deliveryhero/perseus/data/remote/api/PerseusHitsApi;Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;)V", "sendEventsHits", "Lio/reactivex/Single;", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "hitRequest", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusHitsRemoteDataStoreImpl implements PerseusHitsRemoteDataStore {
    @NotNull
    private final PerseusConfigProvider configProvider;
    @NotNull
    private final PerseusHitsApi perseusHitsApi;

    public PerseusHitsRemoteDataStoreImpl(@NotNull PerseusHitsApi perseusHitsApi2, @NotNull PerseusConfigProvider perseusConfigProvider) {
        Intrinsics.checkNotNullParameter(perseusHitsApi2, "perseusHitsApi");
        Intrinsics.checkNotNullParameter(perseusConfigProvider, "configProvider");
        this.perseusHitsApi = perseusHitsApi2;
        this.configProvider = perseusConfigProvider;
    }

    @NotNull
    public Single<HitsResponse> sendEventsHits(@NotNull HitsRequest hitsRequest) {
        Intrinsics.checkNotNullParameter(hitsRequest, "hitRequest");
        return this.perseusHitsApi.sendEventsHits(this.configProvider.provideConfig().getEntity(), hitsRequest);
    }
}
