package com.talabat.core.safety.domain.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/safety/domain/entities/SafetyAppData;", "", "adjustId", "", "(Ljava/lang/String;)V", "getAdjustId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_safety_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafetyAppData {
    @NotNull
    private final String adjustId;

    public SafetyAppData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adjustId");
        this.adjustId = str;
    }

    public static /* synthetic */ SafetyAppData copy$default(SafetyAppData safetyAppData, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = safetyAppData.adjustId;
        }
        return safetyAppData.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.adjustId;
    }

    @NotNull
    public final SafetyAppData copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adjustId");
        return new SafetyAppData(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SafetyAppData) && Intrinsics.areEqual((Object) this.adjustId, (Object) ((SafetyAppData) obj).adjustId);
    }

    @NotNull
    public final String getAdjustId() {
        return this.adjustId;
    }

    public int hashCode() {
        return this.adjustId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.adjustId;
        return "SafetyAppData(adjustId=" + str + ")";
    }
}
