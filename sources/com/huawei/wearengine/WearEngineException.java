package com.huawei.wearengine;

import com.huawei.wearengine.common.WearEngineErrorCode;

public class WearEngineException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private int f35107a;

    public WearEngineException(int i11) {
        super(WearEngineErrorCode.getErrorMsgFromCode(i11));
        this.f35107a = i11;
    }

    public static WearEngineException convertIllegalStateException(IllegalStateException illegalStateException) {
        return new WearEngineException(WearEngineErrorCode.convertStringToErrorCode(illegalStateException.getMessage()));
    }

    public int getErrorCode() {
        return this.f35107a;
    }
}
