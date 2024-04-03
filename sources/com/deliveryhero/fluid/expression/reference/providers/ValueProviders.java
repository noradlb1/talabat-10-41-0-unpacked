package com.deliveryhero.fluid.expression.reference.providers;

import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H¦\u0002¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "", "get", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "ValueT", "type", "Lkotlin/reflect/KClass;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ValueProviders {
    @NotNull
    <ValueT> ValueProvider<ValueT> get(@NotNull KClass<ValueT> kClass);
}
