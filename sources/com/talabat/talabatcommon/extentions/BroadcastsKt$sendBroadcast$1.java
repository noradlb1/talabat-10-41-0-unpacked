package com.talabat.talabatcommon.extentions;

import android.content.Intent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BroadcastsKt$sendBroadcast$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f46918g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Pair<String, Serializable>[] f46919h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastsKt$sendBroadcast$1(String str, Pair<String, ? extends Serializable>[] pairArr) {
        super(0);
        this.f46918g = str;
        this.f46919h = pairArr;
    }

    public final void invoke() {
        Intent intent = new Intent(this.f46918g);
        Pair<String, Serializable>[] pairArr = this.f46919h;
        boolean z11 = true;
        if (pairArr != null) {
            if (!(pairArr.length == 0)) {
                z11 = false;
            }
        }
        if (!z11) {
            for (Pair<String, Serializable> pair : pairArr) {
                intent.putExtra(pair.getFirst(), pair.getSecond());
            }
        }
        BroadcastsKt.sendBroadcast(intent);
    }
}
