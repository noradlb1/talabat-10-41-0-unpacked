package com.deliveryhero.perseus.hits.usecase;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.repository.PerseusHitsRepository;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/perseus/hits/usecase/GetHitsUseCase;", "", "perseusHitsRepository", "Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "(Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;)V", "run", "Lio/reactivex/Single;", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GetHitsUseCase {
    @NotNull
    private final PerseusHitsRepository perseusHitsRepository;

    public GetHitsUseCase(@NotNull PerseusHitsRepository perseusHitsRepository2) {
        Intrinsics.checkNotNullParameter(perseusHitsRepository2, "perseusHitsRepository");
        this.perseusHitsRepository = perseusHitsRepository2;
    }

    @NotNull
    public final Single<List<HitEvent>> run() {
        return this.perseusHitsRepository.getHitEvents();
    }
}
