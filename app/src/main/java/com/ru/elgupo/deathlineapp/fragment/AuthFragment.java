package com.ru.elgupo.deathlineapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ru.elgupo.deathlineapp.MainActivity;
import com.ru.elgupo.deathlineapp.R;
import com.ru.elgupo.deathlineapp.viewModels.AuthViewModel;

public class AuthFragment extends Fragment {

    private static final String AUTH_FRAGMENT_TAG = "Auth_Fragment";

    private MainActivity activity;
    private AuthViewModel authViewModel;

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView errorTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) requireActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        emailEditText = view.findViewById(R.id.email_edittext);
        passwordEditText = view.findViewById(R.id.password_edittext);
        loginButton = view.findViewById(R.id.login_button);
        errorTextView = view.findViewById(R.id.error_textview);

        loginButton.setOnClickListener(v -> login());

        authViewModel.isAuthenticated.observe(getViewLifecycleOwner(), success -> {
            if (success) {
                ((MainActivity) requireActivity()).showCalendarFragment();
            }
        });

        authViewModel.errorMessage.observe(getViewLifecycleOwner(), error -> {
            errorTextView.setText(error);
            errorTextView.setVisibility(error != null ? View.VISIBLE : View.GONE);
        });

        return view;
    }

    private void login() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        authViewModel.login(email, password);
    }

}