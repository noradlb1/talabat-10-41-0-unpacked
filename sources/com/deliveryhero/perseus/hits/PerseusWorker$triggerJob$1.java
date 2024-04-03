package com.deliveryhero.perseus.hits;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class PerseusWorker$triggerJob$1 extends AdaptedFunctionReference implements Function1<Collection<? extends HitEvent>, Unit> {
    public PerseusWorker$triggerJob$1(Object obj) {
        super(1, obj, List.class, "addAll", "addAll(Ljava/util/Collection;)Z", 8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Collection<HitEvent>) (Collection) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Collection<HitEvent> collection) {
        Intrinsics.checkNotNullParameter(collection, "p0");
        ((List) this.f23889b).addAll(collection);
    }
}
