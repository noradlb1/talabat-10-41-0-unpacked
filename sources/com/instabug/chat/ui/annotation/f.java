package com.instabug.chat.ui.annotation;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.util.BitmapUtils;
import java.lang.ref.WeakReference;

class f extends BasePresenter implements a {
    public f(b bVar) {
        super(bVar);
    }

    public void a(@Nullable Bitmap bitmap, Uri uri) {
        b bVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (bVar = (b) weakReference.get()) != null && bVar.getViewContext() != null && ((Fragment) bVar.getViewContext()).getContext() != null && bitmap != null) {
            bVar.k();
            BitmapUtils.saveBitmap(bitmap, uri, ((Fragment) bVar.getViewContext()).getContext(), new e(this, bVar));
        }
    }
}
