package com.instabug.library.invocation.invocationdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;
import com.instabug.library.Instabug;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.invocation.invocationdialog.l;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.ScreenUtility;
import com.instabug.library.util.StatusBarUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InstabugDialogActivity extends BaseFragmentActivity implements l.a, c, View.OnClickListener, b {
    public static final String KEY_DIALOG_ITEMS = "dialog_items";
    public static final String KEY_DIALOG_SHOULD_OVERRIDE_TITLE_DESC = "dialog_should_override_title_desc";
    public static final String KEY_DIALOG_TITLE = "dialog_title";
    public static final String KEY_SCREENSHOT_URI = "screenshot_uri";
    private static final String KEY_SHOULD_BE_KILLED = "should_be_killed";
    private static final String TAG = "InstabugDialogActivity";
    private static Locale currentDialogLocale;
    @Nullable
    private ArrayList<InstabugDialogItem> dialogItems;
    private boolean isInflated = false;
    @Nullable
    private Uri screenshotUri;
    @Nullable
    private View[] sharedViews;
    private boolean shouldBeKilled = false;

    private boolean areDialogItemsTheSame(@Nullable ArrayList<InstabugDialogItem> arrayList) {
        ArrayList<InstabugDialogItem> arrayList2 = this.dialogItems;
        if (arrayList2 != null) {
            return arrayList2.equals(arrayList);
        }
        if (arrayList == null) {
            return true;
        }
        return false;
    }

    private e createPresenter() {
        return new e(this);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static Intent getIntent(Context context, @Nullable String str, @Nullable Uri uri, @Nullable ArrayList<InstabugDialogItem> arrayList, boolean z11) {
        Intent intent = new Intent(context, InstabugDialogActivity.class);
        intent.putExtra("dialog_title", str);
        intent.putExtra(KEY_SCREENSHOT_URI, uri);
        intent.putExtra(KEY_DIALOG_ITEMS, arrayList);
        intent.putExtra(KEY_SHOULD_BE_KILLED, z11);
        intent.addFlags(268435456);
        return intent;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private void runOnSdkInvokedRunnable() {
        if (SettingsManager.getInstance().getOnSdkInvokedCallback() != null) {
            SettingsManager.getInstance().getOnSdkInvokedCallback().onSdkInvoked();
        }
    }

    public void finish() {
        OnSdkDismissCallback onSdkDismissCallback;
        BaseContract.Presenter presenter = this.f34199i;
        if (!(presenter == null || ((e) presenter).d() || (onSdkDismissCallback = SettingsManager.getInstance().getOnSdkDismissCallback()) == null)) {
            onSdkDismissCallback.call(OnSdkDismissCallback.DismissType.CANCEL, OnSdkDismissCallback.ReportType.OTHER);
        }
        super.finish();
        overridePendingTransition(R.anim.ib_core_anim_fade_in, R.anim.ib_core_anim_fade_out);
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public List<InstabugDialogItem> getDialogItems() {
        if (getIntent() != null) {
            return (ArrayList) getIntent().getSerializableExtra(KEY_DIALOG_ITEMS);
        }
        return null;
    }

    public int getEnterAnimation() {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            return ((e) presenter).b();
        }
        return 0;
    }

    public int getExitAnimation() {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            return ((e) presenter).c();
        }
        return 0;
    }

    public int getFadeInAnimation() {
        return R.anim.ib_core_anim_fade_in;
    }

    public int getLayout() {
        return R.layout.ib_lyt_activity_dialog;
    }

    public int getSlidInLeftAnimation() {
        return R.anim.ib_core_anim_slide_in_left;
    }

    public int getSlidInRightAnimation() {
        return R.anim.ib_core_anim_slide_in_right;
    }

    public int getSlidOutLeftAnimation() {
        return R.anim.ib_core_anim_slide_out_left;
    }

    public int getSlidOutRightAnimation() {
        return R.anim.ib_core_anim_slide_out_right;
    }

    public void initViews() {
        if (this.f34199i == null) {
            this.f34199i = createPresenter();
        }
        if (getIntent().getSerializableExtra(KEY_DIALOG_ITEMS) == null) {
            finish();
            return;
        }
        findViewById(R.id.ib_fragment_container).setOnClickListener(this);
        findViewById(R.id.ib_dialog_container).setOnClickListener(this);
        if (getIntent().getBooleanExtra(KEY_SHOULD_BE_KILLED, false)) {
            this.shouldBeKilled = true;
        }
        if (this.dialogItems == null) {
            this.dialogItems = (ArrayList) getIntent().getSerializableExtra(KEY_DIALOG_ITEMS);
        }
    }

    public void onBackPressed() {
        overridePendingTransition(R.anim.ib_core_anim_fade_in, R.anim.ib_core_anim_fade_out);
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((e) presenter).e();
        }
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ib_fragment_container || view.getId() == R.id.ib_dialog_container) {
            BaseContract.Presenter presenter = this.f34199i;
            if (presenter != null) {
                ((e) presenter).h();
            }
            finish();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        FrameLayout frameLayout;
        overridePendingTransition(R.anim.ib_core_anim_fade_in, R.anim.ib_core_anim_fade_out);
        super.onCreate(bundle);
        StatusBarUtils.setStatusBarColorForPrompt(this);
        if (ScreenUtility.hasNavBar(this) && !ScreenUtility.isLandscape(this) && (frameLayout = (FrameLayout) findViewById(R.id.ib_fragment_container)) != null) {
            frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), frameLayout.getPaddingBottom() + ScreenUtility.getNavigationBarHeight(getResources()));
        }
        this.screenshotUri = (Uri) getIntent().getParcelableExtra(KEY_SCREENSHOT_URI);
        runOnSdkInvokedRunnable();
        setTitle(" ");
    }

    public void onDestroy() {
        BaseContract.Presenter presenter;
        if (isFinishing() && (presenter = this.f34199i) != null && !((e) presenter).d()) {
            ((e) this.f34199i).a(this.screenshotUri);
        }
        super.onDestroy();
    }

    public void onDialogItemClicked(@Nullable InstabugDialogItem instabugDialogItem, View... viewArr) {
        this.sharedViews = viewArr;
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((e) presenter).b(instabugDialogItem, this.screenshotUri);
        }
        if (this.shouldBeKilled) {
            finish();
        }
    }

    public void onInitialScreenShotNotRequired() {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((e) presenter).a(this.screenshotUri);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = getIntent().getStringExtra("dialog_title");
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(KEY_DIALOG_ITEMS);
        if (!areDialogItemsTheSame(arrayList)) {
            setIntent(intent);
            if (arrayList == null) {
                finish();
                return;
            }
            if (stringExtra == null) {
                stringExtra = "";
            }
            setContent(stringExtra, true, arrayList);
            if (intent.getBooleanExtra(KEY_SHOULD_BE_KILLED, false)) {
                this.shouldBeKilled = true;
            }
        }
    }

    public void onPause() {
        super.onPause();
        SettingsManager.getInstance().setPromptOptionsScreenShown(false);
        currentDialogLocale = InstabugCore.getLocale(this);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.dialogItems = (ArrayList) bundle.getSerializable(KEY_DIALOG_ITEMS);
    }

    public void onResume() {
        super.onResume();
        if (currentDialogLocale != null && !InstabugCore.getLocale(this).equals(currentDialogLocale)) {
            finish();
            Instabug.show();
        }
        if (!this.isInflated) {
            getSupportFragmentManager().beginTransaction().replace(R.id.ib_fragment_container, l.a(getIntent().getStringExtra("dialog_title"), true, this.dialogItems)).commit();
            this.isInflated = true;
        }
        SettingsManager.getInstance().setPromptOptionsScreenShown(true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(KEY_DIALOG_ITEMS, this.dialogItems);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((e) presenter).f();
        }
    }

    public void onStop() {
        super.onStop();
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((e) presenter).g();
        }
    }

    public void removeScreenshotIfNeeded(InstabugDialogItem instabugDialogItem) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((e) presenter).d(instabugDialogItem);
        }
    }

    public void setContent(@Nullable String str, boolean z11, ArrayList<InstabugDialogItem> arrayList) {
        String transitionName;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        try {
            View[] viewArr = this.sharedViews;
            if (viewArr != null) {
                for (View view : viewArr) {
                    if (!(view == null || (transitionName = ViewCompat.getTransitionName(view)) == null)) {
                        beginTransaction.addSharedElement(view, transitionName);
                    }
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        this.dialogItems = arrayList;
        beginTransaction.setCustomAnimations(0, R.anim.ib_core_anim_invocation_dialog_exit).addToBackStack((String) null).replace(R.id.ib_fragment_container, l.a(str, z11, arrayList)).commit();
    }
}
