package org.example.personagens;

import org.example.util.DadoUtil;

public class Guerreiro extends Personagem {
    public Guerreiro() {
        super(12, 4, 3, 3,3, "Guerreiro");

    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD4() + dadoUtil.rollD4() + getPontosDeForca();
    }
}
