package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    public Response(@NonNull T t11) {
        this.zza = t11;
    }

    @NonNull
    public T getResult() {
        return this.zza;
    }

    public void setResult(@NonNull T t11) {
        this.zza = t11;
    }
}
