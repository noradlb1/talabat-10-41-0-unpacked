package com.google.android.gms.auth.api.phone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;

public interface SmsRetrieverApi {
    @NonNull
    Task<Void> startSmsRetriever();

    @NonNull
    Task<Void> startSmsUserConsent(@Nullable String str);
}
