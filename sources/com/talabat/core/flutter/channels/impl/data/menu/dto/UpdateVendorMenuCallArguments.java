package com.talabat.core.flutter.channels.impl.data.menu.dto;

import JsonModels.MenuItemsResponseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/menu/dto/UpdateVendorMenuCallArguments;", "", "result", "LJsonModels/MenuItemsResponseModel;", "(LJsonModels/MenuItemsResponseModel;)V", "getResult", "()LJsonModels/MenuItemsResponseModel;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateVendorMenuCallArguments {
    @NotNull
    private final MenuItemsResponseModel result;

    public UpdateVendorMenuCallArguments(@NotNull MenuItemsResponseModel menuItemsResponseModel) {
        Intrinsics.checkNotNullParameter(menuItemsResponseModel, "result");
        this.result = menuItemsResponseModel;
    }

    public static /* synthetic */ UpdateVendorMenuCallArguments copy$default(UpdateVendorMenuCallArguments updateVendorMenuCallArguments, MenuItemsResponseModel menuItemsResponseModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            menuItemsResponseModel = updateVendorMenuCallArguments.result;
        }
        return updateVendorMenuCallArguments.copy(menuItemsResponseModel);
    }

    @NotNull
    public final MenuItemsResponseModel component1() {
        return this.result;
    }

    @NotNull
    public final UpdateVendorMenuCallArguments copy(@NotNull MenuItemsResponseModel menuItemsResponseModel) {
        Intrinsics.checkNotNullParameter(menuItemsResponseModel, "result");
        return new UpdateVendorMenuCallArguments(menuItemsResponseModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateVendorMenuCallArguments) && Intrinsics.areEqual((Object) this.result, (Object) ((UpdateVendorMenuCallArguments) obj).result);
    }

    @NotNull
    public final MenuItemsResponseModel getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    @NotNull
    public String toString() {
        MenuItemsResponseModel menuItemsResponseModel = this.result;
        return "UpdateVendorMenuCallArguments(result=" + menuItemsResponseModel + ")";
    }
}
