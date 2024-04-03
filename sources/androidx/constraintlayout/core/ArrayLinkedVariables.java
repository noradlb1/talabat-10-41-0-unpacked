package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    private static float epsilon = 0.001f;
    private int ROW_SIZE = 8;

    /* renamed from: a  reason: collision with root package name */
    public int f10426a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Cache f10427b;
    private SolverVariable candidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.f10427b = cache;
    }

    public void add(SolverVariable solverVariable, float f11, boolean z11) {
        float f12 = epsilon;
        if (f11 <= (-f12) || f11 >= f12) {
            int i11 = this.mHead;
            if (i11 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f11;
                this.mArrayIndices[0] = solverVariable.f10457id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.f10426a++;
                if (!this.mDidFillOnce) {
                    int i12 = this.mLast + 1;
                    this.mLast = i12;
                    int[] iArr = this.mArrayIndices;
                    if (i12 >= iArr.length) {
                        this.mDidFillOnce = true;
                        this.mLast = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i13 = 0;
            int i14 = -1;
            while (i11 != -1 && i13 < this.f10426a) {
                int i15 = this.mArrayIndices[i11];
                int i16 = solverVariable.f10457id;
                if (i15 == i16) {
                    float[] fArr = this.mArrayValues;
                    float f13 = fArr[i11] + f11;
                    float f14 = epsilon;
                    if (f13 > (-f14) && f13 < f14) {
                        f13 = 0.0f;
                    }
                    fArr[i11] = f13;
                    if (f13 == 0.0f) {
                        if (i11 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i11];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i14] = iArr2[i11];
                        }
                        if (z11) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i11;
                        }
                        solverVariable.usageInRowCount--;
                        this.f10426a--;
                        return;
                    }
                    return;
                }
                if (i15 < i16) {
                    i14 = i11;
                }
                i11 = this.mArrayNextIndices[i11];
                i13++;
            }
            int i17 = this.mLast;
            int i18 = i17 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i17] != -1) {
                    i17 = iArr3.length;
                }
            } else {
                i17 = i18;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i17 >= iArr4.length && this.f10426a < iArr4.length) {
                int i19 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i19 >= iArr5.length) {
                        break;
                    } else if (iArr5[i19] == -1) {
                        i17 = i19;
                        break;
                    } else {
                        i19++;
                    }
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i17 >= iArr6.length) {
                i17 = iArr6.length;
                int i21 = this.ROW_SIZE * 2;
                this.ROW_SIZE = i21;
                this.mDidFillOnce = false;
                this.mLast = i17 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i21);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i17] = solverVariable.f10457id;
            this.mArrayValues[i17] = f11;
            if (i14 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i17] = iArr7[i14];
                iArr7[i14] = i17;
            } else {
                this.mArrayNextIndices[i17] = this.mHead;
                this.mHead = i17;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.f10426a++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i22 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i22 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    public final void clear() {
        int i11 = this.mHead;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f10426a) {
            SolverVariable solverVariable = this.f10427b.f10436d[this.mArrayIndices[i11]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.f10426a = 0;
    }

    public boolean contains(SolverVariable solverVariable) {
        int i11 = this.mHead;
        if (i11 == -1) {
            return false;
        }
        int i12 = 0;
        while (i11 != -1 && i12 < this.f10426a) {
            if (this.mArrayIndices[i11] == solverVariable.f10457id) {
                return true;
            }
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
        return false;
    }

    public void display() {
        int i11 = this.f10426a;
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
        int i11 = this.mHead;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f10426a) {
            float[] fArr = this.mArrayValues;
            fArr[i11] = fArr[i11] / f11;
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
    }

    public final float get(SolverVariable solverVariable) {
        int i11 = this.mHead;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f10426a) {
            if (this.mArrayIndices[i11] == solverVariable.f10457id) {
                return this.mArrayValues[i11];
            }
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.f10426a;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i11) {
        return this.mArrayIndices[i11];
    }

    public final int getNextIndice(int i11) {
        return this.mArrayNextIndices[i11];
    }

    public final float getValue(int i11) {
        return this.mArrayValues[i11];
    }

    public SolverVariable getVariable(int i11) {
        int i12 = this.mHead;
        int i13 = 0;
        while (i12 != -1 && i13 < this.f10426a) {
            if (i13 == i11) {
                return this.f10427b.f10436d[this.mArrayIndices[i12]];
            }
            i12 = this.mArrayNextIndices[i12];
            i13++;
        }
        return null;
    }

    public float getVariableValue(int i11) {
        int i12 = this.mHead;
        int i13 = 0;
        while (i12 != -1 && i13 < this.f10426a) {
            if (i13 == i11) {
                return this.mArrayValues[i12];
            }
            i12 = this.mArrayNextIndices[i12];
            i13++;
        }
        return 0.0f;
    }

    public int indexOf(SolverVariable solverVariable) {
        int i11 = this.mHead;
        if (i11 == -1) {
            return -1;
        }
        int i12 = 0;
        while (i11 != -1 && i12 < this.f10426a) {
            if (this.mArrayIndices[i11] == solverVariable.f10457id) {
                return i11;
            }
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
        return -1;
    }

    public void invert() {
        int i11 = this.mHead;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f10426a) {
            float[] fArr = this.mArrayValues;
            fArr[i11] = fArr[i11] * -1.0f;
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
    }

    public final void put(SolverVariable solverVariable, float f11) {
        if (f11 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i11 = this.mHead;
        if (i11 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f11;
            this.mArrayIndices[0] = solverVariable.f10457id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.f10426a++;
            if (!this.mDidFillOnce) {
                int i12 = this.mLast + 1;
                this.mLast = i12;
                int[] iArr = this.mArrayIndices;
                if (i12 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i13 = 0;
        int i14 = -1;
        while (i11 != -1 && i13 < this.f10426a) {
            int i15 = this.mArrayIndices[i11];
            int i16 = solverVariable.f10457id;
            if (i15 == i16) {
                this.mArrayValues[i11] = f11;
                return;
            }
            if (i15 < i16) {
                i14 = i11;
            }
            i11 = this.mArrayNextIndices[i11];
            i13++;
        }
        int i17 = this.mLast;
        int i18 = i17 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i17] != -1) {
                i17 = iArr2.length;
            }
        } else {
            i17 = i18;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i17 >= iArr3.length && this.f10426a < iArr3.length) {
            int i19 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i19 >= iArr4.length) {
                    break;
                } else if (iArr4[i19] == -1) {
                    i17 = i19;
                    break;
                } else {
                    i19++;
                }
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i17 >= iArr5.length) {
            i17 = iArr5.length;
            int i21 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i21;
            this.mDidFillOnce = false;
            this.mLast = i17 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i21);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i17] = solverVariable.f10457id;
        this.mArrayValues[i17] = f11;
        if (i14 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i17] = iArr6[i14];
            iArr6[i14] = i17;
        } else {
            this.mArrayNextIndices[i17] = this.mHead;
            this.mHead = i17;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i22 = this.f10426a + 1;
        this.f10426a = i22;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i22 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z11) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        int i11 = this.mHead;
        if (i11 == -1) {
            return 0.0f;
        }
        int i12 = 0;
        int i13 = -1;
        while (i11 != -1 && i12 < this.f10426a) {
            if (this.mArrayIndices[i11] == solverVariable.f10457id) {
                if (i11 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i11];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i13] = iArr[i11];
                }
                if (z11) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.f10426a--;
                this.mArrayIndices[i11] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i11;
                }
                return this.mArrayValues[i11];
            }
            i12++;
            i13 = i11;
            i11 = this.mArrayNextIndices[i11];
        }
        return 0.0f;
    }

    public int sizeInBytes() {
        return (this.mArrayIndices.length * 4 * 3) + 0 + 36;
    }

    public String toString() {
        int i11 = this.mHead;
        String str = "";
        int i12 = 0;
        while (i11 != -1 && i12 < this.f10426a) {
            str = ((str + " -> ") + this.mArrayValues[i11] + " : ") + this.f10427b.f10436d[this.mArrayIndices[i11]];
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
        return str;
    }

    public float use(ArrayRow arrayRow, boolean z11) {
        float f11 = get(arrayRow.f10428a);
        remove(arrayRow.f10428a, z11);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i11 = 0; i11 < currentSize; i11++) {
            SolverVariable variable = arrayRowVariables.getVariable(i11);
            add(variable, arrayRowVariables.get(variable) * f11, z11);
        }
        return f11;
    }
}
