package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition);
    }

    private TrackSelectionUtil() {
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        List[] listArr = new List[trackSelectionArr.length];
        for (int i11 = 0; i11 < trackSelectionArr.length; i11++) {
            TrackSelection trackSelection = trackSelectionArr[i11];
            listArr[i11] = trackSelection != null ? ImmutableList.of(trackSelection) : ImmutableList.of();
        }
        return buildTracks(mappedTrackInfo, (List<? extends TrackSelection>[]) listArr);
    }

    public static LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions(ExoTrackSelection exoTrackSelection) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (exoTrackSelection.isBlacklisted(i12, elapsedRealtime)) {
                i11++;
            }
        }
        return new LoadErrorHandlingPolicy.FallbackOptions(1, 0, length, i11);
    }

    public static ExoTrackSelection[] createTrackSelectionsForDefinitions(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z11 = false;
        for (int i11 = 0; i11 < definitionArr.length; i11++) {
            ExoTrackSelection.Definition definition = definitionArr[i11];
            if (definition != null) {
                int[] iArr = definition.tracks;
                if (iArr.length <= 1 || z11) {
                    exoTrackSelectionArr[i11] = new FixedTrackSelection(definition.group, iArr[0], definition.type);
                } else {
                    exoTrackSelectionArr[i11] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z11 = true;
                }
            }
        }
        return exoTrackSelectionArr;
    }

    public static DefaultTrackSelector.Parameters updateParametersWithOverride(DefaultTrackSelector.Parameters parameters, int i11, TrackGroupArray trackGroupArray, boolean z11, @Nullable DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.Parameters.Builder rendererDisabled = parameters.buildUpon().clearSelectionOverrides(i11).setRendererDisabled(i11, z11);
        if (selectionOverride != null) {
            rendererDisabled.setSelectionOverride(i11, trackGroupArray, selectionOverride);
        }
        return rendererDisabled.build();
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        boolean z11;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i11 = 0; i11 < mappedTrackInfo.getRendererCount(); i11++) {
            TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i11);
            List<? extends TrackSelection> list = listArr[i11];
            for (int i12 = 0; i12 < trackGroups.length; i12++) {
                TrackGroup trackGroup = trackGroups.get(i12);
                boolean z12 = mappedTrackInfo2.getAdaptiveSupport(i11, i12, false) != 0;
                int i13 = trackGroup.length;
                int[] iArr = new int[i13];
                boolean[] zArr = new boolean[i13];
                for (int i14 = 0; i14 < trackGroup.length; i14++) {
                    iArr[i14] = mappedTrackInfo2.getTrackSupport(i11, i12, i14);
                    int i15 = 0;
                    while (true) {
                        if (i15 >= list.size()) {
                            z11 = false;
                            break;
                        }
                        TrackSelection trackSelection = (TrackSelection) list.get(i15);
                        if (trackSelection.getTrackGroup().equals(trackGroup) && trackSelection.indexOf(i14) != -1) {
                            z11 = true;
                            break;
                        }
                        i15++;
                    }
                    zArr[i14] = z11;
                }
                builder.add((Object) new Tracks.Group(trackGroup, z12, iArr, zArr));
            }
        }
        TrackGroupArray unmappedTrackGroups = mappedTrackInfo.getUnmappedTrackGroups();
        for (int i16 = 0; i16 < unmappedTrackGroups.length; i16++) {
            TrackGroup trackGroup2 = unmappedTrackGroups.get(i16);
            int[] iArr2 = new int[trackGroup2.length];
            Arrays.fill(iArr2, 0);
            builder.add((Object) new Tracks.Group(trackGroup2, false, iArr2, new boolean[trackGroup2.length]));
        }
        return new Tracks(builder.build());
    }
}
