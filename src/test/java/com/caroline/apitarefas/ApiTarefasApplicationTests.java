package com.caroline.apitarefas;


import com.caroline.apitarefas.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;


	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	class ApiTarefasApplicationTests {
		@Autowired
		private WebTestClient webTestClient;

		@Test
		void testCreateTodoSuccess() {
			var todo = new Todo("todo 1", "desc todo 1", false, 1);

			webTestClient
					.post()
					.uri("/todos")
					.bodyValue(todo)
					.exchange()
					.expectStatus().isCreated()
					.expectBody()
					.jsonPath("$").isArray()
					.jsonPath("$.length()").isEqualTo(1)
					.jsonPath("$[0].nome").isEqualTo(todo.getNome())
					.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
					.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
					.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
		}


	}



