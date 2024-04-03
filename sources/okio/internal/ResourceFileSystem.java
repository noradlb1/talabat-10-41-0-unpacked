package okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\f\u0010(\u001a\u00020)*\u00020\nH\u0002R-\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006+"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", "", "(Ljava/lang/ClassLoader;Z)V", "roots", "", "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "appendingSink", "Lokio/Sink;", "file", "mustExist", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toRelativePath", "", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ResourceFileSystem extends FileSystem {
    /* access modifiers changed from: private */
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    @NotNull
    private final Lazy roots$delegate;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e0\r*\u00020\u0010J\u0018\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012J\u0018\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "keepPath", "", "path", "removeBase", "base", "toClasspathRoots", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !StringsKt__StringsJVMKt.endsWith(path.name(), ".class", true);
        }

        @NotNull
        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        @NotNull
        public final Path removeBase(@NotNull Path path, @NotNull Path path2) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            Intrinsics.checkNotNullParameter(path2, TtmlNode.RUBY_BASE);
            return getROOT().resolve(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsKt.removePrefix(path.toString(), (CharSequence) path2.toString()), '\\', '/', false, 4, (Object) null));
        }

        @NotNull
        public final List<Pair<FileSystem, Path>> toClasspathRoots(@NotNull ClassLoader classLoader) {
            Intrinsics.checkNotNullParameter(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(\"\")");
            ArrayList<T> list = Collections.list(resources);
            Intrinsics.checkNotNullExpressionValue(list, "java.util.Collections.list(this)");
            ArrayList arrayList = new ArrayList();
            for (T t11 : list) {
                Companion access$getCompanion$p = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(t11, "it");
                Pair<FileSystem, Path> fileRoot = access$getCompanion$p.toFileRoot(t11);
                if (fileRoot != null) {
                    arrayList.add(fileRoot);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<T> list2 = Collections.list(resources2);
            Intrinsics.checkNotNullExpressionValue(list2, "java.util.Collections.list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (T t12 : list2) {
                Companion access$getCompanion$p2 = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(t12, "it");
                Pair<FileSystem, Path> jarRoot = access$getCompanion$p2.toJarRoot(t12);
                if (jarRoot != null) {
                    arrayList2.add(jarRoot);
                }
            }
            return CollectionsKt___CollectionsKt.plus(arrayList, arrayList2);
        }

        @Nullable
        public final Pair<FileSystem, Path> toFileRoot(@NotNull URL url) {
            Intrinsics.checkNotNullParameter(url, "<this>");
            if (!Intrinsics.areEqual((Object) url.getProtocol(), (Object) "file")) {
                return null;
            }
            return TuplesKt.to(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
        }

        @Nullable
        public final Pair<FileSystem, Path> toJarRoot(@NotNull URL url) {
            int lastIndexOf$default;
            Intrinsics.checkNotNullParameter(url, "<this>");
            String url2 = url.toString();
            Intrinsics.checkNotNullExpressionValue(url2, "toString()");
            if (!StringsKt__StringsJVMKt.startsWith$default(url2, "jar:file:", false, 2, (Object) null) || (lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url2, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Path.Companion companion = Path.Companion;
            String substring = url2.substring(4, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return TuplesKt.to(ZipKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.SYSTEM, ResourceFileSystem$Companion$toJarRoot$zip$1.INSTANCE), getROOT());
        }
    }

    public ResourceFileSystem(@NotNull ClassLoader classLoader, boolean z11) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.roots$delegate = LazyKt__LazyJVMKt.lazy(new ResourceFileSystem$roots$2(classLoader));
        if (z11) {
            getRoots().size();
        }
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @NotNull
    public Sink appendingSink(@NotNull Path path, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException(this + " is read-only");
    }

    public void atomicMove(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException(this + " is read-only");
    }

    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return canonicalizeInternal(path);
    }

    public void createDirectory(@NotNull Path path, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "dir");
        throw new IOException(this + " is read-only");
    }

    public void createSymlink(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException(this + " is read-only");
    }

    public void delete(@NotNull Path path, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @NotNull
    public List<Path> list(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z11 = false;
        for (Pair next : getRoots()) {
            FileSystem fileSystem = (FileSystem) next.component1();
            Path path2 = (Path) next.component2();
            try {
                ArrayList<Path> arrayList = new ArrayList<>();
                for (Object next2 : fileSystem.list(path2.resolve(relativePath))) {
                    if (Companion.keepPath((Path) next2)) {
                        arrayList.add(next2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                for (Path removeBase : arrayList) {
                    arrayList2.add(Companion.removeBase(removeBase, path2));
                }
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, arrayList2);
                z11 = true;
            } catch (IOException unused2) {
            }
        }
        if (z11) {
            return CollectionsKt___CollectionsKt.toList(linkedHashSet);
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", path));
    }

    @Nullable
    public List<Path> listOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> it = getRoots().iterator();
        boolean z11 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair next = it.next();
            Path path2 = (Path) next.component2();
            List<Path> listOrNull = ((FileSystem) next.component1()).listOrNull(path2.resolve(relativePath));
            if (listOrNull != null) {
                ArrayList<Path> arrayList2 = new ArrayList<>();
                for (Object next2 : listOrNull) {
                    if (Companion.keepPath((Path) next2)) {
                        arrayList2.add(next2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                for (Path removeBase : arrayList2) {
                    arrayList3.add(Companion.removeBase(removeBase, path2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, arrayList);
                z11 = true;
            }
        }
        if (z11) {
            return CollectionsKt___CollectionsKt.toList(linkedHashSet);
        }
        return null;
    }

    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair next : getRoots()) {
            FileMetadata metadataOrNull = ((FileSystem) next.component1()).metadataOrNull(((Path) next.component2()).resolve(relativePath));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    @NotNull
    public FileHandle openReadOnly(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (Companion.keepPath(path)) {
            String relativePath = toRelativePath(path);
            for (Pair next : getRoots()) {
                try {
                    return ((FileSystem) next.component1()).openReadOnly(((Path) next.component2()).resolve(relativePath));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", path));
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", path));
    }

    @NotNull
    public FileHandle openReadWrite(@NotNull Path path, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("resources are not writable");
    }

    @NotNull
    public Sink sink(@NotNull Path path, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException(this + " is read-only");
    }

    @NotNull
    public Source source(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (Companion.keepPath(path)) {
            String relativePath = toRelativePath(path);
            for (Pair next : getRoots()) {
                try {
                    return ((FileSystem) next.component1()).source(((Path) next.component2()).resolve(relativePath));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", path));
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", path));
    }
}
