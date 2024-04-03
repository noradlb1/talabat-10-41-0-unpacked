package com.deliveryhero.chatui.view.util;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aI\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00030\u0007¨\u0006\u000b"}, d2 = {"replaceAll", "", "K", "V", "map", "", "transform", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MapperUtilKt {
    public static final <K, V> void replaceAll(@NotNull Map<K, V> map, @NotNull Function1<? super V, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (Map.Entry next : map.entrySet()) {
            try {
                map.put(next.getKey(), function1.invoke(next.getValue()));
            } catch (IllegalStateException e11) {
                throw new ConcurrentModificationException(e11);
            }
        }
    }
}
