package com.designsystem.ds_tabs;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TabBarMenuFragment$Menu$1 extends Lambda implements Function1<LazyListScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabBarMenuFragment f33054g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<DSTabItemModel> f33055h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarMenuFragment$Menu$1(TabBarMenuFragment tabBarMenuFragment, MutableState<DSTabItemModel> mutableState) {
        super(1);
        this.f33054g = tabBarMenuFragment;
        this.f33055h = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        List<DSTabItemModel> tabs$marshmallow_release = this.f33054g.getTabs$marshmallow_release();
        lazyListScope.items(tabs$marshmallow_release.size(), (Function1) null, ComposableLambdaKt.composableLambdaInstance(-985537599, true, new TabBarMenuFragment$Menu$1$invoke$$inlined$items$default$2(tabs$marshmallow_release, this.f33055h, this.f33054g)));
    }
}
