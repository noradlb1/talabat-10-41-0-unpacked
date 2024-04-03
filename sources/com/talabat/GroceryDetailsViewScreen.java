package com.talabat;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionBrandModel;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.request.RequestListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.materialedittext.MaterialEditText;
import com.talabat.adapters.grocery.SearchHistoryAdapter;
import com.talabat.adapters.grocery.TagsAdapter;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.designhelpers.LoadingHelper.LoadingIndicatorView;
import com.talabat.di.grocery.DaggerGroceryDetailsViewScreenComponent;
import com.talabat.dialogs.MenuImageDialog;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.helpers.TalabatBase;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import com.talabat.talabatcommon.views.titleViewMoreGridView.GridSpacingItemDecoration;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.grocerydetails.GroceryDetailsPresenter;
import library.talabat.mvp.grocerydetails.GroceryDetailsView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.a7;
import ue.b7;
import ue.c7;
import ue.d7;
import ue.e7;
import ue.f7;
import ue.g6;
import ue.g7;
import ue.h6;
import ue.h7;
import ue.i6;
import ue.i7;
import ue.j6;
import ue.j7;
import ue.k6;
import ue.l6;
import ue.m6;
import ue.n6;
import ue.o6;
import ue.p6;
import ue.q6;
import ue.r6;
import ue.s6;
import ue.t6;
import ue.u6;
import ue.v6;
import ue.w6;
import ue.x6;
import ue.y6;
import ue.z6;
import yq.a;

