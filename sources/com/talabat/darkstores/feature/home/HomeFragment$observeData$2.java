package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.common.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/feature/home/HomeFragmentData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$observeData$2 extends Lambda implements Function1<Result<HomeFragmentData>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56395g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$observeData$2(HomeFragment homeFragment) {
        super(1);
        this.f56395g = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<HomeFragmentData>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Result<HomeFragmentData> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        this.f56395g.onSwimlanesResultsReceived(result);
        if (result.isSuccess()) {
            this.f56395g.getViewModel().onInteractionReady();
        }
    }
}
