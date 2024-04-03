package com.instabug.library.invocation.invocationdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.instabug.library.Instabug;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.ListUtils;
import com.instabug.library.view.ViewUtils;
import ed.b;
import ed.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l extends InstabugBaseFragment implements m, AdapterView.OnItemClickListener {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private TextView f51304a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private h f51305b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f51306c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private a f51307d = null;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private a f51308e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private b f51309f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ListView f51310g;

    public interface a {
        void onDialogItemClicked(@Nullable InstabugDialogItem instabugDialogItem, View... viewArr);

        void removeScreenshotIfNeeded(InstabugDialogItem instabugDialogItem);
    }

    public static l a(@Nullable String str, boolean z11, @Nullable ArrayList arrayList) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putString("dialog_title", str);
        bundle.putBoolean(InstabugDialogActivity.KEY_DIALOG_SHOULD_OVERRIDE_TITLE_DESC, z11);
        bundle.putSerializable(InstabugDialogActivity.KEY_DIALOG_ITEMS, arrayList);
        lVar.setArguments(bundle);
        return lVar;
    }

    private void b(@NonNull List list) {
        ArrayList arrayList = new ArrayList(list);
        this.f51306c = arrayList;
        Collections.copy(arrayList, list);
        int i11 = 0;
        while (true) {
            if (i11 >= this.f51306c.size()) {
                i11 = -1;
                break;
            } else if (((InstabugDialogItem) this.f51306c.get(i11)) instanceof a) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1) {
            this.f51307d = (a) this.f51306c.remove(i11);
        }
    }

    private void c(View view) {
        if (getActivity() != null) {
            WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            Context applicationContext = Instabug.getApplicationContext();
            if (this.f51306c != null && applicationContext != null && (ViewUtils.convertDpToPx(applicationContext, 56.0f) * this.f51306c.size()) + ViewUtils.convertDpToPx(applicationContext, 200.0f) > displayMetrics.heightPixels) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, displayMetrics.heightPixels - ViewUtils.convertDpToPx(applicationContext, 110.0f));
                layoutParams.addRule(13);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private n e() {
        return new n(this);
    }

    public void d() {
        TextView textView = this.f51304a;
        if (textView != null && getArguments() != null && getArguments().getString("dialog_title") != null) {
            textView.setText(getArguments().getString("dialog_title"));
        }
    }

    public void f() {
        Context context = getContext();
        if (context != null && this.f51309f != null) {
            View i11 = i(R.id.layout_title_container);
            if (i11 != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.f51309f.getEnterAnimation());
                loadAnimation.setStartOffset(100);
                i11.setAnimation(loadAnimation);
            }
            ListView listView = this.f51310g;
            if (listView != null) {
                Animation loadAnimation2 = AnimationUtils.loadAnimation(context, this.f51309f.getEnterAnimation());
                loadAnimation2.setStartOffset(100);
                loadAnimation2.setAnimationListener(new j(this, listView));
                listView.setScrollBarDefaultDelayBeforeFade(0);
                listView.setAnimation(loadAnimation2);
            }
        }
    }

    public void g() {
        Context context = getContext();
        if (context != null && this.f51309f != null) {
            View i11 = i(R.id.layout_title_container);
            if (i11 != null) {
                i11.setAnimation(AnimationUtils.loadAnimation(context, this.f51309f.getExitAnimation()));
            }
            ListView listView = this.f51310g;
            if (listView != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.f51309f.getExitAnimation());
                loadAnimation.setAnimationListener(new k(this, listView));
                listView.setAnimation(loadAnimation);
            }
        }
    }

    public void h() {
        ArrayList arrayList = this.f51306c;
        if (arrayList != null && this.f51305b != null && arrayList.size() > 0) {
            this.f51305b.a(this.f51306c);
            this.f51305b.notifyDataSetChanged();
        }
    }

    public int i0() {
        return R.layout.ib_core_lyt_dialog_fragment;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void j0(View view, @Nullable Bundle bundle) {
        Drawable drawable;
        View i11 = i(R.id.instabug_main_prompt_container);
        if (!(i11 == null || getContext() == null)) {
            c(i11);
            DrawableUtils.setColor(i11, AttrResolver.resolveAttributeColor(getContext(), R.attr.instabug_background_color));
        }
        TextView textView = (TextView) i(R.id.instabug_fragment_title);
        this.f51304a = textView;
        if (textView != null) {
            ViewCompat.setTransitionName(textView, "title");
            if (AccessibilityUtils.isAccessibilityServiceEnabled() && getArguments() != null && getArguments().getBoolean(InstabugDialogActivity.KEY_DIALOG_SHOULD_OVERRIDE_TITLE_DESC)) {
                textView.setContentDescription(getLocalizedString(R.string.ibg_prompt_options_title_content_description));
            }
        }
        if (this.f51307d != null) {
            View i12 = i(R.id.instabug_chats_list_icon_container);
            if (i12 != null) {
                i12.setVisibility(0);
                if (this.f51308e != null) {
                    i12.setOnClickListener(new b(this));
                }
            }
            ImageView imageView = (ImageView) i(R.id.instabug_chats_list_icon);
            if (imageView != null) {
                imageView.getDrawable().setColorFilter(SettingsManager.getInstance().getPrimaryColor(), PorterDuff.Mode.SRC_IN);
            }
            TextView textView2 = (TextView) i(R.id.instabug_notification_count);
            if (this.f51307d.getBadgeCount() > 0) {
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    textView2.setContentDescription(getLocalizedString(R.string.ibg_prompt_options_notification_count_content_description, Integer.valueOf(this.f51307d.getBadgeCount())));
                }
                int color = getResources().getColor(R.color.ib_core_notification_dot_color);
                if (!(textView2 == null || getContext() == null)) {
                    Drawable drawable2 = ContextCompat.getDrawable(getContext(), R.drawable.ibg_core_bg_white_oval);
                    if (drawable2 != null) {
                        drawable = Colorizer.getTintedDrawable(color, drawable2);
                    } else {
                        drawable = null;
                    }
                    textView2.setBackgroundDrawable(drawable);
                }
                if (textView2 != null) {
                    textView2.setText(String.valueOf(this.f51307d.getBadgeCount()));
                }
            } else if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        ListView listView = (ListView) i(R.id.instabug_prompt_options_list_view);
        this.f51310g = listView;
        if (listView != null) {
            listView.setOnItemClickListener(this);
            h hVar = new h();
            this.f51305b = hVar;
            listView.setAdapter(hVar);
            if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
                ViewCompat.setAccessibilityDelegate(listView, new i(this));
            }
        }
        Button button = (Button) i(R.id.instabug_prompt_cancel_btn);
        button.setTextColor(SettingsManager.getInstance().getPrimaryColor());
        button.setOnClickListener(new c(this));
        h();
        f();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof a) || !(context instanceof b)) {
            throw new RuntimeException(context.toString() + " must implement InstabugDialogFragment.Callbacks and AnimationProvider");
        }
        this.f51308e = (a) context;
        this.f51309f = (b) context;
    }

    public void onCreate(@Nullable Bundle bundle) {
        ArrayList arrayList;
        setRetainInstance(true);
        super.onCreate(bundle);
        if (this.C == null) {
            this.C = e();
        }
        if (getArguments() != null) {
            arrayList = (ArrayList) getArguments().getSerializable(InstabugDialogActivity.KEY_DIALOG_ITEMS);
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            b((List) arrayList);
        }
    }

    public void onDestroyView() {
        g();
        this.f51304a = null;
        this.f51310g = null;
        this.f51305b = null;
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
        this.f51308e = null;
        this.f51309f = null;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
        ListView listView = this.f51310g;
        if (listView != null) {
            listView.setOnItemClickListener((AdapterView.OnItemClickListener) null);
        }
        a aVar = this.f51308e;
        if (aVar != null) {
            aVar.onDialogItemClicked((InstabugDialogItem) ListUtils.safeGet(this.f51306c, i11), i(R.id.instabug_main_prompt_container), i(R.id.instabug_pbi_container));
        }
    }

    public void onStart() {
        super.onStart();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).a();
        }
    }

    public void onStop() {
        super.onStop();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((n) presenter).b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar;
        a aVar2 = this.f51307d;
        if (aVar2 != null && (aVar = this.f51308e) != null) {
            aVar.removeScreenshotIfNeeded(aVar2);
            this.f51308e.onDialogItemClicked(this.f51307d, i(R.id.instabug_main_prompt_container), i(R.id.instabug_pbi_container));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finishActivity();
    }

    public void b() {
        InstabugCore.handlePbiFooter(this.F);
        View i11 = i(R.id.instabug_pbi_container);
        if (i11 != null && i11.getVisibility() == 0 && AccessibilityUtils.isAccessibilityServiceEnabled()) {
            ViewCompat.setImportantForAccessibility(i11, 4);
        }
    }
}
