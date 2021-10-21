package com.dgsdhs.fragmentosestaticos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class FragmentoB extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmento_b, container, false);
        return view;
    }

    public void recibir(String dato) {
        TextView tv = getActivity().findViewById(R.id.mensaje);
        tv.setText(dato);
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // codigo que almacena la informacion en el bundle
        TextView tv = getActivity().findViewById(R.id.mensaje);
        String mensaje = tv.getText().toString();
        outState.putString("MENSAJE", mensaje);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
            // codigo que recupera la informacion del bundle
            if (savedInstanceState != null) {
                String mensaje = savedInstanceState.getString("MENSAJE");
                TextView tv = getActivity().findViewById(R.id.mensaje);
                tv.setText(mensaje);
            }
        }
    }

