package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public class BookBuilder extends IndexableBuilder<BookBuilder> {
    public BookBuilder() {
        super("Book");
    }

    @NonNull
    public BookBuilder setAuthor(@NonNull PersonBuilder... personBuilderArr) {
        return (BookBuilder) put("author", (S[]) personBuilderArr);
    }
}
