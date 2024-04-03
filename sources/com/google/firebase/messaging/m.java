package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class m implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f47443b;

    public /* synthetic */ m(Intent intent) {
        this.f47443b = intent;
    }

    public final void onComplete(Task task) {
        WakeLockHolder.completeWakefulIntent(this.f47443b);
    }
}
