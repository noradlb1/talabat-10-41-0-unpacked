package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestListener;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCapsuleCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardLotteModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardType;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCarouselCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingGridCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingTagsCardModel;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.CapsulesItemViewHolder;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.CarouselItemViewHolder;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.DefaultItemViewHolder;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.GridItemViewHolder;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.HeroHeaderItemViewHolder;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.LottieItemViewHolder;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.TagsItemViewHolder;
import com.talabat.feature.tpro.presentation.databinding.DefaultCardBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemCapsulesBenefitCardBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemCarouselBenefitCardBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemContentNewHeroHeaderSavingsBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemGridBenefitCardBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemLottieBenefitCardBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemTagBenefitCardBinding;
import com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012$\u0010\f\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u000f\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\"H\u0002J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\"H\u0016J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\"H\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R,\u0010\f\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u000f\u0012\u0004\u0012\u00020\u000b0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/TProOnBoardingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "tProOnBoardingPlanModel", "Lcom/talabat/feature/tpro/presentation/model/TProOnBoardingDisplayModel;", "preloaderCallback", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onBackClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "triggerGaEvent", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "(Lcom/talabat/feature/tpro/presentation/model/TProOnBoardingDisplayModel;Lcom/bumptech/glide/request/RequestListener;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "createCapsuleViewHolder", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/CapsulesItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "createCardLottieViewHolder", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/LottieItemViewHolder;", "createCardTagsViewHolder", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/TagsItemViewHolder;", "createCarouselViewHolder", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/CarouselItemViewHolder;", "createDefaultViewHolder", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/DefaultItemViewHolder;", "createGridViewHolder", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/GridItemViewHolder;", "createHeroHeaderViewHolder", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/HeroHeaderItemViewHolder;", "getItemCount", "", "getItemViewType", "position", "notifyForAnimation", "onBindViewHolder", "holder", "onCreateViewHolder", "viewType", "onViewAttachedToWindow", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CARD_CAPSULES = 3;
    private static final int CARD_CAROUSEL = 1;
    private static final int CARD_GRID = 2;
    private static final int CARD_LOTTE = 5;
    private static final int CARD_TAGS = 4;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int HERO_HEADER = 0;
    private static final int NONE = -1;
    @NotNull
    private final Function1<View, Unit> onBackClick;
    @NotNull
    private final RequestListener<Drawable> preloaderCallback;
    @NotNull
    private final TProOnBoardingDisplayModel tProOnBoardingPlanModel;
    @NotNull
    private final Function2<String, Pair<String, String>, Unit> triggerGaEvent;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/TProOnBoardingAdapter$Companion;", "", "()V", "CARD_CAPSULES", "", "CARD_CAROUSEL", "CARD_GRID", "CARD_LOTTE", "CARD_TAGS", "HERO_HEADER", "NONE", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TProOnBoardingCardType.values().length];
            iArr[TProOnBoardingCardType.CAROUSEL.ordinal()] = 1;
            iArr[TProOnBoardingCardType.GRID.ordinal()] = 2;
            iArr[TProOnBoardingCardType.CAPSULES.ordinal()] = 3;
            iArr[TProOnBoardingCardType.TAGS.ordinal()] = 4;
            iArr[TProOnBoardingCardType.LOTTIE.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TProOnBoardingAdapter(@NotNull TProOnBoardingDisplayModel tProOnBoardingDisplayModel, @NotNull RequestListener<Drawable> requestListener, @NotNull Function1<? super View, Unit> function1, @NotNull Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingDisplayModel, "tProOnBoardingPlanModel");
        Intrinsics.checkNotNullParameter(requestListener, "preloaderCallback");
        Intrinsics.checkNotNullParameter(function1, "onBackClick");
        Intrinsics.checkNotNullParameter(function2, "triggerGaEvent");
        this.tProOnBoardingPlanModel = tProOnBoardingDisplayModel;
        this.preloaderCallback = requestListener;
        this.onBackClick = function1;
        this.triggerGaEvent = function2;
    }

    private final CapsulesItemViewHolder createCapsuleViewHolder(ViewGroup viewGroup) {
        ItemCapsulesBenefitCardBinding inflate = ItemCapsulesBenefitCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new CapsulesItemViewHolder(inflate, this.triggerGaEvent);
    }

    private final LottieItemViewHolder createCardLottieViewHolder(ViewGroup viewGroup) {
        ItemLottieBenefitCardBinding inflate = ItemLottieBenefitCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new LottieItemViewHolder(inflate, this.triggerGaEvent);
    }

    private final TagsItemViewHolder createCardTagsViewHolder(ViewGroup viewGroup) {
        ItemTagBenefitCardBinding inflate = ItemTagBenefitCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new TagsItemViewHolder(inflate, this.triggerGaEvent);
    }

    private final CarouselItemViewHolder createCarouselViewHolder(ViewGroup viewGroup) {
        ItemCarouselBenefitCardBinding inflate = ItemCarouselBenefitCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new CarouselItemViewHolder(inflate, this.triggerGaEvent);
    }

    private final DefaultItemViewHolder createDefaultViewHolder(ViewGroup viewGroup) {
        DefaultCardBinding inflate = DefaultCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new DefaultItemViewHolder(inflate);
    }

    private final GridItemViewHolder createGridViewHolder(ViewGroup viewGroup) {
        ItemGridBenefitCardBinding inflate = ItemGridBenefitCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new GridItemViewHolder(inflate, this.triggerGaEvent);
    }

    private final HeroHeaderItemViewHolder createHeroHeaderViewHolder(ViewGroup viewGroup) {
        ItemContentNewHeroHeaderSavingsBinding inflate = ItemContentNewHeroHeaderSavingsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new HeroHeaderItemViewHolder(inflate, this.onBackClick, this.triggerGaEvent);
    }

    /* access modifiers changed from: private */
    public final void notifyForAnimation(int i11) {
        notifyItemChanged(i11);
    }

    public int getItemCount() {
        return this.tProOnBoardingPlanModel.getCards().size() + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r4 != 5) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getItemViewType(int r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0004
            r4 = 0
            goto L_0x0033
        L_0x0004:
            com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel r0 = r3.tProOnBoardingPlanModel
            java.util.List r0 = r0.getCards()
            r1 = 1
            int r4 = r4 - r1
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r0, r4)
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel r4 = (com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel) r4
            r0 = -1
            if (r4 == 0) goto L_0x0032
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardType r4 = r4.getCardType()
            int[] r2 = com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.TProOnBoardingAdapter.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r2[r4]
            if (r4 == r1) goto L_0x0030
            r1 = 2
            if (r4 == r1) goto L_0x0030
            r1 = 3
            if (r4 == r1) goto L_0x0030
            r1 = 4
            if (r4 == r1) goto L_0x0030
            r1 = 5
            if (r4 == r1) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r4 = r1
            goto L_0x0033
        L_0x0032:
            r4 = r0
        L_0x0033:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.TProOnBoardingAdapter.getItemViewType(int):int");
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof HeroHeaderItemViewHolder) {
            ((HeroHeaderItemViewHolder) viewHolder).bind(this.tProOnBoardingPlanModel.getHeroBanner(), new TProOnBoardingAdapter$onBindViewHolder$1(this), this.preloaderCallback);
        } else if (viewHolder instanceof CarouselItemViewHolder) {
            CarouselItemViewHolder carouselItemViewHolder = (CarouselItemViewHolder) viewHolder;
            Object orNull = CollectionsKt___CollectionsKt.getOrNull(this.tProOnBoardingPlanModel.getCards(), i11 - 1);
            if (orNull != null) {
                carouselItemViewHolder.bind((TProOnBoardingCarouselCardModel) orNull);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.subscriptions.domain.model.TProOnBoardingCarouselCardModel");
        } else if (viewHolder instanceof GridItemViewHolder) {
            GridItemViewHolder gridItemViewHolder = (GridItemViewHolder) viewHolder;
            Object orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.tProOnBoardingPlanModel.getCards(), i11 - 1);
            if (orNull2 != null) {
                gridItemViewHolder.bind((TProOnBoardingGridCardModel) orNull2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.subscriptions.domain.model.TProOnBoardingGridCardModel");
        } else if (viewHolder instanceof CapsulesItemViewHolder) {
            CapsulesItemViewHolder capsulesItemViewHolder = (CapsulesItemViewHolder) viewHolder;
            Object orNull3 = CollectionsKt___CollectionsKt.getOrNull(this.tProOnBoardingPlanModel.getCards(), i11 - 1);
            if (orNull3 != null) {
                capsulesItemViewHolder.bind((TProOnBoardingCapsuleCardModel) orNull3);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.subscriptions.domain.model.TProOnBoardingCapsuleCardModel");
        } else if (viewHolder instanceof TagsItemViewHolder) {
            TagsItemViewHolder tagsItemViewHolder = (TagsItemViewHolder) viewHolder;
            Object orNull4 = CollectionsKt___CollectionsKt.getOrNull(this.tProOnBoardingPlanModel.getCards(), i11 - 1);
            if (orNull4 != null) {
                tagsItemViewHolder.bind((TProOnBoardingTagsCardModel) orNull4);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.subscriptions.domain.model.TProOnBoardingTagsCardModel");
        } else if (viewHolder instanceof LottieItemViewHolder) {
            LottieItemViewHolder lottieItemViewHolder = (LottieItemViewHolder) viewHolder;
            Object orNull5 = CollectionsKt___CollectionsKt.getOrNull(this.tProOnBoardingPlanModel.getCards(), i11 - 1);
            if (orNull5 != null) {
                lottieItemViewHolder.bind((TProOnBoardingCardLotteModel) orNull5);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardLotteModel");
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 0) {
            return createHeroHeaderViewHolder(viewGroup);
        }
        if (i11 == 1) {
            return createCarouselViewHolder(viewGroup);
        }
        if (i11 == 2) {
            return createGridViewHolder(viewGroup);
        }
        if (i11 == 3) {
            return createCapsuleViewHolder(viewGroup);
        }
        if (i11 == 4) {
            return createCardTagsViewHolder(viewGroup);
        }
        if (i11 != 5) {
            return createDefaultViewHolder(viewGroup);
        }
        return createCardLottieViewHolder(viewGroup);
    }

    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        if (viewHolder instanceof CarouselItemViewHolder) {
            ((CarouselItemViewHolder) viewHolder).startCarouselIfRequired();
        }
    }
}
