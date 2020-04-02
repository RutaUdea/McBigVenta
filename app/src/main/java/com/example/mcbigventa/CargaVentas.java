package com.example.mcbigventa;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class CargaVentas extends Fragment {

    private TableLayout tablaMostador;
    private TableLayout tablaAutomac;
    private TableLayout tablaMcEntrega;
    private TableLayout tablaMcCafe;
    private TableRow rowDesaMostr;
    private TableRow rowExtMostr;
    private TableRow rowDesaAuto;
    private TableRow rowExtAuto;
    private TableRow rowDesaMcEn;
    private TableRow rowExtMcEn;
    private TableRow rowDesaMcCa;
    private TextView proMostra;
    private TextView proMcEntre;
    private TextView proAuto;
    private TextView proMcCafe;
    private TextView ProMostDesy;
    private TextView ProMostAlmu;
    private TextView ProMostTard;
    private TextView ProMostCena;
    private TextView ProMostExt;
    private TextView ProAutoDesy;
    private TextView ProAutoAlmu;
    private TextView ProAutoTard;
    private TextView ProAutoCena;
    private TextView ProAutoExt;
    private TextView ProMcEnDesy;
    private TextView ProMcEnAlmu;
    private TextView ProMcEnTard;
    private TextView ProMcEnCena;
    private TextView ProMcEnExt;
    private TextView ProMcCaDesy;
    private TextView ProMcCaAlmu;
    private TextView ProMcCaTard;
    private TextView ProMcCaCena;
    private TextView difMostDesy;
    private TextView difMostAlmu;
    private TextView difMostTard;
    private TextView difMostCena;
    private TextView difMostExt;
    private TextView difAutoDesy;
    private TextView difAutoAlmu;
    private TextView difAutoTard;
    private TextView difAutoCena;
    private TextView difAutoExt;
    private TextView difMcEnDesy;
    private TextView difMcEnAlmu;
    private TextView difMcEnTard;
    private TextView difMcEnCena;
    private TextView difMcEnExt;
    private TextView difMcCaDesy;
    private TextView difMcCaAlmu;
    private TextView difMcCaTard;
    private TextView difMcCaCena;
    private TextView difMostra;
    private TextView difAuto;
    private TextView difMcEntre;
    private TextView difMcCafe;
    private TextView realMostra;
    private TextView realAuto;
    private TextView realMcEntre;
    private TextView realMcCafe;
    private Button realMostDes;
    private Button realMostAlmu;
    private Button realMostTard;
    private Button realMostCena;
    private Button realMostExt;
    private Button realAutoDes;
    private Button realAutoAlmu;
    private Button realAutoTard;
    private Button realAutoCena;
    private Button realAutoExt;
    private Button realMcEnDes;
    private Button realMcEnAlmu;
    private Button realMcEnTard;
    private Button realMcEnCena;
    private Button realMcEnExt;
    private Button realMcCafeDes;
    private Button realMcCaAlmu;
    private Button realMcCaTard;
    private Button realMcCaCena;
    private EditText ventasDia;
    private TextView RealVentasDia;
    private TextView difVentasDia;
    private TextView diaActual;
    private Button btnGuardarDatos;
    private Button btnCerrarDia;
    private FloatingActionButton btnCompartir;
    private LinearLayout vista;

    private int Dia=1;
    private float PMostrador;
    private float PAutomac;
    private float PMcEntrega;
    private float PMcCafe;
    private float PDesaMcCa,PDesaMostra,PDesaAuto,PDesaMcEn;
    private float PAlmMostra,PAlmAuto,PAlmMcEn,PAlmMcCa;
    private float PTardeMostra,PTardeAuto,PTardeMcEn,PTardeMcCa;
    private float PCenaMostra,PCenaAuto,PCenaMcEn,PCenaMcCa;
    private float PExtendMostra,PExtendAuto,PExtendMcEn;

    private boolean mostrador,autmac,mcentrega, postres, mcaafe, desayunos, extend;

    FirebaseDatabase baseDatos;
    DatabaseReference bdReferencia;
    VentasDB ventasSegDia;
    CompaDB ventasCierre;
    SharedPreferences prefs;


    public CargaVentas() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v1=inflater.inflate(R.layout.fragment_carga_ventas, container, false);
        inicializacion(v1);
        CargarConfiguracion();
        baseDatos=FirebaseDatabase.getInstance();
        bdReferencia=baseDatos.getReference();
        CargarDatos();

        btnGuardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GurdarDatos();
            }
        });

        entrarVentasM(realMostDes,"Desayunos");
        entrarVentasM(realMostAlmu,"Almuerzo");
        entrarVentasM(realMostTard,"Tarde");
        entrarVentasM(realMostCena,"Cena");
        entrarVentasM(realMostExt,"Extend");

        entrarVentas(realAutoDes, realAutoDes,realAutoAlmu,realAutoTard,realAutoCena,realAutoExt,"AutoMac - Desayunos");
        entrarVentas(realAutoAlmu, realAutoDes,realAutoAlmu,realAutoTard,realAutoCena,realAutoExt,"AutoMac - Almuerzo");
        entrarVentas(realAutoTard, realAutoDes,realAutoAlmu,realAutoTard,realAutoCena,realAutoExt,"AutoMac - Tarde");
        entrarVentas(realAutoCena, realAutoDes,realAutoAlmu,realAutoTard,realAutoCena,realAutoExt,"AutoMac - Cena");
        entrarVentas(realAutoExt, realAutoDes,realAutoAlmu,realAutoTard,realAutoCena,realAutoExt,"AutoMac - Extend");

        entrarVentas(realMcEnDes, realMcEnDes,realMcEnAlmu,realMcEnTard,realMcEnCena,realMcEnExt,"Mcentrega - Desayunos");
        entrarVentas(realMcEnAlmu, realMcEnDes,realMcEnAlmu,realMcEnTard,realMcEnCena,realMcEnExt,"Mcentrega - Almuerzo");
        entrarVentas(realMcEnTard, realMcEnDes,realMcEnAlmu,realMcEnTard,realMcEnCena,realMcEnExt,"Mcentrega - Tarde");
        entrarVentas(realMcEnCena, realMcEnDes,realMcEnAlmu,realMcEnTard,realMcEnCena,realMcEnExt,"Mcentrega - Cena");
        entrarVentas(realMcEnExt, realMcEnDes,realMcEnAlmu,realMcEnTard,realMcEnCena,realMcEnExt,"Mcentrega - Extend");

        entrarVentas(realMcCafeDes, realMcCafeDes,realMcCaAlmu,realMcCaTard,realMcCaCena,realMcCafeDes,"McCafe - Desayunos");
        entrarVentas(realMcCaAlmu, realMcCafeDes,realMcCaAlmu,realMcCaTard,realMcCaCena,realMcCaAlmu,"McCafe - Almuerzo");
        entrarVentas(realMcCaTard, realMcCafeDes,realMcCaAlmu,realMcCaTard,realMcCaCena,realMcCaTard,"McCafe - Tarde");
        entrarVentas(realMcCaCena, realMcCafeDes,realMcCaAlmu,realMcCaTard,realMcCaCena,realMcCaCena,"McCafe - Cena");

        ventasDia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double ventas=0;
                float ventasMostra=0;
                float ventasAuto=0;
                float ventasMcEn=0;
                float ventasMcCa=0;
                if(s.toString().equals("")){
                    ventas=0;
                }else{
                    ventas=getFloatFrom(ventasDia);
                }
                proMostra.setText(String.format("%.2f",(ventas*PMostrador)));
                if(proMostra.getText().toString().equals("")){
                    ventasMostra=0;
                }else{
                    ventasMostra=getFloatFrom(proMostra);
                }
                proAuto.setText(String.format("%.2f",(ventas*PAutomac)));
                if(proAuto.getText().toString().equals("")){
                    ventasAuto=0;
                }else{
                    ventasAuto=getFloatFrom(proAuto);
                }
                proMcEntre.setText(String.format("%.2f",(ventas*PMcEntrega)));
                if(proMcEntre.getText().toString().equals("")){
                    ventasMcEn=0;
                }else{
                    ventasMcEn=getFloatFrom(proMcEntre);
                }
                proMcCafe.setText(String.format("%.2f",(ventas*PMcCafe)));
                if(proMcCafe.getText().toString().equals("")){
                    ventasMcCa=0;
                }else{
                    ventasMcCa=getFloatFrom(proMcCafe);
                }

                ProMostDesy.setText(String.format("%.2f",(ventasMostra*PDesaMostra)));
                ProMostAlmu.setText(String.format("%.2f",(ventasMostra*PAlmMostra)));
                ProMostTard.setText(String.format("%.2f",(ventasMostra*PTardeMostra)));
                ProMostCena.setText(String.format("%.2f",(ventasMostra*PCenaMostra)));
                ProMostExt.setText(String.format("%.2f",(ventasMostra*PExtendMostra)));

                ProAutoDesy.setText(String.format("%.2f",(ventasAuto*PDesaAuto)));
                ProAutoAlmu.setText(String.format("%.2f",(ventasAuto*PAlmAuto)));
                ProAutoTard.setText(String.format("%.2f",(ventasAuto*PTardeAuto)));
                ProAutoCena.setText(String.format("%.2f",(ventasAuto*PCenaAuto)));
                ProAutoExt.setText(String.format("%.2f",(ventasAuto*PExtendAuto)));

                ProMcEnDesy.setText(String.format("%.2f",(ventasMcEn*PDesaMcEn)));
                ProMcEnAlmu.setText(String.format("%.2f",(ventasMcEn*PAlmMcEn)));
                ProMcEnTard.setText(String.format("%.2f",(ventasMcEn*PTardeMcEn)));
                ProMcEnCena.setText(String.format("%.2f",(ventasMcEn*PCenaMcEn)));
                ProMcEnExt.setText(String.format("%.2f",(ventasMcEn*PExtendMcEn)));

                ProMcCaDesy.setText(String.format("%.2f",(ventasMcCa*PDesaMcCa)));
                ProMcCaAlmu.setText(String.format("%.2f",(ventasMcCa*PAlmMcCa)));
                ProMcCaTard.setText(String.format("%.2f",(ventasMcCa*PTardeMcCa)));
                ProMcCaCena.setText(String.format("%.2f",(ventasMcCa*PCenaMcCa)));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        CalculoDiferencia(realMostDes,difMostDesy,ProMostDesy);
        CalculoDiferencia(realMostAlmu,difMostAlmu,ProMostAlmu);
        CalculoDiferencia(realMostTard,difMostTard,ProMostTard);
        CalculoDiferencia(realMostCena,difMostCena,ProMostCena);
        CalculoDiferencia(realMostExt,difMostExt,ProMostExt);

        CalculoDiferencia(realAutoDes,difAutoDesy,ProAutoDesy);
        CalculoDiferencia(realAutoAlmu,difAutoAlmu,ProAutoAlmu);
        CalculoDiferencia(realAutoTard,difAutoTard,ProAutoTard);
        CalculoDiferencia(realAutoCena,difAutoCena,ProAutoCena);
        CalculoDiferencia(realAutoExt,difAutoExt,ProAutoExt);

        CalculoDiferencia(realMcEnDes,difMcEnDesy,ProMcEnDesy);
        CalculoDiferencia(realMcEnAlmu,difMcEnAlmu,ProMcEnAlmu);
        CalculoDiferencia(realMcEnTard,difMcEnTard,ProMcEnTard);
        CalculoDiferencia(realMcEnCena,difMcEnCena,ProMcEnCena);
        CalculoDiferencia(realMcEnExt,difMcEnExt,ProMcEnExt);

        CalculoDiferencia(realMcCafeDes,difMcCaDesy,ProMcCaDesy);
        CalculoDiferencia(realMcCaAlmu,difMcCaAlmu,ProMcCaAlmu);
        CalculoDiferencia(realMcCaTard,difMcCaTard,ProMcCaTard);
        CalculoDiferencia(realMcCaCena,difMcCaCena,ProMcCaCena);

        btnCerrarDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CerrarDia();
            }
        });

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBitMap(getContext(),vista);
            }
        });

        return v1;
    }

    private void entrarVentasM(final Button real, final String banda){
        real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.dialogo_mostrador);
                dialog.setTitle("Ventas Mostrador");
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                final EditText pos1=dialog.findViewById(R.id.VentasPos1);
                final EditText pos2=dialog.findViewById(R.id.VentasPos2);
                final EditText pos3=dialog.findViewById(R.id.VentasPos3);
                TextView titulo=dialog.findViewById(R.id.tituloM);
                titulo.setText("Ventas Mostrador - "+banda);
                Button guardar=dialog.findViewById(R.id.btnGuardarVentas);
                Button cancelar=dialog.findViewById(R.id.btnCerrarDialogo);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        real.setText("0");
                        int ventas=ObtenerEntero(pos1)+ObtenerEntero(pos2)+ObtenerEntero(pos3);
                        ventas=ventas-Integer.parseInt(realMostDes.getText().toString())-Integer.parseInt(realMostAlmu.getText().toString())-Integer.parseInt(realMostTard.getText().toString())-Integer.parseInt(realMostCena.getText().toString())-Integer.parseInt(realMostExt.getText().toString());
                        real.setText(String.valueOf(ventas));
                        dialog.dismiss();
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void entrarVentas(final Button real, final Button realD, final Button realA, final Button realT, final Button realC, final Button realE, final String banda){
        real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.dialogo_seg);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                final EditText pos1=dialog.findViewById(R.id.VentasPos);
                TextView titulo=dialog.findViewById(R.id.tituloM);
                titulo.setText("Ventas "+banda);
                Button guardar=dialog.findViewById(R.id.btnGuardarVentas);
                Button cancelar=dialog.findViewById(R.id.btnCerrarDialogo);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        real.setText("0");
                        int ventas=ObtenerEntero(pos1);
                        ventas=ventas-Integer.parseInt(realD.getText().toString())-Integer.parseInt(realA.getText().toString())-Integer.parseInt(realT.getText().toString())-Integer.parseInt(realC.getText().toString())-Integer.parseInt(realE.getText().toString());
                        real.setText(String.valueOf(ventas));
                        dialog.dismiss();
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private int ObtenerEntero(EditText obj){
        int ent=0;
        if(obj.getText().toString().isEmpty()){
            return ent;
        }else{
            ent=Integer.parseInt(obj.getText().toString());
            return ent;
        }
    }

    private void CerrarDia(){
        final String mostra,auto,mcEn,mcCa,gcs;
        prefs=this.getActivity().getSharedPreferences("Configuracion", Context.MODE_PRIVATE);
        mostra=prefs.getString("GcsMostra","0");
        auto=prefs.getString("GcsAuto","0");
        mcEn=prefs.getString("GcsMcEn","0");
        mcCa=prefs.getString("GcsMcCa","0");
        gcs=prefs.getString("GcsTotal","0");
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
        dialogo1.setTitle("Cierre de Dia");
        dialogo1.setMessage("¿ Desea Cerrar el dia "+Dia+" con total Ventas:"+RealVentasDia.getText()+" y Gc's Totales: "+gcs+"?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                String dia=diaActual.getText().toString();
                ventasCierre= new CompaDB(realMostra.getText().toString(),mostra);
                bdReferencia.child("POB").child("Comparables").child("Mostrador").child(dia).setValue(ventasCierre);
                ventasCierre= new CompaDB(realAuto.getText().toString(),auto);
                bdReferencia.child("POB").child("Comparables").child("Auto").child(dia).setValue(ventasCierre);
                ventasCierre= new CompaDB(realMcEntre.getText().toString(),mcEn);
                bdReferencia.child("POB").child("Comparables").child("McEntrega").child(dia).setValue(ventasCierre);
                ventasCierre= new CompaDB(realMcCafe.getText().toString(),mcCa);
                bdReferencia.child("POB").child("Comparables").child("McCafe").child(dia).setValue(ventasCierre);
                int dian=Integer.valueOf(dia)+1;
                ventasSegDia=new VentasDB(String.valueOf(dian),"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
                bdReferencia.child("POB").child("VentasDia").setValue(ventasSegDia);
                bdReferencia.child("POB").child("GcsDia").setValue(ventasSegDia);
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();

    }

    private void saveBitMap(Context context, View drawView){
        File pictureFileDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Handcare");
        if (!pictureFileDir.exists()) {
            boolean isDirectoryCreated = pictureFileDir.mkdirs();
            if(!isDirectoryCreated)
                Log.i("ATG", "Can't create directory to save the image");
        }
        String filename = pictureFileDir.getPath() +File.separator+ "Imagen.jpg";
        File pictureFile = new File(filename);
        Bitmap bitmap =getBitmapFromView(drawView);
        try {
            pictureFile.createNewFile();
            FileOutputStream oStream = new FileOutputStream(pictureFile,false);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, oStream);
            oStream.flush();
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("TAG", "There was an issue saving the image.");
        }

        Uri uriF = Uri.parse(filename);

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uriF);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(shareIntent, "send"));
    }

    private Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            bgDrawable.draw(canvas);
        }   else{
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;
    }


    private void GurdarDatos(){
        View view = getActivity().findViewById(R.id.container);
        ventasSegDia=new VentasDB(diaActual.getText().toString(),ventasDia.getText().toString(),
                realMostDes.getText().toString(),
                realMostAlmu.getText().toString(),
                realMostTard.getText().toString(),
                realMostCena.getText().toString(),
                realMostExt.getText().toString(),
                realAutoDes.getText().toString(),
                realAutoAlmu.getText().toString(),
                realAutoTard.getText().toString(),
                realAutoCena.getText().toString(),
                realAutoExt.getText().toString(),
                realMcEnDes.getText().toString(),
                realMcEnAlmu.getText().toString(),
                realMcEnTard.getText().toString(),
                realMcEnCena.getText().toString(),
                realMcEnExt.getText().toString(),
                realMcCafeDes.getText().toString(),
                realMcCaAlmu.getText().toString(),
                realMcCaTard.getText().toString(),
                realMcCaCena.getText().toString());
        bdReferencia.child("POB").child("VentasDia").setValue(ventasSegDia);
        Snackbar.make(view,"Ventas Guardas con Exito",Snackbar.LENGTH_SHORT).show();
    }

    private void CargarDatos(){

        bdReferencia.child("POB").child("VentasDia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                diaActual.setText(dataSnapshot.child("dia").getValue(String.class));

                ventasDia.setText(dataSnapshot.child("proVentasDia").getValue(String.class));

                realMostDes.setText(dataSnapshot.child("realMostraDes").getValue(String.class));
                realMostAlmu.setText(dataSnapshot.child("realMostraAlm").getValue(String.class));
                realMostTard.setText(dataSnapshot.child("realMostraTard").getValue(String.class));
                realMostCena.setText(dataSnapshot.child("realMostraCena").getValue(String.class));
                realMostExt.setText(dataSnapshot.child("realMostraExt").getValue(String.class));

                realAutoDes.setText(dataSnapshot.child("realAutoDes").getValue(String.class));
                realAutoAlmu.setText(dataSnapshot.child("realAutoAlm").getValue(String.class));
                realAutoTard.setText(dataSnapshot.child("realAutoTard").getValue(String.class));
                realAutoCena.setText(dataSnapshot.child("realAutoCena").getValue(String.class));
                realAutoExt.setText(dataSnapshot.child("realAutoaExt").getValue(String.class));

                realMcEnDes.setText(dataSnapshot.child("realMcEnDes").getValue(String.class));
                realMcEnAlmu.setText(dataSnapshot.child("realMcEnAlm").getValue(String.class));
                realMcEnTard.setText(dataSnapshot.child("realMcEnTard").getValue(String.class));
                realMcEnCena.setText(dataSnapshot.child("realMcEnCena").getValue(String.class));
                realMcEnExt.setText(dataSnapshot.child("realMcEnExt").getValue(String.class));

                realMcCafeDes.setText(dataSnapshot.child("realMcCaDes").getValue(String.class));
                realMcCaAlmu.setText(dataSnapshot.child("realMcCaAlm").getValue(String.class));
                realMcCaTard.setText(dataSnapshot.child("realMcCaTard").getValue(String.class));
                realMcCaCena.setText(dataSnapshot.child("realMcCaCena").getValue(String.class));

                SumaVentas();

                CalculoDiferenciaT(realMostDes,difMostDesy,ProMostDesy);
                CalculoDiferenciaT(realMostAlmu,difMostAlmu,ProMostAlmu);
                CalculoDiferenciaT(realMostTard,difMostTard,ProMostTard);
                CalculoDiferenciaT(realMostCena,difMostCena,ProMostCena);
                CalculoDiferenciaT(realMostExt,difMostExt,ProMostExt);

                CalculoDiferenciaT(realAutoDes,difAutoDesy,ProAutoDesy);
                CalculoDiferenciaT(realAutoAlmu,difAutoAlmu,ProAutoAlmu);
                CalculoDiferenciaT(realAutoTard,difAutoTard,ProAutoTard);
                CalculoDiferenciaT(realAutoCena,difAutoCena,ProAutoCena);
                CalculoDiferenciaT(realAutoExt,difAutoExt,ProAutoExt);

                CalculoDiferenciaT(realMcEnDes,difMcEnDesy,ProMcEnDesy);
                CalculoDiferenciaT(realMcEnAlmu,difMcEnAlmu,ProMcEnAlmu);
                CalculoDiferenciaT(realMcEnTard,difMcEnTard,ProMcEnTard);
                CalculoDiferenciaT(realMcEnCena,difMcEnCena,ProMcEnCena);
                CalculoDiferenciaT(realMcEnExt,difMcEnExt,ProMcEnExt);


                CalculoDiferenciaT(realMcCafeDes,difMcCaDesy,ProMcCaDesy);
                CalculoDiferenciaT(realMcCaAlmu,difMcCaAlmu,ProMcCaAlmu);
                CalculoDiferenciaT(realMcCaTard,difMcCaTard,ProMcCaTard);
                CalculoDiferenciaT(realMcCaCena,difMcCaCena,ProMcCaCena);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    float getFloatFrom(TextView txt) {
        try {
            return NumberFormat.getInstance(new Locale("en", "US")).parse(txt.getText().toString()).floatValue();
        } catch (ParseException e) {
            return 0.0f;
        }
    }

    private void CalculoDiferenciaT(TextView real, final TextView dif, final TextView pro){
        float venta=0;
        float proVenta=0;
        if(real.getText().toString().isEmpty()){
            venta=0;
        }else {
            venta=getFloatFrom(real);
        }
        proVenta=getFloatFrom(pro);
        venta=(1-(proVenta-venta)/proVenta)*100;
        dif.setText(String.format("%.2f",(venta)));
        Colorear(dif,venta);
    }


    private void CalculoDiferencia(final Button real, final TextView dif, final TextView pro){
        real.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float venta=0;
                float proVenta=0;
                if(s.toString().isEmpty()){
                    venta=1;
                }else{
                    venta=getFloatFrom(real);
                }
                proVenta=getFloatFrom(pro);
                venta=(1-(proVenta-venta)/proVenta)*100;
                dif.setText(String.format("%.2f",(venta)));
                Colorear(dif,venta);
                SumaVentas();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void SumaVentas(){
        int ventaMost=0;
        int ventaAuto=0;
        int ventaMcEn=0;
        int ventaPost=0;
        int ventaMcCa=0;
        int ventaDia=0;
        if(!(realMostDes.getText().toString().isEmpty() || realMostAlmu.getText().toString().equals("") || realMostTard.getText().toString().equals("") || realMostCena.getText().toString().equals("") || realMostExt.getText().toString().equals("")
                || realAutoDes.getText().toString().equals("") || realAutoAlmu.getText().toString().equals("") || realAutoTard.getText().toString().equals("") || realAutoCena.getText().toString().equals("") || realAutoExt.getText().toString().equals("")
                || realMcEnDes.getText().toString().equals("") || realMcEnAlmu.getText().toString().equals("") || realMcEnTard.getText().toString().equals("") || realMcEnCena.getText().toString().equals("") || realMcEnExt.getText().toString().equals("")
                || realMcCafeDes.getText().toString().equals("") || realMcCaAlmu.getText().toString().equals("") || realMcCaTard.getText().toString().equals("") || realMcCaCena.getText().toString().equals(""))){

            ventaMost=Integer.parseInt(realMostDes.getText().toString())+Integer.parseInt(realMostAlmu.getText().toString())+Integer.parseInt(realMostTard.getText().toString())+Integer.parseInt(realMostCena.getText().toString())+Integer.parseInt(realMostExt.getText().toString());
            ventaAuto=Integer.parseInt(realAutoDes.getText().toString())+Integer.parseInt(realAutoAlmu.getText().toString())+Integer.parseInt(realAutoTard.getText().toString())+Integer.parseInt(realAutoCena.getText().toString())+Integer.parseInt(realAutoExt.getText().toString());
            ventaMcEn=Integer.parseInt(realMcEnDes.getText().toString())+Integer.parseInt(realMcEnAlmu.getText().toString())+Integer.parseInt(realMcEnTard.getText().toString())+Integer.parseInt(realMcEnCena.getText().toString())+Integer.parseInt(realMcEnExt.getText().toString());
            ventaMcCa=Integer.parseInt(realMcCafeDes.getText().toString())+Integer.parseInt(realMcCaAlmu.getText().toString())+Integer.parseInt(realMcCaTard.getText().toString())+Integer.parseInt(realMcCaCena.getText().toString());
            ventaDia=ventaMost+ventaAuto+ventaPost+ventaMcEn+ventaMcCa;
        }
        realMostra.setText(Integer.toString(ventaMost));
        CalculoDiferenciaT(realMostra,difMostra,proMostra);
        realAuto.setText(Integer.toString((ventaAuto)));
        CalculoDiferenciaT(realAuto,difAuto,proAuto);
        realMcEntre.setText(Integer.toString((ventaMcEn)));
        CalculoDiferenciaT(realMcEntre,difMcEntre,proMcEntre);
        realMcCafe.setText(Integer.toString((ventaMcCa)));
        CalculoDiferenciaT(realMcCafe,difMcCafe,proMcCafe);
        RealVentasDia.setText(Integer.toString((ventaDia)));
        CalculoDiferenciaT(RealVentasDia,difVentasDia,ventasDia);
    }

    private void Colorear(TextView editText, Float venta){
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
        mostrador=prefs.getBoolean("Mostrador",true);
        autmac=prefs.getBoolean("Automac",false);
        postres=prefs.getBoolean("Postres",false);
        mcentrega=prefs.getBoolean("McEntrega",false);
        mcaafe=prefs.getBoolean("McCafe",false);
        desayunos=prefs.getBoolean("Desayunos",false);
        extend=prefs.getBoolean("Extend",false);
        PMostrador=prefs.getFloat("PMostrador",0)/100;
        PAutomac=prefs.getFloat("PAutomac",0)/100;
        PMcEntrega=prefs.getFloat("PMcEntrega",0)/100;
        PMcCafe=prefs.getFloat("PMcCafe",0)/100;
        PDesaMcCa=prefs.getFloat("PDesaMcCa",0)/100;
        PDesaMostra=prefs.getFloat("PDesaMostra",0)/100;
        PDesaAuto=prefs.getFloat("PDesaAuto",0)/100;
        PDesaMcEn=prefs.getFloat("PDesaMcEn",0)/100;
        PAlmMostra=prefs.getFloat("PAlmMostra",0)/100;
        PAlmAuto=prefs.getFloat("PAlmAuto",0)/100;
        PAlmMcEn=prefs.getFloat("PAlmMcEn",0)/100;
        PAlmMcCa=prefs.getFloat("PAlmMcCa",0)/100;
        PTardeMostra=prefs.getFloat("PTardeMostra",0)/100;
        PTardeAuto=prefs.getFloat("PTardeAuto",0)/100;
        PTardeMcEn=prefs.getFloat("PTardeMcEn",0)/100;
        PTardeMcCa=prefs.getFloat("PTardeMcCa",0)/100;
        PCenaMostra=prefs.getFloat("PCenaMostra",0)/100;
        PCenaAuto=prefs.getFloat("PCenaAuto",0)/100;
        PCenaMcEn=prefs.getFloat("PCenaMcEn",0)/100;
        PCenaMcCa=prefs.getFloat("PCenaMcCa",0)/100;

        PExtendMostra=prefs.getFloat("PExtendMostra",0)/100;
        PExtendAuto=prefs.getFloat("PExtendAuto",0)/100;
        PExtendMcEn=prefs.getFloat("PExtendMcEn",0)/100;

        MostrarOcultarTabla(mostrador,tablaMostador);
        MostrarOcultarTabla(autmac,tablaAutomac);
        MostrarOcultarTabla(mcentrega,tablaMcEntrega);
        MostrarOcultarTabla(mcaafe,tablaMcCafe);
        MostrarOcultarFranja(desayunos,rowDesaMostr);
        MostrarOcultarFranja(desayunos,rowDesaAuto);
        MostrarOcultarFranja(desayunos,rowDesaMcCa);
        MostrarOcultarFranja(desayunos,rowDesaMcEn);

        MostrarOcultarFranja(extend,rowExtMostr);
        MostrarOcultarFranja(extend,rowExtAuto);
        MostrarOcultarFranja(extend,rowExtMcEn);
    }

    private void MostrarOcultarTabla(boolean segmento,TableLayout tabla){
        if(segmento){
            tabla.setVisibility(View.VISIBLE);
        }
        else
        {
            tabla.setVisibility(View.GONE);
        }
    }

    private void MostrarOcultarFranja(boolean segmento,TableRow franja){
        if(segmento){
            franja.setVisibility(View.VISIBLE);
        }
        else
        {
            franja.setVisibility(View.GONE);
        }
    }

    private void inicializacion(View v) {
        tablaMostador = v.findViewById(R.id.TablaMostrador);
        tablaAutomac = v.findViewById(R.id.TablaAutomac);
        tablaMcEntrega = v.findViewById(R.id.TablaMcEntrega);
        tablaMcCafe = v.findViewById(R.id.TablaMcCafe);
        rowDesaMostr = v.findViewById(R.id.rowDesayMost);
        rowExtMostr = v.findViewById(R.id.rowExtMost);
        rowDesaAuto = v.findViewById(R.id.rowDesayAuto);
        rowExtAuto = v.findViewById(R.id.rowExtAuto);
        rowDesaMcEn = v.findViewById(R.id.rowDesayMcEn);
        rowExtMcEn = v.findViewById(R.id.rowExtMcEn);
        rowDesaMcCa = v.findViewById(R.id.rowDesayMcCa);
        ProMostDesy = v.findViewById(R.id.tvProMostDesa);
        ProMostAlmu = v.findViewById(R.id.tvProAlmMost);
        ProMostTard = v.findViewById(R.id.tvProTardMost);
        ProMostCena = v.findViewById(R.id.tvPRoCenMostr);
        ProMostExt = v.findViewById(R.id.tvProExtMostr);
        ProAutoDesy = v.findViewById(R.id.tvProAutoDesa);
        ProAutoAlmu = v.findViewById(R.id.tvProAlmAuto);
        ProAutoTard = v.findViewById(R.id.tvProTardAuto);
        ProAutoCena = v.findViewById(R.id.tvPRoCenAuto);
        ProAutoExt = v.findViewById(R.id.tvProExtAuto);
        ProMcEnDesy = v.findViewById(R.id.tvProMcEnDesa);
        ProMcEnAlmu = v.findViewById(R.id.tvProAlmMcEn);
        ProMcEnTard = v.findViewById(R.id.tvProTardMcEn);
        ProMcEnCena = v.findViewById(R.id.tvPRoCenMcEn);
        ProMcEnExt = v.findViewById(R.id.tvProExtMcEn);
        ProMcCaDesy = v.findViewById(R.id.tvProMcCaDesa);
        ProMcCaAlmu = v.findViewById(R.id.tvProAlmMcCa);
        ProMcCaTard = v.findViewById(R.id.tvProTardMcCa);
        ProMcCaCena = v.findViewById(R.id.tvPRoCenMcCa);
        difMostDesy = v.findViewById(R.id.tvDifMostDes);
        difMostAlmu = v.findViewById(R.id.tvDifMostAlm);
        difMostTard = v.findViewById(R.id.tvDifMostTard);
        difMostCena = v.findViewById(R.id.tvDifMostCen);
        difMostExt = v.findViewById(R.id.tvDifMostExt);
        difAutoDesy = v.findViewById(R.id.tvDifAutoDes);
        difAutoAlmu = v.findViewById(R.id.tvDifAutoAlm);
        difAutoTard = v.findViewById(R.id.tvDifAutoTard);
        difAutoCena = v.findViewById(R.id.tvDifAutoCen);
        difAutoExt = v.findViewById(R.id.tvDifAutoExt);
        difMcEnDesy = v.findViewById(R.id.tvDifMcENDes);
        difMcEnAlmu = v.findViewById(R.id.tvDifMcEnAlm);
        difMcEnTard = v.findViewById(R.id.tvDifMcEnTard);
        difMcEnCena = v.findViewById(R.id.tvDifMcEnCen);
        difMcEnExt = v.findViewById(R.id.tvDifMcEnExt);
        difMcCaDesy = v.findViewById(R.id.tvDifMcCaDes);
        difMcCaAlmu = v.findViewById(R.id.tvDifMcCaAlm);
        difMcCaTard = v.findViewById(R.id.tvDifMcCaTard);
        difMcCaCena = v.findViewById(R.id.tvDifMcCaCen);
        realMostDes = v.findViewById(R.id.etRealMostDes);
        realMostAlmu = v.findViewById(R.id.etRealMostAlm);
        realMostTard = v.findViewById(R.id.etRealMostTard);
        realMostCena = v.findViewById(R.id.etRealMostCena);
        realMostExt = v.findViewById(R.id.etRealMostExt);
        realAutoDes = v.findViewById(R.id.etRealAutoDes);
        realAutoAlmu = v.findViewById(R.id.etRealAutoAlm);
        realAutoTard = v.findViewById(R.id.etRealAutoTard);
        realAutoCena = v.findViewById(R.id.etRealAutoCena);
        realAutoExt = v.findViewById(R.id.etRealAutoExt);
        realMcEnDes = v.findViewById(R.id.etRealMcEnDes);
        realMcEnAlmu = v.findViewById(R.id.etRealMcEnAlm);
        realMcEnTard = v.findViewById(R.id.etRealMcEnTard);
        realMcEnCena = v.findViewById(R.id.etRealMcEnCen);
        realMcEnExt = v.findViewById(R.id.etRealMcEnExt);
        realMcCafeDes = v.findViewById(R.id.etRealMcCaDes);
        realMcCaAlmu = v.findViewById(R.id.etRealMcCaAlm);
        realMcCaTard = v.findViewById(R.id.etRealMcCaTard);
        realMcCaCena = v.findViewById(R.id.etRealMcCaCena);
        proMostra = v.findViewById(R.id.tvVentasMostrador);
        proMcEntre = v.findViewById(R.id.tvVentasMcEntrega);
        proAuto = v.findViewById(R.id.tvVentasAutomac);
        proMcCafe = v.findViewById(R.id.tvVentasMcCafe);
        difMostra = v.findViewById(R.id.tvDifMostTotal);
        difAuto = v.findViewById(R.id.tvDifAutoTotal);
        difMcEntre = v.findViewById(R.id.tvDifMcEnTotal);
        difMcCafe = v.findViewById(R.id.tvDifMcCafeTotal);
        realMostra = v.findViewById(R.id.tvRealTotalMostr);
        realAuto = v.findViewById(R.id.tvRealTotalAuto);
        realMcEntre = v.findViewById(R.id.tvRealTotalMcEn);
        realMcCafe = v.findViewById(R.id.tvRealTotalMcCafe);
        ventasDia = v.findViewById(R.id.etProyeccionDia);
        RealVentasDia = v.findViewById(R.id.tvTotalVentasDia);
        difVentasDia = v.findViewById(R.id.tvDifTotalVentasDia);
        btnGuardarDatos = v.findViewById(R.id.btnGuardarDatos);
        btnCerrarDia = v.findViewById(R.id.btnCierreDia);
        btnCompartir= v.findViewById(R.id.btnCompartir);
        vista=v.findViewById(R.id.Vista);
        diaActual=v.findViewById(R.id.tvDiaActual);
    }

}
