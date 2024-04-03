package com.instabug.chat.ui.annotation;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.core.ui.BaseContract;

interface a extends BaseContract.Presenter {
    void a(@Nullable Bitmap bitmap, Uri uri);
}
