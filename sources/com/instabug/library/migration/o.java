package com.instabug.library.migration;

import android.content.Context;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.internal.storage.cache.CacheManager;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;

class o implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f51497a;

    public o(p pVar) {
        this.f51497a = pVar;
    }

    public void subscribe(ObservableEmitter observableEmitter) {
        if (this.f51497a.f51498a != null && this.f51497a.f51498a.get() != null) {
            AttachmentManager.deleteRecursive(new File(AttachmentManager.getAttachmentDirectory((Context) this.f51497a.f51498a.get()) + "/usersteps"));
            CacheManager.getInstance().invalidateAllCaches();
            observableEmitter.onNext(this.f51497a);
            observableEmitter.onComplete();
        }
    }
}
