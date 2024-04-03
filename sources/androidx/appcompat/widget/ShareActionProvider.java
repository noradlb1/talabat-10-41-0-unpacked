package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

public class ShareActionProvider extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /* renamed from: a  reason: collision with root package name */
    public final Context f887a;

    /* renamed from: b  reason: collision with root package name */
    public String f888b = DEFAULT_SHARE_HISTORY_FILE_NAME;

    /* renamed from: c  reason: collision with root package name */
    public OnShareTargetSelectedListener f889c;
    private int mMaxShownActivityCount = 4;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener();

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    public class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        public ShareActivityChooserModelPolicy() {
        }

        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.f889c;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
            return false;
        }
    }

    public class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public ShareMenuItemOnMenuItemClickListener() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            Intent chooseActivity = ActivityChooserModel.get(shareActionProvider.f887a, shareActionProvider.f888b).chooseActivity(menuItem.getItemId());
            if (chooseActivity == null) {
                return true;
            }
            String action = chooseActivity.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.a(chooseActivity);
            }
            ShareActionProvider.this.f887a.startActivity(chooseActivity);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f887a = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.f889c != null) {
            if (this.mOnChooseActivityListener == null) {
                this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy();
            }
            ActivityChooserModel.get(this.f887a, this.f888b).setOnChooseActivityListener(this.mOnChooseActivityListener);
        }
    }

    public void a(Intent intent) {
        intent.addFlags(134742016);
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f887a);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.f887a, this.f888b));
        }
        TypedValue typedValue = new TypedValue();
        this.f887a.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.f887a, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel activityChooserModel = ActivityChooserModel.get(this.f887a, this.f888b);
        PackageManager packageManager = this.f887a.getPackageManager();
        int activityCount = activityChooserModel.getActivityCount();
        int min = Math.min(activityCount, this.mMaxShownActivityCount);
        for (int i11 = 0; i11 < min; i11++) {
            ResolveInfo activity = activityChooserModel.getActivity(i11);
            subMenu.add(0, i11, i11, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
        if (min < activityCount) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f887a.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i12 = 0; i12 < activityCount; i12++) {
                ResolveInfo activity2 = activityChooserModel.getActivity(i12);
                addSubMenu.add(0, i12, i12, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f889c = onShareTargetSelectedListener;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String str) {
        this.f888b = str;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                a(intent);
            }
        }
        ActivityChooserModel.get(this.f887a, this.f888b).setIntent(intent);
    }
}
