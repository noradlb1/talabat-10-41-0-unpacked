package com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassCategory;", "", "headline", "", "id", "type", "ui", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassUi;", "items", "", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassUi;Ljava/util/List;)V", "getHeadline", "()Ljava/lang/String;", "setHeadline", "(Ljava/lang/String;)V", "getId", "setId", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getType", "setType", "getUi", "()Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassUi;", "setUi", "(Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassUi;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlassCategory {
    @SerializedName("headline")
    @NotNull
    private String headline;
    @SerializedName("id")
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f61548id;
    @SerializedName("items")
    @Nullable
    private List<GlassItem> items;
    @SerializedName("type")
    @Nullable
    private String type;
    @SerializedName("ui")
    @Nullable

    /* renamed from: ui  reason: collision with root package name */
    private GlassUi f61549ui;

    public GlassCategory(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable GlassUi glassUi, @Nullable List<GlassItem> list) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(str2, "id");
        this.headline = str;
        this.f61548id = str2;
        this.type = str3;
        this.f61549ui = glassUi;
        this.items = list;
    }

    public static /* synthetic */ GlassCategory copy$default(GlassCategory glassCategory, String str, String str2, String str3, GlassUi glassUi, List<GlassItem> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = glassCategory.headline;
        }
        if ((i11 & 2) != 0) {
            str2 = glassCategory.f61548id;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = glassCategory.type;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            glassUi = glassCategory.f61549ui;
        }
        GlassUi glassUi2 = glassUi;
        if ((i11 & 16) != 0) {
            list = glassCategory.items;
        }
        return glassCategory.copy(str, str4, str5, glassUi2, list);
    }

    @NotNull
    public final String component1() {
        return this.headline;
    }

    @NotNull
    public final String component2() {
        return this.f61548id;
    }

    @Nullable
    public final String component3() {
        return this.type;
    }

    @Nullable
    public final GlassUi component4() {
        return this.f61549ui;
    }

    @Nullable
    public final List<GlassItem> component5() {
        return this.items;
    }

    @NotNull
    public final GlassCategory copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable GlassUi glassUi, @Nullable List<GlassItem> list) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(str2, "id");
        return new GlassCategory(str, str2, str3, glassUi, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassCategory)) {
            return false;
        }
        GlassCategory glassCategory = (GlassCategory) obj;
        return Intrinsics.areEqual((Object) this.headline, (Object) glassCategory.headline) && Intrinsics.areEqual((Object) this.f61548id, (Object) glassCategory.f61548id) && Intrinsics.areEqual((Object) this.type, (Object) glassCategory.type) && Intrinsics.areEqual((Object) this.f61549ui, (Object) glassCategory.f61549ui) && Intrinsics.areEqual((Object) this.items, (Object) glassCategory.items);
    }

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final String getId() {
        return this.f61548id;
    }

    @Nullable
    public final List<GlassItem> getItems() {
        return this.items;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final GlassUi getUi() {
        return this.f61549ui;
    }

    public int hashCode() {
        int hashCode = ((this.headline.hashCode() * 31) + this.f61548id.hashCode()) * 31;
        String str = this.type;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        GlassUi glassUi = this.f61549ui;
        int hashCode3 = (hashCode2 + (glassUi == null ? 0 : glassUi.hashCode())) * 31;
        List<GlassItem> list = this.items;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setHeadline(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headline = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f61548id = str;
    }

    public final void setItems(@Nullable List<GlassItem> list) {
        this.items = list;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setUi(@Nullable GlassUi glassUi) {
        this.f61549ui = glassUi;
    }

    @NotNull
    public String toString() {
        String str = this.headline;
        String str2 = this.f61548id;
        String str3 = this.type;
        GlassUi glassUi = this.f61549ui;
        List<GlassItem> list = this.items;
        return "GlassCategory(headline=" + str + ", id=" + str2 + ", type=" + str3 + ", ui=" + glassUi + ", items=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassCategory(String str, String str2, String str3, GlassUi glassUi, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : glassUi, (i11 & 16) != 0 ? null : list);
    }
}
