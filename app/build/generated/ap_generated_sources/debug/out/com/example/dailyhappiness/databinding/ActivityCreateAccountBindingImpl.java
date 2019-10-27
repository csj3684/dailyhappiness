package com.example.dailyhappiness.databinding;
import com.example.dailyhappiness.R;
import com.example.dailyhappiness.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateAccountBindingImpl extends ActivityCreateAccountBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.Id, 1);
        sViewsWithIds.put(R.id.tvID, 2);
        sViewsWithIds.put(R.id.edtInputID, 3);
        sViewsWithIds.put(R.id.Passward, 4);
        sViewsWithIds.put(R.id.tvPW, 5);
        sViewsWithIds.put(R.id.edtInputPW, 6);
        sViewsWithIds.put(R.id.PasswardRepeat, 7);
        sViewsWithIds.put(R.id.tvRepeatPW, 8);
        sViewsWithIds.put(R.id.edtRepeatInputPW, 9);
        sViewsWithIds.put(R.id.Gender, 10);
        sViewsWithIds.put(R.id.tvGender, 11);
        sViewsWithIds.put(R.id.rgGender, 12);
        sViewsWithIds.put(R.id.rBtnFemale, 13);
        sViewsWithIds.put(R.id.rBtnMale, 14);
        sViewsWithIds.put(R.id.Age, 15);
        sViewsWithIds.put(R.id.tvAge, 16);
        sViewsWithIds.put(R.id.edtInputAge, 17);
        sViewsWithIds.put(R.id.btnConfirm, 18);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCreateAccountBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityCreateAccountBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.Button) bindings[18]
            , (android.widget.EditText) bindings[17]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[9]
            , (android.widget.RadioButton) bindings[13]
            , (android.widget.RadioButton) bindings[14]
            , (android.widget.RadioGroup) bindings[12]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.activity == variableId) {
            setActivity((com.example.dailyhappiness.CreateAccountActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable com.example.dailyhappiness.CreateAccountActivity Activity) {
        this.mActivity = Activity;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): activity
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}