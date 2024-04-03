package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class StickerBuilder extends IndexableBuilder<StickerBuilder> {
    public StickerBuilder() {
        super("Sticker");
    }

    @NonNull
    public StickerBuilder setIsPartOf(@NonNull StickerPackBuilder stickerPackBuilder) {
        return (StickerBuilder) super.setIsPartOf(stickerPackBuilder);
    }
}
