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

import br.edu.up.dominio.Menu;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WsMenuUnitTests {
	private static String MENUS_ENDPOINT = "http://localhost:8080/menu";

	private ClientHttpRequestFactory getHttpClientFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory httpClient
	      = new HttpComponentsClientHttpRequestFactory();
	    httpClient.setConnectTimeout(timeout);
	    return httpClient;
	}
	
	//@Test
	public void buscarMenuPorIDJSONTest() {
		
		//Retorno em JSON
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(MENUS_ENDPOINT + "/1", String.class);
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
	public void listarMenusTest() {
		
		RestTemplate rest = getRestTemplate();
		ParameterizedTypeReference<PagedResources<Menu>> type = new ParameterizedTypeReference<PagedResources<Menu>>() {};
		ResponseEntity<PagedResources<Menu>> response = rest.exchange(MENUS_ENDPOINT, HttpMethod.GET, null, type);
		PagedResources<Menu> mResource = response.getBody();
		List<Menu> lista = new ArrayList<>(mResource.getContent());
		
		for (Menu menu : lista) {
			System.out.println(menu); 
		}
	}
	
	//@Test
		public void buscarMenuPorIDPOJOTest() {
			
			//Retorno como objeto
			RestTemplate rest = new RestTemplate();
			Menu menu = rest.getForObject(MENUS_ENDPOINT + "/1", Menu.class);
			assertThat(menu.getDsMenu(), notNullValue());
			assertThat(menu.getModulo(), notNullValue());
			assertThat(menu.getIdMenu(), is(1L));

		}
		
		//@Test
		public void incluirMenuTest() {
			ClientHttpRequestFactory factory = getHttpClientFactory();
			RestTemplate rest = new RestTemplate(factory);
			 
			HttpEntity<Menu> request = new HttpEntity<>(new Menu("cadastrar", null));
			Menu menu = rest.postForObject(MENUS_ENDPOINT, request, Menu.class);
			
			assertThat(menu, notNullValue());
			assertThat(menu.getDsMenu(), is("cadastrar"));
		}
		
		//@Test
		public void atualizarMenuTest() {
			
			//Primeiro inclui um menu
			RestTemplate rest = new RestTemplate();
			HttpEntity<Menu> requestCreate = new HttpEntity<>(new Menu("Atualizar", null));
			ResponseEntity<Menu> response = rest.exchange(MENUS_ENDPOINT, HttpMethod.POST, requestCreate, Menu.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Menu mCriado = response.getBody();
			  
			assertThat(mCriado, notNullValue());
			assertThat(mCriado.getDsMenu(), is("Atualizar"));
			
			//Depois atualiza
			mCriado.setDsMenu(mCriado.getDsMenu() + "+");

			String url = MENUS_ENDPOINT+ '/' + mCriado.getIdMenu();
			HttpEntity<Menu> requestUpdate = new HttpEntity<>(mCriado);
			rest.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
			
		}		
		
		//@Test
		public void excluirMenuTest() {
			
			//Primeiro inclui um menu
			RestTemplate rest = new RestTemplate();
			HttpEntity<Menu> requestCreate = new HttpEntity<>(new Menu("Excluir", null));
			ResponseEntity<Menu> response = rest.exchange(MENUS_ENDPOINT, HttpMethod.POST, requestCreate, Menu.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Menu mCriado = response.getBody();
			  
			assertThat(mCriado, notNullValue());
			assertThat(mCriado.getDsMenu(), is("Excluir"));
			assertThat(mCriado.getModulo(), is("null"));
			
			//Depois exclui
			String url = MENUS_ENDPOINT+ '/' + mCriado.getIdMenu();
			rest.delete(url);
			
		}
}
