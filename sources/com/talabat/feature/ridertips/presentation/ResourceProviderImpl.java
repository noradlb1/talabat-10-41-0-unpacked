package com.talabat.feature.ridertips.presentation;

import android.content.res.Resources;
import androidx.compose.runtime.internal.StabilityInferred;
import com.talabat.localization.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/ResourceProviderImpl;", "Lcom/talabat/feature/ridertips/presentation/IResourceProvider;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "getStringForEmptyCustomTip", "", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResourceProviderImpl implements IResourceProvider {
    public static final int $stable = 8;
    @NotNull
    private final Resources resources;

    @Inject
    public ResourceProviderImpl(@NotNull Resources resources2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
    }

    @NotNull
    public String getStringForEmptyCustomTip() {
        String string = this.resources.getString(R.string.rider_tip_other);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…R.string.rider_tip_other)");
        return string;
    }
}
