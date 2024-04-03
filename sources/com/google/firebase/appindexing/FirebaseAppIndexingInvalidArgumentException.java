package com.google.firebase.appindexing;

import androidx.annotation.NonNull;

public class FirebaseAppIndexingInvalidArgumentException extends FirebaseAppIndexingException {
    public FirebaseAppIndexingInvalidArgumentException(@NonNull String str) {
        super(str);
    }

    public FirebaseAppIndexingInvalidArgumentException(@NonNull String str, @NonNull Throwable th2) {
        super(str, th2);
    }
}
