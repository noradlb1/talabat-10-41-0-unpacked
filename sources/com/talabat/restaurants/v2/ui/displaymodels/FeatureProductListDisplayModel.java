package com.talabat.restaurants.v2.ui.displaymodels;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "", "featureProductDisplayModels", "", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "name", "", "position", "", "(Ljava/util/List;Ljava/lang/String;I)V", "getFeatureProductDisplayModels", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPosition", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureProductListDisplayModel {
    @NotNull
    private final List<FeatureProductDisplayModel> featureProductDisplayModels;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f61255name;
    private final int position;

    public FeatureProductListDisplayModel(@NotNull List<FeatureProductDisplayModel> list, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(list, "featureProductDisplayModels");
        Intrinsics.checkNotNullParameter(str, "name");
        this.featureProductDisplayModels = list;
        this.f61255name = str;
        this.position = i11;
    }

    public static /* synthetic */ FeatureProductListDisplayModel copy$default(FeatureProductListDisplayModel featureProductListDisplayModel, List<FeatureProductDisplayModel> list, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = featureProductListDisplayModel.featureProductDisplayModels;
        }
        if ((i12 & 2) != 0) {
            str = featureProductListDisplayModel.f61255name;
        }
        if ((i12 & 4) != 0) {
            i11 = featureProductListDisplayModel.position;
        }
        return featureProductListDisplayModel.copy(list, str, i11);
    }

    @NotNull
    public final List<FeatureProductDisplayModel> component1() {
        return this.featureProductDisplayModels;
    }

    @NotNull
    public final String component2() {
        return this.f61255name;
    }

    public final int component3() {
        return this.position;
    }

    @NotNull
    public final FeatureProductListDisplayModel copy(@NotNull List<FeatureProductDisplayModel> list, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(list, "featureProductDisplayModels");
        Intrinsics.checkNotNullParameter(str, "name");
        return new FeatureProductListDisplayModel(list, str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureProductListDisplayModel)) {
            return false;
        }
        FeatureProductListDisplayModel featureProductListDisplayModel = (FeatureProductListDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.featureProductDisplayModels, (Object) featureProductListDisplayModel.featureProductDisplayModels) && Intrinsics.areEqual((Object) this.f61255name, (Object) featureProductListDisplayModel.f61255name) && this.position == featureProductListDisplayModel.position;
    }

    @NotNull
    public final List<FeatureProductDisplayModel> getFeatureProductDisplayModels() {
        return this.featureProductDisplayModels;
    }

    @NotNull
    public final String getName() {
        return this.f61255name;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return (((this.featureProductDisplayModels.hashCode() * 31) + this.f61255name.hashCode()) * 31) + this.position;
    }

    @NotNull
    public String toString() {
        List<FeatureProductDisplayModel> list = this.featureProductDisplayModels;
        String str = this.f61255name;
        int i11 = this.position;
        return "FeatureProductListDisplayModel(featureProductDisplayModels=" + list + ", name=" + str + ", position=" + i11 + ")";
    }
}
