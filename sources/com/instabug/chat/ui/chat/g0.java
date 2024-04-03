package com.instabug.chat.ui.chat;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.instabug.chat.R;
import com.instabug.library.ui.custom.CircularImageView;

public class g0 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public CircularImageView f46202a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public TextView f46203b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public TextView f46204c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ImageView f46205d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f46206e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public ImageView f46207f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f46208g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public ImageView f46209h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ImageView f46210i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f46211j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public ProgressBar f46212k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f46213l;

    public g0(View view) {
        this.f46202a = (CircularImageView) view.findViewById(R.id.instabug_img_message_sender);
        this.f46203b = (TextView) view.findViewById(R.id.instabug_txt_message_time);
        this.f46204c = (TextView) view.findViewById(R.id.instabug_txt_message_body);
        this.f46205d = (ImageView) view.findViewById(R.id.instabug_img_attachment);
        this.f46207f = (ImageView) view.findViewById(R.id.instabug_btn_play_audio);
        this.f46206e = (FrameLayout) view.findViewById(R.id.instabug_audio_attachment);
        this.f46208g = (ProgressBar) view.findViewById(R.id.instabug_audio_attachment_progress_bar);
        this.f46210i = (ImageView) view.findViewById(R.id.instabug_img_video_attachment);
        this.f46209h = (ImageView) view.findViewById(R.id.instabug_btn_play_video);
        this.f46211j = (FrameLayout) view.findViewById(R.id.instabug_video_attachment);
        this.f46212k = (ProgressBar) view.findViewById(R.id.instabug_video_attachment_progress_bar);
        this.f46213l = (LinearLayout) view.findViewById(R.id.instabug_message_actions_container);
    }
}
