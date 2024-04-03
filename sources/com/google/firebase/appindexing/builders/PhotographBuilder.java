package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import java.util.Date;

public final class PhotographBuilder extends IndexableBuilder<PhotographBuilder> {
    public PhotographBuilder() {
        super("Photograph");
    }

    @NonNull
    public PhotographBuilder setDateCreated(@NonNull Date date) {
        put("dateCreated", date.getTime());
        return this;
    }

    @NonNull
    public PhotographBuilder setLocationCreated(@NonNull PlaceBuilder placeBuilder) {
        put("locationCreated", (S[]) new PlaceBuilder[]{placeBuilder});
        return this;
    }
}
