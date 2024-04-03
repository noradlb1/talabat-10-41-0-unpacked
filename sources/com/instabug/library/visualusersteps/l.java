package com.instabug.library.visualusersteps;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.tabs.TabLayout;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

public abstract class l {
    public static boolean a(View view) {
        return !f(view) && (view instanceof TabLayout);
    }

    private static boolean b(View view) {
        try {
            return view instanceof BottomNavigationItemView;
        } catch (IllegalAccessError e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "IllegalAccessException for BottomNavigationItemView";
            }
            InstabugSDKLogger.e("IBG-Core", message, e11);
            return false;
        }
    }

    public static boolean c(View view) {
        return !f(view) && (view instanceof Button) && !(view instanceof Switch) && !(view instanceof SwitchCompat) && !(view instanceof ToggleButton) && !(view instanceof CheckBox) && !(view instanceof RadioButton);
    }

    public static boolean d(View view) {
        return !f(view) && (view instanceof ImageButton);
    }

    public static boolean e(View view) {
        return !f(view) && (view instanceof ImageView) && !(view instanceof ImageButton);
    }

    @VisibleForTesting
    public static boolean f(View view) {
        return view.getClass().getName().contains(SettingsManager.INSTABUG_SHARED_PREF_NAME);
    }

    public static boolean g(View view) {
        if (f(view) || (!h(view) && !b(view))) {
            return false;
        }
        return true;
    }

    private static boolean h(View view) {
        try {
            return view instanceof NavigationMenuItemView;
        } catch (IllegalAccessError e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "IllegalAccessException for NavigationMenuItemView";
            }
            InstabugSDKLogger.e("IBG-Core", message, e11);
            return false;
        }
    }

    public static boolean i(View view) {
        return view instanceof SeekBar;
    }

    public static boolean j(View view) {
        return view instanceof CompoundButton;
    }

    public static boolean k(View view) {
        return !f(view) && (view instanceof TextView) && !(view instanceof Button) && !(view instanceof EditText) && !(view instanceof ActionMenuItemView);
    }

    public static boolean l(View view) {
        return !f(view) && (view instanceof Toolbar);
    }
}
