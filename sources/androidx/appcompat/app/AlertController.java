package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {

    /* renamed from: a  reason: collision with root package name */
    public final AppCompatDialog f502a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f503b;

    /* renamed from: c  reason: collision with root package name */
    public Button f504c;

    /* renamed from: d  reason: collision with root package name */
    public Message f505d;

    /* renamed from: e  reason: collision with root package name */
    public Button f506e;

    /* renamed from: f  reason: collision with root package name */
    public Message f507f;

    /* renamed from: g  reason: collision with root package name */
    public Button f508g;

    /* renamed from: h  reason: collision with root package name */
    public Message f509h;

    /* renamed from: i  reason: collision with root package name */
    public NestedScrollView f510i;

    /* renamed from: j  reason: collision with root package name */
    public ListAdapter f511j;

    /* renamed from: k  reason: collision with root package name */
    public int f512k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f513l;

    /* renamed from: m  reason: collision with root package name */
    public int f514m;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f504c && (message4 = alertController.f505d) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f506e && (message3 = alertController.f507f) != null) {
                message = Message.obtain(message3);
            } else if (view != alertController.f508g || (message2 = alertController.f509h) == null) {
                message = null;
            } else {
                message = Message.obtain(message2);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f517p.obtainMessage(1, alertController2.f502a).sendToTarget();
        }
    };
    private final int mButtonIconDimen;
    private Drawable mButtonNegativeIcon;
    private CharSequence mButtonNegativeText;
    private Drawable mButtonNeutralIcon;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint = 0;
    private int mButtonPanelSideLayout;
    private Drawable mButtonPositiveIcon;
    private CharSequence mButtonPositiveText;
    private final Context mContext;
    private View mCustomTitleView;
    private Drawable mIcon;
    private int mIconId = 0;
    private ImageView mIconView;
    private CharSequence mMessage;
    private TextView mMessageView;
    private boolean mShowTitle;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified = false;
    private int mViewSpacingTop;
    private final Window mWindow;

    /* renamed from: n  reason: collision with root package name */
    public int f515n;

    /* renamed from: o  reason: collision with root package name */
    public int f516o;

    /* renamed from: p  reason: collision with root package name */
    public Handler f517p;

    /* renamed from: androidx.appcompat.app.AlertController$2  reason: invalid class name */
    public class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f520b;

        public void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
            AlertController.b(nestedScrollView, this.f519a, this.f520b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$3  reason: invalid class name */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f521b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f522c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AlertController f523d;

        public void run() {
            AlertController.b(this.f523d.f510i, this.f521b, this.f522c);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$4  reason: invalid class name */
    public class AnonymousClass4 implements AbsListView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f524b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f525c;

        public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
            AlertController.b(absListView, this.f524b, this.f525c);
        }

        public void onScrollStateChanged(AbsListView absListView, int i11) {
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$5  reason: invalid class name */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f526b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f527c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AlertController f528d;

        public void run() {
            AlertController.b(this.f528d.f503b, this.f526b, this.f527c);
        }
    }

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem = -1;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId = 0;
        public int mIconId = 0;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure = true;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified = false;
        public int mViewSpacingTop;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$AlertParams$2] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$AlertParams$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void createListView(final androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.mInflater
                int r1 = r11.f513l
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.mIsMultiChoice
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.mCursor
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$AlertParams$1 r9 = new androidx.appcompat.app.AlertController$AlertParams$1
                android.content.Context r3 = r10.mContext
                int r4 = r11.f514m
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.mItems
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$AlertParams$2 r9 = new androidx.appcompat.app.AlertController$AlertParams$2
                android.content.Context r3 = r10.mContext
                android.database.Cursor r4 = r10.mCursor
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.mIsSingleChoice
                if (r1 == 0) goto L_0x003c
                int r1 = r11.f515n
                goto L_0x003e
            L_0x003c:
                int r1 = r11.f516o
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.mCursor
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.mContext
                android.database.Cursor r5 = r10.mCursor
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.mLabelColumn
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.mAdapter
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$CheckedItemAdapter r9 = new androidx.appcompat.app.AlertController$CheckedItemAdapter
                android.content.Context r1 = r10.mContext
                java.lang.CharSequence[] r3 = r10.mItems
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$AlertParams$OnPrepareListViewListener r1 = r10.mOnPrepareListViewListener
                if (r1 == 0) goto L_0x0072
                r1.onPrepareListView(r0)
            L_0x0072:
                r11.f511j = r9
                int r1 = r10.mCheckedItem
                r11.f512k = r1
                android.content.DialogInterface$OnClickListener r1 = r10.mOnClickListener
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$AlertParams$3 r1 = new androidx.appcompat.app.AlertController$AlertParams$3
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x0091
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.mOnCheckboxClickListener
                if (r1 == 0) goto L_0x0091
                androidx.appcompat.app.AlertController$AlertParams$4 r1 = new androidx.appcompat.app.AlertController$AlertParams$4
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x0091:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.mOnItemSelectedListener
                if (r1 == 0) goto L_0x0098
                r0.setOnItemSelectedListener(r1)
            L_0x0098:
                boolean r1 = r10.mIsSingleChoice
                if (r1 == 0) goto L_0x00a0
                r0.setChoiceMode(r8)
                goto L_0x00a8
            L_0x00a0:
                boolean r1 = r10.mIsMultiChoice
                if (r1 == 0) goto L_0x00a8
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a8:
                r11.f503b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.AlertParams.createListView(androidx.appcompat.app.AlertController):void");
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i11 = this.mIconId;
                if (i11 != 0) {
                    alertController.setIcon(i11);
                }
                int i12 = this.mIconAttrId;
                if (i12 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i12));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            CharSequence charSequence3 = this.mPositiveButtonText;
            if (!(charSequence3 == null && this.mPositiveButtonIcon == null)) {
                alertController.setButton(-1, charSequence3, this.mPositiveButtonListener, (Message) null, this.mPositiveButtonIcon);
            }
            CharSequence charSequence4 = this.mNegativeButtonText;
            if (!(charSequence4 == null && this.mNegativeButtonIcon == null)) {
                alertController.setButton(-2, charSequence4, this.mNegativeButtonListener, (Message) null, this.mNegativeButtonIcon);
            }
            CharSequence charSequence5 = this.mNeutralButtonText;
            if (!(charSequence5 == null && this.mNeutralButtonIcon == null)) {
                alertController.setButton(-3, charSequence5, this.mNeutralButtonListener, (Message) null, this.mNeutralButtonIcon);
            }
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                createListView(alertController);
            }
            View view2 = this.mView;
            if (view2 == null) {
                int i13 = this.mViewLayoutResId;
                if (i13 != 0) {
                    alertController.setView(i13);
                }
            } else if (this.mViewSpacingSpecified) {
                alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            } else {
                alertController.setView(view2);
            }
        }
    }

    public static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == -3 || i11 == -2 || i11 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
            } else if (i11 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i11, int i12, CharSequence[] charSequenceArr) {
            super(context, i11, i12, charSequenceArr);
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void setHasDecor(boolean z11, boolean z12) {
            int i11;
            int i12;
            if (!z12 || !z11) {
                int paddingLeft = getPaddingLeft();
                if (z11) {
                    i11 = getPaddingTop();
                } else {
                    i11 = this.mPaddingTopNoTitle;
                }
                int paddingRight = getPaddingRight();
                if (z12) {
                    i12 = getPaddingBottom();
                } else {
                    i12 = this.mPaddingBottomNoButtons;
                }
                setPadding(paddingLeft, i11, paddingRight, i12);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.f502a = appCompatDialog;
        this.mWindow = window;
        this.f517p = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f513l = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f514m = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f515n = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f516o = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void b(View view, View view2, View view3) {
        int i11;
        int i12 = 0;
        if (view2 != null) {
            if (view.canScrollVertically(-1)) {
                i11 = 0;
            } else {
                i11 = 4;
            }
            view2.setVisibility(i11);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i12 = 4;
            }
            view3.setVisibility(i12);
        }
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int selectContentView() {
        int i11 = this.mButtonPanelSideLayout;
        if (i11 == 0) {
            return this.mAlertDialogLayout;
        }
        if (this.mButtonPanelLayoutHint == 1) {
            return i11;
        }
        return this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int i11, int i12) {
        View findViewById = this.mWindow.findViewById(R.id.scrollIndicatorUp);
        View findViewById2 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(view, i11, i12);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        boolean z11;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f504c = button;
        button.setOnClickListener(this.mButtonHandler);
        boolean z12 = true;
        if (!TextUtils.isEmpty(this.mButtonPositiveText) || this.mButtonPositiveIcon != null) {
            this.f504c.setText(this.mButtonPositiveText);
            Drawable drawable = this.mButtonPositiveIcon;
            if (drawable != null) {
                int i11 = this.mButtonIconDimen;
                drawable.setBounds(0, 0, i11, i11);
                this.f504c.setCompoundDrawables(this.mButtonPositiveIcon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f504c.setVisibility(0);
            z11 = true;
        } else {
            this.f504c.setVisibility(8);
            z11 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f506e = button2;
        button2.setOnClickListener(this.mButtonHandler);
        if (!TextUtils.isEmpty(this.mButtonNegativeText) || this.mButtonNegativeIcon != null) {
            this.f506e.setText(this.mButtonNegativeText);
            Drawable drawable2 = this.mButtonNegativeIcon;
            if (drawable2 != null) {
                int i12 = this.mButtonIconDimen;
                drawable2.setBounds(0, 0, i12, i12);
                this.f506e.setCompoundDrawables(this.mButtonNegativeIcon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f506e.setVisibility(0);
            z11 |= true;
        } else {
            this.f506e.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f508g = button3;
        button3.setOnClickListener(this.mButtonHandler);
        if (!TextUtils.isEmpty(this.mButtonNeutralText) || this.mButtonNeutralIcon != null) {
            this.f508g.setText(this.mButtonNeutralText);
            Drawable drawable3 = this.mButtonNeutralIcon;
            if (drawable3 != null) {
                int i13 = this.mButtonIconDimen;
                drawable3.setBounds(0, 0, i13, i13);
                this.f508g.setCompoundDrawables(this.mButtonNeutralIcon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f508g.setVisibility(0);
            z11 |= true;
        } else {
            this.f508g.setVisibility(8);
        }
        if (shouldCenterSingleButton(this.mContext)) {
            if (z11) {
                centerButton(this.f504c);
            } else if (z11) {
                centerButton(this.f506e);
            } else if (z11) {
                centerButton(this.f508g);
            }
        }
        if (!z11) {
            z12 = false;
        }
        if (!z12) {
            viewGroup.setVisibility(8);
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.mWindow.findViewById(R.id.scrollView);
        this.f510i = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f510i.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.mMessageView = textView;
        if (textView != null) {
            CharSequence charSequence = this.mMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.f510i.removeView(this.mMessageView);
            if (this.f503b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f510i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f510i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f503b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        View view = this.mView;
        boolean z11 = false;
        if (view == null) {
            if (this.mViewLayoutResId != 0) {
                view = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z11 = true;
        }
        if (!z11 || !a(view)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (z11) {
            FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.f503b != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.mWindow.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.mTitle)) || !this.mShowTitle) {
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.mWindow.findViewById(R.id.alertTitle);
        this.mTitleView = textView;
        textView.setText(this.mTitle);
        int i11 = this.mIconId;
        if (i11 != 0) {
            this.mIconView.setImageResource(i11);
            return;
        }
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
            return;
        }
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    private void setupView() {
        boolean z11;
        boolean z12;
        boolean z13;
        ListAdapter listAdapter;
        View findViewById;
        View view;
        View findViewById2;
        View findViewById3 = this.mWindow.findViewById(R.id.parentPanel);
        int i11 = R.id.topPanel;
        View findViewById4 = findViewById3.findViewById(i11);
        int i12 = R.id.contentPanel;
        View findViewById5 = findViewById3.findViewById(i12);
        int i13 = R.id.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i13);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        setupCustomContent(viewGroup);
        View findViewById7 = viewGroup.findViewById(i11);
        View findViewById8 = viewGroup.findViewById(i12);
        View findViewById9 = viewGroup.findViewById(i13);
        ViewGroup resolvePanel = resolvePanel(findViewById7, findViewById4);
        ViewGroup resolvePanel2 = resolvePanel(findViewById8, findViewById5);
        ViewGroup resolvePanel3 = resolvePanel(findViewById9, findViewById6);
        setupContent(resolvePanel2);
        setupButtons(resolvePanel3);
        setupTitle(resolvePanel);
        char c11 = 0;
        if (viewGroup.getVisibility() != 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (resolvePanel == null || resolvePanel.getVisibility() == 8) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (resolvePanel3 == null || resolvePanel3.getVisibility() == 8) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!(z13 || resolvePanel2 == null || (findViewById2 = resolvePanel2.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z12) {
            NestedScrollView nestedScrollView = this.f510i;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.mMessage == null && this.f503b == null) {
                view = null;
            } else {
                view = resolvePanel.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(resolvePanel2 == null || (findViewById = resolvePanel2.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f503b;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z12, z13);
        }
        if (!z11) {
            View view2 = this.f503b;
            if (view2 == null) {
                view2 = this.f510i;
            }
            if (view2 != null) {
                if (z13) {
                    c11 = 2;
                }
                setScrollIndicators(resolvePanel2, view2, z12 | c11 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f503b;
        if (listView2 != null && (listAdapter = this.f511j) != null) {
            listView2.setAdapter(listAdapter);
            int i14 = this.f512k;
            if (i14 > -1) {
                listView2.setItemChecked(i14, true);
                listView2.setSelection(i14);
            }
        }
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public Button getButton(int i11) {
        if (i11 == -3) {
            return this.f508g;
        }
        if (i11 == -2) {
            return this.f506e;
        }
        if (i11 != -1) {
            return null;
        }
        return this.f504c;
    }

    public int getIconAttributeResId(int i11) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.f503b;
    }

    public void installContent() {
        this.f502a.setContentView(selectContentView());
        setupView();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f510i;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f510i;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void setButton(int i11, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f517p.obtainMessage(i11, onClickListener);
        }
        if (i11 == -3) {
            this.mButtonNeutralText = charSequence;
            this.f509h = message;
            this.mButtonNeutralIcon = drawable;
        } else if (i11 == -2) {
            this.mButtonNegativeText = charSequence;
            this.f507f = message;
            this.mButtonNegativeIcon = drawable;
        } else if (i11 == -1) {
            this.mButtonPositiveText = charSequence;
            this.f505d = message;
            this.mButtonPositiveIcon = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setButtonPanelLayoutHint(int i11) {
        this.mButtonPanelLayoutHint = i11;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int i11) {
        this.mIcon = null;
        this.mIconId = i11;
        ImageView imageView = this.mIconView;
        if (imageView == null) {
            return;
        }
        if (i11 != 0) {
            imageView.setVisibility(0);
            this.mIconView.setImageResource(this.mIconId);
            return;
        }
        imageView.setVisibility(8);
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int i11) {
        this.mView = null;
        this.mViewLayoutResId = i11;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        ImageView imageView = this.mIconView;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.mIconView.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void setView(View view, int i11, int i12, int i13, int i14) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i11;
        this.mViewSpacingTop = i12;
        this.mViewSpacingRight = i13;
        this.mViewSpacingBottom = i14;
    }
}
