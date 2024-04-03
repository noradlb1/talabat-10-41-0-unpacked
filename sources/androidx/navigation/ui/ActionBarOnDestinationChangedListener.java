package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0014R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/navigation/ui/ActionBarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "", "title", "", "b", "Landroid/graphics/drawable/Drawable;", "icon", "", "contentDescription", "a", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/navigation/ui/AppBarConfiguration;", "configuration", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/ui/AppBarConfiguration;)V", "navigation-ui_release"}, k = 1, mv = {1, 6, 0})
public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    @NotNull
    private final AppCompatActivity activity;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ActionBarOnDestinationChangedListener(@org.jetbrains.annotations.NotNull androidx.appcompat.app.AppCompatActivity r3, @org.jetbrains.annotations.NotNull androidx.navigation.ui.AppBarConfiguration r4) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.appcompat.app.ActionBarDrawerToggle$Delegate r0 = r3.getDrawerToggleDelegate()
            if (r0 == 0) goto L_0x001f
            android.content.Context r0 = r0.getActionBarThemedContext()
            java.lang.String r1 = "checkNotNull(activity.dr… }.actionBarThemedContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0, r4)
            r2.activity = r3
            return
        L_0x001f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Activity "
            r4.append(r0)
            r4.append(r3)
            java.lang.String r3 = " does not have an DrawerToggleDelegate set"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.ActionBarOnDestinationChangedListener.<init>(androidx.appcompat.app.AppCompatActivity, androidx.navigation.ui.AppBarConfiguration):void");
    }

    public void a(@Nullable Drawable drawable, @StringRes int i11) {
        boolean z11;
        ActionBar supportActionBar = this.activity.getSupportActionBar();
        if (supportActionBar != null) {
            Intrinsics.checkNotNullExpressionValue(supportActionBar, "checkNotNull(activity.su…ortActionBar()\"\n        }");
            if (drawable != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            supportActionBar.setDisplayHomeAsUpEnabled(z11);
            ActionBarDrawerToggle.Delegate drawerToggleDelegate = this.activity.getDrawerToggleDelegate();
            if (drawerToggleDelegate != null) {
                Intrinsics.checkNotNullExpressionValue(drawerToggleDelegate, "checkNotNull(activity.dr…leDelegate set\"\n        }");
                drawerToggleDelegate.setActionBarUpIndicator(drawable, i11);
                return;
            }
            throw new IllegalStateException(("Activity " + this.activity + " does not have an DrawerToggleDelegate set").toString());
        }
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }

    public void b(@Nullable CharSequence charSequence) {
        ActionBar supportActionBar = this.activity.getSupportActionBar();
        if (supportActionBar != null) {
            Intrinsics.checkNotNullExpressionValue(supportActionBar, "checkNotNull(activity.su…ortActionBar()\"\n        }");
            supportActionBar.setTitle(charSequence);
            return;
        }
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }
}
