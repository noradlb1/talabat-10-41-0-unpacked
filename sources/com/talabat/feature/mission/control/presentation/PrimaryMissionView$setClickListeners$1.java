package com.talabat.feature.mission.control.presentation;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "name", "position", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PrimaryMissionView$setClickListeners$1 extends Lambda implements Function3<String, String, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<String, String, Unit> f58598g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PrimaryMissionView f58599h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrimaryMissionView$setClickListeners$1(Function2<? super String, ? super String, Unit> function2, PrimaryMissionView primaryMissionView) {
        super(3);
        this.f58598g = function2;
        this.f58599h = primaryMissionView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (String) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "name");
        Function2<String, String, Unit> function2 = this.f58598g;
        if (function2 != null) {
            this.f58599h.getViewModel().onMissionClicked(str2, i11);
            function2.invoke(str, str2);
        }
    }
}
