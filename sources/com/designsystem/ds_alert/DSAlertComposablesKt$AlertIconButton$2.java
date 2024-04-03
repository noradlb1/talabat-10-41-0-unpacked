package com.designsystem.ds_alert;

import androidx.compose.runtime.Composer;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertIconButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f30508g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30509h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30510i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertIconButton$2(DSIconButtonModel dSIconButtonModel, int i11, int i12) {
        super(2);
        this.f30508g = dSIconButtonModel;
        this.f30509h = i11;
        this.f30510i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAlertComposablesKt.AlertIconButton(this.f30508g, composer, this.f30509h | 1, this.f30510i);
    }
}
