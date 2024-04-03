package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f33928a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33929b;

    /* renamed from: c  reason: collision with root package name */
    private int f33930c;

    /* renamed from: d  reason: collision with root package name */
    private int f33931d;

    /* renamed from: e  reason: collision with root package name */
    private int f33932e;

    /* renamed from: f  reason: collision with root package name */
    private int f33933f;

    /* renamed from: g  reason: collision with root package name */
    private char[] f33934g;

    public a(X500Principal x500Principal) {
        String name2 = x500Principal.getName("RFC2253");
        this.f33928a = name2;
        this.f33929b = name2.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        return new java.lang.String(r1, r2, r8.f33933f - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f33930c
            r8.f33931d = r0
            r8.f33932e = r0
        L_0x0006:
            int r0 = r8.f33930c
            int r1 = r8.f33929b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f33934g
            int r2 = r8.f33931d
            int r3 = r8.f33932e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f33934g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x005c
            if (r2 == r5) goto L_0x0051
            r5 = 92
            if (r2 == r5) goto L_0x003e
            if (r2 == r4) goto L_0x0051
            if (r2 == r3) goto L_0x0051
            int r3 = r8.f33932e
            int r4 = r3 + 1
            r8.f33932e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f33930c = r0
            goto L_0x0006
        L_0x003e:
            int r0 = r8.f33932e
            int r2 = r0 + 1
            r8.f33932e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.f33930c
            int r0 = r0 + 1
            r8.f33930c = r0
            goto L_0x0006
        L_0x0051:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f33931d
            int r3 = r8.f33932e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x005c:
            int r2 = r8.f33932e
            r8.f33933f = r2
            int r0 = r0 + 1
            r8.f33930c = r0
            int r0 = r2 + 1
            r8.f33932e = r0
            r1[r2] = r6
        L_0x006a:
            int r0 = r8.f33930c
            int r1 = r8.f33929b
            if (r0 >= r1) goto L_0x0083
            char[] r2 = r8.f33934g
            char r7 = r2[r0]
            if (r7 != r6) goto L_0x0083
            int r1 = r8.f33932e
            int r7 = r1 + 1
            r8.f33932e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f33930c = r0
            goto L_0x006a
        L_0x0083:
            if (r0 == r1) goto L_0x008f
            char[] r1 = r8.f33934g
            char r0 = r1[r0]
            if (r0 == r3) goto L_0x008f
            if (r0 == r4) goto L_0x008f
            if (r0 != r5) goto L_0x0006
        L_0x008f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f33934g
            int r2 = r8.f33931d
            int r3 = r8.f33933f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.a():java.lang.String");
    }

    private char b() {
        int i11 = this.f33930c + 1;
        this.f33930c = i11;
        if (i11 != this.f33929b) {
            char c11 = this.f33934g[i11];
            if (c11 == ' ' || c11 == '%' || c11 == '\\' || c11 == '_' || c11 == '\"' || c11 == '#') {
                return c11;
            }
            switch (c11) {
                case '*':
                case '+':
                case ',':
                    return c11;
                default:
                    switch (c11) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            return c11;
                        default:
                            return c();
                    }
            }
        } else {
            throw new IllegalStateException("Unexpected end of DN: " + this.f33928a);
        }
    }

    private char c() {
        int i11;
        int i12;
        int a11 = a(this.f33930c);
        this.f33930c++;
        if (a11 < 128) {
            return (char) a11;
        }
        if (a11 < 192 || a11 > 247) {
            return '?';
        }
        if (a11 <= 223) {
            i12 = a11 & 31;
            i11 = 1;
        } else if (a11 <= 239) {
            i12 = a11 & 15;
            i11 = 2;
        } else {
            i12 = a11 & 7;
            i11 = 3;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = this.f33930c + 1;
            this.f33930c = i14;
            if (i14 == this.f33929b || this.f33934g[i14] != '\\') {
                return '?';
            }
            int i15 = i14 + 1;
            this.f33930c = i15;
            int a12 = a(i15);
            this.f33930c++;
            if ((a12 & 192) != 128) {
                return '?';
            }
            i12 = (i12 << 6) + (a12 & 63);
        }
        return (char) i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r1 = r6.f33934g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String d() {
        /*
            r6 = this;
            int r0 = r6.f33930c
            int r1 = r0 + 4
            int r2 = r6.f33929b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L_0x0098
            r6.f33931d = r0
            int r0 = r0 + 1
            r6.f33930c = r0
        L_0x0010:
            int r0 = r6.f33930c
            int r1 = r6.f33929b
            if (r0 == r1) goto L_0x0054
            char[] r1 = r6.f33934g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L_0x0054
            r4 = 44
            if (r2 == r4) goto L_0x0054
            r4 = 59
            if (r2 != r4) goto L_0x0027
            goto L_0x0054
        L_0x0027:
            r4 = 32
            if (r2 != r4) goto L_0x0042
            r6.f33932e = r0
            int r0 = r0 + 1
            r6.f33930c = r0
        L_0x0031:
            int r0 = r6.f33930c
            int r1 = r6.f33929b
            if (r0 >= r1) goto L_0x0056
            char[] r1 = r6.f33934g
            char r1 = r1[r0]
            if (r1 != r4) goto L_0x0056
            int r0 = r0 + 1
            r6.f33930c = r0
            goto L_0x0031
        L_0x0042:
            r4 = 65
            if (r2 < r4) goto L_0x004f
            r4 = 70
            if (r2 > r4) goto L_0x004f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L_0x004f:
            int r0 = r0 + 1
            r6.f33930c = r0
            goto L_0x0010
        L_0x0054:
            r6.f33932e = r0
        L_0x0056:
            int r0 = r6.f33932e
            int r1 = r6.f33931d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L_0x0081
            r2 = r0 & 1
            if (r2 == 0) goto L_0x0081
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L_0x0069:
            if (r4 >= r2) goto L_0x0077
            int r5 = r6.a((int) r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L_0x0069
        L_0x0077:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f33934g
            int r3 = r6.f33931d
            r1.<init>(r2, r3, r0)
            return r1
        L_0x0081:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f33928a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0098:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f33928a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.d():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String e() {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r6.f33930c
            int r1 = r6.f33929b
            r2 = 32
            if (r0 >= r1) goto L_0x0013
            char[] r3 = r6.f33934g
            char r3 = r3[r0]
            if (r3 != r2) goto L_0x0013
            int r0 = r0 + 1
            r6.f33930c = r0
            goto L_0x0000
        L_0x0013:
            if (r0 != r1) goto L_0x0017
            r0 = 0
            return r0
        L_0x0017:
            r6.f33931d = r0
            int r0 = r0 + 1
            r6.f33930c = r0
        L_0x001d:
            int r0 = r6.f33930c
            int r1 = r6.f33929b
            r3 = 61
            if (r0 >= r1) goto L_0x0032
            char[] r4 = r6.f33934g
            char r4 = r4[r0]
            if (r4 == r3) goto L_0x0032
            if (r4 == r2) goto L_0x0032
            int r0 = r0 + 1
            r6.f33930c = r0
            goto L_0x001d
        L_0x0032:
            java.lang.String r4 = "Unexpected end of DN: "
            if (r0 >= r1) goto L_0x00cb
            r6.f33932e = r0
            char[] r1 = r6.f33934g
            char r0 = r1[r0]
            if (r0 != r2) goto L_0x0071
        L_0x003e:
            int r0 = r6.f33930c
            int r1 = r6.f33929b
            if (r0 >= r1) goto L_0x0051
            char[] r5 = r6.f33934g
            char r5 = r5[r0]
            if (r5 == r3) goto L_0x0051
            if (r5 != r2) goto L_0x0051
            int r0 = r0 + 1
            r6.f33930c = r0
            goto L_0x003e
        L_0x0051:
            char[] r5 = r6.f33934g
            char r5 = r5[r0]
            if (r5 != r3) goto L_0x005a
            if (r0 == r1) goto L_0x005a
            goto L_0x0071
        L_0x005a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r6.f33928a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0071:
            int r0 = r6.f33930c
            int r0 = r0 + 1
            r6.f33930c = r0
        L_0x0077:
            int r0 = r6.f33930c
            int r1 = r6.f33929b
            if (r0 >= r1) goto L_0x0088
            char[] r1 = r6.f33934g
            char r1 = r1[r0]
            if (r1 != r2) goto L_0x0088
            int r0 = r0 + 1
            r6.f33930c = r0
            goto L_0x0077
        L_0x0088:
            int r0 = r6.f33932e
            int r1 = r6.f33931d
            int r2 = r0 - r1
            r3 = 4
            if (r2 <= r3) goto L_0x00c0
            char[] r2 = r6.f33934g
            int r4 = r1 + 3
            char r4 = r2[r4]
            r5 = 46
            if (r4 != r5) goto L_0x00c0
            char r4 = r2[r1]
            r5 = 79
            if (r4 == r5) goto L_0x00a5
            r5 = 111(0x6f, float:1.56E-43)
            if (r4 != r5) goto L_0x00c0
        L_0x00a5:
            int r4 = r1 + 1
            char r4 = r2[r4]
            r5 = 73
            if (r4 == r5) goto L_0x00b1
            r5 = 105(0x69, float:1.47E-43)
            if (r4 != r5) goto L_0x00c0
        L_0x00b1:
            int r4 = r1 + 2
            char r2 = r2[r4]
            r4 = 68
            if (r2 == r4) goto L_0x00bd
            r4 = 100
            if (r2 != r4) goto L_0x00c0
        L_0x00bd:
            int r1 = r1 + r3
            r6.f33931d = r1
        L_0x00c0:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f33934g
            int r3 = r6.f33931d
            int r0 = r0 - r3
            r1.<init>(r2, r3, r0)
            return r1
        L_0x00cb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r6.f33928a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.e():java.lang.String");
    }

    private String f() {
        int i11 = this.f33930c + 1;
        this.f33930c = i11;
        this.f33931d = i11;
        this.f33932e = i11;
        while (true) {
            int i12 = this.f33930c;
            if (i12 != this.f33929b) {
                char[] cArr = this.f33934g;
                char c11 = cArr[i12];
                if (c11 == '\"') {
                    this.f33930c = i12 + 1;
                    while (true) {
                        int i13 = this.f33930c;
                        if (i13 >= this.f33929b || this.f33934g[i13] != ' ') {
                            char[] cArr2 = this.f33934g;
                            int i14 = this.f33931d;
                        } else {
                            this.f33930c = i13 + 1;
                        }
                    }
                    char[] cArr22 = this.f33934g;
                    int i142 = this.f33931d;
                    return new String(cArr22, i142, this.f33932e - i142);
                }
                if (c11 == '\\') {
                    cArr[this.f33932e] = b();
                } else {
                    cArr[this.f33932e] = c11;
                }
                this.f33930c++;
                this.f33932e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f33928a);
            }
        }
    }

    public List<String> b(String str) {
        String str2;
        this.f33930c = 0;
        this.f33931d = 0;
        this.f33932e = 0;
        this.f33933f = 0;
        this.f33934g = this.f33928a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String e11 = e();
        if (e11 == null) {
            return emptyList;
        }
        do {
            int i11 = this.f33930c;
            if (i11 < this.f33929b) {
                char c11 = this.f33934g[i11];
                if (c11 == '\"') {
                    str2 = f();
                } else if (c11 != '#') {
                    str2 = (c11 == '+' || c11 == ',' || c11 == ';') ? "" : a();
                } else {
                    str2 = d();
                }
                if (str.equalsIgnoreCase(e11)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(str2);
                }
                int i12 = this.f33930c;
                if (i12 < this.f33929b) {
                    char c12 = this.f33934g[i12];
                    if (c12 == ',' || c12 == ';' || c12 == '+') {
                        this.f33930c = i12 + 1;
                        e11 = e();
                    } else {
                        throw new IllegalStateException("Malformed DN: " + this.f33928a);
                    }
                }
            }
            return emptyList;
        } while (e11 != null);
        throw new IllegalStateException("Malformed DN: " + this.f33928a);
    }

    private int a(int i11) {
        int i12;
        int i13;
        int i14 = i11 + 1;
        if (i14 < this.f33929b) {
            char[] cArr = this.f33934g;
            char c11 = cArr[i11];
            if (c11 >= '0' && c11 <= '9') {
                i12 = c11 - '0';
            } else if (c11 >= 'a' && c11 <= 'f') {
                i12 = c11 - 'W';
            } else if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f33928a);
            } else {
                i12 = c11 - '7';
            }
            char c12 = cArr[i14];
            if (c12 >= '0' && c12 <= '9') {
                i13 = c12 - '0';
            } else if (c12 >= 'a' && c12 <= 'f') {
                i13 = c12 - 'W';
            } else if (c12 < 'A' || c12 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f33928a);
            } else {
                i13 = c12 - '7';
            }
            return (i12 << 4) + i13;
        }
        throw new IllegalStateException("Malformed DN: " + this.f33928a);
    }

    public String a(String str) {
        String str2;
        this.f33930c = 0;
        this.f33931d = 0;
        this.f33932e = 0;
        this.f33933f = 0;
        this.f33934g = this.f33928a.toCharArray();
        String e11 = e();
        if (e11 == null) {
            return null;
        }
        do {
            int i11 = this.f33930c;
            if (i11 == this.f33929b) {
                return null;
            }
            char c11 = this.f33934g[i11];
            if (c11 == '\"') {
                str2 = f();
            } else if (c11 != '#') {
                str2 = (c11 == '+' || c11 == ',' || c11 == ';') ? "" : a();
            } else {
                str2 = d();
            }
            if (str.equalsIgnoreCase(e11)) {
                return str2;
            }
            int i12 = this.f33930c;
            if (i12 >= this.f33929b) {
                return null;
            }
            char c12 = this.f33934g[i12];
            if (c12 == ',' || c12 == ';' || c12 == '+') {
                this.f33930c = i12 + 1;
                e11 = e();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f33928a);
            }
        } while (e11 != null);
        throw new IllegalStateException("Malformed DN: " + this.f33928a);
    }
}
