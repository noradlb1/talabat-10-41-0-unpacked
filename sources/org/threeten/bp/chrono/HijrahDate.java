package org.threeten.bp.chrono;

import com.apptimize.bp;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import datamodels.TypesAliasesKt;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.bytebuddy.jar.asm.Opcodes;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class HijrahDate extends ChronoDateImpl<HijrahDate> {
    private static final Long[] ADJUSTED_CYCLES = new Long[MAX_ADJUSTED_CYCLE];
    private static final HashMap<Integer, Integer[]> ADJUSTED_CYCLE_YEARS = new HashMap<>();
    private static final Integer[] ADJUSTED_LEAST_MAX_VALUES = new Integer[LEAST_MAX_VALUES.length];
    private static final Integer[] ADJUSTED_MAX_VALUES = new Integer[MAX_VALUES.length];
    private static final Integer[] ADJUSTED_MIN_VALUES = new Integer[MIN_VALUES.length];
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_DAYS = new HashMap<>();
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_LENGTHS = new HashMap<>();
    private static final int[] CYCLEYEAR_START_DATE = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
    private static final String DEFAULT_CONFIG_FILENAME = "hijrah_deviation.cfg";
    private static final String DEFAULT_CONFIG_PATH;
    private static final Integer[] DEFAULT_CYCLE_YEARS = new Integer[CYCLEYEAR_START_DATE.length];
    private static final Integer[] DEFAULT_LEAP_MONTH_DAYS = new Integer[LEAP_NUM_DAYS.length];
    private static final Integer[] DEFAULT_LEAP_MONTH_LENGTHS = new Integer[LEAP_MONTH_LENGTH.length];
    private static final Integer[] DEFAULT_MONTH_DAYS;
    private static final Integer[] DEFAULT_MONTH_LENGTHS = new Integer[MONTH_LENGTH.length];
    private static final char FILE_SEP;
    private static final int HIJRAH_JAN_1_1_GREGORIAN_DAY = -492148;
    private static final int[] LEAP_MONTH_LENGTH = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
    private static final int[] LEAP_NUM_DAYS = {0, 30, 59, 89, 118, 148, Opcodes.RETURN, 207, 236, 266, 295, 325};
    private static final int[] LEAST_MAX_VALUES = {1, 9999, 11, 51, 5, 29, 354};
    private static final int MAX_ADJUSTED_CYCLE = 334;
    private static final int[] MAX_VALUES = {1, 9999, 11, 52, 6, 30, 355};
    public static final int MAX_VALUE_OF_ERA = 9999;
    private static final int[] MIN_VALUES = {0, 1, 0, 1, 0, 1, 1};
    public static final int MIN_VALUE_OF_ERA = 1;
    private static final int[] MONTH_LENGTH = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
    private static final int[] NUM_DAYS;
    private static final String PATH_SEP = File.pathSeparator;
    private static final int POSITION_DAY_OF_MONTH = 5;
    private static final int POSITION_DAY_OF_YEAR = 6;
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient int dayOfMonth;
    private final transient DayOfWeek dayOfWeek;
    private final transient int dayOfYear;
    private final transient HijrahEra era;
    private final long gregorianEpochDay;
    private final transient boolean isLeapYear;
    private final transient int monthOfYear;
    private final transient int yearOfEra;

    /* renamed from: org.threeten.bp.chrono.HijrahDate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63336a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63336a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f63336a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        int[] iArr = {0, 30, 59, 89, 118, 148, Opcodes.RETURN, 207, 236, 266, 295, 325};
        NUM_DAYS = iArr;
        char c11 = File.separatorChar;
        FILE_SEP = c11;
        DEFAULT_CONFIG_PATH = "org" + c11 + "threeten" + c11 + bp.f41399a + c11 + "chrono";
        DEFAULT_MONTH_DAYS = new Integer[iArr.length];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int[] iArr2 = NUM_DAYS;
            if (i12 >= iArr2.length) {
                break;
            }
            DEFAULT_MONTH_DAYS[i12] = Integer.valueOf(iArr2[i12]);
            i12++;
        }
        int i13 = 0;
        while (true) {
            int[] iArr3 = LEAP_NUM_DAYS;
            if (i13 >= iArr3.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_DAYS[i13] = Integer.valueOf(iArr3[i13]);
            i13++;
        }
        int i14 = 0;
        while (true) {
            int[] iArr4 = MONTH_LENGTH;
            if (i14 >= iArr4.length) {
                break;
            }
            DEFAULT_MONTH_LENGTHS[i14] = Integer.valueOf(iArr4[i14]);
            i14++;
        }
        int i15 = 0;
        while (true) {
            int[] iArr5 = LEAP_MONTH_LENGTH;
            if (i15 >= iArr5.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_LENGTHS[i15] = Integer.valueOf(iArr5[i15]);
            i15++;
        }
        int i16 = 0;
        while (true) {
            int[] iArr6 = CYCLEYEAR_START_DATE;
            if (i16 >= iArr6.length) {
                break;
            }
            DEFAULT_CYCLE_YEARS[i16] = Integer.valueOf(iArr6[i16]);
            i16++;
        }
        int i17 = 0;
        while (true) {
            Long[] lArr = ADJUSTED_CYCLES;
            if (i17 >= lArr.length) {
                break;
            }
            lArr[i17] = Long.valueOf((long) (i17 * 10631));
            i17++;
        }
        int i18 = 0;
        while (true) {
            int[] iArr7 = MIN_VALUES;
            if (i18 >= iArr7.length) {
                break;
            }
            ADJUSTED_MIN_VALUES[i18] = Integer.valueOf(iArr7[i18]);
            i18++;
        }
        int i19 = 0;
        while (true) {
            int[] iArr8 = LEAST_MAX_VALUES;
            if (i19 >= iArr8.length) {
                break;
            }
            ADJUSTED_LEAST_MAX_VALUES[i19] = Integer.valueOf(iArr8[i19]);
            i19++;
        }
        while (true) {
            int[] iArr9 = MAX_VALUES;
            if (i11 < iArr9.length) {
                ADJUSTED_MAX_VALUES[i11] = Integer.valueOf(iArr9[i11]);
                i11++;
            } else {
                try {
                    readDeviationConfig();
                    return;
                } catch (IOException | ParseException unused) {
                    return;
                }
            }
        }
    }

    private HijrahDate(long j11) {
        int[] hijrahDateInfo = getHijrahDateInfo(j11);
        checkValidYearOfEra(hijrahDateInfo[1]);
        checkValidMonth(hijrahDateInfo[2]);
        checkValidDayOfMonth(hijrahDateInfo[3]);
        checkValidDayOfYear(hijrahDateInfo[4]);
        this.era = HijrahEra.of(hijrahDateInfo[0]);
        int i11 = hijrahDateInfo[1];
        this.yearOfEra = i11;
        this.monthOfYear = hijrahDateInfo[2];
        this.dayOfMonth = hijrahDateInfo[3];
        this.dayOfYear = hijrahDateInfo[4];
        this.dayOfWeek = DayOfWeek.of(hijrahDateInfo[5]);
        this.gregorianEpochDay = j11;
        this.isLeapYear = isLeapYear((long) i11);
    }

    private static void addDeviationAsHijrah(int i11, int i12, int i13, int i14, int i15) {
        int i16 = i11;
        int i17 = i12;
        int i18 = i13;
        int i19 = i14;
        int i21 = i15;
        if (i16 < 1) {
            throw new IllegalArgumentException("startYear < 1");
        } else if (i18 < 1) {
            throw new IllegalArgumentException("endYear < 1");
        } else if (i17 < 0 || i17 > 11) {
            throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
        } else if (i19 < 0 || i19 > 11) {
            throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
        } else if (i18 > 9999) {
            throw new IllegalArgumentException("endYear > 9999");
        } else if (i18 < i16) {
            throw new IllegalArgumentException("startYear > endYear");
        } else if (i18 != i16 || i19 >= i17) {
            boolean isLeapYear2 = isLeapYear((long) i16);
            Integer[] numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i11));
            if (numArr == null) {
                if (!isLeapYear2) {
                    numArr = new Integer[NUM_DAYS.length];
                    int i22 = 0;
                    while (true) {
                        int[] iArr = NUM_DAYS;
                        if (i22 >= iArr.length) {
                            break;
                        }
                        numArr[i22] = Integer.valueOf(iArr[i22]);
                        i22++;
                    }
                } else {
                    numArr = new Integer[LEAP_NUM_DAYS.length];
                    int i23 = 0;
                    while (true) {
                        int[] iArr2 = LEAP_NUM_DAYS;
                        if (i23 >= iArr2.length) {
                            break;
                        }
                        numArr[i23] = Integer.valueOf(iArr2[i23]);
                        i23++;
                    }
                }
            }
            Integer[] numArr2 = new Integer[numArr.length];
            for (int i24 = 0; i24 < 12; i24++) {
                if (i24 > i17) {
                    numArr2[i24] = Integer.valueOf(numArr[i24].intValue() - i21);
                } else {
                    numArr2[i24] = Integer.valueOf(numArr[i24].intValue());
                }
            }
            ADJUSTED_MONTH_DAYS.put(Integer.valueOf(i11), numArr2);
            Integer[] numArr3 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i11));
            if (numArr3 == null) {
                if (!isLeapYear2) {
                    numArr3 = new Integer[MONTH_LENGTH.length];
                    int i25 = 0;
                    while (true) {
                        int[] iArr3 = MONTH_LENGTH;
                        if (i25 >= iArr3.length) {
                            break;
                        }
                        numArr3[i25] = Integer.valueOf(iArr3[i25]);
                        i25++;
                    }
                } else {
                    numArr3 = new Integer[LEAP_MONTH_LENGTH.length];
                    int i26 = 0;
                    while (true) {
                        int[] iArr4 = LEAP_MONTH_LENGTH;
                        if (i26 >= iArr4.length) {
                            break;
                        }
                        numArr3[i26] = Integer.valueOf(iArr4[i26]);
                        i26++;
                    }
                }
            }
            Integer[] numArr4 = new Integer[numArr3.length];
            for (int i27 = 0; i27 < 12; i27++) {
                if (i27 == i17) {
                    numArr4[i27] = Integer.valueOf(numArr3[i27].intValue() - i21);
                } else {
                    numArr4[i27] = Integer.valueOf(numArr3[i27].intValue());
                }
            }
            ADJUSTED_MONTH_LENGTHS.put(Integer.valueOf(i11), numArr4);
            if (i16 != i18) {
                int i28 = i16 - 1;
                int i29 = i28 / 30;
                int i31 = i28 % 30;
                Integer[] numArr5 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i29));
                if (numArr5 == null) {
                    int length = CYCLEYEAR_START_DATE.length;
                    Integer[] numArr6 = new Integer[length];
                    for (int i32 = 0; i32 < length; i32++) {
                        numArr6[i32] = Integer.valueOf(CYCLEYEAR_START_DATE[i32]);
                    }
                    numArr5 = numArr6;
                }
                for (int i33 = i31 + 1; i33 < CYCLEYEAR_START_DATE.length; i33++) {
                    numArr5[i33] = Integer.valueOf(numArr5[i33].intValue() - i21);
                }
                ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i29), numArr5);
                int i34 = i18 - 1;
                int i35 = i34 / 30;
                if (i29 != i35) {
                    int i36 = i29 + 1;
                    while (true) {
                        Long[] lArr = ADJUSTED_CYCLES;
                        if (i36 >= lArr.length) {
                            break;
                        }
                        lArr[i36] = Long.valueOf(lArr[i36].longValue() - ((long) i21));
                        i36++;
                    }
                    int i37 = i35 + 1;
                    while (true) {
                        Long[] lArr2 = ADJUSTED_CYCLES;
                        if (i37 >= lArr2.length) {
                            break;
                        }
                        lArr2[i37] = Long.valueOf(lArr2[i37].longValue() + ((long) i21));
                        i37++;
                        i35 = i35;
                    }
                }
                int i38 = i35;
                int i39 = i34 % 30;
                Integer[] numArr7 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i38));
                if (numArr7 == null) {
                    int length2 = CYCLEYEAR_START_DATE.length;
                    Integer[] numArr8 = new Integer[length2];
                    for (int i41 = 0; i41 < length2; i41++) {
                        numArr8[i41] = Integer.valueOf(CYCLEYEAR_START_DATE[i41]);
                    }
                    numArr7 = numArr8;
                }
                for (int i42 = i39 + 1; i42 < CYCLEYEAR_START_DATE.length; i42++) {
                    numArr7[i42] = Integer.valueOf(numArr7[i42].intValue() + i21);
                }
                ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i38), numArr7);
            }
            boolean isLeapYear3 = isLeapYear((long) i18);
            Integer[] numArr9 = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i13));
            if (numArr9 == null) {
                if (!isLeapYear3) {
                    numArr9 = new Integer[NUM_DAYS.length];
                    int i43 = 0;
                    while (true) {
                        int[] iArr5 = NUM_DAYS;
                        if (i43 >= iArr5.length) {
                            break;
                        }
                        numArr9[i43] = Integer.valueOf(iArr5[i43]);
                        i43++;
                    }
                } else {
                    numArr9 = new Integer[LEAP_NUM_DAYS.length];
                    int i44 = 0;
                    while (true) {
                        int[] iArr6 = LEAP_NUM_DAYS;
                        if (i44 >= iArr6.length) {
                            break;
                        }
                        numArr9[i44] = Integer.valueOf(iArr6[i44]);
                        i44++;
                    }
                }
            }
            Integer[] numArr10 = new Integer[numArr9.length];
            for (int i45 = 0; i45 < 12; i45++) {
                if (i45 > i19) {
                    numArr10[i45] = Integer.valueOf(numArr9[i45].intValue() + i21);
                } else {
                    numArr10[i45] = Integer.valueOf(numArr9[i45].intValue());
                }
            }
            ADJUSTED_MONTH_DAYS.put(Integer.valueOf(i13), numArr10);
            Integer[] numArr11 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i13));
            if (numArr11 == null) {
                if (!isLeapYear3) {
                    numArr11 = new Integer[MONTH_LENGTH.length];
                    int i46 = 0;
                    while (true) {
                        int[] iArr7 = MONTH_LENGTH;
                        if (i46 >= iArr7.length) {
                            break;
                        }
                        numArr11[i46] = Integer.valueOf(iArr7[i46]);
                        i46++;
                    }
                } else {
                    numArr11 = new Integer[LEAP_MONTH_LENGTH.length];
                    int i47 = 0;
                    while (true) {
                        int[] iArr8 = LEAP_MONTH_LENGTH;
                        if (i47 >= iArr8.length) {
                            break;
                        }
                        numArr11[i47] = Integer.valueOf(iArr8[i47]);
                        i47++;
                    }
                }
            }
            Integer[] numArr12 = new Integer[numArr11.length];
            for (int i48 = 0; i48 < 12; i48++) {
                if (i48 == i19) {
                    numArr12[i48] = Integer.valueOf(numArr11[i48].intValue() + i21);
                } else {
                    numArr12[i48] = Integer.valueOf(numArr11[i48].intValue());
                }
            }
            HashMap<Integer, Integer[]> hashMap = ADJUSTED_MONTH_LENGTHS;
            hashMap.put(Integer.valueOf(i13), numArr12);
            Integer[] numArr13 = hashMap.get(Integer.valueOf(i11));
            Integer[] numArr14 = hashMap.get(Integer.valueOf(i13));
            HashMap<Integer, Integer[]> hashMap2 = ADJUSTED_MONTH_DAYS;
            int intValue = numArr13[i17].intValue();
            int intValue2 = numArr14[i19].intValue();
            int intValue3 = hashMap2.get(Integer.valueOf(i11))[11].intValue() + numArr13[11].intValue();
            int intValue4 = hashMap2.get(Integer.valueOf(i13))[11].intValue() + numArr14[11].intValue();
            Integer[] numArr15 = ADJUSTED_MAX_VALUES;
            int intValue5 = numArr15[5].intValue();
            Integer[] numArr16 = ADJUSTED_LEAST_MAX_VALUES;
            int intValue6 = numArr16[5].intValue();
            if (intValue5 < intValue) {
                intValue5 = intValue;
            }
            if (intValue5 < intValue2) {
                intValue5 = intValue2;
            }
            numArr15[5] = Integer.valueOf(intValue5);
            if (intValue6 <= intValue) {
                intValue = intValue6;
            }
            if (intValue <= intValue2) {
                intValue2 = intValue;
            }
            numArr16[5] = Integer.valueOf(intValue2);
            int intValue7 = numArr15[6].intValue();
            int intValue8 = numArr16[6].intValue();
            if (intValue7 < intValue3) {
                intValue7 = intValue3;
            }
            if (intValue7 < intValue4) {
                intValue7 = intValue4;
            }
            numArr15[6] = Integer.valueOf(intValue7);
            if (intValue8 <= intValue3) {
                intValue3 = intValue8;
            }
            if (intValue3 <= intValue4) {
                intValue4 = intValue3;
            }
            numArr16[6] = Integer.valueOf(intValue4);
        } else {
            throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
        }
    }

    private static void checkValidDayOfMonth(int i11) {
        if (i11 < 1 || i11 > d()) {
            throw new DateTimeException("Invalid day of month of Hijrah date, day " + i11 + " greater than " + d() + " or less than 1");
        }
    }

    private static void checkValidDayOfYear(int i11) {
        if (i11 < 1 || i11 > e()) {
            throw new DateTimeException("Invalid day of year of Hijrah date");
        }
    }

    private static void checkValidMonth(int i11) {
        if (i11 < 1 || i11 > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        }
    }

    private static void checkValidYearOfEra(int i11) {
        if (i11 < 1 || i11 > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        }
    }

    public static int d() {
        return ADJUSTED_MAX_VALUES[5].intValue();
    }

    public static int e() {
        return ADJUSTED_MAX_VALUES[6].intValue();
    }

    public static int f(int i11, int i12) {
        return getAdjustedMonthLength(i12)[i11].intValue();
    }

    public static HijrahDate from(TemporalAccessor temporalAccessor) {
        return HijrahChronology.INSTANCE.date(temporalAccessor);
    }

    public static int g(int i11) {
        Integer[] numArr;
        int i12 = i11 - 1;
        int i13 = i12 / 30;
        try {
            numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i13));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            int i14 = i12 % 30;
            if (i14 != 29) {
                return numArr[i14 + 1].intValue() - numArr[i14].intValue();
            }
            Long[] lArr = ADJUSTED_CYCLES;
            return (lArr[i13 + 1].intValue() - lArr[i13].intValue()) - numArr[i14].intValue();
        } else if (isLeapYear((long) i11)) {
            return 355;
        } else {
            return 354;
        }
    }

    private static Integer[] getAdjustedCycle(int i11) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i11));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr == null) {
            return DEFAULT_CYCLE_YEARS;
        }
        return numArr;
    }

    private static Integer[] getAdjustedMonthDays(int i11) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i11));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            return numArr;
        }
        if (isLeapYear((long) i11)) {
            return DEFAULT_LEAP_MONTH_DAYS;
        }
        return DEFAULT_MONTH_DAYS;
    }

    private static Integer[] getAdjustedMonthLength(int i11) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i11));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            return numArr;
        }
        if (isLeapYear((long) i11)) {
            return DEFAULT_LEAP_MONTH_LENGTHS;
        }
        return DEFAULT_MONTH_LENGTHS;
    }

    private static InputStream getConfigFileInputStream() throws IOException {
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = DEFAULT_CONFIG_FILENAME;
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        if (property2 != null) {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                property2 = property2 + System.getProperty("file.separator");
            }
            File file = new File(property2 + FILE_SEP + property);
            if (!file.exists()) {
                return null;
            }
            try {
                return new FileInputStream(file);
            } catch (IOException e11) {
                throw e11;
            }
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), PATH_SEP);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                File file2 = new File(nextToken);
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(nextToken);
                        char c11 = FILE_SEP;
                        sb2.append(c11);
                        String str = DEFAULT_CONFIG_PATH;
                        sb2.append(str);
                        if (new File(sb2.toString(), property).exists()) {
                            try {
                                return new FileInputStream(nextToken + c11 + str + c11 + property);
                            } catch (IOException e12) {
                                throw e12;
                            }
                        }
                    } else {
                        try {
                            zipFile = new ZipFile(file2);
                        } catch (IOException unused) {
                            zipFile = null;
                        }
                        if (zipFile != null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(DEFAULT_CONFIG_PATH);
                            char c12 = FILE_SEP;
                            sb3.append(c12);
                            sb3.append(property);
                            String sb4 = sb3.toString();
                            ZipEntry entry = zipFile.getEntry(sb4);
                            if (entry == null) {
                                if (c12 == '/') {
                                    sb4 = sb4.replace('/', '\\');
                                } else if (c12 == '\\') {
                                    sb4 = sb4.replace('\\', '/');
                                }
                                entry = zipFile.getEntry(sb4);
                            }
                            if (entry != null) {
                                try {
                                    return zipFile.getInputStream(entry);
                                } catch (IOException e13) {
                                    throw e13;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return null;
        }
    }

    private static int getCycleNumber(long j11) {
        Long[] lArr = ADJUSTED_CYCLES;
        int i11 = 0;
        while (i11 < lArr.length) {
            try {
                if (j11 < lArr[i11].longValue()) {
                    return i11 - 1;
                }
                i11++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                return ((int) j11) / 10631;
            }
        }
        return ((int) j11) / 10631;
    }

    private static int getDayOfCycle(long j11, int i11) {
        Long l11;
        try {
            l11 = ADJUSTED_CYCLES[i11];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l11 = null;
        }
        if (l11 == null) {
            l11 = Long.valueOf((long) (i11 * 10631));
        }
        return (int) (j11 - l11.longValue());
    }

    private static int getDayOfMonth(int i11, int i12, int i13) {
        int intValue;
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i13);
        if (i11 < 0) {
            if (isLeapYear((long) i13)) {
                i11 += 355;
            } else {
                i11 += 354;
            }
            if (i12 <= 0) {
                return i11;
            }
            intValue = adjustedMonthDays[i12].intValue();
        } else if (i12 <= 0) {
            return i11;
        } else {
            intValue = adjustedMonthDays[i12].intValue();
        }
        return i11 - intValue;
    }

    private static int getDayOfYear(int i11, int i12, int i13) {
        Integer[] adjustedCycle = getAdjustedCycle(i11);
        if (i12 > 0) {
            return i12 - adjustedCycle[i13].intValue();
        }
        return adjustedCycle[i13].intValue() + i12;
    }

    private static long getGregorianEpochDay(int i11, int i12, int i13) {
        return yearToGregorianEpochDay(i11) + ((long) getMonthDays(i12 - 1, i11)) + ((long) i13);
    }

    private static int[] getHijrahDateInfo(long j11) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        long j12 = j11 - -492148;
        if (j12 >= 0) {
            int cycleNumber = getCycleNumber(j12);
            int dayOfCycle = getDayOfCycle(j12, cycleNumber);
            int yearInCycle = getYearInCycle(cycleNumber, (long) dayOfCycle);
            i14 = getDayOfYear(cycleNumber, dayOfCycle, yearInCycle);
            i15 = (cycleNumber * 30) + yearInCycle + 1;
            i13 = getMonthOfYear(i14, i15);
            i12 = getDayOfMonth(i14, i13, i15) + 1;
            i11 = HijrahEra.AH.getValue();
        } else {
            int i18 = (int) j12;
            int i19 = i18 / 10631;
            int i21 = i18 % 10631;
            if (i21 == 0) {
                i19++;
                i21 = -10631;
            }
            int yearInCycle2 = getYearInCycle(i19, (long) i21);
            int dayOfYear2 = getDayOfYear(i19, i21, yearInCycle2);
            int i22 = 1 - ((i19 * 30) - yearInCycle2);
            if (isLeapYear((long) i22)) {
                i17 = dayOfYear2 + 355;
            } else {
                i17 = dayOfYear2 + 354;
            }
            i13 = getMonthOfYear(i17, i22);
            i12 = getDayOfMonth(i17, i13, i22) + 1;
            i11 = HijrahEra.BEFORE_AH.getValue();
            int i23 = i22;
            i14 = i17;
            i15 = i23;
        }
        int i24 = (int) ((j12 + 5) % 7);
        if (i24 <= 0) {
            i16 = 7;
        } else {
            i16 = 0;
        }
        return new int[]{i11, i15, i13 + 1, i12, i14 + 1, i24 + i16};
    }

    private static int getMonthDays(int i11, int i12) {
        return getAdjustedMonthDays(i12)[i11].intValue();
    }

    private static int getMonthOfYear(int i11, int i12) {
        int i13;
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i12);
        int i14 = 0;
        if (i11 >= 0) {
            while (i14 < adjustedMonthDays.length) {
                if (i11 < adjustedMonthDays[i14].intValue()) {
                    return i14 - 1;
                }
                i14++;
            }
            return 11;
        }
        if (isLeapYear((long) i12)) {
            i13 = i11 + 355;
        } else {
            i13 = i11 + 354;
        }
        while (i14 < adjustedMonthDays.length) {
            if (i13 < adjustedMonthDays[i14].intValue()) {
                return i14 - 1;
            }
            i14++;
        }
        return 11;
    }

    private static int getYearInCycle(int i11, long j11) {
        Integer[] adjustedCycle = getAdjustedCycle(i11);
        int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        int i13 = 0;
        if (i12 == 0) {
            return 0;
        }
        if (i12 > 0) {
            while (i13 < adjustedCycle.length) {
                if (j11 < ((long) adjustedCycle[i13].intValue())) {
                    return i13 - 1;
                }
                i13++;
            }
            return 29;
        }
        long j12 = -j11;
        while (i13 < adjustedCycle.length) {
            if (j12 <= ((long) adjustedCycle[i13].intValue())) {
                return i13 - 1;
            }
            i13++;
        }
        return 29;
    }

    public static HijrahDate h(LocalDate localDate) {
        return new HijrahDate(localDate.toEpochDay());
    }

    public static HijrahDate i(HijrahEra hijrahEra, int i11, int i12, int i13) {
        Jdk8Methods.requireNonNull(hijrahEra, "era");
        checkValidYearOfEra(i11);
        checkValidMonth(i12);
        checkValidDayOfMonth(i13);
        return new HijrahDate(getGregorianEpochDay(hijrahEra.a(i11), i12, i13));
    }

    public static HijrahDate j(long j11) {
        return new HijrahDate(j11);
    }

    public static ChronoLocalDate n(DataInput dataInput) throws IOException {
        return HijrahChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    public static HijrahDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static HijrahDate of(int i11, int i12, int i13) {
        if (i11 >= 1) {
            return i(HijrahEra.AH, i11, i12, i13);
        }
        return i(HijrahEra.BEFORE_AH, 1 - i11, i12, i13);
    }

    private static void parseLine(String str, int i11) throws ParseException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, TypesAliasesKt.separator);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(58);
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(nextToken.substring(indexOf + 1, nextToken.length()));
                    int indexOf2 = nextToken.indexOf(45);
                    if (indexOf2 != -1) {
                        String substring = nextToken.substring(0, indexOf2);
                        String substring2 = nextToken.substring(indexOf2 + 1, indexOf);
                        int indexOf3 = substring.indexOf(47);
                        int indexOf4 = substring2.indexOf(47);
                        if (indexOf3 != -1) {
                            String substring3 = substring.substring(0, indexOf3);
                            String substring4 = substring.substring(indexOf3 + 1, substring.length());
                            try {
                                int parseInt2 = Integer.parseInt(substring3);
                                try {
                                    int parseInt3 = Integer.parseInt(substring4);
                                    if (indexOf4 != -1) {
                                        String substring5 = substring2.substring(0, indexOf4);
                                        String substring6 = substring2.substring(indexOf4 + 1, substring2.length());
                                        try {
                                            int parseInt4 = Integer.parseInt(substring5);
                                            try {
                                                int parseInt5 = Integer.parseInt(substring6);
                                                if (parseInt2 == -1 || parseInt3 == -1 || parseInt4 == -1 || parseInt5 == -1) {
                                                    throw new ParseException("Unknown error at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                                                }
                                                addDeviationAsHijrah(parseInt2, parseInt3, parseInt4, parseInt5, parseInt);
                                            } catch (NumberFormatException unused) {
                                                throw new ParseException("End month is not properly set at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                                            }
                                        } catch (NumberFormatException unused2) {
                                            throw new ParseException("End year is not properly set at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                                        }
                                    } else {
                                        throw new ParseException("End year/month has incorrect format at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                                    }
                                } catch (NumberFormatException unused3) {
                                    throw new ParseException("Start month is not properly set at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                                }
                            } catch (NumberFormatException unused4) {
                                throw new ParseException("Start year is not properly set at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                            }
                        } else {
                            throw new ParseException("Start year/month has incorrect format at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                        }
                    } else {
                        throw new ParseException("Start and end year/month has incorrect format at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                    }
                } catch (NumberFormatException unused5) {
                    throw new ParseException("Offset is not properly set at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
                }
            } else {
                throw new ParseException("Offset has incorrect format at line " + i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, i11);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void readDeviationConfig() throws java.io.IOException, java.text.ParseException {
        /*
            java.io.InputStream r0 = getConfigFileInputStream()
            if (r0 == 0) goto L_0x0030
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0029 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0029 }
            r3.<init>(r0)     // Catch:{ all -> 0x0029 }
            r2.<init>(r3)     // Catch:{ all -> 0x0029 }
            r0 = 0
        L_0x0012:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0022
            int r0 = r0 + 1
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0026 }
            parseLine(r1, r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0012
        L_0x0022:
            r2.close()
            goto L_0x0030
        L_0x0026:
            r0 = move-exception
            r1 = r2
            goto L_0x002a
        L_0x0029:
            r0 = move-exception
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            throw r0
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.readDeviationConfig():void");
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    private static HijrahDate resolvePreviousValid(int i11, int i12, int i13) {
        int monthDays = getMonthDays(i12 - 1, i11);
        if (i13 > monthDays) {
            i13 = monthDays;
        }
        return of(i11, i12, i13);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private static long yearToGregorianEpochDay(int i11) {
        Long l11;
        int i12 = i11 - 1;
        int i13 = i12 / 30;
        int i14 = i12 % 30;
        int intValue = getAdjustedCycle(i13)[Math.abs(i14)].intValue();
        if (i14 < 0) {
            intValue = -intValue;
        }
        try {
            l11 = ADJUSTED_CYCLES[i13];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l11 = null;
        }
        if (l11 == null) {
            l11 = Long.valueOf((long) (i13 * 10631));
        }
        return ((l11.longValue() + ((long) intValue)) - 492148) - 1;
    }

    public final ChronoLocalDateTime<HijrahDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    public long getLong(TemporalField temporalField) {
        int i11;
        int i12;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        switch (AnonymousClass1.f63336a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                i11 = this.dayOfMonth;
                break;
            case 2:
                i11 = this.dayOfYear;
                break;
            case 3:
                i12 = (this.dayOfMonth - 1) / 7;
                break;
            case 4:
                i11 = this.yearOfEra;
                break;
            case 5:
                i11 = this.dayOfWeek.getValue();
                break;
            case 6:
                i12 = (this.dayOfMonth - 1) % 7;
                break;
            case 7:
                i12 = (this.dayOfYear - 1) % 7;
                break;
            case 8:
                return toEpochDay();
            case 9:
                i12 = (this.dayOfYear - 1) / 7;
                break;
            case 10:
                i11 = this.monthOfYear;
                break;
            case 11:
                i11 = this.yearOfEra;
                break;
            case 12:
                i11 = this.era.getValue();
                break;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        i11 = i12 + 1;
        return (long) i11;
    }

    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    /* renamed from: k */
    public HijrahDate a(long j11) {
        return new HijrahDate(this.gregorianEpochDay + j11);
    }

    /* renamed from: l */
    public HijrahDate b(long j11) {
        if (j11 == 0) {
            return this;
        }
        int i11 = (this.monthOfYear - 1) + ((int) j11);
        int i12 = i11 / 12;
        int i13 = i11 % 12;
        while (i13 < 0) {
            i13 += 12;
            i12 = Jdk8Methods.safeSubtract(i12, 1);
        }
        return i(this.era, Jdk8Methods.safeAdd(this.yearOfEra, i12), i13 + 1, this.dayOfMonth);
    }

    public int lengthOfMonth() {
        return f(this.monthOfYear - 1, this.yearOfEra);
    }

    public int lengthOfYear() {
        return g(this.yearOfEra);
    }

    /* renamed from: m */
    public HijrahDate c(long j11) {
        if (j11 == 0) {
            return this;
        }
        return i(this.era, Jdk8Methods.safeAdd(this.yearOfEra, (int) j11), this.monthOfYear, this.dayOfMonth);
    }

    public void o(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i11 = AnonymousClass1.f63336a[chronoField.ordinal()];
            if (i11 == 1) {
                return ValueRange.of(1, (long) lengthOfMonth());
            }
            if (i11 == 2) {
                return ValueRange.of(1, (long) lengthOfYear());
            }
            if (i11 == 3) {
                return ValueRange.of(1, 5);
            }
            if (i11 != 4) {
                return getChronology().range(chronoField);
            }
            return ValueRange.of(1, 1000);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long toEpochDay() {
        return getGregorianEpochDay(this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    }

    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    public static boolean isLeapYear(long j11) {
        if (j11 <= 0) {
            j11 = -j11;
        }
        return ((j11 * 11) + 14) % 30 < 11;
    }

    public static HijrahDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public HijrahChronology getChronology() {
        return HijrahChronology.INSTANCE;
    }

    public HijrahEra getEra() {
        return this.era;
    }

    public /* bridge */ /* synthetic */ ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        return super.until(chronoLocalDate);
    }

    public static HijrahDate now(Clock clock) {
        return HijrahChronology.INSTANCE.dateNow(clock);
    }

    public HijrahDate minus(TemporalAmount temporalAmount) {
        return (HijrahDate) super.minus(temporalAmount);
    }

    public HijrahDate with(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) super.with(temporalAdjuster);
    }

    public HijrahDate minus(long j11, TemporalUnit temporalUnit) {
        return (HijrahDate) super.minus(j11, temporalUnit);
    }

    public HijrahDate plus(TemporalAmount temporalAmount) {
        return (HijrahDate) super.plus(temporalAmount);
    }

    public HijrahDate with(TemporalField temporalField, long j11) {
        if (!(temporalField instanceof ChronoField)) {
            return (HijrahDate) temporalField.adjustInto(this, j11);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j11);
        int i11 = (int) j11;
        switch (AnonymousClass1.f63336a[chronoField.ordinal()]) {
            case 1:
                return resolvePreviousValid(this.yearOfEra, this.monthOfYear, i11);
            case 2:
                int i12 = i11 - 1;
                return resolvePreviousValid(this.yearOfEra, (i12 / 30) + 1, (i12 % 30) + 1);
            case 3:
                return a((j11 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                if (this.yearOfEra < 1) {
                    i11 = 1 - i11;
                }
                return resolvePreviousValid(i11, this.monthOfYear, this.dayOfMonth);
            case 5:
                return a(j11 - ((long) this.dayOfWeek.getValue()));
            case 6:
                return a(j11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return a(j11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return new HijrahDate((long) i11);
            case 9:
                return a((j11 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 10:
                return resolvePreviousValid(this.yearOfEra, i11, this.dayOfMonth);
            case 11:
                return resolvePreviousValid(i11, this.monthOfYear, this.dayOfMonth);
            case 12:
                return resolvePreviousValid(1 - this.yearOfEra, this.monthOfYear, this.dayOfMonth);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public HijrahDate plus(long j11, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j11, temporalUnit);
    }
}
