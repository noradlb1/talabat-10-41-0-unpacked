package com.talabat.darkstores.feature.product;

import androidx.appcompat.widget.AppCompatTextView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.ExpandCollapseTextView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0006*\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "shouldExpandAndText", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observeMoreData$5 extends Lambda implements Function1<Pair<? extends Boolean, ? extends String>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56484g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observeMoreData$5(ProductFragment productFragment) {
        super(1);
        this.f56484g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Boolean, String>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<Boolean, String> pair) {
        if (pair.getSecond() != null) {
            ProductFragment productFragment = this.f56484g;
            int i11 = 0;
            if (pair.getFirst().booleanValue()) {
                int i12 = R.id.tvProductDescription;
                ((ExpandCollapseTextView) productFragment._$_findCachedViewById(i12)).setText(pair.getSecond());
                ExpandCollapseTextView expandCollapseTextView = (ExpandCollapseTextView) productFragment._$_findCachedViewById(i12);
                Intrinsics.checkNotNullExpressionValue(expandCollapseTextView, "tvProductDescription");
                CharSequence text = ((ExpandCollapseTextView) productFragment._$_findCachedViewById(i12)).getText();
                Intrinsics.checkNotNullExpressionValue(text, "tvProductDescription.text");
                if (!(!StringsKt__StringsJVMKt.isBlank(text))) {
                    i11 = 8;
                }
                expandCollapseTextView.setVisibility(i11);
                return;
            }
            int i13 = R.id.tvProductDescriptionStatic;
            ((AppCompatTextView) productFragment._$_findCachedViewById(i13)).setText(pair.getSecond());
            AppCompatTextView appCompatTextView = (AppCompatTextView) productFragment._$_findCachedViewById(i13);
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvProductDescriptionStatic");
            CharSequence text2 = ((AppCompatTextView) productFragment._$_findCachedViewById(i13)).getText();
            Intrinsics.checkNotNullExpressionValue(text2, "tvProductDescriptionStatic.text");
            if (!(!StringsKt__StringsJVMKt.isBlank(text2))) {
                i11 = 8;
            }
            appCompatTextView.setVisibility(i11);
        }
    }
}
