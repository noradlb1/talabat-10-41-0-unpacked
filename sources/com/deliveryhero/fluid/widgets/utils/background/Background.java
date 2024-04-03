package com.deliveryhero.fluid.widgets.utils.background;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LinearGradientOrientation;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.widgets.utils.WidgetTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 %2\u00020\u0001:\u0001%J8\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\b\u001a\u00060\u0005j\u0002`\u00062\n\u0010\t\u001a\u00060\u0005j\u0002`\u0006H\u0016J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H&JT\u0010\u0016\u001a\u00020\u000b2\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u001d\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u001e\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u001f\u001a\u00060\u0005j\u0002`\u0006H&J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010$\u001a\u00020\u000b*\u00060\u0018j\u0002`\u0019H\u0016¨\u0006&"}, d2 = {"Lcom/deliveryhero/fluid/widgets/utils/background/Background;", "", "isRounded", "", "cornerRadiusTopLeft", "", "Lcom/deliveryhero/fluid/values/Pixel;", "cornerRadiusTopRight", "cornerRadiusBottomRight", "cornerRadiusBottomLeft", "setBorder", "", "tags", "Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "width", "", "Lcom/deliveryhero/fluid/values/PixelInt;", "color", "Lcom/deliveryhero/fluid/values/Color;", "setColors", "colors", "", "setCornerRadius", "widget", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "shape", "Lcom/deliveryhero/fluid/values/Shape;", "topLeft", "topRight", "bottomRight", "bottomLeft", "setLinearGradientOrientation", "orientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "setShape", "clipToBackgroundOutline", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Background {
    @NotNull
    public static final Companion Companion = Companion.f30303a;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u000b\u001a\u00060\fj\u0002`\rJ\u0010\u0010\u000e\u001a\u00020\u0004*\u00060\u0006j\u0002`\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u0004*\u00060\u0006j\u0002`\u0007H\u0002¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/widgets/utils/background/Background$Companion;", "", "()V", "getOrInit", "Lcom/deliveryhero/fluid/widgets/utils/background/Background;", "widget", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "borderWidth", "", "Lcom/deliveryhero/fluid/values/PixelInt;", "getOrSetMultiColorBackground", "getOrSetSingleColorBackground", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f30303a = new Companion();

        private Companion() {
        }

        private final Background getOrSetMultiColorBackground(View view) {
            Drawable background = view.getBackground();
            if (background instanceof MultiColorBackground) {
                return (Background) background;
            }
            MultiColorBackground multiColorBackground = new MultiColorBackground();
            view.setBackground(multiColorBackground);
            return multiColorBackground;
        }

        private final Background getOrSetSingleColorBackground(View view) {
            Drawable background = view.getBackground();
            if (background instanceof SingleColorBackground) {
                return (Background) background;
            }
            SingleColorBackground singleColorBackground = new SingleColorBackground();
            view.setBackground(singleColorBackground);
            return singleColorBackground;
        }

        @NotNull
        public final Background getOrInit(@NotNull View view, @NotNull List<Color> list, int i11) {
            Intrinsics.checkNotNullParameter(view, "widget");
            Intrinsics.checkNotNullParameter(list, "backgroundColors");
            if (list.size() == 1 && i11 == 0) {
                return getOrSetSingleColorBackground(view);
            }
            return getOrSetMultiColorBackground(view);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clipToBackgroundOutline(@NotNull Background background, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "receiver");
            if (!view.getClipToOutline()) {
                view.setClipToOutline(true);
            }
        }

        public static boolean isRounded(@NotNull Background background, float f11, float f12, float f13, float f14) {
            if (!(f11 == 0.0f)) {
                if (!(f12 == 0.0f)) {
                    if (!(f13 == 0.0f)) {
                        if (!(f14 == 0.0f)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    void clipToBackgroundOutline(@NotNull View view);

    boolean isRounded(float f11, float f12, float f13, float f14);

    void setBorder(@NotNull WidgetTags widgetTags, int i11, @NotNull Color color);

    void setColors(@NotNull WidgetTags widgetTags, @NotNull List<Color> list);

    void setCornerRadius(@NotNull View view, @NotNull Shape shape, @NotNull WidgetTags widgetTags, float f11, float f12, float f13, float f14);

    void setLinearGradientOrientation(@NotNull LinearGradientOrientation linearGradientOrientation);

    void setShape(@NotNull Shape shape);
}
