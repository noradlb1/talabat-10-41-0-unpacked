package com.google.android.exoplayer2.util;

import java.util.Arrays;

public abstract class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        this.nativeLibraries = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (String loadLibrary : this.nativeLibraries) {
                loadLibrary(loadLibrary);
            }
            this.isAvailable = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.w(TAG, "Failed to load " + Arrays.toString(this.nativeLibraries));
        }
        return this.isAvailable;
    }

    public abstract void loadLibrary(String str);

    public synchronized void setLibraries(String... strArr) {
        boolean z11;
        if (!this.loadAttempted) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }
}
