package com.talabat.home;

import android.view.Window;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/Window;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$onNavDestinationChanged$2 extends Lambda implements Function1<Window, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60888g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$onNavDestinationChanged$2(HomeScreenActivity homeScreenActivity) {
        super(1);
        this.f60888g = homeScreenActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Window) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "$this$onWindow");
        window.setStatusBarColor(this.f60888g.getResources().getColor(R.color.ds_neutral_white, this.f60888g.getTheme()));
    }
}
