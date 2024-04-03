package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import com.huawei.hms.feature.dynamic.b;
import f8.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static final double DEFAULT_PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    public static final HlsPlaylistTracker.Factory FACTORY = new a();
    /* access modifiers changed from: private */
    public final HlsDataSourceFactory dataSourceFactory;
    /* access modifiers changed from: private */
    @Nullable
    public MediaSourceEventListener.EventDispatcher eventDispatcher;
    @Nullable
    private Loader initialPlaylistLoader;
    private long initialStartTimeUs;
    private boolean isLive;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.PlaylistEventListener> listeners;
    /* access modifiers changed from: private */
    public final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    /* access modifiers changed from: private */
    @Nullable
    public HlsMultivariantPlaylist multivariantPlaylist;
    /* access modifiers changed from: private */
    public final HashMap<Uri, MediaPlaylistBundle> playlistBundles;
    /* access modifiers changed from: private */
    public final HlsPlaylistParserFactory playlistParserFactory;
    /* access modifiers changed from: private */
    @Nullable
    public Handler playlistRefreshHandler;
    /* access modifiers changed from: private */
    public final double playlistStuckTargetDurationCoefficient;
    /* access modifiers changed from: private */
    @Nullable
    public HlsMediaPlaylist primaryMediaPlaylistSnapshot;
    /* access modifiers changed from: private */
    @Nullable
    public Uri primaryMediaPlaylistUrl;
    @Nullable
    private HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener;

    public class FirstPrimaryMediaPlaylistListener implements HlsPlaylistTracker.PlaylistEventListener {
        private FirstPrimaryMediaPlaylistListener() {
        }

        public void onPlaylistChanged() {
            DefaultHlsPlaylistTracker.this.listeners.remove(this);
        }

        public boolean onPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z11) {
            MediaPlaylistBundle mediaPlaylistBundle;
            if (DefaultHlsPlaylistTracker.this.primaryMediaPlaylistSnapshot == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<HlsMultivariantPlaylist.Variant> list = ((HlsMultivariantPlaylist) Util.castNonNull(DefaultHlsPlaylistTracker.this.multivariantPlaylist)).variants;
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.playlistBundles.get(list.get(i12).url);
                    if (mediaPlaylistBundle2 != null && elapsedRealtime < mediaPlaylistBundle2.excludeUntilMs) {
                        i11++;
                    }
                }
                LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getFallbackSelectionFor(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, DefaultHlsPlaylistTracker.this.multivariantPlaylist.variants.size(), i11), loadErrorInfo);
                if (!(fallbackSelectionFor == null || fallbackSelectionFor.type != 2 || (mediaPlaylistBundle = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.playlistBundles.get(uri)) == null)) {
                    boolean unused = mediaPlaylistBundle.excludePlaylist(fallbackSelectionFor.exclusionDurationMs);
                }
            }
            return false;
        }
    }

    public final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
        private static final String BLOCK_MSN_PARAM = "_HLS_msn";
        private static final String BLOCK_PART_PARAM = "_HLS_part";
        private static final String SKIP_PARAM = "_HLS_skip";
        private long earliestNextLoadTimeMs;
        /* access modifiers changed from: private */
        public long excludeUntilMs;
        private long lastSnapshotChangeMs;
        private long lastSnapshotLoadMs;
        private boolean loadPending;
        private final DataSource mediaPlaylistDataSource;
        private final Loader mediaPlaylistLoader = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        @Nullable
        private IOException playlistError;
        /* access modifiers changed from: private */
        @Nullable
        public HlsMediaPlaylist playlistSnapshot;
        /* access modifiers changed from: private */
        public final Uri playlistUrl;

        public MediaPlaylistBundle(Uri uri) {
            this.playlistUrl = uri;
            this.mediaPlaylistDataSource = DefaultHlsPlaylistTracker.this.dataSourceFactory.createDataSource(4);
        }

        /* access modifiers changed from: private */
        public boolean excludePlaylist(long j11) {
            this.excludeUntilMs = SystemClock.elapsedRealtime() + j11;
            if (!this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl) || DefaultHlsPlaylistTracker.this.maybeSelectNewPrimaryUrl()) {
                return false;
            }
            return true;
        }

        private Uri getMediaPlaylistUriForReload() {
            String str;
            HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
            if (hlsMediaPlaylist != null) {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.serverControl;
                if (serverControl.skipUntilUs != C.TIME_UNSET || serverControl.canBlockReload) {
                    Uri.Builder buildUpon = this.playlistUrl.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.playlistSnapshot;
                    if (hlsMediaPlaylist2.serverControl.canBlockReload) {
                        buildUpon.appendQueryParameter(BLOCK_MSN_PARAM, String.valueOf(hlsMediaPlaylist2.mediaSequence + ((long) hlsMediaPlaylist2.segments.size())));
                        HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
                        if (hlsMediaPlaylist3.partTargetDurationUs != C.TIME_UNSET) {
                            List<HlsMediaPlaylist.Part> list = hlsMediaPlaylist3.trailingParts;
                            int size = list.size();
                            if (!list.isEmpty() && ((HlsMediaPlaylist.Part) Iterables.getLast(list)).isPreload) {
                                size--;
                            }
                            buildUpon.appendQueryParameter(BLOCK_PART_PARAM, String.valueOf(size));
                        }
                    }
                    HlsMediaPlaylist.ServerControl serverControl2 = this.playlistSnapshot.serverControl;
                    if (serverControl2.skipUntilUs != C.TIME_UNSET) {
                        if (serverControl2.canSkipDateRanges) {
                            str = b.f48777t;
                        } else {
                            str = "YES";
                        }
                        buildUpon.appendQueryParameter(SKIP_PARAM, str);
                    }
                    return buildUpon.build();
                }
            }
            return this.playlistUrl;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$loadPlaylistInternal$0(Uri uri) {
            this.loadPending = false;
            loadPlaylistImmediately(uri);
        }

        private void loadPlaylistImmediately(Uri uri) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.mediaPlaylistDataSource, uri, 4, DefaultHlsPlaylistTracker.this.playlistParserFactory.createPlaylistParser(DefaultHlsPlaylistTracker.this.multivariantPlaylist, this.playlistSnapshot));
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.mediaPlaylistLoader.startLoading(parsingLoadable, this, DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
        }

        /* access modifiers changed from: private */
        public void loadPlaylistInternal(Uri uri) {
            this.excludeUntilMs = 0;
            if (!this.loadPending && !this.mediaPlaylistLoader.isLoading() && !this.mediaPlaylistLoader.hasFatalError()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.earliestNextLoadTimeMs) {
                    this.loadPending = true;
                    DefaultHlsPlaylistTracker.this.playlistRefreshHandler.postDelayed(new a(this, uri), this.earliestNextLoadTimeMs - elapsedRealtime);
                    return;
                }
                loadPlaylistImmediately(uri);
            }
        }

        /* access modifiers changed from: private */
        public void processLoadedPlaylist(HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
            long j11;
            boolean z11;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.playlistSnapshot;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.lastSnapshotLoadMs = elapsedRealtime;
            HlsMediaPlaylist access$1400 = DefaultHlsPlaylistTracker.this.getLatestPlaylistSnapshot(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.playlistSnapshot = access$1400;
            boolean z12 = false;
            IOException iOException = null;
            if (access$1400 != hlsMediaPlaylist2) {
                this.playlistError = null;
                this.lastSnapshotChangeMs = elapsedRealtime;
                DefaultHlsPlaylistTracker.this.onPlaylistUpdated(this.playlistUrl, access$1400);
            } else if (!access$1400.hasEndTag) {
                HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
                if (hlsMediaPlaylist.mediaSequence + ((long) hlsMediaPlaylist.segments.size()) < hlsMediaPlaylist3.mediaSequence) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.playlistUrl);
                    z11 = true;
                } else {
                    if (((double) (elapsedRealtime - this.lastSnapshotChangeMs)) > ((double) Util.usToMs(hlsMediaPlaylist3.targetDurationUs)) * DefaultHlsPlaylistTracker.this.playlistStuckTargetDurationCoefficient) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.playlistUrl);
                    }
                    z11 = false;
                }
                if (iOException != null) {
                    this.playlistError = iOException;
                    boolean unused = DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(4), iOException, 1), z11);
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist4 = this.playlistSnapshot;
            if (hlsMediaPlaylist4.serverControl.canBlockReload) {
                j11 = 0;
            } else if (hlsMediaPlaylist4 != hlsMediaPlaylist2) {
                j11 = hlsMediaPlaylist4.targetDurationUs;
            } else {
                j11 = hlsMediaPlaylist4.targetDurationUs / 2;
            }
            this.earliestNextLoadTimeMs = elapsedRealtime + Util.usToMs(j11);
            if (this.playlistSnapshot.partTargetDurationUs != C.TIME_UNSET || this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl)) {
                z12 = true;
            }
            if (z12 && !this.playlistSnapshot.hasEndTag) {
                loadPlaylistInternal(getMediaPlaylistUriForReload());
            }
        }

        @Nullable
        public HlsMediaPlaylist getPlaylistSnapshot() {
            return this.playlistSnapshot;
        }

        public boolean isSnapshotValid() {
            int i11;
            if (this.playlistSnapshot == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000, Util.usToMs(this.playlistSnapshot.durationUs));
            HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
            if (hlsMediaPlaylist.hasEndTag || (i11 = hlsMediaPlaylist.playlistType) == 2 || i11 == 1 || this.lastSnapshotLoadMs + max > elapsedRealtime) {
                return true;
            }
            return false;
        }

        public void loadPlaylist() {
            loadPlaylistInternal(this.playlistUrl);
        }

        public void maybeThrowPlaylistRefreshError() throws IOException {
            this.mediaPlaylistLoader.maybeThrowError();
            IOException iOException = this.playlistError;
            if (iOException != null) {
                throw iOException;
            }
        }

        public void release() {
            this.mediaPlaylistLoader.release();
        }

        public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j11, long j12, boolean z11) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
            DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadCanceled(loadEventInfo, 4);
        }

        public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j11, long j12) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            HlsPlaylist result = parsingLoadable.getResult();
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
            if (result instanceof HlsMediaPlaylist) {
                processLoadedPlaylist((HlsMediaPlaylist) result, loadEventInfo);
                DefaultHlsPlaylistTracker.this.eventDispatcher.loadCompleted(loadEventInfo, 4);
            } else {
                this.playlistError = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", (Throwable) null);
                DefaultHlsPlaylistTracker.this.eventDispatcher.loadError(loadEventInfo, 4, this.playlistError, true);
            }
            DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        }

        public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j11, long j12, IOException iOException, int i11) {
            Loader.LoadErrorAction loadErrorAction;
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            IOException iOException2 = iOException;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
            boolean z11 = iOException2 instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((parsingLoadable.getUri().getQueryParameter(BLOCK_MSN_PARAM) != null) || z11) {
                int i12 = iOException2 instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException2).responseCode : Integer.MAX_VALUE;
                if (z11 || i12 == 400 || i12 == 503) {
                    this.earliestNextLoadTimeMs = SystemClock.elapsedRealtime();
                    loadPlaylist();
                    ((MediaSourceEventListener.EventDispatcher) Util.castNonNull(DefaultHlsPlaylistTracker.this.eventDispatcher)).loadError(loadEventInfo, parsingLoadable2.type, iOException2, true);
                    return Loader.DONT_RETRY;
                }
            }
            LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.type), iOException2, i11);
            if (DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, loadErrorInfo, false)) {
                long retryDelayMsFor = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
                if (retryDelayMsFor != C.TIME_UNSET) {
                    loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
                } else {
                    loadErrorAction = Loader.DONT_RETRY_FATAL;
                }
            } else {
                loadErrorAction = Loader.DONT_RETRY;
            }
            boolean isRetry = true ^ loadErrorAction.isRetry();
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadError(loadEventInfo, parsingLoadable2.type, iOException2, isRetry);
            if (isRetry) {
                DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
            }
            return loadErrorAction;
        }
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy2, hlsPlaylistParserFactory, 3.5d);
    }

    private void createBundles(List<Uri> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Uri uri = list.get(i11);
            this.playlistBundles.put(uri, new MediaPlaylistBundle(uri));
        }
    }

    private static HlsMediaPlaylist.Segment getFirstOldOverlappingSegment(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i11 = (int) (hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence);
        List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
        if (i11 < list.size()) {
            return list.get(i11);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public HlsMediaPlaylist getLatestPlaylistSnapshot(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.isNewerThan(hlsMediaPlaylist)) {
            return hlsMediaPlaylist2.copyWith(getLoadedPlaylistStartTimeUs(hlsMediaPlaylist, hlsMediaPlaylist2), getLoadedPlaylistDiscontinuitySequence(hlsMediaPlaylist, hlsMediaPlaylist2));
        }
        if (hlsMediaPlaylist2.hasEndTag) {
            return hlsMediaPlaylist.copyWithEndTag();
        }
        return hlsMediaPlaylist;
    }

    private int getLoadedPlaylistDiscontinuitySequence(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i11;
        HlsMediaPlaylist.Segment firstOldOverlappingSegment;
        if (hlsMediaPlaylist2.hasDiscontinuitySequence) {
            return hlsMediaPlaylist2.discontinuitySequence;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryMediaPlaylistSnapshot;
        if (hlsMediaPlaylist3 != null) {
            i11 = hlsMediaPlaylist3.discontinuitySequence;
        } else {
            i11 = 0;
        }
        if (hlsMediaPlaylist == null || (firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) {
            return i11;
        }
        return (hlsMediaPlaylist.discontinuitySequence + firstOldOverlappingSegment.relativeDiscontinuitySequence) - hlsMediaPlaylist2.segments.get(0).relativeDiscontinuitySequence;
    }

    private long getLoadedPlaylistStartTimeUs(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        long j11;
        if (hlsMediaPlaylist2.hasProgramDateTime) {
            return hlsMediaPlaylist2.startTimeUs;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryMediaPlaylistSnapshot;
        if (hlsMediaPlaylist3 != null) {
            j11 = hlsMediaPlaylist3.startTimeUs;
        } else {
            j11 = 0;
        }
        if (hlsMediaPlaylist == null) {
            return j11;
        }
        int size = hlsMediaPlaylist.segments.size();
        HlsMediaPlaylist.Segment firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (firstOldOverlappingSegment != null) {
            return hlsMediaPlaylist.startTimeUs + firstOldOverlappingSegment.relativeStartTimeUs;
        }
        if (((long) size) == hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence) {
            return hlsMediaPlaylist.getEndTimeUs();
        }
        return j11;
    }

    private Uri getRequestUriForPrimaryChange(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.primaryMediaPlaylistSnapshot;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.serverControl.canBlockReload || (renditionReport = hlsMediaPlaylist.renditionReports.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.lastMediaSequence));
        int i11 = renditionReport.lastPartIndex;
        if (i11 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i11));
        }
        return buildUpon.build();
    }

    private boolean isVariantUrl(Uri uri) {
        List<HlsMultivariantPlaylist.Variant> list = this.multivariantPlaylist.variants;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (uri.equals(list.get(i11).url)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean maybeSelectNewPrimaryUrl() {
        List<HlsMultivariantPlaylist.Variant> list = this.multivariantPlaylist.variants;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i11 = 0; i11 < size; i11++) {
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) Assertions.checkNotNull(this.playlistBundles.get(list.get(i11).url));
            if (elapsedRealtime > mediaPlaylistBundle.excludeUntilMs) {
                Uri access$400 = mediaPlaylistBundle.playlistUrl;
                this.primaryMediaPlaylistUrl = access$400;
                mediaPlaylistBundle.loadPlaylistInternal(getRequestUriForPrimaryChange(access$400));
                return true;
            }
        }
        return false;
    }

    private void maybeSetPrimaryUrl(Uri uri) {
        if (!uri.equals(this.primaryMediaPlaylistUrl) && isVariantUrl(uri)) {
            HlsMediaPlaylist hlsMediaPlaylist = this.primaryMediaPlaylistSnapshot;
            if (hlsMediaPlaylist == null || !hlsMediaPlaylist.hasEndTag) {
                this.primaryMediaPlaylistUrl = uri;
                MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(uri);
                HlsMediaPlaylist access$600 = mediaPlaylistBundle.playlistSnapshot;
                if (access$600 == null || !access$600.hasEndTag) {
                    mediaPlaylistBundle.loadPlaylistInternal(getRequestUriForPrimaryChange(uri));
                    return;
                }
                this.primaryMediaPlaylistSnapshot = access$600;
                this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(access$600);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean notifyPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z11) {
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it = this.listeners.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            z12 |= !it.next().onPlaylistError(uri, loadErrorInfo, z11);
        }
        return z12;
    }

    /* access modifiers changed from: private */
    public void onPlaylistUpdated(Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.primaryMediaPlaylistUrl)) {
            if (this.primaryMediaPlaylistSnapshot == null) {
                this.isLive = !hlsMediaPlaylist.hasEndTag;
                this.initialStartTimeUs = hlsMediaPlaylist.startTimeUs;
            }
            this.primaryMediaPlaylistSnapshot = hlsMediaPlaylist;
            this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(hlsMediaPlaylist);
        }
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaylistChanged();
        }
    }

    public void addListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        Assertions.checkNotNull(playlistEventListener);
        this.listeners.add(playlistEventListener);
    }

    public boolean excludeMediaPlaylist(Uri uri, long j11) {
        MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(uri);
        if (mediaPlaylistBundle != null) {
            return !mediaPlaylistBundle.excludePlaylist(j11);
        }
        return false;
    }

    public long getInitialStartTimeUs() {
        return this.initialStartTimeUs;
    }

    @Nullable
    public HlsMultivariantPlaylist getMultivariantPlaylist() {
        return this.multivariantPlaylist;
    }

    @Nullable
    public HlsMediaPlaylist getPlaylistSnapshot(Uri uri, boolean z11) {
        HlsMediaPlaylist playlistSnapshot = this.playlistBundles.get(uri).getPlaylistSnapshot();
        if (playlistSnapshot != null && z11) {
            maybeSetPrimaryUrl(uri);
        }
        return playlistSnapshot;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public boolean isSnapshotValid(Uri uri) {
        return this.playlistBundles.get(uri).isSnapshotValid();
    }

    public void maybeThrowPlaylistRefreshError(Uri uri) throws IOException {
        this.playlistBundles.get(uri).maybeThrowPlaylistRefreshError();
    }

    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        Loader loader = this.initialPlaylistLoader;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.primaryMediaPlaylistUrl;
        if (uri != null) {
            maybeThrowPlaylistRefreshError(uri);
        }
    }

    public void refreshPlaylist(Uri uri) {
        this.playlistBundles.get(uri).loadPlaylist();
    }

    public void removeListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.listeners.remove(playlistEventListener);
    }

    public void start(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher2, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener2) {
        boolean z11;
        this.playlistRefreshHandler = Util.createHandlerForCurrentLooper();
        this.eventDispatcher = eventDispatcher2;
        this.primaryPlaylistListener = primaryPlaylistListener2;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.dataSourceFactory.createDataSource(4), uri, 4, this.playlistParserFactory.createPlaylistParser());
        if (this.initialPlaylistLoader == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.initialPlaylistLoader = loader;
        eventDispatcher2.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, loader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
    }

    public void stop() {
        this.primaryMediaPlaylistUrl = null;
        this.primaryMediaPlaylistSnapshot = null;
        this.multivariantPlaylist = null;
        this.initialStartTimeUs = C.TIME_UNSET;
        this.initialPlaylistLoader.release();
        this.initialPlaylistLoader = null;
        for (MediaPlaylistBundle release : this.playlistBundles.values()) {
            release.release();
        }
        this.playlistRefreshHandler.removeCallbacksAndMessages((Object) null);
        this.playlistRefreshHandler = null;
        this.playlistBundles.clear();
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d11) {
        this.dataSourceFactory = hlsDataSourceFactory;
        this.playlistParserFactory = hlsPlaylistParserFactory;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.playlistStuckTargetDurationCoefficient = d11;
        this.listeners = new CopyOnWriteArrayList<>();
        this.playlistBundles = new HashMap<>();
        this.initialStartTimeUs = C.TIME_UNSET;
    }

    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j11, long j12, boolean z11) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.eventDispatcher.loadCanceled(loadEventInfo, 4);
    }

    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j11, long j12) {
        HlsMultivariantPlaylist hlsMultivariantPlaylist;
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        HlsPlaylist result = parsingLoadable.getResult();
        boolean z11 = result instanceof HlsMediaPlaylist;
        if (z11) {
            hlsMultivariantPlaylist = HlsMultivariantPlaylist.createSingleVariantMultivariantPlaylist(result.baseUri);
        } else {
            hlsMultivariantPlaylist = (HlsMultivariantPlaylist) result;
        }
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.primaryMediaPlaylistUrl = hlsMultivariantPlaylist.variants.get(0).url;
        this.listeners.add(new FirstPrimaryMediaPlaylistListener());
        createBundles(hlsMultivariantPlaylist.mediaPlaylistUrls);
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(this.primaryMediaPlaylistUrl);
        if (z11) {
            mediaPlaylistBundle.processLoadedPlaylist((HlsMediaPlaylist) result, loadEventInfo);
        } else {
            mediaPlaylistBundle.loadPlaylist();
        }
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.eventDispatcher.loadCompleted(loadEventInfo, 4);
    }

    public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j11, long j12, IOException iOException, int i11) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.type), iOException2, i11));
        boolean z11 = retryDelayMsFor == C.TIME_UNSET;
        this.eventDispatcher.loadError(loadEventInfo, parsingLoadable2.type, iOException2, z11);
        if (z11) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        }
        if (z11) {
            return Loader.DONT_RETRY_FATAL;
        }
        return Loader.createRetryAction(false, retryDelayMsFor);
    }
}
