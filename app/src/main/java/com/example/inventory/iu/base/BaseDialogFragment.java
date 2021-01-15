package com.example.inventory.iu.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inventory.R;

public class BaseDialogFragment extends DialogFragment {
    public static final String TITLE = "title";
    public static final String MESSAGE = "message";
    public  static  final String CONFIRM_DELETE="confirm";

    /* No funciona con navigation, si se puede hacer si se utiliza el FragmentManager
    public interface OnPositiveClickListener{
        void onPositiveClick();
    }
    */


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if(getArguments()!=null) {
            String title = getArguments().getString(TITLE);
            String message = getArguments().getString(MESSAGE);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(title);
            builder.setMessage(message);

            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //No funvions von navigation da error porque getTartger es null

                    //ESTO ESTA MAL: EL cuadro de dialogo ya no es generico y la vuelta muestra siempre el fragment ListDependencyFragment
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(CONFIRM_DELETE,true);
                    NavHostFragment.findNavController(BaseDialogFragment.this).navigate(R.id.action_baseDialogFragment_to_listDependencyFragment,bundle);
                }
            });

            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();
                }
            });
            return builder.create();
        }
        return  null;
    }
}
