package com.talabat.darkstores.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.data.discovery.model.ImageUrl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/model/Category;", "Landroid/os/Parcelable;", "name", "", "id", "imageUrls", "", "Lcom/talabat/darkstores/data/discovery/model/ImageUrl;", "subcategories", "Lcom/talabat/darkstores/model/SubCategory;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getImageUrls", "()Ljava/util/List;", "getName", "getSubcategories", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class Category implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<Category> CREATOR = new Creator();
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56636id;
    @Nullable
    private final List<ImageUrl> imageUrls;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56637name;
    @NotNull
    private final List<SubCategory> subcategories;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Category> {
        @NotNull
        public final Category createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList2.add(ImageUrl.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt2);
            for (int i12 = 0; i12 != readInt2; i12++) {
                arrayList3.add(SubCategory.CREATOR.createFromParcel(parcel));
            }
            return new Category(readString, readString2, arrayList, arrayList3);
        }

        @NotNull
        public final Category[] newArray(int i11) {
            return new Category[i11];
        }
    }

    public Category(@NotNull String str, @NotNull String str2, @Nullable @Json(name = "image_urls") List<ImageUrl> list, @NotNull @Json(name = "sub_categories") List<SubCategory> list2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(list2, "subcategories");
        this.f56637name = str;
        this.f56636id = str2;
        this.imageUrls = list;
        this.subcategories = list2;
    }

    public static /* synthetic */ Category copy$default(Category category, String str, String str2, List<ImageUrl> list, List<SubCategory> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = category.f56637name;
        }
        if ((i11 & 2) != 0) {
            str2 = category.f56636id;
        }
        if ((i11 & 4) != 0) {
            list = category.imageUrls;
        }
        if ((i11 & 8) != 0) {
            list2 = category.subcategories;
        }
        return category.copy(str, str2, list, list2);
    }

    @NotNull
    public final String component1() {
        return this.f56637name;
    }

    @NotNull
    public final String component2() {
        return this.f56636id;
    }

    @Nullable
    public final List<ImageUrl> component3() {
        return this.imageUrls;
    }

    @NotNull
    public final List<SubCategory> component4() {
        return this.subcategories;
    }

    @NotNull
    public final Category copy(@NotNull String str, @NotNull String str2, @Nullable @Json(name = "image_urls") List<ImageUrl> list, @NotNull @Json(name = "sub_categories") List<SubCategory> list2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(list2, "subcategories");
        return new Category(str, str2, list, list2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return Intrinsics.areEqual((Object) this.f56637name, (Object) category.f56637name) && Intrinsics.areEqual((Object) this.f56636id, (Object) category.f56636id) && Intrinsics.areEqual((Object) this.imageUrls, (Object) category.imageUrls) && Intrinsics.areEqual((Object) this.subcategories, (Object) category.subcategories);
    }

    @NotNull
    public final String getId() {
        return this.f56636id;
    }

    @Nullable
    public final List<ImageUrl> getImageUrls() {
        return this.imageUrls;
    }

    @NotNull
    public final String getName() {
        return this.f56637name;
    }

    @NotNull
    public final List<SubCategory> getSubcategories() {
        return this.subcategories;
    }

    public int hashCode() {
        int hashCode = ((this.f56637name.hashCode() * 31) + this.f56636id.hashCode()) * 31;
        List<ImageUrl> list = this.imageUrls;
        return ((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.subcategories.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f56637name;
        String str2 = this.f56636id;
        List<ImageUrl> list = this.imageUrls;
        List<SubCategory> list2 = this.subcategories;
        return "Category(name=" + str + ", id=" + str2 + ", imageUrls=" + list + ", subcategories=" + list2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f56637name);
        parcel.writeString(this.f56636id);
        List<ImageUrl> list = this.imageUrls;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (ImageUrl writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i11);
            }
        }
        List<SubCategory> list2 = this.subcategories;
        parcel.writeInt(list2.size());
        for (SubCategory writeToParcel2 : list2) {
            writeToParcel2.writeToParcel(parcel, i11);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Category(String str, String str2, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
