package com.deliveryhero.fluid.expression;

import com.deliveryhero.fluid.template.data.TemplateUiData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J \u0010\u0003\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0007J&\u0010\u0003\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\nJ'\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/expression/Expression;", "ValueT", "", "get", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "default", "(Lcom/deliveryhero/fluid/template/data/TemplateUiData;Ljava/lang/Object;)Ljava/lang/Object;", "(Lcom/deliveryhero/fluid/template/data/TemplateUiData;Lcom/deliveryhero/fluid/expression/Expression;)Ljava/lang/Object;", "getOrNull", "(Lcom/deliveryhero/fluid/template/data/TemplateUiData;)Ljava/lang/Object;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Expression<ValueT> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static <ValueT> ValueT get(@NotNull Expression<ValueT> expression, @Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression2) throws NullPointerException {
            Intrinsics.checkNotNullParameter(expression2, "default");
            ValueT orNull = expression.getOrNull(templateUiData);
            if (orNull != null) {
                return orNull;
            }
            ValueT orNull2 = expression2.getOrNull(templateUiData);
            Intrinsics.checkNotNull(orNull2);
            return orNull2;
        }

        @Nullable
        public static <ValueT> ValueT getOrNull(@NotNull Expression<ValueT> expression, @Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression2) {
            Intrinsics.checkNotNullParameter(expression2, "default");
            ValueT orNull = expression.getOrNull(templateUiData);
            if (orNull == null) {
                return expression2.getOrNull(templateUiData);
            }
            return orNull;
        }

        @NotNull
        public static <ValueT> ValueT get(@NotNull Expression<ValueT> expression, @Nullable TemplateUiData templateUiData, @NotNull ValueT valuet) {
            Intrinsics.checkNotNullParameter(valuet, "default");
            ValueT orNull = expression.getOrNull(templateUiData);
            return orNull == null ? valuet : orNull;
        }
    }

    @NotNull
    ValueT get(@Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression) throws NullPointerException;

    @NotNull
    ValueT get(@Nullable TemplateUiData templateUiData, @NotNull ValueT valuet);

    @Nullable
    ValueT getOrNull(@Nullable TemplateUiData templateUiData);

    @Nullable
    ValueT getOrNull(@Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression);
}
