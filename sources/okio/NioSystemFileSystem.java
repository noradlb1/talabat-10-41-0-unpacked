package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "()V", "atomicMove", "", "source", "Lokio/Path;", "target", "createSymlink", "metadataOrNull", "Lokio/FileMetadata;", "path", "toString", "", "zeroToNull", "", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
@IgnoreJRERequirement
public final class NioSystemFileSystem extends JvmSystemFileSystem {
    private final Long zeroToNull(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    public void atomicMove(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        try {
            Path unused = Files.move(path.toNioPath(), path2.toNioPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});
        } catch (NoSuchFileException e11) {
            throw new FileNotFoundException(e11.getMessage());
        } catch (UnsupportedOperationException unused2) {
            throw new IOException("atomic move not supported");
        }
    }

    public void createSymlink(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        Path unused = Files.createSymbolicLink(path.toNioPath(), path2.toNioPath(), new FileAttribute[0]);
    }

    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Path path2;
        Path path3;
        Long l11;
        Long l12;
        Intrinsics.checkNotNullParameter(path, "path");
        Path nioPath = path.toNioPath();
        Long l13 = null;
        try {
            BasicFileAttributes a11 = Files.readAttributes(nioPath, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            if (a11.isSymbolicLink()) {
                path2 = Files.readSymbolicLink(nioPath);
            } else {
                path2 = null;
            }
            boolean a12 = a11.isRegularFile();
            boolean a13 = a11.isDirectory();
            if (path2 == null) {
                path3 = null;
            } else {
                path3 = Path.Companion.get$default(Path.Companion, path2, false, 1, (Object) null);
            }
            Long valueOf = Long.valueOf(a11.size());
            FileTime a14 = a11.creationTime();
            if (a14 == null) {
                l11 = null;
            } else {
                l11 = zeroToNull(a14);
            }
            FileTime a15 = a11.lastModifiedTime();
            if (a15 == null) {
                l12 = null;
            } else {
                l12 = zeroToNull(a15);
            }
            FileTime a16 = a11.lastAccessTime();
            if (a16 != null) {
                l13 = zeroToNull(a16);
            }
            return new FileMetadata(a12, a13, path3, valueOf, l11, l12, l13, (Map) null, 128, (DefaultConstructorMarker) null);
        } catch (FileSystemException | NoSuchFileException unused) {
            return null;
        }
    }

    @NotNull
    public String toString() {
        return "NioSystemFileSystem";
    }
}
