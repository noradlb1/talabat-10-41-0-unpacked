package com.talabat.filters.presentation;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.talabat.filters.R;
import datamodels.filters.SelectablePopularFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "item", "Ldatamodels/filters/SelectablePopularFilter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment$onActivityCreated$1$5 extends Lambda implements Function2<View, SelectablePopularFilter, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59624g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59625h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersFragment$onActivityCreated$1$5(FiltersViewModel filtersViewModel, FiltersFragment filtersFragment) {
        super(2);
        this.f59624g = filtersViewModel;
        this.f59625h = filtersFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m10440invoke$lambda0(FiltersViewModel filtersViewModel, SelectablePopularFilter selectablePopularFilter, FiltersFragment filtersFragment, View view) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "$this_with");
        Intrinsics.checkNotNullParameter(selectablePopularFilter, "$item");
        Intrinsics.checkNotNullParameter(filtersFragment, "this$0");
        FiltersViewModelKt.onPopularFilterClicked(filtersViewModel, selectablePopularFilter);
        ((LinearLayout) filtersFragment._$_findCachedViewById(R.id.buttonsContainer)).setVisibility(0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, (SelectablePopularFilter) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view, @NotNull SelectablePopularFilter selectablePopularFilter) {
        Intrinsics.checkNotNullParameter(view, "$this$invoke");
        Intrinsics.checkNotNullParameter(selectablePopularFilter, "item");
        ((TextView) view.findViewById(R.id.textView_filterName)).setText(selectablePopularFilter.getFilter().getName());
        ((CheckBox) view.findViewById(R.id.switch_filter)).setChecked(selectablePopularFilter.isOn());
        view.setOnClickListener(new c(this.f59624g, selectablePopularFilter, this.f59625h));
    }
}
