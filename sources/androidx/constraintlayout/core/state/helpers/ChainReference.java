package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;

public class ChainReference extends HelperReference {

    /* renamed from: f0  reason: collision with root package name */
    public float f10739f0 = 0.5f;

    /* renamed from: g0  reason: collision with root package name */
    public State.Chain f10740g0 = State.Chain.SPREAD;

    public ChainReference(State state, State.Helper helper) {
        super(state, helper);
    }

    public float getBias() {
        return this.f10739f0;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public ChainReference style(State.Chain chain) {
        this.f10740g0 = chain;
        return this;
    }

    public ChainReference bias(float f11) {
        this.f10739f0 = f11;
        return this;
    }
}
