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
import tracking.ShopClickedEvent;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemAnalytics$onGemCollectionRestaurantLoaded$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAnalytics f59833g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f59834h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f59835i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAnalytics$onGemCollectionRestaurantLoaded$1(GemAnalytics gemAnalytics, String str, String str2) {
        super(0);
        this.f59833g = gemAnalytics;
        this.f59834h = str;
        this.f59835i = str2;
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
        final GemAnalytics gemAnalytics = this.f59833g;
        final String str = this.f59834h;
        final String str2 = this.f59835i;
        CoroutinesKt.runHandling(r02, new Function0<Unit>() {
            public final void invoke() {
                TalabatGTM.Companion companion = TalabatGTM.Companion;
                Application application = gemAnalytics.getApplication();
                GemOffer gemOffer = (GemOffer) RxKt.invoke(gemAnalytics.getOffer());
                List<GemRestaurant> list = null;
                String id2 = gemOffer != null ? gemOffer.getId() : null;
                String str = str;
                String str2 = str2;
                GemOffer gemOffer2 = (GemOffer) RxKt.invoke(gemAnalytics.getOffer());
                if (gemOffer2 != null) {
                    list = gemOffer2.getRestaurants();
                }
                companion.gemCollectionsListUpdated(application, id2, "All", "", "GEM", str, str2, GemAnalyticsKt.generateShopIds(list), new ShopClickedEvent.EventOriginSourceDelegate());
            }
        });
    }
}
