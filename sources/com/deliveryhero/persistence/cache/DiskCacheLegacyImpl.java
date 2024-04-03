package com.deliveryhero.persistence.cache;

import com.deliveryhero.persistence.serializers.SerializerInterface;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J+\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0016¢\u0006\u0002\u0010\rJ%\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u0002H\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/persistence/cache/DiskCacheLegacyImpl;", "Lcom/deliveryhero/persistence/cache/DiskCacheLegacy;", "localStorage", "Lcom/deliveryhero/persistence/cache/LocalStorage;", "serializer", "Lcom/deliveryhero/persistence/serializers/SerializerInterface;", "(Lcom/deliveryhero/persistence/cache/LocalStorage;Lcom/deliveryhero/persistence/serializers/SerializerInterface;)V", "get", "T", "key", "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "put", "", "value", "ttl", "", "(Ljava/lang/String;Ljava/lang/Object;J)V", "remove", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "This cache uses a deprecated Gson serialization and should be replaced", replaceWith = @ReplaceWith(expression = "DiskCacheImpl", imports = {"com.deliveryhero.persistence.cache.DiskCacheImpl"}))
public final class DiskCacheLegacyImpl implements DiskCacheLegacy {
    @NotNull
    private final LocalStorage localStorage;
    @NotNull
    private final SerializerInterface serializer;

    public DiskCacheLegacyImpl(@NotNull LocalStorage localStorage2, @NotNull SerializerInterface serializerInterface) {
        Intrinsics.checkNotNullParameter(localStorage2, "localStorage");
        Intrinsics.checkNotNullParameter(serializerInterface, "serializer");
        this.localStorage = localStorage2;
        this.serializer = serializerInterface;
    }

    @Nullable
    public <T> T get(@NotNull String str, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return get(str, (Type) cls);
    }

    public <T> void put(@NotNull String str, T t11, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.localStorage.putString(str, this.serializer.serialize(new CacheData(t11, j11)));
    }

    public void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.localStorage.remove(str);
    }

    @Nullable
    public <T> T get(@NotNull String str, @NotNull Type type) {
        CacheData cacheData;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        String string = this.localStorage.getString(str);
        if (string != null) {
            boolean z11 = true;
            cacheData = (CacheData) this.serializer.deSerialize(string, TypeToken.getParameterized(CacheData.class, type).getType());
            if (cacheData == null || !cacheData.isExpired()) {
                z11 = false;
            }
            if (z11) {
                remove(str);
            }
        } else {
            cacheData = null;
        }
        if (cacheData == null || cacheData.isExpired()) {
            return null;
        }
        return cacheData.getData();
    }
}
