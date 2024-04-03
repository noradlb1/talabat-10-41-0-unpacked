package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {

    /* renamed from: a  reason: collision with root package name */
    public final MenuPopupHelper f846a;

    /* renamed from: b  reason: collision with root package name */
    public OnMenuItemClickListener f847b;

    /* renamed from: c  reason: collision with root package name */
    public OnDismissListener f848c;
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    public void dismiss() {
        this.f846a.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new ForwardingListener(this.mAnchor) {
                public ShowableListMenu getPopup() {
                    return PopupMenu.this.f846a.getPopup();
                }

                public boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                public boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }
            };
        }
        return this.mDragListener;
    }

    public int getGravity() {
        return this.f846a.getGravity();
    }

    @NonNull
    public Menu getMenu() {
        return this.mMenu;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    public void inflate(@MenuRes int i11) {
        getMenuInflater().inflate(i11, this.mMenu);
    }

    public void setForceShowIcon(boolean z11) {
        this.f846a.setForceShowIcon(z11);
    }

    public void setGravity(int i11) {
        this.f846a.setGravity(i11);
    }

    public void setOnDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.f848c = onDismissListener;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener onMenuItemClickListener) {
        this.f847b = onMenuItemClickListener;
    }

    public void show() {
        this.f846a.show();
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i11) {
        this(context, view, i11, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i11, @AttrRes int i12, @StyleRes int i13) {
        this.mContext = context;
        this.mAnchor = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.mMenu = menuBuilder;
        menuBuilder.setCallback(new MenuBuilder.Callback() {
            public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.f847b;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }

            public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            }
        });
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i12, i13);
        this.f846a = menuPopupHelper;
        menuPopupHelper.setGravity(i11);
        menuPopupHelper.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                PopupMenu popupMenu = PopupMenu.this;
                OnDismissListener onDismissListener = popupMenu.f848c;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(popupMenu);
                }
            }
        });
    }
}
