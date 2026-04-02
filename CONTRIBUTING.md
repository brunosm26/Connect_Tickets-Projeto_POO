# Connect Tickets - Guia do Projeto

Documento de referencia para toda a equipe. Contem overview do projeto, stack, estrutura, entidades e instrucoes de como contribuir com codigo.

---

## 1. Sobre o Projeto

**Connect Tickets** e uma plataforma web para a Arena de Pernambuco que conecta a administracao do equipamento publico aos cidadaos, facilitando:
- Divulgacao e listagem de eventos
- Participacao/inscricao em eventos
- Sugestoes de novos eventos
- Agendamento de visitas
- Painel administrativo com estatisticas

---

## 2. Stack

| Camada         | Tecnologia                     |
|----------------|--------------------------------|
| Linguagem      | Java 21                        |
| Framework      | Spring Boot 3.4.4              |
| Web            | Spring MVC (REST API)          |
| Persistencia   | Spring Data JPA + Hibernate    |
| Banco de Dados | H2 (desenvolvimento/memoria)   |
| Documentacao   | SpringDoc OpenAPI + Scalar UI  |
| Build          | Maven (wrapper incluso)        |
| Testes         | JUnit 5                        |

---

## 3. Estrutura do Projeto

```
src/main/java/com/projetopoo/mytickets/
├── Application.java                    # Classe principal (Spring Boot)
├── config/                             # Configuracoes
├── controller/                         # REST Controllers
│   ├── AdminController.java            # Endpoints administrativos
│   ├── EventoController.java           # CRUD de eventos
│   ├── InscricaoController.java        # Inscricoes em eventos
│   ├── UsuarioController.java          # Usuarios
│   └── ScalarController.java           # Documentacao Scalar em /docs
├── dto/                                # Data Transfer Objects
│   ├── EventoDTO.java
│   └── EstatisticaDTO.java
├── model/                              # Entidades JPA
│   ├── Usuario.java
│   ├── Evento.java
│   └── Inscricao.java
├── repository/                         # Interfaces Spring Data JPA
│   ├── UsuarioRepository.java
│   ├── EventoRepository.java
│   └── InscricaoRepository.java
└── service/                            # Logica de negocio
    ├── UsuarioService.java
    ├── EventoService.java
    └── InscricaoService.java
```

---

## 4. Entidades

### Usuario
| Campo         | Tipo          | Observacao          |
|---------------|---------------|---------------------|
| id            | Long (PK)     | Auto gerado         |
| name          | String        | Obrigatorio         |
| email         | String        | Unico, obrigatorio  |
| password_hash | String        | Obrigatorio         |
| role          | Enum          | USER ou ADMIN       |
| created_at    | LocalDateTime | Automatico          |

### Evento
| Campo           | Tipo          | Observacao              |
|-----------------|---------------|-------------------------|
| id              | Long (PK)     | Auto gerado             |
| name            | String        | Obrigatorio             |
| description     | String        | Descricao completa      |
| date_time       | LocalDateTime | Data e horario          |
| category        | Enum          | ESPORTE, SHOW, CULTURAL, CORPORATIVO |
| max_capacity    | Integer       | Capacidade maxima       |
| image_url       | String        | URL da imagem           |
| location_detail | String        | Detalhe do local        |
| created_by      | Long (FK)     | Referencia ao Usuario   |
| created_at      | LocalDateTime | Automatico              |
| updated_at      | LocalDateTime | Automatico              |

### Inscricao
| Campo        | Tipo          | Observacao            |
|--------------|---------------|-----------------------|
| id           | Long (PK)     | Auto gerado           |
| user_id      | Long (FK)     | Referencia ao Usuario |
| event_id     | Long (FK)     | Referencia ao Evento  |
| confirmed_at | LocalDateTime | Data de confirmacao   |

---

## 5. Endpoints Principais

| Metodo | Rota                            | Descricao                       |
|--------|---------------------------------|---------------------------------|
| GET    | /api/eventos                    | Listar eventos futuros          |
| GET    | /api/eventos/{id}               | Detalhes de um evento           |
| POST   | /api/eventos                    | Cadastrar evento (admin)        |
| PUT    | /api/eventos/{id}               | Editar evento (admin)           |
| POST   | /api/eventos/{id}/participar    | Confirmar participacao          |
| GET    | /api/eventos?categoria=SHOW     | Filtrar por categoria           |
| GET    | /docs                           | Documentacao Scalar (API)       |
| GET    | /v3/api-docs                    | OpenAPI JSON                    |

---

## 6. Como Rodar o Projeto

