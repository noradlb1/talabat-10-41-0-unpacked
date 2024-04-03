package com.google.firebase.database;

import androidx.annotation.RestrictTo;

public class DatabaseException extends RuntimeException {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DatabaseException(String str) {
        super(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DatabaseException(String str, Throwable th2) {
        super(str, th2);
    }
}
