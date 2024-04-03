package com.instabug.library.visualusersteps;

import android.annotation.SuppressLint;
import android.content.Context;
import com.instabug.library.util.DiskUtils;

class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f52183b;

    public r(y yVar, Context context) {
        this.f52183b = context;
    }

    @SuppressLint({"RV_RETURN_VALUE_IGNORED"})
    public void run() {
        DiskUtils.getCleanDirectoryObservable(VisualUserStepsHelper.getVisualUserStepsDirectory(this.f52183b)).subscribe(new q(this));
    }
}
