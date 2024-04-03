package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

public class HelperReference extends ConstraintReference implements Facade {

    /* renamed from: c0  reason: collision with root package name */
    public final State f10713c0;

    /* renamed from: d0  reason: collision with root package name */
    public final State.Helper f10714d0;

    /* renamed from: e0  reason: collision with root package name */
    public ArrayList<Object> f10715e0 = new ArrayList<>();
    private HelperWidget mHelperWidget;

    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.f10713c0 = state;
        this.f10714d0 = helper;
    }

    public HelperReference add(Object... objArr) {
        Collections.addAll(this.f10715e0, objArr);
        return this;
    }

    public void apply() {
    }

    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public State.Helper getType() {
        return this.f10714d0;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }
}
