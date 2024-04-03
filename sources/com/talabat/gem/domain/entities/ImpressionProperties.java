package com.talabat.gem.domain.entities;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/gem/domain/entities/ImpressionProperties;", "", "position", "", "id", "name", "brand", "list", "category", "variant", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getCategory", "getId", "getList", "getName", "getPosition", "getVariant", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImpressionProperties {
    @NotNull
    private final String brand;
    @NotNull
    private final String category;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f60331id;
    @NotNull
    private final String list;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f60332name;
    @NotNull
    private final String position;
    @NotNull
    private final String variant;

    public ImpressionProperties(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "position");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str5, DefaultCardView.CARD_LIST);
        Intrinsics.checkNotNullParameter(str6, "category");
        Intrinsics.checkNotNullParameter(str7, "variant");
        this.position = str;
        this.f60331id = str2;
        this.f60332name = str3;
        this.brand = str4;
        this.list = str5;
        this.category = str6;
        this.variant = str7;
    }

    public static /* synthetic */ ImpressionProperties copy$default(ImpressionProperties impressionProperties, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = impressionProperties.position;
        }
        if ((i11 & 2) != 0) {
            str2 = impressionProperties.f60331id;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = impressionProperties.f60332name;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = impressionProperties.brand;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = impressionProperties.list;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = impressionProperties.category;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = impressionProperties.variant;
        }
        return impressionProperties.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.position;
    }

    @NotNull
    public final String component2() {
        return this.f60331id;
    }

    @NotNull
    public final String component3() {
        return this.f60332name;
    }

    @NotNull
    public final String component4() {
        return this.brand;
    }

    @NotNull
    public final String component5() {
        return this.list;
    }

    @NotNull
    public final String component6() {
        return this.category;
    }

    @NotNull
    public final String component7() {
        return this.variant;
    }

    @NotNull
    public final ImpressionProperties copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "position");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str5, DefaultCardView.CARD_LIST);
        Intrinsics.checkNotNullParameter(str6, "category");
        String str8 = str7;
        Intrinsics.checkNotNullParameter(str8, "variant");
        return new ImpressionProperties(str, str2, str3, str4, str5, str6, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImpressionProperties)) {
            return false;
        }
        ImpressionProperties impressionProperties = (ImpressionProperties) obj;
        return Intrinsics.areEqual((Object) this.position, (Object) impressionProperties.position) && Intrinsics.areEqual((Object) this.f60331id, (Object) impressionProperties.f60331id) && Intrinsics.areEqual((Object) this.f60332name, (Object) impressionProperties.f60332name) && Intrinsics.areEqual((Object) this.brand, (Object) impressionProperties.brand) && Intrinsics.areEqual((Object) this.list, (Object) impressionProperties.list) && Intrinsics.areEqual((Object) this.category, (Object) impressionProperties.category) && Intrinsics.areEqual((Object) this.variant, (Object) impressionProperties.variant);
    }

    @NotNull
    public final String getBrand() {
        return this.brand;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getId() {
        return this.f60331id;
    }

    @NotNull
    public final String getList() {
        return this.list;
    }

    @NotNull
    public final String getName() {
        return this.f60332name;
    }

    @NotNull
    public final String getPosition() {
        return this.position;
    }

    @NotNull
    public final String getVariant() {
        return this.variant;
    }

    public int hashCode() {
        return (((((((((((this.position.hashCode() * 31) + this.f60331id.hashCode()) * 31) + this.f60332name.hashCode()) * 31) + this.brand.hashCode()) * 31) + this.list.hashCode()) * 31) + this.category.hashCode()) * 31) + this.variant.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.position;
        String str2 = this.f60331id;
        String str3 = this.f60332name;
        String str4 = this.brand;
        String str5 = this.list;
        String str6 = this.category;
        String str7 = this.variant;
        return "ImpressionProperties(position=" + str + ", id=" + str2 + ", name=" + str3 + ", brand=" + str4 + ", list=" + str5 + ", category=" + str6 + ", variant=" + str7 + ")";
    }
}
