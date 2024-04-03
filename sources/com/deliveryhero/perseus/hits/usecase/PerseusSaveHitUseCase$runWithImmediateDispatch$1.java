package com.deliveryhero.perseus.hits.usecase;

import com.deliveryhero.perseus.data.remote.api.model.HitsResponse;
import com.deliveryhero.perseus.logger.PerseusLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "response", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusSaveHitUseCase$runWithImmediateDispatch$1 extends Lambda implements Function1<HitsResponse, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PerseusSaveHitUseCase f30406g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerseusSaveHitUseCase$runWithImmediateDispatch$1(PerseusSaveHitUseCase perseusSaveHitUseCase) {
        super(1);
        this.f30406g = perseusSaveHitUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HitsResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HitsResponse hitsResponse) {
        PerseusLogger access$getPerseusLogger$p = this.f30406g.perseusLogger;
        PerseusLogger.i$default(access$getPerseusLogger$p, "Send immediate hit to remote: Response " + hitsResponse.getStatus(), (Throwable) null, 2, (Object) null);
    }
}
