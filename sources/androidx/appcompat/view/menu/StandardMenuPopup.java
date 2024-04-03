package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, View.OnKeyListener {
    private static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;

    /* renamed from: b  reason: collision with root package name */
    public final MenuPopupWindow f732b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f733c = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.isShowing() && !StandardMenuPopup.this.f732b.isModal()) {
                View view = StandardMenuPopup.this.f734d;
                if (view == null || !view.isShown()) {
                    StandardMenuPopup.this.dismiss();
                } else {
                    StandardMenuPopup.this.f732b.show();
                }
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public View f734d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver f735e;
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.f735e;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.f735e = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.f735e.removeGlobalOnLayoutListener(standardMenuPopup.f733c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity = 0;
    private boolean mHasContentWidth;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private boolean mShowTitle;
    private boolean mWasDismissed;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i11, int i12, boolean z11) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mOverflowOnly = z11;
        this.mAdapter = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z11, ITEM_LAYOUT);
        this.mPopupStyleAttr = i11;
        this.mPopupStyleRes = i12;
        Resources resources = context.getResources();
        this.mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = view;
        this.f732b = new MenuPopupWindow(context, (AttributeSet) null, i11, i12);
        menuBuilder.addMenuPresenter(this, context);
    }

    private boolean tryShow() {
        View view;
        boolean z11;
        if (isShowing()) {
            return true;
        }
        if (this.mWasDismissed || (view = this.mAnchorView) == null) {
            return false;
        }
        this.f734d = view;
        this.f732b.setOnDismissListener(this);
        this.f732b.setOnItemClickListener(this);
        this.f732b.setModal(true);
        View view2 = this.f734d;
        if (this.f735e == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f735e = viewTreeObserver;
        if (z11) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f733c);
        }
        view2.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.f732b.setAnchorView(view2);
        this.f732b.setDropDownGravity(this.mDropDownGravity);
        if (!this.mHasContentWidth) {
            this.mContentWidth = MenuPopup.b(this.mAdapter, (ViewGroup) null, this.mContext, this.mPopupMaxWidth);
            this.mHasContentWidth = true;
        }
        this.f732b.setContentWidth(this.mContentWidth);
        this.f732b.setInputMethodMode(2);
        this.f732b.setEpicenterBounds(getEpicenterBounds());
        this.f732b.show();
        ListView listView = this.f732b.getListView();
        listView.setOnKeyListener(this);
        if (this.mShowTitle && this.mMenu.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.mMenu.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f732b.setAdapter(this.mAdapter);
        this.f732b.show();
        return true;
    }

    public void addMenu(MenuBuilder menuBuilder) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.f732b.dismiss();
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.f732b.getListView();
    }

    public boolean isShowing() {
        return !this.mWasDismissed && this.f732b.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z11) {
        if (menuBuilder == this.mMenu) {
            dismiss();
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z11);
            }
        }
    }

    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        ViewTreeObserver viewTreeObserver = this.f735e;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f735e = this.f734d.getViewTreeObserver();
            }
            this.f735e.removeGlobalOnLayoutListener(this.f733c);
            this.f735e = null;
        }
        this.f734d.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i11 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, subMenuBuilder, this.f734d, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
            menuPopupHelper.setPresenterCallback(this.mPresenterCallback);
            menuPopupHelper.setForceShowIcon(MenuPopup.c(subMenuBuilder));
            menuPopupHelper.setOnDismissListener(this.mOnDismissListener);
            this.mOnDismissListener = null;
            this.mMenu.close(false);
            int horizontalOffset = this.f732b.getHorizontalOffset();
            int verticalOffset = this.f732b.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                horizontalOffset += this.mAnchorView.getWidth();
            }
            if (menuPopupHelper.tryShow(horizontalOffset, verticalOffset)) {
                MenuPresenter.Callback callback = this.mPresenterCallback;
                if (callback == null) {
                    return true;
                }
                callback.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean z11) {
        this.mAdapter.setForceShowIcon(z11);
    }

    public void setGravity(int i11) {
        this.mDropDownGravity = i11;
    }

    public void setHorizontalOffset(int i11) {
        this.f732b.setHorizontalOffset(i11);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean z11) {
        this.mShowTitle = z11;
    }

    public void setVerticalOffset(int i11) {
        this.f732b.setVerticalOffset(i11);
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z11) {
        this.mHasContentWidth = false;
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
