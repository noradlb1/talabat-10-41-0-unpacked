package okio;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006)"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadataOrNull", "Lokio/FileMetadata;", "onPathParameter", "functionName", "", "parameterName", "onPathResult", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ForwardingFileSystem extends FileSystem {
    @NotNull
    private final FileSystem delegate;

    public ForwardingFileSystem(@NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(fileSystem, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = fileSystem;
    }

    @NotNull
    public Sink appendingSink(@NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.appendingSink(onPathParameter(path, "appendingSink", "file"), z11);
    }

    public void atomicMove(@NotNull Path path, @NotNull Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        this.delegate.atomicMove(onPathParameter(path, "atomicMove", "source"), onPathParameter(path2, "atomicMove", "target"));
    }

    @NotNull
    public Path canonicalize(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    public void createDirectory(@NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        this.delegate.createDirectory(onPathParameter(path, "createDirectory", "dir"), z11);
    }

    public void createSymlink(@NotNull Path path, @NotNull Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        this.delegate.createSymlink(onPathParameter(path, "createSymlink", "source"), onPathParameter(path2, "createSymlink", "target"));
    }

    @NotNull
    @JvmName(name = "delegate")
    public final FileSystem delegate() {
        return this.delegate;
    }

    public void delete(@NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), z11);
    }

    @NotNull
    public List<Path> list(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        Path onPathParameter = onPathParameter(path, DefaultCardView.CARD_LIST, "dir");
        ArrayList arrayList = new ArrayList();
        for (Path onPathResult : this.delegate.list(onPathParameter)) {
            arrayList.add(onPathResult(onPathResult, DefaultCardView.CARD_LIST));
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        return arrayList;
    }

    @Nullable
    public List<Path> listOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(path, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Path onPathResult : listOrNull) {
            arrayList.add(onPathResult(onPathResult, "listOrNull"));
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        return arrayList;
    }

    @NotNull
    public Sequence<Path> listRecursively(@NotNull Path path, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return SequencesKt___SequencesKt.map(this.delegate.listRecursively(onPathParameter(path, "listRecursively", "dir"), z11), new ForwardingFileSystem$listRecursively$1(this));
    }

    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        if (metadataOrNull.getSymlinkTarget() == null) {
            return metadataOrNull;
        }
        return FileMetadata.copy$default(metadataOrNull, false, false, onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 251, (Object) null);
    }

    @NotNull
    public Path onPathParameter(@NotNull Path path, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(str, "functionName");
        Intrinsics.checkNotNullParameter(str2, "parameterName");
        return path;
    }

    @NotNull
    public Path onPathResult(@NotNull Path path, @NotNull String str) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(str, "functionName");
        return path;
    }

    @NotNull
    public FileHandle openReadOnly(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.openReadOnly(onPathParameter(path, "openReadOnly", "file"));
    }

    @NotNull
    public FileHandle openReadWrite(@NotNull Path path, boolean z11, boolean z12) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.openReadWrite(onPathParameter(path, "openReadWrite", "file"), z11, z12);
    }

    @NotNull
    public Sink sink(@NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.sink(onPathParameter(path, "sink", "file"), z11);
    }

    @NotNull
    public Source source(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.source(onPathParameter(path, "source", "file"));
    }

    @NotNull
    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
