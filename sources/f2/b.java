package f2;

import android.view.View;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavDirections f44289b;

    public /* synthetic */ b(NavDirections navDirections) {
        this.f44289b = navDirections;
    }

    public final void onClick(View view) {
        Navigation.m9103createNavigateOnClickListener$lambda1(this.f44289b, view);
    }
}
