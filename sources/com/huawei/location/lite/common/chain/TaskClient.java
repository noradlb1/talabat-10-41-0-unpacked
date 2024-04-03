package com.huawei.location.lite.common.chain;

import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TaskClient {
    private static final String TAG = "TaskChain";
    /* access modifiers changed from: private */
    public TaskRequest taskRequest;
    /* access modifiers changed from: private */
    public List<Task> tasks;

    public static final class Builder {
        /* access modifiers changed from: private */
        public TaskRequest taskRequest;
        /* access modifiers changed from: private */
        public List<Task> tasks = new ArrayList();

        public Builder addTask(Task task) {
            if (task != null) {
                if (this.tasks == null) {
                    this.tasks = new ArrayList();
                }
                this.tasks.add(task);
                return this;
            }
            throw new IllegalArgumentException("task == null");
        }

        public TaskClient build() {
            return new TaskClient(this);
        }

        public Builder withTaskRequest(TaskRequest taskRequest2) {
            this.taskRequest = taskRequest2;
            return this;
        }
    }

    private TaskClient(Builder builder) {
        this.tasks = Collections.unmodifiableList(builder.tasks);
        this.taskRequest = builder.taskRequest;
    }

    private void enqueue() throws TaskTimeOutException {
        String str;
        String str2;
        StringBuilder sb2;
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            public String call() {
                new TaskChain(TaskClient.this.tasks, TaskClient.this.taskRequest).runTask(false);
                return TaskClient.TAG;
            }
        });
        ExecutorUtil.getInstance().execute(futureTask);
        try {
            futureTask.get((long) this.taskRequest.getMaxTimeOut(), TimeUnit.MILLISECONDS);
            return;
        } catch (ExecutionException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "Task ExecutionException";
        } catch (InterruptedException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str2 = "Task InterruptedException";
        } catch (TimeoutException e13) {
            if (futureTask.isDone()) {
                str = "Task TimeoutException" + e13.getMessage();
                LogConsole.e(TAG, str);
            }
            this.taskRequest.setIsTimeOut(true);
            futureTask.cancel(true);
            throw new TaskTimeOutException("task timeout");
        }
        sb2.append(str2);
        sb2.append(e.getMessage());
        str = sb2.toString();
        LogConsole.e(TAG, str);
    }

    private void execute() throws TaskTimeOutException {
        String str;
        String str2;
        StringBuilder sb2;
        FutureTask futureTask = new FutureTask(new Callable<Result>() {
            public Result call() {
                return new TaskChain(TaskClient.this.tasks, TaskClient.this.taskRequest).runTask(false);
            }
        });
        ExecutorUtil.getInstance().execute(futureTask);
        try {
            Result result = (Result) futureTask.get((long) this.taskRequest.getMaxTimeOut(), TimeUnit.MILLISECONDS);
            if ((result instanceof Result.Failure) && this.taskRequest.getTaskFinishCallBack() != null) {
                this.taskRequest.getTaskFinishCallBack().onFail(((Result.Failure) result).getOutputData());
            } else if ((result instanceof Result.Success) && this.taskRequest.getTaskFinishCallBack() != null) {
                this.taskRequest.getTaskFinishCallBack().onSuccess(((Result.Success) result).getOutputData());
            }
        } catch (ExecutionException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "Task ExecutionException";
            sb2.append(str2);
            sb2.append(e.getMessage());
            str = sb2.toString();
            LogConsole.e(TAG, str);
        } catch (InterruptedException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str2 = "Task InterruptedException";
            sb2.append(str2);
            sb2.append(e.getMessage());
            str = sb2.toString();
            LogConsole.e(TAG, str);
        } catch (TimeoutException e13) {
            if (futureTask.isDone()) {
                str = "Task TimeoutException" + e13.getMessage();
                LogConsole.e(TAG, str);
            }
            this.taskRequest.setIsTimeOut(true);
            futureTask.cancel(true);
            throw new TaskTimeOutException("task timeout");
        }
    }

    public TaskRequest getTaskRequest() {
        return this.taskRequest;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void runTasks() throws TaskTimeOutException {
        if (!this.tasks.isEmpty()) {
            if (this.taskRequest.isAsync()) {
                enqueue();
            } else {
                execute();
            }
        }
    }

    public void setTaskRequest(TaskRequest taskRequest2) {
        this.taskRequest = taskRequest2;
    }
}
