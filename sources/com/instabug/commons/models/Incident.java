package com.instabug.commons.models;

import org.jetbrains.annotations.NotNull;

public interface Incident {

    public enum Type {
        FatalCrash,
        NonFatalCrash,
        ANR,
        Termination,
        NDKCrash,
        FatalHang
    }

    @NotNull
    IncidentMetadata getMetadata();

    @NotNull
    Type getType();
}
