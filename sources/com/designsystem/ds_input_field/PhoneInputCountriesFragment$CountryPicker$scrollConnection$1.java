package com.designsystem.ds_input_field;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment$CountryPicker$scrollConnection$1 implements NestedScrollConnection {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31880b;

    public PhoneInputCountriesFragment$CountryPicker$scrollConnection$1(PhoneInputCountriesFragment phoneInputCountriesFragment) {
        this.f31880b = phoneInputCountriesFragment;
    }

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m8465onPostFlingRZ2iAVY(long j11, long j12, @NotNull Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.DefaultImpls.m4198onPostFlingRZ2iAVY(this, j11, j12, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m8466onPostScrollDzOQY0M(long j11, long j12, int i11) {
        boolean z11;
        if (((double) Offset.m2677getYimpl(j12)) > 0.0d) {
            if (Offset.m2677getYimpl(j11) == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.f31880b.allowSheetDrag(true);
            }
        }
        return NestedScrollConnection.DefaultImpls.m4199onPostScrollDzOQY0M(this, j11, j12, i11);
    }

    @Nullable
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m8467onPreFlingQWom1Mo(long j11, @NotNull Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.DefaultImpls.m4200onPreFlingQWom1Mo(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m8468onPreScrollOzD1aCk(long j11, int i11) {
        return NestedScrollConnection.DefaultImpls.m4201onPreScrollOzD1aCk(this, j11, i11);
    }
}
