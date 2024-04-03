package com.apptimize;

import android.content.Context;
import java.io.File;
import java.util.UUID;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43155a = "t";

    /* renamed from: b  reason: collision with root package name */
    private static b f43156b;

    /* renamed from: c  reason: collision with root package name */
    private static b f43157c;

    public interface a {
        boolean a();

        boolean b();
    }

    public enum b {
        UNINITIALIZED(-1, 1.0d),
        NO_VARIANT(0, 1.0d),
        BASELINE(3, 0.01d),
        ENABLED_DEVICE(4, 0.25d),
        DISABLED_DEVICE(5, 0.0d),
        VARIANT6(6, 0.5d),
        LIBRARY_DISABLED(7, 1.0d);
        

        /* renamed from: h  reason: collision with root package name */
        public static final b f43165h = null;

        /* renamed from: i  reason: collision with root package name */
        private int f43167i;

        /* renamed from: j  reason: collision with root package name */
        private double f43168j;

        /* access modifiers changed from: public */
        static {
            b bVar;
            f43165h = bVar;
        }

        private b(int i11, double d11) {
            this.f43167i = i11;
            this.f43168j = d11;
        }

        public int a() {
            return this.f43167i;
        }

        public double b() {
            return this.f43168j;
        }
    }

    static {
        b bVar = b.UNINITIALIZED;
        f43156b = bVar;
        f43157c = bVar;
    }

    public static void a(Context context, b bVar, String str, a aVar) {
        b bVar2;
        f43156b = bVar;
        a(context);
        try {
            UUID fromString = UUID.fromString(str);
            if (!aVar.b()) {
                b bVar3 = f43157c;
                b bVar4 = b.UNINITIALIZED;
                if (bVar3 != bVar4) {
                    f43156b = f43157c;
                } else if (bVar != bVar4) {
                    f43156b = bVar;
                } else if (aVar.a()) {
                    b bVar5 = b.ENABLED_DEVICE;
                    if (a(fromString, bVar5)) {
                        bVar2 = bVar5;
                    } else {
                        bVar2 = b.DISABLED_DEVICE;
                    }
                    f43156b = bVar2;
                    if (bVar2 == bVar5) {
                        b bVar6 = b.f43165h;
                        if (a(fromString, bVar6)) {
                            f43156b = bVar6;
                        }
                    }
                } else {
                    b bVar7 = b.BASELINE;
                    if (a(fromString, bVar7)) {
                        f43156b = bVar7;
                    } else {
                        b bVar8 = b.f43165h;
                        if (a(fromString, bVar8)) {
                            f43156b = bVar8;
                        }
                    }
                }
            } else if (f43157c != b.UNINITIALIZED) {
                f43156b = f43157c;
            } else if (aVar.a()) {
                f43156b = b.ENABLED_DEVICE;
            } else {
                f43156b = bVar;
            }
            if (f43156b == b.UNINITIALIZED) {
                f43156b = b.NO_VARIANT;
            }
            String str2 = f43155a;
            bo.k(str2, "using variant: " + f43156b.a());
        } catch (Exception unused) {
        }
    }

    public static int b() {
        return f43156b.a();
    }

    public static boolean c() {
        return f43156b == b.ENABLED_DEVICE || f43156b == b.f43165h;
    }

    public static boolean d() {
        return f43156b == b.BASELINE;
    }

    public static boolean e() {
        return f43156b == b.f43165h;
    }

    public static void a() {
        if (f43156b == b.NO_VARIANT || f43156b == b.ENABLED_DEVICE || f43156b == b.VARIANT6) {
            f43156b = b.LIBRARY_DISABLED;
        }
    }

    private static boolean a(UUID uuid, b bVar) {
        if (f43157c != bVar && ((double) (uuid.getLeastSignificantBits() & 268435455)) / 2.68435455E8d >= bVar.b()) {
            return false;
        }
        return true;
    }

    private static void a(Context context) {
        b bVar = av.f41244g;
        b bVar2 = b.UNINITIALIZED;
        if (bVar != bVar2) {
            f43157c = av.f41244g;
            String str = f43155a;
            bo.k(str, "LocalOverride forcedVariant: " + f43157c.a());
            return;
        }
        f43157c = bVar2;
        long a11 = (long) bVar2.a();
        String b11 = fx.b(new File("/sdcard", "forced_variant"));
        if (b11 != null) {
            try {
                a11 = Long.parseLong(b11);
            } catch (Exception e11) {
                String str2 = f43155a;
                bo.h(str2, "error getting forced apptimize_variant case " + b11, e11);
            }
        }
        b[] values = b.values();
        int length = values.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            b bVar3 = values[i11];
            if (((long) bVar3.a()) == a11) {
                f43157c = bVar3;
                break;
            }
            i11++;
        }
        if (b11 != null) {
            String str3 = f43155a;
            bo.k(str3, "forced apptimize_variant: " + f43157c.a());
        }
    }
}
