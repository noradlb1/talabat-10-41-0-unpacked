package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lokio/internal/ZipEntry;", "entry", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ResourceFileSystem$Companion$toJarRoot$zip$1 extends Lambda implements Function1<ZipEntry, Boolean> {
    public static final ResourceFileSystem$Companion$toJarRoot$zip$1 INSTANCE = new ResourceFileSystem$Companion$toJarRoot$zip$1();

    public ResourceFileSystem$Companion$toJarRoot$zip$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull ZipEntry zipEntry) {
        Intrinsics.checkNotNullParameter(zipEntry, "entry");
        return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(zipEntry.getCanonicalPath()));
    }
}
