package com.opsquad.features.orderDetails.models.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/opsquad/features/orderDetails/models/responses/OrderItemResponse;", "", "()V", "itemChoices", "", "getItemChoices", "()Ljava/lang/String;", "setItemChoices", "(Ljava/lang/String;)V", "itemHasChoices", "", "getItemHasChoices", "()Z", "setItemHasChoices", "(Z)V", "itemName", "getItemName", "setItemName", "itemPrice", "", "getItemPrice", "()F", "setItemPrice", "(F)V", "itemQuantity", "", "getItemQuantity", "()I", "setItemQuantity", "(I)V", "itemSpecialRequest", "getItemSpecialRequest", "setItemSpecialRequest", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderItemResponse {
    @SerializedName("ich")
    @Nullable
    private String itemChoices;
    @SerializedName("ici")
    private boolean itemHasChoices;
    @SerializedName("inm")
    @Nullable
    private String itemName;
    @SerializedName("ip2")
    private float itemPrice;
    @SerializedName("itq")
    private int itemQuantity;
    @SerializedName("sr")
    @Nullable
    private String itemSpecialRequest;

    @Nullable
    public final String getItemChoices() {
        return this.itemChoices;
    }

    public final boolean getItemHasChoices() {
        return this.itemHasChoices;
    }

    @Nullable
    public final String getItemName() {
        return this.itemName;
    }

    public final float getItemPrice() {
        return this.itemPrice;
    }

    public final int getItemQuantity() {
        return this.itemQuantity;
    }

    @Nullable
    public final String getItemSpecialRequest() {
        return this.itemSpecialRequest;
    }

    public final void setItemChoices(@Nullable String str) {
        this.itemChoices = str;
    }

    public final void setItemHasChoices(boolean z11) {
        this.itemHasChoices = z11;
    }

    public final void setItemName(@Nullable String str) {
        this.itemName = str;
    }

    public final void setItemPrice(float f11) {
        this.itemPrice = f11;
    }

    public final void setItemQuantity(int i11) {
        this.itemQuantity = i11;
    }

    public final void setItemSpecialRequest(@Nullable String str) {
        this.itemSpecialRequest = str;
    }
}
