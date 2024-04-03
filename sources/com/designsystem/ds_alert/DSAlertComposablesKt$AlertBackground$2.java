package com.designsystem.ds_alert;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertBackground$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30492g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AlertTypeModel f30493h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Boolean f30494i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f30495j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30496k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30497l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertBackground$2(Modifier modifier, AlertTypeModel alertTypeModel, Boolean bool, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f30492g = modifier;
        this.f30493h = alertTypeModel;
        this.f30494i = bool;
        this.f30495j = function2;
        this.f30496k = i11;
        this.f30497l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAlertComposablesKt.AlertBackground(this.f30492g, this.f30493h, this.f30494i, this.f30495j, composer, this.f30496k | 1, this.f30497l);
    }
}
