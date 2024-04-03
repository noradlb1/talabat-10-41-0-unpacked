package com.talabat;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSubtitleBinder$accept$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextView f54082g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSubtitleBinder$accept$1(TextView textView) {
        super(1);
        this.f54082g = textView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r3 = (r1 = r0.getContext()).getString(com.talabat.R.string.up_to_discount_saving);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.widget.TextView r0 = r9.f54082g
            if (r0 != 0) goto L_0x000a
            goto L_0x002a
        L_0x000a:
            if (r0 == 0) goto L_0x0026
            android.content.Context r1 = r0.getContext()
            if (r1 == 0) goto L_0x0026
            r2 = 2132020347(0x7f140c7b, float:1.9679055E38)
            java.lang.String r3 = r1.getString(r2)
            if (r3 == 0) goto L_0x0026
            java.lang.String r4 = "##"
            r6 = 0
            r7 = 4
            r8 = 0
            r5 = r10
            java.lang.String r10 = kotlin.text.StringsKt__StringsJVMKt.replace$default((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (boolean) r6, (int) r7, (java.lang.Object) r8)
            goto L_0x0027
        L_0x0026:
            r10 = 0
        L_0x0027:
            r0.setText(r10)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.GemSubtitleBinder$accept$1.invoke(java.lang.String):void");
    }
}
