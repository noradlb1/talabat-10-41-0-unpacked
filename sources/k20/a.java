package k20;

import java.util.Comparator;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DumpArchiveInputStream.lambda$new$0((DumpArchiveEntry) obj, (DumpArchiveEntry) obj2);
    }
}
