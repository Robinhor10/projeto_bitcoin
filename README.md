 – Como criar um projeto quarkus novo via terminal ?

Comando abaixo retirado do site : https://quarkus.io/guides/getting-started

mvn io.quarkus:quarkus-maven-plugin:1.9.0.Final:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=getting-started2 \
    -DclassName="org.acme.getting.started.GreetingResource" \
    -Dpath="/hello"
cd getting-started2

– Como buildar projeto no quarkus ?

./mvnw compile quarkus:dev


- Comando para visualizar quais versões do java a máquina tem instalada
update-alternatives --list java

- Comando para alterar a versão do java

sudo update-alternatives --config java

- Comando para alterar a versão do compilador java
sudo update-alternatives --config javac


Como instalar o mysql server no ubuntu via terminal ?

sudo apt install mysql-server 
sudo mysql_secure_installation 
 com o comando: 
sudo gedit /etc/mysql/mysql.conf.d/mysqld.cnf 
	- Edite mysqld.cnf e mude bind-address para 0.0.0.0
sudo service mysql restart 
sudo mysql -u root ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'SuaSenha';

- Como acessar o mysql server via terminal ?

- Esteja no usuário sudo su
- depois digite mysql -uroot -p
- irá pedir a senha que você cadastro no momento de configurar o mysql local



-------------------------------------------------------------------------------------------------------------

DOCKER

Instalar imagem de mysql no docker
docker pull mysql:latest
identificar quais imagens estão baixadas 
docker images

- nomeando a imagem e “setando” usuario e senha
docker run --name db -d -p3306:3306 -e MYSQL_ROOT_PASSWORD=12345 mysql:latest

executando a imagem criada “db”
docker exec -it db /bin/bash

parando um container
docker stop ce97 (exemplo iniciais de um container)

iniciando um container parado
docker start ce97 (exemplo iniciais de um container)

após executar é só acessar o mysql
mysql -uroot -p12345

removendo um container
docker rm db



(678) How To Create And Test MySQL Database Server in Docker On Ubuntu Linux - YouTube
