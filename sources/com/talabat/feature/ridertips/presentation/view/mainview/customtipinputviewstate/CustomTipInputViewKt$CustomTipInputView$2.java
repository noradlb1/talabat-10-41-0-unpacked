package com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomTipInputViewKt$CustomTipInputView$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f58856g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f58857h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f58858i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f58859j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f58860k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58861l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f58862m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTipInputViewKt$CustomTipInputView$2(String str, String str2, String str3, boolean z11, Function1<? super String, Unit> function1, Function0<Unit> function0, int i11) {
        super(2);
        this.f58856g = str;
        this.f58857h = str2;
        this.f58858i = str3;
        this.f58859j = z11;
        this.f58860k = function1;
        this.f58861l = function0;
        this.f58862m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CustomTipInputViewKt.CustomTipInputView(this.f58856g, this.f58857h, this.f58858i, this.f58859j, this.f58860k, this.f58861l, composer, this.f58862m | 1);
    }
}
