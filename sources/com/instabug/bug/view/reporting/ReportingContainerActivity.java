package com.instabug.bug.view.reporting;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.R;
import com.instabug.bug.i;
import com.instabug.bug.o;
import com.instabug.bug.view.annotation.b;
import com.instabug.bug.view.disclaimer.d;
import com.instabug.bug.view.disclaimer.e;
import com.instabug.bug.view.m;
import com.instabug.bug.view.n;
import com.instabug.bug.view.reporting.x;
import com.instabug.library.FragmentVisibilityChangedListener;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseToolbarActivity;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import com.instabug.library.model.Attachment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.custom.InstabugAlertDialog;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.BitmapWorkerTask;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.KeyboardUtils;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.OrientationUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.StatusBarUtils;
import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;

public class ReportingContainerActivity extends BaseToolbarActivity implements n, View.OnClickListener, b.a, FragmentManager.OnBackStackChangedListener, d.a, x.a, m {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45867a = true;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f45868b;

    public class a implements BitmapUtils.OnSaveBitmapCallback {
        public a() {
        }

        public void onError(Throwable th2) {
        }

        public void onSuccess(Uri uri) {
            com.instabug.bug.n.e().e(ReportingContainerActivity.this);
        }
    }

    public class b implements BitmapWorkerTask.OnImageLoadedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f45870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f45871b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImageView f45872c;

        public b(ReportingContainerActivity reportingContainerActivity, float f11, float f12, ImageView imageView) {
            this.f45870a = f11;
            this.f45871b = f12;
            this.f45872c = imageView;
        }

