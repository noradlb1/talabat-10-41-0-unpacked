package com.deliveryhero.fluid.expression.placeholder;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderUtilsKt;
import com.deliveryhero.fluid.values.codecs.CellCodec;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B/\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003JE\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0017\u001a\u00020\u0002J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderValueDecoder;", "DecodedT", "", "EncodedT", "type", "Lkotlin/reflect/KClass;", "codec", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "(Lkotlin/reflect/KClass;Lcom/deliveryhero/fluid/values/codecs/ValueCodec;Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;)V", "getArgs", "()Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "getCodec", "()Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "getType", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "copy", "decode", "Lcom/deliveryhero/fluid/expression/Expression;", "value", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlaceholderValueDecoder<DecodedT, EncodedT> {
    @NotNull
    private final ExpressionBuilder.Args args;
    @NotNull
    private final ValueCodec<DecodedT, EncodedT> codec;
    @NotNull
    private final KClass<DecodedT> type;

    public PlaceholderValueDecoder(@NotNull KClass<DecodedT> kClass, @NotNull ValueCodec<DecodedT, EncodedT> valueCodec, @NotNull ExpressionBuilder.Args args2) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(args2, StepData.ARGS);
        this.type = kClass;
        this.codec = valueCodec;
        this.args = args2;
    }

    public static /* synthetic */ PlaceholderValueDecoder copy$default(PlaceholderValueDecoder placeholderValueDecoder, KClass<DecodedT> kClass, ValueCodec<DecodedT, EncodedT> valueCodec, ExpressionBuilder.Args args2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            kClass = placeholderValueDecoder.type;
        }
        if ((i11 & 2) != 0) {
            valueCodec = placeholderValueDecoder.codec;
        }
        if ((i11 & 4) != 0) {
            args2 = placeholderValueDecoder.args;
        }
        return placeholderValueDecoder.copy(kClass, valueCodec, args2);
    }

    @NotNull
    public final KClass<DecodedT> component1() {
        return this.type;
    }

    @NotNull
    public final ValueCodec<DecodedT, EncodedT> component2() {
        return this.codec;
    }

    @NotNull
    public final ExpressionBuilder.Args component3() {
        return this.args;
    }

    @NotNull
    public final PlaceholderValueDecoder<DecodedT, EncodedT> copy(@NotNull KClass<DecodedT> kClass, @NotNull ValueCodec<DecodedT, EncodedT> valueCodec, @NotNull ExpressionBuilder.Args args2) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(args2, StepData.ARGS);
        return new PlaceholderValueDecoder<>(kClass, valueCodec, args2);
    }

    @NotNull
    public final Expression<DecodedT> decode(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        ValueCodec<DecodedT, EncodedT> valueCodec = this.codec;
        if (valueCodec instanceof ValueCodec.Scalar) {
            return ExpressionBuilderUtilsKt.build(ExpressionBuilderSerializer.Companion.decode(obj.toString()), this.type, this.codec, this.args);
        }
        if (valueCodec instanceof CellCodec) {
            return new Literal(valueCodec.decode(obj));
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceholderValueDecoder)) {
            return false;
        }
        PlaceholderValueDecoder placeholderValueDecoder = (PlaceholderValueDecoder) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) placeholderValueDecoder.type) && Intrinsics.areEqual((Object) this.codec, (Object) placeholderValueDecoder.codec) && Intrinsics.areEqual((Object) this.args, (Object) placeholderValueDecoder.args);
    }

    @NotNull
    public final ExpressionBuilder.Args getArgs() {
        return this.args;
    }

    @NotNull
    public final ValueCodec<DecodedT, EncodedT> getCodec() {
        return this.codec;
    }

    @NotNull
    public final KClass<DecodedT> getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.codec.hashCode()) * 31) + this.args.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlaceholderValueDecoder(type=" + this.type + ", codec=" + this.codec + ", args=" + this.args + ')';
    }
}
