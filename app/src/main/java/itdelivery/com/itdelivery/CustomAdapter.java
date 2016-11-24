package itdelivery.com.itdelivery;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by maykon on 25/10/16.
 */
public class CustomAdapter extends ArrayAdapter {

    Ingrediente[] ingredienteItens = null;
    Context context;

    public CustomAdapter(Context context, Ingrediente[] ingrediente) {
        super(context, R.layout.row, ingrediente);

        this.context = context;
        this.ingredienteItens = ingrediente;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        TextView nome = (TextView) convertView.findViewById(R.id.tv1);
        TextView preco = (TextView) convertView.findViewById(R.id.tv2);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb1);
        nome.setText(ingredienteItens[position].getNome());
        preco.setText(ingredienteItens[position].getPreco().toString());

        if (ingredienteItens[position].getValue() == 1) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        return convertView;
    }
}
