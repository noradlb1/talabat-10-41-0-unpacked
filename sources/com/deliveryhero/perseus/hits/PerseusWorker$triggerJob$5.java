package com.deliveryhero.perseus.hits;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "event", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorker$triggerJob$5 extends Lambda implements Function1<HitsResponse, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PerseusWorker f30402g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<HitEvent> f30403h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerseusWorker$triggerJob$5(PerseusWorker perseusWorker, List<HitEvent> list) {
        super(1);
        this.f30402g = perseusWorker;
        this.f30403h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HitsResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HitsResponse hitsResponse) {
        PerseusWorker perseusWorker = this.f30402g;
        List<HitEvent> list = this.f30403h;
        Intrinsics.checkNotNullExpressionValue(hitsResponse, "event");
        perseusWorker.onSuccess(list, hitsResponse);
    }
}
