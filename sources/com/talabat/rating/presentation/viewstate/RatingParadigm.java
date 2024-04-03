package com.talabat.rating.presentation.viewstate;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/rating/presentation/viewstate/RatingParadigm;", "", "()V", "Smiley", "Star", "Lcom/talabat/rating/presentation/viewstate/RatingParadigm$Star;", "Lcom/talabat/rating/presentation/viewstate/RatingParadigm$Smiley;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RatingParadigm {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/rating/presentation/viewstate/RatingParadigm$Smiley;", "Lcom/talabat/rating/presentation/viewstate/RatingParadigm;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Smiley extends RatingParadigm {
        @NotNull
        public static final Smiley INSTANCE = new Smiley();

        private Smiley() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/rating/presentation/viewstate/RatingParadigm$Star;", "Lcom/talabat/rating/presentation/viewstate/RatingParadigm;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Star extends RatingParadigm {
        @NotNull
        public static final Star INSTANCE = new Star();

        private Star() {
            super((DefaultConstructorMarker) null);
        }
    }

    private RatingParadigm() {
    }

    public /* synthetic */ RatingParadigm(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
