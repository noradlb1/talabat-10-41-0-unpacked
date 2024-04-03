package com.deliveryhero.fluid.values.codecs;

import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LinearGradientOrientation;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.ScalableLogicalPixel;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.values.codecs.composite.HorizontalGridCellsCodec;
import com.deliveryhero.fluid.values.codecs.composite.NativeHorizontalGridCellsCodec;
import com.deliveryhero.fluid.values.codecs.composite.PagerCellsCodec;
import com.deliveryhero.fluid.values.codecs.composite.VerticalGridCellsCodec;
import com.deliveryhero.fluid.values.codecs.scalar.BooleanCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ColorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.FloatCodec;
import com.deliveryhero.fluid.values.codecs.scalar.HorizontalAlignmentCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ImageContentModeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ImageLocatorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.IntegerCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LineBreakModeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LinearGradientOrientationCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LocalImageLocatorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LogicalPixelCodec;
import com.deliveryhero.fluid.values.codecs.scalar.RepeatCountCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ScalableLogicalPixelCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ShapeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.SizeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.StringCodec;
import com.deliveryhero.fluid.values.codecs.scalar.TextAlignmentCodec;
import com.deliveryhero.fluid.values.codecs.scalar.TextStyleCodec;
import com.deliveryhero.fluid.values.codecs.scalar.VerticalAlignmentCodec;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.HorizontalGridCell;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.NativeHorizontalGridCell;
import com.deliveryhero.fluid.widgets.collections.grid.vertical.VerticalGridCell;
import com.deliveryhero.fluid.widgets.collections.pager.PagerCell;
import com.deliveryhero.fluid.widgets.containers.HorizontalAlignment;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import com.deliveryhero.fluid.widgets.image.ImageContentMode;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import com.deliveryhero.fluid.widgets.lottie.RepeatCount;
import com.deliveryhero.fluid.widgets.text.LineBreakMode;
import com.deliveryhero.fluid.widgets.text.TextAlignment;
import com.deliveryhero.fluid.widgets.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0000\u0010\u0005*\u00020\u0001\"\b\b\u0001\u0010\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u0002H\u0005H\u0002¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u0002H\u0005¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/ValueCodecs;", "", "()V", "get", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "DecodedT", "EncodedT", "value", "(Ljava/lang/Object;)Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "getScalar", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "(Ljava/lang/Object;)Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ValueCodecs {
    @NotNull
    public <DecodedT, EncodedT> ValueCodec<DecodedT, EncodedT> get(@NotNull DecodedT decodedt) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(decodedt, "value");
        if (decodedt instanceof Boolean) {
            return BooleanCodec.INSTANCE;
        }
        if (decodedt instanceof Color) {
            return ColorCodec.INSTANCE;
        }
        if (decodedt instanceof Float) {
            return FloatCodec.INSTANCE;
        }
        if (decodedt instanceof HorizontalAlignment) {
            return HorizontalAlignmentCodec.INSTANCE;
        }
        if (decodedt instanceof ImageContentMode) {
            return ImageContentModeCodec.INSTANCE;
        }
        if (decodedt instanceof ImageLocator.Local) {
            return LocalImageLocatorCodec.INSTANCE;
        }
        if (decodedt instanceof ImageLocator.Remote) {
            return ImageLocatorCodec.INSTANCE;
        }
        if (decodedt instanceof Integer) {
            return IntegerCodec.INSTANCE;
        }
        if (decodedt instanceof LinearGradientOrientation) {
            return LinearGradientOrientationCodec.INSTANCE;
        }
        if (decodedt instanceof LineBreakMode) {
            return LineBreakModeCodec.INSTANCE;
        }
        if (decodedt instanceof LogicalPixel) {
            return LogicalPixelCodec.INSTANCE;
        }
        if (decodedt instanceof ScalableLogicalPixel) {
            return ScalableLogicalPixelCodec.INSTANCE;
        }
        if (decodedt instanceof Shape) {
            return ShapeCodec.INSTANCE;
        }
        if (decodedt instanceof Size) {
            return SizeCodec.INSTANCE;
        }
        if (decodedt instanceof String) {
            return StringCodec.INSTANCE;
        }
        if (decodedt instanceof TextAlignment) {
            return TextAlignmentCodec.INSTANCE;
        }
        if (decodedt instanceof TextStyle) {
            return TextStyleCodec.INSTANCE;
        }
        if (decodedt instanceof VerticalAlignment) {
            return VerticalAlignmentCodec.INSTANCE;
        }
        if (decodedt instanceof NativeHorizontalGridCell) {
            return NativeHorizontalGridCellsCodec.INSTANCE;
        }
        if (decodedt instanceof PagerCell) {
            return PagerCellsCodec.INSTANCE;
        }
        if (decodedt instanceof HorizontalGridCell) {
            return HorizontalGridCellsCodec.INSTANCE;
        }
        if (decodedt instanceof VerticalGridCell) {
            return VerticalGridCellsCodec.INSTANCE;
        }
        if (decodedt instanceof RepeatCount) {
            return RepeatCountCodec.INSTANCE;
        }
        throw new IllegalArgumentException("Value type `" + Reflection.getOrCreateKotlinClass(decodedt.getClass()).getQualifiedName() + "` is unsupported");
    }

    @NotNull
    public final <DecodedT> ValueCodec.Scalar<DecodedT> getScalar(@NotNull DecodedT decodedt) throws Exception {
        Intrinsics.checkNotNullParameter(decodedt, "value");
        return (ValueCodec.Scalar) get(decodedt);
    }
}
