package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class PlaceBuilder extends IndexableBuilder<PlaceBuilder> {
    public PlaceBuilder() {
        super("Place");
    }

    @NonNull
    public PlaceBuilder setGeo(@NonNull GeoShapeBuilder geoShapeBuilder) {
        put("geo", (S[]) new GeoShapeBuilder[]{geoShapeBuilder});
        return this;
    }
}
