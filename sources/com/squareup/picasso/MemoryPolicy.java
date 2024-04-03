package com.squareup.picasso;

public enum MemoryPolicy {
    NO_CACHE(1),
    NO_STORE(2);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f53426b;

    private MemoryPolicy(int i11) {
        this.f53426b = i11;
    }

    public static boolean a(int i11) {
        return (i11 & NO_CACHE.f53426b) == 0;
    }

    public static boolean b(int i11) {
        return (i11 & NO_STORE.f53426b) == 0;
    }
}
