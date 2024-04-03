package com.checkout.frames.style.view;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B&\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000e\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\tJ\u0019\u0010\u0010\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\tJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J4\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lcom/checkout/frames/style/view/FlowRowViewStyle;", "", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "imagesContainerModifier", "Landroidx/compose/ui/Modifier;", "(FFLandroidx/compose/ui/Modifier;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisSpacing-D9Ej5fM", "()F", "F", "getImagesContainerModifier", "()Landroidx/compose/ui/Modifier;", "getMainAxisSpacing-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "copy", "copy-Md-fbLM", "(FFLandroidx/compose/ui/Modifier;)Lcom/checkout/frames/style/view/FlowRowViewStyle;", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FlowRowViewStyle {
    private final float crossAxisSpacing;
    @NotNull
    private final Modifier imagesContainerModifier;
    private final float mainAxisSpacing;

    private FlowRowViewStyle(float f11, float f12, Modifier modifier) {
        this.mainAxisSpacing = f11;
        this.crossAxisSpacing = f12;
        this.imagesContainerModifier = modifier;
    }

    public /* synthetic */ FlowRowViewStyle(float f11, float f12, Modifier modifier, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, modifier);
    }

    /* renamed from: copy-Md-fbLM$default  reason: not valid java name */
    public static /* synthetic */ FlowRowViewStyle m9268copyMdfbLM$default(FlowRowViewStyle flowRowViewStyle, float f11, float f12, Modifier modifier, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = flowRowViewStyle.mainAxisSpacing;
        }
        if ((i11 & 2) != 0) {
            f12 = flowRowViewStyle.crossAxisSpacing;
        }
        if ((i11 & 4) != 0) {
            modifier = flowRowViewStyle.imagesContainerModifier;
        }
        return flowRowViewStyle.m9271copyMdfbLM(f11, f12, modifier);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m9269component1D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m9270component2D9Ej5fM() {
        return this.crossAxisSpacing;
    }

    @NotNull
    public final Modifier component3() {
        return this.imagesContainerModifier;
    }

    @NotNull
    /* renamed from: copy-Md-fbLM  reason: not valid java name */
    public final FlowRowViewStyle m9271copyMdfbLM(float f11, float f12, @NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "imagesContainerModifier");
        return new FlowRowViewStyle(f11, f12, modifier, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowRowViewStyle)) {
            return false;
        }
        FlowRowViewStyle flowRowViewStyle = (FlowRowViewStyle) obj;
        return Dp.m5483equalsimpl0(this.mainAxisSpacing, flowRowViewStyle.mainAxisSpacing) && Dp.m5483equalsimpl0(this.crossAxisSpacing, flowRowViewStyle.crossAxisSpacing) && Intrinsics.areEqual((Object) this.imagesContainerModifier, (Object) flowRowViewStyle.imagesContainerModifier);
    }

    /* renamed from: getCrossAxisSpacing-D9Ej5fM  reason: not valid java name */
    public final float m9272getCrossAxisSpacingD9Ej5fM() {
        return this.crossAxisSpacing;
    }

    @NotNull
    public final Modifier getImagesContainerModifier() {
        return this.imagesContainerModifier;
    }

    /* renamed from: getMainAxisSpacing-D9Ej5fM  reason: not valid java name */
    public final float m9273getMainAxisSpacingD9Ej5fM() {
        return this.mainAxisSpacing;
    }

    public int hashCode() {
        return (((Dp.m5484hashCodeimpl(this.mainAxisSpacing) * 31) + Dp.m5484hashCodeimpl(this.crossAxisSpacing)) * 31) + this.imagesContainerModifier.hashCode();
    }

    @NotNull
    public String toString() {
        String r02 = Dp.m5489toStringimpl(this.mainAxisSpacing);
        String r12 = Dp.m5489toStringimpl(this.crossAxisSpacing);
        Modifier modifier = this.imagesContainerModifier;
        return "FlowRowViewStyle(mainAxisSpacing=" + r02 + ", crossAxisSpacing=" + r12 + ", imagesContainerModifier=" + modifier + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowRowViewStyle(float f11, float f12, Modifier modifier, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dp.m5478constructorimpl((float) 0) : f11, (i11 & 2) != 0 ? Dp.m5478constructorimpl((float) 0) : f12, (i11 & 4) != 0 ? Modifier.Companion : modifier, (DefaultConstructorMarker) null);
    }
}
