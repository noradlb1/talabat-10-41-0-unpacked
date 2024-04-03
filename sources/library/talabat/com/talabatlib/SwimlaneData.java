package library.talabat.com.talabatlib;

import com.google.gson.annotations.SerializedName;
import datamodels.FeaturedProducts;
import datamodels.Swimlane;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Llibrary/talabat/com/talabatlib/SwimlaneData;", "", "swimLanes", "Ljava/util/ArrayList;", "Ldatamodels/Swimlane;", "featureProduct", "", "Ldatamodels/FeaturedProducts;", "(Ljava/util/ArrayList;Ljava/util/List;)V", "getFeatureProduct", "()Ljava/util/List;", "getSwimLanes", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneData {
    @SerializedName("featuredProducts")
    @Nullable
    private final List<FeaturedProducts> featureProduct;
    @SerializedName("swimLanes")
    @Nullable
    private final ArrayList<Swimlane> swimLanes;

    public SwimlaneData() {
        this((ArrayList) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public SwimlaneData(@Nullable ArrayList<Swimlane> arrayList, @Nullable List<FeaturedProducts> list) {
        this.swimLanes = arrayList;
        this.featureProduct = list;
    }

    public static /* synthetic */ SwimlaneData copy$default(SwimlaneData swimlaneData, ArrayList<Swimlane> arrayList, List<FeaturedProducts> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            arrayList = swimlaneData.swimLanes;
        }
        if ((i11 & 2) != 0) {
            list = swimlaneData.featureProduct;
        }
        return swimlaneData.copy(arrayList, list);
    }

    @Nullable
    public final ArrayList<Swimlane> component1() {
        return this.swimLanes;
    }

    @Nullable
    public final List<FeaturedProducts> component2() {
        return this.featureProduct;
    }

    @NotNull
    public final SwimlaneData copy(@Nullable ArrayList<Swimlane> arrayList, @Nullable List<FeaturedProducts> list) {
        return new SwimlaneData(arrayList, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneData)) {
            return false;
        }
        SwimlaneData swimlaneData = (SwimlaneData) obj;
        return Intrinsics.areEqual((Object) this.swimLanes, (Object) swimlaneData.swimLanes) && Intrinsics.areEqual((Object) this.featureProduct, (Object) swimlaneData.featureProduct);
    }

    @Nullable
    public final List<FeaturedProducts> getFeatureProduct() {
        return this.featureProduct;
    }

    @Nullable
    public final ArrayList<Swimlane> getSwimLanes() {
        return this.swimLanes;
    }

    public int hashCode() {
        ArrayList<Swimlane> arrayList = this.swimLanes;
        int i11 = 0;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        List<FeaturedProducts> list = this.featureProduct;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        ArrayList<Swimlane> arrayList = this.swimLanes;
        List<FeaturedProducts> list = this.featureProduct;
        return "SwimlaneData(swimLanes=" + arrayList + ", featureProduct=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlaneData(ArrayList arrayList, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : arrayList, (i11 & 2) != 0 ? null : list);
    }
}
