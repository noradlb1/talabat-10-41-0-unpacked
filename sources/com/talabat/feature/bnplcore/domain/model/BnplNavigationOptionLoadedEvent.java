package com.talabat.feature.bnplcore.domain.model;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/model/BnplNavigationOptionLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "eventOrigin", "", "navigationOption", "screenName", "screenType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplNavigationOptionLoadedEvent extends TalabatEvent {
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String navigationOption;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;

    public BnplNavigationOptionLoadedEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        Intrinsics.checkNotNullParameter(str2, "navigationOption");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        Intrinsics.checkNotNullParameter(str4, "screenType");
        this.eventOrigin = str;
        this.navigationOption = str2;
        this.screenName = str3;
        this.screenType = str4;
    }

    private final String component1() {
        return this.eventOrigin;
    }

    private final String component2() {
        return this.navigationOption;
    }

    private final String component3() {
        return this.screenName;
    }

    private final String component4() {
        return this.screenType;
    }

    public static /* synthetic */ BnplNavigationOptionLoadedEvent copy$default(BnplNavigationOptionLoadedEvent bnplNavigationOptionLoadedEvent, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bnplNavigationOptionLoadedEvent.eventOrigin;
        }
        if ((i11 & 2) != 0) {
            str2 = bnplNavigationOptionLoadedEvent.navigationOption;
        }
        if ((i11 & 4) != 0) {
            str3 = bnplNavigationOptionLoadedEvent.screenName;
        }
        if ((i11 & 8) != 0) {
            str4 = bnplNavigationOptionLoadedEvent.screenType;
        }
        return bnplNavigationOptionLoadedEvent.copy(str, str2, str3, str4);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("eventOrigin", this.eventOrigin), TuplesKt.to("navigationOption", this.navigationOption), TuplesKt.to("screenName", this.screenName), TuplesKt.to("screenType", this.screenType));
    }

    @NotNull
    public final BnplNavigationOptionLoadedEvent copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        Intrinsics.checkNotNullParameter(str2, "navigationOption");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        Intrinsics.checkNotNullParameter(str4, "screenType");
        return new BnplNavigationOptionLoadedEvent(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BnplNavigationOptionLoadedEvent)) {
            return false;
        }
        BnplNavigationOptionLoadedEvent bnplNavigationOptionLoadedEvent = (BnplNavigationOptionLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.eventOrigin, (Object) bnplNavigationOptionLoadedEvent.eventOrigin) && Intrinsics.areEqual((Object) this.navigationOption, (Object) bnplNavigationOptionLoadedEvent.navigationOption) && Intrinsics.areEqual((Object) this.screenName, (Object) bnplNavigationOptionLoadedEvent.screenName) && Intrinsics.areEqual((Object) this.screenType, (Object) bnplNavigationOptionLoadedEvent.screenType);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "bnpl_ob_notification";
    }

    public int hashCode() {
        return (((((this.eventOrigin.hashCode() * 31) + this.navigationOption.hashCode()) * 31) + this.screenName.hashCode()) * 31) + this.screenType.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "navigation_option_loaded";
    }

    @NotNull
    public String toString() {
        String str = this.eventOrigin;
        String str2 = this.navigationOption;
        String str3 = this.screenName;
        String str4 = this.screenType;
        return "BnplNavigationOptionLoadedEvent(eventOrigin=" + str + ", navigationOption=" + str2 + ", screenName=" + str3 + ", screenType=" + str4 + ")";
    }
}
