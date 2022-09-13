package com.example.clase3108dsm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.clase3108dsm.databinding.FragmentSecondBinding;

/**
 * @author Vanesa Briones Ibacache
 */
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private EditText txt_number1,txt_number2,txt_resultado2;

    private Spinner sp_operation;

    private ImageButton btn_image;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        txt_number1 = (EditText) binding.txtNumber1;
        txt_number2 = (EditText) binding.txtNumber2;
        txt_resultado2 = (EditText) binding.editTextTextPersonName3;
        sp_operation = (Spinner) binding.spiOption;
        btn_image = (ImageButton) binding.imCalculate;


        String [] operations = {
                "Selecciona una operación",
                "Sumar",
                "Restar",
                "Multiplicar",
                "Dividir",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,operations);
        sp_operation.setAdapter(adapter);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });

        binding.imCalculate.setOnClickListener((View v)->{
            String selected = sp_operation.getSelectedItem().toString();

            switch (selected){
                case "Sumar":
                    opSum();
                    break;
                case "Restar":
                    opRes();
                    break;
                case "Multiplicar":
                    opMul();
                    break;
                case "Dividir":
                    opDiv();
                    break;
                default:
                    showMessage();
                    break;
            }
        });

    }
    public void showMessage(){
        Toast.makeText(this.getContext(),"No se ha seleccionado una operación",Toast.LENGTH_LONG).show();
    }

    /**
     *
     * @return res
     */
    public String opSum() {
        String res = "";
        if (txt_number1.getText().toString().isEmpty() || txt_number2.getText().toString().isEmpty()) {
            Toast.makeText(this.getContext(),"Uno o mas campos estan vacios",Toast.LENGTH_SHORT).show();
        } else {
            double val_1 = Integer.parseInt(txt_number1.getText().toString());
            double val_2 = Integer.parseInt(txt_number2.getText().toString());
            double sum = val_1 + val_2;
            res = String.valueOf(sum);
            txt_resultado2.setText(res);
            return res;
        }
        return res;
    }
    public String opRes(){
        String res = "";
        if (txt_number1.getText().toString().isEmpty() || txt_number2.getText().toString().isEmpty()) {
            Toast.makeText(this.getContext(),"Uno o mas campos estan vacios",Toast.LENGTH_SHORT).show();
        } else {
            double val_1 = Integer.parseInt(txt_number1.getText().toString());
            double val_2 = Integer.parseInt(txt_number2.getText().toString());
            double sum = val_1 - val_2;
            res = String.valueOf(sum);
            txt_resultado2.setText(res);
        }
        return res;
    }
    public String opMul(){
        String res = "";
        if (txt_number1.getText().toString().isEmpty() || txt_number2.getText().toString().isEmpty()) {
            Toast.makeText(this.getContext(),"Uno o mas campos estan vacios",Toast.LENGTH_SHORT).show();
        } else {
            double val_1 = Integer.parseInt(txt_number1.getText().toString());
            double val_2 = Integer.parseInt(txt_number2.getText().toString());
            double sum = val_1 * val_2;
            res = String.valueOf(sum);
            txt_resultado2.setText(res);
        }
        return res;
    }
    public String opDiv(){
        String res = "";
        if (txt_number1.getText().toString().isEmpty() || txt_number2.getText().toString().isEmpty()) {
            Toast.makeText(this.getContext(),"Uno o mas campos estan vacios",Toast.LENGTH_SHORT).show();
        }else {
            double val_1 = Integer.parseInt(txt_number1.getText().toString());
            double val_2 = Integer.parseInt(txt_number2.getText().toString());
            res = "";
            if (val_2 != 0) {
                double sum = val_1 / val_2;
                res = String.valueOf(sum);
                txt_resultado2.setText(res);
            } else {
                Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
            }
        }
        return res;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}