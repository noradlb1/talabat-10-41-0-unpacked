package com.google.firebase.appindexing.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.FirebaseAppIndexingException;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException;
import com.google.firebase.appindexing.zza;
import com.google.firebase.appindexing.zzb;

public final class zzaf {
    public static FirebaseAppIndexingException zza(@NonNull Status status, String str) {
        Preconditions.checkNotNull(status);
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null && !statusMessage.isEmpty()) {
            str = statusMessage;
        }
        switch (status.getStatusCode()) {
            case 17510:
                return new FirebaseAppIndexingInvalidArgumentException(str);
            case 17511:
                return new FirebaseAppIndexingTooManyArgumentsException(str);
            case 17513:
                return new zzb(str);
            case 17514:
                return new zza(str);
            default:
                return new FirebaseAppIndexingException(str);
        }
    }
}
