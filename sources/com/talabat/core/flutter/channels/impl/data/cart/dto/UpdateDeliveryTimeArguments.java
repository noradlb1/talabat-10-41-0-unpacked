package com.talabat.core.flutter.channels.impl.data.cart.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdateDeliveryTimeArguments;", "", "deliveryTime", "", "(Ljava/lang/String;)V", "getDeliveryTime", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateDeliveryTimeArguments {
    @Nullable
    private final String deliveryTime;

    public UpdateDeliveryTimeArguments(@Nullable String str) {
        this.deliveryTime = str;
    }

    public static /* synthetic */ UpdateDeliveryTimeArguments copy$default(UpdateDeliveryTimeArguments updateDeliveryTimeArguments, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = updateDeliveryTimeArguments.deliveryTime;
        }
        return updateDeliveryTimeArguments.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.deliveryTime;
    }

    @NotNull
    public final UpdateDeliveryTimeArguments copy(@Nullable String str) {
        return new UpdateDeliveryTimeArguments(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateDeliveryTimeArguments) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) ((UpdateDeliveryTimeArguments) obj).deliveryTime);
    }

    @Nullable
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    public int hashCode() {
        String str = this.deliveryTime;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.deliveryTime;
        return "UpdateDeliveryTimeArguments(deliveryTime=" + str + ")";
    }
}
