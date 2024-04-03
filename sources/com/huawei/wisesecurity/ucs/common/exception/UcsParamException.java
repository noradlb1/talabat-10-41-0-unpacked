package com.huawei.wisesecurity.ucs.common.exception;

public class UcsParamException extends UcsException {
    public UcsParamException(String str) {
        super(UcsErrorCode.PARAM_ILLEGAL, str);
    }
}
