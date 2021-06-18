package com.luizbcorrea.santanderdevweek.data.local

import com.luizbcorrea.santanderdevweek.data.Cartao
import com.luizbcorrea.santanderdevweek.data.Cliente
import com.luizbcorrea.santanderdevweek.data.Conta

class FakeData{

    // dados fake
    fun getLocalData() : Conta {
        val cliente = Cliente("Luiz")
        val cartao = Cartao("0033")

        // retorna conta mock
        return Conta(
            "445655-4",
            "6552-4",
            "2.450,80",
            "4.120,00",
            cliente,
            cartao
        )
    }

}