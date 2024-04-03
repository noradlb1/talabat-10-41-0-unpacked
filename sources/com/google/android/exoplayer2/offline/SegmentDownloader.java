package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import m8.c;

public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {
    private static final int BUFFER_SIZE_BYTES = 131072;
    public static final long DEFAULT_MAX_MERGED_SEGMENT_START_TIME_DIFF_MS = 20000;
    private final ArrayList<RunnableFutureTask<?, ?>> activeRunnables;
    private final Cache cache;
    private final CacheDataSource.Factory cacheDataSourceFactory;
    private final CacheKeyFactory cacheKeyFactory;
    private final Executor executor;
    private volatile boolean isCanceled;
    private final DataSpec manifestDataSpec;
    /* access modifiers changed from: private */
    public final ParsingLoadable.Parser<M> manifestParser;
    private final long maxMergedSegmentStartTimeDiffUs;
    @Nullable
    private final PriorityTaskManager priorityTaskManager;
    private final ArrayList<StreamKey> streamKeys;

    public static final class ProgressNotifier implements CacheWriter.ProgressListener {
        private long bytesDownloaded;
        private final long contentLength;
        private final Downloader.ProgressListener progressListener;
        private int segmentsDownloaded;
        private final int totalSegments;

        public ProgressNotifier(Downloader.ProgressListener progressListener2, long j11, int i11, long j12, int i12) {
            this.progressListener = progressListener2;
            this.contentLength = j11;
            this.totalSegments = i11;
            this.bytesDownloaded = j12;
            this.segmentsDownloaded = i12;
        }

        private float getPercentDownloaded() {
            long j11 = this.contentLength;
            if (j11 != -1 && j11 != 0) {
                return (((float) this.bytesDownloaded) * 100.0f) / ((float) j11);
            }
            int i11 = this.totalSegments;
            if (i11 != 0) {
                return (((float) this.segmentsDownloaded) * 100.0f) / ((float) i11);
            }
            return -1.0f;
        }

        public void onProgress(long j11, long j12, long j13) {
            long j14 = this.bytesDownloaded + j13;
            this.bytesDownloaded = j14;
            this.progressListener.onProgress(this.contentLength, j14, getPercentDownloaded());
        }

        public void onSegmentDownloaded() {
            this.segmentsDownloaded++;
            this.progressListener.onProgress(this.contentLength, this.bytesDownloaded, getPercentDownloaded());
        }
    }

    public static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j11, DataSpec dataSpec2) {
            this.startTimeUs = j11;
            this.dataSpec = dataSpec2;
        }

        public int compareTo(Segment segment) {
            return Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final CacheWriter cacheWriter;
        public final CacheDataSource dataSource;
        @Nullable
        private final ProgressNotifier progressNotifier;
        public final Segment segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(Segment segment2, CacheDataSource cacheDataSource, @Nullable ProgressNotifier progressNotifier2, byte[] bArr) {
            this.segment = segment2;
            this.dataSource = cacheDataSource;
            this.progressNotifier = progressNotifier2;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new CacheWriter(cacheDataSource, segment2.dataSpec, bArr, progressNotifier2);
        }

        public void cancelWork() {
            this.cacheWriter.cancel();
        }

        public Void doWork() throws IOException {
            this.cacheWriter.cache();
            ProgressNotifier progressNotifier2 = this.progressNotifier;
            if (progressNotifier2 == null) {
                return null;
            }
            progressNotifier2.onSegmentDownloaded();
            return null;
        }
    }

    @Deprecated
    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor2) {
        this(mediaItem, parser, factory, executor2, 20000);
    }

    private <T> void addActiveRunnable(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.activeRunnables) {
            if (!this.isCanceled) {
                this.activeRunnables.add(runnableFutureTask);
            } else {
                throw new InterruptedException();
            }
        }
    }

    private static boolean canMergeSegments(DataSpec dataSpec, DataSpec dataSpec2) {
        if (dataSpec.uri.equals(dataSpec2.uri)) {
            long j11 = dataSpec.length;
            if (j11 == -1 || dataSpec.position + j11 != dataSpec2.position || !Util.areEqual(dataSpec.key, dataSpec2.key) || dataSpec.flags != dataSpec2.flags || dataSpec.httpMethod != dataSpec2.httpMethod || !dataSpec.httpRequestHeaders.equals(dataSpec2.httpRequestHeaders)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    private static void mergeSegments(List<Segment> list, CacheKeyFactory cacheKeyFactory2, long j11) {
        Segment segment;
        HashMap hashMap = new HashMap();
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Segment segment2 = list.get(i12);
            String buildCacheKey = cacheKeyFactory2.buildCacheKey(segment2.dataSpec);
            Integer num = (Integer) hashMap.get(buildCacheKey);
            if (num == null) {
                segment = null;
            } else {
                segment = list.get(num.intValue());
            }
            if (segment == null || segment2.startTimeUs > segment.startTimeUs + j11 || !canMergeSegments(segment.dataSpec, segment2.dataSpec)) {
                hashMap.put(buildCacheKey, Integer.valueOf(i11));
                list.set(i11, segment2);
                i11++;
            } else {
                long j12 = segment2.dataSpec.length;
                long j13 = -1;
                if (j12 != -1) {
                    j13 = segment.dataSpec.length + j12;
                }
                list.set(((Integer) Assertions.checkNotNull(num)).intValue(), new Segment(segment.startTimeUs, segment.dataSpec.subrange(0, j13)));
            }
        }
        Util.removeRange(list, i11, list.size());
    }

    private void removeActiveRunnable(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(runnableFutureTask);
        }
    }

    public void cancel() {
        synchronized (this.activeRunnables) {
            this.isCanceled = true;
            for (int i11 = 0; i11 < this.activeRunnables.size(); i11++) {
                this.activeRunnables.get(i11).cancel(true);
            }
        }
    }

    public final void download(@Nullable Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        ProgressNotifier progressNotifier;
        CacheDataSource cacheDataSource;
        byte[] bArr;
        int size;
        SegmentDownloadRunnable segmentDownloadRunnable;
        int i11;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 != null) {
            priorityTaskManager2.add(-1000);
        }
        try {
            CacheDataSource createDataSourceForDownloading = this.cacheDataSourceFactory.createDataSourceForDownloading();
            FilterableManifest manifest = getManifest(createDataSourceForDownloading, this.manifestDataSpec, false);
            if (!this.streamKeys.isEmpty()) {
                manifest = (FilterableManifest) manifest.copy(this.streamKeys);
            }
            List<Segment> segments = getSegments(createDataSourceForDownloading, manifest, false);
            Collections.sort(segments);
            mergeSegments(segments, this.cacheKeyFactory, this.maxMergedSegmentStartTimeDiffUs);
            int size2 = segments.size();
            int i12 = 0;
            long j11 = 0;
            long j12 = 0;
            for (int size3 = segments.size() - 1; size3 >= 0; size3 = i11 - 1) {
                DataSpec dataSpec = segments.get(size3).dataSpec;
                String buildCacheKey = this.cacheKeyFactory.buildCacheKey(dataSpec);
                long j13 = dataSpec.length;
                if (j13 == -1) {
                    long a11 = c.a(this.cache.getContentMetadata(buildCacheKey));
                    if (a11 != -1) {
                        j13 = a11 - dataSpec.position;
                    }
                }
                int i13 = size3;
                long cachedBytes = this.cache.getCachedBytes(buildCacheKey, dataSpec.position, j13);
                j12 += cachedBytes;
                if (j13 != -1) {
                    if (j13 == cachedBytes) {
                        i12++;
                        i11 = i13;
                        segments.remove(i11);
                    } else {
                        i11 = i13;
                    }
                    if (j11 != -1) {
                        j11 += j13;
                    }
                } else {
                    i11 = i13;
                    j11 = -1;
                }
            }
            if (progressListener != null) {
                progressNotifier = new ProgressNotifier(progressListener, j11, size2, j12, i12);
            } else {
                progressNotifier = null;
            }
            arrayDeque.addAll(segments);
            while (!this.isCanceled && !arrayDeque.isEmpty()) {
                PriorityTaskManager priorityTaskManager3 = this.priorityTaskManager;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.proceed(-1000);
                }
                if (!arrayDeque2.isEmpty()) {
                    SegmentDownloadRunnable segmentDownloadRunnable2 = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                    cacheDataSource = segmentDownloadRunnable2.dataSource;
                    bArr = segmentDownloadRunnable2.temporaryBuffer;
                } else {
                    cacheDataSource = this.cacheDataSourceFactory.createDataSourceForDownloading();
                    bArr = new byte[131072];
                }
                SegmentDownloadRunnable segmentDownloadRunnable3 = new SegmentDownloadRunnable((Segment) arrayDeque.removeFirst(), cacheDataSource, progressNotifier, bArr);
                addActiveRunnable(segmentDownloadRunnable3);
                this.executor.execute(segmentDownloadRunnable3);
                size = this.activeRunnables.size() - 1;
                while (size >= 0) {
                    segmentDownloadRunnable = (SegmentDownloadRunnable) this.activeRunnables.get(size);
                    if (arrayDeque.isEmpty() || segmentDownloadRunnable.isDone()) {
                        segmentDownloadRunnable.get();
                        removeActiveRunnable(size);
                        arrayDeque2.addLast(segmentDownloadRunnable);
                    }
                    size--;
                }
                segmentDownloadRunnable3.blockUntilStarted();
            }
            for (int i14 = 0; i14 < this.activeRunnables.size(); i14++) {
                this.activeRunnables.get(i14).cancel(true);
            }
            for (int size4 = this.activeRunnables.size() - 1; size4 >= 0; size4--) {
                this.activeRunnables.get(size4).blockUntilFinished();
                removeActiveRunnable(size4);
            }
            PriorityTaskManager priorityTaskManager4 = this.priorityTaskManager;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.remove(-1000);
            }
        } catch (ExecutionException e11) {
            Throwable th2 = (Throwable) Assertions.checkNotNull(e11.getCause());
            if (th2 instanceof PriorityTaskManager.PriorityTooLowException) {
                arrayDeque.addFirst(segmentDownloadRunnable.segment);
                removeActiveRunnable(size);
                arrayDeque2.addLast(segmentDownloadRunnable);
            } else if (!(th2 instanceof IOException)) {
                Util.sneakyThrow(th2);
            } else {
                throw ((IOException) th2);
            }
        } catch (Throwable th3) {
            for (int i15 = 0; i15 < this.activeRunnables.size(); i15++) {
                this.activeRunnables.get(i15).cancel(true);
            }
            for (int size5 = this.activeRunnables.size() - 1; size5 >= 0; size5--) {
                this.activeRunnables.get(size5).blockUntilFinished();
                removeActiveRunnable(size5);
            }
            PriorityTaskManager priorityTaskManager5 = this.priorityTaskManager;
            if (priorityTaskManager5 != null) {
                priorityTaskManager5.remove(-1000);
            }
            throw th3;
        }
    }

    public final <T> T execute(RunnableFutureTask<T, ?> runnableFutureTask, boolean z11) throws InterruptedException, IOException {
        if (z11) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e11) {
                Throwable th2 = (Throwable) Assertions.checkNotNull(e11.getCause());
                if (!(th2 instanceof IOException)) {
                    Util.sneakyThrow(e11);
                } else {
                    throw ((IOException) th2);
                }
            }
        }
        while (!this.isCanceled) {
            PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
            if (priorityTaskManager2 != null) {
                priorityTaskManager2.proceed(-1000);
            }
            addActiveRunnable(runnableFutureTask);
            this.executor.execute(runnableFutureTask);
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e12) {
                Throwable th3 = (Throwable) Assertions.checkNotNull(e12.getCause());
                if (!(th3 instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th3 instanceof IOException)) {
                        Util.sneakyThrow(e12);
                    } else {
                        throw ((IOException) th3);
                    }
                }
            } finally {
                runnableFutureTask.blockUntilFinished();
                removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
            }
        }
        throw new InterruptedException();
    }

    public final M getManifest(final DataSource dataSource, final DataSpec dataSpec, boolean z11) throws InterruptedException, IOException {
        return (FilterableManifest) execute(new RunnableFutureTask<M, IOException>() {
            public M doWork() throws IOException {
                return (FilterableManifest) ParsingLoadable.load(dataSource, SegmentDownloader.this.manifestParser, dataSpec, 4);
            }
        }, z11);
    }

    public abstract List<Segment> getSegments(DataSource dataSource, M m11, boolean z11) throws IOException, InterruptedException;

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void remove() {
        /*
            r5 = this;
            com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory r0 = r5.cacheDataSourceFactory
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r0 = r0.createDataSourceForRemovingDownload()
            com.google.android.exoplayer2.upstream.DataSpec r1 = r5.manifestDataSpec     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2 = 1
            com.google.android.exoplayer2.offline.FilterableManifest r1 = r5.getManifest(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.util.List r0 = r5.getSegments(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r1 = 0
        L_0x0012:
            int r2 = r0.size()     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            if (r1 >= r2) goto L_0x0030
            com.google.android.exoplayer2.upstream.cache.Cache r2 = r5.cache     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r3 = r5.cacheKeyFactory     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.Object r4 = r0.get(r1)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r4 = (com.google.android.exoplayer2.offline.SegmentDownloader.Segment) r4     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.upstream.DataSpec r4 = r4.dataSpec     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.String r3 = r3.buildCacheKey(r4)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2.removeResource(r3)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            int r1 = r1 + 1
            goto L_0x0012
        L_0x002e:
            r0 = move-exception
            goto L_0x0047
        L_0x0030:
            com.google.android.exoplayer2.upstream.cache.Cache r0 = r5.cache
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r1 = r5.cacheKeyFactory
            com.google.android.exoplayer2.upstream.DataSpec r2 = r5.manifestDataSpec
            java.lang.String r1 = r1.buildCacheKey(r2)
            r0.removeResource(r1)
            goto L_0x0046
        L_0x003e:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002e }
            r0.interrupt()     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x0046:
            return
        L_0x0047:
            com.google.android.exoplayer2.upstream.cache.Cache r1 = r5.cache
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r2 = r5.cacheKeyFactory
            com.google.android.exoplayer2.upstream.DataSpec r3 = r5.manifestDataSpec
            java.lang.String r2 = r2.buildCacheKey(r3)
            r1.removeResource(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.remove():void");
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor2, long j11) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        this.manifestDataSpec = getCompressibleDataSpec(mediaItem.localConfiguration.uri);
        this.manifestParser = parser;
        this.streamKeys = new ArrayList<>(mediaItem.localConfiguration.streamKeys);
        this.cacheDataSourceFactory = factory;
        this.executor = executor2;
        this.cache = (Cache) Assertions.checkNotNull(factory.getCache());
        this.cacheKeyFactory = factory.getCacheKeyFactory();
        this.priorityTaskManager = factory.getUpstreamPriorityTaskManager();
        this.activeRunnables = new ArrayList<>();
        this.maxMergedSegmentStartTimeDiffUs = Util.msToUs(j11);
    }

    private void removeActiveRunnable(int i11) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(i11);
        }
    }
}
