package com.instabug.chat.ui.chat;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.VideoManipulationUtils;

class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetEntity f46256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ z f46257c;

    public y(z zVar, AssetEntity assetEntity) {
        this.f46257c = zVar;
        this.f46256b = assetEntity;
    }

    public void run() {
        ProgressBar progressBar = this.f46257c.f46258a.f46187c.f46212k;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ImageView imageView = this.f46257c.f46258a.f46187c.f46209h;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        VideoManipulationUtils.extractFirstVideoFrame(this.f46256b.getFile().getPath(), new w(this));
        FrameLayout frameLayout = this.f46257c.f46258a.f46187c.f46211j;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new x(this));
        }
    }
}
