package com.talabat.fluid.homescreen.presentation.viewmodel;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.literal.Literal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/fluid/expression/Expression;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModel$retrieveCellsIfExists$1 extends Lambda implements Function1<Expression<Object>, Object> {
    public static final FluidHomeScreenViewModel$retrieveCellsIfExists$1 INSTANCE = new FluidHomeScreenViewModel$retrieveCellsIfExists$1();

    public FluidHomeScreenViewModel$retrieveCellsIfExists$1() {
        super(1);
    }

    @Nullable
    public final Object invoke(@NotNull Expression<Object> expression) {
        Intrinsics.checkNotNullParameter(expression, "it");
        Literal literal = expression instanceof Literal ? (Literal) expression : null;
        if (literal != null) {
            return literal.getValue();
        }
        return null;
    }
}
