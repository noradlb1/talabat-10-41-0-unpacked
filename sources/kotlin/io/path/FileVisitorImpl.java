package kotlin.io.path;

import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "postVisitDirectory", "dir", "exc", "preVisitDirectory", "attrs", "visitFile", "file", "visitFileFailed", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    @Nullable
    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    @Nullable
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    @Nullable
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    @Nullable
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;

    public FileVisitorImpl(@Nullable Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2, @Nullable Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function22, @Nullable Function2<? super Path, ? super IOException, ? extends FileVisitResult> function23, @Nullable Function2<? super Path, ? super IOException, ? extends FileVisitResult> function24) {
        this.onPreVisitDirectory = function2;
        this.onVisitFile = function22;
        this.onVisitFileFailed = function23;
        this.onPostVisitDirectory = function24;
    }

    @NotNull
    public FileVisitResult postVisitDirectory(@NotNull Path path, @Nullable IOException iOException) {
        FileVisitResult invoke;
        Intrinsics.checkNotNullParameter(path, "dir");
        Function2<Path, IOException, FileVisitResult> function2 = this.onPostVisitDirectory;
        if (function2 != null && (invoke = function2.invoke(path, iOException)) != null) {
            return invoke;
        }
        FileVisitResult postVisitDirectory = super.postVisitDirectory(path, iOException);
        Intrinsics.checkNotNullExpressionValue(postVisitDirectory, "super.postVisitDirectory(dir, exc)");
        return postVisitDirectory;
    }

    @NotNull
    public FileVisitResult preVisitDirectory(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
        FileVisitResult invoke;
        Intrinsics.checkNotNullParameter(path, "dir");
        Intrinsics.checkNotNullParameter(basicFileAttributes, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.onPreVisitDirectory;
        if (function2 != null && (invoke = function2.invoke(path, basicFileAttributes)) != null) {
            return invoke;
        }
        FileVisitResult preVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        Intrinsics.checkNotNullExpressionValue(preVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return preVisitDirectory;
    }

    @NotNull
    public FileVisitResult visitFile(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
        FileVisitResult invoke;
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(basicFileAttributes, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.onVisitFile;
        if (function2 != null && (invoke = function2.invoke(path, basicFileAttributes)) != null) {
            return invoke;
        }
        FileVisitResult visitFile = super.visitFile(path, basicFileAttributes);
        Intrinsics.checkNotNullExpressionValue(visitFile, "super.visitFile(file, attrs)");
        return visitFile;
    }

    @NotNull
    public FileVisitResult visitFileFailed(@NotNull Path path, @NotNull IOException iOException) {
        FileVisitResult invoke;
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(iOException, "exc");
        Function2<Path, IOException, FileVisitResult> function2 = this.onVisitFileFailed;
        if (function2 != null && (invoke = function2.invoke(path, iOException)) != null) {
            return invoke;
        }
        FileVisitResult visitFileFailed = super.visitFileFailed(path, iOException);
        Intrinsics.checkNotNullExpressionValue(visitFileFailed, "super.visitFileFailed(file, exc)");
        return visitFileFailed;
    }
}
