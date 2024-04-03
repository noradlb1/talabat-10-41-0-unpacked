package com.designsystem.animation;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CountAnimation$startSlideAnimation$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextView f30482g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30483h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextView f30484i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30485j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountAnimation$startSlideAnimation$1(TextView textView, String str, TextView textView2, String str2) {
        super(0);
        this.f30482g = textView;
        this.f30483h = str;
        this.f30484i = textView2;
        this.f30485j = str2;
    }

    public final void invoke() {
        this.f30482g.setText(this.f30483h);
        this.f30484i.setText(this.f30485j);
        this.f30482g.setVisibility(0);
    }
}
