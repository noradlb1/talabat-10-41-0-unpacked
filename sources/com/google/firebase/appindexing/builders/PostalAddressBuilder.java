package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import androidx.autofill.HintConstants;

public final class PostalAddressBuilder extends IndexableBuilder<PostalAddressBuilder> {
    public PostalAddressBuilder() {
        super("PostalAddress");
    }

    @NonNull
    public PostalAddressBuilder setAddressCountry(@NonNull String str) {
        put(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY, str);
        return this;
    }

    @NonNull
    public PostalAddressBuilder setAddressLocality(@NonNull String str) {
        put(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY, str);
        return this;
    }

    @NonNull
    public PostalAddressBuilder setPostalCode(@NonNull String str) {
        put("postalCode", str);
        return this;
    }

    @NonNull
    public PostalAddressBuilder setStreetAddress(@NonNull String str) {
        put(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS, str);
        return this;
    }
}
