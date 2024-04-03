package com.talabat.fluid.homescreen.data.remote.component;

import com.talabat.configuration.language.Language;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentRequestParams;", "", "externalExperiments", "", "", "deviceWidthInDP", "countryCode", "latitude", "longitude", "areaId", "selectedLanguage", "Lcom/talabat/configuration/language/Language;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/configuration/language/Language;)V", "getAreaId", "()Ljava/lang/String;", "getCountryCode", "getDeviceWidthInDP", "getExternalExperiments", "()Ljava/util/List;", "getLatitude", "getLongitude", "getSelectedLanguage", "()Lcom/talabat/configuration/language/Language;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeComponentRequestParams {
    @NotNull
    private final String areaId;
    @NotNull
    private final String countryCode;
    @NotNull
    private final String deviceWidthInDP;
    @NotNull
    private final List<String> externalExperiments;
    @NotNull
    private final String latitude;
    @NotNull
    private final String longitude;
    @NotNull
    private final Language selectedLanguage;

    public FluidHomeComponentRequestParams(@NotNull List<String> list, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Language language) {
        Intrinsics.checkNotNullParameter(list, "externalExperiments");
        Intrinsics.checkNotNullParameter(str, "deviceWidthInDP");
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        Intrinsics.checkNotNullParameter(str3, "latitude");
        Intrinsics.checkNotNullParameter(str4, "longitude");
        Intrinsics.checkNotNullParameter(str5, "areaId");
        Intrinsics.checkNotNullParameter(language, "selectedLanguage");
        this.externalExperiments = list;
        this.deviceWidthInDP = str;
        this.countryCode = str2;
        this.latitude = str3;
        this.longitude = str4;
        this.areaId = str5;
        this.selectedLanguage = language;
    }

    public static /* synthetic */ FluidHomeComponentRequestParams copy$default(FluidHomeComponentRequestParams fluidHomeComponentRequestParams, List<String> list, String str, String str2, String str3, String str4, String str5, Language language, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = fluidHomeComponentRequestParams.externalExperiments;
        }
        if ((i11 & 2) != 0) {
            str = fluidHomeComponentRequestParams.deviceWidthInDP;
        }
        String str6 = str;
        if ((i11 & 4) != 0) {
            str2 = fluidHomeComponentRequestParams.countryCode;
        }
        String str7 = str2;
        if ((i11 & 8) != 0) {
            str3 = fluidHomeComponentRequestParams.latitude;
        }
        String str8 = str3;
        if ((i11 & 16) != 0) {
            str4 = fluidHomeComponentRequestParams.longitude;
        }
        String str9 = str4;
        if ((i11 & 32) != 0) {
            str5 = fluidHomeComponentRequestParams.areaId;
        }
        String str10 = str5;
        if ((i11 & 64) != 0) {
            language = fluidHomeComponentRequestParams.selectedLanguage;
        }
        return fluidHomeComponentRequestParams.copy(list, str6, str7, str8, str9, str10, language);
    }

    @NotNull
    public final List<String> component1() {
        return this.externalExperiments;
    }

    @NotNull
    public final String component2() {
        return this.deviceWidthInDP;
    }

    @NotNull
    public final String component3() {
        return this.countryCode;
    }

    @NotNull
    public final String component4() {
        return this.latitude;
    }

    @NotNull
    public final String component5() {
        return this.longitude;
    }

    @NotNull
    public final String component6() {
        return this.areaId;
    }

    @NotNull
    public final Language component7() {
        return this.selectedLanguage;
    }

    @NotNull
    public final FluidHomeComponentRequestParams copy(@NotNull List<String> list, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Language language) {
        Intrinsics.checkNotNullParameter(list, "externalExperiments");
        Intrinsics.checkNotNullParameter(str, "deviceWidthInDP");
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        Intrinsics.checkNotNullParameter(str3, "latitude");
        Intrinsics.checkNotNullParameter(str4, "longitude");
        Intrinsics.checkNotNullParameter(str5, "areaId");
        Language language2 = language;
        Intrinsics.checkNotNullParameter(language2, "selectedLanguage");
        return new FluidHomeComponentRequestParams(list, str, str2, str3, str4, str5, language2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FluidHomeComponentRequestParams)) {
            return false;
        }
        FluidHomeComponentRequestParams fluidHomeComponentRequestParams = (FluidHomeComponentRequestParams) obj;
        return Intrinsics.areEqual((Object) this.externalExperiments, (Object) fluidHomeComponentRequestParams.externalExperiments) && Intrinsics.areEqual((Object) this.deviceWidthInDP, (Object) fluidHomeComponentRequestParams.deviceWidthInDP) && Intrinsics.areEqual((Object) this.countryCode, (Object) fluidHomeComponentRequestParams.countryCode) && Intrinsics.areEqual((Object) this.latitude, (Object) fluidHomeComponentRequestParams.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) fluidHomeComponentRequestParams.longitude) && Intrinsics.areEqual((Object) this.areaId, (Object) fluidHomeComponentRequestParams.areaId) && this.selectedLanguage == fluidHomeComponentRequestParams.selectedLanguage;
    }

    @NotNull
    public final String getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getDeviceWidthInDP() {
        return this.deviceWidthInDP;
    }

    @NotNull
    public final List<String> getExternalExperiments() {
        return this.externalExperiments;
    }

    @NotNull
    public final String getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final Language getSelectedLanguage() {
        return this.selectedLanguage;
    }

    public int hashCode() {
        return (((((((((((this.externalExperiments.hashCode() * 31) + this.deviceWidthInDP.hashCode()) * 31) + this.countryCode.hashCode()) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.areaId.hashCode()) * 31) + this.selectedLanguage.hashCode();
    }

    @NotNull
    public String toString() {
        List<String> list = this.externalExperiments;
        String str = this.deviceWidthInDP;
        String str2 = this.countryCode;
        String str3 = this.latitude;
        String str4 = this.longitude;
        String str5 = this.areaId;
        Language language = this.selectedLanguage;
        return "FluidHomeComponentRequestParams(externalExperiments=" + list + ", deviceWidthInDP=" + str + ", countryCode=" + str2 + ", latitude=" + str3 + ", longitude=" + str4 + ", areaId=" + str5 + ", selectedLanguage=" + language + ")";
    }
}
