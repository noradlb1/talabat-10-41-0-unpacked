package androidx.constraintlayout.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean INTERNAL_DEBUG = false;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f10449b = -1;

    /* renamed from: c  reason: collision with root package name */
    public float[] f10450c = new float[9];
    public float computedValue;

    /* renamed from: d  reason: collision with root package name */
    public float[] f10451d = new float[9];

    /* renamed from: e  reason: collision with root package name */
    public Type f10452e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayRow[] f10453f = new ArrayRow[16];

    /* renamed from: g  reason: collision with root package name */
    public int f10454g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10455h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f10456i = -1;

    /* renamed from: id  reason: collision with root package name */
    public int f10457id = -1;
    public boolean inGoal;
    public boolean isFinalValue = false;

    /* renamed from: j  reason: collision with root package name */
    public float f10458j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public HashSet<ArrayRow> f10459k = null;
    private String mName;
    public int strength = 0;
    public int usageInRowCount = 0;

    /* renamed from: androidx.constraintlayout.core.SolverVariable$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10460a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.SolverVariable$Type[] r0 = androidx.constraintlayout.core.SolverVariable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10460a = r0
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.UNRESTRICTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10460a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.CONSTANT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10460a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.SLACK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10460a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10460a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariable.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.mName = str;
        this.f10452e = type;
    }

    public static void a() {
        uniqueErrorId++;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        int i11 = AnonymousClass1.f10460a[type.ordinal()];
        if (i11 == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("U");
            int i12 = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i12;
            sb2.append(i12);
            return sb2.toString();
        } else if (i11 == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("C");
            int i13 = uniqueConstantId + 1;
            uniqueConstantId = i13;
            sb3.append(i13);
            return sb3.toString();
        } else if (i11 == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(ExifInterface.LATITUDE_SOUTH);
            int i14 = uniqueSlackId + 1;
            uniqueSlackId = i14;
            sb4.append(i14);
            return sb4.toString();
        } else if (i11 == 4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("e");
            int i15 = uniqueErrorId + 1;
            uniqueErrorId = i15;
            sb5.append(i15);
            return sb5.toString();
        } else if (i11 == 5) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            int i16 = uniqueId + 1;
            uniqueId = i16;
            sb6.append(i16);
            return sb6.toString();
        } else {
            throw new AssertionError(type.name());
        }
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i11 = 0;
        while (true) {
            int i12 = this.f10454g;
            if (i11 >= i12) {
                ArrayRow[] arrayRowArr = this.f10453f;
                if (i12 >= arrayRowArr.length) {
                    this.f10453f = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f10453f;
                int i13 = this.f10454g;
                arrayRowArr2[i13] = arrayRow;
                this.f10454g = i13 + 1;
                return;
            } else if (this.f10453f[i11] != arrayRow) {
                i11++;
            } else {
                return;
            }
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i11 = this.f10454g;
        int i12 = 0;
        while (i12 < i11) {
            if (this.f10453f[i12] == arrayRow) {
                while (i12 < i11 - 1) {
                    ArrayRow[] arrayRowArr = this.f10453f;
                    int i13 = i12 + 1;
                    arrayRowArr[i12] = arrayRowArr[i13];
                    i12 = i13;
                }
                this.f10454g--;
                return;
            }
            i12++;
        }
    }

    public void reset() {
        this.mName = null;
        this.f10452e = Type.UNKNOWN;
        this.strength = 0;
        this.f10457id = -1;
        this.f10449b = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.f10455h = false;
        this.f10456i = -1;
        this.f10458j = 0.0f;
        int i11 = this.f10454g;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f10453f[i12] = null;
        }
        this.f10454g = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.f10451d, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f11) {
        this.computedValue = f11;
        this.isFinalValue = true;
        this.f10455h = false;
        this.f10456i = -1;
        this.f10458j = 0.0f;
        int i11 = this.f10454g;
        this.f10449b = -1;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f10453f[i12].updateFromFinalVariable(linearSystem, this, false);
        }
        this.f10454g = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f11) {
        this.f10455h = true;
        this.f10456i = solverVariable.f10457id;
        this.f10458j = f11;
        int i11 = this.f10454g;
        this.f10449b = -1;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f10453f[i12].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.f10454g = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.f10452e = type;
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.f10457id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i11 = this.f10454g;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f10453f[i12].updateFromRow(linearSystem, arrayRow, false);
        }
        this.f10454g = 0;
    }

    public int compareTo(SolverVariable solverVariable) {
        return this.f10457id - solverVariable.f10457id;
    }

    public SolverVariable(Type type, String str) {
        this.f10452e = type;
    }
}