        public void onImageLoaded() {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, this.f45870a, 1, this.f45871b);
            scaleAnimation.setDuration(500);
            scaleAnimation.setFillAfter(false);
            scaleAnimation.setAnimationListener(new j0(this));
            this.f45872c.startAnimation(scaleAnimation);
        }
    }

    private String F() {
        return PlaceHolderUtils.getPlaceHolder(this, InstabugCustomTextPlaceHolder.Key.REPORT_DISCARD_DIALOG_BODY, R.string.instabug_str_bugreport_dismiss_warning_message);
    }

    private String G() {
        return PlaceHolderUtils.getPlaceHolder(this, InstabugCustomTextPlaceHolder.Key.REPORT_DISCARD_DIALOG_NEGATIVE_ACTION, R.string.instabug_str_bugreport_dismiss_cancel);
    }

    private String H() {
        return PlaceHolderUtils.getPlaceHolder(this, InstabugCustomTextPlaceHolder.Key.REPORT_DISCARD_DIALOG_POSITIVE_ACTION, R.string.instabug_str_bugreport_dismiss_discard);
    }

    private String I() {
        return PlaceHolderUtils.getPlaceHolder(this, InstabugCustomTextPlaceHolder.Key.REPORT_DISCARD_DIALOG_TITLE, R.string.instabug_str_bugreport_dismiss_warning_title);
    }

    private String J() {
        return PlaceHolderUtils.getPlaceHolder(this, InstabugCustomTextPlaceHolder.Key.REPRO_STEPS_LIST_HEADER, R.string.IBGReproStepsListTitle);
    }

    private void K() {
        a(false, com.instabug.library.R.id.instabug_fragment_container);
        k0.f(getSupportFragmentManager(), true);
    }

    private void L() {
        if (!isFinishing() && !getSupportFragmentManager().isStateSaved()) {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }

    private void M() {
        this.f45868b = new InstabugAlertDialog.Builder(this).setTitle(I()).setMessage(F()).setPositiveButtonAccessibilityContentDescription(H()).setNegativeButtonAccessibilityContentDescription(G()).setPositiveButton(H(), new zb.a(this)).setNegativeButton(G(), (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        A();
        this.f45868b = null;
    }

    private void a(boolean z11, int i11) {
        if (getSupportFragmentManager().findFragmentById(i11) instanceof FragmentVisibilityChangedListener) {
            ((FragmentVisibilityChangedListener) getSupportFragmentManager().findFragmentById(i11)).onVisibilityChanged(z11);
        }
    }

    private void b(com.instabug.bug.view.disclaimer.a aVar) {
        a(false, com.instabug.library.R.id.instabug_fragment_container);
        k0.b(getSupportFragmentManager(), aVar);
    }

    @VisibleForTesting
    public void A() {
        if (getSupportFragmentManager().getBackStackEntryCount() < 1) {
            com.instabug.bug.n.e().a(o.CANCEL);
            InstabugSDKLogger.d("IBG-BR", "Reporting bug canceled. Deleting attachments");
            Cache cache = CacheManager.getInstance().getCache(CacheManager.DEFAULT_IN_MEMORY_CACHE_KEY);
            if (cache != null) {
                cache.delete("video.path");
            }
            i.c();
            finish();
        }
        if ((InstabugStateProvider.getInstance().getState() == InstabugState.TAKING_SCREENSHOT_FOR_CHAT || InstabugStateProvider.getInstance().getState() == InstabugState.IMPORTING_IMAGE_FROM_GALLERY_FOR_CHAT) && (getSupportFragmentManager().findFragmentById(R.id.instabug_fragment_container) instanceof com.instabug.bug.view.annotation.b)) {
            InstabugStateProvider.getInstance().setState(InstabugState.ENABLED);
        }
        a(false, R.id.instabug_fragment_container);
    }

    public void B() {
        k0.i(getSupportFragmentManager(), com.instabug.bug.n.e().c() != null ? com.instabug.bug.n.e().c().g() : null, false);
    }

    public void D() {
        a(false, R.id.instabug_fragment_container);
        k0.e(getSupportFragmentManager(), com.instabug.bug.n.e().c() != null ? com.instabug.bug.n.e().c().g() : null, false);
    }

    public void E() {
        if (com.instabug.bug.n.e().c() != null) {
            com.instabug.bug.n.e().c().f("feedback");
            String f11 = com.instabug.bug.n.e().c().f();
            if (!com.instabug.bug.n.e().c().m() && f11 != null) {
                com.instabug.bug.n.e().c().a(Uri.parse(f11), Attachment.Type.MAIN_SCREENSHOT);
            }
            a(false, R.id.instabug_fragment_container);
            k0.j(getSupportFragmentManager(), com.instabug.bug.n.e().c().g(), false);
            BaseContract.Presenter presenter = this.f34199i;
            if (presenter != null) {
                ((b) presenter).l();
            }
        }
    }

    public int N() {
        return R.layout.ibg_bug_activity_bug_reporting;
    }

    public void O() {
        int i11;
        Toolbar toolbar;
        if (this.f34201j != null) {
            if (com.instabug.bug.n.e().c() == null) {
                this.f34201j.setNavigationIcon((Drawable) null);
            }
            if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                toolbar = this.f34201j;
                i11 = SettingsManager.getInstance().getPrimaryColor();
            } else {
                toolbar = this.f34201j;
                i11 = ContextCompat.getColor(this, R.color.instabug_attachment_bar_color_dark);
            }
            toolbar.setBackgroundColor(i11);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(float f11, float f12) {
        if (getIntent().getParcelableExtra(InstabugDialogActivity.KEY_SCREENSHOT_URI) != null && this.f45867a) {
            this.f45867a = false;
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundColor(ContextCompat.getColor(this, 17170443));
            ((ViewGroup) getWindow().getDecorView().getRootView()).addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            Uri uri = (Uri) getIntent().getParcelableExtra(InstabugDialogActivity.KEY_SCREENSHOT_URI);
            if (uri != null && uri.getPath() != null) {
                BitmapUtils.loadBitmap(uri.getPath(), imageView, new b(this, f11, f12, imageView));
                getIntent().putExtra(InstabugDialogActivity.KEY_SCREENSHOT_URI, (Parcelable) null);
            }
        }
    }

    public void a(@Nullable Bitmap bitmap, Uri uri) {
        BaseContract.Presenter presenter;
        InstabugSDKLogger.d("IBG-BR", "onImageEditingDone");
        if (bitmap != null) {
            BitmapUtils.saveBitmap(bitmap, uri, this, new a());
        }
        a(false, R.id.instabug_fragment_container);
        L();
        if (getSupportFragmentManager().findFragmentByTag(com.instabug.bug.view.reporting.feedback.a.E) == null && (presenter = this.f34199i) != null) {
            ((b) presenter).n();
        }
    }

    public void a(com.instabug.bug.view.disclaimer.a aVar) {
        b(aVar);
    }

    public void a(@NonNull com.instabug.bug.view.visualusersteps.steppreview.b bVar) {
        a(false, com.instabug.library.R.id.instabug_fragment_container);
        k0.c(getSupportFragmentManager(), bVar);
    }

    public void a(String str) {
        setTitle(str);
    }

    public void c(@StringRes int i11) {
        Toolbar toolbar = this.f34201j;
        if (toolbar != null) {
            toolbar.setNavigationContentDescription(i11);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(Opcodes.ASM10_EXPERIMENTAL, 17432577);
    }

    public void g() {
        Toolbar toolbar = this.f34201j;
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ibg_core_ic_close);
        }
    }

    public void h() {
        int i11 = R.id.instabug_pbi_container;
        View findViewById = findViewById(i11);
        InstabugCore.handlePbiFooter(findViewById);
        InstabugCore.setPbiFooterThemeColor(findViewById, AttrResolver.resolveAttributeColor(getViewContext(), R.attr.instabug_foreground_color));
        findViewById.setBackgroundColor(AttrResolver.getColor(getViewContext(), R.attr.ibg_bug_color_bg_pbi));
        if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
            ViewCompat.setImportantForAccessibility(findViewById(i11), 4);
        }
    }

    public void i() {
        k0.j(getSupportFragmentManager(), com.instabug.bug.n.e().c() != null ? com.instabug.bug.n.e().c().g() : null, false);
    }

    public void l() {
        Cache cache = CacheManager.getInstance().getCache(CacheManager.DEFAULT_IN_MEMORY_CACHE_KEY);
        if (cache != null) {
            cache.delete("video.path");
        }
        finish();
    }

    public void n() {
        InstabugSDKLogger.d("IBG-BR", "startWithHangingBug");
        if (com.instabug.bug.n.e().c() != null) {
            InstabugSDKLogger.d("IBG-BR", "bug attachment size: " + com.instabug.bug.n.e().c().a().size());
        }
        com.instabug.bug.n.e().a(false);
        if (getSupportFragmentManager().findFragmentByTag(com.instabug.bug.view.reporting.feedback.a.E) == null) {
            a(false, R.id.instabug_fragment_container);
            BaseContract.Presenter presenter = this.f34199i;
            if (presenter != null) {
                ((b) presenter).n();
            }
        }
        com.instabug.bug.n.e().e(this);
        BaseContract.Presenter presenter2 = this.f34199i;
        if (presenter2 != null) {
            ((b) presenter2).l();
        }
    }

    public String o() {
        return String.valueOf(getTitle());
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        for (Fragment onActivityResult : getSupportFragmentManager().getFragments()) {
            onActivityResult.onActivityResult(i11, i12, intent);
        }
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            overridePendingTransition(Opcodes.ASM10_EXPERIMENTAL, 17432577);
            super.onBackPressed();
            return;
        }
        KeyboardUtils.hide(this);
        M();
    }

    public void onBackStackChanged() {
        a(true, R.id.instabug_fragment_container);
    }

    public void onClick(View view) {
        ArrayList arrayList = new ArrayList(getSupportFragmentManager().getFragments());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add((Object) null);
        arrayList.removeAll(arrayList2);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(Opcodes.ASM10_EXPERIMENTAL, 17432577);
        if (com.instabug.bug.n.e().c() == null) {
            InstabugSDKLogger.e("IBG-BR", "Bug is null, closing reporting activity and back to launch the app");
            finishActivity();
            return;
        }
        StatusBarUtils.darkenStatusBarColor(this, InstabugCore.getPrimaryColor());
        if (InstabugCore.getTheme() != null) {
            setTheme(com.instabug.bug.utils.a.b(InstabugCore.getTheme()));
        }
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        b bVar = new b(this);
        int intExtra = getIntent().getIntExtra("com.instabug.library.process", Opcodes.IF_ICMPGE);
        this.f34199i = bVar;
        if (bundle == null) {
            bVar.a(intExtra);
        }
        getWindow().setSoftInputMode(3);
    }

    public void onDestroy() {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((b) presenter).onDestroy();
        }
        if (!com.instabug.bug.n.e().f() && com.instabug.bug.n.e().d() == o.ADD_ATTACHMENT) {
            com.instabug.bug.n.e().a(o.CANCEL);
        }
        OrientationUtils.unlockOrientation(this);
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        b bVar = new b(this);
        this.f34199i = bVar;
        if (e.a(intent.getData())) {
            K();
        }
        bVar.a(intent.getIntExtra("com.instabug.library.process", Opcodes.IF_ICMPGE));
    }

    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.f45868b;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f45868b.dismiss();
        }
    }

    public void onStart() {
        super.onStart();
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null) {
            bugPlugin.setState(1);
        }
        InstabugSDKLogger.d("IBG-BR", "Reporting activity started, SDK Invoking State Changed: true");
    }

    public void onStop() {
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (!(bugPlugin == null || bugPlugin.getState() == 2)) {
            bugPlugin.setState(0);
        }
        InstabugSDKLogger.d("IBG-BR", "Reporting activity paused, SDK Invoking State Changed: false");
        super.onStop();
    }

    public void r() {
        if (com.instabug.bug.n.e().c() != null) {
            com.instabug.bug.n.e().c().f("bug");
            String f11 = com.instabug.bug.n.e().c().f();
            if (!com.instabug.bug.n.e().c().m() && f11 != null) {
                com.instabug.bug.n.e().c().a(Uri.parse(f11), Attachment.Type.MAIN_SCREENSHOT);
            }
            a(false, R.id.instabug_fragment_container);
            k0.i(getSupportFragmentManager(), com.instabug.bug.n.e().c().g(), false);
            BaseContract.Presenter presenter = this.f34199i;
            if (presenter != null) {
                ((b) presenter).l();
            }
        }
    }

    public void w() {
        a(false, com.instabug.library.R.id.instabug_fragment_container);
        k0.h(getSupportFragmentManager(), J());
    }

    public void y() {
        Toolbar toolbar = this.f34201j;
        if (toolbar != null) {
            if (LocaleUtils.isRTL(InstabugCore.getLocale(this))) {
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ibg_core_ic_back);
                if (drawable != null) {
                    toolbar.setNavigationIcon(DrawableUtils.getRotateDrawable(drawable, 180.0f));
                }
            } else {
                toolbar.setNavigationIcon(R.drawable.ibg_core_ic_back);
            }
        }
        this.f34201j = toolbar;
    }
}
