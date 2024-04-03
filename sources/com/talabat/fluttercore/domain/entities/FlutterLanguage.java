package com.talabat.fluttercore.domain.entities;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/FlutterLanguage;", "", "name", "", "code", "isRTL", "", "bundledFileCode", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBundledFileCode", "()Ljava/lang/String;", "getCode", "()Z", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterLanguage {
    @NotNull
    private final String bundledFileCode;
    @NotNull
    private final String code;
    private final boolean isRTL;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f59772name;

    public FlutterLanguage(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str3, "bundledFileCode");
        this.f59772name = str;
        this.code = str2;
        this.isRTL = z11;
        this.bundledFileCode = str3;
    }

    public static /* synthetic */ FlutterLanguage copy$default(FlutterLanguage flutterLanguage, String str, String str2, boolean z11, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterLanguage.f59772name;
        }
        if ((i11 & 2) != 0) {
            str2 = flutterLanguage.code;
        }
        if ((i11 & 4) != 0) {
            z11 = flutterLanguage.isRTL;
        }
        if ((i11 & 8) != 0) {
            str3 = flutterLanguage.bundledFileCode;
        }
        return flutterLanguage.copy(str, str2, z11, str3);
    }

    @NotNull
    public final String component1() {
        return this.f59772name;
    }

    @NotNull
    public final String component2() {
        return this.code;
    }

    public final boolean component3() {
        return this.isRTL;
    }

    @NotNull
    public final String component4() {
        return this.bundledFileCode;
    }

    @NotNull
    public final FlutterLanguage copy(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str3, "bundledFileCode");
        return new FlutterLanguage(str, str2, z11, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterLanguage)) {
            return false;
        }
        FlutterLanguage flutterLanguage = (FlutterLanguage) obj;
        return Intrinsics.areEqual((Object) this.f59772name, (Object) flutterLanguage.f59772name) && Intrinsics.areEqual((Object) this.code, (Object) flutterLanguage.code) && this.isRTL == flutterLanguage.isRTL && Intrinsics.areEqual((Object) this.bundledFileCode, (Object) flutterLanguage.bundledFileCode);
    }

    @NotNull
    public final String getBundledFileCode() {
        return this.bundledFileCode;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getName() {
        return this.f59772name;
    }

    public int hashCode() {
        int hashCode = ((this.f59772name.hashCode() * 31) + this.code.hashCode()) * 31;
        boolean z11 = this.isRTL;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.bundledFileCode.hashCode();
    }

    public final boolean isRTL() {
        return this.isRTL;
    }

    @NotNull
    public String toString() {
        String str = this.f59772name;
        String str2 = this.code;
        boolean z11 = this.isRTL;
        String str3 = this.bundledFileCode;
        return "FlutterLanguage(name=" + str + ", code=" + str2 + ", isRTL=" + z11 + ", bundledFileCode=" + str3 + ")";
    }
}
