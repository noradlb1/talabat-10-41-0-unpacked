package com.talabat.fluid.theme;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import com.deliveryhero.fluid.widgets.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/theme/MarshmallowValueProvider;", "Lcom/deliveryhero/fluid/values/providers/CoreValueProviders;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "color", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "Lcom/deliveryhero/fluid/values/Color;", "getColor", "()Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "localImage", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "getLocalImage", "logicalPixel", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "getLogicalPixel", "textStyle", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "getTextStyle", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarshmallowValueProvider extends CoreValueProviders {
    @NotNull
    private final ValueProvider<Color> color;
    @NotNull
    private final ValueProvider<ImageLocator.Local> localImage;
    @NotNull
    private final ValueProvider<LogicalPixel> logicalPixel;
    @NotNull
    private final ValueProvider<TextStyle> textStyle = new MarshmallowFontProvider(super.getTextStyle());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarshmallowValueProvider(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.color = new MarshmallowColorProvider(context, super.getColor());
        this.logicalPixel = new MarshmallowDimensionProvider(context, super.getLogicalPixel());
        this.localImage = new MarshmallowDrawableProvider(context, super.getLocalImage());
    }

    @NotNull
    public ValueProvider<Color> getColor() {
        return this.color;
    }

    @NotNull
    public ValueProvider<ImageLocator.Local> getLocalImage() {
        return this.localImage;
    }

    @NotNull
    public ValueProvider<LogicalPixel> getLogicalPixel() {
        return this.logicalPixel;
    }

    @NotNull
    public ValueProvider<TextStyle> getTextStyle() {
        return this.textStyle;
    }
}
