package com.braze;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import bo.app.a4;
import bo.app.b5;
import bo.app.b6;
import bo.app.c6;
import bo.app.h4;
import bo.app.j;
import bo.app.k4;
import bo.app.l4;
import bo.app.t6;
import bo.app.u6;
import bo.app.v3;
import bo.app.z3;
import bo.app.z4;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.models.cards.Card;
import com.appboy.models.push.BrazeNotificationPayload;
import com.braze.configuration.BrazeConfig;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.configuration.RuntimeAppConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.events.BrazeNetworkFailureEvent;
import com.braze.events.BrazePushEvent;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.IValueCallback;
import com.braze.events.InAppMessageEvent;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.events.SdkDataWipeEvent;
import com.braze.events.SessionStateChangedEvent;
import com.braze.images.DefaultBrazeImageLoader;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.FeatureFlag;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.PermissionUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 ì\u00012\u00020\u0001:\u0002ì\u0001B\u0015\b\u0001\u0012\b\u0010é\u0001\u001a\u00030®\u0001¢\u0006\u0006\bê\u0001\u0010ë\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002Ja\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00022'\u0010\u001a\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015¢\u0006\u0002\b\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J&\u0010)\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J0\u0010)\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J.\u0010)\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010+\u001a\u00020*H\u0016J8\u0010)\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010+\u001a\u00020*2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J&\u00102\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u00100\u001a\u0004\u0018\u00010\r2\b\u00101\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u00104\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u00010\rH\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0002H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010>\u001a\u00020\rH\u0016J\b\u0010@\u001a\u00020\u0004H\u0016J\u0016\u0010D\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020B0AH\u0016J\u0016\u0010F\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0AH\u0016J\u0016\u0010H\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020G0AH\u0016J\u0016\u0010J\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020I0AH\u0016J\u0016\u0010L\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020K0AH\u0016J\u0016\u0010N\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020M0AH\u0016J\u0016\u0010P\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020O0AH\u0016J\u0016\u0010R\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020Q0AH\u0016J\u0016\u0010T\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020S0AH\u0016J*\u0010W\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00102\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000A2\f\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000UH\u0016J,\u0010X\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00102\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010A2\f\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000UH\u0016J\u0012\u0010Z\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010Z\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\r2\b\u0010[\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010_\u001a\u00020\u00042\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0016J\b\u0010`\u001a\u00020*H\u0016J\b\u0010a\u001a\u00020*H\u0016J\b\u0010c\u001a\u00020bH\u0016J\u0010\u0010e\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010;H\u0016J\u0014\u0010g\u001a\u0004\u0018\u00010d2\b\u0010f\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010g\u001a\u0004\u0018\u00010d2\b\u0010i\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010k\u001a\u00020\u00042\b\u0010j\u001a\u0004\u0018\u00010\rH\u0017J\u0012\u0010l\u001a\u00020\u00042\b\u0010j\u001a\u0004\u0018\u00010\rH\u0017J\u0014\u0010o\u001a\u0004\u0018\u00010n2\b\u0010m\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010s\u001a\u00020\u00042\u0006\u0010q\u001a\u00020p2\u0006\u0010r\u001a\u00020pH\u0016J\b\u0010t\u001a\u00020\u0004H\u0016J\u0018\u0010w\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\r2\u0006\u0010v\u001a\u00020\u0002H\u0016J\u0010\u0010y\u001a\u00020\u00042\u0006\u0010x\u001a\u00020\rH\u0016J#\u0010\u001a\u00020\u00042\b\u0010z\u001a\u0004\u0018\u00010\r2\b\u0010|\u001a\u0004\u0018\u00010{H\u0000¢\u0006\u0004\b}\u0010~J\u001e\u0010\u0001\u001a\u00020\u00042\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0002H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\r2\b\u0010Y\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020BH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J&\u0010¡\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0006\b\u0001\u0010 \u0001J\u0012\u0010£\u0001\u001a\u00020\u0004H\u0001¢\u0006\u0006\b¢\u0001\u0010\u0001J:\u0010¦\u0001\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0001¢\u0006\u0006\b¤\u0001\u0010¥\u0001R*\u0010¨\u0001\u001a\u00030§\u00018\u0016@\u0016X.¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010­\u0001R\u001a\u0010¯\u0001\u001a\u00030®\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010±\u0001\u001a\u00020]8\u0002@\u0002X.¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R3\u0010³\u0001\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006 \n\u0006\b³\u0001\u0010´\u0001\u0012\u0006\b¹\u0001\u0010\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\u0019\u0010º\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R2\u0010½\u0001\u001a\u00030¼\u00018\u0000@\u0000X.¢\u0006 \n\u0006\b½\u0001\u0010¾\u0001\u0012\u0006\bÃ\u0001\u0010\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010Æ\u0001\u001a\u0004\u0018\u00010G8BX\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R2\u0010È\u0001\u001a\u00030Ç\u00018\u0000@\u0000X.¢\u0006 \n\u0006\bÈ\u0001\u0010É\u0001\u0012\u0006\bÎ\u0001\u0010\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R2\u0010Ð\u0001\u001a\u00030Ï\u00018\u0000@\u0000X\u000e¢\u0006 \n\u0006\bÐ\u0001\u0010Ñ\u0001\u0012\u0006\bÖ\u0001\u0010\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R2\u0010Ø\u0001\u001a\u00030×\u00018\u0000@\u0000X.¢\u0006 \n\u0006\bØ\u0001\u0010Ù\u0001\u0012\u0006\bÞ\u0001\u0010\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R\u0017\u0010á\u0001\u001a\u00020\r8VX\u0004¢\u0006\b\u001a\u0006\bß\u0001\u0010à\u0001R\u0018\u0010ã\u0001\u001a\u0004\u0018\u00010]8VX\u0004¢\u0006\u0007\u001a\u0005\b_\u0010â\u0001R.\u0010è\u0001\u001a\u0004\u0018\u00010\r2\t\u0010ä\u0001\u001a\u0004\u0018\u00010\r8V@VX\u000e¢\u0006\u0010\u001a\u0006\bå\u0001\u0010à\u0001\"\u0006\bæ\u0001\u0010ç\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006í\u0001"}, d2 = {"Lcom/braze/Braze;", "Lcom/braze/IBraze;", "", "isOffline", "", "setSyncPolicyOfflineStatus", "", "throwable", "publishError", "verifyProperSdkSetup", "Lbo/app/u6;", "dependencyProvider", "setUserSpecificMemberVariablesAndStartDispatch", "", "key", "isEphemeralEventKey", "T", "defaultValueOnException", "Lkotlin/Function0;", "errorLog", "earlyReturnIfDisabled", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "runForResult", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Landroid/app/Activity;", "activity", "openSession", "closeSession", "eventName", "logCustomEvent", "Lcom/braze/models/outgoing/BrazeProperties;", "properties", "productId", "currencyCode", "Ljava/math/BigDecimal;", "price", "logPurchase", "", "quantity", "campaignId", "logPushNotificationOpened", "Landroid/content/Intent;", "intent", "actionId", "actionType", "logPushNotificationActionClicked", "pageId", "logPushStoryPageClicked", "logFeedDisplayed", "requestFeedRefreshFromCache", "requestFeedRefresh", "fromCache", "requestContentCardsRefresh", "refreshFeatureFlags", "", "Lcom/braze/models/FeatureFlag;", "getAllFeatureFlags", "id", "getFeatureFlag", "requestImmediateDataFlush", "Lcom/braze/events/IEventSubscriber;", "Lcom/braze/events/InAppMessageEvent;", "subscriber", "subscribeToNewInAppMessages", "Lcom/braze/events/NoMatchingTriggerEvent;", "subscribeToNoMatchingTriggerForEvent", "Lcom/braze/events/ContentCardsUpdatedEvent;", "subscribeToContentCardsUpdates", "Lcom/braze/events/FeatureFlagsUpdatedEvent;", "subscribeToFeatureFlagsUpdates", "Lcom/appboy/events/FeedUpdatedEvent;", "subscribeToFeedUpdates", "Lcom/braze/events/SessionStateChangedEvent;", "subscribeToSessionUpdates", "Lcom/braze/events/BrazeNetworkFailureEvent;", "subscribeToNetworkFailures", "Lcom/braze/events/BrazeSdkAuthenticationErrorEvent;", "subscribeToSdkAuthenticationFailures", "Lcom/braze/events/BrazePushEvent;", "subscribeToPushNotificationEvents", "Ljava/lang/Class;", "eventClass", "addSingleSynchronousSubscription", "removeSingleSubscription", "userId", "changeUser", "sdkAuthSignature", "Lcom/braze/events/IValueCallback;", "Lcom/braze/BrazeUser;", "completionCallback", "getCurrentUser", "getContentCardCount", "getContentCardUnviewedCount", "", "getContentCardsLastUpdatedInSecondsFromEpoch", "Lcom/appboy/models/cards/Card;", "getCachedContentCards", "contentCardString", "deserializeContentCard", "Lorg/json/JSONObject;", "contentCardJson", "cardId", "logFeedCardImpression", "logFeedCardClick", "inAppMessageString", "Lcom/braze/models/inappmessage/IInAppMessage;", "deserializeInAppMessageString", "", "latitude", "longitude", "requestGeofences", "requestLocationInitialization", "googleAdvertisingId", "isLimitAdTrackingEnabled", "setGoogleAdvertisingId", "signature", "setSdkAuthenticationSignature", "geofenceId", "Lbo/app/o1;", "transitionType", "recordGeofenceTransition$android_sdk_base_release", "(Ljava/lang/String;Lbo/app/o1;)V", "recordGeofenceTransition", "Lbo/app/a2;", "location", "requestGeofenceRefresh$android_sdk_base_release", "(Lbo/app/a2;)V", "requestGeofenceRefresh", "ignoreRateLimit", "(Z)V", "serializedCardJson", "addSerializedCardJsonToStorage$android_sdk_base_release", "(Ljava/lang/String;Ljava/lang/String;)V", "addSerializedCardJsonToStorage", "logLocationRecordedEventFromLocationUpdate$android_sdk_base_release", "logLocationRecordedEventFromLocationUpdate", "requestGeofencesInitialization$android_sdk_base_release", "()V", "requestGeofencesInitialization", "requestSingleLocationUpdate$android_sdk_base_release", "requestSingleLocationUpdate", "handleInAppMessageTestPush$android_sdk_base_release", "(Landroid/content/Intent;)V", "handleInAppMessageTestPush", "applyPendingRuntimeConfiguration$android_sdk_base_release", "applyPendingRuntimeConfiguration", "event", "retryInAppMessage$android_sdk_base_release", "(Lcom/braze/events/InAppMessageEvent;)V", "retryInAppMessage", "Lcom/braze/enums/BrazePushEventType;", "pushActionType", "Lcom/appboy/models/push/BrazeNotificationPayload;", "payload", "publishBrazePushAction$android_sdk_base_release", "(Lcom/braze/enums/BrazePushEventType;Lcom/appboy/models/push/BrazeNotificationPayload;)V", "publishBrazePushAction", "waitForUserDependencyThread$android_sdk_base_release", "waitForUserDependencyThread", "run$android_sdk_base_release", "(Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;)V", "run", "Lcom/braze/images/IBrazeImageLoader;", "imageLoader", "Lcom/braze/images/IBrazeImageLoader;", "getImageLoader", "()Lcom/braze/images/IBrazeImageLoader;", "setImageLoader", "(Lcom/braze/images/IBrazeImageLoader;)V", "Landroid/content/Context;", "applicationContext", "Landroid/content/Context;", "brazeUser", "Lcom/braze/BrazeUser;", "isApiKeyPresent", "Ljava/lang/Boolean;", "isApiKeyPresent$android_sdk_base_release", "()Ljava/lang/Boolean;", "setApiKeyPresent$android_sdk_base_release", "(Ljava/lang/Boolean;)V", "isApiKeyPresent$android_sdk_base_release$annotations", "isInstanceStopped", "Z", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "getConfigurationProvider$android_sdk_base_release", "()Lcom/braze/configuration/BrazeConfigurationProvider;", "setConfigurationProvider$android_sdk_base_release", "(Lcom/braze/configuration/BrazeConfigurationProvider;)V", "getConfigurationProvider$android_sdk_base_release$annotations", "getCachedContentCardsUpdatedEvent", "()Lcom/braze/events/ContentCardsUpdatedEvent;", "cachedContentCardsUpdatedEvent", "Lbo/app/g2;", "deviceIdReader", "Lbo/app/g2;", "getDeviceIdReader$android_sdk_base_release", "()Lbo/app/g2;", "setDeviceIdReader$android_sdk_base_release", "(Lbo/app/g2;)V", "getDeviceIdReader$android_sdk_base_release$annotations", "Lbo/app/j2;", "externalIEventMessenger", "Lbo/app/j2;", "getExternalIEventMessenger$android_sdk_base_release", "()Lbo/app/j2;", "setExternalIEventMessenger$android_sdk_base_release", "(Lbo/app/j2;)V", "getExternalIEventMessenger$android_sdk_base_release$annotations", "Lbo/app/c3;", "udm", "Lbo/app/c3;", "getUdm$android_sdk_base_release", "()Lbo/app/c3;", "setUdm$android_sdk_base_release", "(Lbo/app/c3;)V", "getUdm$android_sdk_base_release$annotations", "getDeviceId", "()Ljava/lang/String;", "deviceId", "()Lcom/braze/BrazeUser;", "currentUser", "value", "getRegisteredPushToken", "setRegisteredPushToken", "(Ljava/lang/String;)V", "registeredPushToken", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class Braze implements IBraze {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Set<String> KNOWN_APP_CRAWLER_DEVICE_MODELS = SetsKt__SetsJVMKt.setOf("calypso appcrawler");
    private static final Set<String> NECESSARY_APPBOY_SDK_PERMISSIONS = SetsKt__SetsKt.setOf("android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET");
    /* access modifiers changed from: private */
    public static boolean areOutboundNetworkRequestsOffline;
    /* access modifiers changed from: private */
    public static final ReentrantLock brazeClassLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static final BrazeConfig clearConfigSentinel = new BrazeConfig.Builder().build();
    /* access modifiers changed from: private */
    public static IBrazeNotificationFactory customBrazeNotificationFactory;
    /* access modifiers changed from: private */
    public static IBrazeEndpointProvider endpointProvider;
    /* access modifiers changed from: private */
    public static final ReentrantLock endpointProviderLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static volatile Braze instance;
    /* access modifiers changed from: private */
    public static final List<BrazeConfig> pendingConfigurations = new ArrayList();
    /* access modifiers changed from: private */
    public static z4 sdkEnablementProvider;
    /* access modifiers changed from: private */
    public static boolean shouldMockNetworkRequestsAndDropEvents;
    /* access modifiers changed from: private */
    public Context applicationContext;
    /* access modifiers changed from: private */
    public BrazeUser brazeUser;
    public BrazeConfigurationProvider configurationProvider;
    public bo.app.g2 deviceIdReader;
    private bo.app.j2 externalIEventMessenger;
    public IBrazeImageLoader imageLoader;
    private Boolean isApiKeyPresent;
    /* access modifiers changed from: private */
    public boolean isInstanceStopped;
    /* access modifiers changed from: private */
    public v3 offlineUserStorageProvider;
    /* access modifiers changed from: private */
    public bo.app.m2 registrationDataProvider;
    /* access modifiers changed from: private */
    public b6 testUserDeviceLoggingManager;
    public bo.app.c3 udm;

    @Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\\\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u001e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0007J\b\u0010\u001d\u001a\u00020\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0019\u0010$\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b\"\u0010#J\u001f\u0010+\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b)\u0010*J\u000f\u0010.\u001a\u00020\u0010H\u0001¢\u0006\u0004\b,\u0010-J\u000f\u00100\u001a\u00020\u0010H\u0001¢\u0006\u0004\b/\u0010-R*\u00101\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b1\u00102\u0012\u0004\b7\u0010-\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b9\u0010:\u0012\u0004\b?\u0010-\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R*\u0010F\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00068F@FX\u000e¢\u0006\u0012\u0012\u0004\bE\u0010-\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010G\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\bH\u0010-\u001a\u0004\bG\u0010BR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010KR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010TR\u0014\u0010U\u001a\u00020O8\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00160X8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010N¨\u0006]"}, d2 = {"Lcom/braze/Braze$Companion;", "", "Landroid/content/Context;", "context", "Lbo/app/z4;", "getSdkEnablementProvider", "", "shouldAllowSingletonInitialization", "Lcom/braze/Braze;", "getInstance", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "", "getConfiguredApiKey", "Lcom/braze/IBrazeEndpointProvider;", "endpointProvider", "", "setEndpointProvider", "clearEndpointProvider", "Landroid/net/Uri;", "brazeEndpoint", "getApiEndpoint", "Lcom/braze/configuration/BrazeConfig;", "config", "configure", "Ljava/util/EnumSet;", "Lcom/braze/enums/BrazeSdkMetadata;", "sdkMetadata", "addSdkMetadata", "enableMockNetworkRequestsAndDropEventsMode", "disableSdk", "enableSdk", "wipeData", "configuredCustomEndpoint", "setConfiguredCustomEndpoint$android_sdk_base_release", "(Ljava/lang/String;)V", "setConfiguredCustomEndpoint", "Landroid/content/Intent;", "intent", "Lbo/app/b2;", "brazeManager", "requestTriggersIfInAppMessageTestPush$android_sdk_base_release", "(Landroid/content/Intent;Lbo/app/b2;)V", "requestTriggersIfInAppMessageTestPush", "stopInstance$android_sdk_base_release", "()V", "stopInstance", "clearInstance$android_sdk_base_release", "clearInstance", "sdkEnablementProvider", "Lbo/app/z4;", "getSdkEnablementProvider$android_sdk_base_release", "()Lbo/app/z4;", "setSdkEnablementProvider$android_sdk_base_release", "(Lbo/app/z4;)V", "getSdkEnablementProvider$android_sdk_base_release$annotations", "Lcom/braze/IBrazeNotificationFactory;", "customBrazeNotificationFactory", "Lcom/braze/IBrazeNotificationFactory;", "getCustomBrazeNotificationFactory", "()Lcom/braze/IBrazeNotificationFactory;", "setCustomBrazeNotificationFactory", "(Lcom/braze/IBrazeNotificationFactory;)V", "getCustomBrazeNotificationFactory$annotations", "isOffline", "getOutboundNetworkRequestsOffline", "()Z", "setOutboundNetworkRequestsOffline", "(Z)V", "getOutboundNetworkRequestsOffline$annotations", "outboundNetworkRequestsOffline", "isDisabled", "isDisabled$annotations", "", "KNOWN_APP_CRAWLER_DEVICE_MODELS", "Ljava/util/Set;", "NECESSARY_APPBOY_SDK_PERMISSIONS", "areOutboundNetworkRequestsOffline", "Z", "Ljava/util/concurrent/locks/ReentrantLock;", "brazeClassLock", "Ljava/util/concurrent/locks/ReentrantLock;", "clearConfigSentinel", "Lcom/braze/configuration/BrazeConfig;", "Lcom/braze/IBrazeEndpointProvider;", "endpointProviderLock", "instance", "Lcom/braze/Braze;", "", "pendingConfigurations", "Ljava/util/List;", "shouldMockNetworkRequestsAndDropEvents", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ EnumSet<BrazeSdkMetadata> f43260g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(EnumSet<BrazeSdkMetadata> enumSet) {
                super(0);
                this.f43260g = enumSet;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Failed to add SDK Metadata of: ", this.f43260g);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a0 extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a0 f43261b = new a0();

            public a0() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to delete data from the internal storage cache.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f43262b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Clearing Braze instance";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b0 extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ File f43263g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b0(File file) {
                super(0);
                this.f43263g = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Deleting shared prefs file at: ", this.f43263g.getAbsolutePath());
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BrazeConfig f43264g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(BrazeConfig brazeConfig) {
                super(0);
                this.f43264g = brazeConfig;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Braze.configure() called with configuration: ", this.f43264g);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c0 extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c0 f43265b = new c0();

            public c0() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to delete shared preference data for the Braze SDK.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final d f43266b = new d();

            public d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze.configure() cannot be called while the singleton is still live.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final e f43267b = new e();

            public e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze.configure() called with a null config; Clearing all configuration values.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final f f43268b = new f();

            public f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Stopping the SDK instance.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class g extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final g f43269b = new g();

            public g() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Disabling all network requests";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class h extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final h f43270b = new h();

            public h() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze network requests already being mocked. Note that events dispatched in this mode are dropped.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class i extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final i f43271b = new i();

            public i() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze network requests will be mocked. Events dispatchedin this mode will be dropped.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class j extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final j f43272b = new j();

            public j() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Attempt to enable mocking Braze network requests had no effect since getInstance() has already been called.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class k extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final k f43273b = new k();

            public k() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Setting SDK to enabled.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class l extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final l f43274b = new l();

            public l() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Enabling all network requests";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class m extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final m f43275b = new m();

            public m() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught exception trying to get a Braze API endpoint from the BrazeEndpointProvider. Using the original URI";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class n extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final n f43276b = new n();

            public n() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught exception while retrieving API key.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class o extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final o f43277b = new o();

            public o() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK enablement provider was null. Returning SDK as enabled.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class p extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final p f43278b = new p();

            public p() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "API key not present. Actions will not be performed on the SDK.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class q extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final q f43279b = new q();

            public q() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK is disabled. Actions will not be performed on the SDK.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class r extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f43280g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public r(boolean z11) {
                super(0);
                this.f43280g = z11;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Braze SDK outbound network requests are now ", this.f43280g ? "disabled" : "enabled");
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class s extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final s f43281b = new s();

            public s() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push contained key for fetching test triggers, fetching triggers.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class t extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final t f43282b = new t();

            public t() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "The instance is null. Allowing instance initialization";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class u extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final u f43283b = new u();

            public u() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "The instance was stopped. Allowing instance initialization";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class v extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final v f43284b = new v();

            public v() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No API key was found previously. Allowing instance initialization";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class w extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final w f43285b = new w();

            public w() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Shutting down all queued work on the Braze SDK";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class x extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final x f43286b = new x();

            public x() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Sending sdk data wipe event to external subscribers";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class y extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final y f43287b = new y();

            public y() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Shutting down the singleton work queue";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class z extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final z f43288b = new z();

            public z() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to shutdown queued work on the Braze SDK.";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getCustomBrazeNotificationFactory$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getOutboundNetworkRequestsOffline$annotations() {
        }

        /* access modifiers changed from: private */
        public final z4 getSdkEnablementProvider(Context context) {
            z4 sdkEnablementProvider$android_sdk_base_release = getSdkEnablementProvider$android_sdk_base_release();
            if (sdkEnablementProvider$android_sdk_base_release != null) {
                return sdkEnablementProvider$android_sdk_base_release;
            }
            z4 z4Var = new z4(context);
            setSdkEnablementProvider$android_sdk_base_release(z4Var);
            return z4Var;
        }

        public static /* synthetic */ void getSdkEnablementProvider$android_sdk_base_release$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isDisabled$annotations() {
        }

        /* access modifiers changed from: private */
        /* renamed from: setConfiguredCustomEndpoint$lambda-12$lambda-11  reason: not valid java name */
        public static final Uri m9193setConfiguredCustomEndpoint$lambda12$lambda11(String str, Uri uri) {
            boolean z11;
            Intrinsics.checkNotNullParameter(uri, "brazeEndpoint");
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String encodedAuthority = parse.getEncodedAuthority();
            Uri.Builder buildUpon = uri.buildUpon();
            boolean z12 = false;
            if (scheme == null || StringsKt__StringsJVMKt.isBlank(scheme)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (encodedAuthority == null || StringsKt__StringsJVMKt.isBlank(encodedAuthority)) {
                    z12 = true;
                }
                if (!z12) {
                    buildUpon.encodedAuthority(encodedAuthority);
                    buildUpon.scheme(scheme);
                    return buildUpon.build();
                }
            }
            return buildUpon.encodedAuthority(str).build();
        }

        private final boolean shouldAllowSingletonInitialization() {
            Braze access$getInstance$cp = Braze.instance;
            if (access$getInstance$cp == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) t.f43282b, 6, (Object) null);
                return true;
            } else if (access$getInstance$cp.isInstanceStopped) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) u.f43283b, 7, (Object) null);
                return true;
            } else if (!Intrinsics.areEqual((Object) Boolean.FALSE, (Object) access$getInstance$cp.isApiKeyPresent$android_sdk_base_release())) {
                return false;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) v.f43284b, 7, (Object) null);
                return true;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: wipeData$lambda-9  reason: not valid java name */
        public static final boolean m9194wipeData$lambda9(File file, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            if (!StringsKt__StringsJVMKt.startsWith$default(str, "com.appboy", false, 2, (Object) null) || Intrinsics.areEqual((Object) str, (Object) "com.appboy.override.configuration.cache")) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final void addSdkMetadata(Context context, EnumSet<BrazeSdkMetadata> enumSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(enumSet, "sdkMetadata");
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze.pendingConfigurations.add(new BrazeConfig.Builder().setSdkMetadata(enumSet).build());
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.applyPendingRuntimeConfiguration$android_sdk_base_release();
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new a(enumSet), 4, (Object) null);
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                access$getBrazeClassLock$cp.unlock();
                throw th2;
            }
            access$getBrazeClassLock$cp.unlock();
        }

        @JvmStatic
        public final void clearEndpointProvider() {
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                Braze.endpointProvider = null;
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getEndpointProviderLock$cp.unlock();
            }
        }

        public final /* synthetic */ void clearInstance$android_sdk_base_release() {
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze access$getInstance$cp = Braze.instance;
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                Companion companion = Braze.Companion;
                BrazeLogger.brazelog$default(brazeLogger, (Object) companion, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43262b, 6, (Object) null);
                BrazeCoroutineScope.cancelChildren();
                if (access$getInstance$cp != null) {
                    if (access$getInstance$cp.udm != null) {
                        access$getInstance$cp.getUdm$android_sdk_base_release().d().g();
                    }
                }
                Braze.instance = null;
                Braze.shouldMockNetworkRequestsAndDropEvents = false;
                Braze.areOutboundNetworkRequestsOffline = false;
                companion.setSdkEnablementProvider$android_sdk_base_release((z4) null);
                Braze.endpointProvider = null;
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getBrazeClassLock$cp.unlock();
            }
        }

        /* JADX INFO: finally extract failed */
        @JvmStatic
        public final boolean configure(Context context, BrazeConfig brazeConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(brazeConfig), 7, (Object) null);
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp == null || access$getInstance$cp.isInstanceStopped || !Intrinsics.areEqual((Object) Boolean.TRUE, (Object) access$getInstance$cp.isApiKeyPresent$android_sdk_base_release())) {
                    if (brazeConfig != null) {
                        Braze.pendingConfigurations.add(brazeConfig);
                    } else {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) e.f43267b, 6, (Object) null);
                        Braze.pendingConfigurations.add(Braze.clearConfigSentinel);
                    }
                    access$getBrazeClassLock$cp.unlock();
                    return true;
                }
                BrazeLogger.brazelog$default(brazeLogger, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) d.f43266b, 6, (Object) null);
                access$getBrazeClassLock$cp.unlock();
                return false;
            } catch (Throwable th2) {
                access$getBrazeClassLock$cp.unlock();
                throw th2;
            }
        }

        @JvmStatic
        public final void disableSdk(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            getSdkEnablementProvider(context).a(true);
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger brazeLogger2 = brazeLogger;
            BrazeLogger.Priority priority = BrazeLogger.Priority.W;
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) f.f43268b, 6, (Object) null);
            stopInstance$android_sdk_base_release();
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) g.f43269b, 6, (Object) null);
            setOutboundNetworkRequestsOffline(true);
        }

        @JvmStatic
        public final boolean enableMockNetworkRequestsAndDropEventsMode() {
            if (Braze.instance == null) {
                ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
                access$getBrazeClassLock$cp.lock();
                try {
                    if (Braze.instance == null) {
                        if (Braze.shouldMockNetworkRequestsAndDropEvents) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) h.f43270b, 6, (Object) null);
                        } else {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) i.f43271b, 6, (Object) null);
                            Braze.shouldMockNetworkRequestsAndDropEvents = true;
                        }
                        return true;
                    }
                    Unit unit = Unit.INSTANCE;
                    access$getBrazeClassLock$cp.unlock();
                } finally {
                    access$getBrazeClassLock$cp.unlock();
                }
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) j.f43272b, 6, (Object) null);
            return false;
        }

        @JvmStatic
        public final void enableSdk(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger brazeLogger2 = brazeLogger;
            BrazeLogger.Priority priority = BrazeLogger.Priority.W;
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) k.f43273b, 6, (Object) null);
            getSdkEnablementProvider(context).a(false);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) l.f43274b, 6, (Object) null);
            setOutboundNetworkRequestsOffline(false);
        }

        @JvmStatic
        public final Uri getApiEndpoint(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "brazeEndpoint");
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                IBrazeEndpointProvider access$getEndpointProvider$cp = Braze.endpointProvider;
                if (access$getEndpointProvider$cp != null) {
                    Uri apiEndpoint = access$getEndpointProvider$cp.getApiEndpoint(uri);
                    if (apiEndpoint != null) {
                        access$getEndpointProviderLock$cp.unlock();
                        return apiEndpoint;
                    }
                }
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) m.f43275b, 4, (Object) null);
            } catch (Throwable th2) {
                access$getEndpointProviderLock$cp.unlock();
                throw th2;
            }
            access$getEndpointProviderLock$cp.unlock();
            return uri;
        }

        @JvmStatic
        public final String getConfiguredApiKey(BrazeConfigurationProvider brazeConfigurationProvider) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            try {
                return brazeConfigurationProvider.getBrazeApiKey().toString();
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) n.f43276b, 4, (Object) null);
                return null;
            }
        }

        public final IBrazeNotificationFactory getCustomBrazeNotificationFactory() {
            return Braze.customBrazeNotificationFactory;
        }

        @JvmStatic
        public final Braze getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (shouldAllowSingletonInitialization()) {
                ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
                access$getBrazeClassLock$cp.lock();
                try {
                    if (Braze.Companion.shouldAllowSingletonInitialization()) {
                        Braze braze = new Braze(context);
                        braze.isInstanceStopped = false;
                        Braze.instance = braze;
                        return braze;
                    }
                    Unit unit = Unit.INSTANCE;
                    access$getBrazeClassLock$cp.unlock();
                } finally {
                    access$getBrazeClassLock$cp.unlock();
                }
            }
            Braze access$getInstance$cp = Braze.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.braze.Braze");
        }

        public final boolean getOutboundNetworkRequestsOffline() {
            return Braze.areOutboundNetworkRequestsOffline;
        }

        public final z4 getSdkEnablementProvider$android_sdk_base_release() {
            return Braze.sdkEnablementProvider;
        }

        public final boolean isDisabled() {
            z4 sdkEnablementProvider$android_sdk_base_release = getSdkEnablementProvider$android_sdk_base_release();
            if (sdkEnablementProvider$android_sdk_base_release == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) o.f43277b, 7, (Object) null);
                return false;
            }
            Braze access$getInstance$cp = Braze.instance;
            if (access$getInstance$cp == null || !Intrinsics.areEqual((Object) Boolean.FALSE, (Object) access$getInstance$cp.isApiKeyPresent$android_sdk_base_release())) {
                boolean a11 = sdkEnablementProvider$android_sdk_base_release.a();
                if (a11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) q.f43279b, 6, (Object) null);
                }
                return a11;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) p.f43278b, 6, (Object) null);
            return true;
        }

        public final void requestTriggersIfInAppMessageTestPush$android_sdk_base_release(Intent intent, bo.app.b2 b2Var) {
            Intent intent2 = intent;
            bo.app.b2 b2Var2 = b2Var;
            Intrinsics.checkNotNullParameter(intent2, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            Intrinsics.checkNotNullParameter(b2Var2, "brazeManager");
            String stringExtra = intent2.getStringExtra("ab_push_fetch_test_triggers_key");
            if (stringExtra != null && Intrinsics.areEqual((Object) stringExtra, (Object) "true")) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) s.f43281b, 6, (Object) null);
                b2Var2.a(new a4.a((String) null, (Boolean) null, (Boolean) null, (z3) null, 15, (DefaultConstructorMarker) null).c());
            }
        }

        public final void setConfiguredCustomEndpoint$android_sdk_base_release(String str) {
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                Braze.Companion.setEndpointProvider(new q3.b(str));
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getEndpointProviderLock$cp.unlock();
            }
        }

        public final void setCustomBrazeNotificationFactory(IBrazeNotificationFactory iBrazeNotificationFactory) {
            Braze.customBrazeNotificationFactory = iBrazeNotificationFactory;
        }

        @JvmStatic
        public final void setEndpointProvider(IBrazeEndpointProvider iBrazeEndpointProvider) {
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                Braze.endpointProvider = iBrazeEndpointProvider;
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getEndpointProviderLock$cp.unlock();
            }
        }

        public final void setOutboundNetworkRequestsOffline(boolean z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new r(z11), 6, (Object) null);
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze.areOutboundNetworkRequestsOffline = z11;
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.setSyncPolicyOfflineStatus(z11);
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                access$getBrazeClassLock$cp.unlock();
            }
        }

        public final void setSdkEnablementProvider$android_sdk_base_release(z4 z4Var) {
            Braze.sdkEnablementProvider = z4Var;
        }

        public final void stopInstance$android_sdk_base_release() {
            ReentrantLock access$getBrazeClassLock$cp;
            try {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) w.f43285b, 6, (Object) null);
                access$getBrazeClassLock$cp = Braze.brazeClassLock;
                access$getBrazeClassLock$cp.lock();
                BrazeCoroutineScope.cancelChildren();
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp != null) {
                    Companion companion = Braze.Companion;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) companion, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) x.f43286b, 6, (Object) null);
                    access$getInstance$cp.getExternalIEventMessenger$android_sdk_base_release().a(new SdkDataWipeEvent(), SdkDataWipeEvent.class);
                    BrazeLogger.brazelog$default(brazeLogger, (Object) companion, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) y.f43287b, 7, (Object) null);
                    b5.f38311a.a();
                    if (access$getInstance$cp.udm != null) {
                        access$getInstance$cp.getUdm$android_sdk_base_release().d().a(true);
                        access$getInstance$cp.getUdm$android_sdk_base_release().f().a();
                        access$getInstance$cp.getUdm$android_sdk_base_release().i().c();
                    }
                    access$getInstance$cp.isInstanceStopped = true;
                }
                Unit unit = Unit.INSTANCE;
                access$getBrazeClassLock$cp.unlock();
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) z.f43288b, 4, (Object) null);
            } catch (Throwable th2) {
                access$getBrazeClassLock$cp.unlock();
                throw th2;
            }
        }

        @JvmStatic
        public final void wipeData(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            stopInstance$android_sdk_base_release();
            try {
                c6.f38383e.a(context);
                DefaultBrazeImageLoader.Companion.a(context);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) a0.f43261b, 4, (Object) null);
            }
            try {
                File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
                if (!file.exists()) {
                    return;
                }
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new q3.a());
                    if (listFiles != null) {
                        List<File> asList = ArraysKt___ArraysJvmKt.asList((T[]) listFiles);
                        if (asList != null) {
                            for (File file2 : asList) {
                                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b0(file2), 6, (Object) null);
                                Intrinsics.checkNotNullExpressionValue(file2, "file");
                                BrazeFileUtils.deleteSharedPreferencesFile(context, file2);
                            }
                        }
                    }
                }
            } catch (Exception e12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e12, false, (Function0) c0.f43265b, 4, (Object) null);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43289b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze SDK Initializing";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$deviceId$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43290h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43291i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(Braze braze, Continuation<? super a0> continuation) {
            super(2, continuation);
            this.f43291i = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((a0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a0(this.f43291i, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43290h == 0) {
                ResultKt.throwOnFailure(obj);
                return this.f43291i.getDeviceIdReader$android_sdk_base_release().getDeviceId();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class a1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43292g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43293h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ BigDecimal f43294i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f43295j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Braze f43296k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ BrazeProperties f43297l;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43298b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Log purchase input was invalid. Not logging in-app purchase to Braze.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f43299b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Purchase logged with invalid properties. Not logging custom event to Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a1(String str, String str2, BigDecimal bigDecimal, int i11, Braze braze, BrazeProperties brazeProperties) {
            super(0);
            this.f43292g = str;
            this.f43293h = str2;
            this.f43294i = bigDecimal;
            this.f43295j = i11;
            this.f43296k = braze;
            this.f43297l = brazeProperties;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
            if (r2.isInvalid() == true) goto L_0x0038;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r18 = this;
                r0 = r18
                java.lang.String r1 = r0.f43292g
                java.lang.String r2 = r0.f43293h
                java.math.BigDecimal r3 = r0.f43294i
                int r4 = r0.f43295j
                com.braze.Braze r5 = r0.f43296k
                bo.app.c3 r5 = r5.getUdm$android_sdk_base_release()
                bo.app.e5 r5 = r5.e()
                boolean r2 = com.braze.support.ValidationUtils.isValidLogPurchaseInput(r1, r2, r3, r4, r5)
                if (r2 != 0) goto L_0x002a
                com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.Braze r4 = r0.f43296k
                com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W
                com.braze.Braze$a1$a r8 = com.braze.Braze.a1.a.f43298b
                r6 = 0
                r7 = 0
                r9 = 6
                r10 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)
                return
            L_0x002a:
                com.braze.models.outgoing.BrazeProperties r2 = r0.f43297l
                if (r2 != 0) goto L_0x002f
                goto L_0x0037
            L_0x002f:
                boolean r2 = r2.isInvalid()
                r3 = 1
                if (r2 != r3) goto L_0x0037
                goto L_0x0038
            L_0x0037:
                r3 = 0
            L_0x0038:
                if (r3 == 0) goto L_0x004a
                com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.Braze r5 = r0.f43296k
                com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.W
                com.braze.Braze$a1$b r9 = com.braze.Braze.a1.b.f43299b
                r7 = 0
                r8 = 0
                r10 = 6
                r11 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                return
            L_0x004a:
                java.lang.String r1 = com.braze.support.ValidationUtils.ensureBrazeFieldLength(r1)
                bo.app.j$a r12 = bo.app.j.f38653h
                java.lang.String r14 = r0.f43293h
                kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
                java.math.BigDecimal r15 = r0.f43294i
                kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
                int r2 = r0.f43295j
                com.braze.models.outgoing.BrazeProperties r3 = r0.f43297l
                r13 = r1
                r16 = r2
                r17 = r3
                bo.app.x1 r2 = r12.a(r13, r14, r15, r16, r17)
                if (r2 != 0) goto L_0x006a
                return
            L_0x006a:
                com.braze.Braze r3 = r0.f43296k
                bo.app.c3 r3 = r3.getUdm$android_sdk_base_release()
                bo.app.b2 r3 = r3.m()
                boolean r3 = r3.a((bo.app.x1) r2)
                if (r3 == 0) goto L_0x008e
                com.braze.Braze r3 = r0.f43296k
                bo.app.c3 r3 = r3.getUdm$android_sdk_base_release()
                bo.app.k6 r3 = r3.l()
                bo.app.f4 r4 = new bo.app.f4
                com.braze.models.outgoing.BrazeProperties r5 = r0.f43297l
                r4.<init>(r1, r5, r2)
                r3.a((bo.app.w2) r4)
            L_0x008e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.Braze.a1.a():void");
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a2 f43300b = new a2();

        public a2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve and publish feed from offline cache.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a3 f43301b = new a3();

        public a3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for Content Cards updates.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43302g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.f43302g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Device build model matches a known crawler. Enabling mock network request mode. Device it: ", this.f43302g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b0 f43303b = new b0();

        public b0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get all feature flags";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b1 f43304b = new b1();

        public b1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log push notification action clicked.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class b2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43305g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b2(Braze braze) {
            super(0);
            this.f43305g = braze;
        }

        public final void a() {
            this.f43305g.getExternalIEventMessenger$android_sdk_base_release().a(this.f43305g.getUdm$android_sdk_base_release().g().getCachedCardsAsEvent(), FeedUpdatedEvent.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b3 f43306b = new b3();

        public b3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for Feature Flags updates.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43307b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to perform initial Braze singleton setup.";
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/braze/models/FeatureFlag;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$getAllFeatureFlags$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends FeatureFlag>>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43308h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43309i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(Braze braze, Continuation<? super c0> continuation) {
            super(2, continuation);
            this.f43309i = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<FeatureFlag>> continuation) {
            return ((c0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c0(this.f43309i, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43308h == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.f43309i.getUdm$android_sdk_base_release().e().o()) {
                    return bo.app.e1.a(this.f43309i.getUdm$android_sdk_base_release().p(), (String) null, 1, (Object) null);
                }
                return CollectionsKt__CollectionsKt.emptyList();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class c1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43310g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43311h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43312i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f43313j;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43314b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No campaign Id associated with this notification (this is expected for test sends). Not logging push notification action clicked.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f43315b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Action ID cannot be null or blank.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c f43316b = new c();

            public c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Action Type cannot be null or blank.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c1(String str, Braze braze, String str2, String str3) {
            super(0);
            this.f43310g = str;
            this.f43311h = braze;
            this.f43312i = str2;
            this.f43313j = str3;
        }

        public final void a() {
            boolean z11;
            boolean z12;
            String str = this.f43310g;
            boolean z13 = false;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43311h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43314b, 6, (Object) null);
                return;
            }
            String str2 = this.f43312i;
            if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43311h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43315b, 6, (Object) null);
                return;
            }
            String str3 = this.f43313j;
            if (str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) {
                z13 = true;
            }
            if (z13) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43311h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f43316b, 6, (Object) null);
            } else {
                this.f43311h.getUdm$android_sdk_base_release().m().a(h4.f38615k.a(this.f43310g, this.f43312i, this.f43313j));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c2 f43317b = new c2();

        public c2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request geofence refresh.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c3 f43318b = new c3();

        public c3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for feed updates.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43319g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f43320h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43321b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to startup user dependency manager.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f43322b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Firebase Cloud Messaging found. Setting up Firebase Cloud Messaging.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c f43323b = new c();

            public c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Firebase Cloud Messaging requirements not met. Braze will not register for Firebase Cloud Messaging.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: com.braze.Braze$d$d  reason: collision with other inner class name */
        public static final class C0038d extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final C0038d f43324b = new C0038d();

            public C0038d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Automatic Firebase Cloud Messaging registration not enabled in configuration. Braze will not register for Firebase Cloud Messaging.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final e f43325b = new e();

            public e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Amazon Device Messaging found. Setting up Amazon Device Messaging";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final f f43326b = new f();

            public f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "ADM manifest requirements not met. Braze will not register for ADM.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class g extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final g f43327b = new g();

            public g() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Automatic ADM registration not enabled in configuration. Braze will not register for ADM.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class h extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final h f43328b = new h();

            public h() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to setup pre SDK tasks";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class i extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final i f43329b = new i();

            public i() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Starting up a new user dependency manager";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Braze braze, Context context) {
            super(0);
            this.f43319g = braze;
            this.f43320h = context;
        }

        public final void a() {
            boolean z11;
            v3 v3Var;
            bo.app.m2 m2Var;
            b6 b6Var;
            this.f43319g.applyPendingRuntimeConfiguration$android_sdk_base_release();
            this.f43319g.setConfigurationProvider$android_sdk_base_release(new BrazeConfigurationProvider(this.f43319g.applicationContext));
            Braze braze = this.f43319g;
            Companion companion = Braze.Companion;
            String configuredApiKey = companion.getConfiguredApiKey(braze.getConfigurationProvider$android_sdk_base_release());
            boolean z12 = false;
            if (configuredApiKey == null || StringsKt__StringsJVMKt.isBlank(configuredApiKey)) {
                z11 = true;
            } else {
                z11 = false;
            }
            braze.setApiKeyPresent$android_sdk_base_release(Boolean.valueOf(!z11));
            BrazeLogger.setInitialLogLevelFromConfiguration(this.f43319g.getConfigurationProvider$android_sdk_base_release().getLoggerInitialLogLevel());
            BrazeLogger.checkForSystemLogLevelProperty$default(false, 1, (Object) null);
            this.f43319g.testUserDeviceLoggingManager = new b6();
            b6 access$getTestUserDeviceLoggingManager$p = this.f43319g.testUserDeviceLoggingManager;
            if (access$getTestUserDeviceLoggingManager$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("testUserDeviceLoggingManager");
                access$getTestUserDeviceLoggingManager$p = null;
            }
            BrazeLogger.setTestUserDeviceLoggingManager(access$getTestUserDeviceLoggingManager$p);
            if (companion.getSdkEnablementProvider(this.f43320h).a()) {
                companion.setOutboundNetworkRequestsOffline(true);
            }
            this.f43319g.setDeviceIdReader$android_sdk_base_release(new bo.app.m0(this.f43319g.applicationContext));
            this.f43319g.offlineUserStorageProvider = new v3(this.f43319g.applicationContext);
            this.f43319g.registrationDataProvider = new l4(this.f43319g.applicationContext, this.f43319g.getConfigurationProvider$android_sdk_base_release());
            String customEndpoint = this.f43319g.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint();
            if (customEndpoint == null || StringsKt__StringsJVMKt.isBlank(customEndpoint)) {
                z12 = true;
            }
            if (!z12) {
                companion.setConfiguredCustomEndpoint$android_sdk_base_release(this.f43319g.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint());
            }
            try {
                if (this.f43319g.getConfigurationProvider$android_sdk_base_release().isFirebaseCloudMessagingRegistrationEnabled()) {
                    Context context = this.f43320h;
                    bo.app.m2 access$getRegistrationDataProvider$p = this.f43319g.registrationDataProvider;
                    if (access$getRegistrationDataProvider$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                        access$getRegistrationDataProvider$p = null;
                    }
                    bo.app.k1 k1Var = new bo.app.k1(context, access$getRegistrationDataProvider$p);
                    if (k1Var.a()) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) b.f43322b, 6, (Object) null);
                        String firebaseCloudMessagingSenderIdKey = this.f43319g.getConfigurationProvider$android_sdk_base_release().getFirebaseCloudMessagingSenderIdKey();
                        if (firebaseCloudMessagingSenderIdKey != null) {
                            k1Var.a(firebaseCloudMessagingSenderIdKey);
                        }
                    } else {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f43323b, 6, (Object) null);
                    }
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) C0038d.f43324b, 6, (Object) null);
                }
                if (!this.f43319g.getConfigurationProvider$android_sdk_base_release().isAdmMessagingRegistrationEnabled()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) g.f43327b, 6, (Object) null);
                } else if (bo.app.b.f38286c.a(this.f43319g.applicationContext)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) e.f43325b, 6, (Object) null);
                    Context access$getApplicationContext$p = this.f43319g.applicationContext;
                    bo.app.m2 access$getRegistrationDataProvider$p2 = this.f43319g.registrationDataProvider;
                    if (access$getRegistrationDataProvider$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                        access$getRegistrationDataProvider$p2 = null;
                    }
                    new bo.app.b(access$getApplicationContext$p, access$getRegistrationDataProvider$p2).a();
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) f.f43326b, 6, (Object) null);
                }
                this.f43319g.verifyProperSdkSetup();
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) h.f43328b, 4, (Object) null);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) i.f43329b, 6, (Object) null);
            try {
                Braze braze2 = this.f43319g;
                Context access$getApplicationContext$p2 = braze2.applicationContext;
                v3 access$getOfflineUserStorageProvider$p = this.f43319g.offlineUserStorageProvider;
                if (access$getOfflineUserStorageProvider$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                    v3Var = null;
                } else {
                    v3Var = access$getOfflineUserStorageProvider$p;
                }
                BrazeConfigurationProvider configurationProvider$android_sdk_base_release = this.f43319g.getConfigurationProvider$android_sdk_base_release();
                bo.app.j2 externalIEventMessenger$android_sdk_base_release = this.f43319g.getExternalIEventMessenger$android_sdk_base_release();
                bo.app.g2 deviceIdReader$android_sdk_base_release = this.f43319g.getDeviceIdReader$android_sdk_base_release();
                bo.app.m2 access$getRegistrationDataProvider$p3 = this.f43319g.registrationDataProvider;
                if (access$getRegistrationDataProvider$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                    m2Var = null;
                } else {
                    m2Var = access$getRegistrationDataProvider$p3;
                }
                boolean access$getShouldMockNetworkRequestsAndDropEvents$cp = Braze.shouldMockNetworkRequestsAndDropEvents;
                boolean access$getAreOutboundNetworkRequestsOffline$cp = Braze.areOutboundNetworkRequestsOffline;
                b6 access$getTestUserDeviceLoggingManager$p2 = this.f43319g.testUserDeviceLoggingManager;
                if (access$getTestUserDeviceLoggingManager$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("testUserDeviceLoggingManager");
                    b6Var = null;
                } else {
                    b6Var = access$getTestUserDeviceLoggingManager$p2;
                }
                braze2.setUserSpecificMemberVariablesAndStartDispatch(new u6(access$getApplicationContext$p2, v3Var, configurationProvider$android_sdk_base_release, externalIEventMessenger$android_sdk_base_release, deviceIdReader$android_sdk_base_release, m2Var, access$getShouldMockNetworkRequestsAndDropEvents$cp, access$getAreOutboundNetworkRequestsOffline$cp, b6Var));
            } catch (Exception e12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43319g, BrazeLogger.Priority.E, (Throwable) e12, false, (Function0) a.f43321b, 4, (Object) null);
                this.f43319g.publishError(e12);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d0 f43330b = new d0();

        public d0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning null for the list of cached cards.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43331g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d1(String str) {
            super(0);
            this.f43331g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log push open for '" + this.f43331g + '\'';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class d2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ bo.app.a2 f43332g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43333h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43334b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot request Geofence refresh with null location.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d2(bo.app.a2 a2Var, Braze braze) {
            super(0);
            this.f43332g = a2Var;
            this.f43333h = braze;
        }

        public final void a() {
            if (this.f43332g == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43333h, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f43334b, 7, (Object) null);
            } else {
                this.f43333h.getUdm$android_sdk_base_release().i().a(this.f43332g);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d3 f43335b = new d3();

        public d3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for network failures.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f43336g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f43337h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(long j11, long j12) {
            super(0);
            this.f43336g = j11;
            this.f43337h = j12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze SDK loaded in " + TimeUnit.MILLISECONDS.convert(this.f43336g - this.f43337h, TimeUnit.NANOSECONDS) + " ms.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e0 f43338b = new e0();

        public e0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning the default value for the card count.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class e1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43339g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43340h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43341b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No campaign Id associated with this notification (this is expected for test sends). Not logging push notification opened.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e1(String str, Braze braze) {
            super(0);
            this.f43339g = str;
            this.f43340h = braze;
        }

        public final void a() {
            boolean z11;
            String str = this.f43339g;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43340h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43341b, 6, (Object) null);
            } else {
                this.f43340h.getUdm$android_sdk_base_release().m().a((bo.app.x1) k4.f38791j.a(this.f43339g));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e2 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43342g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e2(boolean z11) {
            super(0);
            this.f43342g = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to request geofence refresh with rate limit ignore: ", Boolean.valueOf(this.f43342g));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e3 f43343b = new e3();

        public e3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber to new in-app messages.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43344g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43345h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, String str2) {
            super(0);
            this.f43344g = str;
            this.f43345h = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to update ContentCard storage provider with single card update. User id: " + this.f43344g + " Serialized json: " + this.f43345h;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f0 f43346b = new f0();

        public f0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning the default value for the unviewed card count.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f43347g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f1(Intent intent) {
            super(0);
            this.f43347g = intent;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Error logging push notification with intent: ", this.f43347g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class f2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43348g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f43349h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f2(Braze braze, boolean z11) {
            super(0);
            this.f43348g = braze;
            this.f43349h = z11;
        }

        public final void a() {
            this.f43348g.getUdm$android_sdk_base_release().i().b(this.f43349h);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f3 f43350b = new f3();

        public f3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber to no matching trigger events.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43351g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43352h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43353i;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43354g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f43355h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2) {
                super(0);
                this.f43354g = str;
                this.f43355h = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot add null or blank card json to storage. Returning. User id: " + this.f43354g + " Serialized json: " + this.f43355h;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str, Braze braze, String str2) {
            super(0);
            this.f43351g = str;
            this.f43352h = braze;
            this.f43353i = str2;
        }

        public final void a() {
            if (StringsKt__StringsJVMKt.isBlank(this.f43351g)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43352h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(this.f43353i, this.f43351g), 6, (Object) null);
                return;
            }
            this.f43352h.getUdm$android_sdk_base_release().j().a(new bo.app.z(this.f43351g), this.f43353i);
            this.f43352h.getExternalIEventMessenger$android_sdk_base_release().a(this.f43352h.getUdm$android_sdk_base_release().j().getCachedCardsAsEvent(), ContentCardsUpdatedEvent.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g0 f43356b = new g0();

        public g0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning the default value for the last update timestamp.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class g1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f43357g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43358h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43359b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot logPushNotificationOpened with null intent. Not logging push click.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43360g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(0);
                this.f43360g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Logging push click. Campaign Id: ", this.f43360g);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c f43361b = new c();

            public c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No campaign Id associated with this notification (this is expected for test sends). Not logging push click.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g1(Intent intent, Braze braze) {
            super(0);
            this.f43357g = intent;
            this.f43358h = braze;
        }

        public final void a() {
            boolean z11;
            Intent intent = this.f43357g;
            if (intent == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43358h, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f43359b, 6, (Object) null);
                return;
            }
            String stringExtra = intent.getStringExtra("cid");
            if (stringExtra == null || StringsKt__StringsJVMKt.isBlank(stringExtra)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43358h, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new b(stringExtra), 6, (Object) null);
                this.f43358h.getUdm$android_sdk_base_release().m().a((bo.app.x1) k4.f38791j.a(stringExtra));
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43358h, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) c.f43361b, 6, (Object) null);
            }
            Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(this.f43357g, this.f43358h.getUdm$android_sdk_base_release().m());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g2 f43362b = new g2();

        public g2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request geofence refresh.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g3 f43363b = new g3();

        public g3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for push notification updates.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Class<T> f43364g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Class<T> cls) {
            super(0);
            this.f43364g = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to add synchronous subscriber for class: ", this.f43364g);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$getCurrentUser$1", f = "Braze.kt", i = {}, l = {767}, m = "invokeSuspend", n = {}, s = {})
    public static final class h0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43365h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ IValueCallback<BrazeUser> f43366i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Braze f43367j;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "com.braze.Braze$getCurrentUser$1$1", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: h  reason: collision with root package name */
            public int f43368h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ IValueCallback<BrazeUser> f43369i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Braze f43370j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(IValueCallback<BrazeUser> iValueCallback, Braze braze, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f43369i = iValueCallback;
                this.f43370j = braze;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f43369i, this.f43370j, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f43368h == 0) {
                    ResultKt.throwOnFailure(obj);
                    IValueCallback<BrazeUser> iValueCallback = this.f43369i;
                    BrazeUser access$getBrazeUser$p = this.f43370j.brazeUser;
                    if (access$getBrazeUser$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                        access$getBrazeUser$p = null;
                    }
                    iValueCallback.onSuccess(access$getBrazeUser$p);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h0(IValueCallback<BrazeUser> iValueCallback, Braze braze, Continuation<? super h0> continuation) {
            super(2, continuation);
            this.f43366i = iValueCallback;
            this.f43367j = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h0(this.f43366i, this.f43367j, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f43365h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = BrazeCoroutineScope.INSTANCE.getCoroutineContext();
                a aVar = new a(this.f43366i, this.f43367j, (Continuation<? super a>) null);
                this.f43365h = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43371g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43372h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h1(String str, String str2) {
            super(0);
            this.f43371g = str;
            this.f43372h = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log push story page clicked for pageId: " + this.f43371g + " campaignId: " + this.f43372h;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class h2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ double f43373g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f43374h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43375i;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ double f43376g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ double f43377h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(double d11, double d12) {
                super(0);
                this.f43376g = d11;
                this.f43377h = d12;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Location provided is invalid. Not requesting refresh of Braze Geofences. Provided latitude - longitude: " + this.f43376g + " - " + this.f43377h;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ double f43378g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ double f43379h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(double d11, double d12) {
                super(0);
                this.f43378g = d11;
                this.f43379h = d12;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Manually requesting Geofence refresh of with provided latitude - longitude: " + this.f43378g + " - " + this.f43379h;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h2(double d11, double d12, Braze braze) {
            super(0);
            this.f43373g = d11;
            this.f43374h = d12;
            this.f43375i = braze;
        }

        public final void a() {
            if (!ValidationUtils.isValidLocation(this.f43373g, this.f43374h)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43375i, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(this.f43373g, this.f43374h), 6, (Object) null);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43375i, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(this.f43373g, this.f43374h), 6, (Object) null);
            this.f43375i.getUdm$android_sdk_base_release().i().a((bo.app.a2) new bo.app.n(this.f43373g, this.f43374h, (Double) null, (Double) null, 12, (DefaultConstructorMarker) null));
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h3 f43380b = new h3();

        public h3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for SDK authentication failures.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f43381b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Applying any pending runtime configuration values";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i0 f43382b = new i0();

        public i0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the current user.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class i1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43383g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43384h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43385i;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43386b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push story page click input was invalid. Not logging in-app purchase to Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i1(String str, String str2, Braze braze) {
            super(0);
            this.f43383g = str;
            this.f43384h = str2;
            this.f43385i = braze;
        }

        public final void a() {
            if (!ValidationUtils.isValidPushStoryClickInput(this.f43383g, this.f43384h)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43385i, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43386b, 6, (Object) null);
                return;
            }
            j.a aVar = bo.app.j.f38653h;
            String str = this.f43383g;
            Intrinsics.checkNotNull(str);
            String str2 = this.f43384h;
            Intrinsics.checkNotNull(str2);
            bo.app.x1 e11 = aVar.e(str, str2);
            if (e11 != null) {
                this.f43385i.getUdm$android_sdk_base_release().m().a(e11);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i2 f43387b = new i2();

        public i2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to initialize geofences with the geofence manager.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i3 f43388b = new i3();

        public i3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for session updates.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f43389b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Clearing config values";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43390g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j0(String str) {
            super(0);
            this.f43390g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to get feature flag ", this.f43390g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j1 f43391b = new j1();

        public j1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to open session.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class j2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43392g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j2(Braze braze) {
            super(0);
            this.f43392g = braze;
        }

        public final void a() {
            this.f43392g.getUdm$android_sdk_base_release().i().b();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j3 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43393g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j3(String str) {
            super(0);
            this.f43393g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The Braze SDK requires the permission " + this.f43393g + ". Check your AndroidManifest.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BrazeConfig f43394g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(BrazeConfig brazeConfig) {
            super(0);
            this.f43394g = brazeConfig;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Setting pending config object: ", this.f43394g);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/braze/models/FeatureFlag;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$getFeatureFlag$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class k0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FeatureFlag>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43395h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43396i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f43397j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k0(Braze braze, String str, Continuation<? super k0> continuation) {
            super(2, continuation);
            this.f43396i = braze;
            this.f43397j = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FeatureFlag> continuation) {
            return ((k0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new k0(this.f43396i, this.f43397j, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43395h == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.f43396i.getUdm$android_sdk_base_release().e().o()) {
                    return FeatureFlag.Companion.a(this.f43397j);
                }
                FeatureFlag featureFlag = (FeatureFlag) CollectionsKt___CollectionsKt.firstOrNull(this.f43396i.getUdm$android_sdk_base_release().p().a(this.f43397j));
                if (featureFlag == null) {
                    return FeatureFlag.Companion.a(this.f43397j);
                }
                return featureFlag;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class k1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f43398g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43399h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43400b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot open session with null activity.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k1(Activity activity, Braze braze) {
            super(0);
            this.f43398g = activity;
            this.f43399h = braze;
        }

        public final void a() {
            if (this.f43398g == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43399h, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f43400b, 6, (Object) null);
            } else {
                this.f43399h.getUdm$android_sdk_base_release().m().openSession(this.f43398g);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k2 f43401b = new k2();

        public k2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request data flush.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k3 f43402b = new k3();

        public k3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The Braze SDK requires a non-empty API key. Check your braze.xml or BrazeConfig.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f43403b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the cached ContentCardsUpdatedEvent.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l0 f43404b = new l0();

        public l0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error handling test in-app message push";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l1 f43405b = new l1();

        public l1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "User dependency manager is uninitialized. Not publishing error.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class l2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43406g;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43407b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Requesting immediate data flush to Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l2(Braze braze) {
            super(0);
            this.f43406g = braze;
        }

        public final void a() {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43406g, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f43407b, 6, (Object) null);
            this.f43406g.getUdm$android_sdk_base_release().m().b();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l3 f43408b = new l3();

        public l3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The Braze SDK is not integrated correctly. Please visit https://www.braze.com/docs/developer_guide/platform_integration_guides/android/initial_sdk_setup/android_sdk_integration/";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/braze/events/ContentCardsUpdatedEvent;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$cachedContentCardsUpdatedEvent$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ContentCardsUpdatedEvent>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43409h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43410i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Braze braze, Continuation<? super m> continuation) {
            super(2, continuation);
            this.f43410i = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ContentCardsUpdatedEvent> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new m(this.f43410i, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43409h == 0) {
                ResultKt.throwOnFailure(obj);
                return this.f43410i.getUdm$android_sdk_base_release().j().getCachedCardsAsEvent();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class m0 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f43411g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43412h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m0(Intent intent, Braze braze) {
            super(0);
            this.f43411g = intent;
            this.f43412h = braze;
        }

        public final void a() {
            Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(this.f43411g, this.f43412h.getUdm$android_sdk_base_release().m());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Throwable f43413g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m1(Throwable th2) {
            super(0);
            this.f43413g = th2;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log throwable: ", this.f43413g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m2 f43414b = new m2();

        public m2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Location permissions were granted. Requesting geofence and location initialization.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m3 f43415b = new m3();

        public m3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43416g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super(0);
            this.f43416g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set external id to: ", this.f43416g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n0 f43417b = new n0();

        public n0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Ephemeral events enabled";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n1 f43418b = new n1();

        public n1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to post geofence report.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n2 f43419b = new n2();

        public n2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request single location update";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$waitForUserDependencyThread$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class n3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f43420c;

        /* renamed from: h  reason: collision with root package name */
        public int f43421h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43422b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Waited on previous tasks to finish!";
            }
        }

        public n3(Continuation<? super n3> continuation) {
            super(2, continuation);
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((n3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            n3 n3Var = new n3(continuation);
            n3Var.f43420c = obj;
            return n3Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43421h == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) (CoroutineScope) this.f43420c, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f43422b, 7, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43423g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43424h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43425i;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43426b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "userId passed to changeUser was null or empty. The current user will remain the active user.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43427g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(0);
                this.f43427g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Rejected user id with byte length longer than 997. Not changing user. Input user id: ", this.f43427g);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43428g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(0);
                this.f43428g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Received request to change current user " + this.f43428g + " to the same user id. Not changing user.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43429g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(String str) {
                super(0);
                this.f43429g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Set sdk auth signature on changeUser call: ", this.f43429g);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43430g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(String str) {
                super(0);
                this.f43430g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Changing anonymous user to ", this.f43430g);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43431g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f43432h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(String str, String str2) {
                super(0);
                this.f43431g = str;
                this.f43432h = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Changing current user " + this.f43431g + " to new user " + this.f43432h + '.';
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class g extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43433g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(String str) {
                super(0);
                this.f43433g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Set sdk auth signature on changeUser call: ", this.f43433g);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(String str, Braze braze, String str2) {
            super(0);
            this.f43423g = str;
            this.f43424h = braze;
            this.f43425i = str2;
        }

        public final void a() {
            boolean z11;
            v3 v3Var;
            bo.app.m2 m2Var;
            b6 b6Var;
            String str = this.f43423g;
            boolean z12 = true;
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43424h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43426b, 6, (Object) null);
            } else if (StringUtils.getByteSize(this.f43423g) > 997) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43424h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(this.f43423g), 6, (Object) null);
            } else {
                BrazeUser access$getBrazeUser$p = this.f43424h.brazeUser;
                if (access$getBrazeUser$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                    access$getBrazeUser$p = null;
                }
                String userId = access$getBrazeUser$p.getUserId();
                if (Intrinsics.areEqual((Object) userId, (Object) this.f43423g)) {
                    BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this.f43424h, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new c(this.f43423g), 6, (Object) null);
                    String str2 = this.f43425i;
                    if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                        z12 = false;
                    }
                    if (!z12) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this.f43424h, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(this.f43425i), 7, (Object) null);
                        this.f43424h.getUdm$android_sdk_base_release().o().a(this.f43425i);
                        return;
                    }
                    return;
                }
                this.f43424h.getUdm$android_sdk_base_release().k().b();
                if (Intrinsics.areEqual((Object) userId, (Object) "")) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43424h, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new e(this.f43423g), 6, (Object) null);
                    v3 access$getOfflineUserStorageProvider$p = this.f43424h.offlineUserStorageProvider;
                    if (access$getOfflineUserStorageProvider$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                        access$getOfflineUserStorageProvider$p = null;
                    }
                    access$getOfflineUserStorageProvider$p.a(this.f43423g);
                    BrazeUser access$getBrazeUser$p2 = this.f43424h.brazeUser;
                    if (access$getBrazeUser$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                        access$getBrazeUser$p2 = null;
                    }
                    access$getBrazeUser$p2.setUserId(this.f43423g);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43424h, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new f(userId, this.f43423g), 6, (Object) null);
                    this.f43424h.getExternalIEventMessenger$android_sdk_base_release().a(new FeedUpdatedEvent(new ArrayList(), this.f43423g, false, DateTimeUtils.nowInSeconds()), FeedUpdatedEvent.class);
                }
                this.f43424h.getUdm$android_sdk_base_release().m().e();
                v3 access$getOfflineUserStorageProvider$p2 = this.f43424h.offlineUserStorageProvider;
                if (access$getOfflineUserStorageProvider$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                    access$getOfflineUserStorageProvider$p2 = null;
                }
                access$getOfflineUserStorageProvider$p2.a(this.f43423g);
                bo.app.c3 udm$android_sdk_base_release = this.f43424h.getUdm$android_sdk_base_release();
                Context access$getApplicationContext$p = this.f43424h.applicationContext;
                v3 access$getOfflineUserStorageProvider$p3 = this.f43424h.offlineUserStorageProvider;
                if (access$getOfflineUserStorageProvider$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                    v3Var = null;
                } else {
                    v3Var = access$getOfflineUserStorageProvider$p3;
                }
                BrazeConfigurationProvider configurationProvider$android_sdk_base_release = this.f43424h.getConfigurationProvider$android_sdk_base_release();
                bo.app.j2 externalIEventMessenger$android_sdk_base_release = this.f43424h.getExternalIEventMessenger$android_sdk_base_release();
                bo.app.g2 deviceIdReader$android_sdk_base_release = this.f43424h.getDeviceIdReader$android_sdk_base_release();
                bo.app.m2 access$getRegistrationDataProvider$p = this.f43424h.registrationDataProvider;
                if (access$getRegistrationDataProvider$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                    m2Var = null;
                } else {
                    m2Var = access$getRegistrationDataProvider$p;
                }
                boolean access$getShouldMockNetworkRequestsAndDropEvents$cp = Braze.shouldMockNetworkRequestsAndDropEvents;
                boolean access$getAreOutboundNetworkRequestsOffline$cp = Braze.areOutboundNetworkRequestsOffline;
                b6 access$getTestUserDeviceLoggingManager$p = this.f43424h.testUserDeviceLoggingManager;
                if (access$getTestUserDeviceLoggingManager$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("testUserDeviceLoggingManager");
                    b6Var = null;
                } else {
                    b6Var = access$getTestUserDeviceLoggingManager$p;
                }
                this.f43424h.setUserSpecificMemberVariablesAndStartDispatch(new u6(access$getApplicationContext$p, v3Var, configurationProvider$android_sdk_base_release, externalIEventMessenger$android_sdk_base_release, deviceIdReader$android_sdk_base_release, m2Var, access$getShouldMockNetworkRequestsAndDropEvents$cp, access$getAreOutboundNetworkRequestsOffline$cp, b6Var));
                String str3 = this.f43425i;
                if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                    z12 = false;
                }
                if (!z12) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43424h, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new g(this.f43425i), 7, (Object) null);
                    this.f43424h.getUdm$android_sdk_base_release().o().a(this.f43425i);
                }
                this.f43424h.getUdm$android_sdk_base_release().b().h();
                this.f43424h.getUdm$android_sdk_base_release().m().d();
                this.f43424h.getUdm$android_sdk_base_release().m().a(new a4.a((String) null, (Boolean) null, (Boolean) null, (z3) null, 15, (DefaultConstructorMarker) null).b());
                this.f43424h.requestContentCardsRefresh(false);
                udm$android_sdk_base_release.a();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43434g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Set<String> f43435h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f43436i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o0(String str, Set<String> set, boolean z11) {
            super(0);
            this.f43434g = str;
            this.f43435h = set;
            this.f43436i = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Checking event key [" + this.f43434g + "] against ephemeral event list " + this.f43435h + " and got match?: " + this.f43436i;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class o1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ bo.app.o1 f43438h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43439i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o1(String str, bo.app.o1 o1Var, Braze braze) {
            super(0);
            this.f43437g = str;
            this.f43438h = o1Var;
            this.f43439i = braze;
        }

        public final void a() {
            boolean z11;
            String str = this.f43437g;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && this.f43438h != null) {
                this.f43439i.getUdm$android_sdk_base_release().i().b(this.f43437g, this.f43438h);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class o2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43440g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o2(Braze braze) {
            super(0);
            this.f43440g = braze;
        }

        public final void a() {
            this.f43440g.getUdm$android_sdk_base_release().h().a();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o3 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o3 f43441b = new o3();

        public o3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while waiting for previous tasks in serial work queue to finish.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p f43442b = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to close session.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43443g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p0(String str) {
            super(0);
            this.f43443g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log custom event: ", this.f43443g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p1 f43444b = new p1();

        public p1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to refresh feature flags.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p2 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InAppMessageEvent f43445g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p2(InAppMessageEvent inAppMessageEvent) {
            super(0);
            this.f43445g = inAppMessageEvent;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Error retrying In-App Message from event ", this.f43445g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f43446g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43447h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43448b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot close session with null activity.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(Activity activity, Braze braze) {
            super(0);
            this.f43446g = activity;
            this.f43447h = braze;
        }

        public final void a() {
            if (this.f43446g == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43447h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43448b, 6, (Object) null);
            } else {
                this.f43447h.getUdm$android_sdk_base_release().m().closeSession(this.f43446g);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class q0 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43449g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43450h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ BrazeProperties f43451i;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<String> f43452g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Ref.ObjectRef<String> objectRef) {
                super(0);
                this.f43452g = objectRef;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Logged custom event with name " + this.f43452g.element + " was invalid. Not logging custom event to Braze.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<String> f43453g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Ref.ObjectRef<String> objectRef) {
                super(0);
                this.f43453g = objectRef;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Custom event with name " + this.f43453g.element + " logged with invalid properties. Not logging custom event to Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q0(String str, Braze braze, BrazeProperties brazeProperties) {
            super(0);
            this.f43449g = str;
            this.f43450h = braze;
            this.f43451i = brazeProperties;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0036, code lost:
            if (r1.isInvalid() == true) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r11 = this;
                kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
                r0.<init>()
                java.lang.String r1 = r11.f43449g
                r0.element = r1
                com.braze.Braze r2 = r11.f43450h
                bo.app.c3 r2 = r2.getUdm$android_sdk_base_release()
                bo.app.e5 r2 = r2.e()
                boolean r1 = com.braze.support.ValidationUtils.isValidLogCustomEventInput(r1, r2)
                if (r1 != 0) goto L_0x002c
                com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.Braze r3 = r11.f43450h
                com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
                com.braze.Braze$q0$a r7 = new com.braze.Braze$q0$a
                r7.<init>(r0)
                r5 = 0
                r6 = 0
                r8 = 6
                r9 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
                return
            L_0x002c:
                com.braze.models.outgoing.BrazeProperties r1 = r11.f43451i
                if (r1 != 0) goto L_0x0031
                goto L_0x0039
            L_0x0031:
                boolean r1 = r1.isInvalid()
                r2 = 1
                if (r1 != r2) goto L_0x0039
                goto L_0x003a
            L_0x0039:
                r2 = 0
            L_0x003a:
                if (r2 == 0) goto L_0x004f
                com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.Braze r4 = r11.f43450h
                com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W
                com.braze.Braze$q0$b r8 = new com.braze.Braze$q0$b
                r8.<init>(r0)
                r6 = 0
                r7 = 0
                r9 = 6
                r10 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)
                return
            L_0x004f:
                T r1 = r0.element
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r1 = com.braze.support.ValidationUtils.ensureBrazeFieldLength(r1)
                r0.element = r1
                bo.app.j$a r2 = bo.app.j.f38653h
                com.braze.models.outgoing.BrazeProperties r3 = r11.f43451i
                bo.app.x1 r1 = r2.a((java.lang.String) r1, (com.braze.models.outgoing.BrazeProperties) r3)
                if (r1 != 0) goto L_0x0064
                return
            L_0x0064:
                com.braze.Braze r2 = r11.f43450h
                T r3 = r0.element
                java.lang.String r3 = (java.lang.String) r3
                boolean r2 = r2.isEphemeralEventKey(r3)
                if (r2 == 0) goto L_0x007f
                com.braze.Braze r2 = r11.f43450h
                bo.app.c3 r2 = r2.getUdm$android_sdk_base_release()
                bo.app.e5 r2 = r2.e()
                boolean r2 = r2.n()
                goto L_0x008d
            L_0x007f:
                com.braze.Braze r2 = r11.f43450h
                bo.app.c3 r2 = r2.getUdm$android_sdk_base_release()
                bo.app.b2 r2 = r2.m()
                boolean r2 = r2.a((bo.app.x1) r1)
            L_0x008d:
                if (r2 == 0) goto L_0x00a7
                com.braze.Braze r2 = r11.f43450h
                bo.app.c3 r2 = r2.getUdm$android_sdk_base_release()
                bo.app.k6 r2 = r2.l()
                bo.app.e0 r3 = new bo.app.e0
                T r0 = r0.element
                java.lang.String r0 = (java.lang.String) r0
                com.braze.models.outgoing.BrazeProperties r4 = r11.f43451i
                r3.<init>(r0, r4, r1)
                r2.a((bo.app.w2) r3)
            L_0x00a7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.Braze.q0.a():void");
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class q1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43454g;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43455b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Feature flags not enabled. Not refreshing feature flags.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q1(Braze braze) {
            super(0);
            this.f43454g = braze;
        }

        public final void a() {
            if (this.f43454g.getUdm$android_sdk_base_release().e().o()) {
                this.f43454g.getUdm$android_sdk_base_release().p().d();
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43454g, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f43455b, 6, (Object) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class q2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43456g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ InAppMessageEvent f43457h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q2(Braze braze, InAppMessageEvent inAppMessageEvent) {
            super(0);
            this.f43456g = braze;
            this.f43457h = inAppMessageEvent;
        }

        public final void a() {
            this.f43456g.getUdm$android_sdk_base_release().l().a(this.f43457h.getTriggerEvent(), this.f43457h.getTriggerAction());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r f43458b = new r();

        public r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the current user.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43459g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r0(String str) {
            super(0);
            this.f43459g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log feed card clicked. Card id: ", this.f43459g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r1 f43460b = new r1();

        public r1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get the registered push registration token.";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$run$1", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class r2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43461h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f43462i;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "com.braze.Braze$run$1$1", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: h  reason: collision with root package name */
            public int f43463h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f43464i;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Function0<Unit> function0, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f43464i = function0;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f43464i, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f43463h == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.f43464i.invoke();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r2(Function0<Unit> function0, Continuation<? super r2> continuation) {
            super(2, continuation);
            this.f43462i = function0;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((r2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new r2(this.f43462i, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43461h == 0) {
                ResultKt.throwOnFailure(obj);
                Object unused2 = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new a(this.f43462i, (Continuation<? super a>) null), 1, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/braze/BrazeUser;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$currentUser$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class s extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrazeUser>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43465h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43466i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(Braze braze, Continuation<? super s> continuation) {
            super(2, continuation);
            this.f43466i = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BrazeUser> continuation) {
            return ((s) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new s(this.f43466i, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43465h == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeUser access$getBrazeUser$p = this.f43466i.brazeUser;
                if (access$getBrazeUser$p != null) {
                    return access$getBrazeUser$p;
                }
                Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class s0 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43467g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43468h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43469b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Card ID cannot be null or blank.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s0(String str, Braze braze) {
            super(0);
            this.f43467g = str;
            this.f43468h = braze;
        }

        public final void a() {
            boolean z11;
            String str = this.f43467g;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43468h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43469b, 6, (Object) null);
                return;
            }
            bo.app.x1 e11 = bo.app.j.f38653h.e(this.f43467g);
            if (e11 != null) {
                this.f43468h.getUdm$android_sdk_base_release().m().a(e11);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$registeredPushToken$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class s1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43470h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Braze f43471i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s1(Braze braze, Continuation<? super s1> continuation) {
            super(2, continuation);
            this.f43471i = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((s1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new s1(this.f43471i, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43470h == 0) {
                ResultKt.throwOnFailure(obj);
                bo.app.m2 access$getRegistrationDataProvider$p = this.f43471i.registrationDataProvider;
                if (access$getRegistrationDataProvider$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                    access$getRegistrationDataProvider$p = null;
                }
                return access$getRegistrationDataProvider$p.a();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s2 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final s2 f43472b = new s2();

        public s2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got error in singleton run without result";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final t f43473b = new t();

        public t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot deserialize null content card json string. Returning null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43474g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t0(String str) {
            super(0);
            this.f43474g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log feed card impression. Card id: ", this.f43474g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43475g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t1(String str) {
            super(0);
            this.f43475g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set the push token ", this.f43475g);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$runForResult$1", f = "Braze.kt", i = {}, l = {1228}, m = "invokeSuspend", n = {}, s = {})
    public static final class t2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43476h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> f43477i;

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "com.braze.Braze$runForResult$1$1", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

            /* renamed from: h  reason: collision with root package name */
            public int f43478h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> f43479i;

            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
            @DebugMetadata(c = "com.braze.Braze$runForResult$1$1$1", f = "Braze.kt", i = {}, l = {1226}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.braze.Braze$t2$a$a  reason: collision with other inner class name */
            public static final class C0039a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

                /* renamed from: c  reason: collision with root package name */
                private /* synthetic */ Object f43480c;

                /* renamed from: h  reason: collision with root package name */
                public int f43481h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> f43482i;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0039a(Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super C0039a> continuation) {
                    super(2, continuation);
                    this.f43482i = function2;
                }

                /* renamed from: a */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
                    return ((C0039a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0039a aVar = new C0039a(this.f43482i, continuation);
                    aVar.f43480c = obj;
                    return aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i11 = this.f43481h;
                    if (i11 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2<CoroutineScope, Continuation<? super T>, Object> function2 = this.f43482i;
                        this.f43481h = 1;
                        obj = function2.invoke((CoroutineScope) this.f43480c, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i11 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return obj;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f43479i = function2;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f43479i, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f43478h == 0) {
                    ResultKt.throwOnFailure(obj);
                    return BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new C0039a(this.f43479i, (Continuation<? super C0039a>) null), 1, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t2(Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super t2> continuation) {
            super(2, continuation);
            this.f43477i = function2;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((t2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new t2(this.f43477i, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f43476h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred async$default = BuildersKt__Builders_commonKt.async$default(b5.f38311a, (CoroutineContext) null, (CoroutineStart) null, new a(this.f43477i, (Continuation<? super a>) null), 3, (Object) null);
                this.f43476h = 1;
                obj = async$default.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43483g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(String str) {
            super(0);
            this.f43483g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize content card json string. Payload: ", this.f43483g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class u0 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43484g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43485h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43486b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Card ID cannot be null or blank.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u0(String str, Braze braze) {
            super(0);
            this.f43484g = str;
            this.f43485h = braze;
        }

        public final void a() {
            boolean z11;
            String str = this.f43484g;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43485h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43486b, 6, (Object) null);
                return;
            }
            bo.app.x1 f11 = bo.app.j.f38653h.f(this.f43484g);
            if (f11 != null) {
                this.f43485h.getUdm$android_sdk_base_release().m().a(f11);
            }
            this.f43485h.getUdm$android_sdk_base_release().g().markCardAsViewed(this.f43484g);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class u1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43487g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43488h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43489g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(0);
                this.f43489g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push token " + this.f43489g + " registered and immediately being flushed.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f43490b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push token must not be null or blank. Not registering for push with Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u1(Braze braze, String str) {
            super(0);
            this.f43487g = braze;
            this.f43488h = str;
        }

        public final void a() {
            boolean z11;
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this.f43487g, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new a(this.f43488h), 6, (Object) null);
            String str = this.f43488h;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this.f43487g, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43490b, 6, (Object) null);
                return;
            }
            bo.app.m2 access$getRegistrationDataProvider$p = this.f43487g.registrationDataProvider;
            if (access$getRegistrationDataProvider$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                access$getRegistrationDataProvider$p = null;
            }
            access$getRegistrationDataProvider$p.a(this.f43488h);
            this.f43487g.getUdm$android_sdk_base_release().c().e();
            this.f43487g.requestImmediateDataFlush();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u2 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43491g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f43492h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u2(String str, boolean z11) {
            super(0);
            this.f43491g = str;
            this.f43492h = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set Google Advertising ID data on device. Google Advertising ID: " + this.f43491g + " and limit-ad-tracking: " + this.f43492h;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43493g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(JSONObject jSONObject) {
            super(0);
            this.f43493g = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize content card json. Payload: ", this.f43493g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final v0 f43494b = new v0();

        public v0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log that the feed was displayed.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Class<T> f43495g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v1(Class<T> cls) {
            super(0);
            this.f43495g = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to remove " + this.f43495g.getName() + " subscriber.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class v2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43496g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43497h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f43498i;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43499b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Google Advertising ID cannot be null or blank";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43500g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ boolean f43501h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z11) {
                super(0);
                this.f43500g = str;
                this.f43501h = z11;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Setting Google Advertising ID: " + this.f43500g + " and limit-ad-tracking: " + this.f43501h;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v2(String str, Braze braze, boolean z11) {
            super(0);
            this.f43496g = str;
            this.f43497h = braze;
            this.f43498i = z11;
        }

        public final void a() {
            if (StringsKt__StringsJVMKt.isBlank(this.f43496g)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43497h, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43499b, 6, (Object) null);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43497h, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) new b(this.f43496g, this.f43498i), 6, (Object) null);
            this.f43497h.getUdm$android_sdk_base_release().r().a(this.f43496g);
            this.f43497h.getUdm$android_sdk_base_release().r().a(this.f43498i);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/appboy/models/cards/Card;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$deserializeContentCard$4", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class w extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Card>, Object> {

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f43502c;

        /* renamed from: h  reason: collision with root package name */
        public int f43503h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43504i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Braze f43505j;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43506b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot deserialize null content card json. Returning null.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(JSONObject jSONObject, Braze braze, Continuation<? super w> continuation) {
            super(2, continuation);
            this.f43504i = jSONObject;
            this.f43505j = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Card> continuation) {
            return ((w) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            w wVar = new w(this.f43504i, this.f43505j, continuation);
            wVar.f43502c = obj;
            return wVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43503h == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f43502c;
                if (this.f43504i != null) {
                    return this.f43505j.getUdm$android_sdk_base_release().j().a(this.f43504i);
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43506b, 6, (Object) null);
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class w0 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43507g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w0(Braze braze) {
            super(0);
            this.f43507g = braze;
        }

        public final void a() {
            bo.app.x1 a11 = bo.app.j.f38653h.a();
            if (a11 != null) {
                this.f43507g.getUdm$android_sdk_base_release().m().a(a11);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43508g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w1(boolean z11) {
            super(0);
            this.f43508g = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to request Content Cards refresh. Requesting from cache: ", Boolean.valueOf(this.f43508g));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w2 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43509g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w2(String str) {
            super(0);
            this.f43509g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set SDK authentication signature on device.\n", this.f43509g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class x extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43510g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(String str) {
            super(0);
            this.f43510g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize in-app message json. Payload: ", this.f43510g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class x0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final x0 f43511b = new x0();

        public x0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log location recorded event.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class x1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43512g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43513h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43514b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Content Cards is not enabled, skipping API call to refresh";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x1(boolean z11, Braze braze) {
            super(0);
            this.f43512g = z11;
            this.f43513h = braze;
        }

        public final void a() {
            if (this.f43512g) {
                this.f43513h.getExternalIEventMessenger$android_sdk_base_release().a(this.f43513h.getUdm$android_sdk_base_release().j().getCachedCardsAsEvent(), ContentCardsUpdatedEvent.class);
            } else if (this.f43513h.getUdm$android_sdk_base_release().e().m()) {
                x2.a.a(this.f43513h.getUdm$android_sdk_base_release().m(), this.f43513h.getUdm$android_sdk_base_release().j().e(), this.f43513h.getUdm$android_sdk_base_release().j().f(), 0, 4, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43513h, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f43514b, 7, (Object) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class x2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43515g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43516h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43517g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(0);
                this.f43517g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Got new sdk auth signature ", this.f43517g);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f43518b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK authentication signature cannot be null or blank";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x2(Braze braze, String str) {
            super(0);
            this.f43515g = braze;
            this.f43516h = str;
        }

        public final void a() {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this.f43515g, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(this.f43516h), 6, (Object) null);
            if (StringsKt__StringsJVMKt.isBlank(this.f43516h)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this.f43515g, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43518b, 6, (Object) null);
                return;
            }
            this.f43515g.getUdm$android_sdk_base_release().o().a(this.f43516h);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/braze/models/inappmessage/IInAppMessage;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.Braze$deserializeInAppMessageString$2", f = "Braze.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class y extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IInAppMessage>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43519h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43520i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Braze f43521j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(String str, Braze braze, Continuation<? super y> continuation) {
            super(2, continuation);
            this.f43520i = str;
            this.f43521j = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IInAppMessage> continuation) {
            return ((y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new y(this.f43520i, this.f43521j, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43519h == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.f43520i;
                if (str == null) {
                    return null;
                }
                return bo.app.f3.a(str, this.f43521j.getUdm$android_sdk_base_release().m());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class y0 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ bo.app.a2 f43522g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Braze f43523h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y0(bo.app.a2 a2Var, Braze braze) {
            super(0);
            this.f43522g = a2Var;
            this.f43523h = braze;
        }

        public final void a() {
            bo.app.x1 a11 = bo.app.j.f38653h.a(this.f43522g);
            if (a11 != null) {
                this.f43523h.getUdm$android_sdk_base_release().m().a(a11);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class y1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final y1 f43524b = new y1();

        public y1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request refresh of feed.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class y2 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43525g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y2(boolean z11) {
            super(0);
            this.f43525g = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set sync policy offline to ", Boolean.valueOf(this.f43525g));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class z extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final z f43526b = new z();

        public z() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the device id.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class z0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43527g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z0(String str) {
            super(0);
            this.f43527g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to log purchase event of: ", this.f43527g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class z1 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43528g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z1(Braze braze) {
            super(0);
            this.f43528g = braze;
        }

        public final void a() {
            this.f43528g.getUdm$android_sdk_base_release().m().a(new a4.a((String) null, (Boolean) null, (Boolean) null, (z3) null, 15, (DefaultConstructorMarker) null).b());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class z2 extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Braze f43529g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f43530h;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f43531g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(boolean z11) {
                super(0);
                this.f43531g = z11;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Setting the image loader deny network downloads to ", Boolean.valueOf(this.f43531g));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z2(Braze braze, boolean z11) {
            super(0);
            this.f43529g = braze;
            this.f43530h = z11;
        }

        public final void a() {
            this.f43529g.getUdm$android_sdk_base_release().m().b(this.f43530h);
            this.f43529g.getUdm$android_sdk_base_release().d().a(this.f43530h);
            Braze braze = this.f43529g;
            if (braze.imageLoader != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) braze, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new a(this.f43530h), 7, (Object) null);
                this.f43529g.getImageLoader().setOffline(this.f43530h);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public Braze(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long nanoTime = System.nanoTime();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f43289b, 7, (Object) null);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        this.applicationContext = applicationContext2;
        String str = Build.MODEL;
        if (str != null) {
            Set<String> set = KNOWN_APP_CRAWLER_DEVICE_MODELS;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (set.contains(lowerCase)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new b(str), 6, (Object) null);
                Companion.enableMockNetworkRequestsAndDropEventsMode();
            }
        }
        setImageLoader(new DefaultBrazeImageLoader(this.applicationContext));
        this.externalIEventMessenger = new bo.app.z0(Companion.getSdkEnablementProvider(this.applicationContext));
        run$android_sdk_base_release(c.f43307b, false, new d(this, context));
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(System.nanoTime(), nanoTime), 7, (Object) null);
    }

    public static /* synthetic */ Object a(Braze braze, Object obj, Function0 function0, boolean z11, Function2 function2, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return braze.runForResult(obj, function0, z11, function2);
    }

    @JvmStatic
    public static final void addSdkMetadata(Context context, EnumSet<BrazeSdkMetadata> enumSet) {
        Companion.addSdkMetadata(context, enumSet);
    }

    @JvmStatic
    public static final void clearEndpointProvider() {
        Companion.clearEndpointProvider();
    }

    @JvmStatic
    public static final boolean configure(Context context, BrazeConfig brazeConfig) {
        return Companion.configure(context, brazeConfig);
    }

    @JvmStatic
    public static final void disableSdk(Context context) {
        Companion.disableSdk(context);
    }

    @JvmStatic
    public static final boolean enableMockNetworkRequestsAndDropEventsMode() {
        return Companion.enableMockNetworkRequestsAndDropEventsMode();
    }

    @JvmStatic
    public static final void enableSdk(Context context) {
        Companion.enableSdk(context);
    }

    @JvmStatic
    public static final Uri getApiEndpoint(Uri uri) {
        return Companion.getApiEndpoint(uri);
    }

    private final ContentCardsUpdatedEvent getCachedContentCardsUpdatedEvent() {
        return (ContentCardsUpdatedEvent) a(this, (Object) null, l.f43403b, false, new m(this, (Continuation<? super m>) null), 4, (Object) null);
    }

    public static /* synthetic */ void getConfigurationProvider$android_sdk_base_release$annotations() {
    }

    @JvmStatic
    public static final String getConfiguredApiKey(BrazeConfigurationProvider brazeConfigurationProvider) {
        return Companion.getConfiguredApiKey(brazeConfigurationProvider);
    }

    public static final IBrazeNotificationFactory getCustomBrazeNotificationFactory() {
        return Companion.getCustomBrazeNotificationFactory();
    }

    public static /* synthetic */ void getDeviceIdReader$android_sdk_base_release$annotations() {
    }

    public static /* synthetic */ void getExternalIEventMessenger$android_sdk_base_release$annotations() {
    }

    @JvmStatic
    public static final Braze getInstance(Context context) {
        return Companion.getInstance(context);
    }

    public static final boolean getOutboundNetworkRequestsOffline() {
        return Companion.getOutboundNetworkRequestsOffline();
    }

    private static /* synthetic */ void getRegistrationDataProvider$annotations() {
    }

    public static /* synthetic */ void getUdm$android_sdk_base_release$annotations() {
    }

    public static /* synthetic */ void isApiKeyPresent$android_sdk_base_release$annotations() {
    }

    public static final boolean isDisabled() {
        return Companion.isDisabled();
    }

    /* access modifiers changed from: private */
    public final boolean isEphemeralEventKey(String str) {
        if (!getConfigurationProvider$android_sdk_base_release().isEphemeralEventsEnabled()) {
            return false;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) n0.f43417b, 6, (Object) null);
        Set<String> ephemeralEventKeys = getConfigurationProvider$android_sdk_base_release().getEphemeralEventKeys();
        boolean contains = ephemeralEventKeys.contains(str);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new o0(str, ephemeralEventKeys, contains), 6, (Object) null);
        return contains;
    }

    /* access modifiers changed from: private */
    public final void publishError(Throwable th2) {
        if (this.udm == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, th2, false, (Function0) l1.f43405b, 4, (Object) null);
            return;
        }
        try {
            getUdm$android_sdk_base_release().k().a(th2, Throwable.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new m1(th2), 4, (Object) null);
        }
    }

    public static /* synthetic */ void run$android_sdk_base_release$default(Braze braze, Function0 function0, boolean z11, Function0 function02, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        braze.run$android_sdk_base_release(function0, z11, function02);
    }

    private final <T> T runForResult(T t11, Function0<String> function0, boolean z11, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (z11 && Companion.isDisabled()) {
            return t11;
        }
        try {
            return BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new t2(function2, (Continuation<? super t2>) null), 1, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) function0, 4, (Object) null);
            publishError(e11);
            return t11;
        }
    }

    public static final void setCustomBrazeNotificationFactory(IBrazeNotificationFactory iBrazeNotificationFactory) {
        Companion.setCustomBrazeNotificationFactory(iBrazeNotificationFactory);
    }

    @JvmStatic
    public static final void setEndpointProvider(IBrazeEndpointProvider iBrazeEndpointProvider) {
        Companion.setEndpointProvider(iBrazeEndpointProvider);
    }

    public static final void setOutboundNetworkRequestsOffline(boolean z11) {
        Companion.setOutboundNetworkRequestsOffline(z11);
    }

    /* access modifiers changed from: private */
    public final void setSyncPolicyOfflineStatus(boolean z11) {
        run$android_sdk_base_release$default(this, new y2(z11), false, new z2(this, z11), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void setUserSpecificMemberVariablesAndStartDispatch(u6 u6Var) {
        setUdm$android_sdk_base_release(u6Var);
        b5.f38311a.a(getUdm$android_sdk_base_release().k());
        t6 b11 = getUdm$android_sdk_base_release().b();
        bo.app.b2 m11 = getUdm$android_sdk_base_release().m();
        v3 v3Var = this.offlineUserStorageProvider;
        b6 b6Var = null;
        if (v3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
            v3Var = null;
        }
        this.brazeUser = new BrazeUser(b11, m11, v3Var.a(), getUdm$android_sdk_base_release().h(), getUdm$android_sdk_base_release().e());
        getUdm$android_sdk_base_release().q().a((bo.app.j2) getUdm$android_sdk_base_release().k());
        getUdm$android_sdk_base_release().n().d();
        getUdm$android_sdk_base_release().f().a((bo.app.h2) getUdm$android_sdk_base_release().n());
        b6 b6Var2 = this.testUserDeviceLoggingManager;
        if (b6Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("testUserDeviceLoggingManager");
            b6Var2 = null;
        }
        b6Var2.a(getUdm$android_sdk_base_release().m());
        b6 b6Var3 = this.testUserDeviceLoggingManager;
        if (b6Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("testUserDeviceLoggingManager");
        } else {
            b6Var = b6Var3;
        }
        b6Var.a(getUdm$android_sdk_base_release().e().r());
    }

    /* access modifiers changed from: private */
    public final void verifyProperSdkSetup() {
        boolean z11 = true;
        for (String next : NECESSARY_APPBOY_SDK_PERMISSIONS) {
            if (!PermissionUtils.hasPermission(this.applicationContext, next)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new j3(next), 6, (Object) null);
                z11 = false;
            }
        }
        if (StringsKt__StringsJVMKt.isBlank(getConfigurationProvider$android_sdk_base_release().getBrazeApiKey().toString())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) k3.f43402b, 6, (Object) null);
            z11 = false;
        }
        if (!z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) l3.f43408b, 6, (Object) null);
        }
    }

    @JvmStatic
    public static final void wipeData(Context context) {
        Companion.wipeData(context);
    }

    public final /* synthetic */ void addSerializedCardJsonToStorage$android_sdk_base_release(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "serializedCardJson");
        run$android_sdk_base_release$default(this, new f(str2, str), false, new g(str, this, str2), 2, (Object) null);
    }

    public <T> void addSingleSynchronousSubscription(IEventSubscriber<T> iEventSubscriber, Class<T> cls) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        try {
            this.externalIEventMessenger.a(iEventSubscriber, cls);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new h(cls), 4, (Object) null);
            publishError(e11);
        }
    }

    public final /* synthetic */ void applyPendingRuntimeConfiguration$android_sdk_base_release() {
        ReentrantLock reentrantLock = brazeClassLock;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) i.f43381b, 7, (Object) null);
            RuntimeAppConfigurationProvider runtimeAppConfigurationProvider = new RuntimeAppConfigurationProvider(this.applicationContext);
            for (BrazeConfig next : pendingConfigurations) {
                if (Intrinsics.areEqual((Object) next, (Object) clearConfigSentinel)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) j.f43389b, 6, (Object) null);
                    runtimeAppConfigurationProvider.clearAllConfigurationValues();
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new k(next), 6, (Object) null);
                    runtimeAppConfigurationProvider.setConfiguration(next);
                }
            }
            pendingConfigurations.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void changeUser(String str) {
        changeUser(str, (String) null);
    }

    public void closeSession(Activity activity) {
        run$android_sdk_base_release$default(this, p.f43442b, false, new q(activity, this), 2, (Object) null);
    }

    public Card deserializeContentCard(String str) {
        if (Companion.isDisabled()) {
            return null;
        }
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) t.f43473b, 6, (Object) null);
            return null;
        }
        try {
            return deserializeContentCard(new JSONObject(str));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new u(str), 4, (Object) null);
            publishError(e11);
            return null;
        }
    }

    public IInAppMessage deserializeInAppMessageString(String str) {
        return (IInAppMessage) a(this, (Object) null, new x(str), false, new y(str, this, (Continuation<? super y>) null), 4, (Object) null);
    }

    public List<FeatureFlag> getAllFeatureFlags() {
        return (List) a(this, CollectionsKt__CollectionsKt.emptyList(), b0.f43303b, false, new c0(this, (Continuation<? super c0>) null), 4, (Object) null);
    }

    public List<Card> getCachedContentCards() {
        if (Companion.isDisabled()) {
            return null;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getAllCards();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) d0.f43330b, 6, (Object) null);
        return null;
    }

    public final BrazeConfigurationProvider getConfigurationProvider$android_sdk_base_release() {
        BrazeConfigurationProvider brazeConfigurationProvider = this.configurationProvider;
        if (brazeConfigurationProvider != null) {
            return brazeConfigurationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationProvider");
        return null;
    }

    public int getContentCardCount() {
        if (Companion.isDisabled()) {
            return -1;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getCardCount();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) e0.f43338b, 6, (Object) null);
        return -1;
    }

    public int getContentCardUnviewedCount() {
        if (Companion.isDisabled()) {
            return -1;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getUnviewedCardCount();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) f0.f43346b, 6, (Object) null);
        return -1;
    }

    public long getContentCardsLastUpdatedInSecondsFromEpoch() {
        if (Companion.isDisabled()) {
            return -1;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getTimestampSeconds();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) g0.f43356b, 6, (Object) null);
        return -1;
    }

    public BrazeUser getCurrentUser() {
        return (BrazeUser) runForResult((Object) null, r.f43458b, false, new s(this, (Continuation<? super s>) null));
    }

    public String getDeviceId() {
        return (String) runForResult("", z.f43526b, false, new a0(this, (Continuation<? super a0>) null));
    }

    public final bo.app.g2 getDeviceIdReader$android_sdk_base_release() {
        bo.app.g2 g2Var = this.deviceIdReader;
        if (g2Var != null) {
            return g2Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceIdReader");
        return null;
    }

    public final bo.app.j2 getExternalIEventMessenger$android_sdk_base_release() {
        return this.externalIEventMessenger;
    }

    public FeatureFlag getFeatureFlag(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return (FeatureFlag) a(this, FeatureFlag.Companion.a(str), new j0(str), false, new k0(this, str, (Continuation<? super k0>) null), 4, (Object) null);
    }

    public IBrazeImageLoader getImageLoader() {
        IBrazeImageLoader iBrazeImageLoader = this.imageLoader;
        if (iBrazeImageLoader != null) {
            return iBrazeImageLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageLoader");
        return null;
    }

    public /* synthetic */ String getInstallTrackingId() {
        return q3.c.a(this);
    }

    public String getRegisteredPushToken() {
        return (String) a(this, (Object) null, r1.f43460b, false, new s1(this, (Continuation<? super s1>) null), 4, (Object) null);
    }

    public final bo.app.c3 getUdm$android_sdk_base_release() {
        bo.app.c3 c3Var = this.udm;
        if (c3Var != null) {
            return c3Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("udm");
        return null;
    }

    public final /* synthetic */ void handleInAppMessageTestPush$android_sdk_base_release(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        run$android_sdk_base_release$default(this, l0.f43404b, false, new m0(intent, this), 2, (Object) null);
    }

    public final Boolean isApiKeyPresent$android_sdk_base_release() {
        return this.isApiKeyPresent;
    }

    public void logCustomEvent(String str) {
        logCustomEvent(str, (BrazeProperties) null);
    }

    @Deprecated(message = "Please call {@link Card#logClick()} instead to log a click.", replaceWith = @ReplaceWith(expression = "Card.logClick()", imports = {}))
    public void logFeedCardClick(String str) {
        run$android_sdk_base_release$default(this, new r0(str), false, new s0(str, this), 2, (Object) null);
    }

    @Deprecated(message = "Please call {@link Card#logImpression()} instead to log an impression.", replaceWith = @ReplaceWith(expression = "Card.logImpression", imports = {}))
    public void logFeedCardImpression(String str) {
        run$android_sdk_base_release$default(this, new t0(str), false, new u0(str, this), 2, (Object) null);
    }

    public void logFeedDisplayed() {
        run$android_sdk_base_release$default(this, v0.f43494b, false, new w0(this), 2, (Object) null);
    }

    public final /* synthetic */ void logLocationRecordedEventFromLocationUpdate$android_sdk_base_release(bo.app.a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "location");
        run$android_sdk_base_release$default(this, x0.f43511b, false, new y0(a2Var, this), 2, (Object) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal) {
        logPurchase(str, str2, bigDecimal, 1);
    }

    public void logPushNotificationActionClicked(String str, String str2, String str3) {
        run$android_sdk_base_release$default(this, b1.f43304b, false, new c1(str, this, str2, str3), 2, (Object) null);
    }

    public void logPushNotificationOpened(String str) {
        run$android_sdk_base_release$default(this, new d1(str), false, new e1(str, this), 2, (Object) null);
    }

    public void logPushStoryPageClicked(String str, String str2) {
        run$android_sdk_base_release$default(this, new h1(str2, str), false, new i1(str, str2, this), 2, (Object) null);
    }

    public void openSession(Activity activity) {
        run$android_sdk_base_release$default(this, j1.f43391b, false, new k1(activity, this), 2, (Object) null);
    }

    public final /* synthetic */ void publishBrazePushAction$android_sdk_base_release(BrazePushEventType brazePushEventType, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazePushEventType, "pushActionType");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        this.externalIEventMessenger.a(new BrazePushEvent(brazePushEventType, brazeNotificationPayload), BrazePushEvent.class);
    }

    public final /* synthetic */ void recordGeofenceTransition$android_sdk_base_release(String str, bo.app.o1 o1Var) {
        run$android_sdk_base_release$default(this, n1.f43418b, false, new o1(str, o1Var, this), 2, (Object) null);
    }

    public void refreshFeatureFlags() {
        run$android_sdk_base_release$default(this, p1.f43444b, false, new q1(this), 2, (Object) null);
    }

    public <T> void removeSingleSubscription(IEventSubscriber<T> iEventSubscriber, Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        if (iEventSubscriber != null) {
            try {
                getExternalIEventMessenger$android_sdk_base_release().b(iEventSubscriber, cls);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new v1(cls), 4, (Object) null);
                publishError(e11);
            }
        }
    }

    public void requestContentCardsRefresh(boolean z11) {
        run$android_sdk_base_release$default(this, new w1(z11), false, new x1(z11, this), 2, (Object) null);
    }

    public void requestFeedRefresh() {
        run$android_sdk_base_release$default(this, y1.f43524b, false, new z1(this), 2, (Object) null);
    }

    public void requestFeedRefreshFromCache() {
        run$android_sdk_base_release$default(this, a2.f43300b, false, new b2(this), 2, (Object) null);
    }

    public final /* synthetic */ void requestGeofenceRefresh$android_sdk_base_release(bo.app.a2 a2Var) {
        run$android_sdk_base_release$default(this, c2.f43317b, false, new d2(a2Var, this), 2, (Object) null);
    }

    public void requestGeofences(double d11, double d12) {
        run$android_sdk_base_release$default(this, g2.f43362b, false, new h2(d11, d12, this), 2, (Object) null);
    }

    public final /* synthetic */ void requestGeofencesInitialization$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, i2.f43387b, false, new j2(this), 2, (Object) null);
    }

    public void requestImmediateDataFlush() {
        run$android_sdk_base_release$default(this, k2.f43401b, false, new l2(this), 2, (Object) null);
    }

    public void requestLocationInitialization() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) m2.f43414b, 7, (Object) null);
        requestGeofencesInitialization$android_sdk_base_release();
        requestSingleLocationUpdate$android_sdk_base_release();
    }

    public final /* synthetic */ void requestSingleLocationUpdate$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, n2.f43419b, false, new o2(this), 2, (Object) null);
    }

    public final /* synthetic */ void retryInAppMessage$android_sdk_base_release(InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "event");
        run$android_sdk_base_release$default(this, new p2(inAppMessageEvent), false, new q2(this, inAppMessageEvent), 2, (Object) null);
    }

    public final /* synthetic */ void run$android_sdk_base_release(Function0 function0, boolean z11, Function0 function02) {
        Intrinsics.checkNotNullParameter(function02, "block");
        if (!z11 || !Companion.isDisabled()) {
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(b5.f38311a, (CoroutineContext) null, (CoroutineStart) null, new r2(function02, (Continuation<? super r2>) null), 3, (Object) null);
            } catch (Exception e11) {
                if (function0 == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) e11, false, (Function0) s2.f43472b, 5, (Object) null);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, function0, 4, (Object) null);
                }
                publishError(e11);
            }
        }
    }

    public final void setApiKeyPresent$android_sdk_base_release(Boolean bool) {
        this.isApiKeyPresent = bool;
    }

    public final void setConfigurationProvider$android_sdk_base_release(BrazeConfigurationProvider brazeConfigurationProvider) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "<set-?>");
        this.configurationProvider = brazeConfigurationProvider;
    }

    public final void setDeviceIdReader$android_sdk_base_release(bo.app.g2 g2Var) {
        Intrinsics.checkNotNullParameter(g2Var, "<set-?>");
        this.deviceIdReader = g2Var;
    }

    public final void setExternalIEventMessenger$android_sdk_base_release(bo.app.j2 j2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "<set-?>");
        this.externalIEventMessenger = j2Var;
    }

    public void setGoogleAdvertisingId(String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "googleAdvertisingId");
        run$android_sdk_base_release$default(this, new u2(str, z11), false, new v2(str, this, z11), 2, (Object) null);
    }

    public void setImageLoader(IBrazeImageLoader iBrazeImageLoader) {
        Intrinsics.checkNotNullParameter(iBrazeImageLoader, "<set-?>");
        this.imageLoader = iBrazeImageLoader;
    }

    public void setRegisteredPushToken(String str) {
        run$android_sdk_base_release$default(this, new t1(str), false, new u1(this, str), 2, (Object) null);
    }

    public void setSdkAuthenticationSignature(String str) {
        Intrinsics.checkNotNullParameter(str, "signature");
        run$android_sdk_base_release$default(this, new w2(str), false, new x2(this, str), 2, (Object) null);
    }

    public final void setUdm$android_sdk_base_release(bo.app.c3 c3Var) {
        Intrinsics.checkNotNullParameter(c3Var, "<set-?>");
        this.udm = c3Var;
    }

    public void subscribeToContentCardsUpdates(IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, ContentCardsUpdatedEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) a3.f43301b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToFeatureFlagsUpdates(IEventSubscriber<FeatureFlagsUpdatedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, FeatureFlagsUpdatedEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) b3.f43306b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToFeedUpdates(IEventSubscriber<FeedUpdatedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, FeedUpdatedEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) c3.f43318b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToNetworkFailures(IEventSubscriber<BrazeNetworkFailureEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, BrazeNetworkFailureEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) d3.f43335b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToNewInAppMessages(IEventSubscriber<InAppMessageEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, InAppMessageEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) e3.f43343b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToNoMatchingTriggerForEvent(IEventSubscriber<NoMatchingTriggerEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, NoMatchingTriggerEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) f3.f43350b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToPushNotificationEvents(IEventSubscriber<BrazePushEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, BrazePushEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) g3.f43363b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToSdkAuthenticationFailures(IEventSubscriber<BrazeSdkAuthenticationErrorEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, BrazeSdkAuthenticationErrorEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) h3.f43380b, 4, (Object) null);
            publishError(e11);
        }
    }

    public void subscribeToSessionUpdates(IEventSubscriber<SessionStateChangedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.c(iEventSubscriber, SessionStateChangedEvent.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) i3.f43388b, 4, (Object) null);
            publishError(e11);
        }
    }

    public final /* synthetic */ void waitForUserDependencyThread$android_sdk_base_release() {
        try {
            runForResult((Object) null, m3.f43415b, false, new n3((Continuation<? super n3>) null));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) o3.f43441b, 4, (Object) null);
        }
    }

    public void changeUser(String str, String str2) {
        run$android_sdk_base_release$default(this, new n(str), false, new o(str, this, str2), 2, (Object) null);
    }

    public void getCurrentUser(IValueCallback<BrazeUser> iValueCallback) {
        Intrinsics.checkNotNullParameter(iValueCallback, "completionCallback");
        if (Companion.isDisabled()) {
            iValueCallback.onError();
            return;
        }
        try {
            Job unused = BuildersKt__Builders_commonKt.launch$default(b5.f38311a, (CoroutineContext) null, (CoroutineStart) null, new h0(iValueCallback, this, (Continuation<? super h0>) null), 3, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) i0.f43382b, 4, (Object) null);
            iValueCallback.onError();
            publishError(e11);
        }
    }

    public void logCustomEvent(String str, BrazeProperties brazeProperties) {
        run$android_sdk_base_release$default(this, new p0(str), false, new q0(str, this, brazeProperties == null ? null : brazeProperties.clone()), 2, (Object) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal, BrazeProperties brazeProperties) {
        logPurchase(str, str2, bigDecimal, 1, brazeProperties);
    }

    public void logPushNotificationOpened(Intent intent) {
        run$android_sdk_base_release$default(this, new f1(intent), false, new g1(intent, this), 2, (Object) null);
    }

    public final /* synthetic */ void requestGeofenceRefresh$android_sdk_base_release(boolean z11) {
        run$android_sdk_base_release$default(this, new e2(z11), false, new f2(this, z11), 2, (Object) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal, int i11) {
        logPurchase(str, str2, bigDecimal, i11, (BrazeProperties) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal, int i11, BrazeProperties brazeProperties) {
        run$android_sdk_base_release$default(this, new z0(str), false, new a1(str, str2, bigDecimal, i11, this, brazeProperties == null ? null : brazeProperties.clone()), 2, (Object) null);
    }

    public Card deserializeContentCard(JSONObject jSONObject) {
        return (Card) a(this, (Object) null, new v(jSONObject), false, new w(jSONObject, this, (Continuation<? super w>) null), 4, (Object) null);
    }
}
