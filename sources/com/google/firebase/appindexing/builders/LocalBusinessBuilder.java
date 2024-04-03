package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class LocalBusinessBuilder extends IndexableBuilder<LocalBusinessBuilder> {
    public LocalBusinessBuilder() {
        super("LocalBusiness");
    }

    @NonNull
    public LocalBusinessBuilder setAddress(@NonNull PostalAddressBuilder postalAddressBuilder) {
        put("address", (S[]) new PostalAddressBuilder[]{postalAddressBuilder});
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setAggregateRating(@NonNull AggregateRatingBuilder aggregateRatingBuilder) {
        put("aggregateRating", (S[]) new AggregateRatingBuilder[]{aggregateRatingBuilder});
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setGeo(@NonNull GeoShapeBuilder geoShapeBuilder) {
        put("geo", (S[]) new GeoShapeBuilder[]{geoShapeBuilder});
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setPriceRange(@NonNull String str) {
        put("priceRange", str);
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setTelephone(@NonNull String str) {
        put("telephone", str);
        return this;
    }

    public LocalBusinessBuilder(String str) {
        super("Restaurant");
    }
}
