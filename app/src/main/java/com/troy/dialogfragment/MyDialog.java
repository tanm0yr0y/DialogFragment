package com.troy.dialogfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyDialog extends DialogFragment implements View.OnClickListener{

    Button yes, no;
    Communicator communicator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog, null);
        yes = view.findViewById(R.id.button3);
        no = view.findViewById(R.id.button2);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button3) {
            communicator.dialogMessage("Yes was clicked");
            dismiss();
        }
        else if(v.getId() == R.id.button2) {
            communicator.dialogMessage("No was clicked");
            dismiss();
        }
    }

    public interface Communicator {
        public void dialogMessage(String message);
    }
}
