package com.deliveryhero.persistence.cache;

import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\bJ%\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u0002H\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/persistence/cache/DiskCacheLegacy;", "", "get", "T", "key", "", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "put", "", "value", "ttl", "", "(Ljava/lang/String;Ljava/lang/Object;J)V", "remove", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "This cache uses a deprecated Gson serialization and should be replaced", replaceWith = @ReplaceWith(expression = "DiskCache", imports = {"com.deliveryhero.persistence.cache.DiskCache"}))
public interface DiskCacheLegacy {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void put$default(DiskCacheLegacy diskCacheLegacy, String str, Object obj, long j11, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 4) != 0) {
                    j11 = 0;
                }
                diskCacheLegacy.put(str, obj, j11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
        }
    }

    @Nullable
    <T> T get(@NotNull String str, @NotNull Class<T> cls);

    @Nullable
    <T> T get(@NotNull String str, @NotNull Type type);

    <T> void put(@NotNull String str, T t11, long j11);

    void remove(@NotNull String str);
}
