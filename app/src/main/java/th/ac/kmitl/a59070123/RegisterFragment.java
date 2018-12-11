package th.ac.kmitl.a59070123;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

public class RegisterFragment extends Fragment {

    private SQLiteDatabase sqLiteDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate( R.layout.fragment_register, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        registerNewUser();
    }


    void registerNewUser(){

        Button btn_regis = (Button) getView().findViewById(R.id.regis_btn_regisnew);
        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText) getView().findViewById(R.id.regis_user);
                EditText name = (EditText) getView().findViewById(R.id.regis_fname);
                EditText age = (EditText) getView().findViewById(R.id.regis_age);
                EditText pass = (EditText) getView().findViewById(R.id.regis_pass);

                String user_str = user.getText().toString();
                String name_str = name.getText().toString();
                String age_str = age.getText().toString();
                Integer age_int = Integer.parseInt(age_str);
                String pass_str = pass.getText().toString();


                if (name_str.isEmpty() || pass_str.isEmpty() || age_str.isEmpty() || user_str.isEmpty()) {
                    Toast.makeText(getActivity(),
                            "กรุณากรอกข้อมูลให้ครบถ้วน",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER", "FIELD NAME IS EMPTY");
                }
                else if (user_str.length() < 6 || user_str.length() > 12) {
                    Toast.makeText(getActivity(),
                            "User Id ต้องมีตั้งแต่ 6-12 ตัวอักษร",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER", "userid = fail");
                }
                else if (age_int < 10 || age_int > 80) {
                    Toast.makeText(getActivity(),
                            "ต้องมีอายุตั้งแต่ 10 - 80 ปี ช",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER", "age = fail");
                }
                else if(pass_str.length() < 6){
                    Toast.makeText(getActivity(),
                            "Password ต้องมีมากกว่า 6 ตัวอักษร",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER", "pass = fail");
                }
                else{
                     addRegis();

                }

            }
        });

    }

    void addRegis(){
        final Bundle bundle = getArguments();
        Register register = new Register();
        DbHelper dbHelper = new DbHelper(getActivity());
        if(bundle == null){
            dbHelper.addRegis(register);
        }
        RegisterFragment regisFragment = new RegisterFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("complete", "complete");
        regisFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new LoginFragment())
                .addToBackStack(null).commit();

        Toast.makeText(getActivity(), "Success" , Toast.LENGTH_SHORT).show();
    }

}
