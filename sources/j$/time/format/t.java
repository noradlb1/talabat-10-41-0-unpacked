package j$.time.format;

import j$.time.chrono.u;
import j$.time.temporal.a;
import j$.time.temporal.i;
import j$.time.temporal.k;
import j$.time.temporal.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;

public final class t {

    /* renamed from: h  reason: collision with root package name */
    private static final C0110a f28381h = new C0110a();

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap f28382i;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ int f28383j = 0;

    /* renamed from: a  reason: collision with root package name */
    private t f28384a;

    /* renamed from: b  reason: collision with root package name */
    private final t f28385b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f28386c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f28387d;

    /* renamed from: e  reason: collision with root package name */
    private int f28388e;

    /* renamed from: f  reason: collision with root package name */
    private char f28389f;

    /* renamed from: g  reason: collision with root package name */
    private int f28390g;

    static {
        HashMap hashMap = new HashMap();
        f28382i = hashMap;
        hashMap.put('G', a.ERA);
        hashMap.put('y', a.YEAR_OF_ERA);
        hashMap.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), a.YEAR);
        q qVar = i.f28454a;
        hashMap.put('Q', qVar);
        hashMap.put('q', qVar);
        a aVar = a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', a.DAY_OF_YEAR);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL), a.DAY_OF_MONTH);
        hashMap.put('F', a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        a aVar2 = a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', a.AMPM_OF_DAY);
        hashMap.put('H', a.HOUR_OF_DAY);
        hashMap.put('k', a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', a.HOUR_OF_AMPM);
        hashMap.put('h', a.CLOCK_HOUR_OF_AMPM);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL), a.MINUTE_OF_HOUR);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL), a.SECOND_OF_MINUTE);
        a aVar3 = a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', a.NANO_OF_DAY);
        hashMap.put('g', k.f28464a);
    }

    public t() {
        this.f28384a = this;
        this.f28386c = new ArrayList();
        this.f28390g = -1;
        this.f28385b = null;
        this.f28387d = false;
    }

    private t(t tVar) {
        this.f28384a = this;
        this.f28386c = new ArrayList();
        this.f28390g = -1;
        this.f28385b = tVar;
        this.f28387d = true;
    }

    private int d(g gVar) {
        Objects.requireNonNull(gVar, "pp");
        t tVar = this.f28384a;
        int i11 = tVar.f28388e;
        if (i11 > 0) {
            m mVar = new m(gVar, i11, tVar.f28389f);
            tVar.f28388e = 0;
            tVar.f28389f = 0;
            gVar = mVar;
        }
        tVar.f28386c.add(gVar);
        t tVar2 = this.f28384a;
        tVar2.f28390g = -1;
        return tVar2.f28386c.size() - 1;
    }

    private void l(k kVar) {
        k kVar2;
        t tVar = this.f28384a;
        int i11 = tVar.f28390g;
        if (i11 >= 0) {
            k kVar3 = (k) tVar.f28386c.get(i11);
            int i12 = kVar.f28354b;
            int i13 = kVar.f28355c;
            if (i12 == i13 && kVar.f28356d == A.NOT_NEGATIVE) {
                kVar2 = kVar3.d(i13);
                d(kVar.c());
                this.f28384a.f28390g = i11;
            } else {
                kVar2 = kVar3.c();
                this.f28384a.f28390g = d(kVar);
            }
            this.f28384a.f28386c.set(i11, kVar2);
            return;
        }
        tVar.f28390g = d(kVar);
    }

    private DateTimeFormatter w(Locale locale, z zVar, u uVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f28384a.f28385b != null) {
            o();
        }
        f fVar = new f(this.f28386c, false);
        y yVar = y.f28403a;
        return new DateTimeFormatter(fVar, locale, zVar, uVar);
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        d(dateTimeFormatter.f());
    }

    public final void b(a aVar, int i11, int i12, boolean z11) {
        if (i11 != i12 || z11) {
            d(new h(aVar, i11, i12, z11));
        } else {
            l(new h(aVar, i11, i12, z11));
        }
    }

    public final void c() {
        d(new i());
    }

    public final void e(char c11) {
        d(new e(c11));
    }

    public final void f(String str) {
        Objects.requireNonNull(str, "literal");
        if (!str.isEmpty()) {
            d(str.length() == 1 ? new e(str.charAt(0)) : new j(1, str));
        }
    }

    public final void g(String str, String str2) {
        d(new l(str, str2));
    }

    public final void h() {
        d(l.f28359e);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e7, code lost:
        if (r3 == 1) goto L_0x0206;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x02d7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0405 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "pattern"
            java.util.Objects.requireNonNull(r1, r2)
            r2 = 0
            r3 = r2
        L_0x000b:
            int r4 = r17.length()
            if (r3 >= r4) goto L_0x0458
            char r4 = r1.charAt(r3)
            r5 = 90
            r6 = 1
            r7 = 122(0x7a, float:1.71E-43)
            r8 = 97
            r9 = 65
            if (r4 < r9) goto L_0x0022
            if (r4 <= r5) goto L_0x0026
        L_0x0022:
            if (r4 < r8) goto L_0x03c0
            if (r4 > r7) goto L_0x03c0
        L_0x0026:
            int r10 = r3 + 1
        L_0x0028:
            int r11 = r17.length()
            if (r10 >= r11) goto L_0x0037
            char r11 = r1.charAt(r10)
            if (r11 != r4) goto L_0x0037
            int r10 = r10 + 1
            goto L_0x0028
        L_0x0037:
            int r3 = r10 - r3
            r11 = 112(0x70, float:1.57E-43)
            r12 = -1
            if (r4 != r11) goto L_0x0098
            int r11 = r17.length()
            if (r10 >= r11) goto L_0x0064
            char r4 = r1.charAt(r10)
            if (r4 < r9) goto L_0x004c
            if (r4 <= r5) goto L_0x0050
        L_0x004c:
            if (r4 < r8) goto L_0x0064
            if (r4 > r7) goto L_0x0064
        L_0x0050:
            int r11 = r10 + 1
        L_0x0052:
            int r13 = r17.length()
            if (r11 >= r13) goto L_0x0061
            char r13 = r1.charAt(r11)
            if (r13 != r4) goto L_0x0061
            int r11 = r11 + 1
            goto L_0x0052
        L_0x0061:
            int r10 = r11 - r10
            goto L_0x0067
        L_0x0064:
            r11 = r10
            r10 = r3
            r3 = r2
        L_0x0067:
            if (r3 == 0) goto L_0x008c
            if (r3 < r6) goto L_0x0078
            j$.time.format.t r13 = r0.f28384a
            r13.f28388e = r3
            r3 = 32
            r13.f28389f = r3
            r13.f28390g = r12
            r3 = r10
            r10 = r11
            goto L_0x0098
        L_0x0078:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "The pad width must be at least one but was "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x008c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Pad letter 'p' must be followed by valid pad pattern: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L_0x0098:
            java.util.HashMap r11 = f28382i
            java.lang.Character r13 = java.lang.Character.valueOf(r4)
            java.lang.Object r11 = r11.get(r13)
            j$.time.temporal.q r11 = (j$.time.temporal.q) r11
            r13 = 19
            r14 = 2
            r15 = 5
            java.lang.String r12 = "Too many pattern letters: "
            r5 = 4
            if (r11 == 0) goto L_0x021d
            if (r4 == r9) goto L_0x0215
            r7 = 81
            r9 = 3
            if (r4 == r7) goto L_0x01ad
            r7 = 83
            if (r4 == r7) goto L_0x01a6
            if (r4 == r8) goto L_0x0191
            r7 = 107(0x6b, float:1.5E-43)
            if (r4 == r7) goto L_0x0174
            r7 = 113(0x71, float:1.58E-43)
            if (r4 == r7) goto L_0x0172
            r7 = 115(0x73, float:1.61E-43)
            if (r4 == r7) goto L_0x0174
            r7 = 117(0x75, float:1.64E-43)
            if (r4 == r7) goto L_0x0155
            r7 = 121(0x79, float:1.7E-43)
            if (r4 == r7) goto L_0x0155
            r7 = 103(0x67, float:1.44E-43)
            if (r4 == r7) goto L_0x016a
            r7 = 104(0x68, float:1.46E-43)
            if (r4 == r7) goto L_0x0174
            r7 = 109(0x6d, float:1.53E-43)
            if (r4 == r7) goto L_0x0174
            r7 = 110(0x6e, float:1.54E-43)
            if (r4 == r7) goto L_0x0215
            switch(r4) {
                case 68: goto L_0x011f;
                case 69: goto L_0x01ad;
                case 70: goto L_0x0109;
                case 71: goto L_0x00eb;
                case 72: goto L_0x0174;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            switch(r4) {
                case 75: goto L_0x0174;
                case 76: goto L_0x0172;
                case 77: goto L_0x01ad;
                case 78: goto L_0x0215;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            switch(r4) {
                case 99: goto L_0x0141;
                case 100: goto L_0x0174;
                case 101: goto L_0x01ad;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            if (r3 != r6) goto L_0x017a
            goto L_0x0206
        L_0x00eb:
            if (r3 == r6) goto L_0x01f0
            if (r3 == r14) goto L_0x01f0
            if (r3 == r9) goto L_0x01f0
            if (r3 == r5) goto L_0x01d7
            if (r3 != r15) goto L_0x00f7
            goto L_0x01bd
        L_0x00f7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0109:
            if (r3 != r6) goto L_0x010d
            goto L_0x0206
        L_0x010d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x011f:
            if (r3 != r6) goto L_0x0123
            goto L_0x0206
        L_0x0123:
            if (r3 == r14) goto L_0x013a
            if (r3 != r9) goto L_0x0128
            goto L_0x013a
        L_0x0128:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x013a:
            j$.time.format.A r4 = j$.time.format.A.NOT_NEGATIVE
            r0.k(r11, r3, r9, r4)
            goto L_0x021a
        L_0x0141:
            if (r3 != r6) goto L_0x014a
            j$.time.format.q r5 = new j$.time.format.q
            r5.<init>(r4, r3, r3, r3)
            goto L_0x01e8
        L_0x014a:
            if (r3 == r14) goto L_0x014d
            goto L_0x0172
        L_0x014d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid pattern \"cc\""
            r1.<init>(r2)
            throw r1
        L_0x0155:
            if (r3 != r14) goto L_0x0168
            j$.time.h r3 = j$.time.format.n.f28366i
            java.lang.String r4 = "baseDate"
            java.util.Objects.requireNonNull(r3, r4)
            j$.time.format.n r4 = new j$.time.format.n
            r4.<init>(r11, r3)
            r0.l(r4)
            goto L_0x021a
        L_0x0168:
            if (r3 >= r5) goto L_0x016e
        L_0x016a:
            j$.time.format.A r4 = j$.time.format.A.NORMAL
            goto L_0x0217
        L_0x016e:
            j$.time.format.A r4 = j$.time.format.A.EXCEEDS_PAD
            goto L_0x0217
        L_0x0172:
            r7 = r6
            goto L_0x01ae
        L_0x0174:
            if (r3 != r6) goto L_0x0178
            goto L_0x0206
        L_0x0178:
            if (r3 != r14) goto L_0x017f
        L_0x017a:
            r0.m(r11, r3)
            goto L_0x021a
        L_0x017f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0191:
            if (r3 != r6) goto L_0x0194
            goto L_0x01f0
        L_0x0194:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01a6:
            j$.time.temporal.a r4 = j$.time.temporal.a.NANO_OF_SECOND
            r0.b(r4, r3, r3, r2)
            goto L_0x021a
        L_0x01ad:
            r7 = r2
        L_0x01ae:
            if (r3 == r6) goto L_0x01df
            if (r3 == r14) goto L_0x01df
            if (r3 == r9) goto L_0x01da
            if (r3 == r5) goto L_0x01d2
            if (r3 != r15) goto L_0x01c0
            if (r7 == 0) goto L_0x01bd
            j$.time.format.B r3 = j$.time.format.B.NARROW_STANDALONE
            goto L_0x01f2
        L_0x01bd:
            j$.time.format.B r3 = j$.time.format.B.NARROW
            goto L_0x01f2
        L_0x01c0:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d2:
            if (r7 == 0) goto L_0x01d7
            j$.time.format.B r3 = j$.time.format.B.FULL_STANDALONE
            goto L_0x01f2
        L_0x01d7:
            j$.time.format.B r3 = j$.time.format.B.FULL
            goto L_0x01f2
        L_0x01da:
            if (r7 == 0) goto L_0x01f0
            j$.time.format.B r3 = j$.time.format.B.SHORT_STANDALONE
            goto L_0x01f2
        L_0x01df:
            r5 = 101(0x65, float:1.42E-43)
            if (r4 != r5) goto L_0x01ec
            j$.time.format.q r5 = new j$.time.format.q
            r5.<init>(r4, r3, r3, r3)
        L_0x01e8:
            r0.l(r5)
            goto L_0x021a
        L_0x01ec:
            r5 = 69
            if (r4 != r5) goto L_0x0204
        L_0x01f0:
            j$.time.format.B r3 = j$.time.format.B.SHORT
        L_0x01f2:
            java.lang.String r4 = "textStyle"
            java.util.Objects.requireNonNull(r3, r4)
            j$.time.format.p r4 = new j$.time.format.p
            j$.time.format.x r5 = j$.time.format.x.c()
            r4.<init>(r11, r3, r5)
            r0.d(r4)
            goto L_0x021a
        L_0x0204:
            if (r3 != r6) goto L_0x0211
        L_0x0206:
            j$.time.format.k r3 = new j$.time.format.k
            j$.time.format.A r4 = j$.time.format.A.NORMAL
            r3.<init>(r11, r6, r13, r4)
            r0.l(r3)
            goto L_0x021a
        L_0x0211:
            r0.m(r11, r14)
            goto L_0x021a
        L_0x0215:
            j$.time.format.A r4 = j$.time.format.A.NOT_NEGATIVE
        L_0x0217:
            r0.k(r11, r3, r13, r4)
        L_0x021a:
            r3 = -1
            goto L_0x03a9
        L_0x021d:
            if (r4 != r7) goto L_0x0243
            if (r3 > r5) goto L_0x0231
            if (r3 != r5) goto L_0x0226
            j$.time.format.B r3 = j$.time.format.B.FULL
            goto L_0x0228
        L_0x0226:
            j$.time.format.B r3 = j$.time.format.B.SHORT
        L_0x0228:
            j$.time.format.s r4 = new j$.time.format.s
            r4.<init>(r3, r2)
            r0.d(r4)
            goto L_0x021a
        L_0x0231:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0243:
            r7 = 86
            if (r4 != r7) goto L_0x026c
            if (r3 != r14) goto L_0x0258
            j$.time.format.r r3 = new j$.time.format.r
            j$.time.temporal.s r4 = j$.time.temporal.p.k()
            java.lang.String r5 = "ZoneId()"
            r3.<init>(r4, r5)
            r0.d(r3)
            goto L_0x021a
        L_0x0258:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Pattern letter count must be 2: "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x026c:
            r7 = 118(0x76, float:1.65E-43)
            if (r4 != r7) goto L_0x0296
            if (r3 != r6) goto L_0x0275
            j$.time.format.B r3 = j$.time.format.B.SHORT
            goto L_0x0279
        L_0x0275:
            if (r3 != r5) goto L_0x0282
            j$.time.format.B r3 = j$.time.format.B.FULL
        L_0x0279:
            j$.time.format.s r4 = new j$.time.format.s
            r4.<init>(r3, r6)
            r0.d(r4)
            goto L_0x021a
        L_0x0282:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Wrong number of  pattern letters: "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0296:
            java.lang.String r7 = "+0000"
            r8 = 90
            if (r4 != r8) goto L_0x02bc
            if (r3 >= r5) goto L_0x02a2
            java.lang.String r3 = "+HHMM"
            goto L_0x0342
        L_0x02a2:
            if (r3 != r5) goto L_0x02a5
            goto L_0x02c7
        L_0x02a5:
            if (r3 != r15) goto L_0x02aa
            java.lang.String r3 = "+HH:MM:ss"
            goto L_0x030d
        L_0x02aa:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x02bc:
            r8 = 79
            if (r4 != r8) goto L_0x02fd
            if (r3 != r6) goto L_0x02c5
            j$.time.format.B r3 = j$.time.format.B.SHORT
            goto L_0x02c9
        L_0x02c5:
            if (r3 != r5) goto L_0x02e9
        L_0x02c7:
            j$.time.format.B r3 = j$.time.format.B.FULL
        L_0x02c9:
            java.lang.String r4 = "style"
            java.util.Objects.requireNonNull(r3, r4)
            j$.time.format.B r4 = j$.time.format.B.FULL
            if (r3 == r4) goto L_0x02df
            j$.time.format.B r4 = j$.time.format.B.SHORT
            if (r3 != r4) goto L_0x02d7
            goto L_0x02df
        L_0x02d7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Style must be either full or short"
            r1.<init>(r2)
            throw r1
        L_0x02df:
            j$.time.format.j r4 = new j$.time.format.j
            r4.<init>(r2, r3)
            r0.d(r4)
            goto L_0x021a
        L_0x02e9:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Pattern letter count must be 1 or 4: "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x02fd:
            r5 = 88
            if (r4 != r5) goto L_0x0326
            if (r3 > r15) goto L_0x0314
            java.lang.String[] r4 = j$.time.format.l.f28358d
            if (r3 != r6) goto L_0x0309
            r5 = r2
            goto L_0x030a
        L_0x0309:
            r5 = r6
        L_0x030a:
            int r3 = r3 + r5
            r3 = r4[r3]
        L_0x030d:
            java.lang.String r4 = "Z"
            r0.g(r3, r4)
            goto L_0x021a
        L_0x0314:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0326:
            r5 = 120(0x78, float:1.68E-43)
            if (r4 != r5) goto L_0x0359
            if (r3 > r15) goto L_0x0347
            if (r3 != r6) goto L_0x0331
            java.lang.String r7 = "+00"
            goto L_0x0338
        L_0x0331:
            int r4 = r3 % 2
            if (r4 != 0) goto L_0x0336
            goto L_0x0338
        L_0x0336:
            java.lang.String r7 = "+00:00"
        L_0x0338:
            java.lang.String[] r4 = j$.time.format.l.f28358d
            if (r3 != r6) goto L_0x033e
            r5 = r2
            goto L_0x033f
        L_0x033e:
            r5 = r6
        L_0x033f:
            int r3 = r3 + r5
            r3 = r4[r3]
        L_0x0342:
            r0.g(r3, r7)
            goto L_0x021a
        L_0x0347:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0359:
            r5 = 87
            if (r4 != r5) goto L_0x0377
            if (r3 > r6) goto L_0x0365
            j$.time.format.q r5 = new j$.time.format.q
            r5.<init>(r4, r3, r3, r3)
            goto L_0x03a4
        L_0x0365:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0377:
            r5 = 119(0x77, float:1.67E-43)
            if (r4 != r5) goto L_0x0395
            if (r3 > r14) goto L_0x0383
            j$.time.format.q r5 = new j$.time.format.q
            r5.<init>(r4, r3, r3, r14)
            goto L_0x03a4
        L_0x0383:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r12)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0395:
            r5 = 89
            if (r4 != r5) goto L_0x03ac
            j$.time.format.q r5 = new j$.time.format.q
            if (r3 != r14) goto L_0x03a1
            r5.<init>(r4, r3, r3, r14)
            goto L_0x03a4
        L_0x03a1:
            r5.<init>(r4, r3, r3, r13)
        L_0x03a4:
            r0.l(r5)
            goto L_0x021a
        L_0x03a9:
            int r3 = r3 + r10
            goto L_0x043e
        L_0x03ac:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown pattern letter: "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x03c0:
            java.lang.String r5 = "'"
            r7 = 39
            if (r4 != r7) goto L_0x0411
            int r3 = r3 + 1
            r4 = r3
        L_0x03c9:
            int r8 = r17.length()
            if (r4 >= r8) goto L_0x03e6
            char r8 = r1.charAt(r4)
            if (r8 != r7) goto L_0x03e4
            int r8 = r4 + 1
            int r9 = r17.length()
            if (r8 >= r9) goto L_0x03e6
            char r9 = r1.charAt(r8)
            if (r9 != r7) goto L_0x03e6
            r4 = r8
        L_0x03e4:
            int r4 = r4 + r6
            goto L_0x03c9
        L_0x03e6:
            int r8 = r17.length()
            if (r4 >= r8) goto L_0x0405
            java.lang.String r3 = r1.substring(r3, r4)
            boolean r8 = r3.isEmpty()
            if (r8 == 0) goto L_0x03fa
            r0.e(r7)
            goto L_0x0403
        L_0x03fa:
            java.lang.String r7 = "''"
            java.lang.String r3 = r3.replace(r7, r5)
            r0.f(r3)
        L_0x0403:
            r3 = r4
            goto L_0x043e
        L_0x0405:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Pattern ends with an incomplete string literal: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L_0x0411:
            r7 = 91
            if (r4 != r7) goto L_0x0419
            r16.p()
            goto L_0x043e
        L_0x0419:
            r7 = 93
            if (r4 != r7) goto L_0x042f
            j$.time.format.t r4 = r0.f28384a
            j$.time.format.t r4 = r4.f28385b
            if (r4 == 0) goto L_0x0427
            r16.o()
            goto L_0x043e
        L_0x0427:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Pattern invalid as it contains ] without previous ["
            r1.<init>(r2)
            throw r1
        L_0x042f:
            r7 = 123(0x7b, float:1.72E-43)
            if (r4 == r7) goto L_0x0441
            r7 = 125(0x7d, float:1.75E-43)
            if (r4 == r7) goto L_0x0441
            r7 = 35
            if (r4 == r7) goto L_0x0441
            r0.e(r4)
        L_0x043e:
            int r3 = r3 + r6
            goto L_0x000b
        L_0x0441:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Pattern includes reserved character: '"
            r2.<init>(r3)
            r2.append(r4)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0458:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.t.i(java.lang.String):void");
    }

    public final void j(a aVar, HashMap hashMap) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(hashMap);
        B b11 = B.FULL;
        d(new p(aVar, b11, new C0111b(new w(Collections.singletonMap(b11, linkedHashMap)))));
    }

    public final t k(q qVar, int i11, int i12, A a11) {
        if (i11 == i12 && a11 == A.NOT_NEGATIVE) {
            m(qVar, i12);
            return this;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(a11, "signStyle");
        if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i11);
        } else if (i12 < 1 || i12 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i12);
        } else if (i12 >= i11) {
            l(new k(qVar, i11, i12, a11));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i12 + " < " + i11);
        }
    }

    public final void m(q qVar, int i11) {
        Objects.requireNonNull(qVar, "field");
        if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i11);
        }
        l(new k(qVar, i11, i11, A.NOT_NEGATIVE));
    }

    public final void n() {
        d(new r(f28381h, "ZoneRegionId()"));
    }

    public final void o() {
        t tVar = this.f28384a;
        if (tVar.f28385b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        } else if (tVar.f28386c.size() > 0) {
            t tVar2 = this.f28384a;
            f fVar = new f(tVar2.f28386c, tVar2.f28387d);
            this.f28384a = this.f28384a.f28385b;
            d(fVar);
        } else {
            this.f28384a = this.f28384a.f28385b;
        }
    }

    public final void p() {
        t tVar = this.f28384a;
        tVar.f28390g = -1;
        this.f28384a = new t(tVar);
    }

    public final void q() {
        d(o.INSENSITIVE);
    }

    public final void r() {
        d(o.SENSITIVE);
    }

    public final void s() {
        d(o.LENIENT);
    }

    public final void t() {
        d(o.STRICT);
    }

    /* access modifiers changed from: package-private */
    public final DateTimeFormatter u(z zVar, u uVar) {
        return w(Locale.getDefault(), zVar, uVar);
    }

    public final DateTimeFormatter v(Locale locale) {
        return w(locale, z.SMART, (u) null);
    }
}
