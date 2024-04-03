package com.instabug.apm.handler.attributes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.attributes.listeners.OnNetworkTraceListener;
import java.util.ArrayList;
import java.util.List;

public class b implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private List f45362a;

    @Nullable
    public List a() {
        return this.f45362a;
    }

    public void a(@NonNull OnNetworkTraceListener onNetworkTraceListener) {
        if (this.f45362a == null) {
            this.f45362a = new ArrayList();
        }
        this.f45362a.add(onNetworkTraceListener);
    }

    public void b(@NonNull OnNetworkTraceListener onNetworkTraceListener) {
        List list = this.f45362a;
        if (list != null) {
            list.remove(onNetworkTraceListener);
        }
    }
}
