package com.designsystem.ds_dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DialogComposablesKt$DialogLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31104g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31105h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31106i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31107j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31108k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogComposablesKt$DialogLayout$2(Modifier modifier, String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f31104g = modifier;
        this.f31105h = str;
        this.f31106i = str2;
        this.f31107j = function2;
        this.f31108k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DialogComposablesKt.DialogLayout(this.f31104g, this.f31105h, this.f31106i, this.f31107j, composer, this.f31108k | 1);
    }
}
