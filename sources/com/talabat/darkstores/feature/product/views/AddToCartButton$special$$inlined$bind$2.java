package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.marshmallow.R;
import com.talabat.talabatcommon.extentions.ThrowablesKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "invoke", "com/talabat/talabatcommon/lifecycle/AutoDisposableKt$bind$4"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddToCartButton$special$$inlined$bind$2 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f56519g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AddToCartButton f56520h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddToCartButton$special$$inlined$bind$2(AutoDisposable autoDisposable, AddToCartButton addToCartButton) {
        super(1);
        this.f56519g = autoDisposable;
        this.f56520h = addToCartButton;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        final AutoDisposable autoDisposable = this.f56519g;
        if (autoDisposable instanceof View) {
            final AddToCartButton addToCartButton = this.f56520h;
            AutoDisposableKt.autoDisposeView(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    AddToCartButton addToCartButton;
                    AddToCartButton$1$6 addToCartButton$1$6;
                    Context context = ((View) autoDisposable).getContext();
                    Class cls = AddToCartButtonViewModel.class;
                    if (context instanceof AppCompatActivity) {
                        AddToCartButtonViewModel addToCartButtonViewModel = (AddToCartButtonViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        AddToCartButton addToCartButton2 = addToCartButton;
                        addToCartButton2.setRadius(addToCartButton2.getResources().getDimension(R.dimen.card_view_radius_base));
                        AddToCartButton addToCartButton3 = addToCartButton;
                        addToCartButton3.setOnClickListener(new AddToCartButton$1$1(addToCartButton3));
                        addToCartButton.getRemove().setOnClickListener(new AddToCartButton$1$2(addToCartButton));
                        addToCartButton.getAdd().setOnClickListener(new AddToCartButton$1$3(addToCartButton));
                        AddToCartButton addToCartButton4 = addToCartButton;
                        addToCartButton4.autoDispose(new AddToCartButton$1$4(addToCartButtonViewModel, addToCartButton4));
                        AddToCartButton addToCartButton5 = addToCartButton;
                        addToCartButton5.autoDispose(new AddToCartButton$1$5(addToCartButtonViewModel, addToCartButton5));
                        addToCartButton = addToCartButton;
                        addToCartButton$1$6 = new AddToCartButton$1$6(addToCartButton, addToCartButtonViewModel);
                    } else if (context instanceof FragmentActivity) {
                        AddToCartButtonViewModel addToCartButtonViewModel2 = (AddToCartButtonViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        AddToCartButton addToCartButton6 = addToCartButton;
                        addToCartButton6.setRadius(addToCartButton6.getResources().getDimension(R.dimen.card_view_radius_base));
                        AddToCartButton addToCartButton7 = addToCartButton;
                        addToCartButton7.setOnClickListener(new AddToCartButton$1$1(addToCartButton7));
                        addToCartButton.getRemove().setOnClickListener(new AddToCartButton$1$2(addToCartButton));
                        addToCartButton.getAdd().setOnClickListener(new AddToCartButton$1$3(addToCartButton));
                        AddToCartButton addToCartButton8 = addToCartButton;
                        addToCartButton8.autoDispose(new AddToCartButton$1$4(addToCartButtonViewModel2, addToCartButton8));
                        AddToCartButton addToCartButton9 = addToCartButton;
                        addToCartButton9.autoDispose(new AddToCartButton$1$5(addToCartButtonViewModel2, addToCartButton9));
                        addToCartButton = addToCartButton;
                        addToCartButton$1$6 = new AddToCartButton$1$6(addToCartButton, addToCartButtonViewModel2);
                    } else if (context instanceof Fragment) {
                        AddToCartButtonViewModel addToCartButtonViewModel3 = (AddToCartButtonViewModel) ViewModelProviders.of((Fragment) context).get(cls);
                        AddToCartButton addToCartButton10 = addToCartButton;
                        addToCartButton10.setRadius(addToCartButton10.getResources().getDimension(R.dimen.card_view_radius_base));
                        AddToCartButton addToCartButton11 = addToCartButton;
                        addToCartButton11.setOnClickListener(new AddToCartButton$1$1(addToCartButton11));
                        addToCartButton.getRemove().setOnClickListener(new AddToCartButton$1$2(addToCartButton));
                        addToCartButton.getAdd().setOnClickListener(new AddToCartButton$1$3(addToCartButton));
                        AddToCartButton addToCartButton12 = addToCartButton;
                        addToCartButton12.autoDispose(new AddToCartButton$1$4(addToCartButtonViewModel3, addToCartButton12));
                        AddToCartButton addToCartButton13 = addToCartButton;
                        addToCartButton13.autoDispose(new AddToCartButton$1$5(addToCartButtonViewModel3, addToCartButton13));
                        addToCartButton = addToCartButton;
                        addToCartButton$1$6 = new AddToCartButton$1$6(addToCartButton, addToCartButtonViewModel3);
                    } else {
                        throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                    }
                    addToCartButton.autoDispose(addToCartButton$1$6);
                }
            });
        } else if (autoDisposable instanceof AppCompatActivity) {
            final AddToCartButton addToCartButton2 = this.f56520h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    AddToCartButtonViewModel addToCartButtonViewModel = (AddToCartButtonViewModel) ViewModelProviders.of((FragmentActivity) autoDisposable).get(AddToCartButtonViewModel.class);
                    AddToCartButton addToCartButton = addToCartButton2;
                    addToCartButton.setRadius(addToCartButton.getResources().getDimension(R.dimen.card_view_radius_base));
                    AddToCartButton addToCartButton2 = addToCartButton2;
                    addToCartButton2.setOnClickListener(new AddToCartButton$1$1(addToCartButton2));
                    addToCartButton2.getRemove().setOnClickListener(new AddToCartButton$1$2(addToCartButton2));
                    addToCartButton2.getAdd().setOnClickListener(new AddToCartButton$1$3(addToCartButton2));
                    AddToCartButton addToCartButton3 = addToCartButton2;
                    addToCartButton3.autoDispose(new AddToCartButton$1$4(addToCartButtonViewModel, addToCartButton3));
                    AddToCartButton addToCartButton4 = addToCartButton2;
                    addToCartButton4.autoDispose(new AddToCartButton$1$5(addToCartButtonViewModel, addToCartButton4));
                    AddToCartButton addToCartButton5 = addToCartButton2;
                    addToCartButton5.autoDispose(new AddToCartButton$1$6(addToCartButton5, addToCartButtonViewModel));
                }
            });
        } else if (autoDisposable instanceof Fragment) {
            final AddToCartButton addToCartButton3 = this.f56520h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    AddToCartButtonViewModel addToCartButtonViewModel = (AddToCartButtonViewModel) ViewModelProviders.of((Fragment) autoDisposable).get(AddToCartButtonViewModel.class);
                    AddToCartButton addToCartButton = addToCartButton3;
                    addToCartButton.setRadius(addToCartButton.getResources().getDimension(R.dimen.card_view_radius_base));
                    AddToCartButton addToCartButton2 = addToCartButton3;
                    addToCartButton2.setOnClickListener(new AddToCartButton$1$1(addToCartButton2));
                    addToCartButton3.getRemove().setOnClickListener(new AddToCartButton$1$2(addToCartButton3));
                    addToCartButton3.getAdd().setOnClickListener(new AddToCartButton$1$3(addToCartButton3));
                    AddToCartButton addToCartButton3 = addToCartButton3;
                    addToCartButton3.autoDispose(new AddToCartButton$1$4(addToCartButtonViewModel, addToCartButton3));
                    AddToCartButton addToCartButton4 = addToCartButton3;
                    addToCartButton4.autoDispose(new AddToCartButton$1$5(addToCartButtonViewModel, addToCartButton4));
                    AddToCartButton addToCartButton5 = addToCartButton3;
                    addToCartButton5.autoDispose(new AddToCartButton$1$6(addToCartButton5, addToCartButtonViewModel));
                }
            });
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
