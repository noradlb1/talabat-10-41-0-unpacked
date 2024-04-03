package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public class AudiobookBuilder extends IndexableBuilder<AudiobookBuilder> {
    public AudiobookBuilder() {
        super("Audiobook");
    }

    @NonNull
    public AudiobookBuilder setAuthor(@NonNull PersonBuilder... personBuilderArr) {
        return (AudiobookBuilder) put("author", (S[]) personBuilderArr);
    }

    @NonNull
    public AudiobookBuilder setReadBy(@NonNull PersonBuilder... personBuilderArr) {
        return (AudiobookBuilder) put("readBy", (S[]) personBuilderArr);
    }
}
