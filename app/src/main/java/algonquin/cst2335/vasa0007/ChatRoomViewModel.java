package algonquin.cst2335.vasa0007;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;

import java.util.ArrayList;

public class ChatRoomViewModel extends ViewModel {


    protected void onCreate(Bundle savedInstanceState) {
        MutableLiveData<ArrayList<String>> messages = new MutableLiveData< >();

    }
}