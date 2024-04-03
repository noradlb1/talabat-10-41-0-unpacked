package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import o20.a;
import o20.b;
import o20.c;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier;

public class ParallelScatterZipCreator {
    /* access modifiers changed from: private */
    public final ScatterGatherBackingStoreSupplier backingStoreSupplier;
    private long compressionDoneAt;
    private final int compressionLevel;

    /* renamed from: es  reason: collision with root package name */
    private final ExecutorService f27646es;
    private final Deque<Future<? extends ScatterZipOutputStream>> futures;
    private long scatterDoneAt;
    private final long startedAt;
    /* access modifiers changed from: private */
    public final Deque<ScatterZipOutputStream> streams;
    private final ThreadLocal<ScatterZipOutputStream> tlScatterStreams;

    public static class DefaultBackingStoreSupplier implements ScatterGatherBackingStoreSupplier {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f27648a;

        private DefaultBackingStoreSupplier() {
            this.f27648a = new AtomicInteger(0);
        }

        public ScatterGatherBackingStore get() throws IOException {
            return new FileBasedScatterGatherBackingStore(File.createTempFile("parallelscatter", "n" + this.f27648a.incrementAndGet()));
        }
    }

    public ParallelScatterZipCreator() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    private void closeAll() {
        for (ScatterZipOutputStream close : this.streams) {
            try {
                close.close();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public ScatterZipOutputStream createDeferred(ScatterGatherBackingStoreSupplier scatterGatherBackingStoreSupplier) throws IOException {
        ScatterGatherBackingStore scatterGatherBackingStore = scatterGatherBackingStoreSupplier.get();
        return new ScatterZipOutputStream(scatterGatherBackingStore, StreamCompressor.create(this.compressionLevel, scatterGatherBackingStore));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScatterZipOutputStream lambda$createCallable$1(ZipArchiveEntryRequest zipArchiveEntryRequest) throws Exception {
        ScatterZipOutputStream scatterZipOutputStream = this.tlScatterStreams.get();
        scatterZipOutputStream.addArchiveEntry(zipArchiveEntryRequest);
        return scatterZipOutputStream;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScatterZipOutputStream lambda$createCallable$2(ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) throws Exception {
        ScatterZipOutputStream scatterZipOutputStream = this.tlScatterStreams.get();
        scatterZipOutputStream.addArchiveEntry(zipArchiveEntryRequestSupplier.get());
        return scatterZipOutputStream;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScatterZipOutputStream lambda$submit$0(Callable callable) throws Exception {
        callable.call();
        return this.tlScatterStreams.get();
    }

    public void addArchiveEntry(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier inputStreamSupplier) {
        submitStreamAwareCallable(createCallable(zipArchiveEntry, inputStreamSupplier));
    }

    public final Callable<ScatterZipOutputStream> createCallable(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier inputStreamSupplier) {
        if (zipArchiveEntry.getMethod() != -1) {
            return new c(this, ZipArchiveEntryRequest.createZipArchiveEntryRequest(zipArchiveEntry, inputStreamSupplier));
        }
        throw new IllegalArgumentException("Method must be set on zipArchiveEntry: " + zipArchiveEntry);
    }

    public ScatterStatistics getStatisticsMessage() {
        long j11 = this.compressionDoneAt;
        return new ScatterStatistics(j11 - this.startedAt, this.scatterDoneAt - j11);
    }

    public final void submit(Callable<? extends Object> callable) {
        submitStreamAwareCallable(new b(this, callable));
    }

    public final void submitStreamAwareCallable(Callable<? extends ScatterZipOutputStream> callable) {
        this.futures.add(this.f27646es.submit(callable));
    }

    public void writeTo(ZipArchiveOutputStream zipArchiveOutputStream) throws IOException, InterruptedException, ExecutionException {
        try {
            for (Future<? extends ScatterZipOutputStream> future : this.futures) {
                future.get();
            }
            this.f27646es.shutdown();
            this.f27646es.awaitTermination(60000, TimeUnit.SECONDS);
            this.compressionDoneAt = System.currentTimeMillis();
            for (Future<? extends ScatterZipOutputStream> future2 : this.futures) {
                ((ScatterZipOutputStream) future2.get()).zipEntryWriter().writeNextZipEntry(zipArchiveOutputStream);
            }
            for (ScatterZipOutputStream close : this.streams) {
                close.close();
            }
            this.scatterDoneAt = System.currentTimeMillis();
            closeAll();
        } catch (Throwable th2) {
            closeAll();
            throw th2;
        }
    }

    public ParallelScatterZipCreator(ExecutorService executorService) {
        this(executorService, new DefaultBackingStoreSupplier());
    }

    public void addArchiveEntry(ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        submitStreamAwareCallable(createCallable(zipArchiveEntryRequestSupplier));
    }

    public ParallelScatterZipCreator(ExecutorService executorService, ScatterGatherBackingStoreSupplier scatterGatherBackingStoreSupplier) {
        this(executorService, scatterGatherBackingStoreSupplier, -1);
    }

    public ParallelScatterZipCreator(ExecutorService executorService, ScatterGatherBackingStoreSupplier scatterGatherBackingStoreSupplier, int i11) throws IllegalArgumentException {
        this.streams = new ConcurrentLinkedDeque();
        this.futures = new ConcurrentLinkedDeque();
        this.startedAt = System.currentTimeMillis();
        this.tlScatterStreams = new ThreadLocal<ScatterZipOutputStream>() {
            /* renamed from: a */
            public ScatterZipOutputStream initialValue() {
                try {
                    ParallelScatterZipCreator parallelScatterZipCreator = ParallelScatterZipCreator.this;
                    ScatterZipOutputStream access$100 = parallelScatterZipCreator.createDeferred(parallelScatterZipCreator.backingStoreSupplier);
                    ParallelScatterZipCreator.this.streams.add(access$100);
                    return access$100;
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        };
        if ((i11 < 0 || i11 > 9) && i11 != -1) {
            throw new IllegalArgumentException("Compression level is expected between -1~9");
        }
        this.backingStoreSupplier = scatterGatherBackingStoreSupplier;
        this.f27646es = executorService;
        this.compressionLevel = i11;
    }

    public final Callable<ScatterZipOutputStream> createCallable(ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        return new a(this, zipArchiveEntryRequestSupplier);
    }
}
