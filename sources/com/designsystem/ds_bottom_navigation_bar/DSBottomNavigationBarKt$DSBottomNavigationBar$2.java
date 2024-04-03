package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBottomNavigationBarKt$DSBottomNavigationBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30583g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<DSBottomNavigationBarItem> f30584h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSBottomNavigationBarItem f30585i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<DSBottomNavigationBarItem, Unit> f30586j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30587k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30588l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBottomNavigationBarKt$DSBottomNavigationBar$2(Modifier modifier, List<DSBottomNavigationBarItem> list, DSBottomNavigationBarItem dSBottomNavigationBarItem, Function1<? super DSBottomNavigationBarItem, Unit> function1, int i11, int i12) {
        super(2);
        this.f30583g = modifier;
        this.f30584h = list;
        this.f30585i = dSBottomNavigationBarItem;
        this.f30586j = function1;
        this.f30587k = i11;
        this.f30588l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSBottomNavigationBarKt.DSBottomNavigationBar(this.f30583g, this.f30584h, this.f30585i, this.f30586j, composer, this.f30587k | 1, this.f30588l);
    }
}
