package com.instabug.library.migration;

import android.annotation.SuppressLint;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;

class m implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f51495a;

    public m(n nVar) {
        this.f51495a = nVar;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void subscribe(ObservableEmitter observableEmitter) {
        if (this.f51495a.f51496a != null) {
            File file = new File(this.f51495a.f51496a.getCacheDir() + "/issues.cache");
            File file2 = new File(this.f51495a.f51496a.getCacheDir() + "/conversations.cache");
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
            }
            observableEmitter.onNext(this.f51495a);
            observableEmitter.onComplete();
        }
    }
}
