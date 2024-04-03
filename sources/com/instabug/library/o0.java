package com.instabug.library;

import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.common.a;
import com.instabug.library.model.session.SessionLocalEntity;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

class o0 implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f50583a;

    public o0(r0 r0Var, a aVar) {
        this.f50583a = aVar;
    }

    public void subscribe(@NonNull SingleEmitter singleEmitter) {
        Context applicationContext = Instabug.getApplicationContext();
        boolean isUsersPageEnabled = InstabugCore.isUsersPageEnabled();
        if (applicationContext != null) {
            singleEmitter.onSuccess(new SessionLocalEntity.Factory().create(applicationContext, this.f50583a, isUsersPageEnabled));
        }
    }
}
