package com.huawei.location.lite.common.chain;

import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import java.util.List;

public class TaskChain implements Task.Chain {
    private static final String TAG = "TaskChain";
    private int index = -1;
    private TaskRequest request;
    private List<Task> taskList;

    public TaskChain(List<Task> list, TaskRequest taskRequest) {
        this.taskList = list;
        this.request = taskRequest;
    }

    public TaskRequest getRequest() {
        return this.request;
    }

    public int proceed() {
        Result result = this.request.getResult();
        if (result instanceof Result.Failure) {
            return 101;
        }
        if (result instanceof Result.Retry) {
            return 102;
        }
        return this.index == this.taskList.size() + -1 ? 100 : 103;
    }

    public Result runTask(boolean z11) {
        if (!z11) {
            this.index++;
        }
        this.taskList.get(this.index).runTask(this);
        return getRequest().getResult();
    }
}
