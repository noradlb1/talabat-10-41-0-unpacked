package com.instabug.featuresrequest.ui.base.featureslist;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.listeners.a;
import com.instabug.featuresrequest.models.d;
import com.instabug.featuresrequest.ui.custom.IbFrRippleView;
import com.instabug.featuresrequest.utils.b;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.AttrResolver;

public class e {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final TextView f46630a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f46631b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final TextView f46632c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final TextView f46633d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final TextView f46634e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final TextView f46635f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final TextView f46636g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final IbFrRippleView f46637h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final a f46638i;

    /* renamed from: j  reason: collision with root package name */
    private final View f46639j;

    public e(View view, a aVar) {
        this.f46639j = view;
        this.f46638i = aVar;
        this.f46630a = (TextView) view.findViewById(R.id.instabug_txt_feature_request_vote_txt);
        this.f46631b = (ImageView) view.findViewById(R.id.instabug_txt_feature_request_vote_icon);
        this.f46632c = (TextView) view.findViewById(R.id.instabug_txt_feature_request_title);
        this.f46633d = (TextView) view.findViewById(R.id.instabug_txt_feature_request_vote_count);
        this.f46634e = (TextView) view.findViewById(R.id.instabug_txt_feature_request_comment_count);
        this.f46635f = (TextView) view.findViewById(R.id.instabug_txt_feature_request_status);
        this.f46636g = (TextView) view.findViewById(R.id.instabug_txt_feature_request_date);
        this.f46637h = (IbFrRippleView) view.findViewById(R.id.ib_btn_fr_vote);
    }

    private void a(d dVar, e eVar, Context context, @ColorRes int i11) {
        if (dVar.a() != null) {
            b.a(eVar.f46635f, Color.parseColor(dVar.a()));
        } else {
            b.a(eVar.f46635f, ContextCompat.getColor(context, i11));
        }
    }

    public void a(int i11) {
        TextView textView = this.f46634e;
        if (textView != null) {
            textView.setText(com.instabug.featuresrequest.utils.e.a(String.valueOf(i11)));
        }
    }

    public void a(long j11) {
        TextView textView = this.f46636g;
        if (textView != null) {
            textView.setText(com.instabug.featuresrequest.utils.a.a(this.f46639j.getContext(), j11));
        }
    }

    public void a(d dVar) {
        int i11;
        Context context;
        if (this.f46635f != null && this.f46637h != null) {
            int i12 = d.f46629a[dVar.l().ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    this.f46635f.setText(R.string.ib_feature_rq_status_inprogress);
                    context = this.f46639j.getContext();
                    i11 = R.color.ib_fr_color_in_progress;
                } else if (i12 == 3) {
                    this.f46635f.setText(R.string.ib_feature_rq_status_planned);
                    context = this.f46639j.getContext();
                    i11 = R.color.ib_fr_color_planned;
                } else if (i12 == 4) {
                    this.f46635f.setText(R.string.ib_feature_rq_status_open);
                    context = this.f46639j.getContext();
                    i11 = R.color.ib_fr_color_opened;
                } else if (i12 == 5) {
                    this.f46635f.setText(R.string.ib_feature_rq_status_maybe_later);
                    context = this.f46639j.getContext();
                    i11 = R.color.ib_fr_color_maybe_later;
                } else {
                    return;
                }
                a(dVar, this, context, i11);
                this.f46637h.setEnabled(true);
                return;
            }
            this.f46635f.setText(R.string.ib_feature_rq_status_completed);
            a(dVar, this, this.f46639j.getContext(), R.color.ib_fr_color_completed);
            this.f46637h.setEnabled(false);
        }
    }

    public void a(Boolean bool) {
        TextView textView;
        int color;
        ImageView imageView = this.f46631b;
        if (imageView != null && this.f46630a != null && this.f46633d != null) {
            imageView.setImageDrawable(AppCompatResources.getDrawable(this.f46639j.getContext(), R.drawable.ibg_fr_ic_vote_arrow));
            if (bool.booleanValue()) {
                this.f46631b.setColorFilter(ContextCompat.getColor(this.f46639j.getContext(), R.color.ib_fr_white));
                b.a(this.f46637h, SettingsManager.getInstance().getPrimaryColor());
                this.f46633d.setTextColor(ContextCompat.getColor(this.f46639j.getContext(), 17170443));
                textView = this.f46630a;
                color = ContextCompat.getColor(this.f46639j.getContext(), 17170443);
            } else {
                b.a(this.f46637h, 17170443);
                if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                    ImageView imageView2 = this.f46631b;
                    Context context = this.f46639j.getContext();
                    int i11 = R.color.ib_fr_color_ptr_loading_txt;
                    imageView2.setColorFilter(ContextCompat.getColor(context, i11));
                    this.f46633d.setTextColor(ContextCompat.getColor(this.f46639j.getContext(), i11));
                    textView = this.f46630a;
                    color = ContextCompat.getColor(this.f46639j.getContext(), i11);
                } else {
                    this.f46631b.setColorFilter(ContextCompat.getColor(this.f46639j.getContext(), R.color.ib_fr_vote_text_dark));
                    TextView textView2 = this.f46633d;
                    Context context2 = this.f46639j.getContext();
                    int i12 = R.attr.instabug_fr_text_color;
                    textView2.setTextColor(AttrResolver.getColor(context2, i12));
                    textView = this.f46630a;
                    color = AttrResolver.getColor(this.f46639j.getContext(), i12);
                }
            }
            textView.setTextColor(color);
        }
    }

    public void a(String str) {
        TextView textView = this.f46632c;
        if (textView != null) {
            textView.setText(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 63) : Html.fromHtml(str));
        }
    }

    public void b(int i11) {
        TextView textView = this.f46633d;
        if (textView != null) {
            textView.setText(com.instabug.featuresrequest.utils.e.a(String.valueOf(i11)));
        }
    }

    public void b(d dVar) {
        IbFrRippleView ibFrRippleView = this.f46637h;
        if (ibFrRippleView != null) {
            ibFrRippleView.setOnClickListener(new c(this, dVar));
        }
    }
}
