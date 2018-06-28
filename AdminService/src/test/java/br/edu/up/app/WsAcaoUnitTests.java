package br.edu.up.app;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.edu.up.dominio.Acao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WsAcaoUnitTests {
	
	private static String ACOES_ENDPOINT = "http://localhost:8080/acao";

	private ClientHttpRequestFactory getHttpClientFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory httpClient
	      = new HttpComponentsClientHttpRequestFactory();
	    httpClient.setConnectTimeout(timeout);
	    return httpClient;
	}
	
	//@Test
	public void buscarAcaoPorIDJSONTest() {
		
		//Retorno em JSON
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(ACOES_ENDPOINT + "/1", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Autowired
    @Qualifier("halJacksonHttpMessageConverter")
	private TypeConstrainedMappingJackson2HttpMessageConverter converter;
	
	public RestTemplate getRestTemplate() {
		RestTemplate rest = new RestTemplate();
		List<HttpMessageConverter<?>> converters = rest.getMessageConverters();
		converters.add(0, converter);
		rest.setMessageConverters(converters);
		return rest;
	}
	

	@Test
	public void listarAcoesTest() {
		
		RestTemplate rest = getRestTemplate();
		ParameterizedTypeReference<PagedResources<Acao>> type = new ParameterizedTypeReference<PagedResources<Acao>>() {};
		ResponseEntity<PagedResources<Acao>> response = rest.exchange(ACOES_ENDPOINT, HttpMethod.GET, null, type);
		PagedResources<Acao> aResource = response.getBody();
		List<Acao> lista = new ArrayList<>(aResource.getContent());
		
		for (Acao acao : lista) {
			System.out.println(acao); 
		}
	}
	
	//@Test
		public void buscarAcaoPorIDPOJOTest() {
			
			//Retorno como objeto
			RestTemplate rest = new RestTemplate();
			Acao acao = rest.getForObject(ACOES_ENDPOINT + "/1", Acao.class);
			assertThat(acao.getCdAcao(), notNullValue());
			assertThat(acao.getDsAcao(), notNullValue());
			assertThat(acao.getIdAcao(), is(1L));

		}
		
		//@Test
		public void incluirAcaoTest() {
			
			ClientHttpRequestFactory factory = getHttpClientFactory();
			RestTemplate rest = new RestTemplate(factory);
			 
			HttpEntity<Acao> request = new HttpEntity<>(new Acao(1, "cadastrar" ));
			Acao acao = rest.postForObject(ACOES_ENDPOINT, request, Acao.class);
			
			assertThat(acao, notNullValue());
			assertThat(acao.getCdAcao(), is(1));
		}
		
		//@Test
		public void atualizarAcaoTest() {
			
			//Primeiro inclui uma acao
			RestTemplate rest = new RestTemplate();
			HttpEntity<Acao> requestCreate = new HttpEntity<>(new Acao(1, "Atualizar"));
			ResponseEntity<Acao> response = rest.exchange(ACOES_ENDPOINT, HttpMethod.POST, requestCreate, Acao.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Acao aCriada = response.getBody();
			  
			assertThat(aCriada, notNullValue());
			assertThat(aCriada.getCdAcao(), is(1));
			
			//Depois atualiza
			aCriada.setDsAcao(aCriada.getDsAcao() + "+");

			String url = ACOES_ENDPOINT+ '/' + aCriada.getIdAcao();
			HttpEntity<Acao> requestUpdate = new HttpEntity<>(aCriada);
			rest.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
			
		}
		
		
		//@Test
		public void excluirAcaoTest() {
			
			//Primeiro inclui uma acao
			RestTemplate rest = new RestTemplate();
			HttpEntity<Acao> requestCreate = new HttpEntity<>(new Acao(1, "Excluir"));
			ResponseEntity<Acao> response = rest.exchange(ACOES_ENDPOINT, HttpMethod.POST, requestCreate, Acao.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Acao aCriada = response.getBody();
			  
			assertThat(aCriada, notNullValue());
			assertThat(aCriada.getCdAcao(), is(2));
			assertThat(aCriada.getDsAcao(), is("Excluir"));
			
			//Depois exclui
			String url = ACOES_ENDPOINT+ '/' + aCriada.getIdAcao();
			rest.delete(url);
			
		}
	
	
}
