package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b8.a;
import b8.b;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class AdPlaybackState implements Bundleable {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final Bundleable.Creator<AdPlaybackState> CREATOR = new a();
    private static final String FIELD_AD_GROUPS = Util.intToStringMaxRadix(1);
    private static final String FIELD_AD_RESUME_POSITION_US = Util.intToStringMaxRadix(2);
    private static final String FIELD_CONTENT_DURATION_US = Util.intToStringMaxRadix(3);
    private static final String FIELD_REMOVED_AD_GROUP_COUNT = Util.intToStringMaxRadix(4);
    public static final AdPlaybackState NONE = new AdPlaybackState((Object) null, new AdGroup[0], 0, C.TIME_UNSET, 0);
    private static final AdGroup REMOVED_AD_GROUP = new AdGroup(0).withAdCount(0);
    public final int adGroupCount;
    private final AdGroup[] adGroups;
    public final long adResumePositionUs;
    @Nullable
    public final Object adsId;
    public final long contentDurationUs;
    public final int removedAdGroupCount;

    public static final class AdGroup implements Bundleable {
        public static final Bundleable.Creator<AdGroup> CREATOR = new b();
        private static final String FIELD_CONTENT_RESUME_OFFSET_US = Util.intToStringMaxRadix(5);
        private static final String FIELD_COUNT = Util.intToStringMaxRadix(1);
        private static final String FIELD_DURATIONS_US = Util.intToStringMaxRadix(4);
        private static final String FIELD_IS_SERVER_SIDE_INSERTED = Util.intToStringMaxRadix(6);
        private static final String FIELD_ORIGINAL_COUNT = Util.intToStringMaxRadix(7);
        private static final String FIELD_STATES = Util.intToStringMaxRadix(3);
        private static final String FIELD_TIME_US = Util.intToStringMaxRadix(0);
        private static final String FIELD_URIS = Util.intToStringMaxRadix(2);
        public final long contentResumeOffsetUs;
        public final int count;
        public final long[] durationsUs;
        public final boolean isServerSideInserted;
        public final int originalCount;
        public final int[] states;
        public final long timeUs;
        public final Uri[] uris;

        @CheckResult
        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int i11) {
            int length = jArr.length;
            int max = Math.max(i11, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C.TIME_UNSET);
            return copyOf;
        }

        @CheckResult
        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int i11) {
            int length = iArr.length;
            int max = Math.max(i11, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        /* access modifiers changed from: private */
        public static AdGroup fromBundle(Bundle bundle) {
            Uri[] uriArr;
            long[] jArr;
            long j11 = bundle.getLong(FIELD_TIME_US);
            int i11 = bundle.getInt(FIELD_COUNT);
            int i12 = bundle.getInt(FIELD_ORIGINAL_COUNT);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_URIS);
            int[] intArray = bundle.getIntArray(FIELD_STATES);
            long[] longArray = bundle.getLongArray(FIELD_DURATIONS_US);
            long j12 = bundle.getLong(FIELD_CONTENT_RESUME_OFFSET_US);
            boolean z11 = bundle.getBoolean(FIELD_IS_SERVER_SIDE_INSERTED);
            if (intArray == null) {
                intArray = new int[0];
            }
            int[] iArr = intArray;
            if (parcelableArrayList == null) {
                uriArr = new Uri[0];
            } else {
                uriArr = (Uri[]) parcelableArrayList.toArray(new Uri[0]);
            }
            if (longArray == null) {
                jArr = new long[0];
            } else {
                jArr = longArray;
            }
            return new AdGroup(j11, i11, i12, iArr, uriArr, jArr, j12, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            if (this.timeUs == adGroup.timeUs && this.count == adGroup.count && this.originalCount == adGroup.originalCount && Arrays.equals(this.uris, adGroup.uris) && Arrays.equals(this.states, adGroup.states) && Arrays.equals(this.durationsUs, adGroup.durationsUs) && this.contentResumeOffsetUs == adGroup.contentResumeOffsetUs && this.isServerSideInserted == adGroup.isServerSideInserted) {
                return true;
            }
            return false;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(@IntRange(from = -1) int i11) {
            int i12;
            int i13 = i11 + 1;
            while (true) {
                int[] iArr = this.states;
                if (i13 >= iArr.length || this.isServerSideInserted || (i12 = iArr[i13]) == 0 || i12 == 1) {
                    return i13;
                }
                i13++;
            }
            return i13;
        }

        public boolean hasUnplayedAds() {
            if (this.count == -1) {
                return true;
            }
            for (int i11 = 0; i11 < this.count; i11++) {
                int i12 = this.states[i11];
                if (i12 == 0 || i12 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            long j11 = this.timeUs;
            long j12 = this.contentResumeOffsetUs;
            return (((((((((((((this.count * 31) + this.originalCount) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.uris)) * 31) + Arrays.hashCode(this.states)) * 31) + Arrays.hashCode(this.durationsUs)) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.isServerSideInserted ? 1 : 0);
        }

        public boolean shouldPlayAdGroup() {
            return this.count == -1 || getFirstAdIndexToPlay() < this.count;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(FIELD_TIME_US, this.timeUs);
            bundle.putInt(FIELD_COUNT, this.count);
            bundle.putInt(FIELD_ORIGINAL_COUNT, this.originalCount);
            bundle.putParcelableArrayList(FIELD_URIS, new ArrayList(Arrays.asList(this.uris)));
            bundle.putIntArray(FIELD_STATES, this.states);
            bundle.putLongArray(FIELD_DURATIONS_US, this.durationsUs);
            bundle.putLong(FIELD_CONTENT_RESUME_OFFSET_US, this.contentResumeOffsetUs);
            bundle.putBoolean(FIELD_IS_SERVER_SIDE_INSERTED, this.isServerSideInserted);
            return bundle;
        }

        @CheckResult
        public AdGroup withAdCount(int i11) {
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i11);
            long[] copyDurationsUsWithSpaceForAdCount = copyDurationsUsWithSpaceForAdCount(this.durationsUs, i11);
            return new AdGroup(this.timeUs, i11, this.originalCount, copyStatesWithSpaceForAdCount, (Uri[]) Arrays.copyOf(this.uris, i11), copyDurationsUsWithSpaceForAdCount, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAdDurationsUs(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, uriArr.length);
            } else if (this.count != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new AdGroup(this.timeUs, this.count, this.originalCount, this.states, this.uris, jArr, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAdState(int i11, @IntRange(from = 0) int i12) {
            boolean z11;
            int i13 = i11;
            int i14 = i12;
            int i15 = this.count;
            boolean z12 = false;
            if (i15 == -1 || i14 < i15) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i14 + 1);
            int i16 = copyStatesWithSpaceForAdCount[i14];
            if (i16 == 0 || i16 == 1 || i16 == i13) {
                z12 = true;
            }
            Assertions.checkArgument(z12);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            long[] jArr2 = jArr;
            Uri[] uriArr = this.uris;
            if (uriArr.length != copyStatesWithSpaceForAdCount.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, copyStatesWithSpaceForAdCount.length);
            }
            copyStatesWithSpaceForAdCount[i14] = i13;
            return new AdGroup(this.timeUs, this.count, this.originalCount, copyStatesWithSpaceForAdCount, uriArr, jArr2, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAdUri(Uri uri, @IntRange(from = 0) int i11) {
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i11 + 1);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            long[] jArr2 = jArr;
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, copyStatesWithSpaceForAdCount.length);
            uriArr[i11] = uri;
            copyStatesWithSpaceForAdCount[i11] = 1;
            return new AdGroup(this.timeUs, this.count, this.originalCount, copyStatesWithSpaceForAdCount, uriArr, jArr2, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAllAdsReset() {
            int i11;
            if (this.count == -1) {
                return this;
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i12 = 0; i12 < length; i12++) {
                int i13 = copyOf[i12];
                if (i13 == 3 || i13 == 2 || i13 == 4) {
                    if (this.uris[i12] == null) {
                        i11 = 0;
                    } else {
                        i11 = 1;
                    }
                    copyOf[i12] = i11;
                }
            }
            return new AdGroup(this.timeUs, length, this.originalCount, copyOf, this.uris, this.durationsUs, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(this.timeUs, 0, this.originalCount, new int[0], new Uri[0], new long[0], this.contentResumeOffsetUs, this.isServerSideInserted);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = copyOf[i11];
                if (i12 == 1 || i12 == 0) {
                    copyOf[i11] = 2;
                }
            }
            return new AdGroup(this.timeUs, length, this.originalCount, copyOf, this.uris, this.durationsUs, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withContentResumeOffsetUs(long j11) {
            return new AdGroup(this.timeUs, this.count, this.originalCount, this.states, this.uris, this.durationsUs, j11, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withIsServerSideInserted(boolean z11) {
            return new AdGroup(this.timeUs, this.count, this.originalCount, this.states, this.uris, this.durationsUs, this.contentResumeOffsetUs, z11);
        }

        public AdGroup withLastAdRemoved() {
            int[] iArr = this.states;
            int length = iArr.length - 1;
            int[] copyOf = Arrays.copyOf(iArr, length);
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, length);
            long[] jArr = this.durationsUs;
            if (jArr.length > length) {
                jArr = Arrays.copyOf(jArr, length);
            }
            long[] jArr2 = jArr;
            return new AdGroup(this.timeUs, length, this.originalCount, copyOf, uriArr, jArr2, Util.sum(jArr2), this.isServerSideInserted);
        }

        public AdGroup withOriginalAdCount(int i11) {
            return new AdGroup(this.timeUs, this.count, i11, this.states, this.uris, this.durationsUs, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withTimeUs(long j11) {
            return new AdGroup(j11, this.count, this.originalCount, this.states, this.uris, this.durationsUs, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        public AdGroup(long j11) {
            this(j11, -1, -1, new int[0], new Uri[0], new long[0], 0, false);
        }

        private AdGroup(long j11, int i11, int i12, int[] iArr, Uri[] uriArr, long[] jArr, long j12, boolean z11) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.timeUs = j11;
            this.count = i11;
            this.originalCount = i12;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
            this.contentResumeOffsetUs = j12;
            this.isServerSideInserted = z11;
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public AdPlaybackState(Object obj, long... jArr) {
        this(obj, createEmptyAdGroups(jArr), 0, C.TIME_UNSET, 0);
    }

    private static AdGroup[] createEmptyAdGroups(long[] jArr) {
        int length = jArr.length;
        AdGroup[] adGroupArr = new AdGroup[length];
        for (int i11 = 0; i11 < length; i11++) {
            adGroupArr[i11] = new AdGroup(jArr[i11]);
        }
        return adGroupArr;
    }

    public static AdPlaybackState fromAdPlaybackState(Object obj, AdPlaybackState adPlaybackState) {
        AdPlaybackState adPlaybackState2 = adPlaybackState;
        int i11 = adPlaybackState2.adGroupCount - adPlaybackState2.removedAdGroupCount;
        AdGroup[] adGroupArr = new AdGroup[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            AdGroup adGroup = adPlaybackState2.adGroups[i12];
            long j11 = adGroup.timeUs;
            int i13 = adGroup.count;
            int i14 = adGroup.originalCount;
            int[] iArr = adGroup.states;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            Uri[] uriArr = adGroup.uris;
            long[] jArr = adGroup.durationsUs;
            adGroupArr[i12] = new AdGroup(j11, i13, i14, copyOf, (Uri[]) Arrays.copyOf(uriArr, uriArr.length), Arrays.copyOf(jArr, jArr.length), adGroup.contentResumeOffsetUs, adGroup.isServerSideInserted);
        }
        return new AdPlaybackState(obj, adGroupArr, adPlaybackState2.adResumePositionUs, adPlaybackState2.contentDurationUs, adPlaybackState2.removedAdGroupCount);
    }

    /* access modifiers changed from: private */
    public static AdPlaybackState fromBundle(Bundle bundle) {
        AdGroup[] adGroupArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_AD_GROUPS);
        if (parcelableArrayList == null) {
            adGroupArr = new AdGroup[0];
        } else {
            AdGroup[] adGroupArr2 = new AdGroup[parcelableArrayList.size()];
            for (int i11 = 0; i11 < parcelableArrayList.size(); i11++) {
                adGroupArr2[i11] = AdGroup.CREATOR.fromBundle((Bundle) parcelableArrayList.get(i11));
            }
            adGroupArr = adGroupArr2;
        }
        String str = FIELD_AD_RESUME_POSITION_US;
        AdPlaybackState adPlaybackState = NONE;
        return new AdPlaybackState((Object) null, adGroupArr, bundle.getLong(str, adPlaybackState.adResumePositionUs), bundle.getLong(FIELD_CONTENT_DURATION_US, adPlaybackState.contentDurationUs), bundle.getInt(FIELD_REMOVED_AD_GROUP_COUNT, adPlaybackState.removedAdGroupCount));
    }

    private boolean isPositionBeforeAdGroup(long j11, long j12, int i11) {
        if (j11 == Long.MIN_VALUE) {
            return false;
        }
        long j13 = getAdGroup(i11).timeUs;
        return j13 == Long.MIN_VALUE ? j12 == C.TIME_UNSET || j11 < j12 : j11 < j13;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        if (Util.areEqual(this.adsId, adPlaybackState.adsId) && this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && this.removedAdGroupCount == adPlaybackState.removedAdGroupCount && Arrays.equals(this.adGroups, adPlaybackState.adGroups)) {
            return true;
        }
        return false;
    }

    public AdGroup getAdGroup(@IntRange(from = 0) int i11) {
        int i12 = this.removedAdGroupCount;
        if (i11 < i12) {
            return REMOVED_AD_GROUP;
        }
        return this.adGroups[i11 - i12];
    }

    public int getAdGroupIndexAfterPositionUs(long j11, long j12) {
        if (j11 == Long.MIN_VALUE) {
            return -1;
        }
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            return -1;
        }
        int i11 = this.removedAdGroupCount;
        while (i11 < this.adGroupCount && ((getAdGroup(i11).timeUs != Long.MIN_VALUE && getAdGroup(i11).timeUs <= j11) || !getAdGroup(i11).shouldPlayAdGroup())) {
            i11++;
        }
        if (i11 < this.adGroupCount) {
            return i11;
        }
        return -1;
    }

    public int getAdGroupIndexForPositionUs(long j11, long j12) {
        int i11 = this.adGroupCount - 1;
        while (i11 >= 0 && isPositionBeforeAdGroup(j11, j12, i11)) {
            i11--;
        }
        if (i11 < 0 || !getAdGroup(i11).hasUnplayedAds()) {
            return -1;
        }
        return i11;
    }

    public int hashCode() {
        int i11;
        int i12 = this.adGroupCount * 31;
        Object obj = this.adsId;
        if (obj == null) {
            i11 = 0;
        } else {
            i11 = obj.hashCode();
        }
        return ((((((((i12 + i11) * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + this.removedAdGroupCount) * 31) + Arrays.hashCode(this.adGroups);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = getAdGroup(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAdInErrorState(@androidx.annotation.IntRange(from = 0) int r4, @androidx.annotation.IntRange(from = 0) int r5) {
        /*
            r3 = this;
            int r0 = r3.adGroupCount
            r1 = 0
            if (r4 < r0) goto L_0x0006
            return r1
        L_0x0006:
            com.google.android.exoplayer2.source.ads.AdPlaybackState$AdGroup r4 = r3.getAdGroup(r4)
            int r0 = r4.count
            r2 = -1
            if (r0 == r2) goto L_0x001a
            if (r5 < r0) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            int[] r4 = r4.states
            r4 = r4[r5]
            r5 = 4
            if (r4 != r5) goto L_0x001a
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ads.AdPlaybackState.isAdInErrorState(int, int):boolean");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (AdGroup bundle2 : this.adGroups) {
            arrayList.add(bundle2.toBundle());
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(FIELD_AD_GROUPS, arrayList);
        }
        long j11 = this.adResumePositionUs;
        AdPlaybackState adPlaybackState = NONE;
        if (j11 != adPlaybackState.adResumePositionUs) {
            bundle.putLong(FIELD_AD_RESUME_POSITION_US, j11);
        }
        long j12 = this.contentDurationUs;
        if (j12 != adPlaybackState.contentDurationUs) {
            bundle.putLong(FIELD_CONTENT_DURATION_US, j12);
        }
        int i11 = this.removedAdGroupCount;
        if (i11 != adPlaybackState.removedAdGroupCount) {
            bundle.putInt(FIELD_REMOVED_AD_GROUP_COUNT, i11);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.adsId);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.adResumePositionUs);
        sb2.append(", adGroups=[");
        for (int i11 = 0; i11 < this.adGroups.length; i11++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.adGroups[i11].timeUs);
            sb2.append(", ads=[");
            for (int i12 = 0; i12 < this.adGroups[i11].states.length; i12++) {
                sb2.append("ad(state=");
                int i13 = this.adGroups[i11].states[i12];
                if (i13 == 0) {
                    sb2.append('_');
                } else if (i13 == 1) {
                    sb2.append('R');
                } else if (i13 == 2) {
                    sb2.append('S');
                } else if (i13 == 3) {
                    sb2.append('P');
                } else if (i13 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.adGroups[i11].durationsUs[i12]);
                sb2.append(')');
                if (i12 < this.adGroups[i11].states.length - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
            sb2.append("])");
            if (i11 < this.adGroups.length - 1) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append("])");
        return sb2.toString();
    }

    @CheckResult
    public AdPlaybackState withAdCount(@IntRange(from = 0) int i11, @IntRange(from = 1) int i12) {
        boolean z11;
        if (i12 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        int i13 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i13].count == i12) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i13] = this.adGroups[i13].withAdCount(i12);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdDurationsUs(long[][] jArr) {
        Assertions.checkState(this.removedAdGroupCount == 0);
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        for (int i11 = 0; i11 < this.adGroupCount; i11++) {
            adGroupArr2[i11] = adGroupArr2[i11].withAdDurationsUs(jArr[i11]);
        }
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdGroupTimeUs(@IntRange(from = 0) int i11, long j11) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i12] = this.adGroups[i12].withTimeUs(j11);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdLoadError(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12) {
        int i13 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i13] = adGroupArr2[i13].withAdState(4, i12);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdResumePositionUs(long j11) {
        if (this.adResumePositionUs == j11) {
            return this;
        }
        return new AdPlaybackState(this.adsId, this.adGroups, j11, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAvailableAd(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12) {
        return withAvailableAdUri(i11, i12, Uri.EMPTY);
    }

    @CheckResult
    public AdPlaybackState withAvailableAdUri(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12, Uri uri) {
        boolean z11;
        int i13 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        if (!Uri.EMPTY.equals(uri) || adGroupArr2[i13].isServerSideInserted) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        adGroupArr2[i13] = adGroupArr2[i13].withAdUri(uri, i12);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withContentDurationUs(long j11) {
        if (this.contentDurationUs == j11) {
            return this;
        }
        return new AdPlaybackState(this.adsId, this.adGroups, this.adResumePositionUs, j11, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withContentResumeOffsetUs(@IntRange(from = 0) int i11, long j11) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i12].contentResumeOffsetUs == j11) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i12] = adGroupArr2[i12].withContentResumeOffsetUs(j11);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withIsServerSideInserted(@IntRange(from = 0) int i11, boolean z11) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i12].isServerSideInserted == z11) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i12] = adGroupArr2[i12].withIsServerSideInserted(z11);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withLastAdRemoved(@IntRange(from = 0) int i11) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i12] = adGroupArr2[i12].withLastAdRemoved();
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withNewAdGroup(@IntRange(from = 0) int i11, long j11) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup adGroup = new AdGroup(j11);
        AdGroup[] adGroupArr = (AdGroup[]) Util.nullSafeArrayAppend(this.adGroups, adGroup);
        System.arraycopy(adGroupArr, i12, adGroupArr, i12 + 1, this.adGroups.length - i12);
        adGroupArr[i12] = adGroup;
        return new AdPlaybackState(this.adsId, adGroupArr, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withOriginalAdCount(@IntRange(from = 0) int i11, int i12) {
        int i13 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i13].originalCount == i12) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i13] = adGroupArr2[i13].withOriginalAdCount(i12);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withPlayedAd(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12) {
        int i13 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i13] = adGroupArr2[i13].withAdState(3, i12);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withRemovedAdGroupCount(@IntRange(from = 0) int i11) {
        boolean z11;
        int i12 = this.removedAdGroupCount;
        if (i12 == i11) {
            return this;
        }
        if (i11 > i12) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        int i13 = this.adGroupCount - i11;
        AdGroup[] adGroupArr = new AdGroup[i13];
        System.arraycopy(this.adGroups, i11 - this.removedAdGroupCount, adGroupArr, 0, i13);
        return new AdPlaybackState(this.adsId, adGroupArr, this.adResumePositionUs, this.contentDurationUs, i11);
    }

    @CheckResult
    public AdPlaybackState withResetAdGroup(@IntRange(from = 0) int i11) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i12] = adGroupArr2[i12].withAllAdsReset();
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withSkippedAd(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12) {
        int i13 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i13] = adGroupArr2[i13].withAdState(2, i12);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withSkippedAdGroup(@IntRange(from = 0) int i11) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i12] = adGroupArr2[i12].withAllAdsSkipped();
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    private AdPlaybackState(@Nullable Object obj, AdGroup[] adGroupArr, long j11, long j12, int i11) {
        this.adsId = obj;
        this.adResumePositionUs = j11;
        this.contentDurationUs = j12;
        this.adGroupCount = adGroupArr.length + i11;
        this.adGroups = adGroupArr;
        this.removedAdGroupCount = i11;
    }

    @CheckResult
    public AdPlaybackState withAdDurationsUs(@IntRange(from = 0) int i11, long... jArr) {
        int i12 = i11 - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i12] = adGroupArr2[i12].withAdDurationsUs(jArr);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }
}
