package com.talabat.feature.rating.domain.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "", "text", "", "id", "", "isSelected", "", "enableForRating", "", "(Ljava/lang/String;IZ[I)V", "getEnableForRating", "()[I", "getId", "()I", "()Z", "setSelected", "(Z)V", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingReasonsData {
    @NotNull
    private final int[] enableForRating;

    /* renamed from: id  reason: collision with root package name */
    private final int f58680id;
    private boolean isSelected;
    @NotNull
    private final String text;

    public RatingReasonsData(@NotNull String str, int i11, boolean z11, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(iArr, "enableForRating");
        this.text = str;
        this.f58680id = i11;
        this.isSelected = z11;
        this.enableForRating = iArr;
    }

    public static /* synthetic */ RatingReasonsData copy$default(RatingReasonsData ratingReasonsData, String str, int i11, boolean z11, int[] iArr, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = ratingReasonsData.text;
        }
        if ((i12 & 2) != 0) {
            i11 = ratingReasonsData.f58680id;
        }
        if ((i12 & 4) != 0) {
            z11 = ratingReasonsData.isSelected;
        }
        if ((i12 & 8) != 0) {
            iArr = ratingReasonsData.enableForRating;
        }
        return ratingReasonsData.copy(str, i11, z11, iArr);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.f58680id;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    @NotNull
    public final int[] component4() {
        return this.enableForRating;
    }

    @NotNull
    public final RatingReasonsData copy(@NotNull String str, int i11, boolean z11, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(iArr, "enableForRating");
        return new RatingReasonsData(str, i11, z11, iArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingReasonsData)) {
            return false;
        }
        RatingReasonsData ratingReasonsData = (RatingReasonsData) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) ratingReasonsData.text) && this.f58680id == ratingReasonsData.f58680id && this.isSelected == ratingReasonsData.isSelected && Intrinsics.areEqual((Object) this.enableForRating, (Object) ratingReasonsData.enableForRating);
    }

    @NotNull
    public final int[] getEnableForRating() {
        return this.enableForRating;
    }

    public final int getId() {
        return this.f58680id;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + this.f58680id) * 31;
        boolean z11 = this.isSelected;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + Arrays.hashCode(this.enableForRating);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    @NotNull
    public String toString() {
        String str = this.text;
        int i11 = this.f58680id;
        boolean z11 = this.isSelected;
        String arrays = Arrays.toString(this.enableForRating);
        return "RatingReasonsData(text=" + str + ", id=" + i11 + ", isSelected=" + z11 + ", enableForRating=" + arrays + ")";
    }
}
