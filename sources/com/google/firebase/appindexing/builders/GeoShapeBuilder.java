package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class GeoShapeBuilder extends IndexableBuilder<GeoShapeBuilder> {
    public GeoShapeBuilder() {
        super("GeoShape");
    }

    @NonNull
    @Deprecated
    public GeoShapeBuilder setBox(@NonNull String str) {
        put("box", str);
        return this;
    }

    @NonNull
    public GeoShapeBuilder setBox(@NonNull String... strArr) {
        put("box", strArr);
        return this;
    }
}
