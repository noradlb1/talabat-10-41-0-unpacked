package com.deliveryhero.persistence.cache;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\bJ;\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u0002H\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/persistence/cache/DiskCache;", "", "get", "T", "key", "", "serializer", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;)Ljava/lang/Object;", "put", "", "value", "ttl", "", "(Ljava/lang/String;Ljava/lang/Object;JLkotlinx/serialization/KSerializer;)V", "remove", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DiskCache {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void put$default(DiskCache diskCache, String str, Object obj, long j11, KSerializer kSerializer, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 4) != 0) {
                    j11 = 0;
                }
                diskCache.put(str, obj, j11, kSerializer);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
        }
    }

    @Nullable
    <T> T get(@NotNull String str, @NotNull KSerializer<T> kSerializer);

    <T> void put(@NotNull String str, T t11, long j11, @NotNull KSerializer<T> kSerializer);

    void remove(@NotNull String str);
}
