package com.talabat.fluid.homescreen.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/Configuration;", "", "navigationBarColor", "", "locationHintColor", "locationTitleColor", "locationArrowTintColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocationArrowTintColor", "()Ljava/lang/String;", "getLocationHintColor", "getLocationTitleColor", "getNavigationBarColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Configuration {
    @NotNull
    private final String locationArrowTintColor;
    @NotNull
    private final String locationHintColor;
    @NotNull
    private final String locationTitleColor;
    @NotNull
    private final String navigationBarColor;

    public Configuration(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "navigationBarColor");
        Intrinsics.checkNotNullParameter(str2, "locationHintColor");
        Intrinsics.checkNotNullParameter(str3, "locationTitleColor");
        Intrinsics.checkNotNullParameter(str4, "locationArrowTintColor");
        this.navigationBarColor = str;
        this.locationHintColor = str2;
        this.locationTitleColor = str3;
        this.locationArrowTintColor = str4;
    }

    public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = configuration.navigationBarColor;
        }
        if ((i11 & 2) != 0) {
            str2 = configuration.locationHintColor;
        }
        if ((i11 & 4) != 0) {
            str3 = configuration.locationTitleColor;
        }
        if ((i11 & 8) != 0) {
            str4 = configuration.locationArrowTintColor;
        }
        return configuration.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.navigationBarColor;
    }

    @NotNull
    public final String component2() {
        return this.locationHintColor;
    }

    @NotNull
    public final String component3() {
        return this.locationTitleColor;
    }

    @NotNull
    public final String component4() {
        return this.locationArrowTintColor;
    }

    @NotNull
    public final Configuration copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "navigationBarColor");
        Intrinsics.checkNotNullParameter(str2, "locationHintColor");
        Intrinsics.checkNotNullParameter(str3, "locationTitleColor");
        Intrinsics.checkNotNullParameter(str4, "locationArrowTintColor");
        return new Configuration(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return Intrinsics.areEqual((Object) this.navigationBarColor, (Object) configuration.navigationBarColor) && Intrinsics.areEqual((Object) this.locationHintColor, (Object) configuration.locationHintColor) && Intrinsics.areEqual((Object) this.locationTitleColor, (Object) configuration.locationTitleColor) && Intrinsics.areEqual((Object) this.locationArrowTintColor, (Object) configuration.locationArrowTintColor);
    }

    @NotNull
    public final String getLocationArrowTintColor() {
        return this.locationArrowTintColor;
    }

    @NotNull
    public final String getLocationHintColor() {
        return this.locationHintColor;
    }

    @NotNull
    public final String getLocationTitleColor() {
        return this.locationTitleColor;
    }

    @NotNull
    public final String getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public int hashCode() {
        return (((((this.navigationBarColor.hashCode() * 31) + this.locationHintColor.hashCode()) * 31) + this.locationTitleColor.hashCode()) * 31) + this.locationArrowTintColor.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.navigationBarColor;
        String str2 = this.locationHintColor;
        String str3 = this.locationTitleColor;
        String str4 = this.locationArrowTintColor;
        return "Configuration(navigationBarColor=" + str + ", locationHintColor=" + str2 + ", locationTitleColor=" + str3 + ", locationArrowTintColor=" + str4 + ")";
    }
}
