package com.google.android.exoplayer2.source.smoothstreaming.offline;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import i2.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class SsDownloader extends SegmentDownloader<SsManifest> {
    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new b());
    }

    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem.buildUpon().setUri(Util.fixSmoothStreamingIsmManifestUri(((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).uri)).build(), new SsManifestParser(), factory, executor, 20000);
    }

    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, SsManifest ssManifest, boolean z11) {
        ArrayList arrayList = new ArrayList();
        for (SsManifest.StreamElement streamElement : ssManifest.streamElements) {
            for (int i11 = 0; i11 < streamElement.formats.length; i11++) {
                for (int i12 = 0; i12 < streamElement.chunkCount; i12++) {
                    arrayList.add(new SegmentDownloader.Segment(streamElement.getStartTimeUs(i12), new DataSpec(streamElement.buildRequestUri(i11, i12))));
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    public SsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<SsManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, parser, factory, executor, 20000);
    }

    public SsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<SsManifest> parser, CacheDataSource.Factory factory, Executor executor, long j11) {
        super(mediaItem, parser, factory, executor, j11);
    }
}
