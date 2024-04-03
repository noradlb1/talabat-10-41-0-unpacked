package o20;

import java.util.concurrent.Callable;
import org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequestSupplier;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParallelScatterZipCreator f27517b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ZipArchiveEntryRequestSupplier f27518c;

    public /* synthetic */ a(ParallelScatterZipCreator parallelScatterZipCreator, ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        this.f27517b = parallelScatterZipCreator;
        this.f27518c = zipArchiveEntryRequestSupplier;
    }

    public final Object call() {
        return this.f27517b.lambda$createCallable$2(this.f27518c);
    }
}
