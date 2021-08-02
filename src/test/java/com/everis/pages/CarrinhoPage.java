package com.everis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;

public class CarrinhoPage extends BasePage {
	
	public CarrinhoPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	public boolean apresentouProdutoEsperadoNoCarrinho(String nomeProduto) {
		boolean apresentouProdutoEsperadoNoCarrinho = isElementDisplayed(By.xpath("//*[contains(@class,'cart_item')]//a[text()='" + nomeProduto + "']"));
		if (apresentouProdutoEsperadoNoCarrinho) {
			log("Apresentou o produto [" + nomeProduto + "] no carrinho conforme esperado.");
			return true;
		}
		logFail("Deveria ter apresentado o produto [" + nomeProduto + "] no carrinho.");
		return false;
	}

	public boolean oProdutoApresentouQuantidadeEsperado(String nomeProduto, String quantidadeProdutoEsperada) {
		WebElement quantidadeProduto = driver.findElement(By.xpath("//*[text()='" + nomeProduto + "']//ancestor::*[constains(@class, 'cart_item')]//*[contains(@class, 'cart_quantity_input')]"));
		boolean oProdutoApresentouQuantidadeEsperado = quantidadeProdutoEsperada.equals(quantidadeProduto.getAttribute("value"));
		if(oProdutoApresentouQuantidadeEsperado) {
			log("Apresentou a quantidade de produto esperada.");
			return true;
		}
		logFail("Não apresentoua quantidade de produto que era esperada");
		return false;
	}

}

//Selector hub ajuda a monta o xpath dos elementos
//na pasta target -> report -> html-> img é gerado um relatorio dos teste scom prints em uma página html