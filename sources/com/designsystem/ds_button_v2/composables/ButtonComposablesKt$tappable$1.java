package com.designsystem.ds_button_v2.composables;

import android.view.View;
import com.designsystem.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ButtonComposablesKt$tappable$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f30825g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f30826h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30827i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonComposablesKt$tappable$1(boolean z11, View view, Function0<Unit> function0) {
        super(0);
        this.f30825g = z11;
        this.f30826h = view;
        this.f30827i = function0;
    }

    public final void invoke() {
        if (this.f30825g) {
            ViewExtensionsKt.performSelectionFeedback(this.f30826h);
        }
        this.f30827i.invoke();
    }
}
