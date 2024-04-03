package androidx.core.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface SupportMenuItem extends MenuItem {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    boolean collapseActionView();

    boolean expandActionView();

    @Nullable
    View getActionView();

    int getAlphabeticModifiers();

    @Nullable
    CharSequence getContentDescription();

    @Nullable
    ColorStateList getIconTintList();

    @Nullable
    PorterDuff.Mode getIconTintMode();

    int getNumericModifiers();

    @Nullable
    ActionProvider getSupportActionProvider();

    @Nullable
    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    boolean requiresActionButton();

    boolean requiresOverflow();

    @NonNull
    MenuItem setActionView(int i11);

    @NonNull
    MenuItem setActionView(@Nullable View view);

    @NonNull
    MenuItem setAlphabeticShortcut(char c11, int i11);

    @NonNull
    /* bridge */ /* synthetic */ MenuItem setContentDescription(@Nullable CharSequence charSequence);

    @NonNull
    SupportMenuItem setContentDescription(@Nullable CharSequence charSequence);

    @NonNull
    MenuItem setIconTintList(@Nullable ColorStateList colorStateList);

    @NonNull
    MenuItem setIconTintMode(@Nullable PorterDuff.Mode mode);

    @NonNull
    MenuItem setNumericShortcut(char c11, int i11);

    @NonNull
    MenuItem setShortcut(char c11, char c12, int i11, int i12);

    void setShowAsAction(int i11);

    @NonNull
    MenuItem setShowAsActionFlags(int i11);

    @NonNull
    SupportMenuItem setSupportActionProvider(@Nullable ActionProvider actionProvider);

    @NonNull
    /* bridge */ /* synthetic */ MenuItem setTooltipText(@Nullable CharSequence charSequence);

    @NonNull
    SupportMenuItem setTooltipText(@Nullable CharSequence charSequence);
}
