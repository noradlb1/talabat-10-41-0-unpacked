package h2;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavController f44335b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarConfiguration f44336c;

    public /* synthetic */ e(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.f44335b = navController;
        this.f44336c = appBarConfiguration;
    }

    public final void onClick(View view) {
        NavigationUI.m9116setupWithNavController$lambda1(this.f44335b, this.f44336c, view);
    }
}
