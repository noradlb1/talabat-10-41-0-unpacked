package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j8.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class TrackSelectionParameters implements Bundleable {
    @Deprecated
    public static final Bundleable.Creator<TrackSelectionParameters> CREATOR = new m();
    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    protected static final int FIELD_CUSTOM_ID_BASE = 1000;
    /* access modifiers changed from: private */
    public static final String FIELD_DISABLED_TRACK_TYPE = Util.intToStringMaxRadix(24);
    /* access modifiers changed from: private */
    public static final String FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE = Util.intToStringMaxRadix(22);
    /* access modifiers changed from: private */
    public static final String FIELD_FORCE_LOWEST_BITRATE = Util.intToStringMaxRadix(21);
    /* access modifiers changed from: private */
    public static final String FIELD_IGNORED_TEXT_SELECTION_FLAGS = Util.intToStringMaxRadix(26);
    /* access modifiers changed from: private */
    public static final String FIELD_MAX_AUDIO_BITRATE = Util.intToStringMaxRadix(19);
    /* access modifiers changed from: private */
    public static final String FIELD_MAX_AUDIO_CHANNEL_COUNT = Util.intToStringMaxRadix(18);
    /* access modifiers changed from: private */
    public static final String FIELD_MAX_VIDEO_BITRATE = Util.intToStringMaxRadix(9);
    /* access modifiers changed from: private */
    public static final String FIELD_MAX_VIDEO_FRAMERATE = Util.intToStringMaxRadix(8);
    /* access modifiers changed from: private */
    public static final String FIELD_MAX_VIDEO_HEIGHT = Util.intToStringMaxRadix(7);
    /* access modifiers changed from: private */
    public static final String FIELD_MAX_VIDEO_WIDTH = Util.intToStringMaxRadix(6);
    /* access modifiers changed from: private */
    public static final String FIELD_MIN_VIDEO_BITRATE = Util.intToStringMaxRadix(13);
    /* access modifiers changed from: private */
    public static final String FIELD_MIN_VIDEO_FRAMERATE = Util.intToStringMaxRadix(12);
    /* access modifiers changed from: private */
    public static final String FIELD_MIN_VIDEO_HEIGHT = Util.intToStringMaxRadix(11);
    /* access modifiers changed from: private */
    public static final String FIELD_MIN_VIDEO_WIDTH = Util.intToStringMaxRadix(10);
    /* access modifiers changed from: private */
    public static final String FIELD_PREFERRED_AUDIO_LANGUAGES = Util.intToStringMaxRadix(1);
    /* access modifiers changed from: private */
    public static final String FIELD_PREFERRED_AUDIO_MIME_TYPES = Util.intToStringMaxRadix(20);
    /* access modifiers changed from: private */
    public static final String FIELD_PREFERRED_AUDIO_ROLE_FLAGS = Util.intToStringMaxRadix(2);
    /* access modifiers changed from: private */
    public static final String FIELD_PREFERRED_TEXT_LANGUAGES = Util.intToStringMaxRadix(3);
    /* access modifiers changed from: private */
    public static final String FIELD_PREFERRED_TEXT_ROLE_FLAGS = Util.intToStringMaxRadix(4);
    /* access modifiers changed from: private */
    public static final String FIELD_PREFERRED_VIDEO_MIMETYPES = Util.intToStringMaxRadix(17);
    /* access modifiers changed from: private */
    public static final String FIELD_PREFERRED_VIDEO_ROLE_FLAGS = Util.intToStringMaxRadix(25);
    /* access modifiers changed from: private */
    public static final String FIELD_SELECTION_OVERRIDES = Util.intToStringMaxRadix(23);
    /* access modifiers changed from: private */
    public static final String FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE = Util.intToStringMaxRadix(5);
    /* access modifiers changed from: private */
    public static final String FIELD_VIEWPORT_HEIGHT = Util.intToStringMaxRadix(15);
    /* access modifiers changed from: private */
    public static final String FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE = Util.intToStringMaxRadix(16);
    /* access modifiers changed from: private */
    public static final String FIELD_VIEWPORT_WIDTH = Util.intToStringMaxRadix(14);
    public final ImmutableSet<Integer> disabledTrackTypes;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int ignoredTextSelectionFlags;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final ImmutableMap<TrackGroup, TrackSelectionOverride> overrides;
    public final ImmutableList<String> preferredAudioLanguages;
    public final ImmutableList<String> preferredAudioMimeTypes;
    public final int preferredAudioRoleFlags;
    public final ImmutableList<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final ImmutableList<String> preferredVideoMimeTypes;
    public final int preferredVideoRoleFlags;
    public final boolean selectUndeterminedTextLanguage;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    static {
        TrackSelectionParameters build = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
    }

    public TrackSelectionParameters(Builder builder) {
        this.maxVideoWidth = builder.maxVideoWidth;
        this.maxVideoHeight = builder.maxVideoHeight;
        this.maxVideoFrameRate = builder.maxVideoFrameRate;
        this.maxVideoBitrate = builder.maxVideoBitrate;
        this.minVideoWidth = builder.minVideoWidth;
        this.minVideoHeight = builder.minVideoHeight;
        this.minVideoFrameRate = builder.minVideoFrameRate;
        this.minVideoBitrate = builder.minVideoBitrate;
        this.viewportWidth = builder.viewportWidth;
        this.viewportHeight = builder.viewportHeight;
        this.viewportOrientationMayChange = builder.viewportOrientationMayChange;
        this.preferredVideoMimeTypes = builder.preferredVideoMimeTypes;
        this.preferredVideoRoleFlags = builder.preferredVideoRoleFlags;
        this.preferredAudioLanguages = builder.preferredAudioLanguages;
        this.preferredAudioRoleFlags = builder.preferredAudioRoleFlags;
        this.maxAudioChannelCount = builder.maxAudioChannelCount;
        this.maxAudioBitrate = builder.maxAudioBitrate;
        this.preferredAudioMimeTypes = builder.preferredAudioMimeTypes;
        this.preferredTextLanguages = builder.preferredTextLanguages;
        this.preferredTextRoleFlags = builder.preferredTextRoleFlags;
        this.ignoredTextSelectionFlags = builder.ignoredTextSelectionFlags;
        this.selectUndeterminedTextLanguage = builder.selectUndeterminedTextLanguage;
        this.forceLowestBitrate = builder.forceLowestBitrate;
        this.forceHighestSupportedBitrate = builder.forceHighestSupportedBitrate;
        this.overrides = ImmutableMap.copyOf(builder.overrides);
        this.disabledTrackTypes = ImmutableSet.copyOf(builder.disabledTrackTypes);
    }

    public static TrackSelectionParameters fromBundle(Bundle bundle) {
        return new Builder(bundle).build();
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (this.maxVideoWidth == trackSelectionParameters.maxVideoWidth && this.maxVideoHeight == trackSelectionParameters.maxVideoHeight && this.maxVideoFrameRate == trackSelectionParameters.maxVideoFrameRate && this.maxVideoBitrate == trackSelectionParameters.maxVideoBitrate && this.minVideoWidth == trackSelectionParameters.minVideoWidth && this.minVideoHeight == trackSelectionParameters.minVideoHeight && this.minVideoFrameRate == trackSelectionParameters.minVideoFrameRate && this.minVideoBitrate == trackSelectionParameters.minVideoBitrate && this.viewportOrientationMayChange == trackSelectionParameters.viewportOrientationMayChange && this.viewportWidth == trackSelectionParameters.viewportWidth && this.viewportHeight == trackSelectionParameters.viewportHeight && this.preferredVideoMimeTypes.equals(trackSelectionParameters.preferredVideoMimeTypes) && this.preferredVideoRoleFlags == trackSelectionParameters.preferredVideoRoleFlags && this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.maxAudioChannelCount == trackSelectionParameters.maxAudioChannelCount && this.maxAudioBitrate == trackSelectionParameters.maxAudioBitrate && this.preferredAudioMimeTypes.equals(trackSelectionParameters.preferredAudioMimeTypes) && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.ignoredTextSelectionFlags == trackSelectionParameters.ignoredTextSelectionFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.forceLowestBitrate == trackSelectionParameters.forceLowestBitrate && this.forceHighestSupportedBitrate == trackSelectionParameters.forceHighestSupportedBitrate && this.overrides.equals(trackSelectionParameters.overrides) && this.disabledTrackTypes.equals(trackSelectionParameters.disabledTrackTypes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.maxVideoWidth + 31) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.preferredVideoMimeTypes.hashCode()) * 31) + this.preferredVideoRoleFlags) * 31) + this.preferredAudioLanguages.hashCode()) * 31) + this.preferredAudioRoleFlags) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + this.preferredAudioMimeTypes.hashCode()) * 31) + this.preferredTextLanguages.hashCode()) * 31) + this.preferredTextRoleFlags) * 31) + this.ignoredTextSelectionFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + this.overrides.hashCode()) * 31) + this.disabledTrackTypes.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_MAX_VIDEO_WIDTH, this.maxVideoWidth);
        bundle.putInt(FIELD_MAX_VIDEO_HEIGHT, this.maxVideoHeight);
        bundle.putInt(FIELD_MAX_VIDEO_FRAMERATE, this.maxVideoFrameRate);
        bundle.putInt(FIELD_MAX_VIDEO_BITRATE, this.maxVideoBitrate);
        bundle.putInt(FIELD_MIN_VIDEO_WIDTH, this.minVideoWidth);
        bundle.putInt(FIELD_MIN_VIDEO_HEIGHT, this.minVideoHeight);
        bundle.putInt(FIELD_MIN_VIDEO_FRAMERATE, this.minVideoFrameRate);
        bundle.putInt(FIELD_MIN_VIDEO_BITRATE, this.minVideoBitrate);
        bundle.putInt(FIELD_VIEWPORT_WIDTH, this.viewportWidth);
        bundle.putInt(FIELD_VIEWPORT_HEIGHT, this.viewportHeight);
        bundle.putBoolean(FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE, this.viewportOrientationMayChange);
        bundle.putStringArray(FIELD_PREFERRED_VIDEO_MIMETYPES, (String[]) this.preferredVideoMimeTypes.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_VIDEO_ROLE_FLAGS, this.preferredVideoRoleFlags);
        bundle.putStringArray(FIELD_PREFERRED_AUDIO_LANGUAGES, (String[]) this.preferredAudioLanguages.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_AUDIO_ROLE_FLAGS, this.preferredAudioRoleFlags);
        bundle.putInt(FIELD_MAX_AUDIO_CHANNEL_COUNT, this.maxAudioChannelCount);
        bundle.putInt(FIELD_MAX_AUDIO_BITRATE, this.maxAudioBitrate);
        bundle.putStringArray(FIELD_PREFERRED_AUDIO_MIME_TYPES, (String[]) this.preferredAudioMimeTypes.toArray(new String[0]));
        bundle.putStringArray(FIELD_PREFERRED_TEXT_LANGUAGES, (String[]) this.preferredTextLanguages.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_TEXT_ROLE_FLAGS, this.preferredTextRoleFlags);
        bundle.putInt(FIELD_IGNORED_TEXT_SELECTION_FLAGS, this.ignoredTextSelectionFlags);
        bundle.putBoolean(FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE, this.selectUndeterminedTextLanguage);
        bundle.putBoolean(FIELD_FORCE_LOWEST_BITRATE, this.forceLowestBitrate);
        bundle.putBoolean(FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE, this.forceHighestSupportedBitrate);
        bundle.putParcelableArrayList(FIELD_SELECTION_OVERRIDES, BundleableUtil.toBundleArrayList(this.overrides.values()));
        bundle.putIntArray(FIELD_DISABLED_TRACK_TYPE, Ints.toArray(this.disabledTrackTypes));
        return bundle;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public HashSet<Integer> disabledTrackTypes;
        /* access modifiers changed from: private */
        public boolean forceHighestSupportedBitrate;
        /* access modifiers changed from: private */
        public boolean forceLowestBitrate;
        /* access modifiers changed from: private */
        public int ignoredTextSelectionFlags;
        /* access modifiers changed from: private */
        public int maxAudioBitrate;
        /* access modifiers changed from: private */
        public int maxAudioChannelCount;
        /* access modifiers changed from: private */
        public int maxVideoBitrate;
        /* access modifiers changed from: private */
        public int maxVideoFrameRate;
        /* access modifiers changed from: private */
        public int maxVideoHeight;
        /* access modifiers changed from: private */
        public int maxVideoWidth;
        /* access modifiers changed from: private */
        public int minVideoBitrate;
        /* access modifiers changed from: private */
        public int minVideoFrameRate;
        /* access modifiers changed from: private */
        public int minVideoHeight;
        /* access modifiers changed from: private */
        public int minVideoWidth;
        /* access modifiers changed from: private */
        public HashMap<TrackGroup, TrackSelectionOverride> overrides;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredAudioLanguages;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredAudioMimeTypes;
        /* access modifiers changed from: private */
        public int preferredAudioRoleFlags;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredTextLanguages;
        /* access modifiers changed from: private */
        public int preferredTextRoleFlags;
        /* access modifiers changed from: private */
        public ImmutableList<String> preferredVideoMimeTypes;
        /* access modifiers changed from: private */
        public int preferredVideoRoleFlags;
        /* access modifiers changed from: private */
        public boolean selectUndeterminedTextLanguage;
        /* access modifiers changed from: private */
        public int viewportHeight;
        /* access modifiers changed from: private */
        public boolean viewportOrientationMayChange;
        /* access modifiers changed from: private */
        public int viewportWidth;

        @Deprecated
        public Builder() {
            this.maxVideoWidth = Integer.MAX_VALUE;
            this.maxVideoHeight = Integer.MAX_VALUE;
            this.maxVideoFrameRate = Integer.MAX_VALUE;
            this.maxVideoBitrate = Integer.MAX_VALUE;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.viewportOrientationMayChange = true;
            this.preferredVideoMimeTypes = ImmutableList.of();
            this.preferredVideoRoleFlags = 0;
            this.preferredAudioLanguages = ImmutableList.of();
            this.preferredAudioRoleFlags = 0;
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.preferredAudioMimeTypes = ImmutableList.of();
            this.preferredTextLanguages = ImmutableList.of();
            this.preferredTextRoleFlags = 0;
            this.ignoredTextSelectionFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.overrides = new HashMap<>();
            this.disabledTrackTypes = new HashSet<>();
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
        private void init(TrackSelectionParameters trackSelectionParameters) {
            this.maxVideoWidth = trackSelectionParameters.maxVideoWidth;
            this.maxVideoHeight = trackSelectionParameters.maxVideoHeight;
            this.maxVideoFrameRate = trackSelectionParameters.maxVideoFrameRate;
            this.maxVideoBitrate = trackSelectionParameters.maxVideoBitrate;
            this.minVideoWidth = trackSelectionParameters.minVideoWidth;
            this.minVideoHeight = trackSelectionParameters.minVideoHeight;
            this.minVideoFrameRate = trackSelectionParameters.minVideoFrameRate;
            this.minVideoBitrate = trackSelectionParameters.minVideoBitrate;
            this.viewportWidth = trackSelectionParameters.viewportWidth;
            this.viewportHeight = trackSelectionParameters.viewportHeight;
            this.viewportOrientationMayChange = trackSelectionParameters.viewportOrientationMayChange;
            this.preferredVideoMimeTypes = trackSelectionParameters.preferredVideoMimeTypes;
            this.preferredVideoRoleFlags = trackSelectionParameters.preferredVideoRoleFlags;
            this.preferredAudioLanguages = trackSelectionParameters.preferredAudioLanguages;
            this.preferredAudioRoleFlags = trackSelectionParameters.preferredAudioRoleFlags;
            this.maxAudioChannelCount = trackSelectionParameters.maxAudioChannelCount;
            this.maxAudioBitrate = trackSelectionParameters.maxAudioBitrate;
            this.preferredAudioMimeTypes = trackSelectionParameters.preferredAudioMimeTypes;
            this.preferredTextLanguages = trackSelectionParameters.preferredTextLanguages;
            this.preferredTextRoleFlags = trackSelectionParameters.preferredTextRoleFlags;
            this.ignoredTextSelectionFlags = trackSelectionParameters.ignoredTextSelectionFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.forceLowestBitrate = trackSelectionParameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = trackSelectionParameters.forceHighestSupportedBitrate;
            this.disabledTrackTypes = new HashSet<>(trackSelectionParameters.disabledTrackTypes);
            this.overrides = new HashMap<>(trackSelectionParameters.overrides);
        }

        private static ImmutableList<String> normalizeLanguageCodes(String[] strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String checkNotNull : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((Object) Util.normalizeLanguageCode((String) Assertions.checkNotNull(checkNotNull)));
            }
            return builder.build();
        }

        @RequiresApi(19)
        private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context context) {
            CaptioningManager captioningManager;
            if ((Util.SDK_INT >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.preferredTextRoleFlags = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.preferredTextLanguages = ImmutableList.of(Util.getLocaleLanguageTag(locale));
                }
            }
        }

        @CanIgnoreReturnValue
        public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this);
        }

        @CanIgnoreReturnValue
        public Builder clearOverride(TrackGroup trackGroup) {
            this.overrides.remove(trackGroup);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder clearOverrides() {
            this.overrides.clear();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder clearOverridesOfType(int i11) {
            Iterator<TrackSelectionOverride> it = this.overrides.values().iterator();
            while (it.hasNext()) {
                if (it.next().getType() == i11) {
                    it.remove();
                }
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        @CanIgnoreReturnValue
        public Builder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        @CanIgnoreReturnValue
        public Builder set(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder setDisabledTrackTypes(Set<Integer> set) {
            this.disabledTrackTypes.clear();
            this.disabledTrackTypes.addAll(set);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setForceHighestSupportedBitrate(boolean z11) {
            this.forceHighestSupportedBitrate = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setForceLowestBitrate(boolean z11) {
            this.forceLowestBitrate = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIgnoredTextSelectionFlags(int i11) {
            this.ignoredTextSelectionFlags = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxAudioBitrate(int i11) {
            this.maxAudioBitrate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxAudioChannelCount(int i11) {
            this.maxAudioChannelCount = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxVideoBitrate(int i11) {
            this.maxVideoBitrate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxVideoFrameRate(int i11) {
            this.maxVideoFrameRate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxVideoSize(int i11, int i12) {
            this.maxVideoWidth = i11;
            this.maxVideoHeight = i12;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxVideoSizeSd() {
            return setMaxVideoSize(AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD);
        }

        @CanIgnoreReturnValue
        public Builder setMinVideoBitrate(int i11) {
            this.minVideoBitrate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMinVideoFrameRate(int i11) {
            this.minVideoFrameRate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMinVideoSize(int i11, int i12) {
            this.minVideoWidth = i11;
            this.minVideoHeight = i12;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            clearOverridesOfType(trackSelectionOverride.getType());
            this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public Builder setPreferredAudioLanguage(@Nullable String str) {
            if (str == null) {
                return setPreferredAudioLanguages(new String[0]);
            }
            return setPreferredAudioLanguages(str);
        }

        @CanIgnoreReturnValue
        public Builder setPreferredAudioLanguages(String... strArr) {
            this.preferredAudioLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        public Builder setPreferredAudioMimeType(@Nullable String str) {
            if (str == null) {
                return setPreferredAudioMimeTypes(new String[0]);
            }
            return setPreferredAudioMimeTypes(str);
        }

        @CanIgnoreReturnValue
        public Builder setPreferredAudioMimeTypes(String... strArr) {
            this.preferredAudioMimeTypes = ImmutableList.copyOf((E[]) strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPreferredAudioRoleFlags(int i11) {
            this.preferredAudioRoleFlags = i11;
            return this;
        }

        public Builder setPreferredTextLanguage(@Nullable String str) {
            if (str == null) {
                return setPreferredTextLanguages(new String[0]);
            }
            return setPreferredTextLanguages(str);
        }

        @CanIgnoreReturnValue
        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            if (Util.SDK_INT >= 19) {
                setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPreferredTextLanguages(String... strArr) {
            this.preferredTextLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPreferredTextRoleFlags(int i11) {
            this.preferredTextRoleFlags = i11;
            return this;
        }

        public Builder setPreferredVideoMimeType(@Nullable String str) {
            if (str == null) {
                return setPreferredVideoMimeTypes(new String[0]);
            }
            return setPreferredVideoMimeTypes(str);
        }

        @CanIgnoreReturnValue
        public Builder setPreferredVideoMimeTypes(String... strArr) {
            this.preferredVideoMimeTypes = ImmutableList.copyOf((E[]) strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPreferredVideoRoleFlags(int i11) {
            this.preferredVideoRoleFlags = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSelectUndeterminedTextLanguage(boolean z11) {
            this.selectUndeterminedTextLanguage = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTrackTypeDisabled(int i11, boolean z11) {
            if (z11) {
                this.disabledTrackTypes.add(Integer.valueOf(i11));
            } else {
                this.disabledTrackTypes.remove(Integer.valueOf(i11));
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setViewportSize(int i11, int i12, boolean z11) {
            this.viewportWidth = i11;
            this.viewportHeight = i12;
            this.viewportOrientationMayChange = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z11) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z11);
        }

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        public Builder(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
        }

        public Builder(Bundle bundle) {
            ImmutableList<TrackSelectionOverride> immutableList;
            String access$000 = TrackSelectionParameters.FIELD_MAX_VIDEO_WIDTH;
            TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
            this.maxVideoWidth = bundle.getInt(access$000, trackSelectionParameters.maxVideoWidth);
            this.maxVideoHeight = bundle.getInt(TrackSelectionParameters.FIELD_MAX_VIDEO_HEIGHT, trackSelectionParameters.maxVideoHeight);
            this.maxVideoFrameRate = bundle.getInt(TrackSelectionParameters.FIELD_MAX_VIDEO_FRAMERATE, trackSelectionParameters.maxVideoFrameRate);
            this.maxVideoBitrate = bundle.getInt(TrackSelectionParameters.FIELD_MAX_VIDEO_BITRATE, trackSelectionParameters.maxVideoBitrate);
            this.minVideoWidth = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_WIDTH, trackSelectionParameters.minVideoWidth);
            this.minVideoHeight = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_HEIGHT, trackSelectionParameters.minVideoHeight);
            this.minVideoFrameRate = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_FRAMERATE, trackSelectionParameters.minVideoFrameRate);
            this.minVideoBitrate = bundle.getInt(TrackSelectionParameters.FIELD_MIN_VIDEO_BITRATE, trackSelectionParameters.minVideoBitrate);
            this.viewportWidth = bundle.getInt(TrackSelectionParameters.FIELD_VIEWPORT_WIDTH, trackSelectionParameters.viewportWidth);
            this.viewportHeight = bundle.getInt(TrackSelectionParameters.FIELD_VIEWPORT_HEIGHT, trackSelectionParameters.viewportHeight);
            this.viewportOrientationMayChange = bundle.getBoolean(TrackSelectionParameters.FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE, trackSelectionParameters.viewportOrientationMayChange);
            this.preferredVideoMimeTypes = ImmutableList.copyOf((E[]) (String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_VIDEO_MIMETYPES), new String[0]));
            this.preferredVideoRoleFlags = bundle.getInt(TrackSelectionParameters.FIELD_PREFERRED_VIDEO_ROLE_FLAGS, trackSelectionParameters.preferredVideoRoleFlags);
            this.preferredAudioLanguages = normalizeLanguageCodes((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_AUDIO_LANGUAGES), new String[0]));
            this.preferredAudioRoleFlags = bundle.getInt(TrackSelectionParameters.FIELD_PREFERRED_AUDIO_ROLE_FLAGS, trackSelectionParameters.preferredAudioRoleFlags);
            this.maxAudioChannelCount = bundle.getInt(TrackSelectionParameters.FIELD_MAX_AUDIO_CHANNEL_COUNT, trackSelectionParameters.maxAudioChannelCount);
            this.maxAudioBitrate = bundle.getInt(TrackSelectionParameters.FIELD_MAX_AUDIO_BITRATE, trackSelectionParameters.maxAudioBitrate);
            this.preferredAudioMimeTypes = ImmutableList.copyOf((E[]) (String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_AUDIO_MIME_TYPES), new String[0]));
            this.preferredTextLanguages = normalizeLanguageCodes((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.FIELD_PREFERRED_TEXT_LANGUAGES), new String[0]));
            this.preferredTextRoleFlags = bundle.getInt(TrackSelectionParameters.FIELD_PREFERRED_TEXT_ROLE_FLAGS, trackSelectionParameters.preferredTextRoleFlags);
            this.ignoredTextSelectionFlags = bundle.getInt(TrackSelectionParameters.FIELD_IGNORED_TEXT_SELECTION_FLAGS, trackSelectionParameters.ignoredTextSelectionFlags);
            this.selectUndeterminedTextLanguage = bundle.getBoolean(TrackSelectionParameters.FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE, trackSelectionParameters.selectUndeterminedTextLanguage);
            this.forceLowestBitrate = bundle.getBoolean(TrackSelectionParameters.FIELD_FORCE_LOWEST_BITRATE, trackSelectionParameters.forceLowestBitrate);
            this.forceHighestSupportedBitrate = bundle.getBoolean(TrackSelectionParameters.FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE, trackSelectionParameters.forceHighestSupportedBitrate);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.FIELD_SELECTION_OVERRIDES);
            if (parcelableArrayList == null) {
                immutableList = ImmutableList.of();
            } else {
                immutableList = BundleableUtil.fromBundleList(TrackSelectionOverride.CREATOR, parcelableArrayList);
            }
            this.overrides = new HashMap<>();
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                TrackSelectionOverride trackSelectionOverride = immutableList.get(i11);
                this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            }
            int[] iArr = (int[]) MoreObjects.firstNonNull(bundle.getIntArray(TrackSelectionParameters.FIELD_DISABLED_TRACK_TYPE), new int[0]);
            this.disabledTrackTypes = new HashSet<>();
            for (int valueOf : iArr) {
                this.disabledTrackTypes.add(Integer.valueOf(valueOf));
            }
        }
    }
}
