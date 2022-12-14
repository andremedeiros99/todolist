# todolist
Trabalho para disciplina Sistemas Distribuidos  

### Modelo de dados  
#### O sistema deve dar suporte ao gerenciamento de tarefas. Cada tarefa possui os seguintes atributos  
- Identificador: código que identifica de forma única a tarefa.  
- Descrição: informação textual que descreve a tarefa.  
- Prazo: data/hora que informa o limite para completar a tarefa.  
- Completa: valor lógico que define se a tarefa já foi completada.  

#### Funcionalidades da API  
- Get /tarefas -> retornar uma lista com todas as tarefas.  
- Get /tarefas/{identificador} -> retornar os dados da tarefa correspondente ao identificador.  
- Post /tarefas -> incluir uma tarefa; os dados da tarefa devem ser passados no corpo da requisição HTTP.  
- Delete /tarefas/{identificador} -> excluir a tarefa correspondente ao identificador.  
- Put /tarefas/{identificador} -> alterar os dados da tarefa correspondente ao identificador; os novos dados devem ser passados no corpo da requisição HTTP.  

### Tecnologias  
- Spring 3.0   
- Maven   
- Java 17   
- H2   

### Execução do Programa  
Para se executar o programa foi utilizada uma extensão do VSCode para facilitar o uso. A execução provém da classe DemoApplication.java.  
Para consultar o banco de dados é necessário acessar: http://localhost:8080/h2-console  
Informações para login:  
spring.datasource.url=jdbc:h2:mem:db  
spring.datasource.driver-ClassName=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=  
