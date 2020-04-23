visualização de previsão de tempo e análise para cidades.


Esse projeto ilustra uma análise da estação do tempo para cada cidade do mundo, podendo fazer a inclusão, alteração e exclusão das cidades, tudo feito com Spring boot e Java 8.


Começando
Para executar o projeto, será necessário instalar os seguintes programas:


JDK 8: Necessário para executar o projeto Java
Maven 3.5.3: Necessário para realizar o build do projeto Java
Eclipse: Para desenvolvimento do projeto


Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório da sua preferência:
git@github.com:fabioaoki/ForecastJpa.git 


Para construir o projeto com o Maven, executar o comando abaixo:
mvn clean install


O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.


Features:
Inicialmente o projeto realiza apenas inclusão das cidades com o clima local, mas podemos colocar realizar futuramente analise mais específicas como previsão do dia seguinte ou semana com análise mais detalhada.


Configuração:
Para executar o projeto, é necessário utilizar o Eclipse, para que o mesmo identifique as dependências necessárias para a execução no repositório .m2 do Maven. Uma vez importado o projeto, será criado um arquivo .classpath que irá informar qual a classe principal para a execução.
Para realização de post,get, put e delete precisa usar o Postman na porta 8080, também incluso no projeto swagger onde temos o demonstrativo de cada endpoint: http://localhost:8080/swagger-ui.html#/forecast-controller


Estamos utilizando o h2 como configuração, mas podemos usar o banco relacional habilitando ele no applications.properties


Licença
Não se aplica.
