package com.deliveryhero.fluid.template.data;

import com.deliveryhero.fluid.expression.placeholder.PlaceholderValueDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006R)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/deliveryhero/fluid/template/data/DataDecoder;", "", "()V", "valueDecoders", "", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderValueDecoder;", "getValueDecoders", "()Ljava/util/Map;", "addValueDecoder", "", "key", "decoder", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DataDecoder {
    @NotNull
    private final Map<String, PlaceholderValueDecoder<Object, Object>> valueDecoders = new LinkedHashMap();

    public final void addValueDecoder(@NotNull String str, @NotNull PlaceholderValueDecoder<?, ?> placeholderValueDecoder) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(placeholderValueDecoder, "decoder");
        Map<String, PlaceholderValueDecoder<Object, Object>> map = this.valueDecoders;
        Pair<A, B> pair = TuplesKt.to(str, placeholderValueDecoder);
        map.put(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public final Map<String, PlaceholderValueDecoder<Object, Object>> getValueDecoders() {
        return this.valueDecoders;
    }
}
