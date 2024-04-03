package com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassUi;", "", "designVersion", "", "layout", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesignVersion", "()Ljava/lang/String;", "setDesignVersion", "(Ljava/lang/String;)V", "getLayout", "setLayout", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlassUi {
    @SerializedName("design_version")
    @Nullable
    private String designVersion;
    @SerializedName("layout")
    @Nullable
    private String layout;

    public GlassUi() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public GlassUi(@Nullable String str, @Nullable String str2) {
        this.designVersion = str;
        this.layout = str2;
    }

    public static /* synthetic */ GlassUi copy$default(GlassUi glassUi, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = glassUi.designVersion;
        }
        if ((i11 & 2) != 0) {
            str2 = glassUi.layout;
        }
        return glassUi.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.designVersion;
    }

    @Nullable
    public final String component2() {
        return this.layout;
    }

    @NotNull
    public final GlassUi copy(@Nullable String str, @Nullable String str2) {
        return new GlassUi(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassUi)) {
            return false;
        }
        GlassUi glassUi = (GlassUi) obj;
        return Intrinsics.areEqual((Object) this.designVersion, (Object) glassUi.designVersion) && Intrinsics.areEqual((Object) this.layout, (Object) glassUi.layout);
    }

    @Nullable
    public final String getDesignVersion() {
        return this.designVersion;
    }

    @Nullable
    public final String getLayout() {
        return this.layout;
    }

    public int hashCode() {
        String str = this.designVersion;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.layout;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setDesignVersion(@Nullable String str) {
        this.designVersion = str;
    }

    public final void setLayout(@Nullable String str) {
        this.layout = str;
    }

    @NotNull
    public String toString() {
        String str = this.designVersion;
        String str2 = this.layout;
        return "GlassUi(designVersion=" + str + ", layout=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassUi(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
