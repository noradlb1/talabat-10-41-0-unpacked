package com.talabat.wallet.bnplmanager.domain.tracking.event;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tHÖ\u0003J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/BnplErrorEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "bnplValidationErrorCode", "", "bnplValidationErrorDescription", "eventName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplErrorEvent extends TalabatEvent {
    @NotNull
    private final String bnplValidationErrorCode;
    @NotNull
    private final String bnplValidationErrorDescription;
    @NotNull
    private final String eventName;

    public BnplErrorEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "bnplValidationErrorCode");
        Intrinsics.checkNotNullParameter(str2, "bnplValidationErrorDescription");
        Intrinsics.checkNotNullParameter(str3, "eventName");
        this.bnplValidationErrorCode = str;
        this.bnplValidationErrorDescription = str2;
        this.eventName = str3;
    }

    private final String component1() {
        return this.bnplValidationErrorCode;
    }

    private final String component2() {
        return this.bnplValidationErrorDescription;
    }

    private final String component3() {
        return this.eventName;
    }

    public static /* synthetic */ BnplErrorEvent copy$default(BnplErrorEvent bnplErrorEvent, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bnplErrorEvent.bnplValidationErrorCode;
        }
        if ((i11 & 2) != 0) {
            str2 = bnplErrorEvent.bnplValidationErrorDescription;
        }
        if ((i11 & 4) != 0) {
            str3 = bnplErrorEvent.eventName;
        }
        return bnplErrorEvent.copy(str, str2, str3);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("errorCode", this.bnplValidationErrorCode), TuplesKt.to("errorDetail", this.bnplValidationErrorDescription));
    }

    @NotNull
    public final BnplErrorEvent copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "bnplValidationErrorCode");
        Intrinsics.checkNotNullParameter(str2, "bnplValidationErrorDescription");
        Intrinsics.checkNotNullParameter(str3, "eventName");
        return new BnplErrorEvent(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BnplErrorEvent)) {
            return false;
        }
        BnplErrorEvent bnplErrorEvent = (BnplErrorEvent) obj;
        return Intrinsics.areEqual((Object) this.bnplValidationErrorCode, (Object) bnplErrorEvent.bnplValidationErrorCode) && Intrinsics.areEqual((Object) this.bnplValidationErrorDescription, (Object) bnplErrorEvent.bnplValidationErrorDescription) && Intrinsics.areEqual((Object) this.eventName, (Object) bnplErrorEvent.eventName);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "BNPL";
    }

    public int hashCode() {
        return (((this.bnplValidationErrorCode.hashCode() * 31) + this.bnplValidationErrorDescription.hashCode()) * 31) + this.eventName.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.eventName;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        String str = this.bnplValidationErrorCode;
        String str2 = this.bnplValidationErrorDescription;
        String str3 = this.eventName;
        return "BnplErrorEvent(bnplValidationErrorCode=" + str + ", bnplValidationErrorDescription=" + str2 + ", eventName=" + str3 + ")";
    }
}
