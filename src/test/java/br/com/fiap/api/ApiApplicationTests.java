package br.com.fiap.api;

import br.com.fiap.api.example.config.UsuarioService;
import br.com.fiap.api.example.models.Usuario;
import br.com.fiap.api.example.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@SpringBootConfiguration

public class ApiApplicationTests {

//
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//
//
//	public void testCRUDOperations() {
//
//		// Cria um exemplo de entidade
//		Usuario usuario = new Usuario();
//		usuario.setId(1L);
//		usuario.setNome("Karina Joelma");
//		usuario.setEmail("karina@example.com");
//		usuario.setSenha("12345678");
//		usuario.setCidade("Taboão");
//		usuario.setEstado("São Paulo");
//
//		// Salva a entidade no banco de dados
//		Usuario savedUsuario = usuarioRepository.save(usuario);
//		assertNotNull(savedUsuario.getId());
//
//		// Busca a entidade do banco de dados usando o ID
//		Usuario retrievedExample = usuarioRepository.findById(savedUsuario.getId()).orElse(null);
//		assertNotNull(retrievedExample);
//		assertEquals("Karina Joelma", retrievedExample.getNome());
//		assertEquals("karina@example.com", retrievedExample.getEmail());
//
//			// Atualiza a entidade
//			retrievedExample.setNome("Joelma");
//			retrievedExample.setEmail("Joelma@example.com");
//		    Usuario updatedExample = usuarioRepository.save(retrievedExample);
//			assertEquals("Joelma", updatedExample.getNome());
//			assertEquals("Joelma@example.com", updatedExample.getEmail());
//
//			// Exclui a entidade do banco de dados
//			usuarioRepository.delete(updatedExample);
//			assertFalse(usuarioRepository.existsById(updatedExample.getId()));
//}


}
