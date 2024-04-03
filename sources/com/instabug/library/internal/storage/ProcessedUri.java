package com.instabug.library.internal.storage;

import android.net.Uri;
import androidx.annotation.Nullable;

public class ProcessedUri {
    private final boolean isUriEncrypted;
    @Nullable
    private final Uri uri;

    public ProcessedUri(@Nullable Uri uri2, boolean z11) {
        this.uri = uri2;
        this.isUriEncrypted = z11;
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    public boolean isUriEncrypted() {
        return this.isUriEncrypted;
    }
}
