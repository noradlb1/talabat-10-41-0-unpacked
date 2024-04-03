package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class PersonBuilder extends IndexableBuilder<PersonBuilder> {
    public PersonBuilder() {
        super("Person");
    }

    @NonNull
    public PersonBuilder setEmail(@NonNull String str) {
        put("email", str);
        return this;
    }

    @NonNull
    public PersonBuilder setIsSelf(@NonNull boolean z11) {
        put("isSelf", z11);
        return this;
    }

    @NonNull
    public PersonBuilder setTelephone(@NonNull String str) {
        put("telephone", str);
        return this;
    }
}
