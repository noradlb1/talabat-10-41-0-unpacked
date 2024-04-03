package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import g7.o3;
import g7.p3;
import g7.q3;
import java.util.ArrayList;

public abstract class Timeline implements Bundleable {
    public static final Bundleable.Creator<Timeline> CREATOR = new o3();
    public static final Timeline EMPTY = new Timeline() {
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        public Period getPeriod(int i11, Period period, boolean z11) {
            throw new IndexOutOfBoundsException();
        }

        public int getPeriodCount() {
            return 0;
        }

        public Object getUidOfPeriod(int i11) {
            throw new IndexOutOfBoundsException();
        }

        public Window getWindow(int i11, Window window, long j11) {
            throw new IndexOutOfBoundsException();
        }

        public int getWindowCount() {
            return 0;
        }
    };
    private static final String FIELD_PERIODS = Util.intToStringMaxRadix(1);
    private static final String FIELD_SHUFFLED_WINDOW_INDICES = Util.intToStringMaxRadix(2);
    private static final String FIELD_WINDOWS = Util.intToStringMaxRadix(0);

    public static final class Period implements Bundleable {
        public static final Bundleable.Creator<Period> CREATOR = new p3();
        private static final String FIELD_AD_PLAYBACK_STATE = Util.intToStringMaxRadix(4);
        private static final String FIELD_DURATION_US = Util.intToStringMaxRadix(1);
        private static final String FIELD_PLACEHOLDER = Util.intToStringMaxRadix(3);
        private static final String FIELD_POSITION_IN_WINDOW_US = Util.intToStringMaxRadix(2);
        private static final String FIELD_WINDOW_INDEX = Util.intToStringMaxRadix(0);
        /* access modifiers changed from: private */
        public AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
        public long durationUs;
        @Nullable

        /* renamed from: id  reason: collision with root package name */
        public Object f34906id;
        public boolean isPlaceholder;
        public long positionInWindowUs;
        @Nullable
        public Object uid;
        public int windowIndex;

