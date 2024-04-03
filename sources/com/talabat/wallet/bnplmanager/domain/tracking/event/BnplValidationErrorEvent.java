package com.talabat.wallet.bnplmanager.domain.tracking.event;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/BnplValidationErrorEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "errorCode", "", "errorDetail", "(Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplValidationErrorEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "bnpl_validation_loaded";
    @NotNull
    private final String errorCode;
    @NotNull
    private final String errorDetail;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/BnplValidationErrorEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BnplValidationErrorEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Intrinsics.checkNotNullParameter(str2, "errorDetail");
        this.errorCode = str;
        this.errorDetail = str2;
    }

    private final String component1() {
        return this.errorCode;
    }

    private final String component2() {
        return this.errorDetail;
    }

    public static /* synthetic */ BnplValidationErrorEvent copy$default(BnplValidationErrorEvent bnplValidationErrorEvent, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bnplValidationErrorEvent.errorCode;
        }
        if ((i11 & 2) != 0) {
            str2 = bnplValidationErrorEvent.errorDetail;
        }
        return bnplValidationErrorEvent.copy(str, str2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("errorCode", this.errorCode), TuplesKt.to("errorDetail", this.errorDetail));
    }

    @NotNull
    public final BnplValidationErrorEvent copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Intrinsics.checkNotNullParameter(str2, "errorDetail");
        return new BnplValidationErrorEvent(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BnplValidationErrorEvent)) {
            return false;
        }
        BnplValidationErrorEvent bnplValidationErrorEvent = (BnplValidationErrorEvent) obj;
        return Intrinsics.areEqual((Object) this.errorCode, (Object) bnplValidationErrorEvent.errorCode) && Intrinsics.areEqual((Object) this.errorDetail, (Object) bnplValidationErrorEvent.errorDetail);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "BNPL";
    }

    public int hashCode() {
        return (this.errorCode.hashCode() * 31) + this.errorDetail.hashCode();
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
        String str = this.errorCode;
        String str2 = this.errorDetail;
        return "BnplValidationErrorEvent(errorCode=" + str + ", errorDetail=" + str2 + ")";
    }
}
