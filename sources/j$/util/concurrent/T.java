package j$.util.concurrent;

final class T extends ThreadLocal {
    T() {
    }

    /* access modifiers changed from: protected */
    public final Object initialValue() {
        return new ThreadLocalRandom(0);
    }
}