        /* access modifiers changed from: private */
        public static Period fromBundle(Bundle bundle) {
            AdPlaybackState adPlaybackState2;
            int i11 = bundle.getInt(FIELD_WINDOW_INDEX, 0);
            long j11 = bundle.getLong(FIELD_DURATION_US, C.TIME_UNSET);
            long j12 = bundle.getLong(FIELD_POSITION_IN_WINDOW_US, 0);
            boolean z11 = bundle.getBoolean(FIELD_PLACEHOLDER, false);
            Bundle bundle2 = bundle.getBundle(FIELD_AD_PLAYBACK_STATE);
            if (bundle2 != null) {
                adPlaybackState2 = AdPlaybackState.CREATOR.fromBundle(bundle2);
            } else {
                adPlaybackState2 = AdPlaybackState.NONE;
            }
            AdPlaybackState adPlaybackState3 = adPlaybackState2;
            Period period = new Period();
            period.set((Object) null, (Object) null, i11, j11, j12, adPlaybackState3, z11);
            return period;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            if (Util.areEqual(this.f34906id, period.f34906id) && Util.areEqual(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationUs == period.durationUs && this.positionInWindowUs == period.positionInWindowUs && this.isPlaceholder == period.isPlaceholder && Util.areEqual(this.adPlaybackState, period.adPlaybackState)) {
                return true;
            }
            return false;
        }

        public int getAdCountInAdGroup(int i11) {
            return this.adPlaybackState.getAdGroup(i11).count;
        }

        public long getAdDurationUs(int i11, int i12) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(i11);
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i12];
            }
            return C.TIME_UNSET;
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public int getAdGroupIndexAfterPositionUs(long j11) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j11, this.durationUs);
        }

        public int getAdGroupIndexForPositionUs(long j11) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j11, this.durationUs);
        }

        public long getAdGroupTimeUs(int i11) {
            return this.adPlaybackState.getAdGroup(i11).timeUs;
        }

        public long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public int getAdState(int i11, int i12) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(i11);
            if (adGroup.count != -1) {
                return adGroup.states[i12];
            }
            return 0;
        }

        @Nullable
        public Object getAdsId() {
            return this.adPlaybackState.adsId;
        }

        public long getContentResumeOffsetUs(int i11) {
            return this.adPlaybackState.getAdGroup(i11).contentResumeOffsetUs;
        }

        public long getDurationMs() {
            return Util.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public int getFirstAdIndexToPlay(int i11) {
            return this.adPlaybackState.getAdGroup(i11).getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int i11, int i12) {
            return this.adPlaybackState.getAdGroup(i11).getNextAdIndexToPlay(i12);
        }

        public long getPositionInWindowMs() {
            return Util.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public int getRemovedAdGroupCount() {
            return this.adPlaybackState.removedAdGroupCount;
        }

        public boolean hasPlayedAdGroup(int i11) {
            return !this.adPlaybackState.getAdGroup(i11).hasUnplayedAds();
        }

        public int hashCode() {
            int i11;
            Object obj = this.f34906id;
            int i12 = 0;
            if (obj == null) {
                i11 = 0;
            } else {
                i11 = obj.hashCode();
            }
            int i13 = (217 + i11) * 31;
            Object obj2 = this.uid;
            if (obj2 != null) {
                i12 = obj2.hashCode();
            }
            long j11 = this.durationUs;
            long j12 = this.positionInWindowUs;
            return ((((((((((i13 + i12) * 31) + this.windowIndex) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + this.adPlaybackState.hashCode();
        }

        public boolean isServerSideInsertedAdGroup(int i11) {
            return this.adPlaybackState.getAdGroup(i11).isServerSideInserted;
        }

        @CanIgnoreReturnValue
        public Period set(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12) {
            return set(obj, obj2, i11, j11, j12, AdPlaybackState.NONE, false);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            int i11 = this.windowIndex;
            if (i11 != 0) {
                bundle.putInt(FIELD_WINDOW_INDEX, i11);
            }
            long j11 = this.durationUs;
            if (j11 != C.TIME_UNSET) {
                bundle.putLong(FIELD_DURATION_US, j11);
            }
            long j12 = this.positionInWindowUs;
            if (j12 != 0) {
                bundle.putLong(FIELD_POSITION_IN_WINDOW_US, j12);
            }
            boolean z11 = this.isPlaceholder;
            if (z11) {
                bundle.putBoolean(FIELD_PLACEHOLDER, z11);
            }
            if (!this.adPlaybackState.equals(AdPlaybackState.NONE)) {
                bundle.putBundle(FIELD_AD_PLAYBACK_STATE, this.adPlaybackState.toBundle());
            }
            return bundle;
        }

        @CanIgnoreReturnValue
        public Period set(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12, AdPlaybackState adPlaybackState2, boolean z11) {
            this.f34906id = obj;
            this.uid = obj2;
            this.windowIndex = i11;
            this.durationUs = j11;
            this.positionInWindowUs = j12;
            this.adPlaybackState = adPlaybackState2;
            this.isPlaceholder = z11;
            return this;
        }
    }

    public static final class RemotableTimeline extends Timeline {
        private final ImmutableList<Period> periods;
        private final int[] shuffledWindowIndices;
        private final int[] windowIndicesInShuffled;
        private final ImmutableList<Window> windows;

        public RemotableTimeline(ImmutableList<Window> immutableList, ImmutableList<Period> immutableList2, int[] iArr) {
            boolean z11;
            if (immutableList.size() == iArr.length) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            this.windows = immutableList;
            this.periods = immutableList2;
            this.shuffledWindowIndices = iArr;
            this.windowIndicesInShuffled = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.windowIndicesInShuffled[iArr[i11]] = i11;
            }
        }

        public int getFirstWindowIndex(boolean z11) {
            if (isEmpty()) {
                return -1;
            }
            if (z11) {
                return this.shuffledWindowIndices[0];
            }
            return 0;
        }

        public int getIndexOfPeriod(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int getLastWindowIndex(boolean z11) {
            if (isEmpty()) {
                return -1;
            }
            if (z11) {
                return this.shuffledWindowIndices[getWindowCount() - 1];
            }
            return getWindowCount() - 1;
        }

        public int getNextWindowIndex(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 == getLastWindowIndex(z11)) {
                if (i12 == 2) {
                    return getFirstWindowIndex(z11);
                }
                return -1;
            } else if (z11) {
                return this.shuffledWindowIndices[this.windowIndicesInShuffled[i11] + 1];
            } else {
                return i11 + 1;
            }
        }

        public Period getPeriod(int i11, Period period, boolean z11) {
            Period period2 = this.periods.get(i11);
            period.set(period2.f34906id, period2.uid, period2.windowIndex, period2.durationUs, period2.positionInWindowUs, period2.adPlaybackState, period2.isPlaceholder);
            return period;
        }

        public int getPeriodCount() {
            return this.periods.size();
        }

        public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 == getFirstWindowIndex(z11)) {
                if (i12 == 2) {
                    return getLastWindowIndex(z11);
                }
                return -1;
            } else if (z11) {
                return this.shuffledWindowIndices[this.windowIndicesInShuffled[i11] - 1];
            } else {
                return i11 - 1;
            }
        }

        public Object getUidOfPeriod(int i11) {
            throw new UnsupportedOperationException();
        }

        public Window getWindow(int i11, Window window, long j11) {
            Window window2 = window;
            Window window3 = this.windows.get(i11);
            Object obj = window3.uid;
            MediaItem mediaItem = window3.mediaItem;
            MediaItem mediaItem2 = mediaItem;
            Window window4 = window3;
            Window window5 = window;
            window5.set(obj, mediaItem2, window3.manifest, window3.presentationStartTimeMs, window3.windowStartTimeMs, window3.elapsedRealtimeEpochOffsetMs, window3.isSeekable, window3.isDynamic, window3.liveConfiguration, window3.defaultPositionUs, window4.durationUs, window4.firstPeriodIndex, window4.lastPeriodIndex, window4.positionInFirstPeriodUs);
            Window window6 = window;
            window6.isPlaceholder = window4.isPlaceholder;
            return window6;
        }

        public int getWindowCount() {
            return this.windows.size();
        }
    }

    public static final class Window implements Bundleable {
        public static final Bundleable.Creator<Window> CREATOR = new q3();
        private static final Object FAKE_WINDOW_UID = new Object();
        private static final String FIELD_DEFAULT_POSITION_US = Util.intToStringMaxRadix(9);
        private static final String FIELD_DURATION_US = Util.intToStringMaxRadix(10);
        private static final String FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS = Util.intToStringMaxRadix(4);
        private static final String FIELD_FIRST_PERIOD_INDEX = Util.intToStringMaxRadix(11);
        private static final String FIELD_IS_DYNAMIC = Util.intToStringMaxRadix(6);
        private static final String FIELD_IS_PLACEHOLDER = Util.intToStringMaxRadix(8);
        private static final String FIELD_IS_SEEKABLE = Util.intToStringMaxRadix(5);
        private static final String FIELD_LAST_PERIOD_INDEX = Util.intToStringMaxRadix(12);
        private static final String FIELD_LIVE_CONFIGURATION = Util.intToStringMaxRadix(7);
        private static final String FIELD_MEDIA_ITEM = Util.intToStringMaxRadix(1);
        private static final String FIELD_POSITION_IN_FIRST_PERIOD_US = Util.intToStringMaxRadix(13);
        private static final String FIELD_PRESENTATION_START_TIME_MS = Util.intToStringMaxRadix(2);
        private static final String FIELD_WINDOW_START_TIME_MS = Util.intToStringMaxRadix(3);
        private static final MediaItem PLACEHOLDER_MEDIA_ITEM = new MediaItem.Builder().setMediaId("com.google.android.exoplayer2.Timeline").setUri(Uri.EMPTY).build();
        public static final Object SINGLE_WINDOW_UID = new Object();
        public long defaultPositionUs;
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        @Deprecated
        public boolean isLive;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;
        @Nullable
        public MediaItem.LiveConfiguration liveConfiguration;
        @Nullable
        public Object manifest;
        public MediaItem mediaItem = PLACEHOLDER_MEDIA_ITEM;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        @Deprecated
        @Nullable
        public Object tag;
        public Object uid = SINGLE_WINDOW_UID;
        public long windowStartTimeMs;

        /* access modifiers changed from: private */
        public static Window fromBundle(Bundle bundle) {
            MediaItem mediaItem2;
            MediaItem.LiveConfiguration liveConfiguration2;
            Bundle bundle2 = bundle;
            Bundle bundle3 = bundle2.getBundle(FIELD_MEDIA_ITEM);
            if (bundle3 != null) {
                mediaItem2 = MediaItem.CREATOR.fromBundle(bundle3);
            } else {
                mediaItem2 = MediaItem.EMPTY;
            }
            MediaItem mediaItem3 = mediaItem2;
            long j11 = bundle2.getLong(FIELD_PRESENTATION_START_TIME_MS, C.TIME_UNSET);
            long j12 = bundle2.getLong(FIELD_WINDOW_START_TIME_MS, C.TIME_UNSET);
            long j13 = bundle2.getLong(FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS, C.TIME_UNSET);
            boolean z11 = bundle2.getBoolean(FIELD_IS_SEEKABLE, false);
            boolean z12 = bundle2.getBoolean(FIELD_IS_DYNAMIC, false);
            Bundle bundle4 = bundle2.getBundle(FIELD_LIVE_CONFIGURATION);
            if (bundle4 != null) {
                liveConfiguration2 = MediaItem.LiveConfiguration.CREATOR.fromBundle(bundle4);
            } else {
                liveConfiguration2 = null;
            }
            MediaItem.LiveConfiguration liveConfiguration3 = liveConfiguration2;
            boolean z13 = bundle2.getBoolean(FIELD_IS_PLACEHOLDER, false);
            long j14 = bundle2.getLong(FIELD_DEFAULT_POSITION_US, 0);
            long j15 = bundle2.getLong(FIELD_DURATION_US, C.TIME_UNSET);
            int i11 = bundle2.getInt(FIELD_FIRST_PERIOD_INDEX, 0);
            int i12 = bundle2.getInt(FIELD_LAST_PERIOD_INDEX, 0);
            long j16 = bundle2.getLong(FIELD_POSITION_IN_FIRST_PERIOD_US, 0);
            Window window = r0;
            Window window2 = new Window();
            window.set(FAKE_WINDOW_UID, mediaItem3, (Object) null, j11, j12, j13, z11, z12, liveConfiguration3, j14, j15, i11, i12, j16);
            window2.isPlaceholder = z13;
            return window2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            if (Util.areEqual(this.uid, window.uid) && Util.areEqual(this.mediaItem, window.mediaItem) && Util.areEqual(this.manifest, window.manifest) && Util.areEqual(this.liveConfiguration, window.liveConfiguration) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs) {
                return true;
            }
            return false;
        }

        public long getCurrentUnixTimeMs() {
            return Util.getNowUnixTimeMs(this.elapsedRealtimeEpochOffsetMs);
        }

        public long getDefaultPositionMs() {
            return Util.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return Util.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return Util.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public int hashCode() {
            int i11;
            int hashCode = (((217 + this.uid.hashCode()) * 31) + this.mediaItem.hashCode()) * 31;
            Object obj = this.manifest;
            int i12 = 0;
            if (obj == null) {
                i11 = 0;
            } else {
                i11 = obj.hashCode();
            }
            int i13 = (hashCode + i11) * 31;
            MediaItem.LiveConfiguration liveConfiguration2 = this.liveConfiguration;
            if (liveConfiguration2 != null) {
                i12 = liveConfiguration2.hashCode();
            }
            long j11 = this.presentationStartTimeMs;
            long j12 = this.windowStartTimeMs;
            long j13 = this.elapsedRealtimeEpochOffsetMs;
            long j14 = this.defaultPositionUs;
            long j15 = this.durationUs;
            long j16 = this.positionInFirstPeriodUs;
            return ((((((((((((((((((((((i13 + i12) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31) + ((int) (j16 ^ (j16 >>> 32)));
        }

        public boolean isLive() {
            boolean z11;
            boolean z12;
            boolean z13 = this.isLive;
            if (this.liveConfiguration != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z13 == z11) {
                z12 = true;
            } else {
                z12 = false;
            }
            Assertions.checkState(z12);
            if (this.liveConfiguration != null) {
                return true;
            }
            return false;
        }

        @CanIgnoreReturnValue
        public Window set(Object obj, @Nullable MediaItem mediaItem2, @Nullable Object obj2, long j11, long j12, long j13, boolean z11, boolean z12, @Nullable MediaItem.LiveConfiguration liveConfiguration2, long j14, long j15, int i11, int i12, long j16) {
            MediaItem mediaItem3;
            Object obj3;
            boolean z13;
            MediaItem.LocalConfiguration localConfiguration;
            MediaItem mediaItem4 = mediaItem2;
            MediaItem.LiveConfiguration liveConfiguration3 = liveConfiguration2;
            this.uid = obj;
            if (mediaItem4 != null) {
                mediaItem3 = mediaItem4;
            } else {
                mediaItem3 = PLACEHOLDER_MEDIA_ITEM;
            }
            this.mediaItem = mediaItem3;
            if (mediaItem4 == null || (localConfiguration = mediaItem4.localConfiguration) == null) {
                obj3 = null;
            } else {
                obj3 = localConfiguration.tag;
            }
            this.tag = obj3;
            this.manifest = obj2;
            this.presentationStartTimeMs = j11;
            this.windowStartTimeMs = j12;
            this.elapsedRealtimeEpochOffsetMs = j13;
            this.isSeekable = z11;
            this.isDynamic = z12;
            if (liveConfiguration3 != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            this.isLive = z13;
            this.liveConfiguration = liveConfiguration3;
            this.defaultPositionUs = j14;
            this.durationUs = j15;
            this.firstPeriodIndex = i11;
            this.lastPeriodIndex = i12;
            this.positionInFirstPeriodUs = j16;
            this.isPlaceholder = false;
            return this;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (!MediaItem.EMPTY.equals(this.mediaItem)) {
                bundle.putBundle(FIELD_MEDIA_ITEM, this.mediaItem.toBundle());
            }
            long j11 = this.presentationStartTimeMs;
            if (j11 != C.TIME_UNSET) {
                bundle.putLong(FIELD_PRESENTATION_START_TIME_MS, j11);
            }
            long j12 = this.windowStartTimeMs;
            if (j12 != C.TIME_UNSET) {
                bundle.putLong(FIELD_WINDOW_START_TIME_MS, j12);
            }
            long j13 = this.elapsedRealtimeEpochOffsetMs;
            if (j13 != C.TIME_UNSET) {
                bundle.putLong(FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS, j13);
            }
            boolean z11 = this.isSeekable;
            if (z11) {
                bundle.putBoolean(FIELD_IS_SEEKABLE, z11);
            }
            boolean z12 = this.isDynamic;
            if (z12) {
                bundle.putBoolean(FIELD_IS_DYNAMIC, z12);
            }
            MediaItem.LiveConfiguration liveConfiguration2 = this.liveConfiguration;
            if (liveConfiguration2 != null) {
                bundle.putBundle(FIELD_LIVE_CONFIGURATION, liveConfiguration2.toBundle());
            }
            boolean z13 = this.isPlaceholder;
            if (z13) {
                bundle.putBoolean(FIELD_IS_PLACEHOLDER, z13);
            }
            long j14 = this.defaultPositionUs;
            if (j14 != 0) {
                bundle.putLong(FIELD_DEFAULT_POSITION_US, j14);
            }
            long j15 = this.durationUs;
            if (j15 != C.TIME_UNSET) {
                bundle.putLong(FIELD_DURATION_US, j15);
            }
            int i11 = this.firstPeriodIndex;
            if (i11 != 0) {
                bundle.putInt(FIELD_FIRST_PERIOD_INDEX, i11);
            }
            int i12 = this.lastPeriodIndex;
            if (i12 != 0) {
                bundle.putInt(FIELD_LAST_PERIOD_INDEX, i12);
            }
            long j16 = this.positionInFirstPeriodUs;
            if (j16 != 0) {
                bundle.putLong(FIELD_POSITION_IN_FIRST_PERIOD_US, j16);
            }
            return bundle;
        }
    }

    /* access modifiers changed from: private */
    public static Timeline fromBundle(Bundle bundle) {
        ImmutableList<Window> fromBundleListRetriever = fromBundleListRetriever(Window.CREATOR, BundleUtil.getBinder(bundle, FIELD_WINDOWS));
        ImmutableList<Period> fromBundleListRetriever2 = fromBundleListRetriever(Period.CREATOR, BundleUtil.getBinder(bundle, FIELD_PERIODS));
        int[] intArray = bundle.getIntArray(FIELD_SHUFFLED_WINDOW_INDICES);
        if (intArray == null) {
            intArray = generateUnshuffledIndices(fromBundleListRetriever.size());
        }
        return new RemotableTimeline(fromBundleListRetriever, fromBundleListRetriever2, intArray);
    }

    private static <T extends Bundleable> ImmutableList<T> fromBundleListRetriever(Bundleable.Creator<T> creator, @Nullable IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.of();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Bundle> list = BundleListRetriever.getList(iBinder);
        for (int i11 = 0; i11 < list.size(); i11++) {
            builder.add((Object) creator.fromBundle(list.get(i11)));
        }
        return builder.build();
    }

    private static int[] generateUnshuffledIndices(int i11) {
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = i12;
        }
        return iArr;
    }

    public boolean equals(@Nullable Object obj) {
        int lastWindowIndex;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.getWindowCount() != getWindowCount() || timeline.getPeriodCount() != getPeriodCount()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i11 = 0; i11 < getWindowCount(); i11++) {
            if (!getWindow(i11, window).equals(timeline.getWindow(i11, window2))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < getPeriodCount(); i12++) {
            if (!getPeriod(i12, period, true).equals(timeline.getPeriod(i12, period2, true))) {
                return false;
            }
        }
        int firstWindowIndex = getFirstWindowIndex(true);
        if (firstWindowIndex != timeline.getFirstWindowIndex(true) || (lastWindowIndex = getLastWindowIndex(true)) != timeline.getLastWindowIndex(true)) {
            return false;
        }
        while (firstWindowIndex != lastWindowIndex) {
            int nextWindowIndex = getNextWindowIndex(firstWindowIndex, 0, true);
            if (nextWindowIndex != timeline.getNextWindowIndex(firstWindowIndex, 0, true)) {
                return false;
            }
            firstWindowIndex = nextWindowIndex;
        }
        return true;
    }

    public int getFirstWindowIndex(boolean z11) {
        return isEmpty() ? -1 : 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z11) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i11, Period period, Window window, int i12, boolean z11) {
        int i13 = getPeriod(i11, period).windowIndex;
        if (getWindow(i13, window).lastPeriodIndex != i11) {
            return i11 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i13, i12, z11);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i11, int i12, boolean z11) {
        if (i12 != 0) {
            if (i12 == 1) {
                return i11;
            }
            if (i12 != 2) {
                throw new IllegalStateException();
            } else if (i11 == getLastWindowIndex(z11)) {
                return getFirstWindowIndex(z11);
            } else {
                return i11 + 1;
            }
        } else if (i11 == getLastWindowIndex(z11)) {
            return -1;
        } else {
            return i11 + 1;
        }
    }

    public final Period getPeriod(int i11, Period period) {
        return getPeriod(i11, period, false);
    }

    public abstract Period getPeriod(int i11, Period period, boolean z11);

    public Period getPeriodByUid(Object obj, Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public abstract int getPeriodCount();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @Deprecated
    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i11, long j11) {
        return getPeriodPositionUs(window, period, i11, j11);
    }

    public final Pair<Object, Long> getPeriodPositionUs(Window window, Period period, int i11, long j11) {
        return (Pair) Assertions.checkNotNull(getPeriodPositionUs(window, period, i11, j11, 0));
    }

    public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
        if (i12 != 0) {
            if (i12 == 1) {
                return i11;
            }
            if (i12 != 2) {
                throw new IllegalStateException();
            } else if (i11 == getFirstWindowIndex(z11)) {
                return getLastWindowIndex(z11);
            } else {
                return i11 - 1;
            }
        } else if (i11 == getFirstWindowIndex(z11)) {
            return -1;
        } else {
            return i11 - 1;
        }
    }

    public abstract Object getUidOfPeriod(int i11);

    public final Window getWindow(int i11, Window window) {
        return getWindow(i11, window, 0);
    }

    public abstract Window getWindow(int i11, Window window, long j11);

    public abstract int getWindowCount();

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int windowCount = 217 + getWindowCount();
        for (int i11 = 0; i11 < getWindowCount(); i11++) {
            windowCount = (windowCount * 31) + getWindow(i11, window).hashCode();
        }
        int periodCount = (windowCount * 31) + getPeriodCount();
        for (int i12 = 0; i12 < getPeriodCount(); i12++) {
            periodCount = (periodCount * 31) + getPeriod(i12, period, true).hashCode();
        }
        int firstWindowIndex = getFirstWindowIndex(true);
        while (firstWindowIndex != -1) {
            periodCount = (periodCount * 31) + firstWindowIndex;
            firstWindowIndex = getNextWindowIndex(firstWindowIndex, 0, true);
        }
        return periodCount;
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int i11, Period period, Window window, int i12, boolean z11) {
        return getNextPeriodIndex(i11, period, window, i12, z11) == -1;
    }

    public final Bundle toBundle() {
        ArrayList arrayList = new ArrayList();
        int windowCount = getWindowCount();
        Window window = new Window();
        for (int i11 = 0; i11 < windowCount; i11++) {
            arrayList.add(getWindow(i11, window, 0).toBundle());
        }
        ArrayList arrayList2 = new ArrayList();
        int periodCount = getPeriodCount();
        Period period = new Period();
        for (int i12 = 0; i12 < periodCount; i12++) {
            arrayList2.add(getPeriod(i12, period, false).toBundle());
        }
        int[] iArr = new int[windowCount];
        if (windowCount > 0) {
            iArr[0] = getFirstWindowIndex(true);
        }
        for (int i13 = 1; i13 < windowCount; i13++) {
            iArr[i13] = getNextWindowIndex(iArr[i13 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        BundleUtil.putBinder(bundle, FIELD_WINDOWS, new BundleListRetriever(arrayList));
        BundleUtil.putBinder(bundle, FIELD_PERIODS, new BundleListRetriever(arrayList2));
        bundle.putIntArray(FIELD_SHUFFLED_WINDOW_INDICES, iArr);
        return bundle;
    }

    public final Bundle toBundleWithOneWindowOnly(int i11) {
        Window window = getWindow(i11, new Window(), 0);
        ArrayList arrayList = new ArrayList();
        Period period = new Period();
        int i12 = window.firstPeriodIndex;
        while (true) {
            int i13 = window.lastPeriodIndex;
            if (i12 <= i13) {
                getPeriod(i12, period, false);
                period.windowIndex = 0;
                arrayList.add(period.toBundle());
                i12++;
            } else {
                window.lastPeriodIndex = i13 - window.firstPeriodIndex;
                window.firstPeriodIndex = 0;
                Bundle bundle = window.toBundle();
                Bundle bundle2 = new Bundle();
                BundleUtil.putBinder(bundle2, FIELD_WINDOWS, new BundleListRetriever(ImmutableList.of(bundle)));
                BundleUtil.putBinder(bundle2, FIELD_PERIODS, new BundleListRetriever(arrayList));
                bundle2.putIntArray(FIELD_SHUFFLED_WINDOW_INDICES, new int[]{0});
                return bundle2;
            }
        }
    }

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @Nullable
    @Deprecated
    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i11, long j11, long j12) {
        return getPeriodPositionUs(window, period, i11, j11, j12);
    }

    @Nullable
    public final Pair<Object, Long> getPeriodPositionUs(Window window, Period period, int i11, long j11, long j12) {
        Assertions.checkIndex(i11, 0, getWindowCount());
        getWindow(i11, window, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = window.getDefaultPositionUs();
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = window.firstPeriodIndex;
        getPeriod(i12, period);
        while (i12 < window.lastPeriodIndex && period.positionInWindowUs != j11) {
            int i13 = i12 + 1;
            if (getPeriod(i13, period).positionInWindowUs > j11) {
                break;
            }
            i12 = i13;
        }
        getPeriod(i12, period, true);
        long j13 = j11 - period.positionInWindowUs;
        long j14 = period.durationUs;
        if (j14 != C.TIME_UNSET) {
            j13 = Math.min(j13, j14 - 1);
        }
        return Pair.create(Assertions.checkNotNull(period.uid), Long.valueOf(Math.max(0, j13)));
    }
}
