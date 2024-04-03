package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE = 128;
    private SolverVariable[] arrayGoals = new SolverVariable[128];

    /* renamed from: f  reason: collision with root package name */
    public GoalVariableAccessor f10443f = new GoalVariableAccessor(this);

    /* renamed from: g  reason: collision with root package name */
    public Cache f10444g;
    private int numGoals = 0;
    private SolverVariable[] sortArray = new SolverVariable[128];

    public class GoalVariableAccessor {

        /* renamed from: a  reason: collision with root package name */
        public SolverVariable f10446a;

        /* renamed from: b  reason: collision with root package name */
        public PriorityGoalRow f10447b;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.f10447b = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f10446a.f10451d;
                float f11 = fArr[i11] + solverVariable.f10451d[i11];
                fArr[i11] = f11;
                if (Math.abs(f11) < 1.0E-4f) {
                    this.f10446a.f10451d[i11] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f11) {
            boolean z11 = true;
            if (this.f10446a.inGoal) {
                for (int i11 = 0; i11 < 9; i11++) {
                    float[] fArr = this.f10446a.f10451d;
                    float f12 = fArr[i11] + (solverVariable.f10451d[i11] * f11);
                    fArr[i11] = f12;
                    if (Math.abs(f12) < 1.0E-4f) {
                        this.f10446a.f10451d[i11] = 0.0f;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    PriorityGoalRow.this.removeGoal(this.f10446a);
                }
                return false;
            }
            for (int i12 = 0; i12 < 9; i12++) {
                float f13 = solverVariable.f10451d[i12];
                if (f13 != 0.0f) {
                    float f14 = f13 * f11;
                    if (Math.abs(f14) < 1.0E-4f) {
                        f14 = 0.0f;
                    }
                    this.f10446a.f10451d[i12] = f14;
                } else {
                    this.f10446a.f10451d[i12] = 0.0f;
                }
            }
            return true;
        }

        public void init(SolverVariable solverVariable) {
            this.f10446a = solverVariable;
        }

        public final boolean isNegative() {
            for (int i11 = 8; i11 >= 0; i11--) {
                float f11 = this.f10446a.f10451d[i11];
                if (f11 > 0.0f) {
                    return false;
                }
                if (f11 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i11 = 0; i11 < 9; i11++) {
                if (this.f10446a.f10451d[i11] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i11 = 8;
            while (true) {
                if (i11 < 0) {
                    break;
                }
                float f11 = solverVariable.f10451d[i11];
                float f12 = this.f10446a.f10451d[i11];
                if (f12 == f11) {
                    i11--;
                } else if (f12 < f11) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.f10446a.f10451d, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f10446a != null) {
                for (int i11 = 0; i11 < 9; i11++) {
                    str = str + this.f10446a.f10451d[i11] + " ";
                }
            }
            return str + "] " + this.f10446a;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.f10444g = cache;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i11;
        int i12 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i12 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i13 = this.numGoals;
        solverVariableArr3[i13] = solverVariable;
        int i14 = i13 + 1;
        this.numGoals = i14;
        if (i14 > 1 && solverVariableArr3[i14 - 1].f10457id > solverVariable.f10457id) {
            int i15 = 0;
            while (true) {
                i11 = this.numGoals;
                if (i15 >= i11) {
                    break;
                }
                this.sortArray[i15] = this.arrayGoals[i15];
                i15++;
            }
            Arrays.sort(this.sortArray, 0, i11, new Comparator<SolverVariable>() {
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.f10457id - solverVariable2.f10457id;
                }
            });
            for (int i16 = 0; i16 < this.numGoals; i16++) {
                this.arrayGoals[i16] = this.sortArray[i16];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        int i11 = 0;
        while (i11 < this.numGoals) {
            if (this.arrayGoals[i11] == solverVariable) {
                while (true) {
                    int i12 = this.numGoals;
                    if (i11 < i12 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i13 = i11 + 1;
                        solverVariableArr[i11] = solverVariableArr[i13];
                        i11 = i13;
                    } else {
                        this.numGoals = i12 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i11++;
            }
        }
    }

    public void addError(SolverVariable solverVariable) {
        this.f10443f.init(solverVariable);
        this.f10443f.reset();
        solverVariable.f10451d[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    public void clear() {
        this.numGoals = 0;
        this.f10429b = 0.0f;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i11 = -1;
        for (int i12 = 0; i12 < this.numGoals; i12++) {
            SolverVariable solverVariable = this.arrayGoals[i12];
            if (!zArr[solverVariable.f10457id]) {
                this.f10443f.init(solverVariable);
                if (i11 == -1) {
                    if (!this.f10443f.isNegative()) {
                    }
                } else if (!this.f10443f.isSmallerThan(this.arrayGoals[i11])) {
                }
                i11 = i12;
            }
        }
        if (i11 == -1) {
            return null;
        }
        return this.arrayGoals[i11];
    }

    public boolean isEmpty() {
        return this.numGoals == 0;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.f10429b + ") : ";
        for (int i11 = 0; i11 < this.numGoals; i11++) {
            this.f10443f.init(this.arrayGoals[i11]);
            str = str + this.f10443f + " ";
        }
        return str;
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z11) {
        SolverVariable solverVariable = arrayRow.f10428a;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i11 = 0; i11 < currentSize; i11++) {
                SolverVariable variable = arrayRowVariables.getVariable(i11);
                float variableValue = arrayRowVariables.getVariableValue(i11);
                this.f10443f.init(variable);
                if (this.f10443f.addToGoal(solverVariable, variableValue)) {
                    addToGoal(variable);
                }
                this.f10429b += arrayRow.f10429b * variableValue;
            }
            removeGoal(solverVariable);
        }
    }
}
