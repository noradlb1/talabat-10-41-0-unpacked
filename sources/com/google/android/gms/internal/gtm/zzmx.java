package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.firebase.perf.metrics.resource.ResourceType;

public final class zzmx implements Result {
    private final Status zzaen;
    private final int zzasj;
    private final zzmy zzasz;
    private final zznu zzata;

    public zzmx(Status status, int i11) {
        this(status, i11, (zzmy) null, (zznu) null);
    }

    public final int getSource() {
        return this.zzasj;
    }

    public final Status getStatus() {
        return this.zzaen;
    }

    public final zzmy zzll() {
        return this.zzasz;
    }

    public final zznu zzlm() {
        return this.zzata;
    }

    public final String zzln() {
        int i11 = this.zzasj;
        if (i11 == 0) {
            return ResourceType.NETWORK;
        }
        if (i11 == 1) {
            return "Saved file on disk";
        }
        if (i11 == 2) {
            return "Default resource";
        }
        throw new IllegalStateException("Resource source is unknown.");
    }

    public zzmx(Status status, int i11, zzmy zzmy, zznu zznu) {
        this.zzaen = status;
        this.zzasj = i11;
        this.zzasz = zzmy;
        this.zzata = zznu;
    }
}
