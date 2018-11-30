package com.mobileapps.summaryweekonetwo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobileapps.summaryweekonetwo.MessagesReceivedAdapter;
import com.mobileapps.summaryweekonetwo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecievingFragment extends Fragment {
    public static final String RECV_FRAG_TAG = "sending_frag";
    TextView tvMessageReceived;
    RecyclerView rvMessagesReceived;
    MessagesReceivedAdapter adapter;

    ArrayList<String> messagesRecivedList = new ArrayList<>();

    public static RecievingFragment newInstance() {
        RecievingFragment recievingFragment = new RecievingFragment();

        return recievingFragment;
    }


    public RecievingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recieving, container, false);
        messagesRecivedList.add("MESSAGES");
        rvMessagesReceived = view.findViewById(R.id.rvMessagesReceived);
        adapter = new MessagesReceivedAdapter(messagesRecivedList, this.getContext());
        rvMessagesReceived.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvMessagesReceived.setAdapter(adapter);


        return view;
    }

    public void receiveMessage(String msgReceived) {
        adapter.getNewMsg(msgReceived);
    }

}
