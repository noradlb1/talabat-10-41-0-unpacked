package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.huawei.hms.flutter.map.constants.Param;
import com.visa.checkout.Profile;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE;

    /* renamed from: a  reason: collision with root package name */
    public int f10437a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayRow[] f10438b;

    /* renamed from: c  reason: collision with root package name */
    public int f10439c;

    /* renamed from: d  reason: collision with root package name */
    public int f10440d;

    /* renamed from: e  reason: collision with root package name */
    public final Cache f10441e;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition;
    private boolean[] mAlreadyTestedCandidates;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    public boolean newgraphOptimizer;

    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z11);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z11);

        void updateFromSystem(LinearSystem linearSystem);
    }

    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.hasSimpleDefinition = false;
        this.f10437a = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.f10438b = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.f10439c = 1;
        this.f10440d = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.f10438b = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.f10441e = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.f10441e.f10435c.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i11 = this.mPoolVariablesCount;
        int i12 = POOL_SIZE;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            POOL_SIZE = i13;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i13);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i14 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i14 + 1;
        solverVariableArr[i14] = acquire;
        return acquire;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        int i11;
        if (!SIMPLIFY_SYNONYMS || !arrayRow.f10432e) {
            ArrayRow[] arrayRowArr = this.f10438b;
            int i12 = this.f10440d;
            arrayRowArr[i12] = arrayRow;
            SolverVariable solverVariable = arrayRow.f10428a;
            solverVariable.f10449b = i12;
            this.f10440d = i12 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        } else {
            arrayRow.f10428a.setFinalValue(this, arrayRow.f10429b);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i13 = 0;
            while (i13 < this.f10440d) {
                if (this.f10438b[i13] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.f10438b[i13];
                if (arrayRow2 != null && arrayRow2.f10432e) {
                    arrayRow2.f10428a.setFinalValue(this, arrayRow2.f10429b);
                    if (OPTIMIZED_ENGINE) {
                        this.f10441e.f10433a.release(arrayRow2);
                    } else {
                        this.f10441e.f10434b.release(arrayRow2);
                    }
                    this.f10438b[i13] = null;
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (true) {
                        i11 = this.f10440d;
                        if (i14 >= i11) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.f10438b;
                        int i16 = i14 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i14];
                        arrayRowArr2[i16] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.f10428a;
                        if (solverVariable2.f10449b == i14) {
                            solverVariable2.f10449b = i16;
                        }
                        i15 = i14;
                        i14++;
                    }
                    if (i15 < i11) {
                        this.f10438b[i15] = null;
                    }
                    this.f10440d = i11 - 1;
                    i13--;
                }
                i13++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void addSingleError(ArrayRow arrayRow, int i11) {
        a(arrayRow, i11, 0);
    }

    private void computeValues() {
        for (int i11 = 0; i11 < this.f10440d; i11++) {
            ArrayRow arrayRow = this.f10438b[i11];
            arrayRow.f10428a.computedValue = arrayRow.f10429b;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        return linearSystem.createRow().f(solverVariable, solverVariable2, f11);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.f10439c + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, (String) null);
        acquireSolverVariable.setName(str);
        int i11 = this.f10437a + 1;
        this.f10437a = i11;
        this.f10439c++;
        acquireSolverVariable.f10457id = i11;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.f10441e.f10436d[this.f10437a] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i11 = 0; i11 < this.f10440d; i11++) {
            str = (str + this.f10438b[i11]) + StringUtils.LF;
        }
        System.out.println(str + this.mGoal + StringUtils.LF);
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.f10440d + Param.X + this.f10439c + ")\n");
    }

    private int enforceBFS(Row row) throws Exception {
        boolean z11;
        int i11 = 0;
        while (true) {
            if (i11 >= this.f10440d) {
                z11 = false;
                break;
            }
            ArrayRow arrayRow = this.f10438b[i11];
            if (arrayRow.f10428a.f10452e != SolverVariable.Type.UNRESTRICTED && arrayRow.f10429b < 0.0f) {
                z11 = true;
                break;
            }
            i11++;
        }
        if (!z11) {
            return 0;
        }
        boolean z12 = false;
        int i12 = 0;
        while (!z12) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.bfs++;
            }
            i12++;
            float f11 = Float.MAX_VALUE;
            int i13 = -1;
            int i14 = -1;
            int i15 = 0;
            for (int i16 = 0; i16 < this.f10440d; i16++) {
                ArrayRow arrayRow2 = this.f10438b[i16];
                if (arrayRow2.f10428a.f10452e != SolverVariable.Type.UNRESTRICTED && !arrayRow2.f10432e && arrayRow2.f10429b < 0.0f) {
                    int i17 = 9;
                    if (SKIP_COLUMNS) {
                        int currentSize = arrayRow2.variables.getCurrentSize();
                        int i18 = 0;
                        while (i18 < currentSize) {
                            SolverVariable variable = arrayRow2.variables.getVariable(i18);
                            float f12 = arrayRow2.variables.get(variable);
                            if (f12 > 0.0f) {
                                int i19 = 0;
                                while (i19 < i17) {
                                    float f13 = variable.f10450c[i19] / f12;
                                    if ((f13 < f11 && i19 == i15) || i19 > i15) {
                                        i14 = variable.f10457id;
                                        i15 = i19;
                                        i13 = i16;
                                        f11 = f13;
                                    }
                                    i19++;
                                    i17 = 9;
                                }
                            }
                            i18++;
                            i17 = 9;
                        }
                    } else {
                        for (int i21 = 1; i21 < this.f10439c; i21++) {
                            SolverVariable solverVariable = this.f10441e.f10436d[i21];
                            float f14 = arrayRow2.variables.get(solverVariable);
                            if (f14 > 0.0f) {
                                for (int i22 = 0; i22 < 9; i22++) {
                                    float f15 = solverVariable.f10450c[i22] / f14;
                                    if ((f15 < f11 && i22 == i15) || i22 > i15) {
                                        i14 = i21;
                                        i15 = i22;
                                        i13 = i16;
                                        f11 = f15;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i13 != -1) {
                ArrayRow arrayRow3 = this.f10438b[i13];
                arrayRow3.f10428a.f10449b = -1;
                Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.pivots++;
                }
                arrayRow3.j(this.f10441e.f10436d[i14]);
                SolverVariable solverVariable2 = arrayRow3.f10428a;
                solverVariable2.f10449b = i13;
                solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
            } else {
                z12 = true;
            }
            if (i12 > this.f10439c / 2) {
                z12 = true;
            }
        }
        return i12;
    }

    private String getDisplaySize(int i11) {
        int i12 = i11 * 4;
        int i13 = i12 / 1024;
        int i14 = i13 / 1024;
        if (i14 > 0) {
            return "" + i14 + " Mb";
        } else if (i13 > 0) {
            return "" + i13 + " Kb";
        } else {
            return "" + i12 + " bytes";
        }
    }

    private String getDisplayStrength(int i11) {
        return i11 == 1 ? "LOW" : i11 == 2 ? "MEDIUM" : i11 == 3 ? "HIGH" : i11 == 4 ? "HIGHEST" : i11 == 5 ? "EQUALITY" : i11 == 8 ? "FIXED" : i11 == 6 ? "BARRIER" : Profile.DataLevel.NONE;
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i11 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i11;
        this.f10438b = (ArrayRow[]) Arrays.copyOf(this.f10438b, i11);
        Cache cache = this.f10441e;
        cache.f10436d = (SolverVariable[]) Arrays.copyOf(cache.f10436d, this.TABLE_SIZE);
        int i12 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i12];
        this.mMaxColumns = i12;
        this.mMaxRows = i12;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, (long) i12);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z11) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i11 = 0; i11 < this.f10439c; i11++) {
            this.mAlreadyTestedCandidates[i11] = false;
        }
        boolean z12 = false;
        int i12 = 0;
        while (!z12) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i12++;
            if (i12 >= this.f10439c * 2) {
                return i12;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().f10457id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i13 = pivotCandidate.f10457id;
                if (zArr[i13]) {
                    return i12;
                }
                zArr[i13] = true;
            }
            if (pivotCandidate != null) {
                float f11 = Float.MAX_VALUE;
                int i14 = -1;
                for (int i15 = 0; i15 < this.f10440d; i15++) {
                    ArrayRow arrayRow = this.f10438b[i15];
                    if (arrayRow.f10428a.f10452e != SolverVariable.Type.UNRESTRICTED && !arrayRow.f10432e && arrayRow.i(pivotCandidate)) {
                        float f12 = arrayRow.variables.get(pivotCandidate);
                        if (f12 < 0.0f) {
                            float f13 = (-arrayRow.f10429b) / f12;
                            if (f13 < f11) {
                                i14 = i15;
                                f11 = f13;
                            }
                        }
                    }
                }
                if (i14 > -1) {
                    ArrayRow arrayRow2 = this.f10438b[i14];
                    arrayRow2.f10428a.f10449b = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.j(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.f10428a;
                    solverVariable.f10449b = i14;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z12 = true;
            }
        }
        return i12;
    }

    private void releaseRows() {
        int i11 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i11 < this.f10440d) {
                ArrayRow arrayRow = this.f10438b[i11];
                if (arrayRow != null) {
                    this.f10441e.f10433a.release(arrayRow);
                }
                this.f10438b[i11] = null;
                i11++;
            }
            return;
        }
        while (i11 < this.f10440d) {
            ArrayRow arrayRow2 = this.f10438b[i11];
            if (arrayRow2 != null) {
                this.f10441e.f10434b.release(arrayRow2);
            }
            this.f10438b[i11] = null;
            i11++;
        }
    }

    public void a(ArrayRow arrayRow, int i11, int i12) {
        arrayRow.a(createErrorVariable(i12, (String) null), i11);
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f11, int i11) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget3.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget3.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget3.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget3.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget4.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget4.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget4.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget4.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d11 = (double) f11;
        SolverVariable solverVariable = createObjectVariable7;
        double d12 = (double) i11;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d11) * d12));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, solverVariable, (float) (Math.cos(d11) * d12));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12, int i13) {
        int i14 = i13;
        ArrayRow createRow = createRow();
        createRow.d(solverVariable, solverVariable2, i11, f11, solverVariable3, solverVariable4, i12);
        if (i14 != 8) {
            createRow.addError(this, i14);
        }
        addConstraint(createRow);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.constraintlayout.core.Metrics r0 = sMetrics
            r1 = 1
            if (r0 == 0) goto L_0x0017
            long r3 = r0.constraints
            long r3 = r3 + r1
            r0.constraints = r3
            boolean r3 = r8.f10432e
            if (r3 == 0) goto L_0x0017
            long r3 = r0.simpleconstraints
            long r3 = r3 + r1
            r0.simpleconstraints = r3
        L_0x0017:
            int r0 = r7.f10440d
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.mMaxRows
            if (r0 >= r4) goto L_0x0026
            int r0 = r7.f10439c
            int r0 = r0 + r3
            int r4 = r7.mMaxColumns
            if (r0 < r4) goto L_0x0029
        L_0x0026:
            r7.increaseTableSize()
        L_0x0029:
            boolean r0 = r8.f10432e
            r4 = 0
            if (r0 != 0) goto L_0x00a1
            r8.updateFromSystem(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x0038
            return
        L_0x0038:
            r8.g()
            boolean r0 = r8.b(r7)
            if (r0 == 0) goto L_0x0098
            androidx.constraintlayout.core.SolverVariable r0 = r7.createExtraVariable()
            r8.f10428a = r0
            int r5 = r7.f10440d
            r7.addRow(r8)
            int r6 = r7.f10440d
            int r5 = r5 + r3
            if (r6 != r5) goto L_0x0098
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r4.initFromRow(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r7.optimize(r4, r3)
            int r4 = r0.f10449b
            r5 = -1
            if (r4 != r5) goto L_0x0099
            androidx.constraintlayout.core.SolverVariable r4 = r8.f10428a
            if (r4 != r0) goto L_0x0076
            androidx.constraintlayout.core.SolverVariable r0 = r8.pickPivot(r0)
            if (r0 == 0) goto L_0x0076
            androidx.constraintlayout.core.Metrics r4 = sMetrics
            if (r4 == 0) goto L_0x0073
            long r5 = r4.pivots
            long r5 = r5 + r1
            r4.pivots = r5
        L_0x0073:
            r8.j(r0)
        L_0x0076:
            boolean r0 = r8.f10432e
            if (r0 != 0) goto L_0x007f
            androidx.constraintlayout.core.SolverVariable r0 = r8.f10428a
            r0.updateReferencesWithNewDefinition(r7, r8)
        L_0x007f:
            boolean r0 = OPTIMIZED_ENGINE
            if (r0 == 0) goto L_0x008b
            androidx.constraintlayout.core.Cache r0 = r7.f10441e
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.f10433a
            r0.release(r8)
            goto L_0x0092
        L_0x008b:
            androidx.constraintlayout.core.Cache r0 = r7.f10441e
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.f10434b
            r0.release(r8)
        L_0x0092:
            int r0 = r7.f10440d
            int r0 = r0 - r3
            r7.f10440d = r0
            goto L_0x0099
        L_0x0098:
            r3 = r4
        L_0x0099:
            boolean r0 = r8.h()
            if (r0 != 0) goto L_0x00a0
            return
        L_0x00a0:
            r4 = r3
        L_0x00a1:
            if (r4 != 0) goto L_0x00a6
            r7.addRow(r8)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        if (!USE_BASIC_SYNONYMS || i12 != 8 || !solverVariable2.isFinalValue || solverVariable.f10449b != -1) {
            ArrayRow createRow = createRow();
            createRow.createRowEquals(solverVariable, solverVariable2, i11);
            if (i12 != 8) {
                createRow.addError(this, i12);
            }
            addConstraint(createRow);
            return createRow;
        }
        solverVariable.setFinalValue(this, solverVariable2.computedValue + ((float) i11));
        return null;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z11) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i11);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i11);
        if (i12 != 8) {
            a(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i12);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z11) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i11);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i11);
        if (i12 != 8) {
            a(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i12);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11, int i11) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f11);
        if (i11 != 8) {
            createRow.addError(this, i11);
        }
        addConstraint(createRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i11) {
        if (solverVariable.f10449b == -1 && i11 == 0) {
            if (solverVariable2.f10455h) {
                solverVariable2 = this.f10441e.f10436d[solverVariable2.f10456i];
            }
            if (solverVariable.f10455h) {
                SolverVariable solverVariable3 = this.f10441e.f10436d[solverVariable.f10456i];
            } else {
                solverVariable.setSynonym(this, solverVariable2, 0.0f);
            }
        } else {
            addEquality(solverVariable, solverVariable2, i11, 8);
        }
    }

    public void b(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, (long) this.f10439c);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, (long) this.f10440d);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public SolverVariable createErrorVariable(int i11, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.f10439c + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i12 = this.f10437a + 1;
        this.f10437a = i12;
        this.f10439c++;
        acquireSolverVariable.f10457id = i12;
        acquireSolverVariable.strength = i11;
        this.f10441e.f10436d[i12] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.f10439c + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, (String) null);
        int i11 = this.f10437a + 1;
        this.f10437a = i11;
        this.f10439c++;
        acquireSolverVariable.f10457id = i11;
        this.f10441e.f10436d[i11] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f10439c + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.f10441e);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i11 = solverVariable.f10457id;
            if (i11 == -1 || i11 > this.f10437a || this.f10441e.f10436d[i11] == null) {
                if (i11 != -1) {
                    solverVariable.reset();
                }
                int i12 = this.f10437a + 1;
                this.f10437a = i12;
                this.f10439c++;
                solverVariable.f10457id = i12;
                solverVariable.f10452e = SolverVariable.Type.UNRESTRICTED;
                this.f10441e.f10436d[i12] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        if (OPTIMIZED_ENGINE) {
            arrayRow = this.f10441e.f10433a.acquire();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this.f10441e);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        } else {
            arrayRow = this.f10441e.f10434b.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.f10441e);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        }
        SolverVariable.a();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.f10439c + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, (String) null);
        int i11 = this.f10437a + 1;
        this.f10437a = i11;
        this.f10439c++;
        acquireSolverVariable.f10457id = i11;
        this.f10441e.f10436d[i11] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = " num vars " + this.f10437a + StringUtils.LF;
        for (int i11 = 0; i11 < this.f10437a + 1; i11++) {
            SolverVariable solverVariable = this.f10441e.f10436d[i11];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i11 + "] => " + solverVariable + " = " + solverVariable.computedValue + StringUtils.LF;
            }
        }
        String str2 = str + StringUtils.LF;
        for (int i12 = 0; i12 < this.f10437a + 1; i12++) {
            SolverVariable[] solverVariableArr = this.f10441e.f10436d;
            SolverVariable solverVariable2 = solverVariableArr[i12];
            if (solverVariable2 != null && solverVariable2.f10455h) {
                str2 = str2 + " ~[" + i12 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.f10456i] + " + " + solverVariable2.f10458j + StringUtils.LF;
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i13 = 0; i13 < this.f10440d; i13++) {
            str3 = (str3 + this.f10438b[i13].l()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str3 = str3 + "Goal: " + this.mGoal + StringUtils.LF;
        }
        System.out.println(str3);
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i11 = 0; i11 < this.f10440d; i11++) {
            if (this.f10438b[i11].f10428a.f10452e == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.f10438b[i11].l()) + StringUtils.LF;
            }
        }
        System.out.println(str + this.mGoal + StringUtils.LF);
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.f10441e;
    }

    public int getMemoryUsed() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.f10440d; i12++) {
            ArrayRow arrayRow = this.f10438b[i12];
            if (arrayRow != null) {
                i11 += arrayRow.k();
            }
        }
        return i11;
    }

    public int getNumEquations() {
        return this.f10440d;
    }

    public int getNumVariables() {
        return this.f10437a;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
        } else if (this.graphOptimizer || this.newgraphOptimizer) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.graphOptimizer++;
            }
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= this.f10440d) {
                    z11 = true;
                    break;
                } else if (!this.f10438b[i11].f10432e) {
                    break;
                } else {
                    i11++;
                }
            }
            if (!z11) {
                b(this.mGoal);
                return;
            }
            Metrics metrics3 = sMetrics;
            if (metrics3 != null) {
                metrics3.fullySolved++;
            }
            computeValues();
        } else {
            b(this.mGoal);
        }
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i11;
        if (arrayRow.f10432e && (solverVariable = arrayRow.f10428a) != null) {
            int i12 = solverVariable.f10449b;
            if (i12 != -1) {
                while (true) {
                    i11 = this.f10440d;
                    if (i12 >= i11 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.f10438b;
                    int i13 = i12 + 1;
                    ArrayRow arrayRow2 = arrayRowArr[i13];
                    SolverVariable solverVariable2 = arrayRow2.f10428a;
                    if (solverVariable2.f10449b == i13) {
                        solverVariable2.f10449b = i12;
                    }
                    arrayRowArr[i12] = arrayRow2;
                    i12 = i13;
                }
                this.f10440d = i11 - 1;
            }
            SolverVariable solverVariable3 = arrayRow.f10428a;
            if (!solverVariable3.isFinalValue) {
                solverVariable3.setFinalValue(this, arrayRow.f10429b);
            }
            if (OPTIMIZED_ENGINE) {
                this.f10441e.f10433a.release(arrayRow);
            } else {
                this.f10441e.f10434b.release(arrayRow);
            }
        }
    }

    public void reset() {
        Cache cache;
        int i11 = 0;
        while (true) {
            cache = this.f10441e;
            SolverVariable[] solverVariableArr = cache.f10436d;
            if (i11 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i11];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i11++;
        }
        cache.f10435c.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.f10441e.f10436d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f10437a = 0;
        this.mGoal.clear();
        this.f10439c = 1;
        for (int i12 = 0; i12 < this.f10440d; i12++) {
            ArrayRow arrayRow = this.f10438b[i12];
            if (arrayRow != null) {
                arrayRow.f10430c = false;
            }
        }
        releaseRows();
        this.f10440d = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.f10441e);
        } else {
            this.mTempGoal = new ArrayRow(this.f10441e);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i11) {
        if (!USE_BASIC_SYNONYMS || solverVariable.f10449b != -1) {
            int i12 = solverVariable.f10449b;
            if (i12 != -1) {
                ArrayRow arrayRow = this.f10438b[i12];
                if (arrayRow.f10432e) {
                    arrayRow.f10429b = (float) i11;
                } else if (arrayRow.variables.getCurrentSize() == 0) {
                    arrayRow.f10432e = true;
                    arrayRow.f10429b = (float) i11;
                } else {
                    ArrayRow createRow = createRow();
                    createRow.createRowEquals(solverVariable, i11);
                    addConstraint(createRow);
                }
            } else {
                ArrayRow createRow2 = createRow();
                createRow2.e(solverVariable, i11);
                addConstraint(createRow2);
            }
        } else {
            float f11 = (float) i11;
            solverVariable.setFinalValue(this, f11);
            for (int i13 = 0; i13 < this.f10437a + 1; i13++) {
                SolverVariable solverVariable2 = this.f10441e.f10436d[i13];
                if (solverVariable2 != null && solverVariable2.f10455h && solverVariable2.f10456i == solverVariable.f10457id) {
                    solverVariable2.setFinalValue(this, solverVariable2.f10458j + f11);
                }
            }
        }
    }
}
