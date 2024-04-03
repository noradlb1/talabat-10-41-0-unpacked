package com.instabug.apm.handler.networklog;

import androidx.annotation.Nullable;
import com.instabug.apm.model.APMNetworkLog;
import java.util.List;
import java.util.Map;

public interface a {
    @Nullable
    List a(String str);

    Map a(long j11);

    void a();

    void a(long j11, String str, boolean z11, String str2, String str3);

    void a(APMNetworkLog aPMNetworkLog);

    boolean a(String str, String str2, String str3);

    long b(APMNetworkLog aPMNetworkLog);

    void b();

    void c();

    void d();

    void e();
}
