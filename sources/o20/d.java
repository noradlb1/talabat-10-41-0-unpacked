package o20;

import j$.util.function.ToLongFunction;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

public final /* synthetic */ class d implements ToLongFunction {
    public final long applyAsLong(Object obj) {
        return ((ZipArchiveEntry) obj).getDiskNumberStart();
    }
}
