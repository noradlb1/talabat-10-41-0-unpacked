package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/TagResponse;", "", "id", "", "imageUrl", "name", "color", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getId", "getImageUrl", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TagResponse {
    @NotNull
    private final String color;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56192id;
    @NotNull
    private final String imageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56193name;

    public TagResponse(@NotNull @Json(name = "id") String str, @NotNull @Json(name = "image_url") String str2, @NotNull @Json(name = "name") String str3, @NotNull @Json(name = "bg_color") String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "color");
        this.f56192id = str;
        this.imageUrl = str2;
        this.f56193name = str3;
        this.color = str4;
    }

    public static /* synthetic */ TagResponse copy$default(TagResponse tagResponse, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tagResponse.f56192id;
        }
        if ((i11 & 2) != 0) {
            str2 = tagResponse.imageUrl;
        }
        if ((i11 & 4) != 0) {
            str3 = tagResponse.f56193name;
        }
        if ((i11 & 8) != 0) {
            str4 = tagResponse.color;
        }
        return tagResponse.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.f56192id;
    }

    @NotNull
    public final String component2() {
        return this.imageUrl;
    }

    @NotNull
    public final String component3() {
        return this.f56193name;
    }

    @NotNull
    public final String component4() {
        return this.color;
    }

    @NotNull
    public final TagResponse copy(@NotNull @Json(name = "id") String str, @NotNull @Json(name = "image_url") String str2, @NotNull @Json(name = "name") String str3, @NotNull @Json(name = "bg_color") String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "color");
        return new TagResponse(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagResponse)) {
            return false;
        }
        TagResponse tagResponse = (TagResponse) obj;
        return Intrinsics.areEqual((Object) this.f56192id, (Object) tagResponse.f56192id) && Intrinsics.areEqual((Object) this.imageUrl, (Object) tagResponse.imageUrl) && Intrinsics.areEqual((Object) this.f56193name, (Object) tagResponse.f56193name) && Intrinsics.areEqual((Object) this.color, (Object) tagResponse.color);
    }

    @NotNull
    public final String getColor() {
        return this.color;
    }

    @NotNull
    public final String getId() {
        return this.f56192id;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f56193name;
    }

    public int hashCode() {
        return (((((this.f56192id.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + this.f56193name.hashCode()) * 31) + this.color.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f56192id;
        String str2 = this.imageUrl;
        String str3 = this.f56193name;
        String str4 = this.color;
        return "TagResponse(id=" + str + ", imageUrl=" + str2 + ", name=" + str3 + ", color=" + str4 + ")";
    }
}
