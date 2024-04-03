package com.deliveryhero.perseus.hits;

import androidx.work.ListenableWorker;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "it", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorker$triggerJob$6 extends Lambda implements Function1<HitsResponse, ListenableWorker.Result> {
    public static final PerseusWorker$triggerJob$6 INSTANCE = new PerseusWorker$triggerJob$6();

    public PerseusWorker$triggerJob$6() {
        super(1);
    }

    public final ListenableWorker.Result invoke(@NotNull HitsResponse hitsResponse) {
        Intrinsics.checkNotNullParameter(hitsResponse, "it");
        return ListenableWorker.Result.success();
    }
}
