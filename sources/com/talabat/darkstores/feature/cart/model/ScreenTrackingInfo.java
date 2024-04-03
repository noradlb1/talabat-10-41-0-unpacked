package com.talabat.darkstores.feature.cart.model;

import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "screenType", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "(Lcom/talabat/darkstores/feature/tracking/EventOriginType;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;)V", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getScreenName", "()Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "getScreenType", "()Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenTrackingInfo {
    @NotNull
    private final EventOriginType eventOriginType;
    @NotNull
    private final ScreenTrackingProvider.ScreenName screenName;
    @NotNull
    private final ScreenTrackingProvider.ScreenType screenType;

    public ScreenTrackingInfo(@NotNull EventOriginType eventOriginType2, @NotNull ScreenTrackingProvider.ScreenName screenName2, @NotNull ScreenTrackingProvider.ScreenType screenType2) {
        Intrinsics.checkNotNullParameter(eventOriginType2, "eventOriginType");
        Intrinsics.checkNotNullParameter(screenName2, "screenName");
        Intrinsics.checkNotNullParameter(screenType2, "screenType");
        this.eventOriginType = eventOriginType2;
        this.screenName = screenName2;
        this.screenType = screenType2;
    }

    public static /* synthetic */ ScreenTrackingInfo copy$default(ScreenTrackingInfo screenTrackingInfo, EventOriginType eventOriginType2, ScreenTrackingProvider.ScreenName screenName2, ScreenTrackingProvider.ScreenType screenType2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            eventOriginType2 = screenTrackingInfo.eventOriginType;
        }
        if ((i11 & 2) != 0) {
            screenName2 = screenTrackingInfo.screenName;
        }
        if ((i11 & 4) != 0) {
            screenType2 = screenTrackingInfo.screenType;
        }
        return screenTrackingInfo.copy(eventOriginType2, screenName2, screenType2);
    }

    @NotNull
    public final EventOriginType component1() {
        return this.eventOriginType;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenName component2() {
        return this.screenName;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenType component3() {
        return this.screenType;
    }

    @NotNull
    public final ScreenTrackingInfo copy(@NotNull EventOriginType eventOriginType2, @NotNull ScreenTrackingProvider.ScreenName screenName2, @NotNull ScreenTrackingProvider.ScreenType screenType2) {
        Intrinsics.checkNotNullParameter(eventOriginType2, "eventOriginType");
        Intrinsics.checkNotNullParameter(screenName2, "screenName");
        Intrinsics.checkNotNullParameter(screenType2, "screenType");
        return new ScreenTrackingInfo(eventOriginType2, screenName2, screenType2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenTrackingInfo)) {
            return false;
        }
        ScreenTrackingInfo screenTrackingInfo = (ScreenTrackingInfo) obj;
        return this.eventOriginType == screenTrackingInfo.eventOriginType && this.screenName == screenTrackingInfo.screenName && this.screenType == screenTrackingInfo.screenType;
    }

    @NotNull
    public final EventOriginType getEventOriginType() {
        return this.eventOriginType;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenName getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final ScreenTrackingProvider.ScreenType getScreenType() {
        return this.screenType;
    }

    public int hashCode() {
        return (((this.eventOriginType.hashCode() * 31) + this.screenName.hashCode()) * 31) + this.screenType.hashCode();
    }

    @NotNull
    public String toString() {
        EventOriginType eventOriginType2 = this.eventOriginType;
        ScreenTrackingProvider.ScreenName screenName2 = this.screenName;
        ScreenTrackingProvider.ScreenType screenType2 = this.screenType;
        return "ScreenTrackingInfo(eventOriginType=" + eventOriginType2 + ", screenName=" + screenName2 + ", screenType=" + screenType2 + ")";
    }
}
