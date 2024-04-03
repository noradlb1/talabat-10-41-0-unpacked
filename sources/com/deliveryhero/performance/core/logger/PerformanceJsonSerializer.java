package com.deliveryhero.performance.core.logger;

import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001H&¨\u0006\t"}, d2 = {"Lcom/deliveryhero/performance/core/logger/PerformanceJsonSerializer;", "", "deserialize", "jsonString", "", "klass", "Lkotlin/reflect/KClass;", "serialize", "any", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PerformanceJsonSerializer {
    @NotNull
    Object deserialize(@NotNull String str, @NotNull KClass<?> kClass);

    @NotNull
    String serialize(@NotNull Object obj);
}
