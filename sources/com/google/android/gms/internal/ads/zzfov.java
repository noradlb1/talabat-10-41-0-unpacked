package com.google.android.gms.internal.ads;

import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.net.URL;
import java.net.URLConnection;

public final /* synthetic */ class zzfov implements zzfpd {
    public final /* synthetic */ URL zza;

    public /* synthetic */ zzfov(URL url) {
        this.zza = url;
    }

    public final URLConnection zza() {
        return URLConnectionInstrumentation.openConnection(this.zza.openConnection());
    }
}
