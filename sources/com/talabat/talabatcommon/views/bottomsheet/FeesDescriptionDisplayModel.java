package com.talabat.talabatcommon.views.bottomsheet;

import androidx.annotation.DrawableRes;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;", "Ljava/io/Serializable;", "imageId", "", "title", "", "description", "url", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getImageId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesDescriptionDisplayModel implements Serializable {
    @NotNull
    private final String description;
    @Nullable
    private final Integer imageId;
    @NotNull
    private final String title;
    @Nullable
    private final String url;

    public FeesDescriptionDisplayModel(@Nullable @DrawableRes Integer num, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        this.imageId = num;
        this.title = str;
        this.description = str2;
        this.url = str3;
    }

    public static /* synthetic */ FeesDescriptionDisplayModel copy$default(FeesDescriptionDisplayModel feesDescriptionDisplayModel, Integer num, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = feesDescriptionDisplayModel.imageId;
        }
        if ((i11 & 2) != 0) {
            str = feesDescriptionDisplayModel.title;
        }
        if ((i11 & 4) != 0) {
            str2 = feesDescriptionDisplayModel.description;
        }
        if ((i11 & 8) != 0) {
            str3 = feesDescriptionDisplayModel.url;
        }
        return feesDescriptionDisplayModel.copy(num, str, str2, str3);
    }

    @Nullable
    public final Integer component1() {
        return this.imageId;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @NotNull
    public final FeesDescriptionDisplayModel copy(@Nullable @DrawableRes Integer num, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        return new FeesDescriptionDisplayModel(num, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeesDescriptionDisplayModel)) {
            return false;
        }
        FeesDescriptionDisplayModel feesDescriptionDisplayModel = (FeesDescriptionDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.imageId, (Object) feesDescriptionDisplayModel.imageId) && Intrinsics.areEqual((Object) this.title, (Object) feesDescriptionDisplayModel.title) && Intrinsics.areEqual((Object) this.description, (Object) feesDescriptionDisplayModel.description) && Intrinsics.areEqual((Object) this.url, (Object) feesDescriptionDisplayModel.url);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getImageId() {
        return this.imageId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Integer num = this.imageId;
        int i11 = 0;
        int hashCode = (((((num == null ? 0 : num.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.url;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.imageId;
        String str = this.title;
        String str2 = this.description;
        String str3 = this.url;
        return "FeesDescriptionDisplayModel(imageId=" + num + ", title=" + str + ", description=" + str2 + ", url=" + str3 + ")";
    }
}
