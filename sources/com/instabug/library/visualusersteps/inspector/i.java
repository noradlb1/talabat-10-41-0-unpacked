package com.instabug.library.visualusersteps.inspector;

import android.view.View;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import java.util.Iterator;

class i implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Iterator f52166a;

    public i(Iterator it) {
        this.f52166a = it;
    }

    public void subscribe(MaybeEmitter maybeEmitter) {
        if (this.f52166a.hasNext()) {
            maybeEmitter.onSuccess((View) this.f52166a.next());
        } else {
            maybeEmitter.onComplete();
        }
    }
}
