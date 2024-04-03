package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Immutable
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Landroidx/compose/material/CheckDrawingCache;", "", "checkPath", "Landroidx/compose/ui/graphics/Path;", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "pathToDraw", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathMeasure;Landroidx/compose/ui/graphics/Path;)V", "getCheckPath", "()Landroidx/compose/ui/graphics/Path;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "getPathToDraw", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class CheckDrawingCache {
    @NotNull
    private final Path checkPath;
    @NotNull
    private final PathMeasure pathMeasure;
    @NotNull
    private final Path pathToDraw;

    public CheckDrawingCache() {
        this((Path) null, (PathMeasure) null, (Path) null, 7, (DefaultConstructorMarker) null);
    }

    public CheckDrawingCache(@NotNull Path path, @NotNull PathMeasure pathMeasure2, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "checkPath");
        Intrinsics.checkNotNullParameter(pathMeasure2, "pathMeasure");
        Intrinsics.checkNotNullParameter(path2, "pathToDraw");
        this.checkPath = path;
        this.pathMeasure = pathMeasure2;
        this.pathToDraw = path2;
    }

    @NotNull
    public final Path getCheckPath() {
        return this.checkPath;
    }

    @NotNull
    public final PathMeasure getPathMeasure() {
        return this.pathMeasure;
    }

    @NotNull
    public final Path getPathToDraw() {
        return this.pathToDraw;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckDrawingCache(Path path, PathMeasure pathMeasure2, Path path2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AndroidPath_androidKt.Path() : path, (i11 & 2) != 0 ? AndroidPathMeasure_androidKt.PathMeasure() : pathMeasure2, (i11 & 4) != 0 ? AndroidPath_androidKt.Path() : path2);
    }
}
