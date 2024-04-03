package com.deliveryhero.fluid.expression.reference;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.reference.providers.ValueProviders;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J4\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0001\u0010\u000b*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/expression/reference/ReferenceBuilder;", "ValueT", "", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "encodedValue", "", "(Ljava/lang/String;)V", "getEncodedValue", "()Ljava/lang/String;", "build", "Lcom/deliveryhero/fluid/expression/Expression;", "DecodedT", "type", "Lkotlin/reflect/KClass;", "valueProviders", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class ReferenceBuilder<ValueT> implements ExpressionBuilder<ValueT> {
    @NotNull
    private final String encodedValue;

    public ReferenceBuilder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encodedValue");
        this.encodedValue = str;
    }

    @NotNull
    public final <DecodedT> Expression<DecodedT> build(@NotNull KClass<DecodedT> kClass, @NotNull ValueProviders valueProviders, @NotNull Logger logger) {
        ValueT valuet;
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(valueProviders, "valueProviders");
        Intrinsics.checkNotNullParameter(logger, "logger");
        try {
            valuet = valueProviders.get(kClass).get(getEncodedValue());
        } catch (Throwable th2) {
            LoggerKt.error(logger, th2, ErrorTypes.REFERENCE, MapsKt__MapsKt.mapOf(TuplesKt.to("reference", getEncodedValue()), TuplesKt.to("builder", this), TuplesKt.to("type", kClass), TuplesKt.to("value_providers", valueProviders)));
            valuet = null;
        }
        return new Reference(valuet);
    }

    @NotNull
    public String getEncodedValue() {
        return this.encodedValue;
    }
}
