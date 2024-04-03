package j$.util.stream;

final class Q3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29022a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f29023b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f29024c;

    public /* synthetic */ Q3(int i11, Object obj, Object obj2) {
        this.f29022a = i11;
        this.f29023b = obj;
        this.f29024c = obj2;
    }

    public final void run() {
        int i11 = this.f29022a;
        Object obj = this.f29023b;
        Object obj2 = this.f29024c;
        switch (i11) {
            case 0:
                try {
                    ((Runnable) obj).run();
                    ((Runnable) obj2).run();
                    return;
                } catch (Throwable th2) {
                    try {
                        th.addSuppressed(th2);
                        break;
                    } catch (Throwable unused) {
                        break;
                    }
                }
            default:
                try {
                    ((BaseStream) obj).close();
                    ((BaseStream) obj2).close();
                    return;
                } catch (Throwable th3) {
                    try {
                        th.addSuppressed(th3);
                        break;
                    } catch (Throwable unused2) {
                        break;
                    }
                }
        }
        throw th;
        throw th;
    }
}
