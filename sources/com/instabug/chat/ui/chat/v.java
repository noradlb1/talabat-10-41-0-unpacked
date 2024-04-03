package com.instabug.chat.ui.chat;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.instabug.library.util.OnVideoFrameReady;

class v implements OnVideoFrameReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f46253a;

    public v(h0 h0Var, g0 g0Var) {
        this.f46253a = g0Var;
    }

    public void onReady(@Nullable Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null && (imageView = this.f46253a.f46210i) != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
