package net.bytebuddy.jar.asm;

final class Handler {

    /* renamed from: a  reason: collision with root package name */
    public final Label f27382a;

    /* renamed from: b  reason: collision with root package name */
    public final Label f27383b;

    /* renamed from: c  reason: collision with root package name */
    public final Label f27384c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27385d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27386e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f27387f;

    public Handler(Label label, Label label2, Label label3, int i11, String str) {
        this.f27382a = label;
        this.f27383b = label2;
        this.f27384c = label3;
        this.f27385d = i11;
        this.f27386e = str;
    }

    public static int a(Handler handler) {
        int i11 = 0;
        while (handler != null) {
            i11++;
            handler = handler.f27387f;
        }
        return i11;
    }

    public static int b(Handler handler) {
        return (a(handler) * 8) + 2;
    }

    public static void c(Handler handler, ByteVector byteVector) {
        byteVector.putShort(a(handler));
        while (handler != null) {
            byteVector.putShort(handler.f27382a.f27390b).putShort(handler.f27383b.f27390b).putShort(handler.f27384c.f27390b).putShort(handler.f27385d);
            handler = handler.f27387f;
        }
    }

    public static Handler d(Handler handler, Label label, Label label2) {
        int i11;
        if (handler == null) {
            return null;
        }
        Handler d11 = d(handler.f27387f, label, label2);
        handler.f27387f = d11;
        Label label3 = handler.f27382a;
        int i12 = label3.f27390b;
        Label label4 = handler.f27383b;
        int i13 = label4.f27390b;
        int i14 = label.f27390b;
        if (label2 == null) {
            i11 = Integer.MAX_VALUE;
        } else {
            i11 = label2.f27390b;
        }
        if (i14 >= i13 || i11 <= i12) {
            return handler;
        }
        if (i14 <= i12) {
            if (i11 >= i13) {
                return d11;
            }
            return new Handler(handler, label2, label4);
        } else if (i11 >= i13) {
            return new Handler(handler, label3, label);
        } else {
            handler.f27387f = new Handler(handler, label2, label4);
            return new Handler(handler, handler.f27382a, label);
        }
    }

    public Handler(Handler handler, Label label, Label label2) {
        this(label, label2, handler.f27384c, handler.f27385d, handler.f27386e);
        this.f27387f = handler.f27387f;
    }
}
