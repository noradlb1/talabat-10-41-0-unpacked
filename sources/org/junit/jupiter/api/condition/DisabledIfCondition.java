package org.junit.jupiter.api.condition;

import y20.c;
import y20.d;

class DisabledIfCondition extends MethodBasedCondition<DisabledIf> {
    public DisabledIfCondition() {
        super(DisabledIf.class, new c(), new d());
    }

    public boolean j(boolean z11) {
        return !z11;
    }
}
