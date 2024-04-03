package com.talabat.wallet.bnplmanager.domain.tracking.event;

import buisnessmodels.Cart;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import datamodels.Restaurant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAdjust;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\tHÖ\u0003J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\t\u0010\u0017\u001a\u00020\bHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/BnplFakeTestSubmissionEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "isBnplNotify", "", "isBnplFeedback", "(ZZ)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplFakeTestSubmissionEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "bnpl_submit_clicked_temp";
    private final boolean isBnplFeedback;
    private final boolean isBnplNotify;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/BnplFakeTestSubmissionEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BnplFakeTestSubmissionEvent(boolean z11, boolean z12) {
        this.isBnplNotify = z11;
        this.isBnplFeedback = z12;
    }

    private final boolean component1() {
        return this.isBnplNotify;
    }

    private final boolean component2() {
        return this.isBnplFeedback;
    }

    public static /* synthetic */ BnplFakeTestSubmissionEvent copy$default(BnplFakeTestSubmissionEvent bnplFakeTestSubmissionEvent, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = bnplFakeTestSubmissionEvent.isBnplNotify;
        }
        if ((i11 & 2) != 0) {
            z12 = bnplFakeTestSubmissionEvent.isBnplFeedback;
        }
        return bnplFakeTestSubmissionEvent.copy(z11, z12);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("cartValue", String.valueOf(Cart.getInstance().getCartTotalPrice()));
        pairArr[1] = TuplesKt.to("userOnlinePaymentMethods", "N/A");
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            str = Integer.valueOf(restaurant.shopType).toString();
        } else {
            str = null;
        }
        pairArr[2] = TuplesKt.to(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL, str);
        pairArr[3] = TuplesKt.to("surchargeValue", String.valueOf(Cart.getInstance().getAllRestaurantFees()));
        pairArr[4] = TuplesKt.to(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_BNPL_NOTIFY, String.valueOf(this.isBnplNotify));
        pairArr[5] = TuplesKt.to(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_BNPL_FEEDBACK, String.valueOf(this.isBnplFeedback));
        pairArr[6] = TuplesKt.to("currencyCode", TalabatAdjust.getSelectedCurrencyCode());
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public final BnplFakeTestSubmissionEvent copy(boolean z11, boolean z12) {
        return new BnplFakeTestSubmissionEvent(z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BnplFakeTestSubmissionEvent)) {
            return false;
        }
        BnplFakeTestSubmissionEvent bnplFakeTestSubmissionEvent = (BnplFakeTestSubmissionEvent) obj;
        return this.isBnplNotify == bnplFakeTestSubmissionEvent.isBnplNotify && this.isBnplFeedback == bnplFakeTestSubmissionEvent.isBnplFeedback;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "BNPL";
    }

    public int hashCode() {
        boolean z11 = this.isBnplNotify;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.isBnplFeedback;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isBnplNotify;
        boolean z12 = this.isBnplFeedback;
        return "BnplFakeTestSubmissionEvent(isBnplNotify=" + z11 + ", isBnplFeedback=" + z12 + ")";
    }
}
