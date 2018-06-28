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

import br.edu.up.dominio.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WsUsuarioUnitTests {
	
	private static String USUARIOS_ENDPOINT = "http://localhost:8080/usuario";

	private ClientHttpRequestFactory getHttpClientFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory httpClient
	      = new HttpComponentsClientHttpRequestFactory();
	    httpClient.setConnectTimeout(timeout);
	    return httpClient;
	}
	
	//@Test
	public void buscarUsuarioPorIDJSONTest() {
		
		//Retorno em JSON
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(USUARIOS_ENDPOINT + "/1", String.class);
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
	public void listarUsuariosTest() {
		
		RestTemplate rest = getRestTemplate();
		ParameterizedTypeReference<PagedResources<Usuario>> type = new ParameterizedTypeReference<PagedResources<Usuario>>() {};
		ResponseEntity<PagedResources<Usuario>> response = rest.exchange(USUARIOS_ENDPOINT, HttpMethod.GET, null, type);
		PagedResources<Usuario> mResource = response.getBody();
		List<Usuario> lista = new ArrayList<>(mResource.getContent());
		
		for (Usuario usuario : lista) {
			System.out.println(usuario); 
		}
	}
	
	//@Test
		public void buscarUsuarioPorIDPOJOTest() {
			
			//Retorno como objeto
			RestTemplate rest = new RestTemplate();
			Usuario Usuario = rest.getForObject(USUARIOS_ENDPOINT + "/1", Usuario.class);
			assertThat(Usuario.getNome(), notNullValue());
			assertThat(Usuario.getAcoes(), notNullValue());
			assertThat(Usuario.getModulos(), notNullValue());
			assertThat(Usuario.getIdUsuario(), is(1L));
			assertThat(Usuario.getIdexterno(), is(1L));

		}
		
		//@Test
		public void incluirUsuarioTest() {
			ClientHttpRequestFactory factory = getHttpClientFactory();
			RestTemplate rest = new RestTemplate(factory);
			 
			HttpEntity<Usuario> request = new HttpEntity<>(new Usuario(3,"Ariane",null,null));
			Usuario Usuario = rest.postForObject(USUARIOS_ENDPOINT, request, Usuario.class);
			
			assertThat(Usuario, notNullValue());
			assertThat(Usuario.getIdexterno(), is(3));
		}
		
		//@Test
		public void atualizarUsuarioTest() {
			
			//Primeiro inclui um Usuario
			RestTemplate rest = new RestTemplate();
			HttpEntity<Usuario> requestCreate = new HttpEntity<>(new Usuario(3,"Ariane",null,null));
			ResponseEntity<Usuario> response = rest.exchange(USUARIOS_ENDPOINT, HttpMethod.POST, requestCreate, Usuario.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Usuario uCriado = response.getBody();
			  
			assertThat(uCriado, notNullValue());
			assertThat(uCriado.getNome(), is("Atualizar"));
			
			//Depois atualiza
			uCriado.setNome(uCriado.getNome() + "+");

			String url = USUARIOS_ENDPOINT+ '/' + uCriado.getIdUsuario();
			HttpEntity<Usuario> requestUpdate = new HttpEntity<>(uCriado);
			rest.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
			
		}		
		
		//@Test
		public void excluirUsuarioTest() {
			
			//Primeiro inclui um Usuario
			RestTemplate rest = new RestTemplate();
			HttpEntity<Usuario> requestCreate = new HttpEntity<>(new Usuario(3,"Ariane",null,null));
			ResponseEntity<Usuario> response = rest.exchange(USUARIOS_ENDPOINT, HttpMethod.POST, requestCreate, Usuario.class);
			  
			assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
			  
			Usuario uCriado = response.getBody();
			  
			assertThat(uCriado, notNullValue());
			assertThat(uCriado.getIdexterno(), is(3));
			assertThat(uCriado.getNome(), is("Ariane"));
			assertThat(uCriado.getAcoes(), is("null"));
			assertThat(uCriado.getModulos(), is("null"));
			
			//Depois exclui
			String url = USUARIOS_ENDPOINT+ '/' + uCriado.getIdUsuario();
			rest.delete(url);
			
		}

}
