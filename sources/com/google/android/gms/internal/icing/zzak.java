package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

public final class zzak extends zzad<Status> {
    public zzak(BaseImplementation.ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    public final void zzb(Status status) {
        this.zza.setResult(status);
    }
}
