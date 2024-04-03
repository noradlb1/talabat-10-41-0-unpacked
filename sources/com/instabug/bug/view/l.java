package com.instabug.bug.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.instabug.bug.R;
import com.instabug.bug.settings.b;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.Attachment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.VideoManipulationUtils;
import com.instabug.library.view.IconView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

public class l extends RecyclerView.Adapter {

    /* renamed from: b  reason: collision with root package name */
    private List f45856b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ColorFilter f45857c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public i f45858d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f45859e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ImageView f45860f;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public Context f45861g;

    /* renamed from: h  reason: collision with root package name */
    private int f45862h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int[] f45863i;

    public l(@Nullable Context context, @Nullable ColorFilter colorFilter, i iVar) {
        int i11 = R.drawable.ibg_bug_ic_edit;
        int i12 = R.drawable.ibg_bug_ic_magnify;
        int i13 = R.drawable.ibg_bug_ic_blur;
        this.f45863i = new int[]{i11, i12, i13, i11, i12, i13, i11};
        this.f45861g = context;
        this.f45857c = colorFilter;
        this.f45858d = iVar;
        setHasStableIds(true);
        this.f45856b = new ArrayList();
    }

    private View.OnClickListener a(View view, Attachment attachment) {
        return new g(this, view, attachment);
    }

