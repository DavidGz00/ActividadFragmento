package com.dgsdhs.fragmentosestaticos;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoA extends Fragment {

    private EnviarMensaje mensaje;
        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragmento_a, container, false);

            view.findViewById(R.id.enviar).setOnClickListener(v -> {
                TextView tv = view.findViewById(R.id.texto);
                String msg = tv.getText().toString();
                mensaje.enviarDato(msg);
            });
            return view;
        }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mensaje = (EnviarMensaje) context;
    }

    public void onClick(){

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // codigo que almacena la informacion en el bundle

        EditText tv = getActivity().findViewById(R.id.texto);
        String texto = tv.getText().toString();
        outState.putString("MENSAJE", texto);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
            // codigo que recupera la informacion del bundle
            if (savedInstanceState != null) {
                String mensaje = savedInstanceState.getString("MENSAJE");
                EditText tv = getActivity().findViewById(R.id.texto);
                tv.setText(tv.getText());
            }
        }
    }
