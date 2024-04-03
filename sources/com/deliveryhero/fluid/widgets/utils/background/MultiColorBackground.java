package com.deliveryhero.fluid.widgets.utils.background;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.deliveryhero.fluid.utils.AndroidVersion;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LinearGradientOrientation;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.widgets.utils.WidgetTags;
import com.deliveryhero.fluid.widgets.utils.background.Background;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016JT\u0010\u0010\u001a\u00020\u00052\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001b\u001a\u00060\u0017j\u0002`\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006 "}, d2 = {"Lcom/deliveryhero/fluid/widgets/utils/background/MultiColorBackground;", "Landroid/graphics/drawable/GradientDrawable;", "Lcom/deliveryhero/fluid/widgets/utils/background/Background;", "()V", "setBorder", "", "tags", "Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "width", "", "Lcom/deliveryhero/fluid/values/PixelInt;", "color", "Lcom/deliveryhero/fluid/values/Color;", "setColors", "colors", "", "setCornerRadius", "widget", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "shape", "Lcom/deliveryhero/fluid/values/Shape;", "topLeft", "", "Lcom/deliveryhero/fluid/values/Pixel;", "topRight", "bottomRight", "bottomLeft", "setLinearGradientOrientation", "orientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "setShape", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiColorBackground extends GradientDrawable implements Background {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Shape.values().length];
            iArr[Shape.RECT.ordinal()] = 1;
            iArr[Shape.RECT_ROUNDED.ordinal()] = 2;
            iArr[Shape.OVAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LinearGradientOrientation.values().length];
            iArr2[LinearGradientOrientation.LEFT_RIGHT.ordinal()] = 1;
            iArr2[LinearGradientOrientation.BOTTOM_LEFT_TOP_RIGHT.ordinal()] = 2;
            iArr2[LinearGradientOrientation.BOTTOM_TOP.ordinal()] = 3;
            iArr2[LinearGradientOrientation.BOTTOM_RIGHT_TOP_LEFT.ordinal()] = 4;
            iArr2[LinearGradientOrientation.RIGHT_LEFT.ordinal()] = 5;
            iArr2[LinearGradientOrientation.TOP_RIGHT_BOTTOM_LEFT.ordinal()] = 6;
            iArr2[LinearGradientOrientation.TOP_BOTTOM.ordinal()] = 7;
            iArr2[LinearGradientOrientation.TOP_LEFT_BOTTOM_RIGHT.ordinal()] = 8;
            $EnumSwitchMapping$1 = iArr2;
        }
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
        if (widgetTags.getBorderWidth() != i11 || !Intrinsics.areEqual((Object) widgetTags.getBorderColor(), (Object) color)) {
            setStroke(i11, color.getArgb());
            widgetTags.setBorderWidth(i11);
            widgetTags.setBorderColor(color);
        }
    }

    public void setColors(@NotNull WidgetTags widgetTags, @NotNull List<Color> list) {
        Intrinsics.checkNotNullParameter(widgetTags, "tags");
        Intrinsics.checkNotNullParameter(list, "colors");
        if (!Intrinsics.areEqual((Object) widgetTags.getBackgroundColors(), (Object) list)) {
            if (list.size() == 1) {
                setColor(((Color) CollectionsKt___CollectionsKt.single(list)).getArgb());
            } else {
                int size = list.size();
                int[] iArr = new int[size];
                for (int i11 = 0; i11 < size; i11++) {
                    iArr[i11] = list.get(i11).getArgb();
                }
                setColors(iArr);
            }
            widgetTags.setBackgroundColors(list);
        }
    }

    public void setCornerRadius(@NotNull View view, @NotNull Shape shape, @NotNull WidgetTags widgetTags, float f11, float f12, float f13, float f14) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(view, "widget");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(widgetTags, "tags");
        if (widgetTags.getBackgroundCornerRadiusTopLeft() == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (widgetTags.getBackgroundCornerRadiusTopRight() == f12) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (z15) {
                if (widgetTags.getBackgroundCornerRadiusBottomRight() == f13) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (widgetTags.getBackgroundCornerRadiusBottomLeft() == f14) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return;
                    }
                }
            }
        }
        if (f11 == f12) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            if (f11 == f13) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                if (f11 == f14) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (z14) {
                    setCornerRadius(f11);
                    if (isRounded(f11, f12, f13, f14) || shape == Shape.OVAL) {
                        clipToBackgroundOutline(view);
                    }
                    widgetTags.setBackgroundCornerRadiusTopLeft(f11);
                    widgetTags.setBackgroundCornerRadiusTopRight(f12);
                    widgetTags.setBackgroundCornerRadiusBottomRight(f13);
                    widgetTags.setBackgroundCornerRadiusBottomLeft(f14);
                }
            }
        }
        setCornerRadii(new float[]{f11, f11, f12, f12, f13, f13, f14, f14});
        clipToBackgroundOutline(view);
        widgetTags.setBackgroundCornerRadiusTopLeft(f11);
        widgetTags.setBackgroundCornerRadiusTopRight(f12);
        widgetTags.setBackgroundCornerRadiusBottomRight(f13);
        widgetTags.setBackgroundCornerRadiusBottomLeft(f14);
    }

    public void setLinearGradientOrientation(@NotNull LinearGradientOrientation linearGradientOrientation) {
        GradientDrawable.Orientation orientation;
        Intrinsics.checkNotNullParameter(linearGradientOrientation, "orientation");
        switch (WhenMappings.$EnumSwitchMapping$1[linearGradientOrientation.ordinal()]) {
            case 1:
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            case 2:
                orientation = GradientDrawable.Orientation.BL_TR;
                break;
            case 3:
                orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                break;
            case 4:
                orientation = GradientDrawable.Orientation.BR_TL;
                break;
            case 5:
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                break;
            case 6:
                orientation = GradientDrawable.Orientation.TR_BL;
                break;
            case 7:
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            case 8:
                orientation = GradientDrawable.Orientation.TL_BR;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (getOrientation() != orientation) {
            setOrientation(orientation);
        }
    }

    public void setShape(@NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        int i11 = WhenMappings.$EnumSwitchMapping$0[shape.ordinal()];
        int i12 = 0;
        if (!(i11 == 1 || i11 == 2)) {
            if (i11 == 3) {
                i12 = 1;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (!AndroidVersion.INSTANCE.isAtLeastNougat() || getShape() != i12) {
            setShape(i12);
        }
    }
}
