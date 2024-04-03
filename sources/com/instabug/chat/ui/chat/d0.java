package com.instabug.chat.ui.chat;

import android.widget.ImageView;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.BitmapUtils;

class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f46196b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f46197c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f46198d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h0 f46199e;

    public d0(h0 h0Var, String str, ImageView imageView, boolean z11) {
        this.f46199e = h0Var;
        this.f46196b = str;
        this.f46197c = imageView;
        this.f46198d = z11;
    }

    public void run() {
        BitmapUtils.loadBitmapForAsset(this.f46199e.f46218d, this.f46196b, AssetEntity.AssetType.IMAGE, new c0(this));
    }
}
