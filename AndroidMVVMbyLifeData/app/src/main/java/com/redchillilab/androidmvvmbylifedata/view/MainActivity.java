package com.redchillilab.androidmvvmbylifedata.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.redchillilab.androidmvvmbylifedata.R;
import com.redchillilab.androidmvvmbylifedata.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mModel;
    private TextView              tvTitle;
    private EditText              etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initViewModel();
        initObservers();
        initListener();
    }

    private void initListener() {
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mModel != null) {
                    mModel.onNameChange(s.toString());
                }
            }
        });
    }

    private void initObservers() {
        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI
                tvTitle.setText(newName);
            }
        };
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getCurrentName().observe(this, nameObserver);

    }

    private void initViewModel() {
        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }

    private void initView() {
        tvTitle = findViewById(R.id.tvTitle);
        etName = findViewById(R.id.etName);
    }
}
