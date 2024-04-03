package com.talabat.feature.rating.presentation.ui;

import android.content.Context;
import com.talabat.feature.rating.presentation.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingResourceProviderImpl;", "Lcom/talabat/feature/rating/presentation/ui/RatingResourceProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getRatingReasonMessage", "", "rating", "", "getRatingReasonTitle", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingResourceProviderImpl implements RatingResourceProvider {
    @NotNull
    private final Context context;

    @Inject
    public RatingResourceProviderImpl(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public String getRatingReasonMessage(int i11) {
        if (i11 == 1 || i11 == 2) {
            String string = this.context.getString(R.string.what_could_have_been_better);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…t_could_have_been_better)");
            return string;
        } else if (i11 == 3) {
            String string2 = this.context.getString(R.string.what_could_be_improved);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.what_could_be_improved)");
            return string2;
        } else if (i11 != 4 && i11 != 5) {
            return "";
        } else {
            String string3 = this.context.getString(R.string.what_did_you_like);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.what_did_you_like)");
            return string3;
        }
    }

    @NotNull
    public String getRatingReasonTitle(int i11) {
        if (i11 == 1) {
            String string = this.context.getString(R.string.poor);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.poor)");
            return string;
        } else if (i11 == 2) {
            String string2 = this.context.getString(R.string.not_good);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.not_good)");
            return string2;
        } else if (i11 == 3) {
            String string3 = this.context.getString(R.string.average);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.average)");
            return string3;
        } else if (i11 == 4) {
            String string4 = this.context.getString(R.string.very_good);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.very_good)");
            return string4;
        } else if (i11 != 5) {
            return "";
        } else {
            String string5 = this.context.getString(R.string.excellent);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.excellent)");
            return string5;
        }
    }
}
