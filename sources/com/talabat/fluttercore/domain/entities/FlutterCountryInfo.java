package com.talabat.fluttercore.domain.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/FlutterCountryInfo;", "", "id", "", "curs", "", "dno", "code", "(ILjava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getCurs", "getDno", "()I", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCountryInfo {
    @Nullable
    private final String code;
    @NotNull
    private final String curs;
    private final int dno;

    /* renamed from: id  reason: collision with root package name */
    private final int f59770id;

    public FlutterCountryInfo(int i11, @NotNull String str, int i12, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "curs");
        this.f59770id = i11;
        this.curs = str;
        this.dno = i12;
        this.code = str2;
    }

    public static /* synthetic */ FlutterCountryInfo copy$default(FlutterCountryInfo flutterCountryInfo, int i11, String str, int i12, String str2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = flutterCountryInfo.f59770id;
        }
        if ((i13 & 2) != 0) {
            str = flutterCountryInfo.curs;
        }
        if ((i13 & 4) != 0) {
            i12 = flutterCountryInfo.dno;
        }
        if ((i13 & 8) != 0) {
            str2 = flutterCountryInfo.code;
        }
        return flutterCountryInfo.copy(i11, str, i12, str2);
    }

    public final int component1() {
        return this.f59770id;
    }

    @NotNull
    public final String component2() {
        return this.curs;
    }

    public final int component3() {
        return this.dno;
    }

    @Nullable
    public final String component4() {
        return this.code;
    }

    @NotNull
    public final FlutterCountryInfo copy(int i11, @NotNull String str, int i12, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "curs");
        return new FlutterCountryInfo(i11, str, i12, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterCountryInfo)) {
            return false;
        }
        FlutterCountryInfo flutterCountryInfo = (FlutterCountryInfo) obj;
        return this.f59770id == flutterCountryInfo.f59770id && Intrinsics.areEqual((Object) this.curs, (Object) flutterCountryInfo.curs) && this.dno == flutterCountryInfo.dno && Intrinsics.areEqual((Object) this.code, (Object) flutterCountryInfo.code);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCurs() {
        return this.curs;
    }

    public final int getDno() {
        return this.dno;
    }

    public final int getId() {
        return this.f59770id;
    }

    public int hashCode() {
        int hashCode = ((((this.f59770id * 31) + this.curs.hashCode()) * 31) + this.dno) * 31;
        String str = this.code;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.f59770id;
        String str = this.curs;
        int i12 = this.dno;
        String str2 = this.code;
        return "FlutterCountryInfo(id=" + i11 + ", curs=" + str + ", dno=" + i12 + ", code=" + str2 + ")";
    }
}
