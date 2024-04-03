package okio;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0002J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0002¢\u0006\u0002\b\"J\u0013\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0006\u0010&\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006/"}, d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", "parent", "()Lokio/Path;", "root", "getRoot", "segments", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", "other", "div", "child", "resolve", "equals", "", "hashCode", "normalized", "relativeTo", "normalize", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "toString", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Path implements Comparable<Path> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final String DIRECTORY_SEPARATOR;
    @NotNull
    private final ByteString bytes;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", "", "get", "Ljava/nio/file/Path;", "toPath", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return companion.get(str, z11);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path get(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path get(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path get(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return _PathKt.commonToPath(str, z11);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @IgnoreJRERequirement
        @JvmName(name = "get")
        public final Path get(@NotNull java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return companion.get(file, z11);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path get(@NotNull File file, boolean z11) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String file2 = file.toString();
            Intrinsics.checkNotNullExpressionValue(file2, "toString()");
            return get(file2, z11);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return companion.get(path, z11);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @IgnoreJRERequirement
        @JvmName(name = "get")
        public final Path get(@NotNull java.nio.file.Path path, boolean z11) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get(path.toString(), z11);
        }
    }

    static {
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "separator");
        DIRECTORY_SEPARATOR = str;
    }

    public Path(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        this.bytes = byteString;
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path get(@NotNull File file) {
        return Companion.get(file);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path get(@NotNull File file, boolean z11) {
        return Companion.get(file, z11);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path get(@NotNull String str) {
        return Companion.get(str);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path get(@NotNull String str, boolean z11) {
        return Companion.get(str, z11);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @IgnoreJRERequirement
    @JvmName(name = "get")
    public static final Path get(@NotNull java.nio.file.Path path) {
        return Companion.get(path);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @IgnoreJRERequirement
    @JvmName(name = "get")
    public static final Path get(@NotNull java.nio.file.Path path, boolean z11) {
        return Companion.get(path, z11);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return path.resolve(str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Path) && Intrinsics.areEqual((Object) ((Path) obj).getBytes$okio(), (Object) getBytes$okio());
    }

    @NotNull
    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    @Nullable
    public final Path getRoot() {
        int access$rootLength = _PathKt.rootLength(this);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, access$rootLength));
    }

    @NotNull
    public final List<String> getSegments() {
        ArrayList<ByteString> arrayList = new ArrayList<>();
        int access$rootLength = _PathKt.rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        if (access$rootLength < size) {
            int i11 = access$rootLength;
            while (true) {
                int i12 = access$rootLength + 1;
                if (getBytes$okio().getByte(access$rootLength) == ((byte) 47) || getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                    arrayList.add(getBytes$okio().substring(i11, access$rootLength));
                    i11 = i12;
                }
                if (i12 >= size) {
                    break;
                }
                access$rootLength = i12;
            }
            access$rootLength = i11;
        }
        if (access$rootLength < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(access$rootLength, getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (ByteString utf8 : arrayList) {
            arrayList2.add(utf8.utf8());
        }
        return arrayList2;
    }

    @NotNull
    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = _PathKt.rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        if (access$rootLength < size) {
            int i11 = access$rootLength;
            while (true) {
                int i12 = access$rootLength + 1;
                if (getBytes$okio().getByte(access$rootLength) == ((byte) 47) || getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                    arrayList.add(getBytes$okio().substring(i11, access$rootLength));
                    i11 = i12;
                }
                if (i12 >= size) {
                    break;
                }
                access$rootLength = i12;
            }
            access$rootLength = i11;
        }
        if (access$rootLength < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(access$rootLength, getBytes$okio().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        return _PathKt.rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return _PathKt.rootLength(this) == -1;
    }

    public final boolean isRoot() {
        return _PathKt.rootLength(this) == getBytes$okio().size();
    }

    @NotNull
    @JvmName(name = "name")
    public final String name() {
        return nameBytes().utf8();
    }

    @NotNull
    @JvmName(name = "nameBytes")
    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash = _PathKt.getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, (Object) null);
        }
        if (volumeLetter() == null || getBytes$okio().size() != 2) {
            return getBytes$okio();
        }
        return ByteString.EMPTY;
    }

    @NotNull
    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    @Nullable
    @JvmName(name = "parent")
    public final Path parent() {
        Path path;
        if (Intrinsics.areEqual((Object) getBytes$okio(), (Object) _PathKt.DOT) || Intrinsics.areEqual((Object) getBytes$okio(), (Object) _PathKt.SLASH) || Intrinsics.areEqual((Object) getBytes$okio(), (Object) _PathKt.BACKSLASH) || _PathKt.lastSegmentIsDotDot(this)) {
            return null;
        }
        int access$getIndexOfLastSlash = _PathKt.getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != 2 || volumeLetter() == null) {
            if (access$getIndexOfLastSlash == 1 && getBytes$okio().startsWith(_PathKt.BACKSLASH)) {
                return null;
            }
            if (access$getIndexOfLastSlash != -1 || volumeLetter() == null) {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(_PathKt.DOT);
                }
                if (access$getIndexOfLastSlash != 0) {
                    return new Path(ByteString.substring$default(getBytes$okio(), 0, access$getIndexOfLastSlash, 1, (Object) null));
                }
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, (Object) null));
            } else if (getBytes$okio().size() == 2) {
                return null;
            } else {
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, (Object) null));
            }
        } else if (getBytes$okio().size() == 3) {
            return null;
        } else {
            path = new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, (Object) null));
        }
        return path;
    }

    @NotNull
    public final Path relativeTo(@NotNull Path path) {
        boolean z11;
        Intrinsics.checkNotNullParameter(path, "other");
        if (Intrinsics.areEqual((Object) getRoot(), (Object) path.getRoot())) {
            List<ByteString> segmentsBytes = getSegmentsBytes();
            List<ByteString> segmentsBytes2 = path.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i11 = 0;
            while (i11 < min && Intrinsics.areEqual((Object) segmentsBytes.get(i11), (Object) segmentsBytes2.get(i11))) {
                i11++;
            }
            if (i11 == min && getBytes$okio().size() == path.getBytes$okio().size()) {
                return Companion.get$default(Companion, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i11, segmentsBytes2.size()).indexOf(_PathKt.DOT_DOT) == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Buffer buffer = new Buffer();
                ByteString access$getSlash = _PathKt.getSlash(path);
                if (access$getSlash == null && (access$getSlash = _PathKt.getSlash(this)) == null) {
                    access$getSlash = _PathKt.toSlash(DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                if (i11 < size) {
                    int i12 = i11;
                    do {
                        i12++;
                        buffer.write(_PathKt.DOT_DOT);
                        buffer.write(access$getSlash);
                    } while (i12 < size);
                }
                int size2 = segmentsBytes.size();
                if (i11 < size2) {
                    while (true) {
                        int i13 = i11 + 1;
                        buffer.write(segmentsBytes.get(i11));
                        buffer.write(access$getSlash);
                        if (i13 >= size2) {
                            break;
                        }
                        i11 = i13;
                    }
                }
                return _PathKt.toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path).toString());
    }

    @NotNull
    @JvmName(name = "resolve")
    public final Path resolve(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "child");
        return _PathKt.commonResolve(this, path, false);
    }

    @NotNull
    public final File toFile() {
        return new File(toString());
    }

    @NotNull
    @IgnoreJRERequirement
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path a11 = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(a11, "get(toString())");
        return a11;
    }

    @NotNull
    public String toString() {
        return getBytes$okio().utf8();
    }

    @Nullable
    @JvmName(name = "volumeLetter")
    public final Character volumeLetter() {
        boolean z11;
        boolean z12 = false;
        if (ByteString.indexOf$default(getBytes$okio(), _PathKt.SLASH, 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c11 = (char) getBytes$okio().getByte(0);
        if ('a' > c11 || c11 > 'z') {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            if ('A' <= c11 && c11 <= 'Z') {
                z12 = true;
            }
            if (!z12) {
                return null;
            }
        }
        return Character.valueOf(c11);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return path.resolve(byteString, z11);
    }

    public int compareTo(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "other");
        return getBytes$okio().compareTo(path.getBytes$okio());
    }

    @NotNull
    public final Path resolve(@NotNull Path path, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "child");
        return _PathKt.commonResolve(this, path, z11);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return path.resolve(path2, z11);
    }

    @NotNull
    @JvmName(name = "resolve")
    public final Path resolve(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(str), false), false);
    }

    @NotNull
    @JvmName(name = "resolve")
    public final Path resolve(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(byteString), false), false);
    }

    @NotNull
    public final Path resolve(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(str), false), z11);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString byteString, boolean z11) {
        Intrinsics.checkNotNullParameter(byteString, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(byteString), false), z11);
    }
}
