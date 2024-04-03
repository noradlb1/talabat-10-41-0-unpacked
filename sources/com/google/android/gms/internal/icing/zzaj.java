package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract class zzaj<T extends Result> extends zzai<Status> {
    public zzaj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
