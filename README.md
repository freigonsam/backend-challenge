# JWT Validator
Este projeto consiste em uma aplicação Java que expõe uma API web para validar tokens JWT de acordo com determinadas regras. Ele verifica se um token JWT é válido e atende aos seguintes critérios:

- Deve ser um JWT válido
- Deve conter apenas 3 claims (Name, Role e Seed)
- A claim Name não pode ter caracteres numéricos e seu tamanho máximo é de 256 caracteres
- A claim Role deve conter apenas um dos três valores (Admin, Member e External)
- A claim Seed deve ser um número primo

# Requisitos

- Java Development Kit (JDK) 17 ou superior
- Maven (para compilar e gerenciar dependências)

# Instalação e execução

### Clone este repositório:
```
git clone https://github.com/freigonsam/backend-challenge
```

### Compile o projeto usando o Maven:
```
mvn clean package
```

# Uso
Após iniciar a aplicação, você pode enviar uma requisição HTTP POST contendo um token JWT para o endpoint /validate para validar o token. O serviço retornará um boolean indicando se o token é válido ou não.


### Subir API
```
mvn pring-boot:run
```

### Contribuição
Contribuições são bem-vindas!
