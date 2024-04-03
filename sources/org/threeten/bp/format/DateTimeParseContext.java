package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

final class DateTimeParseContext {
    private boolean caseSensitive = true;
    private Locale locale;
    private Chronology overrideChronology;
    /* access modifiers changed from: private */
    public ZoneId overrideZone;
    private final ArrayList<Parsed> parsed;
    private boolean strict = true;
    private DecimalStyle symbols;

    public final class Parsed extends DefaultInterfaceTemporalAccessor {

        /* renamed from: b  reason: collision with root package name */
        public Chronology f63368b;

        /* renamed from: c  reason: collision with root package name */
        public ZoneId f63369c;

        /* renamed from: d  reason: collision with root package name */
        public final Map<TemporalField, Long> f63370d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63371e;

        /* renamed from: f  reason: collision with root package name */
        public Period f63372f;

        /* renamed from: g  reason: collision with root package name */
        public List<Object[]> f63373g;

        public Parsed a() {
            Parsed parsed = new Parsed();
            parsed.f63368b = this.f63368b;
            parsed.f63369c = this.f63369c;
            parsed.f63370d.putAll(this.f63370d);
            parsed.f63371e = this.f63371e;
            return parsed;
        }

        public DateTimeBuilder b() {
            DateTimeBuilder dateTimeBuilder = new DateTimeBuilder();
            dateTimeBuilder.f63346b.putAll(this.f63370d);
            dateTimeBuilder.f63347c = DateTimeParseContext.this.g();
            ZoneId zoneId = this.f63369c;
            if (zoneId != null) {
                dateTimeBuilder.f63348d = zoneId;
            } else {
                dateTimeBuilder.f63348d = DateTimeParseContext.this.overrideZone;
            }
            dateTimeBuilder.f63351g = this.f63371e;
            dateTimeBuilder.f63352h = this.f63372f;
            return dateTimeBuilder;
        }

        public int get(TemporalField temporalField) {
            if (this.f63370d.containsKey(temporalField)) {
                return Jdk8Methods.safeToInt(this.f63370d.get(temporalField).longValue());
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        public long getLong(TemporalField temporalField) {
            if (this.f63370d.containsKey(temporalField)) {
                return this.f63370d.get(temporalField).longValue();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        public boolean isSupported(TemporalField temporalField) {
            return this.f63370d.containsKey(temporalField);
        }

        public <R> R query(TemporalQuery<R> temporalQuery) {
            if (temporalQuery == TemporalQueries.chronology()) {
                return this.f63368b;
            }
            if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone()) {
                return this.f63369c;
            }
            return super.query(temporalQuery);
        }

        public String toString() {
            return this.f63370d.toString() + "," + this.f63368b + "," + this.f63369c;
        }

        private Parsed() {
            this.f63368b = null;
            this.f63369c = null;
            this.f63370d = new HashMap();
            this.f63372f = Period.ZERO;
        }
    }

    public DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.locale = dateTimeFormatter.getLocale();
        this.symbols = dateTimeFormatter.getDecimalStyle();
        this.overrideChronology = dateTimeFormatter.getChronology();
        this.overrideZone = dateTimeFormatter.getZone();
        arrayList.add(new Parsed());
    }

    private Parsed currentParsed() {
        ArrayList<Parsed> arrayList = this.parsed;
        return arrayList.get(arrayList.size() - 1);
    }

    public static boolean d(char c11, char c12) {
        if (c11 == c12 || Character.toUpperCase(c11) == Character.toUpperCase(c12) || Character.toLowerCase(c11) == Character.toLowerCase(c12)) {
            return true;
        }
        return false;
    }

    public void b(DateTimeFormatterBuilder.ReducedPrinterParser reducedPrinterParser, long j11, int i11, int i12) {
        Parsed currentParsed = currentParsed();
        if (currentParsed.f63373g == null) {
            currentParsed.f63373g = new ArrayList(2);
        }
        currentParsed.f63373g.add(new Object[]{reducedPrinterParser, Long.valueOf(j11), Integer.valueOf(i11), Integer.valueOf(i12)});
    }

    public boolean c(char c11, char c12) {
        if (!k()) {
            return d(c11, c12);
        }
        if (c11 == c12) {
            return true;
        }
        return false;
    }

    public DateTimeParseContext e() {
        return new DateTimeParseContext(this);
    }

    public void f(boolean z11) {
        if (z11) {
            ArrayList<Parsed> arrayList = this.parsed;
            arrayList.remove(arrayList.size() - 2);
            return;
        }
        ArrayList<Parsed> arrayList2 = this.parsed;
        arrayList2.remove(arrayList2.size() - 1);
    }

    public Chronology g() {
        Chronology chronology = currentParsed().f63368b;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.overrideChronology;
        if (chronology2 == null) {
            return IsoChronology.INSTANCE;
        }
        return chronology2;
    }

    public Locale h() {
        return this.locale;
    }

    public Long i(TemporalField temporalField) {
        return currentParsed().f63370d.get(temporalField);
    }

    public DecimalStyle j() {
        return this.symbols;
    }

    public boolean k() {
        return this.caseSensitive;
    }

    public boolean l() {
        return this.strict;
    }

    public void m(boolean z11) {
        this.caseSensitive = z11;
    }

    public void n(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        currentParsed().f63369c = zoneId;
    }

    public void o(Chronology chronology) {
        Jdk8Methods.requireNonNull(chronology, "chrono");
        Parsed currentParsed = currentParsed();
        currentParsed.f63368b = chronology;
        if (currentParsed.f63373g != null) {
            ArrayList<Object[]> arrayList = new ArrayList<>(currentParsed.f63373g);
            currentParsed.f63373g.clear();
            for (Object[] objArr : arrayList) {
                ((DateTimeFormatterBuilder.ReducedPrinterParser) objArr[0]).c(this, ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        }
    }

    public int p(TemporalField temporalField, long j11, int i11, int i12) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long put = currentParsed().f63370d.put(temporalField, Long.valueOf(j11));
        if (put == null || put.longValue() == j11) {
            return i12;
        }
        return ~i11;
    }

    public void q() {
        currentParsed().f63371e = true;
    }

    public void r(boolean z11) {
        this.strict = z11;
    }

    public void s() {
        this.parsed.add(currentParsed().a());
    }

    public boolean t(CharSequence charSequence, int i11, CharSequence charSequence2, int i12, int i13) {
        if (i11 + i13 > charSequence.length() || i12 + i13 > charSequence2.length()) {
            return false;
        }
        if (k()) {
            for (int i14 = 0; i14 < i13; i14++) {
                if (charSequence.charAt(i11 + i14) != charSequence2.charAt(i12 + i14)) {
                    return false;
                }
            }
            return true;
        }
        for (int i15 = 0; i15 < i13; i15++) {
            char charAt = charSequence.charAt(i11 + i15);
            char charAt2 = charSequence2.charAt(i12 + i15);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return currentParsed().toString();
    }

    public Parsed u() {
        return currentParsed();
    }

    public DateTimeParseContext(DateTimeParseContext dateTimeParseContext) {
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.locale = dateTimeParseContext.locale;
        this.symbols = dateTimeParseContext.symbols;
        this.overrideChronology = dateTimeParseContext.overrideChronology;
        this.overrideZone = dateTimeParseContext.overrideZone;
        this.caseSensitive = dateTimeParseContext.caseSensitive;
        this.strict = dateTimeParseContext.strict;
        arrayList.add(new Parsed());
    }
}
