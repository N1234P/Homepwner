package com.example.homepwner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;

public class DetailsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        System.out.println("HERE?");
        return new DetailsFragment();
    }

}