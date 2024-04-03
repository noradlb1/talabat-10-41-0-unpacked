package com.instabug.bug.view.reporting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.instabug.bug.R;
import com.instabug.bug.n;
import com.instabug.bug.screenrecording.c;
import com.instabug.bug.settings.b;
import com.instabug.bug.view.extrafields.d;
import com.instabug.bug.view.i;
import com.instabug.bug.view.l;
import com.instabug.bug.view.m;
import com.instabug.library.Feature;
import com.instabug.library.FragmentVisibilityChangedListener;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.internal.video.RequestPermissionActivityLauncher;
import com.instabug.library.internal.video.VideoPlayerFragment;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.custom.InstabugAlertDialog;
import com.instabug.library.ui.custom.InstabugEditText;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.DisplayUtils;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.KeyboardUtils;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.SystemServiceUtils;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import zb.e;
import zb.f;
import zb.g;
import zb.h;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED", "ERADICATE_FIELD_NOT_NULLABLE"})
public abstract class x extends InstabugBaseFragment implements i, View.OnClickListener, i0 {
    /* access modifiers changed from: private */
    public static int D = -1;
    /* access modifiers changed from: private */
    public final AccessibilityDelegateCompat A = new m(this);
    /* access modifiers changed from: private */
    public final AccessibilityDelegateCompat B = new p(this);
    @VisibleForTesting
    public ScrollView G;
    public ViewTreeObserver.OnGlobalLayoutListener H = new q(this);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public EditText f45918a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f45919b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f45920c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f45921d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f45922e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f45923f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f45924g;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f45925i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f45926j;

    /* renamed from: k  reason: collision with root package name */
    private BroadcastReceiver f45927k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ProgressDialog f45928l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public l f45929m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public a f45930n;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public m f45931o;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public BottomSheetBehavior f45932p;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    public ImageView f45933q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f45934r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f45935s = false;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f45936t = false;

    /* renamed from: u  reason: collision with root package name */
    private long f45937u = 0;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public Runnable f45938v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final Handler f45939w = new Handler();

    /* renamed from: x  reason: collision with root package name */
    private ViewStub f45940x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private EditText f45941y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private TextWatcher f45942z;

    public interface a {
        void a(float f11, float f12);

        void l();
    }

    /* access modifiers changed from: private */
    public void G() {
        if (this.F != null) {
            if (b.f().a().b()) {
                int i11 = R.id.instabug_add_attachment;
                if (i(i11) != null) {
                    i(i11).setVisibility(4);
                }
                d(0);
                return;
            }
            int i12 = R.id.instabug_add_attachment;
            if (i(i12) != null) {
                i(i12).setVisibility(8);
            }
            d(8);
        }
    }

    private String H() {
        return PlaceHolderUtils.getPlaceHolder(getContext(), InstabugCustomTextPlaceHolder.Key.REPORT_ADD_ATTACHMENT_HEADER, R.string.instabug_str_add_attachment);
    }

    private String J() {
        return PlaceHolderUtils.getPlaceHolder(getContext(), InstabugCustomTextPlaceHolder.Key.REPORT_REPRO_STEPS_DISCLAIMER_BODY, R.string.IBGReproStepsDisclaimerBody);
    }

    private String K() {
        return PlaceHolderUtils.getPlaceHolder(getContext(), InstabugCustomTextPlaceHolder.Key.REPORT_REPRO_STEPS_DISCLAIMER_LINK, R.string.IBGReproStepsDisclaimerLink);
    }

    private void M() {
        ImageView imageView = this.f45933q;
        if (imageView != null && this.f45934r == 1) {
            imageView.setVisibility(8);
            int i11 = R.id.instabug_add_attachment;
            if (i(i11) != null) {
                i(i11).setVisibility(8);
            }
        }
    }

