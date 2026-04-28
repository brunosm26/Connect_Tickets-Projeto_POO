# Como Contribuir

## Padrão de branches

```
feat/nome-da-feature
fix/nome-do-bug
```

## Padrão de commits

```
feat: adiciona endpoint de refresh token
fix: corrige validação de email no registro
docs: atualiza README com novos endpoints
refactor: extrai lógica de autorização para SecurityUtils
```

## Fluxo

1. Crie uma branch a partir da `main`
2. Faça as alterações
3. Abra um Pull Request descrevendo o que foi feito
4. Aguarde revisão antes de mergear

## Rodando localmente

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Variáveis de ambiente necessárias:

```
DATABASE_URL=
JWT_SECRET=
```
