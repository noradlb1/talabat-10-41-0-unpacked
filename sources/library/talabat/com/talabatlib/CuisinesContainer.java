package library.talabat.com.talabatlib;

import datamodels.Cuisine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Llibrary/talabat/com/talabatlib/CuisinesContainer;", "", "all", "Ljava/util/ArrayList;", "Ldatamodels/Cuisine;", "popular", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAll", "()Ljava/util/ArrayList;", "getPopular", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesContainer {
    @Nullable
    private final ArrayList<Cuisine> all;
    @Nullable
    private final ArrayList<Cuisine> popular;

    public CuisinesContainer(@Nullable ArrayList<Cuisine> arrayList, @Nullable ArrayList<Cuisine> arrayList2) {
        this.all = arrayList;
        this.popular = arrayList2;
    }

    public static /* synthetic */ CuisinesContainer copy$default(CuisinesContainer cuisinesContainer, ArrayList<Cuisine> arrayList, ArrayList<Cuisine> arrayList2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            arrayList = cuisinesContainer.all;
        }
        if ((i11 & 2) != 0) {
            arrayList2 = cuisinesContainer.popular;
        }
        return cuisinesContainer.copy(arrayList, arrayList2);
    }

    @Nullable
    public final ArrayList<Cuisine> component1() {
        return this.all;
    }

    @Nullable
    public final ArrayList<Cuisine> component2() {
        return this.popular;
    }

    @NotNull
    public final CuisinesContainer copy(@Nullable ArrayList<Cuisine> arrayList, @Nullable ArrayList<Cuisine> arrayList2) {
        return new CuisinesContainer(arrayList, arrayList2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CuisinesContainer)) {
            return false;
        }
        CuisinesContainer cuisinesContainer = (CuisinesContainer) obj;
        return Intrinsics.areEqual((Object) this.all, (Object) cuisinesContainer.all) && Intrinsics.areEqual((Object) this.popular, (Object) cuisinesContainer.popular);
    }

    @Nullable
    public final ArrayList<Cuisine> getAll() {
        return this.all;
    }

    @Nullable
    public final ArrayList<Cuisine> getPopular() {
        return this.popular;
    }

    public int hashCode() {
        ArrayList<Cuisine> arrayList = this.all;
        int i11 = 0;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        ArrayList<Cuisine> arrayList2 = this.popular;
        if (arrayList2 != null) {
            i11 = arrayList2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        ArrayList<Cuisine> arrayList = this.all;
        ArrayList<Cuisine> arrayList2 = this.popular;
        return "CuisinesContainer(all=" + arrayList + ", popular=" + arrayList2 + ")";
    }
}
