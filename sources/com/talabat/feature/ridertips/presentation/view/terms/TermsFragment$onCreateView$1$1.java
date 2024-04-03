package com.talabat.feature.ridertips.presentation.view.terms;

import android.os.Bundle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import com.talabat.feature.ridertips.presentation.displaymodel.TermsDisplayModel;
import com.talabat.talabatlife.features.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TermsFragment$onCreateView$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TermsFragment f58882g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TermsFragment$onCreateView$1$1(TermsFragment termsFragment) {
        super(2);
        this.f58882g = termsFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            TermsFragment termsFragment = this.f58882g;
            Bundle arguments = termsFragment.getArguments();
            termsFragment.termsDisplayModel = (TermsDisplayModel) (arguments != null ? arguments.getSerializable(UrlConstantsKt.TLIFE_TERMS_AND_CONDITION_PATH) : null);
            TermsViewKt.TermsView(this.f58882g.termsDisplayModel, composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
