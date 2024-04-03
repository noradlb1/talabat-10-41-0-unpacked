package com.deliveryhero.perseus.hits.usecase;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import com.deliveryhero.perseus.repository.PerseusHitsRepository;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/perseus/hits/usecase/PerseusSendHitUseCase;", "", "perseusHitsRepository", "Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;", "perseusHitsRequestProvider", "Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProvider;", "scheduler", "Lio/reactivex/Scheduler;", "(Lcom/deliveryhero/perseus/repository/PerseusHitsRepository;Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProvider;Lio/reactivex/Scheduler;)V", "run", "Lio/reactivex/Single;", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "hitEvents", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusSendHitUseCase {
    @NotNull
    private final PerseusHitsRepository perseusHitsRepository;
    @NotNull
    private final PerseusHitsRequestProvider perseusHitsRequestProvider;
    @NotNull
    private final Scheduler scheduler;

    public PerseusSendHitUseCase(@NotNull PerseusHitsRepository perseusHitsRepository2, @NotNull PerseusHitsRequestProvider perseusHitsRequestProvider2, @NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(perseusHitsRepository2, "perseusHitsRepository");
        Intrinsics.checkNotNullParameter(perseusHitsRequestProvider2, "perseusHitsRequestProvider");
        Intrinsics.checkNotNullParameter(scheduler2, "scheduler");
        this.perseusHitsRepository = perseusHitsRepository2;
        this.perseusHitsRequestProvider = perseusHitsRequestProvider2;
        this.scheduler = scheduler2;
    }

    @NotNull
    public final Single<HitsResponse> run(@NotNull List<HitEvent> list) {
        Intrinsics.checkNotNullParameter(list, "hitEvents");
        Single<HitsResponse> subscribeOn = this.perseusHitsRepository.perseusHits(this.perseusHitsRequestProvider.provideRequestParams(list)).subscribeOn(this.scheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "perseusHitsRepository.pe…  .subscribeOn(scheduler)");
        return subscribeOn;
    }
}
