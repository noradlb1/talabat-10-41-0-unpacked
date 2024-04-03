package com.talabat.core.flutter.channels.impl.data.gem.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/gem/dto/GemNavArguments;", "", "fromFlutterHoF", "", "(Ljava/lang/Boolean;)V", "getFromFlutterHoF", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/talabat/core/flutter/channels/impl/data/gem/dto/GemNavArguments;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemNavArguments {
    @Nullable
    private final Boolean fromFlutterHoF;

    public GemNavArguments() {
        this((Boolean) null, 1, (DefaultConstructorMarker) null);
    }

    public GemNavArguments(@Nullable Boolean bool) {
        this.fromFlutterHoF = bool;
    }

    public static /* synthetic */ GemNavArguments copy$default(GemNavArguments gemNavArguments, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = gemNavArguments.fromFlutterHoF;
        }
        return gemNavArguments.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.fromFlutterHoF;
    }

    @NotNull
    public final GemNavArguments copy(@Nullable Boolean bool) {
        return new GemNavArguments(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GemNavArguments) && Intrinsics.areEqual((Object) this.fromFlutterHoF, (Object) ((GemNavArguments) obj).fromFlutterHoF);
    }

    @Nullable
    public final Boolean getFromFlutterHoF() {
        return this.fromFlutterHoF;
    }

    public int hashCode() {
        Boolean bool = this.fromFlutterHoF;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @NotNull
    public String toString() {
        Boolean bool = this.fromFlutterHoF;
        return "GemNavArguments(fromFlutterHoF=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GemNavArguments(Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool);
    }
}
