package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import datamodels.TypesAliasesKt;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern CEA608_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern CEA708_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    private final Allocator allocator;
    private final BaseUrlExclusionList baseUrlExclusionList;
    @Nullable
    private MediaPeriod.Callback callback;
    private final DashChunkSource.Factory chunkSourceFactory;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealtimeOffsetMs;
    private EventSampleStream[] eventSampleStreams = new EventSampleStream[0];
    private List<EventStream> eventStreams;

    /* renamed from: id  reason: collision with root package name */
    final int f35021id;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private int periodIndex;
    private final PlayerEmsgHandler playerEmsgHandler;
    private final PlayerId playerId;
    private ChunkSampleStream<DashChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> trackEmsgHandlerBySampleStream = new IdentityHashMap<>();
    private final TrackGroupInfo[] trackGroupInfos;
    private final TrackGroupArray trackGroups;
    @Nullable
    private final TransferListener transferListener;

    public static final class TrackGroupInfo {
        private static final int CATEGORY_EMBEDDED = 1;
        private static final int CATEGORY_MANIFEST_EVENTS = 2;
        private static final int CATEGORY_PRIMARY = 0;
        public final int[] adaptationSetIndices;
        public final int embeddedClosedCaptionTrackGroupIndex;
        public final int embeddedEventMessageTrackGroupIndex;
        public final int eventStreamGroupIndex;
        public final int primaryTrackGroupIndex;
        public final int trackGroupCategory;
        public final int trackType;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        private TrackGroupInfo(int i11, int i12, int[] iArr, int i13, int i14, int i15, int i16) {
            this.trackType = i11;
            this.adaptationSetIndices = iArr;
            this.trackGroupCategory = i12;
            this.primaryTrackGroupIndex = i13;
            this.embeddedEventMessageTrackGroupIndex = i14;
            this.embeddedClosedCaptionTrackGroupIndex = i15;
            this.eventStreamGroupIndex = i16;
        }

        public static TrackGroupInfo embeddedClosedCaptionTrack(int[] iArr, int i11) {
            return new TrackGroupInfo(3, 1, iArr, i11, -1, -1, -1);
        }

        public static TrackGroupInfo embeddedEmsgTrack(int[] iArr, int i11) {
            return new TrackGroupInfo(5, 1, iArr, i11, -1, -1, -1);
        }

        public static TrackGroupInfo mpdEventTrack(int i11) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i11);
        }

        public static TrackGroupInfo primaryTrack(int i11, int[] iArr, int i12, int i13, int i14) {
            return new TrackGroupInfo(i11, 0, iArr, i12, i13, i14, -1);
        }
    }

    public DashMediaPeriod(int i11, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList2, int i12, DashChunkSource.Factory factory, @Nullable TransferListener transferListener2, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j11, LoaderErrorThrower loaderErrorThrower, Allocator allocator2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, PlayerId playerId2) {
        Allocator allocator3 = allocator2;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory3 = compositeSequenceableLoaderFactory2;
        this.f35021id = i11;
        this.manifest = dashManifest;
        this.baseUrlExclusionList = baseUrlExclusionList2;
        this.periodIndex = i12;
        this.chunkSourceFactory = factory;
        this.transferListener = transferListener2;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.elapsedRealtimeOffsetMs = j11;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator3;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory3;
        this.playerId = playerId2;
        this.playerEmsgHandler = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator3);
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory3.createCompositeSequenceableLoader(this.sampleStreams);
        Period period = dashManifest.getPeriod(i12);
        List<EventStream> list = period.eventStreams;
        this.eventStreams = list;
        Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups = buildTrackGroups(drmSessionManager2, period.adaptationSets, list);
        this.trackGroups = (TrackGroupArray) buildTrackGroups.first;
        this.trackGroupInfos = (TrackGroupInfo[]) buildTrackGroups.second;
    }

    private static void buildManifestEventTrackGroupInfos(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i11) {
        int i12 = 0;
        while (i12 < list.size()) {
            EventStream eventStream = list.get(i12);
            trackGroupArr[i11] = new TrackGroup(eventStream.id() + CertificateUtil.DELIMITER + i12, new Format.Builder().setId(eventStream.id()).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
            trackGroupInfoArr[i11] = TrackGroupInfo.mpdEventTrack(i12);
            i12++;
            i11++;
        }
    }

    private static int buildPrimaryAndEmbeddedTrackGroupInfos(DrmSessionManager drmSessionManager2, List<AdaptationSet> list, int[][] iArr, int i11, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        String str;
        int i12;
        int i13;
        List<AdaptationSet> list2 = list;
        int i14 = i11;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i14) {
            int[] iArr2 = iArr[i15];
            ArrayList arrayList = new ArrayList();
            for (int i17 : iArr2) {
                arrayList.addAll(list2.get(i17).representations);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i18 = 0; i18 < size; i18++) {
                Format format = ((Representation) arrayList.get(i18)).format;
                formatArr2[i18] = format.copyWithCryptoType(drmSessionManager2.getCryptoType(format));
            }
            DrmSessionManager drmSessionManager3 = drmSessionManager2;
            AdaptationSet adaptationSet = list2.get(iArr2[0]);
            int i19 = adaptationSet.f35022id;
            if (i19 != -1) {
                str = Integer.toString(i19);
            } else {
                str = "unset:" + i15;
            }
            int i21 = i16 + 1;
            if (zArr[i15]) {
                i12 = i21 + 1;
            } else {
                i12 = i21;
                i21 = -1;
            }
            if (formatArr[i15].length != 0) {
                i13 = i12 + 1;
            } else {
                i13 = i12;
                i12 = -1;
            }
            trackGroupArr[i16] = new TrackGroup(str, formatArr2);
            trackGroupInfoArr[i16] = TrackGroupInfo.primaryTrack(adaptationSet.type, iArr2, i16, i21, i12);
            if (i21 != -1) {
                String str2 = str + ":emsg";
                trackGroupArr[i21] = new TrackGroup(str2, new Format.Builder().setId(str2).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
                trackGroupInfoArr[i21] = TrackGroupInfo.embeddedEmsgTrack(iArr2, i16);
            }
            if (i12 != -1) {
                trackGroupArr[i12] = new TrackGroup(str + ":cc", formatArr[i15]);
                trackGroupInfoArr[i12] = TrackGroupInfo.embeddedClosedCaptionTrack(iArr2, i16);
            }
            i15++;
            i16 = i13;
        }
        return i16;
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackGroupInfo trackGroupInfo, ExoTrackSelection exoTrackSelection, long j11) {
        boolean z11;
        int i11;
        TrackGroup trackGroup;
        boolean z12;
        TrackGroup trackGroup2;
        int i12;
        TrackGroupInfo trackGroupInfo2 = trackGroupInfo;
        int i13 = trackGroupInfo2.embeddedEventMessageTrackGroupIndex;
        if (i13 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z11) {
            trackGroup = this.trackGroups.get(i13);
            i11 = 1;
        } else {
            i11 = 0;
            trackGroup = null;
        }
        int i14 = trackGroupInfo2.embeddedClosedCaptionTrackGroupIndex;
        if (i14 != -1) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            trackGroup2 = this.trackGroups.get(i14);
            i11 += trackGroup2.length;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i11];
        int[] iArr = new int[i11];
        if (z11) {
            formatArr[0] = trackGroup.getFormat(0);
            iArr[0] = 5;
            i12 = 1;
        } else {
            i12 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z12) {
            for (int i15 = 0; i15 < trackGroup2.length; i15++) {
                Format format = trackGroup2.getFormat(i15);
                formatArr[i12] = format;
                iArr[i12] = 3;
                arrayList.add(format);
                i12++;
            }
        }
        if (this.manifest.dynamic && z11) {
            playerTrackEmsgHandler = this.playerEmsgHandler.newPlayerTrackEmsgHandler();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler3 = playerTrackEmsgHandler2;
        ChunkSampleStream chunkSampleStream = new ChunkSampleStream(trackGroupInfo2.trackType, iArr, formatArr, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.baseUrlExclusionList, this.periodIndex, trackGroupInfo2.adaptationSetIndices, exoTrackSelection, trackGroupInfo2.trackType, this.elapsedRealtimeOffsetMs, z11, arrayList, playerTrackEmsgHandler2, this.transferListener, this.playerId), this, this.allocator, j11, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.mediaSourceEventDispatcher);
        synchronized (this) {
            this.trackEmsgHandlerBySampleStream.put(chunkSampleStream, playerTrackEmsgHandler3);
        }
        return chunkSampleStream;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups(DrmSessionManager drmSessionManager2, List<AdaptationSet> list, List<EventStream> list2) {
        int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(list);
        int length = groupedAdaptationSetIndices.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int identifyEmbeddedTracks = identifyEmbeddedTracks(length, list, groupedAdaptationSetIndices, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[identifyEmbeddedTracks];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[identifyEmbeddedTracks];
        buildManifestEventTrackGroupInfos(list2, trackGroupArr, trackGroupInfoArr, buildPrimaryAndEmbeddedTrackGroupInfos(drmSessionManager2, list, groupedAdaptationSetIndices, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    @Nullable
    private static Descriptor findAdaptationSetSwitchingProperty(List<Descriptor> list) {
        return findDescriptor(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    private static Descriptor findDescriptor(List<Descriptor> list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if (str.equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    @Nullable
    private static Descriptor findTrickPlayProperty(List<Descriptor> list) {
        return findDescriptor(list, "http://dashif.org/guidelines/trickmode");
    }

    private static Format[] getClosedCaptionTrackFormats(List<AdaptationSet> list, int[] iArr) {
        for (int i11 : iArr) {
            AdaptationSet adaptationSet = list.get(i11);
            List<Descriptor> list2 = list.get(i11).accessibilityDescriptors;
            int i12 = 0;
            while (i12 < list2.size()) {
                Descriptor descriptor = list2.get(i12);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                    return parseClosedCaptionDescriptor(descriptor, CEA608_SERVICE_DESCRIPTOR_REGEX, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).setId(adaptationSet.f35022id + ":cea608").build());
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri)) {
                    return parseClosedCaptionDescriptor(descriptor, CEA708_SERVICE_DESCRIPTOR_REGEX, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA708).setId(adaptationSet.f35022id + ":cea708").build());
                } else {
                    i12++;
                }
            }
        }
        return new Format[0];
    }

    private static int[][] getGroupedAdaptationSetIndices(List<AdaptationSet> list) {
        int i11;
        Descriptor findAdaptationSetSwitchingProperty;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i12 = 0; i12 < size; i12++) {
            sparseIntArray.put(list.get(i12).f35022id, i12);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i12));
            arrayList.add(arrayList2);
            sparseArray.put(i12, arrayList2);
        }
        for (int i13 = 0; i13 < size; i13++) {
            AdaptationSet adaptationSet = list.get(i13);
            Descriptor findTrickPlayProperty = findTrickPlayProperty(adaptationSet.essentialProperties);
            if (findTrickPlayProperty == null) {
                findTrickPlayProperty = findTrickPlayProperty(adaptationSet.supplementalProperties);
            }
            if (findTrickPlayProperty == null || (i11 = sparseIntArray.get(Integer.parseInt(findTrickPlayProperty.value), -1)) == -1) {
                i11 = i13;
            }
            if (i11 == i13 && (findAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(adaptationSet.supplementalProperties)) != null) {
                for (String parseInt : Util.split(findAdaptationSetSwitchingProperty.value, ",")) {
                    int i14 = sparseIntArray.get(Integer.parseInt(parseInt), -1);
                    if (i14 != -1) {
                        i11 = Math.min(i11, i14);
                    }
                }
            }
            if (i11 != i13) {
                List list2 = (List) sparseArray.get(i13);
                List list3 = (List) sparseArray.get(i11);
                list3.addAll(list2);
                sparseArray.put(i13, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i15 = 0; i15 < size2; i15++) {
            int[] array = Ints.toArray((Collection) arrayList.get(i15));
            iArr[i15] = array;
            Arrays.sort(array);
        }
        return iArr;
    }

    private int getPrimaryStreamIndex(int i11, int[] iArr) {
        int i12 = iArr[i11];
        if (i12 == -1) {
            return -1;
        }
        int i13 = this.trackGroupInfos[i12].primaryTrackGroupIndex;
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            if (i15 == i13 && this.trackGroupInfos[i15].trackGroupCategory == 0) {
                return i14;
            }
        }
        return -1;
    }

    private int[] getStreamIndexToTrackGroupIndex(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i11];
            if (exoTrackSelection != null) {
                iArr[i11] = this.trackGroups.indexOf(exoTrackSelection.getTrackGroup());
            } else {
                iArr[i11] = -1;
            }
        }
        return iArr;
    }

    private static boolean hasEventMessageTrack(List<AdaptationSet> list, int[] iArr) {
        for (int i11 : iArr) {
            List<Representation> list2 = list.get(i11).representations;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                if (!list2.get(i12).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int identifyEmbeddedTracks(int i11, List<AdaptationSet> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (hasEventMessageTrack(list, iArr[i13])) {
                zArr[i13] = true;
                i12++;
            }
            Format[] closedCaptionTrackFormats = getClosedCaptionTrackFormats(list, iArr[i13]);
            formatArr[i13] = closedCaptionTrackFormats;
            if (closedCaptionTrackFormats.length != 0) {
                i12++;
            }
        }
        return i12;
    }

    private static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int i11) {
        return new ChunkSampleStream[i11];
    }

    private static Format[] parseClosedCaptionDescriptor(Descriptor descriptor, Pattern pattern, Format format) {
        String str = descriptor.value;
        if (str == null) {
            return new Format[]{format};
        }
        String[] split = Util.split(str, TypesAliasesKt.separator);
        Format[] formatArr = new Format[split.length];
        for (int i11 = 0; i11 < split.length; i11++) {
            Matcher matcher = pattern.matcher(split[i11]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            formatArr[i11] = format.buildUpon().setId(format.f34900id + CertificateUtil.DELIMITER + parseInt).setAccessibilityChannel(parseInt).setLanguage(matcher.group(2)).build();
        }
        return formatArr;
    }

    private void releaseDisabledStreams(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
            if (exoTrackSelectionArr[i11] == null || !zArr[i11]) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i11];
                if (chunkSampleStream instanceof ChunkSampleStream) {
                    chunkSampleStream.release(this);
                } else if (chunkSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) chunkSampleStream).release();
                }
                sampleStreamArr[i11] = null;
            }
        }
    }

    private void releaseOrphanEmbeddedStreams(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z11;
        for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
            SampleStream sampleStream = sampleStreamArr[i11];
            if ((sampleStream instanceof EmptySampleStream) || (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int primaryStreamIndex = getPrimaryStreamIndex(i11, iArr);
                if (primaryStreamIndex == -1) {
                    z11 = sampleStreamArr[i11] instanceof EmptySampleStream;
                } else {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream = sampleStreamArr[i11];
                    if (!(embeddedSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) || embeddedSampleStream.parent != sampleStreamArr[primaryStreamIndex]) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                }
                if (!z11) {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream2 = sampleStreamArr[i11];
                    if (embeddedSampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        embeddedSampleStream2.release();
                    }
                    sampleStreamArr[i11] = null;
                }
            }
        }
    }

    private void selectNewStreams(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j11, int[] iArr) {
        for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i11];
            if (exoTrackSelection != null) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i11];
                if (chunkSampleStream == null) {
                    zArr[i11] = true;
                    TrackGroupInfo trackGroupInfo = this.trackGroupInfos[iArr[i11]];
                    int i12 = trackGroupInfo.trackGroupCategory;
                    if (i12 == 0) {
                        sampleStreamArr[i11] = buildSampleStream(trackGroupInfo, exoTrackSelection, j11);
                    } else if (i12 == 2) {
                        sampleStreamArr[i11] = new EventSampleStream(this.eventStreams.get(trackGroupInfo.eventStreamGroupIndex), exoTrackSelection.getTrackGroup().getFormat(0), this.manifest.dynamic);
                    }
                } else if (chunkSampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) chunkSampleStream.getChunkSource()).updateTrackSelection(exoTrackSelection);
                }
            }
        }
        for (int i13 = 0; i13 < exoTrackSelectionArr.length; i13++) {
            if (sampleStreamArr[i13] == null && exoTrackSelectionArr[i13] != null) {
                TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[iArr[i13]];
                if (trackGroupInfo2.trackGroupCategory == 1) {
                    int primaryStreamIndex = getPrimaryStreamIndex(i13, iArr);
                    if (primaryStreamIndex == -1) {
                        sampleStreamArr[i13] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i13] = sampleStreamArr[primaryStreamIndex].selectEmbeddedTrack(j11, trackGroupInfo2.trackType);
                    }
                }
            }
        }
    }

    public boolean continueLoading(long j11) {
        return this.compositeSequenceableLoader.continueLoading(j11);
    }

    public void discardBuffer(long j11, boolean z11) {
        for (ChunkSampleStream<DashChunkSource> discardBuffer : this.sampleStreams) {
            discardBuffer.discardBuffer(j11, z11);
        }
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j11, seekParameters);
            }
        }
        return j11;
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        List<AdaptationSet> list2 = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection next : list) {
            TrackGroupInfo trackGroupInfo = this.trackGroupInfos[this.trackGroups.indexOf(next.getTrackGroup())];
            if (trackGroupInfo.trackGroupCategory == 0) {
                int[] iArr = trackGroupInfo.adaptationSetIndices;
                int length = next.length();
                int[] iArr2 = new int[length];
                for (int i11 = 0; i11 < next.length(); i11++) {
                    iArr2[i11] = next.getIndexInTrackGroup(i11);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).representations.size();
                int i12 = 0;
                int i13 = 0;
                for (int i14 = 0; i14 < length; i14++) {
                    int i15 = iArr2[i14];
                    while (true) {
                        int i16 = i13 + size;
                        if (i15 < i16) {
                            break;
                        }
                        i12++;
                        size = list2.get(iArr[i12]).representations.size();
                        i13 = i16;
                    }
                    arrayList.add(new StreamKey(this.periodIndex, iArr[i12], i15 - i13));
                }
            }
        }
        return arrayList;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public synchronized void onSampleStreamReleased(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.trackEmsgHandlerBySampleStream.remove(chunkSampleStream);
        if (remove != null) {
            remove.release();
        }
    }

    public void prepare(MediaPeriod.Callback callback2, long j11) {
        this.callback = callback2;
        callback2.onPrepared(this);
    }

    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    public void reevaluateBuffer(long j11) {
        this.compositeSequenceableLoader.reevaluateBuffer(j11);
    }

    public void release() {
        this.playerEmsgHandler.release();
        for (ChunkSampleStream<DashChunkSource> release : this.sampleStreams) {
            release.release(this);
        }
        this.callback = null;
    }

    public long seekToUs(long j11) {
        for (ChunkSampleStream<DashChunkSource> seekToUs : this.sampleStreams) {
            seekToUs.seekToUs(j11);
        }
        for (EventSampleStream seekToUs2 : this.eventSampleStreams) {
            seekToUs2.seekToUs(j11);
        }
        return j11;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        int[] streamIndexToTrackGroupIndex = getStreamIndexToTrackGroupIndex(exoTrackSelectionArr);
        releaseDisabledStreams(exoTrackSelectionArr, zArr, sampleStreamArr);
        releaseOrphanEmbeddedStreams(exoTrackSelectionArr, sampleStreamArr, streamIndexToTrackGroupIndex);
        selectNewStreams(exoTrackSelectionArr, sampleStreamArr, zArr2, j11, streamIndexToTrackGroupIndex);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ChunkSampleStream chunkSampleStream : sampleStreamArr) {
            if (chunkSampleStream instanceof ChunkSampleStream) {
                arrayList.add(chunkSampleStream);
            } else if (chunkSampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) chunkSampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] newSampleStreamArray = newSampleStreamArray(arrayList.size());
        this.sampleStreams = newSampleStreamArray;
        arrayList.toArray(newSampleStreamArray);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList2.size()];
        this.eventSampleStreams = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        return j11;
    }

    public void updateManifest(DashManifest dashManifest, int i11) {
        this.manifest = dashManifest;
        this.periodIndex = i11;
        this.playerEmsgHandler.updateManifest(dashManifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSource : chunkSampleStreamArr) {
                chunkSource.getChunkSource().updateManifest(dashManifest, i11);
            }
            this.callback.onContinueLoadingRequested(this);
        }
        this.eventStreams = dashManifest.getPeriod(i11).eventStreams;
        for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            Iterator<EventStream> it = this.eventStreams.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EventStream next = it.next();
                if (next.id().equals(eventSampleStream.eventStreamId())) {
                    boolean z11 = true;
                    int periodCount = dashManifest.getPeriodCount() - 1;
                    if (!dashManifest.dynamic || i11 != periodCount) {
                        z11 = false;
                    }
                    eventSampleStream.updateEventStream(next, z11);
                }
            }
        }
    }

    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }
}
