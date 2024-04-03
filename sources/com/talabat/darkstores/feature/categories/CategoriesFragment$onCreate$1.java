package com.talabat.darkstores.feature.categories;

import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.model.Category;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lcom/talabat/darkstores/common/Result;", "", "Lcom/talabat/darkstores/model/Category;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CategoriesFragment$onCreate$1 extends Lambda implements Function1<Result<List<? extends Category>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CategoriesFragment f56305g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Bundle f56306h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoriesFragment$onCreate$1(CategoriesFragment categoriesFragment, Bundle bundle) {
        super(1);
        this.f56305g = categoriesFragment;
        this.f56306h = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<List<Category>>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Result<List<Category>> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ProgressBar progressBar = (ProgressBar) this.f56305g._$_findCachedViewById(R.id.progressBar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        int i11 = 0;
        progressBar.setVisibility(result instanceof Result.Loading ? 0 : 8);
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.f56305g._$_findCachedViewById(R.id.allCategories);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "allCategories");
        boolean z11 = result instanceof Result.Success;
        if (!z11) {
            i11 = 8;
        }
        appCompatImageView.setVisibility(i11);
        if (z11) {
            this.f56305g.onDataReceived((List) ((Result.Success) result).getData(), this.f56306h);
        }
    }
}
