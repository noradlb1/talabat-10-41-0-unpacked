package com.instabug.library;

import androidx.annotation.NonNull;
import com.instabug.library.model.session.NullSessionException;
import com.instabug.library.model.session.SessionLocalEntity;
import com.instabug.library.session.h;
import io.reactivex.Completable;
import io.reactivex.functions.Function;

class n0 implements Function {
    public n0(r0 r0Var) {
    }

    /* renamed from: a */
    public Completable apply(@NonNull SessionLocalEntity sessionLocalEntity) {
        if (sessionLocalEntity != null) {
            return new h().a(sessionLocalEntity);
        }
        return Completable.error((Throwable) new NullSessionException("sessionLocalEntity can't be null!"));
    }
}
