package com.talabat.core.flutter.channels.impl.data.cart.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdateItemFromCartArguments;", "", "originalItem", "Lcom/talabat/core/flutter/channels/impl/data/cart/dto/OriginalItemArguments;", "updatedItem", "Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdateItemArguments;", "(Lcom/talabat/core/flutter/channels/impl/data/cart/dto/OriginalItemArguments;Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdateItemArguments;)V", "getOriginalItem", "()Lcom/talabat/core/flutter/channels/impl/data/cart/dto/OriginalItemArguments;", "getUpdatedItem", "()Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdateItemArguments;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateItemFromCartArguments {
    @NotNull
    private final OriginalItemArguments originalItem;
    @NotNull
    private final UpdateItemArguments updatedItem;

    public UpdateItemFromCartArguments(@NotNull OriginalItemArguments originalItemArguments, @NotNull UpdateItemArguments updateItemArguments) {
        Intrinsics.checkNotNullParameter(originalItemArguments, "originalItem");
        Intrinsics.checkNotNullParameter(updateItemArguments, "updatedItem");
        this.originalItem = originalItemArguments;
        this.updatedItem = updateItemArguments;
    }

    public static /* synthetic */ UpdateItemFromCartArguments copy$default(UpdateItemFromCartArguments updateItemFromCartArguments, OriginalItemArguments originalItemArguments, UpdateItemArguments updateItemArguments, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            originalItemArguments = updateItemFromCartArguments.originalItem;
        }
        if ((i11 & 2) != 0) {
            updateItemArguments = updateItemFromCartArguments.updatedItem;
        }
        return updateItemFromCartArguments.copy(originalItemArguments, updateItemArguments);
    }

    @NotNull
    public final OriginalItemArguments component1() {
        return this.originalItem;
    }

    @NotNull
    public final UpdateItemArguments component2() {
        return this.updatedItem;
    }

    @NotNull
    public final UpdateItemFromCartArguments copy(@NotNull OriginalItemArguments originalItemArguments, @NotNull UpdateItemArguments updateItemArguments) {
        Intrinsics.checkNotNullParameter(originalItemArguments, "originalItem");
        Intrinsics.checkNotNullParameter(updateItemArguments, "updatedItem");
        return new UpdateItemFromCartArguments(originalItemArguments, updateItemArguments);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateItemFromCartArguments)) {
            return false;
        }
        UpdateItemFromCartArguments updateItemFromCartArguments = (UpdateItemFromCartArguments) obj;
        return Intrinsics.areEqual((Object) this.originalItem, (Object) updateItemFromCartArguments.originalItem) && Intrinsics.areEqual((Object) this.updatedItem, (Object) updateItemFromCartArguments.updatedItem);
    }

    @NotNull
    public final OriginalItemArguments getOriginalItem() {
        return this.originalItem;
    }

    @NotNull
    public final UpdateItemArguments getUpdatedItem() {
        return this.updatedItem;
    }

    public int hashCode() {
        return (this.originalItem.hashCode() * 31) + this.updatedItem.hashCode();
    }

    @NotNull
    public String toString() {
        OriginalItemArguments originalItemArguments = this.originalItem;
        UpdateItemArguments updateItemArguments = this.updatedItem;
        return "UpdateItemFromCartArguments(originalItem=" + originalItemArguments + ", updatedItem=" + updateItemArguments + ")";
    }
}
