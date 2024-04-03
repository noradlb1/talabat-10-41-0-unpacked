package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private int audioVideoSampleStreamWrapperCount;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private int[][] manifestUrlIndicesPerWrapper;
    /* access modifiers changed from: private */
    @Nullable
    public MediaPeriod.Callback mediaPeriodCallback;
    @Nullable
    private final TransferListener mediaTransferListener;
    private final int metadataType;
    private int pendingPrepareCount;
    private final PlayerId playerId;
    /* access modifiers changed from: private */
    public final HlsPlaylistTracker playlistTracker;
    private final HlsSampleStreamWrapper.Callback sampleStreamWrapperCallback = new SampleStreamWrapperCallback();
    /* access modifiers changed from: private */
    public HlsSampleStreamWrapper[] sampleStreamWrappers;
    private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    /* access modifiers changed from: private */
    public TrackGroupArray trackGroups;
    private final boolean useSessionKeys;

    public class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        private SampleStreamWrapperCallback() {
        }

        public void onPlaylistRefreshRequired(Uri uri) {
            HlsMediaPeriod.this.playlistTracker.refreshPlaylist(uri);
        }

        public void onPrepared() {
            if (HlsMediaPeriod.access$106(HlsMediaPeriod.this) <= 0) {
                int i11 = 0;
                for (HlsSampleStreamWrapper trackGroups : HlsMediaPeriod.this.sampleStreamWrappers) {
                    i11 += trackGroups.getTrackGroups().length;
                }
                TrackGroup[] trackGroupArr = new TrackGroup[i11];
                int i12 = 0;
                for (HlsSampleStreamWrapper hlsSampleStreamWrapper : HlsMediaPeriod.this.sampleStreamWrappers) {
                    int i13 = hlsSampleStreamWrapper.getTrackGroups().length;
                    int i14 = 0;
                    while (i14 < i13) {
                        trackGroupArr[i12] = hlsSampleStreamWrapper.getTrackGroups().get(i14);
                        i14++;
                        i12++;
                    }
                }
                TrackGroupArray unused = HlsMediaPeriod.this.trackGroups = new TrackGroupArray(trackGroupArr);
                HlsMediaPeriod.this.mediaPeriodCallback.onPrepared(HlsMediaPeriod.this);
            }
        }

        public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            HlsMediaPeriod.this.mediaPeriodCallback.onContinueLoadingRequested(HlsMediaPeriod.this);
        }
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher3, Allocator allocator2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, boolean z11, int i11, boolean z12, PlayerId playerId2) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.mediaTransferListener = transferListener;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher3;
        this.allocator = allocator2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.allowChunklessPreparation = z11;
        this.metadataType = i11;
        this.useSessionKeys = z12;
        this.playerId = playerId2;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamWrapperIndices = new IdentityHashMap<>();
        this.timestampAdjusterProvider = new TimestampAdjusterProvider();
        this.sampleStreamWrappers = new HlsSampleStreamWrapper[0];
        this.enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
        this.manifestUrlIndicesPerWrapper = new int[0][];
    }

    public static /* synthetic */ int access$106(HlsMediaPeriod hlsMediaPeriod) {
        int i11 = hlsMediaPeriod.pendingPrepareCount - 1;
        hlsMediaPeriod.pendingPrepareCount = i11;
        return i11;
    }

    private void buildAndPrepareAudioSampleStreamWrappers(long j11, List<HlsMultivariantPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        boolean z11;
        List<HlsMultivariantPlaylist.Rendition> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list4.get(i11).f35033name;
            if (!hashSet.add(str)) {
                List<HlsSampleStreamWrapper> list5 = list2;
                List<int[]> list6 = list3;
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z12 = true;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (Util.areEqual(str, list4.get(i12).f35033name)) {
                        HlsMultivariantPlaylist.Rendition rendition = list4.get(i12);
                        arrayList3.add(Integer.valueOf(i12));
                        arrayList.add(rendition.url);
                        arrayList2.add(rendition.format);
                        if (Util.getCodecCountOfType(rendition.format.codecs, 1) == 1) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        z12 &= z11;
                    }
                }
                String str2 = "audio:" + str;
                HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(str2, 1, (Uri[]) arrayList.toArray((Uri[]) Util.castNonNullTypeArray(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j11);
                list3.add(Ints.toArray(arrayList3));
                list2.add(buildSampleStreamWrapper);
                if (this.allowChunklessPreparation && z12) {
                    buildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo(new TrackGroup[]{new TrackGroup(str2, (Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private void buildAndPrepareMainSampleStreamWrapper(HlsMultivariantPlaylist hlsMultivariantPlaylist, long j11, List<HlsSampleStreamWrapper> list, List<int[]> list2, Map<String, DrmInitData> map) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i11;
        HlsMultivariantPlaylist hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
        int size = hlsMultivariantPlaylist2.variants.size();
        int[] iArr = new int[size];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < hlsMultivariantPlaylist2.variants.size(); i14++) {
            Format format = hlsMultivariantPlaylist2.variants.get(i14).format;
            if (format.height > 0 || Util.getCodecsOfType(format.codecs, 2) != null) {
                iArr[i14] = 2;
                i12++;
            } else if (Util.getCodecsOfType(format.codecs, 1) != null) {
                iArr[i14] = 1;
                i13++;
            } else {
                iArr[i14] = -1;
            }
        }
        if (i12 > 0) {
            size = i12;
            z12 = true;
            z11 = false;
        } else if (i13 < size) {
            size -= i13;
            z12 = false;
            z11 = true;
        } else {
            z12 = false;
            z11 = false;
        }
        Uri[] uriArr = new Uri[size];
        Format[] formatArr = new Format[size];
        int[] iArr2 = new int[size];
        int i15 = 0;
        for (int i16 = 0; i16 < hlsMultivariantPlaylist2.variants.size(); i16++) {
            if ((!z12 || iArr[i16] == 2) && (!z11 || iArr[i16] != 1)) {
                HlsMultivariantPlaylist.Variant variant = hlsMultivariantPlaylist2.variants.get(i16);
                uriArr[i15] = variant.url;
                formatArr[i15] = variant.format;
                iArr2[i15] = i16;
                i15++;
            }
        }
        String str = formatArr[0].codecs;
        int codecCountOfType = Util.getCodecCountOfType(str, 2);
        int codecCountOfType2 = Util.getCodecCountOfType(str, 1);
        if ((codecCountOfType2 == 1 || (codecCountOfType2 == 0 && hlsMultivariantPlaylist2.audios.isEmpty())) && codecCountOfType <= 1 && codecCountOfType2 + codecCountOfType > 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 || codecCountOfType2 <= 0) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper("main", i11, uriArr, formatArr, hlsMultivariantPlaylist2.muxedAudioFormat, hlsMultivariantPlaylist2.muxedCaptionFormats, map, j11);
        list.add(buildSampleStreamWrapper);
        list2.add(iArr2);
        if (this.allowChunklessPreparation && z13) {
            ArrayList arrayList = new ArrayList();
            if (codecCountOfType > 0) {
                Format[] formatArr2 = new Format[size];
                for (int i17 = 0; i17 < size; i17++) {
                    formatArr2[i17] = deriveVideoFormat(formatArr[i17]);
                }
                arrayList.add(new TrackGroup("main", formatArr2));
                if (codecCountOfType2 > 0 && (hlsMultivariantPlaylist2.muxedAudioFormat != null || hlsMultivariantPlaylist2.audios.isEmpty())) {
                    arrayList.add(new TrackGroup("main" + ":audio", deriveAudioFormat(formatArr[0], hlsMultivariantPlaylist2.muxedAudioFormat, false)));
                }
                List<Format> list3 = hlsMultivariantPlaylist2.muxedCaptionFormats;
                if (list3 != null) {
                    for (int i18 = 0; i18 < list3.size(); i18++) {
                        arrayList.add(new TrackGroup("main" + ":cc:" + i18, list3.get(i18)));
                    }
                }
            } else {
                Format[] formatArr3 = new Format[size];
                for (int i19 = 0; i19 < size; i19++) {
                    formatArr3[i19] = deriveAudioFormat(formatArr[i19], hlsMultivariantPlaylist2.muxedAudioFormat, true);
                }
                arrayList.add(new TrackGroup("main", formatArr3));
            }
            TrackGroup trackGroup = new TrackGroup("main" + ":id3", new Format.Builder().setId("ID3").setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
            arrayList.add(trackGroup);
            buildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo((TrackGroup[]) arrayList.toArray(new TrackGroup[0]), 0, arrayList.indexOf(trackGroup));
        }
    }

    private void buildAndPrepareSampleStreamWrappers(long j11) {
        Map<String, DrmInitData> map;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(this.playlistTracker.getMultivariantPlaylist());
        if (this.useSessionKeys) {
            map = deriveOverridingDrmInitData(hlsMultivariantPlaylist.sessionKeyDrmInitData);
        } else {
            map = Collections.emptyMap();
        }
        Map<String, DrmInitData> map2 = map;
        boolean z11 = !hlsMultivariantPlaylist.variants.isEmpty();
        List<HlsMultivariantPlaylist.Rendition> list = hlsMultivariantPlaylist.audios;
        List<HlsMultivariantPlaylist.Rendition> list2 = hlsMultivariantPlaylist.subtitles;
        this.pendingPrepareCount = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z11) {
            buildAndPrepareMainSampleStreamWrapper(hlsMultivariantPlaylist, j11, arrayList, arrayList2, map2);
        }
        buildAndPrepareAudioSampleStreamWrappers(j11, list, arrayList, arrayList2, map2);
        this.audioVideoSampleStreamWrapperCount = arrayList.size();
        int i11 = 0;
        while (i11 < list2.size()) {
            HlsMultivariantPlaylist.Rendition rendition = list2.get(i11);
            String str = "subtitle:" + i11 + CertificateUtil.DELIMITER + rendition.f35033name;
            int i12 = i11;
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(str, 3, new Uri[]{rendition.url}, new Format[]{rendition.format}, (Format) null, Collections.emptyList(), map2, j11);
            ArrayList arrayList3 = arrayList2;
            arrayList3.add(new int[]{i12});
            arrayList.add(buildSampleStreamWrapper);
            buildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo(new TrackGroup[]{new TrackGroup(str, rendition.format)}, 0, new int[0]);
            i11 = i12 + 1;
            arrayList2 = arrayList3;
        }
        this.sampleStreamWrappers = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.manifestUrlIndicesPerWrapper = (int[][]) arrayList2.toArray(new int[0][]);
        this.pendingPrepareCount = this.sampleStreamWrappers.length;
        for (int i13 = 0; i13 < this.audioVideoSampleStreamWrapperCount; i13++) {
            this.sampleStreamWrappers[i13].setIsTimestampMaster(true);
        }
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(String str, int i11, Uri[] uriArr, Format[] formatArr, @Nullable Format format, @Nullable List<Format> list, Map<String, DrmInitData> map, long j11) {
        HlsChunkSource hlsChunkSource = new HlsChunkSource(this.extractorFactory, this.playlistTracker, uriArr, formatArr, this.dataSourceFactory, this.mediaTransferListener, this.timestampAdjusterProvider, list, this.playerId);
        return new HlsSampleStreamWrapper(str, i11, this.sampleStreamWrapperCallback, hlsChunkSource, map, this.allocator, j11, format, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.eventDispatcher, this.metadataType);
    }

    private static Format deriveAudioFormat(Format format, @Nullable Format format2, boolean z11) {
        String str;
        String str2;
        int i11;
        int i12;
        int i13;
        Metadata metadata;
        String str3;
        int i14;
        int i15 = -1;
        if (format2 != null) {
            str3 = format2.codecs;
            metadata = format2.metadata;
            i13 = format2.channelCount;
            i12 = format2.selectionFlags;
            i11 = format2.roleFlags;
            str2 = format2.language;
            str = format2.label;
        } else {
            str3 = Util.getCodecsOfType(format.codecs, 1);
            metadata = format.metadata;
            if (z11) {
                i13 = format.channelCount;
                i12 = format.selectionFlags;
                i11 = format.roleFlags;
                str2 = format.language;
                str = format.label;
            } else {
                i12 = 0;
                str2 = null;
                i13 = -1;
                i11 = 0;
                str = null;
            }
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str3);
        if (z11) {
            i14 = format.averageBitrate;
        } else {
            i14 = -1;
        }
        if (z11) {
            i15 = format.peakBitrate;
        }
        return new Format.Builder().setId(format.f34900id).setLabel(str).setContainerMimeType(format.containerMimeType).setSampleMimeType(mediaMimeType).setCodecs(str3).setMetadata(metadata).setAverageBitrate(i14).setPeakBitrate(i15).setChannelCount(i13).setSelectionFlags(i12).setRoleFlags(i11).setLanguage(str2).build();
    }

    private static Map<String, DrmInitData> deriveOverridingDrmInitData(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            DrmInitData drmInitData = list.get(i11);
            String str = drmInitData.schemeType;
            i11++;
            int i12 = i11;
            while (i12 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i12);
                if (TextUtils.equals(drmInitData2.schemeType, str)) {
                    drmInitData = drmInitData.merge(drmInitData2);
                    arrayList.remove(i12);
                } else {
                    i12++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    private static Format deriveVideoFormat(Format format) {
        String codecsOfType = Util.getCodecsOfType(format.codecs, 2);
        return new Format.Builder().setId(format.f34900id).setLabel(format.label).setContainerMimeType(format.containerMimeType).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(format.metadata).setAverageBitrate(format.averageBitrate).setPeakBitrate(format.peakBitrate).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).build();
    }

    public boolean continueLoading(long j11) {
        if (this.trackGroups != null) {
            return this.compositeSequenceableLoader.continueLoading(j11);
        }
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        return false;
    }

    public void discardBuffer(long j11, boolean z11) {
        for (HlsSampleStreamWrapper discardBuffer : this.enabledSampleStreamWrappers) {
            discardBuffer.discardBuffer(j11, z11);
        }
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            if (hlsSampleStreamWrapper.isVideoSampleStream()) {
                return hlsSampleStreamWrapper.getAdjustedSeekPositionUs(j11, seekParameters);
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
        TrackGroupArray trackGroupArray;
        int[] iArr;
        int i11;
        int i12;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(hlsMediaPeriod.playlistTracker.getMultivariantPlaylist());
        boolean z11 = !hlsMultivariantPlaylist.variants.isEmpty();
        int length = hlsMediaPeriod.sampleStreamWrappers.length - hlsMultivariantPlaylist.subtitles.size();
        int i13 = 0;
        if (z11) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.sampleStreamWrappers[0];
            iArr = hlsMediaPeriod.manifestUrlIndicesPerWrapper[0];
            trackGroupArray = hlsSampleStreamWrapper.getTrackGroups();
            i11 = hlsSampleStreamWrapper.getPrimaryTrackGroupIndex();
        } else {
            iArr = new int[0];
            trackGroupArray = TrackGroupArray.EMPTY;
            i11 = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z12 = false;
        boolean z13 = false;
        for (ExoTrackSelection next : list) {
            TrackGroup trackGroup = next.getTrackGroup();
            int indexOf = trackGroupArray.indexOf(trackGroup);
            if (indexOf == -1) {
                int i14 = z11;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.sampleStreamWrappers;
                    if (i14 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i14].getTrackGroups().indexOf(trackGroup) != -1) {
                        if (i14 < length) {
                            i12 = 1;
                        } else {
                            i12 = 2;
                        }
                        int[] iArr2 = hlsMediaPeriod.manifestUrlIndicesPerWrapper[i14];
                        int i15 = 0;
                        while (i15 < next.length()) {
                            arrayList.add(new StreamKey(i12, iArr2[next.getIndexInTrackGroup(i15)]));
                            i15++;
                        }
                    } else {
                        i14++;
                        hlsMediaPeriod = this;
                    }
                }
            } else if (indexOf == i11) {
                for (int i16 = i13; i16 < next.length(); i16++) {
                    arrayList.add(new StreamKey(i13, iArr[next.getIndexInTrackGroup(i16)]));
                }
                z13 = true;
            } else {
                z12 = true;
            }
            hlsMediaPeriod = this;
            i13 = 0;
        }
        if (z12 && !z13) {
            int i17 = iArr[0];
            int i18 = hlsMultivariantPlaylist.variants.get(i17).format.bitrate;
            for (int i19 = 1; i19 < iArr.length; i19++) {
                int i21 = hlsMultivariantPlaylist.variants.get(iArr[i19]).format.bitrate;
                if (i21 < i18) {
                    i17 = iArr[i19];
                    i18 = i21;
                }
            }
            arrayList.add(new StreamKey(0, i17));
        }
        return arrayList;
    }

    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() throws IOException {
        for (HlsSampleStreamWrapper maybeThrowPrepareError : this.sampleStreamWrappers) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public void onPlaylistChanged() {
        for (HlsSampleStreamWrapper onPlaylistUpdated : this.sampleStreamWrappers) {
            onPlaylistUpdated.onPlaylistUpdated();
        }
        this.mediaPeriodCallback.onContinueLoadingRequested(this);
    }

    public boolean onPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z11) {
        boolean z12 = true;
        for (HlsSampleStreamWrapper onPlaylistError : this.sampleStreamWrappers) {
            z12 &= onPlaylistError.onPlaylistError(uri, loadErrorInfo, z11);
        }
        this.mediaPeriodCallback.onContinueLoadingRequested(this);
        return z12;
    }

    public void prepare(MediaPeriod.Callback callback, long j11) {
        this.mediaPeriodCallback = callback;
        this.playlistTracker.addListener(this);
        buildAndPrepareSampleStreamWrappers(j11);
    }

    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    public void reevaluateBuffer(long j11) {
        this.compositeSequenceableLoader.reevaluateBuffer(j11);
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        for (HlsSampleStreamWrapper release : this.sampleStreamWrappers) {
            release.release();
        }
        this.mediaPeriodCallback = null;
    }

    public long seekToUs(long j11) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean seekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j11, false);
            int i11 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                if (i11 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i11].seekToUs(j11, seekToUs);
                i11++;
            }
            if (seekToUs) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return j11;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        boolean z11;
        SampleStream sampleStream;
        int i11;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        for (int i12 = 0; i12 < exoTrackSelectionArr2.length; i12++) {
            SampleStream sampleStream2 = sampleStreamArr2[i12];
            if (sampleStream2 == null) {
                i11 = -1;
            } else {
                i11 = this.streamWrapperIndices.get(sampleStream2).intValue();
            }
            iArr[i12] = i11;
            iArr2[i12] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i12];
            if (exoTrackSelection != null) {
                TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
                int i13 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
                    if (i13 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i13].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i12] = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
        }
        this.streamWrapperIndices.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
        int i14 = 0;
        int i15 = 0;
        boolean z12 = false;
        while (i15 < this.sampleStreamWrappers.length) {
            for (int i16 = 0; i16 < exoTrackSelectionArr2.length; i16++) {
                ExoTrackSelection exoTrackSelection2 = null;
                if (iArr[i16] == i15) {
                    sampleStream = sampleStreamArr2[i16];
                } else {
                    sampleStream = null;
                }
                sampleStreamArr4[i16] = sampleStream;
                if (iArr2[i16] == i15) {
                    exoTrackSelection2 = exoTrackSelectionArr2[i16];
                }
                exoTrackSelectionArr3[i16] = exoTrackSelection2;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrappers[i15];
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapper;
            int i17 = i14;
            int i18 = length;
            int i19 = i15;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean selectTracks = hlsSampleStreamWrapper.selectTracks(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j11, z12);
            int i21 = 0;
            boolean z13 = false;
            while (true) {
                z11 = true;
                if (i21 >= exoTrackSelectionArr2.length) {
                    break;
                }
                SampleStream sampleStream3 = sampleStreamArr4[i21];
                if (iArr2[i21] == i19) {
                    Assertions.checkNotNull(sampleStream3);
                    sampleStreamArr3[i21] = sampleStream3;
                    this.streamWrapperIndices.put(sampleStream3, Integer.valueOf(i19));
                    z13 = true;
                } else if (iArr[i21] == i19) {
                    if (sampleStream3 != null) {
                        z11 = false;
                    }
                    Assertions.checkState(z11);
                }
                i21++;
            }
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = hlsSampleStreamWrapperArr3;
            if (z13) {
                hlsSampleStreamWrapperArr4[i17] = hlsSampleStreamWrapper2;
                i14 = i17 + 1;
                if (i17 == 0) {
                    hlsSampleStreamWrapper2.setIsTimestampMaster(true);
                    if (!selectTracks) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = this.enabledSampleStreamWrappers;
                        if (hlsSampleStreamWrapperArr5.length != 0 && hlsSampleStreamWrapper2 == hlsSampleStreamWrapperArr5[0]) {
                        }
                    }
                    this.timestampAdjusterProvider.reset();
                    z12 = true;
                } else {
                    if (i19 >= this.audioVideoSampleStreamWrapperCount) {
                        z11 = false;
                    }
                    hlsSampleStreamWrapper2.setIsTimestampMaster(z11);
                }
            } else {
                i14 = i17;
            }
            i15 = i19 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr4;
            length = i18;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr6 = (HlsSampleStreamWrapper[]) Util.nullSafeArrayCopy(hlsSampleStreamWrapperArr2, i14);
        this.enabledSampleStreamWrappers = hlsSampleStreamWrapperArr6;
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(hlsSampleStreamWrapperArr6);
        return j11;
    }
}
