package com.example.recylcerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PersonajeVo> ListPersonajes;
    RecyclerView recyclerPersonajes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        construirRecycler();


    }

    private void llenarPersonajes(){

        ListPersonajes.add(new PersonajeVo("Pikachu","Electricidad estática, cuando entra en contacto corporal con el rival, a veces lo paraliza. Pikachu evoluciona de Pichu cuando incrementa su nivel de amistad, y evoluciona en Raichu con una Piedra Trueno",R.drawable.pikachu));
        ListPersonajes.add(new PersonajeVo("Groudon"," es un Pokémon legendario de tipo tierra introducido en la tercera generación. Es la mascota de Pokémon Rubí y Pokémon Rubí Omega.",R.drawable.groudon));
        ListPersonajes.add(new PersonajeVo("Gengar","es un Pokémon de tipo fantasma/veneno introducido en la primera generación. Es la evolución de Haunter y, a partir de la sexta generación, puede megaevolucionar en Mega-Gengar",R.drawable.gengar));
        ListPersonajes.add(new PersonajeVo("Eevee","La configuración genética de Eevee le permite mutar y adaptarse enseguida a cualquier medio en el que viva. La evolución de este Pokémon suele ser posible gracias a las radiaciones emitidas por varias piedras.",R.drawable.eve));
        ListPersonajes.add(new PersonajeVo("Jolteon","Las células de Jolteon generan un nivel bajo de electricidad, cuya intensidad aumenta con la electricidad estática que acumula en un pelaje formado por agujas cargadas de electricidad. Esta característica le permite lanzar rayos.",R.drawable.jolteon));
        ListPersonajes.add(new PersonajeVo("Ponyta","Al nacer, Ponyta es muy débil y apenas puede ponerse en pie. Con todo, se va haciendo más fuerte al tropezarse y caerse en su intento por seguir a sus progenitores.",R.drawable.ponyta));
        ListPersonajes.add(new PersonajeVo("Jigglypuff","Jigglypuff tiene unas cuerdas vocales que ajustan sin problema la longitud de onda de su voz. Este Pokémon usa la habilidad que tiene para cantar con la longitud de onda necesaria para adormecer a su rival.",R.drawable.jigglypuff));
        ListPersonajes.add(new PersonajeVo("Charmander","La llama que tiene en la punta de la cola arde según sus sentimientos. Llamea levemente cuando está alegre y arde vigorosamente cuando está enfadado.",R.drawable.charmander));
        ListPersonajes.add(new PersonajeVo("Dratini","Dratini muda y se despoja de la vieja piel continuamente. Es algo que necesita hacer porque la energía que tiene en su interior no para de alcanzar niveles incontrolables.",R.drawable.dratini));

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_list: Utilidades.visualizacion = Utilidades.LIST;
                break;
            case R.id.btn_grid: Utilidades.visualizacion = Utilidades.GRID;
                break;
        }
        
        construirRecycler();
        
    }

    private void construirRecycler() {
        ListPersonajes = new ArrayList<>();
        recyclerPersonajes = (RecyclerView) findViewById(R.id.recycler_id);

        if (Utilidades.visualizacion == Utilidades.LIST){
            recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this,2));

        }


        llenarPersonajes();

        AdaptadorPersonajes adapter = new AdaptadorPersonajes(ListPersonajes);
        recyclerPersonajes.setAdapter(adapter);

    }




}
