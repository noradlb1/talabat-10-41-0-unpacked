package com.google.android.exoplayer2;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Size;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import g7.a2;
import g7.a3;
import g7.b2;
import g7.b3;
import g7.c2;
import g7.c3;
import g7.d1;
import g7.d2;
import g7.d3;
import g7.e1;
import g7.e2;
import g7.e3;
import g7.f1;
import g7.f2;
import g7.f3;
import g7.g1;
import g7.g2;
import g7.g3;
import g7.h1;
import g7.h2;
import g7.h3;
import g7.i1;
import g7.i2;
import g7.j0;
import g7.j1;
import g7.j2;
import g7.k1;
import g7.k2;
import g7.k3;
import g7.l0;
import g7.l1;
import g7.l2;
import g7.m1;
import g7.m2;
import g7.n1;
import g7.n2;
import g7.o1;
import g7.o2;
import g7.p1;
import g7.p2;
import g7.q1;
import g7.q2;
import g7.r1;
import g7.r2;
import g7.s1;
import g7.s2;
import g7.t1;
import g7.t2;
import g7.u1;
import g7.u2;
import g7.v1;
import g7.v2;
import g7.w1;
import g7.w2;
import g7.x1;
import g7.x2;
import g7.y1;
import g7.y2;
import g7.z1;
import g7.z2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public abstract class SimpleBasePlayer extends BasePlayer {
    private static final long POSITION_DISCONTINUITY_THRESHOLD_MS = 1000;
    private final HandlerWrapper applicationHandler;
    private final Looper applicationLooper;
    private final ListenerSet<Player.Listener> listeners;
    private final HashSet<ListenableFuture<?>> pendingOperations;
    private final Timeline.Period period;
    private boolean released;
    private State state;

    public static final class MediaItemData {
        /* access modifiers changed from: private */
        public final MediaMetadata combinedMediaMetadata;
        public final long defaultPositionUs;
        public final long durationUs;
        public final long elapsedRealtimeEpochOffsetMs;
        public final boolean isDynamic;
        public final boolean isPlaceholder;
        public final boolean isSeekable;
        @Nullable
        public final MediaItem.LiveConfiguration liveConfiguration;
        @Nullable
        public final Object manifest;
        public final MediaItem mediaItem;
        @Nullable
        public final MediaMetadata mediaMetadata;
        private final long[] periodPositionInWindowUs;
        public final ImmutableList<PeriodData> periods;
        public final long positionInFirstPeriodUs;
        public final long presentationStartTimeMs;
        public final Tracks tracks;
        public final Object uid;
        public final long windowStartTimeMs;

        public static final class Builder {
            /* access modifiers changed from: private */
            public long defaultPositionUs;
            /* access modifiers changed from: private */
            public long durationUs;
            /* access modifiers changed from: private */
            public long elapsedRealtimeEpochOffsetMs;
            /* access modifiers changed from: private */
            public boolean isDynamic;
            /* access modifiers changed from: private */
            public boolean isPlaceholder;
            /* access modifiers changed from: private */
            public boolean isSeekable;
            /* access modifiers changed from: private */
            @Nullable
            public MediaItem.LiveConfiguration liveConfiguration;
            /* access modifiers changed from: private */
            @Nullable
            public Object manifest;
            /* access modifiers changed from: private */
            public MediaItem mediaItem;
            /* access modifiers changed from: private */
            @Nullable
            public MediaMetadata mediaMetadata;
            /* access modifiers changed from: private */
            public ImmutableList<PeriodData> periods;
            /* access modifiers changed from: private */
            public long positionInFirstPeriodUs;
            /* access modifiers changed from: private */
            public long presentationStartTimeMs;
            /* access modifiers changed from: private */
            public Tracks tracks;
            /* access modifiers changed from: private */
            public Object uid;
            /* access modifiers changed from: private */
            public long windowStartTimeMs;

            public MediaItemData build() {
                return new MediaItemData(this);
            }

            @CanIgnoreReturnValue
            public Builder setDefaultPositionUs(long j11) {
                boolean z11;
                if (j11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkArgument(z11);
                this.defaultPositionUs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDurationUs(long j11) {
                boolean z11;
                if (j11 == C.TIME_UNSET || j11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkArgument(z11);
                this.durationUs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setElapsedRealtimeEpochOffsetMs(long j11) {
                this.elapsedRealtimeEpochOffsetMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsDynamic(boolean z11) {
                this.isDynamic = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsPlaceholder(boolean z11) {
                this.isPlaceholder = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsSeekable(boolean z11) {
                this.isSeekable = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLiveConfiguration(@Nullable MediaItem.LiveConfiguration liveConfiguration2) {
                this.liveConfiguration = liveConfiguration2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setManifest(@Nullable Object obj) {
                this.manifest = obj;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMediaItem(MediaItem mediaItem2) {
                this.mediaItem = mediaItem2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMediaMetadata(@Nullable MediaMetadata mediaMetadata2) {
                this.mediaMetadata = mediaMetadata2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPeriods(List<PeriodData> list) {
                boolean z11;
                int size = list.size();
                int i11 = 0;
                while (i11 < size - 1) {
                    if (list.get(i11).durationUs != C.TIME_UNSET) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Assertions.checkArgument(z11, "Periods other than last need a duration");
                    int i12 = i11 + 1;
                    for (int i13 = i12; i13 < size; i13++) {
                        Assertions.checkArgument(!list.get(i11).uid.equals(list.get(i13).uid), "Duplicate PeriodData UIDs in period list");
                    }
                    i11 = i12;
                }
                this.periods = ImmutableList.copyOf(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPositionInFirstPeriodUs(long j11) {
                boolean z11;
                if (j11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkArgument(z11);
                this.positionInFirstPeriodUs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPresentationStartTimeMs(long j11) {
                this.presentationStartTimeMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTracks(Tracks tracks2) {
                this.tracks = tracks2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUid(Object obj) {
                this.uid = obj;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setWindowStartTimeMs(long j11) {
                this.windowStartTimeMs = j11;
                return this;
            }

            public Builder(Object obj) {
                this.uid = obj;
                this.tracks = Tracks.EMPTY;
                this.mediaItem = MediaItem.EMPTY;
                this.mediaMetadata = null;
                this.manifest = null;
                this.liveConfiguration = null;
                this.presentationStartTimeMs = C.TIME_UNSET;
                this.windowStartTimeMs = C.TIME_UNSET;
                this.elapsedRealtimeEpochOffsetMs = C.TIME_UNSET;
                this.isSeekable = false;
                this.isDynamic = false;
                this.defaultPositionUs = 0;
                this.durationUs = C.TIME_UNSET;
                this.positionInFirstPeriodUs = 0;
                this.isPlaceholder = false;
                this.periods = ImmutableList.of();
            }

            private Builder(MediaItemData mediaItemData) {
                this.uid = mediaItemData.uid;
                this.tracks = mediaItemData.tracks;
                this.mediaItem = mediaItemData.mediaItem;
                this.mediaMetadata = mediaItemData.mediaMetadata;
                this.manifest = mediaItemData.manifest;
                this.liveConfiguration = mediaItemData.liveConfiguration;
                this.presentationStartTimeMs = mediaItemData.presentationStartTimeMs;
                this.windowStartTimeMs = mediaItemData.windowStartTimeMs;
                this.elapsedRealtimeEpochOffsetMs = mediaItemData.elapsedRealtimeEpochOffsetMs;
                this.isSeekable = mediaItemData.isSeekable;
                this.isDynamic = mediaItemData.isDynamic;
                this.defaultPositionUs = mediaItemData.defaultPositionUs;
                this.durationUs = mediaItemData.durationUs;
                this.positionInFirstPeriodUs = mediaItemData.positionInFirstPeriodUs;
                this.isPlaceholder = mediaItemData.isPlaceholder;
                this.periods = mediaItemData.periods;
            }
        }

        private static MediaMetadata getCombinedMediaMetadata(MediaItem mediaItem2, Tracks tracks2) {
            MediaMetadata.Builder builder = new MediaMetadata.Builder();
            int size = tracks2.getGroups().size();
            for (int i11 = 0; i11 < size; i11++) {
                Tracks.Group group = tracks2.getGroups().get(i11);
                for (int i12 = 0; i12 < group.length; i12++) {
                    if (group.isTrackSelected(i12)) {
                        Format trackFormat = group.getTrackFormat(i12);
                        if (trackFormat.metadata != null) {
                            for (int i13 = 0; i13 < trackFormat.metadata.length(); i13++) {
                                trackFormat.metadata.get(i13).populateMediaMetadata(builder);
                            }
                        }
                    }
                }
            }
            return builder.populate(mediaItem2.mediaMetadata).build();
        }

        /* access modifiers changed from: private */
        public Timeline.Period getPeriod(int i11, int i12, Timeline.Period period) {
            if (this.periods.isEmpty()) {
                Object obj = this.uid;
                period.set(obj, obj, i11, this.positionInFirstPeriodUs + this.durationUs, 0, AdPlaybackState.NONE, this.isPlaceholder);
            } else {
                PeriodData periodData = this.periods.get(i12);
                Object obj2 = periodData.uid;
                period.set(obj2, Pair.create(this.uid, obj2), i11, periodData.durationUs, this.periodPositionInWindowUs[i12], periodData.adPlaybackState, periodData.isPlaceholder);
            }
            return period;
        }

        /* access modifiers changed from: private */
        public Object getPeriodUid(int i11) {
            if (this.periods.isEmpty()) {
                return this.uid;
            }
            return Pair.create(this.uid, this.periods.get(i11).uid);
        }

        /* access modifiers changed from: private */
        public Timeline.Window getWindow(int i11, Timeline.Window window) {
            int i12;
            Timeline.Window window2 = window;
            if (this.periods.isEmpty()) {
                i12 = 1;
            } else {
                i12 = this.periods.size();
            }
            Object obj = this.uid;
            Timeline.Window window3 = window;
            window.set(obj, this.mediaItem, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, this.isSeekable, this.isDynamic, this.liveConfiguration, this.defaultPositionUs, this.durationUs, i11, (i11 + i12) - 1, this.positionInFirstPeriodUs);
            Timeline.Window window4 = window;
            window4.isPlaceholder = this.isPlaceholder;
            return window4;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemData)) {
                return false;
            }
            MediaItemData mediaItemData = (MediaItemData) obj;
            if (this.uid.equals(mediaItemData.uid) && this.tracks.equals(mediaItemData.tracks) && this.mediaItem.equals(mediaItemData.mediaItem) && Util.areEqual(this.mediaMetadata, mediaItemData.mediaMetadata) && Util.areEqual(this.manifest, mediaItemData.manifest) && Util.areEqual(this.liveConfiguration, mediaItemData.liveConfiguration) && this.presentationStartTimeMs == mediaItemData.presentationStartTimeMs && this.windowStartTimeMs == mediaItemData.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == mediaItemData.elapsedRealtimeEpochOffsetMs && this.isSeekable == mediaItemData.isSeekable && this.isDynamic == mediaItemData.isDynamic && this.defaultPositionUs == mediaItemData.defaultPositionUs && this.durationUs == mediaItemData.durationUs && this.positionInFirstPeriodUs == mediaItemData.positionInFirstPeriodUs && this.isPlaceholder == mediaItemData.isPlaceholder && this.periods.equals(mediaItemData.periods)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int i12;
            int hashCode = (((((217 + this.uid.hashCode()) * 31) + this.tracks.hashCode()) * 31) + this.mediaItem.hashCode()) * 31;
            MediaMetadata mediaMetadata2 = this.mediaMetadata;
            int i13 = 0;
            if (mediaMetadata2 == null) {
                i11 = 0;
            } else {
                i11 = mediaMetadata2.hashCode();
            }
            int i14 = (hashCode + i11) * 31;
            Object obj = this.manifest;
            if (obj == null) {
                i12 = 0;
            } else {
                i12 = obj.hashCode();
            }
            int i15 = (i14 + i12) * 31;
            MediaItem.LiveConfiguration liveConfiguration2 = this.liveConfiguration;
            if (liveConfiguration2 != null) {
                i13 = liveConfiguration2.hashCode();
            }
            long j11 = this.presentationStartTimeMs;
            long j12 = this.windowStartTimeMs;
            long j13 = this.elapsedRealtimeEpochOffsetMs;
            long j14 = this.defaultPositionUs;
            long j15 = this.durationUs;
            long j16 = this.positionInFirstPeriodUs;
            return ((((((((((((((((((((i15 + i13) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + this.periods.hashCode();
        }

        private MediaItemData(Builder builder) {
            int i11 = 0;
            if (builder.liveConfiguration == null) {
                Assertions.checkArgument(builder.presentationStartTimeMs == C.TIME_UNSET, "presentationStartTimeMs can only be set if liveConfiguration != null");
                Assertions.checkArgument(builder.windowStartTimeMs == C.TIME_UNSET, "windowStartTimeMs can only be set if liveConfiguration != null");
                Assertions.checkArgument(builder.elapsedRealtimeEpochOffsetMs == C.TIME_UNSET, "elapsedRealtimeEpochOffsetMs can only be set if liveConfiguration != null");
            } else if (!(builder.presentationStartTimeMs == C.TIME_UNSET || builder.windowStartTimeMs == C.TIME_UNSET)) {
                Assertions.checkArgument(builder.windowStartTimeMs >= builder.presentationStartTimeMs, "windowStartTimeMs can't be less than presentationStartTimeMs");
            }
            int size = builder.periods.size();
            if (builder.durationUs != C.TIME_UNSET) {
                Assertions.checkArgument(builder.defaultPositionUs <= builder.durationUs, "defaultPositionUs can't be greater than durationUs");
            }
            this.uid = builder.uid;
            this.tracks = builder.tracks;
            this.mediaItem = builder.mediaItem;
            this.mediaMetadata = builder.mediaMetadata;
            this.manifest = builder.manifest;
            this.liveConfiguration = builder.liveConfiguration;
            this.presentationStartTimeMs = builder.presentationStartTimeMs;
            this.windowStartTimeMs = builder.windowStartTimeMs;
            this.elapsedRealtimeEpochOffsetMs = builder.elapsedRealtimeEpochOffsetMs;
            this.isSeekable = builder.isSeekable;
            this.isDynamic = builder.isDynamic;
            this.defaultPositionUs = builder.defaultPositionUs;
            this.durationUs = builder.durationUs;
            long access$6100 = builder.positionInFirstPeriodUs;
            this.positionInFirstPeriodUs = access$6100;
            this.isPlaceholder = builder.isPlaceholder;
            ImmutableList<PeriodData> access$5100 = builder.periods;
            this.periods = access$5100;
            long[] jArr = new long[access$5100.size()];
            this.periodPositionInWindowUs = jArr;
            if (!access$5100.isEmpty()) {
                jArr[0] = -access$6100;
                while (i11 < size - 1) {
                    long[] jArr2 = this.periodPositionInWindowUs;
                    int i12 = i11 + 1;
                    jArr2[i12] = jArr2[i11] + this.periods.get(i11).durationUs;
                    i11 = i12;
                }
            }
            MediaMetadata mediaMetadata2 = this.mediaMetadata;
            this.combinedMediaMetadata = mediaMetadata2 == null ? getCombinedMediaMetadata(this.mediaItem, this.tracks) : mediaMetadata2;
        }
    }

    public static final class PeriodData {
        public final AdPlaybackState adPlaybackState;
        public final long durationUs;
        public final boolean isPlaceholder;
        public final Object uid;

        public static final class Builder {
            /* access modifiers changed from: private */
            public AdPlaybackState adPlaybackState;
            /* access modifiers changed from: private */
            public long durationUs;
            /* access modifiers changed from: private */
            public boolean isPlaceholder;
            /* access modifiers changed from: private */
            public Object uid;

            public PeriodData build() {
                return new PeriodData(this);
            }

            @CanIgnoreReturnValue
            public Builder setAdPlaybackState(AdPlaybackState adPlaybackState2) {
                this.adPlaybackState = adPlaybackState2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDurationUs(long j11) {
                boolean z11;
                if (j11 == C.TIME_UNSET || j11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkArgument(z11);
                this.durationUs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsPlaceholder(boolean z11) {
                this.isPlaceholder = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUid(Object obj) {
                this.uid = obj;
                return this;
            }

            public Builder(Object obj) {
                this.uid = obj;
                this.durationUs = 0;
                this.adPlaybackState = AdPlaybackState.NONE;
                this.isPlaceholder = false;
            }

            private Builder(PeriodData periodData) {
                this.uid = periodData.uid;
                this.durationUs = periodData.durationUs;
                this.adPlaybackState = periodData.adPlaybackState;
                this.isPlaceholder = periodData.isPlaceholder;
            }
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PeriodData)) {
                return false;
            }
            PeriodData periodData = (PeriodData) obj;
            if (!this.uid.equals(periodData.uid) || this.durationUs != periodData.durationUs || !this.adPlaybackState.equals(periodData.adPlaybackState) || this.isPlaceholder != periodData.isPlaceholder) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j11 = this.durationUs;
            return ((((((217 + this.uid.hashCode()) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.adPlaybackState.hashCode()) * 31) + (this.isPlaceholder ? 1 : 0);
        }

        private PeriodData(Builder builder) {
            this.uid = builder.uid;
            this.durationUs = builder.durationUs;
            this.adPlaybackState = builder.adPlaybackState;
            this.isPlaceholder = builder.isPlaceholder;
        }
    }

    public static final class PlaceholderUid {
        private PlaceholderUid() {
        }
    }

    public static final class PlaylistTimeline extends Timeline {
        private final int[] firstPeriodIndexByWindowIndex;
        private final HashMap<Object, Integer> periodIndexByUid;
        private final ImmutableList<MediaItemData> playlist;
        private final int[] windowIndexByPeriodIndex;

        public PlaylistTimeline(ImmutableList<MediaItemData> immutableList) {
            int size = immutableList.size();
            this.playlist = immutableList;
            this.firstPeriodIndexByWindowIndex = new int[size];
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                this.firstPeriodIndexByWindowIndex[i12] = i11;
                i11 += getPeriodCountInMediaItem(immutableList.get(i12));
            }
            this.windowIndexByPeriodIndex = new int[i11];
            this.periodIndexByUid = new HashMap<>();
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                MediaItemData mediaItemData = immutableList.get(i14);
                for (int i15 = 0; i15 < getPeriodCountInMediaItem(mediaItemData); i15++) {
                    this.periodIndexByUid.put(mediaItemData.getPeriodUid(i15), Integer.valueOf(i13));
                    this.windowIndexByPeriodIndex[i13] = i14;
                    i13++;
                }
            }
        }

        private static int getPeriodCountInMediaItem(MediaItemData mediaItemData) {
            if (mediaItemData.periods.isEmpty()) {
                return 1;
            }
            return mediaItemData.periods.size();
        }

        public int getFirstWindowIndex(boolean z11) {
            return super.getFirstWindowIndex(z11);
        }

        public int getIndexOfPeriod(Object obj) {
            Integer num = this.periodIndexByUid.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public int getLastWindowIndex(boolean z11) {
            return super.getLastWindowIndex(z11);
        }

        public int getNextWindowIndex(int i11, int i12, boolean z11) {
            return super.getNextWindowIndex(i11, i12, z11);
        }

        public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            int i12 = this.windowIndexByPeriodIndex[i11];
            return this.playlist.get(i12).getPeriod(i12, i11 - this.firstPeriodIndexByWindowIndex[i12], period);
        }

        public Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
            return getPeriod(((Integer) Assertions.checkNotNull(this.periodIndexByUid.get(obj))).intValue(), period, true);
        }

        public int getPeriodCount() {
            return this.windowIndexByPeriodIndex.length;
        }

        public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
            return super.getPreviousWindowIndex(i11, i12, z11);
        }

        public Object getUidOfPeriod(int i11) {
            int i12 = this.windowIndexByPeriodIndex[i11];
            return this.playlist.get(i12).getPeriodUid(i11 - this.firstPeriodIndexByWindowIndex[i12]);
        }

        public Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
            return this.playlist.get(i11).getWindow(this.firstPeriodIndexByWindowIndex[i11], window);
        }

        public int getWindowCount() {
            return this.playlist.size();
        }
    }

    public interface PositionSupplier {
        public static final PositionSupplier ZERO = k3.a(0);

        long get();
    }

    public static final class State {
        public final PositionSupplier adBufferedPositionMsSupplier;
        public final PositionSupplier adPositionMsSupplier;
        public final AudioAttributes audioAttributes;
        public final Player.Commands availableCommands;
        public final PositionSupplier contentBufferedPositionMsSupplier;
        public final PositionSupplier contentPositionMsSupplier;
        public final int currentAdGroupIndex;
        public final int currentAdIndexInAdGroup;
        public final CueGroup currentCues;
        public final int currentMediaItemIndex;
        public final DeviceInfo deviceInfo;
        @IntRange(from = 0)
        public final int deviceVolume;
        public final long discontinuityPositionMs;
        public final boolean hasPositionDiscontinuity;
        public final boolean isDeviceMuted;
        public final boolean isLoading;
        public final long maxSeekToPreviousPositionMs;
        public final boolean newlyRenderedFirstFrame;
        public final boolean playWhenReady;
        public final int playWhenReadyChangeReason;
        public final PlaybackParameters playbackParameters;
        public final int playbackState;
        public final int playbackSuppressionReason;
        @Nullable
        public final PlaybackException playerError;
        public final ImmutableList<MediaItemData> playlist;
        public final MediaMetadata playlistMetadata;
        public final int positionDiscontinuityReason;
        public final int repeatMode;
        public final long seekBackIncrementMs;
        public final long seekForwardIncrementMs;
        public final boolean shuffleModeEnabled;
        public final Size surfaceSize;
        public final Metadata timedMetadata;
        public final Timeline timeline;
        public final PositionSupplier totalBufferedDurationMsSupplier;
        public final TrackSelectionParameters trackSelectionParameters;
        public final VideoSize videoSize;
        @FloatRange(from = 0.0d, to = 1.0d)
        public final float volume;

        public static final class Builder {
            /* access modifiers changed from: private */
            public PositionSupplier adBufferedPositionMsSupplier;
            /* access modifiers changed from: private */
            @Nullable
            public Long adPositionMs;
            /* access modifiers changed from: private */
            public PositionSupplier adPositionMsSupplier;
            /* access modifiers changed from: private */
            public AudioAttributes audioAttributes;
            /* access modifiers changed from: private */
            public Player.Commands availableCommands;
            /* access modifiers changed from: private */
            public PositionSupplier contentBufferedPositionMsSupplier;
            /* access modifiers changed from: private */
            @Nullable
            public Long contentPositionMs;
            /* access modifiers changed from: private */
            public PositionSupplier contentPositionMsSupplier;
            /* access modifiers changed from: private */
            public int currentAdGroupIndex;
            /* access modifiers changed from: private */
            public int currentAdIndexInAdGroup;
            /* access modifiers changed from: private */
            public CueGroup currentCues;
            /* access modifiers changed from: private */
            public int currentMediaItemIndex;
            /* access modifiers changed from: private */
            public DeviceInfo deviceInfo;
            /* access modifiers changed from: private */
            public int deviceVolume;
            /* access modifiers changed from: private */
            public long discontinuityPositionMs;
            /* access modifiers changed from: private */
            public boolean hasPositionDiscontinuity;
            /* access modifiers changed from: private */
            public boolean isDeviceMuted;
            /* access modifiers changed from: private */
            public boolean isLoading;
            /* access modifiers changed from: private */
            public long maxSeekToPreviousPositionMs;
            /* access modifiers changed from: private */
            public boolean newlyRenderedFirstFrame;
            /* access modifiers changed from: private */
            public boolean playWhenReady;
            /* access modifiers changed from: private */
            public int playWhenReadyChangeReason;
            /* access modifiers changed from: private */
            public PlaybackParameters playbackParameters;
            /* access modifiers changed from: private */
            public int playbackState;
            /* access modifiers changed from: private */
            public int playbackSuppressionReason;
            /* access modifiers changed from: private */
            @Nullable
            public PlaybackException playerError;
            /* access modifiers changed from: private */
            public ImmutableList<MediaItemData> playlist;
            /* access modifiers changed from: private */
            public MediaMetadata playlistMetadata;
            /* access modifiers changed from: private */
            public int positionDiscontinuityReason;
            /* access modifiers changed from: private */
            public int repeatMode;
            /* access modifiers changed from: private */
            public long seekBackIncrementMs;
            /* access modifiers changed from: private */
            public long seekForwardIncrementMs;
            /* access modifiers changed from: private */
            public boolean shuffleModeEnabled;
            /* access modifiers changed from: private */
            public Size surfaceSize;
            /* access modifiers changed from: private */
            public Metadata timedMetadata;
            /* access modifiers changed from: private */
            public Timeline timeline;
            /* access modifiers changed from: private */
            public PositionSupplier totalBufferedDurationMsSupplier;
            /* access modifiers changed from: private */
            public TrackSelectionParameters trackSelectionParameters;
            /* access modifiers changed from: private */
            public VideoSize videoSize;
            /* access modifiers changed from: private */
            public float volume;

            public State build() {
                return new State(this);
            }

            @CanIgnoreReturnValue
            public Builder clearPositionDiscontinuity() {
                this.hasPositionDiscontinuity = false;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAdBufferedPositionMs(PositionSupplier positionSupplier) {
                this.adBufferedPositionMsSupplier = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAdPositionMs(long j11) {
                this.adPositionMs = Long.valueOf(j11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAudioAttributes(AudioAttributes audioAttributes2) {
                this.audioAttributes = audioAttributes2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAvailableCommands(Player.Commands commands) {
                this.availableCommands = commands;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setContentBufferedPositionMs(PositionSupplier positionSupplier) {
                this.contentBufferedPositionMsSupplier = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setContentPositionMs(long j11) {
                this.contentPositionMs = Long.valueOf(j11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCurrentAd(int i11, int i12) {
                boolean z11;
                boolean z12;
                boolean z13 = true;
                if (i11 == -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i12 == -1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z11 != z12) {
                    z13 = false;
                }
                Assertions.checkArgument(z13);
                this.currentAdGroupIndex = i11;
                this.currentAdIndexInAdGroup = i12;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCurrentCues(CueGroup cueGroup) {
                this.currentCues = cueGroup;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCurrentMediaItemIndex(int i11) {
                this.currentMediaItemIndex = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDeviceInfo(DeviceInfo deviceInfo2) {
                this.deviceInfo = deviceInfo2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDeviceVolume(@IntRange(from = 0) int i11) {
                boolean z11;
                if (i11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkArgument(z11);
                this.deviceVolume = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsDeviceMuted(boolean z11) {
                this.isDeviceMuted = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsLoading(boolean z11) {
                this.isLoading = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxSeekToPreviousPositionMs(long j11) {
                this.maxSeekToPreviousPositionMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setNewlyRenderedFirstFrame(boolean z11) {
                this.newlyRenderedFirstFrame = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlayWhenReady(boolean z11, int i11) {
                this.playWhenReady = z11;
                this.playWhenReadyChangeReason = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlaybackParameters(PlaybackParameters playbackParameters2) {
                this.playbackParameters = playbackParameters2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlaybackState(int i11) {
                this.playbackState = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlaybackSuppressionReason(int i11) {
                this.playbackSuppressionReason = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlayerError(@Nullable PlaybackException playbackException) {
                this.playerError = playbackException;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlaylist(List<MediaItemData> list) {
                HashSet hashSet = new HashSet();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    Assertions.checkArgument(hashSet.add(list.get(i11).uid), "Duplicate MediaItemData UID in playlist");
                }
                this.playlist = ImmutableList.copyOf(list);
                this.timeline = new PlaylistTimeline(this.playlist);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlaylistMetadata(MediaMetadata mediaMetadata) {
                this.playlistMetadata = mediaMetadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPositionDiscontinuity(int i11, long j11) {
                this.hasPositionDiscontinuity = true;
                this.positionDiscontinuityReason = i11;
                this.discontinuityPositionMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRepeatMode(int i11) {
                this.repeatMode = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSeekBackIncrementMs(long j11) {
                this.seekBackIncrementMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSeekForwardIncrementMs(long j11) {
                this.seekForwardIncrementMs = j11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setShuffleModeEnabled(boolean z11) {
                this.shuffleModeEnabled = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSurfaceSize(Size size) {
                this.surfaceSize = size;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTimedMetadata(Metadata metadata) {
                this.timedMetadata = metadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTotalBufferedDurationMs(PositionSupplier positionSupplier) {
                this.totalBufferedDurationMsSupplier = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters2) {
                this.trackSelectionParameters = trackSelectionParameters2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setVideoSize(VideoSize videoSize2) {
                this.videoSize = videoSize2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setVolume(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
                boolean z11;
                if (f11 < 0.0f || f11 > 1.0f) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                Assertions.checkArgument(z11);
                this.volume = f11;
                return this;
            }

            public Builder() {
                this.availableCommands = Player.Commands.EMPTY;
                this.playWhenReady = false;
                this.playWhenReadyChangeReason = 1;
                this.playbackState = 1;
                this.playbackSuppressionReason = 0;
                this.playerError = null;
                this.repeatMode = 0;
                this.shuffleModeEnabled = false;
                this.isLoading = false;
                this.seekBackIncrementMs = 5000;
                this.seekForwardIncrementMs = 15000;
                this.maxSeekToPreviousPositionMs = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
                this.playbackParameters = PlaybackParameters.DEFAULT;
                this.trackSelectionParameters = TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
                this.audioAttributes = AudioAttributes.DEFAULT;
                this.volume = 1.0f;
                this.videoSize = VideoSize.UNKNOWN;
                this.currentCues = CueGroup.EMPTY_TIME_ZERO;
                this.deviceInfo = DeviceInfo.UNKNOWN;
                this.deviceVolume = 0;
                this.isDeviceMuted = false;
                this.surfaceSize = Size.UNKNOWN;
                this.newlyRenderedFirstFrame = false;
                this.timedMetadata = new Metadata((long) C.TIME_UNSET, new Metadata.Entry[0]);
                this.playlist = ImmutableList.of();
                this.timeline = Timeline.EMPTY;
                this.playlistMetadata = MediaMetadata.EMPTY;
                this.currentMediaItemIndex = -1;
                this.currentAdGroupIndex = -1;
                this.currentAdIndexInAdGroup = -1;
                this.contentPositionMs = null;
                this.contentPositionMsSupplier = k3.a(C.TIME_UNSET);
                this.adPositionMs = null;
                PositionSupplier positionSupplier = PositionSupplier.ZERO;
                this.adPositionMsSupplier = positionSupplier;
                this.contentBufferedPositionMsSupplier = k3.a(C.TIME_UNSET);
                this.adBufferedPositionMsSupplier = positionSupplier;
                this.totalBufferedDurationMsSupplier = positionSupplier;
                this.hasPositionDiscontinuity = false;
                this.positionDiscontinuityReason = 5;
                this.discontinuityPositionMs = 0;
            }

            @CanIgnoreReturnValue
            public Builder setAdPositionMs(PositionSupplier positionSupplier) {
                this.adPositionMs = null;
                this.adPositionMsSupplier = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setContentPositionMs(PositionSupplier positionSupplier) {
                this.contentPositionMs = null;
                this.contentPositionMsSupplier = positionSupplier;
                return this;
            }

            private Builder(State state) {
                this.availableCommands = state.availableCommands;
                this.playWhenReady = state.playWhenReady;
                this.playWhenReadyChangeReason = state.playWhenReadyChangeReason;
                this.playbackState = state.playbackState;
                this.playbackSuppressionReason = state.playbackSuppressionReason;
                this.playerError = state.playerError;
                this.repeatMode = state.repeatMode;
                this.shuffleModeEnabled = state.shuffleModeEnabled;
                this.isLoading = state.isLoading;
                this.seekBackIncrementMs = state.seekBackIncrementMs;
                this.seekForwardIncrementMs = state.seekForwardIncrementMs;
                this.maxSeekToPreviousPositionMs = state.maxSeekToPreviousPositionMs;
                this.playbackParameters = state.playbackParameters;
                this.trackSelectionParameters = state.trackSelectionParameters;
                this.audioAttributes = state.audioAttributes;
                this.volume = state.volume;
                this.videoSize = state.videoSize;
                this.currentCues = state.currentCues;
                this.deviceInfo = state.deviceInfo;
                this.deviceVolume = state.deviceVolume;
                this.isDeviceMuted = state.isDeviceMuted;
                this.surfaceSize = state.surfaceSize;
                this.newlyRenderedFirstFrame = state.newlyRenderedFirstFrame;
                this.timedMetadata = state.timedMetadata;
                this.playlist = state.playlist;
                this.timeline = state.timeline;
                this.playlistMetadata = state.playlistMetadata;
                this.currentMediaItemIndex = state.currentMediaItemIndex;
                this.currentAdGroupIndex = state.currentAdGroupIndex;
                this.currentAdIndexInAdGroup = state.currentAdIndexInAdGroup;
                this.contentPositionMs = null;
                this.contentPositionMsSupplier = state.contentPositionMsSupplier;
                this.adPositionMs = null;
                this.adPositionMsSupplier = state.adPositionMsSupplier;
                this.contentBufferedPositionMsSupplier = state.contentBufferedPositionMsSupplier;
                this.adBufferedPositionMsSupplier = state.adBufferedPositionMsSupplier;
                this.totalBufferedDurationMsSupplier = state.totalBufferedDurationMsSupplier;
                this.hasPositionDiscontinuity = state.hasPositionDiscontinuity;
                this.positionDiscontinuityReason = state.positionDiscontinuityReason;
                this.discontinuityPositionMs = state.discontinuityPositionMs;
            }
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            if (this.playWhenReady == state.playWhenReady && this.playWhenReadyChangeReason == state.playWhenReadyChangeReason && this.availableCommands.equals(state.availableCommands) && this.playbackState == state.playbackState && this.playbackSuppressionReason == state.playbackSuppressionReason && Util.areEqual(this.playerError, state.playerError) && this.repeatMode == state.repeatMode && this.shuffleModeEnabled == state.shuffleModeEnabled && this.isLoading == state.isLoading && this.seekBackIncrementMs == state.seekBackIncrementMs && this.seekForwardIncrementMs == state.seekForwardIncrementMs && this.maxSeekToPreviousPositionMs == state.maxSeekToPreviousPositionMs && this.playbackParameters.equals(state.playbackParameters) && this.trackSelectionParameters.equals(state.trackSelectionParameters) && this.audioAttributes.equals(state.audioAttributes) && this.volume == state.volume && this.videoSize.equals(state.videoSize) && this.currentCues.equals(state.currentCues) && this.deviceInfo.equals(state.deviceInfo) && this.deviceVolume == state.deviceVolume && this.isDeviceMuted == state.isDeviceMuted && this.surfaceSize.equals(state.surfaceSize) && this.newlyRenderedFirstFrame == state.newlyRenderedFirstFrame && this.timedMetadata.equals(state.timedMetadata) && this.playlist.equals(state.playlist) && this.playlistMetadata.equals(state.playlistMetadata) && this.currentMediaItemIndex == state.currentMediaItemIndex && this.currentAdGroupIndex == state.currentAdGroupIndex && this.currentAdIndexInAdGroup == state.currentAdIndexInAdGroup && this.contentPositionMsSupplier.equals(state.contentPositionMsSupplier) && this.adPositionMsSupplier.equals(state.adPositionMsSupplier) && this.contentBufferedPositionMsSupplier.equals(state.contentBufferedPositionMsSupplier) && this.adBufferedPositionMsSupplier.equals(state.adBufferedPositionMsSupplier) && this.totalBufferedDurationMsSupplier.equals(state.totalBufferedDurationMsSupplier) && this.hasPositionDiscontinuity == state.hasPositionDiscontinuity && this.positionDiscontinuityReason == state.positionDiscontinuityReason && this.discontinuityPositionMs == state.discontinuityPositionMs) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int hashCode = (((((((((217 + this.availableCommands.hashCode()) * 31) + (this.playWhenReady ? 1 : 0)) * 31) + this.playWhenReadyChangeReason) * 31) + this.playbackState) * 31) + this.playbackSuppressionReason) * 31;
            PlaybackException playbackException = this.playerError;
            if (playbackException == null) {
                i11 = 0;
            } else {
                i11 = playbackException.hashCode();
            }
            long j11 = this.seekBackIncrementMs;
            long j12 = this.seekForwardIncrementMs;
            long j13 = this.maxSeekToPreviousPositionMs;
            long j14 = this.discontinuityPositionMs;
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode + i11) * 31) + this.repeatMode) * 31) + (this.shuffleModeEnabled ? 1 : 0)) * 31) + (this.isLoading ? 1 : 0)) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + this.playbackParameters.hashCode()) * 31) + this.trackSelectionParameters.hashCode()) * 31) + this.audioAttributes.hashCode()) * 31) + Float.floatToRawIntBits(this.volume)) * 31) + this.videoSize.hashCode()) * 31) + this.currentCues.hashCode()) * 31) + this.deviceInfo.hashCode()) * 31) + this.deviceVolume) * 31) + (this.isDeviceMuted ? 1 : 0)) * 31) + this.surfaceSize.hashCode()) * 31) + (this.newlyRenderedFirstFrame ? 1 : 0)) * 31) + this.timedMetadata.hashCode()) * 31) + this.playlist.hashCode()) * 31) + this.playlistMetadata.hashCode()) * 31) + this.currentMediaItemIndex) * 31) + this.currentAdGroupIndex) * 31) + this.currentAdIndexInAdGroup) * 31) + this.contentPositionMsSupplier.hashCode()) * 31) + this.adPositionMsSupplier.hashCode()) * 31) + this.contentBufferedPositionMsSupplier.hashCode()) * 31) + this.adBufferedPositionMsSupplier.hashCode()) * 31) + this.totalBufferedDurationMsSupplier.hashCode()) * 31) + (this.hasPositionDiscontinuity ? 1 : 0)) * 31) + this.positionDiscontinuityReason) * 31) + ((int) (j14 ^ (j14 >>> 32)));
        }

        private State(Builder builder) {
            int i11;
            long j11;
            boolean z11 = false;
            if (builder.timeline.isEmpty()) {
                Assertions.checkArgument(builder.playbackState == 1 || builder.playbackState == 4, "Empty playlist only allowed in STATE_IDLE or STATE_ENDED");
                Assertions.checkArgument(builder.currentAdGroupIndex == -1 && builder.currentAdIndexInAdGroup == -1, "Ads not allowed if playlist is empty");
            } else {
                int access$500 = builder.currentMediaItemIndex;
                if (access$500 == -1) {
                    i11 = 0;
                } else {
                    Assertions.checkArgument(builder.currentMediaItemIndex < builder.timeline.getWindowCount(), "currentMediaItemIndex must be less than playlist.size()");
                    i11 = access$500;
                }
                if (builder.currentAdGroupIndex != -1) {
                    Timeline.Period period = new Timeline.Period();
                    Timeline.Window window = new Timeline.Window();
                    if (builder.contentPositionMs != null) {
                        j11 = builder.contentPositionMs.longValue();
                    } else {
                        j11 = builder.contentPositionMsSupplier.get();
                    }
                    builder.timeline.getPeriod(SimpleBasePlayer.getPeriodIndexFromWindowPosition(builder.timeline, i11, j11, window, period), period);
                    Assertions.checkArgument(builder.currentAdGroupIndex < period.getAdGroupCount(), "PeriodData has less ad groups than adGroupIndex");
                    int adCountInAdGroup = period.getAdCountInAdGroup(builder.currentAdGroupIndex);
                    if (adCountInAdGroup != -1) {
                        Assertions.checkArgument(builder.currentAdIndexInAdGroup < adCountInAdGroup, "Ad group has less ads than adIndexInGroupIndex");
                    }
                }
            }
            if (builder.playerError != null) {
                Assertions.checkArgument(builder.playbackState == 1 ? true : z11, "Player error only allowed in STATE_IDLE");
            }
            if (builder.playbackState == 1 || builder.playbackState == 4) {
                Assertions.checkArgument(!builder.isLoading, "isLoading only allowed when not in STATE_IDLE or STATE_ENDED");
            }
            PositionSupplier access$700 = builder.contentPositionMsSupplier;
            if (builder.contentPositionMs != null) {
                if (builder.currentAdGroupIndex == -1 && builder.playWhenReady && builder.playbackState == 3 && builder.playbackSuppressionReason == 0 && builder.contentPositionMs.longValue() != C.TIME_UNSET) {
                    access$700 = k3.b(builder.contentPositionMs.longValue(), builder.playbackParameters.speed);
                } else {
                    access$700 = k3.a(builder.contentPositionMs.longValue());
                }
            }
            PositionSupplier access$1400 = builder.adPositionMsSupplier;
            if (builder.adPositionMs != null) {
                if (builder.currentAdGroupIndex == -1 || !builder.playWhenReady || builder.playbackState != 3 || builder.playbackSuppressionReason != 0) {
                    access$1400 = k3.a(builder.adPositionMs.longValue());
                } else {
                    access$1400 = k3.b(builder.adPositionMs.longValue(), 1.0f);
                }
            }
            this.availableCommands = builder.availableCommands;
            this.playWhenReady = builder.playWhenReady;
            this.playWhenReadyChangeReason = builder.playWhenReadyChangeReason;
            this.playbackState = builder.playbackState;
            this.playbackSuppressionReason = builder.playbackSuppressionReason;
            this.playerError = builder.playerError;
            this.repeatMode = builder.repeatMode;
            this.shuffleModeEnabled = builder.shuffleModeEnabled;
            this.isLoading = builder.isLoading;
            this.seekBackIncrementMs = builder.seekBackIncrementMs;
            this.seekForwardIncrementMs = builder.seekForwardIncrementMs;
            this.maxSeekToPreviousPositionMs = builder.maxSeekToPreviousPositionMs;
            this.playbackParameters = builder.playbackParameters;
            this.trackSelectionParameters = builder.trackSelectionParameters;
            this.audioAttributes = builder.audioAttributes;
            this.volume = builder.volume;
            this.videoSize = builder.videoSize;
            this.currentCues = builder.currentCues;
            this.deviceInfo = builder.deviceInfo;
            this.deviceVolume = builder.deviceVolume;
            this.isDeviceMuted = builder.isDeviceMuted;
            this.surfaceSize = builder.surfaceSize;
            this.newlyRenderedFirstFrame = builder.newlyRenderedFirstFrame;
            this.timedMetadata = builder.timedMetadata;
            this.playlist = builder.playlist;
            this.timeline = builder.timeline;
            this.playlistMetadata = builder.playlistMetadata;
            this.currentMediaItemIndex = builder.currentMediaItemIndex;
            this.currentAdGroupIndex = builder.currentAdGroupIndex;
            this.currentAdIndexInAdGroup = builder.currentAdIndexInAdGroup;
            this.contentPositionMsSupplier = access$700;
            this.adPositionMsSupplier = access$1400;
            this.contentBufferedPositionMsSupplier = builder.contentBufferedPositionMsSupplier;
            this.adBufferedPositionMsSupplier = builder.adBufferedPositionMsSupplier;
            this.totalBufferedDurationMsSupplier = builder.totalBufferedDurationMsSupplier;
            this.hasPositionDiscontinuity = builder.hasPositionDiscontinuity;
            this.positionDiscontinuityReason = builder.positionDiscontinuityReason;
            this.discontinuityPositionMs = builder.discontinuityPositionMs;
        }
    }

    public SimpleBasePlayer(Looper looper) {
        this(looper, Clock.DEFAULT);
    }

    private static State buildStateForNewPosition(State.Builder builder, State state2, long j11, List<MediaItemData> list, int i11, long j12, boolean z11) {
        boolean z12;
        int i12;
        long positionOrDefaultInMediaItem = getPositionOrDefaultInMediaItem(j11, state2);
        boolean z13 = false;
        if (!list.isEmpty() && (i11 == -1 || i11 >= list.size())) {
            j12 = -9223372036854775807L;
            i11 = 0;
        }
        if (!list.isEmpty() && j12 == C.TIME_UNSET) {
            j12 = Util.usToMs(list.get(i11).defaultPositionUs);
        }
        if (state2.playlist.isEmpty() || list.isEmpty()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12 && !state2.playlist.get(getCurrentMediaItemIndexInternal(state2)).uid.equals(list.get(i11).uid)) {
            z13 = true;
        }
        if (z12 || z13 || j12 < positionOrDefaultInMediaItem) {
            builder.setCurrentMediaItemIndex(i11).setCurrentAd(-1, -1).setContentPositionMs(j12).setContentBufferedPositionMs(k3.a(j12)).setTotalBufferedDurationMs(PositionSupplier.ZERO);
        } else if (i12 == 0) {
            builder.setCurrentMediaItemIndex(i11);
            if (state2.currentAdGroupIndex == -1 || !z11) {
                builder.setCurrentAd(-1, -1).setTotalBufferedDurationMs(k3.a(getContentBufferedPositionMsInternal(state2) - positionOrDefaultInMediaItem));
            } else {
                builder.setTotalBufferedDurationMs(k3.a(state2.adBufferedPositionMsSupplier.get() - state2.adPositionMsSupplier.get()));
            }
        } else {
            builder.setCurrentMediaItemIndex(i11).setCurrentAd(-1, -1).setContentPositionMs(j12).setContentBufferedPositionMs(k3.a(Math.max(getContentBufferedPositionMsInternal(state2), j12))).setTotalBufferedDurationMs(k3.a(Math.max(0, state2.totalBufferedDurationMsSupplier.get() - (j12 - positionOrDefaultInMediaItem))));
        }
        return builder.build();
    }

    private void clearVideoOutput(@Nullable Object obj) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(27)) {
            updateStateForPendingOperation(handleClearVideoOutput(obj), new k2(state2));
        }
    }

    private static long getContentBufferedPositionMsInternal(State state2) {
        return getPositionOrDefaultInMediaItem(state2.contentBufferedPositionMsSupplier.get(), state2);
    }

    private static long getContentPositionMsInternal(State state2) {
        return getPositionOrDefaultInMediaItem(state2.contentPositionMsSupplier.get(), state2);
    }

    private static int getCurrentMediaItemIndexInternal(State state2) {
        int i11 = state2.currentMediaItemIndex;
        if (i11 != -1) {
            return i11;
        }
        return 0;
    }

    private static int getCurrentPeriodIndexInternal(State state2, Timeline.Window window, Timeline.Period period2) {
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(state2);
        if (state2.timeline.isEmpty()) {
            return currentMediaItemIndexInternal;
        }
        return getPeriodIndexFromWindowPosition(state2.timeline, currentMediaItemIndexInternal, getContentPositionMsInternal(state2), window, period2);
    }

    private static long getCurrentPeriodOrAdPositionMs(State state2, Object obj, Timeline.Period period2) {
        if (state2.currentAdGroupIndex != -1) {
            return state2.adPositionMsSupplier.get();
        }
        return getContentPositionMsInternal(state2) - state2.timeline.getPeriodByUid(obj, period2).getPositionInWindowMs();
    }

    private static Tracks getCurrentTracksInternal(State state2) {
        if (state2.playlist.isEmpty()) {
            return Tracks.EMPTY;
        }
        return state2.playlist.get(getCurrentMediaItemIndexInternal(state2)).tracks;
    }

    private static int getMediaItemIndexInNewPlaylist(List<MediaItemData> list, Timeline timeline, int i11, Timeline.Period period2) {
        if (!list.isEmpty()) {
            Object access$4300 = list.get(i11).getPeriodUid(0);
            if (timeline.getIndexOfPeriod(access$4300) == -1) {
                return -1;
            }
            return timeline.getPeriodByUid(access$4300, period2).windowIndex;
        } else if (i11 < timeline.getWindowCount()) {
            return i11;
        } else {
            return -1;
        }
    }

    private static int getMediaItemTransitionReason(State state2, State state3, int i11, boolean z11, Timeline.Window window) {
        Timeline timeline = state2.timeline;
        Timeline timeline2 = state3.timeline;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return -1;
        }
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return 3;
        }
        Object obj = state2.timeline.getWindow(getCurrentMediaItemIndexInternal(state2), window).uid;
        Object obj2 = state3.timeline.getWindow(getCurrentMediaItemIndexInternal(state3), window).uid;
        if ((obj instanceof PlaceholderUid) && !(obj2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (!obj.equals(obj2)) {
            if (i11 == 0) {
                return 1;
            }
            if (i11 == 1) {
                return 2;
            }
            return 3;
        } else if (i11 == 0 && getContentPositionMsInternal(state2) > getContentPositionMsInternal(state3)) {
            return 0;
        } else {
            if (i11 != 1 || !z11) {
                return -1;
            }
            return 2;
        }
    }

    private static MediaMetadata getMediaMetadataInternal(State state2) {
        if (state2.playlist.isEmpty()) {
            return MediaMetadata.EMPTY;
        }
        return state2.playlist.get(getCurrentMediaItemIndexInternal(state2)).combinedMediaMetadata;
    }

    /* access modifiers changed from: private */
    public static int getPeriodIndexFromWindowPosition(Timeline timeline, int i11, long j11, Timeline.Window window, Timeline.Period period2) {
        return timeline.getIndexOfPeriod(timeline.getPeriodPositionUs(window, period2, i11, Util.msToUs(j11)).first);
    }

    private static long getPeriodOrAdDurationMs(State state2, Object obj, Timeline.Period period2) {
        long j11;
        state2.timeline.getPeriodByUid(obj, period2);
        int i11 = state2.currentAdGroupIndex;
        if (i11 == -1) {
            j11 = period2.durationUs;
        } else {
            j11 = period2.getAdDurationUs(i11, state2.currentAdIndexInAdGroup);
        }
        return Util.usToMs(j11);
    }

    private static int getPositionDiscontinuityReason(State state2, State state3, boolean z11, Timeline.Window window, Timeline.Period period2) {
        if (state3.hasPositionDiscontinuity) {
            return state3.positionDiscontinuityReason;
        }
        if (z11) {
            return 1;
        }
        if (state2.playlist.isEmpty()) {
            return -1;
        }
        if (state3.playlist.isEmpty()) {
            return 4;
        }
        Object uidOfPeriod = state2.timeline.getUidOfPeriod(getCurrentPeriodIndexInternal(state2, window, period2));
        Object uidOfPeriod2 = state3.timeline.getUidOfPeriod(getCurrentPeriodIndexInternal(state3, window, period2));
        if ((uidOfPeriod instanceof PlaceholderUid) && !(uidOfPeriod2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (uidOfPeriod2.equals(uidOfPeriod) && state2.currentAdGroupIndex == state3.currentAdGroupIndex && state2.currentAdIndexInAdGroup == state3.currentAdIndexInAdGroup) {
            long currentPeriodOrAdPositionMs = getCurrentPeriodOrAdPositionMs(state2, uidOfPeriod, period2);
            if (Math.abs(currentPeriodOrAdPositionMs - getCurrentPeriodOrAdPositionMs(state3, uidOfPeriod2, period2)) < 1000) {
                return -1;
            }
            long periodOrAdDurationMs = getPeriodOrAdDurationMs(state2, uidOfPeriod, period2);
            if (periodOrAdDurationMs == C.TIME_UNSET || currentPeriodOrAdPositionMs < periodOrAdDurationMs) {
                return 5;
            }
            return 0;
        } else if (state3.timeline.getIndexOfPeriod(uidOfPeriod) == -1) {
            return 4;
        } else {
            long currentPeriodOrAdPositionMs2 = getCurrentPeriodOrAdPositionMs(state2, uidOfPeriod, period2);
            long periodOrAdDurationMs2 = getPeriodOrAdDurationMs(state2, uidOfPeriod, period2);
            if (periodOrAdDurationMs2 == C.TIME_UNSET || currentPeriodOrAdPositionMs2 < periodOrAdDurationMs2) {
                return 3;
            }
            return 0;
        }
    }

    private static Player.PositionInfo getPositionInfo(State state2, boolean z11, Timeline.Window window, Timeline.Period period2) {
        int i11;
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        long j11;
        long j12;
        long j13;
        State state3 = state2;
        Timeline.Window window2 = window;
        Timeline.Period period3 = period2;
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(state2);
        if (!state3.timeline.isEmpty()) {
            int currentPeriodIndexInternal = getCurrentPeriodIndexInternal(state3, window2, period3);
            Object obj3 = state3.timeline.getPeriod(currentPeriodIndexInternal, period3, true).uid;
            Object obj4 = state3.timeline.getWindow(currentMediaItemIndexInternal, window2).uid;
            i11 = currentPeriodIndexInternal;
            mediaItem = window2.mediaItem;
            obj2 = obj4;
            obj = obj3;
        } else {
            obj2 = null;
            mediaItem = null;
            obj = null;
            i11 = -1;
        }
        if (z11) {
            j12 = state3.discontinuityPositionMs;
            if (state3.currentAdGroupIndex == -1) {
                j11 = j12;
            } else {
                j11 = getContentPositionMsInternal(state2);
            }
        } else {
            long contentPositionMsInternal = getContentPositionMsInternal(state2);
            if (state3.currentAdGroupIndex != -1) {
                j13 = state3.adPositionMsSupplier.get();
            } else {
                j13 = contentPositionMsInternal;
            }
            long j14 = contentPositionMsInternal;
            j12 = j13;
            j11 = j14;
        }
        return new Player.PositionInfo(obj2, currentMediaItemIndexInternal, mediaItem, obj, i11, j12, j11, state3.currentAdGroupIndex, state3.currentAdIndexInAdGroup);
    }

    private static long getPositionOrDefaultInMediaItem(long j11, State state2) {
        if (j11 != C.TIME_UNSET) {
            return j11;
        }
        if (state2.playlist.isEmpty()) {
            return 0;
        }
        return Util.usToMs(state2.playlist.get(getCurrentMediaItemIndexInternal(state2)).defaultPositionUs);
    }

    private static State getStateWithNewPlaylist(State state2, List<MediaItemData> list, Timeline.Period period2) {
        long j11;
        State.Builder buildUpon = state2.buildUpon();
        buildUpon.setPlaylist(list);
        Timeline access$100 = buildUpon.timeline;
        long j12 = state2.contentPositionMsSupplier.get();
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(state2);
        int mediaItemIndexInNewPlaylist = getMediaItemIndexInNewPlaylist(state2.playlist, access$100, currentMediaItemIndexInternal, period2);
        if (mediaItemIndexInNewPlaylist == -1) {
            j11 = C.TIME_UNSET;
        } else {
            j11 = j12;
        }
        int i11 = currentMediaItemIndexInternal + 1;
        while (mediaItemIndexInNewPlaylist == -1 && i11 < state2.playlist.size()) {
            mediaItemIndexInNewPlaylist = getMediaItemIndexInNewPlaylist(state2.playlist, access$100, i11, period2);
            i11++;
        }
        if (state2.playbackState != 1 && mediaItemIndexInNewPlaylist == -1) {
            buildUpon.setPlaybackState(4).setIsLoading(false);
        }
        return buildStateForNewPosition(buildUpon, state2, j12, list, mediaItemIndexInNewPlaylist, j11, true);
    }

    /* access modifiers changed from: private */
    public static State getStateWithNewPlaylistAndPosition(State state2, List<MediaItemData> list, int i11, long j11) {
        State.Builder buildUpon = state2.buildUpon();
        buildUpon.setPlaylist(list);
        if (state2.playbackState != 1) {
            if (list.isEmpty()) {
                buildUpon.setPlaybackState(4).setIsLoading(false);
            } else {
                buildUpon.setPlaybackState(2);
            }
        }
        return buildStateForNewPosition(buildUpon, state2, state2.contentPositionMsSupplier.get(), list, i11, j11, false);
    }

    private static Size getSurfaceHolderSize(SurfaceHolder surfaceHolder) {
        if (!surfaceHolder.getSurface().isValid()) {
            return Size.ZERO;
        }
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        return new Size(surfaceFrame.width(), surfaceFrame.height());
    }

    private static int getTimelineChangeReason(List<MediaItemData> list, List<MediaItemData> list2) {
        if (list.size() != list2.size()) {
            return 0;
        }
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= list.size()) {
                return 1;
            }
            Object obj = list.get(i11).uid;
            Object obj2 = list2.get(i11).uid;
            if (!(obj instanceof PlaceholderUid) || (obj2 instanceof PlaceholderUid)) {
                z11 = false;
            }
            if (!obj.equals(obj2) && !z11) {
                return 0;
            }
            i11++;
        }
    }

    private static boolean isPlaying(State state2) {
        return state2.playWhenReady && state2.playbackState == 3 && state2.playbackSuppressionReason == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State lambda$addMediaItems$3(State state2, List list, int i11) {
        ArrayList arrayList = new ArrayList(state2.playlist);
        for (int i12 = 0; i12 < list.size(); i12++) {
            arrayList.add(i12 + i11, getPlaceholderMediaItemData((MediaItem) list.get(i12)));
        }
        return getStateWithNewPlaylist(state2, arrayList, this.period);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State lambda$moveMediaItems$4(State state2, int i11, int i12, int i13) {
        ArrayList arrayList = new ArrayList(state2.playlist);
        Util.moveItems(arrayList, i11, i12, i13);
        return getStateWithNewPlaylist(state2, arrayList, this.period);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(this, new Player.Events(flagSet));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ State lambda$prepare$6(State state2) {
        int i11;
        State.Builder playerError = state2.buildUpon().setPlayerError((PlaybackException) null);
        if (state2.timeline.isEmpty()) {
            i11 = 4;
        } else {
            i11 = 2;
        }
        return playerError.setPlaybackState(i11).build();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ State lambda$release$12(State state2) {
        return state2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State lambda$removeMediaItems$5(State state2, int i11, int i12) {
        ArrayList arrayList = new ArrayList(state2.playlist);
        Util.removeRange(arrayList, i11, i12);
        return getStateWithNewPlaylist(state2, arrayList, this.period);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State lambda$setMediaItemsInternal$2(List list, State state2, int i11, long j11) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            arrayList.add(getPlaceholderMediaItemData((MediaItem) list.get(i12)));
        }
        return getStateWithNewPlaylistAndPosition(state2, arrayList, i11, j11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateStateAndInformListeners$26(int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(i11);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateStateAndInformListeners$33(State state2, Player.Listener listener) {
        listener.onLoadingChanged(state2.isLoading);
        listener.onIsLoadingChanged(state2.isLoading);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateStateAndInformListeners$52(State state2, Player.Listener listener) {
        listener.onCues((List<Cue>) state2.currentCues.cues);
        listener.onCues(state2.currentCues);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateStateForPendingOperation$55(ListenableFuture listenableFuture) {
        Util.castNonNull(this.state);
        this.pendingOperations.remove(listenableFuture);
        if (this.pendingOperations.isEmpty() && !this.released) {
            updateStateAndInformListeners(getState(), false, false);
        }
    }

    /* access modifiers changed from: private */
    public void postOrRunOnApplicationHandler(Runnable runnable) {
        if (this.applicationHandler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.applicationHandler.post(runnable);
        }
    }

    @RequiresNonNull({"state"})
    private void setMediaItemsInternal(List<MediaItem> list, int i11, long j11) {
        boolean z11;
        if (i11 == -1 || i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        State state2 = this.state;
        if (shouldHandleCommand(20) || (list.size() == 1 && shouldHandleCommand(31))) {
            updateStateForPendingOperation(handleSetMediaItems(list, i11, j11), new v2(this, list, state2, i11, j11));
        }
    }

    @RequiresNonNull({"state"})
    private boolean shouldHandleCommand(int i11) {
        return !this.released && this.state.availableCommands.contains(i11);
    }

    @RequiresNonNull({"state"})
    private void updateStateAndInformListeners(State state2, boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        MediaItem mediaItem;
        State state3 = state2;
        State state4 = this.state;
        this.state = state3;
        if (state3.hasPositionDiscontinuity || state3.newlyRenderedFirstFrame) {
            this.state = state2.buildUpon().clearPositionDiscontinuity().setNewlyRenderedFirstFrame(false).build();
        }
        if (state4.playWhenReady != state3.playWhenReady) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (state4.playbackState != state3.playbackState) {
            z14 = true;
        } else {
            z14 = false;
        }
        Tracks currentTracksInternal = getCurrentTracksInternal(state4);
        Tracks currentTracksInternal2 = getCurrentTracksInternal(state2);
        MediaMetadata mediaMetadataInternal = getMediaMetadataInternal(state4);
        MediaMetadata mediaMetadataInternal2 = getMediaMetadataInternal(state2);
        int positionDiscontinuityReason = getPositionDiscontinuityReason(state4, state3, z11, this.window, this.period);
        boolean z15 = !state4.timeline.equals(state3.timeline);
        int mediaItemTransitionReason = getMediaItemTransitionReason(state4, state3, positionDiscontinuityReason, z12, this.window);
        if (z15) {
            this.listeners.queueEvent(0, new n1(state3, getTimelineChangeReason(state4.playlist, state3.playlist)));
        }
        if (positionDiscontinuityReason != -1) {
            this.listeners.queueEvent(11, new a2(positionDiscontinuityReason, getPositionInfo(state4, false, this.window, this.period), getPositionInfo(state3, state3.hasPositionDiscontinuity, this.window, this.period)));
        }
        if (mediaItemTransitionReason != -1) {
            if (state3.timeline.isEmpty()) {
                mediaItem = null;
            } else {
                mediaItem = state3.playlist.get(getCurrentMediaItemIndexInternal(state2)).mediaItem;
            }
            this.listeners.queueEvent(1, new l2(mediaItem, mediaItemTransitionReason));
        }
        if (!Util.areEqual(state4.playerError, state3.playerError)) {
            this.listeners.queueEvent(10, new n2(state3));
            if (state3.playerError != null) {
                this.listeners.queueEvent(10, new o2(state3));
            }
        }
        if (!state4.trackSelectionParameters.equals(state3.trackSelectionParameters)) {
            this.listeners.queueEvent(19, new p2(state3));
        }
        if (!currentTracksInternal.equals(currentTracksInternal2)) {
            this.listeners.queueEvent(2, new q2(currentTracksInternal2));
        }
        if (!mediaMetadataInternal.equals(mediaMetadataInternal2)) {
            this.listeners.queueEvent(14, new r2(mediaMetadataInternal2));
        }
        if (state4.isLoading != state3.isLoading) {
            this.listeners.queueEvent(3, new s2(state3));
        }
        if (z13 || z14) {
            this.listeners.queueEvent(-1, new t2(state3));
        }
        if (z14) {
            this.listeners.queueEvent(4, new p1(state3));
        }
        if (z13 || state4.playWhenReadyChangeReason != state3.playWhenReadyChangeReason) {
            this.listeners.queueEvent(5, new q1(state3));
        }
        if (state4.playbackSuppressionReason != state3.playbackSuppressionReason) {
            this.listeners.queueEvent(6, new r1(state3));
        }
        if (isPlaying(state4) != isPlaying(state2)) {
            this.listeners.queueEvent(7, new s1(state3));
        }
        if (!state4.playbackParameters.equals(state3.playbackParameters)) {
            this.listeners.queueEvent(12, new t1(state3));
        }
        if (state4.repeatMode != state3.repeatMode) {
            this.listeners.queueEvent(8, new u1(state3));
        }
        if (state4.shuffleModeEnabled != state3.shuffleModeEnabled) {
            this.listeners.queueEvent(9, new v1(state3));
        }
        if (state4.seekBackIncrementMs != state3.seekBackIncrementMs) {
            this.listeners.queueEvent(16, new w1(state3));
        }
        if (state4.seekForwardIncrementMs != state3.seekForwardIncrementMs) {
            this.listeners.queueEvent(17, new x1(state3));
        }
        if (state4.maxSeekToPreviousPositionMs != state3.maxSeekToPreviousPositionMs) {
            this.listeners.queueEvent(18, new y1(state3));
        }
        if (!state4.audioAttributes.equals(state3.audioAttributes)) {
            this.listeners.queueEvent(20, new b2(state3));
        }
        if (!state4.videoSize.equals(state3.videoSize)) {
            this.listeners.queueEvent(25, new c2(state3));
        }
        if (!state4.deviceInfo.equals(state3.deviceInfo)) {
            this.listeners.queueEvent(29, new d2(state3));
        }
        if (!state4.playlistMetadata.equals(state3.playlistMetadata)) {
            this.listeners.queueEvent(15, new e2(state3));
        }
        if (state3.newlyRenderedFirstFrame) {
            this.listeners.queueEvent(26, new l0());
        }
        if (!state4.surfaceSize.equals(state3.surfaceSize)) {
            this.listeners.queueEvent(24, new f2(state3));
        }
        if (state4.volume != state3.volume) {
            this.listeners.queueEvent(22, new g2(state3));
        }
        if (!(state4.deviceVolume == state3.deviceVolume && state4.isDeviceMuted == state3.isDeviceMuted)) {
            this.listeners.queueEvent(30, new h2(state3));
        }
        if (!state4.currentCues.equals(state3.currentCues)) {
            this.listeners.queueEvent(27, new i2(state3));
        }
        if (!state4.timedMetadata.equals(state3.timedMetadata) && state3.timedMetadata.presentationTimeUs != C.TIME_UNSET) {
            this.listeners.queueEvent(28, new j2(state3));
        }
        if (positionDiscontinuityReason == 1) {
            this.listeners.queueEvent(-1, new j0());
        }
        if (!state4.availableCommands.equals(state3.availableCommands)) {
            this.listeners.queueEvent(13, new m2(state3));
        }
        this.listeners.flushEvents();
    }

    @RequiresNonNull({"state"})
    private void updateStateForPendingOperation(ListenableFuture<?> listenableFuture, Supplier<State> supplier) {
        updateStateForPendingOperation(listenableFuture, supplier, false, false);
    }

    @EnsuresNonNull({"state"})
    private void verifyApplicationThreadAndInitState() {
        if (Thread.currentThread() != this.applicationLooper.getThread()) {
            throw new IllegalStateException(Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.applicationLooper.getThread().getName()));
        } else if (this.state == null) {
            this.state = getState();
        }
    }

    public final void addListener(Player.Listener listener) {
        this.listeners.add((Player.Listener) Assertions.checkNotNull(listener));
    }

    public final void addMediaItems(int i11, List<MediaItem> list) {
        boolean z11;
        verifyApplicationThreadAndInitState();
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        State state2 = this.state;
        int size = state2.playlist.size();
        if (shouldHandleCommand(20) && !list.isEmpty()) {
            int min = Math.min(i11, size);
            updateStateForPendingOperation(handleAddMediaItems(min, list), new g1(this, state2, list, min));
        }
    }

    public final void clearVideoSurface() {
        clearVideoOutput((Object) null);
    }

    public final void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        clearVideoOutput(surfaceHolder);
    }

    public final void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        clearVideoOutput(surfaceView);
    }

    public final void clearVideoTextureView(@Nullable TextureView textureView) {
        clearVideoOutput(textureView);
    }

    public final void decreaseDeviceVolume() {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(26)) {
            updateStateForPendingOperation(handleDecreaseDeviceVolume(), new g3(state2));
        }
    }

    public final Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    public final AudioAttributes getAudioAttributes() {
        verifyApplicationThreadAndInitState();
        return this.state.audioAttributes;
    }

    public final Player.Commands getAvailableCommands() {
        verifyApplicationThreadAndInitState();
        return this.state.availableCommands;
    }

    public final long getBufferedPosition() {
        verifyApplicationThreadAndInitState();
        if (isPlayingAd()) {
            return Math.max(this.state.adBufferedPositionMsSupplier.get(), this.state.adPositionMsSupplier.get());
        }
        return getContentBufferedPosition();
    }

    public final long getContentBufferedPosition() {
        verifyApplicationThreadAndInitState();
        return Math.max(getContentBufferedPositionMsInternal(this.state), getContentPositionMsInternal(this.state));
    }

    public final long getContentPosition() {
        verifyApplicationThreadAndInitState();
        return getContentPositionMsInternal(this.state);
    }

    public final int getCurrentAdGroupIndex() {
        verifyApplicationThreadAndInitState();
        return this.state.currentAdGroupIndex;
    }

    public final int getCurrentAdIndexInAdGroup() {
        verifyApplicationThreadAndInitState();
        return this.state.currentAdIndexInAdGroup;
    }

    public final CueGroup getCurrentCues() {
        verifyApplicationThreadAndInitState();
        return this.state.currentCues;
    }

    public final int getCurrentMediaItemIndex() {
        verifyApplicationThreadAndInitState();
        return getCurrentMediaItemIndexInternal(this.state);
    }

    public final int getCurrentPeriodIndex() {
        verifyApplicationThreadAndInitState();
        return getCurrentPeriodIndexInternal(this.state, this.window, this.period);
    }

    public final long getCurrentPosition() {
        verifyApplicationThreadAndInitState();
        if (isPlayingAd()) {
            return this.state.adPositionMsSupplier.get();
        }
        return getContentPosition();
    }

    public final Timeline getCurrentTimeline() {
        verifyApplicationThreadAndInitState();
        return this.state.timeline;
    }

    public final Tracks getCurrentTracks() {
        verifyApplicationThreadAndInitState();
        return getCurrentTracksInternal(this.state);
    }

    public final DeviceInfo getDeviceInfo() {
        verifyApplicationThreadAndInitState();
        return this.state.deviceInfo;
    }

    public final int getDeviceVolume() {
        verifyApplicationThreadAndInitState();
        return this.state.deviceVolume;
    }

    public final long getDuration() {
        verifyApplicationThreadAndInitState();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        this.state.timeline.getPeriod(getCurrentPeriodIndex(), this.period);
        Timeline.Period period2 = this.period;
        State state2 = this.state;
        return Util.usToMs(period2.getAdDurationUs(state2.currentAdGroupIndex, state2.currentAdIndexInAdGroup));
    }

    public final long getMaxSeekToPreviousPosition() {
        verifyApplicationThreadAndInitState();
        return this.state.maxSeekToPreviousPositionMs;
    }

    public final MediaMetadata getMediaMetadata() {
        verifyApplicationThreadAndInitState();
        return getMediaMetadataInternal(this.state);
    }

    @ForOverride
    public MediaItemData getPlaceholderMediaItemData(MediaItem mediaItem) {
        return new MediaItemData.Builder((Object) new PlaceholderUid()).setMediaItem(mediaItem).setIsDynamic(true).setIsPlaceholder(true).build();
    }

    @ForOverride
    public State getPlaceholderState(State state2) {
        return state2;
    }

    public final boolean getPlayWhenReady() {
        verifyApplicationThreadAndInitState();
        return this.state.playWhenReady;
    }

    public final PlaybackParameters getPlaybackParameters() {
        verifyApplicationThreadAndInitState();
        return this.state.playbackParameters;
    }

    public final int getPlaybackState() {
        verifyApplicationThreadAndInitState();
        return this.state.playbackState;
    }

    public final int getPlaybackSuppressionReason() {
        verifyApplicationThreadAndInitState();
        return this.state.playbackSuppressionReason;
    }

    @Nullable
    public final PlaybackException getPlayerError() {
        verifyApplicationThreadAndInitState();
        return this.state.playerError;
    }

    public final MediaMetadata getPlaylistMetadata() {
        verifyApplicationThreadAndInitState();
        return this.state.playlistMetadata;
    }

    public final int getRepeatMode() {
        verifyApplicationThreadAndInitState();
        return this.state.repeatMode;
    }

    public final long getSeekBackIncrement() {
        verifyApplicationThreadAndInitState();
        return this.state.seekBackIncrementMs;
    }

    public final long getSeekForwardIncrement() {
        verifyApplicationThreadAndInitState();
        return this.state.seekForwardIncrementMs;
    }

    public final boolean getShuffleModeEnabled() {
        verifyApplicationThreadAndInitState();
        return this.state.shuffleModeEnabled;
    }

    @ForOverride
    public abstract State getState();

    public final Size getSurfaceSize() {
        verifyApplicationThreadAndInitState();
        return this.state.surfaceSize;
    }

    public final long getTotalBufferedDuration() {
        verifyApplicationThreadAndInitState();
        return this.state.totalBufferedDurationMsSupplier.get();
    }

    public final TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThreadAndInitState();
        return this.state.trackSelectionParameters;
    }

    public final VideoSize getVideoSize() {
        verifyApplicationThreadAndInitState();
        return this.state.videoSize;
    }

    public final float getVolume() {
        verifyApplicationThreadAndInitState();
        return this.state.volume;
    }

    @ForOverride
    public ListenableFuture<?> handleAddMediaItems(int i11, List<MediaItem> list) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    @ForOverride
    public ListenableFuture<?> handleClearVideoOutput(@Nullable Object obj) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
    }

    @ForOverride
    public ListenableFuture<?> handleDecreaseDeviceVolume() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME");
    }

    @ForOverride
    public ListenableFuture<?> handleIncreaseDeviceVolume() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME");
    }

    @ForOverride
    public ListenableFuture<?> handleMoveMediaItems(int i11, int i12, int i13) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    @ForOverride
    public ListenableFuture<?> handlePrepare() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_PREPARE");
    }

    @ForOverride
    public ListenableFuture<?> handleRelease() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_RELEASE");
    }

    @ForOverride
    public ListenableFuture<?> handleRemoveMediaItems(int i11, int i12) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    @ForOverride
    public ListenableFuture<?> handleSeek(int i11, long j11, int i12) {
        throw new IllegalStateException("Missing implementation to handle one of the COMMAND_SEEK_*");
    }

    @ForOverride
    public ListenableFuture<?> handleSetDeviceMuted(boolean z11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME");
    }

    @ForOverride
    public ListenableFuture<?> handleSetDeviceVolume(@IntRange(from = 0) int i11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_DEVICE_VOLUME");
    }

    @ForOverride
    public ListenableFuture<?> handleSetMediaItems(List<MediaItem> list, int i11, long j11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_MEDIA_ITEM(S)");
    }

    @ForOverride
    public ListenableFuture<?> handleSetPlayWhenReady(boolean z11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_PLAY_PAUSE");
    }

    @ForOverride
    public ListenableFuture<?> handleSetPlaybackParameters(PlaybackParameters playbackParameters) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SPEED_AND_PITCH");
    }

    @ForOverride
    public ListenableFuture<?> handleSetPlaylistMetadata(MediaMetadata mediaMetadata) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_MEDIA_ITEMS_METADATA");
    }

    @ForOverride
    public ListenableFuture<?> handleSetRepeatMode(int i11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_REPEAT_MODE");
    }

    @ForOverride
    public ListenableFuture<?> handleSetShuffleModeEnabled(boolean z11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SHUFFLE_MODE");
    }

    @ForOverride
    public ListenableFuture<?> handleSetTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_TRACK_SELECTION_PARAMETERS");
    }

    @ForOverride
    public ListenableFuture<?> handleSetVideoOutput(Object obj) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
    }

    @ForOverride
    public ListenableFuture<?> handleSetVolume(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VOLUME");
    }

    @ForOverride
    public ListenableFuture<?> handleStop() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_STOP");
    }

    public final void increaseDeviceVolume() {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(26)) {
            updateStateForPendingOperation(handleIncreaseDeviceVolume(), new m1(state2));
        }
    }

    public final void invalidateState() {
        verifyApplicationThreadAndInitState();
        if (this.pendingOperations.isEmpty() && !this.released) {
            updateStateAndInformListeners(getState(), false, false);
        }
    }

    public final boolean isDeviceMuted() {
        verifyApplicationThreadAndInitState();
        return this.state.isDeviceMuted;
    }

    public final boolean isLoading() {
        verifyApplicationThreadAndInitState();
        return this.state.isLoading;
    }

    public final boolean isPlayingAd() {
        verifyApplicationThreadAndInitState();
        if (this.state.currentAdGroupIndex != -1) {
            return true;
        }
        return false;
    }

    public final void moveMediaItems(int i11, int i12, int i13) {
        boolean z11;
        verifyApplicationThreadAndInitState();
        if (i11 < 0 || i12 < i11 || i13 < 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        State state2 = this.state;
        int size = state2.playlist.size();
        if (shouldHandleCommand(20) && size != 0 && i11 < size) {
            int min = Math.min(i12, size);
            int min2 = Math.min(i13, state2.playlist.size() - (min - i11));
            if (i11 != min && min2 != i11) {
                updateStateForPendingOperation(handleMoveMediaItems(i11, min, min2), new d1(this, state2, i11, min, min2));
            }
        }
    }

    public final void prepare() {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(2)) {
            updateStateForPendingOperation(handlePrepare(), new x2(state2));
        }
    }

    public final void release() {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (!this.released) {
            updateStateForPendingOperation(handleRelease(), new f3(state2));
            this.released = true;
            this.listeners.release();
            this.state = this.state.buildUpon().setPlaybackState(1).setTotalBufferedDurationMs(PositionSupplier.ZERO).setContentBufferedPositionMs(k3.a(getContentPositionMsInternal(state2))).setAdBufferedPositionMs(state2.adPositionMsSupplier).setIsLoading(false).build();
        }
    }

    public final void removeListener(Player.Listener listener) {
        verifyApplicationThreadAndInitState();
        this.listeners.remove(listener);
    }

    public final void removeMediaItems(int i11, int i12) {
        boolean z11;
        int min;
        verifyApplicationThreadAndInitState();
        if (i11 < 0 || i12 < i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        State state2 = this.state;
        int size = state2.playlist.size();
        if (shouldHandleCommand(20) && size != 0 && i11 < size && i11 != (min = Math.min(i12, size))) {
            updateStateForPendingOperation(handleRemoveMediaItems(i11, min), new z2(this, state2, i11, min));
        }
    }

    @VisibleForTesting(otherwise = 4)
    public final void seekTo(int i11, long j11, int i12, boolean z11) {
        boolean z12;
        verifyApplicationThreadAndInitState();
        if (i11 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Assertions.checkArgument(z12);
        State state2 = this.state;
        if (shouldHandleCommand(i12) && !isPlayingAd()) {
            if (state2.playlist.isEmpty() || i11 < state2.playlist.size()) {
                updateStateForPendingOperation(handleSeek(i11, j11, i12), new h1(state2, i11, j11), true, z11);
            }
        }
    }

    public final void setDeviceMuted(boolean z11) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(26)) {
            updateStateForPendingOperation(handleSetDeviceMuted(z11), new l1(state2, z11));
        }
    }

    public final void setDeviceVolume(int i11) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(25)) {
            updateStateForPendingOperation(handleSetDeviceVolume(i11), new z1(state2, i11));
        }
    }

    public final void setMediaItems(List<MediaItem> list, boolean z11) {
        int i11;
        long j11;
        verifyApplicationThreadAndInitState();
        if (z11) {
            i11 = -1;
        } else {
            i11 = this.state.currentMediaItemIndex;
        }
        if (z11) {
            j11 = C.TIME_UNSET;
        } else {
            j11 = this.state.contentPositionMsSupplier.get();
        }
        setMediaItemsInternal(list, i11, j11);
    }

    public final void setPlayWhenReady(boolean z11) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(1)) {
            updateStateForPendingOperation(handleSetPlayWhenReady(z11), new j1(state2, z11));
        }
    }

    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(13)) {
            updateStateForPendingOperation(handleSetPlaybackParameters(playbackParameters), new y2(state2, playbackParameters));
        }
    }

    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(19)) {
            updateStateForPendingOperation(handleSetPlaylistMetadata(mediaMetadata), new c3(state2, mediaMetadata));
        }
    }

    public final void setRepeatMode(int i11) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(15)) {
            updateStateForPendingOperation(handleSetRepeatMode(i11), new i1(state2, i11));
        }
    }

    public final void setShuffleModeEnabled(boolean z11) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(14)) {
            updateStateForPendingOperation(handleSetShuffleModeEnabled(z11), new f1(state2, z11));
        }
    }

    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(29)) {
            updateStateForPendingOperation(handleSetTrackSelectionParameters(trackSelectionParameters), new o1(state2, trackSelectionParameters));
        }
    }

    public final void setVideoSurface(@Nullable Surface surface) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(27)) {
            if (surface == null) {
                clearVideoSurface();
            } else {
                updateStateForPendingOperation(handleSetVideoOutput(surface), new e1(state2));
            }
        }
    }

    public final void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(27)) {
            if (surfaceHolder == null) {
                clearVideoSurface();
            } else {
                updateStateForPendingOperation(handleSetVideoOutput(surfaceHolder), new w2(state2, surfaceHolder));
            }
        }
    }

    public final void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(27)) {
            if (surfaceView == null) {
                clearVideoSurface();
            } else {
                updateStateForPendingOperation(handleSetVideoOutput(surfaceView), new h3(state2, surfaceView));
            }
        }
    }

    public final void setVideoTextureView(@Nullable TextureView textureView) {
        Size size;
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(27)) {
            if (textureView == null) {
                clearVideoSurface();
                return;
            }
            if (textureView.isAvailable()) {
                size = new Size(textureView.getWidth(), textureView.getHeight());
            } else {
                size = Size.ZERO;
            }
            updateStateForPendingOperation(handleSetVideoOutput(textureView), new k1(state2, size));
        }
    }

    public final void setVolume(float f11) {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(24)) {
            updateStateForPendingOperation(handleSetVolume(f11), new d3(state2, f11));
        }
    }

    public final void stop() {
        verifyApplicationThreadAndInitState();
        State state2 = this.state;
        if (shouldHandleCommand(3)) {
            updateStateForPendingOperation(handleStop(), new e3(state2));
        }
    }

    public SimpleBasePlayer(Looper looper, Clock clock) {
        this.applicationLooper = looper;
        this.applicationHandler = clock.createHandler(looper, (Handler.Callback) null);
        this.pendingOperations = new HashSet<>();
        this.period = new Timeline.Period();
        this.listeners = new ListenerSet<>(looper, clock, new u2(this));
    }

    @RequiresNonNull({"state"})
    private void updateStateForPendingOperation(ListenableFuture<?> listenableFuture, Supplier<State> supplier, boolean z11, boolean z12) {
        if (!listenableFuture.isDone() || !this.pendingOperations.isEmpty()) {
            this.pendingOperations.add(listenableFuture);
            updateStateAndInformListeners(getPlaceholderState(supplier.get()), z11, z12);
            listenableFuture.addListener(new a3(this, listenableFuture), new b3(this));
            return;
        }
        updateStateAndInformListeners(getState(), z11, z12);
    }

    public final void clearVideoSurface(@Nullable Surface surface) {
        clearVideoOutput(surface);
    }

    public final void setMediaItems(List<MediaItem> list, int i11, long j11) {
        verifyApplicationThreadAndInitState();
        if (i11 == -1) {
            State state2 = this.state;
            int i12 = state2.currentMediaItemIndex;
            long j12 = state2.contentPositionMsSupplier.get();
            i11 = i12;
            j11 = j12;
        }
        setMediaItemsInternal(list, i11, j11);
    }

    public final void stop(boolean z11) {
        stop();
        if (z11) {
            clearMediaItems();
        }
    }
}
