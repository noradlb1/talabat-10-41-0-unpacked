package com.huawei.location.activity;

import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.util.yn;

public abstract class BaseApiTaskCall extends BaseRouterTaskCallImpl {
    protected int errorCode = 0;
    protected String errorReason = "";
    protected yn.C0091yn reportBuilder = new yn.C0091yn();
}
