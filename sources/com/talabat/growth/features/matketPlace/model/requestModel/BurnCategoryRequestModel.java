package com.talabat.growth.features.matketPlace.model.requestModel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/talabat/growth/features/matketPlace/model/requestModel/BurnCategoryRequestModel;", "", "itemId", "", "burnCategoryType", "country", "areaId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAreaId", "()I", "getBurnCategoryType", "()Ljava/lang/String;", "getCountry", "getItemId", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnCategoryRequestModel {
    private final int areaId;
    @NotNull
    private final String burnCategoryType;
    @NotNull
    private final String country;
    @NotNull
    private final String itemId;

    public BurnCategoryRequestModel(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "burnCategoryType");
        Intrinsics.checkNotNullParameter(str3, "country");
        this.itemId = str;
        this.burnCategoryType = str2;
        this.country = str3;
        this.areaId = i11;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getBurnCategoryType() {
        return this.burnCategoryType;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }
}
