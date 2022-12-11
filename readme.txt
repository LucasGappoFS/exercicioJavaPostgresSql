readme

Programa realizado na academia mesttra 1000devs, utilizando o Eclipse IDE, programação orientada a objetos, biblioteca Java JDBC PostgreSQL

Classe cidadesDao.java realiza a interaçao entre programa principal e o banco de dados, implementado no PostgreSQL manualmente.
Classe cidadesPojo.java representa a tabela "cidades" criada no banco de dados, sendo cada um de seus atributos uma coluna da tabela.
Classe ConectionFactoryCidades.java utiliza da biblioteca Postgresql (JDBC) para realizar a comunicação entre software e backend.
Classe programaPrincipal.java possui o menu de utilização do software desenvolvido.

Para utilizar o programa, deve-se antes criar a tabela "cidades" no pgAdmin 4, dentro de um novo schema chamado "cidades".
Suas colunas devem ser compaíveis com os formatos de cada um dos atributos do arquivo cidadesPojo, seguindo a mesma ordem apresentada.