package th.ac.kmitl.a59070123;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class LoginFragment extends Fragment {
    ArrayList<Register> regiss = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        initLoginBTN();
        initGotoRegisterBTN();
        super.onActivityCreated(savedInstanceState);
    }

    void initLoginBTN() {
        Register register = new Register();

        Button btn_login = (Button) getView().findViewById(R.id.login_login_btn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userId = (EditText) getView().findViewById(R.id.login_userId);
                EditText pass = (EditText) getView().findViewById(R.id.login_pass);

                String userID_str = userId.getText().toString();
                String pass_str = pass.getText().toString();


                if (userID_str.isEmpty() || pass_str.isEmpty()) {
                    Toast.makeText(getActivity(),
                            "Please fill out this form",
                            Toast.LENGTH_SHORT
                    ).show();

                    /////////////////////BYPASS
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new HomeFragment()).addToBackStack(null)
                            .commit();
                    ///////////////////don't forget delete

                    Log.d("USER", "USER OR PASSWORD IS EMPTY");
                }
//                else if(userID_str.equals(register.getUser())){
//
//                }
            }
        });
    }

    void initGotoRegisterBTN(){
        TextView btn_regis = (TextView) getView().findViewById(R.id.login_regis_btn);
        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });
    }


}
