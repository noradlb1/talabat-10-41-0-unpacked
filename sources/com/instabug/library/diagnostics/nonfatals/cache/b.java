package com.instabug.library.diagnostics.nonfatals.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.nonfatals.model.a;
import java.util.List;

public interface b {
    long a(a aVar);

    @Nullable
    List a(int i11);

    void a();

    void a(@Nullable List list);

    long b(@NonNull a aVar);

    void deleteNonFatal(long j11);

    @NonNull
    List getAllNonFatals();
}
