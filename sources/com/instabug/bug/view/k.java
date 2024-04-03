package com.instabug.bug.view;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.bug.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.view.IconView;

public class k extends RecyclerView.ViewHolder {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f45850h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f45851i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f45852j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public IconView f45853k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public ImageView f45854l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public ImageView f45855m;

    public k(View view) {
        super(view);
        this.f45850h = (RelativeLayout) view.findViewById(R.id.instabug_attachment_video_item);
        this.f45855m = (ImageView) view.findViewById(R.id.instabug_img_video_attachment);
        this.f45853k = (IconView) view.findViewById(R.id.instabug_btn_remove_attachment);
        this.f45852j = (ProgressBar) view.findViewById(R.id.instabug_attachment_progress_bar);
        this.f45854l = (ImageView) view.findViewById(R.id.instabug_btn_video_play_attachment);
        this.f45851i = (RelativeLayout) view.findViewById(R.id.instabug_attachemnt_thumb_background);
        ProgressBar progressBar = this.f45852j;
        if (progressBar != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(InstabugCore.getPrimaryColor(), PorterDuff.Mode.MULTIPLY);
        }
    }
}
