package com.instabug.crash.utils;

import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.State;
import com.instabug.library.user.UserManagerWrapper;

public abstract class b {
    public static State a(State state) {
        if (InstabugCore.getFeatureState(Feature.CRASHES_CUSTOM_IDENTIFIED_EMAIL) == Feature.State.ENABLED && state != null) {
            state.setUserEmail(UserManagerWrapper.getIdentifiedUserEmail());
        }
        return state;
    }
}
