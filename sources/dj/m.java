package dj;

import android.view.View;
import com.talabat.darkstores.feature.home.HomeFragment;
import com.talabat.darkstores.model.Swimlane;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56748b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Swimlane f56749c;

    public /* synthetic */ m(HomeFragment homeFragment, Swimlane swimlane) {
        this.f56748b = homeFragment;
        this.f56749c = swimlane;
    }

    public final void onClick(View view) {
        HomeFragment.m9947addSwimlaneView$lambda47$lambda46(this.f56748b, this.f56749c, view);
    }
}
