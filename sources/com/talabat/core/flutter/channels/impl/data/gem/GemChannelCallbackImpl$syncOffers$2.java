package com.talabat.core.flutter.channels.impl.data.gem;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemChannelCallbackImpl$syncOffers$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final GemChannelCallbackImpl$syncOffers$2 INSTANCE = new GemChannelCallbackImpl$syncOffers$2();

    public GemChannelCallbackImpl$syncOffers$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        String message = th2.getMessage();
        analytics.observeGemSyncOffers("Error while saving the offer: " + message);
    }
}
