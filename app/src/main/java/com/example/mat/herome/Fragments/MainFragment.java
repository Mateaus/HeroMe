package com.example.mat.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mat.herome.Activities.MainActivity;
import com.example.mat.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{ // set an interface View.OnClickListener
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button accidentBtn;
    private Button geneticBtn;
    private Button bornBtn;
    private Button chooseBtn;
    private static String inherit;

    private MainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        accidentBtn = (Button)view.findViewById(R.id.accidentBtn);
        geneticBtn = (Button)view.findViewById(R.id.geneticBtn);
        bornBtn = (Button)view.findViewById(R.id.bornBtn);
        chooseBtn = (Button)view.findViewById(R.id.chooseBtn);

        //disable the choose button because at the beginning nothing has been tap yet
        chooseBtn.setEnabled(false);
        chooseBtn.getBackground().setAlpha(128); //change color opaque

        accidentBtn.setOnClickListener(this); // "this" looks through the fragment for a onClick listener and find the function below "onClick".
        geneticBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);

        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadPickPowerScreen();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        chooseBtn.setEnabled(true); //When one of the button is pressed, we enter this function and enable the chooseBtn again.
        chooseBtn.getBackground().setAlpha(255); //fully opaque

        Button btn = (Button)v; // converts any input into a button
        int leftDrawable = 0;  // setting both left and right Drawables to 0 == nothing.
        int rightDrawable = 0;

        // Whenever we re-enter this function, we reset everything to 0 and we go through the if statements below again.
        accidentBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning, 0, rightDrawable, 0);
        geneticBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic, 0, rightDrawable, 0);
        bornBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket, 0, rightDrawable,0);

        // If statements to check which parameter is being passed through "View v".
        if (btn == accidentBtn) {
            inherit = "accident";
            leftDrawable = R.drawable.lightning;
            rightDrawable = R.drawable.item_selected;
        } else if (btn == geneticBtn) {
            inherit = "genetic";
            leftDrawable = R.drawable.atomic;
            rightDrawable = R.drawable.item_selected;
        } else if (btn == bornBtn) {
            inherit = "born";
            leftDrawable = R.drawable.rocket;
            rightDrawable = R.drawable.item_selected;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,rightDrawable,0); // setting drawables on this button <^>v
    }

    public String getInheritance() {
        return this.inherit;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
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
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
