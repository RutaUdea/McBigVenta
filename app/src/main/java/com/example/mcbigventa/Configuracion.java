package com.example.mcbigventa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class Configuracion extends Fragment {

    private CheckBox chbMostrador;
    private CheckBox chbAutomac;
    private CheckBox chbMcEntrega;
    private CheckBox chbMcCafe;
    private CheckBox chbDesatunos;
    private CheckBox chbExtend;
    private CheckBox isla;
    private CheckBox k1;
    private CheckBox k2;
    private CheckBox k3;
    private CheckBox k4;
    private CheckBox k5;
    private CheckBox k6;
    private EditText etMostrador;
    private EditText etAutomac;
    private EditText etMcEntrega;
    private EditText etMcCafe;
    private EditText etDesayunoMostra;
    private EditText etDesayunoAuto;
    private EditText etDesayunoMcEn;
    private EditText etDesayunoMcCa;
    private EditText etAlmuerzoMostra;
    private EditText etAlmuerzoAuto;
    private EditText etAlmuerzoMcEn;
    private EditText etAlmuerzoMcCa;
    private EditText etTardeMostra;
    private EditText etTardeAuto;
    private EditText etTardeMcEn;
    private EditText etTardeMcCa;
    private EditText etCenaMostra;
    private EditText etCenaAuto;
    private EditText etCenaMcEn;
    private EditText etCenaMcCa;
    private EditText etExtendMostra;
    private EditText etExtendAuto;
    private EditText etExtendMcEn;
    private EditText etExtendMcCa;
    private LinearLayout lMostrador;
    private LinearLayout lAutomac;
    private LinearLayout lMcEntrega;
    private LinearLayout lMcCafe;
    private LinearLayout lDesayunosMostra;
    private LinearLayout lDesayunosAuto;
    private LinearLayout lDesayunosMcEn;
    private LinearLayout lDesayunosMcCa;
    private LinearLayout lExtendsMostra;
    private LinearLayout lExtendsAuto;
    private LinearLayout lExtendsMcEn;
    private LinearLayout lExtendsMcCa;
    private Button btnSaveDatos;

    SharedPreferences prefs;

    public Configuracion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_configuracion, container, false);

        Inicializacion(v);

        prefs=this.getActivity().getSharedPreferences("Configuracion", Context.MODE_PRIVATE);

        btnSaveDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarDatos();
                Intent startIntent = new Intent(getActivity(), MainActivity.class);
                startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(startIntent);
                getActivity().finish();
            }
        });

        chbMostrador.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Mostrar(chbMostrador,lMostrador);
            }
        });

        chbAutomac.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Mostrar(chbAutomac,lAutomac);
            }
        });

        chbMcEntrega.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Mostrar(chbMcEntrega,lMcEntrega);
            }
        });



        chbMcCafe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Mostrar(chbMcCafe,lMcCafe);
            }
        });

        chbDesatunos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Mostrar(chbDesatunos,lDesayunosMostra);
                Mostrar(chbDesatunos,lDesayunosAuto);
                Mostrar(chbDesatunos,lDesayunosMcEn);
                Mostrar(chbDesatunos,lDesayunosMcCa);
            }
        });

        chbExtend.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Mostrar(chbExtend,lExtendsMostra);
                Mostrar(chbExtend,lExtendsAuto);
                Mostrar(chbExtend,lExtendsMcEn);
                Mostrar(chbExtend,lExtendsMcCa);
            }
        });

        CargarDatos();
        return v;
    }

    float getFloatFrom(TextView txt) {
        try {
            return NumberFormat.getInstance(new Locale("en", "US")).parse(txt.getText().toString()).floatValue();
        } catch (ParseException e) {
            return 0.0f;
        }
    }


    private void Inicializacion(View v){
        chbMostrador= v.findViewById(R.id.chbMostrador);
        chbAutomac= v.findViewById(R.id.chbAutomac);
        chbMcEntrega= v.findViewById(R.id.chbMcEntrega);
        chbMcCafe= v.findViewById(R.id.chbMcCafe);
        chbDesatunos= v.findViewById(R.id.chbDesayuno);
        chbExtend= v.findViewById(R.id.chbExtends);
        etMostrador= v.findViewById(R.id.edPorcMostrador);
        etAutomac= v.findViewById(R.id.edPorcAutomac);
        etMcEntrega= v.findViewById(R.id.etPorcMcEntrega);
        etMcCafe= v.findViewById(R.id.etPorcMcCafe);
        lMostrador= v.findViewById(R.id.lMostrador);
        lAutomac=v.findViewById(R.id.lAutomac);
        lMcEntrega=v.findViewById(R.id.lMcEntrega);
        lMcCafe=v.findViewById(R.id.lMcCafe);
        lDesayunosMostra=v.findViewById(R.id.lDesayunoMostra);
        lDesayunosAuto=v.findViewById(R.id.lDesayunoAuto);
        lDesayunosMcEn=v.findViewById(R.id.lDesayunoMcEn);
        lDesayunosMcCa=v.findViewById(R.id.lDesayunoMcCa);
        lExtendsMostra=v.findViewById(R.id.lExtendMostra);
        lExtendsAuto=v.findViewById(R.id.lExtendAuto);
        lExtendsMcEn=v.findViewById(R.id.lExtendMcEn);
        lExtendsMcCa=v.findViewById(R.id.lExtendMcCa);
        btnSaveDatos=v.findViewById(R.id.btnSaveConfig);
        etDesayunoMostra=v.findViewById(R.id.edPorDesaMostra);
        etDesayunoAuto=v.findViewById(R.id.edPorDesaAuto);
        etDesayunoMcEn=v.findViewById(R.id.edPorDesaMcEn);
        etDesayunoMcCa=v.findViewById(R.id.edPorDesaMcCa);
        etAlmuerzoMostra=v.findViewById(R.id.etPorcAlmMostra);
        etAlmuerzoAuto=v.findViewById(R.id.etPorcAlmAuto);
        etAlmuerzoMcEn=v.findViewById(R.id.etPorcAlmMcEn);
        etAlmuerzoMcCa=v.findViewById(R.id.etPorcAlmMcCa);
        etTardeMostra=v.findViewById(R.id.etPorcTardeMostra);
        etTardeAuto=v.findViewById(R.id.etPorcTardeAuto);
        etTardeMcEn=v.findViewById(R.id.etPorcTardeMcEn);
        etTardeMcCa=v.findViewById(R.id.etPorcTardeMcCa);
        etCenaMostra=v.findViewById(R.id.etPorcCenaMostra);
        etCenaAuto=v.findViewById(R.id.etPorcCenaAuto);
        etCenaMcEn=v.findViewById(R.id.etPorcCenaMcEn);
        etCenaMcCa=v.findViewById(R.id.etPorcCenaMcCa);
        etExtendMostra=v.findViewById(R.id.etPorcExtendsMostra);
        etExtendAuto=v.findViewById(R.id.etPorcExtendsAuto);
        etExtendMcEn=v.findViewById(R.id.etPorcExtendsMcEn);
        etExtendMcCa=v.findViewById(R.id.etPorcExtendsMcCa);
        isla=v.findViewById(R.id.cbxIsla);
        k1=v.findViewById(R.id.cbxK1);
        k2=v.findViewById(R.id.cbxK2);
        k3=v.findViewById(R.id.cbxK3);
        k4=v.findViewById(R.id.cbxK4);
        k5=v.findViewById(R.id.cbxK5);
        k6=v.findViewById(R.id.cbxK6);
    }

    private void GuardarDatos(){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("Mostrador",chbMostrador.isChecked());
        editor.putBoolean("Automac",chbAutomac.isChecked());
        editor.putBoolean("McEntrega",chbMcEntrega.isChecked());
        editor.putBoolean("McCafe",chbMcCafe.isChecked());
        editor.putBoolean("Desayunos",chbDesatunos.isChecked());
        editor.putBoolean("Extend",chbExtend.isChecked());
        editor.putBoolean("Isla",isla.isChecked());
        editor.putBoolean("k1",k1.isChecked());
        editor.putBoolean("k2",k2.isChecked());
        editor.putBoolean("k3",k3.isChecked());
        editor.putBoolean("k4",k4.isChecked());
        editor.putBoolean("k5",k5.isChecked());
        editor.putBoolean("k6",k6.isChecked());
        editor.putFloat("PMostrador",getFloatFrom(etMostrador));
        editor.putFloat("PAutomac",getFloatFrom(etAutomac));
        editor.putFloat("PMcEntrega",getFloatFrom(etMcEntrega));
        editor.putFloat("PMcCafe",getFloatFrom(etMcCafe));
        editor.putFloat("PDesaMostra",getFloatFrom(etDesayunoMostra));
        editor.putFloat("PDesaAuto",getFloatFrom(etDesayunoAuto));
        editor.putFloat("PDesaMcEn",getFloatFrom(etDesayunoMcEn));
        editor.putFloat("PDesaMcCa",getFloatFrom(etDesayunoMcCa));
        editor.putFloat("PAlmMostra",getFloatFrom(etAlmuerzoMostra));
        editor.putFloat("PAlmAuto",getFloatFrom(etAlmuerzoAuto));
        editor.putFloat("PAlmMcEn",getFloatFrom(etAlmuerzoMcEn));
        editor.putFloat("PAlmMcCa",getFloatFrom(etAlmuerzoMcCa));
        editor.putFloat("PTardeMostra",getFloatFrom(etTardeMostra));
        editor.putFloat("PTardeAuto",getFloatFrom(etTardeAuto));
        editor.putFloat("PTardeMcEn",getFloatFrom(etTardeMcEn));
        editor.putFloat("PTardeMcCa",getFloatFrom(etTardeMcCa));
        editor.putFloat("PCenaMostra",getFloatFrom(etCenaMostra));
        editor.putFloat("PCenaAuto",getFloatFrom(etCenaAuto));
        editor.putFloat("PCenaMcEn",getFloatFrom(etCenaMcEn));
        editor.putFloat("PCenaMcCa",getFloatFrom(etCenaMcCa));
        editor.putFloat("PExtendMostra",getFloatFrom(etExtendMostra));
        editor.putFloat("PExtendAuto",getFloatFrom(etExtendAuto));
        editor.putFloat("PExtendMcEn",getFloatFrom(etExtendMcEn));
        editor.putFloat("PExtendMcCa",getFloatFrom(etExtendMcCa));
        editor.commit();
    }

    private void CargarDatos(){
        chbMostrador.setChecked(prefs.getBoolean("Mostrador",chbMostrador.isChecked()));
        chbAutomac.setChecked(prefs.getBoolean("Automac",chbAutomac.isChecked()));
        chbMcEntrega.setChecked(prefs.getBoolean("McEntrega",chbMcEntrega.isChecked()));
        chbMcCafe.setChecked(prefs.getBoolean("McCafe",chbMcCafe.isChecked()));
        chbDesatunos.setChecked(prefs.getBoolean("Desayunos",chbDesatunos.isChecked()));
        chbExtend.setChecked(prefs.getBoolean("Extend",chbExtend.isChecked()));
        isla.setChecked(prefs.getBoolean("Isla",isla.isChecked()));
        k1.setChecked(prefs.getBoolean("k1",k1.isChecked()));
        k2.setChecked(prefs.getBoolean("k2",k2.isChecked()));
        k3.setChecked(prefs.getBoolean("k3",k3.isChecked()));
        k4.setChecked(prefs.getBoolean("k4",k4.isChecked()));
        k5.setChecked(prefs.getBoolean("k5",k5.isChecked()));
        k6.setChecked(prefs.getBoolean("k6",k6.isChecked()));
        etMostrador.setText(String.valueOf(prefs.getFloat("PMostrador",0)));
        etAutomac.setText(String.valueOf(prefs.getFloat("PAutomac",0)));
        etMcEntrega.setText(String.valueOf(prefs.getFloat("PMcEntrega",0)));
        etMcCafe.setText(String.valueOf(prefs.getFloat("PMcCafe",0)));
        etDesayunoMostra.setText(String.valueOf(prefs.getFloat("PDesaMostra",0)));
        etDesayunoAuto.setText(String.valueOf(prefs.getFloat("PDesaAuto",0)));
        etDesayunoMcEn.setText(String.valueOf(prefs.getFloat("PDesaMcEn",0)));
        etDesayunoMcCa.setText(String.valueOf(prefs.getFloat("PDesaMcCa",0)));
        etAlmuerzoMostra.setText(String.valueOf(prefs.getFloat("PAlmMostra",0)));
        etAlmuerzoAuto.setText(String.valueOf(prefs.getFloat("PAlmAuto",0)));
        etAlmuerzoMcEn.setText(String.valueOf(prefs.getFloat("PAlmMcEn",0)));
        etAlmuerzoMcCa.setText(String.valueOf(prefs.getFloat("PAlmMcCa",0)));
        etTardeMostra.setText(String.valueOf(prefs.getFloat("PTardeMostra",0)));
        etTardeAuto.setText(String.valueOf(prefs.getFloat("PTardeAuto",0)));
        etTardeMcEn.setText(String.valueOf(prefs.getFloat("PTardeMcEn",0)));
        etTardeMcCa.setText(String.valueOf(prefs.getFloat("PTardeMcCa",0)));
        etCenaMostra.setText(String.valueOf(prefs.getFloat("PCenaMostra",0)));
        etCenaAuto.setText(String.valueOf(prefs.getFloat("PCenaAuto",0)));
        etCenaMcEn.setText(String.valueOf(prefs.getFloat("PCenaMcEn",0)));
        etCenaMcCa.setText(String.valueOf(prefs.getFloat("PCenaMcCa",0)));
        etExtendMostra.setText(String.valueOf(prefs.getFloat("PExtendMostra",0)));
        etExtendAuto.setText(String.valueOf(prefs.getFloat("PExtendAuto",0)));
        etExtendMcEn.setText(String.valueOf(prefs.getFloat("PExtendMcEn",0)));
        etExtendMcCa.setText(String.valueOf(prefs.getFloat("PExtendMcCa",0)));
    }

    private void Mostrar(CheckBox m, LinearLayout l){
        if(m.isChecked()){
            l.setVisibility(View.VISIBLE);
        }
        else{
            l.setVisibility(View.GONE);
        }
    }


}
