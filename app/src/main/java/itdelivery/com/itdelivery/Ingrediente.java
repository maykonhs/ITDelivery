package itdelivery.com.itdelivery;

import java.math.BigDecimal;

/**
 * Created by maykon on 25/10/16.
 */
public class Ingrediente {

    private String nome;
    private BigDecimal preco;
    int value = 1;

    public Ingrediente(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
        this.value = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getValue(){
        return this.value;
    }
}
