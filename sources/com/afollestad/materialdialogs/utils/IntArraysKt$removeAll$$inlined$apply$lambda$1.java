package com.afollestad.materialdialogs.utils;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "com/afollestad/materialdialogs/utils/IntArraysKt$removeAll$1$1"}, k = 3, mv = {1, 1, 15})
public final class IntArraysKt$removeAll$$inlined$apply$lambda$1 extends Lambda implements Function1<Integer, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Collection f40405g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntArraysKt$removeAll$$inlined$apply$lambda$1(Collection collection) {
        super(1);
        this.f40405g = collection;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke(((Number) obj).intValue()));
    }

    public final boolean invoke(int i11) {
        return this.f40405g.contains(Integer.valueOf(i11));
    }
}
