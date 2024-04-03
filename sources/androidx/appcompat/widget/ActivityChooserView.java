package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* renamed from: b  reason: collision with root package name */
    public final ActivityChooserViewAdapter f785b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f786c;

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f787d;

    /* renamed from: e  reason: collision with root package name */
    public ActionProvider f788e;

    /* renamed from: f  reason: collision with root package name */
    public final DataSetObserver f789f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow.OnDismissListener f790g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f791h;

    /* renamed from: i  reason: collision with root package name */
    public int f792i;
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    private final ImageView mDefaultActivityButtonImage;
    private final ImageView mExpandActivityOverflowButtonImage;
    private boolean mIsAttachedToWindow;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;

    public class ActivityChooserViewAdapter extends BaseAdapter {
        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount = 4;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;

        public ActivityChooserViewAdapter() {
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        public int getCount() {
            int activityCount = this.mDataModel.getActivityCount();
            if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                activityCount--;
            }
            int min = Math.min(activityCount, this.mMaxActivityCount);
            if (this.mShowFooterView) {
                return min + 1;
            }
            return min;
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        public Object getItem(int i11) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType == 0) {
                if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                    i11++;
                }
                return this.mDataModel.getActivity(i11);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public int getItemViewType(int i11) {
            return (!this.mShowFooterView || i11 != getCount() - 1) ? 0 : 1;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i11);
                ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.mShowDefaultActivity || i11 != 0 || !this.mHighlightDefaultActivity) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int i11 = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i12 = 0;
            View view = null;
            for (int i13 = 0; i13 < count; i13++) {
                view = getView(i13, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i12 = Math.max(i12, view.getMeasuredWidth());
            }
            this.mMaxActivityCount = i11;
            return i12;
        }

        public void setDataModel(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel dataModel = ActivityChooserView.this.f785b.getDataModel();
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(ActivityChooserView.this.f789f);
            }
            this.mDataModel = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.f789f);
            }
            notifyDataSetChanged();
        }

        public void setMaxActivityCount(int i11) {
            if (this.mMaxActivityCount != i11) {
                this.mMaxActivityCount = i11;
                notifyDataSetChanged();
            }
        }

        public void setShowDefaultActivity(boolean z11, boolean z12) {
            if (this.mShowDefaultActivity != z11 || this.mHighlightDefaultActivity != z12) {
                this.mShowDefaultActivity = z11;
                this.mHighlightDefaultActivity = z12;
                notifyDataSetChanged();
            }
        }

        public void setShowFooterView(boolean z11) {
            if (this.mShowFooterView != z11) {
                this.mShowFooterView = z11;
                notifyDataSetChanged();
            }
        }
    }

    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public Callbacks() {
        }

        private void notifyOnDismissListener() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f790g;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f787d) {
                activityChooserView.dismissPopup();
                Intent chooseActivity = ActivityChooserView.this.f785b.getDataModel().chooseActivity(ActivityChooserView.this.f785b.getDataModel().getActivityIndex(ActivityChooserView.this.f785b.getDefaultActivity()));
                if (chooseActivity != null) {
                    chooseActivity.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(chooseActivity);
                }
            } else if (view == activityChooserView.f786c) {
                activityChooserView.f791h = false;
                activityChooserView.a(activityChooserView.f792i);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            notifyOnDismissListener();
            ActionProvider actionProvider = ActivityChooserView.this.f788e;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i11);
            if (itemViewType == 0) {
                ActivityChooserView.this.dismissPopup();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.f791h) {
                    if (!activityChooserView.f785b.getShowDefaultActivity()) {
                        i11++;
                    }
                    Intent chooseActivity = ActivityChooserView.this.f785b.getDataModel().chooseActivity(i11);
                    if (chooseActivity != null) {
                        chooseActivity.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(chooseActivity);
                    }
                } else if (i11 > 0) {
                    activityChooserView.f785b.getDataModel().setDefaultActivity(i11);
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f787d) {
                if (activityChooserView.f785b.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f791h = true;
                    activityChooserView2.a(activityChooserView2.f792i);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, TINT_ATTRS);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(int i11) {
        boolean z11;
        if (this.f785b.getDataModel() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
            if (this.f787d.getVisibility() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            int activityCount = this.f785b.getActivityCount();
            if (i11 == Integer.MAX_VALUE || activityCount <= i11 + (z11 ? 1 : 0)) {
                this.f785b.setShowFooterView(false);
                this.f785b.setMaxActivityCount(i11);
            } else {
                this.f785b.setShowFooterView(true);
                this.f785b.setMaxActivityCount(i11 - 1);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.isShowing()) {
                if (this.f791h || !z11) {
                    this.f785b.setShowDefaultActivity(true, z11);
                } else {
                    this.f785b.setShowDefaultActivity(false, false);
                }
                listPopupWindow.setContentWidth(Math.min(this.f785b.measureContentWidth(), this.mListPopupMaxWidth));
                listPopupWindow.show();
                ActionProvider actionProvider = this.f788e;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
                listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
                listPopupWindow.getListView().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public void b() {
        if (this.f785b.getCount() > 0) {
            this.f786c.setEnabled(true);
        } else {
            this.f786c.setEnabled(false);
        }
        int activityCount = this.f785b.getActivityCount();
        int historySize = this.f785b.getHistorySize();
        if (activityCount == 1 || (activityCount > 1 && historySize > 0)) {
            this.f787d.setVisibility(0);
            ResolveInfo defaultActivity = this.f785b.getDefaultActivity();
            PackageManager packageManager = getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(defaultActivity.loadIcon(packageManager));
            if (this.mDefaultActionButtonContentDescription != 0) {
                CharSequence loadLabel = defaultActivity.loadLabel(packageManager);
                this.f787d.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{loadLabel}));
            }
        } else {
            this.f787d.setVisibility(8);
        }
        if (this.f787d.getVisibility() == 0) {
            this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        } else {
            this.mActivityChooserContent.setBackgroundDrawable((Drawable) null);
        }
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ActivityChooserModel getDataModel() {
        return this.f785b.getDataModel();
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.mListPopupWindow = listPopupWindow;
            listPopupWindow.setAdapter(this.f785b);
            this.mListPopupWindow.setAnchorView(this);
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
            this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
        }
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = this.f785b.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.f789f);
        }
        this.mIsAttachedToWindow = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.f785b.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.f789f);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.mActivityChooserContent.layout(0, 0, i13 - i11, i14 - i12);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public void onMeasure(int i11, int i12) {
        View view = this.mActivityChooserContent;
        if (this.f787d.getVisibility() != 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12), 1073741824);
        }
        measureChild(view, i11, i12);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f785b.setDataModel(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i11) {
        this.mDefaultActionButtonContentDescription = i11;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i11) {
        this.mExpandActivityOverflowButtonImage.setContentDescription(getContext().getString(i11));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i11) {
        this.f792i = i11;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f790g = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        this.f788e = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.f791h = false;
        a(this.f792i);
        return true;
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f789f = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f785b.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f785b.notifyDataSetInvalidated();
            }
        };
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!ActivityChooserView.this.isShowingPopup()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ActionProvider actionProvider = ActivityChooserView.this.f788e;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
            }
        };
        this.f792i = 4;
        int[] iArr = R.styleable.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i11, 0);
        this.f792i = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        Callbacks callbacks = new Callbacks();
        this.mCallbacks = callbacks;
        View findViewById = findViewById(R.id.activity_chooser_view_content);
        this.mActivityChooserContent = findViewById;
        this.mActivityChooserContentBackground = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f787d = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        int i12 = R.id.image;
        this.mDefaultActivityButtonImage = (ImageView) frameLayout.findViewById(i12);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(callbacks);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) {
            public ShowableListMenu getPopup() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            public boolean onForwardingStarted() {
                ActivityChooserView.this.showPopup();
                return true;
            }

            public boolean onForwardingStopped() {
                ActivityChooserView.this.dismissPopup();
                return true;
            }
        });
        this.f786c = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i12);
        this.mExpandActivityOverflowButtonImage = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.f785b = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.b();
            }
        });
        Resources resources = context.getResources();
        this.mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
}
