package j$.util.concurrent;

import j$.sun.misc.b;
import java.util.concurrent.locks.LockSupport;

final class O extends E {

    /* renamed from: h  reason: collision with root package name */
    private static final b f28662h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f28663i;

    /* renamed from: e  reason: collision with root package name */
    P f28664e;

    /* renamed from: f  reason: collision with root package name */
    volatile P f28665f;

    /* renamed from: g  reason: collision with root package name */
    volatile Thread f28666g;
    volatile int lockState;

    static {
        b h11 = b.h();
        f28662h = h11;
        f28663i = h11.j(O.class, "lockState");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r6 = j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r8 = j$.util.concurrent.ConcurrentHashMap.compareComparables(r6, r3, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    O(j$.util.concurrent.P r10) {
        /*
            r9 = this;
            r0 = -2
            r1 = 0
            r9.<init>(r0, r1, r1)
            r9.f28665f = r10
            r0 = r1
        L_0x0008:
            if (r10 == 0) goto L_0x005c
            j$.util.concurrent.E r2 = r10.f28634d
            j$.util.concurrent.P r2 = (j$.util.concurrent.P) r2
            r10.f28669g = r1
            r10.f28668f = r1
            if (r0 != 0) goto L_0x001b
            r10.f28667e = r1
            r0 = 0
            r10.f28671i = r0
        L_0x0019:
            r0 = r10
            goto L_0x0058
        L_0x001b:
            java.lang.Object r3 = r10.f28632b
            int r4 = r10.f28631a
            r5 = r0
            r6 = r1
        L_0x0021:
            java.lang.Object r7 = r5.f28632b
            int r8 = r5.f28631a
            if (r8 <= r4) goto L_0x0029
            r7 = -1
            goto L_0x0041
        L_0x0029:
            if (r8 >= r4) goto L_0x002d
            r7 = 1
            goto L_0x0041
        L_0x002d:
            if (r6 != 0) goto L_0x0035
            java.lang.Class r6 = j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r3)
            if (r6 == 0) goto L_0x003b
        L_0x0035:
            int r8 = j$.util.concurrent.ConcurrentHashMap.compareComparables(r6, r3, r7)
            if (r8 != 0) goto L_0x0040
        L_0x003b:
            int r7 = i(r3, r7)
            goto L_0x0041
        L_0x0040:
            r7 = r8
        L_0x0041:
            if (r7 > 0) goto L_0x0046
            j$.util.concurrent.P r8 = r5.f28668f
            goto L_0x0048
        L_0x0046:
            j$.util.concurrent.P r8 = r5.f28669g
        L_0x0048:
            if (r8 != 0) goto L_0x005a
            r10.f28667e = r5
            if (r7 > 0) goto L_0x0051
            r5.f28668f = r10
            goto L_0x0053
        L_0x0051:
            r5.f28669g = r10
        L_0x0053:
            j$.util.concurrent.P r10 = c(r0, r10)
            goto L_0x0019
        L_0x0058:
            r10 = r2
            goto L_0x0008
        L_0x005a:
            r5 = r8
            goto L_0x0021
        L_0x005c:
            r9.f28664e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.O.<init>(j$.util.concurrent.P):void");
    }

    static P b(P p11, P p12) {
        P p13;
        while (p12 != null && p12 != p11) {
            P p14 = p12.f28667e;
            if (p14 == null) {
                p12.f28671i = false;
                return p12;
            } else if (p12.f28671i) {
                p12.f28671i = false;
                return p11;
            } else {
                P p15 = p14.f28668f;
                P p16 = null;
                if (p15 == p12) {
                    p13 = p14.f28669g;
                    if (p13 != null && p13.f28671i) {
                        p13.f28671i = false;
                        p14.f28671i = true;
                        p11 = g(p11, p14);
                        p14 = p12.f28667e;
                        p13 = p14 == null ? null : p14.f28669g;
                    }
                    if (p13 != null) {
                        P p17 = p13.f28668f;
                        P p18 = p13.f28669g;
                        if ((p18 != null && p18.f28671i) || (p17 != null && p17.f28671i)) {
                            if (p18 == null || !p18.f28671i) {
                                if (p17 != null) {
                                    p17.f28671i = false;
                                }
                                p13.f28671i = true;
                                p11 = h(p11, p13);
                                p14 = p12.f28667e;
                                if (p14 != null) {
                                    p16 = p14.f28669g;
                                }
                                p13 = p16;
                            }
                            if (p13 != null) {
                                p13.f28671i = p14 == null ? false : p14.f28671i;
                                P p19 = p13.f28669g;
                                if (p19 != null) {
                                    p19.f28671i = false;
                                }
                            }
                            if (p14 != null) {
                                p14.f28671i = false;
                                p11 = g(p11, p14);
                            }
                            p12 = p11;
                            p11 = p12;
                        }
                        p13.f28671i = true;
                    }
                } else {
                    if (p15 != null && p15.f28671i) {
                        p15.f28671i = false;
                        p14.f28671i = true;
                        p11 = h(p11, p14);
                        p14 = p12.f28667e;
                        p15 = p14 == null ? null : p14.f28668f;
                    }
                    if (p13 != null) {
                        P p21 = p13.f28668f;
                        P p22 = p13.f28669g;
                        if ((p21 != null && p21.f28671i) || (p22 != null && p22.f28671i)) {
                            if (p21 == null || !p21.f28671i) {
                                if (p22 != null) {
                                    p22.f28671i = false;
                                }
                                p13.f28671i = true;
                                p11 = g(p11, p13);
                                p14 = p12.f28667e;
                                if (p14 != null) {
                                    p16 = p14.f28668f;
                                }
                                p13 = p16;
                            }
                            if (p13 != null) {
                                p13.f28671i = p14 == null ? false : p14.f28671i;
                                P p23 = p13.f28668f;
                                if (p23 != null) {
                                    p23.f28671i = false;
                                }
                            }
                            if (p14 != null) {
                                p14.f28671i = false;
                                p11 = h(p11, p14);
                            }
                            p12 = p11;
                            p11 = p12;
                        }
                        p13.f28671i = true;
                    }
                }
                p12 = p14;
            }
        }
        return p11;
    }

    static P c(P p11, P p12) {
        P p13;
        p12.f28671i = true;
        while (true) {
            P p14 = p12.f28667e;
            if (p14 == null) {
                p12.f28671i = false;
                return p12;
            } else if (!p14.f28671i || (p13 = p14.f28667e) == null) {
                return p11;
            } else {
                P p15 = p13.f28668f;
                if (p14 == p15) {
                    p15 = p13.f28669g;
                    if (p15 == null || !p15.f28671i) {
                        if (p12 == p14.f28669g) {
                            p11 = g(p11, p14);
                            P p16 = p14.f28667e;
                            p13 = p16 == null ? null : p16.f28667e;
                            P p17 = p14;
                            p14 = p16;
                            p12 = p17;
                        }
                        if (p14 != null) {
                            p14.f28671i = false;
                            if (p13 != null) {
                                p13.f28671i = true;
                                p11 = h(p11, p13);
                            }
                        }
                    }
                } else if (p15 == null || !p15.f28671i) {
                    if (p12 == p14.f28668f) {
                        p11 = h(p11, p14);
                        P p18 = p14.f28667e;
                        p13 = p18 == null ? null : p18.f28667e;
                        P p19 = p14;
                        p14 = p18;
                        p12 = p19;
                    }
                    if (p14 != null) {
                        p14.f28671i = false;
                        if (p13 != null) {
                            p13.f28671i = true;
                            p11 = g(p11, p13);
                        }
                    }
                }
                p15.f28671i = false;
                p14.f28671i = false;
                p13.f28671i = true;
                p12 = p13;
            }
        }
        return p11;
    }

    private final void d() {
        if (!f28662h.c(this, f28663i, 0, 1)) {
            boolean z11 = false;
            while (true) {
                int i11 = this.lockState;
                if ((i11 & -3) == 0) {
                    if (f28662h.c(this, f28663i, i11, 1)) {
                        break;
                    }
                } else if ((i11 & 2) == 0) {
                    if (f28662h.c(this, f28663i, i11, i11 | 2)) {
                        this.f28666g = Thread.currentThread();
                        z11 = true;
                    }
                } else if (z11) {
                    LockSupport.park(this);
                }
            }
            if (z11) {
                this.f28666g = null;
            }
        }
    }

    static P g(P p11, P p12) {
        P p13 = p12.f28669g;
        if (p13 != null) {
            P p14 = p13.f28668f;
            p12.f28669g = p14;
            if (p14 != null) {
                p14.f28667e = p12;
            }
            P p15 = p12.f28667e;
            p13.f28667e = p15;
            if (p15 == null) {
                p13.f28671i = false;
                p11 = p13;
            } else if (p15.f28668f == p12) {
                p15.f28668f = p13;
            } else {
                p15.f28669g = p13;
            }
            p13.f28668f = p12;
            p12.f28667e = p13;
        }
        return p11;
    }

    static P h(P p11, P p12) {
        P p13 = p12.f28668f;
        if (p13 != null) {
            P p14 = p13.f28669g;
            p12.f28668f = p14;
            if (p14 != null) {
                p14.f28667e = p12;
            }
            P p15 = p12.f28667e;
            p13.f28667e = p15;
            if (p15 == null) {
                p13.f28671i = false;
                p11 = p13;
            } else if (p15.f28669g == p12) {
                p15.f28669g = p13;
            } else {
                p15.f28668f = p13;
            }
            p13.f28669g = p12;
            p12.f28667e = p13;
        }
        return p11;
    }

    static int i(Object obj, Object obj2) {
        int compareTo;
        if (obj != null && obj2 != null && (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) != 0) {
            return compareTo;
        }
        return System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1;
    }

    /* access modifiers changed from: package-private */
    public final E a(int i11, Object obj) {
        Thread thread;
        Thread thread2;
        Object obj2;
        P p11 = null;
        if (obj != null) {
            E e11 = this.f28665f;
            while (e11 != null) {
                int i12 = this.lockState;
                if ((i12 & 3) == 0) {
                    b bVar = f28662h;
                    long j11 = f28663i;
                    if (bVar.c(this, j11, i12, i12 + 4)) {
                        try {
                            P p12 = this.f28664e;
                            if (p12 != null) {
                                p11 = p12.b(i11, obj, (Class) null);
                            }
                            if (bVar.f(this, j11) == 6 && (thread2 = this.f28666g) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return p11;
                        } catch (Throwable th2) {
                            if (f28662h.f(this, f28663i) == 6 && (thread = this.f28666g) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th2;
                        }
                    }
                } else if (e11.f28631a == i11 && ((obj2 = e11.f28632b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return e11;
                } else {
                    e11 = e11.f28634d;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a2, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a7 A[LOOP:0: B:1:0x000c->B:53:0x00a7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0071 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.util.concurrent.P e(int r16, java.lang.Object r17, java.lang.Object r18) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r4 = r17
            j$.util.concurrent.P r2 = r1.f28664e
            r8 = 0
            r9 = 0
            r10 = r2
            r2 = r8
            r3 = r9
        L_0x000c:
            if (r10 != 0) goto L_0x0022
            j$.util.concurrent.P r9 = new j$.util.concurrent.P
            r6 = 0
            r7 = 0
            r2 = r9
            r3 = r16
            r4 = r17
            r5 = r18
            r2.<init>(r3, r4, r5, r6, r7)
            r1.f28664e = r9
            r1.f28665f = r9
            goto L_0x00a2
        L_0x0022:
            int r5 = r10.f28631a
            r11 = 1
            if (r5 <= r0) goto L_0x0029
            r5 = -1
            goto L_0x0065
        L_0x0029:
            if (r5 >= r0) goto L_0x002d
            r12 = r11
            goto L_0x0068
        L_0x002d:
            java.lang.Object r5 = r10.f28632b
            if (r5 == r4) goto L_0x00aa
            if (r5 == 0) goto L_0x003b
            boolean r6 = r4.equals(r5)
            if (r6 == 0) goto L_0x003b
            goto L_0x00aa
        L_0x003b:
            if (r2 != 0) goto L_0x0043
            java.lang.Class r2 = j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r17)
            if (r2 == 0) goto L_0x0049
        L_0x0043:
            int r6 = j$.util.concurrent.ConcurrentHashMap.compareComparables(r2, r4, r5)
            if (r6 != 0) goto L_0x0067
        L_0x0049:
            if (r3 != 0) goto L_0x0061
            j$.util.concurrent.P r3 = r10.f28668f
            if (r3 == 0) goto L_0x0055
            j$.util.concurrent.P r3 = r3.b(r0, r4, r2)
            if (r3 != 0) goto L_0x005f
        L_0x0055:
            j$.util.concurrent.P r3 = r10.f28669g
            if (r3 == 0) goto L_0x0060
            j$.util.concurrent.P r3 = r3.b(r0, r4, r2)
            if (r3 == 0) goto L_0x0060
        L_0x005f:
            return r3
        L_0x0060:
            r3 = r11
        L_0x0061:
            int r5 = i(r4, r5)
        L_0x0065:
            r12 = r5
            goto L_0x0068
        L_0x0067:
            r12 = r6
        L_0x0068:
            if (r12 > 0) goto L_0x006d
            j$.util.concurrent.P r5 = r10.f28668f
            goto L_0x006f
        L_0x006d:
            j$.util.concurrent.P r5 = r10.f28669g
        L_0x006f:
            if (r5 != 0) goto L_0x00a7
            j$.util.concurrent.P r13 = r1.f28665f
            j$.util.concurrent.P r14 = new j$.util.concurrent.P
            r2 = r14
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r13
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            r1.f28665f = r14
            if (r13 == 0) goto L_0x0087
            r13.f28670h = r14
        L_0x0087:
            if (r12 > 0) goto L_0x008c
            r10.f28668f = r14
            goto L_0x008e
        L_0x008c:
            r10.f28669g = r14
        L_0x008e:
            boolean r0 = r10.f28671i
            if (r0 != 0) goto L_0x0095
            r14.f28671i = r11
            goto L_0x00a2
        L_0x0095:
            r15.d()
            j$.util.concurrent.P r0 = r1.f28664e     // Catch:{ all -> 0x00a3 }
            j$.util.concurrent.P r0 = c(r0, r14)     // Catch:{ all -> 0x00a3 }
            r1.f28664e = r0     // Catch:{ all -> 0x00a3 }
            r1.lockState = r9
        L_0x00a2:
            return r8
        L_0x00a3:
            r0 = move-exception
            r1.lockState = r9
            throw r0
        L_0x00a7:
            r10 = r5
            goto L_0x000c
        L_0x00aa:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.O.e(int, java.lang.Object, java.lang.Object):j$.util.concurrent.P");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x008e A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a9 A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00aa A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ba A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bd A[Catch:{ all -> 0x00c8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(j$.util.concurrent.P r11) {
        /*
            r10 = this;
            j$.util.concurrent.E r0 = r11.f28634d
            j$.util.concurrent.P r0 = (j$.util.concurrent.P) r0
            j$.util.concurrent.P r1 = r11.f28670h
            if (r1 != 0) goto L_0x000b
            r10.f28665f = r0
            goto L_0x000d
        L_0x000b:
            r1.f28634d = r0
        L_0x000d:
            if (r0 == 0) goto L_0x0011
            r0.f28670h = r1
        L_0x0011:
            j$.util.concurrent.P r0 = r10.f28665f
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001a
            r10.f28664e = r2
            return r1
        L_0x001a:
            j$.util.concurrent.P r0 = r10.f28664e
            if (r0 == 0) goto L_0x00cc
            j$.util.concurrent.P r3 = r0.f28669g
            if (r3 == 0) goto L_0x00cc
            j$.util.concurrent.P r3 = r0.f28668f
            if (r3 == 0) goto L_0x00cc
            j$.util.concurrent.P r3 = r3.f28668f
            if (r3 != 0) goto L_0x002c
            goto L_0x00cc
        L_0x002c:
            r10.d()
            r1 = 0
            j$.util.concurrent.P r3 = r11.f28668f     // Catch:{ all -> 0x00c8 }
            j$.util.concurrent.P r4 = r11.f28669g     // Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x0084
            if (r4 == 0) goto L_0x0084
            r5 = r4
        L_0x0039:
            j$.util.concurrent.P r6 = r5.f28668f     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x003f
            r5 = r6
            goto L_0x0039
        L_0x003f:
            boolean r6 = r5.f28671i     // Catch:{ all -> 0x00c8 }
            boolean r7 = r11.f28671i     // Catch:{ all -> 0x00c8 }
            r5.f28671i = r7     // Catch:{ all -> 0x00c8 }
            r11.f28671i = r6     // Catch:{ all -> 0x00c8 }
            j$.util.concurrent.P r6 = r5.f28669g     // Catch:{ all -> 0x00c8 }
            j$.util.concurrent.P r7 = r11.f28667e     // Catch:{ all -> 0x00c8 }
            if (r5 != r4) goto L_0x0052
            r11.f28667e = r5     // Catch:{ all -> 0x00c8 }
            r5.f28669g = r11     // Catch:{ all -> 0x00c8 }
            goto L_0x0065
        L_0x0052:
            j$.util.concurrent.P r8 = r5.f28667e     // Catch:{ all -> 0x00c8 }
            r11.f28667e = r8     // Catch:{ all -> 0x00c8 }
            if (r8 == 0) goto L_0x0061
            j$.util.concurrent.P r9 = r8.f28668f     // Catch:{ all -> 0x00c8 }
            if (r5 != r9) goto L_0x005f
            r8.f28668f = r11     // Catch:{ all -> 0x00c8 }
            goto L_0x0061
        L_0x005f:
            r8.f28669g = r11     // Catch:{ all -> 0x00c8 }
        L_0x0061:
            r5.f28669g = r4     // Catch:{ all -> 0x00c8 }
            r4.f28667e = r5     // Catch:{ all -> 0x00c8 }
        L_0x0065:
            r11.f28668f = r2     // Catch:{ all -> 0x00c8 }
            r11.f28669g = r6     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x006d
            r6.f28667e = r11     // Catch:{ all -> 0x00c8 }
        L_0x006d:
            r5.f28668f = r3     // Catch:{ all -> 0x00c8 }
            r3.f28667e = r5     // Catch:{ all -> 0x00c8 }
            r5.f28667e = r7     // Catch:{ all -> 0x00c8 }
            if (r7 != 0) goto L_0x0077
            r0 = r5
            goto L_0x0080
        L_0x0077:
            j$.util.concurrent.P r3 = r7.f28668f     // Catch:{ all -> 0x00c8 }
            if (r11 != r3) goto L_0x007e
            r7.f28668f = r5     // Catch:{ all -> 0x00c8 }
            goto L_0x0080
        L_0x007e:
            r7.f28669g = r5     // Catch:{ all -> 0x00c8 }
        L_0x0080:
            if (r6 == 0) goto L_0x008b
            r3 = r6
            goto L_0x008c
        L_0x0084:
            if (r3 == 0) goto L_0x0087
            goto L_0x008c
        L_0x0087:
            if (r4 == 0) goto L_0x008b
            r3 = r4
            goto L_0x008c
        L_0x008b:
            r3 = r11
        L_0x008c:
            if (r3 == r11) goto L_0x00a5
            j$.util.concurrent.P r4 = r11.f28667e     // Catch:{ all -> 0x00c8 }
            r3.f28667e = r4     // Catch:{ all -> 0x00c8 }
            if (r4 != 0) goto L_0x0096
            r0 = r3
            goto L_0x009f
        L_0x0096:
            j$.util.concurrent.P r5 = r4.f28668f     // Catch:{ all -> 0x00c8 }
            if (r11 != r5) goto L_0x009d
            r4.f28668f = r3     // Catch:{ all -> 0x00c8 }
            goto L_0x009f
        L_0x009d:
            r4.f28669g = r3     // Catch:{ all -> 0x00c8 }
        L_0x009f:
            r11.f28667e = r2     // Catch:{ all -> 0x00c8 }
            r11.f28669g = r2     // Catch:{ all -> 0x00c8 }
            r11.f28668f = r2     // Catch:{ all -> 0x00c8 }
        L_0x00a5:
            boolean r4 = r11.f28671i     // Catch:{ all -> 0x00c8 }
            if (r4 == 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            j$.util.concurrent.P r0 = b(r0, r3)     // Catch:{ all -> 0x00c8 }
        L_0x00ae:
            r10.f28664e = r0     // Catch:{ all -> 0x00c8 }
            if (r11 != r3) goto L_0x00c5
            j$.util.concurrent.P r0 = r11.f28667e     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x00c5
            j$.util.concurrent.P r3 = r0.f28668f     // Catch:{ all -> 0x00c8 }
            if (r11 != r3) goto L_0x00bd
            r0.f28668f = r2     // Catch:{ all -> 0x00c8 }
            goto L_0x00c3
        L_0x00bd:
            j$.util.concurrent.P r3 = r0.f28669g     // Catch:{ all -> 0x00c8 }
            if (r11 != r3) goto L_0x00c3
            r0.f28669g = r2     // Catch:{ all -> 0x00c8 }
        L_0x00c3:
            r11.f28667e = r2     // Catch:{ all -> 0x00c8 }
        L_0x00c5:
            r10.lockState = r1
            return r1
        L_0x00c8:
            r11 = move-exception
            r10.lockState = r1
            throw r11
        L_0x00cc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.O.f(j$.util.concurrent.P):boolean");
    }
}
