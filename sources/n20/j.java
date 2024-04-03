package n20;

import j$.util.function.ToLongFunction;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;

public final /* synthetic */ class j implements ToLongFunction {
    public final long applyAsLong(Object obj) {
        return ((TarArchiveStructSparse) obj).getOffset();
    }
}
