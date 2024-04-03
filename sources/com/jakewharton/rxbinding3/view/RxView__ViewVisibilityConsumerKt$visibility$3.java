package com.jakewharton.rxbinding3.view;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 15})
public final class RxView__ViewVisibilityConsumerKt$visibility$3<T> implements Consumer<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f52678b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f52679c;

    public RxView__ViewVisibilityConsumerKt$visibility$3(View view, int i11) {
        this.f52678b = view;
        this.f52679c = i11;
    }

    public final void accept(Boolean bool) {
        View view = this.f52678b;
        Intrinsics.checkExpressionValueIsNotNull(bool, "value");
        view.setVisibility(bool.booleanValue() ? 0 : this.f52679c);
    }
}
