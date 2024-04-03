package com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/LookingGlassResponse;", "", "()V", "categories", "", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassCategory;", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "vendorInfo", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;", "getVendorInfo", "()Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;", "setVendorInfo", "(Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassResponse {
    @SerializedName("data")
    @NotNull
    private List<GlassCategory> categories = CollectionsKt__CollectionsKt.emptyList();
    @SerializedName("vendor_info")
    @Nullable
    private GVendorInfo vendorInfo;

    @NotNull
    public final List<GlassCategory> getCategories() {
        return this.categories;
    }

    @Nullable
    public final GVendorInfo getVendorInfo() {
        return this.vendorInfo;
    }

    public final void setCategories(@NotNull List<GlassCategory> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.categories = list;
    }

    public final void setVendorInfo(@Nullable GVendorInfo gVendorInfo) {
        this.vendorInfo = gVendorInfo;
    }
}
