package org.example.personagens;

import org.example.util.DadoUtil;

public class MortoVivo extends Personagem {
    public MortoVivo() {
        super(25, 4, 0, 0,1, "Morto Vivo");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD4() + dadoUtil.rollD4() + getPontosDeForca();
    }
}
