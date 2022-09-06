package com.example.clase3108dsm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.clase3108dsm.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_number1,txt_number2,txt_resultado;

    private RadioButton rad_sum,rad_sub,rad_mul,rad_div;

    private CheckBox cb_sum,cb_res,cb_mul,cb_div;
    private RadioGroup rad_group;

    private String sum,res,mul,div;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_number1 = (EditText) binding.number1;
        txt_number2 = (EditText) binding.number2;
        txt_resultado = (EditText) binding.resultado;
        rad_sum = (RadioButton) binding.sumar;
        rad_sub = (RadioButton) binding.restar;
        rad_mul = (RadioButton) binding.multiplicar;
        rad_div = (RadioButton) binding.dividir;
        rad_group = (RadioGroup) binding.radGroup;
        cb_sum = (CheckBox) binding.sumarCb;
        cb_res = (CheckBox) binding.restarCb;
        cb_mul = (CheckBox) binding.multiplicarCb;
        cb_div = (CheckBox) binding.dividirCb;

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.calcular.setOnClickListener((View v)->{

            if(cb_sum.isChecked() && cb_res.isChecked() && cb_mul.isChecked() && cb_div.isChecked()){
                txt_resultado.setText("La suma es: " +OpSum()
                        +"\r\nLa resta es: " +OpRes()
                        +"\r\nLa multiplicacion es: " +OpMul()
                        +"\r\nLa division es: " +OpDiv());
            } else if(cb_mul.isChecked() && cb_div.isChecked()){
                txt_resultado.setText("El resultado de la multiplicacion es: "+OpMul()
                +"\r\nEl resultado de la division es:"+OpDiv());
            } else if (cb_sum.isChecked() && cb_res.isChecked()) {
                txt_resultado.setText("El resultado de la suma es: "+OpSum()
                        +"\r\nEl resultado de la resta es:"+OpRes());
            } else if (cb_sum.isChecked() && cb_div.isChecked()){
                txt_resultado.setText("El resultado de la suma es: "+OpSum()
                        +"\r\nEl resultado de la division es:"+OpDiv());
            } else if (cb_sum.isChecked()) {
                txt_resultado.setText("El total de la suma es: "+OpSum());
                cb_sum.setChecked(false);
            } else if (cb_res.isChecked()) {
                txt_resultado.setText("El total de la resta es: "+OpRes());
                cb_res.setChecked(false);
            }else if (cb_mul.isChecked()){
                txt_resultado.setText("El total de la multiplicacion es: "+OpMul());
                cb_mul.setChecked(false);
            }else if (cb_div.isChecked()) {
                txt_resultado.setText("El total de la division es: " + OpDiv());
                cb_div.setChecked(false);

            }else if(rad_sum.isChecked()){
                OpSum();
                rad_group.clearCheck();
            }else if(rad_sub.isChecked()){
                OpRes();
                rad_group.clearCheck();
            }else if(rad_mul.isChecked()){
                OpMul();
                rad_group.clearCheck();
            }else if(rad_div.isChecked()){
                OpDiv();
                rad_group.clearCheck();
            }else{
                ShowMessage();
            }
        });
    }

    public void ShowMessage(){
        Toast.makeText(this.getContext(),"No se ha seleccionado una operación",Toast.LENGTH_LONG).show();
    }
    public String OpSum(){
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 + val_2;
        String res = String.valueOf(sum);
        txt_resultado.setText(res);
        return res;
    }
    public String OpRes(){
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 - val_2;
        String res = String.valueOf(sum);
        txt_resultado.setText(res);
        return res;
    }
    public String OpMul(){
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 * val_2;
        String res = String.valueOf(sum);
        txt_resultado.setText(res);
        return res;
    }
    public String OpDiv(){
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        String res = "";
        if (val_2 != 0) {
            double sum = val_1 / val_2;
            res = String.valueOf(sum);
            txt_resultado.setText(res);
        } else {
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }
        return res;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}