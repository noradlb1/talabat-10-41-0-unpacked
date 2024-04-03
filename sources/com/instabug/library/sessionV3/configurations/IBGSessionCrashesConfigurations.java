package com.instabug.library.sessionV3.configurations;

public interface IBGSessionCrashesConfigurations {
    int getAnrStoreLimit();

    int getFatalHangStoreLimit();

    int getNonFatalStoreLimit();

    void setAnrStoreLimit(int i11);

    void setFatalHangStoreLimit(int i11);

    void setNonFatalStoreLimit(int i11);
}
