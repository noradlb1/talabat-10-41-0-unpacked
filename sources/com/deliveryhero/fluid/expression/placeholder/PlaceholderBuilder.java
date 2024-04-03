package com.deliveryhero.fluid.expression.placeholder;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JJ\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0001\u0010\u000b*\u00020\u0002\"\b\b\u0002\u0010\f*\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderBuilder;", "ValueT", "", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "encodedValue", "", "(Ljava/lang/String;)V", "getEncodedValue", "()Ljava/lang/String;", "build", "Lcom/deliveryhero/fluid/expression/Expression;", "DecodedT", "EncodedT", "type", "Lkotlin/reflect/KClass;", "codec", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class PlaceholderBuilder<ValueT> implements ExpressionBuilder<ValueT> {
    @NotNull
    private final String encodedValue;

    public PlaceholderBuilder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encodedValue");
        this.encodedValue = str;
    }

    @NotNull
    public final <DecodedT, EncodedT> Expression<DecodedT> build(@NotNull KClass<DecodedT> kClass, @NotNull ValueCodec<DecodedT, EncodedT> valueCodec, @NotNull ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        args.getDataDecoder().addValueDecoder(getEncodedValue(), new PlaceholderValueDecoder(kClass, valueCodec, args));
        return new Placeholder(getEncodedValue(), kClass, args.getLogger());
    }

    @NotNull
    public String getEncodedValue() {
        return this.encodedValue;
    }
}
