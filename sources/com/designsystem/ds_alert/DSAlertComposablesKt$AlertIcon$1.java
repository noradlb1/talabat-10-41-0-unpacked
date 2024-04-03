package com.designsystem.ds_alert;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertIcon$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AlertTypeModel f30505g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30506h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertIcon$1(AlertTypeModel alertTypeModel, int i11) {
        super(2);
        this.f30505g = alertTypeModel;
        this.f30506h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAlertComposablesKt.AlertIcon(this.f30505g, composer, this.f30506h | 1);
    }
}
