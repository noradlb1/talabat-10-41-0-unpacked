package com.talabat.core.flutter.channels.impl.data.cart.dto;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/AddToCartCallArguments;", "", "cartItems", "Ljava/util/ArrayList;", "Lcom/talabat/core/flutter/channels/impl/data/cart/dto/CartItemArguments;", "Lkotlin/collections/ArrayList;", "deliveryMode", "", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getCartItems", "()Ljava/util/ArrayList;", "getDeliveryMode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddToCartCallArguments {
    @Nullable
    private final ArrayList<CartItemArguments> cartItems;
    @Nullable
    private final String deliveryMode;

    public AddToCartCallArguments(@Nullable ArrayList<CartItemArguments> arrayList, @Nullable String str) {
        this.cartItems = arrayList;
        this.deliveryMode = str;
    }

    public static /* synthetic */ AddToCartCallArguments copy$default(AddToCartCallArguments addToCartCallArguments, ArrayList<CartItemArguments> arrayList, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            arrayList = addToCartCallArguments.cartItems;
        }
        if ((i11 & 2) != 0) {
            str = addToCartCallArguments.deliveryMode;
        }
        return addToCartCallArguments.copy(arrayList, str);
    }

    @Nullable
    public final ArrayList<CartItemArguments> component1() {
        return this.cartItems;
    }

    @Nullable
    public final String component2() {
        return this.deliveryMode;
    }

    @NotNull
    public final AddToCartCallArguments copy(@Nullable ArrayList<CartItemArguments> arrayList, @Nullable String str) {
        return new AddToCartCallArguments(arrayList, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddToCartCallArguments)) {
            return false;
        }
        AddToCartCallArguments addToCartCallArguments = (AddToCartCallArguments) obj;
        return Intrinsics.areEqual((Object) this.cartItems, (Object) addToCartCallArguments.cartItems) && Intrinsics.areEqual((Object) this.deliveryMode, (Object) addToCartCallArguments.deliveryMode);
    }

    @Nullable
    public final ArrayList<CartItemArguments> getCartItems() {
        return this.cartItems;
    }

    @Nullable
    public final String getDeliveryMode() {
        return this.deliveryMode;
    }

    public int hashCode() {
        ArrayList<CartItemArguments> arrayList = this.cartItems;
        int i11 = 0;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        String str = this.deliveryMode;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        ArrayList<CartItemArguments> arrayList = this.cartItems;
        String str = this.deliveryMode;
        return "AddToCartCallArguments(cartItems=" + arrayList + ", deliveryMode=" + str + ")";
    }
}
