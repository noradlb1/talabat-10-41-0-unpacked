package com.talabat.filters.presentation;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment$onActivityCreated$1$2 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59618g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59619h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersFragment$onActivityCreated$1$2(FiltersFragment filtersFragment, FiltersViewModel filtersViewModel) {
        super(1);
        this.f59618g = filtersFragment;
        this.f59619h = filtersViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<String, String>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Pair<String, String> pair) {
        AppTracker.onFilterOptionsClicked(this.f59618g.getContext(), FiltersViewModelKt.getSortingSlug(this.f59619h), FiltersViewModelKt.getFiltersSlug(this.f59619h));
    }
}
