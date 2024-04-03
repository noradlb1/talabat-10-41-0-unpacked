package com.facebook.internal.gatekeeper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeper;", "", "name", "", "value", "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getValue", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GateKeeper {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f33599name;
    private final boolean value;

    public GateKeeper(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f33599name = str;
        this.value = z11;
    }

    public static /* synthetic */ GateKeeper copy$default(GateKeeper gateKeeper, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gateKeeper.f33599name;
        }
        if ((i11 & 2) != 0) {
            z11 = gateKeeper.value;
        }
        return gateKeeper.copy(str, z11);
    }

    @NotNull
    public final String component1() {
        return this.f33599name;
    }

    public final boolean component2() {
        return this.value;
    }

    @NotNull
    public final GateKeeper copy(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new GateKeeper(str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GateKeeper)) {
            return false;
        }
        GateKeeper gateKeeper = (GateKeeper) obj;
        return Intrinsics.areEqual((Object) this.f33599name, (Object) gateKeeper.f33599name) && this.value == gateKeeper.value;
    }

    @NotNull
    public final String getName() {
        return this.f33599name;
    }

    public final boolean getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.f33599name.hashCode() * 31;
        boolean z11 = this.value;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "GateKeeper(name=" + this.f33599name + ", value=" + this.value + ')';
    }
}
