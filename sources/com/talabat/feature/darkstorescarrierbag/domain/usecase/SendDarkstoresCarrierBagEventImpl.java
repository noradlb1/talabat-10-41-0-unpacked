package com.talabat.feature.darkstorescarrierbag.domain.usecase;

import cm.a;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.darkstorescarrierbag.domain.event.DarkstoresCarrierBagEvent;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SendDarkstoresCarrierBagEventImpl;", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SendDarkstoresCarrierBagEvent;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "invoke", "Lio/reactivex/Completable;", "eventName", "", "vendorCode", "popupButton", "com_talabat_feature_darkstores-carrier-bag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendDarkstoresCarrierBagEventImpl implements SendDarkstoresCarrierBagEvent {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public SendDarkstoresCarrierBagEventImpl(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Unit m10155invoke$lambda0(SendDarkstoresCarrierBagEventImpl sendDarkstoresCarrierBagEventImpl, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(sendDarkstoresCarrierBagEventImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$eventName");
        Intrinsics.checkNotNullParameter(str2, "$vendorCode");
        Intrinsics.checkNotNullParameter(str3, "$popupButton");
        sendDarkstoresCarrierBagEventImpl.talabatTracker.track(new DarkstoresCarrierBagEvent(str, str2, str3));
        return Unit.INSTANCE;
    }

    @NotNull
    public Completable invoke(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.POPUP_BUTTON);
        Completable fromCallable = Completable.fromCallable(new a(this, str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …)\n            )\n        }");
        return fromCallable;
    }
}
