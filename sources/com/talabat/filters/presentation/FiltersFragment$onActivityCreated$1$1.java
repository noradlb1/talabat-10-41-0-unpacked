package com.talabat.filters.presentation;

import android.widget.LinearLayout;
import com.talabat.filters.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment$onActivityCreated$1$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59617g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersFragment$onActivityCreated$1$1(FiltersFragment filtersFragment) {
        super(1);
        this.f59617g = filtersFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        ((LinearLayout) this.f59617g._$_findCachedViewById(R.id.buttonsContainer)).setVisibility(0);
    }
}
