package com.talabat.talabatcore.viewmodel;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CreateCustomViewViewModel$activity$2 extends Lambda implements Function0<FragmentActivity> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CreateCustomViewViewModel f12031g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateCustomViewViewModel$activity$2(CreateCustomViewViewModel createCustomViewViewModel) {
        super(0);
        this.f12031g = createCustomViewViewModel;
    }

    @NotNull
    public final FragmentActivity invoke() {
        CreateCustomViewViewModel createCustomViewViewModel = this.f12031g;
        return createCustomViewViewModel.scanForActivity(createCustomViewViewModel.getContext());
    }
}