    private String a(int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 <= i11; i13++) {
            if (getItemViewType(i13) == 0) {
                i12++;
            }
        }
        return String.format(Locale.ENGLISH, "Image attachment number %d", new Object[]{Integer.valueOf(i12)});
    }

    private void a(RelativeLayout relativeLayout) {
        Context context = this.f45861g;
        if (context != null) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.ibg_bug_shape_attachment_border);
            drawable.setColorFilter(new PorterDuffColorFilter(AttrResolver.resolveAttributeColor(this.f45861g, R.attr.ibg_bug_attachment_border_color), PorterDuff.Mode.SRC_IN));
            relativeLayout.setBackgroundDrawable(drawable);
        }
    }

    private void a(j jVar, Attachment attachment) {
        ImageView imageView;
        RelativeLayout relativeLayout;
        if (!(attachment.getLocalPath() == null || jVar.f45846j == null)) {
            BitmapUtils.loadBitmap(attachment.getLocalPath(), jVar.f45846j);
        }
        ImageView imageView2 = jVar.f45846j;
        if (imageView2 != null) {
            imageView2.setTag(attachment);
            RelativeLayout relativeLayout2 = jVar.f45844h;
            if (relativeLayout2 != null) {
                jVar.f45846j.setOnClickListener(a((View) relativeLayout2, attachment));
            }
        }
        ImageView imageView3 = jVar.f45847k;
        if (!(imageView3 == null || (relativeLayout = jVar.f45844h) == null)) {
            imageView3.setOnClickListener(a((View) relativeLayout, attachment));
        }
        RelativeLayout relativeLayout3 = jVar.f45844h;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(a((View) relativeLayout3, attachment));
        }
        IconView iconView = jVar.f45848l;
        if (iconView != null) {
            iconView.setTag(attachment);
            IconView iconView2 = jVar.f45848l;
            iconView2.setOnClickListener(a((View) iconView2, attachment));
            jVar.f45848l.setTextColor(SettingsManager.getInstance().getPrimaryColor());
        }
        if (!(attachment.getName() == null || (imageView = jVar.f45846j) == null)) {
            ViewCompat.setTransitionName(imageView, attachment.getName());
        }
        RelativeLayout relativeLayout4 = jVar.f45845i;
        if (relativeLayout4 != null) {
            a(relativeLayout4);
        }
        if (!(jVar.f45848l == null || jVar.f45849m == null)) {
            if (attachment.getType() != Attachment.Type.MAIN_SCREENSHOT || !b.f().s()) {
                jVar.f45848l.setVisibility(0);
                jVar.f45849m.setVisibility(0);
            } else {
                jVar.f45848l.setVisibility(8);
                jVar.f45849m.setVisibility(8);
            }
        }
        String a11 = a(jVar.getAdapterPosition());
        ImageView imageView4 = jVar.f45846j;
        if (imageView4 != null) {
            imageView4.setContentDescription(a11);
        }
        if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
            ImageView imageView5 = jVar.f45847k;
            if (imageView5 != null) {
                ViewCompat.setImportantForAccessibility(imageView5, 2);
            }
            RelativeLayout relativeLayout5 = jVar.f45844h;
            if (relativeLayout5 != null) {
                ViewCompat.setImportantForAccessibility(relativeLayout5, 2);
                jVar.f45844h.setFocusable(false);
            }
            ImageView imageView6 = jVar.f45846j;
            if (imageView6 != null) {
                ViewCompat.setAccessibilityDelegate(imageView6, new a(this, a11, jVar));
            }
            if (jVar.f45848l != null) {
                jVar.f45848l.setContentDescription(a(R.string.ibg_bug_report_attachment_remove_content_description, jVar.itemView.getContext()) + " " + a11);
                ViewCompat.setAccessibilityDelegate(jVar.f45848l, new b(this));
            }
        }
    }

    private void a(k kVar, Attachment attachment) {
        RelativeLayout relativeLayout;
        ColorFilter colorFilter;
        IconView iconView = kVar.f45853k;
        if (iconView != null) {
            View findViewById = iconView.findViewById(R.id.instabug_btn_remove_attachment);
            if (findViewById != null) {
                findViewById.setTag(attachment);
                findViewById.setOnClickListener(a((View) kVar.f45853k, attachment));
            }
            kVar.f45853k.setTextColor(SettingsManager.getInstance().getPrimaryColor());
        }
        ImageView imageView = kVar.f45854l;
        if (!(imageView == null || (colorFilter = this.f45857c) == null)) {
            imageView.setColorFilter(colorFilter);
        }
        ImageView imageView2 = kVar.f45855m;
        if (imageView2 != null) {
            imageView2.setTag(attachment);
            RelativeLayout relativeLayout2 = kVar.f45850h;
            if (relativeLayout2 != null) {
                kVar.f45855m.setOnClickListener(a((View) relativeLayout2, attachment));
            }
        }
        ImageView imageView3 = kVar.f45854l;
        if (!(imageView3 == null || (relativeLayout = kVar.f45850h) == null)) {
            imageView3.setOnClickListener(a((View) relativeLayout, attachment));
        }
        RelativeLayout relativeLayout3 = kVar.f45850h;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(a((View) relativeLayout3, attachment));
        }
        this.f45860f = kVar.f45854l;
        this.f45859e = kVar.f45852j;
        if (attachment.getLocalPath() != null) {
            InstabugSDKLogger.v("IBG-BR", "Video path found, extracting it's first frame " + attachment.getLocalPath());
            VideoManipulationUtils.extractFirstVideoFrame(attachment.getLocalPath(), new d(this, kVar));
        } else {
            InstabugSDKLogger.v("IBG-BR", "Neither video path nor main screenshot found, using white background");
            ImageView imageView4 = kVar.f45855m;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.ibg_core_bg_card);
            }
            ProgressBar progressBar = this.f45859e;
            if (progressBar != null && progressBar.getVisibility() == 8) {
                this.f45859e.setVisibility(0);
            }
            ImageView imageView5 = this.f45860f;
            if (imageView5 != null && imageView5.getVisibility() == 0) {
                this.f45860f.setVisibility(8);
            }
        }
        RelativeLayout relativeLayout4 = kVar.f45851i;
        if (relativeLayout4 != null) {
            a(relativeLayout4);
        }
        if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
            String c11 = c(kVar.getAdapterPosition());
            ImageView imageView6 = kVar.f45854l;
            if (imageView6 != null) {
                ViewCompat.setImportantForAccessibility(imageView6, 2);
            }
            ImageView imageView7 = kVar.f45855m;
            if (imageView7 != null) {
                ViewCompat.setAccessibilityDelegate(imageView7, new e(this, c11, kVar));
            }
            if (kVar.f45853k != null) {
                kVar.f45853k.setContentDescription(a(R.string.ibg_bug_report_attachment_remove_content_description, kVar.itemView.getContext()) + " " + c11);
                ViewCompat.setAccessibilityDelegate(kVar.f45853k, new f(this));
            }
        }
    }

    private String c(int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 <= i11; i13++) {
            if (getItemViewType(i13) == 1) {
                i12++;
            }
        }
        return String.format(Locale.ENGLISH, "Video attachment number %d", new Object[]{Integer.valueOf(i12)});
    }

    public String a(@StringRes int i11, Context context) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), i11, context);
    }

    public void a() {
        this.f45856b.clear();
    }

    public void a(j jVar) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int i11 : this.f45863i) {
            Context context = this.f45861g;
            if (context != null) {
                Drawable drawable = AppCompatResources.getDrawable(context, i11);
                if (drawable != null) {
                    animationDrawable.addFrame(drawable, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                } else {
                    animationDrawable.stop();
                }
            }
        }
        animationDrawable.setEnterFadeDuration(200);
        animationDrawable.setOneShot(true);
        ImageView imageView = jVar.f45847k;
        if (imageView != null) {
            imageView.setImageDrawable(animationDrawable);
            jVar.f45847k.post(new c(this, animationDrawable));
        }
    }

    public void a(Attachment attachment) {
        this.f45856b.add(attachment);
    }

    public Attachment b(int i11) {
        return (Attachment) this.f45856b.get(i11);
    }

    public List b() {
        return this.f45856b;
    }

    public void b(Attachment attachment) {
        this.f45856b.remove(attachment);
    }

    @Nullable
    public ImageView c() {
        return this.f45860f;
    }

    @Nullable
    public ProgressBar d() {
        return this.f45859e;
    }

    public void d(int i11) {
        this.f45862h = i11;
    }

    public int getItemCount() {
        List list = this.f45856b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public long getItemId(int i11) {
        return b(i11).getId();
    }

    public int getItemViewType(int i11) {
        List list = this.f45856b;
        if (list == null || list.size() == 0 || ((Attachment) this.f45856b.get(i11)).getType() == null) {
            return super.getItemViewType(i11);
        }
        int i12 = h.f45843a[((Attachment) this.f45856b.get(i11)).getType().ordinal()];
        return (i12 == 4 || i12 == 5 || i12 == 6) ? 1 : 0;
    }

    @SuppressLint({"STARVATION"})
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        if (getItemViewType(i11) != 1) {
            j jVar = (j) viewHolder;
            a(jVar, b(i11));
            int i12 = this.f45862h;
            if (i12 != -1 && i11 == i12 && b(i11).shouldAnimate()) {
                a(jVar);
                b(i11).setShouldAnimate(false);
                return;
            }
            return;
        }
        a((k) viewHolder, b(i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        return i11 != 1 ? new j(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ibg_bug_lyt_attachment_image, viewGroup, false)) : new k(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ibg_bug_lyt_attachment_video, viewGroup, false));
    }
}
