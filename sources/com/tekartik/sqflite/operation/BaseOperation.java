package com.tekartik.sqflite.operation;

public abstract class BaseOperation extends BaseReadOperation {
    public void error(String str, String str2, Object obj) {
        getOperationResult().error(str, str2, obj);
    }

    public abstract OperationResult getOperationResult();

    public void success(Object obj) {
        getOperationResult().success(obj);
    }
}
