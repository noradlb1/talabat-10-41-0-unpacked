package com.talabat.talabatlife.ui.vendorOffers.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006%"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "info", "", "getInfo", "()Ljava/lang/String;", "setInfo", "(Ljava/lang/String;)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "isSelected", "setSelected", "limits", "", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$OfferLimitModel;", "getLimits", "()Ljava/util/List;", "setLimits", "(Ljava/util/List;)V", "subtitle", "getSubtitle", "setSubtitle", "title", "getTitle", "setTitle", "LimitType", "OfferLimitModel", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOfferDisplayModel {

    /* renamed from: id  reason: collision with root package name */
    private int f12107id = IntKt.orZero(IntCompanionObject.INSTANCE);
    @NotNull
    private String info;
    private boolean isEnabled;
    private boolean isSelected;
    @NotNull
    private List<OfferLimitModel> limits;
    @NotNull
    private String subtitle;
    @NotNull
    private String title;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$LimitType;", "", "(Ljava/lang/String;I)V", "Daily", "Monthly", "None", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum LimitType {
        Daily,
        Monthly,
        None
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$OfferLimitModel;", "", "()V", "isReached", "", "()Z", "setReached", "(Z)V", "type", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$LimitType;", "getType", "()Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$LimitType;", "setType", "(Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$LimitType;)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OfferLimitModel {
        private boolean isReached = BooleanKt.orFalse(BooleanCompanionObject.INSTANCE);
        @NotNull
        private LimitType type = LimitType.None;

        @NotNull
        public final LimitType getType() {
            return this.type;
        }

        public final boolean isReached() {
            return this.isReached;
        }

        public final void setReached(boolean z11) {
            this.isReached = z11;
        }

        public final void setType(@NotNull LimitType limitType) {
            Intrinsics.checkNotNullParameter(limitType, "<set-?>");
            this.type = limitType;
        }
    }

    public VendorOfferDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.title = StringUtils.empty(stringCompanionObject);
        this.subtitle = StringUtils.empty(stringCompanionObject);
        this.info = StringUtils.empty(stringCompanionObject);
        BooleanCompanionObject booleanCompanionObject = BooleanCompanionObject.INSTANCE;
        this.isEnabled = BooleanKt.orFalse(booleanCompanionObject);
        this.isSelected = BooleanKt.orFalse(booleanCompanionObject);
        this.limits = new ArrayList();
    }

    public final int getId() {
        return this.f12107id;
    }

    @NotNull
    public final String getInfo() {
        return this.info;
    }

    @NotNull
    public final List<OfferLimitModel> getLimits() {
        return this.limits;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setEnabled(boolean z11) {
        this.isEnabled = z11;
    }

    public final void setId(int i11) {
        this.f12107id = i11;
    }

    public final void setInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.info = str;
    }

    public final void setLimits(@NotNull List<OfferLimitModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.limits = list;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public final void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
