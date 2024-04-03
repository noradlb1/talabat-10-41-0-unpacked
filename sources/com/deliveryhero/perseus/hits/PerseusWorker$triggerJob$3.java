package com.deliveryhero.perseus.hits;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import com.deliveryhero.perseus.di.HitsModule;
import io.reactivex.MaybeSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/MaybeSource;", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "kotlin.jvm.PlatformType", "hitEvents", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorker$triggerJob$3 extends Lambda implements Function1<List<? extends HitEvent>, MaybeSource<? extends HitsResponse>> {
    public static final PerseusWorker$triggerJob$3 INSTANCE = new PerseusWorker$triggerJob$3();

    public PerseusWorker$triggerJob$3() {
        super(1);
    }

    public final MaybeSource<? extends HitsResponse> invoke(@NotNull List<HitEvent> list) {
        Intrinsics.checkNotNullParameter(list, "hitEvents");
        return HitsModule.INSTANCE.perseusSendHitUseCase().run(list).toMaybe();
    }
}
