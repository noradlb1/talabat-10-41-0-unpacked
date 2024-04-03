package com.talabat.fluid.homescreen.data.impl;

import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import com.talabat.configuration.language.Language;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.fluid.homescreen.data.local.FluidHomeComponentLocalDataSource;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService;
import com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ5\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060 j\u0002`!\u0012\u0004\u0012\u00020\"0\u001f0\u001d2\u0006\u0010#\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ5\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060 j\u0002`!\u0012\u0004\u0012\u00020\"0\u001f0\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ5\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060 j\u0002`!\u0012\u0004\u0012\u00020\"0\u001f0\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010&\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ.\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+2\u0016\u0010,\u001a\u0012\u0012\b\u0012\u00060 j\u0002`!\u0012\u0004\u0012\u00020\"0\u001fH\u0002J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0002J6\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010/\u001a\u00020\u001e2\u0016\u0010,\u001a\u0012\u0012\b\u0012\u00060 j\u0002`!\u0012\u0004\u0012\u00020\"0\u001f2\u0006\u0010*\u001a\u00020+H\u0002J\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\b\u0012\u0004\u0012\u00020807*\u00020\u001eH\u0002J\u0010\u00109\u001a\u0004\u0018\u00010:*\u0004\u0018\u00010;H\u0002J\u0010\u0010<\u001a\u0004\u0018\u00010=*\u0004\u0018\u00010>H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/talabat/fluid/homescreen/data/impl/HomeConfigurationRepositoryImpl;", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository;", "campaignMigratorSharedPreferences", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "readableTemplateSource", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "fluidHomeComponentLocalDataSource", "Lcom/talabat/fluid/homescreen/data/local/FluidHomeComponentLocalDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "fluidHomeComponentService", "Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentService;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "componentMapper", "Lcom/talabat/fluid/homescreen/data/parser/ComponentMapper;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;Lcom/talabat/fluid/homescreen/data/local/FluidHomeComponentLocalDataSource;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentService;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/deliveryhero/fluid/ParseConfig;Lcom/talabat/fluid/homescreen/data/parser/ComponentMapper;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "fetchComponents", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository$Components;", "fluidHomeComponentRequestParams", "Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentRequestParams;", "(Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchComponentsAndTemplates", "Lkotlin/Pair;", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/Template;", "requestParams", "fetchComponentsAndTemplatesInParallel", "fetchComponentsAndTemplatesInSequence", "getComponents", "getFallbackComponents", "", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "selectedLanguage", "Lcom/talabat/configuration/language/Language;", "templates", "getLocalComponentFor", "mapToListCells", "componentResponse", "shouldCallApiInParallel", "", "track", "", "throwable", "", "getTemplateKeys", "", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "toConfiguration", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository$Components$Configuration;", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Configurations;", "toMetadata", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository$Components$Metadata;", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Metadata;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeConfigurationRepositoryImpl implements HomeConfigurationRepository {
    @NotNull
    private final CampaignMigratorSharedPreferences campaignMigratorSharedPreferences;
    @NotNull
    private final ComponentMapper componentMapper;
    @NotNull
    private final FluidHomeComponentLocalDataSource fluidHomeComponentLocalDataSource;
    @NotNull
    private final FluidHomeComponentService fluidHomeComponentService;
    /* access modifiers changed from: private */
    @NotNull
    public final HomeScreenPerformanceObservability homeScreenPerformanceObservability;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    @NotNull
    private final IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    @NotNull
    public final ParseConfig parseConfig;
    /* access modifiers changed from: private */
    @NotNull
    public final ReadableTemplateSource readableTemplateSource;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Language.values().length];
            iArr[Language.ENGLISH.ordinal()] = 1;
            iArr[Language.UNKNOWN.ordinal()] = 2;
            iArr[Language.ARABIC.ordinal()] = 3;
            iArr[Language.KURDISH_BADINI.ordinal()] = 4;
            iArr[Language.KURDISH_SORANI.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HomeConfigurationRepositoryImpl(@NotNull CampaignMigratorSharedPreferences campaignMigratorSharedPreferences2, @NotNull ReadableTemplateSource readableTemplateSource2, @NotNull FluidHomeComponentLocalDataSource fluidHomeComponentLocalDataSource2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability2, @NotNull FluidHomeComponentService fluidHomeComponentService2, @NotNull IObservabilityManager iObservabilityManager, @NotNull ParseConfig parseConfig2, @NotNull ComponentMapper componentMapper2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(campaignMigratorSharedPreferences2, "campaignMigratorSharedPreferences");
        Intrinsics.checkNotNullParameter(readableTemplateSource2, "readableTemplateSource");
        Intrinsics.checkNotNullParameter(fluidHomeComponentLocalDataSource2, "fluidHomeComponentLocalDataSource");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "homeScreenPerformanceObservability");
        Intrinsics.checkNotNullParameter(fluidHomeComponentService2, "fluidHomeComponentService");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(parseConfig2, "parseConfig");
        Intrinsics.checkNotNullParameter(componentMapper2, "componentMapper");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.campaignMigratorSharedPreferences = campaignMigratorSharedPreferences2;
        this.readableTemplateSource = readableTemplateSource2;
        this.fluidHomeComponentLocalDataSource = fluidHomeComponentLocalDataSource2;
        this.ioDispatcher = coroutineDispatcher;
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
        this.fluidHomeComponentService = fluidHomeComponentService2;
        this.observabilityManager = iObservabilityManager;
        this.parseConfig = parseConfig2;
        this.componentMapper = componentMapper2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    public final Object fetchComponentsAndTemplates(FluidHomeComponentRequestParams fluidHomeComponentRequestParams, Continuation<? super Pair<ContentApiResponse, ? extends Map<String, Template>>> continuation) {
        if (shouldCallApiInParallel()) {
            return fetchComponentsAndTemplatesInParallel(fluidHomeComponentRequestParams, continuation);
        }
        return fetchComponentsAndTemplatesInSequence(fluidHomeComponentRequestParams, continuation);
    }

    /* access modifiers changed from: private */
    public final Object fetchComponentsAndTemplatesInParallel(FluidHomeComponentRequestParams fluidHomeComponentRequestParams, Continuation<? super Pair<ContentApiResponse, ? extends Map<String, Template>>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2(this, fluidHomeComponentRequestParams, (Continuation<? super HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b A[LOOP:0: B:17:0x0065->B:19:0x006b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchComponentsAndTemplatesInSequence(com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams r6, kotlin.coroutines.Continuation<? super kotlin.Pair<com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse, ? extends java.util.Map<java.lang.String, com.deliveryhero.fluid.template.Template>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1 r0 = (com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1) r0
            int r1 = r0.f59688k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59688k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1 r0 = new com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f59686i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59688k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f59685h
            com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl r6 = (com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f59685h = r5
            r0.f59688k = r3
            java.lang.Object r7 = r5.getComponents(r6, r0)
            if (r7 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r6 = r5
        L_0x0044:
            com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse r7 = (com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse) r7
            java.util.Set r0 = r6.getTemplateKeys(r7)
            com.deliveryhero.fluid.template.sources.ReadableTemplateSource r1 = r6.readableTemplateSource
            java.util.Map r0 = r1.get((java.util.Set<com.deliveryhero.fluid.template.sources.ReadableTemplateSource.Request>) r0)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            int r2 = r0.size()
            int r2 = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(r2)
            r1.<init>(r2)
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0065:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0085
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r2 = r2.getValue()
            com.deliveryhero.fluid.template.TemplateBuilder r2 = (com.deliveryhero.fluid.template.TemplateBuilder) r2
            com.deliveryhero.fluid.ParseConfig r4 = r6.parseConfig
            com.deliveryhero.fluid.template.Template r2 = r2.build(r4)
            r1.put(r3, r2)
            goto L_0x0065
        L_0x0085:
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r7, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl.fetchComponentsAndTemplatesInSequence(com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getComponents(com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams r26, kotlin.coroutines.Continuation<? super com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse> r27) {
        /*
            r25 = this;
            r1 = r25
            r0 = r27
            boolean r2 = r0 instanceof com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$getComponents$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$getComponents$1 r2 = (com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$getComponents$1) r2
            int r3 = r2.f59693l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f59693l = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$getComponents$1 r2 = new com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$getComponents$1
            r2.<init>(r1, r0)
        L_0x001c:
            r15 = r2
            java.lang.Object r0 = r15.f59691j
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r15.f59693l
            r4 = 1
            if (r3 == 0) goto L_0x0041
            if (r3 != r4) goto L_0x0039
            java.lang.Object r2 = r15.f59690i
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams r2 = (com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams) r2
            java.lang.Object r3 = r15.f59689h
            com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl r3 = (com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0036 }
            goto L_0x00ab
        L_0x0036:
            r0 = move-exception
            goto L_0x00b7
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00b2 }
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService r3 = r1.fluidHomeComponentService     // Catch:{ all -> 0x00b2 }
            com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences r0 = r1.campaignMigratorSharedPreferences     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = r0.getPrefExternalUserId()     // Catch:{ all -> 0x00b2 }
            com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences r5 = r1.campaignMigratorSharedPreferences     // Catch:{ all -> 0x00b2 }
            java.lang.String r5 = r5.getPrefVoucher()     // Catch:{ all -> 0x00b2 }
            com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences r6 = r1.campaignMigratorSharedPreferences     // Catch:{ all -> 0x00b2 }
            java.lang.String r6 = r6.getPrefCampaignName()     // Catch:{ all -> 0x00b2 }
            java.util.List r7 = r26.getExternalExperiments()     // Catch:{ all -> 0x00b2 }
            r16 = r7
            java.lang.Iterable r16 = (java.lang.Iterable) r16     // Catch:{ all -> 0x00b2 }
            java.lang.String r17 = ","
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 62
            r24 = 0
            java.lang.String r7 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x00b2 }
            java.lang.String r8 = r26.getDeviceWidthInDP()     // Catch:{ all -> 0x00b2 }
            java.lang.String r9 = r26.getCountryCode()     // Catch:{ all -> 0x00b2 }
            java.lang.String r10 = r26.getLatitude()     // Catch:{ all -> 0x00b2 }
            double r10 = java.lang.Double.parseDouble(r10)     // Catch:{ all -> 0x00b2 }
            java.lang.String r12 = r26.getLongitude()     // Catch:{ all -> 0x00b2 }
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ all -> 0x00b2 }
            java.lang.String r14 = r26.getAreaId()     // Catch:{ all -> 0x00b2 }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ all -> 0x00b2 }
            r15.f59689h = r1     // Catch:{ all -> 0x00b2 }
            r4 = r26
            r15.f59690i = r4     // Catch:{ all -> 0x00b2 }
            r1 = 1
            r15.f59693l = r1     // Catch:{ all -> 0x00b2 }
            r4 = r0
            java.lang.Object r0 = r3.fetchFluidHomeComponent(r4, r5, r6, r7, r8, r9, r10, r12, r14, r15)     // Catch:{ all -> 0x00b2 }
            if (r0 != r2) goto L_0x00a7
            return r2
        L_0x00a7:
            r3 = r25
            r2 = r26
        L_0x00ab:
            com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse r0 = (com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse) r0     // Catch:{ all -> 0x0036 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0036 }
            goto L_0x00c1
        L_0x00b2:
            r0 = move-exception
            r3 = r25
            r2 = r26
        L_0x00b7:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00c1:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r1 != 0) goto L_0x00c8
            goto L_0x00d3
        L_0x00c8:
            r3.track(r1)
            com.talabat.configuration.language.Language r0 = r2.getSelectedLanguage()
            com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse r0 = r3.getLocalComponentFor(r0)
        L_0x00d3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl.getComponents(com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List<ListCell> getFallbackComponents(Language language, Map<String, Template> map) {
        List<ListCell> map2 = this.componentMapper.map(getLocalComponentFor(language), map);
        HomeScreenPerformanceObservability.DefaultImpls.traceEvent$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "homeConfigurationRepository.getFallbackComponents", (Map) null, 4, (Object) null);
        return map2;
    }

    private final ContentApiResponse getLocalComponentFor(Language language) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[language.ordinal()];
        if (i11 == 1 || i11 == 2) {
            return this.fluidHomeComponentLocalDataSource.getEnglishComponents();
        }
        if (i11 == 3 || i11 == 4 || i11 == 5) {
            return this.fluidHomeComponentLocalDataSource.getArabicComponents();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Set<ReadableTemplateSource.Request> getTemplateKeys(ContentApiResponse contentApiResponse) {
        List<ContentApiResponse.Component> components;
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "homeConfigurationRepository.getTemplateKeys", (Map) null, 4, (Object) null);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ContentApiResponse.Data data = contentApiResponse.getData();
        if (!(data == null || (components = data.getComponents()) == null)) {
            Iterable<ContentApiResponse.Component> iterable = components;
            ArrayList<ContentApiResponse.Item> arrayList = new ArrayList<>();
            for (ContentApiResponse.Component items : iterable) {
                List<ContentApiResponse.Item> items2 = items.getItems();
                if (items2 == null) {
                    items2 = CollectionsKt__CollectionsKt.emptyList();
                }
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, items2);
            }
            for (ContentApiResponse.Item item : arrayList) {
                linkedHashSet.add(new ReadableTemplateSource.Request(item.getTemplateId(), item.getTemplateHash()));
            }
            ArrayList<ContentApiResponse.Component> arrayList2 = new ArrayList<>();
            for (ContentApiResponse.Component component : iterable) {
                if (component != null) {
                    arrayList2.add(component);
                }
            }
            for (ContentApiResponse.Component component2 : arrayList2) {
                linkedHashSet.add(new ReadableTemplateSource.Request(component2.getTemplateId(), component2.getTemplateHash()));
            }
        }
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "homeConfigurationRepository.getTemplateKeys", (Map) null, 4, (Object) null);
        return linkedHashSet;
    }

    /* access modifiers changed from: private */
    public final List<ListCell> mapToListCells(ContentApiResponse contentApiResponse, Map<String, Template> map, Language language) {
        List<ListCell> map2 = this.componentMapper.map(contentApiResponse, map);
        if (!map2.isEmpty()) {
            return map2;
        }
        HomeScreenPerformanceObservability.DefaultImpls.traceEvent$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.ERROR, "homeConfigurationRepository.emptyApiComponentList", (Map) null, 4, (Object) null);
        return getFallbackComponents(language, map);
    }

    private final boolean shouldCallApiInParallel() {
        return this.talabatFeatureFlag.getFeatureFlag(HomePageFeatureFlagsKeys.PARALLEL_API_CALLS, false);
    }

    /* access modifiers changed from: private */
    public final HomeConfigurationRepository.Components.Configuration toConfiguration(ContentApiResponse.Configurations configurations) {
        if (configurations != null) {
            return new HomeConfigurationRepository.Components.Configuration(configurations.getNavigationBarColor(), configurations.getLocationHintColor(), configurations.getLocationTitleColor(), configurations.getLocationArrowTintColor());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final HomeConfigurationRepository.Components.Metadata toMetadata(ContentApiResponse.Metadata metadata) {
        if (metadata != null) {
            return new HomeConfigurationRepository.Components.Metadata(metadata.getClearVoucherCache());
        }
        return null;
    }

    private final void track(Throwable th2) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        iObservabilityManager.trackUnExpectedScenario("HomeConfigurationRepositoryImplExceptions", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    @Nullable
    public Object fetchComponents(@NotNull FluidHomeComponentRequestParams fluidHomeComponentRequestParams, @NotNull Continuation<? super HomeConfigurationRepository.Components> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new HomeConfigurationRepositoryImpl$fetchComponents$2(this, fluidHomeComponentRequestParams, (Continuation<? super HomeConfigurationRepositoryImpl$fetchComponents$2>) null), continuation);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HomeConfigurationRepositoryImpl(com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences r15, com.deliveryhero.fluid.template.sources.ReadableTemplateSource r16, com.talabat.fluid.homescreen.data.local.FluidHomeComponentLocalDataSource r17, kotlinx.coroutines.CoroutineDispatcher r18, com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r19, com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService r20, com.talabat.core.observabilityNew.domain.IObservabilityManager r21, com.deliveryhero.fluid.ParseConfig r22, com.talabat.fluid.homescreen.data.parser.ComponentMapper r23, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25 & 32
            if (r0 == 0) goto L_0x000f
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService r0 = new com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService
            r1 = 1
            r2 = 0
            r8 = r19
            r0.<init>(r2, r8, r1, r2)
            r9 = r0
            goto L_0x0013
        L_0x000f:
            r8 = r19
            r9 = r20
        L_0x0013:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl.<init>(com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences, com.deliveryhero.fluid.template.sources.ReadableTemplateSource, com.talabat.fluid.homescreen.data.local.FluidHomeComponentLocalDataSource, kotlinx.coroutines.CoroutineDispatcher, com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability, com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService, com.talabat.core.observabilityNew.domain.IObservabilityManager, com.deliveryhero.fluid.ParseConfig, com.talabat.fluid.homescreen.data.parser.ComponentMapper, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
