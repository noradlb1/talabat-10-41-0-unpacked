package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new Parcelable.Creator<BackStackRecordState>() {
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        public BackStackRecordState[] newArray(int i11) {
            return new BackStackRecordState[i11];
        }
    };
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    public BackStackRecordState(BackStackRecord backStackRecord) {
        int size = backStackRecord.mOps.size();
        this.mOps = new int[(size * 6)];
        if (backStackRecord.mAddToBackStack) {
            this.mFragmentWhos = new ArrayList<>(size);
            this.mOldMaxLifecycleStates = new int[size];
            this.mCurrentMaxLifecycleStates = new int[size];
            int i11 = 0;
            int i12 = 0;
            while (i11 < size) {
                FragmentTransaction.Op op2 = backStackRecord.mOps.get(i11);
                int i13 = i12 + 1;
                this.mOps[i12] = op2.mCmd;
                ArrayList<String> arrayList = this.mFragmentWhos;
                Fragment fragment = op2.mFragment;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.mOps;
                int i14 = i13 + 1;
                iArr[i13] = op2.mFromExpandedOp;
                int i15 = i14 + 1;
                iArr[i14] = op2.mEnterAnim;
                int i16 = i15 + 1;
                iArr[i15] = op2.mExitAnim;
                int i17 = i16 + 1;
                iArr[i16] = op2.mPopEnterAnim;
                iArr[i17] = op2.mPopExitAnim;
                this.mOldMaxLifecycleStates[i11] = op2.mOldMaxState.ordinal();
                this.mCurrentMaxLifecycleStates[i11] = op2.mCurrentMaxState.ordinal();
                i11++;
                i12 = i17 + 1;
            }
            this.mTransition = backStackRecord.mTransition;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    private void fillInBackStackRecord(@NonNull BackStackRecord backStackRecord) {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 < this.mOps.length) {
                FragmentTransaction.Op op2 = new FragmentTransaction.Op();
                int i13 = i11 + 1;
                op2.mCmd = this.mOps[i11];
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Instantiate ");
                    sb2.append(backStackRecord);
                    sb2.append(" op #");
                    sb2.append(i12);
                    sb2.append(" base fragment #");
                    sb2.append(this.mOps[i13]);
                }
                op2.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i12]];
                op2.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i12]];
                int[] iArr = this.mOps;
                int i14 = i13 + 1;
                if (iArr[i13] == 0) {
                    z11 = false;
                }
                op2.mFromExpandedOp = z11;
                int i15 = i14 + 1;
                int i16 = iArr[i14];
                op2.mEnterAnim = i16;
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                op2.mExitAnim = i18;
                int i19 = i17 + 1;
                int i21 = iArr[i17];
                op2.mPopEnterAnim = i21;
                int i22 = iArr[i19];
                op2.mPopExitAnim = i22;
                backStackRecord.mEnterAnim = i16;
                backStackRecord.mExitAnim = i18;
                backStackRecord.mPopEnterAnim = i21;
                backStackRecord.mPopExitAnim = i22;
                backStackRecord.addOp(op2);
                i12++;
                i11 = i19 + 1;
            } else {
                backStackRecord.mTransition = this.mTransition;
                backStackRecord.mName = this.mName;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
                backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
                return;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        fillInBackStackRecord(backStackRecord);
        backStackRecord.mIndex = this.mIndex;
        for (int i11 = 0; i11 < this.mFragmentWhos.size(); i11++) {
            String str = this.mFragmentWhos.get(i11);
            if (str != null) {
                backStackRecord.mOps.get(i11).mFragment = fragmentManager.findActiveFragment(str);
            }
        }
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager fragmentManager, @NonNull Map<String, Fragment> map) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        fillInBackStackRecord(backStackRecord);
        for (int i11 = 0; i11 < this.mFragmentWhos.size(); i11++) {
            String str = this.mFragmentWhos.get(i11);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment != null) {
                    backStackRecord.mOps.get(i11).mFragment = fragment;
                } else {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + str + ")");
                }
            }
        }
        return backStackRecord;
    }

    public BackStackRecordState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }
}
