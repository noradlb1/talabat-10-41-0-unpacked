package com.instabug.chat.ui.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import cc.a;
import com.instabug.chat.R;
import com.instabug.library.FragmentVisibilityChangedListener;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugBaseFragment;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.ResourcesUtils;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class c extends InstabugBaseFragment implements View.OnClickListener, FragmentVisibilityChangedListener {
    public b C;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private AppCompatImageView f46191a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private AppCompatImageView f46192b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private AppCompatImageView f46193c;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f46194e;

    public static c a(b bVar) {
        c cVar = new c();
        cVar.C = bVar;
        return cVar;
    }

    private void a() {
        try {
            AppCompatImageView appCompatImageView = this.f46191a;
            if (getContext() != null) {
                int color = ContextCompat.getColor(getContext(), Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeDark ? R.color.instabug_theme_tinting_color_dark : R.color.instabug_theme_tinting_color_light);
                if (appCompatImageView != null) {
                    appCompatImageView.setImageDrawable(ResourcesUtils.getDrawable(R.drawable.ibg_core_ic_capture_screenshot, getContext()));
                    appCompatImageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                }
                this.f46191a = appCompatImageView;
                AppCompatImageView appCompatImageView2 = this.f46192b;
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setImageDrawable(ResourcesUtils.getDrawable(R.drawable.ibg_core_ic_record_video, getContext()));
                    appCompatImageView2.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                }
                this.f46192b = appCompatImageView2;
                AppCompatImageView appCompatImageView3 = this.f46193c;
                if (appCompatImageView3 != null) {
                    appCompatImageView3.setImageDrawable(ResourcesUtils.getVectorDrawable(R.drawable.ibg_core_ic_attach_gallery_media, getContext()));
                    appCompatImageView3.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                }
                this.f46193c = appCompatImageView3;
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "Failed to inflate view with exception: " + e11.getMessage(), e11);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a(View view) {
        Context context = getContext();
        if (context != null) {
            TextView textView = (TextView) view.findViewById(R.id.instabug_attach_gallery_image_text);
            if (textView != null) {
                textView.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.ADD_IMAGE_FROM_GALLERY, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), com.instabug.library.R.string.instabug_str_pick_media_from_gallery, context)));
            }
            TextView textView2 = (TextView) view.findViewById(R.id.instabug_attach_screenshot_text);
            if (textView2 != null) {
                textView2.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.ADD_EXTRA_SCREENSHOT, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), com.instabug.library.R.string.instabug_str_take_screenshot, context)));
            }
            TextView textView3 = (TextView) view.findViewById(R.id.instabug_attach_video_text);
            if (textView3 != null) {
                textView3.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.ADD_VIDEO, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), com.instabug.library.R.string.instabug_str_record_video, context)));
            }
        }
    }

    private void b() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            getActivity().getSupportFragmentManager().popBackStack("attachments_bottom_sheet_fragment", 1);
        }
    }

    private void b(View view) {
        View findViewById = view.findViewById(R.id.instabug_attachments_actions_bottom_sheet);
        if (findViewById != null) {
            findViewById.setAlpha(0.0f);
            a aVar = new a(findViewById);
            this.f46194e = aVar;
            findViewById.post(aVar);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(View view) {
        int height = view.getHeight();
        view.setTranslationY((float) height);
        view.setAlpha(1.0f);
        view.animate().setDuration(100).translationYBy((float) (-height));
    }

    public void i0() {
    }

    public int j0() {
        return R.layout.instabug_fragment_attachments_bottom_sheet;
    }

    public String k0() {
        return getString(com.instabug.library.R.string.instabug_str_empty);
    }

    public void l0(Bundle bundle) {
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.instabug_attach_screenshot) {
            b();
            this.C.a();
        } else if (id2 == R.id.instabug_attach_gallery_image) {
            b();
            this.C.b();
        } else if (id2 == R.id.instabug_attach_video) {
            b();
            this.C.g();
        } else if (id2 == R.id.instabug_attachments_bottom_sheet_dim_view) {
            b();
        }
    }

    public void onDestroy() {
        this.f46194e = null;
        super.onDestroy();
    }

    @SuppressLint({"STARVATION"})
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        LinearLayout linearLayout;
        super.onViewCreated(view, bundle);
        if (AccessibilityUtils.isAccessibilityServiceEnabled() && (linearLayout = (LinearLayout) view.findViewById(R.id.instabug_attach_gallery_image)) != null) {
            ViewCompat.setAccessibilityDelegate(linearLayout, new a(this));
        }
        this.f46191a = (AppCompatImageView) view.findViewById(R.id.instabug_attach_screenshot_image_view);
        this.f46192b = (AppCompatImageView) view.findViewById(R.id.instabug_attach_video_image_view);
        this.f46193c = (AppCompatImageView) view.findViewById(R.id.instabug_attach_gallery_image_view);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.instabug_attach_screenshot);
        if (linearLayout2 != null) {
            if (com.instabug.chat.settings.a.a().isScreenshotEnabled()) {
                linearLayout2.setOnClickListener(this);
            } else {
                linearLayout2.setVisibility(8);
            }
        }
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.instabug_attach_gallery_image);
        if (linearLayout3 != null) {
            if (com.instabug.chat.settings.a.a().isImageFromGalleryEnabled()) {
                linearLayout3.setOnClickListener(this);
            } else {
                linearLayout3.setVisibility(8);
            }
        }
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.instabug_attach_video);
        if (linearLayout4 != null) {
            if (com.instabug.chat.settings.a.a().isScreenRecordingEnabled()) {
                linearLayout4.setOnClickListener(this);
            } else {
                linearLayout4.setVisibility(8);
            }
        }
        View findViewById = view.findViewById(R.id.instabug_attachments_bottom_sheet_dim_view);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        a(view);
        b(view);
        a();
    }

    public void onVisibilityChanged(boolean z11) {
    }

    public void restoreState(Bundle bundle) {
    }
}
