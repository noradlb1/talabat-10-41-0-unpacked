package com.talabat.darkstores.common.lists.adapters.compact;

import android.content.Context;
import com.designsystem.marshmallow.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CompactSwimlaneItemButton$orangeBackground$2 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f56165g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompactSwimlaneItemButton$orangeBackground$2(Context context) {
        super(0);
        this.f56165g = context;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(ContextExtensionsKt.getColorCompat(this.f56165g, R.color.ds_primary_100));
    }
}
