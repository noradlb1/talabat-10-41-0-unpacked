package com.huawei.location.lite.common.chain;

import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;

public class TaskRequest {
    private Data data;
    private boolean isAsync = false;
    private boolean isTimeOut = false;
    private int maxTimeOut = 120000;
    private Result result;
    private TaskFinishCallBack taskFinishCallBack;

    private void handleAsyncResult(int i11, Task.Chain chain) {
        boolean z11;
        switch (i11) {
            case 100:
                Result result2 = this.result;
                if (result2 instanceof Result.Success) {
                    this.taskFinishCallBack.onSuccess(((Result.Success) result2).getOutputData());
                    return;
                }
                return;
            case 101:
                Result result3 = this.result;
                if (result3 instanceof Result.Failure) {
                    this.taskFinishCallBack.onFail(((Result.Failure) result3).getOutputData());
                    return;
                }
                return;
            case 102:
                z11 = true;
                break;
            case 103:
                z11 = false;
                break;
            default:
                return;
        }
        chain.runTask(z11);
    }

    private void handleSyncResult(int i11, Task.Chain chain) {
        boolean z11;
        if (i11 == 102) {
            z11 = true;
        } else if (i11 == 103) {
            z11 = false;
        } else {
            return;
        }
        chain.runTask(z11);
    }

    public Data getInputData() {
        return this.data;
    }

    public int getMaxTimeOut() {
        return this.maxTimeOut;
    }

    public Data getOutputData() {
        Result result2 = this.result;
        return result2 instanceof Result.Success ? ((Result.Success) result2).getOutputData() : result2 instanceof Result.Failure ? ((Result.Failure) result2).getOutputData() : this.data;
    }

    public Result getResult() {
        return this.result;
    }

    public TaskFinishCallBack getTaskFinishCallBack() {
        return this.taskFinishCallBack;
    }

    public boolean isAsync() {
        return this.isAsync;
    }

    public void setAsync(boolean z11) {
        this.isAsync = z11;
    }

    public void setInputData(Data data2) {
        this.data = data2;
    }

    public void setIsTimeOut(boolean z11) {
        this.isTimeOut = z11;
    }

    public void setMaxTimeOut(int i11) {
        this.maxTimeOut = i11;
    }

    public void setResult(Result result2, Task.Chain chain) {
        this.result = result2;
        if (this.taskFinishCallBack != null && !this.isTimeOut) {
            int proceed = chain.proceed();
            if (this.isAsync) {
                handleAsyncResult(proceed, chain);
            } else {
                handleSyncResult(proceed, chain);
            }
        }
    }

    public void setTaskFinishCallBack(TaskFinishCallBack taskFinishCallBack2) {
        this.taskFinishCallBack = taskFinishCallBack2;
    }
}
