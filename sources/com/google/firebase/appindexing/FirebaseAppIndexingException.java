package com.google.firebase.appindexing;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseAppIndexingException extends FirebaseException {
    public FirebaseAppIndexingException(@NonNull String str) {
        super(str);
    }

    public FirebaseAppIndexingException(@NonNull String str, @NonNull Throwable th2) {
        super(str, th2);
    }
}
