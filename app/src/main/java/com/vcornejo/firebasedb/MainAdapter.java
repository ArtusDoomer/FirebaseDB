package com.vcornejo.firebasedb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel>options){
        super(options);
    }
        protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model){
        holder.Nombre.setText(model.getNombre());
        holder.Marca.setText(model.getMarca());
        holder.Precio.setText(model.getPrecio());

        Glide.with(holder.Imagen.getContext())
                .load(model.getImagen())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.Imagen);

        holder.Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.Imagen.getContext())
                        .setContentHolder(new ViewHolder(R.layout.ventana_emergente))
                        .setExpanded(true,1200)
                        .create();

                View view = dialogPlus.getHolderView();
                EditText Nombre = view.findViewById(R.id.nombreText);
                EditText Marca = view.findViewById(R.id.marcaText);
                EditText Precio = view.findViewById(R.id.precioText);
                EditText Imagen = view.findViewById(R.id.imagenText);

                Button actualizar = view.findViewById(R.id.btn_actualizar);

                Nombre.setText(model.getNombre());
                Marca.setText(model.getMarca());
                Precio.setText(model.getPrecio());
                Imagen.setText(model.getImagen());

                dialogPlus.show();

            }
        });
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
       CircleImageView Imagen;
       TextView Nombre, Marca, Precio;
       Button Editar, Eliminar;

       public myViewHolder(@NonNull View itemView){
           super(itemView);

           Imagen = itemView.findViewById(R.id.img1);
           Nombre = itemView.findViewById(R.id.nombreText);
           Marca = itemView.findViewById(R.id.marcaText);
           Precio = itemView.findViewById(R.id.precioText);

           Editar = itemView.findViewById(R.id.btn_edit);
           Eliminar = itemView.findViewById(R.id.btn_eliminar);
       }
    }
}
