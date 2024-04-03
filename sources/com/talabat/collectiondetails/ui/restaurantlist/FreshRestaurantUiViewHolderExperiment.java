package com.talabat.collectiondetails.ui.restaurantlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.android.material.snackbar.Snackbar;
import com.talabat.collectiondetails.R;
import com.talabat.collectiondetails.di.DaggerFreshRestaurantUiViewHolderExperimentComponent;
import com.talabat.collectiondetails.di.FreshRestaurantUiViewHolderExperimentComponent;
import com.talabat.collectiondetails.tracking.FavouriteVendorAddedRemovedEvent;
import com.talabat.collectiondetails.ui.customviews.DelayBadge;
import com.talabat.collectiondetails.ui.customviews.TStarBadge;
import com.talabat.core.experiment.data.Experiments;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.search.SearchFeatureFlagsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.RestaurantExtensionsKt;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.helpers.GlideActivityExceptionHandler;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import com.talabat.talabatcommon.views.ratings.SmallStarRatingView;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import datamodels.Restaurant;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yf.a;
import yf.b;
import yf.c;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 ¬\u00012\u00020\u0001:\u0002¬\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010~\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u0000H\u0002Jm\u0010\u0001\u001a\u000202\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012B\u0010\u0001\u001a=\u0012\u0019\u0012\u0017\u0018\u00010\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u000200\u00012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001Jv\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012B\u0010\u0001\u001a=\u0012\u0019\u0012\u0017\u0018\u00010\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u000200\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u001c\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J&\u0010 \u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010¡\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010¢\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010£\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010¤\u0001\u001a\u00020H\u0002J\u0015\u0010¥\u0001\u001a\u000202\n\b\u0001\u0010¦\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010§\u0001\u001a\u000202\b\u0010¨\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010©\u0001\u001a\u000202\b\u0010¨\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010ª\u0001\u001a\u000202\n\b\u0001\u0010«\u0001\u001a\u00030\u0001H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001a\u0010(\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u00107R\u001a\u00108\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\n\"\u0004\b:\u0010\fR\u001a\u0010;\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\fR\u001a\u0010>\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R\u001a\u0010A\u001a\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010\u0018R\u001a\u0010J\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\fR\u001a\u0010M\u001a\u00020NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR\u001a\u0010\\\u001a\u00020]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010b\u001a\u00020c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0016\"\u0004\bj\u0010\u0018R\u001a\u0010k\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\n\"\u0004\bm\u0010\fR\u001e\u0010n\u001a\u00020o8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u000e\u0010t\u001a\u00020uX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010v\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0016\"\u0004\bx\u0010\u0018R\u001a\u0010y\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\n\"\u0004\b{\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}¨\u0006­\u0001"}, d2 = {"Lcom/talabat/collectiondetails/ui/restaurantlist/FreshRestaurantUiViewHolderExperiment;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "isCard", "", "(Landroid/view/View;Z)V", "averageDeliveryTimeTextView", "Landroid/widget/TextView;", "getAverageDeliveryTimeTextView", "()Landroid/widget/TextView;", "setAverageDeliveryTimeTextView", "(Landroid/widget/TextView;)V", "cuisineTextView", "getCuisineTextView", "setCuisineTextView", "currentDeliveryFee", "getCurrentDeliveryFee", "setCurrentDeliveryFee", "dashedImage", "Landroid/widget/ImageView;", "getDashedImage", "()Landroid/widget/ImageView;", "setDashedImage", "(Landroid/widget/ImageView;)V", "delayBadge", "Lcom/talabat/collectiondetails/ui/customviews/DelayBadge;", "getDelayBadge", "()Lcom/talabat/collectiondetails/ui/customviews/DelayBadge;", "setDelayBadge", "(Lcom/talabat/collectiondetails/ui/customviews/DelayBadge;)V", "deliveryModeLabel", "getDeliveryModeLabel", "setDeliveryModeLabel", "deliveryTimeIcon", "getDeliveryTimeIcon", "setDeliveryTimeIcon", "discountPlusMore", "getDiscountPlusMore", "setDiscountPlusMore", "discountText", "getDiscountText", "setDiscountText", "favouriteButton", "Landroidx/appcompat/widget/AppCompatImageButton;", "getFavouriteButton", "()Landroidx/appcompat/widget/AppCompatImageButton;", "setFavouriteButton", "(Landroidx/appcompat/widget/AppCompatImageButton;)V", "flowContainer", "Landroidx/constraintlayout/helper/widget/Flow;", "getFlowContainer", "()Landroidx/constraintlayout/helper/widget/Flow;", "setFlowContainer", "(Landroidx/constraintlayout/helper/widget/Flow;)V", "()Z", "newTagImageView", "getNewTagImageView", "setNewTagImageView", "pickupDiscountText", "getPickupDiscountText", "setPickupDiscountText", "proTagImageView", "getProTagImageView", "setProTagImageView", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "restaurantLogoImageView", "getRestaurantLogoImageView", "setRestaurantLogoImageView", "restaurantNameTextView", "getRestaurantNameTextView", "setRestaurantNameTextView", "starRatingView", "Lcom/talabat/talabatcommon/views/ratings/SmallStarRatingView;", "getStarRatingView", "()Lcom/talabat/talabatcommon/views/ratings/SmallStarRatingView;", "setStarRatingView", "(Lcom/talabat/talabatcommon/views/ratings/SmallStarRatingView;)V", "statusContainerFrameLayout", "Landroid/widget/FrameLayout;", "getStatusContainerFrameLayout", "()Landroid/widget/FrameLayout;", "setStatusContainerFrameLayout", "(Landroid/widget/FrameLayout;)V", "statusTextView", "getStatusTextView", "setStatusTextView", "tStarBadge", "Lcom/talabat/collectiondetails/ui/customviews/TStarBadge;", "getTStarBadge", "()Lcom/talabat/collectiondetails/ui/customviews/TStarBadge;", "setTStarBadge", "(Lcom/talabat/collectiondetails/ui/customviews/TStarBadge;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "tmpImage", "getTmpImage", "setTmpImage", "tmpText", "getTmpText", "setTmpText", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "userSettingsTracker", "Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;", "vendorRateAvatar", "getVendorRateAvatar", "setVendorRateAvatar", "vendorRateStatus", "getVendorRateStatus", "setVendorRateStatus", "getView", "()Landroid/view/View;", "applyProBrandUpdate", "", "holder", "bind", "vendor", "Ldatamodels/Restaurant;", "position", "", "clickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "restaurant", "searchString", "", "bindClickListener", "bindCuisineText", "bindDelayBadge", "tgoTmpVariant", "bindDeliveryFee", "context", "Landroid/content/Context;", "bindDeliveryModeLabel", "bindDeliveryTime", "bindDeliveryTimeIcon", "bindDiscountTag", "bindFavouriteButton", "bindNewTag", "bindPickupDiscountTag", "bindPickupDistance", "bindProTag", "bindRestaurantLogo", "bindRestaurantName", "bindRestaurantRating", "bindRestaurantStatusUpdatingDeliveryTime", "bindTStarBadge", "bindTmpTag", "compileDeliveryPrice", "initDagger", "setFavouriteIcon", "resId", "setStatusInDeliveryTimeString", "statusType", "setStatusInDeliveryTimeStringPickup", "showFavouriteToast", "messageId", "Companion", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FreshRestaurantUiViewHolderExperiment extends RecyclerView.ViewHolder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int METERS_IN_KILOMETER = 1000;
    @NotNull
    private TextView averageDeliveryTimeTextView;
    @NotNull
    private TextView cuisineTextView;
    @NotNull
    private TextView currentDeliveryFee;
    @NotNull
    private ImageView dashedImage;
    @NotNull
    private DelayBadge delayBadge;
    @NotNull
    private TextView deliveryModeLabel;
    @NotNull
    private ImageView deliveryTimeIcon;
    @NotNull
    private TextView discountPlusMore;
    @NotNull
    private TextView discountText;
    @NotNull
    private AppCompatImageButton favouriteButton;
    @NotNull
    private Flow flowContainer;
    private final boolean isCard;
    @NotNull
    private TextView newTagImageView;
    @NotNull
    private TextView pickupDiscountText;
    @NotNull
    private ImageView proTagImageView;
    @NotNull
    private ProgressBar progressBar;
    @NotNull
    private ImageView restaurantLogoImageView;
    @NotNull
    private TextView restaurantNameTextView;
    @NotNull
    private SmallStarRatingView starRatingView;
    @NotNull
    private FrameLayout statusContainerFrameLayout;
    @NotNull
    private TextView statusTextView;
    @NotNull
    private TStarBadge tStarBadge;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private ImageView tmpImage;
    @NotNull
    private TextView tmpText;
    @Inject
    public TalabatTracker tracker;
    @NotNull
    private final UserSettingsTracker userSettingsTracker;
    @NotNull
    private ImageView vendorRateAvatar;
    @NotNull
    private TextView vendorRateStatus;
    @NotNull
    private final View view;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/collectiondetails/ui/restaurantlist/FreshRestaurantUiViewHolderExperiment$Companion;", "", "()V", "METERS_IN_KILOMETER", "", "getInstance", "Lcom/talabat/collectiondetails/ui/restaurantlist/FreshRestaurantUiViewHolderExperiment;", "parent", "Landroid/view/ViewGroup;", "isCard", "", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FreshRestaurantUiViewHolderExperiment getInstance$default(Companion companion, ViewGroup viewGroup, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return companion.getInstance(viewGroup, z11);
        }

        @NotNull
        public final FreshRestaurantUiViewHolderExperiment getInstance(@NotNull ViewGroup viewGroup, boolean z11) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new FreshRestaurantUiViewHolderExperiment(ViewKt.inflate(viewGroup, R.layout.item_fresh_restaurant_ui_experiment), z11);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FreshRestaurantUiViewHolderExperiment(View view2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, (i11 & 2) != 0 ? false : z11);
    }

    private final void applyProBrandUpdate(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment) {
        int i11;
        boolean booleanVariant$default = ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatFeatureFlagConstants.BRAND_UPDATES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null);
        ImageView imageView = freshRestaurantUiViewHolderExperiment.proTagImageView;
        if (booleanVariant$default) {
            i11 = com.example.talabatresources.R.drawable.bg_vendor_pro_tag_blue;
        } else {
            i11 = com.example.talabatresources.R.drawable.bg_vendor_pro_tag;
        }
        imageView.setImageResource(i11);
    }

    public static /* synthetic */ void bind$default(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, int i11, Function2 function2, String str, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str = "";
        }
        freshRestaurantUiViewHolderExperiment.bind(restaurant, i11, function2, str);
    }

    private final void bindClickListener(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, int i11, Function2<? super Restaurant, ? super Integer, Unit> function2, String str) {
        freshRestaurantUiViewHolderExperiment.itemView.setOnClickListener(new b(function2, str, restaurant, i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindClickListener$lambda-0  reason: not valid java name */
    public static final void m9571bindClickListener$lambda0(Function2 function2, String str, Restaurant restaurant, int i11, View view2) {
        Intrinsics.checkNotNullParameter(function2, "$clickListener");
        Intrinsics.checkNotNullParameter(restaurant, "$restaurant");
        if (!Intrinsics.areEqual((Object) str, (Object) "")) {
            GlobalDataModel.ShopClickOrigin = "search";
        } else if (restaurant.isRecommendation()) {
            GlobalDataModel.ShopClickOrigin = "recommended";
        } else {
            GlobalDataModel.ShopClickOrigin = DefaultCardView.CARD_LIST;
        }
        function2.invoke(restaurant, Integer.valueOf(i11));
    }

    private final void bindCuisineText(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        freshRestaurantUiViewHolderExperiment.cuisineTextView.setText(restaurant.getCuisineString());
    }

    private final void bindDelayBadge(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, int i11) {
        boolean z11;
        boolean z12 = true;
        if (i11 == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            String delayLabel = restaurant.getDelayLabel();
            if (!(delayLabel == null || delayLabel.length() == 0)) {
                z12 = false;
            }
            if (!z12) {
                DelayBadge delayBadge2 = freshRestaurantUiViewHolderExperiment.delayBadge;
                String delayLabel2 = restaurant.getDelayLabel();
                if (delayLabel2 == null) {
                    delayLabel2 = "";
                }
                delayBadge2.setLabel(delayLabel2);
                freshRestaurantUiViewHolderExperiment.delayBadge.setVisibility(0);
                return;
            }
        }
        freshRestaurantUiViewHolderExperiment.delayBadge.setVisibility(8);
    }

    private final void bindDeliveryFee(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, Context context) {
        boolean z11;
        boolean z12 = true;
        if (restaurant.isFirstOrderFree) {
            if (restaurant.getDeliveryCharges() == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(restaurant.deliveryCharges, false);
                SpannableString spannableString = new SpannableString(formattedCurrency + " " + context.getResources().getString(com.talabat.localization.R.string.free_delivery_vl));
                spannableString.setSpan(new StrikethroughSpan(), 0, formattedCurrency.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, com.talabat.marshmallow.R.color.text_base_gray)), 0, formattedCurrency.length(), 33);
                freshRestaurantUiViewHolderExperiment.currentDeliveryFee.setText(spannableString);
                return;
            }
        }
        if (restaurant.getDeliveryCharges() != 0.0f) {
            z12 = false;
        }
        if (z12) {
            freshRestaurantUiViewHolderExperiment.currentDeliveryFee.setText(context.getResources().getString(com.talabat.localization.R.string.free_delivery_vl));
        } else {
            freshRestaurantUiViewHolderExperiment.currentDeliveryFee.setText(compileDeliveryPrice(restaurant));
        }
    }

    private final void bindDeliveryModeLabel(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, int i11) {
        boolean z11;
        boolean z12 = true;
        if (i11 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            String deliveryModeLabel2 = restaurant.getDeliveryModeLabel();
            if (!(deliveryModeLabel2 == null || deliveryModeLabel2.length() == 0)) {
                z12 = false;
            }
            if (!z12) {
                freshRestaurantUiViewHolderExperiment.deliveryModeLabel.setText(restaurant.getDeliveryModeLabel());
                freshRestaurantUiViewHolderExperiment.deliveryModeLabel.setVisibility(0);
                return;
            }
        }
        freshRestaurantUiViewHolderExperiment.deliveryModeLabel.setVisibility(8);
    }

    private final void bindDeliveryTime(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, Context context) {
        String str;
        String string = context.getString(com.talabat.localization.R.string.mins_);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…alization.R.string.mins_)");
        Boolean isPickup = restaurant.isPickup();
        Intrinsics.checkNotNullExpressionValue(isPickup, "restaurant.isPickup");
        if (isPickup.booleanValue()) {
            str = context.getString(com.talabat.localization.R.string.pickup_delivery_time, new Object[]{restaurant.deliveryTimeInteger + " " + string});
        } else {
            str = restaurant.deliveryTimeInteger + " " + string;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (restaurant.isPickup)…minsString\"\n            }");
        freshRestaurantUiViewHolderExperiment.averageDeliveryTimeTextView.setText(StringsKt__StringsKt.trimStart((CharSequence) new SpannableString(str)));
    }

    private final void bindDeliveryTimeIcon(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, int i11) {
        boolean z11;
        int i12;
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || (i12 = restaurant.statusType) == 1 || i12 == 2) {
            freshRestaurantUiViewHolderExperiment.deliveryTimeIcon.setImageResource(com.designsystem.marshmallow.R.drawable.ds_time);
            return;
        }
        String deliveryTimeIcon2 = restaurant.getDeliveryTimeIcon();
        if (deliveryTimeIcon2 != null) {
            int hashCode = deliveryTimeIcon2.hashCode();
            if (hashCode != -1680910220) {
                if (hashCode != 81009) {
                    if (hashCode == 68081379 && deliveryTimeIcon2.equals("GREEN")) {
                        freshRestaurantUiViewHolderExperiment.deliveryTimeIcon.setImageResource(com.designsystem.marshmallow.R.drawable.ds_delivery_tgo);
                        return;
                    }
                } else if (deliveryTimeIcon2.equals("RED")) {
                    freshRestaurantUiViewHolderExperiment.deliveryTimeIcon.setImageResource(com.designsystem.marshmallow.R.drawable.ds_delivery_tmp_delays);
                    return;
                }
            } else if (deliveryTimeIcon2.equals("YELLOW")) {
                freshRestaurantUiViewHolderExperiment.deliveryTimeIcon.setImageResource(com.designsystem.marshmallow.R.drawable.ds_delivery_tmp);
                return;
            }
        }
        freshRestaurantUiViewHolderExperiment.deliveryTimeIcon.setImageResource(com.designsystem.marshmallow.R.drawable.ds_time);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0041, code lost:
        if ((!kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)) == true) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindDiscountTag(com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment r5, datamodels.Restaurant r6, android.content.Context r7) {
        /*
            r4 = this;
            android.widget.TextView r0 = r5.discountText
            java.lang.String r1 = r6.betterOfferText
            r0.setText(r1)
            int r0 = r6.moreOffers
            if (r0 <= 0) goto L_0x002f
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.talabat.localization.R.string.more
            java.lang.String r1 = r1.getString(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "+ "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            goto L_0x0031
        L_0x002f:
            java.lang.String r0 = ""
        L_0x0031:
            android.widget.TextView r1 = r5.discountPlusMore
            r1.setText(r0)
            java.lang.String r0 = r6.betterOfferText
            r1 = 0
            if (r0 == 0) goto L_0x0044
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            r2 = 1
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r2 = r1
        L_0x0045:
            if (r2 == 0) goto L_0x0057
            android.widget.TextView r0 = r5.discountPlusMore
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r5.dashedImage
            r0.setVisibility(r1)
            android.widget.TextView r0 = r5.discountText
            r0.setVisibility(r1)
            goto L_0x0068
        L_0x0057:
            android.widget.ImageView r0 = r5.dashedImage
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r5.discountText
            r0.setVisibility(r1)
            android.widget.TextView r0 = r5.discountPlusMore
            r0.setVisibility(r1)
        L_0x0068:
            java.lang.Boolean r6 = r6.isPickup()
            java.lang.String r0 = "restaurant.isPickup"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x007a
            int r6 = com.talabat.collectiondetails.R.drawable.ic_new_pickup_promo
            goto L_0x007c
        L_0x007a:
            int r6 = com.talabat.talabatcommon.R.drawable.ic_offer_tag_listpx
        L_0x007c:
            android.widget.TextView r5 = r5.discountText
            android.graphics.drawable.Drawable r6 = androidx.core.content.ContextCompat.getDrawable(r7, r6)
            r7 = 0
            r5.setCompoundDrawablesRelativeWithIntrinsicBounds(r6, r7, r7, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment.bindDiscountTag(com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment, datamodels.Restaurant, android.content.Context):void");
    }

    private final void bindFavouriteButton(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        boolean z11;
        int i11 = 0;
        if (!ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.ENABLE_FAVORITES_ON_VENDOR_LIST, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null) || restaurant.isPickup().booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        AppCompatImageButton appCompatImageButton = this.favouriteButton;
        if (!z11) {
            i11 = 8;
        }
        appCompatImageButton.setVisibility(i11);
        if (z11) {
            if (RestaurantExtensionsKt.isFavourite(restaurant)) {
                freshRestaurantUiViewHolderExperiment.setFavouriteIcon(R.drawable.ic_filled_heart);
            } else {
                freshRestaurantUiViewHolderExperiment.setFavouriteIcon(R.drawable.ic_empty_heart);
            }
            freshRestaurantUiViewHolderExperiment.favouriteButton.setOnClickListener(new a(restaurant, freshRestaurantUiViewHolderExperiment, this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindFavouriteButton$lambda-5  reason: not valid java name */
    public static final void m9572bindFavouriteButton$lambda5(Restaurant restaurant, FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment2, View view2) {
        Intrinsics.checkNotNullParameter(restaurant, "$restaurant");
        Intrinsics.checkNotNullParameter(freshRestaurantUiViewHolderExperiment, "$holder");
        Intrinsics.checkNotNullParameter(freshRestaurantUiViewHolderExperiment2, "this$0");
        if (RestaurantExtensionsKt.isFavourite(restaurant)) {
            freshRestaurantUiViewHolderExperiment.setFavouriteIcon(R.drawable.ic_empty_heart);
            freshRestaurantUiViewHolderExperiment.showFavouriteToast(com.talabat.localization.R.string.vl_favourite_removed);
            SharedPreferencesManager.getInstance().removeFavouriteVendorId(Integer.valueOf(restaurant.f13872id));
            freshRestaurantUiViewHolderExperiment2.getTracker().track(new FavouriteVendorAddedRemovedEvent(false, freshRestaurantUiViewHolderExperiment2.userSettingsTracker.addUserSettings(), restaurant));
            return;
        }
        freshRestaurantUiViewHolderExperiment.setFavouriteIcon(R.drawable.ic_filled_heart);
        freshRestaurantUiViewHolderExperiment.showFavouriteToast(com.talabat.localization.R.string.vl_favourite_added);
        SharedPreferencesManager.getInstance().addFavouriteVendorId(Integer.valueOf(restaurant.f13872id));
        freshRestaurantUiViewHolderExperiment2.getTracker().track(new FavouriteVendorAddedRemovedEvent(true, freshRestaurantUiViewHolderExperiment2.userSettingsTracker.addUserSettings(), restaurant));
    }

    private final void bindNewTag(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        if (restaurant.isNewRestaurant) {
            freshRestaurantUiViewHolderExperiment.newTagImageView.setVisibility(0);
        } else {
            freshRestaurantUiViewHolderExperiment.newTagImageView.setVisibility(8);
        }
    }

    private final void bindPickupDiscountTag(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        String str;
        TextView textView = freshRestaurantUiViewHolderExperiment.pickupDiscountText;
        boolean z11 = false;
        if (getTalabatFeatureFlag().getFeatureFlag(SearchFeatureFlagsKeys.SEARCH_ENABLE_PICKUP_DIFFERENTIAL_DISCOUNTS, false)) {
            str = restaurant.getPickupDiscountDisplayText();
        } else {
            str = restaurant.getPickupDiscountText();
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        }
        if (z11) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(str);
        ViewKt.invisible(freshRestaurantUiViewHolderExperiment.discountPlusMore);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindPickupDistance(com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment r6, datamodels.Restaurant r7, android.content.Context r8) {
        /*
            r5 = this;
            android.widget.TextView r6 = r6.currentDeliveryFee
            int r0 = com.talabat.talabatcommon.R.drawable.ic_location_pin
            android.graphics.drawable.Drawable r0 = r8.getDrawable(r0)
            r1 = 0
            r6.setCompoundDrawablesRelativeWithIntrinsicBounds(r0, r1, r1, r1)
            java.lang.String r6 = r7.getPickupDistanceKm()
            if (r6 == 0) goto L_0x0022
            java.lang.String r7 = "pickupDistanceKm"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.Double r6 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r6)
            if (r6 == 0) goto L_0x0022
            double r6 = r6.doubleValue()
            goto L_0x0024
        L_0x0022:
            r6 = 0
        L_0x0024:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 >= 0) goto L_0x002e
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r0 = r2
        L_0x002f:
            if (r0 == 0) goto L_0x004a
            r0 = 1000(0x3e8, float:1.401E-42)
            double r3 = (double) r0
            double r6 = r6 * r3
            int r6 = (int) r6
            android.widget.TextView r7 = r5.currentDeliveryFee
            int r0 = com.talabat.localization.R.string.pickup_distance_m_away
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r1[r2] = r6
            java.lang.String r6 = r8.getString(r0, r1)
            r7.setText(r6)
            goto L_0x005d
        L_0x004a:
            android.widget.TextView r0 = r5.currentDeliveryFee
            int r3 = com.talabat.localization.R.string.pickup_distance_km_away
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r1[r2] = r6
            java.lang.String r6 = r8.getString(r3, r1)
            r0.setText(r6)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment.bindPickupDistance(com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment, datamodels.Restaurant, android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        if (r0.isShowPro() == true) goto L_0x0010;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindProTag(com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment r4, datamodels.Restaurant r5) {
        /*
            r3 = this;
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            r1 = 0
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.isShowPro()
            r2 = 1
            if (r0 != r2) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r1
        L_0x0010:
            r0 = 8
            if (r2 == 0) goto L_0x0026
            boolean r5 = r5.isProRestaurant
            if (r5 == 0) goto L_0x0026
            r3.applyProBrandUpdate(r4)
            android.widget.ImageView r5 = r4.proTagImageView
            r5.setVisibility(r1)
            android.widget.TextView r4 = r4.newTagImageView
            r4.setVisibility(r0)
            goto L_0x002b
        L_0x0026:
            android.widget.ImageView r4 = r4.proTagImageView
            r4.setVisibility(r0)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment.bindProTag(com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment, datamodels.Restaurant):void");
    }

    private final void bindRestaurantLogo(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, Context context) {
        String str;
        freshRestaurantUiViewHolderExperiment.restaurantLogoImageView.setImageDrawable((Drawable) null);
        freshRestaurantUiViewHolderExperiment.progressBar.setVisibility(0);
        if (this.isCard) {
            str = restaurant.getTalabatCoverLogo();
        } else {
            str = restaurant.getLogo();
        }
        if (str == null) {
            freshRestaurantUiViewHolderExperiment.restaurantLogoImageView.setImageResource(0);
            freshRestaurantUiViewHolderExperiment.restaurantLogoImageView.setVisibility(0);
        } else if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(context)) {
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.getResources()");
            float applyDimension = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
            Glide.with(context).clear((View) freshRestaurantUiViewHolderExperiment.restaurantLogoImageView);
            ((RequestBuilder) ((RequestBuilder) Glide.with(context).load(str).transform((Transformation<Bitmap>) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) applyDimension)}))).listener(new FreshRestaurantUiViewHolderExperiment$bindRestaurantLogo$1(restaurant, freshRestaurantUiViewHolderExperiment)).placeholder(com.talabat.gem.adapters.R.drawable.glide_placeholder)).into(freshRestaurantUiViewHolderExperiment.restaurantLogoImageView);
        }
    }

    private final void bindRestaurantName(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        freshRestaurantUiViewHolderExperiment.restaurantNameTextView.setText(restaurant.f13873name);
        freshRestaurantUiViewHolderExperiment.restaurantNameTextView.setMaxLines(1);
        freshRestaurantUiViewHolderExperiment.restaurantNameTextView.setLines(1);
        freshRestaurantUiViewHolderExperiment.restaurantNameTextView.setSingleLine(true);
        freshRestaurantUiViewHolderExperiment.restaurantNameTextView.setEllipsize(TextUtils.TruncateAt.END);
    }

    private final void bindRestaurantRating(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        int i11 = 0;
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_STAR_RATING, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            freshRestaurantUiViewHolderExperiment.vendorRateAvatar.setVisibility(8);
            freshRestaurantUiViewHolderExperiment.vendorRateStatus.setVisibility(8);
            freshRestaurantUiViewHolderExperiment.starRatingView.setVisibility(0);
            freshRestaurantUiViewHolderExperiment.starRatingView.setRating(restaurant.getRating());
            SmallStarRatingView smallStarRatingView = freshRestaurantUiViewHolderExperiment.starRatingView;
            try {
                String totalRatingNonformatted = restaurant.getTotalRatingNonformatted();
                Intrinsics.checkNotNullExpressionValue(totalRatingNonformatted, "restaurant.getTotalRatingNonformatted()");
                i11 = Integer.parseInt(totalRatingNonformatted);
            } catch (NumberFormatException unused) {
            }
            smallStarRatingView.setReviewsAmount(i11);
            if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.SHOW_STAR_RATING_WITH_COLORS, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
                SmallStarRatingView smallStarRatingView2 = freshRestaurantUiViewHolderExperiment.starRatingView;
                int[] intArray = freshRestaurantUiViewHolderExperiment.itemView.getContext().getResources().getIntArray(com.talabat.talabatcommon.R.array.colors);
                Intrinsics.checkNotNullExpressionValue(intArray, "itemView.context.resourc…batcommon.R.array.colors)");
                smallStarRatingView2.setColors(ArraysKt___ArraysKt.toList(intArray));
                return;
            }
            freshRestaurantUiViewHolderExperiment.starRatingView.setColors(CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(ContextCompat.getColor(freshRestaurantUiViewHolderExperiment.itemView.getContext(), com.designsystem.marshmallow.R.color.ds_alert_100))));
            return;
        }
        freshRestaurantUiViewHolderExperiment.starRatingView.setVisibility(8);
        if (restaurant.getRating() <= 2.7f) {
            freshRestaurantUiViewHolderExperiment.vendorRateAvatar.setImageResource(R.drawable.ic_vendor_rate_ok_list);
            freshRestaurantUiViewHolderExperiment.vendorRateStatus.setText(com.talabat.localization.R.string.rate_fair);
        } else if (restaurant.getRating() <= 3.7f) {
            freshRestaurantUiViewHolderExperiment.vendorRateAvatar.setImageResource(R.drawable.ic_vendor_rate_good_list);
            freshRestaurantUiViewHolderExperiment.vendorRateStatus.setText(com.talabat.localization.R.string.rate_okay);
        } else if (restaurant.getRating() <= 4.5f) {
            freshRestaurantUiViewHolderExperiment.vendorRateAvatar.setImageResource(R.drawable.ic_vendor_rate_very_good_list);
            freshRestaurantUiViewHolderExperiment.vendorRateStatus.setText(com.talabat.localization.R.string.rate_very_good);
        } else {
            freshRestaurantUiViewHolderExperiment.vendorRateAvatar.setImageResource(R.drawable.ic_vendor_rate_amazing_list);
            freshRestaurantUiViewHolderExperiment.vendorRateStatus.setText(com.talabat.localization.R.string.rate_amazing);
        }
        if (restaurant.getRating() > 0.0f || !restaurant.isNewRestaurant) {
            freshRestaurantUiViewHolderExperiment.vendorRateAvatar.setVisibility(0);
            freshRestaurantUiViewHolderExperiment.vendorRateStatus.setVisibility(0);
            return;
        }
        freshRestaurantUiViewHolderExperiment.vendorRateAvatar.setVisibility(8);
        freshRestaurantUiViewHolderExperiment.vendorRateStatus.setText(com.talabat.localization.R.string.not_rated);
    }

    private final void bindRestaurantStatusUpdatingDeliveryTime(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant, Context context) {
        Boolean isPickup = restaurant.isPickup();
        Intrinsics.checkNotNullExpressionValue(isPickup, "restaurant.isPickup");
        if (isPickup.booleanValue()) {
            setStatusInDeliveryTimeStringPickup(restaurant.statusType, context);
            freshRestaurantUiViewHolderExperiment.statusContainerFrameLayout.setBackground(context.getDrawable(R.drawable.bg_pickup_vendor_status));
        } else {
            setStatusInDeliveryTimeString(restaurant.statusType, context);
            freshRestaurantUiViewHolderExperiment.statusContainerFrameLayout.setBackground(context.getDrawable(com.talabat.sdsquad.R.drawable.bg_m_vendor_status));
        }
        int i11 = restaurant.statusType;
        if (i11 == 0) {
            freshRestaurantUiViewHolderExperiment.statusContainerFrameLayout.setVisibility(8);
        } else if (i11 == 1) {
            freshRestaurantUiViewHolderExperiment.statusTextView.setText(context.getResources().getText(com.talabat.localization.R.string.closed_tgo));
            freshRestaurantUiViewHolderExperiment.statusContainerFrameLayout.setVisibility(0);
        } else if (i11 != 5) {
            freshRestaurantUiViewHolderExperiment.statusTextView.setText(context.getResources().getText(com.talabat.localization.R.string.busy_tgo));
            freshRestaurantUiViewHolderExperiment.statusContainerFrameLayout.setVisibility(0);
        } else {
            freshRestaurantUiViewHolderExperiment.statusTextView.setText(context.getResources().getText(com.talabat.localization.R.string.preorder_only));
            freshRestaurantUiViewHolderExperiment.statusContainerFrameLayout.setVisibility(0);
        }
    }

    private final void bindTStarBadge(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        if (restaurant.isTStar) {
            TStarBadge tStarBadge2 = freshRestaurantUiViewHolderExperiment.tStarBadge;
            String str = restaurant.tStarLabel;
            if (str == null) {
                str = "";
            }
            tStarBadge2.configure(str);
            freshRestaurantUiViewHolderExperiment.tStarBadge.setVisibility(0);
            return;
        }
        freshRestaurantUiViewHolderExperiment.tStarBadge.setVisibility(8);
    }

    private final void bindTmpTag(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, Restaurant restaurant) {
        freshRestaurantUiViewHolderExperiment.tmpText.setVisibility(8);
        freshRestaurantUiViewHolderExperiment.tmpImage.setVisibility(8);
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.SHOW_TMP_TAG, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            Boolean isPickup = restaurant.isPickup();
            Intrinsics.checkNotNullExpressionValue(isPickup, "restaurant.isPickup");
            if (!isPickup.booleanValue() && !restaurant.isTalabatGo) {
                freshRestaurantUiViewHolderExperiment.discountText.setVisibility(8);
                freshRestaurantUiViewHolderExperiment.discountPlusMore.setVisibility(8);
                freshRestaurantUiViewHolderExperiment.dashedImage.setVisibility(0);
                freshRestaurantUiViewHolderExperiment.tmpText.setVisibility(0);
                freshRestaurantUiViewHolderExperiment.tmpImage.setVisibility(0);
            }
        }
    }

    private final String compileDeliveryPrice(Restaurant restaurant) {
        if (restaurant.DeliveryChargestype == 1) {
            int roundToInt = MathKt__MathJVMKt.roundToInt(restaurant.deliveryCharges);
            return roundToInt + " %";
        }
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(restaurant.deliveryCharges, true);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "{\n            TalabatFor…yCharges, true)\n        }");
        return formattedCurrency;
    }

    private final void initDagger() {
        FreshRestaurantUiViewHolderExperimentComponent.Factory factory = DaggerFreshRestaurantUiViewHolderExperimentComponent.factory();
        Context context = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Context context2 = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        factory.create((TrackingCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(TrackingCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer(context2).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private final void setFavouriteIcon(@DrawableRes int i11) {
        AppCompatImageButton appCompatImageButton = this.favouriteButton;
        appCompatImageButton.setImageDrawable(ContextCompat.getDrawable(appCompatImageButton.getContext(), i11));
    }

    private final void setStatusInDeliveryTimeString(int i11, Context context) {
        this.averageDeliveryTimeTextView.setTextColor(ContextCompat.getColor(context, com.designsystem.marshmallow.R.color.ds_danger_100));
        if (i11 == 0) {
            this.averageDeliveryTimeTextView.setTextColor(ContextCompat.getColor(context, com.designsystem.marshmallow.R.color.ds_neutral_100));
        } else if (i11 == 1) {
            this.averageDeliveryTimeTextView.setText(context.getResources().getText(com.talabat.localization.R.string.closed_tgo));
        } else if (i11 == 2) {
            this.averageDeliveryTimeTextView.setText(context.getResources().getText(com.talabat.localization.R.string.busy_tgo));
        } else if (i11 == 5) {
            this.averageDeliveryTimeTextView.setText(context.getResources().getText(com.talabat.localization.R.string.preorder_status));
        }
    }

    private final void setStatusInDeliveryTimeStringPickup(int i11, Context context) {
        if (i11 == 1) {
            this.averageDeliveryTimeTextView.setText(context.getResources().getText(com.talabat.localization.R.string.closed_tgo));
        } else if (i11 == 2) {
            this.averageDeliveryTimeTextView.setText(context.getResources().getText(com.talabat.localization.R.string.busy_tgo));
        } else if (i11 == 5) {
            this.averageDeliveryTimeTextView.setText(context.getResources().getText(com.talabat.localization.R.string.preorder_status));
        }
    }

    private final void showFavouriteToast(@StringRes int i11) {
        Snackbar make = Snackbar.make(this.view, i11, -1);
        Intrinsics.checkNotNullExpressionValue(make, "make(view, messageId, Snackbar.LENGTH_SHORT)");
        make.setAction(com.talabat.localization.R.string.favourites_view_all, (View.OnClickListener) new c(this));
        make.setActionTextColor(this.view.getContext().getColor(com.designsystem.marshmallow.R.color.ds_neutral_white));
        make.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showFavouriteToast$lambda-6  reason: not valid java name */
    public static final void m9573showFavouriteToast$lambda6(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, View view2) {
        Intrinsics.checkNotNullParameter(freshRestaurantUiViewHolderExperiment, "this$0");
        Navigator.Companion companion = Navigator.Companion;
        Context context = freshRestaurantUiViewHolderExperiment.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        companion.navigate(context, new NavigatorModel("talabat.action.SQSquad.favouriteList", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
    }

    public final void bind(@NotNull Restaurant restaurant, int i11, @NotNull Function2<? super Restaurant, ? super Integer, Unit> function2, @Nullable String str) {
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        Intrinsics.checkNotNullParameter(function2, "clickListener");
        Context context = this.restaurantNameTextView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.restaurantNameTextView.context");
        int intValue = ((Number) Experiments.withSafeExperiment$default(TalabatExperimentConstants.ENABLE_TMP_TGO_DELIVERY_CHANGES, 0, (ITalabatExperiment) null, (Function1) null, 12, (Object) null)).intValue();
        bindRestaurantName(this, restaurant);
        bindDeliveryTime(this, restaurant, context);
        bindRestaurantLogo(this, restaurant, context);
        bindRestaurantStatusUpdatingDeliveryTime(this, restaurant, context);
        Boolean isPickup = restaurant.isPickup();
        Intrinsics.checkNotNullExpressionValue(isPickup, "restaurant.isPickup");
        if (isPickup.booleanValue()) {
            bindPickupDistance(this, restaurant, context);
        } else {
            bindDeliveryFee(this, restaurant, context);
        }
        bindRestaurantRating(this, restaurant);
        bindTStarBadge(this, restaurant);
        bindNewTag(this, restaurant);
        bindProTag(this, restaurant);
        bindDiscountTag(this, restaurant, context);
        bindPickupDiscountTag(this, restaurant);
        bindCuisineText(this, restaurant);
        bindClickListener(this, restaurant, i11, function2, str);
        bindTmpTag(this, restaurant);
        bindFavouriteButton(this, restaurant);
        bindDeliveryTimeIcon(this, restaurant, intValue);
        bindDeliveryModeLabel(this, restaurant, intValue);
        bindDelayBadge(this, restaurant, intValue);
    }

    @NotNull
    public final TextView getAverageDeliveryTimeTextView() {
        return this.averageDeliveryTimeTextView;
    }

    @NotNull
    public final TextView getCuisineTextView() {
        return this.cuisineTextView;
    }

    @NotNull
    public final TextView getCurrentDeliveryFee() {
        return this.currentDeliveryFee;
    }

    @NotNull
    public final ImageView getDashedImage() {
        return this.dashedImage;
    }

    @NotNull
    public final DelayBadge getDelayBadge() {
        return this.delayBadge;
    }

    @NotNull
    public final TextView getDeliveryModeLabel() {
        return this.deliveryModeLabel;
    }

    @NotNull
    public final ImageView getDeliveryTimeIcon() {
        return this.deliveryTimeIcon;
    }

    @NotNull
    public final TextView getDiscountPlusMore() {
        return this.discountPlusMore;
    }

    @NotNull
    public final TextView getDiscountText() {
        return this.discountText;
    }

    @NotNull
    public final AppCompatImageButton getFavouriteButton() {
        return this.favouriteButton;
    }

    @NotNull
    public final Flow getFlowContainer() {
        return this.flowContainer;
    }

    @NotNull
    public final TextView getNewTagImageView() {
        return this.newTagImageView;
    }

    @NotNull
    public final TextView getPickupDiscountText() {
        return this.pickupDiscountText;
    }

    @NotNull
    public final ImageView getProTagImageView() {
        return this.proTagImageView;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    @NotNull
    public final ImageView getRestaurantLogoImageView() {
        return this.restaurantLogoImageView;
    }

    @NotNull
    public final TextView getRestaurantNameTextView() {
        return this.restaurantNameTextView;
    }

    @NotNull
    public final SmallStarRatingView getStarRatingView() {
        return this.starRatingView;
    }

    @NotNull
    public final FrameLayout getStatusContainerFrameLayout() {
        return this.statusContainerFrameLayout;
    }

    @NotNull
    public final TextView getStatusTextView() {
        return this.statusTextView;
    }

    @NotNull
    public final TStarBadge getTStarBadge() {
        return this.tStarBadge;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public final ImageView getTmpImage() {
        return this.tmpImage;
    }

    @NotNull
    public final TextView getTmpText() {
        return this.tmpText;
    }

    @NotNull
    public final TalabatTracker getTracker() {
        TalabatTracker talabatTracker = this.tracker;
        if (talabatTracker != null) {
            return talabatTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    @NotNull
    public final ImageView getVendorRateAvatar() {
        return this.vendorRateAvatar;
    }

    @NotNull
    public final TextView getVendorRateStatus() {
        return this.vendorRateStatus;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public final boolean isCard() {
        return this.isCard;
    }

    public final void setAverageDeliveryTimeTextView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.averageDeliveryTimeTextView = textView;
    }

    public final void setCuisineTextView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.cuisineTextView = textView;
    }

    public final void setCurrentDeliveryFee(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.currentDeliveryFee = textView;
    }

    public final void setDashedImage(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.dashedImage = imageView;
    }

    public final void setDelayBadge(@NotNull DelayBadge delayBadge2) {
        Intrinsics.checkNotNullParameter(delayBadge2, "<set-?>");
        this.delayBadge = delayBadge2;
    }

    public final void setDeliveryModeLabel(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.deliveryModeLabel = textView;
    }

    public final void setDeliveryTimeIcon(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.deliveryTimeIcon = imageView;
    }

    public final void setDiscountPlusMore(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.discountPlusMore = textView;
    }

    public final void setDiscountText(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.discountText = textView;
    }

    public final void setFavouriteButton(@NotNull AppCompatImageButton appCompatImageButton) {
        Intrinsics.checkNotNullParameter(appCompatImageButton, "<set-?>");
        this.favouriteButton = appCompatImageButton;
    }

    public final void setFlowContainer(@NotNull Flow flow) {
        Intrinsics.checkNotNullParameter(flow, "<set-?>");
        this.flowContainer = flow;
    }

    public final void setNewTagImageView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.newTagImageView = textView;
    }

    public final void setPickupDiscountText(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.pickupDiscountText = textView;
    }

    public final void setProTagImageView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.proTagImageView = imageView;
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar2) {
        Intrinsics.checkNotNullParameter(progressBar2, "<set-?>");
        this.progressBar = progressBar2;
    }

    public final void setRestaurantLogoImageView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.restaurantLogoImageView = imageView;
    }

    public final void setRestaurantNameTextView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.restaurantNameTextView = textView;
    }

    public final void setStarRatingView(@NotNull SmallStarRatingView smallStarRatingView) {
        Intrinsics.checkNotNullParameter(smallStarRatingView, "<set-?>");
        this.starRatingView = smallStarRatingView;
    }

    public final void setStatusContainerFrameLayout(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.statusContainerFrameLayout = frameLayout;
    }

    public final void setStatusTextView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.statusTextView = textView;
    }

    public final void setTStarBadge(@NotNull TStarBadge tStarBadge2) {
        Intrinsics.checkNotNullParameter(tStarBadge2, "<set-?>");
        this.tStarBadge = tStarBadge2;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setTmpImage(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.tmpImage = imageView;
    }

    public final void setTmpText(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tmpText = textView;
    }

    public final void setTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "<set-?>");
        this.tracker = talabatTracker;
    }

    public final void setVendorRateAvatar(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.vendorRateAvatar = imageView;
    }

    public final void setVendorRateStatus(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.vendorRateStatus = textView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FreshRestaurantUiViewHolderExperiment(@NotNull View view2, boolean z11) {
        super(view2);
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        this.isCard = z11;
        this.userSettingsTracker = new UserSettingsTracker((Function0) null, 1, (DefaultConstructorMarker) null);
        initDagger();
        View findViewById = view2.findViewById(R.id.progressBar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progressBar)");
        this.progressBar = (ProgressBar) findViewById;
        View findViewById2 = view2.findViewById(R.id.imageView_restaurantLogo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.imageView_restaurantLogo)");
        this.restaurantLogoImageView = (ImageView) findViewById2;
        View findViewById3 = view2.findViewById(R.id.vendorRateStatus);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.vendorRateStatus)");
        this.vendorRateStatus = (TextView) findViewById3;
        View findViewById4 = view2.findViewById(R.id.vendorRateAvatar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.vendorRateAvatar)");
        this.vendorRateAvatar = (ImageView) findViewById4;
        View findViewById5 = view2.findViewById(R.id.textView_restaurantName);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.textView_restaurantName)");
        this.restaurantNameTextView = (TextView) findViewById5;
        View findViewById6 = view2.findViewById(R.id.textView_cuisines);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.textView_cuisines)");
        this.cuisineTextView = (TextView) findViewById6;
        View findViewById7 = view2.findViewById(R.id.imageView_newTag);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.imageView_newTag)");
        this.newTagImageView = (TextView) findViewById7;
        View findViewById8 = view2.findViewById(R.id.imageView_proTag);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.imageView_proTag)");
        this.proTagImageView = (ImageView) findViewById8;
        View findViewById9 = view2.findViewById(R.id.textView_averageDeliveryTime);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.t…View_averageDeliveryTime)");
        this.averageDeliveryTimeTextView = (TextView) findViewById9;
        View findViewById10 = view2.findViewById(R.id.frameLayout_statusContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.f…meLayout_statusContainer)");
        this.statusContainerFrameLayout = (FrameLayout) findViewById10;
        View findViewById11 = view2.findViewById(R.id.textView_status);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.textView_status)");
        this.statusTextView = (TextView) findViewById11;
        View findViewById12 = view2.findViewById(R.id.textView_deliveryFee);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.textView_deliveryFee)");
        this.currentDeliveryFee = (TextView) findViewById12;
        View findViewById13 = view2.findViewById(R.id.textView_discountTag);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.textView_discountTag)");
        this.discountText = (TextView) findViewById13;
        View findViewById14 = view2.findViewById(R.id.moreOffers);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.moreOffers)");
        this.discountPlusMore = (TextView) findViewById14;
        View findViewById15 = view2.findViewById(R.id.dashedImage);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.dashedImage)");
        this.dashedImage = (ImageView) findViewById15;
        View findViewById16 = view2.findViewById(R.id.flowContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "view.findViewById(R.id.flowContainer)");
        this.flowContainer = (Flow) findViewById16;
        View findViewById17 = view2.findViewById(R.id.textView_pickupDiscountTag);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "view.findViewById(R.id.textView_pickupDiscountTag)");
        this.pickupDiscountText = (TextView) findViewById17;
        this.flowContainer.setHorizontalBias(TalabatUtils.isRTL() ? 1.0f : 0.0f);
        View findViewById18 = view2.findViewById(R.id.starRating);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "view.findViewById(R.id.starRating)");
        this.starRatingView = (SmallStarRatingView) findViewById18;
        View findViewById19 = view2.findViewById(R.id.tmp_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "view.findViewById(R.id.tmp_icon)");
        this.tmpImage = (ImageView) findViewById19;
        View findViewById20 = view2.findViewById(R.id.textView_tmp);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "view.findViewById(R.id.textView_tmp)");
        this.tmpText = (TextView) findViewById20;
        View findViewById21 = view2.findViewById(R.id.tStarBadge);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "view.findViewById(R.id.tStarBadge)");
        this.tStarBadge = (TStarBadge) findViewById21;
        View findViewById22 = view2.findViewById(R.id.favouriteButton);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "view.findViewById(R.id.favouriteButton)");
        this.favouriteButton = (AppCompatImageButton) findViewById22;
        View findViewById23 = view2.findViewById(R.id.deliveryTimeIcon);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "view.findViewById(R.id.deliveryTimeIcon)");
        this.deliveryTimeIcon = (ImageView) findViewById23;
        View findViewById24 = view2.findViewById(R.id.deliveryModeLabel);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "view.findViewById(R.id.deliveryModeLabel)");
        this.deliveryModeLabel = (TextView) findViewById24;
        View findViewById25 = view2.findViewById(R.id.delayBadge);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "view.findViewById(R.id.delayBadge)");
        this.delayBadge = (DelayBadge) findViewById25;
    }
}
