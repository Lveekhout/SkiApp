package com.example.dialogs;

import com.example.activities.R;
import android.os.Bundle;
import android.app.Dialog;
import android.app.AlertDialog;
import android.support.v4.app.DialogFragment;

public class AboutDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.DialogStr)
               .setPositiveButton(R.string.gezien, null);
//               .setPositiveButton(R.string.gezien, new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int id) {
//                       System.out.println("Fire!");
//                   }
//               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
