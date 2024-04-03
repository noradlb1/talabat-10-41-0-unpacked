package com.talabat.feature.ridertips.presentation.view.terms;

import androidx.compose.runtime.Composer;
import com.talabat.feature.ridertips.presentation.displaymodel.TermsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TermsViewKt$TermsView$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TermsDisplayModel f58884g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f58885h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TermsViewKt$TermsView$2(TermsDisplayModel termsDisplayModel, int i11) {
        super(2);
        this.f58884g = termsDisplayModel;
        this.f58885h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TermsViewKt.TermsView(this.f58884g, composer, this.f58885h | 1);
    }
}
