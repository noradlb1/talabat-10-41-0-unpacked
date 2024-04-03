package okio.internal;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\b\u001a\u0012\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\b¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, d2 = {"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _PathKt {
    @NotNull
    private static final ByteString ANY_SLASH;
    /* access modifiers changed from: private */
    @NotNull
    public static final ByteString BACKSLASH;
    /* access modifiers changed from: private */
    @NotNull
    public static final ByteString DOT;
    /* access modifiers changed from: private */
    @NotNull
    public static final ByteString DOT_DOT;
    /* access modifiers changed from: private */
    @NotNull
    public static final ByteString SLASH;

    static {
        ByteString.Companion companion = ByteString.Companion;
        SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        DOT = companion.encodeUtf8(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        DOT_DOT = companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        return path.getBytes$okio().compareTo(path2.getBytes$okio());
    }

    public static final boolean commonEquals(@NotNull Path path, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (!(obj instanceof Path) || !Intrinsics.areEqual((Object) ((Path) obj).getBytes$okio(), (Object) path.getBytes$okio())) {
            return false;
        }
        return true;
    }

    public static final int commonHashCode(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (rootLength(path) != -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRelative(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (rootLength(path) == -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (rootLength(path) == path.getBytes$okio().size()) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String commonName(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.nameBytes().utf8();
    }

    @NotNull
    public static final ByteString commonNameBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int access$getIndexOfLastSlash = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(path.getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, (Object) null);
        }
        if (path.volumeLetter() == null || path.getBytes$okio().size() != 2) {
            return path.getBytes$okio();
        }
        return ByteString.EMPTY;
    }

    @NotNull
    public static final Path commonNormalized(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Path.Companion.get(path.toString(), true);
    }

    @Nullable
    public static final Path commonParent(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (Intrinsics.areEqual((Object) path.getBytes$okio(), (Object) DOT) || Intrinsics.areEqual((Object) path.getBytes$okio(), (Object) SLASH) || Intrinsics.areEqual((Object) path.getBytes$okio(), (Object) BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int access$getIndexOfLastSlash = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash != 2 || path.volumeLetter() == null) {
            if (access$getIndexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
                return null;
            }
            if (access$getIndexOfLastSlash != -1 || path.volumeLetter() == null) {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(DOT);
                }
                if (access$getIndexOfLastSlash == 0) {
                    return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, (Object) null));
                }
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, access$getIndexOfLastSlash, 1, (Object) null));
            } else if (path.getBytes$okio().size() == 2) {
                return null;
            } else {
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, (Object) null));
            }
        } else if (path.getBytes$okio().size() == 3) {
            return null;
        } else {
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, (Object) null));
        }
    }

    @NotNull
    public static final Path commonRelativeTo(@NotNull Path path, @NotNull Path path2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        if (Intrinsics.areEqual((Object) path.getRoot(), (Object) path2.getRoot())) {
            List<ByteString> segmentsBytes = path.getSegmentsBytes();
            List<ByteString> segmentsBytes2 = path2.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i11 = 0;
            while (i11 < min && Intrinsics.areEqual((Object) segmentsBytes.get(i11), (Object) segmentsBytes2.get(i11))) {
                i11++;
            }
            if (i11 == min && path.getBytes$okio().size() == path2.getBytes$okio().size()) {
                return Path.Companion.get$default(Path.Companion, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i11, segmentsBytes2.size()).indexOf(DOT_DOT) == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Buffer buffer = new Buffer();
                ByteString access$getSlash = getSlash(path2);
                if (access$getSlash == null && (access$getSlash = getSlash(path)) == null) {
                    access$getSlash = toSlash(Path.DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                if (i11 < size) {
                    int i12 = i11;
                    do {
                        i12++;
                        buffer.write(DOT_DOT);
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
                return toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + path2).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + path2).toString());
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(str), false), z11);
    }

    @Nullable
    public static final Path commonRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(path.getBytes$okio().substring(0, access$rootLength));
    }

    @NotNull
    public static final List<String> commonSegments(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList<ByteString> arrayList = new ArrayList<>();
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = path.getBytes$okio().size();
        if (access$rootLength < size) {
            int i11 = access$rootLength;
            while (true) {
                int i12 = access$rootLength + 1;
                if (path.getBytes$okio().getByte(access$rootLength) == ((byte) 47) || path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                    arrayList.add(path.getBytes$okio().substring(i11, access$rootLength));
                    i11 = i12;
                }
                if (i12 >= size) {
                    break;
                }
                access$rootLength = i12;
            }
            access$rootLength = i11;
        }
        if (access$rootLength < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(access$rootLength, path.getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (ByteString utf8 : arrayList) {
            arrayList2.add(utf8.utf8());
        }
        return arrayList2;
    }

    @NotNull
    public static final List<ByteString> commonSegmentsBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = path.getBytes$okio().size();
        if (access$rootLength < size) {
            int i11 = access$rootLength;
            while (true) {
                int i12 = access$rootLength + 1;
                if (path.getBytes$okio().getByte(access$rootLength) == ((byte) 47) || path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                    arrayList.add(path.getBytes$okio().substring(i11, access$rootLength));
                    i11 = i12;
                }
                if (i12 >= size) {
                    break;
                }
                access$rootLength = i12;
            }
            access$rootLength = i11;
        }
        if (access$rootLength < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(access$rootLength, path.getBytes$okio().size()));
        }
        return arrayList;
    }

    @NotNull
    public static final Path commonToPath(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z11);
    }

    @NotNull
    public static final String commonToString(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes$okio().utf8();
    }

    @Nullable
    public static final Character commonVolumeLetter(@NotNull Path path) {
        boolean z11;
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean z12 = false;
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || path.getBytes$okio().size() < 2 || path.getBytes$okio().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c11 = (char) path.getBytes$okio().getByte(0);
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

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    /* access modifiers changed from: private */
    public static final int getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        if (lastIndexOf$default != -1) {
            return lastIndexOf$default;
        }
        return ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    /* access modifiers changed from: private */
    public static final ByteString getSlash(Path path) {
        ByteString bytes$okio = path.getBytes$okio();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes$okio, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString bytes$okio2 = path.getBytes$okio();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes$okio2, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean lastSegmentIsDotDot(Path path) {
        if (!path.getBytes$okio().endsWith(DOT_DOT) || (path.getBytes$okio().size() != 2 && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1) && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int rootLength(Path path) {
        boolean z11;
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        boolean z12 = false;
        if (path.getBytes$okio().getByte(0) == ((byte) 47)) {
            return 1;
        }
        byte b11 = (byte) 92;
        if (path.getBytes$okio().getByte(0) == b11) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != b11) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            if (indexOf == -1) {
                return path.getBytes$okio().size();
            }
            return indexOf;
        } else if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != ((byte) 58) || path.getBytes$okio().getByte(2) != b11) {
            return -1;
        } else {
            char c11 = (char) path.getBytes$okio().getByte(0);
            if ('a' > c11 || c11 > 'z') {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return 3;
            }
            if ('A' <= c11 && c11 <= 'Z') {
                z12 = true;
            }
            if (!z12) {
                return -1;
            }
            return 3;
        }
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        boolean z11;
        boolean z12;
        if (!Intrinsics.areEqual((Object) byteString, (Object) BACKSLASH) || buffer.size() < 2 || buffer.getByte(1) != ((byte) 58)) {
            return false;
        }
        char c11 = (char) buffer.getByte(0);
        if ('a' > c11 || c11 > 'z') {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            if ('A' > c11 || c11 > 'Z') {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!z12) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final Path toPath(@NotNull Buffer buffer, boolean z11) {
        ByteString byteString;
        boolean z12;
        boolean z13;
        ByteString byteString2;
        Buffer buffer2 = buffer;
        Intrinsics.checkNotNullParameter(buffer2, "<this>");
        Buffer buffer3 = new Buffer();
        ByteString byteString3 = null;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (!buffer2.rangeEquals(0, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer2.rangeEquals(0, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString3 == null) {
                byteString3 = toSlash(readByte);
            }
            i12++;
        }
        if (i12 < 2 || !Intrinsics.areEqual((Object) byteString3, (Object) byteString)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            Intrinsics.checkNotNull(byteString3);
            buffer3.write(byteString3);
            buffer3.write(byteString3);
        } else if (i12 > 0) {
            Intrinsics.checkNotNull(byteString3);
            buffer3.write(byteString3);
        } else {
            long indexOfElement = buffer2.indexOfElement(ANY_SLASH);
            if (byteString3 == null) {
                if (indexOfElement == -1) {
                    byteString3 = toSlash(Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString3 = toSlash(buffer2.getByte(indexOfElement));
                }
            }
            if (startsWithVolumeLetterAndColon(buffer2, byteString3)) {
                if (indexOfElement == 2) {
                    buffer3.write(buffer2, 3);
                } else {
                    buffer3.write(buffer2, 2);
                }
            }
        }
        if (buffer3.size() > 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer2.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                byteString2 = buffer.readByteString();
            } else {
                byteString2 = buffer2.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString4 = DOT_DOT;
            if (Intrinsics.areEqual((Object) byteString2, (Object) byteString4)) {
                if (!z13 || !arrayList.isEmpty()) {
                    if (!z11 || (!z13 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt___CollectionsKt.last(arrayList), (Object) byteString4)))) {
                        arrayList.add(byteString2);
                    } else if (!z12 || arrayList.size() != 1) {
                        Object unused = CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                    }
                }
            } else if (!Intrinsics.areEqual((Object) byteString2, (Object) DOT) && !Intrinsics.areEqual((Object) byteString2, (Object) ByteString.EMPTY)) {
                arrayList.add(byteString2);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            while (true) {
                int i13 = i11 + 1;
                if (i11 > 0) {
                    buffer3.write(byteString3);
                }
                buffer3.write((ByteString) arrayList.get(i11));
                if (i13 >= size) {
                    break;
                }
                i11 = i13;
            }
        }
        if (buffer3.size() == 0) {
            buffer3.write(DOT);
        }
        return new Path(buffer3.readByteString());
    }

    /* access modifiers changed from: private */
    public static final ByteString toSlash(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", str));
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull ByteString byteString, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "child");
        return commonResolve(path, toPath(new Buffer().write(byteString), false), z11);
    }

    private static final ByteString toSlash(byte b11) {
        if (b11 == 47) {
            return SLASH;
        }
        if (b11 == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", Byte.valueOf(b11)));
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Buffer buffer, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "child");
        return commonResolve(path, toPath(buffer, false), z11);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Path path2, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "child");
        if (path2.isAbsolute() || path2.volumeLetter() != null) {
            return path2;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(path2)) == null) {
            slash = toSlash(Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(path2.getBytes$okio());
        return toPath(buffer, z11);
    }
}
