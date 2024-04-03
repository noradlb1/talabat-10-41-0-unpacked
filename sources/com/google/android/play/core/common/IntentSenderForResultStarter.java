package com.google.android.play.core.common;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IntentSenderForResultStarter {
    void startIntentSenderForResult(@NonNull IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException;
}
