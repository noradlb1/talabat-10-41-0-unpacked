package com.google.firebase.appindexing;

import androidx.annotation.NonNull;

public class FirebaseAppIndexingTooManyArgumentsException extends FirebaseAppIndexingException {
    public FirebaseAppIndexingTooManyArgumentsException() {
        super("Too many Indexables provided. Try splitting them in batches.");
    }

    public FirebaseAppIndexingTooManyArgumentsException(@NonNull String str) {
        super(str);
    }

    public FirebaseAppIndexingTooManyArgumentsException(@NonNull String str, @NonNull Throwable th2) {
        super(str, th2);
    }
}
