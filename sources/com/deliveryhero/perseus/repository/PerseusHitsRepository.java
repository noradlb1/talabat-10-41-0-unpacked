package com.deliveryhero.perseus.repository;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.remote.api.model.HitsRequest;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bH&J\u001c\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "", "deleteHits", "", "hitValues", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "getHitEvents", "Lio/reactivex/Single;", "insertEvent", "payload", "", "", "perseusHits", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "hitRequest", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusHitsRepository {
    void deleteHits(@NotNull List<HitEvent> list);

    @NotNull
    Single<List<HitEvent>> getHitEvents();

    void insertEvent(@NotNull Map<String, String> map);

    @NotNull
    Single<HitsResponse> perseusHits(@NotNull HitsRequest hitsRequest);
}