@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\nþ\u0001ÿ\u0001\u0002\u0002\u0002B\u0005¢\u0006\u0002\u0010\u0007J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0002J%\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020}H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\tH\u0002J\u0019\u0010\u0001\u001a\u00020H2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010{H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u0004\u0018\u00010HJ\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010 \u0001\u001a\u00030\u0001H\u0016J\t\u0010¡\u0001\u001a\u00020HH\u0016J\n\u0010¢\u0001\u001a\u00030£\u0001H\u0016J\t\u0010¤\u0001\u001a\u00020HH\u0016J\t\u0010¥\u0001\u001a\u00020HH\u0016J\u0011\u0010f\u001a\u00020H2\u0007\u0010¦\u0001\u001a\u00020\tH\u0002J\u001c\u0010§\u0001\u001a\u00030\u00012\u0007\u0010¨\u0001\u001a\u00020H2\u0007\u0010©\u0001\u001a\u00020HH\u0002J\t\u0010ª\u0001\u001a\u00020HH\u0016J\n\u0010«\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010¬\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020}H\u0002J\n\u0010­\u0001\u001a\u00030\u0001H\u0002J\t\u0010®\u0001\u001a\u00020\u0015H\u0016J\n\u0010¯\u0001\u001a\u00030\u0001H\u0016J\u0016\u0010°\u0001\u001a\u00030\u00012\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001H\u0016J#\u0010³\u0001\u001a\u00030\u00012\u0007\u0010´\u0001\u001a\u00020-2\u0007\u0010µ\u0001\u001a\u00020w2\u0007\u0010¶\u0001\u001a\u00020HJ\u0016\u0010·\u0001\u001a\u00030\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u0016\u0010º\u0001\u001a\u00030\u00012\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001H\u0016J\u0016\u0010»\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0014J-\u0010¾\u0001\u001a\u00030\u00012\u0017\u0010¿\u0001\u001a\u0012\u0012\u0004\u0012\u00020-0{j\b\u0012\u0004\u0012\u00020-`~2\b\u0010À\u0001\u001a\u00030Á\u0001H\u0016J\n\u0010Â\u0001\u001a\u00030\u0001H\u0016J\n\u0010Ã\u0001\u001a\u00030\u0001H\u0016J\u0016\u0010Ä\u0001\u001a\u00030\u00012\n\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001H\u0016J\n\u0010Ç\u0001\u001a\u00030\u0001H\u0016J\u001c\u0010È\u0001\u001a\u00030\u00012\u0007\u0010´\u0001\u001a\u00020-2\u0007\u0010É\u0001\u001a\u00020wH\u0002J\u001c\u0010Ê\u0001\u001a\u00030\u00012\u0007\u0010´\u0001\u001a\u00020-2\u0007\u0010µ\u0001\u001a\u00020wH\u0002J\u001d\u0010Ë\u0001\u001a\u00030\u00012\b\u0010Å\u0001\u001a\u00030Æ\u00012\u0007\u0010µ\u0001\u001a\u00020wH\u0002J\u0016\u0010Ë\u0001\u001a\u00030\u00012\n\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001H\u0016J\n\u0010Ì\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010Í\u0001\u001a\u00030\u00012\u0007\u0010Î\u0001\u001a\u00020SH\u0002J\u0013\u0010Ï\u0001\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020HH\u0002J\n\u0010Ð\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030\u0001H\u0016J\n\u0010Ò\u0001\u001a\u00030\u0001H\u0014J\u0013\u0010Ó\u0001\u001a\u00030\u00012\u0007\u0010Ô\u0001\u001a\u00020HH\u0016J\b\u0010Õ\u0001\u001a\u00030\u0001J\n\u0010Ö\u0001\u001a\u00030\u0001H\u0016J\n\u0010×\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010Ø\u0001\u001a\u00030\u00012\u0007\u0010Ù\u0001\u001a\u00020\u0015H\u0016J\n\u0010Ú\u0001\u001a\u00030\u0001H\u0002J4\u0010Û\u0001\u001a\u00030\u00012\u0010\u0010Ü\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ý\u0001\u0018\u00010R2\u0007\u0010Þ\u0001\u001a\u00020\u00152\u0007\u0010ß\u0001\u001a\u00020\u0015H\u0016¢\u0006\u0003\u0010à\u0001J\n\u0010á\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010â\u0001\u001a\u00030\u00012\u0007\u0010ã\u0001\u001a\u00020\u0015H\u0016J\u0014\u0010ä\u0001\u001a\u00030\u00012\b\u0010å\u0001\u001a\u00030Á\u0001H\u0016J\n\u0010æ\u0001\u001a\u00030\u0001H\u0002J\n\u0010ç\u0001\u001a\u00030\u0001H\u0002J\n\u0010è\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010é\u0001\u001a\u00030\u00012\u0007\u0010ê\u0001\u001a\u00020\u0015H\u0016J\u001c\u0010ë\u0001\u001a\u00030\u00012\u0007\u0010ê\u0001\u001a\u00020\u00152\u0007\u0010ì\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010í\u0001\u001a\u00030\u00012\u0007\u0010î\u0001\u001a\u00020\tH\u0002J\n\u0010ï\u0001\u001a\u00030\u0001H\u0016J \u0010ð\u0001\u001a\u00030\u00012\n\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u00012\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0016J\n\u0010ó\u0001\u001a\u00030\u0001H\u0002J\n\u0010ô\u0001\u001a\u00030\u0001H\u0002J\n\u0010õ\u0001\u001a\u00030\u0001H\u0016J\u001e\u0010ö\u0001\u001a\u00030\u00012\u0007\u0010÷\u0001\u001a\u00020\u00152\t\u0010ø\u0001\u001a\u0004\u0018\u00010HH\u0016J\n\u0010ù\u0001\u001a\u00030\u0001H\u0016J8\u0010ú\u0001\u001a\u00030\u00012\u0017\u0010û\u0001\u001a\u0012\u0012\u0004\u0012\u00020-0{j\b\u0012\u0004\u0012\u00020-`~2\b\u0010ü\u0001\u001a\u00030Á\u00012\t\u0010ý\u0001\u001a\u0004\u0018\u00010HH\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0018\u00010\u001dR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0014\u00104\u001a\b\u0018\u000105R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020=X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010)R\u001a\u0010G\u001a\u00020HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010)R\u000e\u0010P\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010Q\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010RX\u000e¢\u0006\u0010\n\u0002\u0010X\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00150ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u000e\u0010_\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010)R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u000b\"\u0004\br\u0010)R\u001a\u0010s\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u000b\"\u0004\bu\u0010)R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000RE\u0010z\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020}0|0{j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020}0|`~X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000b\"\u0005\b\u0001\u0010)R\u001d\u0010\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000b\"\u0005\b\u0001\u0010)¨\u0006\u0002"}, d2 = {"Lcom/talabat/GroceryDetailsViewScreen;", "Lcom/talabat/helpers/TalabatBase;", "Llibrary/talabat/mvp/grocerydetails/GroceryDetailsView;", "Llibrary/talabat/gemengine/GemView;", "Lcom/talabat/geminterfaces/OnGemAlertDialogClickListener;", "Lcom/talabat/helpers/MiniCartLayout$OnCartClickListener;", "Lcom/talabat/adapters/grocery/TagsAdapter$onTagSelectedListener;", "()V", "A_Z", "", "getA_Z", "()I", "HIGH_LOW", "getHIGH_LOW", "LOW_HIGH", "getLOW_HIGH", "RELEVANCE", "getRELEVANCE", "Z_A", "getZ_A", "allItemsForCurrentKeywordLoaded", "", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getAppVersionProvider", "()Lcom/talabat/configuration/discovery/AppVersionProvider;", "setAppVersionProvider", "(Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "brandListAdapter", "Lcom/talabat/GroceryDetailsViewScreen$BrandListAdapter;", "decremented", "getDecremented", "()Z", "setDecremented", "(Z)V", "enableSearchWithButtonClick", "getEnableSearchWithButtonClick", "setEnableSearchWithButtonClick", "firstVisibleItem", "getFirstVisibleItem", "setFirstVisibleItem", "(I)V", "gemFooter", "Lcom/talabat/GemFooterCartView;", "globalMenuItem", "Ldatamodels/MenuItem;", "groceryDetailsPresenter", "Llibrary/talabat/mvp/grocerydetails/GroceryDetailsPresenter;", "getGroceryDetailsPresenter", "()Llibrary/talabat/mvp/grocerydetails/GroceryDetailsPresenter;", "groceryDetailsPresenter$delegate", "Lkotlin/Lazy;", "itemListadapter", "Lcom/talabat/GroceryDetailsViewScreen$ItemListAdapter;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "listUpdateRequired", "loading", "mGemDialogSwitcher", "Lcom/talabat/GemDialogSwitcher;", "menuSection", "Ldatamodels/MenuSection;", "getMenuSection", "()Ldatamodels/MenuSection;", "setMenuSection", "(Ldatamodels/MenuSection;)V", "menuSectionId", "moreValuesPresent", "pageNumber", "getPageNumber", "setPageNumber", "previousBrand", "", "getPreviousBrand", "()Ljava/lang/String;", "setPreviousBrand", "(Ljava/lang/String;)V", "previousSort", "getPreviousSort", "setPreviousSort", "previousTotal", "radioButtons", "", "Landroid/widget/RadioButton;", "getRadioButtons", "()[Landroid/widget/RadioButton;", "setRadioButtons", "([Landroid/widget/RadioButton;)V", "[Landroid/widget/RadioButton;", "readyToUpdate", "Landroidx/lifecycle/MutableLiveData;", "getReadyToUpdate", "()Landroidx/lifecycle/MutableLiveData;", "setReadyToUpdate", "(Landroidx/lifecycle/MutableLiveData;)V", "reloadmenuCalled", "resetTags", "screenHeight", "searchHistoryAdapter", "Lcom/talabat/adapters/grocery/SearchHistoryAdapter;", "searchPageNumber", "selectedSort", "getSelectedSort", "setSelectedSort", "tagsAdapter", "Lcom/talabat/adapters/grocery/TagsAdapter;", "toast", "Landroid/widget/Toast;", "getToast", "()Landroid/widget/Toast;", "setToast", "(Landroid/widget/Toast;)V", "totalItemCount", "getTotalItemCount", "setTotalItemCount", "totalPages", "getTotalPages", "setTotalPages", "transitionImageView", "Landroid/widget/ImageView;", "updateRequired", "viewHeight", "visibilityControlledViews", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getVisibilityControlledViews", "()Ljava/util/ArrayList;", "setVisibilityControlledViews", "(Ljava/util/ArrayList;)V", "visibleItemCount", "getVisibleItemCount", "setVisibleItemCount", "visibleThreshold", "getVisibleThreshold", "setVisibleThreshold", "adjustSnackBar", "", "cartButtonClicked", "cartCountChanged", "createRotateAnimator", "Landroid/animation/ObjectAnimator;", "target", "from", "", "to", "destroyPresenter", "expand", "thisView", "getAllSelectedSortAndFilterCriteriaAndApply", "sortCriteria", "getChoicesString", "lstItemsChoice", "Ldatamodels/ChoiceSection;", "getContext", "Landroid/content/Context;", "getDisplayAmountForEmptyCart", "getEditText", "Landroid/widget/EditText;", "getGemContext", "getGemScreenType", "getPresenter", "Llibrary/talabat/mvp/IGlobalPresenter;", "getScreenName", "getSearchTerm", "selectedSortType", "getSortFromDescription", "sortBy", "sortOrder", "getTagNamesString", "goToCart", "hideOtherViewsExcept", "inflateGemFooter", "isRequired", "onAuthError", "onBackToRestaurantPage", "dialog", "Landroid/app/Dialog;", "onCartIconClicked", "menuItem", "imageView", "eventOrigin", "onChoiceReceived", "splitChoiceItemModel", "LJsonModels/Response/SplitRestaurantApiResponse/SplitChoiceItemModel;", "onCloseButtonClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataLoaded", "items", "pagingInfo", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "onDataLoadingError", "onError", "onItemAdded", "cartMenuItem", "Ldatamodels/CartMenuItem;", "onMaxCartItemsReached", "onMenuImageClicked", "itemImg", "onMenuItemClicked", "onNavigateToItemDetails", "onPause", "onRadioButtonClicked", "selectedRadio", "onReadyToAddItem", "onReadyToNavigatetoItemDetails", "onResume", "onStop", "onTagSelected", "tagsString", "resetTagsForSearch", "resetTagsRecyclerView", "sendGAForSearchApiCalled", "setAllItemsLoaded", "set", "setFilter", "setGroceryTags", "groceryTags", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "fromFilterOrSearch", "allItemsTagSelected", "([LJsonModels/Response/GroceryResponse/GroceryTagsModel;ZZ)V", "setHintText", "setIsUpdateRequired", "required", "setItemsCount", "sortedItemsItemsPagingInfo", "setRecyclerView", "setSort", "setTags", "showClearButton", "show", "showEmptyScreen", "isNetWorkError", "showHeaderSection", "totalItems", "showLoading", "showRestaurantChangePopup", "restaurant", "Ldatamodels/Restaurant;", "showSingleToast", "showSnackBar", "showTimeOutDialog", "showTimerView", "showTimer", "time", "stopLoading", "updateList", "menuItems", "searchPagingInfo", "query", "BrandListAdapter", "ItemListAdapter", "MenuCategoryViewHolderViewHolder", "MenuItemViewHolder", "SectionHeaderViewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsViewScreen extends TalabatBase implements GroceryDetailsView, GemView, OnGemAlertDialogClickListener, MiniCartLayout.OnCartClickListener, TagsAdapter.onTagSelectedListener {
    private final int A_Z = 4;
    private final int HIGH_LOW = 2;
    private final int LOW_HIGH = 3;
    private final int RELEVANCE = 1;
    private final int Z_A = 5;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public boolean allItemsForCurrentKeywordLoaded;
    @Inject
    public AppVersionProvider appVersionProvider;
    @Nullable
    private BrandListAdapter brandListAdapter;
    private boolean decremented;
    private boolean enableSearchWithButtonClick;
    private int firstVisibleItem;
    private GemFooterCartView gemFooter;
    @Nullable
    private MenuItem globalMenuItem;
    @NotNull
    private final Lazy groceryDetailsPresenter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new GroceryDetailsViewScreen$groceryDetailsPresenter$2(this));
    @Nullable
    private ItemListAdapter itemListadapter;
    @Nullable
    private LinearLayoutManager layoutManager;
    private boolean listUpdateRequired;
    /* access modifiers changed from: private */
    public boolean loading;
    @Nullable
    private final GemDialogSwitcher mGemDialogSwitcher;
    public MenuSection menuSection;
    private int menuSectionId;
    private boolean moreValuesPresent = true;
    private int pageNumber = 2;
    @NotNull
    private String previousBrand = "";
    private int previousSort = 1;
    private int previousTotal;
    @Nullable
    private RadioButton[] radioButtons;
    @NotNull
    private MutableLiveData<Boolean> readyToUpdate = new MutableLiveData<>();
    private boolean reloadmenuCalled;
    private boolean resetTags;
    private int screenHeight;
    @Nullable
    private SearchHistoryAdapter searchHistoryAdapter;
    /* access modifiers changed from: private */
    public int searchPageNumber = 1;
    private int selectedSort = 1;
    @Nullable
    private TagsAdapter tagsAdapter;
    @Nullable
    private Toast toast;
    private int totalItemCount;
    private int totalPages;
    @Nullable
    private ImageView transitionImageView;
    /* access modifiers changed from: private */
    public boolean updateRequired = true;
    private int viewHeight;
    @NotNull
    private ArrayList<Pair<View, View>> visibilityControlledViews = new ArrayList<>();
    private int visibleItemCount;
    private int visibleThreshold;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0005J\u0014\u0010\u001a\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/GroceryDetailsViewScreen$BrandListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/GroceryDetailsViewScreen$MenuCategoryViewHolderViewHolder;", "Lcom/talabat/GroceryDetailsViewScreen;", "brandList", "Ljava/util/ArrayList;", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionBrandModel;", "(Lcom/talabat/GroceryDetailsViewScreen;Ljava/util/ArrayList;)V", "brandIds", "", "getBrandIds", "()Ljava/util/ArrayList;", "setBrandIds", "(Ljava/util/ArrayList;)V", "getFilterString", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectedBrands", "setSelectedBrands", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class BrandListAdapter extends RecyclerView.Adapter<MenuCategoryViewHolderViewHolder> {
        @NotNull
        private ArrayList<String> brandIds = new ArrayList<>();
        @Nullable
        private final ArrayList<GroceryItemsForSectionBrandModel> brandList;

        public BrandListAdapter(@Nullable ArrayList<GroceryItemsForSectionBrandModel> arrayList) {
            this.brandList = arrayList;
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
        public static final void m9450onBindViewHolder$lambda0(MenuCategoryViewHolderViewHolder menuCategoryViewHolderViewHolder, View view) {
            Intrinsics.checkNotNullParameter(menuCategoryViewHolderViewHolder, "$holder");
            menuCategoryViewHolderViewHolder.getBrandSelectorCheckBox().setChecked(!menuCategoryViewHolderViewHolder.getBrandSelectorCheckBox().isChecked());
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
        public static final void m9451onBindViewHolder$lambda1(BrandListAdapter brandListAdapter, GroceryItemsForSectionBrandModel groceryItemsForSectionBrandModel, CompoundButton compoundButton, boolean z11) {
            Intrinsics.checkNotNullParameter(brandListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(groceryItemsForSectionBrandModel, "$item");
            if (!z11) {
                brandListAdapter.brandIds.remove(String.valueOf(groceryItemsForSectionBrandModel.getBrandId()));
            } else if (!brandListAdapter.brandIds.contains(String.valueOf(groceryItemsForSectionBrandModel.getBrandId()))) {
                brandListAdapter.brandIds.add(String.valueOf(groceryItemsForSectionBrandModel.getBrandId()));
            }
        }

        @NotNull
        public final ArrayList<String> getBrandIds() {
            return this.brandIds;
        }

        @NotNull
        public final String getFilterString() {
            boolean z11;
            if (!(!this.brandIds.isEmpty())) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = this.brandIds.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb2.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    sb2.append(",");
                }
                sb2.append(next);
            }
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
            return sb3;
        }

        public int getItemCount() {
            ArrayList<GroceryItemsForSectionBrandModel> arrayList = this.brandList;
            Intrinsics.checkNotNull(arrayList);
            return arrayList.size();
        }

        @NotNull
        public final ArrayList<String> selectedBrands() {
            return this.brandIds;
        }

        public final void setBrandIds(@NotNull ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.brandIds = arrayList;
        }

        public final void setSelectedBrands(@NotNull ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "brandIds");
            if (!this.brandIds.isEmpty()) {
                this.brandIds.clear();
            }
            this.brandIds.addAll(arrayList);
        }

        public void onBindViewHolder(@NotNull MenuCategoryViewHolderViewHolder menuCategoryViewHolderViewHolder, int i11) {
            Intrinsics.checkNotNullParameter(menuCategoryViewHolderViewHolder, "holder");
            ArrayList<GroceryItemsForSectionBrandModel> arrayList = this.brandList;
            Intrinsics.checkNotNull(arrayList);
            GroceryItemsForSectionBrandModel groceryItemsForSectionBrandModel = arrayList.get(i11);
            Intrinsics.checkNotNullExpressionValue(groceryItemsForSectionBrandModel, "brandList!![position]");
            GroceryItemsForSectionBrandModel groceryItemsForSectionBrandModel2 = groceryItemsForSectionBrandModel;
            menuCategoryViewHolderViewHolder.getBrandName().setText(StringsKt__StringsKt.trim((CharSequence) groceryItemsForSectionBrandModel2.getBrandName()).toString());
            menuCategoryViewHolderViewHolder.getParentView().setOnClickListener(new i7(menuCategoryViewHolderViewHolder));
            menuCategoryViewHolderViewHolder.getBrandSelectorCheckBox().setChecked(this.brandIds.isEmpty() ^ true ? this.brandIds.contains(String.valueOf(groceryItemsForSectionBrandModel2.getBrandId())) : false);
            menuCategoryViewHolderViewHolder.getBrandSelectorCheckBox().setOnCheckedChangeListener(new j7(this, groceryItemsForSectionBrandModel2));
        }

        @NotNull
        public MenuCategoryViewHolderViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grocery_brand_row, viewGroup, false);
            GroceryDetailsViewScreen groceryDetailsViewScreen = GroceryDetailsViewScreen.this;
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new MenuCategoryViewHolderViewHolder(groceryDetailsViewScreen, inflate);
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J(\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bH\u0016J(\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010&\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006("}, d2 = {"Lcom/talabat/GroceryDetailsViewScreen$ItemListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "_groceryContinuousMenuListModel", "Ljava/util/ArrayList;", "Ldatamodels/MenuItem;", "Lkotlin/collections/ArrayList;", "(Lcom/talabat/GroceryDetailsViewScreen;Ljava/util/ArrayList;)V", "groceryContinuousMenuListModel", "getGroceryContinuousMenuListModel", "()Ljava/util/ArrayList;", "setGroceryContinuousMenuListModel", "(Ljava/util/ArrayList;)V", "decreaseQuantity", "", "menuItem", "quantitySection", "Landroid/view/View;", "addButton", "Landroid/widget/Button;", "quantityText", "Landroid/widget/TextView;", "getDataList", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "getItemViewType", "position", "increaseQuantity", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCount", "setMenu", "menuItems", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ItemListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
        @NotNull
        private ArrayList<MenuItem> groceryContinuousMenuListModel;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ GroceryDetailsViewScreen f54099i;

        public ItemListAdapter(@NotNull GroceryDetailsViewScreen groceryDetailsViewScreen, ArrayList<MenuItem> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "_groceryContinuousMenuListModel");
            this.f54099i = groceryDetailsViewScreen;
            this.groceryContinuousMenuListModel = arrayList;
        }

        private final void decreaseQuantity(MenuItem menuItem, View view, Button button, TextView textView) {
            CartMenuItem cartMenuItem;
            Cart instance = Cart.getInstance();
            CartMenuItem cartMenuItem2 = new CartMenuItem();
            Iterator<CartMenuItem> it = instance.getCartItems().iterator();
            loop0:
            while (true) {
                cartMenuItem = cartMenuItem2;
                while (it.hasNext()) {
                    cartMenuItem2 = it.next();
                    if (menuItem.f13861id == cartMenuItem2.f13861id) {
                        Intrinsics.checkNotNullExpressionValue(cartMenuItem2, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
                        cartMenuItem2.setQuantity(cartMenuItem2.getQuantity() - 1);
                        int quantity = cartMenuItem2.getQuantity();
                        if (quantity < 1) {
                            view.setVisibility(8);
                            button.setVisibility(0);
                        } else {
                            textView.setText(String.valueOf(quantity));
                        }
                    }
                }
                break loop0;
            }
            if (cartMenuItem.f13861id > 0) {
                instance.decreaseItemQuantity(cartMenuItem, this.f54099i);
                AppTracker.onItemRemovedFromCart(this.f54099i, Cart.getInstance().getRestaurant(), cartMenuItem, "menu_decrease", ScreenNames.getScreenType(this.f54099i.getScreenName()), this.f54099i.getScreenName());
                this.f54099i.cartCountChanged();
            }
        }

        private final void increaseQuantity(MenuItem menuItem, View view, Button button, TextView textView) {
            String str;
            Cart instance = Cart.getInstance();
            CartMenuItem cartMenuItem = new CartMenuItem();
            Iterator<CartMenuItem> it = instance.getCartItems().iterator();
            CartMenuItem cartMenuItem2 = cartMenuItem;
            boolean z11 = false;
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (menuItem.f13861id == next.f13861id) {
                    Intrinsics.checkNotNullExpressionValue(next, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
                    int quantity = next.getQuantity();
                    if (instance.getCartItemQuantity(next) < 100) {
                        next.setQuantity(quantity + 1);
                        textView.setText(String.valueOf(next.getQuantity()));
                        z11 = false;
                        cartMenuItem2 = next;
                    } else {
                        TextView textView2 = textView;
                        cartMenuItem2 = next;
                        z11 = true;
                    }
                } else {
                    TextView textView3 = textView;
                }
            }
            if (z11) {
                this.f54099i.onMaxCartItemsReached();
            } else if (cartMenuItem2.f13861id > 0) {
                instance.increaseItemQuantity(cartMenuItem2, this.f54099i);
                ArrayList<ChoiceSection> arrayList = cartMenuItem2.selectedChoices;
                if (arrayList != null) {
                    GroceryDetailsViewScreen groceryDetailsViewScreen = this.f54099i;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "cartMenuItemToModify.selectedChoices");
                    str = groceryDetailsViewScreen.getChoicesString(arrayList);
                } else {
                    str = "";
                }
                AppTracker.onItemAddedToCart(this.f54099i, Cart.getInstance().getRestaurant(), cartMenuItem2, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant), "menu_increase", str, cartMenuItem2.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], cartMenuItem2.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(this.f54099i.getScreenName()), this.f54099i.getScreenName());
                this.f54099i.cartCountChanged();
                this.f54099i.showSingleToast();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-6$lambda-1  reason: not valid java name */
        public static final void m9452onBindViewHolder$lambda6$lambda1(GroceryDetailsViewScreen groceryDetailsViewScreen, MenuItem menuItem, RecyclerView.ViewHolder viewHolder, View view) {
            Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
            Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
            Intrinsics.checkNotNullParameter(viewHolder, "$holder");
            groceryDetailsViewScreen.onMenuItemClicked(menuItem, ((MenuItemViewHolder) viewHolder).getItemImg());
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-6$lambda-2  reason: not valid java name */
        public static final void m9453onBindViewHolder$lambda6$lambda2(RecyclerView.ViewHolder viewHolder, GroceryDetailsViewScreen groceryDetailsViewScreen, MenuItem menuItem, View view) {
            Drawable.ConstantState constantState;
            Intrinsics.checkNotNullParameter(viewHolder, "$holder");
            Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
            Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
            try {
                if (((MenuItemViewHolder) viewHolder).getItemImg().getDrawable() != null) {
                    Drawable drawable = ((MenuItemViewHolder) viewHolder).getItemImg().getDrawable();
                    Intrinsics.checkNotNull(drawable);
                    if (drawable.getConstantState() != null) {
                        Drawable drawable2 = ContextCompat.getDrawable(groceryDetailsViewScreen.getContext(), R.drawable.bg_m_grocery_placeholder);
                        Drawable.ConstantState constantState2 = null;
                        if (drawable2 != null) {
                            constantState = drawable2.getConstantState();
                        } else {
                            constantState = null;
                        }
                        if (constantState != null) {
                            Drawable drawable3 = ((MenuItemViewHolder) viewHolder).getItemImg().getDrawable();
                            Intrinsics.checkNotNull(drawable3);
                            Drawable.ConstantState constantState3 = drawable3.getConstantState();
                            Drawable drawable4 = ContextCompat.getDrawable(groceryDetailsViewScreen.getContext(), R.drawable.bg_m_grocery_placeholder);
                            if (drawable4 != null) {
                                constantState2 = drawable4.getConstantState();
                            }
                            if (!Intrinsics.areEqual((Object) constantState3, (Object) constantState2)) {
                                groceryDetailsViewScreen.onMenuImageClicked(menuItem, ((MenuItemViewHolder) viewHolder).getItemImg());
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-6$lambda-3  reason: not valid java name */
        public static final void m9454onBindViewHolder$lambda6$lambda3(GroceryDetailsViewScreen groceryDetailsViewScreen, MenuItem menuItem, RecyclerView.ViewHolder viewHolder, ItemListAdapter itemListAdapter, View view) {
            Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
            Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
            Intrinsics.checkNotNullParameter(viewHolder, "$holder");
            Intrinsics.checkNotNullParameter(itemListAdapter, "$this_run");
            MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) viewHolder;
            groceryDetailsViewScreen.onCartIconClicked(menuItem, menuItemViewHolder.getItemImg(), "menu_normal");
            if (GlobalDataModel.MENU.isQuickAddEnabled) {
                itemListAdapter.setCount(menuItem, menuItemViewHolder.getQuantitySection(), menuItemViewHolder.getAddButton(), menuItemViewHolder.getQuantityText());
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-6$lambda-4  reason: not valid java name */
        public static final void m9455onBindViewHolder$lambda6$lambda4(MenuItem menuItem, GroceryDetailsViewScreen groceryDetailsViewScreen, ItemListAdapter itemListAdapter, RecyclerView.ViewHolder viewHolder, View view) {
            boolean z11;
            Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
            Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
            Intrinsics.checkNotNullParameter(itemListAdapter, "$this_run");
            Intrinsics.checkNotNullParameter(viewHolder, "$holder");
            ChoiceSection[] choiceSectionArr = menuItem.choiceSections;
            Intrinsics.checkNotNullExpressionValue(choiceSectionArr, "menuItem.choiceSections");
            if (choiceSectionArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((!z11) || menuItem.willHaveChoices()) {
                groceryDetailsViewScreen.goToCart();
                return;
            }
            MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) viewHolder;
            itemListAdapter.decreaseQuantity(menuItem, menuItemViewHolder.getQuantitySection(), menuItemViewHolder.getAddButton(), menuItemViewHolder.getQuantityText());
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-6$lambda-5  reason: not valid java name */
        public static final void m9456onBindViewHolder$lambda6$lambda5(MenuItem menuItem, GroceryDetailsViewScreen groceryDetailsViewScreen, RecyclerView.ViewHolder viewHolder, ItemListAdapter itemListAdapter, View view) {
            boolean z11;
            Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
            Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
            Intrinsics.checkNotNullParameter(viewHolder, "$holder");
            Intrinsics.checkNotNullParameter(itemListAdapter, "$this_run");
            ChoiceSection[] choiceSectionArr = menuItem.choiceSections;
            Intrinsics.checkNotNullExpressionValue(choiceSectionArr, "menuItem.choiceSections");
            if (choiceSectionArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((!z11) || menuItem.willHaveChoices()) {
                groceryDetailsViewScreen.onCartIconClicked(menuItem, ((MenuItemViewHolder) viewHolder).getItemImg(), "menu_increase");
                return;
            }
            MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) viewHolder;
            itemListAdapter.increaseQuantity(menuItem, menuItemViewHolder.getQuantitySection(), menuItemViewHolder.getAddButton(), menuItemViewHolder.getQuantityText());
        }

        private final void setCount(MenuItem menuItem, View view, Button button, TextView textView) {
            if (!Cart.getInstance().hasItems()) {
                view.setVisibility(8);
                button.setVisibility(0);
                return;
            }
            Iterator<CartMenuItem> it = Cart.getInstance().getCartItems().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (Intrinsics.areEqual((Object) menuItem.f13862name, (Object) next.f13862name) && menuItem.f13861id == next.f13861id) {
                    i11 += next.getQuantity();
                }
            }
            if (i11 > 0) {
                view.setVisibility(0);
                button.setVisibility(8);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i11);
                textView.setText(sb2.toString());
                return;
            }
            view.setVisibility(8);
            button.setVisibility(0);
        }

        @NotNull
        public final ArrayList<MenuItem> getDataList() {
            return this.groceryContinuousMenuListModel;
        }

        @NotNull
        public Filter getFilter() {
            return new GroceryDetailsViewScreen$ItemListAdapter$getFilter$1(this.f54099i, this);
        }

        @NotNull
        public final ArrayList<MenuItem> getGroceryContinuousMenuListModel() {
            return this.groceryContinuousMenuListModel;
        }

        public int getItemCount() {
            return this.groceryContinuousMenuListModel.size();
        }

        public int getItemViewType(int i11) {
            return 2;
        }

        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            if (viewHolder instanceof MenuItemViewHolder) {
                GroceryDetailsViewScreen groceryDetailsViewScreen = this.f54099i;
                viewHolder.setIsRecyclable(false);
                MenuItem menuItem = this.groceryContinuousMenuListModel.get(i11);
                Intrinsics.checkNotNullExpressionValue(menuItem, "this@ItemListAdapter.gro…nuListModel.get(position)");
                MenuItem menuItem2 = menuItem;
                MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) viewHolder;
                menuItemViewHolder.getLoadingIndicator().show();
                menuItemViewHolder.getName().setText(menuItem2.f13862name);
                if (Intrinsics.areEqual((Object) menuItem2.desc, (Object) "")) {
                    menuItemViewHolder.getDescription().setVisibility(8);
                } else {
                    menuItemViewHolder.getDescription().setText(menuItem2.desc);
                    menuItemViewHolder.getDescription().setVisibility(8);
                }
                if (menuItem2.isPromotional) {
                    menuItemViewHolder.getDescountIc().setVisibility(0);
                } else {
                    menuItemViewHolder.getDescountIc().setVisibility(8);
                }
                if (Intrinsics.areEqual((Object) menuItem2.getDisplayPrice(), (Object) "0")) {
                    menuItemViewHolder.getPriceExtraInfo().setVisibility(0);
                    menuItemViewHolder.getPriceExtraInfo().setText(groceryDetailsViewScreen.getString(R.string.price_based_on_selection));
                    menuItemViewHolder.getPriceView().setVisibility(8);
                    menuItemViewHolder.getPriceBefore().setVisibility(8);
                } else {
                    menuItemViewHolder.getPriceExtraInfo().setVisibility(8);
                    menuItemViewHolder.getPriceView().setVisibility(0);
                    menuItemViewHolder.getPrice().setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem2.price, true));
                    menuItemViewHolder.getPriceBefore().setVisibility(8);
                    if (menuItem2.isDiscounted()) {
                        if (Integration.isGemActive()) {
                            menuItemViewHolder.getPriceBefore().setVisibility(8);
                            menuItemViewHolder.getPrice().setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem2.oldPrice, true));
                        } else {
                            menuItemViewHolder.getPriceBefore().setVisibility(0);
                            menuItemViewHolder.getPriceBefore().setText(menuItem2.getDisplayOldPriceNonFormatted());
                            menuItemViewHolder.getPriceBefore().setPaintFlags(menuItemViewHolder.getPriceExtraInfo().getPaintFlags() | 16);
                        }
                    }
                }
                menuItemViewHolder.getPriceView().setTag(Integer.valueOf(i11));
                menuItemViewHolder.getWholeCell().setOnClickListener(new b(groceryDetailsViewScreen, menuItem2, viewHolder));
                if (menuItem2.hasThumbnail) {
                    menuItemViewHolder.getItemImg().setOnClickListener(new c(viewHolder, groceryDetailsViewScreen, menuItem2));
                    if (groceryDetailsViewScreen.isValidContextForGlide(groceryDetailsViewScreen)) {
                        GlideApp.with((FragmentActivity) groceryDetailsViewScreen).clear((View) menuItemViewHolder.getItemImg());
                        GlideApp.with((FragmentActivity) groceryDetailsViewScreen).load(menuItem2.getThumbnail()).centerInside().error((int) R.drawable.bg_m_grocery_placeholder).fallback((int) R.drawable.bg_m_grocery_placeholder).placeholder((int) R.drawable.bg_m_grocery_placeholder).listener((RequestListener) new GroceryDetailsViewScreen$ItemListAdapter$onBindViewHolder$1$3(viewHolder)).into(menuItemViewHolder.getItemImg());
                    }
                } else {
                    menuItemViewHolder.getItemImg().setImageResource(R.drawable.bg_m_grocery_placeholder);
                    menuItemViewHolder.getProgress().setVisibility(8);
                    menuItemViewHolder.getItemImg().setVisibility(0);
                }
                if (GlobalDataModel.MENU.isQuickAddEnabled) {
                    setCount(menuItem2, menuItemViewHolder.getQuantitySection(), menuItemViewHolder.getAddButton(), menuItemViewHolder.getQuantityText());
                }
                menuItemViewHolder.getAddButton().setOnClickListener(new d(groceryDetailsViewScreen, menuItem2, viewHolder, this));
                menuItemViewHolder.getDecreaseQuantity().setOnClickListener(new e(menuItem2, groceryDetailsViewScreen, this, viewHolder));
                menuItemViewHolder.getIncreaseQuantity().setOnClickListener(new f(menuItem2, groceryDetailsViewScreen, viewHolder, this));
            }
        }

        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
            MenuItemViewHolder menuItemViewHolder;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            if (i11 == 2) {
                GroceryDetailsViewScreen groceryDetailsViewScreen = this.f54099i;
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grocery_grid_view_item, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "childView");
                menuItemViewHolder = new MenuItemViewHolder(groceryDetailsViewScreen, inflate);
            } else {
                menuItemViewHolder = null;
            }
            Intrinsics.checkNotNull(menuItemViewHolder);
            return menuItemViewHolder;
        }

        public final void setGroceryContinuousMenuListModel(@NotNull ArrayList<MenuItem> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.groceryContinuousMenuListModel = arrayList;
        }

        public final void setMenu(@NotNull ArrayList<MenuItem> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "menuItems");
            if (this.groceryContinuousMenuListModel.size() > 0) {
                this.groceryContinuousMenuListModel.clear();
            }
            this.groceryContinuousMenuListModel.addAll(arrayList);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/GroceryDetailsViewScreen$MenuCategoryViewHolderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/talabat/GroceryDetailsViewScreen;Landroid/view/View;)V", "brandName", "Landroid/widget/TextView;", "getBrandName", "()Landroid/widget/TextView;", "setBrandName", "(Landroid/widget/TextView;)V", "brandSelectorCheckBox", "Landroidx/appcompat/widget/AppCompatCheckBox;", "getBrandSelectorCheckBox", "()Landroidx/appcompat/widget/AppCompatCheckBox;", "setBrandSelectorCheckBox", "(Landroidx/appcompat/widget/AppCompatCheckBox;)V", "parentView", "getParentView", "()Landroid/view/View;", "setParentView", "(Landroid/view/View;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class MenuCategoryViewHolderViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private TextView brandName;
        @NotNull
        private AppCompatCheckBox brandSelectorCheckBox;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ GroceryDetailsViewScreen f54103h;
        @NotNull
        private View parentView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MenuCategoryViewHolderViewHolder(@NotNull GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f54103h = groceryDetailsViewScreen;
            View findViewById = view.findViewById(R.id.parent_row_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.parent_row_view)");
            this.parentView = findViewById;
            View findViewById2 = view.findViewById(R.id.brand_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.brand_title)");
            this.brandName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.brand_checkbox);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.brand_checkbox)");
            this.brandSelectorCheckBox = (AppCompatCheckBox) findViewById3;
        }

        @NotNull
        public final TextView getBrandName() {
            return this.brandName;
        }

        @NotNull
        public final AppCompatCheckBox getBrandSelectorCheckBox() {
            return this.brandSelectorCheckBox;
        }

        @NotNull
        public final View getParentView() {
            return this.parentView;
        }

        public final void setBrandName(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.brandName = textView;
        }

        public final void setBrandSelectorCheckBox(@NotNull AppCompatCheckBox appCompatCheckBox) {
            Intrinsics.checkNotNullParameter(appCompatCheckBox, "<set-?>");
            this.brandSelectorCheckBox = appCompatCheckBox;
        }

        public final void setParentView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.parentView = view;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010.\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001a\u00101\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001a\u00104\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001a\u00107\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR\u001a\u0010:\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR\u001a\u0010C\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR\u001a\u0010F\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\r\"\u0004\bH\u0010\u000f¨\u0006I"}, d2 = {"Lcom/talabat/GroceryDetailsViewScreen$MenuItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/talabat/GroceryDetailsViewScreen;Landroid/view/View;)V", "addButton", "Lcom/talabat/TalabatButton;", "getAddButton", "()Lcom/talabat/TalabatButton;", "setAddButton", "(Lcom/talabat/TalabatButton;)V", "decreaseQuantity", "getDecreaseQuantity", "()Landroid/view/View;", "setDecreaseQuantity", "(Landroid/view/View;)V", "descountIc", "Landroid/widget/RelativeLayout;", "getDescountIc", "()Landroid/widget/RelativeLayout;", "setDescountIc", "(Landroid/widget/RelativeLayout;)V", "description", "Landroid/widget/TextView;", "getDescription", "()Landroid/widget/TextView;", "setDescription", "(Landroid/widget/TextView;)V", "increaseQuantity", "getIncreaseQuantity", "setIncreaseQuantity", "itemImg", "Landroid/widget/ImageView;", "getItemImg", "()Landroid/widget/ImageView;", "setItemImg", "(Landroid/widget/ImageView;)V", "loadingIndicator", "Lcom/talabat/designhelpers/LoadingHelper/LoadingIndicatorView;", "getLoadingIndicator", "()Lcom/talabat/designhelpers/LoadingHelper/LoadingIndicatorView;", "setLoadingIndicator", "(Lcom/talabat/designhelpers/LoadingHelper/LoadingIndicatorView;)V", "name", "getName", "setName", "price", "getPrice", "setPrice", "priceBefore", "getPriceBefore", "setPriceBefore", "priceExtraInfo", "getPriceExtraInfo", "setPriceExtraInfo", "priceView", "getPriceView", "setPriceView", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "quantitySection", "getQuantitySection", "setQuantitySection", "quantityText", "getQuantityText", "setQuantityText", "wholeCell", "getWholeCell", "setWholeCell", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class MenuItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private TalabatButton addButton;
        @NotNull
        private View decreaseQuantity;
        @NotNull
        private RelativeLayout descountIc;
        @NotNull
        private TextView description;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ GroceryDetailsViewScreen f54104h;
        @NotNull
        private View increaseQuantity;
        @NotNull
        private ImageView itemImg;
        @NotNull
        private LoadingIndicatorView loadingIndicator;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private TextView f54105name;
        @NotNull
        private TextView price;
        @NotNull
        private TextView priceBefore;
        @NotNull
        private TextView priceExtraInfo;
        @NotNull
        private View priceView;
        @NotNull
        private ProgressBar progress;
        @NotNull
        private View quantitySection;
        @NotNull
        private TextView quantityText;
        @NotNull
        private View wholeCell;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MenuItemViewHolder(@NotNull GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f54104h = groceryDetailsViewScreen;
            View findViewById = view.findViewById(R.id.itemName);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.itemName)");
            this.f54105name = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.itemDescription);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.itemDescription)");
            this.description = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.itemPrice);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.itemPrice)");
            this.price = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.itemImg);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.itemImg)");
            this.itemImg = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.progress);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.progress)");
            this.progress = (ProgressBar) findViewById5;
            View findViewById6 = view.findViewById(R.id.discountIc);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.discountIc)");
            this.descountIc = (RelativeLayout) findViewById6;
            View findViewById7 = view.findViewById(R.id.priceExtraInfo);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.priceExtraInfo)");
            this.priceExtraInfo = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.price_view);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.price_view)");
            this.priceView = findViewById8;
            View findViewById9 = view.findViewById(R.id.priceBefore);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.priceBefore)");
            this.priceBefore = (TextView) findViewById9;
            View findViewById10 = view.findViewById(R.id.loading_price);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.loading_price)");
            this.loadingIndicator = (LoadingIndicatorView) findViewById10;
            View findViewById11 = view.findViewById(R.id.add_item);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.id.add_item)");
            this.addButton = (TalabatButton) findViewById11;
            View findViewById12 = view.findViewById(R.id.rootView);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(R.id.rootView)");
            this.wholeCell = findViewById12;
            View findViewById13 = view.findViewById(R.id.quantity_section);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "itemView.findViewById(R.id.quantity_section)");
            this.quantitySection = findViewById13;
            View findViewById14 = view.findViewById(R.id.increase_qty);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "itemView.findViewById(R.id.increase_qty)");
            this.increaseQuantity = findViewById14;
            View findViewById15 = view.findViewById(R.id.decrease_qty);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "itemView.findViewById(R.id.decrease_qty)");
            this.decreaseQuantity = findViewById15;
            View findViewById16 = view.findViewById(R.id.quantity_text);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "itemView.findViewById(R.id.quantity_text)");
            this.quantityText = (TextView) findViewById16;
        }

        @NotNull
        public final TalabatButton getAddButton() {
            return this.addButton;
        }

        @NotNull
        public final View getDecreaseQuantity() {
            return this.decreaseQuantity;
        }

        @NotNull
        public final RelativeLayout getDescountIc() {
            return this.descountIc;
        }

        @NotNull
        public final TextView getDescription() {
            return this.description;
        }

        @NotNull
        public final View getIncreaseQuantity() {
            return this.increaseQuantity;
        }

        @NotNull
        public final ImageView getItemImg() {
            return this.itemImg;
        }

        @NotNull
        public final LoadingIndicatorView getLoadingIndicator() {
            return this.loadingIndicator;
        }

        @NotNull
        public final TextView getName() {
            return this.f54105name;
        }

        @NotNull
        public final TextView getPrice() {
            return this.price;
        }

        @NotNull
        public final TextView getPriceBefore() {
            return this.priceBefore;
        }

        @NotNull
        public final TextView getPriceExtraInfo() {
            return this.priceExtraInfo;
        }

        @NotNull
        public final View getPriceView() {
            return this.priceView;
        }

        @NotNull
        public final ProgressBar getProgress() {
            return this.progress;
        }

        @NotNull
        public final View getQuantitySection() {
            return this.quantitySection;
        }

        @NotNull
        public final TextView getQuantityText() {
            return this.quantityText;
        }

        @NotNull
        public final View getWholeCell() {
            return this.wholeCell;
        }

        public final void setAddButton(@NotNull TalabatButton talabatButton) {
            Intrinsics.checkNotNullParameter(talabatButton, "<set-?>");
            this.addButton = talabatButton;
        }

        public final void setDecreaseQuantity(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.decreaseQuantity = view;
        }

        public final void setDescountIc(@NotNull RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.descountIc = relativeLayout;
        }

        public final void setDescription(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.description = textView;
        }

        public final void setIncreaseQuantity(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.increaseQuantity = view;
        }

        public final void setItemImg(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.itemImg = imageView;
        }

        public final void setLoadingIndicator(@NotNull LoadingIndicatorView loadingIndicatorView) {
            Intrinsics.checkNotNullParameter(loadingIndicatorView, "<set-?>");
            this.loadingIndicator = loadingIndicatorView;
        }

        public final void setName(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.f54105name = textView;
        }

        public final void setPrice(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.price = textView;
        }

        public final void setPriceBefore(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.priceBefore = textView;
        }

        public final void setPriceExtraInfo(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.priceExtraInfo = textView;
        }

        public final void setPriceView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.priceView = view;
        }

        public final void setProgress(@NotNull ProgressBar progressBar) {
            Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
            this.progress = progressBar;
        }

        public final void setQuantitySection(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.quantitySection = view;
        }

        public final void setQuantityText(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.quantityText = textView;
        }

        public final void setWholeCell(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.wholeCell = view;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/GroceryDetailsViewScreen$SectionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/talabat/GroceryDetailsViewScreen;Landroid/view/View;)V", "convertView", "getConvertView", "()Landroid/view/View;", "setConvertView", "(Landroid/view/View;)V", "menuSectionName", "Landroid/widget/TextView;", "getMenuSectionName", "()Landroid/widget/TextView;", "setMenuSectionName", "(Landroid/widget/TextView;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private View convertView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ GroceryDetailsViewScreen f54106h;
        @NotNull
        private TextView menuSectionName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SectionHeaderViewHolder(@NotNull GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f54106h = groceryDetailsViewScreen;
            View findViewById = view.findViewById(R.id.section_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.section_name)");
            this.menuSectionName = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.section_header_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.section_header_view)");
            this.convertView = findViewById2;
        }

        @NotNull
        public final View getConvertView() {
            return this.convertView;
        }

        @NotNull
        public final TextView getMenuSectionName() {
            return this.menuSectionName;
        }

        public final void setConvertView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.convertView = view;
        }

        public final void setMenuSectionName(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.menuSectionName = textView;
        }
    }

    private final void adjustSnackBar() {
        int i11 = R.id.miniCart;
        ((MiniCartLayout) _$_findCachedViewById(i11)).setClickListener(this);
        Cart instance = Cart.getInstance();
        if (instance == null || instance.getRestaurant() == null) {
            ((MiniCartLayout) _$_findCachedViewById(i11)).showMiniCart(0, GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable);
        } else {
            ((MiniCartLayout) _$_findCachedViewById(i11)).showMiniCart(Cart.getInstance().getCartCount(), GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), Cart.getInstance().getCartSubTotalDisplayPrice(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        }
        ((MiniCartLayout) _$_findCachedViewById(i11)).setVisibility(0);
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            ((RelativeLayout) _$_findCachedViewById(R.id.gem_holder_view)).setVisibility(0);
        } else {
            ((RelativeLayout) _$_findCachedViewById(R.id.gem_holder_view)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void cartCountChanged() {
        Cart.getInstance();
        showSnackBar();
    }

    private final void expand(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, view.getMeasuredHeight()});
        ofInt.addUpdateListener(new p6(view));
        ofInt.setDuration(300);
        ofInt.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: expand$lambda-26  reason: not valid java name */
    public static final void m9422expand$lambda26(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$thisView");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = intValue;
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void getAllSelectedSortAndFilterCriteriaAndApply(int r11) {
        /*
            r10 = this;
            com.talabat.adapters.grocery.TagsAdapter r0 = r10.tagsAdapter
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0016
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getTagIdString()
            java.lang.CharSequence r0 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            com.talabat.GroceryDetailsViewScreen$BrandListAdapter r2 = r10.brandListAdapter
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0050
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r2 = r2.getFilterString()
            java.lang.CharSequence r5 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r2)
            java.lang.String r5 = r5.toString()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0034
            r5 = r3
            goto L_0x0035
        L_0x0034:
            r5 = r4
        L_0x0035:
            if (r5 == 0) goto L_0x0048
            library.talabat.mvp.grocerydetails.GroceryDetailsPresenter r5 = r10.getGroceryDetailsPresenter()
            com.talabat.GroceryDetailsViewScreen$BrandListAdapter r6 = r10.brandListAdapter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.util.ArrayList r6 = r6.selectedBrands()
            r5.setSelectedBrandIdsList(r6)
            goto L_0x0051
        L_0x0048:
            library.talabat.mvp.grocerydetails.GroceryDetailsPresenter r5 = r10.getGroceryDetailsPresenter()
            r5.clearSelectedBrands()
            goto L_0x0051
        L_0x0050:
            r2 = r1
        L_0x0051:
            int r5 = r10.RELEVANCE
            java.lang.String r6 = "original"
            if (r11 != r5) goto L_0x005c
            r10.previousSort = r5
            r7 = r1
            r1 = r6
            goto L_0x0084
        L_0x005c:
            int r5 = r10.HIGH_LOW
            java.lang.String r7 = "desc"
            java.lang.String r8 = "Price"
            if (r11 != r5) goto L_0x0068
            r10.previousSort = r5
        L_0x0066:
            r1 = r8
            goto L_0x0084
        L_0x0068:
            int r5 = r10.LOW_HIGH
            java.lang.String r9 = "asc"
            if (r11 != r5) goto L_0x0073
            r10.previousSort = r5
        L_0x0070:
            r1 = r8
            r7 = r9
            goto L_0x0084
        L_0x0073:
            int r5 = r10.A_Z
            java.lang.String r8 = "Name"
            if (r11 != r5) goto L_0x007c
            r10.previousSort = r5
            goto L_0x0070
        L_0x007c:
            int r5 = r10.Z_A
            if (r11 != r5) goto L_0x0083
            r10.previousSort = r5
            goto L_0x0066
        L_0x0083:
            r7 = r1
        L_0x0084:
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r6)
            if (r11 == 0) goto L_0x00ad
            int r11 = r7.length()
            if (r11 != 0) goto L_0x0092
            r11 = r3
            goto L_0x0093
        L_0x0092:
            r11 = r4
        L_0x0093:
            if (r11 == 0) goto L_0x00ad
            int r11 = r2.length()
            if (r11 != 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r3 = r4
        L_0x009d:
            if (r3 == 0) goto L_0x00ad
            int r11 = com.talabat.R.id.sort_selected
            android.view.View r11 = r10._$_findCachedViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r3 = 8
            r11.setVisibility(r3)
            goto L_0x00b8
        L_0x00ad:
            int r11 = com.talabat.R.id.sort_selected
            android.view.View r11 = r10._$_findCachedViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r11.setVisibility(r4)
        L_0x00b8:
            library.talabat.mvp.grocerydetails.GroceryDetailsPresenter r11 = r10.getGroceryDetailsPresenter()
            r11.setSortAndFilterCriteria(r2, r1, r7, r0)
            int r11 = com.talabat.R.id.search_field
            android.view.View r11 = r10._$_findCachedViewById(r11)
            com.materialedittext.MaterialEditText r11 = (com.materialedittext.MaterialEditText) r11
            android.text.Editable r11 = r11.getText()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.CharSequence r11 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r11)
            java.lang.String r11 = r11.toString()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x00e0
            int r11 = r10.pageNumber
            goto L_0x00e2
        L_0x00e0:
            int r11 = r10.searchPageNumber
        L_0x00e2:
            library.talabat.mvp.grocerydetails.GroceryDetailsPresenter r0 = r10.getGroceryDetailsPresenter()
            r0.loadMoreItems(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.GroceryDetailsViewScreen.getAllSelectedSortAndFilterCriteriaAndApply(int):void");
    }

    /* access modifiers changed from: private */
    public final String getChoicesString(ArrayList<ChoiceSection> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
            while (it2.hasNext()) {
                ChoiceItem next = it2.next();
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(next.f13840name);
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
        return sb3;
    }

    /* access modifiers changed from: private */
    public final GroceryDetailsPresenter getGroceryDetailsPresenter() {
        return (GroceryDetailsPresenter) this.groceryDetailsPresenter$delegate.getValue();
    }

    private final void getSortFromDescription(String str, String str2) {
        if (str.equals("original")) {
            this.previousSort = this.RELEVANCE;
        } else if (str.equals("Price") && str2.equals("desc")) {
            this.previousSort = this.HIGH_LOW;
        } else if (str.equals("Price") && str2.equals("asc")) {
            this.previousSort = this.LOW_HIGH;
        } else if (str.equals("Name") && str2.equals("desc")) {
            this.previousSort = this.Z_A;
        } else if (str.equals("Name") && str2.equals("asc")) {
            this.previousSort = this.A_Z;
        }
    }

    /* access modifiers changed from: private */
    public final void goToCart() {
        startActivity(new Intent(this, CartScreen.class));
    }

    /* access modifiers changed from: private */
    public final void hideOtherViewsExcept(View view) {
        Iterator<Pair<View, View>> it = this.visibilityControlledViews.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (!Intrinsics.areEqual(next.getFirst(), (Object) view)) {
                if (((View) next.getFirst()).getVisibility() != 8) {
                    ((View) next.getFirst()).setVisibility(8);
                    createRotateAnimator((View) next.getSecond(), 180.0f, 0.0f).start();
                }
            } else if (view.getVisibility() != 0) {
                view.setVisibility(0);
                expand(view);
                createRotateAnimator((View) next.getSecond(), 0.0f, 180.0f).start();
            }
        }
    }

    private final void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.gemFooter = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine instance = GEMEngine.getInstance();
                Intrinsics.checkNotNull(instance);
                instance.startListening(this, false);
            }
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            GemFooterCartView gemFooterCartView = this.gemFooter;
            if (gemFooterCartView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gemFooter");
                gemFooterCartView = null;
            }
            beginTransaction.add((int) R.id.gem_holder_view, (Fragment) gemFooterCartView, getScreenName());
            beginTransaction.commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m9423onCreate$lambda0(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m9424onCreate$lambda1(GroceryDetailsViewScreen groceryDetailsViewScreen, Boolean bool) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            groceryDetailsViewScreen.stopLodingPopup();
            groceryDetailsViewScreen.setRecyclerView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m9425onCreate$lambda2(GroceryDetailsViewScreen groceryDetailsViewScreen, Boolean bool) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            groceryDetailsViewScreen.stopLodingPopup();
            groceryDetailsViewScreen.showEmptyScreen(true, true);
            Toast.makeText(groceryDetailsViewScreen, groceryDetailsViewScreen.getResources().getString(R.string.server_error_msg), 1).show();
            GlobalDataModel.JSON.netWorkErrorOccured.setValue(Boolean.FALSE);
        }
    }

    /* access modifiers changed from: private */
    public final void onMenuImageClicked(MenuItem menuItem, ImageView imageView) {
        GlobalDataModel.MENU.menuItem = menuItem;
        if (menuItem.hasThumbnail) {
            AppTracker.onProductImageClicked(this, CartMenuItem.createWithMenuItem(menuItem));
            MenuImageDialog menuImageDialog = new MenuImageDialog();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            menuImageDialog.show(supportFragmentManager, "Dialog Fragment");
            return;
        }
        onMenuItemClicked(menuItem, imageView);
    }

    /* access modifiers changed from: private */
    public final void onMenuItemClicked(MenuItem menuItem, ImageView imageView) {
        if (!GlobalDataModel.MENU.ChoiceClicked) {
            startLodingPopup();
            GlobalDataModel.MENU.ChoiceClicked = true;
            this.transitionImageView = imageView;
            this.globalMenuItem = menuItem;
            if (!menuItem.willHaveChoices()) {
                onReadyToNavigatetoItemDetails();
            } else if (!menuItem.isChoicesLoaded()) {
                getGroceryDetailsPresenter().getChoiceSection(menuItem.f13861id);
            } else {
                onReadyToNavigatetoItemDetails();
            }
        }
    }

    private final void onNavigateToItemDetails(CartMenuItem cartMenuItem, ImageView imageView) {
        GlobalDataModel.SELECTED.cartMenuItem = cartMenuItem;
        startActivity(new Intent(this, ItemDetailsActivity.class));
        stopLodingPopup();
    }

    private final void onRadioButtonClicked(RadioButton radioButton) {
        boolean z11;
        RadioButton[] radioButtonArr = this.radioButtons;
        Intrinsics.checkNotNull(radioButtonArr);
        for (RadioButton radioButton2 : radioButtonArr) {
            if (radioButton2 == radioButton) {
                z11 = true;
            } else {
                z11 = false;
            }
            radioButton2.setChecked(z11);
        }
    }

    private final void onReadyToAddItem(String str) {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.globalMenuItem);
        createWithMenuItem.setQuantity(1);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant));
        stopLodingPopup();
        getGroceryDetailsPresenter().addItem(GlobalDataModel.SELECTED.restaurant, createWithMenuItem, str);
        GlobalDataModel.MENU.AddToCartClicked = false;
    }

    private final void onReadyToNavigatetoItemDetails() {
        if (GlobalDataModel.MENU.AddToCartClicked) {
            GlobalDataModel.MENU.AddToCartClicked = false;
        }
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.globalMenuItem);
        Intrinsics.checkNotNullExpressionValue(createWithMenuItem, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
        ImageView imageView = this.transitionImageView;
        Intrinsics.checkNotNull(imageView);
        onNavigateToItemDetails(createWithMenuItem, imageView);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant));
        GlobalDataModel.MENU.ChoiceClicked = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-28  reason: not valid java name */
    public static final void m9426onResume$lambda28(GroceryDetailsViewScreen groceryDetailsViewScreen, Boolean bool) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            groceryDetailsViewScreen.readyToUpdate.setValue(Boolean.FALSE);
            int i11 = groceryDetailsViewScreen.previousSort;
            int i12 = groceryDetailsViewScreen.RELEVANCE;
            if (i11 != i12) {
                groceryDetailsViewScreen.getAllSelectedSortAndFilterCriteriaAndApply(i11);
                return;
            }
            groceryDetailsViewScreen.previousSort = i12;
            TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.relevance).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "relevance.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
            groceryDetailsViewScreen.getGroceryDetailsPresenter().setSortAndFilterCriteria("", "original", "", "");
        }
    }

    private final void setFilter() {
        boolean z11;
        GroceryItemsForSectionBrandModel[] brands = getGroceryDetailsPresenter().getBrands();
        if (brands != null) {
            if (brands.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                this.brandListAdapter = new BrandListAdapter((ArrayList) ArraysKt___ArraysKt.toCollection((T[]) brands, new ArrayList()));
                int i11 = R.id.brands_recyclerView;
                ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(this.brandListAdapter);
                ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(this, 1, false));
                ((RecyclerView) _$_findCachedViewById(i11)).setHasFixedSize(false);
                ((RecyclerView) _$_findCachedViewById(i11)).setItemViewCacheSize(20);
                ((RecyclerView) _$_findCachedViewById(i11)).setDrawingCacheEnabled(true);
                ((RecyclerView) _$_findCachedViewById(i11)).setDrawingCacheQuality(1048576);
                _$_findCachedViewById(R.id.seperator).setVisibility(0);
                ((RelativeLayout) _$_findCachedViewById(R.id.filter_header_section)).setVisibility(0);
                this.visibilityControlledViews.add(new Pair((RecyclerView) _$_findCachedViewById(i11), (ImageView) _$_findCachedViewById(R.id.brands_expand)));
                ((RelativeLayout) _$_findCachedViewById(R.id.brand_section)).setOnClickListener(new t6(this));
                return;
            }
            _$_findCachedViewById(R.id.seperator).setVisibility(8);
            ((RelativeLayout) _$_findCachedViewById(R.id.filter_header_section)).setVisibility(8);
            return;
        }
        _$_findCachedViewById(R.id.seperator).setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(R.id.filter_header_section)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: setFilter$lambda-7  reason: not valid java name */
    public static final void m9427setFilter$lambda7(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        int i11 = R.id.brands_recyclerView;
        if (((RecyclerView) groceryDetailsViewScreen._$_findCachedViewById(i11)).getVisibility() == 8) {
            BrandListAdapter brandListAdapter2 = groceryDetailsViewScreen.brandListAdapter;
            if (brandListAdapter2 != null) {
                Intrinsics.checkNotNull(brandListAdapter2);
                brandListAdapter2.setSelectedBrands(groceryDetailsViewScreen.getGroceryDetailsPresenter().getSelectedBrandIds());
                BrandListAdapter brandListAdapter3 = groceryDetailsViewScreen.brandListAdapter;
                Intrinsics.checkNotNull(brandListAdapter3);
                brandListAdapter3.notifyDataSetChanged();
            } else {
                GroceryItemsForSectionBrandModel[] brands = groceryDetailsViewScreen.getGroceryDetailsPresenter().getBrands();
                if (brands != null) {
                    arrayList = (ArrayList) ArraysKt___ArraysKt.toCollection((T[]) brands, new ArrayList());
                } else {
                    arrayList = null;
                }
                groceryDetailsViewScreen.brandListAdapter = new BrandListAdapter(arrayList);
            }
        }
        RecyclerView recyclerView = (RecyclerView) groceryDetailsViewScreen._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "brands_recyclerView");
        groceryDetailsViewScreen.hideOtherViewsExcept(recyclerView);
    }

    private final void setHintText() {
        String string = getResources().getString(R.string.search);
        String str = GlobalDataModel.SELECTED.restaurant.f13873name;
        ((MaterialEditText) _$_findCachedViewById(R.id.search_field)).setHint(string + " " + str);
    }

    private final void setRecyclerView() {
        int i11 = R.id.search_section;
        ((RelativeLayout) _$_findCachedViewById(i11)).setVisibility(0);
        ((RelativeLayout) _$_findCachedViewById(i11)).animate().alpha(1.0f).setDuration(300);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new GridLayoutManager(this, 2);
        int i12 = R.id.menu_items_recycler;
        ((RecyclerView) _$_findCachedViewById(i12)).setLayoutManager((RecyclerView.LayoutManager) objectRef.element);
        ((RecyclerView) _$_findCachedViewById(i12)).addItemDecoration(new GridSpacingItemDecoration(2, getResources().getDimensionPixelOffset(R.dimen.grocery_grid_view_internal_margin), 2, false));
        getGroceryDetailsPresenter().setTotalPages();
        this.totalPages = getGroceryDetailsPresenter().getPagingInfo().getTotalPages();
        this.visibleThreshold = getGroceryDetailsPresenter().getPagingInfo().getPageSize();
        this.itemListadapter = new ItemListAdapter(this, getGroceryDetailsPresenter().getAllItemsToDisplay());
        ((RecyclerView) _$_findCachedViewById(i12)).setAdapter(this.itemListadapter);
        ((RecyclerView) _$_findCachedViewById(i12)).setHasFixedSize(false);
        ((RecyclerView) _$_findCachedViewById(i12)).setItemViewCacheSize(20);
        ((RecyclerView) _$_findCachedViewById(i12)).setDrawingCacheEnabled(true);
        ((RecyclerView) _$_findCachedViewById(i12)).setDrawingCacheQuality(1048576);
        showHeaderSection(getGroceryDetailsPresenter().getPagingInfo().getTotalItems());
        setSort();
        setFilter();
        setTags();
        int i13 = Resources.getSystem().getDisplayMetrics().heightPixels;
        this.screenHeight = i13;
        this.viewHeight = (i13 * 65) / 100;
        int i14 = R.id.content_view;
        ((RelativeLayout) _$_findCachedViewById(i14)).getLayoutParams().height = this.viewHeight;
        ((RelativeLayout) _$_findCachedViewById(i14)).requestLayout();
        ((RecyclerView) _$_findCachedViewById(i12)).addOnScrollListener(new GroceryDetailsViewScreen$setRecyclerView$1(this, objectRef));
        int i15 = R.id.search_field;
        ((MaterialEditText) _$_findCachedViewById(i15)).setOnTouchListener(new u6(this));
        ((MaterialEditText) _$_findCachedViewById(i15)).addTextChangedListener(new GroceryDetailsViewScreen$setRecyclerView$3(this));
        GroceryDetailsPresenter groceryDetailsPresenter = getGroceryDetailsPresenter();
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(i15);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "search_field");
        groceryDetailsPresenter.setUpSearchThreads(materialEditText, this.searchPageNumber);
        if (this.enableSearchWithButtonClick) {
            getGroceryDetailsPresenter().disableAutoSearch(true);
            ((MaterialEditText) _$_findCachedViewById(i15)).setOnEditorActionListener(new v6(this));
        } else {
            getGroceryDetailsPresenter().disableAutoSearch(false);
        }
        ((ImageView) _$_findCachedViewById(R.id.clear_text)).setOnClickListener(new w6(this));
        AppTracker.onCategoryDetailsLoaded(this, GlobalDataModel.SELECTED.restaurant, getMenuSection(), getScreenName(), ScreenNames.getScreenType(getScreenName()));
    }

    /* access modifiers changed from: private */
    /* renamed from: setRecyclerView$lambda-3  reason: not valid java name */
    public static final boolean m9428setRecyclerView$lambda3(GroceryDetailsViewScreen groceryDetailsViewScreen, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        AppTracker.onSearchBarClicked(groceryDetailsViewScreen, ScreenNames.getScreenType(groceryDetailsViewScreen.getScreenName()), groceryDetailsViewScreen.getScreenName(), "N/A", "search");
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: setRecyclerView$lambda-4  reason: not valid java name */
    public static final boolean m9429setRecyclerView$lambda4(GroceryDetailsViewScreen groceryDetailsViewScreen, TextView textView, int i11, KeyEvent keyEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        if (i11 == 3) {
            if (StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) groceryDetailsViewScreen._$_findCachedViewById(R.id.search_field)).getText())).toString().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                groceryDetailsViewScreen.getGroceryDetailsPresenter().requestForSearch(true);
                groceryDetailsViewScreen.getGroceryDetailsPresenter().setNewPageNumber(groceryDetailsViewScreen.searchPageNumber);
                groceryDetailsViewScreen.getWindow().setSoftInputMode(2);
                Object systemService = groceryDetailsViewScreen.getSystemService("input_method");
                if (systemService != null) {
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
                    return true;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: setRecyclerView$lambda-5  reason: not valid java name */
    public static final void m9430setRecyclerView$lambda5(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        view.setVisibility(8);
        ((TalabatStrokeButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.reset)).performClick();
        TagsAdapter tagsAdapter2 = groceryDetailsViewScreen.tagsAdapter;
        if (!(tagsAdapter2 == null || tagsAdapter2 == null)) {
            tagsAdapter2.clearSelection();
        }
        groceryDetailsViewScreen.getGroceryDetailsPresenter().clearEditText();
        groceryDetailsViewScreen.getWindow().setSoftInputMode(2);
        Object systemService = groceryDetailsViewScreen.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(((ImageView) groceryDetailsViewScreen._$_findCachedViewById(R.id.clear_text)).getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void setSort() {
        ((ImageView) _$_findCachedViewById(R.id.sort_icon)).setOnClickListener(new g6(this));
        ((Button) _$_findCachedViewById(R.id.sort_icon_padding)).setOnClickListener(new h7(this));
        ((ImageView) _$_findCachedViewById(R.id.close_categories)).setOnClickListener(new h6(this));
        ((RelativeLayout) _$_findCachedViewById(R.id.sort_header_section)).setOnClickListener(new i6(this));
        ((LinearLayout) _$_findCachedViewById(R.id.close_categories_view)).setOnClickListener(new j6(this));
        ((RelativeLayout) _$_findCachedViewById(R.id.sort_bottom_sheet)).setOnClickListener(new k6(this));
        int i11 = R.id.relevance;
        View _$_findCachedViewById = _$_findCachedViewById(i11);
        int i12 = R.id.item_txt;
        ((TalabatTextView) _$_findCachedViewById.findViewById(i12)).setText(getString(R.string.best_match));
        int i13 = R.id.price_high_to_low;
        ((TalabatTextView) _$_findCachedViewById(i13).findViewById(i12)).setText(getString(R.string.high_to_low));
        int i14 = R.id.price_low_to_high;
        ((TalabatTextView) _$_findCachedViewById(i14).findViewById(i12)).setText(getString(R.string.low_to_high));
        int i15 = R.id.name_a_z;
        ((TalabatTextView) _$_findCachedViewById(i15).findViewById(i12)).setText(getString(R.string.a_to_z));
        int i16 = R.id.name_z_a;
        ((TalabatTextView) _$_findCachedViewById(i16).findViewById(i12)).setText(getString(R.string.z_to_a));
        View _$_findCachedViewById2 = _$_findCachedViewById(i11);
        int i17 = R.id.item_radio;
        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) _$_findCachedViewById2.findViewById(i17);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "relevance.item_radio");
        TalabatRadioButton talabatRadioButton2 = (TalabatRadioButton) _$_findCachedViewById(i13).findViewById(i17);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton2, "price_high_to_low.item_radio");
        TalabatRadioButton talabatRadioButton3 = (TalabatRadioButton) _$_findCachedViewById(i14).findViewById(i17);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton3, "price_low_to_high.item_radio");
        TalabatRadioButton talabatRadioButton4 = (TalabatRadioButton) _$_findCachedViewById(i15).findViewById(i17);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton4, "name_a_z.item_radio");
        TalabatRadioButton talabatRadioButton5 = (TalabatRadioButton) _$_findCachedViewById(i16).findViewById(i17);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton5, "name_z_a.item_radio");
        this.radioButtons = new RadioButton[]{talabatRadioButton, talabatRadioButton2, talabatRadioButton3, talabatRadioButton4, talabatRadioButton5};
        _$_findCachedViewById(i11).setOnClickListener(new l6(this));
        ((TalabatRadioButton) _$_findCachedViewById(i11).findViewById(i17)).setOnClickListener(new m6(this));
        _$_findCachedViewById(i13).setOnClickListener(new n6(this));
        ((TalabatRadioButton) _$_findCachedViewById(i13).findViewById(i17)).setOnClickListener(new o6(this));
        _$_findCachedViewById(i14).setOnClickListener(new r6(this));
        ((TalabatRadioButton) _$_findCachedViewById(i14).findViewById(i17)).setOnClickListener(new a7(this));
        _$_findCachedViewById(i15).setOnClickListener(new b7(this));
        ((TalabatRadioButton) _$_findCachedViewById(i15).findViewById(i17)).setOnClickListener(new c7(this));
        _$_findCachedViewById(i16).setOnClickListener(new d7(this));
        ((TalabatRadioButton) _$_findCachedViewById(i16).findViewById(i17)).setOnClickListener(new e7(this));
        ((TalabatFillButton) _$_findCachedViewById(R.id.apply)).setOnClickListener(new f7(this));
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.reset)).setOnClickListener(new g7(this));
        this.readyToUpdate.setValue(Boolean.TRUE);
        this.visibilityControlledViews.add(new Pair((LinearLayout) _$_findCachedViewById(R.id.sort_sections), (ImageView) _$_findCachedViewById(R.id.sort_section_expand)));
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-10  reason: not valid java name */
    public static final void m9431setSort$lambda10(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        int i11 = R.id.content_view;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((RelativeLayout) groceryDetailsViewScreen._$_findCachedViewById(i11), "translationY", new float[]{0.0f, (float) ((RelativeLayout) groceryDetailsViewScreen._$_findCachedViewById(i11)).getHeight()});
        ofFloat.addListener(new GroceryDetailsViewScreen$setSort$3$1(groceryDetailsViewScreen));
        ofFloat.start();
        int i12 = groceryDetailsViewScreen.previousSort;
        int i13 = groceryDetailsViewScreen.RELEVANCE;
        if (i12 == i13) {
            TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.relevance).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "relevance.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
        } else if (i12 == groceryDetailsViewScreen.HIGH_LOW) {
            TalabatRadioButton talabatRadioButton2 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.price_high_to_low).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton2, "price_high_to_low.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton2);
        } else if (i12 == groceryDetailsViewScreen.LOW_HIGH) {
            TalabatRadioButton talabatRadioButton3 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.price_low_to_high).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton3, "price_low_to_high.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton3);
        } else if (i12 == groceryDetailsViewScreen.A_Z) {
            TalabatRadioButton talabatRadioButton4 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.name_a_z).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton4, "name_a_z.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton4);
        } else if (i12 == groceryDetailsViewScreen.Z_A) {
            TalabatRadioButton talabatRadioButton5 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.name_z_a).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton5, "name_z_a.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton5);
        } else {
            groceryDetailsViewScreen.previousSort = i13;
            TalabatRadioButton talabatRadioButton6 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.relevance).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton6, "relevance.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton6);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-11  reason: not valid java name */
    public static final void m9432setSort$lambda11(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        LinearLayout linearLayout = (LinearLayout) groceryDetailsViewScreen._$_findCachedViewById(R.id.sort_sections);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "sort_sections");
        groceryDetailsViewScreen.hideOtherViewsExcept(linearLayout);
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-12  reason: not valid java name */
    public static final void m9433setSort$lambda12(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        ((ImageView) groceryDetailsViewScreen._$_findCachedViewById(R.id.close_categories)).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-13  reason: not valid java name */
    public static final void m9434setSort$lambda13(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        ((ImageView) groceryDetailsViewScreen._$_findCachedViewById(R.id.close_categories)).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-14  reason: not valid java name */
    public static final void m9435setSort$lambda14(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen.selectedSort = groceryDetailsViewScreen.RELEVANCE;
        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.relevance).findViewById(R.id.item_radio);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "relevance.item_radio");
        groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-15  reason: not valid java name */
    public static final void m9436setSort$lambda15(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen._$_findCachedViewById(R.id.relevance).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-16  reason: not valid java name */
    public static final void m9437setSort$lambda16(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen.selectedSort = groceryDetailsViewScreen.HIGH_LOW;
        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.price_high_to_low).findViewById(R.id.item_radio);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "price_high_to_low.item_radio");
        groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-17  reason: not valid java name */
    public static final void m9438setSort$lambda17(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen._$_findCachedViewById(R.id.price_high_to_low).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-18  reason: not valid java name */
    public static final void m9439setSort$lambda18(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen.selectedSort = groceryDetailsViewScreen.LOW_HIGH;
        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.price_low_to_high).findViewById(R.id.item_radio);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "price_low_to_high.item_radio");
        groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-19  reason: not valid java name */
    public static final void m9440setSort$lambda19(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen._$_findCachedViewById(R.id.price_low_to_high).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-20  reason: not valid java name */
    public static final void m9441setSort$lambda20(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen.selectedSort = groceryDetailsViewScreen.A_Z;
        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.name_a_z).findViewById(R.id.item_radio);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "name_a_z.item_radio");
        groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-21  reason: not valid java name */
    public static final void m9442setSort$lambda21(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen._$_findCachedViewById(R.id.name_a_z).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-22  reason: not valid java name */
    public static final void m9443setSort$lambda22(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen.selectedSort = groceryDetailsViewScreen.Z_A;
        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.name_z_a).findViewById(R.id.item_radio);
        Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "name_z_a.item_radio");
        groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-23  reason: not valid java name */
    public static final void m9444setSort$lambda23(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen._$_findCachedViewById(R.id.name_z_a).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-24  reason: not valid java name */
    public static final void m9445setSort$lambda24(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        if (StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) groceryDetailsViewScreen._$_findCachedViewById(R.id.search_field)).getText())).toString().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            groceryDetailsViewScreen.startLodingPopup();
        }
        AppTracker.onCategoryDetailsUpdated(groceryDetailsViewScreen, GlobalDataModel.SELECTED.restaurant, groceryDetailsViewScreen.getSelectedSort(groceryDetailsViewScreen.previousSort), groceryDetailsViewScreen.getMenuSection());
        groceryDetailsViewScreen.allItemsForCurrentKeywordLoaded = false;
        groceryDetailsViewScreen.searchPageNumber = 1;
        groceryDetailsViewScreen.pageNumber = 1;
        groceryDetailsViewScreen.getAllSelectedSortAndFilterCriteriaAndApply(groceryDetailsViewScreen.selectedSort);
        if (((RelativeLayout) groceryDetailsViewScreen._$_findCachedViewById(R.id.content_view)).getVisibility() == 0) {
            ((ImageView) groceryDetailsViewScreen._$_findCachedViewById(R.id.close_categories)).performClick();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b7, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) "-1") == false) goto L_0x00b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: setSort$lambda-25  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9446setSort$lambda25(com.talabat.GroceryDetailsViewScreen r5, android.view.View r6) {
        /*
            java.lang.String r6 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            int r6 = com.talabat.R.id.sort_selected
            android.view.View r6 = r5._$_findCachedViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r0 = 8
            r6.setVisibility(r0)
            int r6 = com.talabat.R.id.search_field
            android.view.View r6 = r5._$_findCachedViewById(r6)
            com.materialedittext.MaterialEditText r6 = (com.materialedittext.MaterialEditText) r6
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.CharSequence r6 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r6)
            java.lang.String r6 = r6.toString()
            int r6 = r6.length()
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x0035
            r6 = r1
            goto L_0x0036
        L_0x0035:
            r6 = r0
        L_0x0036:
            if (r6 == 0) goto L_0x0076
            library.talabat.mvp.grocerydetails.GroceryDetailsPresenter r6 = r5.getGroceryDetailsPresenter()
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r6 = r6.getPagingInfo()
            int r2 = r6.getTotalPages()
            r5.totalPages = r2
            int r2 = r6.getTotalItems()
            r5.totalItemCount = r2
            int r2 = com.talabat.R.id.category_count
            android.view.View r2 = r5._$_findCachedViewById(r2)
            com.talabat.TalabatTextView r2 = (com.talabat.TalabatTextView) r2
            int r6 = r6.getTotalItems()
            r3 = 2132018584(0x7f140598, float:1.9675479E38)
            java.lang.String r3 = r5.getString(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r6 = " "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r6 = r4.toString()
            r2.setText(r6)
        L_0x0076:
            int r6 = r5.previousSort
            int r2 = r5.RELEVANCE
            java.lang.String r3 = "relevance.item_radio"
            if (r6 != r2) goto L_0x00b9
            library.talabat.mvp.grocerydetails.GroceryDetailsPresenter r6 = r5.getGroceryDetailsPresenter()
            java.util.ArrayList r6 = r6.getSelectedBrandIds()
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x00d9
            com.talabat.adapters.grocery.TagsAdapter r6 = r5.tagsAdapter
            r2 = 0
            if (r6 == 0) goto L_0x0097
            java.lang.String r6 = r6.getTagIdString()
            goto L_0x0098
        L_0x0097:
            r6 = r2
        L_0x0098:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x00a3
            r6 = r1
            goto L_0x00a4
        L_0x00a3:
            r6 = r0
        L_0x00a4:
            if (r6 != 0) goto L_0x00b9
            com.talabat.adapters.grocery.TagsAdapter r6 = r5.tagsAdapter
            if (r6 == 0) goto L_0x00ae
            java.lang.String r2 = r6.getTagIdString()
        L_0x00ae:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r6 = "-1"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x00d9
        L_0x00b9:
            int r6 = r5.RELEVANCE
            r5.selectedSort = r6
            r5.previousSort = r6
            int r6 = com.talabat.R.id.relevance
            android.view.View r6 = r5._$_findCachedViewById(r6)
            int r2 = com.talabat.R.id.item_radio
            android.view.View r6 = r6.findViewById(r2)
            com.talabat.TalabatRadioButton r6 = (com.talabat.TalabatRadioButton) r6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r5.onRadioButtonClicked(r6)
            r5.allItemsForCurrentKeywordLoaded = r0
            r5.searchPageNumber = r1
            r5.pageNumber = r1
        L_0x00d9:
            com.talabat.adapters.grocery.TagsAdapter r6 = r5.tagsAdapter
            if (r6 == 0) goto L_0x00e9
            if (r6 == 0) goto L_0x00e2
            r6.clearSelection()
        L_0x00e2:
            com.talabat.adapters.grocery.TagsAdapter r6 = r5.tagsAdapter
            if (r6 == 0) goto L_0x00e9
            r6.setAllSelected(r1, r1)
        L_0x00e9:
            library.talabat.mvp.grocerydetails.GroceryDetailsPresenter r6 = r5.getGroceryDetailsPresenter()
            r6.resetSortAndFilter()
            int r6 = r5.RELEVANCE
            r5.previousSort = r6
            int r6 = com.talabat.R.id.relevance
            android.view.View r6 = r5._$_findCachedViewById(r6)
            int r0 = com.talabat.R.id.item_radio
            android.view.View r6 = r6.findViewById(r0)
            com.talabat.TalabatRadioButton r6 = (com.talabat.TalabatRadioButton) r6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r5.onRadioButtonClicked(r6)
            com.talabat.GroceryDetailsViewScreen$BrandListAdapter r6 = r5.brandListAdapter
            if (r6 == 0) goto L_0x011f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.setSelectedBrands(r0)
            com.talabat.GroceryDetailsViewScreen$BrandListAdapter r5 = r5.brandListAdapter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r5.notifyDataSetChanged()
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.GroceryDetailsViewScreen.m9446setSort$lambda25(com.talabat.GroceryDetailsViewScreen, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-8  reason: not valid java name */
    public static final void m9447setSort$lambda8(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        groceryDetailsViewScreen.getSortFromDescription(groceryDetailsViewScreen.getGroceryDetailsPresenter().getSortBy(), groceryDetailsViewScreen.getGroceryDetailsPresenter().getSortOrder());
        int i11 = groceryDetailsViewScreen.previousSort;
        int i12 = groceryDetailsViewScreen.RELEVANCE;
        if (i11 == i12) {
            TalabatRadioButton talabatRadioButton = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.relevance).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "relevance.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton);
        } else if (i11 == groceryDetailsViewScreen.HIGH_LOW) {
            TalabatRadioButton talabatRadioButton2 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.price_high_to_low).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton2, "price_high_to_low.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton2);
        } else if (i11 == groceryDetailsViewScreen.LOW_HIGH) {
            TalabatRadioButton talabatRadioButton3 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.price_low_to_high).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton3, "price_low_to_high.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton3);
        } else if (i11 == groceryDetailsViewScreen.A_Z) {
            TalabatRadioButton talabatRadioButton4 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.name_a_z).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton4, "name_a_z.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton4);
        } else if (i11 == groceryDetailsViewScreen.Z_A) {
            TalabatRadioButton talabatRadioButton5 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.name_z_a).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton5, "name_z_a.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton5);
        } else {
            groceryDetailsViewScreen.previousSort = i12;
            TalabatRadioButton talabatRadioButton6 = (TalabatRadioButton) groceryDetailsViewScreen._$_findCachedViewById(R.id.relevance).findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(talabatRadioButton6, "relevance.item_radio");
            groceryDetailsViewScreen.onRadioButtonClicked(talabatRadioButton6);
        }
        int i13 = R.id.sort_bottom_sheet;
        ((RelativeLayout) groceryDetailsViewScreen._$_findCachedViewById(i13)).setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((RelativeLayout) groceryDetailsViewScreen._$_findCachedViewById(i13), "alpha", new float[]{0.0f, 1.0f});
        ofFloat.addListener(new GroceryDetailsViewScreen$setSort$1$1(groceryDetailsViewScreen));
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: setSort$lambda-9  reason: not valid java name */
    public static final void m9448setSort$lambda9(GroceryDetailsViewScreen groceryDetailsViewScreen, View view) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        ((ImageView) groceryDetailsViewScreen._$_findCachedViewById(R.id.sort_icon)).performClick();
    }

    private final void setTags() {
        boolean z11;
        GroceryTagsModel[] tags = getGroceryDetailsPresenter().getTags();
        if (tags != null) {
            if (tags.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                ((RecyclerView) _$_findCachedViewById(R.id.tags_recyclerview)).setVisibility(0);
                for (GroceryTagsModel tagName : tags) {
                    tagName.getTagName();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(0, new GroceryTagsModel(-1, "All", 0));
                arrayList.addAll(1, ArraysKt___ArraysKt.toCollection((T[]) tags, new ArrayList()));
                this.tagsAdapter = new TagsAdapter(arrayList, this, this);
                int i11 = R.id.tags_recyclerview;
                ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(this, 0, false));
                ((RecyclerView) _$_findCachedViewById(i11)).setHasFixedSize(false);
                ((RecyclerView) _$_findCachedViewById(i11)).setItemViewCacheSize(20);
                ((RecyclerView) _$_findCachedViewById(i11)).setDrawingCacheEnabled(true);
                ((RecyclerView) _$_findCachedViewById(i11)).setDrawingCacheQuality(1048576);
                ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(this.tagsAdapter);
                return;
            }
            ((RecyclerView) _$_findCachedViewById(R.id.tags_recyclerview)).setVisibility(8);
            return;
        }
        ((RecyclerView) _$_findCachedViewById(R.id.tags_recyclerview)).setVisibility(8);
    }

    private final void showHeaderSection(int i11) {
        this.totalItemCount = i11;
        ((TalabatTextView) _$_findCachedViewById(R.id.category_name)).setText(getMenuSection().f13864name);
        String string = getString(R.string.grocery_items);
        ((TalabatTextView) _$_findCachedViewById(R.id.category_count)).setText(i11 + " " + string);
        int i12 = R.id.appbar;
        ((AppBarLayout) _$_findCachedViewById(i12)).setVisibility(0);
        ((AppBarLayout) _$_findCachedViewById(i12)).animate().alpha(1.0f).setDuration(300);
    }

    /* access modifiers changed from: private */
    /* renamed from: showRestaurantChangePopup$lambda-27  reason: not valid java name */
    public static final void m9449showRestaurantChangePopup$lambda27(GroceryDetailsViewScreen groceryDetailsViewScreen, Restaurant restaurant, CartMenuItem cartMenuItem, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(groceryDetailsViewScreen, "this$0");
        Intrinsics.checkNotNullParameter(cartMenuItem, "$cartMenuItem");
        groceryDetailsViewScreen.listUpdateRequired = true;
        groceryDetailsViewScreen.getGroceryDetailsPresenter().changeRestaurantAndAddItem(groceryDetailsViewScreen, restaurant, cartMenuItem);
    }

    /* access modifiers changed from: private */
    public final void showSingleToast() {
        boolean z11;
        View view;
        try {
            Toast toast2 = this.toast;
            if (toast2 == null || (view = toast2.getView()) == null || view.isShown()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                Toast makeText = Toast.makeText(this, getResources().getString(R.string.items_successfully_added), 0);
                this.toast = makeText;
                if (makeText != null) {
                    makeText.show();
                }
            }
        } catch (Exception unused) {
            Toast toast3 = this.toast;
            if (toast3 != null) {
                toast3.show();
            }
        }
    }

    private final void showSnackBar() {
        int i11 = R.id.miniCart;
        ((MiniCartLayout) _$_findCachedViewById(i11)).setVisibility(0);
        if (Cart.getInstance() == null || Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().getId() != GlobalDataModel.SELECTED.restaurant.getId()) {
            ((MiniCartLayout) _$_findCachedViewById(i11)).showMiniCart(0, GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable);
        } else {
            ((MiniCartLayout) _$_findCachedViewById(i11)).showMiniCart(Cart.getInstance().getCartCount(), GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), Cart.getInstance().getCartSubTotalDisplayPrice(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void cartButtonClicked() {
        startActivity(new Intent(this, CartScreen.class));
    }

    @NotNull
    public final ObjectAnimator createRotateAnimator(@NotNull View view, float f11, float f12) {
        Intrinsics.checkNotNullParameter(view, "target");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", new float[]{f11, f12});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        return ofFloat;
    }

    public void destroyPresenter() {
        getGroceryDetailsPresenter().onDestroy();
    }

    public final int getA_Z() {
        return this.A_Z;
    }

    @NotNull
    public final AppVersionProvider getAppVersionProvider() {
        AppVersionProvider appVersionProvider2 = this.appVersionProvider;
        if (appVersionProvider2 != null) {
            return appVersionProvider2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appVersionProvider");
        return null;
    }

    @NotNull
    public Context getContext() {
        return this;
    }

    public final boolean getDecremented() {
        return this.decremented;
    }

    @Nullable
    public final String getDisplayAmountForEmptyCart() {
        return TalabatFormatter.getInstance().getFormattedCurrency(0.0f);
    }

    @NotNull
    public EditText getEditText() {
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(R.id.search_field);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "search_field");
        return materialEditText;
    }

    public final boolean getEnableSearchWithButtonClick() {
        return this.enableSearchWithButtonClick;
    }

    public final int getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    @NotNull
    public Context getGemContext() {
        return this;
    }

    @NotNull
    public String getGemScreenType() {
        String screenType = ScreenNames.getScreenType(getScreenName());
        Intrinsics.checkNotNullExpressionValue(screenType, "getScreenType(screenName)");
        return screenType;
    }

    public final int getHIGH_LOW() {
        return this.HIGH_LOW;
    }

    public final int getLOW_HIGH() {
        return this.LOW_HIGH;
    }

    @NotNull
    public final MenuSection getMenuSection() {
        MenuSection menuSection2 = this.menuSection;
        if (menuSection2 != null) {
            return menuSection2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("menuSection");
        return null;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    @NotNull
    public IGlobalPresenter getPresenter() {
        return getGroceryDetailsPresenter();
    }

    @NotNull
    public final String getPreviousBrand() {
        return this.previousBrand;
    }

    public final int getPreviousSort() {
        return this.previousSort;
    }

    public final int getRELEVANCE() {
        return this.RELEVANCE;
    }

    @Nullable
    public final RadioButton[] getRadioButtons() {
        return this.radioButtons;
    }

    @NotNull
    public final MutableLiveData<Boolean> getReadyToUpdate() {
        return this.readyToUpdate;
    }

    @NotNull
    public String getScreenName() {
        return ScreenNames.GROCERY_DETAILS_SCREEN;
    }

    @NotNull
    public String getSearchTerm() {
        return String.valueOf(((MaterialEditText) _$_findCachedViewById(R.id.search_field)).getText());
    }

    public final int getSelectedSort() {
        return this.selectedSort;
    }

    @NotNull
    public String getTagNamesString() {
        boolean z11;
        TagsAdapter tagsAdapter2 = this.tagsAdapter;
        if (tagsAdapter2 == null) {
            return "";
        }
        Intrinsics.checkNotNull(tagsAdapter2);
        String tagNameString = tagsAdapter2.getTagNameString();
        if (tagNameString.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        return tagNameString;
    }

    @Nullable
    public final Toast getToast() {
        return this.toast;
    }

    public final int getTotalItemCount() {
        return this.totalItemCount;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    @NotNull
    public final ArrayList<Pair<View, View>> getVisibilityControlledViews() {
        return this.visibilityControlledViews;
    }

    public final int getVisibleItemCount() {
        return this.visibleItemCount;
    }

    public final int getVisibleThreshold() {
        return this.visibleThreshold;
    }

    public final int getZ_A() {
        return this.Z_A;
    }

    public boolean isRequired() {
        return this.updateRequired;
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(@Nullable Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
        finish();
    }

    public final void onCartIconClicked(@NotNull MenuItem menuItem, @NotNull ImageView imageView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        if (!GlobalDataModel.MENU.AddToCartClicked) {
            startLodingPopup();
            GlobalDataModel.MENU.AddToCartClicked = true;
            this.transitionImageView = imageView;
            this.globalMenuItem = menuItem;
            Intrinsics.checkNotNull(menuItem);
            if (menuItem.willHaveChoices()) {
                MenuItem menuItem2 = this.globalMenuItem;
                Intrinsics.checkNotNull(menuItem2);
                if (!menuItem2.isChoicesLoaded()) {
                    GroceryDetailsPresenter groceryDetailsPresenter = getGroceryDetailsPresenter();
                    MenuItem menuItem3 = this.globalMenuItem;
                    Intrinsics.checkNotNull(menuItem3);
                    groceryDetailsPresenter.getChoiceSection(menuItem3.f13861id);
                    return;
                }
                onReadyToAddItem(str);
                return;
            }
            onReadyToAddItem(str);
        }
    }

    public void onChoiceReceived(@Nullable SplitChoiceItemModel splitChoiceItemModel) {
        if (splitChoiceItemModel != null) {
            MenuItem menuItem = this.globalMenuItem;
            Intrinsics.checkNotNull(menuItem);
            menuItem.choiceSections = splitChoiceItemModel.choiceSections;
            onReadyToNavigatetoItemDetails();
        }
    }

    public void onCloseButtonClicked(@Nullable Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerGroceryDetailsViewScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        try {
            super.onCreate(bundle);
            setContentView((int) R.layout.grocery_details_view);
            this.menuSectionId = getIntent().getIntExtra("menuSectionId", -1);
            this.readyToUpdate.setValue(Boolean.FALSE);
            setHintText();
            inflateGemFooter();
            adjustSnackBar();
            ((RelativeLayout) _$_findCachedViewById(R.id.back)).setOnClickListener(new x6(this));
            this.enableSearchWithButtonClick = false;
            GlobalDataModel.MENU.isQuickAddEnabled = true;
            setMenuSection(getGroceryDetailsPresenter().getMenuSection(this.menuSectionId));
            Boolean value = GlobalDataModel.JSON.groceryMenuItemsLoadedForSection.getValue();
            Intrinsics.checkNotNull(value);
            if (!value.booleanValue()) {
                if (!getMenuSection().firstPageLoaded) {
                    startLodingPopup();
                    GlobalDataModel.JSON.groceryMenuItemsLoadedForSection.observe(this, new y6(this));
                    GlobalDataModel.JSON.netWorkErrorOccured.observe(this, new z6(this));
                }
            }
            setRecyclerView();
            GlobalDataModel.JSON.netWorkErrorOccured.observe(this, new z6(this));
        } catch (Exception e11) {
            e11.getLocalizedMessage().toString();
        }
    }

    public void onDataLoaded(@NotNull ArrayList<MenuItem> arrayList, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
        Intrinsics.checkNotNullParameter(arrayList, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "pagingInfo");
        stopLodingPopup();
        ((ProgressBar) _$_findCachedViewById(R.id.linear_progressBar)).setVisibility(8);
        if (TextUtils.isEmpty(StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) _$_findCachedViewById(R.id.search_field)).getText())).toString())) {
            ItemListAdapter itemListAdapter = this.itemListadapter;
            if (itemListAdapter == null) {
                ItemListAdapter itemListAdapter2 = new ItemListAdapter(this, arrayList);
                this.itemListadapter = itemListAdapter2;
                Intrinsics.checkNotNull(itemListAdapter2);
                itemListAdapter2.setHasStableIds(true);
                ((RecyclerView) _$_findCachedViewById(R.id.menu_items_recycler)).setAdapter(this.itemListadapter);
            } else {
                Intrinsics.checkNotNull(itemListAdapter);
                itemListAdapter.setMenu(arrayList);
                ItemListAdapter itemListAdapter3 = this.itemListadapter;
                Intrinsics.checkNotNull(itemListAdapter3);
                itemListAdapter3.notifyDataSetChanged();
            }
            if (this.loading) {
                this.pageNumber++;
            }
            this.totalPages = groceryItemsForSectionPagingInfo.getTotalPages();
            this.totalItemCount = groceryItemsForSectionPagingInfo.getTotalItems();
            ((TalabatTextView) _$_findCachedViewById(R.id.category_count)).setText(groceryItemsForSectionPagingInfo.getTotalItems() + " " + getString(R.string.grocery_items));
        }
        this.loading = false;
        this.decremented = false;
    }

    public void onDataLoadingError() {
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
        this.loading = false;
        ((ProgressBar) _$_findCachedViewById(R.id.linear_progressBar)).setVisibility(8);
        stopLoading();
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onItemAdded(@Nullable CartMenuItem cartMenuItem) {
        Cart.getInstance();
        cartCountChanged();
        showSingleToast();
        if (this.listUpdateRequired) {
            this.listUpdateRequired = false;
            ItemListAdapter itemListAdapter = this.itemListadapter;
            if (itemListAdapter != null) {
                itemListAdapter.notifyDataSetChanged();
            }
        }
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onMaxCartItemsReached() {
        Toast.makeText(this, getString(R.string.max_cart_items), 0).show();
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        adjustSnackBar();
        Boolean value = this.readyToUpdate.getValue();
        Intrinsics.checkNotNull(value);
        if (value.booleanValue()) {
            this.readyToUpdate.setValue(Boolean.FALSE);
            int i11 = this.previousSort;
            int i12 = this.RELEVANCE;
            if (i11 != i12) {
                getAllSelectedSortAndFilterCriteriaAndApply(i11);
            } else {
                this.previousSort = i12;
                TalabatRadioButton talabatRadioButton = (TalabatRadioButton) _$_findCachedViewById(R.id.relevance).findViewById(R.id.item_radio);
                Intrinsics.checkNotNullExpressionValue(talabatRadioButton, "relevance.item_radio");
                onRadioButtonClicked(talabatRadioButton);
                getGroceryDetailsPresenter().setSortAndFilterCriteria("", "original", "", "");
            }
        } else {
            this.readyToUpdate.observe(this, new q6(this));
        }
        Cart.getInstance();
        GlobalDataModel.MENU.AddToCartClicked = false;
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            if (GEMEngine.getInstance() != null) {
                GEMEngine instance = GEMEngine.getInstance();
                Intrinsics.checkNotNull(instance);
                instance.startListening(this, false);
            }
        } else if (GlobalDataModel.GEMCONSTANTS.menuCouponSupressed) {
            GlobalDataModel.GEMCONSTANTS.menuCouponSupressed = false;
            if (!this.reloadmenuCalled) {
                this.reloadmenuCalled = true;
                setRecyclerView();
            }
        }
        ItemListAdapter itemListAdapter = this.itemListadapter;
        if (itemListAdapter != null) {
            Intrinsics.checkNotNull(itemListAdapter);
            itemListAdapter.notifyDataSetChanged();
        }
    }

    public void onStop() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        getGroceryDetailsPresenter().clearLocalCache();
        super.onStop();
    }

    public void onTagSelected(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tagsString");
        ((TalabatFillButton) _$_findCachedViewById(R.id.apply)).performClick();
    }

    public final void resetTagsForSearch() {
        boolean z11;
        String str;
        GroceryTagsModel[] groceryTags = getGroceryDetailsPresenter().getGroceryTags();
        if (groceryTags != null) {
            if (groceryTags.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                TagsAdapter tagsAdapter2 = this.tagsAdapter;
                if (tagsAdapter2 != null) {
                    if (tagsAdapter2 != null) {
                        str = tagsAdapter2.getTagIdString();
                    } else {
                        str = null;
                    }
                    if (str != null && !Intrinsics.areEqual((Object) str, (Object) "") && !Intrinsics.areEqual((Object) str, (Object) "-1")) {
                        int i11 = R.id.tags_recyclerview;
                        ((RecyclerView) _$_findCachedViewById(i11)).setVisibility(0);
                        ArrayList arrayList = new ArrayList();
                        String string = getResources().getString(R.string.all);
                        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ocalization.R.string.all)");
                        arrayList.add(0, new GroceryTagsModel(-1, string, 0));
                        arrayList.addAll(1, ArraysKt___ArraysKt.toCollection((T[]) groceryTags, new ArrayList()));
                        ((RecyclerView) _$_findCachedViewById(i11)).scrollToPosition(0);
                        TagsAdapter tagsAdapter3 = this.tagsAdapter;
                        if (tagsAdapter3 != null) {
                            if (tagsAdapter3 != null) {
                                tagsAdapter3.setTagsArray(arrayList);
                            }
                            TagsAdapter tagsAdapter4 = this.tagsAdapter;
                            if (tagsAdapter4 != null) {
                                tagsAdapter4.setAllSelected(true, true);
                            }
                            TagsAdapter tagsAdapter5 = this.tagsAdapter;
                            if (tagsAdapter5 != null) {
                                tagsAdapter5.notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        this.tagsAdapter = new TagsAdapter(arrayList, this, this);
                        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(this.tagsAdapter);
                        return;
                    }
                    return;
                }
                return;
            }
            ((RecyclerView) _$_findCachedViewById(R.id.tags_recyclerview)).setVisibility(8);
            return;
        }
        ((RecyclerView) _$_findCachedViewById(R.id.tags_recyclerview)).setVisibility(8);
    }

    public void resetTagsRecyclerView() {
        this.resetTags = true;
    }

    public void sendGAForSearchApiCalled() {
    }

    public void setAllItemsLoaded(boolean z11) {
        stopLodingPopup();
        this.allItemsForCurrentKeywordLoaded = z11;
    }

    public final void setAppVersionProvider(@NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "<set-?>");
        this.appVersionProvider = appVersionProvider2;
    }

    public final void setDecremented(boolean z11) {
        this.decremented = z11;
    }

    public final void setEnableSearchWithButtonClick(boolean z11) {
        this.enableSearchWithButtonClick = z11;
    }

    public final void setFirstVisibleItem(int i11) {
        this.firstVisibleItem = i11;
    }

    public void setGroceryTags(@Nullable GroceryTagsModel[] groceryTagsModelArr, boolean z11, boolean z12) {
        boolean z13;
        if (groceryTagsModelArr != null) {
            if (groceryTagsModelArr.length == 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z13) {
                int i11 = R.id.tags_recyclerview;
                ((RecyclerView) _$_findCachedViewById(i11)).setVisibility(0);
                ArrayList arrayList = new ArrayList();
                String string = getResources().getString(R.string.all);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ocalization.R.string.all)");
                arrayList.add(0, new GroceryTagsModel(-1, string, 0));
                arrayList.addAll(1, ArraysKt___ArraysKt.toCollection((T[]) groceryTagsModelArr, new ArrayList()));
                if (!z11) {
                    TagsAdapter tagsAdapter2 = this.tagsAdapter;
                    if (tagsAdapter2 != null) {
                        if (tagsAdapter2 != null) {
                            tagsAdapter2.setTagsArray(arrayList);
                        }
                        TagsAdapter tagsAdapter3 = this.tagsAdapter;
                        if (tagsAdapter3 != null) {
                            tagsAdapter3.setAllSelected(z12, true);
                            return;
                        }
                        return;
                    }
                    TagsAdapter tagsAdapter4 = new TagsAdapter(arrayList, this, this);
                    this.tagsAdapter = tagsAdapter4;
                    tagsAdapter4.setAllSelected(false, true);
                    ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(this.tagsAdapter);
                } else if (this.resetTags) {
                    ((RecyclerView) _$_findCachedViewById(i11)).scrollToPosition(0);
                    TagsAdapter tagsAdapter5 = this.tagsAdapter;
                    if (tagsAdapter5 != null) {
                        if (tagsAdapter5 != null) {
                            tagsAdapter5.setTagsArray(arrayList);
                        }
                        TagsAdapter tagsAdapter6 = this.tagsAdapter;
                        if (tagsAdapter6 != null) {
                            tagsAdapter6.setAllSelected(true, false);
                        }
                        TagsAdapter tagsAdapter7 = this.tagsAdapter;
                        if (tagsAdapter7 != null) {
                            tagsAdapter7.notifyDataSetChanged();
                        }
                    } else {
                        TagsAdapter tagsAdapter8 = new TagsAdapter(arrayList, this, this);
                        this.tagsAdapter = tagsAdapter8;
                        tagsAdapter8.setAllSelected(true, true);
                        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(this.tagsAdapter);
                    }
                    this.resetTags = false;
                }
            } else {
                ((RecyclerView) _$_findCachedViewById(R.id.tags_recyclerview)).setVisibility(8);
            }
        } else {
            ((RecyclerView) _$_findCachedViewById(R.id.tags_recyclerview)).setVisibility(8);
        }
    }

    public void setIsUpdateRequired(boolean z11) {
        this.updateRequired = z11;
    }

    public void setItemsCount(@NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "sortedItemsItemsPagingInfo");
        this.totalPages = groceryItemsForSectionPagingInfo.getTotalPages();
        this.totalItemCount = groceryItemsForSectionPagingInfo.getTotalItems();
        int totalItems = groceryItemsForSectionPagingInfo.getTotalItems();
        String string = getString(R.string.grocery_items);
        ((TalabatTextView) _$_findCachedViewById(R.id.category_count)).setText(totalItems + " " + string);
    }

    public final void setMenuSection(@NotNull MenuSection menuSection2) {
        Intrinsics.checkNotNullParameter(menuSection2, "<set-?>");
        this.menuSection = menuSection2;
    }

    public final void setPageNumber(int i11) {
        this.pageNumber = i11;
    }

    public final void setPreviousBrand(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.previousBrand = str;
    }

    public final void setPreviousSort(int i11) {
        this.previousSort = i11;
    }

    public final void setRadioButtons(@Nullable RadioButton[] radioButtonArr) {
        this.radioButtons = radioButtonArr;
    }

    public final void setReadyToUpdate(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.readyToUpdate = mutableLiveData;
    }

    public final void setSelectedSort(int i11) {
        this.selectedSort = i11;
    }

    public final void setToast(@Nullable Toast toast2) {
        this.toast = toast2;
    }

    public final void setTotalItemCount(int i11) {
        this.totalItemCount = i11;
    }

    public final void setTotalPages(int i11) {
        this.totalPages = i11;
    }

    public final void setVisibilityControlledViews(@NotNull ArrayList<Pair<View, View>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.visibilityControlledViews = arrayList;
    }

    public final void setVisibleItemCount(int i11) {
        this.visibleItemCount = i11;
    }

    public final void setVisibleThreshold(int i11) {
        this.visibleThreshold = i11;
    }

    public void showClearButton(boolean z11) {
        if (z11) {
            ((ImageView) _$_findCachedViewById(R.id.clear_text)).setVisibility(0);
        } else {
            ((ImageView) _$_findCachedViewById(R.id.clear_text)).setVisibility(8);
        }
    }

    public void showEmptyScreen(boolean z11, boolean z12) {
        if (z11) {
            AppTracker.onSearchErrorShown(this, ScreenNames.getScreenType(getScreenName()), getScreenName(), StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) _$_findCachedViewById(R.id.search_field)).getText())).toString());
            String string = getString(R.string.grocery_items);
            ((TalabatTextView) _$_findCachedViewById(R.id.category_count)).setText("0 " + string);
            if (z12) {
                int i11 = R.id.first_sentence;
                ((TalabatTextView) _$_findCachedViewById(i11)).setVisibility(0);
                ((TalabatTextView) _$_findCachedViewById(R.id.second_sentence)).setVisibility(8);
                ((TalabatTextView) _$_findCachedViewById(i11)).setText(getResources().getString(R.string.no_items_found));
            } else {
                int i12 = R.id.first_sentence;
                ((TalabatTextView) _$_findCachedViewById(i12)).setVisibility(0);
                ((TalabatTextView) _$_findCachedViewById(R.id.second_sentence)).setVisibility(0);
                ((TalabatTextView) _$_findCachedViewById(i12)).setText(getResources().getString(R.string.this_item_is_not_on_the_menu));
            }
            ((LinearLayout) _$_findCachedViewById(R.id.no_items_view)).setVisibility(0);
            ((RecyclerView) _$_findCachedViewById(R.id.menu_items_recycler)).setVisibility(8);
            return;
        }
        ((LinearLayout) _$_findCachedViewById(R.id.no_items_view)).setVisibility(8);
        ((RecyclerView) _$_findCachedViewById(R.id.menu_items_recycler)).setVisibility(0);
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public /* synthetic */ void showInAppReminder(int i11) {
        v00.a.b(this, i11);
    }

    public void showLoading() {
        ((ProgressBar) _$_findCachedViewById(R.id.linear_progressBar)).setVisibility(0);
    }

    public void showRestaurantChangePopup(@Nullable Restaurant restaurant, @NotNull CartMenuItem cartMenuItem) {
        Intrinsics.checkNotNullParameter(cartMenuItem, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String string = getString(R.string.cart_will_be_cleared);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.cart_will_be_cleared)");
        String replace$default = StringsKt__StringsJVMKt.replace$default(string, "#", "\"" + instance.getRestaurant().f13873name + "\"", false, 4, (Object) null);
        builder.setTitle((CharSequence) getString(R.string.start_new_cart));
        builder.setMessage((CharSequence) replace$default);
        builder.setPositiveButton((CharSequence) getString(R.string.start), (DialogInterface.OnClickListener) new s6(this, restaurant, cartMenuItem));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showTimeOutDialog() {
        GemDialogSwitcher gemDialogSwitcher = this.mGemDialogSwitcher;
        GemFooterCartView gemFooterCartView = this.gemFooter;
        if (gemFooterCartView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gemFooter");
            gemFooterCartView = null;
        }
        showGemTimeOutDialog(gemDialogSwitcher, gemFooterCartView, this, this);
    }

    public void showTimerView(boolean z11, @Nullable String str) {
        GemFooterCartView gemFooterCartView = this.gemFooter;
        if (gemFooterCartView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gemFooter");
            gemFooterCartView = null;
        }
        gemFooterCartView.setTimerText(str);
    }

    public void stopLoading() {
        ((ProgressBar) _$_findCachedViewById(R.id.linear_progressBar)).setVisibility(8);
    }

    public void updateList(@NotNull ArrayList<MenuItem> arrayList, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, @Nullable String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(arrayList, "menuItems");
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo, "searchPagingInfo");
        stopLodingPopup();
        String previousTagString = getGroceryDetailsPresenter().getPreviousTagString();
        int i11 = R.id.search_field;
        if (StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) _$_findCachedViewById(i11)).getText())).toString().equals(str)) {
            if (StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) _$_findCachedViewById(i11)).getText())).toString().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && Intrinsics.areEqual((Object) previousTagString, (Object) getTagNamesString())) {
                this.searchPageNumber++;
                this.totalItemCount = groceryItemsForSectionPagingInfo.getTotalItems();
                ((TalabatTextView) _$_findCachedViewById(R.id.category_count)).setText(groceryItemsForSectionPagingInfo.getTotalItems() + " " + getString(R.string.grocery_items));
            }
        }
        this.loading = false;
        ItemListAdapter itemListAdapter = this.itemListadapter;
        if (itemListAdapter == null) {
            ItemListAdapter itemListAdapter2 = new ItemListAdapter(this, arrayList);
            this.itemListadapter = itemListAdapter2;
            Intrinsics.checkNotNull(itemListAdapter2);
            itemListAdapter2.setHasStableIds(true);
            ((RecyclerView) _$_findCachedViewById(R.id.menu_items_recycler)).setAdapter(this.itemListadapter);
            return;
        }
        if (this.searchPageNumber > 2) {
            Intrinsics.checkNotNull(itemListAdapter);
            ArrayList<MenuItem> dataList = itemListAdapter.getDataList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<MenuItem> it = dataList.iterator();
            while (it.hasNext()) {
                MenuItem next = it.next();
                if (!arrayList2.contains(next)) {
                    arrayList2.add(next);
                }
            }
            Iterator<MenuItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                MenuItem next2 = it2.next();
                if (!arrayList2.contains(next2)) {
                    arrayList2.add(next2);
                }
            }
            ItemListAdapter itemListAdapter3 = this.itemListadapter;
            Intrinsics.checkNotNull(itemListAdapter3);
            itemListAdapter3.setMenu(arrayList2);
        } else {
            Intrinsics.checkNotNull(itemListAdapter);
            itemListAdapter.setMenu(arrayList);
        }
        ItemListAdapter itemListAdapter4 = this.itemListadapter;
        Intrinsics.checkNotNull(itemListAdapter4);
        itemListAdapter4.notifyDataSetChanged();
        if (this.searchPageNumber == 2) {
            ((RecyclerView) _$_findCachedViewById(R.id.menu_items_recycler)).scrollToPosition(0);
        }
    }

    private final String getSelectedSort(int i11) {
        if (i11 == this.RELEVANCE) {
            return "relevance";
        }
        if (i11 == this.HIGH_LOW) {
            return "price_high_low";
        }
        if (i11 == this.LOW_HIGH) {
            return "price_low_high";
        }
        if (i11 == this.A_Z) {
            return "a_z";
        }
        if (i11 == this.Z_A) {
            return "z_a";
        }
        return "relevance";
    }

    public void onNavigateToItemDetails(@Nullable CartMenuItem cartMenuItem) {
        GlobalDataModel.SELECTED.cartMenuItem = cartMenuItem;
        startActivity(new Intent(this, ItemDetailsActivity.class));
        stopLodingPopup();
    }
}
