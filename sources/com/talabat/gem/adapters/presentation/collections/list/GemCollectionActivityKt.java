package com.talabat.gem.adapters.presentation.collections.list;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"GEM_VISIBILITY_THRESHOLD", "", "close", "", "Lcom/talabat/gem/adapters/presentation/collections/list/GemCollectionActivity;", "navigateHome", "", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionActivityKt {
    public static final float GEM_VISIBILITY_THRESHOLD = 0.7f;

    public static final void close(@NotNull GemCollectionActivity gemCollectionActivity, boolean z11) {
        Intrinsics.checkNotNullParameter(gemCollectionActivity, "<this>");
        if (!gemCollectionActivity.isFinishing()) {
            gemCollectionActivity.onBackPressed();
            if (z11) {
                gemCollectionActivity.checkIfNavigateToHome$com_talabat_Components_gem_gem();
            }
        }
    }

    public static /* synthetic */ void close$default(GemCollectionActivity gemCollectionActivity, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        close(gemCollectionActivity, z11);
    }
}
