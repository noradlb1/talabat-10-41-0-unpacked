package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

public class GuidelineReference implements Facade, Reference {

    /* renamed from: a  reason: collision with root package name */
    public final State f10741a;
    private Object key;
    private int mEnd = -1;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    private float mPercent = 0.0f;
    private int mStart = -1;

    public GuidelineReference(State state) {
        this.f10741a = state;
    }

    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int i11 = this.mStart;
        if (i11 != -1) {
            this.mGuidelineWidget.setGuideBegin(i11);
            return;
        }
        int i12 = this.mEnd;
        if (i12 != -1) {
            this.mGuidelineWidget.setGuideEnd(i12);
        } else {
            this.mGuidelineWidget.setGuidePercent(this.mPercent);
        }
    }

    public GuidelineReference end(Object obj) {
        this.mStart = -1;
        this.mEnd = this.f10741a.convertDimension(obj);
        this.mPercent = 0.0f;
        return this;
    }

    public ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget == null) {
            this.mGuidelineWidget = new Guideline();
        }
        return this.mGuidelineWidget;
    }

    public Facade getFacade() {
        return null;
    }

    public Object getKey() {
        return this.key;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public GuidelineReference percent(float f11) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = f11;
        return this;
    }

    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof Guideline) {
            this.mGuidelineWidget = (Guideline) constraintWidget;
        } else {
            this.mGuidelineWidget = null;
        }
    }

    public void setKey(Object obj) {
        this.key = obj;
    }

    public void setOrientation(int i11) {
        this.mOrientation = i11;
    }

    public GuidelineReference start(Object obj) {
        this.mStart = this.f10741a.convertDimension(obj);
        this.mEnd = -1;
        this.mPercent = 0.0f;
        return this;
    }
}
