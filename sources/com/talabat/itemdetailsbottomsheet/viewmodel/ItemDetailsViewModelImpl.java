package com.talabat.itemdetailsbottomsheet.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import com.talabat.lib.Integration;
import datamodels.CartMenuItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/talabat/itemdetailsbottomsheet/viewmodel/ItemDetailsViewModelImpl;", "Lcom/talabat/itemdetailsbottomsheet/viewmodel/ItemDetailsViewModel;", "()V", "addItemToCart", "", "cartMenuItem", "Ldatamodels/CartMenuItem;", "onCleared", "onDecreaseQuantityClicked", "onIncreaseQuantityClicked", "setImage", "item", "screenWidth", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemDetailsViewModelImpl extends ItemDetailsViewModel {
    public void addItemToCart(@NotNull CartMenuItem cartMenuItem) {
        Intrinsics.checkNotNullParameter(cartMenuItem, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
    }

    public void onCleared() {
        super.onCleared();
        getMDisposables();
        getMDisposables().dispose();
    }

    public void onDecreaseQuantityClicked(@NotNull CartMenuItem cartMenuItem) {
        float f11;
        Intrinsics.checkNotNullParameter(cartMenuItem, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
        int quantity = cartMenuItem.getQuantity();
        if (quantity > 1) {
            int i11 = quantity - 1;
            cartMenuItem.setQuantity(i11);
            getQuantity().setValue(Integer.valueOf(i11));
            MutableLiveData<Float> price = getPrice();
            if (!cartMenuItem.isDiscounted() || !Integration.isGemActive()) {
                f11 = cartMenuItem.getTotalPrice();
            } else {
                f11 = cartMenuItem.getCartOldTotalPrice();
            }
            price.setValue(Float.valueOf(f11));
        }
    }

    public void onIncreaseQuantityClicked(@NotNull CartMenuItem cartMenuItem) {
        float f11;
        Intrinsics.checkNotNullParameter(cartMenuItem, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
        int quantity = cartMenuItem.getQuantity();
        if (quantity <= 100) {
            int i11 = quantity + 1;
            cartMenuItem.setQuantity(i11);
            getQuantity().setValue(Integer.valueOf(i11));
            MutableLiveData<Float> price = getPrice();
            if (!cartMenuItem.isDiscounted() || !Integration.isGemActive()) {
                f11 = cartMenuItem.getTotalPrice();
            } else {
                f11 = cartMenuItem.getCartOldTotalPrice();
            }
            price.setValue(Float.valueOf(f11));
        }
    }

    public void setImage(@NotNull CartMenuItem cartMenuItem, int i11) {
        Boolean bool;
        String str;
        boolean z11;
        Intrinsics.checkNotNullParameter(cartMenuItem, "item");
        String thumbnail = cartMenuItem.getThumbnail();
        boolean z12 = false;
        if (thumbnail != null) {
            if (thumbnail.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            bool = Boolean.valueOf(z11);
        } else {
            bool = null;
        }
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            String thumbnail2 = cartMenuItem.getThumbnail();
            Intrinsics.checkNotNullExpressionValue(thumbnail2, "item.getThumbnail()");
            String thumbnail3 = cartMenuItem.getThumbnail();
            Intrinsics.checkNotNullExpressionValue(thumbnail3, "item.getThumbnail()");
            String substring = thumbnail2.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) thumbnail3, "/", 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            str = StringsKt__StringsKt.trim((CharSequence) substring).toString();
        } else {
            str = "";
        }
        if (str.length() > 0) {
            z12 = true;
        }
        if (!z12) {
            getImageUrl().setValue("");
        } else if (i11 > 0) {
            getImageUrl().setValue(cartMenuItem.getThumbnailWithWidth(i11));
        } else {
            getImageUrl().setValue(cartMenuItem.getThumbnail());
        }
    }
}
