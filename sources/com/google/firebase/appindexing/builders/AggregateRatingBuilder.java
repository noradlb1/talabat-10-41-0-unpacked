package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class AggregateRatingBuilder extends IndexableBuilder<AggregateRatingBuilder> {
    public AggregateRatingBuilder() {
        super("AggregateRating");
    }

    @NonNull
    public AggregateRatingBuilder setRatingCount(@NonNull long j11) {
        put("ratingCount", j11);
        return this;
    }

    @NonNull
    public AggregateRatingBuilder setRatingValue(@NonNull String str) {
        put("ratingValue", str);
        return this;
    }
}
