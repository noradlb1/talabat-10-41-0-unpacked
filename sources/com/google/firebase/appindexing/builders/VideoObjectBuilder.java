package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import java.util.Date;

public final class VideoObjectBuilder extends IndexableBuilder<VideoObjectBuilder> {
    public VideoObjectBuilder() {
        super("VideoObject");
    }

    @NonNull
    public VideoObjectBuilder setAuthor(@NonNull PersonBuilder personBuilder) {
        put("author", (S[]) new PersonBuilder[]{personBuilder});
        return this;
    }

    @NonNull
    public VideoObjectBuilder setDuration(long j11) {
        put("duration", j11);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setDurationWatched(long j11) {
        put("durationWatched", j11);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setLocationCreated(@NonNull PlaceBuilder placeBuilder) {
        put("locationCreated", (S[]) new PlaceBuilder[]{placeBuilder});
        return this;
    }

    @NonNull
    public VideoObjectBuilder setSeriesName(@NonNull String str) {
        put("seriesName", str);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setUploadDate(@NonNull Date date) {
        put("uploadDate", date.getTime());
        return this;
    }
}
