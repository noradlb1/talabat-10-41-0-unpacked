package com.google.android.exoplayer2.source.hls.playlist;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.ParsingLoadable;

public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    public ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser() {
        return new HlsPlaylistParser();
    }

    public ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        return new HlsPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist);
    }
}
