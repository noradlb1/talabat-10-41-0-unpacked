package com.talabat.restaurants.v2.data.swimlane;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;", "", "getSwimlanes", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/SwimlaneResponse;", "data", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository$SwimlaneData;", "SwimlaneData", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SwimlaneRepository {
    @NotNull
    Single<SwimlaneResponse> getSwimlanes(@NotNull SwimlaneData swimlaneData);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b*\b\b\u0018\u0000 42\u00020\u0001:\u00014B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u001d\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b J\u000e\u0010!\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b&J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u000bHÀ\u0003¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b*J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b,J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b.Jm\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\bHÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\f\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00065"}, d2 = {"Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository$SwimlaneData;", "", "isForceUpdate", "", "latitude", "", "longitude", "areaId", "", "countryCode", "verticalIds", "", "swimlaneVariant", "placementScreen", "placementPlace", "(ZLjava/lang/String;Ljava/lang/String;IILjava/util/List;ILjava/lang/String;Ljava/lang/String;)V", "getAreaId$com_talabat_talabat_talabat", "()I", "getCountryCode$com_talabat_talabat_talabat", "isForceUpdate$com_talabat_talabat_talabat", "()Z", "getLatitude$com_talabat_talabat_talabat", "()Ljava/lang/String;", "getLongitude$com_talabat_talabat_talabat", "getPlacementPlace$com_talabat_talabat_talabat", "getPlacementScreen$com_talabat_talabat_talabat", "getSwimlaneVariant$com_talabat_talabat_talabat", "getVerticalIds$com_talabat_talabat_talabat", "()Ljava/util/List;", "component1", "component1$com_talabat_talabat_talabat", "component2", "component2$com_talabat_talabat_talabat", "component3", "component3$com_talabat_talabat_talabat", "component4", "component4$com_talabat_talabat_talabat", "component5", "component5$com_talabat_talabat_talabat", "component6", "component6$com_talabat_talabat_talabat", "component7", "component7$com_talabat_talabat_talabat", "component8", "component8$com_talabat_talabat_talabat", "component9", "component9$com_talabat_talabat_talabat", "copy", "equals", "other", "hashCode", "toString", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SwimlaneData {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        public static final String PLACEMENT_PLACE_SWIMLANES = "swimlane";
        @NotNull
        public static final String PLACEMENT_SCREEN_RESTAURANTS = "shop_list";
        private final int areaId;
        private final int countryCode;
        private final boolean isForceUpdate;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;
        @Nullable
        private final String placementPlace;
        @Nullable
        private final String placementScreen;
        private final int swimlaneVariant;
        @NotNull
        private final List<Integer> verticalIds;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository$SwimlaneData$Companion;", "", "()V", "PLACEMENT_PLACE_SWIMLANES", "", "PLACEMENT_SCREEN_RESTAURANTS", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SwimlaneData(boolean z11, @NotNull String str, @NotNull String str2, int i11, int i12, @NotNull List<Integer> list, int i13, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            Intrinsics.checkNotNullParameter(list, "verticalIds");
            this.isForceUpdate = z11;
            this.latitude = str;
            this.longitude = str2;
            this.areaId = i11;
            this.countryCode = i12;
            this.verticalIds = list;
            this.swimlaneVariant = i13;
            this.placementScreen = str3;
            this.placementPlace = str4;
        }

        public static /* synthetic */ SwimlaneData copy$default(SwimlaneData swimlaneData, boolean z11, String str, String str2, int i11, int i12, List list, int i13, String str3, String str4, int i14, Object obj) {
            SwimlaneData swimlaneData2 = swimlaneData;
            int i15 = i14;
            return swimlaneData.copy((i15 & 1) != 0 ? swimlaneData2.isForceUpdate : z11, (i15 & 2) != 0 ? swimlaneData2.latitude : str, (i15 & 4) != 0 ? swimlaneData2.longitude : str2, (i15 & 8) != 0 ? swimlaneData2.areaId : i11, (i15 & 16) != 0 ? swimlaneData2.countryCode : i12, (i15 & 32) != 0 ? swimlaneData2.verticalIds : list, (i15 & 64) != 0 ? swimlaneData2.swimlaneVariant : i13, (i15 & 128) != 0 ? swimlaneData2.placementScreen : str3, (i15 & 256) != 0 ? swimlaneData2.placementPlace : str4);
        }

        public final boolean component1$com_talabat_talabat_talabat() {
            return this.isForceUpdate;
        }

        @NotNull
        public final String component2$com_talabat_talabat_talabat() {
            return this.latitude;
        }

        @NotNull
        public final String component3$com_talabat_talabat_talabat() {
            return this.longitude;
        }

        public final int component4$com_talabat_talabat_talabat() {
            return this.areaId;
        }

        public final int component5$com_talabat_talabat_talabat() {
            return this.countryCode;
        }

        @NotNull
        public final List<Integer> component6$com_talabat_talabat_talabat() {
            return this.verticalIds;
        }

        public final int component7$com_talabat_talabat_talabat() {
            return this.swimlaneVariant;
        }

        @Nullable
        public final String component8$com_talabat_talabat_talabat() {
            return this.placementScreen;
        }

        @Nullable
        public final String component9$com_talabat_talabat_talabat() {
            return this.placementPlace;
        }

        @NotNull
        public final SwimlaneData copy(boolean z11, @NotNull String str, @NotNull String str2, int i11, int i12, @NotNull List<Integer> list, int i13, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            List<Integer> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "verticalIds");
            return new SwimlaneData(z11, str, str2, i11, i12, list2, i13, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SwimlaneData)) {
                return false;
            }
            SwimlaneData swimlaneData = (SwimlaneData) obj;
            return this.isForceUpdate == swimlaneData.isForceUpdate && Intrinsics.areEqual((Object) this.latitude, (Object) swimlaneData.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) swimlaneData.longitude) && this.areaId == swimlaneData.areaId && this.countryCode == swimlaneData.countryCode && Intrinsics.areEqual((Object) this.verticalIds, (Object) swimlaneData.verticalIds) && this.swimlaneVariant == swimlaneData.swimlaneVariant && Intrinsics.areEqual((Object) this.placementScreen, (Object) swimlaneData.placementScreen) && Intrinsics.areEqual((Object) this.placementPlace, (Object) swimlaneData.placementPlace);
        }

        public final int getAreaId$com_talabat_talabat_talabat() {
            return this.areaId;
        }

        public final int getCountryCode$com_talabat_talabat_talabat() {
            return this.countryCode;
        }

        @NotNull
        public final String getLatitude$com_talabat_talabat_talabat() {
            return this.latitude;
        }

        @NotNull
        public final String getLongitude$com_talabat_talabat_talabat() {
            return this.longitude;
        }

        @Nullable
        public final String getPlacementPlace$com_talabat_talabat_talabat() {
            return this.placementPlace;
        }

        @Nullable
        public final String getPlacementScreen$com_talabat_talabat_talabat() {
            return this.placementScreen;
        }

        public final int getSwimlaneVariant$com_talabat_talabat_talabat() {
            return this.swimlaneVariant;
        }

        @NotNull
        public final List<Integer> getVerticalIds$com_talabat_talabat_talabat() {
            return this.verticalIds;
        }

        public int hashCode() {
            boolean z11 = this.isForceUpdate;
            if (z11) {
                z11 = true;
            }
            int hashCode = (((((((((((((z11 ? 1 : 0) * true) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.areaId) * 31) + this.countryCode) * 31) + this.verticalIds.hashCode()) * 31) + this.swimlaneVariant) * 31;
            String str = this.placementScreen;
            int i11 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.placementPlace;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode2 + i11;
        }

        public final boolean isForceUpdate$com_talabat_talabat_talabat() {
            return this.isForceUpdate;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.isForceUpdate;
            String str = this.latitude;
            String str2 = this.longitude;
            int i11 = this.areaId;
            int i12 = this.countryCode;
            List<Integer> list = this.verticalIds;
            int i13 = this.swimlaneVariant;
            String str3 = this.placementScreen;
            String str4 = this.placementPlace;
            return "SwimlaneData(isForceUpdate=" + z11 + ", latitude=" + str + ", longitude=" + str2 + ", areaId=" + i11 + ", countryCode=" + i12 + ", verticalIds=" + list + ", swimlaneVariant=" + i13 + ", placementScreen=" + str3 + ", placementPlace=" + str4 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ SwimlaneData(boolean r14, java.lang.String r15, java.lang.String r16, int r17, int r18, java.util.List r19, int r20, java.lang.String r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
            /*
                r13 = this;
                r0 = r23
                r1 = r0 & 128(0x80, float:1.794E-43)
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r11 = r2
                goto L_0x000b
            L_0x0009:
                r11 = r21
            L_0x000b:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x0011
                r12 = r2
                goto L_0x0013
            L_0x0011:
                r12 = r22
            L_0x0013:
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r16
                r7 = r17
                r8 = r18
                r9 = r19
                r10 = r20
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository.SwimlaneData.<init>(boolean, java.lang.String, java.lang.String, int, int, java.util.List, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
