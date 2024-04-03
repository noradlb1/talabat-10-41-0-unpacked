package com.huawei.secure.android.common.activity.protect;

import android.os.Message;

public interface IActivityProtect {
    void finishLaunchActivity(Message message);

    void finishPauseActivity(Message message);

    void finishResumeActivity(Message message);

    void finishStopActivity(Message message);
}
