package com.talabat.cuisines.di.factory;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.cuisines.presentation.CuisinesViewModel;
import com.talabat.cuisines.presentation.MultipleSelectionCollectionsCuisinesViewModel;
import com.talabat.cuisines.presentation.MultipleSelectionCuisinesViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/cuisines/di/factory/CuisinesViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "isCollection", "", "isPickup", "(ZZ)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static CuisinesViewModel mockedViewModel;
    private final boolean isCollection;
    private final boolean isPickup;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/talabat/cuisines/di/factory/CuisinesViewModelFactory$Companion;", "", "()V", "mockedViewModel", "Lcom/talabat/cuisines/presentation/CuisinesViewModel;", "getMockedViewModel$annotations", "getMockedViewModel", "()Lcom/talabat/cuisines/presentation/CuisinesViewModel;", "setMockedViewModel", "(Lcom/talabat/cuisines/presentation/CuisinesViewModel;)V", "newInstance", "Lcom/talabat/cuisines/di/factory/CuisinesViewModelFactory;", "isCollection", "", "isPickup", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMockedViewModel$annotations() {
        }

        @Nullable
        public final CuisinesViewModel getMockedViewModel() {
            return CuisinesViewModelFactory.mockedViewModel;
        }

        @NotNull
        public final CuisinesViewModelFactory newInstance(boolean z11, boolean z12) {
            return new CuisinesViewModelFactory(z11, z12);
        }

        public final void setMockedViewModel(@Nullable CuisinesViewModel cuisinesViewModel) {
            CuisinesViewModelFactory.mockedViewModel = cuisinesViewModel;
        }
    }

    public CuisinesViewModelFactory(boolean z11, boolean z12) {
        this.isCollection = z11;
        this.isPickup = z12;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        T t11 = mockedViewModel;
        if (t11 != null) {
            return t11;
        }
        if (this.isCollection) {
            return new MultipleSelectionCollectionsCuisinesViewModel();
        }
        return new MultipleSelectionCuisinesViewModel();
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
