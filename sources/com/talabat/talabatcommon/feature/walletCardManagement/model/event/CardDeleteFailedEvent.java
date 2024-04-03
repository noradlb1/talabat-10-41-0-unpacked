package com.talabat.talabatcommon.feature.walletCardManagement.model.event;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/event/CardDeleteFailedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "screenType", "errorCode", "errorMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardDeleteFailedEvent extends TalabatEvent {
    @NotNull
    private final String errorCode;
    @NotNull
    private final String errorMessage;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;

    public CardDeleteFailedEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "errorCode");
        Intrinsics.checkNotNullParameter(str4, "errorMessage");
        this.screenName = str;
        this.screenType = str2;
        this.errorCode = str3;
        this.errorMessage = str4;
    }

    private final String component1() {
        return this.screenName;
    }

    private final String component2() {
        return this.screenType;
    }

    private final String component3() {
        return this.errorCode;
    }

    private final String component4() {
        return this.errorMessage;
    }

    public static /* synthetic */ CardDeleteFailedEvent copy$default(CardDeleteFailedEvent cardDeleteFailedEvent, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cardDeleteFailedEvent.screenName;
        }
        if ((i11 & 2) != 0) {
            str2 = cardDeleteFailedEvent.screenType;
        }
        if ((i11 & 4) != 0) {
            str3 = cardDeleteFailedEvent.errorCode;
        }
        if ((i11 & 8) != 0) {
            str4 = cardDeleteFailedEvent.errorMessage;
        }
        return cardDeleteFailedEvent.copy(str, str2, str3, str4);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", this.screenName), TuplesKt.to("screenType", this.screenType), TuplesKt.to("errorCode", this.errorCode), TuplesKt.to("errorMessage", this.errorMessage));
    }

    @NotNull
    public final CardDeleteFailedEvent copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "errorCode");
        Intrinsics.checkNotNullParameter(str4, "errorMessage");
        return new CardDeleteFailedEvent(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardDeleteFailedEvent)) {
            return false;
        }
        CardDeleteFailedEvent cardDeleteFailedEvent = (CardDeleteFailedEvent) obj;
        return Intrinsics.areEqual((Object) this.screenName, (Object) cardDeleteFailedEvent.screenName) && Intrinsics.areEqual((Object) this.screenType, (Object) cardDeleteFailedEvent.screenType) && Intrinsics.areEqual((Object) this.errorCode, (Object) cardDeleteFailedEvent.errorCode) && Intrinsics.areEqual((Object) this.errorMessage, (Object) cardDeleteFailedEvent.errorMessage);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "managed_cards";
    }

    public int hashCode() {
        return (((((this.screenName.hashCode() * 31) + this.screenType.hashCode()) * 31) + this.errorCode.hashCode()) * 31) + this.errorMessage.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "online_payment_card_deleted_failed";
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        String str2 = this.screenType;
        String str3 = this.errorCode;
        String str4 = this.errorMessage;
        return "CardDeleteFailedEvent(screenName=" + str + ", screenType=" + str2 + ", errorCode=" + str3 + ", errorMessage=" + str4 + ")";
    }
}
