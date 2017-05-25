package com.example.ths.demosearchuserrx.utils.validator;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.reflect.Method;

/**
 * Created by ths on 19/05/2017.
 */

public class Validator {
    private String mMessage;
    private Context mContext;
    private SparseArray<Method> mValidatedMethods;
    private SparseArray<Integer> mAllErrorMessage;

    @ValidMethod(type = { ValidType.NON_EMPTY })
    public String validateValueNonEmpty(String value) {
        boolean isValid = !TextUtils.isEmpty(value);
        mMessage = isValid ? "" : mContext.getString(mAllErrorMessage.valueAt(ValidType.NON_EMPTY));
        return mMessage;
    }
}
