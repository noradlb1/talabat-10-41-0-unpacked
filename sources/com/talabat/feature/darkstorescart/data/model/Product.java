package com.talabat.feature.darkstorescart.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.google.android.exoplayer2.C;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.local.CampaignTriggerConverter;
import com.talabat.feature.darkstorescart.data.local.ProductUrlListTypeConverter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Parcelize
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bñ\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0011\u001a\u00020\n\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0003\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u001e\u001a\u00020\u0013\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0003\u0010!\u001a\u00020\n\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010#\u0012\u0010\b\u0003\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010+J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\n\u0010\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\u0012\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010PJ\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010-J\n\u0010\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0001\u001a\u00020\nHÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010KJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010-Jü\u0002\u0010 \u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0003\u0010\u0012\u001a\u00020\u00132\u000e\b\u0003\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152\b\b\u0003\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0003\u0010\u001e\u001a\u00020\u00132\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0003\u0010!\u001a\u00020\n2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010#2\u0010\b\u0003\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010¡\u0001J\n\u0010¢\u0001\u001a\u00020\nHÖ\u0001J\u0016\u0010£\u0001\u001a\u00020\u00132\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001HÖ\u0003J\n\u0010¦\u0001\u001a\u00020\nHÖ\u0001J\n\u0010§\u0001\u001a\u00020\u0003HÖ\u0001J\u001e\u0010¨\u0001\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010¬\u0001\u001a\u00020\nHÖ\u0001R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R&\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00106\"\u0004\bB\u0010CR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010>\"\u0004\bE\u0010@R \u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010%\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010'\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\u001e\u0010(\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bV\u0010P\"\u0004\bW\u0010RR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010>\"\u0004\bY\u0010@R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010>\"\u0004\b[\u0010@R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00106\"\u0004\b]\u0010CR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010^\"\u0004\b_\u0010`R\u001a\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010^\"\u0004\ba\u0010`R\u001a\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010^\"\u0004\bb\u0010`R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010>\"\u0004\bd\u0010@R\u001c\u0010)\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010>\"\u0004\bf\u0010@R\u001e\u0010&\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bg\u0010P\"\u0004\bh\u0010RR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\bi\u0010-\"\u0004\bj\u0010/R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010>\"\u0004\bp\u0010@R\u001a\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00102\"\u0004\br\u00104R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00102\"\u0004\bt\u00104R$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u00106\"\u0004\bv\u0010CR\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010>\"\u0004\bx\u0010@R\u0011\u0010y\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bz\u00102R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001b\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010>\"\u0005\b\u0001\u0010@¨\u0006­\u0001"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/Product;", "Landroid/os/Parcelable;", "id", "", "name", "imageUrl", "price", "", "previousPrice", "cartCount", "", "syncedCount", "freeCount", "absoluteDiscount", "tracking", "Lcom/talabat/feature/darkstorescart/data/model/Tracking;", "vendorId", "stock", "isAvailable", "", "imageUrls", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductUrl;", "tags", "description", "appliedCampaigns", "Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "categoryId", "isFavorite", "sku", "isSponsored", "campaignTrigger", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "ageLimit", "extendedInfo", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "categoryIds", "hasBeenMarkedOOS", "predictedToBeOOS", "hasPriceChanged", "hasQuantityChanged", "offerText", "tooltipAlertText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Float;IILjava/lang/Integer;Ljava/lang/Float;Lcom/talabat/feature/darkstorescart/data/model/Tracking;Ljava/lang/String;IZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZLcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;ILcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAbsoluteDiscount", "()Ljava/lang/Float;", "setAbsoluteDiscount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getAgeLimit", "()I", "setAgeLimit", "(I)V", "getAppliedCampaigns", "()Ljava/util/List;", "getCampaignTrigger", "()Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "setCampaignTrigger", "(Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;)V", "getCartCount", "setCartCount", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "getCategoryIds", "setCategoryIds", "(Ljava/util/List;)V", "getDescription", "setDescription", "getExtendedInfo", "()Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "setExtendedInfo", "(Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;)V", "getFreeCount", "()Ljava/lang/Integer;", "setFreeCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasBeenMarkedOOS", "()Ljava/lang/Boolean;", "setHasBeenMarkedOOS", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHasPriceChanged", "setHasPriceChanged", "getHasQuantityChanged", "setHasQuantityChanged", "getId", "setId", "getImageUrl", "setImageUrl", "getImageUrls", "setImageUrls", "()Z", "setAvailable", "(Z)V", "setFavorite", "setSponsored", "getName", "setName", "getOfferText", "setOfferText", "getPredictedToBeOOS", "setPredictedToBeOOS", "getPreviousPrice", "setPreviousPrice", "getPrice", "()F", "setPrice", "(F)V", "getSku", "setSku", "getStock", "setStock", "getSyncedCount", "setSyncedCount", "getTags", "setTags", "getTooltipAlertText", "setTooltipAlertText", "totalCountWithFreeItems", "getTotalCountWithFreeItems", "getTracking", "()Lcom/talabat/feature/darkstorescart/data/model/Tracking;", "setTracking", "(Lcom/talabat/feature/darkstorescart/data/model/Tracking;)V", "getVendorId", "setVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Float;IILjava/lang/Integer;Ljava/lang/Float;Lcom/talabat/feature/darkstorescart/data/model/Tracking;Ljava/lang/String;IZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZLcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;ILcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/darkstorescart/data/model/Product;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Entity
public final class Product implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<Product> CREATOR = new Creator();
    @Nullable
    private Float absoluteDiscount;
    private int ageLimit;
    @Ignore
    @NotNull
    private final transient List<CampaignLabel> appliedCampaigns;
    @Nullable
    private CampaignTrigger campaignTrigger;
    private int cartCount;
    @NotNull
    private String categoryId;
    @Ignore
    @Nullable
    private List<String> categoryIds;
    @Nullable
    private String description;
    @Ignore
    @Nullable
    private ProductExtendedInfo extendedInfo;
    @Nullable
    private Integer freeCount;
    @Nullable
    private Boolean hasBeenMarkedOOS;
    @Nullable
    private Boolean hasPriceChanged;
    @Nullable
    private Boolean hasQuantityChanged;
    @NotNull
    @PrimaryKey

    /* renamed from: id  reason: collision with root package name */
    private String f58492id;
    @Nullable
    private String imageUrl;
    @NotNull
    private List<ProductUrl> imageUrls;
    private boolean isAvailable;
    private boolean isFavorite;
    private boolean isSponsored;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f58493name;
    @Nullable
    private String offerText;
    @Nullable
    private Boolean predictedToBeOOS;
    @Nullable
    private Float previousPrice;
    private float price;
    @NotNull
    private String sku;
    private int stock;
    private int syncedCount;
    @Ignore
    @NotNull
    private List<String> tags;
    @Nullable
    private String tooltipAlertText;
    @Ignore
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private Tracking f58494tracking;
    @NotNull
    private String vendorId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Product> {
        @NotNull
        public final Product createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Boolean bool4;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            float readFloat = parcel.readFloat();
            Float valueOf = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Float valueOf3 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Tracking createFromParcel = parcel.readInt() == 0 ? null : Tracking.CREATOR.createFromParcel(parcel2);
            String readString4 = parcel.readString();
            int readInt3 = parcel.readInt();
            boolean z11 = false;
            boolean z12 = parcel.readInt() != 0;
            int readInt4 = parcel.readInt();
            boolean z13 = z12;
            ArrayList arrayList = new ArrayList(readInt4);
            int i11 = 0;
            while (i11 != readInt4) {
                arrayList.add(ProductUrl.CREATOR.createFromParcel(parcel2));
                i11++;
                readInt4 = readInt4;
            }
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString5 = parcel.readString();
            int readInt5 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt5);
            ArrayList arrayList3 = arrayList;
            int i12 = 0;
            while (i12 != readInt5) {
                arrayList2.add(CampaignLabel.CREATOR.createFromParcel(parcel2));
                i12++;
                readInt5 = readInt5;
            }
            String readString6 = parcel.readString();
            boolean z14 = parcel.readInt() != 0;
            String readString7 = parcel.readString();
            boolean z15 = parcel.readInt() != 0;
            CampaignTrigger createFromParcel2 = parcel.readInt() == 0 ? null : CampaignTrigger.CREATOR.createFromParcel(parcel2);
            int readInt6 = parcel.readInt();
            ProductExtendedInfo createFromParcel3 = parcel.readInt() == 0 ? null : ProductExtendedInfo.CREATOR.createFromParcel(parcel2);
            ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                bool2 = null;
            } else {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                bool3 = null;
            } else {
                bool3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                bool4 = null;
            } else {
                if (parcel.readInt() != 0) {
                    z11 = true;
                }
                bool4 = Boolean.valueOf(z11);
            }
            return new Product(readString, readString2, readString3, readFloat, valueOf, readInt, readInt2, valueOf2, valueOf3, createFromParcel, readString4, readInt3, z13, arrayList3, createStringArrayList, readString5, arrayList2, readString6, z14, readString7, z15, createFromParcel2, readInt6, createFromParcel3, createStringArrayList2, bool, bool2, bool3, bool4, parcel.readString(), parcel.readString());
        }

        @NotNull
        public final Product[] newArray(int i11) {
            return new Product[i11];
        }
    }

    public Product() {
        this((String) null, (String) null, (String) null, 0.0f, (Float) null, 0, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, (CampaignTrigger) null, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, Integer.MAX_VALUE, (DefaultConstructorMarker) null);
    }

    public Product(@NotNull String str, @NotNull String str2, @Nullable @Json(name = "image_url") String str3, float f11, @Nullable Float f12, int i11, int i12, @Nullable Integer num, @Nullable Float f13, @Nullable Tracking tracking2, @NotNull @Json(name = "vendor_id") String str4, @Json(name = "stock_amount") int i13, @Json(name = "is_available") boolean z11, @NotNull @TypeConverters({ProductUrlListTypeConverter.class}) @Json(name = "image_urls") List<ProductUrl> list, @NotNull List<String> list2, @Nullable String str5, @NotNull List<CampaignLabel> list3, @NotNull @Json(name = "category_id") String str6, boolean z12, @NotNull String str7, @Json(name = "is_sponsored") boolean z13, @Nullable @TypeConverters({CampaignTriggerConverter.class}) CampaignTrigger campaignTrigger2, @Json(name = "age_limit") int i14, @Nullable @Json(name = "extended_info") ProductExtendedInfo productExtendedInfo, @Nullable @Json(name = "category_ids") List<String> list4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str8, @Nullable String str9) {
        String str10 = str4;
        List<ProductUrl> list5 = list;
        List<String> list6 = list2;
        List<CampaignLabel> list7 = list3;
        String str11 = str6;
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str10, "vendorId");
        Intrinsics.checkNotNullParameter(list5, "imageUrls");
        Intrinsics.checkNotNullParameter(list6, "tags");
        Intrinsics.checkNotNullParameter(list7, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(str11, "categoryId");
        Intrinsics.checkNotNullParameter(str12, "sku");
        this.f58492id = str;
        this.f58493name = str2;
        this.imageUrl = str3;
        this.price = f11;
        this.previousPrice = f12;
        this.cartCount = i11;
        this.syncedCount = i12;
        this.freeCount = num;
        this.absoluteDiscount = f13;
        this.f58494tracking = tracking2;
        this.vendorId = str10;
        this.stock = i13;
        this.isAvailable = z11;
        this.imageUrls = list5;
        this.tags = list6;
        this.description = str5;
        this.appliedCampaigns = list7;
        this.categoryId = str11;
        this.isFavorite = z12;
        this.sku = str12;
        this.isSponsored = z13;
        this.campaignTrigger = campaignTrigger2;
        this.ageLimit = i14;
        this.extendedInfo = productExtendedInfo;
        this.categoryIds = list4;
        this.hasBeenMarkedOOS = bool;
        this.predictedToBeOOS = bool2;
        this.hasPriceChanged = bool3;
        this.hasQuantityChanged = bool4;
        this.offerText = str8;
        this.tooltipAlertText = str9;
    }

    public static /* synthetic */ Product copy$default(Product product, String str, String str2, String str3, float f11, Float f12, int i11, int i12, Integer num, Float f13, Tracking tracking2, String str4, int i13, boolean z11, List list, List list2, String str5, List list3, String str6, boolean z12, String str7, boolean z13, CampaignTrigger campaignTrigger2, int i14, ProductExtendedInfo productExtendedInfo, List list4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str8, String str9, int i15, Object obj) {
        Product product2 = product;
        int i16 = i15;
        return product.copy((i16 & 1) != 0 ? product2.f58492id : str, (i16 & 2) != 0 ? product2.f58493name : str2, (i16 & 4) != 0 ? product2.imageUrl : str3, (i16 & 8) != 0 ? product2.price : f11, (i16 & 16) != 0 ? product2.previousPrice : f12, (i16 & 32) != 0 ? product2.cartCount : i11, (i16 & 64) != 0 ? product2.syncedCount : i12, (i16 & 128) != 0 ? product2.freeCount : num, (i16 & 256) != 0 ? product2.absoluteDiscount : f13, (i16 & 512) != 0 ? product2.f58494tracking : tracking2, (i16 & 1024) != 0 ? product2.vendorId : str4, (i16 & 2048) != 0 ? product2.stock : i13, (i16 & 4096) != 0 ? product2.isAvailable : z11, (i16 & 8192) != 0 ? product2.imageUrls : list, (i16 & 16384) != 0 ? product2.tags : list2, (i16 & 32768) != 0 ? product2.description : str5, (i16 & 65536) != 0 ? product2.appliedCampaigns : list3, (i16 & 131072) != 0 ? product2.categoryId : str6, (i16 & 262144) != 0 ? product2.isFavorite : z12, (i16 & 524288) != 0 ? product2.sku : str7, (i16 & 1048576) != 0 ? product2.isSponsored : z13, (i16 & 2097152) != 0 ? product2.campaignTrigger : campaignTrigger2, (i16 & 4194304) != 0 ? product2.ageLimit : i14, (i16 & 8388608) != 0 ? product2.extendedInfo : productExtendedInfo, (i16 & 16777216) != 0 ? product2.categoryIds : list4, (i16 & 33554432) != 0 ? product2.hasBeenMarkedOOS : bool, (i16 & 67108864) != 0 ? product2.predictedToBeOOS : bool2, (i16 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? product2.hasPriceChanged : bool3, (i16 & 268435456) != 0 ? product2.hasQuantityChanged : bool4, (i16 & 536870912) != 0 ? product2.offerText : str8, (i16 & 1073741824) != 0 ? product2.tooltipAlertText : str9);
    }

    @NotNull
    public final String component1() {
        return this.f58492id;
    }

    @Nullable
    public final Tracking component10() {
        return this.f58494tracking;
    }

    @NotNull
    public final String component11() {
        return this.vendorId;
    }

    public final int component12() {
        return this.stock;
    }

    public final boolean component13() {
        return this.isAvailable;
    }

    @NotNull
    public final List<ProductUrl> component14() {
        return this.imageUrls;
    }

    @NotNull
    public final List<String> component15() {
        return this.tags;
    }

    @Nullable
    public final String component16() {
        return this.description;
    }

    @NotNull
    public final List<CampaignLabel> component17() {
        return this.appliedCampaigns;
    }

    @NotNull
    public final String component18() {
        return this.categoryId;
    }

    public final boolean component19() {
        return this.isFavorite;
    }

    @NotNull
    public final String component2() {
        return this.f58493name;
    }

    @NotNull
    public final String component20() {
        return this.sku;
    }

    public final boolean component21() {
        return this.isSponsored;
    }

    @Nullable
    public final CampaignTrigger component22() {
        return this.campaignTrigger;
    }

    public final int component23() {
        return this.ageLimit;
    }

    @Nullable
    public final ProductExtendedInfo component24() {
        return this.extendedInfo;
    }

    @Nullable
    public final List<String> component25() {
        return this.categoryIds;
    }

    @Nullable
    public final Boolean component26() {
        return this.hasBeenMarkedOOS;
    }

    @Nullable
    public final Boolean component27() {
        return this.predictedToBeOOS;
    }

    @Nullable
    public final Boolean component28() {
        return this.hasPriceChanged;
    }

    @Nullable
    public final Boolean component29() {
        return this.hasQuantityChanged;
    }

    @Nullable
    public final String component3() {
        return this.imageUrl;
    }

    @Nullable
    public final String component30() {
        return this.offerText;
    }

    @Nullable
    public final String component31() {
        return this.tooltipAlertText;
    }

    public final float component4() {
        return this.price;
    }

    @Nullable
    public final Float component5() {
        return this.previousPrice;
    }

    public final int component6() {
        return this.cartCount;
    }

    public final int component7() {
        return this.syncedCount;
    }

    @Nullable
    public final Integer component8() {
        return this.freeCount;
    }

    @Nullable
    public final Float component9() {
        return this.absoluteDiscount;
    }

    @NotNull
    public final Product copy(@NotNull String str, @NotNull String str2, @Nullable @Json(name = "image_url") String str3, float f11, @Nullable Float f12, int i11, int i12, @Nullable Integer num, @Nullable Float f13, @Nullable Tracking tracking2, @NotNull @Json(name = "vendor_id") String str4, @Json(name = "stock_amount") int i13, @Json(name = "is_available") boolean z11, @NotNull @TypeConverters({ProductUrlListTypeConverter.class}) @Json(name = "image_urls") List<ProductUrl> list, @NotNull List<String> list2, @Nullable String str5, @NotNull List<CampaignLabel> list3, @NotNull @Json(name = "category_id") String str6, boolean z12, @NotNull String str7, @Json(name = "is_sponsored") boolean z13, @Nullable @TypeConverters({CampaignTriggerConverter.class}) CampaignTrigger campaignTrigger2, @Json(name = "age_limit") int i14, @Nullable @Json(name = "extended_info") ProductExtendedInfo productExtendedInfo, @Nullable @Json(name = "category_ids") List<String> list4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str8, @Nullable String str9) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str4, "vendorId");
        Intrinsics.checkNotNullParameter(list, "imageUrls");
        Intrinsics.checkNotNullParameter(list2, "tags");
        Intrinsics.checkNotNullParameter(list3, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(str6, "categoryId");
        Intrinsics.checkNotNullParameter(str7, "sku");
        return new Product(str10, str2, str3, f11, f12, i11, i12, num, f13, tracking2, str4, i13, z11, list, list2, str5, list3, str6, z12, str7, z13, campaignTrigger2, i14, productExtendedInfo, list4, bool, bool2, bool3, bool4, str8, str9);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return Intrinsics.areEqual((Object) this.f58492id, (Object) product.f58492id) && Intrinsics.areEqual((Object) this.f58493name, (Object) product.f58493name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) product.imageUrl) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(product.price)) && Intrinsics.areEqual((Object) this.previousPrice, (Object) product.previousPrice) && this.cartCount == product.cartCount && this.syncedCount == product.syncedCount && Intrinsics.areEqual((Object) this.freeCount, (Object) product.freeCount) && Intrinsics.areEqual((Object) this.absoluteDiscount, (Object) product.absoluteDiscount) && Intrinsics.areEqual((Object) this.f58494tracking, (Object) product.f58494tracking) && Intrinsics.areEqual((Object) this.vendorId, (Object) product.vendorId) && this.stock == product.stock && this.isAvailable == product.isAvailable && Intrinsics.areEqual((Object) this.imageUrls, (Object) product.imageUrls) && Intrinsics.areEqual((Object) this.tags, (Object) product.tags) && Intrinsics.areEqual((Object) this.description, (Object) product.description) && Intrinsics.areEqual((Object) this.appliedCampaigns, (Object) product.appliedCampaigns) && Intrinsics.areEqual((Object) this.categoryId, (Object) product.categoryId) && this.isFavorite == product.isFavorite && Intrinsics.areEqual((Object) this.sku, (Object) product.sku) && this.isSponsored == product.isSponsored && Intrinsics.areEqual((Object) this.campaignTrigger, (Object) product.campaignTrigger) && this.ageLimit == product.ageLimit && Intrinsics.areEqual((Object) this.extendedInfo, (Object) product.extendedInfo) && Intrinsics.areEqual((Object) this.categoryIds, (Object) product.categoryIds) && Intrinsics.areEqual((Object) this.hasBeenMarkedOOS, (Object) product.hasBeenMarkedOOS) && Intrinsics.areEqual((Object) this.predictedToBeOOS, (Object) product.predictedToBeOOS) && Intrinsics.areEqual((Object) this.hasPriceChanged, (Object) product.hasPriceChanged) && Intrinsics.areEqual((Object) this.hasQuantityChanged, (Object) product.hasQuantityChanged) && Intrinsics.areEqual((Object) this.offerText, (Object) product.offerText) && Intrinsics.areEqual((Object) this.tooltipAlertText, (Object) product.tooltipAlertText);
    }

    @Nullable
    public final Float getAbsoluteDiscount() {
        return this.absoluteDiscount;
    }

    public final int getAgeLimit() {
        return this.ageLimit;
    }

    @NotNull
    public final List<CampaignLabel> getAppliedCampaigns() {
        return this.appliedCampaigns;
    }

    @Nullable
    public final CampaignTrigger getCampaignTrigger() {
        return this.campaignTrigger;
    }

    public final int getCartCount() {
        return this.cartCount;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final List<String> getCategoryIds() {
        return this.categoryIds;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ProductExtendedInfo getExtendedInfo() {
        return this.extendedInfo;
    }

    @Nullable
    public final Integer getFreeCount() {
        return this.freeCount;
    }

    @Nullable
    public final Boolean getHasBeenMarkedOOS() {
        return this.hasBeenMarkedOOS;
    }

    @Nullable
    public final Boolean getHasPriceChanged() {
        return this.hasPriceChanged;
    }

    @Nullable
    public final Boolean getHasQuantityChanged() {
        return this.hasQuantityChanged;
    }

    @NotNull
    public final String getId() {
        return this.f58492id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final List<ProductUrl> getImageUrls() {
        return this.imageUrls;
    }

    @NotNull
    public final String getName() {
        return this.f58493name;
    }

    @Nullable
    public final String getOfferText() {
        return this.offerText;
    }

    @Nullable
    public final Boolean getPredictedToBeOOS() {
        return this.predictedToBeOOS;
    }

    @Nullable
    public final Float getPreviousPrice() {
        return this.previousPrice;
    }

    public final float getPrice() {
        return this.price;
    }

    @NotNull
    public final String getSku() {
        return this.sku;
    }

    public final int getStock() {
        return this.stock;
    }

    public final int getSyncedCount() {
        return this.syncedCount;
    }

    @NotNull
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getTooltipAlertText() {
        return this.tooltipAlertText;
    }

    public final int getTotalCountWithFreeItems() {
        int i11 = this.cartCount;
        Integer num = this.freeCount;
        return i11 + (num != null ? num.intValue() : 0);
    }

    @Nullable
    public final Tracking getTracking() {
        return this.f58494tracking;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((this.f58492id.hashCode() * 31) + this.f58493name.hashCode()) * 31;
        String str = this.imageUrl;
        int i11 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.floatToIntBits(this.price)) * 31;
        Float f11 = this.previousPrice;
        int hashCode3 = (((((hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31) + this.cartCount) * 31) + this.syncedCount) * 31;
        Integer num = this.freeCount;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Float f12 = this.absoluteDiscount;
        int hashCode5 = (hashCode4 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Tracking tracking2 = this.f58494tracking;
        int hashCode6 = (((((hashCode5 + (tracking2 == null ? 0 : tracking2.hashCode())) * 31) + this.vendorId.hashCode()) * 31) + this.stock) * 31;
        boolean z11 = this.isAvailable;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode7 = (((((hashCode6 + (z11 ? 1 : 0)) * 31) + this.imageUrls.hashCode()) * 31) + this.tags.hashCode()) * 31;
        String str2 = this.description;
        int hashCode8 = (((((hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.appliedCampaigns.hashCode()) * 31) + this.categoryId.hashCode()) * 31;
        boolean z13 = this.isFavorite;
        if (z13) {
            z13 = true;
        }
        int hashCode9 = (((hashCode8 + (z13 ? 1 : 0)) * 31) + this.sku.hashCode()) * 31;
        boolean z14 = this.isSponsored;
        if (!z14) {
            z12 = z14;
        }
        int i12 = (hashCode9 + (z12 ? 1 : 0)) * 31;
        CampaignTrigger campaignTrigger2 = this.campaignTrigger;
        int hashCode10 = (((i12 + (campaignTrigger2 == null ? 0 : campaignTrigger2.hashCode())) * 31) + this.ageLimit) * 31;
        ProductExtendedInfo productExtendedInfo = this.extendedInfo;
        int hashCode11 = (hashCode10 + (productExtendedInfo == null ? 0 : productExtendedInfo.hashCode())) * 31;
        List<String> list = this.categoryIds;
        int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.hasBeenMarkedOOS;
        int hashCode13 = (hashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.predictedToBeOOS;
        int hashCode14 = (hashCode13 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.hasPriceChanged;
        int hashCode15 = (hashCode14 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.hasQuantityChanged;
        int hashCode16 = (hashCode15 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str3 = this.offerText;
        int hashCode17 = (hashCode16 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tooltipAlertText;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode17 + i11;
    }

    public final boolean isAvailable() {
        return this.isAvailable;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final boolean isSponsored() {
        return this.isSponsored;
    }

    public final void setAbsoluteDiscount(@Nullable Float f11) {
        this.absoluteDiscount = f11;
    }

    public final void setAgeLimit(int i11) {
        this.ageLimit = i11;
    }

    public final void setAvailable(boolean z11) {
        this.isAvailable = z11;
    }

    public final void setCampaignTrigger(@Nullable CampaignTrigger campaignTrigger2) {
        this.campaignTrigger = campaignTrigger2;
    }

    public final void setCartCount(int i11) {
        this.cartCount = i11;
    }

    public final void setCategoryId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryId = str;
    }

    public final void setCategoryIds(@Nullable List<String> list) {
        this.categoryIds = list;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setExtendedInfo(@Nullable ProductExtendedInfo productExtendedInfo) {
        this.extendedInfo = productExtendedInfo;
    }

    public final void setFavorite(boolean z11) {
        this.isFavorite = z11;
    }

    public final void setFreeCount(@Nullable Integer num) {
        this.freeCount = num;
    }

    public final void setHasBeenMarkedOOS(@Nullable Boolean bool) {
        this.hasBeenMarkedOOS = bool;
    }

    public final void setHasPriceChanged(@Nullable Boolean bool) {
        this.hasPriceChanged = bool;
    }

    public final void setHasQuantityChanged(@Nullable Boolean bool) {
        this.hasQuantityChanged = bool;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f58492id = str;
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void setImageUrls(@NotNull List<ProductUrl> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.imageUrls = list;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f58493name = str;
    }

    public final void setOfferText(@Nullable String str) {
        this.offerText = str;
    }

    public final void setPredictedToBeOOS(@Nullable Boolean bool) {
        this.predictedToBeOOS = bool;
    }

    public final void setPreviousPrice(@Nullable Float f11) {
        this.previousPrice = f11;
    }

    public final void setPrice(float f11) {
        this.price = f11;
    }

    public final void setSku(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sku = str;
    }

    public final void setSponsored(boolean z11) {
        this.isSponsored = z11;
    }

    public final void setStock(int i11) {
        this.stock = i11;
    }

    public final void setSyncedCount(int i11) {
        this.syncedCount = i11;
    }

    public final void setTags(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tags = list;
    }

    public final void setTooltipAlertText(@Nullable String str) {
        this.tooltipAlertText = str;
    }

    public final void setTracking(@Nullable Tracking tracking2) {
        this.f58494tracking = tracking2;
    }

    public final void setVendorId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vendorId = str;
    }

    @NotNull
    public String toString() {
        String str = this.f58492id;
        String str2 = this.f58493name;
        String str3 = this.imageUrl;
        float f11 = this.price;
        Float f12 = this.previousPrice;
        int i11 = this.cartCount;
        int i12 = this.syncedCount;
        Integer num = this.freeCount;
        Float f13 = this.absoluteDiscount;
        Tracking tracking2 = this.f58494tracking;
        String str4 = this.vendorId;
        int i13 = this.stock;
        boolean z11 = this.isAvailable;
        List<ProductUrl> list = this.imageUrls;
        List<String> list2 = this.tags;
        String str5 = this.description;
        List<CampaignLabel> list3 = this.appliedCampaigns;
        String str6 = this.categoryId;
        boolean z12 = this.isFavorite;
        String str7 = this.sku;
        boolean z13 = this.isSponsored;
        CampaignTrigger campaignTrigger2 = this.campaignTrigger;
        int i14 = this.ageLimit;
        ProductExtendedInfo productExtendedInfo = this.extendedInfo;
        List<String> list4 = this.categoryIds;
        Boolean bool = this.hasBeenMarkedOOS;
        Boolean bool2 = this.predictedToBeOOS;
        Boolean bool3 = this.hasPriceChanged;
        Boolean bool4 = this.hasQuantityChanged;
        String str8 = this.offerText;
        String str9 = this.tooltipAlertText;
        return "Product(id=" + str + ", name=" + str2 + ", imageUrl=" + str3 + ", price=" + f11 + ", previousPrice=" + f12 + ", cartCount=" + i11 + ", syncedCount=" + i12 + ", freeCount=" + num + ", absoluteDiscount=" + f13 + ", tracking=" + tracking2 + ", vendorId=" + str4 + ", stock=" + i13 + ", isAvailable=" + z11 + ", imageUrls=" + list + ", tags=" + list2 + ", description=" + str5 + ", appliedCampaigns=" + list3 + ", categoryId=" + str6 + ", isFavorite=" + z12 + ", sku=" + str7 + ", isSponsored=" + z13 + ", campaignTrigger=" + campaignTrigger2 + ", ageLimit=" + i14 + ", extendedInfo=" + productExtendedInfo + ", categoryIds=" + list4 + ", hasBeenMarkedOOS=" + bool + ", predictedToBeOOS=" + bool2 + ", hasPriceChanged=" + bool3 + ", hasQuantityChanged=" + bool4 + ", offerText=" + str8 + ", tooltipAlertText=" + str9 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f58492id);
        parcel.writeString(this.f58493name);
        parcel.writeString(this.imageUrl);
        parcel.writeFloat(this.price);
        Float f11 = this.previousPrice;
        if (f11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f11.floatValue());
        }
        parcel.writeInt(this.cartCount);
        parcel.writeInt(this.syncedCount);
        Integer num = this.freeCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Float f12 = this.absoluteDiscount;
        if (f12 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f12.floatValue());
        }
        Tracking tracking2 = this.f58494tracking;
        if (tracking2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            tracking2.writeToParcel(parcel, i11);
        }
        parcel.writeString(this.vendorId);
        parcel.writeInt(this.stock);
        parcel.writeInt(this.isAvailable ? 1 : 0);
        List<ProductUrl> list = this.imageUrls;
        parcel.writeInt(list.size());
        for (ProductUrl writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        parcel.writeStringList(this.tags);
        parcel.writeString(this.description);
        List<CampaignLabel> list2 = this.appliedCampaigns;
        parcel.writeInt(list2.size());
        for (CampaignLabel writeToParcel2 : list2) {
            writeToParcel2.writeToParcel(parcel, i11);
        }
        parcel.writeString(this.categoryId);
        parcel.writeInt(this.isFavorite ? 1 : 0);
        parcel.writeString(this.sku);
        parcel.writeInt(this.isSponsored ? 1 : 0);
        CampaignTrigger campaignTrigger2 = this.campaignTrigger;
        if (campaignTrigger2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            campaignTrigger2.writeToParcel(parcel, i11);
        }
        parcel.writeInt(this.ageLimit);
        ProductExtendedInfo productExtendedInfo = this.extendedInfo;
        if (productExtendedInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            productExtendedInfo.writeToParcel(parcel, i11);
        }
        parcel.writeStringList(this.categoryIds);
        Boolean bool = this.hasBeenMarkedOOS;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.predictedToBeOOS;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.hasPriceChanged;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.hasQuantityChanged;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.offerText);
        parcel.writeString(this.tooltipAlertText);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Product(java.lang.String r33, java.lang.String r34, java.lang.String r35, float r36, java.lang.Float r37, int r38, int r39, java.lang.Integer r40, java.lang.Float r41, com.talabat.feature.darkstorescart.data.model.Tracking r42, java.lang.String r43, int r44, boolean r45, java.util.List r46, java.util.List r47, java.lang.String r48, java.util.List r49, java.lang.String r50, boolean r51, java.lang.String r52, boolean r53, com.talabat.feature.darkstorescart.data.model.CampaignTrigger r54, int r55, com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo r56, java.util.List r57, java.lang.Boolean r58, java.lang.Boolean r59, java.lang.Boolean r60, java.lang.Boolean r61, java.lang.String r62, java.lang.String r63, int r64, kotlin.jvm.internal.DefaultConstructorMarker r65) {
        /*
            r32 = this;
            r0 = r64
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r33
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r34
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = 0
            goto L_0x001c
        L_0x001a:
            r4 = r35
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r36
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r37
        L_0x002c:
            r8 = r0 & 32
            r9 = 0
            if (r8 == 0) goto L_0x0033
            r8 = r9
            goto L_0x0035
        L_0x0033:
            r8 = r38
        L_0x0035:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003b
            r10 = r9
            goto L_0x003d
        L_0x003b:
            r10 = r39
        L_0x003d:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0046
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            goto L_0x0048
        L_0x0046:
            r11 = r40
        L_0x0048:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004e
            r12 = 0
            goto L_0x0050
        L_0x004e:
            r12 = r41
        L_0x0050:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0056
            r13 = 0
            goto L_0x0058
        L_0x0056:
            r13 = r42
        L_0x0058:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0062
            java.lang.String r14 = new java.lang.String
            r14.<init>()
            goto L_0x0064
        L_0x0062:
            r14 = r43
        L_0x0064:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x006a
            r15 = r9
            goto L_0x006c
        L_0x006a:
            r15 = r44
        L_0x006c:
            r5 = r0 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0072
            r5 = 1
            goto L_0x0074
        L_0x0072:
            r5 = r45
        L_0x0074:
            r9 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x007d
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x007f
        L_0x007d:
            r9 = r46
        L_0x007f:
            r65 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x008a
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x008c
        L_0x008a:
            r2 = r47
        L_0x008c:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0096
            r16 = 0
            goto L_0x0098
        L_0x0096:
            r16 = r48
        L_0x0098:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00a3
            java.util.List r17 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x00a5
        L_0x00a3:
            r17 = r49
        L_0x00a5:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00ae
            r18 = r65
            goto L_0x00b0
        L_0x00ae:
            r18 = r50
        L_0x00b0:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b9
            r19 = 0
            goto L_0x00bb
        L_0x00b9:
            r19 = r51
        L_0x00bb:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00c4
            r20 = r65
            goto L_0x00c6
        L_0x00c4:
            r20 = r52
        L_0x00c6:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00cf
            r21 = 0
            goto L_0x00d1
        L_0x00cf:
            r21 = r53
        L_0x00d1:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00da
            r22 = 0
            goto L_0x00dc
        L_0x00da:
            r22 = r54
        L_0x00dc:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00e5
            r23 = 0
            goto L_0x00e7
        L_0x00e5:
            r23 = r55
        L_0x00e7:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00f0
            r24 = 0
            goto L_0x00f2
        L_0x00f0:
            r24 = r56
        L_0x00f2:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00fb
            r25 = 0
            goto L_0x00fd
        L_0x00fb:
            r25 = r57
        L_0x00fd:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x0106
            java.lang.Boolean r26 = java.lang.Boolean.FALSE
            goto L_0x0108
        L_0x0106:
            r26 = r58
        L_0x0108:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x0111
            java.lang.Boolean r27 = java.lang.Boolean.FALSE
            goto L_0x0113
        L_0x0111:
            r27 = r59
        L_0x0113:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x011c
            java.lang.Boolean r28 = java.lang.Boolean.FALSE
            goto L_0x011e
        L_0x011c:
            r28 = r60
        L_0x011e:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0127
            java.lang.Boolean r29 = java.lang.Boolean.FALSE
            goto L_0x0129
        L_0x0127:
            r29 = r61
        L_0x0129:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x0132
            r30 = 0
            goto L_0x0134
        L_0x0132:
            r30 = r62
        L_0x0134:
            r31 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r31
            if (r0 == 0) goto L_0x013c
            r0 = 0
            goto L_0x013e
        L_0x013c:
            r0 = r63
        L_0x013e:
            r33 = r32
            r34 = r1
            r35 = r3
            r36 = r4
            r37 = r6
            r38 = r7
            r39 = r8
            r40 = r10
            r41 = r11
            r42 = r12
            r43 = r13
            r44 = r14
            r45 = r15
            r46 = r5
            r47 = r9
            r48 = r2
            r49 = r16
            r50 = r17
            r51 = r18
            r52 = r19
            r53 = r20
            r54 = r21
            r55 = r22
            r56 = r23
            r57 = r24
            r58 = r25
            r59 = r26
            r60 = r27
            r61 = r28
            r62 = r29
            r63 = r30
            r64 = r0
            r33.<init>(r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.Product.<init>(java.lang.String, java.lang.String, java.lang.String, float, java.lang.Float, int, int, java.lang.Integer, java.lang.Float, com.talabat.feature.darkstorescart.data.model.Tracking, java.lang.String, int, boolean, java.util.List, java.util.List, java.lang.String, java.util.List, java.lang.String, boolean, java.lang.String, boolean, com.talabat.feature.darkstorescart.data.model.CampaignTrigger, int, com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo, java.util.List, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
