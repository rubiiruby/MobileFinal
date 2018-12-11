package th.ac.kmitl.a59070123;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //go();

    }
//    void go() {
//        public void onCilckListner(){
//            if (getView().equals("PROFILE SETUP")) {
//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.main_view, new ProfileFragment())
//                        .addToBackStack(null)
//                        .commit();
//            } else if (getView().equals("MY FRIENDS")) {
//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.main_view, new MyfriendFragment())
//                        .addToBackStack(null)
//                        .commit();
//            } else if (getView().equals("SIGN OUT")) {
//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.main_view, new LoginFragment())
//                        .addToBackStack(null)
//                        .commit();
//            }
//
//        }
//    }

}
