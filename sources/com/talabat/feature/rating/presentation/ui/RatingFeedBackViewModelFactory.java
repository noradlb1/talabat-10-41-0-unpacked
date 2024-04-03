package com.talabat.feature.rating.presentation.ui;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provider", "Ljavax/inject/Provider;", "Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingFeedBackViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    private final Provider<RatingFeedBackViewModel> provider;

    @Inject
    public RatingFeedBackViewModelFactory(@NotNull Provider<RatingFeedBackViewModel> provider2) {
        Intrinsics.checkNotNullParameter(provider2, "provider");
        this.provider = provider2;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        T t11 = this.provider.get();
        if (t11 != null) {
            return (ViewModel) t11;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModelFactory.create");
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
