package com.talabat.gem.adapters.analytics;

import android.app.Application;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.logging.LoggerPort;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcommon.extentions.RxKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemAnalytics$onGemHomeSwimlaneShown$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAnalytics f59843g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAnalytics$onGemHomeSwimlaneShown$1(GemAnalytics gemAnalytics) {
        super(0);
        this.f59843g = gemAnalytics;
    }

    public final void invoke() {
        AnonymousClass1 r02 = new Function1<Throwable, Unit>(IntegrationKt.getLogger()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((LoggerPort) this.receiver).logError(th2);
            }
        };
        final GemAnalytics gemAnalytics = this.f59843g;
        CoroutinesKt.runHandling(r02, new Function0<Unit>() {
            public final void invoke() {
                List<GemRestaurant> restaurants;
                IntegrationKt.getLogger().logMessage("GemAnalytics", "onGemHomeSwimlaneShown()");
                IntegrationKt.getLogger().logMessage("GemAnalytics", GemLightboxShownEvent.EVENT_NAME);
                TalabatGTM.Companion companion = TalabatGTM.Companion;
                Application application = gemAnalytics.getApplication();
                GemOffer gemOffer = (GemOffer) RxKt.invoke(gemAnalytics.getOffer());
                String id2 = gemOffer != null ? gemOffer.getId() : null;
                GemOffer gemOffer2 = (GemOffer) RxKt.invoke(gemAnalytics.getOffer());
                companion.onJokerLightboxShown(application, id2, (gemOffer2 == null || (restaurants = gemOffer2.getRestaurants()) == null) ? null : Integer.valueOf(restaurants.size()), "GEM", "Home Screen", "home");
            }
        });
    }
}
