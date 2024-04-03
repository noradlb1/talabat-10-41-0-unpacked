package com.google.android.exoplayer2.source.hls.playlist;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import java.util.List;
import java.util.Map;

@Deprecated
public final class HlsMasterPlaylist extends HlsMultivariantPlaylist {
    @Deprecated
    public HlsMasterPlaylist(String str, List<String> list, List<HlsMultivariantPlaylist.Variant> list2, List<HlsMultivariantPlaylist.Rendition> list3, List<HlsMultivariantPlaylist.Rendition> list4, List<HlsMultivariantPlaylist.Rendition> list5, List<HlsMultivariantPlaylist.Rendition> list6, @Nullable Format format, @Nullable List<Format> list7, boolean z11, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, list2, list3, list4, list5, list6, format, list7, z11, map, list8);
    }
}
