package com.deliveryhero.fluid.widgets.utils.background;

import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LinearGradientOrientation;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.widgets.utils.WidgetTags;
import com.deliveryhero.fluid.widgets.utils.background.Background;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016JT\u0010\u0010\u001a\u00020\u00052\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001b\u001a\u00060\u0017j\u0002`\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\f\u0010 \u001a\u00020\u0005*\u00020\u0001H\u0002J\f\u0010!\u001a\u00020\u0005*\u00020\u0001H\u0002JD\u0010\"\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001b\u001a\u00060\u0017j\u0002`\u0018H\u0002¨\u0006#"}, d2 = {"Lcom/deliveryhero/fluid/widgets/utils/background/SingleColorBackground;", "Landroid/graphics/drawable/ShapeDrawable;", "Lcom/deliveryhero/fluid/widgets/utils/background/Background;", "()V", "setBorder", "", "tags", "Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "width", "", "Lcom/deliveryhero/fluid/values/PixelInt;", "color", "Lcom/deliveryhero/fluid/values/Color;", "setColors", "colors", "", "setCornerRadius", "widget", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "shape", "Lcom/deliveryhero/fluid/values/Shape;", "topLeft", "", "Lcom/deliveryhero/fluid/values/Pixel;", "topRight", "bottomRight", "bottomLeft", "setLinearGradientOrientation", "orientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "setShape", "useOvalShape", "useRectShape", "useRoundRectShape", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleColorBackground extends ShapeDrawable implements Background {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shape.values().length];
            iArr[Shape.RECT.ordinal()] = 1;
            iArr[Shape.RECT_ROUNDED.ordinal()] = 2;
            iArr[Shape.OVAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void useOvalShape(ShapeDrawable shapeDrawable) {
        if (!(shapeDrawable.getShape() instanceof OvalShape)) {
            shapeDrawable.setShape(new OvalShape());
        }
    }

    private final void useRectShape(ShapeDrawable shapeDrawable) {
        if (!(shapeDrawable.getShape() instanceof RectShape)) {
            shapeDrawable.setShape(new RectShape());
        }
    }

    private final void useRoundRectShape(ShapeDrawable shapeDrawable, WidgetTags widgetTags, float f11, float f12, float f13, float f14) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (widgetTags.getBackgroundCornerRadiusTopLeft() == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (widgetTags.getBackgroundCornerRadiusTopRight() == f12) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (widgetTags.getBackgroundCornerRadiusBottomRight() == f13) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (widgetTags.getBackgroundCornerRadiusBottomLeft() == f14) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        return;
                    }
                }
            }
        }
        shapeDrawable.setShape(new RoundRectShape(new float[]{f11, f11, f12, f12, f13, f13, f14, f14}, (RectF) null, (float[]) null));
        widgetTags.setBackgroundCornerRadiusTopLeft(f11);
        widgetTags.setBackgroundCornerRadiusTopRight(f12);
        widgetTags.setBackgroundCornerRadiusBottomRight(f13);
        widgetTags.setBackgroundCornerRadiusBottomLeft(f14);
    }

    public void clipToBackgroundOutline(@NotNull View view) {
        Background.DefaultImpls.clipToBackgroundOutline(this, view);
    }

    public boolean isRounded(float f11, float f12, float f13, float f14) {
        return Background.DefaultImpls.isRounded(this, f11, f12, f13, f14);
    }

    public void setBorder(@NotNull WidgetTags widgetTags, int i11, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(widgetTags, "tags");
        Intrinsics.checkNotNullParameter(color, "color");
    }

    public void setColors(@NotNull WidgetTags widgetTags, @NotNull List<Color> list) {
        Intrinsics.checkNotNullParameter(widgetTags, "tags");
        Intrinsics.checkNotNullParameter(list, "colors");
        int argb = ((Color) CollectionsKt___CollectionsKt.single(list)).getArgb();
        if (getPaint().getColor() != argb) {
            getPaint().setColor(argb);
            widgetTags.setBackgroundColors(list);
        }
    }

    public void setCornerRadius(@NotNull View view, @NotNull Shape shape, @NotNull WidgetTags widgetTags, float f11, float f12, float f13, float f14) {
        Intrinsics.checkNotNullParameter(view, "widget");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(widgetTags, "tags");
        boolean isRounded = isRounded(f11, f12, f13, f14);
        int i11 = WhenMappings.$EnumSwitchMapping$0[shape.ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (isRounded) {
                useRoundRectShape(this, widgetTags, f11, f12, f13, f14);
            } else {
                useRectShape(this);
            }
        } else if (i11 == 3) {
            useOvalShape(this);
        }
        if (isRounded || shape == Shape.OVAL) {
            clipToBackgroundOutline(view);
        }
    }

    public void setLinearGradientOrientation(@NotNull LinearGradientOrientation linearGradientOrientation) {
        Intrinsics.checkNotNullParameter(linearGradientOrientation, "orientation");
    }

    public void setShape(@NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
    }
}
