package bo.app;

import com.braze.support.BrazeLogger;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public final class n0 {

    /* renamed from: o  reason: collision with root package name */
    static final Pattern f39007o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p  reason: collision with root package name */
    private static final String f39008p = BrazeLogger.getBrazeLogTag((Class<?>) n0.class);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final OutputStream f39009q = new b();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final File f39010a;

    /* renamed from: b  reason: collision with root package name */
    private final File f39011b;

    /* renamed from: c  reason: collision with root package name */
    private final File f39012c;

    /* renamed from: d  reason: collision with root package name */
    private final File f39013d;

    /* renamed from: e  reason: collision with root package name */
    private final int f39014e;

    /* renamed from: f  reason: collision with root package name */
    private long f39015f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f39016g;

    /* renamed from: h  reason: collision with root package name */
    private long f39017h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Writer f39018i;

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashMap<String, t0> f39019j = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f39020k;

    /* renamed from: l  reason: collision with root package name */
    private long f39021l = 0;

    /* renamed from: m  reason: collision with root package name */
    final ThreadPoolExecutor f39022m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: n  reason: collision with root package name */
    private final Callable<Void> f39023n = new a();

    public class a implements Callable<Void> {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() {
            /*
                r4 = this;
                bo.app.n0 r0 = bo.app.n0.this
                monitor-enter(r0)
                bo.app.n0 r1 = bo.app.n0.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f39018i     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                bo.app.n0 r1 = bo.app.n0.this     // Catch:{ all -> 0x0028 }
                r1.i()     // Catch:{ all -> 0x0028 }
                bo.app.n0 r1 = bo.app.n0.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.e()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                bo.app.n0 r1 = bo.app.n0.this     // Catch:{ all -> 0x0028 }
                r1.h()     // Catch:{ all -> 0x0028 }
                bo.app.n0 r1 = bo.app.n0.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f39020k = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.n0.a.call():java.lang.Void");
        }
    }

    public class b extends OutputStream {
        public void write(int i11) {
        }
    }

    public final class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final t0 f39025a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f39026b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f39027c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f39028d;

        public class a extends FilterOutputStream {
            public /* synthetic */ a(c cVar, OutputStream outputStream, a aVar) {
                this(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = c.this.f39027c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = c.this.f39027c = true;
                }
            }

            public void write(int i11) {
                try {
                    this.out.write(i11);
                } catch (IOException unused) {
                    boolean unused2 = c.this.f39027c = true;
                }
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(byte[] bArr, int i11, int i12) {
                try {
                    this.out.write(bArr, i11, i12);
                } catch (IOException unused) {
                    boolean unused2 = c.this.f39027c = true;
                }
            }
        }

        public /* synthetic */ c(n0 n0Var, t0 t0Var, a aVar) {
            this(t0Var);
        }

        private c(t0 t0Var) {
            this.f39025a = t0Var;
            this.f39026b = t0Var.f39399c ? null : new boolean[n0.this.f39016g];
        }

        public void b() {
            if (this.f39027c) {
                n0.this.a(this, false);
                n0.this.d(this.f39025a.f39397a);
            } else {
                n0.this.a(this, true);
            }
            this.f39028d = true;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream a(int r5) {
            /*
                r4 = this;
                if (r5 < 0) goto L_0x004b
                bo.app.n0 r0 = bo.app.n0.this
                int r0 = r0.f39016g
                if (r5 >= r0) goto L_0x004b
                bo.app.n0 r0 = bo.app.n0.this
                monitor-enter(r0)
                bo.app.t0 r1 = r4.f39025a     // Catch:{ all -> 0x0048 }
                bo.app.n0$c r2 = r1.f39400d     // Catch:{ all -> 0x0048 }
                if (r2 != r4) goto L_0x0042
                boolean r2 = r1.f39399c     // Catch:{ all -> 0x0048 }
                if (r2 != 0) goto L_0x001c
                boolean[] r2 = r4.f39026b     // Catch:{ all -> 0x0048 }
                r3 = 1
                r2[r5] = r3     // Catch:{ all -> 0x0048 }
            L_0x001c:
                java.io.File r5 = r1.b((int) r5)     // Catch:{ all -> 0x0048 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0026 }
                r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0026 }
                goto L_0x0034
            L_0x0026:
                bo.app.n0 r1 = bo.app.n0.this     // Catch:{ all -> 0x0048 }
                java.io.File r1 = r1.f39010a     // Catch:{ all -> 0x0048 }
                r1.mkdirs()     // Catch:{ all -> 0x0048 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003c }
                r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x003c }
            L_0x0034:
                bo.app.n0$c$a r5 = new bo.app.n0$c$a     // Catch:{ all -> 0x0048 }
                r2 = 0
                r5.<init>(r4, r1, r2)     // Catch:{ all -> 0x0048 }
                monitor-exit(r0)     // Catch:{ all -> 0x0048 }
                return r5
            L_0x003c:
                java.io.OutputStream r5 = bo.app.n0.f39009q     // Catch:{ all -> 0x0048 }
                monitor-exit(r0)     // Catch:{ all -> 0x0048 }
                return r5
            L_0x0042:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0048 }
                r5.<init>()     // Catch:{ all -> 0x0048 }
                throw r5     // Catch:{ all -> 0x0048 }
            L_0x0048:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0048 }
                throw r5
            L_0x004b:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Expected index "
                r1.append(r2)
                r1.append(r5)
                java.lang.String r5 = " to be greater than 0 and less than the maximum value count of "
                r1.append(r5)
                bo.app.n0 r5 = bo.app.n0.this
                int r5 = r5.f39016g
                r1.append(r5)
                java.lang.String r5 = r1.toString()
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.n0.c.a(int):java.io.OutputStream");
        }

        public void a() {
            n0.this.a(this, false);
        }
    }

    public final class d implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f39031b;

        /* renamed from: c  reason: collision with root package name */
        private final long f39032c;

        /* renamed from: d  reason: collision with root package name */
        private final InputStream[] f39033d;

        /* renamed from: e  reason: collision with root package name */
        private final long[] f39034e;

        public /* synthetic */ d(n0 n0Var, String str, long j11, InputStream[] inputStreamArr, long[] jArr, a aVar) {
            this(str, j11, inputStreamArr, jArr);
        }

        public InputStream a(int i11) {
            return this.f39033d[i11];
        }

        public void close() {
            for (InputStream a11 : this.f39033d) {
                v6.a((Closeable) a11);
            }
        }

        private d(String str, long j11, InputStream[] inputStreamArr, long[] jArr) {
            this.f39031b = str;
            this.f39032c = j11;
            this.f39033d = inputStreamArr;
            this.f39034e = jArr;
        }
    }

    private n0(File file, int i11, int i12, long j11) {
        File file2 = file;
        this.f39010a = file2;
        this.f39014e = i11;
        this.f39011b = new File(file2, "journal");
        this.f39012c = new File(file2, "journal.tmp");
        this.f39013d = new File(file2, "journal.bkp");
        this.f39016g = i12;
        this.f39015f = j11;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f39020k = r0 - r9.f39019j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f39018i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f39011b, true), bo.app.v6.f39511a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            bo.app.s5 r1 = new bo.app.s5
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f39011b
            r2.<init>(r3)
            java.nio.charset.Charset r3 = bo.app.v6.f39511a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.c()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.c()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.c()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.c()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.c()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f39014e     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f39016g     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.c()     // Catch:{ EOFException -> 0x005f }
            r9.c((java.lang.String) r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, bo.app.t0> r2 = r9.f39019j     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.f39020k = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.b()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.h()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f39011b     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = bo.app.v6.f39511a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f39018i = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            bo.app.v6.a((java.io.Closeable) r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            bo.app.v6.a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n0.g():void");
    }

    /* access modifiers changed from: private */
    public synchronized void h() {
        Writer writer = this.f39018i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39012c), v6.f39511a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.f39014e));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.f39016g));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(StringUtils.LF);
            for (t0 next : this.f39019j.values()) {
                if (next.f39400d != null) {
                    bufferedWriter.write("DIRTY " + next.f39397a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f39397a + next.a() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f39011b.exists()) {
                a(this.f39011b, this.f39013d, true);
            }
            a(this.f39012c, this.f39011b, false);
            this.f39013d.delete();
            this.f39018i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39011b, true), v6.f39511a));
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        return;
        throw th;
    }

    /* access modifiers changed from: private */
    public void i() {
        while (this.f39017h > this.f39015f) {
            d((String) this.f39019j.entrySet().iterator().next().getKey());
        }
    }

    private void c(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i11 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i11);
            if (indexOf2 == -1) {
                str2 = str.substring(i11);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f39019j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i11, indexOf2);
            }
            t0 t0Var = this.f39019j.get(str2);
            if (t0Var == null) {
                t0Var = new t0(str2, this.f39016g, this.f39010a);
                this.f39019j.put(str2, t0Var);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                t0Var.f39399c = true;
                t0Var.f39400d = null;
                t0Var.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                t0Var.f39400d = new c(this, t0Var, (a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* access modifiers changed from: private */
    public boolean e() {
        int i11 = this.f39020k;
        return i11 >= 2000 && i11 >= this.f39019j.size();
    }

    private void f() {
        a(this.f39012c);
        Iterator<t0> it = this.f39019j.values().iterator();
        while (it.hasNext()) {
            t0 next = it.next();
            int i11 = 0;
            if (next.f39400d == null) {
                while (i11 < this.f39016g) {
                    this.f39017h += next.f39398b[i11];
                    i11++;
                }
            } else {
                next.f39400d = null;
                while (i11 < this.f39016g) {
                    a(next.a(i11));
                    a(next.b(i11));
                    i11++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.f39020k++;
        r11.f39018i.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (e() == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r11.f39022m.submit(r11.f39023n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        return new bo.app.n0.d(r11, r12, r0.f39401e, r8, r0.f39398b, (bo.app.n0.a) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007e, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized bo.app.n0.d b(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.b()     // Catch:{ all -> 0x007f }
            r11.e((java.lang.String) r12)     // Catch:{ all -> 0x007f }
            java.util.LinkedHashMap<java.lang.String, bo.app.t0> r0 = r11.f39019j     // Catch:{ all -> 0x007f }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x007f }
            bo.app.t0 r0 = (bo.app.t0) r0     // Catch:{ all -> 0x007f }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.f39399c     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x001a
            monitor-exit(r11)
            return r1
        L_0x001a:
            int r2 = r11.f39016g     // Catch:{ all -> 0x007f }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x007f }
            r2 = 0
            r3 = r2
        L_0x0020:
            int r4 = r11.f39016g     // Catch:{ FileNotFoundException -> 0x006f }
            if (r3 >= r4) goto L_0x0032
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006f }
            java.io.File r5 = r0.a((int) r3)     // Catch:{ FileNotFoundException -> 0x006f }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x006f }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x006f }
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0032:
            int r1 = r11.f39020k     // Catch:{ all -> 0x007f }
            int r1 = r1 + 1
            r11.f39020k = r1     // Catch:{ all -> 0x007f }
            java.io.Writer r1 = r11.f39018i     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r2.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x007f }
            r2.append(r12)     // Catch:{ all -> 0x007f }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x007f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007f }
            r1.append(r2)     // Catch:{ all -> 0x007f }
            boolean r1 = r11.e()     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0060
            java.util.concurrent.ThreadPoolExecutor r1 = r11.f39022m     // Catch:{ all -> 0x007f }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f39023n     // Catch:{ all -> 0x007f }
            r1.submit(r2)     // Catch:{ all -> 0x007f }
        L_0x0060:
            bo.app.n0$d r1 = new bo.app.n0$d     // Catch:{ all -> 0x007f }
            long r6 = r0.f39401e     // Catch:{ all -> 0x007f }
            long[] r9 = r0.f39398b     // Catch:{ all -> 0x007f }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch:{ all -> 0x007f }
            monitor-exit(r11)
            return r1
        L_0x006f:
            int r12 = r11.f39016g     // Catch:{ all -> 0x007f }
            if (r2 >= r12) goto L_0x007d
            r12 = r8[r2]     // Catch:{ all -> 0x007f }
            if (r12 == 0) goto L_0x007d
            bo.app.v6.a((java.io.Closeable) r12)     // Catch:{ all -> 0x007f }
            int r2 = r2 + 1
            goto L_0x006f
        L_0x007d:
            monitor-exit(r11)
            return r1
        L_0x007f:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n0.b(java.lang.String):bo.app.n0$d");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean d(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.b()     // Catch:{ all -> 0x008a }
            r7.e((java.lang.String) r8)     // Catch:{ all -> 0x008a }
            java.util.LinkedHashMap<java.lang.String, bo.app.t0> r0 = r7.f39019j     // Catch:{ all -> 0x008a }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008a }
            bo.app.t0 r0 = (bo.app.t0) r0     // Catch:{ all -> 0x008a }
            r1 = 0
            if (r0 == 0) goto L_0x0088
            bo.app.n0$c r2 = r0.f39400d     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0017
            goto L_0x0088
        L_0x0017:
            int r2 = r7.f39016g     // Catch:{ all -> 0x008a }
            if (r1 >= r2) goto L_0x0053
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x008a }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r0.<init>()     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008a }
            r0.append(r2)     // Catch:{ all -> 0x008a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008a }
            r8.<init>(r0)     // Catch:{ all -> 0x008a }
            throw r8     // Catch:{ all -> 0x008a }
        L_0x0043:
            long r2 = r7.f39017h     // Catch:{ all -> 0x008a }
            long[] r4 = r0.f39398b     // Catch:{ all -> 0x008a }
            r5 = r4[r1]     // Catch:{ all -> 0x008a }
            long r2 = r2 - r5
            r7.f39017h = r2     // Catch:{ all -> 0x008a }
            r2 = 0
            r4[r1] = r2     // Catch:{ all -> 0x008a }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0053:
            int r0 = r7.f39020k     // Catch:{ all -> 0x008a }
            r1 = 1
            int r0 = r0 + r1
            r7.f39020k = r0     // Catch:{ all -> 0x008a }
            java.io.Writer r0 = r7.f39018i     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r2.<init>()     // Catch:{ all -> 0x008a }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x008a }
            r2.append(r8)     // Catch:{ all -> 0x008a }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008a }
            r0.append(r2)     // Catch:{ all -> 0x008a }
            java.util.LinkedHashMap<java.lang.String, bo.app.t0> r0 = r7.f39019j     // Catch:{ all -> 0x008a }
            r0.remove(r8)     // Catch:{ all -> 0x008a }
            boolean r8 = r7.e()     // Catch:{ all -> 0x008a }
            if (r8 == 0) goto L_0x0086
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f39022m     // Catch:{ all -> 0x008a }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f39023n     // Catch:{ all -> 0x008a }
            r8.submit(r0)     // Catch:{ all -> 0x008a }
        L_0x0086:
            monitor-exit(r7)
            return r1
        L_0x0088:
            monitor-exit(r7)
            return r1
        L_0x008a:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n0.d(java.lang.String):boolean");
    }

    private void e(String str) {
        if (!f39007o.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public static n0 a(File file, int i11, int i12, long j11) {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i12 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            n0 n0Var = new n0(file, i11, i12, j11);
            if (n0Var.f39011b.exists()) {
                try {
                    n0Var.g();
                    n0Var.f();
                    return n0Var;
                } catch (IOException e11) {
                    String str = f39008p;
                    BrazeLogger.w(str, "DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                    n0Var.d();
                }
            }
            file.mkdirs();
            n0 n0Var2 = new n0(file, i11, i12, j11);
            n0Var2.h();
            return n0Var2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void b() {
        if (this.f39018i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public void d() {
        c();
        v6.a(this.f39010a);
    }

    public synchronized void c() {
        if (this.f39018i != null) {
            Iterator it = new ArrayList(this.f39019j.values()).iterator();
            while (it.hasNext()) {
                c cVar = ((t0) it.next()).f39400d;
                if (cVar != null) {
                    cVar.a();
                }
            }
            i();
            this.f39018i.close();
            this.f39018i = null;
        }
    }

    private static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z11) {
        if (z11) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public c a(String str) {
        return a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized bo.app.n0.c a(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.b()     // Catch:{ all -> 0x0060 }
            r5.e((java.lang.String) r6)     // Catch:{ all -> 0x0060 }
            java.util.LinkedHashMap<java.lang.String, bo.app.t0> r0 = r5.f39019j     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0060 }
            bo.app.t0 r0 = (bo.app.t0) r0     // Catch:{ all -> 0x0060 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0020
            if (r0 == 0) goto L_0x001e
            long r3 = r0.f39401e     // Catch:{ all -> 0x0060 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0020
        L_0x001e:
            monitor-exit(r5)
            return r2
        L_0x0020:
            if (r0 != 0) goto L_0x0031
            bo.app.t0 r0 = new bo.app.t0     // Catch:{ all -> 0x0060 }
            int r7 = r5.f39016g     // Catch:{ all -> 0x0060 }
            java.io.File r8 = r5.f39010a     // Catch:{ all -> 0x0060 }
            r0.<init>(r6, r7, r8)     // Catch:{ all -> 0x0060 }
            java.util.LinkedHashMap<java.lang.String, bo.app.t0> r7 = r5.f39019j     // Catch:{ all -> 0x0060 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0060 }
            goto L_0x0037
        L_0x0031:
            bo.app.n0$c r7 = r0.f39400d     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r2
        L_0x0037:
            bo.app.n0$c r7 = new bo.app.n0$c     // Catch:{ all -> 0x0060 }
            r7.<init>(r5, r0, r2)     // Catch:{ all -> 0x0060 }
            r0.f39400d = r7     // Catch:{ all -> 0x0060 }
            java.io.Writer r8 = r5.f39018i     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0060 }
            r0.append(r6)     // Catch:{ all -> 0x0060 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0060 }
            r8.write(r6)     // Catch:{ all -> 0x0060 }
            java.io.Writer r6 = r5.f39018i     // Catch:{ all -> 0x0060 }
            r6.flush()     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return r7
        L_0x0060:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n0.a(java.lang.String, long):bo.app.n0$c");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(bo.app.n0.c r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            bo.app.t0 r0 = r10.f39025a     // Catch:{ all -> 0x00fd }
            bo.app.n0$c r1 = r0.f39400d     // Catch:{ all -> 0x00fd }
            if (r1 != r10) goto L_0x00f7
            r1 = 0
            if (r11 == 0) goto L_0x0049
            boolean r2 = r0.f39399c     // Catch:{ all -> 0x00fd }
            if (r2 != 0) goto L_0x0049
            r2 = r1
        L_0x0011:
            int r3 = r9.f39016g     // Catch:{ all -> 0x00fd }
            if (r2 >= r3) goto L_0x0049
            boolean[] r3 = r10.f39026b     // Catch:{ all -> 0x00fd }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fd }
            if (r3 == 0) goto L_0x002f
            java.io.File r3 = r0.b((int) r2)     // Catch:{ all -> 0x00fd }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x00fd }
            if (r3 != 0) goto L_0x002c
            r10.a()     // Catch:{ all -> 0x00fd }
            monitor-exit(r9)
            return
        L_0x002c:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x002f:
            r10.a()     // Catch:{ all -> 0x00fd }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r11.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fd }
            r11.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fd }
            r10.<init>(r11)     // Catch:{ all -> 0x00fd }
            throw r10     // Catch:{ all -> 0x00fd }
        L_0x0049:
            int r10 = r9.f39016g     // Catch:{ all -> 0x00fd }
            if (r1 >= r10) goto L_0x0079
            java.io.File r10 = r0.b((int) r1)     // Catch:{ all -> 0x00fd }
            if (r11 == 0) goto L_0x0073
            boolean r2 = r10.exists()     // Catch:{ all -> 0x00fd }
            if (r2 == 0) goto L_0x0076
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x00fd }
            r10.renameTo(r2)     // Catch:{ all -> 0x00fd }
            long[] r10 = r0.f39398b     // Catch:{ all -> 0x00fd }
            r3 = r10[r1]     // Catch:{ all -> 0x00fd }
            long r5 = r2.length()     // Catch:{ all -> 0x00fd }
            long[] r10 = r0.f39398b     // Catch:{ all -> 0x00fd }
            r10[r1] = r5     // Catch:{ all -> 0x00fd }
            long r7 = r9.f39017h     // Catch:{ all -> 0x00fd }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f39017h = r7     // Catch:{ all -> 0x00fd }
            goto L_0x0076
        L_0x0073:
            a((java.io.File) r10)     // Catch:{ all -> 0x00fd }
        L_0x0076:
            int r1 = r1 + 1
            goto L_0x0049
        L_0x0079:
            int r10 = r9.f39020k     // Catch:{ all -> 0x00fd }
            r1 = 1
            int r10 = r10 + r1
            r9.f39020k = r10     // Catch:{ all -> 0x00fd }
            r10 = 0
            r0.f39400d = r10     // Catch:{ all -> 0x00fd }
            boolean r10 = r0.f39399c     // Catch:{ all -> 0x00fd }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00b9
            r0.f39399c = r1     // Catch:{ all -> 0x00fd }
            java.io.Writer r10 = r9.f39018i     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r3 = "CLEAN "
            r1.append(r3)     // Catch:{ all -> 0x00fd }
            java.lang.String r3 = r0.f39397a     // Catch:{ all -> 0x00fd }
            r1.append(r3)     // Catch:{ all -> 0x00fd }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x00fd }
            r1.append(r3)     // Catch:{ all -> 0x00fd }
            r1.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fd }
            r10.write(r1)     // Catch:{ all -> 0x00fd }
            if (r11 == 0) goto L_0x00db
            long r10 = r9.f39021l     // Catch:{ all -> 0x00fd }
            r1 = 1
            long r1 = r1 + r10
            r9.f39021l = r1     // Catch:{ all -> 0x00fd }
            r0.f39401e = r10     // Catch:{ all -> 0x00fd }
            goto L_0x00db
        L_0x00b9:
            java.util.LinkedHashMap<java.lang.String, bo.app.t0> r10 = r9.f39019j     // Catch:{ all -> 0x00fd }
            java.lang.String r11 = r0.f39397a     // Catch:{ all -> 0x00fd }
            r10.remove(r11)     // Catch:{ all -> 0x00fd }
            java.io.Writer r10 = r9.f39018i     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r11.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = "REMOVE "
            r11.append(r1)     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = r0.f39397a     // Catch:{ all -> 0x00fd }
            r11.append(r0)     // Catch:{ all -> 0x00fd }
            r11.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fd }
            r10.write(r11)     // Catch:{ all -> 0x00fd }
        L_0x00db:
            java.io.Writer r10 = r9.f39018i     // Catch:{ all -> 0x00fd }
            r10.flush()     // Catch:{ all -> 0x00fd }
            long r10 = r9.f39017h     // Catch:{ all -> 0x00fd }
            long r0 = r9.f39015f     // Catch:{ all -> 0x00fd }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00ee
            boolean r10 = r9.e()     // Catch:{ all -> 0x00fd }
            if (r10 == 0) goto L_0x00f5
        L_0x00ee:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f39022m     // Catch:{ all -> 0x00fd }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f39023n     // Catch:{ all -> 0x00fd }
            r10.submit(r11)     // Catch:{ all -> 0x00fd }
        L_0x00f5:
            monitor-exit(r9)
            return
        L_0x00f7:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fd }
            r10.<init>()     // Catch:{ all -> 0x00fd }
            throw r10     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n0.a(bo.app.n0$c, boolean):void");
    }
}
