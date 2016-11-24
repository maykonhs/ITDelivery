package itdelivery.com.itdelivery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigDecimal;

public class PedidoActivity extends AppCompatActivity {

    ListView lv;
    Ingrediente[] ingredienteItens;
    Button btPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

//        ListView lista = (ListView) findViewById(R.id.lvpedido);
//
//        String[] values = new String[] {"Integral", "Bacon", "Catupiry", "Cebola", "Azeitona",
//                "Brócolis", "Coca-Cola"};
//
//        ArrayAdapter<String> valuesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
//
//        lista.setAdapter(valuesAdapter);

        lv = (ListView) findViewById(R.id.lvpedido);
        ingredienteItens = new Ingrediente[5];
        ingredienteItens[0] = new Ingrediente("Massa Integral", BigDecimal.valueOf(10.00));
        ingredienteItens[1] = new Ingrediente("Peito de Peru", BigDecimal.valueOf(25.00));
        ingredienteItens[2] = new Ingrediente("Catupiry", BigDecimal.valueOf(8.00));
        ingredienteItens[3] = new Ingrediente("Tomate Seco", BigDecimal.valueOf(4.00));
        ingredienteItens[4] = new Ingrediente("Manjericão", BigDecimal.valueOf(2.00));

        CustomAdapter adapter = new CustomAdapter(this, ingredienteItens);
        lv.setAdapter(adapter);

        btPagar = (Button) findViewById(R.id.btpagar);

        btPagar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(PedidoActivity.this, PagamentoActivity.class);
                startActivity(intent);

            }
        });


    }

}
