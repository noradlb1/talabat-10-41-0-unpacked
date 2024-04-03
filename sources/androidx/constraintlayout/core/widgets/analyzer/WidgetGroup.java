package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class WidgetGroup {
    private static final boolean DEBUG = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f10817f;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ConstraintWidget> f10818a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f10819b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10820c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f10821d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<MeasureResult> f10822e = null;
    private int moveTo = -1;

    public class MeasureResult {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<ConstraintWidget> f10823a;

        /* renamed from: b  reason: collision with root package name */
        public int f10824b;

        /* renamed from: c  reason: collision with root package name */
        public int f10825c;

        /* renamed from: d  reason: collision with root package name */
        public int f10826d;

        /* renamed from: e  reason: collision with root package name */
        public int f10827e;

        /* renamed from: f  reason: collision with root package name */
        public int f10828f;

        /* renamed from: g  reason: collision with root package name */
        public int f10829g;

        public MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i11) {
            this.f10823a = new WeakReference<>(constraintWidget);
            this.f10824b = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.f10825c = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.f10826d = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.f10827e = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.f10828f = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.f10829g = i11;
        }

        public void apply() {
            ConstraintWidget constraintWidget = this.f10823a.get();
            if (constraintWidget != null) {
                constraintWidget.setFinalFrame(this.f10824b, this.f10825c, this.f10826d, this.f10827e, this.f10828f, this.f10829g);
            }
        }
    }

    public WidgetGroup(int i11) {
        int i12 = f10817f;
        f10817f = i12 + 1;
        this.f10819b = i12;
        this.f10821d = i11;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        return this.f10818a.contains(constraintWidget);
    }

    private String getOrientationString() {
        int i11 = this.f10821d;
        return i11 == 0 ? "Horizontal" : i11 == 1 ? "Vertical" : i11 == 2 ? "Both" : "Unknown";
    }

    private int measureWrap(int i11, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i11);
        if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) {
            return -1;
        }
        if (i11 == 0) {
            return constraintWidget.getWidth();
        }
        return constraintWidget.getHeight();
    }

    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i11) {
        int objectVariableValue;
        int objectVariableValue2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList.get(i12).addToSolver(linearSystem, false);
        }
        if (i11 == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i11 == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f10822e = new ArrayList<>();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            this.f10822e.add(new MeasureResult(arrayList.get(i13), linearSystem, i11));
        }
        if (i11 == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.f10818a.contains(constraintWidget)) {
            return false;
        }
        this.f10818a.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.f10822e != null && this.f10820c) {
            for (int i11 = 0; i11 < this.f10822e.size(); i11++) {
                this.f10822e.get(i11).apply();
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.f10818a.size();
        if (this.moveTo != -1 && size > 0) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                WidgetGroup widgetGroup = arrayList.get(i11);
                if (this.moveTo == widgetGroup.f10819b) {
                    moveTo(this.f10821d, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.f10818a.clear();
    }

    public int getId() {
        return this.f10819b;
    }

    public int getOrientation() {
        return this.f10821d;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        for (int i11 = 0; i11 < this.f10818a.size(); i11++) {
            if (widgetGroup.contains(this.f10818a.get(i11))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.f10820c;
    }

    public void moveTo(int i11, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.f10818a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.add(next);
            if (i11 == 0) {
                next.horizontalGroup = widgetGroup.getId();
            } else {
                next.verticalGroup = widgetGroup.getId();
            }
        }
        this.moveTo = widgetGroup.f10819b;
    }

    public void setAuthoritative(boolean z11) {
        this.f10820c = z11;
    }

    public void setOrientation(int i11) {
        this.f10821d = i11;
    }

    public int size() {
        return this.f10818a.size();
    }

    public String toString() {
        String str = getOrientationString() + " [" + this.f10819b + "] <";
        Iterator<ConstraintWidget> it = this.f10818a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().getDebugName();
        }
        return str + " >";
    }

    public int measureWrap(LinearSystem linearSystem, int i11) {
        if (this.f10818a.size() == 0) {
            return 0;
        }
        return solverMeasure(linearSystem, this.f10818a, i11);
    }
}
