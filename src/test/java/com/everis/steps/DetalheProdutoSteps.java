package com.everis.steps;

import com.everis.pages.DetalhesProdutoPagePage;

import io.cucumber.java.pt.E;

public class DetalheProdutoSteps {

	@E("^aumenta a quantidade produto$")
	public void aumentarQuantidadeProduto(String nomeProduto){
		DetalhesProdutoPagePage detalheProdutoPage = new DetalhesProdutoPagePage();
		detalheProdutoPage.aumentarQuantidadeProduto();
	}
}
