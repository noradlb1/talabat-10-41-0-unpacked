package com.instabug.chat.notification;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.threading.PoolProvider;

class n implements BitmapUtils.OnBitmapReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f46126a;

    public n(o oVar) {
        this.f46126a = oVar;
    }

    public void onBitmapFailedToLoad() {
        if (!this.f46126a.f46130e.f46132b) {
            this.f46126a.f46130e.f();
        } else if (this.f46126a.f46129d.getVisibility() != 0) {
            this.f46126a.f46129d.setVisibility(0);
        }
    }

    public void onBitmapReady(@Nullable Bitmap bitmap) {
        PoolProvider.postMainThreadTask(new m(this, bitmap));
    }
}
