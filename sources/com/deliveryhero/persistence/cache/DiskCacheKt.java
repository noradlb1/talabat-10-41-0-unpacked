package com.deliveryhero.persistence.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;

@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a4\u0010\u0006\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u0002H\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"get", "T", "Lcom/deliveryhero/persistence/cache/DiskCache;", "key", "", "(Lcom/deliveryhero/persistence/cache/DiskCache;Ljava/lang/String;)Ljava/lang/Object;", "put", "", "value", "ttl", "", "(Lcom/deliveryhero/persistence/cache/DiskCache;Ljava/lang/String;Ljava/lang/Object;J)V", "pandora-persistence_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DiskCacheKt {
    public static final /* synthetic */ <T> T get(DiskCache diskCache, String str) {
        Intrinsics.checkNotNullParameter(diskCache, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(6, "T?");
        return diskCache.get(str, SerializersKt.serializer((KType) null));
    }

    public static final /* synthetic */ <T> void put(DiskCache diskCache, String str, T t11, long j11) {
        Intrinsics.checkNotNullParameter(diskCache, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(6, "T");
        diskCache.put(str, t11, j11, SerializersKt.serializer((KType) null));
    }

    public static /* synthetic */ void put$default(DiskCache diskCache, String str, Object obj, long j11, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            j11 = 0;
        }
        Intrinsics.checkNotNullParameter(diskCache, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(6, "T");
        diskCache.put(str, obj, j11, SerializersKt.serializer((KType) null));
    }
}
