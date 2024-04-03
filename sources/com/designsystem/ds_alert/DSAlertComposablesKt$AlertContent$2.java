package com.designsystem.ds_alert;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30499g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30500h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30501i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSAlertActionButtonModel f30502j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30503k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30504l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertContent$2(Modifier modifier, String str, String str2, DSAlertActionButtonModel dSAlertActionButtonModel, int i11, int i12) {
        super(2);
        this.f30499g = modifier;
        this.f30500h = str;
        this.f30501i = str2;
        this.f30502j = dSAlertActionButtonModel;
        this.f30503k = i11;
        this.f30504l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAlertComposablesKt.AlertContent(this.f30499g, this.f30500h, this.f30501i, this.f30502j, composer, this.f30503k | 1, this.f30504l);
    }
}
