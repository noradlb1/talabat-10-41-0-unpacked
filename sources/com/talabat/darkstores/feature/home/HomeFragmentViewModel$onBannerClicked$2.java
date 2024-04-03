package com.talabat.darkstores.feature.home;

import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HomeFragmentViewModel$onBannerClicked$2 extends FunctionReferenceImpl implements Function1<String, NavDirections> {
    public HomeFragmentViewModel$onBannerClicked$2(Object obj) {
        super(1, obj, HomeFragmentViewModel.class, "getBannerNativeNavAction", "getBannerNativeNavAction(Ljava/lang/String;)Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((HomeFragmentViewModel) this.receiver).getBannerNativeNavAction(str);
    }
}
