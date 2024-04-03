package com.talabat.core.navigation.domain.screen.rewards;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/rewards/BurnOptionsScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/rewards/BurnOptionsScreen$Data;", "data", "(Lcom/talabat/core/navigation/domain/screen/rewards/BurnOptionsScreen$Data;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/rewards/BurnOptionsScreen$Data;", "link", "", "getLink", "()Ljava/lang/String;", "Data", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsScreen implements Screen<Data> {
    @NotNull
    private final Data data;
    @NotNull
    private final String link = GrowthNavigatorActions.OPEN_LOYALTY_FEATURED_LIST_ACTIVITY;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006+"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/rewards/BurnOptionsScreen$Data;", "Landroid/os/Parcelable;", "categoryId", "", "categoryName", "categoryType", "totalPoints", "", "channelName", "channelPosition", "burnItemsDisplayModel", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/util/List;)V", "getBurnItemsDisplayModel", "()Ljava/util/List;", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getCategoryType", "getChannelName", "getChannelPosition", "()I", "getTotalPoints", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class Data implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<Data> CREATOR = new Creator();
        @NotNull
        private final List<Parcelable> burnItemsDisplayModel;
        @NotNull
        private final String categoryId;
        @NotNull
        private final String categoryName;
        @NotNull
        private final String categoryType;
        @NotNull
        private final String channelName;
        private final int channelPosition;
        private final int totalPoints;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Data> {
            @NotNull
            public final Data createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                int readInt = parcel.readInt();
                String readString4 = parcel.readString();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt3);
                for (int i11 = 0; i11 != readInt3; i11++) {
                    arrayList.add(parcel.readParcelable(Data.class.getClassLoader()));
                }
                return new Data(readString, readString2, readString3, readInt, readString4, readInt2, arrayList);
            }

            @NotNull
            public final Data[] newArray(int i11) {
                return new Data[i11];
            }
        }

        public Data(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, @NotNull String str4, int i12, @NotNull List<? extends Parcelable> list) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CATEGORY_TYPE);
            Intrinsics.checkNotNullParameter(str4, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CHANNEL_NAME);
            Intrinsics.checkNotNullParameter(list, "burnItemsDisplayModel");
            this.categoryId = str;
            this.categoryName = str2;
            this.categoryType = str3;
            this.totalPoints = i11;
            this.channelName = str4;
            this.channelPosition = i12;
            this.burnItemsDisplayModel = list;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, int i11, String str4, int i12, List<Parcelable> list, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                str = data.categoryId;
            }
            if ((i13 & 2) != 0) {
                str2 = data.categoryName;
            }
            String str5 = str2;
            if ((i13 & 4) != 0) {
                str3 = data.categoryType;
            }
            String str6 = str3;
            if ((i13 & 8) != 0) {
                i11 = data.totalPoints;
            }
            int i14 = i11;
            if ((i13 & 16) != 0) {
                str4 = data.channelName;
            }
            String str7 = str4;
            if ((i13 & 32) != 0) {
                i12 = data.channelPosition;
            }
            int i15 = i12;
            if ((i13 & 64) != 0) {
                list = data.burnItemsDisplayModel;
            }
            return data.copy(str, str5, str6, i14, str7, i15, list);
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
            return this.categoryType;
        }

        public final int component4() {
            return this.totalPoints;
        }

        @NotNull
        public final String component5() {
            return this.channelName;
        }

        public final int component6() {
            return this.channelPosition;
        }

        @NotNull
        public final List<Parcelable> component7() {
            return this.burnItemsDisplayModel;
        }

        @NotNull
        public final Data copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, @NotNull String str4, int i12, @NotNull List<? extends Parcelable> list) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CATEGORY_TYPE);
            Intrinsics.checkNotNullParameter(str4, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CHANNEL_NAME);
            List<? extends Parcelable> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "burnItemsDisplayModel");
            return new Data(str, str2, str3, i11, str4, i12, list2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.categoryId, (Object) data.categoryId) && Intrinsics.areEqual((Object) this.categoryName, (Object) data.categoryName) && Intrinsics.areEqual((Object) this.categoryType, (Object) data.categoryType) && this.totalPoints == data.totalPoints && Intrinsics.areEqual((Object) this.channelName, (Object) data.channelName) && this.channelPosition == data.channelPosition && Intrinsics.areEqual((Object) this.burnItemsDisplayModel, (Object) data.burnItemsDisplayModel);
        }

        @NotNull
        public final List<Parcelable> getBurnItemsDisplayModel() {
            return this.burnItemsDisplayModel;
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
        public final String getCategoryType() {
            return this.categoryType;
        }

        @NotNull
        public final String getChannelName() {
            return this.channelName;
        }

        public final int getChannelPosition() {
            return this.channelPosition;
        }

        public final int getTotalPoints() {
            return this.totalPoints;
        }

        public int hashCode() {
            return (((((((((((this.categoryId.hashCode() * 31) + this.categoryName.hashCode()) * 31) + this.categoryType.hashCode()) * 31) + this.totalPoints) * 31) + this.channelName.hashCode()) * 31) + this.channelPosition) * 31) + this.burnItemsDisplayModel.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.categoryId;
            String str2 = this.categoryName;
            String str3 = this.categoryType;
            int i11 = this.totalPoints;
            String str4 = this.channelName;
            int i12 = this.channelPosition;
            List<Parcelable> list = this.burnItemsDisplayModel;
            return "Data(categoryId=" + str + ", categoryName=" + str2 + ", categoryType=" + str3 + ", totalPoints=" + i11 + ", channelName=" + str4 + ", channelPosition=" + i12 + ", burnItemsDisplayModel=" + list + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.categoryId);
            parcel.writeString(this.categoryName);
            parcel.writeString(this.categoryType);
            parcel.writeInt(this.totalPoints);
            parcel.writeString(this.channelName);
            parcel.writeInt(this.channelPosition);
            List<Parcelable> list = this.burnItemsDisplayModel;
            parcel.writeInt(list.size());
            for (Parcelable writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i11);
            }
        }
    }

    public BurnOptionsScreen(@NotNull Data data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public Data getData() {
        return this.data;
    }
}
