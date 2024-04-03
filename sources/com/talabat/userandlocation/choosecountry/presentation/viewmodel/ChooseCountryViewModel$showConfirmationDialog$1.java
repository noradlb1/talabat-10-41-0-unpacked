package com.talabat.userandlocation.choosecountry.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.userandlocation.choosecountry.presentation.StringProvider;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.ClearCartConfirmationDialogDisplayModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.presentation.viewmodel.ChooseCountryViewModel$showConfirmationDialog$1", f = "ChooseCountryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChooseCountryViewModel$showConfirmationDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12259h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryViewModel f12260i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12261j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCountryViewModel$showConfirmationDialog$1(ChooseCountryViewModel chooseCountryViewModel, int i11, Continuation<? super ChooseCountryViewModel$showConfirmationDialog$1> continuation) {
        super(2, continuation);
        this.f12260i = chooseCountryViewModel;
        this.f12261j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChooseCountryViewModel$showConfirmationDialog$1(this.f12260i, this.f12261j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChooseCountryViewModel$showConfirmationDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f12259h == 0) {
            ResultKt.throwOnFailure(obj);
            StringProvider.ClearCartConfirmationStrings clearCartConfirmationStrings = this.f12260i.stringProvider.getClearCartConfirmationStrings();
            MutableLiveData<ClearCartConfirmationDialogDisplayModel> clearCartConfirmationDialogDisplayModel = this.f12260i.getClearCartConfirmationDialogDisplayModel();
            String title = clearCartConfirmationStrings.getTitle();
            String message = clearCartConfirmationStrings.getMessage();
            String positiveButton = clearCartConfirmationStrings.getPositiveButton();
            String negativeButton = clearCartConfirmationStrings.getNegativeButton();
            final ChooseCountryViewModel chooseCountryViewModel = this.f12260i;
            final int i11 = this.f12261j;
            clearCartConfirmationDialogDisplayModel.postValue(new ClearCartConfirmationDialogDisplayModel.Show(title, message, positiveButton, new Function0<Unit>() {
                public final void invoke() {
                    Job unused = chooseCountryViewModel.onClearCartWarningAcknowledged(i11);
                }
            }, negativeButton, AnonymousClass2.INSTANCE));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
