package com.uxcam.internals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class gu {

    /* renamed from: a  reason: collision with root package name */
    public static final List f13502a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static volatile ab[] f13503b = new ab[0];

    /* renamed from: c  reason: collision with root package name */
    public static final ab f13504c = new aa();

    public class aa extends ab {
        public void a(int i11, String str, String str2, Throwable th2) {
            throw new AssertionError("Missing override for log method.");
        }

        public void b(String str, Object... objArr) {
            for (ab b11 : gu.f13503b) {
                b11.b(str, objArr);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        f13504c.getClass();
    }

    public static abstract class ab {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadLocal f13505a = new ThreadLocal();

        public String a() {
            String str = (String) this.f13505a.get();
            if (str != null) {
                this.f13505a.remove();
            }
            return str;
        }

        public abstract void a(int i11, String str, String str2, Throwable th2);

        public void b(String str, Object... objArr) {
            a(4, (Throwable) null, str, objArr);
        }

        public final void a(int i11, Throwable th2, String str, Object... objArr) {
            String a11 = a();
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr.length > 0) {
                    str = a(str, objArr);
                }
                if (th2 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(StringUtils.LF);
                    StringWriter stringWriter = new StringWriter(256);
                    PrintWriter printWriter = new PrintWriter(stringWriter, false);
                    th2.printStackTrace(printWriter);
                    printWriter.flush();
                    sb2.append(stringWriter.toString());
                    str = sb2.toString();
                }
            } else if (th2 != null) {
                StringWriter stringWriter2 = new StringWriter(256);
                PrintWriter printWriter2 = new PrintWriter(stringWriter2, false);
                th2.printStackTrace(printWriter2);
                printWriter2.flush();
                str = stringWriter2.toString();
            } else {
                return;
            }
            a(i11, a11, str, th2);
        }

        public String a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }
    }

    public static ab a(String str) {
        for (ab abVar : f13503b) {
            abVar.f13505a.set(str);
        }
        return f13504c;
    }
}
