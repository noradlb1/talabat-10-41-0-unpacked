package com.talabat.vendormenu.presentation.flutter;

import com.talabat.feature.pickup.data.events.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013JD\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/MenuNavigatorModel;", "", "branchId", "", "deliveryMode", "", "clickOrigin", "isProRestaurant", "", "itemId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBranchId", "()I", "getClickOrigin", "()Ljava/lang/String;", "getDeliveryMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/talabat/vendormenu/presentation/flutter/MenuNavigatorModel;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuNavigatorModel {
    private final int branchId;
    @NotNull
    private final String clickOrigin;
    @NotNull
    private final String deliveryMode;
    @Nullable
    private final Boolean isProRestaurant;
    @Nullable
    private final Integer itemId;

    public MenuNavigatorModel(int i11, @NotNull String str, @NotNull String str2, @Nullable Boolean bool, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "deliveryMode");
        Intrinsics.checkNotNullParameter(str2, ConstantsKt.CLICK_CLICK_ORIGIN);
        this.branchId = i11;
        this.deliveryMode = str;
        this.clickOrigin = str2;
        this.isProRestaurant = bool;
        this.itemId = num;
    }

    public static /* synthetic */ MenuNavigatorModel copy$default(MenuNavigatorModel menuNavigatorModel, int i11, String str, String str2, Boolean bool, Integer num, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = menuNavigatorModel.branchId;
        }
        if ((i12 & 2) != 0) {
            str = menuNavigatorModel.deliveryMode;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            str2 = menuNavigatorModel.clickOrigin;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            bool = menuNavigatorModel.isProRestaurant;
        }
        Boolean bool2 = bool;
        if ((i12 & 16) != 0) {
            num = menuNavigatorModel.itemId;
        }
        return menuNavigatorModel.copy(i11, str3, str4, bool2, num);
    }

    public final int component1() {
        return this.branchId;
    }

    @NotNull
    public final String component2() {
        return this.deliveryMode;
    }

    @NotNull
    public final String component3() {
        return this.clickOrigin;
    }

    @Nullable
    public final Boolean component4() {
        return this.isProRestaurant;
    }

    @Nullable
    public final Integer component5() {
        return this.itemId;
    }

    @NotNull
    public final MenuNavigatorModel copy(int i11, @NotNull String str, @NotNull String str2, @Nullable Boolean bool, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "deliveryMode");
        Intrinsics.checkNotNullParameter(str2, ConstantsKt.CLICK_CLICK_ORIGIN);
        return new MenuNavigatorModel(i11, str, str2, bool, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenuNavigatorModel)) {
            return false;
        }
        MenuNavigatorModel menuNavigatorModel = (MenuNavigatorModel) obj;
        return this.branchId == menuNavigatorModel.branchId && Intrinsics.areEqual((Object) this.deliveryMode, (Object) menuNavigatorModel.deliveryMode) && Intrinsics.areEqual((Object) this.clickOrigin, (Object) menuNavigatorModel.clickOrigin) && Intrinsics.areEqual((Object) this.isProRestaurant, (Object) menuNavigatorModel.isProRestaurant) && Intrinsics.areEqual((Object) this.itemId, (Object) menuNavigatorModel.itemId);
    }

    public final int getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getClickOrigin() {
        return this.clickOrigin;
    }

    @NotNull
    public final String getDeliveryMode() {
        return this.deliveryMode;
    }

    @Nullable
    public final Integer getItemId() {
        return this.itemId;
    }

    public int hashCode() {
        int hashCode = ((((this.branchId * 31) + this.deliveryMode.hashCode()) * 31) + this.clickOrigin.hashCode()) * 31;
        Boolean bool = this.isProRestaurant;
        int i11 = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.itemId;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isProRestaurant() {
        return this.isProRestaurant;
    }

    @NotNull
    public String toString() {
        int i11 = this.branchId;
        String str = this.deliveryMode;
        String str2 = this.clickOrigin;
        Boolean bool = this.isProRestaurant;
        Integer num = this.itemId;
        return "MenuNavigatorModel(branchId=" + i11 + ", deliveryMode=" + str + ", clickOrigin=" + str2 + ", isProRestaurant=" + bool + ", itemId=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MenuNavigatorModel(int i11, String str, String str2, Boolean bool, Integer num, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, str, str2, (i12 & 8) != 0 ? Boolean.FALSE : bool, (i12 & 16) != 0 ? -1 : num);
    }
}
