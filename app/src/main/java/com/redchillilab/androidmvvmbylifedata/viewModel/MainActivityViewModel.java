package com.redchillilab.androidmvvmbylifedata.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by sijan on 2/4/18.
 */

public class MainActivityViewModel extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<String>();
        }
        return mCurrentName;
    }

    public void onNameChange(String name) {
        if (name.isEmpty()) {
            mCurrentName.setValue("Hi!");
        } else {
            mCurrentName.setValue("Hi, " + name);
        }
    }
}
