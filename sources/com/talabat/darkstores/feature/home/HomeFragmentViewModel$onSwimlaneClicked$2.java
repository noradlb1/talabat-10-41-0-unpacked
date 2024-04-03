package com.talabat.darkstores.feature.home;

import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HomeFragmentViewModel$onSwimlaneClicked$2 extends FunctionReferenceImpl implements Function4<String, String, String, String, NavDirections> {
    public HomeFragmentViewModel$onSwimlaneClicked$2(Object obj) {
        super(4, obj, HomeFragmentViewModel.class, "getSwimlanesNativeNavDirection", "getSwimlanesNativeNavDirection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(str2, "p1");
        return ((HomeFragmentViewModel) this.receiver).getSwimlanesNativeNavDirection(str, str2, str3, str4);
    }
}
