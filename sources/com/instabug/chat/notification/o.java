package com.instabug.chat.notification;

import android.view.View;
import com.instabug.chat.model.n;
import com.instabug.library.Instabug;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.ui.custom.CircularImageView;
import com.instabug.library.util.BitmapUtils;

class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f46127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CircularImageView f46128c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f46129d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f46130e;

    public o(s sVar, n nVar, CircularImageView circularImageView, View view) {
        this.f46130e = sVar;
        this.f46127b = nVar;
        this.f46128c = circularImageView;
        this.f46129d = view;
    }

    public void run() {
        if (this.f46127b.a() != null) {
            BitmapUtils.loadBitmapForAsset(Instabug.getApplicationContext(), this.f46127b.a(), AssetEntity.AssetType.IMAGE, new n(this));
        }
    }
}
