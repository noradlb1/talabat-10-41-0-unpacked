package com.talabat.darkstores.feature.mission.control;

import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class MainViewModel$navigateToCampaign$2 extends FunctionReferenceImpl implements Function1<String, NavDirections> {
    public MainViewModel$navigateToCampaign$2(Object obj) {
        super(1, obj, MainViewModel.class, "getBannerNativeNavAction", "getBannerNativeNavAction(Ljava/lang/String;)Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((MainViewModel) this.receiver).getBannerNativeNavAction(str);
    }
}
