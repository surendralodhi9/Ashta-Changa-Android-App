package com.example.astachanga;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import static com.example.astachanga.R.layout.layout_dialog;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText user;
    private ExampleDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);
        builder.setView(view)
                .setTitle("Add Player")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String username=user.getText().toString();
                        listener.applyTexts(username);
                    }
                });
        user=view.findViewById(R.id.edit_username);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener) context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString()+"Must implement ExampleListener");
        }
    }
    public interface ExampleDialogListener{

        void applyTexts(String user);
    }
}
