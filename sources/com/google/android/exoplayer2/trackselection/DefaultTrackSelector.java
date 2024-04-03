package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import g7.c1;
import j8.b;
import j8.c;
import j8.d;
import j8.e;
import j8.f;
import j8.g;
import j8.h;
import j8.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import y1.a;

public class DefaultTrackSelector extends MappingTrackSelector {
    private static final String AUDIO_CHANNEL_COUNT_CONSTRAINTS_WARN_MESSAGE = "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.";
    /* access modifiers changed from: private */
    public static final Ordering<Integer> FORMAT_VALUE_ORDERING = Ordering.from(new c());
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    /* access modifiers changed from: private */
    public static final Ordering<Integer> NO_ORDER = Ordering.from(new d());
    protected static final int SELECTION_ELIGIBILITY_ADAPTIVE = 2;
    protected static final int SELECTION_ELIGIBILITY_FIXED = 1;
    protected static final int SELECTION_ELIGIBILITY_NO = 0;
    private static final String TAG = "DefaultTrackSelector";
    @GuardedBy("lock")
    private AudioAttributes audioAttributes;
    @Nullable
    public final Context context;
    private final boolean deviceIsTV;
    private final Object lock;
    @GuardedBy("lock")
    private Parameters parameters;
    @GuardedBy("lock")
    @Nullable
    private SpatializerWrapperV32 spatializer;
    private final ExoTrackSelection.Factory trackSelectionFactory;

    public static final class AudioTrackInfo extends TrackInfo<AudioTrackInfo> implements Comparable<AudioTrackInfo> {
        private final int bitrate;
        private final int channelCount;
        private final boolean hasMainOrNoRoleFlag;
        private final boolean isDefaultSelectionFlag;
        private final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        @Nullable
        private final String language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(this.format.language);
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredMimeTypeMatchIndex;
        private final int preferredRoleFlagsScore;
        private final int sampleRate;
        private final int selectionEligibility;
        private final boolean usesHardwareAcceleration;
        private final boolean usesPrimaryDecoder;

