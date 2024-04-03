package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class StickerPackBuilder extends IndexableBuilder<StickerPackBuilder> {
    public StickerPackBuilder() {
        super("StickerPack");
    }

    @NonNull
    public StickerPackBuilder setHasSticker(@NonNull StickerBuilder... stickerBuilderArr) {
        put("hasSticker", (S[]) stickerBuilderArr);
        return this;
    }
}
