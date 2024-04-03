package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class MusicAlbumBuilder extends IndexableBuilder<MusicAlbumBuilder> {
    public MusicAlbumBuilder() {
        super("MusicAlbum");
    }

    @NonNull
    public MusicAlbumBuilder setByArtist(@NonNull MusicGroupBuilder musicGroupBuilder) {
        put("byArtist", (S[]) new MusicGroupBuilder[]{musicGroupBuilder});
        return this;
    }

    @NonNull
    public MusicAlbumBuilder setNumTracks(int i11) {
        put("numTracks", (long) i11);
        return this;
    }

    @NonNull
    public MusicAlbumBuilder setTrack(@NonNull MusicRecordingBuilder... musicRecordingBuilderArr) {
        put("track", (S[]) musicRecordingBuilderArr);
        return this;
    }
}
