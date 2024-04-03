package com.deliveryhero.fluid.expression.utils;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0007"}, d2 = {"get", "", "ValueT", "", "Lcom/deliveryhero/fluid/expression/Expression;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExpressionUtilsKt {
    @NotNull
    public static final <ValueT> List<ValueT> get(@NotNull List<? extends Expression<ValueT>> list, @Nullable TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Expression orNull : list) {
            Object orNull2 = orNull.getOrNull(templateUiData);
            if (orNull2 != null) {
                arrayList.add(orNull2);
            }
        }
        return arrayList;
    }
}
