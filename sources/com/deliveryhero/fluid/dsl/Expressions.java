package com.deliveryhero.fluid.dsl;

import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.literal.LiteralBuilder;
import com.deliveryhero.fluid.expression.placeholder.PlaceholderBuilder;
import com.deliveryhero.fluid.expression.reference.ReferenceBuilder;
import com.deliveryhero.fluid.values.codecs.ValueCodecs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/dsl/Expressions;", "", "()V", "literal", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "ValueT", "value", "valueCodecs", "Lcom/deliveryhero/fluid/values/codecs/ValueCodecs;", "(Ljava/lang/Object;Lcom/deliveryhero/fluid/values/codecs/ValueCodecs;)Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "placeholder", "name", "", "reference", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Expressions {
    @NotNull
    public static final Expressions INSTANCE = new Expressions();

    private Expressions() {
    }

    @NotNull
    public final <ValueT> ExpressionBuilder<ValueT> literal(@NotNull ValueT valuet, @NotNull ValueCodecs valueCodecs) {
        Intrinsics.checkNotNullParameter(valuet, "value");
        Intrinsics.checkNotNullParameter(valueCodecs, "valueCodecs");
        return new LiteralBuilder((String) valueCodecs.getScalar(valuet).encode(valuet));
    }

    @NotNull
    public final <ValueT> ExpressionBuilder<ValueT> placeholder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new PlaceholderBuilder(str);
    }

    @NotNull
    public final <ValueT> ExpressionBuilder<ValueT> reference(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ReferenceBuilder(str);
    }
}
