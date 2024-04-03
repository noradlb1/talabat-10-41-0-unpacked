package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HlsMultivariantPlaylist extends HlsPlaylist {
    public static final HlsMultivariantPlaylist EMPTY = new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
    public static final int GROUP_INDEX_AUDIO = 1;
    public static final int GROUP_INDEX_SUBTITLE = 2;
    public static final int GROUP_INDEX_VARIANT = 0;
    public final List<Rendition> audios;
    public final List<Rendition> closedCaptions;
    public final List<Uri> mediaPlaylistUrls;
    @Nullable
    public final Format muxedAudioFormat;
    @Nullable
    public final List<Format> muxedCaptionFormats;
    public final List<DrmInitData> sessionKeyDrmInitData;
    public final List<Rendition> subtitles;
    public final Map<String, String> variableDefinitions;
    public final List<Variant> variants;
    public final List<Rendition> videos;

    public static final class Rendition {
        public final Format format;
        public final String groupId;

        /* renamed from: name  reason: collision with root package name */
        public final String f35033name;
        @Nullable
        public final Uri url;

        public Rendition(@Nullable Uri uri, Format format2, String str, String str2) {
            this.url = uri;
            this.format = format2;
            this.groupId = str;
            this.f35033name = str2;
        }
    }

    public static final class Variant {
        @Nullable
        public final String audioGroupId;
        @Nullable
        public final String captionGroupId;
        public final Format format;
        @Nullable
        public final String subtitleGroupId;
        public final Uri url;
        @Nullable
        public final String videoGroupId;

        public Variant(Uri uri, Format format2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.url = uri;
            this.format = format2;
            this.videoGroupId = str;
            this.audioGroupId = str2;
            this.subtitleGroupId = str3;
            this.captionGroupId = str4;
        }

        public static Variant createMediaPlaylistVariantUrl(Uri uri) {
            return new Variant(uri, new Format.Builder().setId("0").setContainerMimeType(MimeTypes.APPLICATION_M3U8).build(), (String) null, (String) null, (String) null, (String) null);
        }

        public Variant copyWithFormat(Format format2) {
            return new Variant(this.url, format2, this.videoGroupId, this.audioGroupId, this.subtitleGroupId, this.captionGroupId);
        }
    }

    public HlsMultivariantPlaylist(String str, List<String> list, List<Variant> list2, List<Rendition> list3, List<Rendition> list4, List<Rendition> list5, List<Rendition> list6, @Nullable Format format, @Nullable List<Format> list7, boolean z11, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z11);
        List<Format> list9;
        this.mediaPlaylistUrls = Collections.unmodifiableList(getMediaPlaylistUrls(list2, list3, list4, list5, list6));
        this.variants = Collections.unmodifiableList(list2);
        this.videos = Collections.unmodifiableList(list3);
        this.audios = Collections.unmodifiableList(list4);
        this.subtitles = Collections.unmodifiableList(list5);
        this.closedCaptions = Collections.unmodifiableList(list6);
        this.muxedAudioFormat = format;
        if (list7 != null) {
            list9 = Collections.unmodifiableList(list7);
        } else {
            list9 = null;
        }
        this.muxedCaptionFormats = list9;
        this.variableDefinitions = Collections.unmodifiableMap(map);
        this.sessionKeyDrmInitData = Collections.unmodifiableList(list8);
    }

    private static void addMediaPlaylistUrls(List<Rendition> list, List<Uri> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = list.get(i11).url;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static <T> List<T> copyStreams(List<T> list, int i11, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i12 = 0; i12 < list.size(); i12++) {
            T t11 = list.get(i12);
            int i13 = 0;
            while (true) {
                if (i13 >= list2.size()) {
                    break;
                }
                StreamKey streamKey = list2.get(i13);
                if (streamKey.groupIndex == i11 && streamKey.streamIndex == i12) {
                    arrayList.add(t11);
                    break;
                }
                i13++;
            }
        }
        return arrayList;
    }

    public static HlsMultivariantPlaylist createSingleVariantMultivariantPlaylist(String str) {
        return new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.singletonList(Variant.createMediaPlaylistVariantUrl(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, (List<Format>) null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List<Uri> getMediaPlaylistUrls(List<Variant> list, List<Rendition> list2, List<Rendition> list3, List<Rendition> list4, List<Rendition> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = list.get(i11).url;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        addMediaPlaylistUrls(list2, arrayList);
        addMediaPlaylistUrls(list3, arrayList);
        addMediaPlaylistUrls(list4, arrayList);
        addMediaPlaylistUrls(list5, arrayList);
        return arrayList;
    }

    public HlsMultivariantPlaylist copy(List<StreamKey> list) {
        return new HlsMultivariantPlaylist(this.baseUri, this.tags, copyStreams(this.variants, 0, list), Collections.emptyList(), copyStreams(this.audios, 1, list), copyStreams(this.subtitles, 2, list), Collections.emptyList(), this.muxedAudioFormat, this.muxedCaptionFormats, this.hasIndependentSegments, this.variableDefinitions, this.sessionKeyDrmInitData);
    }
}
