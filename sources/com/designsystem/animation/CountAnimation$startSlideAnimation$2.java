package com.designsystem.animation;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CountAnimation$startSlideAnimation$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextView f30486g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountAnimation$startSlideAnimation$2(TextView textView) {
        super(0);
        this.f30486g = textView;
    }

    public final void invoke() {
        this.f30486g.setVisibility(8);
    }
}
