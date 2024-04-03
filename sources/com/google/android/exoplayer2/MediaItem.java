package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import g7.p0;
import g7.q0;
import g7.r0;
import g7.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MediaItem implements Bundleable {
    public static final Bundleable.Creator<MediaItem> CREATOR = new p0();
    public static final String DEFAULT_MEDIA_ID = "";
    public static final MediaItem EMPTY = new Builder().build();
    private static final String FIELD_CLIPPING_PROPERTIES = Util.intToStringMaxRadix(3);
    private static final String FIELD_LIVE_CONFIGURATION = Util.intToStringMaxRadix(1);
    private static final String FIELD_MEDIA_ID = Util.intToStringMaxRadix(0);
    private static final String FIELD_MEDIA_METADATA = Util.intToStringMaxRadix(2);
    private static final String FIELD_REQUEST_METADATA = Util.intToStringMaxRadix(4);
    public final ClippingConfiguration clippingConfiguration;
    @Deprecated
    public final ClippingProperties clippingProperties;
    public final LiveConfiguration liveConfiguration;
    @Nullable
    public final LocalConfiguration localConfiguration;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    @Deprecated
    @Nullable
    public final PlaybackProperties playbackProperties;
    public final RequestMetadata requestMetadata;

    public static final class AdsConfiguration {
        public final Uri adTagUri;
        @Nullable
        public final Object adsId;

        public static final class Builder {
            /* access modifiers changed from: private */
            public Uri adTagUri;
            /* access modifiers changed from: private */
            @Nullable
            public Object adsId;

            public Builder(Uri uri) {
                this.adTagUri = uri;
            }

            public AdsConfiguration build() {
                return new AdsConfiguration(this);
            }

            @CanIgnoreReturnValue
            public Builder setAdTagUri(Uri uri) {
                this.adTagUri = uri;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAdsId(@Nullable Object obj) {
                this.adsId = obj;
                return this;
            }
        }

        public Builder buildUpon() {
            return new Builder(this.adTagUri).setAdsId(this.adsId);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration)) {
                return false;
            }
            AdsConfiguration adsConfiguration = (AdsConfiguration) obj;
            if (!this.adTagUri.equals(adsConfiguration.adTagUri) || !Util.areEqual(this.adsId, adsConfiguration.adsId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i11;
            int hashCode = this.adTagUri.hashCode() * 31;
            Object obj = this.adsId;
            if (obj != null) {
                i11 = obj.hashCode();
            } else {
                i11 = 0;
            }
            return hashCode + i11;
        }

        private AdsConfiguration(Builder builder) {
            this.adTagUri = builder.adTagUri;
            this.adsId = builder.adsId;
        }
    }

    public static final class Builder {
        @Nullable
        private AdsConfiguration adsConfiguration;
        private ClippingConfiguration.Builder clippingConfiguration;
        @Nullable
        private String customCacheKey;
        private DrmConfiguration.Builder drmConfiguration;
        private LiveConfiguration.Builder liveConfiguration;
        @Nullable
        private String mediaId;
        @Nullable
        private MediaMetadata mediaMetadata;
        @Nullable
        private String mimeType;
        private RequestMetadata requestMetadata;
        private List<StreamKey> streamKeys;
        private ImmutableList<SubtitleConfiguration> subtitleConfigurations;
        @Nullable
        private Object tag;
        @Nullable
        private Uri uri;

        public MediaItem build() {
            boolean z11;
            PlaybackProperties playbackProperties;
            if (this.drmConfiguration.licenseUri == null || this.drmConfiguration.scheme != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
            Uri uri2 = this.uri;
            DrmConfiguration drmConfiguration2 = null;
            if (uri2 != null) {
                String str = this.mimeType;
                if (this.drmConfiguration.scheme != null) {
                    drmConfiguration2 = this.drmConfiguration.build();
                }
                playbackProperties = new PlaybackProperties(uri2, str, drmConfiguration2, this.adsConfiguration, this.streamKeys, this.customCacheKey, this.subtitleConfigurations, this.tag);
            } else {
                playbackProperties = null;
            }
            String str2 = this.mediaId;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties buildClippingProperties = this.clippingConfiguration.buildClippingProperties();
            LiveConfiguration build = this.liveConfiguration.build();
            MediaMetadata mediaMetadata2 = this.mediaMetadata;
            if (mediaMetadata2 == null) {
                mediaMetadata2 = MediaMetadata.EMPTY;
            }
            return new MediaItem(str3, buildClippingProperties, playbackProperties, build, mediaMetadata2, this.requestMetadata);
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setAdTagUri(@Nullable String str) {
            return setAdTagUri(str != null ? Uri.parse(str) : null);
        }

        @CanIgnoreReturnValue
        public Builder setAdsConfiguration(@Nullable AdsConfiguration adsConfiguration2) {
            this.adsConfiguration = adsConfiguration2;
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setClipEndPositionMs(long j11) {
            this.clippingConfiguration.setEndPositionMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setClipRelativeToDefaultPosition(boolean z11) {
            this.clippingConfiguration.setRelativeToDefaultPosition(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setClipRelativeToLiveWindow(boolean z11) {
            this.clippingConfiguration.setRelativeToLiveWindow(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setClipStartPositionMs(@IntRange(from = 0) long j11) {
            this.clippingConfiguration.setStartPositionMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setClipStartsAtKeyFrame(boolean z11) {
            this.clippingConfiguration.setStartsAtKeyFrame(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setClippingConfiguration(ClippingConfiguration clippingConfiguration2) {
            this.clippingConfiguration = clippingConfiguration2.buildUpon();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCustomCacheKey(@Nullable String str) {
            this.customCacheKey = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDrmConfiguration(@Nullable DrmConfiguration drmConfiguration2) {
            this.drmConfiguration = drmConfiguration2 != null ? drmConfiguration2.buildUpon() : new DrmConfiguration.Builder();
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmForceDefaultLicenseUri(boolean z11) {
            this.drmConfiguration.setForceDefaultLicenseUri(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmKeySetId(@Nullable byte[] bArr) {
            this.drmConfiguration.setKeySetId(bArr);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmLicenseRequestHeaders(@Nullable Map<String, String> map) {
            DrmConfiguration.Builder builder = this.drmConfiguration;
            if (map == null) {
                map = ImmutableMap.of();
            }
            builder.setLicenseRequestHeaders(map);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmLicenseUri(@Nullable Uri uri2) {
            this.drmConfiguration.setLicenseUri(uri2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmMultiSession(boolean z11) {
            this.drmConfiguration.setMultiSession(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmPlayClearContentWithoutKey(boolean z11) {
            this.drmConfiguration.setPlayClearContentWithoutKey(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmSessionForClearPeriods(boolean z11) {
            this.drmConfiguration.setForceSessionsForAudioAndVideoTracks(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmSessionForClearTypes(@Nullable List<Integer> list) {
            DrmConfiguration.Builder builder = this.drmConfiguration;
            if (list == null) {
                list = ImmutableList.of();
            }
            builder.setForcedSessionTrackTypes(list);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmUuid(@Nullable UUID uuid) {
            DrmConfiguration.Builder unused = this.drmConfiguration.setNullableScheme(uuid);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setLiveConfiguration(LiveConfiguration liveConfiguration2) {
            this.liveConfiguration = liveConfiguration2.buildUpon();
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLiveMaxOffsetMs(long j11) {
            this.liveConfiguration.setMaxOffsetMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLiveMaxPlaybackSpeed(float f11) {
            this.liveConfiguration.setMaxPlaybackSpeed(f11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLiveMinOffsetMs(long j11) {
            this.liveConfiguration.setMinOffsetMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLiveMinPlaybackSpeed(float f11) {
            this.liveConfiguration.setMinPlaybackSpeed(f11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setLiveTargetOffsetMs(long j11) {
            this.liveConfiguration.setTargetOffsetMs(j11);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaId(String str) {
            this.mediaId = (String) Assertions.checkNotNull(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaMetadata(MediaMetadata mediaMetadata2) {
            this.mediaMetadata = mediaMetadata2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMimeType(@Nullable String str) {
            this.mimeType = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRequestMetadata(RequestMetadata requestMetadata2) {
            this.requestMetadata = requestMetadata2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setStreamKeys(@Nullable List<StreamKey> list) {
            List<StreamKey> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.streamKeys = list2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSubtitleConfigurations(List<SubtitleConfiguration> list) {
            this.subtitleConfigurations = ImmutableList.copyOf(list);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setSubtitles(@Nullable List<Subtitle> list) {
            this.subtitleConfigurations = list != null ? ImmutableList.copyOf(list) : ImmutableList.of();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUri(@Nullable String str) {
            return setUri(str == null ? null : Uri.parse(str));
        }

        public Builder() {
            this.clippingConfiguration = new ClippingConfiguration.Builder();
            this.drmConfiguration = new DrmConfiguration.Builder();
            this.streamKeys = Collections.emptyList();
            this.subtitleConfigurations = ImmutableList.of();
            this.liveConfiguration = new LiveConfiguration.Builder();
            this.requestMetadata = RequestMetadata.EMPTY;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setAdTagUri(@Nullable Uri uri2) {
            return setAdTagUri(uri2, (Object) null);
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDrmLicenseUri(@Nullable String str) {
            this.drmConfiguration.setLicenseUri(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUri(@Nullable Uri uri2) {
            this.uri = uri2;
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setAdTagUri(@Nullable Uri uri2, @Nullable Object obj) {
            this.adsConfiguration = uri2 != null ? new AdsConfiguration.Builder(uri2).setAdsId(obj).build() : null;
            return this;
        }

        private Builder(MediaItem mediaItem) {
            this();
            DrmConfiguration.Builder builder;
            this.clippingConfiguration = mediaItem.clippingConfiguration.buildUpon();
            this.mediaId = mediaItem.mediaId;
            this.mediaMetadata = mediaItem.mediaMetadata;
            this.liveConfiguration = mediaItem.liveConfiguration.buildUpon();
            this.requestMetadata = mediaItem.requestMetadata;
            LocalConfiguration localConfiguration = mediaItem.localConfiguration;
            if (localConfiguration != null) {
                this.customCacheKey = localConfiguration.customCacheKey;
                this.mimeType = localConfiguration.mimeType;
                this.uri = localConfiguration.uri;
                this.streamKeys = localConfiguration.streamKeys;
                this.subtitleConfigurations = localConfiguration.subtitleConfigurations;
                this.tag = localConfiguration.tag;
                DrmConfiguration drmConfiguration2 = localConfiguration.drmConfiguration;
                if (drmConfiguration2 != null) {
                    builder = drmConfiguration2.buildUpon();
                } else {
                    builder = new DrmConfiguration.Builder();
                }
                this.drmConfiguration = builder;
                this.adsConfiguration = localConfiguration.adsConfiguration;
            }
        }
    }

    public static class ClippingConfiguration implements Bundleable {
        public static final Bundleable.Creator<ClippingProperties> CREATOR = new q0();
        private static final String FIELD_END_POSITION_MS = Util.intToStringMaxRadix(1);
        private static final String FIELD_RELATIVE_TO_DEFAULT_POSITION = Util.intToStringMaxRadix(3);
        private static final String FIELD_RELATIVE_TO_LIVE_WINDOW = Util.intToStringMaxRadix(2);
        private static final String FIELD_STARTS_AT_KEY_FRAME = Util.intToStringMaxRadix(4);
        private static final String FIELD_START_POSITION_MS = Util.intToStringMaxRadix(0);
        public static final ClippingConfiguration UNSET = new Builder().build();
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        @IntRange(from = 0)
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        public static final class Builder {
            /* access modifiers changed from: private */
            public long endPositionMs;
            /* access modifiers changed from: private */
            public boolean relativeToDefaultPosition;
            /* access modifiers changed from: private */
            public boolean relativeToLiveWindow;
            /* access modifiers changed from: private */
            public long startPositionMs;
            /* access modifiers changed from: private */
            public boolean startsAtKeyFrame;

            public ClippingConfiguration build() {
                return buildClippingProperties();
            }

            @Deprecated
            public ClippingProperties buildClippingProperties() {
                return new ClippingProperties(this);
            }

            @CanIgnoreReturnValue
            public Builder setEndPositionMs(long j11) {
                boolean z11;
                if (j11 == Long.MIN_VALUE || j11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkArgument(z11);
                this.endPositionMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRelativeToDefaultPosition(boolean z11) {
                this.relativeToDefaultPosition = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRelativeToLiveWindow(boolean z11) {
                this.relativeToLiveWindow = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setStartPositionMs(@IntRange(from = 0) long j11) {
                boolean z11;
                if (j11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkArgument(z11);
                this.startPositionMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setStartsAtKeyFrame(boolean z11) {
                this.startsAtKeyFrame = z11;
                return this;
            }

            public Builder() {
                this.endPositionMs = Long.MIN_VALUE;
            }

            private Builder(ClippingConfiguration clippingConfiguration) {
                this.startPositionMs = clippingConfiguration.startPositionMs;
                this.endPositionMs = clippingConfiguration.endPositionMs;
                this.relativeToLiveWindow = clippingConfiguration.relativeToLiveWindow;
                this.relativeToDefaultPosition = clippingConfiguration.relativeToDefaultPosition;
                this.startsAtKeyFrame = clippingConfiguration.startsAtKeyFrame;
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ClippingProperties lambda$static$0(Bundle bundle) {
            Builder builder = new Builder();
            String str = FIELD_START_POSITION_MS;
            ClippingConfiguration clippingConfiguration = UNSET;
            return builder.setStartPositionMs(bundle.getLong(str, clippingConfiguration.startPositionMs)).setEndPositionMs(bundle.getLong(FIELD_END_POSITION_MS, clippingConfiguration.endPositionMs)).setRelativeToLiveWindow(bundle.getBoolean(FIELD_RELATIVE_TO_LIVE_WINDOW, clippingConfiguration.relativeToLiveWindow)).setRelativeToDefaultPosition(bundle.getBoolean(FIELD_RELATIVE_TO_DEFAULT_POSITION, clippingConfiguration.relativeToDefaultPosition)).setStartsAtKeyFrame(bundle.getBoolean(FIELD_STARTS_AT_KEY_FRAME, clippingConfiguration.startsAtKeyFrame)).buildClippingProperties();
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            if (this.startPositionMs == clippingConfiguration.startPositionMs && this.endPositionMs == clippingConfiguration.endPositionMs && this.relativeToLiveWindow == clippingConfiguration.relativeToLiveWindow && this.relativeToDefaultPosition == clippingConfiguration.relativeToDefaultPosition && this.startsAtKeyFrame == clippingConfiguration.startsAtKeyFrame) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j11 = this.startPositionMs;
            long j12 = this.endPositionMs;
            return (((((((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) ((j12 >>> 32) ^ j12))) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j11 = this.startPositionMs;
            ClippingConfiguration clippingConfiguration = UNSET;
            if (j11 != clippingConfiguration.startPositionMs) {
                bundle.putLong(FIELD_START_POSITION_MS, j11);
            }
            long j12 = this.endPositionMs;
            if (j12 != clippingConfiguration.endPositionMs) {
                bundle.putLong(FIELD_END_POSITION_MS, j12);
            }
            boolean z11 = this.relativeToLiveWindow;
            if (z11 != clippingConfiguration.relativeToLiveWindow) {
                bundle.putBoolean(FIELD_RELATIVE_TO_LIVE_WINDOW, z11);
            }
            boolean z12 = this.relativeToDefaultPosition;
            if (z12 != clippingConfiguration.relativeToDefaultPosition) {
                bundle.putBoolean(FIELD_RELATIVE_TO_DEFAULT_POSITION, z12);
            }
            boolean z13 = this.startsAtKeyFrame;
            if (z13 != clippingConfiguration.startsAtKeyFrame) {
                bundle.putBoolean(FIELD_STARTS_AT_KEY_FRAME, z13);
            }
            return bundle;
        }

        private ClippingConfiguration(Builder builder) {
            this.startPositionMs = builder.startPositionMs;
            this.endPositionMs = builder.endPositionMs;
            this.relativeToLiveWindow = builder.relativeToLiveWindow;
            this.relativeToDefaultPosition = builder.relativeToDefaultPosition;
            this.startsAtKeyFrame = builder.startsAtKeyFrame;
        }
    }

    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration {
        public static final ClippingProperties UNSET = new ClippingConfiguration.Builder().buildClippingProperties();

        private ClippingProperties(ClippingConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static final class DrmConfiguration {
        public final boolean forceDefaultLicenseUri;
        public final ImmutableList<Integer> forcedSessionTrackTypes;
        /* access modifiers changed from: private */
        @Nullable
        public final byte[] keySetId;
        public final ImmutableMap<String, String> licenseRequestHeaders;
        @Nullable
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        @Deprecated
        public final ImmutableMap<String, String> requestHeaders;
        public final UUID scheme;
        @Deprecated
        public final ImmutableList<Integer> sessionForClearTypes;
        @Deprecated
        public final UUID uuid;

        public static final class Builder {
            /* access modifiers changed from: private */
            public boolean forceDefaultLicenseUri;
            /* access modifiers changed from: private */
            public ImmutableList<Integer> forcedSessionTrackTypes;
            /* access modifiers changed from: private */
            @Nullable
            public byte[] keySetId;
            /* access modifiers changed from: private */
            public ImmutableMap<String, String> licenseRequestHeaders;
            /* access modifiers changed from: private */
            @Nullable
            public Uri licenseUri;
            /* access modifiers changed from: private */
            public boolean multiSession;
            /* access modifiers changed from: private */
            public boolean playClearContentWithoutKey;
            /* access modifiers changed from: private */
            @Nullable
            public UUID scheme;

            /* access modifiers changed from: private */
            @CanIgnoreReturnValue
            @Deprecated
            public Builder setNullableScheme(@Nullable UUID uuid) {
                this.scheme = uuid;
                return this;
            }

            public DrmConfiguration build() {
                return new DrmConfiguration(this);
            }

            @InlineMe(replacement = "this.setForceSessionsForAudioAndVideoTracks(forceSessionsForAudioAndVideoTracks)")
            @CanIgnoreReturnValue
            @Deprecated
            public Builder forceSessionsForAudioAndVideoTracks(boolean z11) {
                return setForceSessionsForAudioAndVideoTracks(z11);
            }

            @CanIgnoreReturnValue
            public Builder setForceDefaultLicenseUri(boolean z11) {
                this.forceDefaultLicenseUri = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForceSessionsForAudioAndVideoTracks(boolean z11) {
                ImmutableList immutableList;
                if (z11) {
                    immutableList = ImmutableList.of(2, 1);
                } else {
                    immutableList = ImmutableList.of();
                }
                setForcedSessionTrackTypes(immutableList);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForcedSessionTrackTypes(List<Integer> list) {
                this.forcedSessionTrackTypes = ImmutableList.copyOf(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setKeySetId(@Nullable byte[] bArr) {
                this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLicenseRequestHeaders(Map<String, String> map) {
                this.licenseRequestHeaders = ImmutableMap.copyOf(map);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLicenseUri(@Nullable Uri uri) {
                this.licenseUri = uri;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMultiSession(boolean z11) {
                this.multiSession = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlayClearContentWithoutKey(boolean z11) {
                this.playClearContentWithoutKey = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setScheme(UUID uuid) {
                this.scheme = uuid;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLicenseUri(@Nullable String str) {
                this.licenseUri = str == null ? null : Uri.parse(str);
                return this;
            }

            public Builder(UUID uuid) {
                this.scheme = uuid;
                this.licenseRequestHeaders = ImmutableMap.of();
                this.forcedSessionTrackTypes = ImmutableList.of();
            }

            @Deprecated
            private Builder() {
                this.licenseRequestHeaders = ImmutableMap.of();
                this.forcedSessionTrackTypes = ImmutableList.of();
            }

            private Builder(DrmConfiguration drmConfiguration) {
                this.scheme = drmConfiguration.scheme;
                this.licenseUri = drmConfiguration.licenseUri;
                this.licenseRequestHeaders = drmConfiguration.licenseRequestHeaders;
                this.multiSession = drmConfiguration.multiSession;
                this.playClearContentWithoutKey = drmConfiguration.playClearContentWithoutKey;
                this.forceDefaultLicenseUri = drmConfiguration.forceDefaultLicenseUri;
                this.forcedSessionTrackTypes = drmConfiguration.forcedSessionTrackTypes;
                this.keySetId = drmConfiguration.keySetId;
            }
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            if (!this.scheme.equals(drmConfiguration.scheme) || !Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) || !Util.areEqual(this.licenseRequestHeaders, drmConfiguration.licenseRequestHeaders) || this.multiSession != drmConfiguration.multiSession || this.forceDefaultLicenseUri != drmConfiguration.forceDefaultLicenseUri || this.playClearContentWithoutKey != drmConfiguration.playClearContentWithoutKey || !this.forcedSessionTrackTypes.equals(drmConfiguration.forcedSessionTrackTypes) || !Arrays.equals(this.keySetId, drmConfiguration.keySetId)) {
                return false;
            }
            return true;
        }

        @Nullable
        public byte[] getKeySetId() {
            byte[] bArr = this.keySetId;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public int hashCode() {
            int i11;
            int hashCode = this.scheme.hashCode() * 31;
            Uri uri = this.licenseUri;
            if (uri != null) {
                i11 = uri.hashCode();
            } else {
                i11 = 0;
            }
            return ((((((((((((hashCode + i11) * 31) + this.licenseRequestHeaders.hashCode()) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31) + this.forcedSessionTrackTypes.hashCode()) * 31) + Arrays.hashCode(this.keySetId);
        }

        private DrmConfiguration(Builder builder) {
            Assertions.checkState(!builder.forceDefaultLicenseUri || builder.licenseUri != null);
            UUID uuid2 = (UUID) Assertions.checkNotNull(builder.scheme);
            this.scheme = uuid2;
            this.uuid = uuid2;
            this.licenseUri = builder.licenseUri;
            this.requestHeaders = builder.licenseRequestHeaders;
            this.licenseRequestHeaders = builder.licenseRequestHeaders;
            this.multiSession = builder.multiSession;
            this.forceDefaultLicenseUri = builder.forceDefaultLicenseUri;
            this.playClearContentWithoutKey = builder.playClearContentWithoutKey;
            this.sessionForClearTypes = builder.forcedSessionTrackTypes;
            this.forcedSessionTrackTypes = builder.forcedSessionTrackTypes;
            this.keySetId = builder.keySetId != null ? Arrays.copyOf(builder.keySetId, builder.keySetId.length) : null;
        }
    }

    public static final class LiveConfiguration implements Bundleable {
        public static final Bundleable.Creator<LiveConfiguration> CREATOR = new r0();
        private static final String FIELD_MAX_OFFSET_MS = Util.intToStringMaxRadix(2);
        private static final String FIELD_MAX_PLAYBACK_SPEED = Util.intToStringMaxRadix(4);
        private static final String FIELD_MIN_OFFSET_MS = Util.intToStringMaxRadix(1);
        private static final String FIELD_MIN_PLAYBACK_SPEED = Util.intToStringMaxRadix(3);
        private static final String FIELD_TARGET_OFFSET_MS = Util.intToStringMaxRadix(0);
        public static final LiveConfiguration UNSET = new Builder().build();
        public final long maxOffsetMs;
        public final float maxPlaybackSpeed;
        public final long minOffsetMs;
        public final float minPlaybackSpeed;
        public final long targetOffsetMs;

        public static final class Builder {
            /* access modifiers changed from: private */
            public long maxOffsetMs;
            /* access modifiers changed from: private */
            public float maxPlaybackSpeed;
            /* access modifiers changed from: private */
            public long minOffsetMs;
            /* access modifiers changed from: private */
            public float minPlaybackSpeed;
            /* access modifiers changed from: private */
            public long targetOffsetMs;

            public LiveConfiguration build() {
                return new LiveConfiguration(this);
            }

            @CanIgnoreReturnValue
            public Builder setMaxOffsetMs(long j11) {
                this.maxOffsetMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxPlaybackSpeed(float f11) {
                this.maxPlaybackSpeed = f11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMinOffsetMs(long j11) {
                this.minOffsetMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMinPlaybackSpeed(float f11) {
                this.minPlaybackSpeed = f11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTargetOffsetMs(long j11) {
                this.targetOffsetMs = j11;
                return this;
            }

            public Builder() {
                this.targetOffsetMs = C.TIME_UNSET;
                this.minOffsetMs = C.TIME_UNSET;
                this.maxOffsetMs = C.TIME_UNSET;
                this.minPlaybackSpeed = -3.4028235E38f;
                this.maxPlaybackSpeed = -3.4028235E38f;
            }

            private Builder(LiveConfiguration liveConfiguration) {
                this.targetOffsetMs = liveConfiguration.targetOffsetMs;
                this.minOffsetMs = liveConfiguration.minOffsetMs;
                this.maxOffsetMs = liveConfiguration.maxOffsetMs;
                this.minPlaybackSpeed = liveConfiguration.minPlaybackSpeed;
                this.maxPlaybackSpeed = liveConfiguration.maxPlaybackSpeed;
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LiveConfiguration lambda$static$0(Bundle bundle) {
            String str = FIELD_TARGET_OFFSET_MS;
            LiveConfiguration liveConfiguration = UNSET;
            return new LiveConfiguration(bundle.getLong(str, liveConfiguration.targetOffsetMs), bundle.getLong(FIELD_MIN_OFFSET_MS, liveConfiguration.minOffsetMs), bundle.getLong(FIELD_MAX_OFFSET_MS, liveConfiguration.maxOffsetMs), bundle.getFloat(FIELD_MIN_PLAYBACK_SPEED, liveConfiguration.minPlaybackSpeed), bundle.getFloat(FIELD_MAX_PLAYBACK_SPEED, liveConfiguration.maxPlaybackSpeed));
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            if (this.targetOffsetMs == liveConfiguration.targetOffsetMs && this.minOffsetMs == liveConfiguration.minOffsetMs && this.maxOffsetMs == liveConfiguration.maxOffsetMs && this.minPlaybackSpeed == liveConfiguration.minPlaybackSpeed && this.maxPlaybackSpeed == liveConfiguration.maxPlaybackSpeed) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            long j11 = this.targetOffsetMs;
            long j12 = this.minOffsetMs;
            long j13 = this.maxOffsetMs;
            int i12 = ((((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) ((j13 >>> 32) ^ j13))) * 31;
            float f11 = this.minPlaybackSpeed;
            int i13 = 0;
            if (f11 != 0.0f) {
                i11 = Float.floatToIntBits(f11);
            } else {
                i11 = 0;
            }
            int i14 = (i12 + i11) * 31;
            float f12 = this.maxPlaybackSpeed;
            if (f12 != 0.0f) {
                i13 = Float.floatToIntBits(f12);
            }
            return i14 + i13;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j11 = this.targetOffsetMs;
            LiveConfiguration liveConfiguration = UNSET;
            if (j11 != liveConfiguration.targetOffsetMs) {
                bundle.putLong(FIELD_TARGET_OFFSET_MS, j11);
            }
            long j12 = this.minOffsetMs;
            if (j12 != liveConfiguration.minOffsetMs) {
                bundle.putLong(FIELD_MIN_OFFSET_MS, j12);
            }
            long j13 = this.maxOffsetMs;
            if (j13 != liveConfiguration.maxOffsetMs) {
                bundle.putLong(FIELD_MAX_OFFSET_MS, j13);
            }
            float f11 = this.minPlaybackSpeed;
            if (f11 != liveConfiguration.minPlaybackSpeed) {
                bundle.putFloat(FIELD_MIN_PLAYBACK_SPEED, f11);
            }
            float f12 = this.maxPlaybackSpeed;
            if (f12 != liveConfiguration.maxPlaybackSpeed) {
                bundle.putFloat(FIELD_MAX_PLAYBACK_SPEED, f12);
            }
            return bundle;
        }

        private LiveConfiguration(Builder builder) {
            this(builder.targetOffsetMs, builder.minOffsetMs, builder.maxOffsetMs, builder.minPlaybackSpeed, builder.maxPlaybackSpeed);
        }

        @Deprecated
        public LiveConfiguration(long j11, long j12, long j13, float f11, float f12) {
            this.targetOffsetMs = j11;
            this.minOffsetMs = j12;
            this.maxOffsetMs = j13;
            this.minPlaybackSpeed = f11;
            this.maxPlaybackSpeed = f12;
        }
    }

    public static class LocalConfiguration {
        @Nullable
        public final AdsConfiguration adsConfiguration;
        @Nullable
        public final String customCacheKey;
        @Nullable
        public final DrmConfiguration drmConfiguration;
        @Nullable
        public final String mimeType;
        public final List<StreamKey> streamKeys;
        public final ImmutableList<SubtitleConfiguration> subtitleConfigurations;
        @Deprecated
        public final List<Subtitle> subtitles;
        @Nullable
        public final Object tag;
        public final Uri uri;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            if (!this.uri.equals(localConfiguration.uri) || !Util.areEqual(this.mimeType, localConfiguration.mimeType) || !Util.areEqual(this.drmConfiguration, localConfiguration.drmConfiguration) || !Util.areEqual(this.adsConfiguration, localConfiguration.adsConfiguration) || !this.streamKeys.equals(localConfiguration.streamKeys) || !Util.areEqual(this.customCacheKey, localConfiguration.customCacheKey) || !this.subtitleConfigurations.equals(localConfiguration.subtitleConfigurations) || !Util.areEqual(this.tag, localConfiguration.tag)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            int i14;
            int hashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i15 = 0;
            if (str == null) {
                i11 = 0;
            } else {
                i11 = str.hashCode();
            }
            int i16 = (hashCode + i11) * 31;
            DrmConfiguration drmConfiguration2 = this.drmConfiguration;
            if (drmConfiguration2 == null) {
                i12 = 0;
            } else {
                i12 = drmConfiguration2.hashCode();
            }
            int i17 = (i16 + i12) * 31;
            AdsConfiguration adsConfiguration2 = this.adsConfiguration;
            if (adsConfiguration2 == null) {
                i13 = 0;
            } else {
                i13 = adsConfiguration2.hashCode();
            }
            int hashCode2 = (((i17 + i13) * 31) + this.streamKeys.hashCode()) * 31;
            String str2 = this.customCacheKey;
            if (str2 == null) {
                i14 = 0;
            } else {
                i14 = str2.hashCode();
            }
            int hashCode3 = (((hashCode2 + i14) * 31) + this.subtitleConfigurations.hashCode()) * 31;
            Object obj = this.tag;
            if (obj != null) {
                i15 = obj.hashCode();
            }
            return hashCode3 + i15;
        }

        private LocalConfiguration(Uri uri2, @Nullable String str, @Nullable DrmConfiguration drmConfiguration2, @Nullable AdsConfiguration adsConfiguration2, List<StreamKey> list, @Nullable String str2, ImmutableList<SubtitleConfiguration> immutableList, @Nullable Object obj) {
            this.uri = uri2;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration2;
            this.adsConfiguration = adsConfiguration2;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitleConfigurations = immutableList;
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                builder.add((Object) immutableList.get(i11).buildUpon().buildSubtitle());
            }
            this.subtitles = builder.build();
            this.tag = obj;
        }
    }

    @Deprecated
    public static final class PlaybackProperties extends LocalConfiguration {
        private PlaybackProperties(Uri uri, @Nullable String str, @Nullable DrmConfiguration drmConfiguration, @Nullable AdsConfiguration adsConfiguration, List<StreamKey> list, @Nullable String str2, ImmutableList<SubtitleConfiguration> immutableList, @Nullable Object obj) {
            super(uri, str, drmConfiguration, adsConfiguration, list, str2, immutableList, obj);
        }
    }

    public static final class RequestMetadata implements Bundleable {
        public static final Bundleable.Creator<RequestMetadata> CREATOR = new s0();
        public static final RequestMetadata EMPTY = new Builder().build();
        private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(2);
        private static final String FIELD_MEDIA_URI = Util.intToStringMaxRadix(0);
        private static final String FIELD_SEARCH_QUERY = Util.intToStringMaxRadix(1);
        @Nullable
        public final Bundle extras;
        @Nullable
        public final Uri mediaUri;
        @Nullable
        public final String searchQuery;

        public static final class Builder {
            /* access modifiers changed from: private */
            @Nullable
            public Bundle extras;
            /* access modifiers changed from: private */
            @Nullable
            public Uri mediaUri;
            /* access modifiers changed from: private */
            @Nullable
            public String searchQuery;

            public Builder() {
            }

            public RequestMetadata build() {
                return new RequestMetadata(this);
            }

            @CanIgnoreReturnValue
            public Builder setExtras(@Nullable Bundle bundle) {
                this.extras = bundle;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMediaUri(@Nullable Uri uri) {
                this.mediaUri = uri;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSearchQuery(@Nullable String str) {
                this.searchQuery = str;
                return this;
            }

            private Builder(RequestMetadata requestMetadata) {
                this.mediaUri = requestMetadata.mediaUri;
                this.searchQuery = requestMetadata.searchQuery;
                this.extras = requestMetadata.extras;
            }
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (!Util.areEqual(this.mediaUri, requestMetadata.mediaUri) || !Util.areEqual(this.searchQuery, requestMetadata.searchQuery)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i11;
            Uri uri = this.mediaUri;
            int i12 = 0;
            if (uri == null) {
                i11 = 0;
            } else {
                i11 = uri.hashCode();
            }
            int i13 = i11 * 31;
            String str = this.searchQuery;
            if (str != null) {
                i12 = str.hashCode();
            }
            return i13 + i12;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            Uri uri = this.mediaUri;
            if (uri != null) {
                bundle.putParcelable(FIELD_MEDIA_URI, uri);
            }
            String str = this.searchQuery;
            if (str != null) {
                bundle.putString(FIELD_SEARCH_QUERY, str);
            }
            Bundle bundle2 = this.extras;
            if (bundle2 != null) {
                bundle.putBundle(FIELD_EXTRAS, bundle2);
            }
            return bundle;
        }

        private RequestMetadata(Builder builder) {
            this.mediaUri = builder.mediaUri;
            this.searchQuery = builder.searchQuery;
            this.extras = builder.extras;
        }
    }

    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration {
        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2) {
            this(uri, str, str2, 0);
        }

        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2, int i11) {
            this(uri, str, str2, i11, 0, (String) null);
        }

        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2, int i11, int i12, @Nullable String str3) {
            super(uri, str, str2, i11, i12, str3, (String) null);
        }

        private Subtitle(SubtitleConfiguration.Builder builder) {
            super(builder);
        }
    }

    /* access modifiers changed from: private */
    public static MediaItem fromBundle(Bundle bundle) {
        LiveConfiguration liveConfiguration2;
        MediaMetadata mediaMetadata2;
        ClippingProperties clippingProperties2;
        RequestMetadata requestMetadata2;
        String str = (String) Assertions.checkNotNull(bundle.getString(FIELD_MEDIA_ID, ""));
        Bundle bundle2 = bundle.getBundle(FIELD_LIVE_CONFIGURATION);
        if (bundle2 == null) {
            liveConfiguration2 = LiveConfiguration.UNSET;
        } else {
            liveConfiguration2 = LiveConfiguration.CREATOR.fromBundle(bundle2);
        }
        LiveConfiguration liveConfiguration3 = liveConfiguration2;
        Bundle bundle3 = bundle.getBundle(FIELD_MEDIA_METADATA);
        if (bundle3 == null) {
            mediaMetadata2 = MediaMetadata.EMPTY;
        } else {
            mediaMetadata2 = MediaMetadata.CREATOR.fromBundle(bundle3);
        }
        MediaMetadata mediaMetadata3 = mediaMetadata2;
        Bundle bundle4 = bundle.getBundle(FIELD_CLIPPING_PROPERTIES);
        if (bundle4 == null) {
            clippingProperties2 = ClippingProperties.UNSET;
        } else {
            clippingProperties2 = ClippingConfiguration.CREATOR.fromBundle(bundle4);
        }
        ClippingProperties clippingProperties3 = clippingProperties2;
        Bundle bundle5 = bundle.getBundle(FIELD_REQUEST_METADATA);
        if (bundle5 == null) {
            requestMetadata2 = RequestMetadata.EMPTY;
        } else {
            requestMetadata2 = RequestMetadata.CREATOR.fromBundle(bundle5);
        }
        return new MediaItem(str, clippingProperties3, (PlaybackProperties) null, liveConfiguration3, mediaMetadata3, requestMetadata2);
    }

    public static MediaItem fromUri(String str) {
        return new Builder().setUri(str).build();
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        if (!Util.areEqual(this.mediaId, mediaItem.mediaId) || !this.clippingConfiguration.equals(mediaItem.clippingConfiguration) || !Util.areEqual(this.localConfiguration, mediaItem.localConfiguration) || !Util.areEqual(this.liveConfiguration, mediaItem.liveConfiguration) || !Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata) || !Util.areEqual(this.requestMetadata, mediaItem.requestMetadata)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i11;
        int hashCode = this.mediaId.hashCode() * 31;
        LocalConfiguration localConfiguration2 = this.localConfiguration;
        if (localConfiguration2 != null) {
            i11 = localConfiguration2.hashCode();
        } else {
            i11 = 0;
        }
        return ((((((((hashCode + i11) * 31) + this.liveConfiguration.hashCode()) * 31) + this.clippingConfiguration.hashCode()) * 31) + this.mediaMetadata.hashCode()) * 31) + this.requestMetadata.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (!this.mediaId.equals("")) {
            bundle.putString(FIELD_MEDIA_ID, this.mediaId);
        }
        if (!this.liveConfiguration.equals(LiveConfiguration.UNSET)) {
            bundle.putBundle(FIELD_LIVE_CONFIGURATION, this.liveConfiguration.toBundle());
        }
        if (!this.mediaMetadata.equals(MediaMetadata.EMPTY)) {
            bundle.putBundle(FIELD_MEDIA_METADATA, this.mediaMetadata.toBundle());
        }
        if (!this.clippingConfiguration.equals(ClippingConfiguration.UNSET)) {
            bundle.putBundle(FIELD_CLIPPING_PROPERTIES, this.clippingConfiguration.toBundle());
        }
        if (!this.requestMetadata.equals(RequestMetadata.EMPTY)) {
            bundle.putBundle(FIELD_REQUEST_METADATA, this.requestMetadata.toBundle());
        }
        return bundle;
    }

    public static class SubtitleConfiguration {
        @Nullable

        /* renamed from: id  reason: collision with root package name */
        public final String f34902id;
        @Nullable
        public final String label;
        @Nullable
        public final String language;
        @Nullable
        public final String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final Uri uri;

        public static final class Builder {
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: id  reason: collision with root package name */
            public String f34903id;
            /* access modifiers changed from: private */
            @Nullable
            public String label;
            /* access modifiers changed from: private */
            @Nullable
            public String language;
            /* access modifiers changed from: private */
            @Nullable
            public String mimeType;
            /* access modifiers changed from: private */
            public int roleFlags;
            /* access modifiers changed from: private */
            public int selectionFlags;
            /* access modifiers changed from: private */
            public Uri uri;

            /* access modifiers changed from: private */
            public Subtitle buildSubtitle() {
                return new Subtitle(this);
            }

            public SubtitleConfiguration build() {
                return new SubtitleConfiguration(this);
            }

            @CanIgnoreReturnValue
            public Builder setId(@Nullable String str) {
                this.f34903id = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLabel(@Nullable String str) {
                this.label = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLanguage(@Nullable String str) {
                this.language = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMimeType(@Nullable String str) {
                this.mimeType = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRoleFlags(int i11) {
                this.roleFlags = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSelectionFlags(int i11) {
                this.selectionFlags = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUri(Uri uri2) {
                this.uri = uri2;
                return this;
            }

            public Builder(Uri uri2) {
                this.uri = uri2;
            }

            private Builder(SubtitleConfiguration subtitleConfiguration) {
                this.uri = subtitleConfiguration.uri;
                this.mimeType = subtitleConfiguration.mimeType;
                this.language = subtitleConfiguration.language;
                this.selectionFlags = subtitleConfiguration.selectionFlags;
                this.roleFlags = subtitleConfiguration.roleFlags;
                this.label = subtitleConfiguration.label;
                this.f34903id = subtitleConfiguration.f34902id;
            }
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            if (!this.uri.equals(subtitleConfiguration.uri) || !Util.areEqual(this.mimeType, subtitleConfiguration.mimeType) || !Util.areEqual(this.language, subtitleConfiguration.language) || this.selectionFlags != subtitleConfiguration.selectionFlags || this.roleFlags != subtitleConfiguration.roleFlags || !Util.areEqual(this.label, subtitleConfiguration.label) || !Util.areEqual(this.f34902id, subtitleConfiguration.f34902id)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            int hashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i14 = 0;
            if (str == null) {
                i11 = 0;
            } else {
                i11 = str.hashCode();
            }
            int i15 = (hashCode + i11) * 31;
            String str2 = this.language;
            if (str2 == null) {
                i12 = 0;
            } else {
                i12 = str2.hashCode();
            }
            int i16 = (((((i15 + i12) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            String str3 = this.label;
            if (str3 == null) {
                i13 = 0;
            } else {
                i13 = str3.hashCode();
            }
            int i17 = (i16 + i13) * 31;
            String str4 = this.f34902id;
            if (str4 != null) {
                i14 = str4.hashCode();
            }
            return i17 + i14;
        }

        private SubtitleConfiguration(Uri uri2, String str, @Nullable String str2, int i11, int i12, @Nullable String str3, @Nullable String str4) {
            this.uri = uri2;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i11;
            this.roleFlags = i12;
            this.label = str3;
            this.f34902id = str4;
        }

        private SubtitleConfiguration(Builder builder) {
            this.uri = builder.uri;
            this.mimeType = builder.mimeType;
            this.language = builder.language;
            this.selectionFlags = builder.selectionFlags;
            this.roleFlags = builder.roleFlags;
            this.label = builder.label;
            this.f34902id = builder.f34903id;
        }
    }

    private MediaItem(String str, ClippingProperties clippingProperties2, @Nullable PlaybackProperties playbackProperties2, LiveConfiguration liveConfiguration2, MediaMetadata mediaMetadata2, RequestMetadata requestMetadata2) {
        this.mediaId = str;
        this.localConfiguration = playbackProperties2;
        this.playbackProperties = playbackProperties2;
        this.liveConfiguration = liveConfiguration2;
        this.mediaMetadata = mediaMetadata2;
        this.clippingConfiguration = clippingProperties2;
        this.clippingProperties = clippingProperties2;
        this.requestMetadata = requestMetadata2;
    }

    public static MediaItem fromUri(Uri uri) {
        return new Builder().setUri(uri).build();
    }
}
