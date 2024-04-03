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
public final class DSAlertKt$DSAlert$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30535g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30536h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSAlertType f30537i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30538j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSAlertActionButtonModel f30539k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f30540l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Boolean f30541m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30542n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30543o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertKt$DSAlert$1(Modifier modifier, String str, DSAlertType dSAlertType, String str2, DSAlertActionButtonModel dSAlertActionButtonModel, DSIconButtonModel dSIconButtonModel, Boolean bool, int i11, int i12) {
        super(2);
        this.f30535g = modifier;
        this.f30536h = str;
        this.f30537i = dSAlertType;
        this.f30538j = str2;
        this.f30539k = dSAlertActionButtonModel;
        this.f30540l = dSIconButtonModel;
        this.f30541m = bool;
        this.f30542n = i11;
        this.f30543o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAlertKt.DSAlert(this.f30535g, this.f30536h, this.f30537i, this.f30538j, this.f30539k, this.f30540l, this.f30541m, composer, this.f30542n | 1, this.f30543o);
    }
}
