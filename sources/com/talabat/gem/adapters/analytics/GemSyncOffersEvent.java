package com.talabat.gem.adapters.analytics;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tHÖ\u0003J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/talabat/gem/adapters/analytics/GemSyncOffersEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "Companion", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemSyncOffersEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "gem_sync_offers";
    @NotNull
    public static final String FEATURE_NAME = "Gem_Events";
    @NotNull
    private final String errorMessage;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/gem/adapters/analytics/GemSyncOffersEvent$Companion;", "", "()V", "EVENT_NAME", "", "FEATURE_NAME", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GemSyncOffersEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.errorMessage = str;
    }

    public static /* synthetic */ GemSyncOffersEvent copy$default(GemSyncOffersEvent gemSyncOffersEvent, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gemSyncOffersEvent.errorMessage;
        }
        return gemSyncOffersEvent.copy(str);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("error_message", this.errorMessage);
        return linkedHashMap;
    }

    @NotNull
    public final String component1() {
        return this.errorMessage;
    }

    @NotNull
    public final GemSyncOffersEvent copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        return new GemSyncOffersEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GemSyncOffersEvent) && Intrinsics.areEqual((Object) this.errorMessage, (Object) ((GemSyncOffersEvent) obj).errorMessage);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "Gem_Events";
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        return this.errorMessage.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }

    @NotNull
    public String toString() {
        String str = this.errorMessage;
        return "GemSyncOffersEvent(errorMessage=" + str + ")";
    }
}
