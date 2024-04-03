package h2;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavController f44330b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarConfiguration f44331c;

    public /* synthetic */ b(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.f44330b = navController;
        this.f44331c = appBarConfiguration;
    }

    public final void onClick(View view) {
        NavigationUI.m9117setupWithNavController$lambda2(this.f44330b, this.f44331c, view);
    }
}
