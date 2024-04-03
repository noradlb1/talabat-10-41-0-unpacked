package org.apache.commons.lang3.time;

import com.adjust.sdk.Constants;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.lang3.Validate;

public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    public static class CharacterLiteral implements Rule {
        private final char mValue;

        public CharacterLiteral(char c11) {
            this.mValue = c11;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return 1;
        }
    }

    public interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i11);
    }

    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        public PaddedNumberField(int i11, int i12) {
            if (i12 >= 3) {
                this.mField = i11;
                this.mSize = i12;
                return;
            }
            throw new IllegalArgumentException();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }

        public final void appendTo(StringBuffer stringBuffer, int i11) {
            int i12;
            if (i11 < 100) {
                int i13 = this.mSize;
                while (true) {
                    i13--;
                    if (i13 >= 2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append((char) ((i11 / 10) + 48));
                        stringBuffer.append((char) ((i11 % 10) + 48));
                        return;
                    }
                }
            } else {
                if (i11 < 1000) {
                    i12 = 3;
                } else {
                    Validate.isTrue(i11 > -1, "Negative values should not be possible", (long) i11);
                    i12 = Integer.toString(i11).length();
                }
                int i14 = this.mSize;
                while (true) {
                    i14--;
                    if (i14 >= i12) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append(Integer.toString(i11));
                        return;
                    }
                }
            }
        }
    }

    public interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    public static class StringLiteral implements Rule {
        private final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return this.mValue.length();
        }
    }

    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        public TextField(int i11, String[] strArr) {
            this.mField = i11;
            this.mValues = strArr;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }

        public int estimateLength() {
            int length = this.mValues.length;
            int i11 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i11;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i11) {
                    i11 = length2;
                }
            }
        }
    }

    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z11, int i11, Locale locale) {
            this.mTimeZone = timeZone;
            if (z11) {
                this.mStyle = Integer.MIN_VALUE | i11;
            } else {
                this.mStyle = i11;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            if (!this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) || this.mStyle != timeZoneDisplayKey.mStyle || !this.mLocale.equals(timeZoneDisplayKey.mLocale)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }
    }

    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i11) {
            this.mLocale = locale;
            this.mStyle = i11;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i11, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i11, locale);
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            TimeZone timeZone = calendar.getTimeZone();
            if (!timeZone.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }

        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    public static class TimeZoneNumberRule implements Rule {

        /* renamed from: b  reason: collision with root package name */
        public static final TimeZoneNumberRule f27852b = new TimeZoneNumberRule(true);

        /* renamed from: c  reason: collision with root package name */
        public static final TimeZoneNumberRule f27853c = new TimeZoneNumberRule(false);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f27854a;

        public TimeZoneNumberRule(boolean z11) {
            this.f27854a = z11;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i11 = calendar.get(15) + calendar.get(16);
            if (i11 < 0) {
                stringBuffer.append(SignatureVisitor.SUPER);
                i11 = -i11;
            } else {
                stringBuffer.append(SignatureVisitor.EXTENDS);
            }
            int i12 = i11 / Constants.ONE_HOUR;
            stringBuffer.append((char) ((i12 / 10) + 48));
            stringBuffer.append((char) ((i12 % 10) + 48));
            if (this.f27854a) {
                stringBuffer.append(AbstractJsonLexerKt.COLON);
            }
            int i13 = (i11 / 60000) - (i12 * 60);
            stringBuffer.append((char) ((i13 / 10) + 48));
            stringBuffer.append((char) ((i13 % 10) + 48));
        }

        public int estimateLength() {
            return 5;
        }
    }

    public static class TwoDigitMonthField implements NumberRule {

        /* renamed from: a  reason: collision with root package name */
        public static final TwoDigitMonthField f27855a = new TwoDigitMonthField();

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i11) {
            stringBuffer.append((char) ((i11 / 10) + 48));
            stringBuffer.append((char) ((i11 % 10) + 48));
        }
    }

    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        public TwoDigitNumberField(int i11) {
            this.mField = i11;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i11) {
            if (i11 < 100) {
                stringBuffer.append((char) ((i11 / 10) + 48));
                stringBuffer.append((char) ((i11 % 10) + 48));
                return;
            }
            stringBuffer.append(Integer.toString(i11));
        }
    }

    public static class TwoDigitYearField implements NumberRule {

        /* renamed from: a  reason: collision with root package name */
        public static final TwoDigitYearField f27856a = new TwoDigitYearField();

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i11) {
            stringBuffer.append((char) ((i11 / 10) + 48));
            stringBuffer.append((char) ((i11 % 10) + 48));
        }
    }

    public static class UnpaddedMonthField implements NumberRule {

        /* renamed from: a  reason: collision with root package name */
        public static final UnpaddedMonthField f27857a = new UnpaddedMonthField();

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i11) {
            if (i11 < 10) {
                stringBuffer.append((char) (i11 + 48));
                return;
            }
            stringBuffer.append((char) ((i11 / 10) + 48));
            stringBuffer.append((char) ((i11 % 10) + 48));
        }
    }

    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        public UnpaddedNumberField(int i11) {
            this.mField = i11;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }

        public final void appendTo(StringBuffer stringBuffer, int i11) {
            if (i11 < 10) {
                stringBuffer.append((char) (i11 + 48));
            } else if (i11 < 100) {
                stringBuffer.append((char) ((i11 / 10) + 48));
                stringBuffer.append((char) ((i11 % 10) + 48));
            } else {
                stringBuffer.append(Integer.toString(i11));
            }
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    private String applyRulesToString(Calendar calendar) {
        return applyRules(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z11, int i11, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z11, i11, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z11, i11, locale);
        String putIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return displayName;
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i11 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i11 += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i11;
                return;
            }
        }
    }

    private GregorianCalendar newCalendar() {
        return new GregorianCalendar(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule appendTo : this.mRules) {
            appendTo.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        if (!this.mPattern.equals(fastDatePrinter.mPattern) || !this.mTimeZone.equals(fastDatePrinter.mTimeZone) || !this.mLocale.equals(fastDatePrinter.mLocale)) {
            return false;
        }
        return true;
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown class: ");
        sb2.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0099, code lost:
        r11 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<org.apache.commons.lang3.time.FastDatePrinter.Rule> parsePattern() {
        /*
            r16 = this;
            r0 = r16
            java.text.DateFormatSymbols r1 = new java.text.DateFormatSymbols
            java.util.Locale r2 = r0.mLocale
            r1.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String[] r3 = r1.getEras()
            java.lang.String[] r4 = r1.getMonths()
            java.lang.String[] r5 = r1.getShortMonths()
            java.lang.String[] r6 = r1.getWeekdays()
            java.lang.String[] r7 = r1.getShortWeekdays()
            java.lang.String[] r1 = r1.getAmPmStrings()
            java.lang.String r8 = r0.mPattern
            int r8 = r8.length()
            r9 = 1
            int[] r10 = new int[r9]
            r11 = 0
            r12 = r11
        L_0x0031:
            if (r12 >= r8) goto L_0x015f
            r10[r11] = r12
            java.lang.String r12 = r0.mPattern
            java.lang.String r12 = r0.parseToken(r12, r10)
            r13 = r10[r11]
            int r14 = r12.length()
            if (r14 != 0) goto L_0x0045
            goto L_0x015f
        L_0x0045:
            char r15 = r12.charAt(r11)
            r9 = 121(0x79, float:1.7E-43)
            r11 = 4
            if (r15 == r9) goto L_0x0147
            r9 = 122(0x7a, float:1.71E-43)
            if (r15 == r9) goto L_0x012b
            r9 = 11
            switch(r15) {
                case 39: goto L_0x010d;
                case 75: goto L_0x0106;
                case 77: goto L_0x00eb;
                case 83: goto L_0x00e4;
                case 87: goto L_0x00df;
                case 90: goto L_0x00d6;
                case 97: goto L_0x00ce;
                case 100: goto L_0x00c8;
                case 104: goto L_0x00bc;
                case 107: goto L_0x00b2;
                case 109: goto L_0x00ab;
                case 115: goto L_0x00a4;
                case 119: goto L_0x009e;
                default: goto L_0x0057;
            }
        L_0x0057:
            switch(r15) {
                case 68: goto L_0x0094;
                case 69: goto L_0x0088;
                case 70: goto L_0x0081;
                case 71: goto L_0x0076;
                case 72: goto L_0x0071;
                default: goto L_0x005a;
            }
        L_0x005a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Illegal pattern component: "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0071:
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x0076:
            org.apache.commons.lang3.time.FastDatePrinter$TextField r9 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r11 = 0
            r9.<init>(r11, r3)
            r15 = r11
        L_0x007d:
            r11 = r9
            r9 = 1
            goto L_0x0157
        L_0x0081:
            r9 = 8
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x0088:
            org.apache.commons.lang3.time.FastDatePrinter$TextField r9 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            if (r14 >= r11) goto L_0x008e
            r11 = r7
            goto L_0x008f
        L_0x008e:
            r11 = r6
        L_0x008f:
            r12 = 7
            r9.<init>(r12, r11)
            goto L_0x0099
        L_0x0094:
            r9 = 6
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
        L_0x0099:
            r11 = r9
        L_0x009a:
            r9 = 1
        L_0x009b:
            r15 = 0
            goto L_0x0157
        L_0x009e:
            r9 = 3
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x00a4:
            r9 = 13
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x00ab:
            r9 = 12
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x00b2:
            org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField r11 = new org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            r11.<init>(r9)
            goto L_0x009a
        L_0x00bc:
            org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField r9 = new org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField
            r11 = 10
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r14)
            r9.<init>(r11)
            goto L_0x0099
        L_0x00c8:
            r9 = 5
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x00ce:
            org.apache.commons.lang3.time.FastDatePrinter$TextField r9 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r11 = 9
            r9.<init>(r11, r1)
            goto L_0x0099
        L_0x00d6:
            r9 = 1
            if (r14 != r9) goto L_0x00dc
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule r9 = org.apache.commons.lang3.time.FastDatePrinter.TimeZoneNumberRule.f27853c
            goto L_0x0099
        L_0x00dc:
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule r9 = org.apache.commons.lang3.time.FastDatePrinter.TimeZoneNumberRule.f27852b
            goto L_0x0099
        L_0x00df:
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r11, r14)
            goto L_0x0099
        L_0x00e4:
            r9 = 14
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x00eb:
            if (r14 < r11) goto L_0x00f4
            org.apache.commons.lang3.time.FastDatePrinter$TextField r9 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r11 = 2
            r9.<init>(r11, r4)
            goto L_0x0099
        L_0x00f4:
            r9 = 3
            r11 = 2
            if (r14 != r9) goto L_0x00fe
            org.apache.commons.lang3.time.FastDatePrinter$TextField r9 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r9.<init>(r11, r5)
            goto L_0x0099
        L_0x00fe:
            if (r14 != r11) goto L_0x0103
            org.apache.commons.lang3.time.FastDatePrinter$TwoDigitMonthField r9 = org.apache.commons.lang3.time.FastDatePrinter.TwoDigitMonthField.f27855a
            goto L_0x0099
        L_0x0103:
            org.apache.commons.lang3.time.FastDatePrinter$UnpaddedMonthField r9 = org.apache.commons.lang3.time.FastDatePrinter.UnpaddedMonthField.f27857a
            goto L_0x0099
        L_0x0106:
            r9 = 10
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r9 = r0.selectNumberRule(r9, r14)
            goto L_0x0099
        L_0x010d:
            r9 = 1
            java.lang.String r11 = r12.substring(r9)
            int r12 = r11.length()
            if (r12 != r9) goto L_0x0124
            org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral r9 = new org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral
            r12 = 0
            char r11 = r11.charAt(r12)
            r9.<init>(r11)
            goto L_0x0099
        L_0x0124:
            org.apache.commons.lang3.time.FastDatePrinter$StringLiteral r9 = new org.apache.commons.lang3.time.FastDatePrinter$StringLiteral
            r9.<init>(r11)
            goto L_0x0099
        L_0x012b:
            if (r14 < r11) goto L_0x013b
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule r9 = new org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule
            java.util.TimeZone r11 = r0.mTimeZone
            java.util.Locale r12 = r0.mLocale
            r14 = 1
            r9.<init>(r11, r12, r14)
            r11 = r9
            r9 = r14
            goto L_0x009b
        L_0x013b:
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule r9 = new org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule
            java.util.TimeZone r11 = r0.mTimeZone
            java.util.Locale r12 = r0.mLocale
            r15 = 0
            r9.<init>(r11, r12, r15)
            goto L_0x007d
        L_0x0147:
            r9 = 2
            r15 = 0
            if (r14 != r9) goto L_0x014f
            org.apache.commons.lang3.time.FastDatePrinter$TwoDigitYearField r9 = org.apache.commons.lang3.time.FastDatePrinter.TwoDigitYearField.f27856a
            goto L_0x007d
        L_0x014f:
            if (r14 >= r11) goto L_0x0152
            r14 = r11
        L_0x0152:
            r9 = 1
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r9, r14)
        L_0x0157:
            r2.add(r11)
            int r12 = r13 + 1
            r11 = r15
            goto L_0x0031
        L_0x015f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDatePrinter.parsePattern():java.util.List");
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i11);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb2.append(charAt);
            while (true) {
                int i12 = i11 + 1;
                if (i12 >= length || str.charAt(i12) != charAt) {
                    break;
                }
                sb2.append(charAt);
                i11 = i12;
            }
        } else {
            sb2.append('\'');
            boolean z11 = false;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                char charAt2 = str.charAt(i11);
                if (charAt2 == '\'') {
                    int i13 = i11 + 1;
                    if (i13 >= length || str.charAt(i13) != '\'') {
                        z11 = !z11;
                    } else {
                        sb2.append(charAt2);
                        i11 = i13;
                    }
                } else if (z11 || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb2.append(charAt2);
                }
                i11++;
            }
            i11--;
        }
        iArr[0] = i11;
        return sb2.toString();
    }

    public NumberRule selectNumberRule(int i11, int i12) {
        if (i12 == 1) {
            return new UnpaddedNumberField(i11);
        }
        if (i12 != 2) {
            return new PaddedNumberField(i11, i12);
        }
        return new TwoDigitNumberField(i11);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i11 = calendar.get(10);
            if (i11 == 0) {
                i11 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, i11);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, int i11) {
            this.mRule.appendTo(stringBuffer, i11);
        }
    }

    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i11 = calendar.get(11);
            if (i11 == 0) {
                i11 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, i11);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, int i11) {
            this.mRule.appendTo(stringBuffer, i11);
        }
    }

    public String format(long j11) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j11);
        return applyRulesToString(newCalendar);
    }

    public String format(Date date) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(long j11, StringBuffer stringBuffer) {
        return format(new Date(j11), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRules(newCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return applyRules(calendar, stringBuffer);
    }
}
