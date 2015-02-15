package nl.lveekhout.dialogs;

import nl.lveekhout.data.GlobalAppData;
import nl.lveekhout.fragmentactivities.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class ShowCoordDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(GlobalAppData.maxSpeedCoord + "\n" + "Aantal metingen: " + GlobalAppData.listCoordsList.size())
               .setTitle("Coördinaten")
               .setPositiveButton("Kopieren", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE); 
                       ClipData clip = ClipData.newPlainText("simple_text", GlobalAppData.maxSpeedCoord);
                       clipboard.setPrimaryClip(clip);
                       Toast.makeText(getActivity(), "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
                   }
               })
               .setNegativeButton(R.string.gezien, null);
        return builder.create();
    }
}
