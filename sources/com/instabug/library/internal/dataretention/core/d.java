package com.instabug.library.internal.dataretention.core;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;

public class d implements e {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Collection f50966a;

    public d(@NonNull Collection collection) {
        this.f50966a = collection;
    }

    public void dispose() {
        for (e dispose : this.f50966a) {
            dispose.dispose();
        }
    }
}
