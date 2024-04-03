package com.deliveryhero.fluid.expression.reference.providers;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0016\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "ValueT", "", "get", "name", "", "(Ljava/lang/String;)Ljava/lang/Object;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ValueProvider<ValueT> {
    @NotNull
    ValueT get(@NotNull String str) throws Exception;
}
