package com.huawei.hms.push.task;

public class ConsentTask extends BaseVoidTask {
    public ConsentTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public int getApiLevel() {
        return 3;
    }

    public int getMinApkVersion() {
        return 60300300;
    }
}
