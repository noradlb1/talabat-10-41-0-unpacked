package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.List;

public final class DashUtil {
    private DashUtil() {
    }

    public static DataSpec buildDataSpec(Representation representation, String str, RangedUri rangedUri, int i11) {
        return new DataSpec.Builder().setUri(rangedUri.resolveUri(str)).setPosition(rangedUri.start).setLength(rangedUri.length).setKey(resolveCacheKey(representation, rangedUri)).setFlags(i11).build();
    }

    @Nullable
    private static Representation getFirstRepresentation(Period period, int i11) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i11);
        if (adaptationSetIndex == -1) {
            return null;
        }
        List<Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i11, Representation representation, int i12) throws IOException {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        ChunkExtractor newChunkExtractor = newChunkExtractor(i11, representation.format);
        try {
            loadInitializationData(newChunkExtractor, dataSource, representation, i12, true);
            newChunkExtractor.release();
            return newChunkExtractor.getChunkIndex();
        } catch (Throwable th2) {
            newChunkExtractor.release();
            throw th2;
        }
    }

    @Nullable
    public static Format loadFormatWithDrmInitData(DataSource dataSource, Period period) throws IOException {
        int i11 = 2;
        Representation firstRepresentation = getFirstRepresentation(period, 2);
        if (firstRepresentation == null) {
            i11 = 1;
            firstRepresentation = getFirstRepresentation(period, 1);
            if (firstRepresentation == null) {
                return null;
            }
        }
        Format format = firstRepresentation.format;
        Format loadSampleFormat = loadSampleFormat(dataSource, i11, firstRepresentation);
        if (loadSampleFormat == null) {
            return format;
        }
        return loadSampleFormat.withManifestFormatInfo(format);
    }

    private static void loadInitializationData(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, int i11, boolean z11) throws IOException {
        RangedUri rangedUri = (RangedUri) Assertions.checkNotNull(representation.getInitializationUri());
        if (z11) {
            RangedUri indexUri = representation.getIndexUri();
            if (indexUri != null) {
                RangedUri attemptMerge = rangedUri.attemptMerge(indexUri, representation.baseUrls.get(i11).url);
                if (attemptMerge == null) {
                    loadInitializationData(dataSource, representation, i11, chunkExtractor, rangedUri);
                    rangedUri = indexUri;
                } else {
                    rangedUri = attemptMerge;
                }
            } else {
                return;
            }
        }
        loadInitializationData(dataSource, representation, i11, chunkExtractor, rangedUri);
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) throws IOException {
        return (DashManifest) ParsingLoadable.load(dataSource, new DashManifestParser(), uri, 4);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public static Format loadSampleFormat(DataSource dataSource, int i11, Representation representation, int i12) throws IOException {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        ChunkExtractor newChunkExtractor = newChunkExtractor(i11, representation.format);
        try {
            loadInitializationData(newChunkExtractor, dataSource, representation, i12, false);
            newChunkExtractor.release();
            return ((Format[]) Assertions.checkStateNotNull(newChunkExtractor.getSampleFormats()))[0];
        } catch (Throwable th2) {
            newChunkExtractor.release();
            throw th2;
        }
    }

    private static ChunkExtractor newChunkExtractor(int i11, Format format) {
        boolean z11;
        Extractor extractor;
        String str = format.containerMimeType;
        if (str == null || (!str.startsWith(MimeTypes.VIDEO_WEBM) && !str.startsWith(MimeTypes.AUDIO_WEBM))) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            extractor = new MatroskaExtractor();
        } else {
            extractor = new FragmentedMp4Extractor();
        }
        return new BundledChunkExtractor(extractor, i11, format);
    }

    public static String resolveCacheKey(Representation representation, RangedUri rangedUri) {
        String cacheKey = representation.getCacheKey();
        if (cacheKey != null) {
            return cacheKey;
        }
        return rangedUri.resolveUri(representation.baseUrls.get(0).url).toString();
    }

    public static void loadInitializationData(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, boolean z11) throws IOException {
        loadInitializationData(chunkExtractor, dataSource, representation, 0, z11);
    }

    public static DataSpec buildDataSpec(Representation representation, RangedUri rangedUri, int i11) {
        return buildDataSpec(representation, representation.baseUrls.get(0).url, rangedUri, i11);
    }

    @Nullable
    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i11, Representation representation) throws IOException {
        return loadChunkIndex(dataSource, i11, representation, 0);
    }

    private static void loadInitializationData(DataSource dataSource, Representation representation, int i11, ChunkExtractor chunkExtractor, RangedUri rangedUri) throws IOException {
        new InitializationChunk(dataSource, buildDataSpec(representation, representation.baseUrls.get(i11).url, rangedUri, 0), representation.format, 0, (Object) null, chunkExtractor).load();
    }

    @Nullable
    public static Format loadSampleFormat(DataSource dataSource, int i11, Representation representation) throws IOException {
        return loadSampleFormat(dataSource, i11, representation, 0);
    }
}
