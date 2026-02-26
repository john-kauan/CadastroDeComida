# 🍽️ Cadastro de comida - API

API desenvolvida com Java e Spring Boot para gerenciamento de cadastro de alimentos.

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (banco em memória)
- Maven
- Insomnia (testes de API)

---

## 📌 Funcionalidades

✔ Criar alimento  
✔ Listar todos os alimentos  
✔ Atualizar alimento  
✔ Deletar alimento  
✔ Integração com banco de dados H2  
✔ Console H2 habilitado  

---

## 🏗️ Arquitetura

O projeto segue o padrão em camadas:

- Controller → Camada de requisição HTTP
- Service → Regras de negócio
- Repository → Acesso ao banco de dados (JPA)
- Model → Entidade mapeada com @Entity

---

## 📂 Endpoints

### 🔹 Criar alimento
POST /foods

### 🔹 Listar alimentos
GET /foods

### 🔹 Atualizar alimento
PUT /foods/{id}

### 🔹 Deletar alimento
DELETE /foods/{id}

---

## 🗄 Banco de Dados

Banco utilizado: H2 (em memória)

Console disponível em:
http://localhost:8080/h2-console

JDBC URL:
jdbc:h2:mem:testdb

Username:
sa

Password:
(vazio)

---

## ▶ Como rodar o projeto

1. Clonar o repositório
2. Abrir no IntelliJ ou VS Code
3. Rodar a aplicação
4. Testar endpoints no Insomnia

---

## 🎯 Objetivo do Projeto

Projeto desenvolvido para prática de:

- API REST
- CRUD completo
- JPA / Hibernate
- Arquitetura em camadas
- Boas práticas com Spring Boot

---

## 👨‍💻 Autor

Desenvolvido por John Kauan
