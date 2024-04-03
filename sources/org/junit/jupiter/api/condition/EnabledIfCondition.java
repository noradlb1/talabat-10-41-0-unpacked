package org.junit.jupiter.api.condition;

import y20.j;
import y20.k;

class EnabledIfCondition extends MethodBasedCondition<EnabledIf> {
    public EnabledIfCondition() {
        super(EnabledIf.class, new j(), new k());
    }

    public boolean j(boolean z11) {
        return z11;
    }
}
