package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 15})
public final class DialogActionButton$update$1 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f40398g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogActionButton$update$1(Context context) {
        super(0);
        this.f40398g = context;
    }

    public final int invoke() {
        return MDUtil.resolveColor$default(MDUtil.INSTANCE, this.f40398g, (Integer) null, Integer.valueOf(R.attr.colorPrimary), (Function0) null, 10, (Object) null);
    }
}
