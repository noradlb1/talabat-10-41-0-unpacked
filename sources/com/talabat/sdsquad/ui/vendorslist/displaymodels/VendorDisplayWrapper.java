package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "", "type", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorCellType;", "vendorDisplayModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "collections", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "swimlane", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "inlineAd", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/InlineAdDisplayModel;", "(Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorCellType;Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;Ljava/util/List;Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/InlineAdDisplayModel;)V", "getCollections", "()Ljava/util/List;", "setCollections", "(Ljava/util/List;)V", "getInlineAd", "()Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/InlineAdDisplayModel;", "setInlineAd", "(Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/InlineAdDisplayModel;)V", "getSwimlane", "()Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "setSwimlane", "(Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;)V", "getType", "()Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorCellType;", "setType", "(Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorCellType;)V", "getVendorDisplayModel", "()Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "setVendorDisplayModel", "(Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorDisplayWrapper {
    @Nullable
    private List<CollectionDisplayModel> collections;
    @Nullable
    private InlineAdDisplayModel inlineAd;
    @Nullable
    private SwimlaneDisplayModel swimlane;
    @NotNull
    private VendorCellType type;
    @Nullable
    private VendorDisplayModel vendorDisplayModel;

    public VendorDisplayWrapper(@NotNull VendorCellType vendorCellType, @Nullable VendorDisplayModel vendorDisplayModel2, @Nullable List<CollectionDisplayModel> list, @Nullable SwimlaneDisplayModel swimlaneDisplayModel, @Nullable InlineAdDisplayModel inlineAdDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorCellType, "type");
        this.type = vendorCellType;
        this.vendorDisplayModel = vendorDisplayModel2;
        this.collections = list;
        this.swimlane = swimlaneDisplayModel;
        this.inlineAd = inlineAdDisplayModel;
    }

    public static /* synthetic */ VendorDisplayWrapper copy$default(VendorDisplayWrapper vendorDisplayWrapper, VendorCellType vendorCellType, VendorDisplayModel vendorDisplayModel2, List<CollectionDisplayModel> list, SwimlaneDisplayModel swimlaneDisplayModel, InlineAdDisplayModel inlineAdDisplayModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            vendorCellType = vendorDisplayWrapper.type;
        }
        if ((i11 & 2) != 0) {
            vendorDisplayModel2 = vendorDisplayWrapper.vendorDisplayModel;
        }
        VendorDisplayModel vendorDisplayModel3 = vendorDisplayModel2;
        if ((i11 & 4) != 0) {
            list = vendorDisplayWrapper.collections;
        }
        List<CollectionDisplayModel> list2 = list;
        if ((i11 & 8) != 0) {
            swimlaneDisplayModel = vendorDisplayWrapper.swimlane;
        }
        SwimlaneDisplayModel swimlaneDisplayModel2 = swimlaneDisplayModel;
        if ((i11 & 16) != 0) {
            inlineAdDisplayModel = vendorDisplayWrapper.inlineAd;
        }
        return vendorDisplayWrapper.copy(vendorCellType, vendorDisplayModel3, list2, swimlaneDisplayModel2, inlineAdDisplayModel);
    }

    @NotNull
    public final VendorCellType component1() {
        return this.type;
    }

    @Nullable
    public final VendorDisplayModel component2() {
        return this.vendorDisplayModel;
    }

    @Nullable
    public final List<CollectionDisplayModel> component3() {
        return this.collections;
    }

    @Nullable
    public final SwimlaneDisplayModel component4() {
        return this.swimlane;
    }

    @Nullable
    public final InlineAdDisplayModel component5() {
        return this.inlineAd;
    }

    @NotNull
    public final VendorDisplayWrapper copy(@NotNull VendorCellType vendorCellType, @Nullable VendorDisplayModel vendorDisplayModel2, @Nullable List<CollectionDisplayModel> list, @Nullable SwimlaneDisplayModel swimlaneDisplayModel, @Nullable InlineAdDisplayModel inlineAdDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorCellType, "type");
        return new VendorDisplayWrapper(vendorCellType, vendorDisplayModel2, list, swimlaneDisplayModel, inlineAdDisplayModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorDisplayWrapper)) {
            return false;
        }
        VendorDisplayWrapper vendorDisplayWrapper = (VendorDisplayWrapper) obj;
        return this.type == vendorDisplayWrapper.type && Intrinsics.areEqual((Object) this.vendorDisplayModel, (Object) vendorDisplayWrapper.vendorDisplayModel) && Intrinsics.areEqual((Object) this.collections, (Object) vendorDisplayWrapper.collections) && Intrinsics.areEqual((Object) this.swimlane, (Object) vendorDisplayWrapper.swimlane) && Intrinsics.areEqual((Object) this.inlineAd, (Object) vendorDisplayWrapper.inlineAd);
    }

    @Nullable
    public final List<CollectionDisplayModel> getCollections() {
        return this.collections;
    }

    @Nullable
    public final InlineAdDisplayModel getInlineAd() {
        return this.inlineAd;
    }

    @Nullable
    public final SwimlaneDisplayModel getSwimlane() {
        return this.swimlane;
    }

    @NotNull
    public final VendorCellType getType() {
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
        List<CollectionDisplayModel> list = this.collections;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        SwimlaneDisplayModel swimlaneDisplayModel = this.swimlane;
        int hashCode4 = (hashCode3 + (swimlaneDisplayModel == null ? 0 : swimlaneDisplayModel.hashCode())) * 31;
        InlineAdDisplayModel inlineAdDisplayModel = this.inlineAd;
        if (inlineAdDisplayModel != null) {
            i11 = inlineAdDisplayModel.hashCode();
        }
        return hashCode4 + i11;
    }

    public final void setCollections(@Nullable List<CollectionDisplayModel> list) {
        this.collections = list;
    }

    public final void setInlineAd(@Nullable InlineAdDisplayModel inlineAdDisplayModel) {
        this.inlineAd = inlineAdDisplayModel;
    }

    public final void setSwimlane(@Nullable SwimlaneDisplayModel swimlaneDisplayModel) {
        this.swimlane = swimlaneDisplayModel;
    }

    public final void setType(@NotNull VendorCellType vendorCellType) {
        Intrinsics.checkNotNullParameter(vendorCellType, "<set-?>");
        this.type = vendorCellType;
    }

    public final void setVendorDisplayModel(@Nullable VendorDisplayModel vendorDisplayModel2) {
        this.vendorDisplayModel = vendorDisplayModel2;
    }

    @NotNull
    public String toString() {
        VendorCellType vendorCellType = this.type;
        VendorDisplayModel vendorDisplayModel2 = this.vendorDisplayModel;
        List<CollectionDisplayModel> list = this.collections;
        SwimlaneDisplayModel swimlaneDisplayModel = this.swimlane;
        InlineAdDisplayModel inlineAdDisplayModel = this.inlineAd;
        return "VendorDisplayWrapper(type=" + vendorCellType + ", vendorDisplayModel=" + vendorDisplayModel2 + ", collections=" + list + ", swimlane=" + swimlaneDisplayModel + ", inlineAd=" + inlineAdDisplayModel + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorDisplayWrapper(VendorCellType vendorCellType, VendorDisplayModel vendorDisplayModel2, List list, SwimlaneDisplayModel swimlaneDisplayModel, InlineAdDisplayModel inlineAdDisplayModel, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorCellType, (i11 & 2) != 0 ? null : vendorDisplayModel2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : swimlaneDisplayModel, (i11 & 16) != 0 ? null : inlineAdDisplayModel);
    }
}
