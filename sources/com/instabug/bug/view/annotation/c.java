package com.instabug.bug.view.annotation;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.instabug.library.core.ui.BasePresenter;
import java.lang.ref.WeakReference;

class c extends BasePresenter {
    public c(a aVar) {
        super(aVar);
    }

    public void a(@Nullable Bitmap bitmap) {
        a aVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
            if (bitmap != null) {
                aVar.a(bitmap);
            } else {
                aVar.q();
            }
        }
    }
}
