package com.deliveryhero.perseus.hits.usecase;

import com.deliveryhero.perseus.logger.PerseusLogger;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Instrumented
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusSaveHitUseCase$runWithImmediateDispatch$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PerseusSaveHitUseCase f30407g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f30408h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerseusSaveHitUseCase$runWithImmediateDispatch$2(PerseusSaveHitUseCase perseusSaveHitUseCase, Map<String, String> map) {
        super(1);
        this.f30407g = perseusSaveHitUseCase;
        this.f30408h = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th2) {
        PerseusLogger access$getPerseusLogger$p = this.f30407g.perseusLogger;
        access$getPerseusLogger$p.e("Error happened while sending hit to remote from Worker! With the following params:" + GsonInstrumentation.toJson(new Gson(), (Object) this.f30408h), th2);
    }
}
