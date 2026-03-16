Arena Connect
📊 Projeto de Gestão de Eventos
Integrantes do Grupo


O Arena Connect é uma solução desenvolvida para auxiliar na gestão de eventos em grandes complexos esportivos e culturais. O sistema foi projetado com o objetivo de centralizar a organização de eventos, melhorar o acompanhamento da agenda da arena e promover maior interação entre cidadãos e administradores.

A plataforma permite que usuários acompanhem os eventos programados, confirmem presença e participem de forma ativa sugerindo novas atividades. Para a administração da arena, o sistema oferece ferramentas de gestão e análise que facilitam o planejamento e a tomada de decisões.

Através da utilização de tecnologias modernas como Java e Spring Boot, o sistema foi estruturado seguindo boas práticas de desenvolvimento, com separação clara de responsabilidades entre as camadas da aplicação.

Funcionalidades do Sistema
Área do Cidadão

A plataforma disponibiliza um ambiente voltado para o público que deseja acompanhar as atividades da arena.

Entre as principais funcionalidades estão:

visualização da agenda de eventos futuros;

acesso a informações detalhadas sobre cada evento;

filtragem de eventos por categorias;

confirmação de presença em eventos disponíveis;

envio de sugestões de novos eventos;

solicitação de visitas guiadas à arena.

Esses recursos permitem que os cidadãos tenham uma participação mais ativa na programação da arena.

Painel Administrativo

O sistema também oferece um painel administrativo voltado para a gestão dos eventos.

Por meio desse painel é possível:

cadastrar novos eventos;

editar informações de eventos existentes;

atualizar detalhes como data, categoria e descrição;

gerenciar a agenda completa da arena.

Além disso, o sistema disponibiliza um dashboard estatístico, permitindo a visualização de informações importantes como:

total de eventos cadastrados;

média de participação do público;

categorias de eventos mais populares.

Outro recurso disponível é o gerenciamento das sugestões enviadas pelos usuários, permitindo que os administradores aprovem ou descartem ideias de novos eventos.

Arquitetura do Sistema

A aplicação foi desenvolvida utilizando o padrão de arquitetura em camadas, amplamente adotado em aplicações baseadas em Spring Boot.

A estrutura principal é organizada da seguinte forma:

Controller
   ↓
Service
   ↓
Repository
   ↓
Database

Essa organização facilita a manutenção do código, melhora a escalabilidade do sistema e garante uma separação clara das responsabilidades de cada componente.

Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

Backend

Java 17

Spring Boot 3

Spring Data JPA

Banco de Dados

MySQL / PostgreSQL

Ferramentas

Maven

Git

GitHub

Figma (protótipo de interface)

Execução do Projeto

Para executar o projeto localmente, siga os passos abaixo.

Clonar o repositório
git clone https://github.com/seu-usuario/arena-connect.git
Acessar a pasta do projeto
cd arena-connect
Instalar dependências
mvn clean install
Executar a aplicação
mvn spring-boot:run

Após a execução, a API estará disponível em:

http://localhost:8080
Protótipo do Sistema

O design da interface do sistema foi desenvolvido com foco em usabilidade e experiência do usuário.

Link do protótipo no Figma:

https://cold-target-85807250.figma.site/home
