package com.talabat.offering.domain.usecases.business.impl;

import com.talabat.offering.data.SubscriptionVerificationEvent;
import com.talabat.offering.domain.OfferCollectionTracker;
import com.talabat.offering.domain.usecases.business.TrackSubscriptionVerificationUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JL\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J0\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J0\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J8\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J8\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J0\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J0\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/impl/TrackSubscriptionVerificationUseCaseImpl;", "Lcom/talabat/offering/domain/usecases/business/TrackSubscriptionVerificationUseCase;", "offerCollectionTracker", "Lcom/talabat/offering/domain/OfferCollectionTracker;", "(Lcom/talabat/offering/domain/OfferCollectionTracker;)V", "generateVerificationEvent", "Lcom/talabat/offering/data/SubscriptionVerificationEvent;", "channel", "", "eventOrigin", "screenName", "screenType", "subscriptionType", "failReason", "mobileVerificationStatus", "trackMobileVerificationCancelled", "", "trackMobileVerificationClicked", "trackMobileVerificationCodeExpired", "trackMobileVerificationCodeResend", "trackMobileVerificationContinued", "trackMobileVerificationErrorShown", "trackMobileVerificationStarted", "trackMobileVerificationValidated", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackSubscriptionVerificationUseCaseImpl implements TrackSubscriptionVerificationUseCase {
    @NotNull
    private final OfferCollectionTracker offerCollectionTracker;

    public TrackSubscriptionVerificationUseCaseImpl(@NotNull OfferCollectionTracker offerCollectionTracker2) {
        Intrinsics.checkNotNullParameter(offerCollectionTracker2, "offerCollectionTracker");
        this.offerCollectionTracker = offerCollectionTracker2;
    }

    public static /* synthetic */ SubscriptionVerificationEvent a(TrackSubscriptionVerificationUseCaseImpl trackSubscriptionVerificationUseCaseImpl, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        return trackSubscriptionVerificationUseCaseImpl.generateVerificationEvent(str, str2, str3, str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7);
    }

    private final SubscriptionVerificationEvent generateVerificationEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str5;
        String str9 = str6;
        String str10 = str7;
        SubscriptionVerificationEvent subscriptionVerificationEvent = new SubscriptionVerificationEvent(str, str2, str3, str4, (String) null, (String) null, (String) null, 112, (DefaultConstructorMarker) null);
        if (str8 != null) {
            subscriptionVerificationEvent.setSubscriptionType(str8);
        }
        if (str9 != null) {
            subscriptionVerificationEvent.setFailReason(str9);
        }
        if (str10 != null) {
            subscriptionVerificationEvent.setMobileVerificationStatus(str10);
        }
        return subscriptionVerificationEvent;
    }

    public void trackMobileVerificationCancelled(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        Intrinsics.checkNotNullParameter(str4, "screenType");
        this.offerCollectionTracker.trackMobileVerificationCancelled(a(this, str, str2, str3, str4, (String) null, (String) null, (String) null, 112, (Object) null));
    }

    public void trackMobileVerificationClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        Intrinsics.checkNotNullParameter(str4, "screenType");
        this.offerCollectionTracker.trackMobileVerificationClicked(a(this, str, str2, str3, str4, (String) null, (String) null, (String) null, 112, (Object) null));
    }

    public void trackMobileVerificationCodeExpired(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "screenType");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "subscriptionType");
        this.offerCollectionTracker.trackMobileVerificationCodeExpired(a(this, str, str2, str3, str6, str7, (String) null, (String) null, 96, (Object) null));
    }

    public void trackMobileVerificationCodeResend(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "screenType");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "subscriptionType");
        this.offerCollectionTracker.trackMobileVerificationCodeResend(a(this, str, str2, str3, str6, str7, (String) null, (String) null, 96, (Object) null));
    }

    public void trackMobileVerificationContinued(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "screenType");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "subscriptionType");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "mobileVerificationStatus");
        this.offerCollectionTracker.trackMobileVerificationContinued(a(this, str, str2, str3, str7, str8, (String) null, str9, 32, (Object) null));
    }

    public void trackMobileVerificationErrorShown(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "screenType");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "subscriptionType");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "failReason");
        this.offerCollectionTracker.trackMobileVerificationErrorShown(a(this, str, str2, str3, str7, str8, str9, (String) null, 64, (Object) null));
    }

    public void trackMobileVerificationStarted(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "screenType");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "subscriptionType");
        this.offerCollectionTracker.trackMobileVerificationStarted(a(this, str, str2, str3, str6, str7, (String) null, (String) null, 96, (Object) null));
    }

    public void trackMobileVerificationValidated(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "screenType");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "subscriptionType");
        this.offerCollectionTracker.trackMobileVerificationValidated(a(this, str, str2, str3, str6, str7, (String) null, (String) null, 96, (Object) null));
    }
}
