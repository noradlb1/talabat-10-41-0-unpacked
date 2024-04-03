package com.instabug.terminations.sync;

import com.instabug.library.model.State;
import kotlin.jvm.internal.Intrinsics;

public abstract class e {
    /* access modifiers changed from: private */
    public static final String c(State.StateItem stateItem) {
        Intrinsics.checkNotNullParameter(stateItem, "<this>");
        return stateItem.getKey();
    }

    /* access modifiers changed from: private */
    public static final Object d(State.StateItem stateItem) {
        Intrinsics.checkNotNullParameter(stateItem, "<this>");
        return stateItem.getValue();
    }
}
