package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.growth.features.loyalty.sharedpreferences.IsUserRewards;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.GetSupportedCountriesForUserToChooseUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00121\u0010\u0011\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001c\u0010!\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f\u0012\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001b\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010(J!\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010.J!\u0010/\u001a\u0002002\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010.J)\u00101\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u00103R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R>\u0010\u0011\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0012X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R)\u0010!\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\fX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/impl/SetUserSelectedCountryUseCaseImpl;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase;", "resetAppStateDelegate", "Lkotlin/Function0;", "", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getSupportedCountriesForUserToChooseUseCase", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/GetSupportedCountriesForUserToChooseUseCase;", "isUserRewardsSharedPreferences", "Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewards;", "saveSelectedCountryDelegate", "Lkotlin/Function1;", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "cartHasItemsProvider", "", "clearCartItemDelegate", "handleAppInfoDelegate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "countryId", "Lkotlin/coroutines/Continuation;", "", "requestAreasToCacheUseCase", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/RequestAreasToCacheUseCase;", "currencyFormatDelegate", "resetSmsVerificationInstanceDelegate", "resetBrandLocationAddressDelegate", "markFirstInstallAsFalseDelegate", "clearCachedLocationDelegate", "emptyDarkStoresCartDelegate", "refreshFunWithFlagsDelegate", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lkotlin/jvm/functions/Function0;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/GetSupportedCountriesForUserToChooseUseCase;Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewards;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/RequestAreasToCacheUseCase;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "callAppInfoApi", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCountry", "selectedCountryId", "resetApplicationState", "fromLocationWelcome", "selectedCountry", "(ZLcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSelectedCountry", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "setUserSelectedCountry", "warningAcknowledged", "(IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetUserSelectedCountryUseCaseImpl implements SetUserSelectedCountryUseCase {
    @NotNull
    private final Function0<Boolean> cartHasItemsProvider;
    @NotNull
    private final Function0<Unit> clearCachedLocationDelegate;
    @NotNull
    private final Function0<Unit> clearCartItemDelegate;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Function1<CountryVO, Unit> currencyFormatDelegate;
    @NotNull
    private final Function0<Unit> emptyDarkStoresCartDelegate;
    @NotNull
    private final GetSupportedCountriesForUserToChooseUseCase getSupportedCountriesForUserToChooseUseCase;
    @NotNull
    private final Function2<Integer, Continuation<? super Unit>, Object> handleAppInfoDelegate;
    @NotNull
    private final IsUserRewards isUserRewardsSharedPreferences;
    @NotNull
    private final Function0<Unit> markFirstInstallAsFalseDelegate;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final Function1<Continuation<? super Unit>, Object> refreshFunWithFlagsDelegate;
    @NotNull
    private final RequestAreasToCacheUseCase requestAreasToCacheUseCase;
    @NotNull
    private final Function0<Unit> resetAppStateDelegate;
    @NotNull
    private final Function0<Unit> resetBrandLocationAddressDelegate;
    @NotNull
    private final Function0<Unit> resetSmsVerificationInstanceDelegate;
    @NotNull
    private final Function1<CountryVO, Unit> saveSelectedCountryDelegate;

    public SetUserSelectedCountryUseCaseImpl(@NotNull Function0<Unit> function0, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull GetSupportedCountriesForUserToChooseUseCase getSupportedCountriesForUserToChooseUseCase2, @NotNull IsUserRewards isUserRewards, @NotNull Function1<? super CountryVO, Unit> function1, @NotNull Function0<Boolean> function02, @NotNull Function0<Unit> function03, @NotNull Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull RequestAreasToCacheUseCase requestAreasToCacheUseCase2, @NotNull Function1<? super CountryVO, Unit> function12, @NotNull Function0<Unit> function04, @NotNull Function0<Unit> function05, @NotNull Function0<Unit> function06, @NotNull Function0<Unit> function07, @NotNull Function0<Unit> function08, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function13, @NotNull IObservabilityManager iObservabilityManager) {
        Function0<Unit> function09 = function0;
        ConfigurationLocalRepository configurationLocalRepository3 = configurationLocalRepository2;
        GetSupportedCountriesForUserToChooseUseCase getSupportedCountriesForUserToChooseUseCase3 = getSupportedCountriesForUserToChooseUseCase2;
        IsUserRewards isUserRewards2 = isUserRewards;
        Function1<? super CountryVO, Unit> function14 = function1;
        Function0<Boolean> function010 = function02;
        Function0<Unit> function011 = function03;
        Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function22 = function2;
        RequestAreasToCacheUseCase requestAreasToCacheUseCase3 = requestAreasToCacheUseCase2;
        Function1<? super CountryVO, Unit> function15 = function12;
        Function0<Unit> function012 = function04;
        Function0<Unit> function013 = function05;
        Function0<Unit> function014 = function06;
        Function0<Unit> function015 = function07;
        Function1<? super Continuation<? super Unit>, ? extends Object> function16 = function13;
        Intrinsics.checkNotNullParameter(function09, "resetAppStateDelegate");
        Intrinsics.checkNotNullParameter(configurationLocalRepository3, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(getSupportedCountriesForUserToChooseUseCase3, "getSupportedCountriesForUserToChooseUseCase");
        Intrinsics.checkNotNullParameter(isUserRewards2, "isUserRewardsSharedPreferences");
        Intrinsics.checkNotNullParameter(function14, "saveSelectedCountryDelegate");
        Intrinsics.checkNotNullParameter(function010, "cartHasItemsProvider");
        Intrinsics.checkNotNullParameter(function011, "clearCartItemDelegate");
        Intrinsics.checkNotNullParameter(function22, "handleAppInfoDelegate");
        Intrinsics.checkNotNullParameter(requestAreasToCacheUseCase3, "requestAreasToCacheUseCase");
        Intrinsics.checkNotNullParameter(function15, "currencyFormatDelegate");
        Intrinsics.checkNotNullParameter(function012, "resetSmsVerificationInstanceDelegate");
        Intrinsics.checkNotNullParameter(function013, "resetBrandLocationAddressDelegate");
        Intrinsics.checkNotNullParameter(function014, "markFirstInstallAsFalseDelegate");
        Intrinsics.checkNotNullParameter(function015, "clearCachedLocationDelegate");
        Intrinsics.checkNotNullParameter(function08, "emptyDarkStoresCartDelegate");
        Intrinsics.checkNotNullParameter(function13, "refreshFunWithFlagsDelegate");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.resetAppStateDelegate = function09;
        this.configurationLocalRepository = configurationLocalRepository3;
        this.getSupportedCountriesForUserToChooseUseCase = getSupportedCountriesForUserToChooseUseCase3;
        this.isUserRewardsSharedPreferences = isUserRewards2;
        this.saveSelectedCountryDelegate = function14;
        this.cartHasItemsProvider = function010;
        this.clearCartItemDelegate = function011;
        this.handleAppInfoDelegate = function22;
        this.requestAreasToCacheUseCase = requestAreasToCacheUseCase3;
        this.currencyFormatDelegate = function15;
        this.resetSmsVerificationInstanceDelegate = function012;
        this.resetBrandLocationAddressDelegate = function013;
        this.markFirstInstallAsFalseDelegate = function014;
        this.clearCachedLocationDelegate = function015;
        this.emptyDarkStoresCartDelegate = function08;
        this.refreshFunWithFlagsDelegate = function13;
        this.observabilityManager = iObservabilityManager;
    }

    /* access modifiers changed from: private */
    public final Object callAppInfoApi(int i11, Continuation<? super Unit> continuation) {
        Object invoke = this.handleAppInfoDelegate.invoke(Boxing.boxInt(i11), continuation);
        return invoke == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCountry(int r5, kotlin.coroutines.Continuation<? super com.talabat.userandlocation.choosecountry.domain.entity.CountryVO> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$getCountry$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$getCountry$1 r0 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$getCountry$1) r0
            int r1 = r0.f12225k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12225k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$getCountry$1 r0 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$getCountry$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12223i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12225k
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            int r5 = r0.f12222h
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0043
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.userandlocation.choosecountry.domain.usecase.business.GetSupportedCountriesForUserToChooseUseCase r6 = r4.getSupportedCountriesForUserToChooseUseCase
            r0.f12222h = r5
            r0.f12225k = r3
            java.lang.Object r6 = r6.getSupportedCountriesForUserToChoose(r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x0049:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r6.next()
            r1 = r0
            com.talabat.userandlocation.choosecountry.domain.entity.CountryVO r1 = (com.talabat.userandlocation.choosecountry.domain.entity.CountryVO) r1
            int r1 = r1.getId()
            if (r1 != r5) goto L_0x005e
            r1 = r3
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x0049
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl.getCountry(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object resetApplicationState(boolean r5, com.talabat.userandlocation.choosecountry.domain.entity.CountryVO r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$resetApplicationState$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$resetApplicationState$1 r0 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$resetApplicationState$1) r0
            int r1 = r0.f12230l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12230l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$resetApplicationState$1 r0 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$resetApplicationState$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12228j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12230l
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            boolean r5 = r0.f12227i
            java.lang.Object r6 = r0.f12226h
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl r6 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0072
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r4.resetSmsVerificationInstanceDelegate
            r7.invoke()
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r4.resetAppStateDelegate
            r7.invoke()
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r4.clearCartItemDelegate
            r7.invoke()
            kotlin.jvm.functions.Function1<com.talabat.userandlocation.choosecountry.domain.entity.CountryVO, kotlin.Unit> r7 = r4.saveSelectedCountryDelegate
            r7.invoke(r6)
            kotlin.jvm.functions.Function1<com.talabat.userandlocation.choosecountry.domain.entity.CountryVO, kotlin.Unit> r7 = r4.currencyFormatDelegate
            r7.invoke(r6)
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r4.resetBrandLocationAddressDelegate
            r6.invoke()
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r4.clearCachedLocationDelegate
            r6.invoke()
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r4.emptyDarkStoresCartDelegate
            r6.invoke()
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r4.refreshFunWithFlagsDelegate
            r0.f12226h = r4
            r0.f12227i = r5
            r0.f12230l = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r6 = r4
        L_0x0072:
            if (r5 == 0) goto L_0x0079
            kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r6.markFirstInstallAsFalseDelegate
            r5.invoke()
        L_0x0079:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl.resetApplicationState(boolean, com.talabat.userandlocation.choosecountry.domain.entity.CountryVO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setSelectedCountry(boolean r9, com.talabat.userandlocation.choosecountry.domain.entity.CountryVO r10, kotlin.coroutines.Continuation<? super com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase.Result> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1 r0 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1) r0
            int r1 = r0.f12237n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12237n = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1 r0 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f12235l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12237n
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005b
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ed
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            boolean r9 = r0.f12234k
            java.lang.Object r10 = r0.f12233j
            java.lang.Object r2 = r0.f12232i
            com.talabat.userandlocation.choosecountry.domain.entity.CountryVO r2 = (com.talabat.userandlocation.choosecountry.domain.entity.CountryVO) r2
            java.lang.Object r4 = r0.f12231h
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl r4 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl) r4
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0048 }
            goto L_0x00a3
        L_0x0048:
            r11 = move-exception
            goto L_0x00ae
        L_0x004b:
            boolean r9 = r0.f12234k
            java.lang.Object r10 = r0.f12232i
            com.talabat.userandlocation.choosecountry.domain.entity.CountryVO r10 = (com.talabat.userandlocation.choosecountry.domain.entity.CountryVO) r10
            java.lang.Object r2 = r0.f12231h
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl r2 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0059 }
            goto L_0x0074
        L_0x0059:
            r11 = move-exception
            goto L_0x007d
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x007b }
            int r11 = r10.getId()     // Catch:{ all -> 0x007b }
            r0.f12231h = r8     // Catch:{ all -> 0x007b }
            r0.f12232i = r10     // Catch:{ all -> 0x007b }
            r0.f12234k = r9     // Catch:{ all -> 0x007b }
            r0.f12237n = r5     // Catch:{ all -> 0x007b }
            java.lang.Object r11 = r8.callAppInfoApi(r11, r0)     // Catch:{ all -> 0x007b }
            if (r11 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r2 = r8
        L_0x0074:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0059 }
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)     // Catch:{ all -> 0x0059 }
            goto L_0x0087
        L_0x007b:
            r11 = move-exception
            r2 = r8
        L_0x007d:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x0087:
            r7 = r2
            r2 = r10
            r10 = r11
            r11 = r7
            com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase r5 = r11.requestAreasToCacheUseCase     // Catch:{ all -> 0x00aa }
            int r6 = r2.getId()     // Catch:{ all -> 0x00aa }
            r0.f12231h = r11     // Catch:{ all -> 0x00aa }
            r0.f12232i = r2     // Catch:{ all -> 0x00aa }
            r0.f12233j = r10     // Catch:{ all -> 0x00aa }
            r0.f12234k = r9     // Catch:{ all -> 0x00aa }
            r0.f12237n = r4     // Catch:{ all -> 0x00aa }
            java.lang.Object r4 = r5.requestAreasToCache(r6, r0)     // Catch:{ all -> 0x00aa }
            if (r4 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            r4 = r11
        L_0x00a3:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0048 }
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)     // Catch:{ all -> 0x0048 }
            goto L_0x00b8
        L_0x00aa:
            r4 = move-exception
            r7 = r4
            r4 = r11
            r11 = r7
        L_0x00ae:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x00b8:
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r11)
            if (r11 == 0) goto L_0x00d7
            com.talabat.core.observabilityNew.domain.IObservabilityManager r5 = r4.observabilityManager
            java.lang.String r11 = r11.getMessage()
            if (r11 != 0) goto L_0x00c8
            java.lang.String r11 = ""
        L_0x00c8:
            java.lang.String r6 = "errorMessage"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r6, r11)
            java.util.Map r11 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r11)
            java.lang.String r6 = "ULAreasException"
            r5.trackUnExpectedScenario(r6, r11)
        L_0x00d7:
            boolean r10 = kotlin.Result.m6336isSuccessimpl(r10)
            if (r10 == 0) goto L_0x00f0
            r10 = 0
            r0.f12231h = r10
            r0.f12232i = r10
            r0.f12233j = r10
            r0.f12237n = r3
            java.lang.Object r9 = r4.resetApplicationState(r9, r2, r0)
            if (r9 != r1) goto L_0x00ed
            return r1
        L_0x00ed:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Success r9 = com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase.Result.Success.INSTANCE
            goto L_0x00f7
        L_0x00f0:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error r9 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error$Code r10 = com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase.Result.Error.Code.API_ERROR
            r9.<init>(r10)
        L_0x00f7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl.setSelectedCountry(boolean, com.talabat.userandlocation.choosecountry.domain.entity.CountryVO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setUserSelectedCountry(int r7, boolean r8, boolean r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase.Result> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1 r0 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1) r0
            int r1 = r0.f12242l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12242l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1 r0 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f12240j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12242l
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009a
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            boolean r9 = r0.f12239i
            java.lang.Object r7 = r0.f12238h
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl r7 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0085
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r10)
            com.talabat.configuration.ConfigurationLocalRepository r10 = r6.configurationLocalRepository
            com.talabat.configuration.country.Country r10 = r10.selectedCountry()
            int r10 = r10.getCountryId()
            if (r10 == r7) goto L_0x0051
            r10 = r5
            goto L_0x0052
        L_0x0051:
            r10 = r4
        L_0x0052:
            if (r10 != 0) goto L_0x005c
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error r7 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error$Code r8 = com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase.Result.Error.Code.COUNTRY_ALREADY_SELECTED
            r7.<init>(r8)
            return r7
        L_0x005c:
            kotlin.jvm.functions.Function0<java.lang.Boolean> r10 = r6.cartHasItemsProvider
            java.lang.Object r10 = r10.invoke()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x006e
            if (r8 != 0) goto L_0x006e
            r8 = r5
            goto L_0x006f
        L_0x006e:
            r8 = r4
        L_0x006f:
            if (r8 == 0) goto L_0x0077
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$WarnBasketClear r8 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$WarnBasketClear
            r8.<init>(r7)
            goto L_0x00a2
        L_0x0077:
            r0.f12238h = r6
            r0.f12239i = r9
            r0.f12242l = r5
            java.lang.Object r10 = r6.getCountry(r7, r0)
            if (r10 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r7 = r6
        L_0x0085:
            com.talabat.userandlocation.choosecountry.domain.entity.CountryVO r10 = (com.talabat.userandlocation.choosecountry.domain.entity.CountryVO) r10
            if (r10 == 0) goto L_0x009b
            com.talabat.growth.features.loyalty.sharedpreferences.IsUserRewards r8 = r7.isUserRewardsSharedPreferences
            r8.saveIsUserEligibleForRewardsProgram(r4)
            r8 = 0
            r0.f12238h = r8
            r0.f12242l = r3
            java.lang.Object r10 = r7.setSelectedCountry(r9, r10, r0)
            if (r10 != r1) goto L_0x009a
            return r1
        L_0x009a:
            return r10
        L_0x009b:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error r8 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error
            com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase$Result$Error$Code r7 = com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase.Result.Error.Code.NO_COUNTRY_FOUND
            r8.<init>(r7)
        L_0x00a2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl.setUserSelectedCountry(int, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
