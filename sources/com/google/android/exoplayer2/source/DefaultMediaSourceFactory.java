package com.google.android.exoplayer2.source;

import a8.d;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleExtractor;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String TAG = "DMediaSourceFactory";
    @Nullable
    private AdViewProvider adViewProvider;
    @Nullable
    private AdsLoader.Provider adsLoaderProvider;
    private DataSource.Factory dataSourceFactory;
    private final DelegateFactoryLoader delegateFactoryLoader;
    private long liveMaxOffsetMs;
    private float liveMaxSpeed;
    private long liveMinOffsetMs;
    private float liveMinSpeed;
    private long liveTargetOffsetMs;
    @Nullable
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    @Nullable
    private MediaSource.Factory serverSideAdInsertionMediaSourceFactory;
    private boolean useProgressiveMediaSourceForSubtitles;

    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    public static final class DelegateFactoryLoader {
        private DataSource.Factory dataSourceFactory;
        @Nullable
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private final ExtractorsFactory extractorsFactory;
        @Nullable
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final Map<Integer, MediaSource.Factory> mediaSourceFactories = new HashMap();
        private final Map<Integer, Supplier<MediaSource.Factory>> mediaSourceFactorySuppliers = new HashMap();
        private final Set<Integer> supportedTypes = new HashSet();

        public DelegateFactoryLoader(ExtractorsFactory extractorsFactory2) {
            this.extractorsFactory = extractorsFactory2;
        }

        private void ensureAllSuppliersAreLoaded() {
            maybeLoadSupplier(0);
            maybeLoadSupplier(1);
            maybeLoadSupplier(2);
            maybeLoadSupplier(3);
            maybeLoadSupplier(4);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ MediaSource.Factory lambda$maybeLoadSupplier$4(DataSource.Factory factory) {
            return new ProgressiveMediaSource.Factory(factory, this.extractorsFactory);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0079  */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource.Factory> maybeLoadSupplier(int r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.mediaSourceFactorySuppliers
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L_0x0019
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.mediaSourceFactorySuppliers
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                com.google.common.base.Supplier r5 = (com.google.common.base.Supplier) r5
                return r5
            L_0x0019:
                com.google.android.exoplayer2.upstream.DataSource$Factory r0 = r4.dataSourceFactory
                java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
                com.google.android.exoplayer2.upstream.DataSource$Factory r0 = (com.google.android.exoplayer2.upstream.DataSource.Factory) r0
                java.lang.Class<com.google.android.exoplayer2.source.MediaSource$Factory> r1 = com.google.android.exoplayer2.source.MediaSource.Factory.class
                r2 = 0
                if (r5 == 0) goto L_0x0062
                r3 = 1
                if (r5 == r3) goto L_0x0056
                r3 = 2
                if (r5 == r3) goto L_0x004a
                r3 = 3
                if (r5 == r3) goto L_0x003a
                r1 = 4
                if (r5 == r1) goto L_0x0033
                goto L_0x006e
            L_0x0033:
                com.google.android.exoplayer2.source.e r1 = new com.google.android.exoplayer2.source.e     // Catch:{ ClassNotFoundException -> 0x006e }
                r1.<init>(r4, r0)     // Catch:{ ClassNotFoundException -> 0x006e }
            L_0x0038:
                r2 = r1
                goto L_0x006e
            L_0x003a:
                java.lang.String r0 = "com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory"
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x006e }
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x006e }
                com.google.android.exoplayer2.source.d r1 = new com.google.android.exoplayer2.source.d     // Catch:{ ClassNotFoundException -> 0x006e }
                r1.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x006e }
                goto L_0x0038
            L_0x004a:
                java.lang.Class<com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x006e }
                com.google.android.exoplayer2.source.c r3 = new com.google.android.exoplayer2.source.c     // Catch:{ ClassNotFoundException -> 0x006e }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x006e }
                goto L_0x006d
            L_0x0056:
                java.lang.Class<com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x006e }
                com.google.android.exoplayer2.source.b r3 = new com.google.android.exoplayer2.source.b     // Catch:{ ClassNotFoundException -> 0x006e }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x006e }
                goto L_0x006d
            L_0x0062:
                java.lang.Class<com.google.android.exoplayer2.source.dash.DashMediaSource$Factory> r3 = com.google.android.exoplayer2.source.dash.DashMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x006e }
                com.google.android.exoplayer2.source.a r3 = new com.google.android.exoplayer2.source.a     // Catch:{ ClassNotFoundException -> 0x006e }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x006e }
            L_0x006d:
                r2 = r3
            L_0x006e:
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.mediaSourceFactorySuppliers
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L_0x0082
                java.util.Set<java.lang.Integer> r0 = r4.supportedTypes
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L_0x0082:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.DefaultMediaSourceFactory.DelegateFactoryLoader.maybeLoadSupplier(int):com.google.common.base.Supplier");
        }

        @Nullable
        public MediaSource.Factory getMediaSourceFactory(int i11) {
            MediaSource.Factory factory = this.mediaSourceFactories.get(Integer.valueOf(i11));
            if (factory != null) {
                return factory;
            }
            Supplier<MediaSource.Factory> maybeLoadSupplier = maybeLoadSupplier(i11);
            if (maybeLoadSupplier == null) {
                return null;
            }
            MediaSource.Factory factory2 = maybeLoadSupplier.get();
            DrmSessionManagerProvider drmSessionManagerProvider2 = this.drmSessionManagerProvider;
            if (drmSessionManagerProvider2 != null) {
                factory2.setDrmSessionManagerProvider(drmSessionManagerProvider2);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
            if (loadErrorHandlingPolicy2 != null) {
                factory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
            }
            this.mediaSourceFactories.put(Integer.valueOf(i11), factory2);
            return factory2;
        }

        public int[] getSupportedTypes() {
            ensureAllSuppliersAreLoaded();
            return Ints.toArray(this.supportedTypes);
        }

        public void setDataSourceFactory(DataSource.Factory factory) {
            if (factory != this.dataSourceFactory) {
                this.dataSourceFactory = factory;
                this.mediaSourceFactorySuppliers.clear();
                this.mediaSourceFactories.clear();
            }
        }

        public void setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider2) {
            this.drmSessionManagerProvider = drmSessionManagerProvider2;
            for (MediaSource.Factory drmSessionManagerProvider3 : this.mediaSourceFactories.values()) {
                drmSessionManagerProvider3.setDrmSessionManagerProvider(drmSessionManagerProvider2);
            }
        }

        public void setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            for (MediaSource.Factory loadErrorHandlingPolicy3 : this.mediaSourceFactories.values()) {
                loadErrorHandlingPolicy3.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
            }
        }
    }

    public static final class UnknownSubtitlesExtractor implements Extractor {
        private final Format format;

        public UnknownSubtitlesExtractor(Format format2) {
            this.format = format2;
        }

        public void init(ExtractorOutput extractorOutput) {
            TrackOutput track = extractorOutput.track(0, 3);
            extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
            extractorOutput.endTracks();
            track.format(this.format.buildUpon().setSampleMimeType(MimeTypes.TEXT_UNKNOWN).setCodecs(this.format.sampleMimeType).build());
        }

        public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
            return extractorInput.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        public void release() {
        }

        public void seek(long j11, long j12) {
        }

        public boolean sniff(ExtractorInput extractorInput) {
            return true;
        }
    }

    public DefaultMediaSourceFactory(Context context) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$createMediaSource$0(Format format) {
        Extractor extractor;
        Extractor[] extractorArr = new Extractor[1];
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.DEFAULT;
        if (subtitleDecoderFactory.supportsFormat(format)) {
            extractor = new SubtitleExtractor(subtitleDecoderFactory.createDecoder(format), format);
        } else {
            extractor = new UnknownSubtitlesExtractor(format);
        }
        extractorArr[0] = extractor;
        return extractorArr;
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.clippingConfiguration;
        if (clippingConfiguration.startPositionMs == 0 && clippingConfiguration.endPositionMs == Long.MIN_VALUE && !clippingConfiguration.relativeToDefaultPosition) {
            return mediaSource;
        }
        long msToUs = Util.msToUs(mediaItem.clippingConfiguration.startPositionMs);
        long msToUs2 = Util.msToUs(mediaItem.clippingConfiguration.endPositionMs);
        MediaItem.ClippingConfiguration clippingConfiguration2 = mediaItem.clippingConfiguration;
        return new ClippingMediaSource(mediaSource, msToUs, msToUs2, !clippingConfiguration2.startsAtKeyFrame, clippingConfiguration2.relativeToLiveWindow, clippingConfiguration2.relativeToDefaultPosition);
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        ImmutableList immutableList;
        Assertions.checkNotNull(mediaItem.localConfiguration);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.localConfiguration.adsConfiguration;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoader.Provider provider = this.adsLoaderProvider;
        AdViewProvider adViewProvider2 = this.adViewProvider;
        if (provider == null || adViewProvider2 == null) {
            Log.w(TAG, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = provider.getAdsLoader(adsConfiguration);
        if (adsLoader == null) {
            Log.w(TAG, "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(adsConfiguration.adTagUri);
        Object obj = adsConfiguration.adsId;
        if (obj != null) {
            immutableList = obj;
        } else {
            immutableList = ImmutableList.of(mediaItem.mediaId, mediaItem.localConfiguration.uri, adsConfiguration.adTagUri);
        }
        return new AdsMediaSource(mediaSource, dataSpec, immutableList, this, adsLoader, adViewProvider2);
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory newInstance(Class<? extends MediaSource.Factory> cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory});
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory clearLocalAdInsertionComponents() {
        this.adsLoaderProvider = null;
        this.adViewProvider = null;
        return this;
    }

    public MediaSource createMediaSource(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        String scheme = mediaItem.localConfiguration.uri.getScheme();
        if (scheme != null && scheme.equals(C.SSAI_SCHEME)) {
            return ((MediaSource.Factory) Assertions.checkNotNull(this.serverSideAdInsertionMediaSourceFactory)).createMediaSource(mediaItem);
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
        MediaSource.Factory mediaSourceFactory = this.delegateFactoryLoader.getMediaSourceFactory(inferContentTypeForUriAndMimeType);
        Assertions.checkStateNotNull(mediaSourceFactory, "No suitable media source factory found for content type: " + inferContentTypeForUriAndMimeType);
        MediaItem.LiveConfiguration.Builder buildUpon = mediaItem.liveConfiguration.buildUpon();
        if (mediaItem.liveConfiguration.targetOffsetMs == C.TIME_UNSET) {
            buildUpon.setTargetOffsetMs(this.liveTargetOffsetMs);
        }
        if (mediaItem.liveConfiguration.minPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMinPlaybackSpeed(this.liveMinSpeed);
        }
        if (mediaItem.liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMaxPlaybackSpeed(this.liveMaxSpeed);
        }
        if (mediaItem.liveConfiguration.minOffsetMs == C.TIME_UNSET) {
            buildUpon.setMinOffsetMs(this.liveMinOffsetMs);
        }
        if (mediaItem.liveConfiguration.maxOffsetMs == C.TIME_UNSET) {
            buildUpon.setMaxOffsetMs(this.liveMaxOffsetMs);
        }
        MediaItem.LiveConfiguration build = buildUpon.build();
        if (!build.equals(mediaItem.liveConfiguration)) {
            mediaItem = mediaItem.buildUpon().setLiveConfiguration(build).build();
        }
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        ImmutableList<MediaItem.SubtitleConfiguration> immutableList = ((MediaItem.LocalConfiguration) Util.castNonNull(mediaItem.localConfiguration)).subtitleConfigurations;
        if (!immutableList.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(immutableList.size() + 1)];
            mediaSourceArr[0] = createMediaSource;
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                if (this.useProgressiveMediaSourceForSubtitles) {
                    ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.dataSourceFactory, (ExtractorsFactory) new d(new Format.Builder().setSampleMimeType(immutableList.get(i11).mimeType).setLanguage(immutableList.get(i11).language).setSelectionFlags(immutableList.get(i11).selectionFlags).setRoleFlags(immutableList.get(i11).roleFlags).setLabel(immutableList.get(i11).label).setId(immutableList.get(i11).f34902id).build()));
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
                    if (loadErrorHandlingPolicy2 != null) {
                        factory.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
                    }
                    mediaSourceArr[i11 + 1] = factory.createMediaSource(MediaItem.fromUri(immutableList.get(i11).uri.toString()));
                } else {
                    SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.dataSourceFactory);
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy3 = this.loadErrorHandlingPolicy;
                    if (loadErrorHandlingPolicy3 != null) {
                        factory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy3);
                    }
                    mediaSourceArr[i11 + 1] = factory2.createMediaSource(immutableList.get(i11), C.TIME_UNSET);
                }
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        return maybeWrapWithAdsMediaSource(mediaItem, maybeClipMediaSource(mediaItem, createMediaSource));
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory experimentalUseProgressiveMediaSourceForSubtitles(boolean z11) {
        this.useProgressiveMediaSourceForSubtitles = z11;
        return this;
    }

    public int[] getSupportedTypes() {
        return this.delegateFactoryLoader.getSupportedTypes();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public DefaultMediaSourceFactory setAdViewProvider(@Nullable AdViewProvider adViewProvider2) {
        this.adViewProvider = adViewProvider2;
        return this;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public DefaultMediaSourceFactory setAdsLoaderProvider(@Nullable AdsLoader.Provider provider) {
        this.adsLoaderProvider = provider;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setDataSourceFactory(DataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.delegateFactoryLoader.setDataSourceFactory(factory);
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long j11) {
        this.liveMaxOffsetMs = j11;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setLiveMaxSpeed(float f11) {
        this.liveMaxSpeed = f11;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setLiveMinOffsetMs(long j11) {
        this.liveMinOffsetMs = j11;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setLiveMinSpeed(float f11) {
        this.liveMinSpeed = f11;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long j11) {
        this.liveTargetOffsetMs = j11;
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setLocalAdInsertionComponents(AdsLoader.Provider provider, AdViewProvider adViewProvider2) {
        this.adsLoaderProvider = (AdsLoader.Provider) Assertions.checkNotNull(provider);
        this.adViewProvider = (AdViewProvider) Assertions.checkNotNull(adViewProvider2);
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setServerSideAdInsertionMediaSourceFactory(@Nullable MediaSource.Factory factory) {
        this.serverSideAdInsertionMediaSourceFactory = factory;
        return this;
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context), extractorsFactory);
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.delegateFactoryLoader.setDrmSessionManagerProvider((DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
        this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy2, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.delegateFactoryLoader.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
        return this;
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory newInstance(Class<? extends MediaSource.Factory> cls) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        DelegateFactoryLoader delegateFactoryLoader2 = new DelegateFactoryLoader(extractorsFactory);
        this.delegateFactoryLoader = delegateFactoryLoader2;
        delegateFactoryLoader2.setDataSourceFactory(factory);
        this.liveTargetOffsetMs = C.TIME_UNSET;
        this.liveMinOffsetMs = C.TIME_UNSET;
        this.liveMaxOffsetMs = C.TIME_UNSET;
        this.liveMinSpeed = -3.4028235E38f;
        this.liveMaxSpeed = -3.4028235E38f;
    }
}
