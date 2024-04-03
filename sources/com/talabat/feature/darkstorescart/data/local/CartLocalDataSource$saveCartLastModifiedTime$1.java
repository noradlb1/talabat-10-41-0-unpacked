package com.talabat.feature.darkstorescart.data.local;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/SharedPreferences$Editor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartLocalDataSource$saveCartLastModifiedTime$1 extends Lambda implements Function1<SharedPreferences.Editor, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f58485g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartLocalDataSource$saveCartLastModifiedTime$1(long j11) {
        super(1);
        this.f58485g = j11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SharedPreferences.Editor) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "$this$save");
        editor.putLong("cart_last_modified_millis", this.f58485g);
    }
}
