package com.talabat.talabatcommon.views.darkstores.lookingGlass.model;

import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.GVendorInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "", "()V", "categories", "Ljava/util/ArrayList;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayCategory;", "Lkotlin/collections/ArrayList;", "getCategories", "()Ljava/util/ArrayList;", "setCategories", "(Ljava/util/ArrayList;)V", "vendorInfo", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;", "getVendorInfo", "()Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;", "setVendorInfo", "(Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassDisplayModel {
    @NotNull
    private ArrayList<GDisplayCategory> categories = new ArrayList<>();
    @Nullable
    private GVendorInfo vendorInfo;

    @NotNull
    public final ArrayList<GDisplayCategory> getCategories() {
        return this.categories;
    }

    @Nullable
    public final GVendorInfo getVendorInfo() {
        return this.vendorInfo;
    }

    public final void setCategories(@NotNull ArrayList<GDisplayCategory> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.categories = arrayList;
    }

    public final void setVendorInfo(@Nullable GVendorInfo gVendorInfo) {
        this.vendorInfo = gVendorInfo;
    }
}