### Pre-requisitos
- Java 21 instalado (verificar com `java -version`)
- Git instalado

### Passo a passo

```bash
# 1. clonar o repositorio
git clone https://github.com/brunosm26/Connect_Tickets-Projeto_POO.git
cd Connect_Tickets-Projeto_POO

# 2. dar permissao ao maven wrapper (mac/linux)
chmod +x mvnw

# 3. rodar a aplicacao
./mvnw spring-boot:run

# no windows:
mvnw.cmd spring-boot:run
```

A aplicacao inicia em **http://localhost:8080**.

| Recurso             | URL                              |
|---------------------|----------------------------------|
| API REST            | http://localhost:8080/api/        |
| Documentacao Scalar | http://localhost:8080/docs        |
| OpenAPI JSON        | http://localhost:8080/v3/api-docs |

---

## 7. Como Contribuir (Git)

### 7.1 Clonar e criar branch

**SEMPRE clone o repositorio, nunca baixe como ZIP.**

```bash
# clonar
git clone https://github.com/brunosm26/Connect_Tickets-Projeto_POO.git
cd Connect_Tickets-Projeto_POO

# criar branch a partir da main
git checkout main
git pull origin main
git checkout -b feat/nome-da-sua-feature
```

### 7.2 Padrao de nomes de branch

```
feat/nome-da-feature      → nova funcionalidade
fix/nome-do-bug           → correcao de bug
refactor/o-que-mudou      → refatoracao
docs/o-que-documentou     → documentacao
test/o-que-testou         → testes
chore/o-que-configurou    → configuracao/tooling
```

Exemplos:
```
feat/listagem-eventos
fix/erro-inscricao-duplicada
refactor/evento-service
docs/readme-atualizado
```

### 7.3 Padrao de commits (Conventional Commits)

Formato: `tipo: descricao curta em ingles e minusculo`

```bash
git add src/main/java/com/projetopoo/mytickets/model/Evento.java
git commit -m "feat: add evento entity with jpa annotations"

git add src/main/java/com/projetopoo/mytickets/service/EventoService.java
git commit -m "feat: add evento service with crud operations"

git add src/main/java/com/projetopoo/mytickets/controller/EventoController.java
git commit -m "feat: add evento rest controller"
```

**Tipos de commit:**
| Tipo     | Quando usar                          |
|----------|--------------------------------------|
| feat     | Nova funcionalidade                  |
| fix      | Correcao de bug                      |
| refactor | Refatoracao (sem mudar comportamento)|
| test     | Adicionar/alterar testes             |
| docs     | Documentacao                         |
| chore    | Configuracao, build, dependencias    |

**Regras:**
- Mensagem em **ingles**
- Tudo em **minusculo**
- Sem ponto final
- Sem descricao/body, so a primeira linha
- Um commit por arquivo/mudanca logica (nao commitar tudo junto)

### 7.4 Subir a branch e criar PR

```bash
# subir a branch para o github
git push -u origin feat/nome-da-sua-feature
```

Depois acesse o GitHub e crie o Pull Request:
```
https://github.com/brunosm26/Connect_Tickets-Projeto_POO/compare/main...feat/nome-da-sua-feature
```

No PR, escreva:
- **Titulo:** descricao curta do que foi feito
- **Corpo:** lista do que foi adicionado/alterado

### 7.5 Manter a branch atualizada

Antes de comecar a trabalhar no dia, sempre atualize:

```bash
git checkout main
git pull origin main
git checkout feat/sua-feature
git merge main
```

---

## 8. Regras Importantes

1. **Nunca commite direto na main** — sempre use branch + PR
2. **Nunca baixe como ZIP** — sempre use `git clone`
3. **Sempre crie branch a partir da main atualizada**
4. **Commits pequenos e semanticos** — um commit por mudanca logica
5. **Teste antes de subir** — rode `./mvnw spring-boot:run` e veja se funciona

---

## 9. Links Uteis

- **Repositorio:** https://github.com/brunosm26/Connect_Tickets-Projeto_POO
- **Backlog:** [Google Docs](https://docs.google.com/document/d/1fHHdMvh4ezyT2cgZMGVdHDAEMCshl091lF6qxCRIG8Y/edit?usp=sharing)
- **Historias de Usuario (BDD):** [Google Docs](https://docs.google.com/document/d/1rNh6yjRiOeY_gCbTfAXizIdN77B5HpMKccM51h26qmo/edit?usp=sharing)
- **Prototipo Figma:** [Figma](https://cold-target-85807250.figma.site/)
- **Screencast:** [YouTube](https://youtu.be/EOYhhS9HprU)