    private void N() {
        if (getActivity() != null) {
            KeyboardUtils.hide(getActivity());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fd A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0102 A[Catch:{ Exception -> 0x010b }] */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void O() {
        /*
            r6 = this;
            int r0 = com.instabug.bug.R.id.instabug_attachment_bottom_sheet     // Catch:{ Exception -> 0x010b }
            android.view.View r0 = r6.i(r0)     // Catch:{ Exception -> 0x010b }
            int r1 = com.instabug.bug.R.id.instabug_add_attachment_label     // Catch:{ Exception -> 0x010b }
            android.view.View r1 = r6.i(r1)     // Catch:{ Exception -> 0x010b }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x010b }
            if (r1 == 0) goto L_0x0017
            java.lang.String r2 = r6.H()     // Catch:{ Exception -> 0x010b }
            r1.setText(r2)     // Catch:{ Exception -> 0x010b }
        L_0x0017:
            int r1 = com.instabug.bug.R.id.instabug_add_attachment_icon     // Catch:{ Exception -> 0x010b }
            android.view.View r1 = r6.i(r1)     // Catch:{ Exception -> 0x010b }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x010b }
            int r2 = com.instabug.bug.R.id.arrow_handler     // Catch:{ Exception -> 0x010b }
            android.view.View r2 = r6.i(r2)     // Catch:{ Exception -> 0x010b }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x010b }
            r3 = 0
            if (r2 == 0) goto L_0x003b
            r2.setRotation(r3)     // Catch:{ Exception -> 0x010b }
            r2.setOnClickListener(r6)     // Catch:{ Exception -> 0x010b }
            boolean r4 = com.instabug.library.util.AccessibilityUtils.isAccessibilityServiceEnabled()     // Catch:{ Exception -> 0x010b }
            if (r4 == 0) goto L_0x003b
            androidx.core.view.AccessibilityDelegateCompat r4 = r6.A     // Catch:{ Exception -> 0x010b }
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r2, r4)     // Catch:{ Exception -> 0x010b }
        L_0x003b:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r0)     // Catch:{ Exception -> 0x010b }
            r6.f45932p = r0     // Catch:{ Exception -> 0x010b }
            android.content.Context r4 = com.instabug.library.Instabug.getApplicationContext()     // Catch:{ Exception -> 0x010b }
            r5 = 1120403456(0x42c80000, float:100.0)
            int r4 = com.instabug.library.view.ViewUtils.convertDpToPx(r4, r5)     // Catch:{ Exception -> 0x010b }
            r0.setPeekHeight(r4)     // Catch:{ Exception -> 0x010b }
            int r0 = com.instabug.bug.R.id.instabug_add_attachment     // Catch:{ Exception -> 0x010b }
            android.view.View r4 = r6.i(r0)     // Catch:{ Exception -> 0x010b }
            if (r4 == 0) goto L_0x005d
            android.view.View r4 = r6.i(r0)     // Catch:{ Exception -> 0x010b }
            r4.setOnClickListener(r6)     // Catch:{ Exception -> 0x010b }
        L_0x005d:
            int r4 = com.instabug.bug.R.id.ib_bottomsheet_arrow_layout     // Catch:{ Exception -> 0x010b }
            android.view.View r5 = r6.i(r4)     // Catch:{ Exception -> 0x010b }
            if (r5 == 0) goto L_0x006c
            android.view.View r4 = r6.i(r4)     // Catch:{ Exception -> 0x010b }
            r4.setOnClickListener(r6)     // Catch:{ Exception -> 0x010b }
        L_0x006c:
            if (r1 == 0) goto L_0x0079
            com.instabug.library.settings.SettingsManager r4 = com.instabug.library.settings.SettingsManager.getInstance()     // Catch:{ Exception -> 0x010b }
            int r4 = r4.getPrimaryColor()     // Catch:{ Exception -> 0x010b }
            r6.a((android.widget.ImageView) r1, (int) r4)     // Catch:{ Exception -> 0x010b }
        L_0x0079:
            r6.b0()     // Catch:{ Exception -> 0x010b }
            android.view.View r1 = r6.i(r0)     // Catch:{ Exception -> 0x010b }
            r4 = 4
            if (r1 == 0) goto L_0x008a
            android.view.View r0 = r6.i(r0)     // Catch:{ Exception -> 0x010b }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x010b }
        L_0x008a:
            int r0 = r6.f45934r     // Catch:{ Exception -> 0x010b }
            r1 = 1
            if (r0 <= r1) goto L_0x0099
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f45932p     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x00a5
            com.instabug.bug.view.reporting.w r1 = new com.instabug.bug.view.reporting.w     // Catch:{ Exception -> 0x010b }
            r1.<init>(r6, r2)     // Catch:{ Exception -> 0x010b }
            goto L_0x00a2
        L_0x0099:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f45932p     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x00a5
            com.instabug.bug.view.reporting.c r1 = new com.instabug.bug.view.reporting.c     // Catch:{ Exception -> 0x010b }
            r1.<init>(r6)     // Catch:{ Exception -> 0x010b }
        L_0x00a2:
            r0.setBottomSheetCallback(r1)     // Catch:{ Exception -> 0x010b }
        L_0x00a5:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f45932p     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x00b2
            int r1 = D     // Catch:{ Exception -> 0x010b }
            r5 = -1
            if (r1 != r5) goto L_0x00af
            r1 = 3
        L_0x00af:
            r0.setState(r1)     // Catch:{ Exception -> 0x010b }
        L_0x00b2:
            int r0 = D     // Catch:{ Exception -> 0x010b }
            r1 = 1127481344(0x43340000, float:180.0)
            if (r0 != r4) goto L_0x00d0
            r6.y()     // Catch:{ Exception -> 0x010b }
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f45932p     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x00c2
            r0.setState(r4)     // Catch:{ Exception -> 0x010b }
        L_0x00c2:
            if (r2 == 0) goto L_0x00e3
            r2.setRotation(r1)     // Catch:{ Exception -> 0x010b }
            boolean r0 = com.instabug.library.util.AccessibilityUtils.isAccessibilityServiceEnabled()     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x00e3
            androidx.core.view.AccessibilityDelegateCompat r0 = r6.B     // Catch:{ Exception -> 0x010b }
            goto L_0x00e0
        L_0x00d0:
            r6.G()     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x00e3
            r2.setRotation(r3)     // Catch:{ Exception -> 0x010b }
            boolean r0 = com.instabug.library.util.AccessibilityUtils.isAccessibilityServiceEnabled()     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x00e3
            androidx.core.view.AccessibilityDelegateCompat r0 = r6.A     // Catch:{ Exception -> 0x010b }
        L_0x00e0:
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r2, r0)     // Catch:{ Exception -> 0x010b }
        L_0x00e3:
            r6.g()     // Catch:{ Exception -> 0x010b }
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x0105
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()     // Catch:{ Exception -> 0x010b }
            boolean r0 = com.instabug.library.util.OrientationUtils.isInLandscape(r0)     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x0105
            r6.y()     // Catch:{ Exception -> 0x010b }
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.f45932p     // Catch:{ Exception -> 0x010b }
            if (r0 == 0) goto L_0x0100
            r0.setState(r4)     // Catch:{ Exception -> 0x010b }
        L_0x0100:
            if (r2 == 0) goto L_0x0105
            r2.setRotation(r1)     // Catch:{ Exception -> 0x010b }
        L_0x0105:
            r6.M()     // Catch:{ Exception -> 0x010b }
            r6.f45933q = r2     // Catch:{ Exception -> 0x010b }
            goto L_0x0113
        L_0x010b:
            r0 = move-exception
            java.lang.String r1 = "IBG-BR"
            java.lang.String r2 = "Error in initAttachmentsActionBar"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r2, r0)
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.reporting.x.O():void");
    }

    private void P() {
        if (b.f().a().c()) {
            this.f45934r++;
            int i11 = R.id.instabug_attach_screenshot;
            if (i(i11) != null) {
                i(i11).setOnClickListener(this);
            }
            ImageView imageView = (ImageView) i(R.id.ib_bug_attachment_collapsed_screenshot_icon);
            a((ImageView) i(R.id.instabug_attach_screenshot_icon), SettingsManager.getInstance().getPrimaryColor());
            if (getContext() != null) {
                a(imageView, AttrResolver.resolveAttributeColor(getContext(), R.attr.ibg_bug_add_attachment_icon_color));
                return;
            }
            return;
        }
        int i12 = R.id.instabug_attach_screenshot;
        if (i(i12) != null) {
            i(i12).setVisibility(8);
        }
        int i13 = R.id.ib_bug_attachment_collapsed_screenshot_icon;
        if (i(i13) != null) {
            i(i13).setVisibility(8);
        }
        int i14 = R.id.ib_bug_screenshot_separator;
        if (i(i14) != null) {
            i(i14).setVisibility(8);
        }
    }

    private void Q() {
        if (b.f().a().a()) {
            this.f45934r++;
            int i11 = R.id.instabug_attach_gallery_image;
            if (i(i11) != null) {
                i(i11).setOnClickListener(this);
            }
            ImageView imageView = (ImageView) i(R.id.instabug_attach_gallery_image_icon);
            ImageView imageView2 = (ImageView) i(R.id.ib_bug_attachment_collapsed_photo_library_icon);
            if (getContext() != null) {
                a(imageView2, AttrResolver.resolveAttributeColor(getContext(), R.attr.ibg_bug_add_attachment_icon_color));
            }
            a(imageView, SettingsManager.getInstance().getPrimaryColor());
            return;
        }
        int i12 = R.id.instabug_attach_gallery_image;
        if (i(i12) != null) {
            i(i12).setVisibility(8);
        }
        int i13 = R.id.ib_bug_attachment_collapsed_photo_library_icon;
        if (i(i13) != null) {
            i(i13).setVisibility(8);
        }
    }

    private void R() {
        this.f45927k = new n(this);
    }

    private void S() {
        if (b.f().a().b()) {
            this.f45934r++;
            int i11 = R.id.instabug_attach_video;
            if (i(i11) != null) {
                i(i11).setOnClickListener(this);
            }
            ImageView imageView = (ImageView) i(R.id.ib_bug_attachment_collapsed_video_icon);
            a((ImageView) i(R.id.instabug_attach_video_icon), SettingsManager.getInstance().getPrimaryColor());
            if (getContext() != null) {
                a(imageView, AttrResolver.resolveAttributeColor(getContext(), R.attr.ibg_bug_add_attachment_icon_color));
                return;
            }
            return;
        }
        d(8);
        int i12 = R.id.ib_bug_attachment_collapsed_video_icon;
        if (i(i12) != null) {
            i(i12).setVisibility(8);
        }
        int i13 = R.id.ib_bug_videorecording_separator;
        if (i(i13) != null) {
            i(i13).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V() {
        EditText editText = this.f45918a;
        if (editText != null) {
            editText.addTextChangedListener(new v(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W() {
        String emailForBugReport = UserManagerWrapper.getEmailForBugReport();
        if (n.e().c() != null) {
            State state = n.e().c().getState();
            String userEmail = state != null ? state.getUserEmail() : null;
            if (userEmail != null && !userEmail.isEmpty()) {
                emailForBugReport = userEmail;
            } else if (emailForBugReport == null || emailForBugReport.isEmpty()) {
                emailForBugReport = null;
            }
            if (emailForBugReport != null) {
                f(emailForBugReport);
            }
        }
        l();
    }

    private void Y() {
        if (getActivity() != null) {
            getActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.H);
        }
    }

    @RequiresApi(api = 21)
    private void Z() {
        if (getActivity() != null) {
            if (!(ContextCompat.checkSelfPermission(getActivity(), "android.permission.RECORD_AUDIO") == 0)) {
                requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, Opcodes.RETURN);
            } else {
                a0();
            }
        }
    }

    private void a(View view, Attachment attachment, @IdRes int i11) {
        this.f45938v = new i(this, i11, view, attachment);
    }

    private void a(ImageView imageView, int i11) {
        if (imageView != null) {
            imageView.getDrawable().setColorFilter(i11, PorterDuff.Mode.SRC_IN);
        }
    }

    private void a(Attachment attachment, ImageView imageView, String str) {
        if (attachment.getLocalPath() != null) {
            b(false);
            FragmentTransaction beginTransaction = getFragmentManager() != null ? getFragmentManager().beginTransaction() : null;
            Uri fromFile = Uri.fromFile(new File(attachment.getLocalPath()));
            String transitionName = ViewCompat.getTransitionName(imageView);
            if (!(transitionName == null || beginTransaction == null)) {
                beginTransaction.addSharedElement(imageView, transitionName);
            }
            if (((BitmapDrawable) imageView.getDrawable()) != null && beginTransaction != null) {
                beginTransaction.replace(R.id.instabug_fragment_container, (Fragment) com.instabug.bug.view.annotation.b.a(str, fromFile, attachment.getName()), "annotation").addToBackStack("annotation").commitAllowingStateLoss();
            }
        }
    }

    private void a(Runnable runnable) {
        if (c.a().b()) {
            String str = getLocalizedString(R.string.instabug_str_video_encoder_busy) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + getLocalizedString(R.string.instabug_str_please_wait);
            if (getContext() != null) {
                Toast.makeText(getContext().getApplicationContext(), str, 1).show();
                return;
            }
            return;
        }
        runnable.run();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        EditText editText = this.f45918a;
        if (editText != null) {
            editText.setText(str);
        }
    }

    private void a(String str, String str2) {
        BaseContract.Presenter presenter = this.C;
        com.instabug.bug.view.visualusersteps.steppreview.b bVar = new com.instabug.bug.view.visualusersteps.steppreview.b(presenter != null ? ((h0) presenter).h() : str2, str, str2);
        m mVar = this.f45931o;
        if (mVar != null) {
            mVar.a(bVar);
        }
    }

    @RequiresApi(api = 21)
    private void a0() {
        MediaProjectionManager mediaProjectionManager;
        if (getActivity() != null && (mediaProjectionManager = (MediaProjectionManager) getActivity().getSystemService("media_projection")) != null) {
            k0.a(mediaProjectionManager, this);
        }
    }

    /* access modifiers changed from: private */
    public void b(View view, Attachment attachment) {
        ImageView imageView;
        N();
        if (attachment.getLocalPath() != null && (imageView = (ImageView) view.findViewById(R.id.instabug_img_attachment)) != null) {
            if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
                a(attachment.getLocalPath(), imageView.getContentDescription().toString());
                return;
            }
            BaseContract.Presenter presenter = this.C;
            if (presenter != null) {
                a(attachment, imageView, ((h0) presenter).h());
            }
        }
    }

    private void b0() {
        S();
        P();
        Q();
    }

    private boolean c0() {
        return DisplayUtils.isSmallDevice() && b.f().c() != null && !b.f().c().toString().equals("");
    }

    private void d(int i11) {
        if (!b.f().a().b()) {
            int i12 = R.id.instabug_attach_video;
            if (i(i12) != null) {
                i(i12).setVisibility(8);
            }
            int i13 = R.id.ib_bug_attachment_collapsed_video_icon;
            if (i(i13) != null) {
                i(i13).setVisibility(8);
                return;
            }
            return;
        }
        int i14 = R.id.instabug_attach_video;
        if (i(i14) != null) {
            i(i14).setVisibility(i11);
        }
    }

    private void d0() {
        if (getActivity() != null) {
            new InstabugAlertDialog.Builder(getActivity()).setMessage(getLocalizedString(R.string.ib_alert_phone_number_msg)).setPositiveButton(getLocalizedString(R.string.instabug_str_ok), new e()).show();
        }
    }

    /* access modifiers changed from: private */
    public void e0() {
        if (getActivity() != null) {
            new InstabugAlertDialog.Builder(getActivity()).setTitle(getLocalizedString(R.string.instabug_str_alert_title_max_attachments)).setMessage(getLocalizedString(R.string.instabug_str_alert_message_max_attachments)).setPositiveButton(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BUG_ATTACHMENT_DIALOG_OK_BUTTON, getLocalizedString(R.string.instabug_str_ok)), (DialogInterface.OnClickListener) null).show();
        }
    }

    private void f(String str) {
        PoolProvider.postMainThreadTask(new f(this, str));
    }

    /* access modifiers changed from: private */
    @RequiresApi(api = 21)
    public void f0() {
        if (!c.a().b()) {
            Z();
        } else if (getContext() != null) {
            Toast.makeText(getContext().getApplicationContext(), R.string.instabug_str_video_encoder_busy, 0).show();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void g() {
        int i11 = R.id.instabug_attach_gallery_image_label;
        if (i(i11) != null) {
            ((TextView) i(i11)).setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.ADD_IMAGE_FROM_GALLERY, getLocalizedString(R.string.instabug_str_pick_media_from_gallery)));
        }
        int i12 = R.id.instabug_attach_screenshot_label;
        if (i(i12) != null) {
            ((TextView) i(i12)).setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.ADD_EXTRA_SCREENSHOT, getLocalizedString(R.string.instabug_str_take_screenshot)));
        }
        int i13 = R.id.instabug_attach_video_label;
        if (i(i13) != null) {
            ((TextView) i(i13)).setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.ADD_VIDEO, getLocalizedString(R.string.instabug_str_record_video)));
        }
    }

    private static void g0() {
        D = -1;
    }

    private void h0() {
        if (getActivity() != null) {
            getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.H);
        }
    }

    private void l() {
        PoolProvider.postMainThreadTask(new zb.i(this));
    }

    private void o() {
        long b11 = (long) n.e().b();
        if (b11 != -1 && AccessibilityUtils.isAccessibilityServiceEnabled()) {
            AccessibilityUtils.sendTextEvent(getLocalizedString(R.string.ibg_screen_recording_duration_ended_for_accessibility, Long.valueOf(b11)));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void w() {
        EditText editText = this.f45918a;
        if (editText != null) {
            editText.clearFocus();
            this.f45918a.setError((CharSequence) null);
        }
        EditText editText2 = this.f45919b;
        if (editText2 != null) {
            editText2.clearFocus();
            this.f45919b.setError((CharSequence) null);
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        if (this.F != null) {
            int i11 = R.id.instabug_add_attachment;
            if (i(i11) != null) {
                i(i11).setVisibility(0);
            }
            d(b.f().a().b() ? 4 : 8);
        }
    }

    public abstract int A0();

    public void C() {
        h0 h0Var = (h0) this.C;
        if (!(h0Var == null || getFragmentManager() == null)) {
            k0.d(getFragmentManager(), h0Var.h());
        }
        this.C = h0Var;
    }

    public boolean T() {
        return this.f45929m.c() != null && this.f45929m.c().getVisibility() == 0;
    }

    public boolean U() {
        return this.f45929m.d() != null && this.f45929m.d().getVisibility() == 0;
    }

    public void X() {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((h0) presenter).g();
        }
    }

    public void a() {
        ProgressDialog progressDialog = this.f45928l;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f45928l.dismiss();
        }
    }

    public void a(Intent intent, int i11) {
        startActivityForResult(intent, i11);
    }

    public void a(Spanned spanned) {
        this.f45920c.setVisibility(0);
        this.f45920c.setText(spanned);
        this.f45920c.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void a(Spanned spanned, String str) {
        this.f45921d.setVisibility(0);
        this.f45921d.setText(spanned);
        if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
            ViewCompat.setAccessibilityDelegate(this.f45921d, new l(this, str));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(View view, Attachment attachment) {
        w();
        if (getActivity() != null) {
            SystemServiceUtils.hideInputMethod(getActivity());
        }
        int id2 = view.getId();
        if (this.f45938v == null) {
            a(view, attachment, id2);
        }
        this.f45939w.postDelayed(this.f45938v, 200);
    }

    public void a(Attachment attachment) {
        this.f45929m.b(attachment);
        this.f45929m.notifyDataSetChanged();
    }

    public void a(List list) {
        View view;
        this.f45929m.a();
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (((Attachment) list.get(i12)).getType() != null) {
                if (((Attachment) list.get(i12)).getType().equals(Attachment.Type.MAIN_SCREENSHOT) || ((Attachment) list.get(i12)).getType().equals(Attachment.Type.EXTRA_IMAGE) || ((Attachment) list.get(i12)).getType().equals(Attachment.Type.GALLERY_IMAGE) || ((Attachment) list.get(i12)).getType().equals(Attachment.Type.AUDIO) || ((Attachment) list.get(i12)).getType().equals(Attachment.Type.EXTRA_VIDEO) || ((Attachment) list.get(i12)).getType().equals(Attachment.Type.GALLERY_VIDEO) || ((Attachment) list.get(i12)).getType().equals(Attachment.Type.AUTO_SCREEN_RECORDING_VIDEO)) {
                    if (((Attachment) list.get(i12)).getType().equals(Attachment.Type.GALLERY_VIDEO)) {
                        ((Attachment) list.get(i12)).setVideoEncoded(true);
                    }
                    this.f45929m.a((Attachment) list.get(i12));
                }
                if ((((Attachment) list.get(i12)).getType().equals(Attachment.Type.EXTRA_VIDEO) || ((Attachment) list.get(i12)).getType().equals(Attachment.Type.GALLERY_VIDEO)) && n.e().c() != null) {
                    n.e().c().setHasVideo(true);
                }
            }
        }
        int i13 = -1;
        for (int i14 = 0; i14 < this.f45929m.b().size(); i14++) {
            if (((Attachment) this.f45929m.b().get(i14)).getType() != null && (((Attachment) this.f45929m.b().get(i14)).getType().equals(Attachment.Type.MAIN_SCREENSHOT) || ((Attachment) this.f45929m.b().get(i14)).getType().equals(Attachment.Type.GALLERY_IMAGE) || ((Attachment) this.f45929m.b().get(i14)).getType().equals(Attachment.Type.EXTRA_IMAGE))) {
                i13 = i14;
            }
        }
        this.f45929m.d(i13);
        this.f45922e.setAdapter(this.f45929m);
        this.f45929m.notifyDataSetChanged();
        if (InstabugCore.getFeatureState(Feature.MULTIPLE_ATTACHMENTS) != Feature.State.ENABLED || !b.f().m()) {
            int i15 = R.id.instabug_attachment_bottom_sheet;
            if (i(i15) != null) {
                view = i(i15);
                i11 = 8;
            }
            this.f45922e.post(new j(this));
            startPostponedEnterTransition();
        }
        int i16 = R.id.instabug_attachment_bottom_sheet;
        if (i(i16) != null) {
            view = i(i16);
        }
        this.f45922e.post(new j(this));
        startPostponedEnterTransition();
        view.setVisibility(i11);
        this.f45922e.post(new j(this));
        startPostponedEnterTransition();
    }

    public void b() {
        ProgressDialog progressDialog = this.f45928l;
        if (progressDialog != null) {
            if (progressDialog.isShowing() || getFragmentManager() == null || getFragmentManager().isStateSaved()) {
                return;
            }
        } else if (getActivity() != null) {
            ProgressDialog progressDialog2 = new ProgressDialog(getActivity());
            this.f45928l = progressDialog2;
            progressDialog2.setCancelable(false);
            this.f45928l.setMessage(getLocalizedString(R.string.instabug_str_dialog_message_preparing));
            if (getFragmentManager() == null || getFragmentManager().isStateSaved()) {
                return;
            }
        } else {
            return;
        }
        this.f45928l.show();
    }

    public void b(String str) {
        this.f45919b.requestFocus();
        this.f45919b.setError(str);
    }

    public void b(boolean z11) {
        if (getFragmentManager() != null) {
            FragmentManager fragmentManager = getFragmentManager();
            int i11 = R.id.instabug_fragment_container;
            if (fragmentManager.findFragmentById(i11) instanceof FragmentVisibilityChangedListener) {
                ((FragmentVisibilityChangedListener) getFragmentManager().findFragmentById(i11)).onVisibilityChanged(z11);
            }
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ Activity c() {
        return super.getActivity();
    }

    public void c(String str) {
        EditText editText = this.f45941y;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void c(boolean z11) {
        ImageView imageView;
        int i11;
        if (this.f45929m.c() != null) {
            if (z11) {
                imageView = this.f45929m.c();
                i11 = 0;
            } else {
                imageView = this.f45929m.c();
                i11 = 8;
            }
            imageView.setVisibility(i11);
        }
    }

    public void d() {
        this.f45921d.setVisibility(8);
    }

    public void d(String str) {
        EditText editText = this.f45941y;
        if (editText != null) {
            editText.requestFocus();
            this.f45941y.setError(str);
        }
    }

    public void d(boolean z11) {
        ProgressBar progressBar;
        int i11;
        if (this.f45929m.d() != null) {
            if (z11) {
                progressBar = this.f45929m.d();
                i11 = 0;
            } else {
                progressBar = this.f45929m.d();
                i11 = 8;
            }
            progressBar.setVisibility(i11);
        }
    }

    public void e() {
        try {
            this.f45940x.inflate();
        } catch (IllegalStateException unused) {
        }
        this.f45941y = (EditText) i(R.id.instabug_edit_text_phone);
        View i11 = i(R.id.instabug_image_button_phone_info);
        if (i11 != null) {
            i11.setOnClickListener(this);
        }
        o oVar = new o(this);
        this.f45942z = oVar;
        EditText editText = this.f45941y;
        if (editText != null) {
            editText.addTextChangedListener(oVar);
        }
    }

    public void e(String str) {
        this.f45918a.requestFocus();
        this.f45918a.setError(str);
    }

    public void f() {
        k0.g(this, getLocalizedString(R.string.instabug_str_pick_media_chooser_title));
    }

    public void g(String str) {
        if (str == null || getFragmentManager() == null) {
            if (!U()) {
                d(true);
            }
            if (T()) {
                c(false);
                return;
            }
            return;
        }
        getFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) VideoPlayerFragment.newInstance(str), "video_player").addToBackStack("play video").commitAllowingStateLoss();
    }

    public String getLocalizedString(@StringRes int i11) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), i11, getContext());
    }

    public String getLocalizedString(@StringRes int i11, Object... objArr) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), i11, getContext(), objArr);
    }

    public int i0() {
        return R.layout.ibg_bug_frgament_reporting_layout;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void j0(View view, @Nullable Bundle bundle) {
        if (getActivity() instanceof ReportingContainerActivity) {
            ReportingContainerActivity reportingContainerActivity = (ReportingContainerActivity) getActivity();
            reportingContainerActivity.c(z0());
            reportingContainerActivity.g();
        }
        this.G = (ScrollView) i(R.id.ib_bug_scroll_view);
        this.f45919b = ((InstabugEditText) i(R.id.instabug_edit_text_message)).getEditText();
        InstabugEditText instabugEditText = (InstabugEditText) i(R.id.instabug_edit_text_email);
        this.f45918a = instabugEditText.getEditText();
        this.f45922e = (RecyclerView) i(R.id.instabug_lyt_attachments_list);
        this.f45920c = (TextView) i(R.id.instabug_text_view_disclaimer);
        this.f45921d = (TextView) i(R.id.instabug_text_view_repro_steps_disclaimer);
        this.f45940x = (ViewStub) i(R.id.instabug_viewstub_phone);
        this.f45923f = (LinearLayout) i(R.id.instabug_add_attachment);
        h0 h0Var = (h0) this.C;
        if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
            ViewCompat.setAccessibilityDelegate(this.f45923f, new r(this));
        }
        this.f45924g = (LinearLayout) i(R.id.instabug_bug_reporting_edit_texts_container);
        O();
        if (getContext() != null) {
            this.f45922e.setLayoutManager(new LinearLayoutManager(getContext(), 0, TextUtilsCompat.getLayoutDirectionFromLocale(InstabugCore.getLocale(getContext())) == 1));
            ViewCompat.setLayoutDirection(this.f45922e, 0);
            this.f45929m = new l(getContext(), (ColorFilter) null, this);
        }
        String placeHolder = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.EMAIL_FIELD_HINT, getLocalizedString(R.string.instabug_str_email_hint));
        this.f45918a.setHint(placeHolder);
        if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
            ViewCompat.setAccessibilityDelegate(this.f45918a, new s(this, placeHolder));
            ViewCompat.setAccessibilityDelegate(this.f45919b, new t(this, h0Var));
        }
        this.f45921d.setOnClickListener(this);
        if (!b.f().q()) {
            instabugEditText.setVisibility(8);
        }
        if (!(h0Var == null || h0Var.a() == null)) {
            this.f45919b.setHint(h0Var.a());
        }
        String str = this.f45925i;
        if (str != null) {
            this.f45919b.setText(str);
        }
        if (b.f().q()) {
            PoolProvider.postIOTask(new g(this));
        }
        if (h0Var != null) {
            h0Var.a(J(), K());
            h0Var.d();
        }
        this.C = h0Var;
        N();
        if (c0()) {
            float dpToPx = DisplayUtils.dpToPx(getResources(), 5);
            int dpToPxIntRounded = DisplayUtils.dpToPxIntRounded(getResources(), 14);
            this.f45918a.setTextSize(dpToPx);
            this.f45918a.setPadding(dpToPxIntRounded, dpToPxIntRounded, dpToPxIntRounded, dpToPxIntRounded);
            this.f45919b.setTextSize(dpToPx);
            this.f45919b.setPadding(dpToPxIntRounded, dpToPxIntRounded, dpToPxIntRounded, dpToPxIntRounded);
            this.f45918a.setMinimumHeight(0);
            this.f45918a.setLines(1);
        }
        this.f45919b.addTextChangedListener(new u(this, h0Var));
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public String k() {
        EditText editText = this.f45941y;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((h0) presenter).a(i11, i12, intent);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f45930n = (a) context;
            if (getActivity() instanceof m) {
                this.f45931o = (m) context;
            }
        } catch (ClassCastException unused) {
            throw new ClassCastException(getClass().getSimpleName() + " must implement BaseReportingFragment.Callbacks");
        }
    }

    public void onClick(View view) {
        Handler handler;
        Runnable runnable;
        Runnable fVar;
        if (SystemClock.elapsedRealtime() - this.f45937u >= 1000) {
            this.f45937u = SystemClock.elapsedRealtime();
            int id2 = view.getId();
            if (id2 == R.id.instabug_attach_screenshot) {
                fVar = new d(this);
            } else if (id2 == R.id.instabug_attach_gallery_image) {
                fVar = new e(this);
            } else if (id2 == R.id.instabug_attach_video) {
                fVar = new f(this);
            } else {
                if (id2 == R.id.ib_bottomsheet_arrow_layout || id2 == R.id.arrow_handler) {
                    N();
                    handler = new Handler();
                    runnable = new g(this);
                } else if (id2 == R.id.instabug_add_attachment) {
                    BottomSheetBehavior bottomSheetBehavior = this.f45932p;
                    if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 4) {
                        N();
                        handler = new Handler();
                        runnable = new h(this);
                    } else {
                        return;
                    }
                } else if (id2 == R.id.instabug_text_view_repro_steps_disclaimer) {
                    m mVar = this.f45931o;
                    if (mVar != null) {
                        mVar.w();
                        return;
                    }
                    return;
                } else if (id2 == R.id.instabug_image_button_phone_info) {
                    d0();
                    return;
                } else {
                    return;
                }
                handler.postDelayed(runnable, 200);
                return;
            }
            a(fVar);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        postponeEnterTransition();
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f45925i = getArguments().getString("bug_message");
        }
        setHasOptionsMenu(true);
        R();
        if (this.C == null) {
            this.C = w0();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Drawable drawable;
        MenuItem menuItem;
        menuInflater.inflate(R.menu.instabug_bug_reporting, menu);
        BaseContract.Presenter presenter = this.C;
        if (presenter != null ? ((h0) presenter).i() : false) {
            MenuItem findItem = menu.findItem(R.id.instabug_bugreporting_send);
            if (findItem != null) {
                findItem.setVisible(false);
            }
            menuItem = menu.findItem(R.id.instabug_bugreporting_next);
            if (menuItem != null) {
                menuItem.setVisible(true);
                if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
                    menuItem.setTitle(R.string.ibg_bug_report_next_btn_content_description);
                }
                Drawable icon = menuItem.getIcon();
                if (getContext() != null && icon != null && LocaleUtils.isRTL(InstabugCore.getLocale(getContext()))) {
                    drawable = DrawableUtils.getRotateDrawable(icon, 180.0f);
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            int i11 = R.id.instabug_bugreporting_send;
            menu.findItem(i11).setVisible(true);
            menu.findItem(R.id.instabug_bugreporting_next).setVisible(false);
            menu.findItem(i11).setTitle(A0());
            Drawable icon2 = menu.findItem(i11).getIcon();
            if (getContext() != null && icon2 != null && LocaleUtils.isRTL(InstabugCore.getLocale(getContext()))) {
                menuItem = menu.findItem(i11);
                drawable = DrawableUtils.getRotateDrawable(icon2, 180.0f);
            } else {
                return;
            }
        }
        menuItem.setIcon(drawable);
    }

    public void onDestroy() {
        Handler handler;
        Runnable runnable = this.f45938v;
        if (!(runnable == null || (handler = this.f45939w) == null)) {
            handler.removeCallbacks(runnable);
            this.f45938v = null;
        }
        super.onDestroy();
        g0();
    }

    public void onDestroyView() {
        super.onDestroyView();
        LinearLayout linearLayout = this.f45924g;
        if (linearLayout != null) {
            linearLayout.clearFocus();
            this.f45924g.removeAllViews();
        }
        this.f45934r = 0;
        this.f45920c = null;
        this.f45918a = null;
        this.f45919b = null;
        this.f45941y = null;
        this.f45940x = null;
        this.f45921d = null;
        this.G = null;
        this.f45933q = null;
        this.f45922e = null;
        this.f45932p = null;
        this.f45929m = null;
        this.f45923f = null;
        this.f45924g = null;
    }

    public void onDetach() {
        super.onDetach();
        this.f45931o = null;
        this.f45930n = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        h0 h0Var = (h0) this.C;
        if (SystemClock.elapsedRealtime() - this.f45937u < 1000) {
            return false;
        }
        this.f45937u = SystemClock.elapsedRealtime();
        if (menuItem.getItemId() != R.id.instabug_bugreporting_next || h0Var == null) {
            if (menuItem.getItemId() != R.id.instabug_bugreporting_send || h0Var == null) {
                if (menuItem.getItemId() == 16908332 && getActivity() != null) {
                    getActivity().onBackPressed();
                }
                this.C = h0Var;
                return false;
            } else if (getFragmentManager() != null) {
                for (Fragment fragment : getFragmentManager().getFragments()) {
                    if (fragment instanceof d) {
                        return super.onOptionsItemSelected(menuItem);
                    }
                }
            }
        }
        h0Var.f();
        this.C = h0Var;
        return false;
    }

    @RequiresApi(api = 21)
    public void onRequestPermissionsResult(int i11, @NotNull String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            if (i11 != 177) {
                return;
            }
        } else if (i11 != 177) {
            if (i11 != 3873) {
                super.onRequestPermissionsResult(i11, strArr, iArr);
                return;
            }
            f();
            n.e().g();
            return;
        }
        a0();
    }

    public void onResume() {
        super.onResume();
        o();
        Y();
    }

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((h0) presenter).b(bundle);
        }
    }

    public void onStart() {
        super.onStart();
        h0 h0Var = (h0) this.C;
        if (!(getActivity() == null || h0Var == null)) {
            h0Var.e();
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f45927k, new IntentFilter("refresh.attachments"));
            h0Var.k();
        }
        this.C = h0Var;
    }

    public void onStop() {
        TextWatcher textWatcher;
        BaseContract.Presenter presenter;
        super.onStop();
        if (!(getActivity() == null || (presenter = this.C) == null)) {
            ((h0) presenter).c();
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f45927k);
        }
        h0();
        EditText editText = this.f45941y;
        if (editText != null && (textWatcher = this.f45942z) != null) {
            editText.removeTextChangedListener(textWatcher);
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        BaseContract.Presenter presenter;
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(16);
        }
        m mVar = this.f45931o;
        if (mVar != null && (presenter = this.C) != null) {
            mVar.a(((h0) presenter).h());
        }
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((h0) presenter).a(bundle);
        }
    }

    public void p() {
        this.f45920c.setVisibility(8);
    }

    public String s() {
        return this.f45918a.getText().toString();
    }

    public void t() {
        if (getActivity() != null) {
            new InstabugAlertDialog.Builder(getActivity()).setTitle(getLocalizedString(R.string.instabug_str_video_length_limit_warning_title)).setMessage(getLocalizedString(R.string.instabug_str_video_length_limit_warning_message)).setPositiveButton(getLocalizedString(R.string.instabug_str_ok), new h()).show();
        }
    }

    public void u() {
        if (getActivity() != null) {
            RequestPermissionActivityLauncher.start(getActivity(), false, false, (ScreenshotProvider.ScreenshotCapturingListener) null);
        }
    }

    public abstract h0 w0();

    public void x() {
        if (getActivity() != null) {
            new InstabugAlertDialog.Builder(getActivity()).setTitle(getLocalizedString(R.string.instabug_str_bugreport_file_size_limit_warning_title)).setMessage(getLocalizedString(R.string.instabug_str_bugreport_file_size_limit_warning_message, 50L)).setPositiveButton(getLocalizedString(R.string.instabug_str_ok), new zb.d()).show();
        }
    }

    public void z() {
        N();
        new Handler().postDelayed(new k(this), 200);
    }

    @StringRes
    public abstract int z0();
}
