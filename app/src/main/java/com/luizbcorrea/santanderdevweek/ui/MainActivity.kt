package com.luizbcorrea.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.luizbcorrea.santanderdevweek.R
import com.luizbcorrea.santanderdevweek.data.Conta
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    // importando os dados
    private lateinit var mainViewModel: MainViewModel // "lateinit" = contruido posteriormente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // ESCOPO: primeiro fala que o ViewModelProvider tem que istanciar(recuperar) o MainViewModel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()

        //throw RuntimeException("test crash") // Force a crash
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }


    // retorna a conta
    private fun bindOnView(conta : Conta) {
        //busca o texto do nome no usuário
        findViewById<TextView>(R.id.TV_usuario).text = conta.cliente.nome
        //busca o texto da agência
        findViewById<TextView>(R.id.TV_agencia).text = conta.agencia
        //busca o texto da conta corrente
        findViewById<TextView>(R.id.TV_conta_corrente).text = conta.numero
        //busca o texto do saldo
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        //busca o texto do limite
        findViewById<TextView>(R.id.tv_limite).text = conta.limite
        //busca o texto do cartão de credito
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao

    }

    // inflando o layout de menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    // escutar o item do menu ( gerência o cliques do menu)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) { // quando este for item1 faça...
            R.id.menu_notification -> {
                Log.d("click", "CLICK NO ITEM 1")
                true
            }else -> super.onOptionsItemSelected(item)
        }

    }


}