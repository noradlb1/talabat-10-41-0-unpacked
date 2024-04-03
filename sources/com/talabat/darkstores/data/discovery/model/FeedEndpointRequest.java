package com.talabat.darkstores.data.discovery.model;

import com.google.android.exoplayer2.C;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\ba\b\b\u0018\u00002\u00020\u0001:\f\u0001\u0001\u0001\u0001\u0001\u0001Bÿ\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0015\u0012\u0010\b\u0003\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010%\u0012\b\b\u0003\u0010&\u001a\u00020\u0012\u0012\b\b\u0003\u0010'\u001a\u00020\u0012\u0012\b\b\u0003\u0010(\u001a\u00020\u0012\u0012\b\b\u0003\u0010)\u001a\u00020\u0006\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010-J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010`\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00103J\t\u0010a\u001a\u00020\u0015HÆ\u0003J\u0011\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003J\u0011\u0010c\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010 HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010k\u001a\u0004\u0018\u00010%HÆ\u0003J\t\u0010l\u001a\u00020\u0012HÆ\u0003J\t\u0010m\u001a\u00020\u0012HÆ\u0003J\t\u0010n\u001a\u00020\u0012HÆ\u0003J\t\u0010o\u001a\u00020\u0006HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010q\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0003\u0010z\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0003\u0010\u0014\u001a\u00020\u00152\u0010\b\u0003\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0003\u0010&\u001a\u00020\u00122\b\b\u0003\u0010'\u001a\u00020\u00122\b\b\u0003\u0010(\u001a\u00020\u00122\b\b\u0003\u0010)\u001a\u00020\u00062\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010{J\u0013\u0010|\u001a\u00020\u00062\b\u0010}\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010~\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0015\u0010*\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0015\u0010#\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010/R\u0011\u0010&\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0015\u0010!\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00107\u001a\u0004\b!\u00106R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010/R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00104\u001a\u0004\bD\u00103R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010/R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00104\u001a\u0004\bH\u00103R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010/R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010/R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00107\u001a\u0004\bP\u00106R\u0011\u0010'\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010<R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010/R\u0011\u0010)\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010/R\u0011\u0010(\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bV\u0010<R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010/R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010Y¨\u0006\u0001"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest;", "", "query", "", "originalQuery", "saveQuery", "", "countryCode", "languageCode", "languageId", "brand", "vendorId", "branchId", "customerId", "sessionId", "categoryId", "config", "limit", "", "offset", "location", "Lcom/talabat/darkstores/data/discovery/model/Location;", "includeFields", "", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$FieldsTypes;", "includeComponentTypes", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ComponentTypes;", "platform", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$Platform;", "verticalType", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$VerticalTypes;", "expeditionType", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ExpeditionTypes;", "isDarkstore", "productTag", "completeQuery", "pageType", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;", "designVariant", "searchVariant", "sortingStrategy", "showAgeRestrictedItems", "chainId", "missionControl", "sort", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/talabat/darkstores/data/discovery/model/Location;Ljava/util/List;Ljava/util/List;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$Platform;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$VerticalTypes;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ExpeditionTypes;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;IIIZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/String;", "getBrand", "getCategoryId", "getChainId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCompleteQuery", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConfig", "getCountryCode", "getCustomerId", "getDesignVariant", "()I", "getExpeditionType", "()Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ExpeditionTypes;", "getIncludeComponentTypes", "()Ljava/util/List;", "getIncludeFields", "getLanguageCode", "getLanguageId", "getLimit", "getLocation", "()Lcom/talabat/darkstores/data/discovery/model/Location;", "getMissionControl", "getOffset", "getOriginalQuery", "getPageType", "()Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;", "getPlatform", "()Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$Platform;", "getProductTag", "getQuery", "getSaveQuery", "getSearchVariant", "getSessionId", "getShowAgeRestrictedItems", "()Z", "getSort", "getSortingStrategy", "getVendorId", "getVerticalType", "()Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$VerticalTypes;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/talabat/darkstores/data/discovery/model/Location;Ljava/util/List;Ljava/util/List;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$Platform;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$VerticalTypes;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ExpeditionTypes;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;IIIZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest;", "equals", "other", "hashCode", "toString", "ComponentTypes", "ExpeditionTypes", "FieldsTypes", "PageType", "Platform", "VerticalTypes", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeedEndpointRequest {
    @Nullable
    private final String branchId;
    @NotNull
    private final String brand;
    @Nullable
    private final String categoryId;
    @Nullable
    private final Integer chainId;
    @Nullable
    private final Boolean completeQuery;
    @Nullable
    private final String config;
    @NotNull
    private final String countryCode;
    @Nullable
    private final String customerId;
    private final int designVariant;
    @Nullable
    private final ExpeditionTypes expeditionType;
    @Nullable
    private final List<ComponentTypes> includeComponentTypes;
    @Nullable
    private final List<FieldsTypes> includeFields;
    @Nullable
    private final Boolean isDarkstore;
    @NotNull
    private final String languageCode;
    @Nullable
    private final String languageId;
    @Nullable
    private final Integer limit;
    @NotNull
    private final Location location;
    @Nullable
    private final String missionControl;
    @Nullable
    private final Integer offset;
    @Nullable
    private final String originalQuery;
    @Nullable
    private final PageType pageType;
    @Nullable
    private final Platform platform;
    @Nullable
    private final String productTag;
    @Nullable
    private final String query;
    @Nullable
    private final Boolean saveQuery;
    private final int searchVariant;
    @Nullable
    private final String sessionId;
    private final boolean showAgeRestrictedItems;
    @Nullable
    private final String sort;
    private final int sortingStrategy;
    @NotNull
    private final String vendorId;
    @Nullable
    private final VerticalTypes verticalType;

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ComponentTypes;", "", "(Ljava/lang/String;I)V", "multi_list", "products", "vendors", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ComponentTypes {
        multi_list,
        products,
        vendors
    }

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ExpeditionTypes;", "", "(Ljava/lang/String;I)V", "delivery", "pickup", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ExpeditionTypes {
        delivery,
        pickup
    }

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$FieldsTypes;", "", "(Ljava/lang/String;I)V", "category_tree", "feed", "vendor", "suggestions", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum FieldsTypes {
        category_tree,
        feed,
        vendor,
        suggestions
    }

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;", "", "(Ljava/lang/String;I)V", "landing_page", "default_page", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum PageType {
        landing_page,
        default_page
    }

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$Platform;", "", "(Ljava/lang/String;I)V", "ios", "android", "web", "mweb", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Platform {
        ios,
        android,
        web,
        mweb
    }

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$VerticalTypes;", "", "(Ljava/lang/String;I)V", "restaurants", "groceries", "flowers", "cosmetics", "health_supplements", "pharmacies", "pets", "drinks", "cross_vertical", "electronics", "baby_supplies", "furniture", "max_hits_vertical", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum VerticalTypes {
        restaurants,
        groceries,
        flowers,
        cosmetics,
        health_supplements,
        pharmacies,
        pets,
        drinks,
        cross_vertical,
        electronics,
        baby_supplies,
        furniture,
        max_hits_vertical
    }

    public FeedEndpointRequest(@Nullable @Json(name = "q") String str, @Nullable @Json(name = "oq") String str2, @Nullable @Json(name = "save_query") Boolean bool, @NotNull @Json(name = "country_code") String str3, @NotNull @Json(name = "language_code") String str4, @Nullable @Json(name = "language_id") String str5, @NotNull @Json(name = "brand") String str6, @NotNull @Json(name = "vendor_id") String str7, @Nullable @Json(name = "branch_id") String str8, @Nullable @Json(name = "customer_id") String str9, @Nullable @Json(name = "session_id") String str10, @Nullable @Json(name = "category_id") String str11, @Nullable @Json(name = "config") String str12, @Nullable @Json(name = "limit") Integer num, @Nullable @Json(name = "offset") Integer num2, @NotNull @Json(name = "location") Location location2, @Nullable @Json(name = "include_fields") List<? extends FieldsTypes> list, @Nullable @Json(name = "include_component_types") List<? extends ComponentTypes> list2, @Nullable @Json(name = "platform") Platform platform2, @Nullable @Json(name = "vertical_type") VerticalTypes verticalTypes, @Nullable @Json(name = "expedition_type") ExpeditionTypes expeditionTypes, @Nullable @Json(name = "is_darkstore") Boolean bool2, @Nullable @Json(name = "product_tag") String str13, @Nullable @Json(name = "complete_query") Boolean bool3, @Nullable @Json(name = "page_name") PageType pageType2, @Json(name = "design_variant") int i11, @Json(name = "search_variant") int i12, @Json(name = "sorting_strategy") int i13, @Json(name = "show_age_restricted_items") boolean z11, @Nullable @Json(name = "chain_id") Integer num3, @Nullable @Json(name = "mission_control") String str14, @Nullable @Json(name = "sort") String str15) {
        Location location3 = location2;
        Intrinsics.checkNotNullParameter(str3, "countryCode");
        Intrinsics.checkNotNullParameter(str4, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        Intrinsics.checkNotNullParameter(str6, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str7, "vendorId");
        Intrinsics.checkNotNullParameter(location3, "location");
        this.query = str;
        this.originalQuery = str2;
        this.saveQuery = bool;
        this.countryCode = str3;
        this.languageCode = str4;
        this.languageId = str5;
        this.brand = str6;
        this.vendorId = str7;
        this.branchId = str8;
        this.customerId = str9;
        this.sessionId = str10;
        this.categoryId = str11;
        this.config = str12;
        this.limit = num;
        this.offset = num2;
        this.location = location3;
        this.includeFields = list;
        this.includeComponentTypes = list2;
        this.platform = platform2;
        this.verticalType = verticalTypes;
        this.expeditionType = expeditionTypes;
        this.isDarkstore = bool2;
        this.productTag = str13;
        this.completeQuery = bool3;
        this.pageType = pageType2;
        this.designVariant = i11;
        this.searchVariant = i12;
        this.sortingStrategy = i13;
        this.showAgeRestrictedItems = z11;
        this.chainId = num3;
        this.missionControl = str14;
        this.sort = str15;
    }

    public static /* synthetic */ FeedEndpointRequest copy$default(FeedEndpointRequest feedEndpointRequest, String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num, Integer num2, Location location2, List list, List list2, Platform platform2, VerticalTypes verticalTypes, ExpeditionTypes expeditionTypes, Boolean bool2, String str13, Boolean bool3, PageType pageType2, int i11, int i12, int i13, boolean z11, Integer num3, String str14, String str15, int i14, Object obj) {
        FeedEndpointRequest feedEndpointRequest2 = feedEndpointRequest;
        int i15 = i14;
        return feedEndpointRequest.copy((i15 & 1) != 0 ? feedEndpointRequest2.query : str, (i15 & 2) != 0 ? feedEndpointRequest2.originalQuery : str2, (i15 & 4) != 0 ? feedEndpointRequest2.saveQuery : bool, (i15 & 8) != 0 ? feedEndpointRequest2.countryCode : str3, (i15 & 16) != 0 ? feedEndpointRequest2.languageCode : str4, (i15 & 32) != 0 ? feedEndpointRequest2.languageId : str5, (i15 & 64) != 0 ? feedEndpointRequest2.brand : str6, (i15 & 128) != 0 ? feedEndpointRequest2.vendorId : str7, (i15 & 256) != 0 ? feedEndpointRequest2.branchId : str8, (i15 & 512) != 0 ? feedEndpointRequest2.customerId : str9, (i15 & 1024) != 0 ? feedEndpointRequest2.sessionId : str10, (i15 & 2048) != 0 ? feedEndpointRequest2.categoryId : str11, (i15 & 4096) != 0 ? feedEndpointRequest2.config : str12, (i15 & 8192) != 0 ? feedEndpointRequest2.limit : num, (i15 & 16384) != 0 ? feedEndpointRequest2.offset : num2, (i15 & 32768) != 0 ? feedEndpointRequest2.location : location2, (i15 & 65536) != 0 ? feedEndpointRequest2.includeFields : list, (i15 & 131072) != 0 ? feedEndpointRequest2.includeComponentTypes : list2, (i15 & 262144) != 0 ? feedEndpointRequest2.platform : platform2, (i15 & 524288) != 0 ? feedEndpointRequest2.verticalType : verticalTypes, (i15 & 1048576) != 0 ? feedEndpointRequest2.expeditionType : expeditionTypes, (i15 & 2097152) != 0 ? feedEndpointRequest2.isDarkstore : bool2, (i15 & 4194304) != 0 ? feedEndpointRequest2.productTag : str13, (i15 & 8388608) != 0 ? feedEndpointRequest2.completeQuery : bool3, (i15 & 16777216) != 0 ? feedEndpointRequest2.pageType : pageType2, (i15 & 33554432) != 0 ? feedEndpointRequest2.designVariant : i11, (i15 & 67108864) != 0 ? feedEndpointRequest2.searchVariant : i12, (i15 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? feedEndpointRequest2.sortingStrategy : i13, (i15 & 268435456) != 0 ? feedEndpointRequest2.showAgeRestrictedItems : z11, (i15 & 536870912) != 0 ? feedEndpointRequest2.chainId : num3, (i15 & 1073741824) != 0 ? feedEndpointRequest2.missionControl : str14, (i15 & Integer.MIN_VALUE) != 0 ? feedEndpointRequest2.sort : str15);
    }

    @Nullable
    public final String component1() {
        return this.query;
    }

    @Nullable
    public final String component10() {
        return this.customerId;
    }

    @Nullable
    public final String component11() {
        return this.sessionId;
    }

    @Nullable
    public final String component12() {
        return this.categoryId;
    }

    @Nullable
    public final String component13() {
        return this.config;
    }

    @Nullable
    public final Integer component14() {
        return this.limit;
    }

    @Nullable
    public final Integer component15() {
        return this.offset;
    }

    @NotNull
    public final Location component16() {
        return this.location;
    }

    @Nullable
    public final List<FieldsTypes> component17() {
        return this.includeFields;
    }

    @Nullable
    public final List<ComponentTypes> component18() {
        return this.includeComponentTypes;
    }

    @Nullable
    public final Platform component19() {
        return this.platform;
    }

    @Nullable
    public final String component2() {
        return this.originalQuery;
    }

    @Nullable
    public final VerticalTypes component20() {
        return this.verticalType;
    }

    @Nullable
    public final ExpeditionTypes component21() {
        return this.expeditionType;
    }

    @Nullable
    public final Boolean component22() {
        return this.isDarkstore;
    }

    @Nullable
    public final String component23() {
        return this.productTag;
    }

    @Nullable
    public final Boolean component24() {
        return this.completeQuery;
    }

    @Nullable
    public final PageType component25() {
        return this.pageType;
    }

    public final int component26() {
        return this.designVariant;
    }

    public final int component27() {
        return this.searchVariant;
    }

    public final int component28() {
        return this.sortingStrategy;
    }

    public final boolean component29() {
        return this.showAgeRestrictedItems;
    }

    @Nullable
    public final Boolean component3() {
        return this.saveQuery;
    }

    @Nullable
    public final Integer component30() {
        return this.chainId;
    }

    @Nullable
    public final String component31() {
        return this.missionControl;
    }

    @Nullable
    public final String component32() {
        return this.sort;
    }

    @NotNull
    public final String component4() {
        return this.countryCode;
    }

    @NotNull
    public final String component5() {
        return this.languageCode;
    }

    @Nullable
    public final String component6() {
        return this.languageId;
    }

    @NotNull
    public final String component7() {
        return this.brand;
    }

    @NotNull
    public final String component8() {
        return this.vendorId;
    }

    @Nullable
    public final String component9() {
        return this.branchId;
    }

    @NotNull
    public final FeedEndpointRequest copy(@Nullable @Json(name = "q") String str, @Nullable @Json(name = "oq") String str2, @Nullable @Json(name = "save_query") Boolean bool, @NotNull @Json(name = "country_code") String str3, @NotNull @Json(name = "language_code") String str4, @Nullable @Json(name = "language_id") String str5, @NotNull @Json(name = "brand") String str6, @NotNull @Json(name = "vendor_id") String str7, @Nullable @Json(name = "branch_id") String str8, @Nullable @Json(name = "customer_id") String str9, @Nullable @Json(name = "session_id") String str10, @Nullable @Json(name = "category_id") String str11, @Nullable @Json(name = "config") String str12, @Nullable @Json(name = "limit") Integer num, @Nullable @Json(name = "offset") Integer num2, @NotNull @Json(name = "location") Location location2, @Nullable @Json(name = "include_fields") List<? extends FieldsTypes> list, @Nullable @Json(name = "include_component_types") List<? extends ComponentTypes> list2, @Nullable @Json(name = "platform") Platform platform2, @Nullable @Json(name = "vertical_type") VerticalTypes verticalTypes, @Nullable @Json(name = "expedition_type") ExpeditionTypes expeditionTypes, @Nullable @Json(name = "is_darkstore") Boolean bool2, @Nullable @Json(name = "product_tag") String str13, @Nullable @Json(name = "complete_query") Boolean bool3, @Nullable @Json(name = "page_name") PageType pageType2, @Json(name = "design_variant") int i11, @Json(name = "search_variant") int i12, @Json(name = "sorting_strategy") int i13, @Json(name = "show_age_restricted_items") boolean z11, @Nullable @Json(name = "chain_id") Integer num3, @Nullable @Json(name = "mission_control") String str14, @Nullable @Json(name = "sort") String str15) {
        String str16 = str;
        Intrinsics.checkNotNullParameter(str3, "countryCode");
        Intrinsics.checkNotNullParameter(str4, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        Intrinsics.checkNotNullParameter(str6, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str7, "vendorId");
        Intrinsics.checkNotNullParameter(location2, "location");
        return new FeedEndpointRequest(str, str2, bool, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, num, num2, location2, list, list2, platform2, verticalTypes, expeditionTypes, bool2, str13, bool3, pageType2, i11, i12, i13, z11, num3, str14, str15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedEndpointRequest)) {
            return false;
        }
        FeedEndpointRequest feedEndpointRequest = (FeedEndpointRequest) obj;
        return Intrinsics.areEqual((Object) this.query, (Object) feedEndpointRequest.query) && Intrinsics.areEqual((Object) this.originalQuery, (Object) feedEndpointRequest.originalQuery) && Intrinsics.areEqual((Object) this.saveQuery, (Object) feedEndpointRequest.saveQuery) && Intrinsics.areEqual((Object) this.countryCode, (Object) feedEndpointRequest.countryCode) && Intrinsics.areEqual((Object) this.languageCode, (Object) feedEndpointRequest.languageCode) && Intrinsics.areEqual((Object) this.languageId, (Object) feedEndpointRequest.languageId) && Intrinsics.areEqual((Object) this.brand, (Object) feedEndpointRequest.brand) && Intrinsics.areEqual((Object) this.vendorId, (Object) feedEndpointRequest.vendorId) && Intrinsics.areEqual((Object) this.branchId, (Object) feedEndpointRequest.branchId) && Intrinsics.areEqual((Object) this.customerId, (Object) feedEndpointRequest.customerId) && Intrinsics.areEqual((Object) this.sessionId, (Object) feedEndpointRequest.sessionId) && Intrinsics.areEqual((Object) this.categoryId, (Object) feedEndpointRequest.categoryId) && Intrinsics.areEqual((Object) this.config, (Object) feedEndpointRequest.config) && Intrinsics.areEqual((Object) this.limit, (Object) feedEndpointRequest.limit) && Intrinsics.areEqual((Object) this.offset, (Object) feedEndpointRequest.offset) && Intrinsics.areEqual((Object) this.location, (Object) feedEndpointRequest.location) && Intrinsics.areEqual((Object) this.includeFields, (Object) feedEndpointRequest.includeFields) && Intrinsics.areEqual((Object) this.includeComponentTypes, (Object) feedEndpointRequest.includeComponentTypes) && this.platform == feedEndpointRequest.platform && this.verticalType == feedEndpointRequest.verticalType && this.expeditionType == feedEndpointRequest.expeditionType && Intrinsics.areEqual((Object) this.isDarkstore, (Object) feedEndpointRequest.isDarkstore) && Intrinsics.areEqual((Object) this.productTag, (Object) feedEndpointRequest.productTag) && Intrinsics.areEqual((Object) this.completeQuery, (Object) feedEndpointRequest.completeQuery) && this.pageType == feedEndpointRequest.pageType && this.designVariant == feedEndpointRequest.designVariant && this.searchVariant == feedEndpointRequest.searchVariant && this.sortingStrategy == feedEndpointRequest.sortingStrategy && this.showAgeRestrictedItems == feedEndpointRequest.showAgeRestrictedItems && Intrinsics.areEqual((Object) this.chainId, (Object) feedEndpointRequest.chainId) && Intrinsics.areEqual((Object) this.missionControl, (Object) feedEndpointRequest.missionControl) && Intrinsics.areEqual((Object) this.sort, (Object) feedEndpointRequest.sort);
    }

    @Nullable
    public final String getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getBrand() {
        return this.brand;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final Integer getChainId() {
        return this.chainId;
    }

    @Nullable
    public final Boolean getCompleteQuery() {
        return this.completeQuery;
    }

    @Nullable
    public final String getConfig() {
        return this.config;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @Nullable
    public final String getCustomerId() {
        return this.customerId;
    }

    public final int getDesignVariant() {
        return this.designVariant;
    }

    @Nullable
    public final ExpeditionTypes getExpeditionType() {
        return this.expeditionType;
    }

    @Nullable
    public final List<ComponentTypes> getIncludeComponentTypes() {
        return this.includeComponentTypes;
    }

    @Nullable
    public final List<FieldsTypes> getIncludeFields() {
        return this.includeFields;
    }

    @NotNull
    public final String getLanguageCode() {
        return this.languageCode;
    }

    @Nullable
    public final String getLanguageId() {
        return this.languageId;
    }

    @Nullable
    public final Integer getLimit() {
        return this.limit;
    }

    @NotNull
    public final Location getLocation() {
        return this.location;
    }

    @Nullable
    public final String getMissionControl() {
        return this.missionControl;
    }

    @Nullable
    public final Integer getOffset() {
        return this.offset;
    }

    @Nullable
    public final String getOriginalQuery() {
        return this.originalQuery;
    }

    @Nullable
    public final PageType getPageType() {
        return this.pageType;
    }

    @Nullable
    public final Platform getPlatform() {
        return this.platform;
    }

    @Nullable
    public final String getProductTag() {
        return this.productTag;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final Boolean getSaveQuery() {
        return this.saveQuery;
    }

    public final int getSearchVariant() {
        return this.searchVariant;
    }

    @Nullable
    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getShowAgeRestrictedItems() {
        return this.showAgeRestrictedItems;
    }

    @Nullable
    public final String getSort() {
        return this.sort;
    }

    public final int getSortingStrategy() {
        return this.sortingStrategy;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    @Nullable
    public final VerticalTypes getVerticalType() {
        return this.verticalType;
    }

    public int hashCode() {
        String str = this.query;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.originalQuery;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.saveQuery;
        int hashCode3 = (((((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + this.countryCode.hashCode()) * 31) + this.languageCode.hashCode()) * 31;
        String str3 = this.languageId;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.brand.hashCode()) * 31) + this.vendorId.hashCode()) * 31;
        String str4 = this.branchId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.customerId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sessionId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.categoryId;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.config;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num = this.limit;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.offset;
        int hashCode11 = (((hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.location.hashCode()) * 31;
        List<FieldsTypes> list = this.includeFields;
        int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        List<ComponentTypes> list2 = this.includeComponentTypes;
        int hashCode13 = (hashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Platform platform2 = this.platform;
        int hashCode14 = (hashCode13 + (platform2 == null ? 0 : platform2.hashCode())) * 31;
        VerticalTypes verticalTypes = this.verticalType;
        int hashCode15 = (hashCode14 + (verticalTypes == null ? 0 : verticalTypes.hashCode())) * 31;
        ExpeditionTypes expeditionTypes = this.expeditionType;
        int hashCode16 = (hashCode15 + (expeditionTypes == null ? 0 : expeditionTypes.hashCode())) * 31;
        Boolean bool2 = this.isDarkstore;
        int hashCode17 = (hashCode16 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str9 = this.productTag;
        int hashCode18 = (hashCode17 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool3 = this.completeQuery;
        int hashCode19 = (hashCode18 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        PageType pageType2 = this.pageType;
        int hashCode20 = (((((((hashCode19 + (pageType2 == null ? 0 : pageType2.hashCode())) * 31) + this.designVariant) * 31) + this.searchVariant) * 31) + this.sortingStrategy) * 31;
        boolean z11 = this.showAgeRestrictedItems;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode20 + (z11 ? 1 : 0)) * 31;
        Integer num3 = this.chainId;
        int hashCode21 = (i12 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.missionControl;
        int hashCode22 = (hashCode21 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.sort;
        if (str11 != null) {
            i11 = str11.hashCode();
        }
        return hashCode22 + i11;
    }

    @Nullable
    public final Boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.query;
        String str2 = this.originalQuery;
        Boolean bool = this.saveQuery;
        String str3 = this.countryCode;
        String str4 = this.languageCode;
        String str5 = this.languageId;
        String str6 = this.brand;
        String str7 = this.vendorId;
        String str8 = this.branchId;
        String str9 = this.customerId;
        String str10 = this.sessionId;
        String str11 = this.categoryId;
        String str12 = this.config;
        Integer num = this.limit;
        Integer num2 = this.offset;
        Location location2 = this.location;
        List<FieldsTypes> list = this.includeFields;
        List<ComponentTypes> list2 = this.includeComponentTypes;
        Platform platform2 = this.platform;
        VerticalTypes verticalTypes = this.verticalType;
        ExpeditionTypes expeditionTypes = this.expeditionType;
        Boolean bool2 = this.isDarkstore;
        String str13 = this.productTag;
        Boolean bool3 = this.completeQuery;
        PageType pageType2 = this.pageType;
        int i11 = this.designVariant;
        int i12 = this.searchVariant;
        int i13 = this.sortingStrategy;
        boolean z11 = this.showAgeRestrictedItems;
        Integer num3 = this.chainId;
        String str14 = this.missionControl;
        String str15 = this.sort;
        return "FeedEndpointRequest(query=" + str + ", originalQuery=" + str2 + ", saveQuery=" + bool + ", countryCode=" + str3 + ", languageCode=" + str4 + ", languageId=" + str5 + ", brand=" + str6 + ", vendorId=" + str7 + ", branchId=" + str8 + ", customerId=" + str9 + ", sessionId=" + str10 + ", categoryId=" + str11 + ", config=" + str12 + ", limit=" + num + ", offset=" + num2 + ", location=" + location2 + ", includeFields=" + list + ", includeComponentTypes=" + list2 + ", platform=" + platform2 + ", verticalType=" + verticalTypes + ", expeditionType=" + expeditionTypes + ", isDarkstore=" + bool2 + ", productTag=" + str13 + ", completeQuery=" + bool3 + ", pageType=" + pageType2 + ", designVariant=" + i11 + ", searchVariant=" + i12 + ", sortingStrategy=" + i13 + ", showAgeRestrictedItems=" + z11 + ", chainId=" + num3 + ", missionControl=" + str14 + ", sort=" + str15 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FeedEndpointRequest(java.lang.String r37, java.lang.String r38, java.lang.Boolean r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.Integer r50, java.lang.Integer r51, com.talabat.darkstores.data.discovery.model.Location r52, java.util.List r53, java.util.List r54, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.Platform r55, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.VerticalTypes r56, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.ExpeditionTypes r57, java.lang.Boolean r58, java.lang.String r59, java.lang.Boolean r60, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.PageType r61, int r62, int r63, int r64, boolean r65, java.lang.Integer r66, java.lang.String r67, java.lang.String r68, int r69, kotlin.jvm.internal.DefaultConstructorMarker r70) {
        /*
            r36 = this;
            r0 = r69
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r37
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r38
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r39
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r42
        L_0x0023:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0029
            r12 = r2
            goto L_0x002b
        L_0x0029:
            r12 = r45
        L_0x002b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0031
            r13 = r2
            goto L_0x0033
        L_0x0031:
            r13 = r46
        L_0x0033:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0039
            r14 = r2
            goto L_0x003b
        L_0x0039:
            r14 = r47
        L_0x003b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0041
            r15 = r2
            goto L_0x0043
        L_0x0041:
            r15 = r48
        L_0x0043:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x004a
            r16 = r2
            goto L_0x004c
        L_0x004a:
            r16 = r49
        L_0x004c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0053
            r17 = r2
            goto L_0x0055
        L_0x0053:
            r17 = r50
        L_0x0055:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x005c
            r18 = r2
            goto L_0x005e
        L_0x005c:
            r18 = r51
        L_0x005e:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0066
            r20 = r2
            goto L_0x0068
        L_0x0066:
            r20 = r53
        L_0x0068:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0070
            r21 = r2
            goto L_0x0072
        L_0x0070:
            r21 = r54
        L_0x0072:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007a
            r22 = r2
            goto L_0x007c
        L_0x007a:
            r22 = r55
        L_0x007c:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0084
            r23 = r2
            goto L_0x0086
        L_0x0084:
            r23 = r56
        L_0x0086:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008e
            r24 = r2
            goto L_0x0090
        L_0x008e:
            r24 = r57
        L_0x0090:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0098
            r25 = r2
            goto L_0x009a
        L_0x0098:
            r25 = r58
        L_0x009a:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a2
            r26 = r2
            goto L_0x00a4
        L_0x00a2:
            r26 = r59
        L_0x00a4:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ac
            r27 = r2
            goto L_0x00ae
        L_0x00ac:
            r27 = r60
        L_0x00ae:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b6
            r28 = r2
            goto L_0x00b8
        L_0x00b6:
            r28 = r61
        L_0x00b8:
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 & r0
            r3 = 1
            if (r1 == 0) goto L_0x00c1
            r29 = r3
            goto L_0x00c3
        L_0x00c1:
            r29 = r62
        L_0x00c3:
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00cb
            r30 = r3
            goto L_0x00cd
        L_0x00cb:
            r30 = r63
        L_0x00cd:
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d6
            r1 = 0
            r31 = r1
            goto L_0x00d8
        L_0x00d6:
            r31 = r64
        L_0x00d8:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00e0
            r32 = r3
            goto L_0x00e2
        L_0x00e0:
            r32 = r65
        L_0x00e2:
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ea
            r33 = r2
            goto L_0x00ec
        L_0x00ea:
            r33 = r66
        L_0x00ec:
            r1 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00f4
            r34 = r2
            goto L_0x00f6
        L_0x00f4:
            r34 = r67
        L_0x00f6:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00fe
            r35 = r2
            goto L_0x0100
        L_0x00fe:
            r35 = r68
        L_0x0100:
            r3 = r36
            r7 = r40
            r8 = r41
            r10 = r43
            r11 = r44
            r19 = r52
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.<init>(java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, com.talabat.darkstores.data.discovery.model.Location, java.util.List, java.util.List, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$Platform, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$VerticalTypes, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$ExpeditionTypes, java.lang.Boolean, java.lang.String, java.lang.Boolean, com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$PageType, int, int, int, boolean, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
