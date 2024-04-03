package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

public class AlignVerticallyReference extends HelperReference {
    private float mBias = 0.5f;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    public void apply() {
        Iterator<Object> it = this.f10715e0.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.f10713c0.constraints(it.next());
            constraints.clearVertical();
            Object obj = this.R;
            if (obj != null) {
                constraints.topToTop(obj);
            } else {
                Object obj2 = this.S;
                if (obj2 != null) {
                    constraints.topToBottom(obj2);
                } else {
                    constraints.topToTop(State.PARENT);
                }
            }
            Object obj3 = this.T;
            if (obj3 != null) {
                constraints.bottomToTop(obj3);
            } else {
                Object obj4 = this.U;
                if (obj4 != null) {
                    constraints.bottomToBottom(obj4);
                } else {
                    constraints.bottomToBottom(State.PARENT);
                }
            }
            float f11 = this.mBias;
            if (f11 != 0.5f) {
                constraints.verticalBias(f11);
            }
        }
    }
}
