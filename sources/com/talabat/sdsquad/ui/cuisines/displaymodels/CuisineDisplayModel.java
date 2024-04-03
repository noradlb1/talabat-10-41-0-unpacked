package com.talabat.sdsquad.ui.cuisines.displaymodels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "", "id", "", "name", "", "isOn", "", "(ILjava/lang/String;Z)V", "getId", "()I", "()Z", "setOn", "(Z)V", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineDisplayModel {

    /* renamed from: id  reason: collision with root package name */
    private final int f61330id;
    private boolean isOn;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f61331name;

    public CuisineDisplayModel(int i11, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f61330id = i11;
        this.f61331name = str;
        this.isOn = z11;
    }

    public static /* synthetic */ CuisineDisplayModel copy$default(CuisineDisplayModel cuisineDisplayModel, int i11, String str, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = cuisineDisplayModel.f61330id;
        }
        if ((i12 & 2) != 0) {
            str = cuisineDisplayModel.f61331name;
        }
        if ((i12 & 4) != 0) {
            z11 = cuisineDisplayModel.isOn;
        }
        return cuisineDisplayModel.copy(i11, str, z11);
    }

    public final int component1() {
        return this.f61330id;
    }

    @NotNull
    public final String component2() {
        return this.f61331name;
    }

    public final boolean component3() {
        return this.isOn;
    }

    @NotNull
    public final CuisineDisplayModel copy(int i11, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new CuisineDisplayModel(i11, str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CuisineDisplayModel)) {
            return false;
        }
        CuisineDisplayModel cuisineDisplayModel = (CuisineDisplayModel) obj;
        return this.f61330id == cuisineDisplayModel.f61330id && Intrinsics.areEqual((Object) this.f61331name, (Object) cuisineDisplayModel.f61331name) && this.isOn == cuisineDisplayModel.isOn;
    }

    public final int getId() {
        return this.f61330id;
    }

    @NotNull
    public final String getName() {
        return this.f61331name;
    }

    public int hashCode() {
        int hashCode = ((this.f61330id * 31) + this.f61331name.hashCode()) * 31;
        boolean z11 = this.isOn;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final void setOn(boolean z11) {
        this.isOn = z11;
    }

    @NotNull
    public String toString() {
        int i11 = this.f61330id;
        String str = this.f61331name;
        boolean z11 = this.isOn;
        return "CuisineDisplayModel(id=" + i11 + ", name=" + str + ", isOn=" + z11 + ")";
    }
}
