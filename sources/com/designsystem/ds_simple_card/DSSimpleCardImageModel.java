package com.designsystem.ds_simple_card;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\tJ6\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lcom/designsystem/ds_simple_card/DSSimpleCardImageModel;", "", "imageUrl", "", "placeholderImageUrl", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "(Ljava/lang/String;Ljava/lang/String;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCornerRadius-D9Ej5fM", "()F", "F", "getImageUrl", "()Ljava/lang/String;", "getPlaceholderImageUrl", "component1", "component2", "component3", "component3-D9Ej5fM", "copy", "copy-wH6b6FI", "(Ljava/lang/String;Ljava/lang/String;F)Lcom/designsystem/ds_simple_card/DSSimpleCardImageModel;", "equals", "", "other", "hashCode", "", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSimpleCardImageModel {
    public static final int $stable = 0;
    private final float cornerRadius;
    @NotNull
    private final String imageUrl;
    @Nullable
    private final String placeholderImageUrl;

    private DSSimpleCardImageModel(String str, String str2, float f11) {
        this.imageUrl = str;
        this.placeholderImageUrl = str2;
        this.cornerRadius = f11;
    }

    public /* synthetic */ DSSimpleCardImageModel(String str, String str2, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f11);
    }

    /* renamed from: copy-wH6b6FI$default  reason: not valid java name */
    public static /* synthetic */ DSSimpleCardImageModel m8567copywH6b6FI$default(DSSimpleCardImageModel dSSimpleCardImageModel, String str, String str2, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dSSimpleCardImageModel.imageUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = dSSimpleCardImageModel.placeholderImageUrl;
        }
        if ((i11 & 4) != 0) {
            f11 = dSSimpleCardImageModel.cornerRadius;
        }
        return dSSimpleCardImageModel.m8569copywH6b6FI(str, str2, f11);
    }

    @NotNull
    public final String component1() {
        return this.imageUrl;
    }

    @Nullable
    public final String component2() {
        return this.placeholderImageUrl;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m8568component3D9Ej5fM() {
        return this.cornerRadius;
    }

    @NotNull
    /* renamed from: copy-wH6b6FI  reason: not valid java name */
    public final DSSimpleCardImageModel m8569copywH6b6FI(@NotNull String str, @Nullable String str2, float f11) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        return new DSSimpleCardImageModel(str, str2, f11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSSimpleCardImageModel)) {
            return false;
        }
        DSSimpleCardImageModel dSSimpleCardImageModel = (DSSimpleCardImageModel) obj;
        return Intrinsics.areEqual((Object) this.imageUrl, (Object) dSSimpleCardImageModel.imageUrl) && Intrinsics.areEqual((Object) this.placeholderImageUrl, (Object) dSSimpleCardImageModel.placeholderImageUrl) && Dp.m5483equalsimpl0(this.cornerRadius, dSSimpleCardImageModel.cornerRadius);
    }

    /* renamed from: getCornerRadius-D9Ej5fM  reason: not valid java name */
    public final float m8570getCornerRadiusD9Ej5fM() {
        return this.cornerRadius;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getPlaceholderImageUrl() {
        return this.placeholderImageUrl;
    }

    public int hashCode() {
        int hashCode = this.imageUrl.hashCode() * 31;
        String str = this.placeholderImageUrl;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Dp.m5484hashCodeimpl(this.cornerRadius);
    }

    @NotNull
    public String toString() {
        return "DSSimpleCardImageModel(imageUrl=" + this.imageUrl + ", placeholderImageUrl=" + this.placeholderImageUrl + ", cornerRadius=" + Dp.m5489toStringimpl(this.cornerRadius) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSimpleCardImageModel(String str, String str2, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? DSSimpleCardKt.access$getDefaultRadius$p() : f11, (DefaultConstructorMarker) null);
    }
}
