package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

public interface CustomAuthProvider {
    Task<Token> getTokens(boolean z11);

    String getUid();
}
