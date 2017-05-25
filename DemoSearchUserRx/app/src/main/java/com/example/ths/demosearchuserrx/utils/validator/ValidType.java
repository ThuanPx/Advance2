package com.example.ths.demosearchuserrx.utils.validator;

import android.support.annotation.IntDef;

/**
 * Created by ths on 19/05/2017.
 */
@IntDef({ ValidType.NON_EMPTY, ValidType.VALUE_RANGE_0_100})
public @interface ValidType {
    int NON_EMPTY =0x00;
    int VALUE_RANGE_0_100=0x01;
}
