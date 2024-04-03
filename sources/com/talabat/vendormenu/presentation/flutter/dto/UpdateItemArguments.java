package com.talabat.vendormenu.presentation.flutter.dto;

import datamodels.ChoiceSection;
import datamodels.MenuItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\fHÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/dto/UpdateItemArguments;", "", "itemId", "", "quantity", "specialRequest", "", "selectedChoiceSections", "Ljava/util/ArrayList;", "Ldatamodels/ChoiceSection;", "Lkotlin/collections/ArrayList;", "menuItem", "Ldatamodels/MenuItem;", "(IILjava/lang/String;Ljava/util/ArrayList;Ldatamodels/MenuItem;)V", "getItemId", "()I", "getMenuItem", "()Ldatamodels/MenuItem;", "getQuantity", "getSelectedChoiceSections", "()Ljava/util/ArrayList;", "getSpecialRequest", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateItemArguments {
    private final int itemId;
    @Nullable
    private final MenuItem menuItem;
    private final int quantity;
    @Nullable
    private final ArrayList<ChoiceSection> selectedChoiceSections;
    @NotNull
    private final String specialRequest;

    public UpdateItemArguments(int i11, int i12, @NotNull String str, @Nullable ArrayList<ChoiceSection> arrayList, @Nullable MenuItem menuItem2) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        this.itemId = i11;
        this.quantity = i12;
        this.specialRequest = str;
        this.selectedChoiceSections = arrayList;
        this.menuItem = menuItem2;
    }

    public static /* synthetic */ UpdateItemArguments copy$default(UpdateItemArguments updateItemArguments, int i11, int i12, String str, ArrayList<ChoiceSection> arrayList, MenuItem menuItem2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = updateItemArguments.itemId;
        }
        if ((i13 & 2) != 0) {
            i12 = updateItemArguments.quantity;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            str = updateItemArguments.specialRequest;
        }
        String str2 = str;
        if ((i13 & 8) != 0) {
            arrayList = updateItemArguments.selectedChoiceSections;
        }
        ArrayList<ChoiceSection> arrayList2 = arrayList;
        if ((i13 & 16) != 0) {
            menuItem2 = updateItemArguments.menuItem;
        }
        return updateItemArguments.copy(i11, i14, str2, arrayList2, menuItem2);
    }

    public final int component1() {
        return this.itemId;
    }

    public final int component2() {
        return this.quantity;
    }

    @NotNull
    public final String component3() {
        return this.specialRequest;
    }

    @Nullable
    public final ArrayList<ChoiceSection> component4() {
        return this.selectedChoiceSections;
    }

    @Nullable
    public final MenuItem component5() {
        return this.menuItem;
    }

    @NotNull
    public final UpdateItemArguments copy(int i11, int i12, @NotNull String str, @Nullable ArrayList<ChoiceSection> arrayList, @Nullable MenuItem menuItem2) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        return new UpdateItemArguments(i11, i12, str, arrayList, menuItem2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateItemArguments)) {
            return false;
        }
        UpdateItemArguments updateItemArguments = (UpdateItemArguments) obj;
        return this.itemId == updateItemArguments.itemId && this.quantity == updateItemArguments.quantity && Intrinsics.areEqual((Object) this.specialRequest, (Object) updateItemArguments.specialRequest) && Intrinsics.areEqual((Object) this.selectedChoiceSections, (Object) updateItemArguments.selectedChoiceSections) && Intrinsics.areEqual((Object) this.menuItem, (Object) updateItemArguments.menuItem);
    }

    public final int getItemId() {
        return this.itemId;
    }

    @Nullable
    public final MenuItem getMenuItem() {
        return this.menuItem;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @Nullable
    public final ArrayList<ChoiceSection> getSelectedChoiceSections() {
        return this.selectedChoiceSections;
    }

    @NotNull
    public final String getSpecialRequest() {
        return this.specialRequest;
    }

    public int hashCode() {
        int hashCode = ((((this.itemId * 31) + this.quantity) * 31) + this.specialRequest.hashCode()) * 31;
        ArrayList<ChoiceSection> arrayList = this.selectedChoiceSections;
        int i11 = 0;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        MenuItem menuItem2 = this.menuItem;
        if (menuItem2 != null) {
            i11 = menuItem2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.itemId;
        int i12 = this.quantity;
        String str = this.specialRequest;
        ArrayList<ChoiceSection> arrayList = this.selectedChoiceSections;
        MenuItem menuItem2 = this.menuItem;
        return "UpdateItemArguments(itemId=" + i11 + ", quantity=" + i12 + ", specialRequest=" + str + ", selectedChoiceSections=" + arrayList + ", menuItem=" + menuItem2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateItemArguments(int i11, int i12, String str, ArrayList arrayList, MenuItem menuItem2, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, str, (i13 & 8) != 0 ? null : arrayList, (i13 & 16) != 0 ? null : menuItem2);
    }
}
