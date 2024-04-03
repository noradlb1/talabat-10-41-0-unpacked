package com.talabat.core.flutter.channels.impl.data.cart.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdateQuantityWrapperArguments;", "", "menuItemId", "", "quantity", "specialRequest", "", "choices", "", "(IILjava/lang/String;Ljava/util/List;)V", "getChoices", "()Ljava/util/List;", "getMenuItemId", "()I", "getQuantity", "getSpecialRequest", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateQuantityWrapperArguments {
    @Nullable
    private final List<Integer> choices;
    private final int menuItemId;
    private final int quantity;
    @NotNull
    private final String specialRequest;

    public UpdateQuantityWrapperArguments(int i11, int i12, @NotNull String str, @Nullable List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        this.menuItemId = i11;
        this.quantity = i12;
        this.specialRequest = str;
        this.choices = list;
    }

    public static /* synthetic */ UpdateQuantityWrapperArguments copy$default(UpdateQuantityWrapperArguments updateQuantityWrapperArguments, int i11, int i12, String str, List<Integer> list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = updateQuantityWrapperArguments.menuItemId;
        }
        if ((i13 & 2) != 0) {
            i12 = updateQuantityWrapperArguments.quantity;
        }
        if ((i13 & 4) != 0) {
            str = updateQuantityWrapperArguments.specialRequest;
        }
        if ((i13 & 8) != 0) {
            list = updateQuantityWrapperArguments.choices;
        }
        return updateQuantityWrapperArguments.copy(i11, i12, str, list);
    }

    public final int component1() {
        return this.menuItemId;
    }

    public final int component2() {
        return this.quantity;
    }

    @NotNull
    public final String component3() {
        return this.specialRequest;
    }

    @Nullable
    public final List<Integer> component4() {
        return this.choices;
    }

    @NotNull
    public final UpdateQuantityWrapperArguments copy(int i11, int i12, @NotNull String str, @Nullable List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        return new UpdateQuantityWrapperArguments(i11, i12, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateQuantityWrapperArguments)) {
            return false;
        }
        UpdateQuantityWrapperArguments updateQuantityWrapperArguments = (UpdateQuantityWrapperArguments) obj;
        return this.menuItemId == updateQuantityWrapperArguments.menuItemId && this.quantity == updateQuantityWrapperArguments.quantity && Intrinsics.areEqual((Object) this.specialRequest, (Object) updateQuantityWrapperArguments.specialRequest) && Intrinsics.areEqual((Object) this.choices, (Object) updateQuantityWrapperArguments.choices);
    }

    @Nullable
    public final List<Integer> getChoices() {
        return this.choices;
    }

    public final int getMenuItemId() {
        return this.menuItemId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @NotNull
    public final String getSpecialRequest() {
        return this.specialRequest;
    }

    public int hashCode() {
        int hashCode = ((((this.menuItemId * 31) + this.quantity) * 31) + this.specialRequest.hashCode()) * 31;
        List<Integer> list = this.choices;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.menuItemId;
        int i12 = this.quantity;
        String str = this.specialRequest;
        List<Integer> list = this.choices;
        return "UpdateQuantityWrapperArguments(menuItemId=" + i11 + ", quantity=" + i12 + ", specialRequest=" + str + ", choices=" + list + ")";
    }
}
