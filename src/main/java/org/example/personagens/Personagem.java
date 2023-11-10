package org.example.personagens;

import lombok.Data;
import org.example.util.DadoUtil;


@Data
public abstract class Personagem {
    private int pontosDeVida;
    private int pontosDeDefesa;
    private int pontosDeForca;
    private int pontosDeAtaque;
    private int pontosDeAgilidade;
    private String classe;

    public Personagem(int pontosDeVida, int pontosDeForca, int pontosDeAtaque, int pontosDeDefesa, int pontosDeAgilidade, String classe) {
        this.pontosDeVida = pontosDeVida;
        this.pontosDeForca = pontosDeForca;
        this.pontosDeAtaque = pontosDeAtaque;
        this.pontosDeAgilidade = pontosDeAgilidade;
        this.pontosDeDefesa = pontosDeDefesa;
        this.classe = classe;
    }

    public abstract int calcularFatorDeDano();

    public int CalcularIniciativa() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD10() + pontosDeAgilidade;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "pontosDeVida=" + pontosDeVida +
                ", classe='" + classe + '\'' +
                '}';
    }

    public int calcularFatorDeAtaque() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD10() + pontosDeAgilidade + pontosDeForca;
    }

    public int calcularFatorDeDefesa() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD10() + pontosDeAgilidade + pontosDeDefesa;
    }

    public void sofrerDano(int dano) {
        if(dano <= 0) {
            throw new IllegalArgumentException("Dano não pode ser menor que 0");
        }

        this.pontosDeVida -= dano;
    }
}
