package com.talabat.darkstores.feature.mission.control;

import androidx.navigation.NavDirections;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "action", "Landroidx/navigation/NavDirections;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MainViewModel$navigateToPrimaryMissionSwimlane$3 extends Lambda implements Function1<NavDirections, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MainViewModel f56465g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainViewModel$navigateToPrimaryMissionSwimlane$3(MainViewModel mainViewModel) {
        super(1);
        this.f56465g = mainViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavDirections) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavDirections navDirections) {
        Intrinsics.checkNotNullParameter(navDirections, NativeProtocol.WEB_DIALOG_ACTION);
        this.f56465g.navigate(navDirections);
    }
}
