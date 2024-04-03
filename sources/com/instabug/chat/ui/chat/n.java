package com.instabug.chat.ui.chat;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.threading.PoolProvider;

class n implements BitmapUtils.OnBitmapReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f46234a;

    public n(o oVar) {
        this.f46234a = oVar;
    }

    public void onBitmapFailedToLoad() {
    }

    public void onBitmapReady(@Nullable Bitmap bitmap) {
        PoolProvider.postMainThreadTask(new m(this, bitmap));
    }
}
