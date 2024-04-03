package com.instabug.apm.handler.attributes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.attributes.listeners.OnNetworkTraceListener;
import java.util.List;

public interface a {
    @Nullable
    List a();

    void a(@NonNull OnNetworkTraceListener onNetworkTraceListener);

    void b(@NonNull OnNetworkTraceListener onNetworkTraceListener);
}
