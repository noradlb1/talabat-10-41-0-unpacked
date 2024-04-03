package com.instabug.apm.cache.handler.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.f;
import com.instabug.library.model.common.Session;
import java.util.List;

public interface a {
    int a(@NonNull f fVar);

    int a(@NonNull String str, long j11, int i11);

    @Nullable
    f a(@NonNull Session session);

    @Nullable
    f a(String str);

    @NonNull
    List a();

    @NonNull
    List a(@NonNull List list);

    void a(int i11);

    void a(@NonNull List list, int i11);

    int b(int i11);

    @Nullable
    f b(String str);

    void b(@NonNull List list);
}
