package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class MusicRecordingBuilder extends IndexableBuilder<MusicRecordingBuilder> {
    public MusicRecordingBuilder() {
        super("MusicRecording");
    }

    @NonNull
    public MusicRecordingBuilder setByArtist(@NonNull MusicGroupBuilder musicGroupBuilder) {
        put("byArtist", (S[]) new MusicGroupBuilder[]{musicGroupBuilder});
        return this;
    }

    @NonNull
    public MusicRecordingBuilder setDuration(int i11) {
        put("duration", (long) i11);
        return this;
    }

    @NonNull
    public MusicRecordingBuilder setInAlbum(@NonNull MusicAlbumBuilder musicAlbumBuilder) {
        put("inAlbum", (S[]) new MusicAlbumBuilder[]{musicAlbumBuilder});
        return this;
    }

    @NonNull
    public MusicRecordingBuilder setInPlaylist(@NonNull MusicPlaylistBuilder... musicPlaylistBuilderArr) {
        put("inPlaylist", (S[]) musicPlaylistBuilderArr);
        return this;
    }
}
