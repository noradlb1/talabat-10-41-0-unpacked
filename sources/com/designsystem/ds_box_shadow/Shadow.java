package com.designsystem.ds_box_shadow;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B&\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\rJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\nJ4\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Lcom/designsystem/ds_box_shadow/Shadow;", "", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Lcom/designsystem/ds_box_shadow/ShadowOffset;", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "(JLcom/designsystem/ds_box_shadow/ShadowOffset;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlurRadius-D9Ej5fM", "()F", "F", "getColor-0d7_KjU", "()J", "J", "getOffset", "()Lcom/designsystem/ds_box_shadow/ShadowOffset;", "component1", "component1-0d7_KjU", "component2", "component3", "component3-D9Ej5fM", "copy", "copy-gMqxd7g", "(JLcom/designsystem/ds_box_shadow/ShadowOffset;F)Lcom/designsystem/ds_box_shadow/Shadow;", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Shadow {
    public static final int $stable = 0;
    private final float blurRadius;
    private final long color;
    @NotNull
    private final ShadowOffset offset;

    private Shadow(long j11, ShadowOffset shadowOffset, float f11) {
        this.color = j11;
        this.offset = shadowOffset;
        this.blurRadius = f11;
    }

    public /* synthetic */ Shadow(long j11, ShadowOffset shadowOffset, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, shadowOffset, f11);
    }

    /* renamed from: copy-gMqxd7g$default  reason: not valid java name */
    public static /* synthetic */ Shadow m8269copygMqxd7g$default(Shadow shadow, long j11, ShadowOffset shadowOffset, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = shadow.color;
        }
        if ((i11 & 2) != 0) {
            shadowOffset = shadow.offset;
        }
        if ((i11 & 4) != 0) {
            f11 = shadow.blurRadius;
        }
        return shadow.m8272copygMqxd7g(j11, shadowOffset, f11);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m8270component10d7_KjU() {
        return this.color;
    }

    @NotNull
    public final ShadowOffset component2() {
        return this.offset;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m8271component3D9Ej5fM() {
        return this.blurRadius;
    }

    @NotNull
    /* renamed from: copy-gMqxd7g  reason: not valid java name */
    public final Shadow m8272copygMqxd7g(long j11, @NotNull ShadowOffset shadowOffset, float f11) {
        Intrinsics.checkNotNullParameter(shadowOffset, "offset");
        return new Shadow(j11, shadowOffset, f11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        return Color.m2920equalsimpl0(this.color, shadow.color) && Intrinsics.areEqual((Object) this.offset, (Object) shadow.offset) && Dp.m5483equalsimpl0(this.blurRadius, shadow.blurRadius);
    }

    /* renamed from: getBlurRadius-D9Ej5fM  reason: not valid java name */
    public final float m8273getBlurRadiusD9Ej5fM() {
        return this.blurRadius;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m8274getColor0d7_KjU() {
        return this.color;
    }

    @NotNull
    public final ShadowOffset getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return (((Color.m2926hashCodeimpl(this.color) * 31) + this.offset.hashCode()) * 31) + Dp.m5484hashCodeimpl(this.blurRadius);
    }

    @NotNull
    public String toString() {
        return "Shadow(color=" + Color.m2927toStringimpl(this.color) + ", offset=" + this.offset + ", blurRadius=" + Dp.m5489toStringimpl(this.blurRadius) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Shadow(long j11, ShadowOffset shadowOffset, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? ColorKt.Color((long) CountryPickerScreenConstants.focusedBorderColor) : j11, (i11 & 2) != 0 ? new ShadowOffset(0.0f, 0.0f, 3, (DefaultConstructorMarker) null) : shadowOffset, (i11 & 4) != 0 ? Dp.m5478constructorimpl((float) 0) : f11, (DefaultConstructorMarker) null);
    }
}
