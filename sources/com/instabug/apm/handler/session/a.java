package com.instabug.apm.handler.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.model.common.Session;

public interface a {
    void onNewSessionStarted(@NonNull Session session, @Nullable Session session2);
}
