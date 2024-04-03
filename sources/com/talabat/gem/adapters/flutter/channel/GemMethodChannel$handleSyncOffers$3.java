package com.talabat.gem.adapters.flutter.channel;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.lib.Integration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemMethodChannel$handleSyncOffers$3 extends Lambda implements Function1<GemOffer, Unit> {
    public static final GemMethodChannel$handleSyncOffers$3 INSTANCE = new GemMethodChannel$handleSyncOffers$3();

    public GemMethodChannel$handleSyncOffers$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemOffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GemOffer gemOffer) {
        IntegrationKt.getDataSources().updateExpiredOffer(BusinessRulesKt.getNullGemOffer());
        Integration.getAppContext().getSharedPreferences(GemViewBusinessRulesKt.FLUTTER_SHARED_PREFS_NAME, 0).edit().putBoolean("flutter.gem.expiration.popup.shown", false).apply();
        IntegrationKt.getDataSources().setExpirationAlertShown(false);
        IntegrationKt.getDataSources().resetTriggerExpirationAlertFlag();
    }
}
