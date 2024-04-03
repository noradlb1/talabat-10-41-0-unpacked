package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PathRelativizer {
    @NotNull
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    private static final Path emptyPath = Paths.get("", new String[0]);
    private static final Path parentPath = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }

    @NotNull
    public final Path tryRelativeTo(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(path2, TtmlNode.RUBY_BASE);
        Path a11 = path2.normalize();
        Path a12 = path.normalize();
        Path a13 = a11.relativize(a12);
        int min = Math.min(a11.getNameCount(), a12.getNameCount());
        int i11 = 0;
        while (i11 < min) {
            Path a14 = a11.getName(i11);
            Path path3 = parentPath;
            if (!Intrinsics.areEqual((Object) a14, (Object) path3)) {
                break;
            } else if (Intrinsics.areEqual((Object) a12.getName(i11), (Object) path3)) {
                i11++;
            } else {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (Intrinsics.areEqual((Object) a12, (Object) a11) || !Intrinsics.areEqual((Object) a11, (Object) emptyPath)) {
            String obj = a13.toString();
            String a15 = a13.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(a15, "rn.fileSystem.separator");
            if (StringsKt__StringsJVMKt.endsWith$default(obj, a15, false, 2, (Object) null)) {
                a12 = a13.getFileSystem().getPath(StringsKt___StringsKt.dropLast(obj, a13.getFileSystem().getSeparator().length()), new String[0]);
            } else {
                a12 = a13;
            }
        }
        Intrinsics.checkNotNullExpressionValue(a12, "r");
        return a12;
    }
}
