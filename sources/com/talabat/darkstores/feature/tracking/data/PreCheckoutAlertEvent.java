package com.talabat.darkstores.feature.tracking.data;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/PreCheckoutAlertEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreCheckoutAlertEvent extends TalabatEvent {
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String screenName;

    public PreCheckoutAlertEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        this.screenName = str;
        this.eventOrigin = str2;
    }

    private final String component1() {
        return this.screenName;
    }

    private final String component2() {
        return this.eventOrigin;
    }

    public static /* synthetic */ PreCheckoutAlertEvent copy$default(PreCheckoutAlertEvent preCheckoutAlertEvent, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = preCheckoutAlertEvent.screenName;
        }
        if ((i11 & 2) != 0) {
            str2 = preCheckoutAlertEvent.eventOrigin;
        }
        return preCheckoutAlertEvent.copy(str, str2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", this.screenName), TuplesKt.to("screenType", PreCheckoutEventsKt.SCREEN_TYPE_VALUE), TuplesKt.to(FeeTrackingConstantsKt.ATTRIBUTE_ALERT_TYPE, "replacement_alert"), TuplesKt.to("eventOrigin", this.eventOrigin));
    }

    @NotNull
    public final PreCheckoutAlertEvent copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        return new PreCheckoutAlertEvent(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreCheckoutAlertEvent)) {
            return false;
        }
        PreCheckoutAlertEvent preCheckoutAlertEvent = (PreCheckoutAlertEvent) obj;
        return Intrinsics.areEqual((Object) this.screenName, (Object) preCheckoutAlertEvent.screenName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) preCheckoutAlertEvent.eventOrigin);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pre_checkout";
    }

    public int hashCode() {
        return (this.screenName.hashCode() * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingConstantsKt.EVENT_ALERT_SHOWN;
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        String str2 = this.eventOrigin;
        return "PreCheckoutAlertEvent(screenName=" + str + ", eventOrigin=" + str2 + ")";
    }
}
