package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lokio/Path;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ForwardingFileSystem$listRecursively$1 extends Lambda implements Function1<Path, Path> {
    final /* synthetic */ ForwardingFileSystem this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForwardingFileSystem$listRecursively$1(ForwardingFileSystem forwardingFileSystem) {
        super(1);
        this.this$0 = forwardingFileSystem;
    }

    @NotNull
    public final Path invoke(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "it");
        return this.this$0.onPathResult(path, "listRecursively");
    }
}
