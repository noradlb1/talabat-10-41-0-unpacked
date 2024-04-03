package datamodels;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JS\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Ldatamodels/HomeSwimlanesTrackerData;", "Ljava/io/Serializable;", "swimlaneTitles", "", "strategiesList", "swimlanesCount", "", "swimlaneRequestId", "swimlaneVariation", "screenType", "screenName", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "getScreenType", "getStrategiesList", "getSwimlaneRequestId", "getSwimlaneTitles", "getSwimlaneVariation", "setSwimlaneVariation", "(Ljava/lang/String;)V", "getSwimlanesCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeSwimlanesTrackerData implements Serializable {
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String strategiesList;
    @Nullable
    private final String swimlaneRequestId;
    @NotNull
    private final String swimlaneTitles;
    @Nullable
    private String swimlaneVariation;
    private final int swimlanesCount;

    public HomeSwimlanesTrackerData(@NotNull String str, @NotNull String str2, int i11, @Nullable String str3, @Nullable String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "swimlaneTitles");
        Intrinsics.checkNotNullParameter(str2, "strategiesList");
        Intrinsics.checkNotNullParameter(str5, "screenType");
        Intrinsics.checkNotNullParameter(str6, "screenName");
        this.swimlaneTitles = str;
        this.strategiesList = str2;
        this.swimlanesCount = i11;
        this.swimlaneRequestId = str3;
        this.swimlaneVariation = str4;
        this.screenType = str5;
        this.screenName = str6;
    }

    public static /* synthetic */ HomeSwimlanesTrackerData copy$default(HomeSwimlanesTrackerData homeSwimlanesTrackerData, String str, String str2, int i11, String str3, String str4, String str5, String str6, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = homeSwimlanesTrackerData.swimlaneTitles;
        }
        if ((i12 & 2) != 0) {
            str2 = homeSwimlanesTrackerData.strategiesList;
        }
        String str7 = str2;
        if ((i12 & 4) != 0) {
            i11 = homeSwimlanesTrackerData.swimlanesCount;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            str3 = homeSwimlanesTrackerData.swimlaneRequestId;
        }
        String str8 = str3;
        if ((i12 & 16) != 0) {
            str4 = homeSwimlanesTrackerData.swimlaneVariation;
        }
        String str9 = str4;
        if ((i12 & 32) != 0) {
            str5 = homeSwimlanesTrackerData.screenType;
        }
        String str10 = str5;
        if ((i12 & 64) != 0) {
            str6 = homeSwimlanesTrackerData.screenName;
        }
        return homeSwimlanesTrackerData.copy(str, str7, i13, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.swimlaneTitles;
    }

    @NotNull
    public final String component2() {
        return this.strategiesList;
    }

    public final int component3() {
        return this.swimlanesCount;
    }

    @Nullable
    public final String component4() {
        return this.swimlaneRequestId;
    }

    @Nullable
    public final String component5() {
        return this.swimlaneVariation;
    }

    @NotNull
    public final String component6() {
        return this.screenType;
    }

    @NotNull
    public final String component7() {
        return this.screenName;
    }

    @NotNull
    public final HomeSwimlanesTrackerData copy(@NotNull String str, @NotNull String str2, int i11, @Nullable String str3, @Nullable String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "swimlaneTitles");
        Intrinsics.checkNotNullParameter(str2, "strategiesList");
        Intrinsics.checkNotNullParameter(str5, "screenType");
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str7, "screenName");
        return new HomeSwimlanesTrackerData(str, str2, i11, str3, str4, str5, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeSwimlanesTrackerData)) {
            return false;
        }
        HomeSwimlanesTrackerData homeSwimlanesTrackerData = (HomeSwimlanesTrackerData) obj;
        return Intrinsics.areEqual((Object) this.swimlaneTitles, (Object) homeSwimlanesTrackerData.swimlaneTitles) && Intrinsics.areEqual((Object) this.strategiesList, (Object) homeSwimlanesTrackerData.strategiesList) && this.swimlanesCount == homeSwimlanesTrackerData.swimlanesCount && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) homeSwimlanesTrackerData.swimlaneRequestId) && Intrinsics.areEqual((Object) this.swimlaneVariation, (Object) homeSwimlanesTrackerData.swimlaneVariation) && Intrinsics.areEqual((Object) this.screenType, (Object) homeSwimlanesTrackerData.screenType) && Intrinsics.areEqual((Object) this.screenName, (Object) homeSwimlanesTrackerData.screenName);
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getScreenType() {
        return this.screenType;
    }

    @NotNull
    public final String getStrategiesList() {
        return this.strategiesList;
    }

    @Nullable
    public final String getSwimlaneRequestId() {
        return this.swimlaneRequestId;
    }

    @NotNull
    public final String getSwimlaneTitles() {
        return this.swimlaneTitles;
    }

    @Nullable
    public final String getSwimlaneVariation() {
        return this.swimlaneVariation;
    }

    public final int getSwimlanesCount() {
        return this.swimlanesCount;
    }

    public int hashCode() {
        int hashCode = ((((this.swimlaneTitles.hashCode() * 31) + this.strategiesList.hashCode()) * 31) + this.swimlanesCount) * 31;
        String str = this.swimlaneRequestId;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.swimlaneVariation;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((((hashCode2 + i11) * 31) + this.screenType.hashCode()) * 31) + this.screenName.hashCode();
    }

    public final void setSwimlaneVariation(@Nullable String str) {
        this.swimlaneVariation = str;
    }

    @NotNull
    public String toString() {
        String str = this.swimlaneTitles;
        String str2 = this.strategiesList;
        int i11 = this.swimlanesCount;
        String str3 = this.swimlaneRequestId;
        String str4 = this.swimlaneVariation;
        String str5 = this.screenType;
        String str6 = this.screenName;
        return "HomeSwimlanesTrackerData(swimlaneTitles=" + str + ", strategiesList=" + str2 + ", swimlanesCount=" + i11 + ", swimlaneRequestId=" + str3 + ", swimlaneVariation=" + str4 + ", screenType=" + str5 + ", screenName=" + str6 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeSwimlanesTrackerData(String str, String str2, int i11, String str3, String str4, String str5, String str6, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : str3, (i12 & 16) != 0 ? null : str4, str5, str6);
    }
}
