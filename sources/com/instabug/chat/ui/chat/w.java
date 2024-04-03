package com.instabug.chat.ui.chat;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.instabug.library.util.OnVideoFrameReady;

class w implements OnVideoFrameReady {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y f46254a;

    public w(y yVar) {
        this.f46254a = yVar;
    }

    public void onReady(@Nullable Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null && (imageView = this.f46254a.f46257c.f46258a.f46187c.f46210i) != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
