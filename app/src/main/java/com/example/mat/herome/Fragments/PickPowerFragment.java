package com.example.mat.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mat.herome.Activities.MainActivity;
import com.example.mat.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button strengthBtn;
    private Button storyBtn;

    private static String power;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);

        storyBtn = (Button)view.findViewById(R.id.storyBtn);
        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightningBtn);
        flightBtn = (Button)view.findViewById(R.id.flightBtn);
        webBtn = (Button)view.findViewById(R.id.webBtn);
        laserBtn = (Button)view.findViewById(R.id.laserBtn);
        strengthBtn = (Button)view.findViewById(R.id.strengthBtn);

        // Disabling storyBtn until a power has been chosen
        storyBtn.setEnabled(false);
        storyBtn.getBackground().setAlpha(128);

        // Buttons to be sent to the onclick function
        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        strengthBtn.setOnClickListener(this);

        storyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadShowBackStoryScreen();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        // Enabling storyBtn because a button has been pressed
        storyBtn.setEnabled(true);
        storyBtn.getBackground().setAlpha(255);

        Button btn = (Button)v; // converting incoming button inputs into variable btn.
        int leftDrawable = 0; //TODO : Find a solution to avoid writing all this unnecessary code!(bring variables outside function)
        int rightDrawable = 0;

        // resetting images to 0 whenever a new button is pressed just like in MainFragment.
        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        strengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);

        if (btn == turtleBtn){
            power = "turtle";
            leftDrawable = R.drawable.turtle_power;
            rightDrawable = R.drawable.item_selected;
        }
        else if (btn == lightningBtn){
            power = "lighting";
            leftDrawable = R.drawable.thors_hammer;
            rightDrawable = R.drawable.item_selected;
        }
        else if (btn == flightBtn){
            power = "flight";
            leftDrawable = R.drawable.super_man_crest;
            rightDrawable = R.drawable.item_selected;
        }
        else if (btn == webBtn){
            power = "web";
            leftDrawable = R.drawable.spider_web;
            rightDrawable = R.drawable.item_selected;
        }
        else if (btn == laserBtn){
            power = "laser";
            leftDrawable = R.drawable.laser_vision;
            rightDrawable = R.drawable.item_selected;
        }
        else if (btn == strengthBtn){
            power = "strength";
            leftDrawable = R.drawable.super_strength;
            rightDrawable = R.drawable.item_selected;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, rightDrawable, 0);

    }

    public String getPower() {
        return this.power;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
