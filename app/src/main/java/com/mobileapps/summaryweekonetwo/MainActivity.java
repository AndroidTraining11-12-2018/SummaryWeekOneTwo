package com.mobileapps.summaryweekonetwo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobileapps.summaryweekonetwo.fragments.RecievingFragment;
import com.mobileapps.summaryweekonetwo.fragments.SendingFragment;

public class MainActivity extends AppCompatActivity implements SendingFragment.OnFragmentInteractionListener {
    FragmentManager fragmentManager;
    RecievingFragment recievingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recievingFragment = RecievingFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.sendingFrag,
                        SendingFragment.newInstance(), SendingFragment.SEND_FRAG_TAG)
                .addToBackStack(SendingFragment.SEND_FRAG_TAG)
                .commit();
        fragmentManager.beginTransaction()
                .add(R.id.receivingFrag,
                        recievingFragment, RecievingFragment.RECV_FRAG_TAG)
                .addToBackStack(RecievingFragment.RECV_FRAG_TAG)
                .commit();
    }

    @Override
    public void sendMessageToMainActivity(String messageToSend) {
        recievingFragment.receiveMessage(messageToSend);
    }
}
