package com.talabat.talabatlife.ui.vendorList.viewModel;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatlife.ui.vendorList.model.VendorAreasDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorAreasDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorsListViewModelImpl$getVendorsAreasList$1 extends Lambda implements Function1<Either<? extends Failure, ? extends VendorAreasDisplayModel>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModelImpl f12097g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListViewModelImpl$getVendorsAreasList$1(VendorsListViewModelImpl vendorsListViewModelImpl) {
        super(1);
        this.f12097g = vendorsListViewModelImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, VendorAreasDisplayModel>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, VendorAreasDisplayModel> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        either.either(new Function1<Failure, Unit>(this.f12097g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((VendorsListViewModelImpl) this.receiver).handleFailure(failure);
            }
        }, new Function1<VendorAreasDisplayModel, Unit>(this.f12097g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((VendorAreasDisplayModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull VendorAreasDisplayModel vendorAreasDisplayModel) {
                Intrinsics.checkNotNullParameter(vendorAreasDisplayModel, "p0");
                ((VendorsListViewModelImpl) this.receiver).handleVendorsAreasDisplayModel(vendorAreasDisplayModel);
            }
        });
    }
}
