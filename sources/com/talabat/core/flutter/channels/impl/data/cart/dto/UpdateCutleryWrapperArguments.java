package com.talabat.core.flutter.channels.impl.data.cart.dto;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdateCutleryWrapperArguments;", "", "cutleryValue", "", "(Z)V", "getCutleryValue", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateCutleryWrapperArguments {
    private final boolean cutleryValue;

    public UpdateCutleryWrapperArguments(boolean z11) {
        this.cutleryValue = z11;
    }

    public static /* synthetic */ UpdateCutleryWrapperArguments copy$default(UpdateCutleryWrapperArguments updateCutleryWrapperArguments, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = updateCutleryWrapperArguments.cutleryValue;
        }
        return updateCutleryWrapperArguments.copy(z11);
    }

    public final boolean component1() {
        return this.cutleryValue;
    }

    @NotNull
    public final UpdateCutleryWrapperArguments copy(boolean z11) {
        return new UpdateCutleryWrapperArguments(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateCutleryWrapperArguments) && this.cutleryValue == ((UpdateCutleryWrapperArguments) obj).cutleryValue;
    }

    public final boolean getCutleryValue() {
        return this.cutleryValue;
    }

    public int hashCode() {
        boolean z11 = this.cutleryValue;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.cutleryValue;
        return "UpdateCutleryWrapperArguments(cutleryValue=" + z11 + ")";
    }
}
