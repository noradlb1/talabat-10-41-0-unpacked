package com.talabat.feature.rewards.presentation.mission.details;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_button_v2.DSSecondaryButton;
import com.designsystem.marshmallow.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.model.MissionButtonType;
import com.talabat.feature.rewards.domain.model.MissionDetails;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.feature.rewards.domain.model.MissionSection;
import com.talabat.feature.rewards.presentation.databinding.FragmentMissionDetailsBinding;
import com.talabat.feature.rewards.presentation.databinding.MissionBlockSectionBinding;
import com.talabat.feature.rewards.presentation.databinding.MissionButtonBasicSectionBinding;
import com.talabat.feature.rewards.presentation.databinding.MissionButtonPrimarySectionBinding;
import com.talabat.feature.rewards.presentation.databinding.MissionInfoSectionBinding;
import com.talabat.feature.rewards.presentation.databinding.MissionTextSectionBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Instrumented
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 82\u00020\u0001:\u000389:B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J$\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u0012H\u0002J\u0012\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010.\u001a\u00020\u00122\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000100H\u0002J\u0012\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u00103\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u000206H\u0002J\f\u00107\u001a\u00020\u0012*\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006;"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/feature/rewards/presentation/databinding/FragmentMissionDetailsBinding;", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "missionTracker", "Lcom/talabat/feature/rewards/domain/MissionTracker;", "getMissionTracker", "()Lcom/talabat/feature/rewards/domain/MissionTracker;", "setMissionTracker", "(Lcom/talabat/feature/rewards/domain/MissionTracker;)V", "closeBottomSheet", "", "getMissionOrigin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "getSectionView", "Landroid/view/View;", "section", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "showSeparator", "", "handleButtonClick", "deeplink", "", "navigateToDeeplink", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupCloseButton", "setupImage", "image", "setupSections", "sections", "", "setupTitle", "title", "shouldCloseBottomSheet", "trackButtonClicked", "buttonType", "Lcom/talabat/feature/rewards/domain/model/MissionButtonType;", "setTopMargin", "Companion", "MissionDetailsParcelable", "Section", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionDetailsDialogFragment extends Fragment implements TraceFieldInterface {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final Function1<String, Regex> DEEPLINK_REGEX = MissionDetailsDialogFragment$Companion$DEEPLINK_REGEX$1.INSTANCE;
    @NotNull
    private static final String HOME_OF_FOOD_DEEPLINK = "s=l";
    @NotNull
    private static final String MISSION_DETAILS = "MISSION_DETAILS";
    @NotNull
    private static final String MISSION_ORIGIN_ORDINAL = "MISSION_ORIGIN_ORDINAL";
    @NotNull
    private static final String REWARDS_DEEPLINK = "s=loyalty";
    @NotNull
    private static final String T_MART_DEEPLINK = "s=ds";
    public Trace _nr_trace;
    private FragmentMissionDetailsBinding binding;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public MissionTracker missionTracker;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0017H\u0002R)\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Companion;", "", "()V", "DEEPLINK_REGEX", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deeplink", "Lkotlin/text/Regex;", "HOME_OF_FOOD_DEEPLINK", "MISSION_DETAILS", "MISSION_ORIGIN_ORDINAL", "REWARDS_DEEPLINK", "T_MART_DEEPLINK", "newInstance", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment;", "missionDetails", "Lcom/talabat/feature/rewards/domain/model/MissionDetails;", "origin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "parseToSection", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "Lcom/talabat/feature/rewards/domain/model/MissionSection;", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Section parseToSection(MissionSection missionSection) {
            String type = missionSection.getType();
            if (type != null) {
                switch (type.hashCode()) {
                    case -118877188:
                        if (type.equals(Section.ButtonBasic.TYPE)) {
                            return new Section.ButtonBasic(missionSection.getText(), missionSection.getDeeplink());
                        }
                        break;
                    case 2283726:
                        if (type.equals(Section.Info.TYPE)) {
                            return new Section.Info(missionSection.getText());
                        }
                        break;
                    case 2603341:
                        if (type.equals(Section.Text.TYPE)) {
                            return new Section.Text(missionSection.getText());
                        }
                        break;
                    case 64279661:
                        if (type.equals(Section.Block.TYPE)) {
                            return new Section.Block(missionSection.getTitle(), missionSection.getText());
                        }
                        break;
                    case 1740870224:
                        if (type.equals(Section.ButtonPrimary.TYPE)) {
                            return new Section.ButtonPrimary(missionSection.getText(), missionSection.getDeeplink());
                        }
                        break;
                }
            }
            return null;
        }

        @NotNull
        public final MissionDetailsDialogFragment newInstance(@NotNull MissionDetails missionDetails, @Nullable MissionOrigin missionOrigin) {
            Intrinsics.checkNotNullParameter(missionDetails, "missionDetails");
            List<MissionSection> sections = missionDetails.getSections();
            Intrinsics.checkNotNull(sections);
            ArrayList arrayList = new ArrayList();
            for (MissionSection parseToSection : sections) {
                Section parseToSection2 = MissionDetailsDialogFragment.Companion.parseToSection(parseToSection);
                if (parseToSection2 != null) {
                    arrayList.add(parseToSection2);
                }
            }
            MissionDetailsParcelable missionDetailsParcelable = new MissionDetailsParcelable(missionDetails.getTitle(), missionDetails.getImage(), arrayList);
            Bundle bundle = new Bundle();
            bundle.putParcelable(MissionDetailsDialogFragment.MISSION_DETAILS, missionDetailsParcelable);
            if (missionOrigin != null) {
                bundle.putInt(MissionDetailsDialogFragment.MISSION_ORIGIN_ORDINAL, missionOrigin.ordinal());
            }
            MissionDetailsDialogFragment missionDetailsDialogFragment = new MissionDetailsDialogFragment();
            missionDetailsDialogFragment.setArguments(bundle);
            return missionDetailsDialogFragment;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "Landroid/os/Parcelable;", "()V", "Block", "ButtonBasic", "ButtonPrimary", "Info", "Text", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Text;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Info;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Block;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$ButtonPrimary;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$ButtonBasic;", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Section implements Parcelable {

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Block;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "title", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getTitle", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Parcelize
        public static final class Block extends Section {
            public static final int $stable = 8;
            @NotNull
            public static final Parcelable.Creator<Block> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @NotNull
            public static final String TYPE = "Block";
            @Nullable
            private final String text;
            @Nullable
            private final String title;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Block$Companion;", "", "()V", "TYPE", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Block> {
                @NotNull
                public final Block createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Block(parcel.readString(), parcel.readString());
                }

                @NotNull
                public final Block[] newArray(int i11) {
                    return new Block[i11];
                }
            }

            public Block(@Nullable String str, @Nullable String str2) {
                super((DefaultConstructorMarker) null);
                this.title = str;
                this.text = str2;
            }

            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getText() {
                return this.text;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            public void writeToParcel(@NotNull Parcel parcel, int i11) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.text);
            }
        }

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$ButtonBasic;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "text", "", "deeplink", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getText", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Parcelize
        public static final class ButtonBasic extends Section {
            public static final int $stable = 8;
            @NotNull
            public static final Parcelable.Creator<ButtonBasic> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @NotNull
            public static final String TYPE = "ButtonBasic";
            @Nullable
            private final String deeplink;
            @Nullable
            private final String text;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$ButtonBasic$Companion;", "", "()V", "TYPE", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<ButtonBasic> {
                @NotNull
                public final ButtonBasic createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ButtonBasic(parcel.readString(), parcel.readString());
                }

                @NotNull
                public final ButtonBasic[] newArray(int i11) {
                    return new ButtonBasic[i11];
                }
            }

            public ButtonBasic(@Nullable String str, @Nullable String str2) {
                super((DefaultConstructorMarker) null);
                this.text = str;
                this.deeplink = str2;
            }

            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getDeeplink() {
                return this.deeplink;
            }

            @Nullable
            public final String getText() {
                return this.text;
            }

            public void writeToParcel(@NotNull Parcel parcel, int i11) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.text);
                parcel.writeString(this.deeplink);
            }
        }

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$ButtonPrimary;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "text", "", "deeplink", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getText", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Parcelize
        public static final class ButtonPrimary extends Section {
            public static final int $stable = 8;
            @NotNull
            public static final Parcelable.Creator<ButtonPrimary> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @NotNull
            public static final String TYPE = "ButtonPrimary";
            @Nullable
            private final String deeplink;
            @Nullable
            private final String text;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$ButtonPrimary$Companion;", "", "()V", "TYPE", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<ButtonPrimary> {
                @NotNull
                public final ButtonPrimary createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ButtonPrimary(parcel.readString(), parcel.readString());
                }

                @NotNull
                public final ButtonPrimary[] newArray(int i11) {
                    return new ButtonPrimary[i11];
                }
            }

            public ButtonPrimary(@Nullable String str, @Nullable String str2) {
                super((DefaultConstructorMarker) null);
                this.text = str;
                this.deeplink = str2;
            }

            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getDeeplink() {
                return this.deeplink;
            }

            @Nullable
            public final String getText() {
                return this.text;
            }

            public void writeToParcel(@NotNull Parcel parcel, int i11) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.text);
                parcel.writeString(this.deeplink);
            }
        }

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Info;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Parcelize
        public static final class Info extends Section {
            public static final int $stable = 8;
            @NotNull
            public static final Parcelable.Creator<Info> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @NotNull
            public static final String TYPE = "Info";
            @Nullable
            private final String text;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Info$Companion;", "", "()V", "TYPE", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Info> {
                @NotNull
                public final Info createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Info(parcel.readString());
                }

                @NotNull
                public final Info[] newArray(int i11) {
                    return new Info[i11];
                }
            }

            public Info(@Nullable String str) {
                super((DefaultConstructorMarker) null);
                this.text = str;
            }

            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getText() {
                return this.text;
            }

            public void writeToParcel(@NotNull Parcel parcel, int i11) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.text);
            }
        }

        @StabilityInferred(parameters = 0)
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Text;", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Parcelize
        public static final class Text extends Section {
            public static final int $stable = 8;
            @NotNull
            public static final Parcelable.Creator<Text> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @NotNull
            public static final String TYPE = "Text";
            @Nullable
            private final String text;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section$Text$Companion;", "", "()V", "TYPE", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Text> {
                @NotNull
                public final Text createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Text(parcel.readString());
                }

                @NotNull
                public final Text[] newArray(int i11) {
                    return new Text[i11];
                }
            }

            public Text(@Nullable String str) {
                super((DefaultConstructorMarker) null);
                this.text = str;
            }

            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getText() {
                return this.text;
            }

            public void writeToParcel(@NotNull Parcel parcel, int i11) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.text);
            }
        }

        private Section() {
        }

        public /* synthetic */ Section(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MissionOrigin.values().length];
            iArr[MissionOrigin.REWARDS.ordinal()] = 1;
            iArr[MissionOrigin.HOME_OF_FOOD.ordinal()] = 2;
            iArr[MissionOrigin.T_MART.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public final void closeBottomSheet() {
        Fragment parentFragment = getParentFragment();
        BottomSheetDialogFragment bottomSheetDialogFragment = parentFragment instanceof BottomSheetDialogFragment ? (BottomSheetDialogFragment) parentFragment : null;
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismiss();
        }
    }

    private final MissionOrigin getMissionOrigin() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        return MissionOrigin.values()[arguments.getInt(MISSION_ORIGIN_ORDINAL)];
    }

    private final View getSectionView(Section section, boolean z11) {
        int i11;
        String str = "";
        if (section instanceof Section.Text) {
            TextView root = MissionTextSectionBinding.inflate(getLayoutInflater()).getRoot();
            String text = ((Section.Text) section).getText();
            if (text != null) {
                str = text;
            }
            root.setText(str);
            Intrinsics.checkNotNullExpressionValue(root, "inflate(layoutInflater).….text.orEmpty()\n        }");
            return root;
        } else if (section instanceof Section.Info) {
            DSAlert root2 = MissionInfoSectionBinding.inflate(getLayoutInflater()).getRoot();
            String text2 = ((Section.Info) section).getText();
            if (text2 != null) {
                str = text2;
            }
            root2.setDescriptor(str);
            Intrinsics.checkNotNullExpressionValue(root2, "inflate(layoutInflater).….text.orEmpty()\n        }");
            return root2;
        } else if (section instanceof Section.Block) {
            MissionBlockSectionBinding inflate = MissionBlockSectionBinding.inflate(getLayoutInflater());
            TextView textView = inflate.tvSectionTitle;
            Section.Block block = (Section.Block) section;
            String title = block.getTitle();
            if (title == null) {
                title = str;
            }
            textView.setText(title);
            TextView textView2 = inflate.tvSectionText;
            String text3 = block.getText();
            if (text3 != null) {
                str = text3;
            }
            textView2.setText(str);
            View view = inflate.vSectionSeparator;
            Intrinsics.checkNotNullExpressionValue(view, "vSectionSeparator");
            if (!z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            view.setVisibility(i11);
            ConstraintLayout root3 = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "inflate(layoutInflater).…wSeparator\n        }.root");
            return root3;
        } else if (section instanceof Section.ButtonPrimary) {
            DSPrimaryButton root4 = MissionButtonPrimarySectionBinding.inflate(getLayoutInflater()).getRoot();
            String text4 = ((Section.ButtonPrimary) section).getText();
            if (text4 != null) {
                str = text4;
            }
            root4.setTitle(str);
            root4.setOnTap(new MissionDetailsDialogFragment$getSectionView$4$1(this, section));
            Intrinsics.checkNotNullExpressionValue(root4, "inflate(layoutInflater).…          }\n            }");
            return root4;
        } else if (section instanceof Section.ButtonBasic) {
            DSSecondaryButton root5 = MissionButtonBasicSectionBinding.inflate(getLayoutInflater()).getRoot();
            String text5 = ((Section.ButtonBasic) section).getText();
            if (text5 != null) {
                str = text5;
            }
            root5.setTitle(str);
            root5.setOnTap(new MissionDetailsDialogFragment$getSectionView$5$1(this, section));
            Intrinsics.checkNotNullExpressionValue(root5, "inflate(layoutInflater).…          }\n            }");
            return root5;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final void handleButtonClick(String str) {
        if (str != null) {
            if (shouldCloseBottomSheet(str)) {
                closeBottomSheet();
            } else {
                navigateToDeeplink(str);
            }
        }
    }

    private final void navigateToDeeplink(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new MissionDetailsDialogFragment$navigateToDeeplink$1(this, str, (Continuation<? super MissionDetailsDialogFragment$navigateToDeeplink$1>) null), 3, (Object) null);
    }

    private final void setTopMargin(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) view.getResources().getDimension(R.dimen.ds_s);
        view.setLayoutParams(layoutParams);
    }

    private final void setupCloseButton() {
        FragmentMissionDetailsBinding fragmentMissionDetailsBinding = this.binding;
        if (fragmentMissionDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMissionDetailsBinding = null;
        }
        fragmentMissionDetailsBinding.dsIconButtonClose.setOnTap(new MissionDetailsDialogFragment$setupCloseButton$1(this));
    }

    private final void setupImage(String str) {
        if (str != null) {
            FragmentMissionDetailsBinding fragmentMissionDetailsBinding = this.binding;
            if (fragmentMissionDetailsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMissionDetailsBinding = null;
            }
            fragmentMissionDetailsBinding.tivImage.setImageUrl(str);
        }
    }

    private final void setupSections(List<? extends Section> list) {
        int i11;
        boolean z11;
        if (list != null) {
            ListIterator<? extends Section> listIterator = list.listIterator(list.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (((Section) listIterator.previous()) instanceof Section.Block) {
                        i11 = listIterator.nextIndex();
                        break;
                    }
                } else {
                    i11 = -1;
                    break;
                }
            }
            int i12 = 0;
            for (Object next : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Section section = (Section) next;
                if (i12 == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                View sectionView = getSectionView(section, z11);
                setTopMargin(sectionView);
                FragmentMissionDetailsBinding fragmentMissionDetailsBinding = this.binding;
                if (fragmentMissionDetailsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentMissionDetailsBinding = null;
                }
                fragmentMissionDetailsBinding.llSections.addView(sectionView);
                i12 = i13;
            }
        }
    }

    private final void setupTitle(String str) {
        FragmentMissionDetailsBinding fragmentMissionDetailsBinding = this.binding;
        if (fragmentMissionDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMissionDetailsBinding = null;
        }
        TextView textView = fragmentMissionDetailsBinding.tvTitle;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    private final boolean shouldCloseBottomSheet(String str) {
        int i11;
        String str2;
        MissionOrigin missionOrigin = getMissionOrigin();
        if (missionOrigin == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[missionOrigin.ordinal()];
        }
        if (i11 == -1) {
            return false;
        }
        if (i11 == 1) {
            str2 = REWARDS_DEEPLINK;
        } else if (i11 == 2) {
            str2 = HOME_OF_FOOD_DEEPLINK;
        } else if (i11 == 3) {
            str2 = T_MART_DEEPLINK;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return DEEPLINK_REGEX.invoke(str2).matches(str);
    }

    /* access modifiers changed from: private */
    public final void trackButtonClicked(MissionButtonType missionButtonType) {
        getMissionTracker().onMissionButtonClicked(missionButtonType, getMissionOrigin());
    }

    @NotNull
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final MissionTracker getMissionTracker() {
        MissionTracker missionTracker2 = this.missionTracker;
        if (missionTracker2 != null) {
            return missionTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("missionTracker");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerMissionDetailsDialogFragmentComponent.factory().create((RewardsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(RewardsFeatureApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentMissionDetailsBinding fragmentMissionDetailsBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "MissionDetailsDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "MissionDetailsDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMissionDetailsBinding inflate = FragmentMissionDetailsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMissionDetailsBinding = inflate;
        }
        ConstraintLayout root = fragmentMissionDetailsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        MissionDetailsParcelable missionDetailsParcelable;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        List<Section> list = null;
        if (arguments != null) {
            missionDetailsParcelable = (MissionDetailsParcelable) arguments.getParcelable(MISSION_DETAILS);
        } else {
            missionDetailsParcelable = null;
        }
        setupCloseButton();
        if (missionDetailsParcelable != null) {
            str = missionDetailsParcelable.getTitle();
        } else {
            str = null;
        }
        setupTitle(str);
        if (missionDetailsParcelable != null) {
            str2 = missionDetailsParcelable.getImage();
        } else {
            str2 = null;
        }
        setupImage(str2);
        if (missionDetailsParcelable != null) {
            list = missionDetailsParcelable.getSections();
        }
        setupSections(list);
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setMissionTracker(@NotNull MissionTracker missionTracker2) {
        Intrinsics.checkNotNullParameter(missionTracker2, "<set-?>");
        this.missionTracker = missionTracker2;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$MissionDetailsParcelable;", "Landroid/os/Parcelable;", "title", "", "image", "sections", "", "Lcom/talabat/feature/rewards/presentation/mission/details/MissionDetailsDialogFragment$Section;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getImage", "()Ljava/lang/String;", "getSections", "()Ljava/util/List;", "getTitle", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class MissionDetailsParcelable implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<MissionDetailsParcelable> CREATOR = new Creator();
        @Nullable
        private final String image;
        @Nullable
        private final List<Section> sections;
        @Nullable
        private final String title;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<MissionDetailsParcelable> {
            @NotNull
            public final MissionDetailsParcelable createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int readInt = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(readInt);
                    for (int i11 = 0; i11 != readInt; i11++) {
                        arrayList2.add(parcel.readParcelable(MissionDetailsParcelable.class.getClassLoader()));
                    }
                    arrayList = arrayList2;
                }
                return new MissionDetailsParcelable(readString, readString2, arrayList);
            }

            @NotNull
            public final MissionDetailsParcelable[] newArray(int i11) {
                return new MissionDetailsParcelable[i11];
            }
        }

        public MissionDetailsParcelable() {
            this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        public MissionDetailsParcelable(@Nullable String str, @Nullable String str2, @Nullable List<? extends Section> list) {
            this.title = str;
            this.image = str2;
            this.sections = list;
        }

        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final List<Section> getSections() {
            return this.sections;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.image);
            List<Section> list = this.sections;
            if (list == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Section writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i11);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MissionDetailsParcelable(String str, String str2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list);
        }
    }
}
