package o20;

import java.util.concurrent.Callable;
import org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParallelScatterZipCreator f27519b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f27520c;

    public /* synthetic */ b(ParallelScatterZipCreator parallelScatterZipCreator, Callable callable) {
        this.f27519b = parallelScatterZipCreator;
        this.f27520c = callable;
    }

    public final Object call() {
        return this.f27519b.lambda$submit$0(this.f27520c);
    }
}
