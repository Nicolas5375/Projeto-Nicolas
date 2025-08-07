<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <title>Cadastrar Usuário</title>
</head>
<body>
    <h1>Cadastrar Usuário</h1>
  		 <form action="${pageContext.request.contextPath}/inserir-usuario" method="post">
        <label for="nome">Nome</label><br/>
        <input type="text" id="nome" name="nome" required /><br/><br/>

        <label for="sobrenome">Sobrenome</label><br/>
        <input type="text" id="sobrenome" name="sobrenome" required /><br/><br/>

        <label for="email">E-mail</label><br/>
        <input type="email" id="email" name="email" required /><br/><br/>

        <label for="senha">Senha</label><br/>
        <input type="password" id="senha" name="senha" required /><br/><br/>

        <button type="submit">Cadastrar</button>

    </form>
</body>
</html>
