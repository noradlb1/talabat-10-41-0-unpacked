package o20;

import java.util.concurrent.Callable;
import org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParallelScatterZipCreator f27521b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ZipArchiveEntryRequest f27522c;

    public /* synthetic */ c(ParallelScatterZipCreator parallelScatterZipCreator, ZipArchiveEntryRequest zipArchiveEntryRequest) {
        this.f27521b = parallelScatterZipCreator;
        this.f27522c = zipArchiveEntryRequest;
    }

    public final Object call() {
        return this.f27521b.lambda$createCallable$1(this.f27522c);
    }
}
