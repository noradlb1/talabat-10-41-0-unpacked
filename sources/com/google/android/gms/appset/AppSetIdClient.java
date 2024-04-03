package com.google.android.gms.appset;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

public interface AppSetIdClient {
    @NonNull
    Task<AppSetIdInfo> getAppSetIdInfo();
}
