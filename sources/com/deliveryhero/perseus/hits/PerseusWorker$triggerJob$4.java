package com.deliveryhero.perseus.hits;

import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorker$triggerJob$4 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PerseusWorker f30400g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<HitEvent> f30401h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerseusWorker$triggerJob$4(PerseusWorker perseusWorker, List<HitEvent> list) {
        super(1);
        this.f30400g = perseusWorker;
        this.f30401h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th2) {
        PerseusWorker perseusWorker = this.f30400g;
        List<HitEvent> list = this.f30401h;
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        perseusWorker.onError(list, th2);
    }
}
