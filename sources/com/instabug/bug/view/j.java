package com.instabug.bug.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.bug.R;
import com.instabug.library.view.IconView;

public class j extends RecyclerView.ViewHolder {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f45844h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f45845i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public ImageView f45846j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public ImageView f45847k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public IconView f45848l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public View f45849m;

    public j(View view) {
        super(view);
        this.f45846j = (ImageView) view.findViewById(R.id.instabug_img_attachment);
        this.f45847k = (ImageView) view.findViewById(R.id.instabug_btn_image_edit_attachment);
        this.f45844h = (RelativeLayout) view.findViewById(R.id.instabug_attachment_img_item);
        this.f45848l = (IconView) view.findViewById(R.id.instabug_btn_remove_attachment);
        this.f45845i = (RelativeLayout) view.findViewById(R.id.instabug_attachemnt_thumb_background);
        this.f45849m = view.findViewById(R.id.instabug_btn_remove_attachment_circle);
    }
}
