package com.talabat.talabatcore.adapters;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "I", "Lcom/talabat/talabatcore/adapters/UpdatableAdapter;", "Lcom/talabat/talabatcore/adapters/UpdatableViewHolder;", "Lcom/talabat/talabatcore/adapters/ItemsAdapter;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunctionalAdaptersKt$withAdapter$3 extends Lambda implements Function2 {
    public static final FunctionalAdaptersKt$withAdapter$3 INSTANCE = new FunctionalAdaptersKt$withAdapter$3();

    public FunctionalAdaptersKt$withAdapter$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((UpdatableAdapter) obj, (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull UpdatableAdapter updatableAdapter, @NotNull List list) {
        Intrinsics.checkNotNullParameter(updatableAdapter, "$this$null");
        Intrinsics.checkNotNullParameter(list, "it");
        updatableAdapter.update(list);
    }
}
