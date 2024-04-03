package com.talabat.talabatcommon.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u00020\b2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0007\u001a\u0012\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f*\u00020\bH\u0002\u001a\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000f\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\f*\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0014\u0010\u0012\u001a\u00020\f*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"FRAGMENT_TAG", "", "REQUEST_CODE", "", "StartForResultBuilder", "Lcom/talabat/talabatcommon/views/StartForResultExecutor;", "T", "", "Landroidx/appcompat/app/AppCompatActivity;", "builder", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "", "Lkotlin/ExtensionFunctionType;", "findFragment", "Lcom/talabat/talabatcommon/views/StartForResultFragment;", "fragment", "removeIfExisting", "replaceFragments", "Landroidx/fragment/app/Fragment;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StartForResultKt {
    @NotNull
    private static final String FRAGMENT_TAG = "StartForResultFragment";
    private static final int REQUEST_CODE = 100;

    @StartForResultDsl
    @NotNull
    public static final <T> StartForResultExecutor<T> StartForResultBuilder(@NotNull AppCompatActivity appCompatActivity, @NotNull Function1<? super StartForResultBuilder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        StartForResultBuilder startForResultBuilder = new StartForResultBuilder();
        function1.invoke(startForResultBuilder);
        return new StartForResultExecutor<>(appCompatActivity, startForResultBuilder);
    }

    private static final StartForResultFragment findFragment(AppCompatActivity appCompatActivity) {
        Fragment findFragmentByTag = appCompatActivity.getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag instanceof StartForResultFragment) {
            return (StartForResultFragment) findFragmentByTag;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final <T> StartForResultFragment fragment(StartForResultExecutor<T> startForResultExecutor) {
        StartForResultFragment startForResultFragment = new StartForResultFragment();
        startForResultFragment.setBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon(startForResultExecutor.getBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon());
        startForResultFragment.setCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon(startForResultExecutor.getCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon());
        return startForResultFragment;
    }

    private static final void removeIfExisting(AppCompatActivity appCompatActivity, StartForResultFragment startForResultFragment) {
        appCompatActivity.getSupportFragmentManager().beginTransaction().remove(startForResultFragment).commitNowAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public static final void replaceFragments(AppCompatActivity appCompatActivity, Fragment fragment) {
        StartForResultFragment findFragment = findFragment(appCompatActivity);
        if (findFragment != null) {
            removeIfExisting(appCompatActivity, findFragment);
        }
        appCompatActivity.getSupportFragmentManager().beginTransaction().add(fragment, FRAGMENT_TAG).commit();
    }
}
