package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public float N = -1.0f;
    public int O = -1;
    public int P = -1;
    public boolean Q = true;
    private ConstraintAnchor mAnchor = this.mTop;
    private int mMinimumPosition;
    private int mOrientation;
    private boolean resolved;

    /* renamed from: androidx.constraintlayout.core.widgets.Guideline$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10796a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10796a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10796a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Guideline.AnonymousClass1.<clinit>():void");
        }
    }

    public Guideline() {
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.f10771f.clear();
        this.f10771f.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.mListAnchors[i11] = this.mAnchor;
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean z11) {
        boolean z12;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer != null) {
            ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.mParent;
            boolean z13 = true;
            if (constraintWidget == null || constraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (this.mOrientation == 0) {
                anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
                anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.mParent;
                if (constraintWidget2 == null || constraintWidget2.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z13 = false;
                }
                z12 = z13;
            }
            if (this.resolved && this.mAnchor.hasFinalValue()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
                linearSystem.addEquality(createObjectVariable, this.mAnchor.getFinalValue());
                if (this.O != -1) {
                    if (z12) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                    }
                } else if (this.P != -1 && z12) {
                    SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(anchor2);
                    linearSystem.addGreaterThan(createObjectVariable, linearSystem.createObjectVariable(anchor), 0, 5);
                    linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 5);
                }
                this.resolved = false;
            } else if (this.O != -1) {
                SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mAnchor);
                linearSystem.addEquality(createObjectVariable3, linearSystem.createObjectVariable(anchor), this.O, 8);
                if (z12) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable3, 0, 5);
                }
            } else if (this.P != -1) {
                SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mAnchor);
                SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(anchor2);
                linearSystem.addEquality(createObjectVariable4, createObjectVariable5, -this.P, 8);
                if (z12) {
                    linearSystem.addGreaterThan(createObjectVariable4, linearSystem.createObjectVariable(anchor), 0, 5);
                    linearSystem.addGreaterThan(createObjectVariable5, createObjectVariable4, 0, 5);
                }
            } else if (this.N != -1.0f) {
                linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor2), this.N));
            }
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.N = guideline.N;
        this.O = guideline.O;
        this.P = guideline.P;
        this.Q = guideline.Q;
        setOrientation(guideline.mOrientation);
    }

    public void cyclePosition() {
        if (this.O != -1) {
            g();
        } else if (this.N != -1.0f) {
            f();
        } else if (this.P != -1) {
            e();
        }
    }

    public void e() {
        int x11 = getX();
        if (this.mOrientation == 0) {
            x11 = getY();
        }
        setGuideBegin(x11);
    }

    public void f() {
        int width = getParent().getWidth() - getX();
        if (this.mOrientation == 0) {
            width = getParent().getHeight() - getY();
        }
        setGuideEnd(width);
    }

    public void g() {
        float x11 = ((float) getX()) / ((float) getParent().getWidth());
        if (this.mOrientation == 0) {
            x11 = ((float) getY()) / ((float) getParent().getHeight());
        }
        setGuidePercent(x11);
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.O;
    }

    public int getRelativeBehaviour() {
        if (this.N != -1.0f) {
            return 0;
        }
        if (this.O != -1) {
            return 1;
        }
        if (this.P != -1) {
            return 2;
        }
        return -1;
    }

    public int getRelativeEnd() {
        return this.P;
    }

    public float getRelativePercent() {
        return this.N;
    }

    public String getType() {
        return "Guideline";
    }

    public boolean isPercent() {
        return this.N != -1.0f && this.O == -1 && this.P == -1;
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void setFinalValue(int i11) {
        this.mAnchor.setFinalValue(i11);
        this.resolved = true;
    }

    public void setGuideBegin(int i11) {
        if (i11 > -1) {
            this.N = -1.0f;
            this.O = i11;
            this.P = -1;
        }
    }

    public void setGuideEnd(int i11) {
        if (i11 > -1) {
            this.N = -1.0f;
            this.O = -1;
            this.P = i11;
        }
    }

    public void setGuidePercent(int i11) {
        setGuidePercent(((float) i11) / 100.0f);
    }

    public void setMinimumPosition(int i11) {
        this.mMinimumPosition = i11;
    }

    public void setOrientation(int i11) {
        if (this.mOrientation != i11) {
            this.mOrientation = i11;
            this.f10771f.clear();
            if (this.mOrientation == 1) {
                this.mAnchor = this.mLeft;
            } else {
                this.mAnchor = this.mTop;
            }
            this.f10771f.add(this.mAnchor);
            int length = this.mListAnchors.length;
            for (int i12 = 0; i12 < length; i12++) {
                this.mListAnchors[i12] = this.mAnchor;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z11) {
        if (getParent() != null) {
            int objectVariableValue = linearSystem.getObjectVariableValue(this.mAnchor);
            if (this.mOrientation == 1) {
                setX(objectVariableValue);
                setY(0);
                setHeight(getParent().getHeight());
                setWidth(0);
                return;
            }
            setX(0);
            setY(objectVariableValue);
            setWidth(getParent().getWidth());
            setHeight(0);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        int i11 = AnonymousClass1.f10796a[type.ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (this.mOrientation == 1) {
                return this.mAnchor;
            }
            return null;
        } else if ((i11 == 3 || i11 == 4) && this.mOrientation == 0) {
            return this.mAnchor;
        } else {
            return null;
        }
    }

    public void setGuidePercent(float f11) {
        if (f11 > -1.0f) {
            this.N = f11;
            this.O = -1;
            this.P = -1;
        }
    }
}
