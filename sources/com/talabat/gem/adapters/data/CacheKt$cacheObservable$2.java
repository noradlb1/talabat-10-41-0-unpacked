package com.talabat.gem.adapters.data;

import com.talabat.gem.domain.entities.Location;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/gem/adapters/data/ObservedData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CacheKt$cacheObservable$2 extends Lambda implements Function0<ObservedData> {
    public static final CacheKt$cacheObservable$2 INSTANCE = new CacheKt$cacheObservable$2();

    public CacheKt$cacheObservable$2() {
        super(0);
    }

    @NotNull
    public final ObservedData invoke() {
        return new ObservedData((String) null, (Location) null, (String) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }
}
