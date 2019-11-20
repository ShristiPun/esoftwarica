package com.example.esoftwarica.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;


    Button Save;
    EditText Name,Age,Address;
    RadioGroup Gender;
    RadioButton Male,Female,Others;
    String uname,uage,uaddress,ugender;
   public static List<student> students=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        Save=root.findViewById(R.id.btnSave);
        Name=root.findViewById(R.id.editName);
        Age=root.findViewById(R.id.editAge);
        Address=root.findViewById(R.id.editAddress);
        Gender=root.findViewById(R.id.radioGender);
        Male=root.findViewById(R.id.radioMale);
        Female=root.findViewById(R.id.radioFemale);
        Others=root.findViewById(R.id.radioOthers);


        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if(i==R.id.radioMale){
                            ugender="Male";

                        }
                        if(i==R.id.radioFemale){
                            ugender="Female";

                        }
                        if(i==R.id.radioOthers){
                            ugender="Others";

                        }
                    }
                });

                Save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        uname=Name.getText().toString();
                        uage=Age.getText().toString();
                        uaddress=Address.getText().toString();
                        if (validate()) {
                            students.add(new student(uage, uname, uaddress, ugender));

                            Name.setText(null);
                            Age.setText(null);
                            Address.setText(null);

                        }
                        }
                });



            }
        });
        return root;
    }
    public boolean validate(){
        if (TextUtils.isEmpty(uname)){
            Name.setError("please enter your Full name");
            return false;
        }

        if (TextUtils.isEmpty(uage)){
            Age.setError("please enter your age");
            return false;
        }
        if (TextUtils.isEmpty(uaddress)){
            Address.setError("please enter your address");
            return false;
        }

        if (TextUtils.isEmpty(ugender)){
            Toast.makeText(getContext(), "please select your gender ", Toast.LENGTH_SHORT).show();
                  return false;
        }


        return true;
    }
}