package com.example.mat.herome.Activities;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toolbar;

import com.example.mat.herome.Fragments.MainFragment;
import com.example.mat.herome.Fragments.PickPowerFragment;
import com.example.mat.herome.Fragments.ShowBackStoryFragment;
import com.example.mat.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener , ShowBackStoryFragment.ShowBackStoryInteractionListener{

    public FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager(); // We begin by creating a FragmentManager to manage multiple fragments.
        Fragment mainFragment = (Fragment)manager.findFragmentById(R.id.fragment_container); // We find the fragment and target its ID.

        if (mainFragment == null) { // if the fragment is null then we create a new one.
            loadMainFragmentScreen();
        }
    }

    public void loadMainFragmentScreen() {
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment).commit(); // we add the fragment to the list
    }

    public void loadPickPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit(); // We add another fragment into list
    }

    public void loadShowBackStoryScreen() {
        ShowBackStoryFragment showBackStoryFragment = new ShowBackStoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, showBackStoryFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onShowBackStoryFragmentInteraction(Uri uri) {

    }
}
