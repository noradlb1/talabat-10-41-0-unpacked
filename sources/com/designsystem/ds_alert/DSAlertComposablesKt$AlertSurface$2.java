package com.designsystem.ds_alert;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30526g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30527h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSAlertType f30528i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30529j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSAlertActionButtonModel f30530k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f30531l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Boolean f30532m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30533n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30534o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertSurface$2(Modifier modifier, String str, DSAlertType dSAlertType, String str2, DSAlertActionButtonModel dSAlertActionButtonModel, DSIconButtonModel dSIconButtonModel, Boolean bool, int i11, int i12) {
        super(2);
        this.f30526g = modifier;
        this.f30527h = str;
        this.f30528i = dSAlertType;
        this.f30529j = str2;
        this.f30530k = dSAlertActionButtonModel;
        this.f30531l = dSIconButtonModel;
        this.f30532m = bool;
        this.f30533n = i11;
        this.f30534o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAlertComposablesKt.AlertSurface(this.f30526g, this.f30527h, this.f30528i, this.f30529j, this.f30530k, this.f30531l, this.f30532m, composer, this.f30533n | 1, this.f30534o);
    }
}
