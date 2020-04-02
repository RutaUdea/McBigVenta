package com.example.mcbigventa;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class Comparables extends Fragment {

    private TableRow mostrador;
    private TableRow auto;
    private TableRow mcEntrega;
    private TableRow mcCafe;
    private TableRow isla;
    private TableRow k1;
    private TableRow k2;
    private TableRow k3;
    private TableRow k4;
    private TableRow k5;
    private TableRow k6;
    private TableRow mostrador2;
    private TableRow auto2;
    private TableRow mcEntrega2;
    private TableRow mcCafe2;
    private TableRow isla2;
    private TableRow k12;
    private TableRow k22;
    private TableRow k32;
    private TableRow k42;
    private TableRow k52;
    private TableRow k62;

    private TextView proMostra;
    private TextView proAuto;
    private TextView proMcEn;
    private TextView proMcCa;
    private TextView proIsla;
    private TextView proK1;
    private TextView proK2;
    private TextView proK3;
    private TextView proK4;
    private TextView proK5;
    private TextView proK6;
    private TextView proMostra2;
    private TextView proAuto2;
    private TextView proMcEn2;
    private TextView proMcCa2;
    private TextView proIsla2;
    private TextView proK12;
    private TextView proK22;
    private TextView proK32;
    private TextView proK42;
    private TextView proK52;
    private TextView proK62;
    private TextView realMostra;
    private TextView realAuto;
    private TextView realMcEn;
    private TextView realMcCa;
    private TextView realIsla;
    private TextView realK1;
    private TextView realK2;
    private TextView realK3;
    private TextView realK4;
    private TextView realK5;
    private TextView realK6;
    private TextView realMostra2;
    private TextView realAuto2;
    private TextView realMcEn2;
    private TextView realMcCa2;
    private TextView realIsla2;
    private TextView realK12;
    private TextView realK22;
    private TextView realK32;
    private TextView realK42;
    private TextView realK52;
    private TextView realK62;
    private TextView difMostra;
    private TextView difAuto;
    private TextView difMcEn;
    private TextView difMcCa;
    private TextView difIsla;
    private TextView difK1;
    private TextView difK2;
    private TextView difK3;
    private TextView difK4;
    private TextView difK5;
    private TextView difK6;
    private TextView difMostra2;
    private TextView difAuto2;
    private TextView difMcEn2;
    private TextView difMcCa2;
    private TextView difIsla2;
    private TextView difK12;
    private TextView difK22;
    private TextView difK32;
    private TextView difK42;
    private TextView difK52;
    private TextView difK62;

    private boolean bmostra, bautmac, bmcentrega, bmcaafe, bIsla, bK1,bK2,bK3,bK4,bK5,bK6;

    FirebaseDatabase baseDatos;
    DatabaseReference bdReferencia;
    VentasDB ventasSegDia;
    SharedPreferences prefs;

    public Comparables() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_comparables, container, false);
        baseDatos=FirebaseDatabase.getInstance();
        bdReferencia=baseDatos.getReference();
        Inicializacion(v);
        CargarConfiguracion();

        bdReferencia.child("POB").child("Comparables").child("Mostrador").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int venta=0;
                int gcs=0;
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()) {
                    venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                    gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                }
                realMostra.setText(String.valueOf(venta));
                realMostra2.setText(String.valueOf(gcs));
                CalculoDiferenciaT(realMostra,difMostra,proMostra);
                CalculoDiferenciaT(realMostra2,difMostra2,proMostra2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        bdReferencia.child("POB").child("Comparables").child("McEntrega").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int venta=0;
                int gcs=0;
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()) {
                    venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                    gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                }
                realMcEn.setText(String.valueOf(venta));
                realMcEn2.setText(String.valueOf(gcs));
                CalculoDiferenciaT(realAuto,difAuto,proAuto);
                CalculoDiferenciaT(realAuto2,difAuto2,proAuto2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        bdReferencia.child("POB").child("Comparables").child("McCafe").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int venta=0;
                int gcs=0;
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()) {
                    venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                    gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                }
                realMcCa.setText(String.valueOf(venta));
                realMcCa2.setText(String.valueOf(gcs));
                CalculoDiferenciaT(realMcEn,difMcEn,proMcEn);
                CalculoDiferenciaT(realMcEn2,difMcEn2,proMcEn2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        bdReferencia.child("POB").child("Comparables").child("Auto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int venta=0;
                int gcs=0;
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()) {
                    venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                    gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                }
                realAuto.setText(String.valueOf(venta));
                realAuto2.setText(String.valueOf(gcs));
                CalculoDiferenciaT(realMcCa,difMcCa,proMcCa);
                CalculoDiferenciaT(realMcCa2,difMcCa2,proMcCa2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(bIsla){
            bdReferencia.child("POB").child("Comparables").child("Isla").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int venta=0;
                    int gcs=0;
                    for (DataSnapshot snapshot :
                            dataSnapshot.getChildren()) {
                        venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                        gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                    }
                    realIsla.setText(String.valueOf(venta));
                    realIsla2.setText(String.valueOf(gcs));
                    CalculoDiferenciaT(realIsla,difIsla,proIsla);
                    CalculoDiferenciaT(realIsla2,difIsla2,proIsla2);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if(bK1){
            bdReferencia.child("POB").child("Comparables").child("K1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int venta=0;
                    int gcs=0;
                    for (DataSnapshot snapshot :
                            dataSnapshot.getChildren()) {
                        venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                        gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                    }
                    realK1.setText(String.valueOf(venta));
                    realK12.setText(String.valueOf(gcs));
                    CalculoDiferenciaT(realK1,difK1,proK1);
                    CalculoDiferenciaT(realK12,difK12,proK12);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if(bK2){
            bdReferencia.child("POB").child("Comparables").child("K2").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int venta=0;
                    int gcs=0;
                    for (DataSnapshot snapshot :
                            dataSnapshot.getChildren()) {
                        venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                        gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                    }
                    realK2.setText(String.valueOf(venta));
                    realK22.setText(String.valueOf(gcs));
                    CalculoDiferenciaT(realK2,difK2,proK2);
                    CalculoDiferenciaT(realK22,difK22,proK22);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if(bK3){
            bdReferencia.child("POB").child("Comparables").child("K3").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int venta=0;
                    int gcs=0;
                    for (DataSnapshot snapshot :
                            dataSnapshot.getChildren()) {
                        venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                        gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                    }
                    realK3.setText(String.valueOf(venta));
                    realK32.setText(String.valueOf(gcs));
                    CalculoDiferenciaT(realK3,difK3,proK3);
                    CalculoDiferenciaT(realK32,difK32,proK32);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if(bK4){
            bdReferencia.child("POB").child("Comparables").child("K1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int venta=0;
                    int gcs=0;
                    for (DataSnapshot snapshot :
                            dataSnapshot.getChildren()) {
                        venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                        gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                    }
                    realK4.setText(String.valueOf(venta));
                    realK42.setText(String.valueOf(gcs));
                    CalculoDiferenciaT(realK4,difK4,proK4);
                    CalculoDiferenciaT(realK42,difK42,proK42);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if(bK5){
            bdReferencia.child("POB").child("Comparables").child("K1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int venta=0;
                    int gcs=0;
                    for (DataSnapshot snapshot :
                            dataSnapshot.getChildren()) {
                        venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                        gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                    }
                    realK5.setText(String.valueOf(venta));
                    realK52.setText(String.valueOf(gcs));
                    CalculoDiferenciaT(realK5,difK5,proK5);
                    CalculoDiferenciaT(realK52,difK52,proK52);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if(bK6){
            bdReferencia.child("POB").child("Comparables").child("K1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int venta=0;
                    int gcs=0;
                    for (DataSnapshot snapshot :
                            dataSnapshot.getChildren()) {
                        venta=venta+getintFrom(snapshot.child("ventas").getValue(String.class));
                        gcs=gcs+getintFrom(snapshot.child("gcs").getValue(String.class));
                    }
                    realK6.setText(String.valueOf(venta));
                    realK62.setText(String.valueOf(gcs));
                    CalculoDiferenciaT(realK6,difK6,proK6);
                    CalculoDiferenciaT(realK62,difK62,proK62);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        // Inflate the layout for this fragment
        return v;
    }

    private void CalculoDiferenciaT(TextView real, final TextView dif, final TextView pro){
        float venta=0;
        int proVenta=0;
        if(real.getText().toString().isEmpty()){
            venta=0;
        }else {
            venta=getintFrom(real.getText().toString());
        }
        proVenta=getintFrom(pro.getText().toString());
        venta=(1-(proVenta-venta)/proVenta)*100;
        dif.setText(String.format("%.2f",(venta)));
        Colorear(dif,venta);
    }

    int getintFrom(String txt) {
        try {
            return NumberFormat.getInstance(new Locale("en", "CA")).parse(txt).intValue();
        } catch (ParseException e) {
            return 0;
        }
    }

    private void Colorear(TextView editText, float venta){
        if(venta<100){
            editText.setBackgroundColor(0xA1FF0000);
        }
        else
        {
            editText.setBackgroundColor(0x8000FF2B);
        }
    }


    private void CargarConfiguracion()
    {
        prefs=this.getActivity().getSharedPreferences("Configuracion", Context.MODE_PRIVATE);
        bmostra =prefs.getBoolean("Mostrador",true);
        bautmac =prefs.getBoolean("Automac",false);
        bmcentrega =prefs.getBoolean("McEntrega",false);
        bmcaafe =prefs.getBoolean("McCafe",false);
        bIsla=prefs.getBoolean("Isla",false);
        bK1=prefs.getBoolean("k1",false);
        bK2=prefs.getBoolean("k2",false);
        bK3=prefs.getBoolean("k3",false);
        bK4=prefs.getBoolean("k4",false);
        bK5=prefs.getBoolean("k5",false);
        bK6=prefs.getBoolean("k6",false);

        MostrarOcultarFranja(bmostra,mostrador);
        MostrarOcultarFranja(bautmac,auto);
        MostrarOcultarFranja(bmcentrega,mcEntrega);
        MostrarOcultarFranja(bmcaafe,mcCafe);
        MostrarOcultarFranja(bIsla,isla);
        MostrarOcultarFranja(bK1,k1);
        MostrarOcultarFranja(bK2,k2);
        MostrarOcultarFranja(bK3,k3);
        MostrarOcultarFranja(bK4,k4);
        MostrarOcultarFranja(bK5,k5);
        MostrarOcultarFranja(bK6,k6);

        MostrarOcultarFranja(bmostra,mostrador2);
        MostrarOcultarFranja(bautmac,auto2);
        MostrarOcultarFranja(bmcentrega,mcEntrega2);
        MostrarOcultarFranja(bmcaafe,mcCafe2);
        MostrarOcultarFranja(bIsla,isla2);
        MostrarOcultarFranja(bK1,k12);
        MostrarOcultarFranja(bK2,k22);
        MostrarOcultarFranja(bK3,k32);
        MostrarOcultarFranja(bK4,k42);
        MostrarOcultarFranja(bK5,k52);
        MostrarOcultarFranja(bK6,k62);

    }

    private void MostrarOcultarFranja(boolean segmento, TableRow row){
        if(segmento){
            row.setVisibility(View.VISIBLE);
        }
        else
        {
            row.setVisibility(View.GONE);
        }
    }

    public void Inicializacion(View v){
        mostrador=v.findViewById(R.id.rowMostra);
        proMostra=v.findViewById(R.id.tvProMostra);
        realMostra=v.findViewById(R.id.tvrealMostra);
        difMostra=v.findViewById(R.id.tvDifMostra);
        auto=v.findViewById(R.id.rowAuto);
        proAuto=v.findViewById(R.id.tvProAuto);
        realAuto=v.findViewById(R.id.tvRealAuto);
        difAuto=v.findViewById(R.id.tvDifAuto);
        mcEntrega=v.findViewById(R.id.rowMcEn);
        proMcEn=v.findViewById(R.id.tvProMcEn);
        realMcEn=v.findViewById(R.id.tvRealMcEn);
        difMcEn=v.findViewById(R.id.tvDifMcEn);
        mcCafe=v.findViewById(R.id.rowMcCa);
        proMcCa=v.findViewById(R.id.tvProMcCa);
        realMcCa=v.findViewById(R.id.tvRealMcCa);
        difMcCa=v.findViewById(R.id.tvDifMcCa);
        isla=v.findViewById(R.id.rowIsla);
        proIsla=v.findViewById(R.id.tvProIsla);
        realIsla=v.findViewById(R.id.tvRealIsla);
        difIsla=v.findViewById(R.id.tvDifIsla);
        k1=v.findViewById(R.id.rowK1);
        proK1=v.findViewById(R.id.tvProK1);
        realK1=v.findViewById(R.id.tvRealK1);
        difK1=v.findViewById(R.id.tvDifK1);
        k2=v.findViewById(R.id.rowK2);
        proK2=v.findViewById(R.id.tvProK2);
        realK2=v.findViewById(R.id.tvRealK2);
        difK2=v.findViewById(R.id.tvDifK2);
        k3=v.findViewById(R.id.rowk3);
        proK3=v.findViewById(R.id.tvProK3);
        realK3=v.findViewById(R.id.tvRealK3);
        difK3=v.findViewById(R.id.tvDifK3);
        k4=v.findViewById(R.id.rowK4);
        proK4=v.findViewById(R.id.tvProK4);
        realK4=v.findViewById(R.id.tvRealK4);
        difK4=v.findViewById(R.id.tvDifK4);
        k5=v.findViewById(R.id.rowK5);
        proK5=v.findViewById(R.id.tvProK5);
        realK5=v.findViewById(R.id.tvRealK5);
        difK5=v.findViewById(R.id.tvDifK5);
        k6=v.findViewById(R.id.rowK6);
        proK6=v.findViewById(R.id.tvProK6);
        realK6=v.findViewById(R.id.tvRealK6);
        difK6=v.findViewById(R.id.tvDifK6);
        mostrador2=v.findViewById(R.id.rowMostra2);
        proMostra2=v.findViewById(R.id.tvProMostra2);
        realMostra2=v.findViewById(R.id.tvrealMostra2);
        difMostra2=v.findViewById(R.id.tvDifMostra2);
        auto2=v.findViewById(R.id.rowAuto2);
        proAuto2=v.findViewById(R.id.tvProAuto2);
        realAuto2=v.findViewById(R.id.tvRealAuto2);
        difAuto2=v.findViewById(R.id.tvDifAuto2);
        mcEntrega2=v.findViewById(R.id.rowMcEn2);
        proMcEn2=v.findViewById(R.id.tvProMcEn2);
        realMcEn2=v.findViewById(R.id.tvRealMcEn2);
        difMcEn2=v.findViewById(R.id.tvDifMcEn2);
        mcCafe2=v.findViewById(R.id.rowMcCa2);
        proMcCa2=v.findViewById(R.id.tvProMcCa2);
        realMcCa2=v.findViewById(R.id.tvRealMcCa2);
        difMcCa2=v.findViewById(R.id.tvDifMcCa2);
        isla2=v.findViewById(R.id.rowIsla2);
        proIsla2=v.findViewById(R.id.tvProIsla2);
        realIsla2=v.findViewById(R.id.tvRealIsla2);
        difIsla2=v.findViewById(R.id.tvDifIsla2);
        k12=v.findViewById(R.id.rowK12);
        proK12=v.findViewById(R.id.tvProK12);
        realK12=v.findViewById(R.id.tvRealK12);
        difK12=v.findViewById(R.id.tvDifK12);
        k22=v.findViewById(R.id.rowK22);
        proK22=v.findViewById(R.id.tvProK22);
        realK22=v.findViewById(R.id.tvRealK22);
        difK22=v.findViewById(R.id.tvDifK22);
        k32=v.findViewById(R.id.rowk32);
        proK32=v.findViewById(R.id.tvProK32);
        realK32=v.findViewById(R.id.tvRealK32);
        difK32=v.findViewById(R.id.tvDifK32);
        k42=v.findViewById(R.id.rowK42);
        proK42=v.findViewById(R.id.tvProK42);
        realK42=v.findViewById(R.id.tvRealK42);
        difK42=v.findViewById(R.id.tvDifK42);
        k52=v.findViewById(R.id.rowK52);
        proK52=v.findViewById(R.id.tvProK52);
        realK52=v.findViewById(R.id.tvRealK52);
        difK52=v.findViewById(R.id.tvDifK52);
        k62=v.findViewById(R.id.rowK62);
        proK62=v.findViewById(R.id.tvProK62);
        realK62=v.findViewById(R.id.tvRealK62);
        difK62=v.findViewById(R.id.tvDifK62);

    }

}
