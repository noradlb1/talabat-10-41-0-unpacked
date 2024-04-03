package com.instabug.survey;

import com.google.android.gms.tasks.Task;

public interface b {
    void onComplete(Task task);

    void onFailure(Exception exc);
}
