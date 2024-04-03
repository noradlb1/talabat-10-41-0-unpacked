package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

public class HorizontalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10742a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.state.State$Chain[] r0 = androidx.constraintlayout.core.state.State.Chain.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10742a = r0
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10742a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10742a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.PACKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.helpers.HorizontalChainReference.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    public void apply() {
        Iterator<Object> it = this.f10715e0.iterator();
        while (it.hasNext()) {
            this.f10713c0.constraints(it.next()).clearHorizontal();
        }
        Iterator<Object> it2 = this.f10715e0.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraints = this.f10713c0.constraints(it2.next());
            if (constraintReference2 == null) {
                Object obj = this.N;
                if (obj != null) {
                    constraints.startToStart(obj).margin(this.f10690l);
                } else {
                    Object obj2 = this.O;
                    if (obj2 != null) {
                        constraints.startToEnd(obj2).margin(this.f10690l);
                    } else {
                        Object obj3 = this.J;
                        if (obj3 != null) {
                            constraints.startToStart(obj3).margin(this.f10688j);
                        } else {
                            Object obj4 = this.K;
                            if (obj4 != null) {
                                constraints.startToEnd(obj4).margin(this.f10688j);
                            } else {
                                constraints.startToStart(State.PARENT);
                            }
                        }
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.endToStart(constraints.getKey());
                constraints.startToEnd(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj5 = this.P;
            if (obj5 != null) {
                constraintReference.endToStart(obj5).margin(this.f10691m);
            } else {
                Object obj6 = this.Q;
                if (obj6 != null) {
                    constraintReference.endToEnd(obj6).margin(this.f10691m);
                } else {
                    Object obj7 = this.L;
                    if (obj7 != null) {
                        constraintReference.endToStart(obj7).margin(this.f10689k);
                    } else {
                        Object obj8 = this.M;
                        if (obj8 != null) {
                            constraintReference.endToEnd(obj8).margin(this.f10689k);
                        } else {
                            constraintReference.endToEnd(State.PARENT);
                        }
                    }
                }
            }
        }
        if (constraintReference2 != null) {
            float f11 = this.f10739f0;
            if (f11 != 0.5f) {
                constraintReference2.horizontalBias(f11);
            }
            int i11 = AnonymousClass1.f10742a[this.f10740g0.ordinal()];
            if (i11 == 1) {
                constraintReference2.setHorizontalChainStyle(0);
            } else if (i11 == 2) {
                constraintReference2.setHorizontalChainStyle(1);
            } else if (i11 == 3) {
                constraintReference2.setHorizontalChainStyle(2);
            }
        }
    }
}
