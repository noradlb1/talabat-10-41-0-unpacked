package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010\u000fJu\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u00012\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001e0\u000e¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lokio/FileMetadata;", "", "isRegularFile", "", "isDirectory", "symlinkTarget", "Lokio/Path;", "size", "", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "extras", "", "Lkotlin/reflect/KClass;", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getCreatedAtMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtras", "()Ljava/util/Map;", "()Z", "getLastAccessedAtMillis", "getLastModifiedAtMillis", "getSize", "getSymlinkTarget", "()Lokio/Path;", "copy", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "extra", "T", "type", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FileMetadata {
    @Nullable
    private final Long createdAtMillis;
    @NotNull
    private final Map<KClass<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    @Nullable
    private final Long lastAccessedAtMillis;
    @Nullable
    private final Long lastModifiedAtMillis;
    @Nullable
    private final Long size;
    @Nullable
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, (Path) null, (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 255, (DefaultConstructorMarker) null);
    }

    public FileMetadata(boolean z11, boolean z12, @Nullable Path path, @Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @Nullable Long l14, @NotNull Map<KClass<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extras");
        this.isRegularFile = z11;
        this.isDirectory = z12;
        this.symlinkTarget = path;
        this.size = l11;
        this.createdAtMillis = l12;
        this.lastModifiedAtMillis = l13;
        this.lastAccessedAtMillis = l14;
        this.extras = MapsKt__MapsKt.toMap(map);
    }

    public static /* synthetic */ FileMetadata copy$default(FileMetadata fileMetadata, boolean z11, boolean z12, Path path, Long l11, Long l12, Long l13, Long l14, Map map, int i11, Object obj) {
        FileMetadata fileMetadata2 = fileMetadata;
        int i12 = i11;
        return fileMetadata.copy((i12 & 1) != 0 ? fileMetadata2.isRegularFile : z11, (i12 & 2) != 0 ? fileMetadata2.isDirectory : z12, (i12 & 4) != 0 ? fileMetadata2.symlinkTarget : path, (i12 & 8) != 0 ? fileMetadata2.size : l11, (i12 & 16) != 0 ? fileMetadata2.createdAtMillis : l12, (i12 & 32) != 0 ? fileMetadata2.lastModifiedAtMillis : l13, (i12 & 64) != 0 ? fileMetadata2.lastAccessedAtMillis : l14, (i12 & 128) != 0 ? fileMetadata2.extras : map);
    }

    @NotNull
    public final FileMetadata copy(boolean z11, boolean z12, @Nullable Path path, @Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @Nullable Long l14, @NotNull Map<KClass<?>, ? extends Object> map) {
        Map<KClass<?>, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extras");
        return new FileMetadata(z11, z12, path, l11, l12, l13, l14, map2);
    }

    @Nullable
    public final <T> T extra(@NotNull KClass<? extends T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Object obj = this.extras.get(kClass);
        if (obj == null) {
            return null;
        }
        return KClasses.cast(kClass, obj);
    }

    @Nullable
    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    @NotNull
    public final Map<KClass<?>, Object> getExtras() {
        return this.extras;
    }

    @Nullable
    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    @Nullable
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        Long l11 = this.size;
        if (l11 != null) {
            arrayList.add(Intrinsics.stringPlus("byteCount=", l11));
        }
        Long l12 = this.createdAtMillis;
        if (l12 != null) {
            arrayList.add(Intrinsics.stringPlus("createdAt=", l12));
        }
        Long l13 = this.lastModifiedAtMillis;
        if (l13 != null) {
            arrayList.add(Intrinsics.stringPlus("lastModifiedAt=", l13));
        }
        Long l14 = this.lastAccessedAtMillis;
        if (l14 != null) {
            arrayList.add(Intrinsics.stringPlus("lastAccessedAt=", l14));
        }
        if (!this.extras.isEmpty()) {
            arrayList.add(Intrinsics.stringPlus("extras=", this.extras));
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "FileMetadata(", ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileMetadata(boolean r10, boolean r11, okio.Path r12, java.lang.Long r13, java.lang.Long r14, java.lang.Long r15, java.lang.Long r16, java.util.Map r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r11
        L_0x0010:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0017
            r3 = r4
            goto L_0x0018
        L_0x0017:
            r3 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r4
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r4
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r4
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r4 = r16
        L_0x0034:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003d
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            goto L_0x003f
        L_0x003d:
            r0 = r17
        L_0x003f:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r4
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileMetadata.<init>(boolean, boolean, okio.Path, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
