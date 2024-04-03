package com.huawei.wisesecurity.ucs.credential.outer;

import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import java.io.IOException;

public interface NetworkCapability {
    NetworkResponse get(NetworkRequest networkRequest) throws IOException;

    void initConfig(int i11, int i12) throws UcsException;

    NetworkResponse post(NetworkRequest networkRequest) throws IOException;
}
