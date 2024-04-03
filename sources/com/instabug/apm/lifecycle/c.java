package com.instabug.apm.lifecycle;

import android.app.Activity;
import com.instabug.apm.model.e;
import com.instabug.library.model.common.Session;
import org.jetbrains.annotations.NotNull;

public interface c {
    void a();

    void a(@NotNull Activity activity, @NotNull e eVar);

    void a(@NotNull Session session);

    void b();

    void b(@NotNull Activity activity, @NotNull e eVar);

    void c(@NotNull Activity activity, @NotNull e eVar);
}
