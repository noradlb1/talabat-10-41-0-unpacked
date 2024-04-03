package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";

    /* renamed from: b  reason: collision with root package name */
    public MenuItemImpl f688b;

    /* renamed from: c  reason: collision with root package name */
    public MenuBuilder.ItemInvoker f689c;

    /* renamed from: d  reason: collision with root package name */
    public PopupCallback f690d;
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    private int mMaxIconSize;
    private int mMinWidth;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        public ShowableListMenu getPopup() {
            PopupCallback popupCallback = ActionMenuItemView.this.f690d;
            if (popupCallback != null) {
                return popupCallback.getPopup();
            }
            return null;
        }

        public boolean onForwardingStarted() {
            ShowableListMenu popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.f689c;
            if (itemInvoker == null || !itemInvoker.invokeItem(actionMenuItemView.f688b) || (popup = getPopup()) == null || !popup.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class PopupCallback {
        public abstract ShowableListMenu getPopup();
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        int i12 = configuration.screenHeightDp;
        if (i11 >= 480 || ((i11 >= 640 && i12 >= 480) || configuration.orientation == 2)) {
            return true;
        }
        return false;
    }

    private void updateTextButtonVisibility() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z11 = true;
        boolean z12 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null && (!this.f688b.showsTextAsAction() || (!this.mAllowTextWithIcon && !this.mExpandedFormat))) {
            z11 = false;
        }
        boolean z13 = z12 & z11;
        CharSequence charSequence3 = null;
        if (z13) {
            charSequence = this.mTitle;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f688b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z13) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f688b.getTitle();
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f688b.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z13) {
                charSequence3 = this.f688b.getTitle();
            }
            TooltipCompat.setTooltipText(this, charSequence3);
            return;
        }
        TooltipCompat.setTooltipText(this, tooltipText);
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public MenuItemImpl getItemData() {
        return this.f688b;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void initialize(MenuItemImpl menuItemImpl, int i11) {
        int i12;
        this.f688b = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.c(this));
        setId(menuItemImpl.getItemId());
        if (menuItemImpl.isVisible()) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        setVisibility(i12);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener();
        }
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public boolean needsDividerBefore() {
        return hasText() && this.f688b.getIcon() == null;
    }

    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.f689c;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.f688b);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        boolean hasText = hasText();
        if (hasText && (i14 = this.mSavedPaddingLeft) >= 0) {
            super.setPadding(i14, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i13 = Math.min(size, this.mMinWidth);
        } else {
            i13 = this.mMinWidth;
        }
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < i13) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
        }
        if (!hasText && this.mIcon != null) {
            super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (!this.f688b.hasSubMenu() || (forwardingListener = this.mForwardingListener) == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z11) {
    }

    public void setChecked(boolean z11) {
    }

    public void setExpandedFormat(boolean z11) {
        if (this.mExpandedFormat != z11) {
            this.mExpandedFormat = z11;
            MenuItemImpl menuItemImpl = this.f688b;
            if (menuItemImpl != null) {
                menuItemImpl.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i11 = this.mMaxIconSize;
            if (intrinsicWidth > i11) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i11) / ((float) intrinsicWidth)));
                intrinsicWidth = i11;
            }
            if (intrinsicHeight > i11) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i11) / ((float) intrinsicHeight)));
            } else {
                i11 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i11);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f689c = itemInvoker;
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        this.mSavedPaddingLeft = i11;
        super.setPadding(i11, i12, i13, i14);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f690d = popupCallback;
    }

    public void setShortcut(boolean z11, char c11) {
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        updateTextButtonVisibility();
    }

    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i11, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }
}
