package com.instabug.chat.ui.chats;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.threading.PoolProvider;

class b implements BitmapUtils.OnBitmapReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f46262a;

    public b(d dVar, c cVar) {
        this.f46262a = cVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(c cVar, Bitmap bitmap) {
        if (cVar.f46264b != null) {
            cVar.f46264b.setImageBitmap(bitmap);
        }
    }

    public void onBitmapFailedToLoad() {
    }

    public void onBitmapReady(@Nullable Bitmap bitmap) {
        PoolProvider.postMainThreadTask(new l(this.f46262a, bitmap));
    }
}
