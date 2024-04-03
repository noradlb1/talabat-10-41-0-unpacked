package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;

public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;

    /* renamed from: a  reason: collision with root package name */
    public SolverVariable f10428a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f10429b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10430c = false;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<SolverVariable> f10431d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f10432e = false;
    public ArrayRowVariables variables;

    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f11, boolean z11);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f11);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i11);

        float getVariableValue(int i11);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f11);

        float remove(SolverVariable solverVariable, boolean z11);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z11);
    }

    public ArrayRow() {
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f11 = 0.0f;
        for (int i11 = 0; i11 < currentSize; i11++) {
            float variableValue = this.variables.getVariableValue(i11);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i11);
                if ((zArr == null || !zArr[variable.f10457id]) && variable != solverVariable && (((type = variable.f10452e) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f11)) {
                    f11 = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public ArrayRow a(SolverVariable solverVariable, int i11) {
        this.variables.put(solverVariable, (float) i11);
        return this;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i11) {
        this.variables.put(linearSystem.createErrorVariable(i11, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i11, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    public boolean b(LinearSystem linearSystem) {
        boolean z11;
        SolverVariable c11 = c(linearSystem);
        if (c11 == null) {
            z11 = true;
        } else {
            j(c11);
            z11 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.f10432e = true;
        }
        return z11;
    }

    public SolverVariable c(LinearSystem linearSystem) {
        boolean isNew;
        boolean isNew2;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        boolean z11 = false;
        boolean z12 = false;
        SolverVariable solverVariable2 = null;
        for (int i11 = 0; i11 < currentSize; i11++) {
            float variableValue = this.variables.getVariableValue(i11);
            SolverVariable variable = this.variables.getVariable(i11);
            if (variable.f10452e == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (f11 > variableValue) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (!z11 && isNew(variable, linearSystem)) {
                    f11 = variableValue;
                    solverVariable = variable;
                    z11 = true;
                }
                z11 = isNew2;
                f11 = variableValue;
                solverVariable = variable;
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null) {
                    isNew = isNew(variable, linearSystem);
                } else if (f12 > variableValue) {
                    isNew = isNew(variable, linearSystem);
                } else if (!z12 && isNew(variable, linearSystem)) {
                    f12 = variableValue;
                    solverVariable2 = variable;
                    z12 = true;
                }
                z12 = isNew;
                f12 = variableValue;
                solverVariable2 = variable;
            }
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }

    public void clear() {
        this.variables.clear();
        this.f10428a = null;
        this.f10429b = 0.0f;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f11);
        this.variables.put(solverVariable4, -f11);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f11, float f12, float f13, SolverVariable solverVariable, int i11, SolverVariable solverVariable2, int i12, SolverVariable solverVariable3, int i13, SolverVariable solverVariable4, int i14) {
        if (f12 == 0.0f || f11 == f13) {
            this.f10429b = (float) (((-i11) - i12) + i13 + i14);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            float f14 = (f11 / f12) / (f13 / f12);
            this.f10429b = ((float) ((-i11) - i12)) + (((float) i13) * f14) + (((float) i14) * f14);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f14);
            this.variables.put(solverVariable3, -f14);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f11, float f12, float f13, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f10429b = 0.0f;
        if (f12 == 0.0f || f11 == f13) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else if (f11 == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        } else if (f13 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
        } else {
            float f14 = (f11 / f12) / (f13 / f12);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f14);
            this.variables.put(solverVariable3, -f14);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i11) {
        if (i11 < 0) {
            this.f10429b = (float) (i11 * -1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.f10429b = (float) i11;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z11 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            }
            this.f10429b = (float) i11;
        }
        if (!z11) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z11 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            }
            this.f10429b = (float) i11;
        }
        if (!z11) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.f10429b = -f11;
        return this;
    }

    public ArrayRow d(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f11 == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i11 > 0 || i12 > 0) {
                this.f10429b = (float) ((-i11) + i12);
            }
        } else if (f11 <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.f10429b = (float) i11;
        } else if (f11 >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.f10429b = (float) (-i12);
        } else {
            float f12 = 1.0f - f11;
            this.variables.put(solverVariable, f12 * 1.0f);
            this.variables.put(solverVariable2, f12 * -1.0f);
            this.variables.put(solverVariable3, -1.0f * f11);
            this.variables.put(solverVariable4, 1.0f * f11);
            if (i11 > 0 || i12 > 0) {
                this.f10429b = (((float) (-i11)) * f12) + (((float) i12) * f11);
            }
        }
        return this;
    }

    public ArrayRow e(SolverVariable solverVariable, int i11) {
        this.f10428a = solverVariable;
        float f11 = (float) i11;
        solverVariable.computedValue = f11;
        this.f10429b = f11;
        this.f10432e = true;
        return this;
    }

    public ArrayRow f(SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f11);
        return this;
    }

    public void g() {
        float f11 = this.f10429b;
        if (f11 < 0.0f) {
            this.f10429b = f11 * -1.0f;
            this.variables.invert();
        }
    }

    public SolverVariable getKey() {
        return this.f10428a;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, (SolverVariable) null);
    }

    public boolean h() {
        SolverVariable solverVariable = this.f10428a;
        return solverVariable != null && (solverVariable.f10452e == SolverVariable.Type.UNRESTRICTED || this.f10429b >= 0.0f);
    }

    public boolean i(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.f10428a = null;
            this.variables.clear();
            for (int i11 = 0; i11 < arrayRow.variables.getCurrentSize(); i11++) {
                this.variables.add(arrayRow.variables.getVariable(i11), arrayRow.variables.getVariableValue(i11), true);
            }
        }
    }

    public boolean isEmpty() {
        return this.f10428a == null && this.f10429b == 0.0f && this.variables.getCurrentSize() == 0;
    }

    public void j(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f10428a;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.f10428a.f10449b = -1;
            this.f10428a = null;
        }
        float remove = this.variables.remove(solverVariable, true) * -1.0f;
        this.f10428a = solverVariable;
        if (remove != 1.0f) {
            this.f10429b /= remove;
            this.variables.divideByAmount(remove);
        }
    }

    public int k() {
        int i11;
        if (this.f10428a != null) {
            i11 = 4;
        } else {
            i11 = 0;
        }
        return i11 + 4 + 4 + this.variables.sizeInBytes();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String l() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.f10428a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.f10428a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f10429b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f10429b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L_0x0057
        L_0x0056:
            r1 = r3
        L_0x0057:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r10.variables
            int r5 = r5.getCurrentSize()
        L_0x005d:
            if (r3 >= r5) goto L_0x00eb
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r10.variables
            androidx.constraintlayout.core.SolverVariable r6 = r6.getVariable(r3)
            if (r6 != 0) goto L_0x0069
            goto L_0x00e7
        L_0x0069:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r10.variables
            float r7 = r7.getVariableValue(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            goto L_0x00e7
        L_0x0075:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0093
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b8
        L_0x0093:
            if (r8 <= 0) goto L_0x00a7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b9
        L_0x00a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b8:
            float r7 = r7 * r9
        L_0x00b9:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00cf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e6
        L_0x00cf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e6:
            r1 = r4
        L_0x00e7:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x00eb:
            if (r1 != 0) goto L_0x00fe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00fe:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.l():java.lang.String");
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables((boolean[]) null, solverVariable);
    }

    public void reset() {
        this.f10428a = null;
        this.variables.clear();
        this.f10429b = 0.0f;
        this.f10432e = false;
    }

    public String toString() {
        return l();
    }

    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z11) {
        if (solverVariable != null && solverVariable.isFinalValue) {
            this.f10429b += solverVariable.computedValue * this.variables.get(solverVariable);
            this.variables.remove(solverVariable, z11);
            if (z11) {
                solverVariable.removeFromRow(this);
            }
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.f10432e = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z11) {
        this.f10429b += arrayRow.f10429b * this.variables.use(arrayRow, z11);
        if (z11) {
            arrayRow.f10428a.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.f10428a != null && this.variables.getCurrentSize() == 0) {
            this.f10432e = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z11) {
        if (solverVariable != null && solverVariable.f10455h) {
            float f11 = this.variables.get(solverVariable);
            this.f10429b += solverVariable.f10458j * f11;
            this.variables.remove(solverVariable, z11);
            if (z11) {
                solverVariable.removeFromRow(this);
            }
            this.variables.add(linearSystem.f10441e.f10436d[solverVariable.f10456i], f11, z11);
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.f10432e = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.f10438b.length != 0) {
            boolean z11 = false;
            while (!z11) {
                int currentSize = this.variables.getCurrentSize();
                for (int i11 = 0; i11 < currentSize; i11++) {
                    SolverVariable variable = this.variables.getVariable(i11);
                    if (variable.f10449b != -1 || variable.isFinalValue || variable.f10455h) {
                        this.f10431d.add(variable);
                    }
                }
                int size = this.f10431d.size();
                if (size > 0) {
                    for (int i12 = 0; i12 < size; i12++) {
                        SolverVariable solverVariable = this.f10431d.get(i12);
                        if (solverVariable.isFinalValue) {
                            updateFromFinalVariable(linearSystem, solverVariable, true);
                        } else if (solverVariable.f10455h) {
                            updateFromSynonymVariable(linearSystem, solverVariable, true);
                        } else {
                            updateFromRow(linearSystem, linearSystem.f10438b[solverVariable.f10449b], true);
                        }
                    }
                    this.f10431d.clear();
                } else {
                    z11 = true;
                }
            }
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.f10428a != null && this.variables.getCurrentSize() == 0) {
                this.f10432e = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void addError(SolverVariable solverVariable) {
        int i11 = solverVariable.strength;
        float f11 = 1.0f;
        if (i11 != 1) {
            if (i11 == 2) {
                f11 = 1000.0f;
            } else if (i11 == 3) {
                f11 = 1000000.0f;
            } else if (i11 == 4) {
                f11 = 1.0E9f;
            } else if (i11 == 5) {
                f11 = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f11);
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i11) {
        boolean z11 = false;
        if (i11 != 0) {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            }
            this.f10429b = (float) i11;
        }
        if (!z11) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i11, SolverVariable solverVariable2) {
        this.f10429b = (float) i11;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
