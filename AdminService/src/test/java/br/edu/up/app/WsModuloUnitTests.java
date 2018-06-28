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

import br.edu.up.dominio.Modulo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WsModuloUnitTests {
	
	private static String MODULOS_ENDPOINT = "http://localhost:8080/modulo";

	private ClientHttpRequestFactory getHttpClientFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory httpClient
	      = new HttpComponentsClientHttpRequestFactory();
	    httpClient.setConnectTimeout(timeout);
	    return httpClient;
	}
	
	//@Test
	public void buscarModuloPorIDJSONTest() {
		
		//Retorno em JSON
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(MODULOS_ENDPOINT + "/1", String.class);
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
	public void listarModulosTest() {
		
		RestTemplate rest = getRestTemplate();
		ParameterizedTypeReference<PagedResources<Modulo>> type = new ParameterizedTypeReference<PagedResources<Modulo>>() {};
		ResponseEntity<PagedResources<Modulo>> response = rest.exchange(MODULOS_ENDPOINT, HttpMethod.GET, null, type);
		PagedResources<Modulo> mResource = response.getBody();
		List<Modulo> lista = new ArrayList<>(mResource.getContent());
		
		for (Modulo modulo : lista) {
			System.out.println(modulo); 
		}
	}
	
	//@Test
		public void buscarModuloPorIDPOJOTest() {
			
			//Retorno como objeto
			RestTemplate rest = new RestTemplate();
			Modulo Modulo = rest.getForObject(MODULOS_ENDPOINT + "/1", Modulo.class);
			assertThat(Modulo.getDsModulo(), notNullValue());
			assertThat(Modulo.getNrModulo(), notNullValue());
			assertThat(Modulo.getMenus(), notNullValue());
			assertThat(Modulo.getIdModulo(), is(1L));

		}
		
		//@Test
		public void incluirModuloTest() {
			ClientHttpRequestFactory factory = getHttpClientFactory();
			RestTemplate rest = new RestTemplate(factory);
			 
			HttpEntity<Modulo> request = new HttpEntity<>(new Modulo("vendas", 1, null));
			Modulo Modulo = rest.postForObject(MODULOS_ENDPOINT, request, Modulo.class);
			
			assertThat(Modulo, notNullValue());
			assertThat(Modulo.getDsModulo(), is("vendas"));
		}
		
		//@Test
		public void atualizarModuloTest() {
			
			//Primeiro inclui um Modulo
			RestTemplate rest = new RestTemplate();
			HttpEntity<Modulo> requestCreate = new HttpEntity<>(new Modulo("Atualizar", 1, null));
			ResponseEntity<Modulo> response = rest.exchange(MODULOS_ENDPOINT, HttpMethod.POST, requestCreate, Modulo.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Modulo mCriado = response.getBody();
			  
			assertThat(mCriado, notNullValue());
			assertThat(mCriado.getDsModulo(), is("Atualizar"));
			
			//Depois atualiza
			mCriado.setDsModulo(mCriado.getDsModulo() + "+");

			String url = MODULOS_ENDPOINT+ '/' + mCriado.getIdModulo();
			HttpEntity<Modulo> requestUpdate = new HttpEntity<>(mCriado);
			rest.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
			
		}		
		
		//@Test
		public void excluirModuloTest() {
			
			//Primeiro inclui um Modulo
			RestTemplate rest = new RestTemplate();
			HttpEntity<Modulo> requestCreate = new HttpEntity<>(new Modulo("Excluir", 1 ,null));
			ResponseEntity<Modulo> response = rest.exchange(MODULOS_ENDPOINT, HttpMethod.POST, requestCreate, Modulo.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Modulo mCriado = response.getBody();
			  
			assertThat(mCriado, notNullValue());
			assertThat(mCriado.getDsModulo(), is("Excluir"));
			assertThat(mCriado.getNrModulo(), is(1));
			assertThat(mCriado.getMenus(), is("null"));
			
			//Depois exclui
			String url = MODULOS_ENDPOINT+ '/' + mCriado.getIdModulo();
			rest.delete(url);
			
		}

}
