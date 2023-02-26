package com.example.homepwner;


import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class DetailsFragment extends Fragment {

    private Item uDetail;
    private EditText uNameField;
    private EditText uSerialField;
    private EditText uValueField;
    private Button uDateButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uDetail = new Item();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        uNameField = v.findViewById(R.id.name);
        uSerialField = v.findViewById(R.id.serial);
        uValueField = v.findViewById(R.id.value);
        uDateButton = v.findViewById(R.id.date);


        uNameField.setText(bundle.getString("name"));
        uSerialField.setText(bundle.getString("id"));
        uValueField.setText(bundle.getString("value"));
        uDateButton.setText(bundle.getString("date"));


        uDateButton.setText(uDetail.getDate().toString());
        uDateButton.setEnabled(false);
        return v;


    }



}