package com.talabat.feature.tmart.growth.presentation.sheet;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction;", "", "()V", "Dismiss", "OpenTMart", "Save", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction$Save;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction$Dismiss;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction$OpenTMart;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BottomSheetAction {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction$Dismiss;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction;", "()V", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Dismiss extends BottomSheetAction {
        @NotNull
        public static final Dismiss INSTANCE = new Dismiss();

        private Dismiss() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction$OpenTMart;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction;", "()V", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OpenTMart extends BottomSheetAction {
        @NotNull
        public static final OpenTMart INSTANCE = new OpenTMart();

        private OpenTMart() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction$Save;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetAction;", "()V", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Save extends BottomSheetAction {
        @NotNull
        public static final Save INSTANCE = new Save();

        private Save() {
            super((DefaultConstructorMarker) null);
        }
    }

    private BottomSheetAction() {
    }

    public /* synthetic */ BottomSheetAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
