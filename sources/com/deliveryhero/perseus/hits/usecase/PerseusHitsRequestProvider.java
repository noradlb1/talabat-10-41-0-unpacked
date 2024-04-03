package com.deliveryhero.perseus.hits.usecase;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.remote.api.model.HitsRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProvider;", "", "provideRequestParams", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "hits", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "params", "", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerseusHitsRequestProvider {
    @NotNull
    HitsRequest provideRequestParams(@NotNull List<HitEvent> list);

    @NotNull
    HitsRequest provideRequestParams(@NotNull Map<String, String> map);
}
