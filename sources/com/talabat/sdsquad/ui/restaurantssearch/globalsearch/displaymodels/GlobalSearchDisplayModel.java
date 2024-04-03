package com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels;

import com.talabat.sdsquad.core.DisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J5\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchDisplayModel;", "Lcom/talabat/sdsquad/core/DisplayModel;", "type", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchCellType;", "vendorDisplayModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "dishDisplayModel", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "itemCount", "", "(Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchCellType;Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;I)V", "getDishDisplayModel", "()Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "setDishDisplayModel", "(Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;)V", "getItemCount", "()I", "setItemCount", "(I)V", "getType", "()Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchCellType;", "setType", "(Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchCellType;)V", "getVendorDisplayModel", "()Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "setVendorDisplayModel", "(Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalSearchDisplayModel implements DisplayModel {
    @Nullable
    private DishDisplayModel dishDisplayModel;
    private int itemCount;
    @NotNull
    private GlobalSearchCellType type;
    @Nullable
    private VendorDisplayModel vendorDisplayModel;

    public GlobalSearchDisplayModel(@NotNull GlobalSearchCellType globalSearchCellType, @Nullable VendorDisplayModel vendorDisplayModel2, @Nullable DishDisplayModel dishDisplayModel2, int i11) {
        Intrinsics.checkNotNullParameter(globalSearchCellType, "type");
        this.type = globalSearchCellType;
        this.vendorDisplayModel = vendorDisplayModel2;
        this.dishDisplayModel = dishDisplayModel2;
        this.itemCount = i11;
    }

    public static /* synthetic */ GlobalSearchDisplayModel copy$default(GlobalSearchDisplayModel globalSearchDisplayModel, GlobalSearchCellType globalSearchCellType, VendorDisplayModel vendorDisplayModel2, DishDisplayModel dishDisplayModel2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            globalSearchCellType = globalSearchDisplayModel.type;
        }
        if ((i12 & 2) != 0) {
            vendorDisplayModel2 = globalSearchDisplayModel.vendorDisplayModel;
        }
        if ((i12 & 4) != 0) {
            dishDisplayModel2 = globalSearchDisplayModel.dishDisplayModel;
        }
        if ((i12 & 8) != 0) {
            i11 = globalSearchDisplayModel.itemCount;
        }
        return globalSearchDisplayModel.copy(globalSearchCellType, vendorDisplayModel2, dishDisplayModel2, i11);
    }

    @NotNull
    public final GlobalSearchCellType component1() {
        return this.type;
    }

    @Nullable
    public final VendorDisplayModel component2() {
        return this.vendorDisplayModel;
    }

    @Nullable
    public final DishDisplayModel component3() {
        return this.dishDisplayModel;
    }

    public final int component4() {
        return this.itemCount;
    }

    @NotNull
    public final GlobalSearchDisplayModel copy(@NotNull GlobalSearchCellType globalSearchCellType, @Nullable VendorDisplayModel vendorDisplayModel2, @Nullable DishDisplayModel dishDisplayModel2, int i11) {
        Intrinsics.checkNotNullParameter(globalSearchCellType, "type");
        return new GlobalSearchDisplayModel(globalSearchCellType, vendorDisplayModel2, dishDisplayModel2, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlobalSearchDisplayModel)) {
            return false;
        }
        GlobalSearchDisplayModel globalSearchDisplayModel = (GlobalSearchDisplayModel) obj;
        return this.type == globalSearchDisplayModel.type && Intrinsics.areEqual((Object) this.vendorDisplayModel, (Object) globalSearchDisplayModel.vendorDisplayModel) && Intrinsics.areEqual((Object) this.dishDisplayModel, (Object) globalSearchDisplayModel.dishDisplayModel) && this.itemCount == globalSearchDisplayModel.itemCount;
    }

    @Nullable
    public final DishDisplayModel getDishDisplayModel() {
        return this.dishDisplayModel;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    @NotNull
    public final GlobalSearchCellType getType() {
        return this.type;
    }

    @Nullable
    public final VendorDisplayModel getVendorDisplayModel() {
        return this.vendorDisplayModel;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        VendorDisplayModel vendorDisplayModel2 = this.vendorDisplayModel;
        int i11 = 0;
        int hashCode2 = (hashCode + (vendorDisplayModel2 == null ? 0 : vendorDisplayModel2.hashCode())) * 31;
        DishDisplayModel dishDisplayModel2 = this.dishDisplayModel;
        if (dishDisplayModel2 != null) {
            i11 = dishDisplayModel2.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.itemCount;
    }

    public final void setDishDisplayModel(@Nullable DishDisplayModel dishDisplayModel2) {
        this.dishDisplayModel = dishDisplayModel2;
    }

    public final void setItemCount(int i11) {
        this.itemCount = i11;
    }

    public final void setType(@NotNull GlobalSearchCellType globalSearchCellType) {
        Intrinsics.checkNotNullParameter(globalSearchCellType, "<set-?>");
        this.type = globalSearchCellType;
    }

    public final void setVendorDisplayModel(@Nullable VendorDisplayModel vendorDisplayModel2) {
        this.vendorDisplayModel = vendorDisplayModel2;
    }

    @NotNull
    public String toString() {
        GlobalSearchCellType globalSearchCellType = this.type;
        VendorDisplayModel vendorDisplayModel2 = this.vendorDisplayModel;
        DishDisplayModel dishDisplayModel2 = this.dishDisplayModel;
        int i11 = this.itemCount;
        return "GlobalSearchDisplayModel(type=" + globalSearchCellType + ", vendorDisplayModel=" + vendorDisplayModel2 + ", dishDisplayModel=" + dishDisplayModel2 + ", itemCount=" + i11 + ")";
    }
}
