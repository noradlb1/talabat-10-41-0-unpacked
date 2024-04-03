package com.talabat.talabatcommon.views.darkstores.lookingGlass.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GHeadline;", "", "headline", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getHeadline", "()Ljava/lang/String;", "setHeadline", "(Ljava/lang/String;)V", "getId", "setId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GHeadline {
    @NotNull
    private String headline;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f11727id;

    public GHeadline(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(str2, "id");
        this.headline = str;
        this.f11727id = str2;
    }

    public static /* synthetic */ GHeadline copy$default(GHeadline gHeadline, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gHeadline.headline;
        }
        if ((i11 & 2) != 0) {
            str2 = gHeadline.f11727id;
        }
        return gHeadline.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.headline;
    }

    @NotNull
    public final String component2() {
        return this.f11727id;
    }

    @NotNull
    public final GHeadline copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(str2, "id");
        return new GHeadline(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GHeadline)) {
            return false;
        }
        GHeadline gHeadline = (GHeadline) obj;
        return Intrinsics.areEqual((Object) this.headline, (Object) gHeadline.headline) && Intrinsics.areEqual((Object) this.f11727id, (Object) gHeadline.f11727id);
    }

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final String getId() {
        return this.f11727id;
    }

    public int hashCode() {
        return (this.headline.hashCode() * 31) + this.f11727id.hashCode();
    }

    public final void setHeadline(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headline = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11727id = str;
    }

    @NotNull
    public String toString() {
        String str = this.headline;
        String str2 = this.f11727id;
        return "GHeadline(headline=" + str + ", id=" + str2 + ")";
    }
}
