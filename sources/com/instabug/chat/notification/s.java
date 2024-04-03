package com.instabug.chat.notification;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.instabug.chat.R;
import com.instabug.chat.cache.k;
import com.instabug.chat.f;
import com.instabug.chat.model.n;
import com.instabug.chat.settings.a;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.PresentationManager;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.custom.CircularImageView;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ScreenUtility;
import com.instabug.library.util.threading.PoolProvider;
import java.lang.ref.WeakReference;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f46131a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f46132b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f46133c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f46134d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private n f46135e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public q f46136f;

    public s() {
        g();
        i();
        h();
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f46135e = null;
    }

    private void a(n nVar) {
        WeakReference weakReference = this.f46131a;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            CircularImageView circularImageView = (CircularImageView) view.findViewById(R.id.senderAvatarImageView);
            new Handler(Looper.getMainLooper()).post(new l(this, view, circularImageView, nVar));
            if (nVar.a() != null) {
                PoolProvider.postIOTask(new o(this, nVar, circularImageView, view));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(@Nullable InstabugColorTheme instabugColorTheme) {
        int i11;
        WeakReference weakReference = this.f46131a;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            View findViewById = view.findViewById(R.id.instabug_notification_layout);
            Button button = (Button) view.findViewById(R.id.replyButton);
            Button button2 = (Button) view.findViewById(R.id.dismissButton);
            TextView textView = (TextView) view.findViewById(R.id.senderNameTextView);
            TextView textView2 = (TextView) view.findViewById(R.id.senderMessageTextView);
            if (InstabugCore.isFeatureEnabled(Feature.CUSTOM_FONT)) {
                Typeface font = ResourcesCompat.getFont(view.getContext(), R.font.instabug_custom_font);
                if (button != null) {
                    button.setTypeface(font);
                }
                if (button2 != null) {
                    button2.setTypeface(font);
                }
                if (textView != null) {
                    textView.setTypeface(font);
                }
                if (textView2 != null) {
                    textView2.setTypeface(font);
                }
            }
            if (button2 != null) {
                button2.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
                button2.setTextColor(-6579301);
            }
            if (button != null) {
                button.getBackground().setColorFilter(SettingsManager.getInstance().getPrimaryColor(), PorterDuff.Mode.MULTIPLY);
                button.setTextColor(-1);
            }
            if (instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight) {
                if (findViewById != null) {
                    findViewById.setBackgroundColor(-1);
                }
                if (textView != null) {
                    textView.setTextColor(-11908534);
                }
                if (textView2 != null) {
                    i11 = -7697777;
                } else {
                    return;
                }
            } else {
                if (findViewById != null) {
                    findViewById.setBackgroundColor(-12434878);
                }
                if (textView != null) {
                    textView.setTextColor(-1);
                }
                if (textView2 != null) {
                    i11 = -2631721;
                } else {
                    return;
                }
            }
            textView2.setTextColor(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SDKCoreEvent sDKCoreEvent) {
        String type = sDKCoreEvent.getType();
        type.hashCode();
        if (!type.equals("features")) {
            if (!type.equals("user") || !sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_OUT)) {
                return;
            }
        } else if (!sDKCoreEvent.getValue().equals(SDKCoreEvent.Feature.VALUE_UPDATED) || InstabugCore.isFeatureEnabled(Feature.REPLIES)) {
            return;
        }
        a();
        a(false);
    }

    /* access modifiers changed from: private */
    public void a(CircularImageView circularImageView, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            circularImageView.setBackgroundResource(0);
            circularImageView.setImageBitmap(bitmap);
        }
    }

    private void a(@NonNull WeakReference weakReference, r rVar) {
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            View findViewById = activity.findViewById(R.id.instabug_in_app_notification);
            if (findViewById != null) {
                this.f46131a = new WeakReference(findViewById);
                rVar.a();
                return;
            }
            a(false);
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
            if (layoutInflater == null) {
                InstabugSDKLogger.e("IBG-BR", "Unable to inflate the InAppNotifications view due to null Inflater");
                return;
            }
            View inflate = layoutInflater.inflate(R.layout.instabug_lyt_notification, (ViewGroup) null);
            this.f46131a = new WeakReference(inflate);
            inflate.setVisibility(4);
            inflate.setOnClickListener(new f(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            Resources resources = activity.getResources();
            int i11 = Build.VERSION.SDK_INT;
            if (ScreenUtility.isLandscape(activity) && ScreenUtility.hasNavBar(activity.getApplicationContext())) {
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation != 1) {
                    if (rotation == 3) {
                        if (i11 >= 24) {
                            layoutParams.leftMargin = ScreenUtility.getNavigationBarWidth(resources);
                        }
                    }
                }
                layoutParams.rightMargin = ScreenUtility.getNavigationBarWidth(resources);
            }
            inflate.setLayoutParams(layoutParams);
            activity.runOnUiThread(new g(this, inflate, activity, layoutParams, rVar));
            activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new h(this, activity));
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z11) {
        WeakReference weakReference = this.f46131a;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (this.f46132b && view != null) {
            int screenHeight = ScreenUtility.getScreenHeight((Activity) view.getContext());
            if (z11) {
                view.animate().y((float) screenHeight).setListener(new a(this, view)).start();
            } else {
                view.setY((float) screenHeight);
                view.setVisibility(4);
            }
            this.f46132b = false;
            this.f46134d = false;
            PresentationManager.getInstance().setNotificationShowing(false);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        a(true);
    }

    /* access modifiers changed from: private */
    public void b(n nVar) {
        a(nVar);
    }

    /* access modifiers changed from: private */
    public void c() {
        a(false);
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f46135e != null && this.f46136f != null && InstabugCore.getTargetActivity() != null && k.h() > 0 && f.c()) {
            a(new WeakReference(InstabugCore.getTargetActivity()), this.f46135e, this.f46136f);
        }
    }

    private void e() {
        WeakReference weakReference = this.f46131a;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            Button button = (Button) view.findViewById(R.id.replyButton);
            Button button2 = (Button) view.findViewById(R.id.dismissButton);
            if (button != null) {
                button.setOnClickListener(new j(this));
            }
            if (button2 != null) {
                button2.setOnClickListener(new k(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.f46133c) {
            this.f46134d = true;
            return;
        }
        new Handler(Looper.getMainLooper()).post(new b(this));
        if (a.i()) {
            v.a().b(Instabug.getApplicationContext());
        }
    }

    private void g() {
        CurrentActivityLifeCycleEventBus.getInstance().subscribe(new c(this));
    }

    private void h() {
        SDKCoreEventSubscriber.subscribe(new ac.a(this));
    }

    private void i() {
        InstabugStateEventBus.getInstance().subscribe(new e(this));
    }

    public void a(@NonNull WeakReference weakReference, n nVar, q qVar) {
        this.f46135e = nVar;
        this.f46136f = qVar;
        a(weakReference, (r) new i(this, nVar));
        e();
    }
}
