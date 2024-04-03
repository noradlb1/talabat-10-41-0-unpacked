package com.designsystem.ds_dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSDialogKt$DSDialog$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31084g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSDialogPrimaryAction f31085h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f31086i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31087j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31088k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSDialogSecondaryAction f31089l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DialogProperties f31090m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31091n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31092o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDialogKt$DSDialog$2(Function0<Unit> function0, DSDialogPrimaryAction dSDialogPrimaryAction, Modifier modifier, String str, String str2, DSDialogSecondaryAction dSDialogSecondaryAction, DialogProperties dialogProperties, int i11, int i12) {
        super(2);
        this.f31084g = function0;
        this.f31085h = dSDialogPrimaryAction;
        this.f31086i = modifier;
        this.f31087j = str;
        this.f31088k = str2;
        this.f31089l = dSDialogSecondaryAction;
        this.f31090m = dialogProperties;
        this.f31091n = i11;
        this.f31092o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSDialogKt.DSDialog(this.f31084g, this.f31085h, this.f31086i, this.f31087j, this.f31088k, this.f31089l, this.f31090m, composer, this.f31091n | 1, this.f31092o);
    }
}
