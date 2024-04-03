package com.designsystem.ds_tabs;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TabBarMenuFragment$Menu$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabBarMenuFragment f33059g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33060h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarMenuFragment$Menu$2(TabBarMenuFragment tabBarMenuFragment, int i11) {
        super(2);
        this.f33059g = tabBarMenuFragment;
        this.f33060h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f33059g.Menu$marshmallow_release(composer, this.f33060h | 1);
    }
}
