package com.talabat.gem.adapters.analytics;

import JsonModels.PolygonEvents;
import android.app.Application;
import com.talabat.gem.domain.entities.GemRestaurant;
import datamodels.Restaurant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tracking.ScreenNames;
import tracking.ShopClickedEvent;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemAnalytics$onShopClicked$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAnalytics f59861g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemRestaurant f59862h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f59863i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAnalytics$onShopClicked$2(GemAnalytics gemAnalytics, GemRestaurant gemRestaurant, String str) {
        super(0);
        this.f59861g = gemAnalytics;
        this.f59862h = gemRestaurant;
        this.f59863i = str;
    }

    public final void invoke() {
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        Application application = this.f59861g.getApplication();
        Restaurant data = this.f59862h.getData();
        String str = this.f59863i;
        String screenType = ScreenNames.getScreenType("Restaurant List Screen");
        ShopClickedEvent.EventOriginSourceDelegate eventOriginSourceDelegate = r15;
        ShopClickedEvent.EventOriginSourceDelegate eventOriginSourceDelegate2 = new ShopClickedEvent.EventOriginSourceDelegate();
        companion.restaurantClicked(application, false, data, "", "", "", str, screenType, "", (PolygonEvents) null, "list_view", (HashMap<String, String>) null, eventOriginSourceDelegate, true, (String) null, (Integer) null, (Integer) null);
    }
}
