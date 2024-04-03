package com.talabat.filters.presentation;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.talabat.filters.R;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "item", "Ldatamodels/filters/SelectableSortType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment$onActivityCreated$1$3 extends Lambda implements Function2<View, SelectableSortType, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59620g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59621h;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SortType.values().length];
            iArr[SortType.RECOMMENDATION.ordinal()] = 1;
            iArr[SortType.RATING.ordinal()] = 2;
            iArr[SortType.ALPHABETIC.ordinal()] = 3;
            iArr[SortType.MIN_ORDER.ordinal()] = 4;
            iArr[SortType.FASTEST_DELIVERY.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersFragment$onActivityCreated$1$3(FiltersFragment filtersFragment, FiltersViewModel filtersViewModel) {
        super(2);
        this.f59620g = filtersFragment;
        this.f59621h = filtersViewModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m10438invoke$lambda0(FiltersViewModel filtersViewModel, SelectableSortType selectableSortType, FiltersFragment filtersFragment, View view) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "$this_with");
        Intrinsics.checkNotNullParameter(selectableSortType, "$item");
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        FiltersViewModelKt.onSortClicked(filtersViewModel, selectableSortType);
        ((LinearLayout) filtersFragment._$_findCachedViewById(R.id.buttonsContainer)).setVisibility(0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, (SelectableSortType) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view, @NotNull SelectableSortType selectableSortType) {
        Intrinsics.checkNotNullParameter(view, "$this$invoke");
        Intrinsics.checkNotNullParameter(selectableSortType, "item");
        int i11 = WhenMappings.$EnumSwitchMapping$0[selectableSortType.getType().ordinal()];
        if (i11 == 1) {
            ((TextView) view.findViewById(R.id.sortName)).setText(this.f59620g.getString(com.talabat.localization.R.string.sort_recommendation));
        } else if (i11 == 2) {
            ((TextView) view.findViewById(R.id.sortName)).setText(this.f59620g.getString(com.talabat.localization.R.string.sort_rating));
        } else if (i11 == 3) {
            ((TextView) view.findViewById(R.id.sortName)).setText(this.f59620g.getString(com.talabat.localization.R.string.sort_alpha));
        } else if (i11 == 4) {
            ((TextView) view.findViewById(R.id.sortName)).setText(this.f59620g.getString(com.talabat.localization.R.string.sort_min_order));
        } else if (i11 == 5) {
            ((TextView) view.findViewById(R.id.sortName)).setText(this.f59620g.getString(com.talabat.localization.R.string.sort_fastes_delivery));
        }
        ((RadioButton) view.findViewById(R.id.vendorSortBtn)).setChecked(selectableSortType.isOn());
        view.setOnClickListener(new a(this.f59621h, selectableSortType, this.f59620g));
    }
}
