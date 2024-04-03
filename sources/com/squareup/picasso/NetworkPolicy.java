package com.squareup.picasso;

public enum NetworkPolicy {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f53427b;

    private NetworkPolicy(int i11) {
        this.f53427b = i11;
    }

    public static boolean isOfflineOnly(int i11) {
        return (i11 & OFFLINE.f53427b) != 0;
    }

    public static boolean shouldReadFromDiskCache(int i11) {
        return (i11 & NO_CACHE.f53427b) == 0;
    }

    public static boolean shouldWriteToDiskCache(int i11) {
        return (i11 & NO_STORE.f53427b) == 0;
    }
}
