package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import b8.c;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final MediaSource.MediaPeriodId CHILD_SOURCE_MEDIA_PERIOD_ID = new MediaSource.MediaPeriodId(new Object());
    private final MediaSource.Factory adMediaSourceFactory;
    private AdMediaSourceHolder[][] adMediaSourceHolders = new AdMediaSourceHolder[0][];
    @Nullable
    private AdPlaybackState adPlaybackState;
    private final DataSpec adTagDataSpec;
    private final AdViewProvider adViewProvider;
    private final Object adsId;
    /* access modifiers changed from: private */
    public final AdsLoader adsLoader;
    @Nullable
    private ComponentListener componentListener;
    private final MediaSource contentMediaSource;
    @Nullable
    private Timeline contentTimeline;
    /* access modifiers changed from: private */
    public final Handler mainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Timeline.Period period = new Timeline.Period();

    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private AdLoadException(int i11, Exception exc) {
            super(exc);
            this.type = i11;
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i11) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i11, exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            boolean z11;
            if (this.type == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
            return (RuntimeException) Assertions.checkNotNull(getCause());
        }
    }

    public final class AdMediaSourceHolder {
        private final List<MaskingMediaPeriod> activeMediaPeriods = new ArrayList();
        private MediaSource adMediaSource;
        private Uri adUri;

        /* renamed from: id  reason: collision with root package name */
        private final MediaSource.MediaPeriodId f35003id;
        private Timeline timeline;

        public AdMediaSourceHolder(MediaSource.MediaPeriodId mediaPeriodId) {
            this.f35003id = mediaPeriodId;
        }

        public MediaPeriod createMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j11);
            this.activeMediaPeriods.add(maskingMediaPeriod);
            MediaSource mediaSource = this.adMediaSource;
            if (mediaSource != null) {
                maskingMediaPeriod.setMediaSource(mediaSource);
                maskingMediaPeriod.setPrepareListener(new AdPrepareListener((Uri) Assertions.checkNotNull(this.adUri)));
            }
            Timeline timeline2 = this.timeline;
            if (timeline2 != null) {
                maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(timeline2.getUidOfPeriod(0), mediaPeriodId.windowSequenceNumber));
            }
            return maskingMediaPeriod;
        }

        public long getDurationUs() {
            Timeline timeline2 = this.timeline;
            if (timeline2 == null) {
                return C.TIME_UNSET;
            }
            return timeline2.getPeriod(0, AdsMediaSource.this.period).getDurationUs();
        }

        public void handleSourceInfoRefresh(Timeline timeline2) {
            boolean z11 = true;
            if (timeline2.getPeriodCount() != 1) {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            if (this.timeline == null) {
                Object uidOfPeriod = timeline2.getUidOfPeriod(0);
                for (int i11 = 0; i11 < this.activeMediaPeriods.size(); i11++) {
                    MaskingMediaPeriod maskingMediaPeriod = this.activeMediaPeriods.get(i11);
                    maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(uidOfPeriod, maskingMediaPeriod.f34998id.windowSequenceNumber));
                }
            }
            this.timeline = timeline2;
        }

        public boolean hasMediaSource() {
            return this.adMediaSource != null;
        }

        public void initializeWithMediaSource(MediaSource mediaSource, Uri uri) {
            this.adMediaSource = mediaSource;
            this.adUri = uri;
            for (int i11 = 0; i11 < this.activeMediaPeriods.size(); i11++) {
                MaskingMediaPeriod maskingMediaPeriod = this.activeMediaPeriods.get(i11);
                maskingMediaPeriod.setMediaSource(mediaSource);
                maskingMediaPeriod.setPrepareListener(new AdPrepareListener(uri));
            }
            AdsMediaSource.this.prepareChildSource(this.f35003id, mediaSource);
        }

        public boolean isInactive() {
            return this.activeMediaPeriods.isEmpty();
        }

        public void release() {
            if (hasMediaSource()) {
                AdsMediaSource.this.releaseChildSource(this.f35003id);
            }
        }

        public void releaseMediaPeriod(MaskingMediaPeriod maskingMediaPeriod) {
            this.activeMediaPeriods.remove(maskingMediaPeriod);
            maskingMediaPeriod.releasePeriod();
        }
    }

    public final class AdPrepareListener implements MaskingMediaPeriod.PrepareListener {
        private final Uri adUri;

        public AdPrepareListener(Uri uri) {
            this.adUri = uri;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrepareComplete$0(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.adsLoader.handlePrepareComplete(AdsMediaSource.this, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrepareError$1(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.adsLoader.handlePrepareError(AdsMediaSource.this, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, iOException);
        }

        public void onPrepareComplete(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.mainHandler.post(new c(this, mediaPeriodId));
        }

        public void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), new DataSpec(this.adUri), SystemClock.elapsedRealtime()), 6, (IOException) AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.mainHandler.post(new d(this, mediaPeriodId, iOException));
        }
    }

    public final class ComponentListener implements AdsLoader.EventListener {
        private final Handler playerHandler = Util.createHandlerForCurrentLooper();
        private volatile boolean stopped;

        public ComponentListener() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onAdPlaybackState$0(AdPlaybackState adPlaybackState) {
            if (!this.stopped) {
                AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
            }
        }

        public /* synthetic */ void onAdClicked() {
            c.a(this);
        }

        public void onAdLoadError(AdLoadException adLoadException, DataSpec dataSpec) {
            if (!this.stopped) {
                AdsMediaSource.this.createEventDispatcher((MediaSource.MediaPeriodId) null).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), dataSpec, SystemClock.elapsedRealtime()), 6, (IOException) adLoadException, true);
            }
        }

        public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
            if (!this.stopped) {
                this.playerHandler.post(new e(this, adPlaybackState));
            }
        }

        public /* synthetic */ void onAdTapped() {
            c.d(this);
        }

        public void stop() {
            this.stopped = true;
            this.playerHandler.removeCallbacksAndMessages((Object) null);
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader2, AdViewProvider adViewProvider2) {
        this.contentMediaSource = mediaSource;
        this.adMediaSourceFactory = factory;
        this.adsLoader = adsLoader2;
        this.adViewProvider = adViewProvider2;
        this.adTagDataSpec = dataSpec;
        this.adsId = obj;
        adsLoader2.setSupportedContentTypes(factory.getSupportedTypes());
    }

    private long[][] getAdDurationsUs() {
        long j11;
        long[][] jArr = new long[this.adMediaSourceHolders.length][];
        int i11 = 0;
        while (true) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.adMediaSourceHolders;
            if (i11 >= adMediaSourceHolderArr.length) {
                return jArr;
            }
            jArr[i11] = new long[adMediaSourceHolderArr[i11].length];
            int i12 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.adMediaSourceHolders[i11];
                if (i12 >= adMediaSourceHolderArr2.length) {
                    break;
                }
                AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i12];
                long[] jArr2 = jArr[i11];
                if (adMediaSourceHolder == null) {
                    j11 = C.TIME_UNSET;
                } else {
                    j11 = adMediaSourceHolder.getDurationUs();
                }
                jArr2[i12] = j11;
                i12++;
            }
            i11++;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSourceInternal$0(ComponentListener componentListener2) {
        this.adsLoader.start(this, this.adTagDataSpec, this.adsId, this.adViewProvider, componentListener2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseSourceInternal$1(ComponentListener componentListener2) {
        this.adsLoader.stop(this, componentListener2);
    }

    private void maybeUpdateAdMediaSources() {
        Uri uri;
        AdPlaybackState adPlaybackState2 = this.adPlaybackState;
        if (adPlaybackState2 != null) {
            for (int i11 = 0; i11 < this.adMediaSourceHolders.length; i11++) {
                int i12 = 0;
                while (true) {
                    AdMediaSourceHolder[] adMediaSourceHolderArr = this.adMediaSourceHolders[i11];
                    if (i12 >= adMediaSourceHolderArr.length) {
                        break;
                    }
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr[i12];
                    AdPlaybackState.AdGroup adGroup = adPlaybackState2.getAdGroup(i11);
                    if (adMediaSourceHolder != null && !adMediaSourceHolder.hasMediaSource()) {
                        Uri[] uriArr = adGroup.uris;
                        if (i12 < uriArr.length && (uri = uriArr[i12]) != null) {
                            MediaItem.Builder uri2 = new MediaItem.Builder().setUri(uri);
                            MediaItem.LocalConfiguration localConfiguration = this.contentMediaSource.getMediaItem().localConfiguration;
                            if (localConfiguration != null) {
                                uri2.setDrmConfiguration(localConfiguration.drmConfiguration);
                            }
                            adMediaSourceHolder.initializeWithMediaSource(this.adMediaSourceFactory.createMediaSource(uri2.build()), uri);
                        }
                    }
                    i12++;
                }
            }
        }
    }

    private void maybeUpdateSourceInfo() {
        Timeline timeline = this.contentTimeline;
        AdPlaybackState adPlaybackState2 = this.adPlaybackState;
        if (adPlaybackState2 != null && timeline != null) {
            if (adPlaybackState2.adGroupCount == 0) {
                refreshSourceInfo(timeline);
                return;
            }
            this.adPlaybackState = adPlaybackState2.withAdDurationsUs(getAdDurationsUs());
            refreshSourceInfo(new SinglePeriodAdTimeline(timeline, this.adPlaybackState));
        }
    }

    /* access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState2) {
        AdPlaybackState adPlaybackState3 = this.adPlaybackState;
        boolean z11 = false;
        if (adPlaybackState3 == null) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = new AdMediaSourceHolder[adPlaybackState2.adGroupCount][];
            this.adMediaSourceHolders = adMediaSourceHolderArr;
            Arrays.fill(adMediaSourceHolderArr, new AdMediaSourceHolder[0]);
        } else {
            if (adPlaybackState2.adGroupCount == adPlaybackState3.adGroupCount) {
                z11 = true;
            }
            Assertions.checkState(z11);
        }
        this.adPlaybackState = adPlaybackState2;
        maybeUpdateAdMediaSources();
        maybeUpdateSourceInfo();
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        if (((AdPlaybackState) Assertions.checkNotNull(this.adPlaybackState)).adGroupCount <= 0 || !mediaPeriodId.isAd()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j11);
            maskingMediaPeriod.setMediaSource(this.contentMediaSource);
            maskingMediaPeriod.createPeriod(mediaPeriodId);
            return maskingMediaPeriod;
        }
        int i11 = mediaPeriodId.adGroupIndex;
        int i12 = mediaPeriodId.adIndexInAdGroup;
        AdMediaSourceHolder[][] adMediaSourceHolderArr = this.adMediaSourceHolders;
        AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i11];
        if (adMediaSourceHolderArr2.length <= i12) {
            adMediaSourceHolderArr[i11] = (AdMediaSourceHolder[]) Arrays.copyOf(adMediaSourceHolderArr2, i12 + 1);
        }
        AdMediaSourceHolder adMediaSourceHolder = this.adMediaSourceHolders[i11][i12];
        if (adMediaSourceHolder == null) {
            adMediaSourceHolder = new AdMediaSourceHolder(mediaPeriodId);
            this.adMediaSourceHolders[i11][i12] = adMediaSourceHolder;
            maybeUpdateAdMediaSources();
        }
        return adMediaSourceHolder.createMediaPeriod(mediaPeriodId, allocator, j11);
    }

    public MediaItem getMediaItem() {
        return this.contentMediaSource.getMediaItem();
    }

    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        ComponentListener componentListener2 = new ComponentListener();
        this.componentListener = componentListener2;
        prepareChildSource(CHILD_SOURCE_MEDIA_PERIOD_ID, this.contentMediaSource);
        this.mainHandler.post(new b(this, componentListener2));
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.f34998id;
        if (mediaPeriodId.isAd()) {
            AdMediaSourceHolder adMediaSourceHolder = (AdMediaSourceHolder) Assertions.checkNotNull(this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup]);
            adMediaSourceHolder.releaseMediaPeriod(maskingMediaPeriod);
            if (adMediaSourceHolder.isInactive()) {
                adMediaSourceHolder.release();
                this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup] = null;
                return;
            }
            return;
        }
        maskingMediaPeriod.releasePeriod();
    }

    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        ComponentListener componentListener2 = (ComponentListener) Assertions.checkNotNull(this.componentListener);
        this.componentListener = null;
        componentListener2.stop();
        this.contentTimeline = null;
        this.adPlaybackState = null;
        this.adMediaSourceHolders = new AdMediaSourceHolder[0][];
        this.mainHandler.post(new a(this, componentListener2));
    }

    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    public void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline) {
        if (mediaPeriodId.isAd()) {
            int i11 = mediaPeriodId.adGroupIndex;
            ((AdMediaSourceHolder) Assertions.checkNotNull(this.adMediaSourceHolders[i11][mediaPeriodId.adIndexInAdGroup])).handleSourceInfoRefresh(timeline);
        } else {
            boolean z11 = true;
            if (timeline.getPeriodCount() != 1) {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            this.contentTimeline = timeline;
        }
        maybeUpdateSourceInfo();
    }
}
