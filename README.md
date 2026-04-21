# Connect Tickets: Conectando a População à Arena Pernambuco

Este projeto é uma solução tecnológica desenvolvida para otimizar o uso da Arena Pernambuco. A plataforma funciona como uma ponte entre a administração do equipamento público e os cidadãos, facilitando a divulgação de eventos, o agendamento de visitas e a gestão administrativa do espaço.

## 📌 Problema Central
Atualmente, a Arena Pernambuco possui baixa ocupação efetiva e dificuldades de comunicação com o público interessado. O **Connect Tickets** resolve isso centralizando informações, simulando vendas de ingressos e fornecendo dashboards de ocupação para os gestores.

---

## 📅 Entrega 01 (16/03) - Planejamento e Design

Nesta primeira etapa, focamos na definição do escopo, mapeamento das necessidades dos usuários e desenho da interface (baixa fidelidade).

### 1. Documentação de Negócio
* **Backlog do Produto:** [Acesse o Google Docs](https://docs.google.com/document/d/1fHHdMvh4ezyT2cgZMGVdHDAEMCshl091lF6qxCRIG8Y/edit?usp=sharing)
* **Histórias de Usuário (BDD):** [Acesse o Google Docs](https://docs.google.com/document/d/1rNh6yjRiOeY_gCbTfAXizIdN77B5HpMKccM51h26qmo/edit?usp=sharing)
    * *Inclui cenários de validação (Dado/Quando/Então) para o mínimo de 7 histórias exigidas.*

### 2. Prototipagem (Lo-Fi)
* **Protótipo Interativo (Figma):** [Clique para navegar no Figma](https://cold-target-85807250.figma.site/)
* **Screencast de Apresentação:** [Assista ao vídeo demonstrativo](https://youtu.be/EOYhhS9HprU)
    * *O vídeo apresenta o fluxo de 5 histórias principais do usuário.*


## 🛠️ Tecnologias e Funcionalidades do MVP
* **Tipo de Solução:** Aplicação Web.
* **Principais Funcionalidades:**
    * Visualização e filtro de eventos.
    * Painel Administrativo com métricas de estatística (tendência central e dispersão).
    * Cadastro de eventos por administradores.
    * Agendamento de participação em eventos e visitas.

---

## 🔌 API — Status dos Módulos

Base URL: `http://localhost:8080`  
Documentação interativa: [`/docs`](http://localhost:8080/docs)

### Autenticação

Rotas públicas. Após o login, use o token em todas as requisições autenticadas:

```
Authorization: Bearer {token}
```

| Método | Rota | Acesso | Status |
|--------|------|--------|--------|
| POST | `/api/auth/register` | Público | ✅ |
| POST | `/api/auth/login` | Público | ✅ |
| POST | `/api/auth/register-admin` | ADMIN | ✅ |

> Token JWT com expiração de **2 horas**. Algoritmo HMAC256.

---

### Módulos

#### Eventos (Público para leitura)

| Método | Rota | Acesso | Status |
|--------|------|--------|--------|
| GET | `/api/eventos` | Público | ✅ |
| GET | `/api/eventos/{id}` | Público | ✅ |
| POST | `/api/eventos` | ADMIN | ✅ |
| PUT | `/api/eventos/{id}` | ADMIN | ✅ |
| DELETE | `/api/eventos/{id}` | ADMIN | ✅ |
| POST | `/api/eventos/{id}/admins/{idUsuario}` | ADMIN | ✅ |
| DELETE | `/api/eventos/{id}/admins/{idUsuario}` | ADMIN | ✅ |
| GET | `/api/eventos?categoria={categoria}` | Público | ⏳ pendente |

> Categorias disponíveis: `ESPORTE`, `SHOW`, `CULTURAL`, `CORPORATIVO`

---

#### Usuários (Admin)

| Método | Rota | Acesso | Status |
|--------|------|--------|--------|
| GET | `/api/usuarios` | ADMIN | ✅ |
| GET | `/api/usuarios/{id}` | ADMIN | ✅ |
| POST | `/api/usuarios` | ADMIN | ✅ |
| PUT | `/api/usuarios/{id}` | ADMIN / próprio usuário | ✅ |
| DELETE | `/api/usuarios/{id}` | ADMIN | ⏳ pendente |

---

#### Inscrições

| Método | Rota | Acesso | Status |
|--------|------|--------|--------|
| POST | `/api/inscricoes` | Autenticado | ✅ |
| GET | `/api/inscricoes` | ADMIN | ✅ |
| GET | `/api/inscricoes/me` | Autenticado | ✅ |
| DELETE | `/api/inscricoes/{id}` | Autenticado | ⏳ pendente |

---

#### Agendamentos

| Método | Rota | Acesso | Status |
|--------|------|--------|--------|
| POST | `/api/agendamentos` | Autenticado | ✅ |
| GET | `/api/agendamentos` | ADMIN | ✅ |
| GET | `/api/agendamentos/{id}` | Autenticado | ✅ |
| DELETE | `/api/agendamentos/{id}` | Autenticado | ⏳ pendente |

---

#### Visitas

| Método | Rota | Acesso | Status |
|--------|------|--------|--------|
| POST | `/api/visitas` | Autenticado | ✅ |
| GET | `/api/visitas` | Autenticado | ✅ |
| GET | `/api/visitas/{id}` | Autenticado | ✅ |
| DELETE | `/api/visitas/{id}` | Autenticado | ⏳ pendente |

---

#### Sugestões

| Método | Rota | Acesso | Status |
|--------|------|--------|--------|
| POST | `/api/sugestoes` | Autenticado | ✅ |
| GET | `/api/sugestoes` | Autenticado | ✅ |
| GET | `/api/sugestoes/{id}` | Autenticado | ✅ |
| PUT | `/api/sugestoes/{id}/status` | ADMIN | ⏳ pendente |
| DELETE | `/api/sugestoes/{id}` | Autenticado | ⏳ pendente |

---

### Legenda

| Símbolo | Significado |
|---------|-------------|
| ✅ | Implementado e disponível |
| ⏳ | Pendente de implementação |