package com.huawei.location.lite.common.chain;

public interface Task {

    public interface Chain {
        TaskRequest getRequest();

        int proceed();

        Result runTask(boolean z11);
    }

    void runTask(Chain chain);
}
