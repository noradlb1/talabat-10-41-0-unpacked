package j$.time.format;

import j$.time.b;
import j$.time.chrono.n;
import j$.time.chrono.u;
import j$.time.temporal.a;
import j$.time.temporal.i;
import j$.time.temporal.m;
import j$.time.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_LOCAL_DATE;

    /* renamed from: f  reason: collision with root package name */
    public static final DateTimeFormatter f28338f;

    /* renamed from: a  reason: collision with root package name */
    private final f f28339a;

    /* renamed from: b  reason: collision with root package name */
    private final Locale f28340b;

    /* renamed from: c  reason: collision with root package name */
    private final y f28341c;

    /* renamed from: d  reason: collision with root package name */
    private final n f28342d;

    /* renamed from: e  reason: collision with root package name */
    private final x f28343e = null;

    static {
        t tVar = new t();
        a aVar = a.YEAR;
        A a11 = A.EXCEEDS_PAD;
        tVar.k(aVar, 4, 10, a11);
        tVar.e(SignatureVisitor.SUPER);
        a aVar2 = a.MONTH_OF_YEAR;
        tVar.m(aVar2, 2);
        tVar.e(SignatureVisitor.SUPER);
        a aVar3 = a.DAY_OF_MONTH;
        tVar.m(aVar3, 2);
        z zVar = z.STRICT;
        u uVar = u.f28321d;
        DateTimeFormatter u11 = tVar.u(zVar, uVar);
        ISO_LOCAL_DATE = u11;
        t tVar2 = new t();
        tVar2.q();
        tVar2.a(u11);
        tVar2.h();
        tVar2.u(zVar, uVar);
        t tVar3 = new t();
        tVar3.q();
        tVar3.a(u11);
        tVar3.p();
        tVar3.h();
        tVar3.u(zVar, uVar);
        t tVar4 = new t();
        a aVar4 = a.HOUR_OF_DAY;
        tVar4.m(aVar4, 2);
        tVar4.e(AbstractJsonLexerKt.COLON);
        a aVar5 = a.MINUTE_OF_HOUR;
        tVar4.m(aVar5, 2);
        tVar4.p();
        tVar4.e(AbstractJsonLexerKt.COLON);
        a aVar6 = a.SECOND_OF_MINUTE;
        tVar4.m(aVar6, 2);
        tVar4.p();
        tVar4.b(a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter u12 = tVar4.u(zVar, (u) null);
        t tVar5 = new t();
        tVar5.q();
        tVar5.a(u12);
        tVar5.h();
        tVar5.u(zVar, (u) null);
        t tVar6 = new t();
        tVar6.q();
        tVar6.a(u12);
        tVar6.p();
        tVar6.h();
        tVar6.u(zVar, (u) null);
        t tVar7 = new t();
        tVar7.q();
        tVar7.a(u11);
        tVar7.e('T');
        tVar7.a(u12);
        DateTimeFormatter u13 = tVar7.u(zVar, uVar);
        t tVar8 = new t();
        tVar8.q();
        tVar8.a(u13);
        tVar8.s();
        tVar8.h();
        tVar8.t();
        DateTimeFormatter u14 = tVar8.u(zVar, uVar);
        t tVar9 = new t();
        tVar9.a(u14);
        tVar9.p();
        tVar9.e('[');
        tVar9.r();
        tVar9.n();
        tVar9.e(AbstractJsonLexerKt.END_LIST);
        tVar9.u(zVar, uVar);
        t tVar10 = new t();
        tVar10.a(u13);
        tVar10.p();
        tVar10.h();
        tVar10.p();
        tVar10.e('[');
        tVar10.r();
        tVar10.n();
        tVar10.e(AbstractJsonLexerKt.END_LIST);
        tVar10.u(zVar, uVar);
        t tVar11 = new t();
        tVar11.q();
        tVar11.k(aVar, 4, 10, a11);
        tVar11.e(SignatureVisitor.SUPER);
        tVar11.m(a.DAY_OF_YEAR, 3);
        tVar11.p();
        tVar11.h();
        tVar11.u(zVar, uVar);
        t tVar12 = new t();
        tVar12.q();
        tVar12.k(i.f28456c, 4, 10, a11);
        tVar12.f("-W");
        tVar12.m(i.f28455b, 2);
        tVar12.e(SignatureVisitor.SUPER);
        a aVar7 = a.DAY_OF_WEEK;
        tVar12.m(aVar7, 1);
        tVar12.p();
        tVar12.h();
        tVar12.u(zVar, uVar);
        t tVar13 = new t();
        tVar13.q();
        tVar13.c();
        f28338f = tVar13.u(zVar, (u) null);
        t tVar14 = new t();
        tVar14.q();
        tVar14.m(aVar, 4);
        tVar14.m(aVar2, 2);
        tVar14.m(aVar3, 2);
        tVar14.p();
        tVar14.s();
        tVar14.g("+HHMMss", "Z");
        tVar14.t();
        tVar14.u(zVar, uVar);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        u uVar2 = uVar;
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        t tVar15 = new t();
        tVar15.q();
        tVar15.s();
        tVar15.p();
        tVar15.j(aVar7, hashMap);
        tVar15.f(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        tVar15.o();
        tVar15.k(aVar3, 1, 2, A.NOT_NEGATIVE);
        tVar15.e(' ');
        tVar15.j(aVar2, hashMap2);
        tVar15.e(' ');
        tVar15.m(aVar, 4);
        tVar15.e(' ');
        tVar15.m(aVar4, 2);
        tVar15.e(AbstractJsonLexerKt.COLON);
        tVar15.m(aVar5, 2);
        tVar15.p();
        tVar15.e(AbstractJsonLexerKt.COLON);
        tVar15.m(aVar6, 2);
        tVar15.o();
        tVar15.e(' ');
        tVar15.g("+HHMM", "GMT");
        tVar15.u(z.SMART, uVar2);
    }

    DateTimeFormatter(f fVar, Locale locale, z zVar, u uVar) {
        y yVar = y.f28403a;
        this.f28339a = fVar;
        Objects.requireNonNull(locale, "locale");
        this.f28340b = locale;
        this.f28341c = yVar;
        Objects.requireNonNull(zVar, "resolverStyle");
        this.f28342d = uVar;
    }

    public static DateTimeFormatter ofPattern(String str, Locale locale) {
        t tVar = new t();
        tVar.i(str);
        return tVar.v(locale);
    }

    public final String a(m mVar) {
        StringBuilder sb2 = new StringBuilder(32);
        Objects.requireNonNull(mVar, "temporal");
        try {
            this.f28339a.f(new v(mVar, this), sb2);
            return sb2.toString();
        } catch (IOException e11) {
            throw new b(e11.getMessage(), e11);
        }
    }

    public final n b() {
        return this.f28342d;
    }

    public final y c() {
        return this.f28341c;
    }

    public final Locale d() {
        return this.f28340b;
    }

    public final x e() {
        return this.f28343e;
    }

    /* access modifiers changed from: package-private */
    public final f f() {
        return this.f28339a.a();
    }

    public final String toString() {
        String fVar = this.f28339a.toString();
        return fVar.startsWith("[") ? fVar : fVar.substring(1, fVar.length() - 1);
    }
}
