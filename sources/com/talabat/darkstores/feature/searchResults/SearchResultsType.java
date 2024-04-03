package com.talabat.darkstores.feature.searchResults;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = false)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "Landroid/os/Parcelable;", "()V", "Banner", "Category", "LifestyleMissionControl", "LifestyleMissionControlV2", "PrimaryMissionControl", "Query", "SwimlaneProducts", "Tag", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Query;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Tag;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Banner;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Category;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$LifestyleMissionControl;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$LifestyleMissionControlV2;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$PrimaryMissionControl;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$SwimlaneProducts;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SearchResultsType implements Parcelable {

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Banner;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Banner extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<Banner> CREATOR = new Creator();
        @NotNull
        private final String tag;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Banner> {
            @NotNull
            public final Banner createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Banner(parcel.readString());
            }

            @NotNull
            public final Banner[] newArray(int i11) {
                return new Banner[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Banner(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "tag");
            this.tag = str;
        }

        public static /* synthetic */ Banner copy$default(Banner banner, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = banner.tag;
            }
            return banner.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.tag;
        }

        @NotNull
        public final Banner copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            return new Banner(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Banner) && Intrinsics.areEqual((Object) this.tag, (Object) ((Banner) obj).tag);
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            return this.tag.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.tag;
            return "Banner(tag=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.tag);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Category;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "categoryId", "", "categoryName", "query", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getQuery", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Category extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<Category> CREATOR = new Creator();
        @NotNull
        private final String categoryId;
        @NotNull
        private final String categoryName;
        @NotNull
        private final String query;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Category> {
            @NotNull
            public final Category createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Category(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @NotNull
            public final Category[] newArray(int i11) {
                return new Category[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Category(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "query");
            this.categoryId = str;
            this.categoryName = str2;
            this.query = str3;
        }

        public static /* synthetic */ Category copy$default(Category category, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = category.categoryId;
            }
            if ((i11 & 2) != 0) {
                str2 = category.categoryName;
            }
            if ((i11 & 4) != 0) {
                str3 = category.query;
            }
            return category.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.categoryId;
        }

        @NotNull
        public final String component2() {
            return this.categoryName;
        }

        @NotNull
        public final String component3() {
            return this.query;
        }

        @NotNull
        public final Category copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "query");
            return new Category(str, str2, str3);
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
            return Intrinsics.areEqual((Object) this.categoryId, (Object) category.categoryId) && Intrinsics.areEqual((Object) this.categoryName, (Object) category.categoryName) && Intrinsics.areEqual((Object) this.query, (Object) category.query);
        }

        @NotNull
        public final String getCategoryId() {
            return this.categoryId;
        }

        @NotNull
        public final String getCategoryName() {
            return this.categoryName;
        }

        @NotNull
        public final String getQuery() {
            return this.query;
        }

        public int hashCode() {
            return (((this.categoryId.hashCode() * 31) + this.categoryName.hashCode()) * 31) + this.query.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.categoryId;
            String str2 = this.categoryName;
            String str3 = this.query;
            return "Category(categoryId=" + str + ", categoryName=" + str2 + ", query=" + str3 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.categoryId);
            parcel.writeString(this.categoryName);
            parcel.writeString(this.query);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$LifestyleMissionControl;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "code", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LifestyleMissionControl extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<LifestyleMissionControl> CREATOR = new Creator();
        @NotNull
        private final String code;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f56622name;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<LifestyleMissionControl> {
            @NotNull
            public final LifestyleMissionControl createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new LifestyleMissionControl(parcel.readString(), parcel.readString());
            }

            @NotNull
            public final LifestyleMissionControl[] newArray(int i11) {
                return new LifestyleMissionControl[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LifestyleMissionControl(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
            Intrinsics.checkNotNullParameter(str2, "name");
            this.code = str;
            this.f56622name = str2;
        }

        public static /* synthetic */ LifestyleMissionControl copy$default(LifestyleMissionControl lifestyleMissionControl, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = lifestyleMissionControl.code;
            }
            if ((i11 & 2) != 0) {
                str2 = lifestyleMissionControl.f56622name;
            }
            return lifestyleMissionControl.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.code;
        }

        @NotNull
        public final String component2() {
            return this.f56622name;
        }

        @NotNull
        public final LifestyleMissionControl copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
            Intrinsics.checkNotNullParameter(str2, "name");
            return new LifestyleMissionControl(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LifestyleMissionControl)) {
                return false;
            }
            LifestyleMissionControl lifestyleMissionControl = (LifestyleMissionControl) obj;
            return Intrinsics.areEqual((Object) this.code, (Object) lifestyleMissionControl.code) && Intrinsics.areEqual((Object) this.f56622name, (Object) lifestyleMissionControl.f56622name);
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final String getName() {
            return this.f56622name;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.f56622name.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.code;
            String str2 = this.f56622name;
            return "LifestyleMissionControl(code=" + str + ", name=" + str2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.code);
            parcel.writeString(this.f56622name);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$LifestyleMissionControlV2;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "swimlaneId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getSwimlaneId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LifestyleMissionControlV2 extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<LifestyleMissionControlV2> CREATOR = new Creator();
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f56623name;
        @NotNull
        private final String swimlaneId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<LifestyleMissionControlV2> {
            @NotNull
            public final LifestyleMissionControlV2 createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new LifestyleMissionControlV2(parcel.readString(), parcel.readString());
            }

            @NotNull
            public final LifestyleMissionControlV2[] newArray(int i11) {
                return new LifestyleMissionControlV2[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LifestyleMissionControlV2(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "swimlaneId");
            Intrinsics.checkNotNullParameter(str2, "name");
            this.swimlaneId = str;
            this.f56623name = str2;
        }

        public static /* synthetic */ LifestyleMissionControlV2 copy$default(LifestyleMissionControlV2 lifestyleMissionControlV2, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = lifestyleMissionControlV2.swimlaneId;
            }
            if ((i11 & 2) != 0) {
                str2 = lifestyleMissionControlV2.f56623name;
            }
            return lifestyleMissionControlV2.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.swimlaneId;
        }

        @NotNull
        public final String component2() {
            return this.f56623name;
        }

        @NotNull
        public final LifestyleMissionControlV2 copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "swimlaneId");
            Intrinsics.checkNotNullParameter(str2, "name");
            return new LifestyleMissionControlV2(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LifestyleMissionControlV2)) {
                return false;
            }
            LifestyleMissionControlV2 lifestyleMissionControlV2 = (LifestyleMissionControlV2) obj;
            return Intrinsics.areEqual((Object) this.swimlaneId, (Object) lifestyleMissionControlV2.swimlaneId) && Intrinsics.areEqual((Object) this.f56623name, (Object) lifestyleMissionControlV2.f56623name);
        }

        @NotNull
        public final String getName() {
            return this.f56623name;
        }

        @NotNull
        public final String getSwimlaneId() {
            return this.swimlaneId;
        }

        public int hashCode() {
            return (this.swimlaneId.hashCode() * 31) + this.f56623name.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.swimlaneId;
            String str2 = this.f56623name;
            return "LifestyleMissionControlV2(swimlaneId=" + str + ", name=" + str2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.swimlaneId);
            parcel.writeString(this.f56623name);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$PrimaryMissionControl;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "code", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PrimaryMissionControl extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<PrimaryMissionControl> CREATOR = new Creator();
        @NotNull
        private final String code;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f56624name;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PrimaryMissionControl> {
            @NotNull
            public final PrimaryMissionControl createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PrimaryMissionControl(parcel.readString(), parcel.readString());
            }

            @NotNull
            public final PrimaryMissionControl[] newArray(int i11) {
                return new PrimaryMissionControl[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrimaryMissionControl(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
            Intrinsics.checkNotNullParameter(str2, "name");
            this.code = str;
            this.f56624name = str2;
        }

        public static /* synthetic */ PrimaryMissionControl copy$default(PrimaryMissionControl primaryMissionControl, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = primaryMissionControl.code;
            }
            if ((i11 & 2) != 0) {
                str2 = primaryMissionControl.f56624name;
            }
            return primaryMissionControl.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.code;
        }

        @NotNull
        public final String component2() {
            return this.f56624name;
        }

        @NotNull
        public final PrimaryMissionControl copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
            Intrinsics.checkNotNullParameter(str2, "name");
            return new PrimaryMissionControl(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrimaryMissionControl)) {
                return false;
            }
            PrimaryMissionControl primaryMissionControl = (PrimaryMissionControl) obj;
            return Intrinsics.areEqual((Object) this.code, (Object) primaryMissionControl.code) && Intrinsics.areEqual((Object) this.f56624name, (Object) primaryMissionControl.f56624name);
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final String getName() {
            return this.f56624name;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.f56624name.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.code;
            String str2 = this.f56624name;
            return "PrimaryMissionControl(code=" + str + ", name=" + str2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.code);
            parcel.writeString(this.f56624name);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Query;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "query", "", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Query extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<Query> CREATOR = new Creator();
        @NotNull
        private final String query;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Query> {
            @NotNull
            public final Query createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Query(parcel.readString());
            }

            @NotNull
            public final Query[] newArray(int i11) {
                return new Query[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Query(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "query");
            this.query = str;
        }

        public static /* synthetic */ Query copy$default(Query query2, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = query2.query;
            }
            return query2.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.query;
        }

        @NotNull
        public final Query copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "query");
            return new Query(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Query) && Intrinsics.areEqual((Object) this.query, (Object) ((Query) obj).query);
        }

        @NotNull
        public final String getQuery() {
            return this.query;
        }

        public int hashCode() {
            return this.query.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.query;
            return "Query(query=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.query);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$SwimlaneProducts;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "swimlaneId", "", "name", "productId", "productSku", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getProductId", "getProductSku", "getSwimlaneId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SwimlaneProducts extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<SwimlaneProducts> CREATOR = new Creator();
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f56625name;
        @NotNull
        private final String productId;
        @NotNull
        private final String productSku;
        @NotNull
        private final String swimlaneId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SwimlaneProducts> {
            @NotNull
            public final SwimlaneProducts createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SwimlaneProducts(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @NotNull
            public final SwimlaneProducts[] newArray(int i11) {
                return new SwimlaneProducts[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SwimlaneProducts(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "swimlaneId");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "productId");
            Intrinsics.checkNotNullParameter(str4, "productSku");
            this.swimlaneId = str;
            this.f56625name = str2;
            this.productId = str3;
            this.productSku = str4;
        }

        public static /* synthetic */ SwimlaneProducts copy$default(SwimlaneProducts swimlaneProducts, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = swimlaneProducts.swimlaneId;
            }
            if ((i11 & 2) != 0) {
                str2 = swimlaneProducts.f56625name;
            }
            if ((i11 & 4) != 0) {
                str3 = swimlaneProducts.productId;
            }
            if ((i11 & 8) != 0) {
                str4 = swimlaneProducts.productSku;
            }
            return swimlaneProducts.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.swimlaneId;
        }

        @NotNull
        public final String component2() {
            return this.f56625name;
        }

        @NotNull
        public final String component3() {
            return this.productId;
        }

        @NotNull
        public final String component4() {
            return this.productSku;
        }

        @NotNull
        public final SwimlaneProducts copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "swimlaneId");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "productId");
            Intrinsics.checkNotNullParameter(str4, "productSku");
            return new SwimlaneProducts(str, str2, str3, str4);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SwimlaneProducts)) {
                return false;
            }
            SwimlaneProducts swimlaneProducts = (SwimlaneProducts) obj;
            return Intrinsics.areEqual((Object) this.swimlaneId, (Object) swimlaneProducts.swimlaneId) && Intrinsics.areEqual((Object) this.f56625name, (Object) swimlaneProducts.f56625name) && Intrinsics.areEqual((Object) this.productId, (Object) swimlaneProducts.productId) && Intrinsics.areEqual((Object) this.productSku, (Object) swimlaneProducts.productSku);
        }

        @NotNull
        public final String getName() {
            return this.f56625name;
        }

        @NotNull
        public final String getProductId() {
            return this.productId;
        }

        @NotNull
        public final String getProductSku() {
            return this.productSku;
        }

        @NotNull
        public final String getSwimlaneId() {
            return this.swimlaneId;
        }

        public int hashCode() {
            return (((((this.swimlaneId.hashCode() * 31) + this.f56625name.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.productSku.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.swimlaneId;
            String str2 = this.f56625name;
            String str3 = this.productId;
            String str4 = this.productSku;
            return "SwimlaneProducts(swimlaneId=" + str + ", name=" + str2 + ", productId=" + str3 + ", productSku=" + str4 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.swimlaneId);
            parcel.writeString(this.f56625name);
            parcel.writeString(this.productId);
            parcel.writeString(this.productSku);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsType$Tag;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "tag", "", "swimlaneTitle", "(Ljava/lang/String;Ljava/lang/String;)V", "getSwimlaneTitle", "()Ljava/lang/String;", "getTag", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Tag extends SearchResultsType {
        @NotNull
        public static final Parcelable.Creator<Tag> CREATOR = new Creator();
        @Nullable
        private final String swimlaneTitle;
        @NotNull
        private final String tag;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Tag> {
            @NotNull
            public final Tag createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Tag(parcel.readString(), parcel.readString());
            }

            @NotNull
            public final Tag[] newArray(int i11) {
                return new Tag[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Tag(@NotNull String str, @Nullable String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "tag");
            this.tag = str;
            this.swimlaneTitle = str2;
        }

        public static /* synthetic */ Tag copy$default(Tag tag2, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = tag2.tag;
            }
            if ((i11 & 2) != 0) {
                str2 = tag2.swimlaneTitle;
            }
            return tag2.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.tag;
        }

        @Nullable
        public final String component2() {
            return this.swimlaneTitle;
        }

        @NotNull
        public final Tag copy(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            return new Tag(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Tag)) {
                return false;
            }
            Tag tag2 = (Tag) obj;
            return Intrinsics.areEqual((Object) this.tag, (Object) tag2.tag) && Intrinsics.areEqual((Object) this.swimlaneTitle, (Object) tag2.swimlaneTitle);
        }

        @Nullable
        public final String getSwimlaneTitle() {
            return this.swimlaneTitle;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            int hashCode = this.tag.hashCode() * 31;
            String str = this.swimlaneTitle;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            String str = this.tag;
            String str2 = this.swimlaneTitle;
            return "Tag(tag=" + str + ", swimlaneTitle=" + str2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.tag);
            parcel.writeString(this.swimlaneTitle);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Tag(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? null : str2);
        }
    }

    private SearchResultsType() {
    }

    public /* synthetic */ SearchResultsType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
