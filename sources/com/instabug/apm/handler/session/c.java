package com.instabug.apm.handler.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.f;
import com.instabug.library.model.common.Session;
import java.util.List;

public interface c {
    @Nullable
    f a(String str);

    @NonNull
    List a();

    @NonNull
    List a(@NonNull List list);

    void a(int i11);

    void a(@NonNull Session session);

    void a(@NonNull String str, long j11, int i11);

    void a(@NonNull List list, int i11);

    @Nullable
    Session b();

    void b(int i11);

    void b(@NonNull List list);
}
