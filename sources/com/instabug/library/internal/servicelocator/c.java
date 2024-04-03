package com.instabug.library.internal.servicelocator;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class c {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static c a(@NonNull a aVar, @NonNull e eVar) {
        return new d(aVar, eVar);
    }
}
