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

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowBackStoryFragment.ShowBackStoryInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowBackStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowBackStoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private ShowBackStoryInteractionListener mListener;

    public ShowBackStoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment show_backstory.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowBackStoryFragment newInstance(String param1, String param2) {
        ShowBackStoryFragment fragment = new ShowBackStoryFragment();
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

        View view = inflater.inflate(R.layout.fragment_show_backstory, container, false);

        TextView heroName = (TextView)view.findViewById(R.id.heroName);
        TextView mainTitle = (TextView)view.findViewById(R.id.mainTitle);
        TextView aboutHero = (TextView)view.findViewById(R.id.aboutHero);
        Button startoverBtn = (Button)view.findViewById(R.id.startoverBtn);
        Button primaryBtn = (Button)view.findViewById(R.id.primaryBtn);
        Button secondaryBtn = (Button)view.findViewById(R.id.secondaryBtn);

        MainFragment mainFragment = new MainFragment();
        PickPowerFragment pickPowerFragment = new PickPowerFragment();

        // Text Changes
        if (mainFragment.getInheritance().equalsIgnoreCase("accident") && (pickPowerFragment.getPower().equalsIgnoreCase("turtle"))) {
            heroName.setText("Marty");
            mainTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.big_superman_logo, 0, 0, 0);
            aboutHero.setText("             Marty Rivia was once part of a videogame called Paragon where he participated as a " +
                    "semi professional player. During his career he decided that it was of his best interest to become a Turtle superhero after having a conversation " +
                    "with BloodMordicus, his jungler. Since then, Marty has been roaming through the jungle as a Turtle living a peaceful life.");
        }

        // Primary power result
        if (mainFragment.getInheritance().equalsIgnoreCase("accident")) {
            primaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning, 0, 0, 0);
            primaryBtn.setBackgroundResource(R.drawable.button_base);
        }
        else if (mainFragment.getInheritance().equalsIgnoreCase("genetic")) {
            primaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic, 0, 0, 0);
            primaryBtn.setBackgroundResource(R.drawable.genetic_mutation_powers);
        }
        else if (mainFragment.getInheritance().equalsIgnoreCase("born")) {
            primaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket, 0, 0, 0);
            primaryBtn.setBackgroundResource(R.drawable.born_with_them_powers);
        }

        // Secondary power result
        if (pickPowerFragment.getPower().equalsIgnoreCase("turtle")) {
            secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power, 0, 0, 0);
            secondaryBtn.setBackgroundResource(R.drawable.turtle_power_option);
        }
        else if (pickPowerFragment.getPower().equalsIgnoreCase("lighting")) {
            secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer, 0, 0, 0);
            secondaryBtn.setBackgroundResource(R.drawable.lightning_option);
        }
        else if (pickPowerFragment.getPower().equalsIgnoreCase("flight")) {
            secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0 ,0 ,0);
            secondaryBtn.setBackgroundResource(R.drawable.flight_option);
        }
        else if (pickPowerFragment.getPower().equalsIgnoreCase("web")) {
            secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web, 0, 0, 0);
            secondaryBtn.setBackgroundResource(R.drawable.web_slinging_option);
        }
        else if (pickPowerFragment.getPower().equalsIgnoreCase("laser")) {
            secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision, 0, 0, 0);
            secondaryBtn.setBackgroundResource(R.drawable.laser_vision_option);
        }
        else if (pickPowerFragment.getPower().equalsIgnoreCase("strength")) {
            secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength, 0, 0, 0);
            secondaryBtn.setBackgroundResource(R.drawable.super_strength_option);
        }

        // Back to the beginning to start over
        startoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadMainFragmentScreen();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onShowBackStoryFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ShowBackStoryInteractionListener) {
            mListener = (ShowBackStoryInteractionListener) context;
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
    public interface ShowBackStoryInteractionListener {
        // TODO: Update argument type and name
        void onShowBackStoryFragmentInteraction(Uri uri);
    }
}
