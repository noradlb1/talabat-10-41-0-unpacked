package com.instabug.chat.ui.chat;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.threading.PoolProvider;

class c0 implements BitmapUtils.OnBitmapReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f46195a;

    public c0(d0 d0Var) {
        this.f46195a = d0Var;
    }

    public void onBitmapFailedToLoad() {
    }

    public void onBitmapReady(@Nullable Bitmap bitmap) {
        PoolProvider.postMainThreadTask(new b0(this, bitmap));
    }
}
