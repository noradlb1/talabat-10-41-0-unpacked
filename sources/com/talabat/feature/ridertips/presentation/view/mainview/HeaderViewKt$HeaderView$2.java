package com.talabat.feature.ridertips.presentation.view.mainview;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class HeaderViewKt$HeaderView$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f58823g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f58824h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58825i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f58826j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderViewKt$HeaderView$2(String str, String str2, Function0<Unit> function0, int i11) {
        super(2);
        this.f58823g = str;
        this.f58824h = str2;
        this.f58825i = function0;
        this.f58826j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        HeaderViewKt.HeaderView(this.f58823g, this.f58824h, this.f58825i, composer, this.f58826j | 1);
    }
}
