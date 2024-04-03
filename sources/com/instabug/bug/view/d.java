package com.instabug.bug.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.instabug.library.util.OnVideoFrameReady;

class d implements OnVideoFrameReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f45813a;

    public d(l lVar, k kVar) {
        this.f45813a = kVar;
    }

    public void onReady(@Nullable Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null && (imageView = this.f45813a.f45855m) != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
