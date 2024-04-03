package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

public class VerticalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10743a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.state.State$Chain[] r0 = androidx.constraintlayout.core.state.State.Chain.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10743a = r0
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10743a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10743a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.PACKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.helpers.VerticalChainReference.AnonymousClass1.<clinit>():void");
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    public void apply() {
        Iterator<Object> it = this.f10715e0.iterator();
        while (it.hasNext()) {
            this.f10713c0.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it2 = this.f10715e0.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraints = this.f10713c0.constraints(it2.next());
            if (constraintReference2 == null) {
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
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.bottomToTop(constraints.getKey());
                constraints.topToBottom(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj3 = this.T;
            if (obj3 != null) {
                constraintReference.bottomToTop(obj3);
            } else {
                Object obj4 = this.U;
                if (obj4 != null) {
                    constraintReference.bottomToBottom(obj4);
                } else {
                    constraintReference.bottomToBottom(State.PARENT);
                }
            }
        }
        if (constraintReference2 != null) {
            float f11 = this.f10739f0;
            if (f11 != 0.5f) {
                constraintReference2.verticalBias(f11);
            }
            int i11 = AnonymousClass1.f10743a[this.f10740g0.ordinal()];
            if (i11 == 1) {
                constraintReference2.setVerticalChainStyle(0);
            } else if (i11 == 2) {
                constraintReference2.setVerticalChainStyle(1);
            } else if (i11 == 3) {
                constraintReference2.setVerticalChainStyle(2);
            }
        }
    }
}
