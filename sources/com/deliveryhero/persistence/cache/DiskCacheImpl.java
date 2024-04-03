package com.deliveryhero.persistence.cache;

import com.deliveryhero.persistence.serializers.Serializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J+\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fJ9\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/persistence/cache/DiskCacheImpl;", "Lcom/deliveryhero/persistence/cache/DiskCache;", "serializer", "Lcom/deliveryhero/persistence/serializers/Serializer;", "localStorage", "Lcom/deliveryhero/persistence/cache/LocalStorage;", "(Lcom/deliveryhero/persistence/serializers/Serializer;Lcom/deliveryhero/persistence/cache/LocalStorage;)V", "get", "T", "key", "", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;)Ljava/lang/Object;", "put", "", "value", "ttl", "", "(Ljava/lang/String;Ljava/lang/Object;JLkotlinx/serialization/KSerializer;)V", "remove", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DiskCacheImpl implements DiskCache {
    @NotNull
    private final LocalStorage localStorage;
    @NotNull
    private final Serializer serializer;

    @Inject
    public DiskCacheImpl(@NotNull Serializer serializer2, @NotNull LocalStorage localStorage2) {
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        Intrinsics.checkNotNullParameter(localStorage2, "localStorage");
        this.serializer = serializer2;
        this.localStorage = localStorage2;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlinx.serialization.KSerializer<T>, java.lang.Object, kotlinx.serialization.KSerializer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T get(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlinx.serialization.KSerializer<T> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.deliveryhero.persistence.cache.LocalStorage r0 = r4.localStorage
            java.lang.String r0 = r0.getString(r5)
            r1 = 0
            if (r0 == 0) goto L_0x002f
            com.deliveryhero.persistence.serializers.Serializer r2 = r4.serializer
            com.deliveryhero.persistence.cache.CacheData$Companion r3 = com.deliveryhero.persistence.cache.CacheData.Companion
            kotlinx.serialization.KSerializer r6 = r3.serializer(r6)
            java.lang.Object r6 = r2.deserialize((java.lang.String) r0, r6)
            com.deliveryhero.persistence.cache.CacheData r6 = (com.deliveryhero.persistence.cache.CacheData) r6
            if (r6 == 0) goto L_0x0028
            boolean r0 = r6.isExpired()
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0030
            r4.remove(r5)
            goto L_0x0030
        L_0x002f:
            r6 = r1
        L_0x0030:
            if (r6 == 0) goto L_0x003d
            boolean r5 = r6.isExpired()
            if (r5 == 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            java.lang.Object r1 = r6.getData()
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.persistence.cache.DiskCacheImpl.get(java.lang.String, kotlinx.serialization.KSerializer):java.lang.Object");
    }

    public <T> void put(@NotNull String str, T t11, long j11, @NotNull KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        this.localStorage.putString(str, this.serializer.serialize(new CacheData(t11, j11), CacheData.Companion.serializer(kSerializer)));
    }

    public void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.localStorage.remove(str);
    }
}
