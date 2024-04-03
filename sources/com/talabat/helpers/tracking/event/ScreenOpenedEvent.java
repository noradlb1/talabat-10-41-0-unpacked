package com.talabat.helpers.tracking.event;

import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.helpers.GlobalDataModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0016J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/talabat/helpers/tracking/event/ScreenOpenedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenOpenedEventModel", "Lcom/talabat/helpers/tracking/event/ScreenOpenedEventModel;", "(Lcom/talabat/helpers/tracking/event/ScreenOpenedEventModel;)V", "getScreenOpenedEventModel", "()Lcom/talabat/helpers/tracking/event/ScreenOpenedEventModel;", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "getCartValue", "getScreenType", "getTalabatCredits", "hashCode", "", "isCartEmpty", "name", "platforms", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenOpenedEvent extends TalabatEvent {
    @NotNull
    private final ScreenOpenedEventModel screenOpenedEventModel;

    public ScreenOpenedEvent(@NotNull ScreenOpenedEventModel screenOpenedEventModel2) {
        Intrinsics.checkNotNullParameter(screenOpenedEventModel2, "screenOpenedEventModel");
        this.screenOpenedEventModel = screenOpenedEventModel2;
    }

    public static /* synthetic */ ScreenOpenedEvent copy$default(ScreenOpenedEvent screenOpenedEvent, ScreenOpenedEventModel screenOpenedEventModel2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            screenOpenedEventModel2 = screenOpenedEvent.screenOpenedEventModel;
        }
        return screenOpenedEvent.copy(screenOpenedEventModel2);
    }

    private final String getCartValue() {
        return this.screenOpenedEventModel.getCartSubTotal();
    }

    private final String getScreenType() {
        if (GlobalDataModel.PageOpenFromHelpCenter) {
            return "help_center";
        }
        String screenType = ScreenNames.getScreenType(this.screenOpenedEventModel.getScreenName());
        Intrinsics.checkNotNullExpressionValue(screenType, "{\n            ScreenName…del.screenName)\n        }");
        return screenType;
    }

    private final String getTalabatCredits() {
        if (this.screenOpenedEventModel.isLoggedIn()) {
            return String.valueOf(this.screenOpenedEventModel.getTalabatCredits());
        }
        return "N/A";
    }

    private final String isCartEmpty() {
        return String.valueOf(this.screenOpenedEventModel.getCartHasItems());
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenType", getScreenType()), TuplesKt.to("screenName", this.screenOpenedEventModel.getScreenName()), TuplesKt.to("userOnlinePaymentMethods", getTalabatCredits()), TuplesKt.to(ShopDetailsLoadedEvent.CART_EMPTY, isCartEmpty()), TuplesKt.to("cartValue", getCartValue()));
    }

    @NotNull
    public final ScreenOpenedEventModel component1() {
        return this.screenOpenedEventModel;
    }

    @NotNull
    public final ScreenOpenedEvent copy(@NotNull ScreenOpenedEventModel screenOpenedEventModel2) {
        Intrinsics.checkNotNullParameter(screenOpenedEventModel2, "screenOpenedEventModel");
        return new ScreenOpenedEvent(screenOpenedEventModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScreenOpenedEvent) && Intrinsics.areEqual((Object) this.screenOpenedEventModel, (Object) ((ScreenOpenedEvent) obj).screenOpenedEventModel);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "talabat";
    }

    @NotNull
    public final ScreenOpenedEventModel getScreenOpenedEventModel() {
        return this.screenOpenedEventModel;
    }

    public int hashCode() {
        return this.screenOpenedEventModel.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "screen_opened";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        ScreenOpenedEventModel screenOpenedEventModel2 = this.screenOpenedEventModel;
        return "ScreenOpenedEvent(screenOpenedEventModel=" + screenOpenedEventModel2 + ")";
    }
}
