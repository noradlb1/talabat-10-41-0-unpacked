package com.talabat.darkstores.feature.home;

import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HomeFragmentViewModel$onLifestyleMissionControlV2Clicked$2 extends FunctionReferenceImpl implements Function2<String, String, NavDirections> {
    public HomeFragmentViewModel$onLifestyleMissionControlV2Clicked$2(Object obj) {
        super(2, obj, HomeFragmentViewModel.class, "getLifestyleMissionControlV2NativeNavAction", "getLifestyleMissionControlV2NativeNavAction(Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(str2, "p1");
        return ((HomeFragmentViewModel) this.receiver).getLifestyleMissionControlV2NativeNavAction(str, str2);
    }
}
