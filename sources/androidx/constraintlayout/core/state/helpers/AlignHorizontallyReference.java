package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

public class AlignHorizontallyReference extends HelperReference {
    private float mBias = 0.5f;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    public void apply() {
        Iterator<Object> it = this.f10715e0.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.f10713c0.constraints(it.next());
            constraints.clearHorizontal();
            Object obj = this.N;
            if (obj != null) {
                constraints.startToStart(obj);
            } else {
                Object obj2 = this.O;
                if (obj2 != null) {
                    constraints.startToEnd(obj2);
                } else {
                    constraints.startToStart(State.PARENT);
                }
            }
            Object obj3 = this.P;
            if (obj3 != null) {
                constraints.endToStart(obj3);
            } else {
                Object obj4 = this.Q;
                if (obj4 != null) {
                    constraints.endToEnd(obj4);
                } else {
                    constraints.endToEnd(State.PARENT);
                }
            }
            float f11 = this.mBias;
            if (f11 != 0.5f) {
                constraints.horizontalBias(f11);
            }
        }
    }
}
