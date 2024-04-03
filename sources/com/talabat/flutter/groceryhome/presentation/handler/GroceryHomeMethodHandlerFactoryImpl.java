package com.talabat.flutter.groceryhome.presentation.handler;

import android.os.Bundle;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.flutter.groceryhome.domain.usecase.GetClosestDarkstoreInfoUseCase;
import com.talabat.flutter.groceryhome.domain.usecase.GetMigratedVendorInfoUseCase;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandler;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerFactoryImpl;", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerFactory;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getClosestDarkstoreInfoUseCase", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCase;", "getMigratedVendorInfoUseCase", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetMigratedVendorInfoUseCase;", "(Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCase;Lcom/talabat/flutter/groceryhome/domain/usecase/GetMigratedVendorInfoUseCase;)V", "create", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler;", "deeplinkBundle", "Landroid/os/Bundle;", "verticalIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tileId", "callback", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler$Callback;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryHomeMethodHandlerFactoryImpl implements GroceryHomeMethodHandlerFactory {
    @NotNull
    private final GetClosestDarkstoreInfoUseCase getClosestDarkstoreInfoUseCase;
    @NotNull
    private final GetMigratedVendorInfoUseCase getMigratedVendorInfoUseCase;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public GroceryHomeMethodHandlerFactoryImpl(@NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull GetClosestDarkstoreInfoUseCase getClosestDarkstoreInfoUseCase2, @NotNull GetMigratedVendorInfoUseCase getMigratedVendorInfoUseCase2) {
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(getClosestDarkstoreInfoUseCase2, "getClosestDarkstoreInfoUseCase");
        Intrinsics.checkNotNullParameter(getMigratedVendorInfoUseCase2, "getMigratedVendorInfoUseCase");
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.talabatExperiment = iTalabatExperiment;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getClosestDarkstoreInfoUseCase = getClosestDarkstoreInfoUseCase2;
        this.getMigratedVendorInfoUseCase = getMigratedVendorInfoUseCase2;
    }

    @NotNull
    public GroceryHomeMethodHandler create(@Nullable Bundle bundle, @NotNull ArrayList<Integer> arrayList, int i11, @NotNull GroceryHomeMethodHandler.Callback callback) {
        Intrinsics.checkNotNullParameter(arrayList, "verticalIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new GroceryHomeMethodHandlerImpl(new FWFParams(this.talabatExperiment, this.talabatFeatureFlag), callback, this.rxSchedulersFactory, bundle, arrayList, i11, this.getClosestDarkstoreInfoUseCase, this.getMigratedVendorInfoUseCase);
    }
}
