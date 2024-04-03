package js;

import android.view.View;
import com.talabat.homescreen.widget.HomeScreenHeaderView;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f62203b;

    public /* synthetic */ c(Function0 function0) {
        this.f62203b = function0;
    }

    public final void onClick(View view) {
        HomeScreenHeaderView.m10658setOnAddressClicked$lambda0(this.f62203b, view);
    }
}
