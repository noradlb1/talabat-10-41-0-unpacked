package com.instabug.chat.ui.chat;

import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.BitmapUtils;

class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f46235b;

    public o(p pVar) {
        this.f46235b = pVar;
    }

    public void run() {
        BitmapUtils.loadBitmapForAsset(this.f46235b.getActivity(), this.f46235b.f46236a, AssetEntity.AssetType.IMAGE, new n(this));
    }
}
