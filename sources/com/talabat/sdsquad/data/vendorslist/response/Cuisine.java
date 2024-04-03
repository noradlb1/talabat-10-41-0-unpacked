package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "", "id", "", "na", "", "sl", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNa", "()Ljava/lang/String;", "getSl", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Cuisine {
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f61311id;
    @SerializedName("na")
    @Nullable

    /* renamed from: na  reason: collision with root package name */
    private final String f61312na;
    @SerializedName("sl")
    @Nullable

    /* renamed from: sl  reason: collision with root package name */
    private final String f61313sl;

    public Cuisine(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.f61311id = num;
        this.f61312na = str;
        this.f61313sl = str2;
    }

    public static /* synthetic */ Cuisine copy$default(Cuisine cuisine, Integer num, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = cuisine.f61311id;
        }
        if ((i11 & 2) != 0) {
            str = cuisine.f61312na;
        }
        if ((i11 & 4) != 0) {
            str2 = cuisine.f61313sl;
        }
        return cuisine.copy(num, str, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.f61311id;
    }

    @Nullable
    public final String component2() {
        return this.f61312na;
    }

    @Nullable
    public final String component3() {
        return this.f61313sl;
    }

    @NotNull
    public final Cuisine copy(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        return new Cuisine(num, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cuisine)) {
            return false;
        }
        Cuisine cuisine = (Cuisine) obj;
        return Intrinsics.areEqual((Object) this.f61311id, (Object) cuisine.f61311id) && Intrinsics.areEqual((Object) this.f61312na, (Object) cuisine.f61312na) && Intrinsics.areEqual((Object) this.f61313sl, (Object) cuisine.f61313sl);
    }

    @Nullable
    public final Integer getId() {
        return this.f61311id;
    }

    @Nullable
    public final String getNa() {
        return this.f61312na;
    }

    @Nullable
    public final String getSl() {
        return this.f61313sl;
    }

    public int hashCode() {
        Integer num = this.f61311id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f61312na;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f61313sl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.f61311id;
        String str = this.f61312na;
        String str2 = this.f61313sl;
        return "Cuisine(id=" + num + ", na=" + str + ", sl=" + str2 + ")";
    }
}
