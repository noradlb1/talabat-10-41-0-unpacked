package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public class MusicPlaylistBuilder extends IndexableBuilder<MusicPlaylistBuilder> {
    public MusicPlaylistBuilder() {
        super("MusicPlaylist");
    }

    @NonNull
    public MusicPlaylistBuilder setNumTracks(int i11) {
        return (MusicPlaylistBuilder) put("numTracks", (long) i11);
    }

    @NonNull
    public MusicPlaylistBuilder setTrack(@NonNull MusicRecordingBuilder... musicRecordingBuilderArr) {
        return (MusicPlaylistBuilder) put("track", (S[]) musicRecordingBuilderArr);
    }
}
