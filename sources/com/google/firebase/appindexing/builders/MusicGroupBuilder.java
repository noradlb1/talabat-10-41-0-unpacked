package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class MusicGroupBuilder extends IndexableBuilder<MusicGroupBuilder> {
    public MusicGroupBuilder() {
        super("MusicGroup");
    }

    @NonNull
    public MusicGroupBuilder setAlbum(@NonNull MusicAlbumBuilder... musicAlbumBuilderArr) {
        put("album", (S[]) musicAlbumBuilderArr);
        return this;
    }

    @NonNull
    public MusicGroupBuilder setGenre(@NonNull String str) {
        put("genre", str);
        return this;
    }

    @NonNull
    public MusicGroupBuilder setTrack(@NonNull MusicRecordingBuilder... musicRecordingBuilderArr) {
        put("track", (S[]) musicRecordingBuilderArr);
        return this;
    }
}