        public AudioTrackInfo(int i11, TrackGroup trackGroup, int i12, Parameters parameters2, int i13, boolean z11, Predicate<Format> predicate) {
            super(i11, trackGroup, i12);
            int i14;
            int i15;
            boolean z12;
            boolean z13;
            boolean z14;
            int i16;
            boolean z15;
            this.parameters = parameters2;
            boolean z16 = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i13, false);
            int i17 = 0;
            while (true) {
                i14 = Integer.MAX_VALUE;
                if (i17 >= parameters2.preferredAudioLanguages.size()) {
                    i15 = 0;
                    i17 = Integer.MAX_VALUE;
                    break;
                }
                i15 = DefaultTrackSelector.getFormatLanguageScore(this.format, parameters2.preferredAudioLanguages.get(i17), false);
                if (i15 > 0) {
                    break;
                }
                i17++;
            }
            this.preferredLanguageIndex = i17;
            this.preferredLanguageScore = i15;
            this.preferredRoleFlagsScore = DefaultTrackSelector.getRoleFlagMatchScore(this.format.roleFlags, parameters2.preferredAudioRoleFlags);
            Format format = this.format;
            int i18 = format.roleFlags;
            if (i18 == 0 || (i18 & 1) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            this.hasMainOrNoRoleFlag = z12;
            if ((format.selectionFlags & 1) != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            this.isDefaultSelectionFlag = z13;
            int i19 = format.channelCount;
            this.channelCount = i19;
            this.sampleRate = format.sampleRate;
            int i21 = format.bitrate;
            this.bitrate = i21;
            if ((i21 == -1 || i21 <= parameters2.maxAudioBitrate) && ((i19 == -1 || i19 <= parameters2.maxAudioChannelCount) && predicate.apply(format))) {
                z14 = true;
            } else {
                z14 = false;
            }
            this.isWithinConstraints = z14;
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i22 = 0;
            while (true) {
                if (i22 >= systemLanguageCodes.length) {
                    i16 = 0;
                    i22 = Integer.MAX_VALUE;
                    break;
                }
                i16 = DefaultTrackSelector.getFormatLanguageScore(this.format, systemLanguageCodes[i22], false);
                if (i16 > 0) {
                    break;
                }
                i22++;
            }
            this.localeLanguageMatchIndex = i22;
            this.localeLanguageScore = i16;
            int i23 = 0;
            while (true) {
                if (i23 < parameters2.preferredAudioMimeTypes.size()) {
                    String str = this.format.sampleMimeType;
                    if (str != null && str.equals(parameters2.preferredAudioMimeTypes.get(i23))) {
                        i14 = i23;
                        break;
                    }
                    i23++;
                } else {
                    break;
                }
            }
            this.preferredMimeTypeMatchIndex = i14;
            if (c1.e(i13) == 128) {
                z15 = true;
            } else {
                z15 = false;
            }
            this.usesPrimaryDecoder = z15;
            this.usesHardwareAcceleration = c1.g(i13) == 64 ? true : z16;
            this.selectionEligibility = evaluateSelectionEligibility(i13, z11);
        }

        public static int compareSelections(List<AudioTrackInfo> list, List<AudioTrackInfo> list2) {
            return ((AudioTrackInfo) Collections.max(list)).compareTo((AudioTrackInfo) Collections.max(list2));
        }

        public static ImmutableList<AudioTrackInfo> createForTrackGroup(int i11, TrackGroup trackGroup, Parameters parameters2, int[] iArr, boolean z11, Predicate<Format> predicate) {
            ImmutableList.Builder builder = ImmutableList.builder();
            TrackGroup trackGroup2 = trackGroup;
            for (int i12 = 0; i12 < trackGroup2.length; i12++) {
                builder.add((Object) new AudioTrackInfo(i11, trackGroup, i12, parameters2, iArr[i12], z11, predicate));
            }
            return builder.build();
        }

        private int evaluateSelectionEligibility(int i11, boolean z11) {
            if (!DefaultTrackSelector.isSupported(i11, this.parameters.exceedRendererCapabilitiesIfNecessary)) {
                return 0;
            }
            if (!this.isWithinConstraints && !this.parameters.exceedAudioConstraintsIfNecessary) {
                return 0;
            }
            if (DefaultTrackSelector.isSupported(i11, false) && this.isWithinConstraints && this.format.bitrate != -1) {
                Parameters parameters2 = this.parameters;
                if (parameters2.forceHighestSupportedBitrate || parameters2.forceLowestBitrate || (!parameters2.allowMultipleAdaptiveSelections && z11)) {
                    return 1;
                }
                return 2;
            }
            return 1;
        }

        public int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        public int compareTo(AudioTrackInfo audioTrackInfo) {
            Ordering ordering;
            if (!this.isWithinConstraints || !this.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, audioTrackInfo.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(audioTrackInfo.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, audioTrackInfo.preferredLanguageScore).compare(this.preferredRoleFlagsScore, audioTrackInfo.preferredRoleFlagsScore).compareFalseFirst(this.isDefaultSelectionFlag, audioTrackInfo.isDefaultSelectionFlag).compareFalseFirst(this.hasMainOrNoRoleFlag, audioTrackInfo.hasMainOrNoRoleFlag).compare(Integer.valueOf(this.localeLanguageMatchIndex), Integer.valueOf(audioTrackInfo.localeLanguageMatchIndex), Ordering.natural().reverse()).compare(this.localeLanguageScore, audioTrackInfo.localeLanguageScore).compareFalseFirst(this.isWithinConstraints, audioTrackInfo.isWithinConstraints).compare(Integer.valueOf(this.preferredMimeTypeMatchIndex), Integer.valueOf(audioTrackInfo.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compare(Integer.valueOf(this.bitrate), Integer.valueOf(audioTrackInfo.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compareFalseFirst(this.usesPrimaryDecoder, audioTrackInfo.usesPrimaryDecoder).compareFalseFirst(this.usesHardwareAcceleration, audioTrackInfo.usesHardwareAcceleration).compare(Integer.valueOf(this.channelCount), Integer.valueOf(audioTrackInfo.channelCount), ordering).compare(Integer.valueOf(this.sampleRate), Integer.valueOf(audioTrackInfo.sampleRate), ordering);
            Integer valueOf = Integer.valueOf(this.bitrate);
            Integer valueOf2 = Integer.valueOf(audioTrackInfo.bitrate);
            if (!Util.areEqual(this.language, audioTrackInfo.language)) {
                ordering = DefaultTrackSelector.NO_ORDER;
            }
            return compare.compare(valueOf, valueOf2, ordering).result();
        }

        public boolean isCompatibleForAdaptationWith(AudioTrackInfo audioTrackInfo) {
            int i11;
            String str;
            int i12;
            Parameters parameters2 = this.parameters;
            if ((parameters2.allowAudioMixedChannelCountAdaptiveness || ((i12 = this.format.channelCount) != -1 && i12 == audioTrackInfo.format.channelCount)) && (parameters2.allowAudioMixedMimeTypeAdaptiveness || ((str = this.format.sampleMimeType) != null && TextUtils.equals(str, audioTrackInfo.format.sampleMimeType)))) {
                Parameters parameters3 = this.parameters;
                if ((parameters3.allowAudioMixedSampleRateAdaptiveness || ((i11 = this.format.sampleRate) != -1 && i11 == audioTrackInfo.format.sampleRate)) && (parameters3.allowAudioMixedDecoderSupportAdaptiveness || (this.usesPrimaryDecoder == audioTrackInfo.usesPrimaryDecoder && this.usesHardwareAcceleration == audioTrackInfo.usesHardwareAcceleration))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class OtherTrackScore implements Comparable<OtherTrackScore> {
        private final boolean isDefault;
        private final boolean isWithinRendererCapabilities;

        public OtherTrackScore(Format format, int i11) {
            this.isDefault = (format.selectionFlags & 1) == 0 ? false : true;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i11, false);
        }

        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, otherTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isDefault, otherTrackScore.isDefault).result();
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Bundleable.Creator<Parameters> CREATOR = new h();
        @Deprecated
        public static final Parameters DEFAULT;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT;
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_AUDIO_MIXED_CHANNEL_COUNT_ADAPTIVENESS = Util.intToStringMaxRadix(1006);
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_AUDIO_MIXED_DECODER_SUPPORT_ADAPTIVENESS = Util.intToStringMaxRadix(1015);
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_AUDIO_MIXED_MIME_TYPE_ADAPTIVENESS = Util.intToStringMaxRadix(1004);
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_AUDIO_MIXED_SAMPLE_RATE_ADAPTIVENESS = Util.intToStringMaxRadix(1005);
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_MULTIPLE_ADAPTIVE_SELECTIONS = Util.intToStringMaxRadix(1009);
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_VIDEO_MIXED_DECODER_SUPPORT_ADAPTIVENESS = Util.intToStringMaxRadix(1014);
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_VIDEO_MIXED_MIME_TYPE_ADAPTIVENESS = Util.intToStringMaxRadix(1001);
        /* access modifiers changed from: private */
        public static final String FIELD_ALLOW_VIDEO_NON_SEAMLESS_ADAPTIVENESS = Util.intToStringMaxRadix(1002);
        /* access modifiers changed from: private */
        public static final String FIELD_CONSTRAIN_AUDIO_CHANNEL_COUNT_TO_DEVICE_CAPABILITIES = Util.intToStringMaxRadix(1016);
        /* access modifiers changed from: private */
        public static final String FIELD_EXCEED_AUDIO_CONSTRAINTS_IF_NECESSARY = Util.intToStringMaxRadix(1003);
        /* access modifiers changed from: private */
        public static final String FIELD_EXCEED_RENDERER_CAPABILITIES_IF_NECESSARY = Util.intToStringMaxRadix(1007);
        /* access modifiers changed from: private */
        public static final String FIELD_EXCEED_VIDEO_CONSTRAINTS_IF_NECESSARY = Util.intToStringMaxRadix(1000);
        /* access modifiers changed from: private */
        public static final String FIELD_RENDERER_DISABLED_INDICES = Util.intToStringMaxRadix(1013);
        /* access modifiers changed from: private */
        public static final String FIELD_SELECTION_OVERRIDES = Util.intToStringMaxRadix(1012);
        /* access modifiers changed from: private */
        public static final String FIELD_SELECTION_OVERRIDES_RENDERER_INDICES = Util.intToStringMaxRadix(1010);
        /* access modifiers changed from: private */
        public static final String FIELD_SELECTION_OVERRIDES_TRACK_GROUP_ARRAYS = Util.intToStringMaxRadix(1011);
        /* access modifiers changed from: private */
        public static final String FIELD_TUNNELING_ENABLED = Util.intToStringMaxRadix(1008);
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedDecoderSupportAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowMultipleAdaptiveSelections;
        public final boolean allowVideoMixedDecoderSupportAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean constrainAudioChannelCountToDeviceCapabilities;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        /* access modifiers changed from: private */
        public final SparseBooleanArray rendererDisabledFlags;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final boolean tunnelingEnabled;

        public static final class Builder extends TrackSelectionParameters.Builder {
            /* access modifiers changed from: private */
            public boolean allowAudioMixedChannelCountAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowAudioMixedDecoderSupportAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowAudioMixedMimeTypeAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowAudioMixedSampleRateAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowMultipleAdaptiveSelections;
            /* access modifiers changed from: private */
            public boolean allowVideoMixedDecoderSupportAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowVideoMixedMimeTypeAdaptiveness;
            /* access modifiers changed from: private */
            public boolean allowVideoNonSeamlessAdaptiveness;
            /* access modifiers changed from: private */
            public boolean constrainAudioChannelCountToDeviceCapabilities;
            /* access modifiers changed from: private */
            public boolean exceedAudioConstraintsIfNecessary;
            /* access modifiers changed from: private */
            public boolean exceedRendererCapabilitiesIfNecessary;
            /* access modifiers changed from: private */
            public boolean exceedVideoConstraintsIfNecessary;
            /* access modifiers changed from: private */
            public final SparseBooleanArray rendererDisabledFlags;
            /* access modifiers changed from: private */
            public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
            /* access modifiers changed from: private */
            public boolean tunnelingEnabled;

            private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
                SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    sparseArray2.put(sparseArray.keyAt(i11), new HashMap(sparseArray.valueAt(i11)));
                }
                return sparseArray2;
            }

            private void init() {
                this.exceedVideoConstraintsIfNecessary = true;
                this.allowVideoMixedMimeTypeAdaptiveness = false;
                this.allowVideoNonSeamlessAdaptiveness = true;
                this.allowVideoMixedDecoderSupportAdaptiveness = false;
                this.exceedAudioConstraintsIfNecessary = true;
                this.allowAudioMixedMimeTypeAdaptiveness = false;
                this.allowAudioMixedSampleRateAdaptiveness = false;
                this.allowAudioMixedChannelCountAdaptiveness = false;
                this.allowAudioMixedDecoderSupportAdaptiveness = false;
                this.constrainAudioChannelCountToDeviceCapabilities = true;
                this.exceedRendererCapabilitiesIfNecessary = true;
                this.tunnelingEnabled = false;
                this.allowMultipleAdaptiveSelections = true;
            }

            private SparseBooleanArray makeSparseBooleanArrayFromTrueKeys(@Nullable int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int append : iArr) {
                    sparseBooleanArray.append(append, true);
                }
                return sparseBooleanArray;
            }

            private void setSelectionOverridesFromBundle(Bundle bundle) {
                ImmutableList<TrackGroupArray> immutableList;
                SparseArray<SelectionOverride> sparseArray;
                int[] intArray = bundle.getIntArray(Parameters.FIELD_SELECTION_OVERRIDES_RENDERER_INDICES);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(Parameters.FIELD_SELECTION_OVERRIDES_TRACK_GROUP_ARRAYS);
                if (parcelableArrayList == null) {
                    immutableList = ImmutableList.of();
                } else {
                    immutableList = BundleableUtil.fromBundleList(TrackGroupArray.CREATOR, parcelableArrayList);
                }
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(Parameters.FIELD_SELECTION_OVERRIDES);
                if (sparseParcelableArray == null) {
                    sparseArray = new SparseArray<>();
                } else {
                    sparseArray = BundleableUtil.fromBundleSparseArray(SelectionOverride.CREATOR, sparseParcelableArray);
                }
                if (intArray != null && intArray.length == immutableList.size()) {
                    for (int i11 = 0; i11 < intArray.length; i11++) {
                        setSelectionOverride(intArray[i11], immutableList.get(i11), sparseArray.get(i11));
                    }
                }
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder clearSelectionOverride(int i11, TrackGroupArray trackGroupArray) {
                Map map = this.selectionOverrides.get(i11);
                if (map != null && map.containsKey(trackGroupArray)) {
                    map.remove(trackGroupArray);
                    if (map.isEmpty()) {
                        this.selectionOverrides.remove(i11);
                    }
                }
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder clearSelectionOverrides(int i11) {
                Map map = this.selectionOverrides.get(i11);
                if (map != null && !map.isEmpty()) {
                    this.selectionOverrides.remove(i11);
                }
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowAudioMixedChannelCountAdaptiveness(boolean z11) {
                this.allowAudioMixedChannelCountAdaptiveness = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowAudioMixedDecoderSupportAdaptiveness(boolean z11) {
                this.allowAudioMixedDecoderSupportAdaptiveness = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowAudioMixedMimeTypeAdaptiveness(boolean z11) {
                this.allowAudioMixedMimeTypeAdaptiveness = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowAudioMixedSampleRateAdaptiveness(boolean z11) {
                this.allowAudioMixedSampleRateAdaptiveness = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowMultipleAdaptiveSelections(boolean z11) {
                this.allowMultipleAdaptiveSelections = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowVideoMixedDecoderSupportAdaptiveness(boolean z11) {
                this.allowVideoMixedDecoderSupportAdaptiveness = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowVideoMixedMimeTypeAdaptiveness(boolean z11) {
                this.allowVideoMixedMimeTypeAdaptiveness = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAllowVideoNonSeamlessAdaptiveness(boolean z11) {
                this.allowVideoNonSeamlessAdaptiveness = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setConstrainAudioChannelCountToDeviceCapabilities(boolean z11) {
                this.constrainAudioChannelCountToDeviceCapabilities = z11;
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder setDisabledTextTrackSelectionFlags(int i11) {
                return setIgnoredTextSelectionFlags(i11);
            }

            @CanIgnoreReturnValue
            public Builder setExceedAudioConstraintsIfNecessary(boolean z11) {
                this.exceedAudioConstraintsIfNecessary = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setExceedRendererCapabilitiesIfNecessary(boolean z11) {
                this.exceedRendererCapabilitiesIfNecessary = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setExceedVideoConstraintsIfNecessary(boolean z11) {
                this.exceedVideoConstraintsIfNecessary = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRendererDisabled(int i11, boolean z11) {
                if (this.rendererDisabledFlags.get(i11) == z11) {
                    return this;
                }
                if (z11) {
                    this.rendererDisabledFlags.put(i11, true);
                } else {
                    this.rendererDisabledFlags.delete(i11);
                }
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder setSelectionOverride(int i11, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
                Map map = this.selectionOverrides.get(i11);
                if (map == null) {
                    map = new HashMap();
                    this.selectionOverrides.put(i11, map);
                }
                if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                    return this;
                }
                map.put(trackGroupArray, selectionOverride);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTunnelingEnabled(boolean z11) {
                this.tunnelingEnabled = z11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
                super.addOverride(trackSelectionOverride);
                return this;
            }

            public Parameters build() {
                return new Parameters(this);
            }

            @CanIgnoreReturnValue
            public Builder clearOverride(TrackGroup trackGroup) {
                super.clearOverride(trackGroup);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder clearOverrides() {
                super.clearOverrides();
                return this;
            }

            @CanIgnoreReturnValue
            public Builder clearOverridesOfType(int i11) {
                super.clearOverridesOfType(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder clearVideoSizeConstraints() {
                super.clearVideoSizeConstraints();
                return this;
            }

            @CanIgnoreReturnValue
            public Builder clearViewportSizeConstraints() {
                super.clearViewportSizeConstraints();
                return this;
            }

            @CanIgnoreReturnValue
            public Builder set(TrackSelectionParameters trackSelectionParameters) {
                super.set(trackSelectionParameters);
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder setDisabledTrackTypes(Set<Integer> set) {
                super.setDisabledTrackTypes(set);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForceHighestSupportedBitrate(boolean z11) {
                super.setForceHighestSupportedBitrate(z11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForceLowestBitrate(boolean z11) {
                super.setForceLowestBitrate(z11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIgnoredTextSelectionFlags(int i11) {
                super.setIgnoredTextSelectionFlags(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxAudioBitrate(int i11) {
                super.setMaxAudioBitrate(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxAudioChannelCount(int i11) {
                super.setMaxAudioChannelCount(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxVideoBitrate(int i11) {
                super.setMaxVideoBitrate(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxVideoFrameRate(int i11) {
                super.setMaxVideoFrameRate(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxVideoSize(int i11, int i12) {
                super.setMaxVideoSize(i11, i12);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxVideoSizeSd() {
                super.setMaxVideoSizeSd();
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMinVideoBitrate(int i11) {
                super.setMinVideoBitrate(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMinVideoFrameRate(int i11) {
                super.setMinVideoFrameRate(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMinVideoSize(int i11, int i12) {
                super.setMinVideoSize(i11, i12);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
                super.setOverrideForType(trackSelectionOverride);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredAudioLanguage(@Nullable String str) {
                super.setPreferredAudioLanguage(str);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredAudioLanguages(String... strArr) {
                super.setPreferredAudioLanguages(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredAudioMimeType(@Nullable String str) {
                super.setPreferredAudioMimeType(str);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredAudioMimeTypes(String... strArr) {
                super.setPreferredAudioMimeTypes(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredAudioRoleFlags(int i11) {
                super.setPreferredAudioRoleFlags(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredTextLanguage(@Nullable String str) {
                super.setPreferredTextLanguage(str);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
                super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredTextLanguages(String... strArr) {
                super.setPreferredTextLanguages(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredTextRoleFlags(int i11) {
                super.setPreferredTextRoleFlags(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredVideoMimeType(@Nullable String str) {
                super.setPreferredVideoMimeType(str);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredVideoMimeTypes(String... strArr) {
                super.setPreferredVideoMimeTypes(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreferredVideoRoleFlags(int i11) {
                super.setPreferredVideoRoleFlags(i11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSelectUndeterminedTextLanguage(boolean z11) {
                super.setSelectUndeterminedTextLanguage(z11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTrackTypeDisabled(int i11, boolean z11) {
                super.setTrackTypeDisabled(i11, z11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setViewportSize(int i11, int i12, boolean z11) {
                super.setViewportSize(i11, i12, z11);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z11) {
                super.setViewportSizeToPhysicalDisplaySize(context, z11);
                return this;
            }

            @Deprecated
            public Builder() {
                this.selectionOverrides = new SparseArray<>();
                this.rendererDisabledFlags = new SparseBooleanArray();
                init();
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder clearSelectionOverrides() {
                if (this.selectionOverrides.size() == 0) {
                    return this;
                }
                this.selectionOverrides.clear();
                return this;
            }

            public Builder(Context context) {
                super(context);
                this.selectionOverrides = new SparseArray<>();
                this.rendererDisabledFlags = new SparseBooleanArray();
                init();
            }

            private Builder(Parameters parameters) {
                super((TrackSelectionParameters) parameters);
                this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
                this.allowVideoMixedMimeTypeAdaptiveness = parameters.allowVideoMixedMimeTypeAdaptiveness;
                this.allowVideoNonSeamlessAdaptiveness = parameters.allowVideoNonSeamlessAdaptiveness;
                this.allowVideoMixedDecoderSupportAdaptiveness = parameters.allowVideoMixedDecoderSupportAdaptiveness;
                this.exceedAudioConstraintsIfNecessary = parameters.exceedAudioConstraintsIfNecessary;
                this.allowAudioMixedMimeTypeAdaptiveness = parameters.allowAudioMixedMimeTypeAdaptiveness;
                this.allowAudioMixedSampleRateAdaptiveness = parameters.allowAudioMixedSampleRateAdaptiveness;
                this.allowAudioMixedChannelCountAdaptiveness = parameters.allowAudioMixedChannelCountAdaptiveness;
                this.allowAudioMixedDecoderSupportAdaptiveness = parameters.allowAudioMixedDecoderSupportAdaptiveness;
                this.constrainAudioChannelCountToDeviceCapabilities = parameters.constrainAudioChannelCountToDeviceCapabilities;
                this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
                this.tunnelingEnabled = parameters.tunnelingEnabled;
                this.allowMultipleAdaptiveSelections = parameters.allowMultipleAdaptiveSelections;
                this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
                this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
            }

            private Builder(Bundle bundle) {
                super(bundle);
                init();
                Parameters parameters = Parameters.DEFAULT_WITHOUT_CONTEXT;
                setExceedVideoConstraintsIfNecessary(bundle.getBoolean(Parameters.FIELD_EXCEED_VIDEO_CONSTRAINTS_IF_NECESSARY, parameters.exceedVideoConstraintsIfNecessary));
                setAllowVideoMixedMimeTypeAdaptiveness(bundle.getBoolean(Parameters.FIELD_ALLOW_VIDEO_MIXED_MIME_TYPE_ADAPTIVENESS, parameters.allowVideoMixedMimeTypeAdaptiveness));
                setAllowVideoNonSeamlessAdaptiveness(bundle.getBoolean(Parameters.FIELD_ALLOW_VIDEO_NON_SEAMLESS_ADAPTIVENESS, parameters.allowVideoNonSeamlessAdaptiveness));
                setAllowVideoMixedDecoderSupportAdaptiveness(bundle.getBoolean(Parameters.FIELD_ALLOW_VIDEO_MIXED_DECODER_SUPPORT_ADAPTIVENESS, parameters.allowVideoMixedDecoderSupportAdaptiveness));
                setExceedAudioConstraintsIfNecessary(bundle.getBoolean(Parameters.FIELD_EXCEED_AUDIO_CONSTRAINTS_IF_NECESSARY, parameters.exceedAudioConstraintsIfNecessary));
                setAllowAudioMixedMimeTypeAdaptiveness(bundle.getBoolean(Parameters.FIELD_ALLOW_AUDIO_MIXED_MIME_TYPE_ADAPTIVENESS, parameters.allowAudioMixedMimeTypeAdaptiveness));
                setAllowAudioMixedSampleRateAdaptiveness(bundle.getBoolean(Parameters.FIELD_ALLOW_AUDIO_MIXED_SAMPLE_RATE_ADAPTIVENESS, parameters.allowAudioMixedSampleRateAdaptiveness));
                setAllowAudioMixedChannelCountAdaptiveness(bundle.getBoolean(Parameters.FIELD_ALLOW_AUDIO_MIXED_CHANNEL_COUNT_ADAPTIVENESS, parameters.allowAudioMixedChannelCountAdaptiveness));
                setAllowAudioMixedDecoderSupportAdaptiveness(bundle.getBoolean(Parameters.FIELD_ALLOW_AUDIO_MIXED_DECODER_SUPPORT_ADAPTIVENESS, parameters.allowAudioMixedDecoderSupportAdaptiveness));
                setConstrainAudioChannelCountToDeviceCapabilities(bundle.getBoolean(Parameters.FIELD_CONSTRAIN_AUDIO_CHANNEL_COUNT_TO_DEVICE_CAPABILITIES, parameters.constrainAudioChannelCountToDeviceCapabilities));
                setExceedRendererCapabilitiesIfNecessary(bundle.getBoolean(Parameters.FIELD_EXCEED_RENDERER_CAPABILITIES_IF_NECESSARY, parameters.exceedRendererCapabilitiesIfNecessary));
                setTunnelingEnabled(bundle.getBoolean(Parameters.FIELD_TUNNELING_ENABLED, parameters.tunnelingEnabled));
                setAllowMultipleAdaptiveSelections(bundle.getBoolean(Parameters.FIELD_ALLOW_MULTIPLE_ADAPTIVE_SELECTIONS, parameters.allowMultipleAdaptiveSelections));
                this.selectionOverrides = new SparseArray<>();
                setSelectionOverridesFromBundle(bundle);
                this.rendererDisabledFlags = makeSparseBooleanArrayFromTrueKeys(bundle.getIntArray(Parameters.FIELD_RENDERER_DISABLED_INDICES));
            }
        }

        static {
            Parameters build = new Builder().build();
            DEFAULT_WITHOUT_CONTEXT = build;
            DEFAULT = build;
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i11)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i11));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i11), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static Parameters getDefaults(Context context) {
            return new Builder(context).build();
        }

        private static int[] getKeysFromSparseBooleanArray(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i11 = 0; i11 < sparseBooleanArray.size(); i11++) {
                iArr[i11] = sparseBooleanArray.keyAt(i11);
            }
            return iArr;
        }

        private static void putSelectionOverridesToBundle(Bundle bundle, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                int keyAt = sparseArray.keyAt(i11);
                for (Map.Entry entry : sparseArray.valueAt(i11).entrySet()) {
                    SelectionOverride selectionOverride = (SelectionOverride) entry.getValue();
                    if (selectionOverride != null) {
                        sparseArray2.put(arrayList2.size(), selectionOverride);
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(FIELD_SELECTION_OVERRIDES_RENDERER_INDICES, Ints.toArray(arrayList));
                bundle.putParcelableArrayList(FIELD_SELECTION_OVERRIDES_TRACK_GROUP_ARRAYS, BundleableUtil.toBundleArrayList(arrayList2));
                bundle.putSparseParcelableArray(FIELD_SELECTION_OVERRIDES, BundleableUtil.toBundleSparseArray(sparseArray2));
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (super.equals(parameters) && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.allowVideoMixedDecoderSupportAdaptiveness == parameters.allowVideoMixedDecoderSupportAdaptiveness && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.allowAudioMixedDecoderSupportAdaptiveness == parameters.allowAudioMixedDecoderSupportAdaptiveness && this.constrainAudioChannelCountToDeviceCapabilities == parameters.constrainAudioChannelCountToDeviceCapabilities && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingEnabled == parameters.tunnelingEnabled && this.allowMultipleAdaptiveSelections == parameters.allowMultipleAdaptiveSelections && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides)) {
                return true;
            }
            return false;
        }

        public boolean getRendererDisabled(int i11) {
            return this.rendererDisabledFlags.get(i11);
        }

        @Deprecated
        @Nullable
        public SelectionOverride getSelectionOverride(int i11, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i11);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        @Deprecated
        public boolean hasSelectionOverride(int i11, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i11);
            if (map == null || !map.containsKey(trackGroupArray)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoMixedDecoderSupportAdaptiveness ? 1 : 0)) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedDecoderSupportAdaptiveness ? 1 : 0)) * 31) + (this.constrainAudioChannelCountToDeviceCapabilities ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.tunnelingEnabled ? 1 : 0)) * 31) + (this.allowMultipleAdaptiveSelections ? 1 : 0);
        }

        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(FIELD_EXCEED_VIDEO_CONSTRAINTS_IF_NECESSARY, this.exceedVideoConstraintsIfNecessary);
            bundle.putBoolean(FIELD_ALLOW_VIDEO_MIXED_MIME_TYPE_ADAPTIVENESS, this.allowVideoMixedMimeTypeAdaptiveness);
            bundle.putBoolean(FIELD_ALLOW_VIDEO_NON_SEAMLESS_ADAPTIVENESS, this.allowVideoNonSeamlessAdaptiveness);
            bundle.putBoolean(FIELD_ALLOW_VIDEO_MIXED_DECODER_SUPPORT_ADAPTIVENESS, this.allowVideoMixedDecoderSupportAdaptiveness);
            bundle.putBoolean(FIELD_EXCEED_AUDIO_CONSTRAINTS_IF_NECESSARY, this.exceedAudioConstraintsIfNecessary);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_MIME_TYPE_ADAPTIVENESS, this.allowAudioMixedMimeTypeAdaptiveness);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_SAMPLE_RATE_ADAPTIVENESS, this.allowAudioMixedSampleRateAdaptiveness);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_CHANNEL_COUNT_ADAPTIVENESS, this.allowAudioMixedChannelCountAdaptiveness);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_DECODER_SUPPORT_ADAPTIVENESS, this.allowAudioMixedDecoderSupportAdaptiveness);
            bundle.putBoolean(FIELD_CONSTRAIN_AUDIO_CHANNEL_COUNT_TO_DEVICE_CAPABILITIES, this.constrainAudioChannelCountToDeviceCapabilities);
            bundle.putBoolean(FIELD_EXCEED_RENDERER_CAPABILITIES_IF_NECESSARY, this.exceedRendererCapabilitiesIfNecessary);
            bundle.putBoolean(FIELD_TUNNELING_ENABLED, this.tunnelingEnabled);
            bundle.putBoolean(FIELD_ALLOW_MULTIPLE_ADAPTIVE_SELECTIONS, this.allowMultipleAdaptiveSelections);
            putSelectionOverridesToBundle(bundle, this.selectionOverrides);
            bundle.putIntArray(FIELD_RENDERER_DISABLED_INDICES, getKeysFromSparseBooleanArray(this.rendererDisabledFlags));
            return bundle;
        }

        private Parameters(Builder builder) {
            super(builder);
            this.exceedVideoConstraintsIfNecessary = builder.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = builder.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = builder.allowVideoNonSeamlessAdaptiveness;
            this.allowVideoMixedDecoderSupportAdaptiveness = builder.allowVideoMixedDecoderSupportAdaptiveness;
            this.exceedAudioConstraintsIfNecessary = builder.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = builder.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = builder.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = builder.allowAudioMixedChannelCountAdaptiveness;
            this.allowAudioMixedDecoderSupportAdaptiveness = builder.allowAudioMixedDecoderSupportAdaptiveness;
            this.constrainAudioChannelCountToDeviceCapabilities = builder.constrainAudioChannelCountToDeviceCapabilities;
            this.exceedRendererCapabilitiesIfNecessary = builder.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingEnabled = builder.tunnelingEnabled;
            this.allowMultipleAdaptiveSelections = builder.allowMultipleAdaptiveSelections;
            this.selectionOverrides = builder.selectionOverrides;
            this.rendererDisabledFlags = builder.rendererDisabledFlags;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean areSelectionOverridesEqual(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.google.android.exoplayer2.source.TrackGroupArray r1 = (com.google.android.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.Util.areEqual(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.areSelectionOverridesEqual(java.util.Map, java.util.Map):boolean");
        }
    }

    @Deprecated
    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private final Parameters.Builder delegate;

        @Deprecated
        public ParametersBuilder() {
            this.delegate = new Parameters.Builder();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder clearSelectionOverride(int i11, TrackGroupArray trackGroupArray) {
            this.delegate.clearSelectionOverride(i11, trackGroupArray);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder clearSelectionOverrides(int i11) {
            this.delegate.clearSelectionOverrides(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z11) {
            this.delegate.setAllowAudioMixedChannelCountAdaptiveness(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowAudioMixedDecoderSupportAdaptiveness(boolean z11) {
            this.delegate.setAllowAudioMixedDecoderSupportAdaptiveness(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z11) {
            this.delegate.setAllowAudioMixedMimeTypeAdaptiveness(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z11) {
            this.delegate.setAllowAudioMixedSampleRateAdaptiveness(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowMultipleAdaptiveSelections(boolean z11) {
            this.delegate.setAllowMultipleAdaptiveSelections(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowVideoMixedDecoderSupportAdaptiveness(boolean z11) {
            this.delegate.setAllowVideoMixedDecoderSupportAdaptiveness(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z11) {
            this.delegate.setAllowVideoMixedMimeTypeAdaptiveness(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z11) {
            this.delegate.setAllowVideoNonSeamlessAdaptiveness(z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder setDisabledTextTrackSelectionFlags(int i11) {
            this.delegate.setDisabledTextTrackSelectionFlags(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z11) {
            this.delegate.setExceedAudioConstraintsIfNecessary(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z11) {
            this.delegate.setExceedRendererCapabilitiesIfNecessary(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z11) {
            this.delegate.setExceedVideoConstraintsIfNecessary(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setRendererDisabled(int i11, boolean z11) {
            this.delegate.setRendererDisabled(i11, z11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder setSelectionOverride(int i11, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
            this.delegate.setSelectionOverride(i11, trackGroupArray, selectionOverride);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setTunnelingEnabled(boolean z11) {
            this.delegate.setTunnelingEnabled(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.delegate.addOverride(trackSelectionOverride);
            return this;
        }

        public Parameters build() {
            return this.delegate.build();
        }

        @CanIgnoreReturnValue
        public ParametersBuilder clearOverride(TrackGroup trackGroup) {
            this.delegate.clearOverride(trackGroup);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder clearOverrides() {
            this.delegate.clearOverrides();
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder clearOverridesOfType(int i11) {
            this.delegate.clearOverridesOfType(i11);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder clearSelectionOverrides() {
            this.delegate.clearSelectionOverrides();
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder clearVideoSizeConstraints() {
            this.delegate.clearVideoSizeConstraints();
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder clearViewportSizeConstraints() {
            this.delegate.clearViewportSizeConstraints();
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder set(TrackSelectionParameters trackSelectionParameters) {
            this.delegate.set(trackSelectionParameters);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder setDisabledTrackTypes(Set<Integer> set) {
            this.delegate.setDisabledTrackTypes(set);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setForceHighestSupportedBitrate(boolean z11) {
            this.delegate.setForceHighestSupportedBitrate(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setForceLowestBitrate(boolean z11) {
            this.delegate.setForceLowestBitrate(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setIgnoredTextSelectionFlags(int i11) {
            this.delegate.setIgnoredTextSelectionFlags(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMaxAudioBitrate(int i11) {
            this.delegate.setMaxAudioBitrate(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMaxAudioChannelCount(int i11) {
            this.delegate.setMaxAudioChannelCount(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMaxVideoBitrate(int i11) {
            this.delegate.setMaxVideoBitrate(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMaxVideoFrameRate(int i11) {
            this.delegate.setMaxVideoFrameRate(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMaxVideoSize(int i11, int i12) {
            this.delegate.setMaxVideoSize(i11, i12);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMaxVideoSizeSd() {
            this.delegate.setMaxVideoSizeSd();
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMinVideoBitrate(int i11) {
            this.delegate.setMinVideoBitrate(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMinVideoFrameRate(int i11) {
            this.delegate.setMinVideoFrameRate(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setMinVideoSize(int i11, int i12) {
            this.delegate.setMinVideoSize(i11, i12);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            this.delegate.setOverrideForType(trackSelectionOverride);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredAudioLanguage(@Nullable String str) {
            this.delegate.setPreferredAudioLanguage(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredAudioLanguages(String... strArr) {
            this.delegate.setPreferredAudioLanguages(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredAudioMimeType(@Nullable String str) {
            this.delegate.setPreferredAudioMimeType(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredAudioMimeTypes(String... strArr) {
            this.delegate.setPreferredAudioMimeTypes(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredAudioRoleFlags(int i11) {
            this.delegate.setPreferredAudioRoleFlags(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredTextLanguage(@Nullable String str) {
            this.delegate.setPreferredTextLanguage(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            this.delegate.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredTextLanguages(String... strArr) {
            this.delegate.setPreferredTextLanguages(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredTextRoleFlags(int i11) {
            this.delegate.setPreferredTextRoleFlags(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredVideoMimeType(@Nullable String str) {
            this.delegate.setPreferredVideoMimeType(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredVideoMimeTypes(String... strArr) {
            this.delegate.setPreferredVideoMimeTypes(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setPreferredVideoRoleFlags(int i11) {
            this.delegate.setPreferredVideoRoleFlags(i11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z11) {
            this.delegate.setSelectUndeterminedTextLanguage(z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setTrackTypeDisabled(int i11, boolean z11) {
            this.delegate.setTrackTypeDisabled(i11, z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setViewportSize(int i11, int i12, boolean z11) {
            this.delegate.setViewportSize(i11, i12, z11);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z11) {
            this.delegate.setViewportSizeToPhysicalDisplaySize(context, z11);
            return this;
        }

        public ParametersBuilder(Context context) {
            this.delegate = new Parameters.Builder(context);
        }
    }

    public static final class SelectionOverride implements Bundleable {
        public static final Bundleable.Creator<SelectionOverride> CREATOR = new i();
        private static final String FIELD_GROUP_INDEX = Util.intToStringMaxRadix(0);
        private static final String FIELD_TRACKS = Util.intToStringMaxRadix(1);
        private static final String FIELD_TRACK_TYPE = Util.intToStringMaxRadix(2);
        public final int groupIndex;
        public final int length;
        public final int[] tracks;
        public final int type;

        public SelectionOverride(int i11, int... iArr) {
            this(i11, iArr, 0);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ SelectionOverride lambda$static$0(Bundle bundle) {
            boolean z11;
            int i11 = bundle.getInt(FIELD_GROUP_INDEX, -1);
            int[] intArray = bundle.getIntArray(FIELD_TRACKS);
            int i12 = bundle.getInt(FIELD_TRACK_TYPE, -1);
            if (i11 < 0 || i12 < 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            Assertions.checkArgument(z11);
            Assertions.checkNotNull(intArray);
            return new SelectionOverride(i11, intArray, i12);
        }

        public boolean containsTrack(int i11) {
            for (int i12 : this.tracks) {
                if (i12 == i11) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.type == selectionOverride.type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.groupIndex * 31) + Arrays.hashCode(this.tracks)) * 31) + this.type;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(FIELD_GROUP_INDEX, this.groupIndex);
            bundle.putIntArray(FIELD_TRACKS, this.tracks);
            bundle.putInt(FIELD_TRACK_TYPE, this.type);
            return bundle;
        }

        public SelectionOverride(int i11, int[] iArr, int i12) {
            this.groupIndex = i11;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            this.type = i12;
            Arrays.sort(copyOf);
        }
    }

    @RequiresApi(32)
    public static class SpatializerWrapperV32 {
        @Nullable
        private Handler handler;
        @Nullable
        private Spatializer.OnSpatializerStateChangedListener listener;
        private final boolean spatializationSupported;
        private final Spatializer spatializer;

        private SpatializerWrapperV32(Spatializer spatializer2) {
            boolean z11;
            this.spatializer = spatializer2;
            if (spatializer2.getImmersiveAudioLevel() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.spatializationSupported = z11;
        }

        @Nullable
        public static SpatializerWrapperV32 tryCreateInstance(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager == null) {
                return null;
            }
            return new SpatializerWrapperV32(audioManager.getSpatializer());
        }

        public boolean canBeSpatialized(AudioAttributes audioAttributes, Format format) {
            int i11;
            if (!MimeTypes.AUDIO_E_AC3_JOC.equals(format.sampleMimeType) || format.channelCount != 16) {
                i11 = format.channelCount;
            } else {
                i11 = 12;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(Util.getAudioTrackChannelConfig(i11));
            int i12 = format.sampleRate;
            if (i12 != -1) {
                channelMask.setSampleRate(i12);
            }
            return this.spatializer.canBeSpatialized(audioAttributes.getAudioAttributesV21().audioAttributes, channelMask.build());
        }

        public void ensureInitialized(final DefaultTrackSelector defaultTrackSelector, Looper looper) {
            if (this.listener == null && this.handler == null) {
                this.listener = new Spatializer.OnSpatializerStateChangedListener(this) {
                    public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z11) {
                        defaultTrackSelector.maybeInvalidateForAudioChannelCountConstraints();
                    }

                    public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z11) {
                        defaultTrackSelector.maybeInvalidateForAudioChannelCountConstraints();
                    }
                };
                Handler handler2 = new Handler(looper);
                this.handler = handler2;
                Spatializer spatializer2 = this.spatializer;
                Objects.requireNonNull(handler2);
                spatializer2.addOnSpatializerStateChangedListener(new a(handler2), this.listener);
            }
        }

        public boolean isAvailable() {
            return this.spatializer.isAvailable();
        }

        public boolean isEnabled() {
            return this.spatializer.isEnabled();
        }

        public boolean isSpatializationSupported() {
            return this.spatializationSupported;
        }

        public void release() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.listener;
            if (onSpatializerStateChangedListener != null && this.handler != null) {
                this.spatializer.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
                ((Handler) Util.castNonNull(this.handler)).removeCallbacksAndMessages((Object) null);
                this.handler = null;
                this.listener = null;
            }
        }
    }

    public static final class TextTrackInfo extends TrackInfo<TextTrackInfo> implements Comparable<TextTrackInfo> {
        private final boolean hasCaptionRoleFlags;
        private final boolean isDefault;
        private final boolean isForced;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;
        private final int selectionEligibility;

        public TextTrackInfo(int i11, TrackGroup trackGroup, int i12, Parameters parameters, int i13, @Nullable String str) {
            super(i11, trackGroup, i12);
            boolean z11;
            boolean z12;
            ImmutableList<String> immutableList;
            int i14;
            boolean z13;
            boolean z14;
            boolean z15;
            int i15 = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i13, false);
            int i16 = this.format.selectionFlags & (~parameters.ignoredTextSelectionFlags);
            if ((i16 & 1) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.isDefault = z11;
            if ((i16 & 2) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            this.isForced = z12;
            if (parameters.preferredTextLanguages.isEmpty()) {
                immutableList = ImmutableList.of("");
            } else {
                immutableList = parameters.preferredTextLanguages;
            }
            int i17 = 0;
            while (true) {
                if (i17 >= immutableList.size()) {
                    i17 = Integer.MAX_VALUE;
                    i14 = 0;
                    break;
                }
                i14 = DefaultTrackSelector.getFormatLanguageScore(this.format, immutableList.get(i17), parameters.selectUndeterminedTextLanguage);
                if (i14 > 0) {
                    break;
                }
                i17++;
            }
            this.preferredLanguageIndex = i17;
            this.preferredLanguageScore = i14;
            int access$3800 = DefaultTrackSelector.getRoleFlagMatchScore(this.format.roleFlags, parameters.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = access$3800;
            if ((this.format.roleFlags & 1088) != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            this.hasCaptionRoleFlags = z13;
            if (DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null) {
                z14 = true;
            } else {
                z14 = false;
            }
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(this.format, str, z14);
            this.selectedAudioLanguageScore = formatLanguageScore;
            if (i14 > 0 || ((parameters.preferredTextLanguages.isEmpty() && access$3800 > 0) || this.isDefault || (this.isForced && formatLanguageScore > 0))) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (DefaultTrackSelector.isSupported(i13, parameters.exceedRendererCapabilitiesIfNecessary) && z15) {
                i15 = 1;
            }
            this.selectionEligibility = i15;
        }

        public static int compareSelections(List<TextTrackInfo> list, List<TextTrackInfo> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<TextTrackInfo> createForTrackGroup(int i11, TrackGroup trackGroup, Parameters parameters, int[] iArr, @Nullable String str) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i12 = 0; i12 < trackGroup.length; i12++) {
                builder.add((Object) new TextTrackInfo(i11, trackGroup, i12, parameters, iArr[i12], str));
            }
            return builder.build();
        }

        public int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        public boolean isCompatibleForAdaptationWith(TextTrackInfo textTrackInfo) {
            return false;
        }

        public int compareTo(TextTrackInfo textTrackInfo) {
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, textTrackInfo.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(textTrackInfo.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, textTrackInfo.preferredLanguageScore).compare(this.preferredRoleFlagsScore, textTrackInfo.preferredRoleFlagsScore).compareFalseFirst(this.isDefault, textTrackInfo.isDefault).compare(Boolean.valueOf(this.isForced), Boolean.valueOf(textTrackInfo.isForced), this.preferredLanguageScore == 0 ? Ordering.natural() : Ordering.natural().reverse()).compare(this.selectedAudioLanguageScore, textTrackInfo.selectedAudioLanguageScore);
            if (this.preferredRoleFlagsScore == 0) {
                compare = compare.compareTrueFirst(this.hasCaptionRoleFlags, textTrackInfo.hasCaptionRoleFlags);
            }
            return compare.result();
        }
    }

    public static abstract class TrackInfo<T extends TrackInfo<T>> {
        public final Format format;
        public final int rendererIndex;
        public final TrackGroup trackGroup;
        public final int trackIndex;

        public interface Factory<T extends TrackInfo<T>> {
            List<T> create(int i11, TrackGroup trackGroup, int[] iArr);
        }

        public TrackInfo(int i11, TrackGroup trackGroup2, int i12) {
            this.rendererIndex = i11;
            this.trackGroup = trackGroup2;
            this.trackIndex = i12;
            this.format = trackGroup2.getFormat(i12);
        }

        public abstract int getSelectionEligibility();

        public abstract boolean isCompatibleForAdaptationWith(T t11);
    }

    public static final class VideoTrackInfo extends TrackInfo<VideoTrackInfo> {
        private final boolean allowMixedMimeTypes;
        private final int bitrate;
        private final int codecPreferenceScore;
        private final boolean hasMainOrNoRoleFlag;
        private final boolean isWithinMaxConstraints;
        private final boolean isWithinMinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final Parameters parameters;
        private final int pixelCount;
        private final int preferredMimeTypeMatchIndex;
        private final int preferredRoleFlagsScore;
        private final int selectionEligibility;
        private final boolean usesHardwareAcceleration;
        private final boolean usesPrimaryDecoder;

        /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x00e3  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00c8 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public VideoTrackInfo(int r5, com.google.android.exoplayer2.source.TrackGroup r6, int r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, int r10, boolean r11) {
            /*
                r4 = this;
                r4.<init>(r5, r6, r7)
                r4.parameters = r8
                boolean r5 = r8.allowVideoNonSeamlessAdaptiveness
                if (r5 == 0) goto L_0x000c
                r5 = 24
                goto L_0x000e
            L_0x000c:
                r5 = 16
            L_0x000e:
                boolean r6 = r8.allowVideoMixedMimeTypeAdaptiveness
                r7 = 1
                r0 = 0
                if (r6 == 0) goto L_0x001a
                r6 = r10 & r5
                if (r6 == 0) goto L_0x001a
                r6 = r7
                goto L_0x001b
            L_0x001a:
                r6 = r0
            L_0x001b:
                r4.allowMixedMimeTypes = r6
                r6 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10 = -1
                if (r11 == 0) goto L_0x004b
                com.google.android.exoplayer2.Format r1 = r4.format
                int r2 = r1.width
                if (r2 == r10) goto L_0x002c
                int r3 = r8.maxVideoWidth
                if (r2 > r3) goto L_0x004b
            L_0x002c:
                int r2 = r1.height
                if (r2 == r10) goto L_0x0034
                int r3 = r8.maxVideoHeight
                if (r2 > r3) goto L_0x004b
            L_0x0034:
                float r2 = r1.frameRate
                int r3 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r3 == 0) goto L_0x0041
                int r3 = r8.maxVideoFrameRate
                float r3 = (float) r3
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 > 0) goto L_0x004b
            L_0x0041:
                int r1 = r1.bitrate
                if (r1 == r10) goto L_0x0049
                int r2 = r8.maxVideoBitrate
                if (r1 > r2) goto L_0x004b
            L_0x0049:
                r1 = r7
                goto L_0x004c
            L_0x004b:
                r1 = r0
            L_0x004c:
                r4.isWithinMaxConstraints = r1
                if (r11 == 0) goto L_0x0079
                com.google.android.exoplayer2.Format r11 = r4.format
                int r1 = r11.width
                if (r1 == r10) goto L_0x005a
                int r2 = r8.minVideoWidth
                if (r1 < r2) goto L_0x0079
            L_0x005a:
                int r1 = r11.height
                if (r1 == r10) goto L_0x0062
                int r2 = r8.minVideoHeight
                if (r1 < r2) goto L_0x0079
            L_0x0062:
                float r1 = r11.frameRate
                int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r6 == 0) goto L_0x006f
                int r6 = r8.minVideoFrameRate
                float r6 = (float) r6
                int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r6 < 0) goto L_0x0079
            L_0x006f:
                int r6 = r11.bitrate
                if (r6 == r10) goto L_0x0077
                int r10 = r8.minVideoBitrate
                if (r6 < r10) goto L_0x0079
            L_0x0077:
                r6 = r7
                goto L_0x007a
            L_0x0079:
                r6 = r0
            L_0x007a:
                r4.isWithinMinConstraints = r6
                boolean r6 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(r9, r0)
                r4.isWithinRendererCapabilities = r6
                com.google.android.exoplayer2.Format r6 = r4.format
                int r10 = r6.bitrate
                r4.bitrate = r10
                int r6 = r6.getPixelCount()
                r4.pixelCount = r6
                com.google.android.exoplayer2.Format r6 = r4.format
                int r6 = r6.roleFlags
                int r10 = r8.preferredVideoRoleFlags
                int r6 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getRoleFlagMatchScore(r6, r10)
                r4.preferredRoleFlagsScore = r6
                com.google.android.exoplayer2.Format r6 = r4.format
                int r6 = r6.roleFlags
                if (r6 == 0) goto L_0x00a6
                r6 = r6 & r7
                if (r6 == 0) goto L_0x00a4
                goto L_0x00a6
            L_0x00a4:
                r6 = r0
                goto L_0x00a7
            L_0x00a6:
                r6 = r7
            L_0x00a7:
                r4.hasMainOrNoRoleFlag = r6
                r6 = r0
            L_0x00aa:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.preferredVideoMimeTypes
                int r10 = r10.size()
                if (r6 >= r10) goto L_0x00c8
                com.google.android.exoplayer2.Format r10 = r4.format
                java.lang.String r10 = r10.sampleMimeType
                if (r10 == 0) goto L_0x00c5
                com.google.common.collect.ImmutableList<java.lang.String> r11 = r8.preferredVideoMimeTypes
                java.lang.Object r11 = r11.get(r6)
                boolean r10 = r10.equals(r11)
                if (r10 == 0) goto L_0x00c5
                goto L_0x00cb
            L_0x00c5:
                int r6 = r6 + 1
                goto L_0x00aa
            L_0x00c8:
                r6 = 2147483647(0x7fffffff, float:NaN)
            L_0x00cb:
                r4.preferredMimeTypeMatchIndex = r6
                int r6 = g7.c1.e(r9)
                r8 = 128(0x80, float:1.794E-43)
                if (r6 != r8) goto L_0x00d7
                r6 = r7
                goto L_0x00d8
            L_0x00d7:
                r6 = r0
            L_0x00d8:
                r4.usesPrimaryDecoder = r6
                int r6 = g7.c1.g(r9)
                r8 = 64
                if (r6 != r8) goto L_0x00e3
                goto L_0x00e4
            L_0x00e3:
                r7 = r0
            L_0x00e4:
                r4.usesHardwareAcceleration = r7
                com.google.android.exoplayer2.Format r6 = r4.format
                java.lang.String r6 = r6.sampleMimeType
                int r6 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getVideoCodecPreferenceScore(r6)
                r4.codecPreferenceScore = r6
                int r5 = r4.evaluateSelectionEligibility(r9, r5)
                r4.selectionEligibility = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackInfo.<init>(int, com.google.android.exoplayer2.source.TrackGroup, int, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, int, boolean):void");
        }

        /* access modifiers changed from: private */
        public static int compareNonQualityPreferences(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            ComparisonChain compareFalseFirst = ComparisonChain.start().compareFalseFirst(videoTrackInfo.isWithinRendererCapabilities, videoTrackInfo2.isWithinRendererCapabilities).compare(videoTrackInfo.preferredRoleFlagsScore, videoTrackInfo2.preferredRoleFlagsScore).compareFalseFirst(videoTrackInfo.hasMainOrNoRoleFlag, videoTrackInfo2.hasMainOrNoRoleFlag).compareFalseFirst(videoTrackInfo.isWithinMaxConstraints, videoTrackInfo2.isWithinMaxConstraints).compareFalseFirst(videoTrackInfo.isWithinMinConstraints, videoTrackInfo2.isWithinMinConstraints).compare(Integer.valueOf(videoTrackInfo.preferredMimeTypeMatchIndex), Integer.valueOf(videoTrackInfo2.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compareFalseFirst(videoTrackInfo.usesPrimaryDecoder, videoTrackInfo2.usesPrimaryDecoder).compareFalseFirst(videoTrackInfo.usesHardwareAcceleration, videoTrackInfo2.usesHardwareAcceleration);
            if (videoTrackInfo.usesPrimaryDecoder && videoTrackInfo.usesHardwareAcceleration) {
                compareFalseFirst = compareFalseFirst.compare(videoTrackInfo.codecPreferenceScore, videoTrackInfo2.codecPreferenceScore);
            }
            return compareFalseFirst.result();
        }

        /* access modifiers changed from: private */
        public static int compareQualityPreferences(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            Ordering ordering;
            Ordering ordering2;
            if (!videoTrackInfo.isWithinMaxConstraints || !videoTrackInfo.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            ComparisonChain start = ComparisonChain.start();
            Integer valueOf = Integer.valueOf(videoTrackInfo.bitrate);
            Integer valueOf2 = Integer.valueOf(videoTrackInfo2.bitrate);
            if (videoTrackInfo.parameters.forceLowestBitrate) {
                ordering2 = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering2 = DefaultTrackSelector.NO_ORDER;
            }
            return start.compare(valueOf, valueOf2, ordering2).compare(Integer.valueOf(videoTrackInfo.pixelCount), Integer.valueOf(videoTrackInfo2.pixelCount), ordering).compare(Integer.valueOf(videoTrackInfo.bitrate), Integer.valueOf(videoTrackInfo2.bitrate), ordering).result();
        }

        public static int compareSelections(List<VideoTrackInfo> list, List<VideoTrackInfo> list2) {
            return ComparisonChain.start().compare((VideoTrackInfo) Collections.max(list, new d()), (VideoTrackInfo) Collections.max(list2, new d()), new d()).compare(list.size(), list2.size()).compare((VideoTrackInfo) Collections.max(list, new e()), (VideoTrackInfo) Collections.max(list2, new e()), new e()).result();
        }

        public static ImmutableList<VideoTrackInfo> createForTrackGroup(int i11, TrackGroup trackGroup, Parameters parameters2, int[] iArr, int i12) {
            boolean z11;
            TrackGroup trackGroup2 = trackGroup;
            Parameters parameters3 = parameters2;
            int access$3700 = DefaultTrackSelector.getMaxVideoPixelsToRetainForViewport(trackGroup2, parameters3.viewportWidth, parameters3.viewportHeight, parameters3.viewportOrientationMayChange);
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i13 = 0; i13 < trackGroup2.length; i13++) {
                int pixelCount2 = trackGroup2.getFormat(i13).getPixelCount();
                if (access$3700 == Integer.MAX_VALUE || (pixelCount2 != -1 && pixelCount2 <= access$3700)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                builder.add((Object) new VideoTrackInfo(i11, trackGroup, i13, parameters2, iArr[i13], i12, z11));
            }
            return builder.build();
        }

        private int evaluateSelectionEligibility(int i11, int i12) {
            if ((this.format.roleFlags & 16384) != 0 || !DefaultTrackSelector.isSupported(i11, this.parameters.exceedRendererCapabilitiesIfNecessary)) {
                return 0;
            }
            if (!this.isWithinMaxConstraints && !this.parameters.exceedVideoConstraintsIfNecessary) {
                return 0;
            }
            if (DefaultTrackSelector.isSupported(i11, false) && this.isWithinMinConstraints && this.isWithinMaxConstraints && this.format.bitrate != -1) {
                Parameters parameters2 = this.parameters;
                if (parameters2.forceHighestSupportedBitrate || parameters2.forceLowestBitrate || (i11 & i12) == 0) {
                    return 1;
                }
                return 2;
            }
            return 1;
        }

        public int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        public boolean isCompatibleForAdaptationWith(VideoTrackInfo videoTrackInfo) {
            return (this.allowMixedMimeTypes || Util.areEqual(this.format.sampleMimeType, videoTrackInfo.format.sampleMimeType)) && (this.parameters.allowVideoMixedDecoderSupportAdaptiveness || (this.usesPrimaryDecoder == videoTrackInfo.usesPrimaryDecoder && this.usesHardwareAcceleration == videoTrackInfo.usesHardwareAcceleration));
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this((TrackSelectionParameters) Parameters.DEFAULT_WITHOUT_CONTEXT, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    private static void applyLegacyRendererOverrides(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, Parameters parameters2, ExoTrackSelection.Definition[] definitionArr) {
        ExoTrackSelection.Definition definition;
        int rendererCount = mappedTrackInfo.getRendererCount();
        for (int i11 = 0; i11 < rendererCount; i11++) {
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i11);
            if (parameters2.hasSelectionOverride(i11, trackGroups)) {
                SelectionOverride selectionOverride = parameters2.getSelectionOverride(i11, trackGroups);
                if (selectionOverride == null || selectionOverride.tracks.length == 0) {
                    definition = null;
                } else {
                    definition = new ExoTrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.type);
                }
                definitionArr[i11] = definition;
            }
        }
    }

    private static void applyTrackSelectionOverrides(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Definition[] definitionArr) {
        ExoTrackSelection.Definition definition;
        int rendererCount = mappedTrackInfo.getRendererCount();
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < rendererCount; i11++) {
            collectTrackSelectionOverrides(mappedTrackInfo.getTrackGroups(i11), trackSelectionParameters, hashMap);
        }
        collectTrackSelectionOverrides(mappedTrackInfo.getUnmappedTrackGroups(), trackSelectionParameters, hashMap);
        for (int i12 = 0; i12 < rendererCount; i12++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(Integer.valueOf(mappedTrackInfo.getRendererType(i12)));
            if (trackSelectionOverride != null) {
                if (trackSelectionOverride.trackIndices.isEmpty() || mappedTrackInfo.getTrackGroups(i12).indexOf(trackSelectionOverride.mediaTrackGroup) == -1) {
                    definition = null;
                } else {
                    definition = new ExoTrackSelection.Definition(trackSelectionOverride.mediaTrackGroup, Ints.toArray(trackSelectionOverride.trackIndices));
                }
                definitionArr[i12] = definition;
            }
        }
    }

    private static void collectTrackSelectionOverrides(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, Map<Integer, TrackSelectionOverride> map) {
        TrackSelectionOverride trackSelectionOverride;
        for (int i11 = 0; i11 < trackGroupArray.length; i11++) {
            TrackSelectionOverride trackSelectionOverride2 = trackSelectionParameters.overrides.get(trackGroupArray.get(i11));
            if (trackSelectionOverride2 != null && ((trackSelectionOverride = map.get(Integer.valueOf(trackSelectionOverride2.getType()))) == null || (trackSelectionOverride.trackIndices.isEmpty() && !trackSelectionOverride2.trackIndices.isEmpty()))) {
                map.put(Integer.valueOf(trackSelectionOverride2.getType()), trackSelectionOverride2);
            }
        }
    }

    public static int getFormatLanguageScore(Format format, @Nullable String str, boolean z11) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 == null || normalizeUndeterminedLanguageToNull == null) {
            if (!z11 || normalizeUndeterminedLanguageToNull2 != null) {
                return 0;
            }
            return 1;
        } else if (normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) || normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
            return 3;
        } else {
            if (Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0].equals(Util.splitAtFirst(normalizeUndeterminedLanguageToNull, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0])) {
                return 2;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int getMaxVideoPixelsToRetainForViewport(TrackGroup trackGroup, int i11, int i12, boolean z11) {
        int i13;
        int i14 = Integer.MAX_VALUE;
        if (!(i11 == Integer.MAX_VALUE || i12 == Integer.MAX_VALUE)) {
            for (int i15 = 0; i15 < trackGroup.length; i15++) {
                Format format = trackGroup.getFormat(i15);
                int i16 = format.width;
                if (i16 > 0 && (i13 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z11, i11, i12, i16, i13);
                    int i17 = format.width;
                    int i18 = format.height;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (((float) maxVideoSizeInViewport.x) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i18 >= ((int) (((float) maxVideoSizeInViewport.y) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i19 < i14) {
                        i14 = i19;
                    }
                }
            }
        }
        return i14;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = r3
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = r0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    /* access modifiers changed from: private */
    public static int getRoleFlagMatchScore(int i11, int i12) {
        if (i11 == 0 || i11 != i12) {
            return Integer.bitCount(i11 & i12);
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    public static int getVideoCodecPreferenceScore(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1662735862:
                if (str.equals(MimeTypes.VIDEO_AV1)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 5;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: private */
    public boolean isAudioFormatWithinAudioChannelCountConstraints(Format format) {
        boolean z11;
        SpatializerWrapperV32 spatializerWrapperV32;
        SpatializerWrapperV32 spatializerWrapperV322;
        synchronized (this.lock) {
            if (this.parameters.constrainAudioChannelCountToDeviceCapabilities && !this.deviceIsTV && format.channelCount > 2 && (!isDolbyAudio(format) || (Util.SDK_INT >= 32 && (spatializerWrapperV322 = this.spatializer) != null && spatializerWrapperV322.isSpatializationSupported()))) {
                if (Util.SDK_INT < 32 || (spatializerWrapperV32 = this.spatializer) == null || !spatializerWrapperV32.isSpatializationSupported() || !this.spatializer.isAvailable() || !this.spatializer.isEnabled() || !this.spatializer.canBeSpatialized(this.audioAttributes, format)) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    private static boolean isDolbyAudio(Format format) {
        String str = format.sampleMimeType;
        if (str == null) {
            return false;
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c11 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c11 = 1;
                    break;
                }
                break;
            case 187078297:
                if (str.equals(MimeTypes.AUDIO_AC4)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSupported(int i11, boolean z11) {
        int f11 = c1.f(i11);
        return f11 == 4 || (z11 && f11 == 3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List lambda$selectAudioTrack$3(Parameters parameters2, boolean z11, int i11, TrackGroup trackGroup, int[] iArr) {
        return AudioTrackInfo.createForTrackGroup(i11, trackGroup, parameters2, iArr, z11, new e(this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            if (num2.intValue() == -1) {
                return 0;
            }
            return -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(Integer num, Integer num2) {
        return 0;
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z11;
        boolean z12 = false;
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            if (i13 >= mappedTrackInfo.getRendererCount()) {
                z11 = true;
                break;
            }
            int rendererType = mappedTrackInfo.getRendererType(i13);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i13];
            if ((rendererType == 1 || rendererType == 2) && exoTrackSelection != null && rendererSupportsTunneling(iArr[i13], mappedTrackInfo.getTrackGroups(i13), exoTrackSelection)) {
                if (rendererType == 1) {
                    if (i12 != -1) {
                        break;
                    }
                    i12 = i13;
                } else if (i11 != -1) {
                    break;
                } else {
                    i11 = i13;
                }
            }
            i13++;
        }
        z11 = false;
        if (!(i12 == -1 || i11 == -1)) {
            z12 = true;
        }
        if (z11 && z12) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(true);
            rendererConfigurationArr[i12] = rendererConfiguration;
            rendererConfigurationArr[i11] = rendererConfiguration;
        }
    }

    /* access modifiers changed from: private */
    public void maybeInvalidateForAudioChannelCountConstraints() {
        boolean z11;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.lock) {
            if (!this.parameters.constrainAudioChannelCountToDeviceCapabilities || this.deviceIsTV || Util.SDK_INT < 32 || (spatializerWrapperV32 = this.spatializer) == null || !spatializerWrapperV32.isSpatializationSupported()) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        if (z11) {
            invalidate();
        }
    }

    @Nullable
    public static String normalizeUndeterminedLanguageToNull(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(exoTrackSelection.getTrackGroup());
        for (int i11 = 0; i11 < exoTrackSelection.length(); i11++) {
            if (c1.h(iArr[indexOf][exoTrackSelection.getIndexInTrackGroup(i11)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private <T extends TrackInfo<T>> Pair<ExoTrackSelection.Definition, Integer> selectTracksForType(int i11, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory<T> factory, Comparator<List<T>> comparator) {
        int i12;
        Object obj;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int rendererCount = mappedTrackInfo.getRendererCount();
        int i13 = 0;
        while (i13 < rendererCount) {
            if (i11 == mappedTrackInfo2.getRendererType(i13)) {
                TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i13);
                int i14 = 0;
                while (i14 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i14);
                    List<T> create = factory.create(i13, trackGroup, iArr[i13][i14]);
                    boolean[] zArr = new boolean[trackGroup.length];
                    int i15 = 0;
                    while (i15 < trackGroup.length) {
                        TrackInfo trackInfo = (TrackInfo) create.get(i15);
                        int selectionEligibility = trackInfo.getSelectionEligibility();
                        if (zArr[i15] || selectionEligibility == 0) {
                            i12 = rendererCount;
                        } else {
                            if (selectionEligibility == 1) {
                                obj = ImmutableList.of(trackInfo);
                                i12 = rendererCount;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(trackInfo);
                                int i16 = i15 + 1;
                                while (i16 < trackGroup.length) {
                                    TrackInfo trackInfo2 = (TrackInfo) create.get(i16);
                                    int i17 = rendererCount;
                                    if (trackInfo2.getSelectionEligibility() == 2 && trackInfo.isCompatibleForAdaptationWith(trackInfo2)) {
                                        arrayList2.add(trackInfo2);
                                        zArr[i16] = true;
                                    }
                                    i16++;
                                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo;
                                    rendererCount = i17;
                                }
                                i12 = rendererCount;
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        i15++;
                        MappingTrackSelector.MappedTrackInfo mappedTrackInfo4 = mappedTrackInfo;
                        rendererCount = i12;
                    }
                    int i18 = rendererCount;
                    i14++;
                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo5 = mappedTrackInfo;
                }
            }
            TrackInfo.Factory<T> factory2 = factory;
            i13++;
            mappedTrackInfo2 = mappedTrackInfo;
            rendererCount = rendererCount;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i19 = 0; i19 < list.size(); i19++) {
            iArr2[i19] = ((TrackInfo) list.get(i19)).trackIndex;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.trackGroup, iArr2), Integer.valueOf(trackInfo3.rendererIndex));
    }

    private void setParametersInternal(Parameters parameters2) {
        boolean z11;
        Assertions.checkNotNull(parameters2);
        synchronized (this.lock) {
            if (!this.parameters.equals(parameters2)) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.parameters = parameters2;
        }
        if (z11) {
            if (parameters2.constrainAudioChannelCountToDeviceCapabilities && this.context == null) {
                Log.w(TAG, AUDIO_CHANNEL_COUNT_CONSTRAINTS_WARN_MESSAGE);
            }
            invalidate();
        }
    }

    public Parameters.Builder buildUponParameters() {
        return getParameters().buildUpon();
    }

    public boolean isSetParametersSupported() {
        return true;
    }

    public void release() {
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.lock) {
            if (Util.SDK_INT >= 32 && (spatializerWrapperV32 = this.spatializer) != null) {
                spatializerWrapperV32.release();
            }
        }
        super.release();
    }

    public ExoTrackSelection.Definition[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters2) throws ExoPlaybackException {
        String str;
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[rendererCount];
        Pair<ExoTrackSelection.Definition, Integer> selectVideoTrack = selectVideoTrack(mappedTrackInfo, iArr, iArr2, parameters2);
        if (selectVideoTrack != null) {
            definitionArr[((Integer) selectVideoTrack.second).intValue()] = (ExoTrackSelection.Definition) selectVideoTrack.first;
        }
        Pair<ExoTrackSelection.Definition, Integer> selectAudioTrack = selectAudioTrack(mappedTrackInfo, iArr, iArr2, parameters2);
        if (selectAudioTrack != null) {
            definitionArr[((Integer) selectAudioTrack.second).intValue()] = (ExoTrackSelection.Definition) selectAudioTrack.first;
        }
        if (selectAudioTrack == null) {
            str = null;
        } else {
            Object obj = selectAudioTrack.first;
            str = ((ExoTrackSelection.Definition) obj).group.getFormat(((ExoTrackSelection.Definition) obj).tracks[0]).language;
        }
        Pair<ExoTrackSelection.Definition, Integer> selectTextTrack = selectTextTrack(mappedTrackInfo, iArr, parameters2, str);
        if (selectTextTrack != null) {
            definitionArr[((Integer) selectTextTrack.second).intValue()] = (ExoTrackSelection.Definition) selectTextTrack.first;
        }
        for (int i11 = 0; i11 < rendererCount; i11++) {
            int rendererType = mappedTrackInfo.getRendererType(i11);
            if (!(rendererType == 2 || rendererType == 1 || rendererType == 3)) {
                definitionArr[i11] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i11), iArr[i11], parameters2);
            }
        }
        return definitionArr;
    }

    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> selectAudioTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters2) throws ExoPlaybackException {
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 < mappedTrackInfo.getRendererCount()) {
                if (2 == mappedTrackInfo.getRendererType(i11) && mappedTrackInfo.getTrackGroups(i11).length > 0) {
                    z11 = true;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        return selectTracksForType(1, mappedTrackInfo, iArr, new g(this, parameters2, z11), new c());
    }

    @Nullable
    public ExoTrackSelection.Definition selectOtherTrack(int i11, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters2) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i12 = 0;
        for (int i13 = 0; i13 < trackGroupArray.length; i13++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < trackGroup2.length; i14++) {
                if (isSupported(iArr2[i14], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroup2.getFormat(i14), iArr2[i14]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroup2;
                        i12 = i14;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i12);
    }

    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> selectTextTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters2, @Nullable String str) throws ExoPlaybackException {
        return selectTracksForType(3, mappedTrackInfo, iArr, new b(parameters2, str), new a());
    }

    public final Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters2;
        boolean z11;
        RendererConfiguration rendererConfiguration;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.lock) {
            parameters2 = this.parameters;
            if (parameters2.constrainAudioChannelCountToDeviceCapabilities && Util.SDK_INT >= 32 && (spatializerWrapperV32 = this.spatializer) != null) {
                spatializerWrapperV32.ensureInitialized(this, (Looper) Assertions.checkStateNotNull(Looper.myLooper()));
            }
        }
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters2);
        applyTrackSelectionOverrides(mappedTrackInfo, parameters2, selectAllTracks);
        applyLegacyRendererOverrides(mappedTrackInfo, parameters2, selectAllTracks);
        for (int i11 = 0; i11 < rendererCount; i11++) {
            int rendererType = mappedTrackInfo.getRendererType(i11);
            if (parameters2.getRendererDisabled(i11) || parameters2.disabledTrackTypes.contains(Integer.valueOf(rendererType))) {
                selectAllTracks[i11] = null;
            }
        }
        ExoTrackSelection[] createTrackSelections = this.trackSelectionFactory.createTrackSelections(selectAllTracks, getBandwidthMeter(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i12 = 0; i12 < rendererCount; i12++) {
            int rendererType2 = mappedTrackInfo.getRendererType(i12);
            boolean z12 = true;
            if (parameters2.getRendererDisabled(i12) || parameters2.disabledTrackTypes.contains(Integer.valueOf(rendererType2))) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 || (mappedTrackInfo.getRendererType(i12) != -2 && createTrackSelections[i12] == null)) {
                z12 = false;
            }
            if (z12) {
                rendererConfiguration = RendererConfiguration.DEFAULT;
            } else {
                rendererConfiguration = null;
            }
            rendererConfigurationArr[i12] = rendererConfiguration;
        }
        if (parameters2.tunnelingEnabled) {
            maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, createTrackSelections);
        }
        return Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> selectVideoTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters2) throws ExoPlaybackException {
        return selectTracksForType(2, mappedTrackInfo, iArr, new f(parameters2, iArr2), new b());
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2) {
        boolean z11;
        synchronized (this.lock) {
            if (!this.audioAttributes.equals(audioAttributes2)) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.audioAttributes = audioAttributes2;
        }
        if (z11) {
            maybeInvalidateForAudioChannelCountConstraints();
        }
    }

    public void setParameters(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            setParametersInternal((Parameters) trackSelectionParameters);
        }
        setParametersInternal(new Parameters.Builder().set(trackSelectionParameters).build());
    }

    public DefaultTrackSelector(Context context2) {
        this(context2, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    public Parameters getParameters() {
        Parameters parameters2;
        synchronized (this.lock) {
            parameters2 = this.parameters;
        }
        return parameters2;
    }

    public DefaultTrackSelector(Context context2, ExoTrackSelection.Factory factory) {
        this(context2, (TrackSelectionParameters) Parameters.getDefaults(context2), factory);
    }

    public DefaultTrackSelector(Context context2, TrackSelectionParameters trackSelectionParameters) {
        this(context2, trackSelectionParameters, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, (Context) null);
    }

    @Deprecated
    public void setParameters(ParametersBuilder parametersBuilder) {
        setParametersInternal(parametersBuilder.build());
    }

    public DefaultTrackSelector(Context context2, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context2);
    }

    public void setParameters(Parameters.Builder builder) {
        setParametersInternal(builder.build());
    }

    private DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory, @Nullable Context context2) {
        this.lock = new Object();
        this.context = context2 != null ? context2.getApplicationContext() : null;
        this.trackSelectionFactory = factory;
        if (trackSelectionParameters instanceof Parameters) {
            this.parameters = (Parameters) trackSelectionParameters;
        } else {
            this.parameters = (context2 == null ? Parameters.DEFAULT_WITHOUT_CONTEXT : Parameters.getDefaults(context2)).buildUpon().set(trackSelectionParameters).build();
        }
        this.audioAttributes = AudioAttributes.DEFAULT;
        boolean z11 = context2 != null && Util.isTv(context2);
        this.deviceIsTV = z11;
        if (!z11 && context2 != null && Util.SDK_INT >= 32) {
            this.spatializer = SpatializerWrapperV32.tryCreateInstance(context2);
        }
        if (this.parameters.constrainAudioChannelCountToDeviceCapabilities && context2 == null) {
            Log.w(TAG, AUDIO_CHANNEL_COUNT_CONSTRAINTS_WARN_MESSAGE);
        }
    }
}
