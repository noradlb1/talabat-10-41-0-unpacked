package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/SizeCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "Lcom/deliveryhero/fluid/values/Size;", "()V", "MATCH_PARENT_ID", "", "PERCENTAGE_SUFFIX", "", "WRAP_CONTENT_ID", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "encoded", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SizeCodec implements ValueCodec.Scalar<Size> {
    @NotNull
    public static final SizeCodec INSTANCE = new SizeCodec();
    @NotNull
    private static final String MATCH_PARENT_ID = "match_parent";
    private static final char PERCENTAGE_SUFFIX = '%';
    @NotNull
    private static final String WRAP_CONTENT_ID = "wrap_content";
    @NotNull
    private static final ValueType valueType = ValueType.SIZE;

    private SizeCodec() {
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public Size decode(@NotNull String str) {
        Size size;
        Intrinsics.checkNotNullParameter(str, "encoded");
        if (StringsKt__StringsJVMKt.equals(str, WRAP_CONTENT_ID, true)) {
            return Size.WrapContent.INSTANCE;
        }
        if (StringsKt__StringsJVMKt.equals(str, MATCH_PARENT_ID, true)) {
            return Size.MatchParent.INSTANCE;
        }
        Character lastOrNull = StringsKt___StringsKt.lastOrNull(str);
        if (lastOrNull != null && lastOrNull.charValue() == '%') {
            Character lastOrNull2 = StringsKt___StringsKt.lastOrNull(str);
            if (lastOrNull2 != null && lastOrNull2.charValue() == '%') {
                str = str.substring(0, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            size = new Size.Relative(Integer.parseInt(str));
        } else {
            size = new Size.Absolute(new LogicalPixel(Float.parseFloat(str)));
        }
        return size;
    }

    @NotNull
    public String encode(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "decoded");
        if (Intrinsics.areEqual((Object) size, (Object) Size.WrapContent.INSTANCE)) {
            return WRAP_CONTENT_ID;
        }
        if (Intrinsics.areEqual((Object) size, (Object) Size.MatchParent.INSTANCE)) {
            return MATCH_PARENT_ID;
        }
        if (size instanceof Size.Relative) {
            String valueOf = String.valueOf(((Size.Relative) size).getPercent());
            return valueOf + PERCENTAGE_SUFFIX;
        } else if (size instanceof Size.Absolute) {
            return String.valueOf(((Size.Absolute) size).getValue().getValue());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
