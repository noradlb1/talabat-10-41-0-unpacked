package com.deliveryhero.customerchat.fwf;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/ChannelFeatureFlags;", "", "isVoipEnabled", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChannelFeatureFlags {
    private final boolean isVoipEnabled;

    public ChannelFeatureFlags() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public ChannelFeatureFlags(boolean z11) {
        this.isVoipEnabled = z11;
    }

    public static /* synthetic */ ChannelFeatureFlags copy$default(ChannelFeatureFlags channelFeatureFlags, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = channelFeatureFlags.isVoipEnabled;
        }
        return channelFeatureFlags.copy(z11);
    }

    public final boolean component1() {
        return this.isVoipEnabled;
    }

    @NotNull
    public final ChannelFeatureFlags copy(boolean z11) {
        return new ChannelFeatureFlags(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChannelFeatureFlags) && this.isVoipEnabled == ((ChannelFeatureFlags) obj).isVoipEnabled;
    }

    public int hashCode() {
        boolean z11 = this.isVoipEnabled;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    public final boolean isVoipEnabled() {
        return this.isVoipEnabled;
    }

    @NotNull
    public String toString() {
        return "ChannelFeatureFlags(isVoipEnabled=" + this.isVoipEnabled + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFeatureFlags(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }
}
