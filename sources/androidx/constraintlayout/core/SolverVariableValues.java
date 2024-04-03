package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    private int HASH_SIZE = 16;
    private final int NONE = -1;
    private int SIZE = 16;

    /* renamed from: a  reason: collision with root package name */
    public int[] f10461a = new int[16];

    /* renamed from: b  reason: collision with root package name */
    public int[] f10462b = new int[16];

    /* renamed from: c  reason: collision with root package name */
    public int[] f10463c = new int[16];

    /* renamed from: d  reason: collision with root package name */
    public float[] f10464d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    public int[] f10465e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    public int[] f10466f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    public int f10467g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f10468h = -1;

    /* renamed from: i  reason: collision with root package name */
    public final Cache f10469i;
    private final ArrayRow mRow;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.f10469i = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i11) {
        int[] iArr;
        int i12 = solverVariable.f10457id % this.HASH_SIZE;
        int[] iArr2 = this.f10461a;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            iArr2[i12] = i11;
        } else {
            while (true) {
                iArr = this.f10462b;
                int i14 = iArr[i13];
                if (i14 == -1) {
                    break;
                }
                i13 = i14;
            }
            iArr[i13] = i11;
        }
        this.f10462b[i11] = -1;
    }

    private void addVariable(int i11, SolverVariable solverVariable, float f11) {
        this.f10463c[i11] = solverVariable.f10457id;
        this.f10464d[i11] = f11;
        this.f10465e[i11] = -1;
        this.f10466f[i11] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.f10467g++;
    }

    private void displayHash() {
        for (int i11 = 0; i11 < this.HASH_SIZE; i11++) {
            if (this.f10461a[i11] != -1) {
                String str = hashCode() + " hash [" + i11 + "] => ";
                int i12 = this.f10461a[i11];
                boolean z11 = false;
                while (!z11) {
                    str = str + " " + this.f10463c[i12];
                    int i13 = this.f10462b[i12];
                    if (i13 != -1) {
                        i12 = i13;
                    } else {
                        z11 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i11 = 0; i11 < this.SIZE; i11++) {
            if (this.f10463c[i11] == -1) {
                return i11;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i11 = this.SIZE * 2;
        this.f10463c = Arrays.copyOf(this.f10463c, i11);
        this.f10464d = Arrays.copyOf(this.f10464d, i11);
        this.f10465e = Arrays.copyOf(this.f10465e, i11);
        this.f10466f = Arrays.copyOf(this.f10466f, i11);
        this.f10462b = Arrays.copyOf(this.f10462b, i11);
        for (int i12 = this.SIZE; i12 < i11; i12++) {
            this.f10463c[i12] = -1;
            this.f10462b[i12] = -1;
        }
        this.SIZE = i11;
    }

    private void insertVariable(int i11, SolverVariable solverVariable, float f11) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f11);
        if (i11 != -1) {
            this.f10465e[findEmptySlot] = i11;
            int[] iArr = this.f10466f;
            iArr[findEmptySlot] = iArr[i11];
            iArr[i11] = findEmptySlot;
        } else {
            this.f10465e[findEmptySlot] = -1;
            if (this.f10467g > 0) {
                this.f10466f[findEmptySlot] = this.f10468h;
                this.f10468h = findEmptySlot;
            } else {
                this.f10466f[findEmptySlot] = -1;
            }
        }
        int i12 = this.f10466f[findEmptySlot];
        if (i12 != -1) {
            this.f10465e[i12] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeFromHashMap(androidx.constraintlayout.core.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.f10457id
            int r0 = r5.HASH_SIZE
            int r0 = r6 % r0
            int[] r1 = r5.f10461a
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            return
        L_0x000e:
            int[] r4 = r5.f10463c
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r6 = r5.f10462b
            r4 = r6[r2]
            r1[r0] = r4
            r6[r2] = r3
            goto L_0x0039
        L_0x001d:
            int[] r0 = r5.f10462b
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.f10463c
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r4 = r5.f10463c
            r4 = r4[r1]
            if (r4 != r6) goto L_0x0039
            r6 = r0[r1]
            r0[r2] = r6
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.removeFromHashMap(androidx.constraintlayout.core.SolverVariable):void");
    }

    public void add(SolverVariable solverVariable, float f11, boolean z11) {
        float f12 = epsilon;
        if (f11 <= (-f12) || f11 >= f12) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f11);
                return;
            }
            float[] fArr = this.f10464d;
            float f13 = fArr[indexOf] + f11;
            fArr[indexOf] = f13;
            float f14 = epsilon;
            if (f13 > (-f14) && f13 < f14) {
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z11);
            }
        }
    }

    public void clear() {
        int i11 = this.f10467g;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable variable = getVariable(i12);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i13 = 0; i13 < this.SIZE; i13++) {
            this.f10463c[i13] = -1;
            this.f10462b[i13] = -1;
        }
        for (int i14 = 0; i14 < this.HASH_SIZE; i14++) {
            this.f10461a[i14] = -1;
        }
        this.f10467g = 0;
        this.f10468h = -1;
    }

    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    public void display() {
        int i11 = this.f10467g;
        System.out.print("{ ");
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable variable = getVariable(i12);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i12) + " ");
            }
        }
        System.out.println(" }");
    }

    public void divideByAmount(float f11) {
        int i11 = this.f10467g;
        int i12 = this.f10468h;
        int i13 = 0;
        while (i13 < i11) {
            float[] fArr = this.f10464d;
            fArr[i12] = fArr[i12] / f11;
            i12 = this.f10466f[i12];
            if (i12 != -1) {
                i13++;
            } else {
                return;
            }
        }
    }

    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.f10464d[indexOf];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.f10467g;
    }

    public SolverVariable getVariable(int i11) {
        int i12 = this.f10467g;
        if (i12 == 0) {
            return null;
        }
        int i13 = this.f10468h;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11 && i13 != -1) {
                return this.f10469i.f10436d[this.f10463c[i13]];
            }
            i13 = this.f10466f[i13];
            if (i13 == -1) {
                break;
            }
        }
        return null;
    }

    public float getVariableValue(int i11) {
        int i12 = this.f10467g;
        int i13 = this.f10468h;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11) {
                return this.f10464d[i13];
            }
            i13 = this.f10466f[i13];
            if (i13 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(androidx.constraintlayout.core.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.f10467g
            r1 = -1
            if (r0 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0008
            goto L_0x0033
        L_0x0008:
            int r4 = r4.f10457id
            int r0 = r3.HASH_SIZE
            int r0 = r4 % r0
            int[] r2 = r3.f10461a
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0015
            return r1
        L_0x0015:
            int[] r2 = r3.f10463c
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001c
            return r0
        L_0x001c:
            int[] r2 = r3.f10462b
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0029
            int[] r2 = r3.f10463c
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0029
            goto L_0x001c
        L_0x0029:
            if (r0 != r1) goto L_0x002c
            return r1
        L_0x002c:
            int[] r2 = r3.f10463c
            r2 = r2[r0]
            if (r2 != r4) goto L_0x0033
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.indexOf(androidx.constraintlayout.core.SolverVariable):int");
    }

    public void invert() {
        int i11 = this.f10467g;
        int i12 = this.f10468h;
        int i13 = 0;
        while (i13 < i11) {
            float[] fArr = this.f10464d;
            fArr[i12] = fArr[i12] * -1.0f;
            i12 = this.f10466f[i12];
            if (i12 != -1) {
                i13++;
            } else {
                return;
            }
        }
    }

    public void put(SolverVariable solverVariable, float f11) {
        float f12 = epsilon;
        if (f11 <= (-f12) || f11 >= f12) {
            if (this.f10467g == 0) {
                addVariable(0, solverVariable, f11);
                addToHashMap(solverVariable, 0);
                this.f10468h = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.f10464d[indexOf] = f11;
                return;
            }
            if (this.f10467g + 1 >= this.SIZE) {
                increaseSize();
            }
            int i11 = this.f10467g;
            int i12 = this.f10468h;
            int i13 = -1;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = this.f10463c[i12];
                int i16 = solverVariable.f10457id;
                if (i15 == i16) {
                    this.f10464d[i12] = f11;
                    return;
                }
                if (i15 < i16) {
                    i13 = i12;
                }
                i12 = this.f10466f[i12];
                if (i12 == -1) {
                    break;
                }
            }
            insertVariable(i13, solverVariable, f11);
            return;
        }
        remove(solverVariable, true);
    }

    public float remove(SolverVariable solverVariable, boolean z11) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f11 = this.f10464d[indexOf];
        if (this.f10468h == indexOf) {
            this.f10468h = this.f10466f[indexOf];
        }
        this.f10463c[indexOf] = -1;
        int[] iArr = this.f10465e;
        int i11 = iArr[indexOf];
        if (i11 != -1) {
            int[] iArr2 = this.f10466f;
            iArr2[i11] = iArr2[indexOf];
        }
        int i12 = this.f10466f[indexOf];
        if (i12 != -1) {
            iArr[i12] = iArr[indexOf];
        }
        this.f10467g--;
        solverVariable.usageInRowCount--;
        if (z11) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f11;
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i11 = this.f10467g;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable variable = getVariable(i12);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i12) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.f10465e[indexOf] != -1) {
                    str = str5 + this.f10469i.f10436d[this.f10463c[this.f10465e[indexOf]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f10466f[indexOf] != -1) {
                    str2 = str6 + this.f10469i.f10436d[this.f10463c[this.f10466f[indexOf]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public float use(ArrayRow arrayRow, boolean z11) {
        float f11 = get(arrayRow.f10428a);
        remove(arrayRow.f10428a, z11);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i11 = 0;
        int i12 = 0;
        while (i11 < currentSize) {
            int i13 = solverVariableValues.f10463c[i12];
            if (i13 != -1) {
                add(this.f10469i.f10436d[i13], solverVariableValues.f10464d[i12] * f11, z11);
                i11++;
            }
            i12++;
        }
        return f11;
    }
}
