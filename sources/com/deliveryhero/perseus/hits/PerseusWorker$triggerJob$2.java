package com.deliveryhero.perseus.hits;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "invoke", "(Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorker$triggerJob$2 extends Lambda implements Function1<List<? extends HitEvent>, Boolean> {
    public static final PerseusWorker$triggerJob$2 INSTANCE = new PerseusWorker$triggerJob$2();

    public PerseusWorker$triggerJob$2() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull List<HitEvent> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return Boolean.valueOf(!list.isEmpty());
    }
}
