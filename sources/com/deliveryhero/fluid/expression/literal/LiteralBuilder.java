package com.deliveryhero.fluid.expression.literal;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J<\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0001\u0010\u000b*\u00020\u0002\"\b\b\u0002\u0010\f*\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/expression/literal/LiteralBuilder;", "ValueT", "", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "encodedValue", "", "(Ljava/lang/String;)V", "getEncodedValue", "()Ljava/lang/String;", "build", "Lcom/deliveryhero/fluid/expression/Expression;", "DecodedT", "EncodedT", "codec", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class LiteralBuilder<ValueT> implements ExpressionBuilder<ValueT> {
    @NotNull
    private final String encodedValue;

    public LiteralBuilder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encodedValue");
        this.encodedValue = str;
    }

    @NotNull
    public final <DecodedT, EncodedT> Expression<DecodedT> build(@NotNull ValueCodec<DecodedT, EncodedT> valueCodec, @NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(logger, "logger");
        if (!(valueCodec instanceof ValueCodec.Scalar)) {
            ErrorTypes errorTypes = ErrorTypes.LITERAL;
            LoggerKt.error(logger, new IllegalArgumentException(errorTypes.getMessage()), errorTypes, MapsKt__MapsKt.mapOf(TuplesKt.to("literal", getEncodedValue()), TuplesKt.to("builder", this), TuplesKt.to("codec", valueCodec)));
            return new Literal(null);
        }
        try {
            return new Literal(((ValueCodec.Scalar) valueCodec).decode(getEncodedValue()));
        } catch (Throwable th2) {
            LoggerKt.error(logger, th2, ErrorTypes.OBJECT_INITIALIZE, MapsKt__MapsKt.mapOf(TuplesKt.to("literal", getEncodedValue()), TuplesKt.to("type_name", Reflection.getOrCreateKotlinClass(Literal.class).getSimpleName()), TuplesKt.to("builder", this), TuplesKt.to("codec", valueCodec)));
            return new Literal(null);
        }
    }

    @NotNull
    public String getEncodedValue() {
        return this.encodedValue;
    }
}
