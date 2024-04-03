package com.talabat.home;

import android.view.Window;
import com.talabat.R;
import com.talabat.homescreen.widget.HomeScreenHeaderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/Window;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$showHideToolBarViaFlutter$1 extends Lambda implements Function1<Window, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60899g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$showHideToolBarViaFlutter$1(HomeScreenActivity homeScreenActivity) {
        super(1);
        this.f60899g = homeScreenActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Window) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Window window) {
        int i11;
        Intrinsics.checkNotNullParameter(window, "$this$onWindow");
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) this.f60899g._$_findCachedViewById(R.id.header_view);
        if (homeScreenHeaderView != null) {
            i11 = homeScreenHeaderView.getHeaderBackgroundColor();
        } else {
            i11 = this.f60899g.getResources().getColor(R.color.ds_primary_10, this.f60899g.getTheme());
        }
        window.setStatusBarColor(i11);
    }
}
