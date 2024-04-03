package com.talabat.offering.domain.entities;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/offering/domain/entities/Background;", "", "color", "", "image", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getColor", "()Ljava/lang/String;", "getImage", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/offering/domain/entities/Background;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Background {
    @ModelMapping({"color"})
    @Nullable
    private final String color;
    @ModelMapping({"image"})
    @Nullable
    private final String image;
    @ModelMapping({"type"})
    @Nullable
    private final Integer type;

    public Background() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public Background(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.color = str;
        this.image = str2;
        this.type = num;
    }

    public static /* synthetic */ Background copy$default(Background background, String str, String str2, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = background.color;
        }
        if ((i11 & 2) != 0) {
            str2 = background.image;
        }
        if ((i11 & 4) != 0) {
            num = background.type;
        }
        return background.copy(str, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.color;
    }

    @Nullable
    public final String component2() {
        return this.image;
    }

    @Nullable
    public final Integer component3() {
        return this.type;
    }

    @NotNull
    public final Background copy(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        return new Background(str, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Background)) {
            return false;
        }
        Background background = (Background) obj;
        return Intrinsics.areEqual((Object) this.color, (Object) background.color) && Intrinsics.areEqual((Object) this.image, (Object) background.image) && Intrinsics.areEqual((Object) this.type, (Object) background.type);
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.color;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.type;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.color;
        String str2 = this.image;
        Integer num = this.type;
        return "Background(color=" + str + ", image=" + str2 + ", type=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Background(String str, String str2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : num);
    }
}
